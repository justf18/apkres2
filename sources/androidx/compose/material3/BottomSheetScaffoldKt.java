package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.OnRemeasuredModifierKt;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.layout.SubcomposeLayoutKt;
import androidx.compose.p000ui.layout.SubcomposeMeasureScope;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BottomSheetScaffold.kt */
@Metadata(m164d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\u008a\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001aÀ\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052&\u0010#\u001a\"\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052&\u0010'\u001a\"\u0012\u0013\u0012\u00110(¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0006\u0010\u000b\u001a\u00020\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00162\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a¶\u0001\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020-2'\u00102\u001a#\u0012\u0013\u0012\u001103¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(4\u0012\n\u0012\b\u0012\u0004\u0012\u000206050\u00032\u0006\u00107\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\f2\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0003ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a!\u0010>\u001a\u00020\n2\b\b\u0002\u0010?\u001a\u00020-2\b\b\u0002\u0010@\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010A\u001a7\u0010B\u001a\u00020-2\b\b\u0002\u0010C\u001a\u0002062\u0014\b\u0002\u0010D\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0002\u0010E\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010F\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G"}, m165d2 = {"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetMaxWidth", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-sdMYb0k", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "", "sheetState", "Landroidx/compose/material3/SheetState;", "BottomSheetScaffoldLayout-PxNyym8", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;JJLandroidx/compose/runtime/Composer;I)V", "StandardBottomSheet", "state", "calculateAnchors", "Landroidx/compose/ui/unit/IntSize;", "sheetSize", "Landroidx/compose/material3/DraggableAnchors;", "Landroidx/compose/material3/SheetValue;", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-XcniZvE", "(Landroidx/compose/material3/SheetState;Lkotlin/jvm/functions/Function1;FFZLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BottomSheetScaffoldKt {
    /* renamed from: BottomSheetScaffold-sdMYb0k, reason: not valid java name */
    public static final void m1793BottomSheetScaffoldsdMYb0k(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState scaffoldState, float sheetPeekHeight, float sheetMaxWidth, Shape sheetShape, long sheetContainerColor, long sheetContentColor, float sheetTonalElevation, float sheetShadowElevation, Function2<? super Composer, ? super Integer, Unit> function2, boolean sheetSwipeEnabled, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, long containerColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34;
        final BottomSheetScaffoldState scaffoldState2;
        float sheetPeekHeight2;
        float sheetMaxWidth2;
        Shape sheetShape2;
        long sheetContainerColor2;
        long sheetContentColor2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Modifier modifier2;
        int i8;
        int $dirty1;
        float sheetShadowElevation2;
        Function2 sheetDragHandle;
        boolean sheetSwipeEnabled2;
        Function2 topBar;
        float sheetTonalElevation2;
        long containerColor2;
        int $dirty12;
        final long containerColor3;
        Modifier modifier3;
        float sheetTonalElevation3;
        long contentColor2;
        final Function3 snackbarHost;
        final float sheetTonalElevation4;
        final float sheetShadowElevation3;
        Composer $composer2;
        final float sheetPeekHeight3;
        final float sheetMaxWidth3;
        final long sheetContainerColor3;
        final BottomSheetScaffoldState scaffoldState3;
        final Function2 sheetDragHandle2;
        final Function3 snackbarHost2;
        final float sheetTonalElevation5;
        final float sheetShadowElevation4;
        final Shape sheetShape3;
        final long sheetContentColor3;
        final Function2 topBar2;
        final boolean sheetSwipeEnabled3;
        final long contentColor3;
        final Modifier modifier4;
        int i9;
        Composer $composer3 = $composer.startRestartGroup(-1523924135);
        ComposerKt.sourceInformation($composer3, "C(BottomSheetScaffold)P(6,3,4,10:c#ui.unit.Dp,9:c#ui.unit.Dp,12,5:c#ui.graphics.Color,7:c#ui.graphics.Color,14:c#ui.unit.Dp,11:c#ui.unit.Dp,8,13,16,15,0:c#ui.graphics.Color,2:c#ui.graphics.Color)103@5431L34,106@5633L13,107@5701L14,108@5748L36,115@6205L11,116@6252L31,*119@6379L7,130@6700L50,122@6436L1811:BottomSheetScaffold.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty13 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
            function34 = function3;
        } else if (($changed & 6) == 0) {
            function34 = function3;
            $dirty |= $composer3.changedInstance(function34) ? 4 : 2;
        } else {
            function34 = function3;
        }
        int i10 = i & 2;
        if (i10 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                scaffoldState2 = scaffoldState;
                int i11 = $composer3.changed(scaffoldState2) ? 256 : 128;
                $dirty |= i11;
            } else {
                scaffoldState2 = scaffoldState;
            }
            $dirty |= i11;
        } else {
            scaffoldState2 = scaffoldState;
        }
        int i12 = i & 8;
        if (i12 != 0) {
            $dirty |= 3072;
            sheetPeekHeight2 = sheetPeekHeight;
        } else if (($changed & 3072) == 0) {
            sheetPeekHeight2 = sheetPeekHeight;
            $dirty |= $composer3.changed(sheetPeekHeight2) ? 2048 : 1024;
        } else {
            sheetPeekHeight2 = sheetPeekHeight;
        }
        int i13 = i & 16;
        int i14 = 8192;
        if (i13 != 0) {
            $dirty |= 24576;
            sheetMaxWidth2 = sheetMaxWidth;
        } else if (($changed & 24576) == 0) {
            sheetMaxWidth2 = sheetMaxWidth;
            $dirty |= $composer3.changed(sheetMaxWidth2) ? 16384 : 8192;
        } else {
            sheetMaxWidth2 = sheetMaxWidth;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            if ((i & 32) == 0) {
                sheetShape2 = sheetShape;
                if ($composer3.changed(sheetShape2)) {
                    i9 = 131072;
                }
                $dirty |= i9;
            } else {
                sheetShape2 = sheetShape;
            }
            i9 = 65536;
            $dirty |= i9;
        } else {
            sheetShape2 = sheetShape;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                sheetContainerColor2 = sheetContainerColor;
                int i15 = $composer3.changed(sheetContainerColor2) ? 1048576 : 524288;
                $dirty |= i15;
            } else {
                sheetContainerColor2 = sheetContainerColor;
            }
            $dirty |= i15;
        } else {
            sheetContainerColor2 = sheetContainerColor;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                sheetContentColor2 = sheetContentColor;
                int i16 = $composer3.changed(sheetContentColor2) ? 8388608 : 4194304;
                $dirty |= i16;
            } else {
                sheetContentColor2 = sheetContentColor;
            }
            $dirty |= i16;
        } else {
            sheetContentColor2 = sheetContentColor;
        }
        int i17 = i & 256;
        if (i17 != 0) {
            $dirty |= 100663296;
            i2 = i17;
        } else if (($changed & 100663296) == 0) {
            i2 = i17;
            $dirty |= $composer3.changed(sheetTonalElevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i17;
        }
        int i18 = i & 512;
        if (i18 != 0) {
            $dirty |= 805306368;
            i3 = i18;
        } else if (($changed & 805306368) == 0) {
            i3 = i18;
            $dirty |= $composer3.changed(sheetShadowElevation) ? 536870912 : 268435456;
        } else {
            i3 = i18;
        }
        int i19 = i & 1024;
        if (i19 != 0) {
            $dirty13 |= 6;
            i4 = i19;
        } else if (($changed1 & 6) == 0) {
            i4 = i19;
            $dirty13 |= $composer3.changedInstance(function2) ? 4 : 2;
        } else {
            i4 = i19;
        }
        int i20 = i & 2048;
        if (i20 != 0) {
            $dirty13 |= 48;
            i5 = i20;
        } else if (($changed1 & 48) == 0) {
            i5 = i20;
            $dirty13 |= $composer3.changed(sheetSwipeEnabled) ? 32 : 16;
        } else {
            i5 = i20;
        }
        int i21 = i & 4096;
        if (i21 != 0) {
            $dirty13 |= 384;
            i6 = i21;
        } else {
            i6 = i21;
            if (($changed1 & 384) == 0) {
                $dirty13 |= $composer3.changedInstance(function22) ? 256 : 128;
            }
        }
        int i22 = i & 8192;
        if (i22 != 0) {
            $dirty13 |= 3072;
            i7 = i22;
        } else {
            i7 = i22;
            if (($changed1 & 3072) == 0) {
                $dirty13 |= $composer3.changedInstance(function32) ? 2048 : 1024;
            }
        }
        if (($changed1 & 24576) == 0) {
            if ((i & 16384) == 0 && $composer3.changed(containerColor)) {
                i14 = 16384;
            }
            $dirty13 |= i14;
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            $dirty13 |= ((i & 32768) == 0 && $composer3.changed(contentColor)) ? 131072 : 65536;
        }
        if ((i & 65536) != 0) {
            $dirty13 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty13 |= $composer3.changedInstance(function33) ? 1048576 : 524288;
        }
        if ((306783379 & $dirty) == 306783378 && (599187 & $dirty13) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            snackbarHost2 = function32;
            containerColor3 = containerColor;
            contentColor3 = contentColor;
            $composer2 = $composer3;
            sheetPeekHeight3 = sheetPeekHeight2;
            sheetMaxWidth3 = sheetMaxWidth2;
            sheetShape3 = sheetShape2;
            sheetContainerColor3 = sheetContainerColor2;
            scaffoldState3 = scaffoldState2;
            sheetContentColor3 = sheetContentColor2;
            sheetTonalElevation5 = sheetTonalElevation;
            sheetShadowElevation4 = sheetShadowElevation;
            sheetDragHandle2 = function2;
            sheetSwipeEnabled3 = sheetSwipeEnabled;
            topBar2 = function22;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i10 != 0 ? Modifier.INSTANCE : modifier;
                if ((i & 4) != 0) {
                    i8 = -458753;
                    modifier2 = modifier5;
                    $dirty1 = $dirty13;
                    $dirty &= -897;
                    scaffoldState2 = rememberBottomSheetScaffoldState(null, null, $composer3, 0, 3);
                } else {
                    modifier2 = modifier5;
                    i8 = -458753;
                    $dirty1 = $dirty13;
                }
                if (i12 != 0) {
                    sheetPeekHeight2 = BottomSheetDefaults.INSTANCE.m1792getSheetPeekHeightD9Ej5fM();
                }
                if (i13 != 0) {
                    sheetMaxWidth2 = BottomSheetDefaults.INSTANCE.m1791getSheetMaxWidthD9Ej5fM();
                }
                if ((i & 32) != 0) {
                    $dirty &= i8;
                    sheetShape2 = BottomSheetDefaults.INSTANCE.getExpandedShape($composer3, 6);
                }
                if ((i & 64) != 0) {
                    sheetContainerColor2 = BottomSheetDefaults.INSTANCE.getContainerColor($composer3, 6);
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    sheetContentColor2 = ColorSchemeKt.m1935contentColorForek8zF_U(sheetContainerColor2, $composer3, ($dirty >> 18) & 14);
                    $dirty &= -29360129;
                }
                float sheetTonalElevation6 = i2 != 0 ? BottomSheetDefaults.INSTANCE.m1790getElevationD9Ej5fM() : sheetTonalElevation;
                sheetShadowElevation2 = i3 != 0 ? BottomSheetDefaults.INSTANCE.m1790getElevationD9Ej5fM() : sheetShadowElevation;
                sheetDragHandle = i4 != 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1957getLambda1$material3_release() : function2;
                sheetSwipeEnabled2 = i5 != 0 ? true : sheetSwipeEnabled;
                topBar = i6 != 0 ? null : function22;
                Function3 snackbarHost3 = i7 != 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1958getLambda2$material3_release() : function32;
                if ((i & 16384) != 0) {
                    sheetTonalElevation2 = sheetTonalElevation6;
                    containerColor2 = MaterialTheme.INSTANCE.getColorScheme($composer3, 6).getSurface();
                    $dirty1 &= -57345;
                } else {
                    sheetTonalElevation2 = sheetTonalElevation6;
                    containerColor2 = containerColor;
                }
                if ((i & 32768) != 0) {
                    contentColor2 = ColorSchemeKt.m1935contentColorForek8zF_U(containerColor2, $composer3, ($dirty1 >> 12) & 14);
                    int i23 = $dirty1 & i8;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    $dirty12 = i23;
                    snackbarHost = snackbarHost3;
                    sheetTonalElevation3 = sheetTonalElevation2;
                } else {
                    long contentColor4 = containerColor2;
                    $dirty12 = $dirty1;
                    containerColor3 = contentColor4;
                    modifier3 = modifier2;
                    sheetTonalElevation3 = sheetTonalElevation2;
                    contentColor2 = contentColor;
                    snackbarHost = snackbarHost3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 16384) != 0) {
                    $dirty13 &= -57345;
                }
                if ((i & 32768) != 0) {
                    $dirty12 = $dirty13 & (-458753);
                    sheetTonalElevation3 = sheetTonalElevation;
                    sheetShadowElevation2 = sheetShadowElevation;
                    sheetDragHandle = function2;
                    sheetSwipeEnabled2 = sheetSwipeEnabled;
                    topBar = function22;
                    snackbarHost = function32;
                    containerColor3 = containerColor;
                    contentColor2 = contentColor;
                    modifier3 = modifier;
                } else {
                    sheetTonalElevation3 = sheetTonalElevation;
                    sheetDragHandle = function2;
                    sheetSwipeEnabled2 = sheetSwipeEnabled;
                    topBar = function22;
                    snackbarHost = function32;
                    containerColor3 = containerColor;
                    contentColor2 = contentColor;
                    $dirty12 = $dirty13;
                    modifier3 = modifier;
                    sheetShadowElevation2 = sheetShadowElevation;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                sheetTonalElevation4 = sheetTonalElevation3;
                sheetShadowElevation3 = sheetShadowElevation2;
                ComposerKt.traceEventStart(-1523924135, $dirty, $dirty12, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:118)");
            } else {
                sheetTonalElevation4 = sheetTonalElevation3;
                sheetShadowElevation3 = sheetShadowElevation2;
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            int $dirty14 = $dirty12;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$BottomSheetScaffold_sdMYb0k_u24lambda_u240 = (Density) objConsume;
            final int peekHeightPx = $this$BottomSheetScaffold_sdMYb0k_u24lambda_u240.mo512roundToPx0680j_4(sheetPeekHeight2);
            SheetState bottomSheetState = scaffoldState2.getBottomSheetState();
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35 = function34;
            final float sheetPeekHeight4 = sheetPeekHeight2;
            final float sheetMaxWidth4 = sheetMaxWidth2;
            final Function2 sheetDragHandle3 = sheetDragHandle;
            final Shape sheetShape4 = sheetShape2;
            final long sheetContainerColor4 = sheetContainerColor2;
            final BottomSheetScaffoldState scaffoldState4 = scaffoldState2;
            final long sheetContentColor4 = sheetContentColor2;
            final boolean sheetSwipeEnabled4 = sheetSwipeEnabled2;
            float sheetTonalElevation7 = sheetTonalElevation4;
            float sheetShadowElevation5 = sheetShadowElevation3;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda($composer3, -680109608, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer, Integer num2) {
                    invoke(num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final int layoutHeight, Composer $composer4, int $changed2) {
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r");
                    int $dirty2 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty2 |= $composer4.changed(layoutHeight) ? 4 : 2;
                    }
                    if (($dirty2 & 19) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-680109608, $dirty2, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)");
                        }
                        SheetState bottomSheetState2 = scaffoldState4.getBottomSheetState();
                        $composer4.startReplaceableGroup(1237684821);
                        ComposerKt.sourceInformation($composer4, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                        boolean invalid$iv = (($dirty2 & 14) == 4) | $composer4.changed(scaffoldState4) | $composer4.changed(peekHeightPx);
                        final BottomSheetScaffoldState bottomSheetScaffoldState = scaffoldState4;
                        final int i24 = peekHeightPx;
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = (Function1) new Function1<IntSize, DraggableAnchors<SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ DraggableAnchors<SheetValue> invoke(IntSize intSize) {
                                    return m1798invokeozmzZPI(intSize.getPackedValue());
                                }

                                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final DraggableAnchors<SheetValue> m1798invokeozmzZPI(long sheetSize) {
                                    final int sheetHeight = IntSize.m6466getHeightimpl(sheetSize);
                                    final BottomSheetScaffoldState bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                                    final int i25 = layoutHeight;
                                    final int i26 = i24;
                                    return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                            invoke2(draggableAnchorsConfig);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                            if (!bottomSheetScaffoldState2.getBottomSheetState().getSkipPartiallyExpanded()) {
                                                draggableAnchorsConfig.m17at(SheetValue.PartiallyExpanded, i25 - i26);
                                            }
                                            if (sheetHeight != i26) {
                                                draggableAnchorsConfig.m17at(SheetValue.Expanded, Math.max(i25 - sheetHeight, 0));
                                            }
                                            if (!bottomSheetScaffoldState2.getBottomSheetState().getSkipHiddenState()) {
                                                draggableAnchorsConfig.m17at(SheetValue.Hidden, i25);
                                            }
                                        }
                                    });
                                }
                            };
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer4.endReplaceableGroup();
                        BottomSheetScaffoldKt.m1795StandardBottomSheetXcniZvE(bottomSheetState2, (Function1) value$iv, sheetPeekHeight4, sheetMaxWidth4, sheetSwipeEnabled4, sheetShape4, sheetContainerColor4, sheetContentColor4, sheetTonalElevation4, sheetShadowElevation3, sheetDragHandle3, function35, $composer4, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            });
            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda($composer3, 88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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
                    ComposerKt.sourceInformation($composer4, "C127@6578L45:BottomSheetScaffold.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(88659390, $changed2, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:127)");
                    }
                    snackbarHost.invoke(scaffoldState2.getSnackbarHostState(), $composer4, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            $composer3.startReplaceableGroup(-1567544379);
            ComposerKt.sourceInformation($composer3, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean invalid$iv = ((($dirty & 896) ^ 384) > 256 && $composer3.changed(scaffoldState2)) || ($dirty & 384) == 256;
            Object value$iv = $composer3.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(scaffoldState2.getBottomSheetState().requireOffset());
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            }
            $composer3.endReplaceableGroup();
            Modifier modifier6 = modifier3;
            m1794BottomSheetScaffoldLayoutPxNyym8(modifier6, topBar, function33, composableLambda, composableLambda2, sheetPeekHeight2, (Function0) value$iv, bottomSheetState, containerColor3, contentColor2, $composer3, (($dirty >> 3) & 14) | 27648 | (($dirty14 >> 3) & 112) | (($dirty14 >> 12) & 896) | (($dirty << 6) & 458752) | (($dirty14 << 12) & 234881024) | (($dirty14 << 12) & 1879048192));
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            sheetPeekHeight3 = sheetPeekHeight2;
            sheetMaxWidth3 = sheetMaxWidth2;
            sheetContainerColor3 = sheetContainerColor2;
            scaffoldState3 = scaffoldState2;
            sheetDragHandle2 = sheetDragHandle3;
            snackbarHost2 = snackbarHost;
            sheetTonalElevation5 = sheetTonalElevation7;
            sheetShadowElevation4 = sheetShadowElevation5;
            sheetShape3 = sheetShape2;
            sheetContentColor3 = sheetContentColor2;
            topBar2 = topBar;
            sheetSwipeEnabled3 = sheetSwipeEnabled4;
            contentColor3 = contentColor2;
            modifier4 = modifier6;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$4
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

                public final void invoke(Composer composer, int i24) {
                    BottomSheetScaffoldKt.m1793BottomSheetScaffoldsdMYb0k(function3, modifier4, scaffoldState3, sheetPeekHeight3, sheetMaxWidth3, sheetShape3, sheetContainerColor3, sheetContentColor3, sheetTonalElevation5, sheetShadowElevation4, sheetDragHandle2, sheetSwipeEnabled3, topBar2, snackbarHost2, containerColor3, contentColor3, function33, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Composer $composer2;
        Object value$iv;
        Object value$iv2;
        $composer.startReplaceableGroup(-1474606134);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetScaffoldState)189@9008L34,190@9087L32,192@9161L196:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 1) != 0) {
            $composer2 = $composer;
            bottomSheetState = rememberStandardBottomSheetState(null, null, false, $composer2, 0, 7);
        } else {
            $composer2 = $composer;
        }
        if ((i & 2) != 0) {
            $composer2.startReplaceableGroup(667326536);
            ComposerKt.sourceInformation($composer2, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Composer $this$cache$iv = $composer2;
            Object it$iv = $this$cache$iv.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new SnackbarHostState();
                $this$cache$iv.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv;
            }
            snackbarHostState = (SnackbarHostState) value$iv2;
            $composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1474606134, $changed, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:191)");
        }
        $composer2.startReplaceableGroup(667326610);
        ComposerKt.sourceInformation($composer2, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer2.changed(bottomSheetState)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer2.changed(snackbarHostState)) || ($changed & 48) == 32);
        Composer $this$cache$iv2 = $composer2;
        Object it$iv2 = $this$cache$iv2.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv = new BottomSheetScaffoldState(bottomSheetState, snackbarHostState);
            $this$cache$iv2.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv2;
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) value$iv;
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer2.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    public static final SheetState rememberStandardBottomSheetState(SheetValue initialValue, Function1<? super SheetValue, Boolean> function1, boolean skipHiddenState, Composer $composer, int $changed, int i) {
        SheetValue initialValue2;
        Function1 confirmValueChange;
        $composer.startReplaceableGroup(678511581);
        ComposerKt.sourceInformation($composer, "C(rememberStandardBottomSheetState)P(1)214@9987L76:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 1) != 0) {
            SheetValue initialValue3 = SheetValue.PartiallyExpanded;
            initialValue2 = initialValue3;
        } else {
            initialValue2 = initialValue;
        }
        if ((i & 2) != 0) {
            Function1 confirmValueChange2 = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt.rememberStandardBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SheetValue it) {
                    return true;
                }
            };
            confirmValueChange = confirmValueChange2;
        } else {
            confirmValueChange = function1;
        }
        boolean skipHiddenState2 = (i & 4) != 0 ? true : skipHiddenState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678511581, $changed, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:214)");
        }
        SheetState sheetStateRememberSheetState = SheetDefaultsKt.rememberSheetState(false, confirmValueChange, initialValue2, skipHiddenState2, $composer, ($changed & 112) | 6 | (($changed << 6) & 896) | (($changed << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return sheetStateRememberSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: StandardBottomSheet-XcniZvE, reason: not valid java name */
    public static final void m1795StandardBottomSheetXcniZvE(final SheetState state, Function1<? super IntSize, ? extends DraggableAnchors<SheetValue>> function1, final float peekHeight, final float sheetMaxWidth, final boolean sheetSwipeEnabled, final Shape shape, final long containerColor, final long contentColor, final float tonalElevation, final float shadowElevation, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1) {
        Shape shape2;
        int i;
        long j;
        float f;
        float f2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Object value$iv$iv$iv;
        Object value$iv;
        Orientation orientation;
        final Function1<? super IntSize, ? extends DraggableAnchors<SheetValue>> function12;
        Object value$iv2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(424459667);
        ComposerKt.sourceInformation($composer3, "C(StandardBottomSheet)P(10!1,5:c#ui.unit.Dp,8:c#ui.unit.Dp,9,7,1:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.unit.Dp,6:c#ui.unit.Dp,4)232@10554L24,242@10826L326,255@11381L491,236@10628L3850:BottomSheetScaffold.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(peekHeight) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(sheetMaxWidth) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(sheetSwipeEnabled) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            shape2 = shape;
            $dirty |= $composer3.changed(shape2) ? 131072 : 65536;
        } else {
            shape2 = shape;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changed(containerColor) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            i = 12582912;
            j = contentColor;
            $dirty |= $composer3.changed(j) ? 8388608 : 4194304;
        } else {
            i = 12582912;
            j = contentColor;
        }
        if (($changed & 100663296) == 0) {
            f = tonalElevation;
            $dirty |= $composer3.changed(f) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            f = tonalElevation;
        }
        if (($changed & 805306368) == 0) {
            f2 = shadowElevation;
            $dirty |= $composer3.changed(f2) ? 536870912 : 268435456;
        } else {
            f2 = shadowElevation;
        }
        if (($changed1 & 6) == 0) {
            function22 = function2;
            $dirty1 |= $composer3.changedInstance(function22) ? 4 : 2;
        } else {
            function22 = function2;
        }
        if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changedInstance(function3) ? 32 : 16;
        }
        if (($dirty & 306783379) != 306783378 || ($dirty1 & 19) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(424459667, $dirty, $dirty1, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:231)");
            }
            boolean z = false;
            $composer3.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation($composer3, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            int $dirty2 = $dirty;
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                $composer3.updateRememberedValue(value$iv$iv$iv);
            } else {
                value$iv$iv$iv = it$iv$iv$iv;
            }
            $composer3.endReplaceableGroup();
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
            final CoroutineScope scope = wrapper$iv.getCoroutineScope();
            $composer3.endReplaceableGroup();
            Orientation orientation2 = Orientation.Vertical;
            Modifier modifierM807requiredHeightInVpY3zN4$default = SizeKt.m807requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.m823widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, sheetMaxWidth, 1, null), 0.0f, 1, null), peekHeight, 0.0f, 2, null);
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material3_release = state.getAnchoredDraggableState$material3_release();
            $composer3.startReplaceableGroup(1603483798);
            ComposerKt.sourceInformation($composer3, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(anchoredDraggableState$material3_release);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(state, orientation2, new Function1<Float, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f3) {
                        invoke(f3.floatValue());
                        return Unit.INSTANCE;
                    }

                    /* compiled from: BottomSheetScaffold.kt */
                    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m179c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1$1", m180f = "BottomSheetScaffold.kt", m181i = {}, m182l = {247}, m183m = "invokeSuspend", m184n = {}, m185s = {})
                    /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1$1 */
                    static final class C12371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ float $it;
                        final /* synthetic */ SheetState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C12371(SheetState sheetState, float f, Continuation<? super C12371> continuation) {
                            super(2, continuation);
                            this.$state = sheetState;
                            this.$it = f;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C12371(this.$state, this.$it, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C12371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (this.$state.settle$material3_release(this.$it, this) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    public final void invoke(float it) {
                        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C12371(state, it, null), 3, null);
                    }
                });
                orientation = orientation2;
                $composer3.updateRememberedValue(value$iv);
            } else {
                orientation = orientation2;
                value$iv = it$iv;
            }
            $composer3.endReplaceableGroup();
            Modifier modifierAnchoredDraggable = AnchoredDraggableKt.anchoredDraggable(NestedScrollModifierKt.nestedScroll$default(modifierM807requiredHeightInVpY3zN4$default, (NestedScrollConnection) value$iv, null, 2, null), state.getAnchoredDraggableState$material3_release(), orientation, (16 & 4) != 0 ? true : sheetSwipeEnabled, (16 & 8) != 0 ? false : false, (16 & 16) != 0 ? null : null);
            $composer3.startReplaceableGroup(1603484353);
            ComposerKt.sourceInformation($composer3, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean z2 = ($dirty2 & 112) == 32;
            if (($dirty2 & 14) == 4) {
                z = true;
            }
            boolean invalid$iv2 = z2 | z;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                function12 = function1;
                value$iv2 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1

                    /* compiled from: BottomSheetScaffold.kt */
                    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[SheetValue.values().length];
                            try {
                                iArr[SheetValue.Hidden.ordinal()] = 1;
                            } catch (NoSuchFieldError e) {
                            }
                            try {
                                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                            } catch (NoSuchFieldError e2) {
                            }
                            try {
                                iArr[SheetValue.Expanded.ordinal()] = 3;
                            } catch (NoSuchFieldError e3) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                        m1800invokeozmzZPI(intSize.getPackedValue());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m1800invokeozmzZPI(long layoutSize) {
                        SheetValue newTarget;
                        DraggableAnchors newAnchors = function12.invoke(IntSize.m6459boximpl(layoutSize));
                        switch (WhenMappings.$EnumSwitchMapping$0[state.getAnchoredDraggableState$material3_release().getTargetValue().ordinal()]) {
                            case 1:
                            case 2:
                                newTarget = SheetValue.PartiallyExpanded;
                                break;
                            case 3:
                                if (!newAnchors.hasAnchorFor(SheetValue.Expanded)) {
                                    newTarget = SheetValue.PartiallyExpanded;
                                    break;
                                } else {
                                    newTarget = SheetValue.Expanded;
                                    break;
                                }
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        state.getAnchoredDraggableState$material3_release().updateAnchors(newAnchors, newTarget);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
                function12 = function1;
            }
            $composer3.endReplaceableGroup();
            final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
            $composer2 = $composer3;
            SurfaceKt.m2519SurfaceT9BRK9s(OnRemeasuredModifierKt.onSizeChanged(modifierAnchoredDraggable, (Function1) value$iv2), shape2, containerColor, j, f, f2, null, ComposableLambdaKt.composableLambda($composer3, 1070542936, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3
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

                /* JADX WARN: Removed duplicated region for block: B:38:0x0288  */
                /* JADX WARN: Removed duplicated region for block: B:41:0x0294  */
                /* JADX WARN: Removed duplicated region for block: B:42:0x029a  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r52, int r53) {
                    /*
                        Method dump skipped, instructions count: 922
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, (($dirty2 >> 12) & 112) | i | (($dirty2 >> 12) & 896) | (($dirty2 >> 12) & 7168) | (($dirty2 >> 12) & 57344) | (458752 & ($dirty2 >> 12)), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            function12 = function1;
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1<? super IntSize, ? extends DraggableAnchors<SheetValue>> function13 = function12;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$4
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

                public final void invoke(Composer composer, int i2) {
                    BottomSheetScaffoldKt.m1795StandardBottomSheetXcniZvE(state, function13, peekHeight, sheetMaxWidth, sheetSwipeEnabled, shape, containerColor, contentColor, tonalElevation, shadowElevation, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-PxNyym8, reason: not valid java name */
    public static final void m1794BottomSheetScaffoldLayoutPxNyym8(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32, final Function2<? super Composer, ? super Integer, Unit> function22, final float sheetPeekHeight, final Function0<Float> function0, final SheetState sheetState, final long containerColor, final long contentColor, Composer $composer, final int $changed) {
        final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33;
        Function2<? super Composer, ? super Integer, Unit> function23;
        float f;
        Function0<Float> function02;
        long j;
        Object value$iv;
        int i;
        Composer $composer2 = $composer.startRestartGroup(-1120561936);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffoldLayout)P(4,9!2,8,6:c#ui.unit.Dp,5,7,2:c#ui.graphics.Color,3:c#ui.graphics.Color)334@15050L7,335@15073L44,335@15062L55,338@15139L1965,338@15122L1982:BottomSheetScaffold.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            function33 = function3;
            $dirty |= $composer2.changedInstance(function33) ? 256 : 128;
        } else {
            function33 = function3;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function32) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            function23 = function22;
            $dirty |= $composer2.changedInstance(function23) ? 16384 : 8192;
        } else {
            function23 = function22;
        }
        if ((196608 & $changed) == 0) {
            f = sheetPeekHeight;
            $dirty |= $composer2.changed(f) ? 131072 : 65536;
        } else {
            f = sheetPeekHeight;
        }
        if (($changed & 1572864) == 0) {
            function02 = function0;
            $dirty |= $composer2.changedInstance(function02) ? 1048576 : 524288;
        } else {
            function02 = function0;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(sheetState) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(containerColor) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            j = contentColor;
            $dirty |= $composer2.changed(j) ? 536870912 : 268435456;
        } else {
            j = contentColor;
        }
        if (($dirty & 306783379) != 306783378 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1120561936, $dirty, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:332)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Density density = (Density) objConsume;
            $composer2.startReplaceableGroup(-99158096);
            ComposerKt.sourceInformation($composer2, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean invalid$iv = (($dirty & 29360128) == 8388608) | $composer2.changed(density);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        sheetState.setDensity$material3_release(density);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) value$iv, $composer2, 0);
            $composer2.startReplaceableGroup(-99158030);
            ComposerKt.sourceInformation($composer2, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean invalid$iv2 = (($dirty & 7168) == 2048) | (($dirty & 112) == 32) | (($dirty & 14) == 4) | ((234881024 & $dirty) == 67108864) | ((1879048192 & $dirty) == 536870912) | (($dirty & 896) == 256) | ((458752 & $dirty) == 131072) | ((57344 & $dirty) == 16384) | ((3670016 & $dirty) == 1048576) | (($dirty & 29360128) == 8388608);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv2 == Composer.INSTANCE.getEmpty()) {
                final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                final Function0<Float> function03 = function02;
                final float f2 = f;
                i = 1;
                final long j2 = j;
                value$iv2 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1799invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1799invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
                        Placeable placeableMo5219measureBRTryo0;
                        final int layoutWidth = Constraints.m6253getMaxWidthimpl(constraints);
                        final int layoutHeight = Constraints.m6252getMaxHeightimpl(constraints);
                        long looseConstraints = Constraints.m6243copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(constraints) : 0);
                        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot = BottomSheetScaffoldLayoutSlot.Sheet;
                        final Function3<Integer, Composer, Integer, Unit> function34 = function32;
                        final Placeable sheetPlaceable = $this$SubcomposeLayout.subcompose(bottomSheetScaffoldLayoutSlot, ComposableLambdaKt.composableLambdaInstance(-1192048628, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$sheetPlaceable$1
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

                            public final void invoke(Composer $composer3, int $changed2) {
                                ComposerKt.sourceInformation($composer3, "C344@15421L25:BottomSheetScaffold.kt#uh7d8r");
                                if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                                    $composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1192048628, $changed2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:344)");
                                }
                                function34.invoke(Integer.valueOf(layoutHeight), $composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        })).get(0).mo5219measureBRTryo0(looseConstraints);
                        if (function2 != null) {
                            final Function2<Composer, Integer, Unit> function25 = function2;
                            placeableMo5219measureBRTryo0 = $this$SubcomposeLayout.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, ComposableLambdaKt.composableLambdaInstance(-873203005, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$topBarPlaceable$1$1
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

                                public final void invoke(Composer $composer3, int $changed2) {
                                    ComposerKt.sourceInformation($composer3, "C348@15594L8:BottomSheetScaffold.kt#uh7d8r");
                                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                                        $composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-873203005, $changed2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:348)");
                                    }
                                    function25.invoke($composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            })).get(0).mo5219measureBRTryo0(looseConstraints);
                        } else {
                            placeableMo5219measureBRTryo0 = null;
                        }
                        final Placeable topBarPlaceable = placeableMo5219measureBRTryo0;
                        final int topBarHeight = topBarPlaceable != null ? topBarPlaceable.getHeight() : 0;
                        long bodyConstraints = Constraints.m6243copyZbe2FdA(looseConstraints, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(looseConstraints) : 0, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(looseConstraints) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(looseConstraints) : 0, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(looseConstraints) : layoutHeight - topBarHeight);
                        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot2 = BottomSheetScaffoldLayoutSlot.Body;
                        final Modifier modifier2 = modifier;
                        final long j3 = containerColor;
                        final long j4 = j2;
                        final Function3<PaddingValues, Composer, Integer, Unit> function35 = function33;
                        final float f3 = f2;
                        final Placeable bodyPlaceable = $this$SubcomposeLayout.subcompose(bottomSheetScaffoldLayoutSlot2, ComposableLambdaKt.composableLambdaInstance(-1459220575, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$bodyPlaceable$1
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

                            public final void invoke(Composer $composer3, int $changed2) {
                                ComposerKt.sourceInformation($composer3, "C355@15900L194:BottomSheetScaffold.kt#uh7d8r");
                                if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1459220575, $changed2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:355)");
                                    }
                                    Modifier modifier3 = modifier2;
                                    long j5 = j3;
                                    long j6 = j4;
                                    final Function3<PaddingValues, Composer, Integer, Unit> function36 = function35;
                                    final float f4 = f3;
                                    SurfaceKt.m2519SurfaceT9BRK9s(modifier3, null, j5, j6, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda($composer3, 1725620860, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$bodyPlaceable$1.1
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

                                        public final void invoke(Composer $composer4, int $changed3) {
                                            ComposerKt.sourceInformation($composer4, "C359@16047L45:BottomSheetScaffold.kt#uh7d8r");
                                            if (($changed3 & 3) == 2 && $composer4.getSkipping()) {
                                                $composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1725620860, $changed3, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:359)");
                                            }
                                            function36.invoke(PaddingKt.m764PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f4, 7, null), $composer4, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), $composer3, 12582912, 114);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        })).get(0).mo5219measureBRTryo0(bodyConstraints);
                        final Placeable snackbarPlaceable = $this$SubcomposeLayout.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, function24).get(0).mo5219measureBRTryo0(looseConstraints);
                        final Function0<Float> function04 = function03;
                        final SheetState sheetState2 = sheetState;
                        return MeasureScope.layout$default($this$SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1.1

                            /* compiled from: BottomSheetScaffold.kt */
                            @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                            /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$1$WhenMappings */
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[SheetValue.values().length];
                                    try {
                                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 1;
                                    } catch (NoSuchFieldError e) {
                                    }
                                    try {
                                        iArr[SheetValue.Expanded.ordinal()] = 2;
                                    } catch (NoSuchFieldError e2) {
                                    }
                                    try {
                                        iArr[SheetValue.Hidden.ordinal()] = 3;
                                    } catch (NoSuchFieldError e3) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout) {
                                int snackbarOffsetY;
                                int sheetOffsetY = MathKt.roundToInt(function04.invoke().floatValue());
                                int sheetOffsetX = Integer.max(0, (layoutWidth - sheetPlaceable.getWidth()) / 2);
                                int snackbarOffsetX = (layoutWidth - snackbarPlaceable.getWidth()) / 2;
                                switch (WhenMappings.$EnumSwitchMapping$0[sheetState2.getCurrentValue().ordinal()]) {
                                    case 1:
                                        snackbarOffsetY = sheetOffsetY - snackbarPlaceable.getHeight();
                                        break;
                                    case 2:
                                    case 3:
                                        snackbarOffsetY = layoutHeight - snackbarPlaceable.getHeight();
                                        break;
                                    default:
                                        throw new NoWhenBranchMatchedException();
                                }
                                Placeable.PlacementScope.placeRelative$default($this$layout, bodyPlaceable, 0, topBarHeight, 0.0f, 4, null);
                                Placeable placeable = topBarPlaceable;
                                if (placeable != null) {
                                    Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, 0, 0.0f, 4, null);
                                }
                                Placeable.PlacementScope.placeRelative$default($this$layout, sheetPlaceable, sheetOffsetX, sheetOffsetY, 0.0f, 4, null);
                                Placeable.PlacementScope.placeRelative$default($this$layout, snackbarPlaceable, snackbarOffsetX, snackbarOffsetY, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                i = 1;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) value$iv2, $composer2, 0, i);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$3
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

                public final void invoke(Composer composer, int i2) {
                    BottomSheetScaffoldKt.m1794BottomSheetScaffoldLayoutPxNyym8(modifier, function2, function3, function32, function22, sheetPeekHeight, function0, sheetState, containerColor, contentColor, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
