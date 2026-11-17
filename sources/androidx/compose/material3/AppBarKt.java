package androidx.compose.material3;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.LayoutModifierKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: AppBar.kt */
@Metadata(m164d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0083\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u008f\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001al\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001ax\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a \u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0007\u001a\u007f\u00104\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u007f\u0010;\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u007f\u0010<\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0085\u0001\u0010=\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\b\u0010%\u001a\u0004\u0018\u000109H\u0003¢\u0006\u0002\u0010B\u001a\u007f\u0010C\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u007f\u0010D\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a£\u0001\u0010E\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001c2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010>\u001a\u00020?2\u0006\u0010J\u001a\u0002012\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020A2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001aµ\u0001\u0010T\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010>\u001a\u00020?2\u0006\u0010O\u001a\u00020\u00012\u0011\u0010U\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010V\u001a\u00020?2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\u0006\u0010W\u001a\u00020\u00012\u0006\u0010X\u001a\u00020\u00012\b\u0010%\u001a\u0004\u0018\u000109H\u0003ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\u001a+\u0010[\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010\\\u001a+\u0010]\u001a\u00020^2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010_\u001a>\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020^2\u0006\u0010c\u001a\u0002012\u000e\u0010d\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010e2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010gH\u0082@¢\u0006\u0002\u0010h\u001a>\u0010i\u001a\u00020a2\u0006\u0010b\u001a\u00020/2\u0006\u0010c\u001a\u0002012\u000e\u0010d\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010e2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010gH\u0083@¢\u0006\u0002\u0010j\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006k²\u0006\n\u0010l\u001a\u00020\u001cX\u008a\u0084\u0002"}, m165d2 = {"BottomAppBarHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "LargeTitleBottomPadding", "MediumTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "BottomAppBar", "", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "floatingActionButton", "Lkotlin/Function0;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "scrollBehavior", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "BottomAppBar-qhFBPw4", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-e-3WI5M", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBarState", "Landroidx/compose/material3/BottomAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "CenterAlignedTopAppBar", "title", "navigationIcon", "colors", "Landroidx/compose/material3/TopAppBarColors;", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "LargeTopAppBar", "MediumTopAppBar", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "centeredTitle", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "SmallTopAppBar", "TopAppBar", "TopAppBarLayout", "heightPx", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "titleBottomPadding", "", "hideTitleSemantics", "TopAppBarLayout-kXwM9vE", "(Landroidx/compose/ui/Modifier;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TwoRowsTopAppBar", "smallTitle", "smallTitleTextStyle", "maxHeight", "pinnedHeight", "TwoRowsTopAppBar-tjU4iQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;FFLandroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "rememberBottomAppBarState", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarState;", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "settleAppBar", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settleAppBarBottom", "(Landroidx/compose/material3/BottomAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release", "appBarContainerColor"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AppBarKt {
    private static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    private static final float FABHorizontalPadding;
    private static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding;
    private static final float MediumTitleBottomPadding;
    private static final float TopAppBarHorizontalPadding;
    private static final float TopAppBarTitleInset;
    private static final CubicBezierEasing TopTitleAlphaEasing;

    /* compiled from: AppBar.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.material3.AppBarKt", m180f = "AppBar.kt", m181i = {0, 0, 0, 1}, m182l = {2241, 2257}, m183m = "settleAppBar", m184n = {"state", "snapAnimationSpec", "remainingVelocity", "remainingVelocity"}, m185s = {"L$0", "L$1", "L$2", "L$0"})
    /* renamed from: androidx.compose.material3.AppBarKt$settleAppBar$1 */
    static final class C12131 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12131(Continuation<? super C12131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppBarKt.settleAppBar(null, 0.0f, null, null, this);
        }
    }

    /* compiled from: AppBar.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.material3.AppBarKt", m180f = "AppBar.kt", m181i = {0, 0, 0, 1}, m182l = {1578, 1594}, m183m = "settleAppBarBottom", m184n = {"state", "snapAnimationSpec", "remainingVelocity", "remainingVelocity"}, m185s = {"L$0", "L$1", "L$2", "L$0"})
    /* renamed from: androidx.compose.material3.AppBarKt$settleAppBarBottom$1 */
    static final class C12161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12161(Continuation<? super C12161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppBarKt.settleAppBarBottom(null, 0.0f, null, null, this);
        }
    }

    public static final void TopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        Modifier modifier2;
        Function2 navigationIcon;
        Function3 actions;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        Function2 navigationIcon2;
        TopAppBarColors colors3;
        TopAppBarScrollBehavior scrollBehavior2;
        Function3 actions2;
        Modifier modifier3;
        int i2;
        Composer $composer2;
        final Modifier modifier4;
        final Function2 navigationIcon3;
        final Function3 actions3;
        final WindowInsets windowInsets3;
        final TopAppBarColors colors4;
        final TopAppBarScrollBehavior scrollBehavior3;
        Composer $composer3 = $composer.startRestartGroup(1906353009);
        ComposerKt.sourceInformation($composer3, "C(TopAppBar)P(5,2,3!1,6)126@6292L12,127@6354L17,133@6544L10,130@6433L374:AppBar.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            function23 = function2;
        } else if (($changed & 6) == 0) {
            function23 = function2;
            $dirty |= $composer3.changedInstance(function23) ? 4 : 2;
        } else {
            function23 = function2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            navigationIcon = function22;
        } else if (($changed & 384) == 0) {
            navigationIcon = function22;
            $dirty |= $composer3.changedInstance(navigationIcon) ? 256 : 128;
        } else {
            navigationIcon = function22;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            actions = function3;
        } else if (($changed & 3072) == 0) {
            actions = function3;
            $dirty |= $composer3.changedInstance(actions) ? 2048 : 1024;
        } else {
            actions = function3;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i6 = $composer3.changed(windowInsets2) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty |= i6;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i7 = $composer3.changed(colors2) ? 131072 : 65536;
                $dirty |= i7;
            } else {
                colors2 = colors;
            }
            $dirty |= i7;
        } else {
            colors2 = colors;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if ((1572864 & $changed) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty |= $composer3.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if ((599187 & $dirty) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            navigationIcon3 = navigationIcon;
            actions3 = actions;
            windowInsets3 = windowInsets2;
            colors4 = colors2;
            scrollBehavior3 = topAppBarScrollBehavior;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    navigationIcon = ComposableSingletons$AppBarKt.INSTANCE.m1945getLambda1$material3_release();
                }
                if (i5 != 0) {
                    actions = ComposableSingletons$AppBarKt.INSTANCE.m1949getLambda2$material3_release();
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    colors2 = TopAppBarDefaults.INSTANCE.topAppBarColors($composer3, 6);
                }
                if (i8 != 0) {
                    scrollBehavior2 = null;
                    navigationIcon2 = navigationIcon;
                    actions2 = actions;
                    colors3 = colors2;
                    modifier3 = modifier5;
                    i2 = 1906353009;
                } else {
                    navigationIcon2 = navigationIcon;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    actions2 = actions;
                    modifier3 = modifier5;
                    i2 = 1906353009;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    navigationIcon2 = navigationIcon;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    i2 = 1906353009;
                    actions2 = actions;
                    modifier3 = modifier2;
                } else {
                    navigationIcon2 = navigationIcon;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    i2 = 1906353009;
                    actions2 = actions;
                    modifier3 = modifier2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:129)");
            }
            $composer2 = $composer3;
            WindowInsets windowInsets4 = windowInsets2;
            SingleRowTopAppBar(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), false, navigationIcon2, actions2, windowInsets4, colors3, scrollBehavior2, $composer2, (($dirty >> 3) & 14) | 3072 | (($dirty << 3) & 112) | (($dirty << 6) & 57344) | (($dirty << 6) & 458752) | (($dirty << 6) & 3670016) | (($dirty << 6) & 29360128) | (($dirty << 6) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            navigationIcon3 = navigationIcon2;
            actions3 = actions2;
            windowInsets3 = windowInsets4;
            colors4 = colors3;
            scrollBehavior3 = scrollBehavior2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.TopAppBar.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    AppBarKt.TopAppBar(function2, modifier4, navigationIcon3, actions3, windowInsets3, colors4, scrollBehavior3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use TopAppBar instead.", replaceWith = @ReplaceWith(expression = "TopAppBar(title, modifier, navigationIcon, actions, windowInsets, colors, scrollBehavior)", imports = {}))
    public static final void SmallTopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        Modifier modifier2;
        Function2 navigationIcon;
        Function3 actions;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        WindowInsets windowInsets3;
        TopAppBarScrollBehavior scrollBehavior2;
        Function2 navigationIcon2;
        TopAppBarColors colors3;
        Function3 actions2;
        Modifier modifier3;
        Composer $composer2;
        final Modifier modifier4;
        final Function2 navigationIcon3;
        final Function3 actions3;
        final WindowInsets windowInsets4;
        final TopAppBarColors colors4;
        final TopAppBarScrollBehavior scrollBehavior3;
        Composer $composer3 = $composer.startRestartGroup(-1967617284);
        ComposerKt.sourceInformation($composer3, "C(SmallTopAppBar)P(5,2,3!1,6)189@9271L12,190@9333L17,192@9408L89:AppBar.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            function23 = function2;
        } else if (($changed & 6) == 0) {
            function23 = function2;
            $dirty |= $composer3.changedInstance(function23) ? 4 : 2;
        } else {
            function23 = function2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            navigationIcon = function22;
        } else if (($changed & 384) == 0) {
            navigationIcon = function22;
            $dirty |= $composer3.changedInstance(navigationIcon) ? 256 : 128;
        } else {
            navigationIcon = function22;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            actions = function3;
        } else if (($changed & 3072) == 0) {
            actions = function3;
            $dirty |= $composer3.changedInstance(actions) ? 2048 : 1024;
        } else {
            actions = function3;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i5 = $composer3.changed(windowInsets2) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty |= i5;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i6 = $composer3.changed(colors2) ? 131072 : 65536;
                $dirty |= i6;
            } else {
                colors2 = colors;
            }
            $dirty |= i6;
        } else {
            colors2 = colors;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if ((1572864 & $changed) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty |= $composer3.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if ((599187 & $dirty) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            actions3 = actions;
            $composer2 = $composer3;
            navigationIcon3 = navigationIcon;
            windowInsets4 = windowInsets2;
            colors4 = colors2;
            scrollBehavior3 = topAppBarScrollBehavior;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    navigationIcon = ComposableSingletons$AppBarKt.INSTANCE.m1950getLambda3$material3_release();
                }
                if (i4 != 0) {
                    actions = ComposableSingletons$AppBarKt.INSTANCE.m1951getLambda4$material3_release();
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    colors2 = TopAppBarDefaults.INSTANCE.topAppBarColors($composer3, 6);
                }
                if (i7 != 0) {
                    scrollBehavior2 = null;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    navigationIcon2 = navigationIcon;
                    actions2 = actions;
                    modifier3 = modifier5;
                } else {
                    windowInsets3 = windowInsets2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    navigationIcon2 = navigationIcon;
                    colors3 = colors2;
                    actions2 = actions;
                    modifier3 = modifier5;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    windowInsets3 = windowInsets2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    navigationIcon2 = navigationIcon;
                    colors3 = colors2;
                    actions2 = actions;
                    modifier3 = modifier2;
                } else {
                    windowInsets3 = windowInsets2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    navigationIcon2 = navigationIcon;
                    colors3 = colors2;
                    actions2 = actions;
                    modifier3 = modifier2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1967617284, $dirty, -1, "androidx.compose.material3.SmallTopAppBar (AppBar.kt:192)");
            }
            $composer2 = $composer3;
            TopAppBar(function23, modifier3, navigationIcon2, actions2, windowInsets3, colors3, scrollBehavior2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            navigationIcon3 = navigationIcon2;
            actions3 = actions2;
            windowInsets4 = windowInsets3;
            colors4 = colors3;
            scrollBehavior3 = scrollBehavior2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.SmallTopAppBar.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i8) {
                    AppBarKt.SmallTopAppBar(function2, modifier4, navigationIcon3, actions3, windowInsets4, colors4, scrollBehavior3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void CenterAlignedTopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        Modifier modifier2;
        Function2 navigationIcon;
        Function3 actions;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        Function2 navigationIcon2;
        TopAppBarColors colors3;
        TopAppBarScrollBehavior scrollBehavior2;
        Function3 actions2;
        Modifier modifier3;
        int i2;
        Composer $composer2;
        final Modifier modifier4;
        final Function2 navigationIcon3;
        final Function3 actions3;
        final WindowInsets windowInsets3;
        final TopAppBarColors colors4;
        final TopAppBarScrollBehavior scrollBehavior3;
        Composer $composer3 = $composer.startRestartGroup(-2139286460);
        ComposerKt.sourceInformation($composer3, "C(CenterAlignedTopAppBar)P(5,2,3!1,6)230@11690L12,231@11752L30,238@11963L10,234@11844L381:AppBar.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            function23 = function2;
        } else if (($changed & 6) == 0) {
            function23 = function2;
            $dirty |= $composer3.changedInstance(function23) ? 4 : 2;
        } else {
            function23 = function2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            navigationIcon = function22;
        } else if (($changed & 384) == 0) {
            navigationIcon = function22;
            $dirty |= $composer3.changedInstance(navigationIcon) ? 256 : 128;
        } else {
            navigationIcon = function22;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            actions = function3;
        } else if (($changed & 3072) == 0) {
            actions = function3;
            $dirty |= $composer3.changedInstance(actions) ? 2048 : 1024;
        } else {
            actions = function3;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i6 = $composer3.changed(windowInsets2) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty |= i6;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i7 = $composer3.changed(colors2) ? 131072 : 65536;
                $dirty |= i7;
            } else {
                colors2 = colors;
            }
            $dirty |= i7;
        } else {
            colors2 = colors;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if ((1572864 & $changed) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty |= $composer3.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if ((599187 & $dirty) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            navigationIcon3 = navigationIcon;
            actions3 = actions;
            windowInsets3 = windowInsets2;
            colors4 = colors2;
            scrollBehavior3 = topAppBarScrollBehavior;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    navigationIcon = ComposableSingletons$AppBarKt.INSTANCE.m1952getLambda5$material3_release();
                }
                if (i5 != 0) {
                    actions = ComposableSingletons$AppBarKt.INSTANCE.m1953getLambda6$material3_release();
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    colors2 = TopAppBarDefaults.INSTANCE.centerAlignedTopAppBarColors($composer3, 6);
                }
                if (i8 != 0) {
                    scrollBehavior2 = null;
                    navigationIcon2 = navigationIcon;
                    actions2 = actions;
                    colors3 = colors2;
                    modifier3 = modifier5;
                    i2 = -2139286460;
                } else {
                    navigationIcon2 = navigationIcon;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    actions2 = actions;
                    modifier3 = modifier5;
                    i2 = -2139286460;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    navigationIcon2 = navigationIcon;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    i2 = -2139286460;
                    actions2 = actions;
                    modifier3 = modifier2;
                } else {
                    navigationIcon2 = navigationIcon;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    i2 = -2139286460;
                    actions2 = actions;
                    modifier3 = modifier2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:233)");
            }
            $composer2 = $composer3;
            WindowInsets windowInsets4 = windowInsets2;
            SingleRowTopAppBar(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), true, navigationIcon2, actions2, windowInsets4, colors3, scrollBehavior2, $composer2, (($dirty >> 3) & 14) | 3072 | (($dirty << 3) & 112) | (($dirty << 6) & 57344) | (($dirty << 6) & 458752) | (($dirty << 6) & 3670016) | (($dirty << 6) & 29360128) | (($dirty << 6) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            navigationIcon3 = navigationIcon2;
            actions3 = actions2;
            windowInsets3 = windowInsets4;
            colors4 = colors3;
            scrollBehavior3 = scrollBehavior2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.CenterAlignedTopAppBar.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    AppBarKt.CenterAlignedTopAppBar(function2, modifier4, navigationIcon3, actions3, windowInsets3, colors4, scrollBehavior3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void MediumTopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        Modifier modifier2;
        Function2 navigationIcon;
        Function3 actions;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        Function3 actions2;
        WindowInsets windowInsets3;
        TopAppBarColors colors3;
        TopAppBarScrollBehavior scrollBehavior2;
        Modifier modifier3;
        int i2;
        Composer $composer2;
        final Modifier modifier4;
        final Function2 navigationIcon2;
        final Function3 actions3;
        final WindowInsets windowInsets4;
        final TopAppBarColors colors4;
        final TopAppBarScrollBehavior scrollBehavior3;
        Composer $composer3 = $composer.startRestartGroup(1805417862);
        ComposerKt.sourceInformation($composer3, "C(MediumTopAppBar)P(5,2,3!1,6)285@14543L12,286@14605L23,292@14799L10,293@14901L10,289@14690L646:AppBar.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            function23 = function2;
        } else if (($changed & 6) == 0) {
            function23 = function2;
            $dirty |= $composer3.changedInstance(function23) ? 4 : 2;
        } else {
            function23 = function2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            navigationIcon = function22;
        } else if (($changed & 384) == 0) {
            navigationIcon = function22;
            $dirty |= $composer3.changedInstance(navigationIcon) ? 256 : 128;
        } else {
            navigationIcon = function22;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            actions = function3;
        } else if (($changed & 3072) == 0) {
            actions = function3;
            $dirty |= $composer3.changedInstance(actions) ? 2048 : 1024;
        } else {
            actions = function3;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i6 = $composer3.changed(windowInsets2) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty |= i6;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i7 = $composer3.changed(colors2) ? 131072 : 65536;
                $dirty |= i7;
            } else {
                colors2 = colors;
            }
            $dirty |= i7;
        } else {
            colors2 = colors;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if ((1572864 & $changed) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty |= $composer3.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if ((599187 & $dirty) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            navigationIcon2 = navigationIcon;
            actions3 = actions;
            windowInsets4 = windowInsets2;
            colors4 = colors2;
            scrollBehavior3 = topAppBarScrollBehavior;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    navigationIcon = ComposableSingletons$AppBarKt.INSTANCE.m1954getLambda7$material3_release();
                }
                if (i5 != 0) {
                    actions = ComposableSingletons$AppBarKt.INSTANCE.m1955getLambda8$material3_release();
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    colors2 = TopAppBarDefaults.INSTANCE.mediumTopAppBarColors($composer3, 6);
                }
                if (i8 != 0) {
                    scrollBehavior2 = null;
                    actions2 = actions;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    modifier3 = modifier5;
                    i2 = 1805417862;
                } else {
                    actions2 = actions;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    modifier3 = modifier5;
                    i2 = 1805417862;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    actions2 = actions;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    i2 = 1805417862;
                    modifier3 = modifier2;
                } else {
                    actions2 = actions;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    i2 = 1805417862;
                    modifier3 = modifier2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:288)");
            }
            $composer2 = $composer3;
            Function2 navigationIcon3 = navigationIcon;
            m1775TwoRowsTopAppBartjU4iQQ(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TopAppBarMediumTokens.INSTANCE.getHeadlineFont()), MediumTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), navigationIcon3, actions2, windowInsets3, colors3, TopAppBarMediumTokens.INSTANCE.m3394getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3404getContainerHeightD9Ej5fM(), scrollBehavior2, $composer2, (($dirty >> 3) & 14) | 3072 | (($dirty << 3) & 112) | (($dirty << 12) & 57344) | (($dirty << 12) & 3670016) | (($dirty << 12) & 29360128) | (($dirty << 12) & 234881024) | (($dirty << 12) & 1879048192), (($dirty >> 12) & 896) | 54, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            navigationIcon2 = navigationIcon3;
            actions3 = actions2;
            windowInsets4 = windowInsets3;
            colors4 = colors3;
            scrollBehavior3 = scrollBehavior2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.MediumTopAppBar.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    AppBarKt.MediumTopAppBar(function2, modifier4, navigationIcon2, actions3, windowInsets4, colors4, scrollBehavior3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void LargeTopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors colors, TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        Modifier modifier2;
        Function2 navigationIcon;
        Function3 actions;
        WindowInsets windowInsets2;
        TopAppBarColors colors2;
        TopAppBarScrollBehavior topAppBarScrollBehavior;
        Function3 actions2;
        WindowInsets windowInsets3;
        TopAppBarColors colors3;
        TopAppBarScrollBehavior scrollBehavior2;
        Modifier modifier3;
        int i2;
        Composer $composer2;
        final Modifier modifier4;
        final Function2 navigationIcon2;
        final Function3 actions3;
        final WindowInsets windowInsets4;
        final TopAppBarColors colors4;
        final TopAppBarScrollBehavior scrollBehavior3;
        Composer $composer3 = $composer.startRestartGroup(-474540752);
        ComposerKt.sourceInformation($composer3, "C(LargeTopAppBar)P(5,2,3!1,6)343@17646L12,344@17708L22,349@17872L10,350@17973L10,347@17792L643:AppBar.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            function23 = function2;
        } else if (($changed & 6) == 0) {
            function23 = function2;
            $dirty |= $composer3.changedInstance(function23) ? 4 : 2;
        } else {
            function23 = function2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            navigationIcon = function22;
        } else if (($changed & 384) == 0) {
            navigationIcon = function22;
            $dirty |= $composer3.changedInstance(navigationIcon) ? 256 : 128;
        } else {
            navigationIcon = function22;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            actions = function3;
        } else if (($changed & 3072) == 0) {
            actions = function3;
            $dirty |= $composer3.changedInstance(actions) ? 2048 : 1024;
        } else {
            actions = function3;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                windowInsets2 = windowInsets;
                int i6 = $composer3.changed(windowInsets2) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty |= i6;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i7 = $composer3.changed(colors2) ? 131072 : 65536;
                $dirty |= i7;
            } else {
                colors2 = colors;
            }
            $dirty |= i7;
        } else {
            colors2 = colors;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
            topAppBarScrollBehavior = scrollBehavior;
        } else if ((1572864 & $changed) == 0) {
            topAppBarScrollBehavior = scrollBehavior;
            $dirty |= $composer3.changed(topAppBarScrollBehavior) ? 1048576 : 524288;
        } else {
            topAppBarScrollBehavior = scrollBehavior;
        }
        if ((599187 & $dirty) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            navigationIcon2 = navigationIcon;
            actions3 = actions;
            windowInsets4 = windowInsets2;
            colors4 = colors2;
            scrollBehavior3 = topAppBarScrollBehavior;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    navigationIcon = ComposableSingletons$AppBarKt.INSTANCE.m1956getLambda9$material3_release();
                }
                if (i5 != 0) {
                    actions = ComposableSingletons$AppBarKt.INSTANCE.m1946getLambda10$material3_release();
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    colors2 = TopAppBarDefaults.INSTANCE.largeTopAppBarColors($composer3, 6);
                }
                if (i8 != 0) {
                    scrollBehavior2 = null;
                    actions2 = actions;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    modifier3 = modifier5;
                    i2 = -474540752;
                } else {
                    actions2 = actions;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    modifier3 = modifier5;
                    i2 = -474540752;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    actions2 = actions;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    i2 = -474540752;
                    modifier3 = modifier2;
                } else {
                    actions2 = actions;
                    windowInsets3 = windowInsets2;
                    colors3 = colors2;
                    scrollBehavior2 = topAppBarScrollBehavior;
                    i2 = -474540752;
                    modifier3 = modifier2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:346)");
            }
            $composer2 = $composer3;
            Function2 navigationIcon3 = navigationIcon;
            m1775TwoRowsTopAppBartjU4iQQ(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TopAppBarLargeTokens.INSTANCE.getHeadlineFont()), LargeTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), navigationIcon3, actions2, windowInsets3, colors3, TopAppBarLargeTokens.INSTANCE.m3390getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3404getContainerHeightD9Ej5fM(), scrollBehavior2, $composer2, (($dirty >> 3) & 14) | 3072 | (($dirty << 3) & 112) | (($dirty << 12) & 57344) | (($dirty << 12) & 3670016) | (($dirty << 12) & 29360128) | (($dirty << 12) & 234881024) | (($dirty << 12) & 1879048192), (($dirty >> 12) & 896) | 54, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            navigationIcon2 = navigationIcon3;
            actions3 = actions2;
            windowInsets4 = windowInsets3;
            colors4 = colors3;
            scrollBehavior3 = scrollBehavior2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt.LargeTopAppBar.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    AppBarKt.LargeTopAppBar(function2, modifier4, navigationIcon2, actions3, windowInsets4, colors4, scrollBehavior3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: BottomAppBar-Snr_uVM, reason: not valid java name */
    public static final void m1771BottomAppBarSnr_uVM(final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, Composer $composer, final int $changed, final int i) {
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        Modifier modifier2;
        Function2 floatingActionButton;
        long containerColor2;
        long contentColor2;
        float tonalElevation2;
        WindowInsets windowInsets2;
        PaddingValues contentPadding2;
        Modifier modifier3;
        long containerColor3;
        long contentColor3;
        float tonalElevation3;
        int i2;
        Function2 floatingActionButton2;
        Composer $composer2;
        final Modifier modifier4;
        final Function2 floatingActionButton3;
        final long containerColor4;
        final long contentColor4;
        final float tonalElevation4;
        final PaddingValues contentPadding3;
        final WindowInsets windowInsets3;
        Composer $composer3 = $composer.startRestartGroup(2141738945);
        ComposerKt.sourceInformation($composer3, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp)400@20438L14,401@20480L31,404@20706L12,405@20724L315:AppBar.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            function32 = function3;
        } else if (($changed & 6) == 0) {
            function32 = function3;
            $dirty |= $composer3.changedInstance(function32) ? 4 : 2;
        } else {
            function32 = function3;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            floatingActionButton = function2;
        } else if (($changed & 384) == 0) {
            floatingActionButton = function2;
            $dirty |= $composer3.changedInstance(floatingActionButton) ? 256 : 128;
        } else {
            floatingActionButton = function2;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i5 = $composer3.changed(containerColor2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i5;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer3.changed(contentColor2) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            tonalElevation2 = tonalElevation;
        } else if ((196608 & $changed) == 0) {
            tonalElevation2 = tonalElevation;
            $dirty |= $composer3.changed(tonalElevation2) ? 131072 : 65536;
        } else {
            tonalElevation2 = tonalElevation;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(contentPadding) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= ((i & 128) == 0 && $composer3.changed(windowInsets)) ? 8388608 : 4194304;
        }
        if (($dirty & 4793491) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            floatingActionButton3 = floatingActionButton;
            containerColor4 = containerColor2;
            contentColor4 = contentColor2;
            tonalElevation4 = tonalElevation2;
            contentPadding3 = contentPadding;
            windowInsets3 = windowInsets;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    floatingActionButton = null;
                }
                if ((i & 8) != 0) {
                    containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor($composer3, 6);
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = ColorSchemeKt.m1935contentColorForek8zF_U(containerColor2, $composer3, ($dirty >> 9) & 14);
                    $dirty &= -57345;
                }
                if (i7 != 0) {
                    tonalElevation2 = BottomAppBarDefaults.INSTANCE.m1788getContainerElevationD9Ej5fM();
                }
                PaddingValues contentPadding4 = i8 != 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : contentPadding;
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                    contentPadding2 = contentPadding4;
                    modifier3 = modifier2;
                    windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    tonalElevation3 = tonalElevation2;
                    i2 = 2141738945;
                    floatingActionButton2 = floatingActionButton;
                } else {
                    windowInsets2 = windowInsets;
                    contentPadding2 = contentPadding4;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    tonalElevation3 = tonalElevation2;
                    i2 = 2141738945;
                    floatingActionButton2 = floatingActionButton;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 128) != 0) {
                    contentPadding2 = contentPadding;
                    windowInsets2 = windowInsets;
                    $dirty &= -29360129;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    tonalElevation3 = tonalElevation2;
                    i2 = 2141738945;
                    floatingActionButton2 = floatingActionButton;
                } else {
                    contentPadding2 = contentPadding;
                    windowInsets2 = windowInsets;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    tonalElevation3 = tonalElevation2;
                    i2 = 2141738945;
                    floatingActionButton2 = floatingActionButton;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:405)");
            }
            $composer2 = $composer3;
            m1773BottomAppBarqhFBPw4(function32, modifier3, floatingActionButton2, containerColor3, contentColor3, tonalElevation3, contentPadding2, windowInsets2, null, $composer2, ($dirty & 14) | 100663296 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            floatingActionButton3 = floatingActionButton2;
            containerColor4 = containerColor3;
            contentColor4 = contentColor3;
            tonalElevation4 = tonalElevation3;
            contentPadding3 = contentPadding2;
            windowInsets3 = windowInsets2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) {
                    AppBarKt.m1771BottomAppBarSnr_uVM(function3, modifier4, floatingActionButton3, containerColor4, contentColor4, tonalElevation4, contentPadding3, windowInsets3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: BottomAppBar-qhFBPw4, reason: not valid java name */
    public static final void m1773BottomAppBarqhFBPw4(final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, BottomAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Function2 floatingActionButton;
        long containerColor2;
        long contentColor2;
        float tonalElevation2;
        int i2;
        WindowInsets windowInsets2;
        BottomAppBarScrollBehavior scrollBehavior2;
        PaddingValues contentPadding2;
        Modifier modifier3;
        WindowInsets windowInsets3;
        float tonalElevation3;
        int i3;
        int i4;
        long containerColor3;
        long contentColor3;
        Composer $composer2;
        final Modifier modifier4;
        final long containerColor4;
        final float tonalElevation4;
        final PaddingValues contentPadding3;
        final WindowInsets windowInsets4;
        final BottomAppBarScrollBehavior scrollBehavior3;
        final Function2 floatingActionButton2;
        final long contentColor4;
        Composer $composer3 = $composer.startRestartGroup(-1044837119);
        ComposerKt.sourceInformation($composer3, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,7:c#ui.unit.Dp!1,8)462@23624L14,463@23666L31,466@23892L12,468@23966L804:AppBar.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty |= 384;
            floatingActionButton = function2;
        } else if (($changed & 384) == 0) {
            floatingActionButton = function2;
            $dirty |= $composer3.changedInstance(floatingActionButton) ? 256 : 128;
        } else {
            floatingActionButton = function2;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i7 = $composer3.changed(containerColor2) ? 2048 : 1024;
                $dirty |= i7;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i7;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i8 = $composer3.changed(contentColor2) ? 16384 : 8192;
                $dirty |= i8;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i8;
        } else {
            contentColor2 = contentColor;
        }
        int i9 = i & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            tonalElevation2 = tonalElevation;
        } else if ((196608 & $changed) == 0) {
            tonalElevation2 = tonalElevation;
            $dirty |= $composer3.changed(tonalElevation2) ? 131072 : 65536;
        } else {
            tonalElevation2 = tonalElevation;
        }
        int i10 = i & 64;
        if (i10 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(contentPadding) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= ((i & 128) == 0 && $composer3.changed(windowInsets)) ? 8388608 : 4194304;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
            i2 = i11;
        } else if (($changed & 100663296) == 0) {
            i2 = i11;
            $dirty |= $composer3.changed(scrollBehavior) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i11;
        }
        if (($dirty & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            floatingActionButton2 = floatingActionButton;
            containerColor4 = containerColor2;
            contentColor4 = contentColor2;
            tonalElevation4 = tonalElevation2;
            contentPadding3 = contentPadding;
            windowInsets4 = windowInsets;
            scrollBehavior3 = scrollBehavior;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    floatingActionButton = null;
                }
                if ((i & 8) != 0) {
                    containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor($composer3, 6);
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = ColorSchemeKt.m1935contentColorForek8zF_U(containerColor2, $composer3, ($dirty >> 9) & 14);
                    $dirty &= -57345;
                }
                if (i9 != 0) {
                    tonalElevation2 = BottomAppBarDefaults.INSTANCE.m1788getContainerElevationD9Ej5fM();
                }
                PaddingValues contentPadding4 = i10 != 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : contentPadding;
                if ((i & 128) != 0) {
                    windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                    $dirty &= -29360129;
                } else {
                    windowInsets2 = windowInsets;
                }
                if (i2 != 0) {
                    contentPadding2 = contentPadding4;
                    scrollBehavior2 = null;
                    modifier3 = modifier2;
                    windowInsets3 = windowInsets2;
                    tonalElevation3 = tonalElevation2;
                    i3 = 12582912;
                    i4 = -1044837119;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                } else {
                    scrollBehavior2 = scrollBehavior;
                    contentPadding2 = contentPadding4;
                    modifier3 = modifier2;
                    windowInsets3 = windowInsets2;
                    tonalElevation3 = tonalElevation2;
                    i3 = 12582912;
                    i4 = -1044837119;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 128) != 0) {
                    contentPadding2 = contentPadding;
                    windowInsets3 = windowInsets;
                    scrollBehavior2 = scrollBehavior;
                    $dirty &= -29360129;
                    modifier3 = modifier2;
                    tonalElevation3 = tonalElevation2;
                    i3 = 12582912;
                    i4 = -1044837119;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                } else {
                    contentPadding2 = contentPadding;
                    windowInsets3 = windowInsets;
                    scrollBehavior2 = scrollBehavior;
                    modifier3 = modifier2;
                    tonalElevation3 = tonalElevation2;
                    i3 = 12582912;
                    i4 = -1044837119;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i4, $dirty, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:468)");
            }
            $composer2 = $composer3;
            m1772BottomAppBare3WI5M(modifier3, containerColor3, contentColor3, tonalElevation3, contentPadding2, windowInsets3, scrollBehavior2, ComposableLambdaKt.composableLambda($composer3, 1566394874, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope $this$BottomAppBar, Composer $composer4, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    int $changed$iv;
                    ComposerKt.sourceInformation($composer4, "C477@24226L184,484@24459L303:AppBar.kt#uh7d8r");
                    int $dirty2 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty2 |= $composer4.changed($this$BottomAppBar) ? 4 : 2;
                    }
                    if (($dirty2 & 19) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1566394874, $dirty2, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:477)");
                        }
                        Modifier modifier$iv = RowScope.weight$default($this$BottomAppBar, Modifier.INSTANCE, 1.0f, false, 2, null);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function3 content$iv = function3;
                        $composer4.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        $composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3479constructorimpl($composer4);
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        $composer4.startReplaceableGroup(2058660585);
                        int i12 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        content$iv.invoke(RowScopeInstance.INSTANCE, $composer4, Integer.valueOf(((432 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endReplaceableGroup();
                        $composer4.endNode();
                        $composer4.endReplaceableGroup();
                        $composer4.endReplaceableGroup();
                        if (floatingActionButton != null) {
                            Modifier modifier$iv2 = PaddingKt.m771paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, AppBarKt.FABVerticalPadding, AppBarKt.FABHorizontalPadding, 0.0f, 9, null);
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            Function2<Composer, Integer, Unit> function22 = floatingActionButton;
                            $composer4.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                            int $changed$iv$iv2 = (54 << 3) & 112;
                            $composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                            Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.modifierMaterializerOf(modifier$iv2);
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                $composer4.createNode(factory$iv$iv$iv3);
                            } else {
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3479constructorimpl($composer4);
                            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                                $changed$iv = 54;
                            } else {
                                $changed$iv = 54;
                                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                }
                                skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                                $composer4.startReplaceableGroup(2058660585);
                                int i13 = ($changed$iv$iv$iv2 >> 9) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                int i14 = (($changed$iv >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer4, 1859776956, "C493@24730L22:AppBar.kt#uh7d8r");
                                function22.invoke($composer4, 0);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer4.endReplaceableGroup();
                                $composer4.endNode();
                                $composer4.endReplaceableGroup();
                                $composer4.endReplaceableGroup();
                            }
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
                            skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                            $composer4.startReplaceableGroup(2058660585);
                            int i132 = ($changed$iv$iv$iv2 >> 9) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            int i142 = (($changed$iv >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1859776956, "C493@24730L22:AppBar.kt#uh7d8r");
                            function22.invoke($composer4, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endReplaceableGroup();
                            $composer4.endNode();
                            $composer4.endReplaceableGroup();
                            $composer4.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, i3 | (($dirty >> 3) & 14) | (($dirty >> 6) & 112) | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168) | (($dirty >> 6) & 57344) | (($dirty >> 6) & 458752) | (($dirty >> 6) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            containerColor4 = containerColor3;
            tonalElevation4 = tonalElevation3;
            contentPadding3 = contentPadding2;
            windowInsets4 = windowInsets3;
            scrollBehavior3 = scrollBehavior2;
            floatingActionButton2 = floatingActionButton;
            contentColor4 = contentColor3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i12) {
                    AppBarKt.m1773BottomAppBarqhFBPw4(function3, modifier4, floatingActionButton2, containerColor4, contentColor4, tonalElevation4, contentPadding3, windowInsets4, scrollBehavior3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: BottomAppBar-1oL4kX8, reason: not valid java name */
    public static final void m1770BottomAppBar1oL4kX8(Modifier modifier, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long containerColor2;
        long contentColor2;
        float tonalElevation2;
        PaddingValues contentPadding2;
        WindowInsets windowInsets2;
        int $dirty;
        int i2;
        int $dirty2;
        PaddingValues contentPadding3;
        WindowInsets windowInsets3;
        int $dirty3;
        int i3;
        long containerColor3;
        long contentColor3;
        float tonalElevation3;
        Modifier modifier3;
        Composer $composer2;
        final long containerColor4;
        final Modifier modifier4;
        final long contentColor4;
        final float tonalElevation4;
        final PaddingValues contentPadding4;
        final WindowInsets windowInsets4;
        Composer $composer3 = $composer.startRestartGroup(-1391700845);
        ComposerKt.sourceInformation($composer3, "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,3,6)527@26431L14,528@26473L31,531@26699L12,533@26762L266:AppBar.kt#uh7d8r");
        int $dirty4 = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty4 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                containerColor2 = containerColor;
                int i5 = $composer3.changed(containerColor2) ? 32 : 16;
                $dirty4 |= i5;
            } else {
                containerColor2 = containerColor;
            }
            $dirty4 |= i5;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer3.changed(contentColor2) ? 256 : 128;
                $dirty4 |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty4 |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty4 |= 3072;
            tonalElevation2 = tonalElevation;
        } else if (($changed & 3072) == 0) {
            tonalElevation2 = tonalElevation;
            $dirty4 |= $composer3.changed(tonalElevation2) ? 2048 : 1024;
        } else {
            tonalElevation2 = tonalElevation;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty4 |= 24576;
            contentPadding2 = contentPadding;
        } else if (($changed & 24576) == 0) {
            contentPadding2 = contentPadding;
            $dirty4 |= $composer3.changed(contentPadding2) ? 16384 : 8192;
        } else {
            contentPadding2 = contentPadding;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                windowInsets2 = windowInsets;
                int i9 = $composer3.changed(windowInsets2) ? 131072 : 65536;
                $dirty4 |= i9;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty4 |= i9;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i & 64) != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty4 |= $composer3.changedInstance(function3) ? 1048576 : 524288;
        }
        int $dirty5 = $dirty4;
        if (($dirty4 & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            containerColor4 = containerColor2;
            contentColor4 = contentColor2;
            tonalElevation4 = tonalElevation2;
            contentPadding4 = contentPadding2;
            windowInsets4 = windowInsets2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 2) != 0) {
                    containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor($composer3, 6);
                    $dirty = $dirty5 & (-113);
                } else {
                    $dirty = $dirty5;
                }
                if ((i & 4) != 0) {
                    i2 = -458753;
                    contentColor2 = ColorSchemeKt.m1935contentColorForek8zF_U(containerColor2, $composer3, ($dirty >> 3) & 14);
                    $dirty &= -897;
                } else {
                    i2 = -458753;
                }
                if (i7 != 0) {
                    tonalElevation2 = BottomAppBarDefaults.INSTANCE.m1788getContainerElevationD9Ej5fM();
                }
                if (i8 != 0) {
                    contentPadding2 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                }
                if ((i & 32) != 0) {
                    windowInsets3 = BottomAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                    contentColor3 = contentColor2;
                    contentPadding3 = contentPadding2;
                    i3 = -1391700845;
                    $dirty2 = $dirty & i2;
                    containerColor3 = containerColor2;
                    $dirty3 = 1572864;
                    tonalElevation3 = tonalElevation2;
                    modifier3 = modifier2;
                } else {
                    $dirty2 = $dirty;
                    contentPadding3 = contentPadding2;
                    windowInsets3 = windowInsets2;
                    $dirty3 = 1572864;
                    i3 = -1391700845;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    tonalElevation3 = tonalElevation2;
                    modifier3 = modifier2;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty6 = (i & 2) != 0 ? $dirty5 & (-113) : $dirty5;
                if ((i & 4) != 0) {
                    $dirty6 &= -897;
                }
                if ((i & 32) != 0) {
                    $dirty2 = $dirty6 & (-458753);
                    contentPadding3 = contentPadding2;
                    windowInsets3 = windowInsets2;
                    $dirty3 = 1572864;
                    i3 = -1391700845;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    tonalElevation3 = tonalElevation2;
                    modifier3 = modifier2;
                } else {
                    $dirty2 = $dirty6;
                    contentPadding3 = contentPadding2;
                    windowInsets3 = windowInsets2;
                    $dirty3 = 1572864;
                    i3 = -1391700845;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    tonalElevation3 = tonalElevation2;
                    modifier3 = modifier2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i3, $dirty2, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:533)");
            }
            $composer2 = $composer3;
            m1772BottomAppBare3WI5M(modifier3, containerColor3, contentColor3, tonalElevation3, contentPadding3, windowInsets3, null, function3, $composer2, $dirty3 | ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2) | (458752 & $dirty2) | (29360128 & ($dirty2 << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            containerColor4 = containerColor3;
            modifier4 = modifier3;
            contentColor4 = contentColor3;
            tonalElevation4 = tonalElevation3;
            contentPadding4 = contentPadding3;
            windowInsets4 = windowInsets3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i10) {
                    AppBarKt.m1770BottomAppBar1oL4kX8(modifier4, containerColor4, contentColor4, tonalElevation4, contentPadding4, windowInsets4, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: BottomAppBar-e-3WI5M, reason: not valid java name */
    public static final void m1772BottomAppBare3WI5M(Modifier modifier, long containerColor, long contentColor, float tonalElevation, PaddingValues contentPadding, WindowInsets windowInsets, BottomAppBarScrollBehavior scrollBehavior, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long containerColor2;
        long contentColor2;
        float f;
        PaddingValues paddingValues;
        int $dirty;
        final PaddingValues contentPadding2;
        WindowInsets windowInsets2;
        float tonalElevation2;
        long containerColor3;
        int i2;
        final BottomAppBarScrollBehavior scrollBehavior2;
        int $dirty2;
        long contentColor3;
        final WindowInsets windowInsets3;
        int i3;
        int $dirty3;
        int i4;
        int i5;
        Modifier.Companion appBarDragModifier;
        Object value$iv;
        Composer $composer2;
        final WindowInsets windowInsets4;
        final Modifier modifier3;
        final PaddingValues contentPadding3;
        final long contentColor4;
        final float tonalElevation3;
        final BottomAppBarScrollBehavior scrollBehavior3;
        final long containerColor4;
        Object value$iv2;
        AppBarKt$BottomAppBar$appBarDragModifier$2$1 value$iv3;
        Composer $composer3 = $composer.startRestartGroup(422438773);
        ComposerKt.sourceInformation($composer3, "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp,3,7,5)577@29038L14,578@29080L31,581@29306L12,613@30640L5,615@30695L577,608@30373L1325:AppBar.kt#uh7d8r");
        int $dirty4 = $changed;
        int i6 = i & 1;
        if (i6 != 0) {
            $dirty4 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                containerColor2 = containerColor;
                int i7 = $composer3.changed(containerColor2) ? 32 : 16;
                $dirty4 |= i7;
            } else {
                containerColor2 = containerColor;
            }
            $dirty4 |= i7;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                int i8 = $composer3.changed(contentColor2) ? 256 : 128;
                $dirty4 |= i8;
            } else {
                contentColor2 = contentColor;
            }
            $dirty4 |= i8;
        } else {
            contentColor2 = contentColor;
        }
        int i9 = i & 8;
        if (i9 != 0) {
            $dirty4 |= 3072;
            f = tonalElevation;
        } else if (($changed & 3072) == 0) {
            f = tonalElevation;
            $dirty4 |= $composer3.changed(f) ? 2048 : 1024;
        } else {
            f = tonalElevation;
        }
        int i10 = i & 16;
        if (i10 != 0) {
            $dirty4 |= 24576;
            paddingValues = contentPadding;
        } else if (($changed & 24576) == 0) {
            paddingValues = contentPadding;
            $dirty4 |= $composer3.changed(paddingValues) ? 16384 : 8192;
        } else {
            paddingValues = contentPadding;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            $dirty4 |= ((i & 32) == 0 && $composer3.changed(windowInsets)) ? 131072 : 65536;
        }
        int i11 = i & 64;
        if (i11 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty4 |= $composer3.changed(scrollBehavior) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty4 |= $composer3.changedInstance(function3) ? 8388608 : 4194304;
        }
        int $dirty5 = $dirty4;
        if ((4793491 & $dirty4) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            scrollBehavior3 = scrollBehavior;
            $composer2 = $composer3;
            modifier3 = modifier2;
            containerColor4 = containerColor2;
            contentColor4 = contentColor2;
            tonalElevation3 = f;
            contentPadding3 = paddingValues;
            windowInsets4 = windowInsets;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 2) != 0) {
                    containerColor2 = BottomAppBarDefaults.INSTANCE.getContainerColor($composer3, 6);
                    $dirty = $dirty5 & (-113);
                } else {
                    $dirty = $dirty5;
                }
                if ((i & 4) != 0) {
                    contentColor2 = ColorSchemeKt.m1935contentColorForek8zF_U(containerColor2, $composer3, ($dirty >> 3) & 14);
                    $dirty &= -897;
                }
                float tonalElevation4 = i9 != 0 ? BottomAppBarDefaults.INSTANCE.m1788getContainerElevationD9Ej5fM() : f;
                contentPadding2 = i10 != 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : paddingValues;
                if ((i & 32) != 0) {
                    windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets($composer3, 6);
                    $dirty &= -458753;
                } else {
                    windowInsets2 = windowInsets;
                }
                if (i11 != 0) {
                    tonalElevation2 = tonalElevation4;
                    containerColor3 = containerColor2;
                    scrollBehavior2 = null;
                    i2 = 12582912;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                    windowInsets3 = windowInsets2;
                    i3 = 422438773;
                } else {
                    tonalElevation2 = tonalElevation4;
                    containerColor3 = containerColor2;
                    i2 = 12582912;
                    scrollBehavior2 = scrollBehavior;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                    windowInsets3 = windowInsets2;
                    i3 = 422438773;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty6 = (i & 2) != 0 ? $dirty5 & (-113) : $dirty5;
                if ((i & 4) != 0) {
                    $dirty6 &= -897;
                }
                if ((i & 32) != 0) {
                    $dirty6 &= -458753;
                }
                scrollBehavior2 = scrollBehavior;
                tonalElevation2 = f;
                contentPadding2 = paddingValues;
                containerColor3 = containerColor2;
                i2 = 12582912;
                $dirty2 = $dirty6;
                contentColor3 = contentColor2;
                i3 = 422438773;
                windowInsets3 = windowInsets;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i3, $dirty2, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:584)");
            }
            $composer3.startReplaceableGroup(1291864525);
            ComposerKt.sourceInformation($composer3, "589@29726L83,589@29703L106,592@29839L261");
            if (scrollBehavior2 == null || scrollBehavior2.getIsPinned()) {
                $dirty3 = $dirty2;
                i4 = i2;
                i5 = 3670016;
                appBarDragModifier = Modifier.INSTANCE;
            } else {
                Modifier.Companion companion = Modifier.INSTANCE;
                Orientation orientation = Orientation.Vertical;
                i4 = i2;
                $composer3.startReplaceableGroup(1291864702);
                ComposerKt.sourceInformation($composer3, "CC(remember):AppBar.kt#9igjgp");
                i5 = 3670016;
                boolean invalid$iv = ($dirty2 & 3670016) == 1048576;
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$appBarDragModifier$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f2) {
                            invoke(f2.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float delta) {
                            BottomAppBarState state = scrollBehavior2.getState();
                            state.setHeightOffset(state.getHeightOffset() - delta);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv;
                }
                $composer3.endReplaceableGroup();
                DraggableState draggableStateRememberDraggableState = DraggableKt.rememberDraggableState((Function1) value$iv2, $composer3, 0);
                Modifier.Companion companion2 = companion;
                $composer3.startReplaceableGroup(1291864815);
                ComposerKt.sourceInformation($composer3, "CC(remember):AppBar.kt#9igjgp");
                boolean invalid$iv2 = ($dirty2 & 3670016) == 1048576;
                Object it$iv2 = $composer3.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    $dirty3 = $dirty2;
                    value$iv3 = new AppBarKt$BottomAppBar$appBarDragModifier$2$1(scrollBehavior2, null);
                    $composer3.updateRememberedValue(value$iv3);
                } else {
                    $dirty3 = $dirty2;
                    value$iv3 = it$iv2;
                }
                $composer3.endReplaceableGroup();
                appBarDragModifier = DraggableKt.draggable(companion2, draggableStateRememberDraggableState, orientation, (188 & 4) != 0, (188 & 8) != 0 ? null : null, (188 & 16) != 0 ? false : false, (188 & 32) != 0 ? new DraggableKt.C03841(null) : null, (188 & 64) != 0 ? new DraggableKt.C03852(null) : (Function3) value$iv3, (188 & 128) != 0 ? false : false);
            }
            $composer3.endReplaceableGroup();
            Shape value = ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), $composer3, 6);
            $composer3.startReplaceableGroup(1291865671);
            ComposerKt.sourceInformation($composer3, "CC(remember):AppBar.kt#9igjgp");
            boolean invalid$iv3 = ($dirty3 & i5) == 1048576;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m1778invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m1778invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                        BottomAppBarState state;
                        BottomAppBarScrollBehavior bottomAppBarScrollBehavior = scrollBehavior2;
                        BottomAppBarState state2 = bottomAppBarScrollBehavior != null ? bottomAppBarScrollBehavior.getState() : null;
                        if (state2 != null) {
                            state2.setHeightOffsetLimit(-$this$layout.mo518toPx0680j_4(BottomAppBarTokens.INSTANCE.m2856getContainerHeightD9Ej5fM()));
                        }
                        final Placeable placeable = measurable.mo5219measureBRTryo0(constraints);
                        float height = placeable.getHeight();
                        BottomAppBarScrollBehavior bottomAppBarScrollBehavior2 = scrollBehavior2;
                        float height2 = height + ((bottomAppBarScrollBehavior2 == null || (state = bottomAppBarScrollBehavior2.getState()) == null) ? 0.0f : state.getHeightOffset());
                        return MeasureScope.layout$default($this$layout, placeable.getWidth(), MathKt.roundToInt(height2), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                Placeable.PlacementScope.place$default($this$layout2, placeable, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv3;
            }
            $composer3.endReplaceableGroup();
            $composer2 = $composer3;
            SurfaceKt.m2519SurfaceT9BRK9s(LayoutModifierKt.layout(modifier2, (Function3) value$iv).then(appBarDragModifier), value, containerColor3, contentColor3, tonalElevation2, 0.0f, null, ComposableLambdaKt.composableLambda($composer3, 1243053520, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C629@31327L365:AppBar.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1243053520, $changed2, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:629)");
                        }
                        Modifier modifier$iv = PaddingKt.padding(SizeKt.m802height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets3), BottomAppBarTokens.INSTANCE.m2856getContainerHeightD9Ej5fM()), contentPadding2);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function3 content$iv = function3;
                        $composer4.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        $composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3479constructorimpl($composer4);
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        $composer4.startReplaceableGroup(2058660585);
                        int i12 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        content$iv.invoke(RowScopeInstance.INSTANCE, $composer4, Integer.valueOf(((432 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endReplaceableGroup();
                        $composer4.endNode();
                        $composer4.endReplaceableGroup();
                        $composer4.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, (($dirty3 << 3) & 896) | i4 | (($dirty3 << 3) & 7168) | (57344 & ($dirty3 << 3)), 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets4 = windowInsets3;
            modifier3 = modifier2;
            contentPadding3 = contentPadding2;
            contentColor4 = contentColor3;
            tonalElevation3 = tonalElevation2;
            scrollBehavior3 = scrollBehavior2;
            containerColor4 = containerColor3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i12) {
                    AppBarKt.m1772BottomAppBare3WI5M(modifier3, containerColor4, contentColor4, tonalElevation3, contentPadding3, windowInsets4, scrollBehavior3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final TopAppBarState rememberTopAppBarState(final float initialHeightOffsetLimit, final float initialHeightOffset, final float initialContentOffset, Composer $composer, int $changed, int i) {
        Object value$iv;
        $composer.startReplaceableGroup(1801969826);
        ComposerKt.sourceInformation($composer, "C(rememberTopAppBarState)P(2,1)1052@50642L145,1052@50595L192:AppBar.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialHeightOffsetLimit = -3.4028235E38f;
        }
        if ((i & 2) != 0) {
            initialHeightOffset = 0.0f;
        }
        if ((i & 4) != 0) {
            initialContentOffset = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1801969826, $changed, -1, "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:1051)");
        }
        Object[] objArr = new Object[0];
        Saver<TopAppBarState, ?> saver = TopAppBarState.INSTANCE.getSaver();
        $composer.startReplaceableGroup(1171243704);
        ComposerKt.sourceInformation($composer, "CC(remember):AppBar.kt#9igjgp");
        boolean invalid$iv = (((($changed & 896) ^ 384) > 256 && $composer.changed(initialContentOffset)) || ($changed & 384) == 256) | (((($changed & 14) ^ 6) > 4 && $composer.changed(initialHeightOffsetLimit)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(initialHeightOffset)) || ($changed & 48) == 32);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = (Function0) new Function0<TopAppBarState>() { // from class: androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TopAppBarState invoke() {
                    return new TopAppBarState(initialHeightOffsetLimit, initialHeightOffset, initialContentOffset);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        $composer.endReplaceableGroup();
        TopAppBarState topAppBarState = (TopAppBarState) RememberSaveableKt.m3566rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return topAppBarState;
    }

    public static final BottomAppBarState rememberBottomAppBarState(final float initialHeightOffsetLimit, final float initialHeightOffset, final float initialContentOffset, Composer $composer, int $changed, int i) {
        Object value$iv;
        $composer.startReplaceableGroup(1420874240);
        ComposerKt.sourceInformation($composer, "C(rememberBottomAppBarState)P(2,1)1373@63308L148,1373@63258L198:AppBar.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialHeightOffsetLimit = -3.4028235E38f;
        }
        if ((i & 2) != 0) {
            initialHeightOffset = 0.0f;
        }
        if ((i & 4) != 0) {
            initialContentOffset = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1420874240, $changed, -1, "androidx.compose.material3.rememberBottomAppBarState (AppBar.kt:1372)");
        }
        Object[] objArr = new Object[0];
        Saver<BottomAppBarState, ?> saver = BottomAppBarState.INSTANCE.getSaver();
        $composer.startReplaceableGroup(647586024);
        ComposerKt.sourceInformation($composer, "CC(remember):AppBar.kt#9igjgp");
        boolean invalid$iv = (((($changed & 896) ^ 384) > 256 && $composer.changed(initialContentOffset)) || ($changed & 384) == 256) | (((($changed & 14) ^ 6) > 4 && $composer.changed(initialHeightOffsetLimit)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(initialHeightOffset)) || ($changed & 48) == 32);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = (Function0) new Function0<BottomAppBarState>() { // from class: androidx.compose.material3.AppBarKt$rememberBottomAppBarState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BottomAppBarState invoke() {
                    return AppBarKt.BottomAppBarState(initialHeightOffsetLimit, initialHeightOffset, initialContentOffset);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        $composer.endReplaceableGroup();
        BottomAppBarState bottomAppBarState = (BottomAppBarState) RememberSaveableKt.m3566rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomAppBarState;
    }

    public static final BottomAppBarState BottomAppBarState(float initialHeightOffsetLimit, float initialHeightOffset, float initialContentOffset) {
        return new BottomAppBarStateImpl(initialHeightOffsetLimit, initialHeightOffset, initialContentOffset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0122 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object settleAppBarBottom(final androidx.compose.material3.BottomAppBarState r23, float r24, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r25, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r26, kotlin.coroutines.Continuation<? super androidx.compose.p000ui.unit.Velocity> r27) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.settleAppBarBottom(androidx.compose.material3.BottomAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static {
        float arg0$iv = C1956Dp.m6297constructorimpl(16);
        float other$iv = C1956Dp.m6297constructorimpl(12);
        BottomAppBarHorizontalPadding = C1956Dp.m6297constructorimpl(arg0$iv - other$iv);
        float arg0$iv2 = C1956Dp.m6297constructorimpl(16);
        float other$iv2 = C1956Dp.m6297constructorimpl(12);
        BottomAppBarVerticalPadding = C1956Dp.m6297constructorimpl(arg0$iv2 - other$iv2);
        float arg0$iv3 = C1956Dp.m6297constructorimpl(16);
        float other$iv3 = BottomAppBarHorizontalPadding;
        FABHorizontalPadding = C1956Dp.m6297constructorimpl(arg0$iv3 - other$iv3);
        float arg0$iv4 = C1956Dp.m6297constructorimpl(12);
        float other$iv4 = BottomAppBarVerticalPadding;
        FABVerticalPadding = C1956Dp.m6297constructorimpl(arg0$iv4 - other$iv4);
        TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);
        MediumTitleBottomPadding = C1956Dp.m6297constructorimpl(24);
        LargeTitleBottomPadding = C1956Dp.m6297constructorimpl(28);
        TopAppBarHorizontalPadding = C1956Dp.m6297constructorimpl(4);
        float arg0$iv5 = C1956Dp.m6297constructorimpl(16);
        float other$iv5 = TopAppBarHorizontalPadding;
        TopAppBarTitleInset = C1956Dp.m6297constructorimpl(arg0$iv5 - other$iv5);
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0330  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void SingleRowTopAppBar(androidx.compose.p000ui.Modifier r34, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, final androidx.compose.p000ui.text.TextStyle r36, final boolean r37, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, final androidx.compose.foundation.layout.WindowInsets r40, final androidx.compose.material3.TopAppBarColors r41, final androidx.compose.material3.TopAppBarScrollBehavior r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 818
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.SingleRowTopAppBar(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final long SingleRowTopAppBar$lambda$7(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m3959unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0407  */
    /* renamed from: TwoRowsTopAppBar-tjU4iQQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1775TwoRowsTopAppBartjU4iQQ(androidx.compose.p000ui.Modifier r41, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, final androidx.compose.p000ui.text.TextStyle r43, final float r44, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, final androidx.compose.p000ui.text.TextStyle r46, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, final androidx.compose.foundation.layout.WindowInsets r49, final androidx.compose.material3.TopAppBarColors r50, final float r51, final float r52, final androidx.compose.material3.TopAppBarScrollBehavior r53, androidx.compose.runtime.Composer r54, final int r55, final int r56, final int r57) {
        /*
            Method dump skipped, instructions count: 1040
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1775TwoRowsTopAppBartjU4iQQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, float, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, float, float, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:145:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0655  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x074c  */
    /* renamed from: TopAppBarLayout-kXwM9vE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1774TopAppBarLayoutkXwM9vE(androidx.compose.p000ui.Modifier r60, final float r61, long r62, final long r64, final long r66, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, final androidx.compose.p000ui.text.TextStyle r69, final float r70, final androidx.compose.foundation.layout.Arrangement.Vertical r71, final androidx.compose.foundation.layout.Arrangement.Horizontal r72, final int r73, final boolean r74, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, androidx.compose.runtime.Composer r77, final int r78, final int r79) {
        /*
            Method dump skipped, instructions count: 1917
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1774TopAppBarLayoutkXwM9vE(androidx.compose.ui.Modifier, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, float, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, int, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0122 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object settleAppBar(final androidx.compose.material3.TopAppBarState r23, float r24, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r25, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r26, kotlin.coroutines.Continuation<? super androidx.compose.p000ui.unit.Velocity> r27) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.settleAppBar(androidx.compose.material3.TopAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }
}
