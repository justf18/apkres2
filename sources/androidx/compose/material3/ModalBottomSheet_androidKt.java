package androidx.compose.material3;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.Strings;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.layout.OnRemeasuredModifierKt;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.p000ui.window.SecureFlagPolicy;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.UUID;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: ModalBottomSheet.android.kt */
@Metadata(m164d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¹\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\r2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a>\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012H\u0001¢\u0006\u0002\u0010\u001e\u001a0\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\r2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010!\u001a\u00020\"H\u0003ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a-\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\"2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\"0\u0018H\u0007¢\u0006\u0002\u0010)\u001a\f\u0010*\u001a\u00020\"*\u00020+H\u0002\u001a\u001c\u0010,\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.H\u0003\u001a\u0014\u0010/\u001a\u00020\"*\u0002002\u0006\u00101\u001a\u00020\"H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00062²\u0006\n\u00103\u001a\u00020.X\u008a\u0084\u0002²\u0006\u0015\u00104\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012X\u008a\u0084\u0002"}, m165d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetPopup", "(Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Scrim", TypedValues.Custom.S_COLOR, "visible", "", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "isFlagSecureEnabled", "Landroid/view/View;", "modalBottomSheetAnchors", "fullHeight", "", "shouldApplySecureFlag", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "material3_release", "alpha", "currentContent"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ModalBottomSheet_androidKt {

    /* compiled from: ModalBottomSheet.android.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SecureFlagPolicy.values().length];
            try {
                iArr[SecureFlagPolicy.SecureOff.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SecureFlagPolicy.SecureOn.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SecureFlagPolicy.Inherit.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: ModalBottomSheet-dYc4hso, reason: not valid java name */
    public static final void m2214ModalBottomSheetdYc4hso(final Function0<Unit> function0, Modifier modifier, SheetState sheetState, float sheetMaxWidth, Shape shape, long containerColor, long contentColor, float tonalElevation, long scrimColor, Function2<? super Composer, ? super Integer, Unit> function2, WindowInsets windowInsets, ModalBottomSheetProperties properties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        final SheetState sheetState2;
        Shape shape2;
        long contentColor2;
        float tonalElevation2;
        int $dirty;
        int $dirty1;
        int i2;
        int $dirty12;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        long containerColor2;
        long scrimColor2;
        float sheetMaxWidth2;
        WindowInsets windowInsets2;
        final float sheetMaxWidth3;
        ModalBottomSheetProperties properties2;
        final long containerColor3;
        final long contentColor3;
        final Function2 dragHandle;
        final Shape shape3;
        final Modifier modifier3;
        final float tonalElevation3;
        final long scrimColor3;
        int $dirty13;
        int $dirty14;
        WindowInsets windowInsets3;
        Object value$iv;
        Object value$iv$iv$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Composer $composer2;
        final ModalBottomSheetProperties properties3;
        final SheetState sheetState3;
        final long scrimColor4;
        final Modifier modifier4;
        final float sheetMaxWidth4;
        final long containerColor4;
        final long contentColor4;
        final float tonalElevation4;
        final Function2 dragHandle2;
        final WindowInsets windowInsets4;
        final Shape shape4;
        ModalBottomSheet_androidKt$ModalBottomSheet$4$1 value$iv5;
        int $dirty2;
        Composer $composer3 = $composer.startRestartGroup(944867294);
        ComposerKt.sourceInformation($composer3, "C(ModalBottomSheet)P(5,4,10,9:c#ui.unit.Dp,8,0:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.unit.Dp,7:c#ui.graphics.Color,3,12,6)139@6724L31,141@6855L13,142@6918L14,143@6960L31,145@7093L10,147@7240L12,152@7505L7,153@7528L44,153@7517L55,156@7589L24,157@7653L277,166@7984L143,174@8216L350,172@8133L5284,280@13492L41,280@13465L68:ModalBottomSheet.android.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                sheetState2 = sheetState;
                int i4 = $composer3.changed(sheetState2) ? 256 : 128;
                $dirty3 |= i4;
            } else {
                sheetState2 = sheetState;
            }
            $dirty3 |= i4;
        } else {
            sheetState2 = sheetState;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer3.changed(sheetMaxWidth) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                shape2 = shape;
                int i6 = $composer3.changed(shape2) ? 16384 : 8192;
                $dirty3 |= i6;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i6;
        } else {
            shape2 = shape;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            $dirty3 |= ((i & 32) == 0 && $composer3.changed(containerColor)) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                contentColor2 = contentColor;
                int i7 = $composer3.changed(contentColor2) ? 1048576 : 524288;
                $dirty3 |= i7;
            } else {
                contentColor2 = contentColor;
            }
            $dirty3 |= i7;
        } else {
            contentColor2 = contentColor;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 12582912;
            tonalElevation2 = tonalElevation;
        } else if (($changed & 12582912) == 0) {
            tonalElevation2 = tonalElevation;
            $dirty3 |= $composer3.changed(tonalElevation2) ? 8388608 : 4194304;
        } else {
            tonalElevation2 = tonalElevation;
        }
        if (($changed & 100663296) == 0) {
            if ((i & 256) == 0) {
                $dirty2 = $dirty3;
                $dirty1 = $changed1;
                int i9 = $composer3.changed(scrimColor) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty = $dirty2 | i9;
            } else {
                $dirty2 = $dirty3;
                $dirty1 = $changed1;
            }
            $dirty = $dirty2 | i9;
        } else {
            $dirty = $dirty3;
            $dirty1 = $changed1;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
            i2 = i10;
        } else if (($changed & 805306368) == 0) {
            i2 = i10;
            $dirty |= $composer3.changedInstance(function2) ? 536870912 : 268435456;
        } else {
            i2 = i10;
        }
        int $dirty4 = $dirty;
        if (($changed1 & 6) == 0) {
            int $dirty15 = $dirty1;
            int $dirty16 = i & 1024;
            $dirty12 = $dirty15 | (($dirty16 == 0 && $composer3.changed(windowInsets)) ? 4 : 2);
        } else {
            $dirty12 = $dirty1;
        }
        if (($changed1 & 48) == 0) {
            $dirty12 |= ((i & 2048) == 0 && $composer3.changed(properties)) ? 32 : 16;
        }
        int $dirty17 = $dirty12;
        if ((i & 4096) != 0) {
            $dirty17 |= 384;
            function32 = function3;
        } else if (($changed1 & 384) == 0) {
            function32 = function3;
            $dirty17 |= $composer3.changedInstance(function32) ? 256 : 128;
        } else {
            function32 = function3;
        }
        if ((306783379 & $dirty4) == 306783378 && ($dirty17 & 147) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            containerColor4 = containerColor;
            $composer2 = $composer3;
            contentColor4 = contentColor2;
            shape4 = shape2;
            modifier4 = modifier2;
            sheetState3 = sheetState2;
            tonalElevation4 = tonalElevation2;
            sheetMaxWidth4 = sheetMaxWidth;
            scrimColor4 = scrimColor;
            dragHandle2 = function2;
            windowInsets4 = windowInsets;
            properties3 = properties;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty4 &= -897;
                    sheetState2 = rememberModalBottomSheetState(false, null, $composer3, 0, 3);
                }
                float sheetMaxWidth5 = i5 != 0 ? BottomSheetDefaults.INSTANCE.m1791getSheetMaxWidthD9Ej5fM() : sheetMaxWidth;
                if ((i & 16) != 0) {
                    $dirty4 &= -57345;
                    shape2 = BottomSheetDefaults.INSTANCE.getExpandedShape($composer3, 6);
                }
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                    containerColor2 = BottomSheetDefaults.INSTANCE.getContainerColor($composer3, 6);
                } else {
                    containerColor2 = containerColor;
                }
                if ((i & 64) != 0) {
                    contentColor2 = ColorSchemeKt.m1935contentColorForek8zF_U(containerColor2, $composer3, ($dirty4 >> 15) & 14);
                    $dirty4 &= -3670017;
                }
                if (i8 != 0) {
                    tonalElevation2 = BottomSheetDefaults.INSTANCE.m1790getElevationD9Ej5fM();
                }
                if ((i & 256) != 0) {
                    scrimColor2 = BottomSheetDefaults.INSTANCE.getScrimColor($composer3, 6);
                    $dirty4 &= -234881025;
                } else {
                    scrimColor2 = scrimColor;
                }
                Function2 dragHandle3 = i2 != 0 ? ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1968getLambda1$material3_release() : function2;
                int $dirty5 = $dirty4;
                if ((i & 1024) != 0) {
                    sheetMaxWidth2 = sheetMaxWidth5;
                    windowInsets2 = BottomSheetDefaults.INSTANCE.getWindowInsets($composer3, 6);
                    $dirty17 &= -15;
                } else {
                    sheetMaxWidth2 = sheetMaxWidth5;
                    windowInsets2 = windowInsets;
                }
                if ((i & 2048) != 0) {
                    properties2 = ModalBottomSheetDefaults.properties$default(ModalBottomSheetDefaults.INSTANCE, null, false, false, 7, null);
                    sheetMaxWidth3 = sheetMaxWidth2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    dragHandle = dragHandle3;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    tonalElevation3 = tonalElevation2;
                    scrimColor3 = scrimColor2;
                    $dirty13 = $dirty17 & (-113);
                    $dirty14 = $dirty5;
                } else {
                    sheetMaxWidth3 = sheetMaxWidth2;
                    properties2 = properties;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    dragHandle = dragHandle3;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    tonalElevation3 = tonalElevation2;
                    scrimColor3 = scrimColor2;
                    $dirty13 = $dirty17;
                    $dirty14 = $dirty5;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty4 &= -897;
                }
                if ((i & 16) != 0) {
                    $dirty4 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty4 &= -3670017;
                }
                if ((i & 256) != 0) {
                    $dirty4 &= -234881025;
                }
                if ((i & 1024) != 0) {
                    $dirty17 &= -15;
                }
                if ((i & 2048) != 0) {
                    int i11 = $dirty17 & (-113);
                    sheetMaxWidth3 = sheetMaxWidth;
                    containerColor3 = containerColor;
                    scrimColor3 = scrimColor;
                    dragHandle = function2;
                    $dirty14 = $dirty4;
                    $dirty13 = i11;
                    contentColor3 = contentColor2;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    tonalElevation3 = tonalElevation2;
                    windowInsets2 = windowInsets;
                    properties2 = properties;
                } else {
                    sheetMaxWidth3 = sheetMaxWidth;
                    containerColor3 = containerColor;
                    scrimColor3 = scrimColor;
                    dragHandle = function2;
                    properties2 = properties;
                    $dirty13 = $dirty17;
                    contentColor3 = contentColor2;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    tonalElevation3 = tonalElevation2;
                    $dirty14 = $dirty4;
                    windowInsets2 = windowInsets;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(944867294, $dirty14, $dirty13, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:150)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) objConsume;
            $composer3.startReplaceableGroup(-203430466);
            ComposerKt.sourceInformation($composer3, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean invalid$iv = (((($dirty14 & 896) ^ 384) > 256 && $composer3.changed(sheetState2)) || ($dirty14 & 384) == 256) | $composer3.changed(density);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                windowInsets3 = windowInsets2;
                value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$1$1
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
                        sheetState2.setDensity$material3_release(density);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                windowInsets3 = windowInsets2;
                value$iv = it$iv;
            }
            $composer3.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) value$iv, $composer3, 0);
            $composer3.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation($composer3, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv$iv = $composer3.rememberedValue();
            ModalBottomSheetProperties properties4 = properties2;
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
            $composer3.startReplaceableGroup(-203430341);
            ComposerKt.sourceInformation($composer3, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean invalid$iv2 = (((($dirty14 & 896) ^ 384) > 256 && $composer3.changed(sheetState2)) || ($dirty14 & 384) == 256) | $composer3.changedInstance(scope) | (($dirty14 & 14) == 4);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* compiled from: ModalBottomSheet.android.kt */
                    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m179c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1", m180f = "ModalBottomSheet.android.kt", m181i = {}, m182l = {160}, m183m = "invokeSuspend", m184n = {}, m185s = {})
                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1$1 */
                    static final class C14071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ SheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C14071(SheetState sheetState, Continuation<? super C14071> continuation) {
                            super(2, continuation);
                            this.$sheetState = sheetState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C14071(this.$sheetState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C14071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (this.$sheetState.hide(this) != coroutine_suspended) {
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

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (sheetState2.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Hidden).booleanValue()) {
                            Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C14071(sheetState2, null), 3, null);
                            final SheetState sheetState4 = sheetState2;
                            final Function0<Unit> function02 = function0;
                            jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                    invoke2(th);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    if (!sheetState4.isVisible()) {
                                        function02.invoke();
                                    }
                                }
                            });
                        }
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final Function0 animateToDismiss = (Function0) value$iv2;
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(-203430010);
            ComposerKt.sourceInformation($composer3, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean invalid$iv3 = $composer3.changedInstance(scope) | (((($dirty14 & 896) ^ 384) > 256 && $composer3.changed(sheetState2)) || ($dirty14 & 384) == 256) | (($dirty14 & 14) == 4);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* compiled from: ModalBottomSheet.android.kt */
                    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m179c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1", m180f = "ModalBottomSheet.android.kt", m181i = {}, m182l = {168}, m183m = "invokeSuspend", m184n = {}, m185s = {})
                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1$1 */
                    static final class C14091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ float $it;
                        final /* synthetic */ SheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C14091(SheetState sheetState, float f, Continuation<? super C14091> continuation) {
                            super(2, continuation);
                            this.$sheetState = sheetState;
                            this.$it = f;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C14091(this.$sheetState, this.$it, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C14091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (this.$sheetState.settle$material3_release(this.$it, this) != coroutine_suspended) {
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

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                        invoke(f.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float it) {
                        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C14091(sheetState2, it, null), 3, null);
                        final SheetState sheetState4 = sheetState2;
                        final Function0<Unit> function02 = function0;
                        jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it2) {
                                if (!sheetState4.isVisible()) {
                                    function02.invoke();
                                }
                            }
                        });
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final Function1 settleToDismiss = (Function1) value$iv3;
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(-203429778);
            ComposerKt.sourceInformation($composer3, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean invalid$iv4 = (((($dirty14 & 896) ^ 384) > 256 && $composer3.changed(sheetState2)) || ($dirty14 & 384) == 256) | $composer3.changedInstance(scope) | (($dirty14 & 14) == 4);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* compiled from: ModalBottomSheet.android.kt */
                    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m179c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1", m180f = "ModalBottomSheet.android.kt", m181i = {}, m182l = {177}, m183m = "invokeSuspend", m184n = {}, m185s = {})
                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1 */
                    static final class C14011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ SheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C14011(SheetState sheetState, Continuation<? super C14011> continuation) {
                            super(2, continuation);
                            this.$sheetState = sheetState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C14011(this.$sheetState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C14011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (this.$sheetState.partialExpand(this) != coroutine_suspended) {
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

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (sheetState2.getCurrentValue() != SheetValue.Expanded || !sheetState2.getHasPartiallyExpandedState()) {
                            Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C14022(sheetState2, null), 3, null);
                            final Function0<Unit> function02 = function0;
                            jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                    invoke2(th);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    function02.invoke();
                                }
                            });
                            return;
                        }
                        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C14011(sheetState2, null), 3, null);
                    }

                    /* compiled from: ModalBottomSheet.android.kt */
                    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m179c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2", m180f = "ModalBottomSheet.android.kt", m181i = {}, m182l = {179}, m183m = "invokeSuspend", m184n = {}, m185s = {})
                    /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2 */
                    static final class C14022 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ SheetState $sheetState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C14022(SheetState sheetState, Continuation<? super C14022> continuation) {
                            super(2, continuation);
                            this.$sheetState = sheetState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C14022(this.$sheetState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C14022) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object $result) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    this.label = 1;
                                    if (this.$sheetState.hide(this) != coroutine_suspended) {
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
                };
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            $composer3.endReplaceableGroup();
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33 = function32;
            final SheetState sheetState4 = sheetState2;
            ModalBottomSheetPopup(properties4, (Function0) value$iv4, windowInsets3, ComposableLambdaKt.composableLambda($composer3, -1311525899, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3
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
                    ComposerKt.sourceInformation($composer4, "C183@8621L4790:ModalBottomSheet.android.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1311525899, $changed2, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.android.kt:183)");
                        }
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        final long j = scrimColor3;
                        final Function0<Unit> function02 = animateToDismiss;
                        final SheetState sheetState5 = sheetState4;
                        final Modifier modifier5 = modifier3;
                        final float f = sheetMaxWidth3;
                        final Function1<Float, Unit> function1 = settleToDismiss;
                        final Shape shape5 = shape3;
                        final long j2 = containerColor3;
                        final long j3 = contentColor3;
                        final float f2 = tonalElevation3;
                        final Function2<Composer, Integer, Unit> function22 = dragHandle;
                        final CoroutineScope coroutineScope = scope;
                        final Function3<ColumnScope, Composer, Integer, Unit> function34 = function33;
                        BoxWithConstraintsKt.BoxWithConstraints(modifierFillMaxSize$default, null, false, ComposableLambdaKt.composableLambda($composer4, 2008499679, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
                                invoke(boxWithConstraintsScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer5, int $changed3) {
                                Object value$iv6;
                                Object value$iv7;
                                Object value$iv8;
                                ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1 value$iv9;
                                ComposerKt.sourceInformation($composer5, "C185@8729L168,190@8937L48,196@9208L36,197@9273L244,206@9577L348,219@10319L23,191@8998L4403:ModalBottomSheet.android.kt#uh7d8r");
                                int $dirty6 = $changed3;
                                if (($changed3 & 6) == 0) {
                                    $dirty6 |= $composer5.changed($this$BoxWithConstraints) ? 4 : 2;
                                }
                                int $dirty7 = $dirty6;
                                if (($dirty7 & 19) != 18 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2008499679, $dirty7, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:184)");
                                    }
                                    int fullHeight = Constraints.m6252getMaxHeightimpl($this$BoxWithConstraints.mo703getConstraintsmsEJaDk());
                                    ModalBottomSheet_androidKt.m2215Scrim3JVO9M(j, function02, sheetState5.getTargetValue() != SheetValue.Hidden, $composer5, 0);
                                    Strings.Companion companion = Strings.INSTANCE;
                                    final String bottomSheetPaneTitle = Strings_androidKt.m2509getStringNWtq28(Strings.m2440constructorimpl(C1453R.string.m3c_bottom_sheet_pane_title), $composer5, 0);
                                    Modifier modifierAlign = $this$BoxWithConstraints.align(SizeKt.fillMaxWidth$default(SizeKt.m823widthInVpY3zN4$default(modifier5, 0.0f, f, 1, null), 0.0f, 1, null), Alignment.INSTANCE.getTopCenter());
                                    $composer5.startReplaceableGroup(-1482644208);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                    boolean invalid$iv5 = $composer5.changed(bottomSheetPaneTitle);
                                    Object it$iv5 = $composer5.rememberedValue();
                                    if (invalid$iv5 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                        value$iv6 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                                SemanticsPropertiesKt.setPaneTitle($this$semantics, bottomSheetPaneTitle);
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv6);
                                    } else {
                                        value$iv6 = it$iv5;
                                    }
                                    $composer5.endReplaceableGroup();
                                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierAlign, false, (Function1) value$iv6, 1, null);
                                    $composer5.startReplaceableGroup(-1482644143);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                    boolean invalid$iv6 = $composer5.changed(sheetState5);
                                    final SheetState sheetState6 = sheetState5;
                                    Object it$iv6 = $composer5.rememberedValue();
                                    if (invalid$iv6 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                                        value$iv7 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$2$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density2) {
                                                return IntOffset.m6416boximpl(m2217invokeBjo55l4(density2));
                                            }

                                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                            public final long m2217invokeBjo55l4(Density $this$offset) {
                                                return IntOffsetKt.IntOffset(0, (int) sheetState6.requireOffset());
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv7);
                                    } else {
                                        value$iv7 = it$iv6;
                                    }
                                    $composer5.endReplaceableGroup();
                                    Modifier modifierOffset = OffsetKt.offset(modifierSemantics$default, (Function1) value$iv7);
                                    $composer5.startReplaceableGroup(-1482643839);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                    boolean invalid$iv7 = $composer5.changed(sheetState5);
                                    SheetState sheetState7 = sheetState5;
                                    Function1<Float, Unit> function12 = function1;
                                    Object it$iv7 = $composer5.rememberedValue();
                                    if (invalid$iv7 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                                        value$iv8 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState7, Orientation.Vertical, function12);
                                        $composer5.updateRememberedValue(value$iv8);
                                    } else {
                                        value$iv8 = it$iv7;
                                    }
                                    $composer5.endReplaceableGroup();
                                    Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifierOffset, (NestedScrollConnection) value$iv8, null, 2, null);
                                    DraggableState draggableState = sheetState5.getAnchoredDraggableState$material3_release().getDraggableState();
                                    Orientation orientation = Orientation.Vertical;
                                    boolean zIsVisible = sheetState5.isVisible();
                                    boolean zIsAnimationRunning = sheetState5.getAnchoredDraggableState$material3_release().isAnimationRunning();
                                    $composer5.startReplaceableGroup(-1482643097);
                                    ComposerKt.sourceInformation($composer5, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                                    boolean invalid$iv8 = $composer5.changed(function1);
                                    Function1<Float, Unit> function13 = function1;
                                    Object it$iv8 = $composer5.rememberedValue();
                                    if (invalid$iv8 || it$iv8 == Composer.INSTANCE.getEmpty()) {
                                        value$iv9 = new ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1(function13, null);
                                        $composer5.updateRememberedValue(value$iv9);
                                    } else {
                                        value$iv9 = it$iv8;
                                    }
                                    $composer5.endReplaceableGroup();
                                    Modifier modifierModalBottomSheetAnchors = ModalBottomSheet_androidKt.modalBottomSheetAnchors(DraggableKt.draggable(modifierNestedScroll$default, draggableState, orientation, (188 & 4) != 0 ? true : zIsVisible, (188 & 8) != 0 ? null : null, (188 & 16) != 0 ? false : zIsAnimationRunning, (188 & 32) != 0 ? new DraggableKt.C03841(null) : null, (188 & 64) != 0 ? new DraggableKt.C03852(null) : (Function3) value$iv9, (188 & 128) != 0 ? false : false), sheetState5, fullHeight);
                                    Shape shape6 = shape5;
                                    long j4 = j2;
                                    long j5 = j3;
                                    float f3 = f2;
                                    final Function2<Composer, Integer, Unit> function23 = function22;
                                    final SheetState sheetState8 = sheetState5;
                                    final Function0<Unit> function03 = function02;
                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                    final Function3<ColumnScope, Composer, Integer, Unit> function35 = function34;
                                    SurfaceKt.m2519SurfaceT9BRK9s(modifierModalBottomSheetAnchors, shape6, j4, j5, f3, 0.0f, null, ComposableLambdaKt.composableLambda($composer5, 1096570852, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheet.3.1.5
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

                                        /* JADX WARN: Removed duplicated region for block: B:38:0x028a  */
                                        /* JADX WARN: Removed duplicated region for block: B:41:0x0296  */
                                        /* JADX WARN: Removed duplicated region for block: B:42:0x029c  */
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                                        */
                                        public final void invoke(androidx.compose.runtime.Composer r52, int r53) {
                                            /*
                                                Method dump skipped, instructions count: 924
                                                To view this dump change 'Code comments level' option to 'DEBUG'
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3.C14041.AnonymousClass5.invoke(androidx.compose.runtime.Composer, int):void");
                                        }
                                    }), $composer5, 12582912, 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }), $composer4, 3078, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, (($dirty13 >> 3) & 14) | 3072 | (($dirty13 << 6) & 896));
            WindowInsets windowInsets5 = windowInsets3;
            $composer2 = $composer3;
            if (sheetState2.getHasExpandedState()) {
                $composer2.startReplaceableGroup(-203424502);
                ComposerKt.sourceInformation($composer2, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                boolean invalid$iv5 = ((($dirty14 & 896) ^ 384) > 256 && $composer2.changed(sheetState2)) || ($dirty14 & 384) == 256;
                Object it$iv5 = $composer2.rememberedValue();
                if (invalid$iv5 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                    value$iv5 = new ModalBottomSheet_androidKt$ModalBottomSheet$4$1(sheetState2, null);
                    $composer2.updateRememberedValue(value$iv5);
                } else {
                    value$iv5 = it$iv5;
                }
                $composer2.endReplaceableGroup();
                EffectsKt.LaunchedEffect(sheetState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv5, $composer2, ($dirty14 >> 6) & 14);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            properties3 = properties4;
            sheetState3 = sheetState2;
            scrimColor4 = scrimColor3;
            modifier4 = modifier3;
            sheetMaxWidth4 = sheetMaxWidth3;
            containerColor4 = containerColor3;
            contentColor4 = contentColor3;
            tonalElevation4 = tonalElevation3;
            dragHandle2 = dragHandle;
            windowInsets4 = windowInsets5;
            shape4 = shape3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$5
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
                    ModalBottomSheet_androidKt.m2214ModalBottomSheetdYc4hso(function0, modifier4, sheetState3, sheetMaxWidth4, shape4, containerColor4, contentColor4, tonalElevation4, scrimColor4, dragHandle2, windowInsets4, properties3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final SheetState rememberModalBottomSheetState(boolean skipPartiallyExpanded, Function1<? super SheetValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Function1 confirmValueChange;
        $composer.startReplaceableGroup(-1261794383);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(1)363@16906L69:ModalBottomSheet.android.kt#uh7d8r");
        boolean skipPartiallyExpanded2 = (i & 1) != 0 ? false : skipPartiallyExpanded;
        if ((i & 2) != 0) {
            Function1 confirmValueChange2 = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.rememberModalBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SheetValue it) {
                    return true;
                }
            };
            confirmValueChange = confirmValueChange2;
        } else {
            confirmValueChange = function1;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1261794383, $changed, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.android.kt:363)");
        }
        SheetState sheetStateRememberSheetState = SheetDefaultsKt.rememberSheetState(skipPartiallyExpanded2, confirmValueChange, SheetValue.Hidden, false, $composer, ($changed & 14) | 384 | ($changed & 112), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return sheetStateRememberSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m2215Scrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissSheet;
        Object value$iv;
        ModalBottomSheet_androidKt$Scrim$dismissSheet$1$1 value$iv2;
        Composer $composer2 = $composer.startRestartGroup(1053897700);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)372@17135L121,391@17696L62,387@17590L168:ModalBottomSheet.android.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(visible) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1053897700, $dirty, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.android.kt:370)");
            }
            if ((color != Color.INSTANCE.m3985getUnspecified0d7_KjU() ? 1 : 0) != 0) {
                int $dirty2 = $dirty;
                final State alpha$delegate = AnimateAsStateKt.animateFloatAsState(visible ? 1065353216 : 0, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer2, 48, 28);
                $composer2.startReplaceableGroup(-1858718943);
                ComposerKt.sourceInformation($composer2, "378@17368L124");
                if (visible) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    $composer2.startReplaceableGroup(-1858718859);
                    ComposerKt.sourceInformation($composer2, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                    boolean invalid$iv = ($dirty2 & 112) == 32;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new ModalBottomSheet_androidKt$Scrim$dismissSheet$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv;
                    }
                    $composer2.endReplaceableGroup();
                    dismissSheet = SemanticsModifierKt.clearAndSetSemantics(SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$dismissSheet$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                        }
                    });
                } else {
                    dismissSheet = Modifier.INSTANCE;
                }
                $composer2.endReplaceableGroup();
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissSheet);
                $composer2.startReplaceableGroup(-1858718531);
                ComposerKt.sourceInformation($composer2, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changed(alpha$delegate) | (($dirty2 & 14) == 4);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope $this$Canvas) {
                            DrawScope.m4493drawRectnJ9OG0$default($this$Canvas, color, 0L, 0L, ModalBottomSheet_androidKt.Scrim_3J_VO9M$lambda$5(alpha$delegate), null, null, 0, 118, null);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv2;
                }
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(modifierThen, (Function1) value$iv, $composer2, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ModalBottomSheet_androidKt.m2215Scrim3JVO9M(color, function0, visible, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$5(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier modalBottomSheetAnchors(Modifier $this$modalBottomSheetAnchors, final SheetState sheetState, final float fullHeight) {
        return OnRemeasuredModifierKt.onSizeChanged($this$modalBottomSheetAnchors, new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.modalBottomSheetAnchors.1

            /* compiled from: ModalBottomSheet.android.kt */
            @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$modalBottomSheetAnchors$1$WhenMappings */
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
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                m2219invokeozmzZPI(intSize.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
            public final void m2219invokeozmzZPI(final long sheetSize) {
                SheetValue newTarget;
                final float f = fullHeight;
                final SheetState sheetState2 = sheetState;
                DraggableAnchors newAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$modalBottomSheetAnchors$1$newAnchors$1
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
                        draggableAnchorsConfig.m17at(SheetValue.Hidden, f);
                        if (IntSize.m6466getHeightimpl(sheetSize) > f / 2 && !sheetState2.getSkipPartiallyExpanded()) {
                            draggableAnchorsConfig.m17at(SheetValue.PartiallyExpanded, f / 2.0f);
                        }
                        if (IntSize.m6466getHeightimpl(sheetSize) != 0) {
                            draggableAnchorsConfig.m17at(SheetValue.Expanded, Math.max(0.0f, f - IntSize.m6466getHeightimpl(sheetSize)));
                        }
                    }
                });
                switch (WhenMappings.$EnumSwitchMapping$0[sheetState.getAnchoredDraggableState$material3_release().getTargetValue().ordinal()]) {
                    case 1:
                        newTarget = SheetValue.Hidden;
                        break;
                    case 2:
                    case 3:
                        boolean hasPartiallyExpandedState = newAnchors.hasAnchorFor(SheetValue.PartiallyExpanded);
                        if (!hasPartiallyExpandedState) {
                            if (!newAnchors.hasAnchorFor(SheetValue.Expanded)) {
                                newTarget = SheetValue.Hidden;
                                break;
                            } else {
                                newTarget = SheetValue.Expanded;
                                break;
                            }
                        } else {
                            newTarget = SheetValue.PartiallyExpanded;
                            break;
                        }
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                sheetState.getAnchoredDraggableState$material3_release().updateAnchors(newAnchors, newTarget);
            }
        });
    }

    public static final void ModalBottomSheetPopup(final ModalBottomSheetProperties modalBottomSheetProperties, final Function0<Unit> function0, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        Object obj;
        Object obj2;
        Composer composerStartRestartGroup = composer.startRestartGroup(738805080);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalBottomSheetPopup)P(2,1,3)437@19070L7,438@19091L38,439@19158L28,440@19213L29,441@19290L7,442@19331L941,470@20319L248,470@20278L289:ModalBottomSheet.android.kt#uh7d8r");
        int i2 = i;
        if ((i & 6) == 0) {
            i2 |= composerStartRestartGroup.changed(modalBottomSheetProperties) ? 4 : 2;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(windowInsets) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(738805080, i3, -1, "androidx.compose.material3.ModalBottomSheetPopup (ModalBottomSheet.android.kt:436)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            View view = (View) objConsume;
            UUID uuid = (UUID) RememberSaveableKt.m3566rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<UUID>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$id$1
                @Override // kotlin.jvm.functions.Function0
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, composerStartRestartGroup, 3072, 6);
            CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i3 >> 9) & 14);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            composerStartRestartGroup.startReplaceableGroup(173201889);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                ModalBottomSheetWindow modalBottomSheetWindow = new ModalBottomSheetWindow(modalBottomSheetProperties, function0, view, uuid);
                modalBottomSheetWindow.setCustomContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-114385661, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$modalBottomSheetWindow$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:32:0x018d  */
                    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke(androidx.compose.runtime.Composer r27, int r28) {
                        /*
                            Method dump skipped, instructions count: 401
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.C1412x4d8b1701.invoke(androidx.compose.runtime.Composer, int):void");
                    }
                }));
                composerStartRestartGroup.updateRememberedValue(modalBottomSheetWindow);
                obj = modalBottomSheetWindow;
            } else {
                obj = objRememberedValue;
            }
            final ModalBottomSheetWindow modalBottomSheetWindow2 = (ModalBottomSheetWindow) obj;
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(173202877);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ModalBottomSheet.android.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(modalBottomSheetWindow2) | composerStartRestartGroup.changed(layoutDirection);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                obj2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                        modalBottomSheetWindow2.show();
                        modalBottomSheetWindow2.superSetLayoutDirection(layoutDirection);
                        final ModalBottomSheetWindow modalBottomSheetWindow3 = modalBottomSheetWindow2;
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                modalBottomSheetWindow3.disposeComposition();
                                modalBottomSheetWindow3.dismiss();
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj2);
            } else {
                obj2 = objRememberedValue2;
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(modalBottomSheetWindow2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) obj2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheetPopup.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ModalBottomSheet_androidKt.ModalBottomSheetPopup(modalBottomSheetProperties, function0, windowInsets, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ModalBottomSheetPopup$lambda$8(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function2) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isFlagSecureEnabled(View $this$isFlagSecureEnabled) {
        ViewGroup.LayoutParams layoutParams = $this$isFlagSecureEnabled.getRootView().getLayoutParams();
        WindowManager.LayoutParams windowParams = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (windowParams == null || (windowParams.flags & 8192) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldApplySecureFlag(SecureFlagPolicy $this$shouldApplySecureFlag, boolean isSecureFlagSetOnParent) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$shouldApplySecureFlag.ordinal()]) {
            case 1:
                return false;
            case 2:
                return true;
            case 3:
                return isSecureFlagSetOnParent;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
