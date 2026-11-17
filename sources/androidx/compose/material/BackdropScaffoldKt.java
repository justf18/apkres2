package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.ZIndexModifierKt;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.layout.SubcomposeLayoutKt;
import androidx.compose.p000ui.layout.SubcomposeMeasureScope;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BackdropScaffold.kt */
@Metadata(m164d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u000b\u001aò\u0001\u0010\f\u001a\u00020\u00042\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u001a2\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040#¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001ae\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t¢\u0006\u0002\b)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0#2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0002\b\t¢\u0006\u0002\b)H\u0003¢\u0006\u0002\u0010/\u001a0\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001a2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u00103\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aE\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00062\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020.092\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140#2\b\b\u0002\u0010;\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006=²\u0006\n\u0010>\u001a\u00020.X\u008a\u0084\u0002²\u0006\n\u0010?\u001a\u00020.X\u008a\u0084\u0002"}, m165d2 = {"AnimationSlideOffset", "Landroidx/compose/ui/unit/Dp;", "F", "BackLayerTransition", "", TypedValues.AttributesType.S_TARGET, "Landroidx/compose/material/BackdropValue;", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropScaffold", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "gesturesEnabled", "", "peekHeight", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "BackdropScaffold-BZszfkY", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BackdropStack", "backLayer", "Landroidx/compose/ui/UiComposable;", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Scrim", TypedValues.Custom.S_COLOR, "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberBackdropScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "snackbarHostState", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "material_release", "alpha", "animationProgress"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = C1956Dp.m6297constructorimpl(20);

    public static final BackdropScaffoldState rememberBackdropScaffoldState(final BackdropValue initialValue, final AnimationSpec<Float> animationSpec, final Function1<? super BackdropValue, Boolean> function1, final SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-862178912);
        ComposerKt.sourceInformation($composer, "C(rememberBackdropScaffoldState)P(2)173@6493L32,175@6564L538:BackdropScaffold.kt#jmzs0o");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            Function1 confirmStateChange = new Function1<BackdropValue, Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt.rememberBackdropScaffoldState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BackdropValue it) {
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if ((i & 8) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new SnackbarHostState();
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) value$iv$iv;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-862178912, $changed, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:174)");
        }
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.m3566rememberSaveable(new Object[]{animationSpec, function1, snackbarHostState}, (Saver) BackdropScaffoldState.INSTANCE.Saver(animationSpec, function1, snackbarHostState), (String) null, (Function0) new Function0<BackdropScaffoldState>() { // from class: androidx.compose.material.BackdropScaffoldKt.rememberBackdropScaffoldState.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BackdropScaffoldState invoke() {
                return new BackdropScaffoldState(initialValue, animationSpec, function1, snackbarHostState);
            }
        }, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return backdropScaffoldState;
    }

    /* renamed from: BackdropScaffold-BZszfkY, reason: not valid java name */
    public static final void m1425BackdropScaffoldBZszfkY(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Modifier modifier, BackdropScaffoldState scaffoldState, boolean gesturesEnabled, float peekHeight, float headerHeight, boolean persistentAppBar, boolean stickyFrontLayer, long backLayerBackgroundColor, long backLayerContentColor, Shape frontLayerShape, float frontLayerElevation, long frontLayerBackgroundColor, long frontLayerContentColor, long frontLayerScrimColor, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        BackdropScaffoldState backdropScaffoldState;
        boolean z;
        float f;
        int $dirty1;
        int i2;
        int i3;
        int $dirty;
        int $dirty12;
        Shape shape;
        Function3 function32;
        int i4;
        final BackdropScaffoldState scaffoldState2;
        boolean gesturesEnabled2;
        float peekHeight2;
        float headerHeight2;
        boolean stickyFrontLayer2;
        long backLayerBackgroundColor2;
        long backLayerContentColor2;
        int $dirty13;
        int i5;
        Shape frontLayerShape2;
        long frontLayerBackgroundColor2;
        long frontLayerContentColor2;
        long frontLayerBackgroundColor3;
        long frontLayerBackgroundColor4;
        final float frontLayerElevation2;
        long frontLayerScrimColor2;
        final boolean persistentAppBar2;
        int $dirty2;
        Function3 snackbarHost;
        final Function3 snackbarHost2;
        final boolean gesturesEnabled3;
        Composer $composer2;
        final float peekHeight3;
        final Modifier modifier3;
        final boolean stickyFrontLayer3;
        final boolean persistentAppBar3;
        final float frontLayerElevation3;
        final float peekHeight4;
        final BackdropScaffoldState scaffoldState3;
        final boolean gesturesEnabled4;
        final long backLayerBackgroundColor3;
        final Shape frontLayerShape3;
        final long frontLayerBackgroundColor5;
        final long backLayerContentColor3;
        final long frontLayerBackgroundColor6;
        final Function3 snackbarHost3;
        final long backLayerContentColor4;
        int i6;
        Composer $composer3 = $composer.startRestartGroup(1397420093);
        ComposerKt.sourceInformation($composer3, "C(BackdropScaffold)P(!1,2,5,12,15,10,13:c#ui.unit.Dp,11:c#ui.unit.Dp,14,17,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color)262@11812L40,268@12139L6,269@12190L41,270@12287L15,272@12433L6,273@12485L42,274@12588L20,*277@12736L7,278@12810L7,295@13317L3282:BackdropScaffold.kt#jmzs0o");
        int $dirty3 = $changed;
        int i7 = 2;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changedInstance(function23) ? 256 : 128;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty3 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 7168) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i9 = 8192;
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                backdropScaffoldState = scaffoldState;
                if ($composer3.changed(backdropScaffoldState)) {
                    i6 = 16384;
                }
                $dirty3 |= i6;
            } else {
                backdropScaffoldState = scaffoldState;
            }
            i6 = 8192;
            $dirty3 |= i6;
        } else {
            backdropScaffoldState = scaffoldState;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            z = gesturesEnabled;
        } else if (($changed & 458752) == 0) {
            z = gesturesEnabled;
            $dirty3 |= $composer3.changed(z) ? 131072 : 65536;
        } else {
            z = gesturesEnabled;
        }
        int i11 = i & 64;
        if (i11 != 0) {
            $dirty3 |= 1572864;
            f = peekHeight;
        } else if (($changed & 3670016) == 0) {
            f = peekHeight;
            $dirty3 |= $composer3.changed(f) ? 1048576 : 524288;
        } else {
            f = peekHeight;
        }
        int i12 = i & 128;
        if (i12 != 0) {
            $dirty3 |= 12582912;
            $dirty1 = $changed1;
        } else if (($changed & 29360128) == 0) {
            $dirty1 = $changed1;
            $dirty3 |= $composer3.changed(headerHeight) ? 8388608 : 4194304;
        } else {
            $dirty1 = $changed1;
        }
        int $dirty14 = i & 256;
        if ($dirty14 != 0) {
            $dirty3 |= 100663296;
            i2 = $dirty14;
        } else if (($changed & 234881024) == 0) {
            i2 = $dirty14;
            $dirty3 |= $composer3.changed(persistentAppBar) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = $dirty14;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty = $dirty3 | 805306368;
            i3 = i13;
        } else {
            if (($changed & 1879048192) == 0) {
                i3 = i13;
                $dirty3 |= $composer3.changed(stickyFrontLayer) ? 536870912 : 268435456;
            } else {
                i3 = i13;
            }
            $dirty = $dirty3;
        }
        if (($changed1 & 14) == 0) {
            if ((i & 1024) == 0 && $composer3.changed(backLayerBackgroundColor)) {
                i7 = 4;
            }
            $dirty12 = $dirty1 | i7;
        } else {
            $dirty12 = $dirty1;
        }
        if (($changed1 & 112) == 0) {
            $dirty12 |= ((i & 2048) == 0 && $composer3.changed(backLayerContentColor)) ? 32 : 16;
        }
        if (($changed1 & 896) == 0) {
            if ((i & 4096) == 0) {
                shape = frontLayerShape;
                int i14 = $composer3.changed(shape) ? 256 : 128;
                $dirty12 |= i14;
            } else {
                shape = frontLayerShape;
            }
            $dirty12 |= i14;
        } else {
            shape = frontLayerShape;
        }
        int i15 = i & 8192;
        if (i15 != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty12 |= $composer3.changed(frontLayerElevation) ? 2048 : 1024;
        }
        if (($changed1 & 57344) == 0) {
            if ((i & 16384) == 0 && $composer3.changed(frontLayerBackgroundColor)) {
                i9 = 16384;
            }
            $dirty12 |= i9;
        }
        if ((458752 & $changed1) == 0) {
            $dirty12 |= ((i & 32768) == 0 && $composer3.changed(frontLayerContentColor)) ? 131072 : 65536;
        }
        if ((3670016 & $changed1) == 0) {
            $dirty12 |= ((i & 65536) == 0 && $composer3.changed(frontLayerScrimColor)) ? 1048576 : 524288;
        }
        int i16 = i & 131072;
        if (i16 != 0) {
            $dirty12 |= 12582912;
            function32 = function3;
        } else if (($changed1 & 29360128) == 0) {
            function32 = function3;
            $dirty12 |= $composer3.changedInstance(function32) ? 8388608 : 4194304;
        } else {
            function32 = function3;
        }
        int $dirty15 = $dirty12;
        if (($dirty & 1533916891) == 306783378 && ($dirty15 & 23967451) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            peekHeight4 = headerHeight;
            frontLayerElevation3 = frontLayerElevation;
            frontLayerBackgroundColor6 = frontLayerContentColor;
            backLayerContentColor4 = frontLayerScrimColor;
            snackbarHost3 = function32;
            modifier3 = modifier2;
            $composer2 = $composer3;
            scaffoldState3 = backdropScaffoldState;
            gesturesEnabled4 = z;
            peekHeight3 = f;
            persistentAppBar3 = persistentAppBar;
            stickyFrontLayer3 = stickyFrontLayer;
            backLayerContentColor3 = backLayerContentColor;
            frontLayerBackgroundColor5 = frontLayerBackgroundColor;
            frontLayerShape3 = shape;
            backLayerBackgroundColor3 = backLayerBackgroundColor;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier modifier4 = i8 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 16) != 0) {
                    i4 = i15;
                    scaffoldState2 = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, $composer3, 6, 14);
                    $dirty &= -57345;
                } else {
                    i4 = i15;
                    scaffoldState2 = backdropScaffoldState;
                }
                gesturesEnabled2 = i10 != 0 ? true : z;
                peekHeight2 = i11 != 0 ? BackdropScaffoldDefaults.INSTANCE.m1424getPeekHeightD9Ej5fM() : f;
                headerHeight2 = i12 != 0 ? BackdropScaffoldDefaults.INSTANCE.m1423getHeaderHeightD9Ej5fM() : headerHeight;
                boolean persistentAppBar4 = i2 != 0 ? true : persistentAppBar;
                stickyFrontLayer2 = i3 != 0 ? true : stickyFrontLayer;
                if ((i & 1024) != 0) {
                    backLayerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1490getPrimary0d7_KjU();
                    $dirty15 &= -15;
                } else {
                    backLayerBackgroundColor2 = backLayerBackgroundColor;
                }
                if ((i & 2048) != 0) {
                    backLayerContentColor2 = ColorsKt.m1508contentColorForek8zF_U(backLayerBackgroundColor2, $composer3, $dirty15 & 14);
                    $dirty13 = $dirty15 & (-113);
                } else {
                    backLayerContentColor2 = backLayerContentColor;
                    $dirty13 = $dirty15;
                }
                if ((i & 4096) != 0) {
                    i5 = i16;
                    frontLayerShape2 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape($composer3, 6);
                    $dirty13 &= -897;
                } else {
                    i5 = i16;
                    frontLayerShape2 = frontLayerShape;
                }
                float frontLayerElevation4 = i4 != 0 ? BackdropScaffoldDefaults.INSTANCE.m1422getFrontLayerElevationD9Ej5fM() : frontLayerElevation;
                if ((i & 16384) != 0) {
                    $dirty13 &= -57345;
                    frontLayerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1494getSurface0d7_KjU();
                } else {
                    frontLayerBackgroundColor2 = frontLayerBackgroundColor;
                }
                if ((i & 32768) != 0) {
                    frontLayerContentColor2 = ColorsKt.m1508contentColorForek8zF_U(frontLayerBackgroundColor2, $composer3, ($dirty13 >> 12) & 14);
                    $dirty13 &= -458753;
                } else {
                    frontLayerContentColor2 = frontLayerContentColor;
                }
                if ((i & 65536) != 0) {
                    frontLayerBackgroundColor3 = frontLayerBackgroundColor2;
                    frontLayerBackgroundColor4 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor($composer3, 6);
                    $dirty13 &= -3670017;
                } else {
                    frontLayerBackgroundColor3 = frontLayerBackgroundColor2;
                    frontLayerBackgroundColor4 = frontLayerScrimColor;
                }
                if (i5 != 0) {
                    frontLayerElevation2 = frontLayerElevation4;
                    frontLayerScrimColor2 = frontLayerBackgroundColor4;
                    $dirty2 = $dirty;
                    snackbarHost = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1515getLambda1$material_release();
                    persistentAppBar2 = persistentAppBar4;
                    modifier2 = modifier4;
                } else {
                    frontLayerElevation2 = frontLayerElevation4;
                    frontLayerScrimColor2 = frontLayerBackgroundColor4;
                    persistentAppBar2 = persistentAppBar4;
                    modifier2 = modifier4;
                    $dirty2 = $dirty;
                    snackbarHost = function3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 1024) != 0) {
                    $dirty15 &= -15;
                }
                if ((i & 2048) != 0) {
                    $dirty15 &= -113;
                }
                int $dirty16 = $dirty15;
                if ((i & 4096) != 0) {
                    $dirty16 &= -897;
                }
                if ((i & 16384) != 0) {
                    $dirty16 &= -57345;
                }
                if ((i & 32768) != 0) {
                    $dirty16 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty16 &= -3670017;
                }
                headerHeight2 = headerHeight;
                backLayerContentColor2 = backLayerContentColor;
                frontLayerBackgroundColor3 = frontLayerBackgroundColor;
                frontLayerContentColor2 = frontLayerContentColor;
                frontLayerScrimColor2 = frontLayerScrimColor;
                $dirty13 = $dirty16;
                snackbarHost = function32;
                scaffoldState2 = backdropScaffoldState;
                gesturesEnabled2 = z;
                peekHeight2 = f;
                $dirty2 = $dirty;
                persistentAppBar2 = persistentAppBar;
                backLayerBackgroundColor2 = backLayerBackgroundColor;
                frontLayerElevation2 = frontLayerElevation;
                frontLayerShape2 = shape;
                stickyFrontLayer2 = stickyFrontLayer;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                snackbarHost2 = snackbarHost;
                gesturesEnabled3 = gesturesEnabled2;
                ComposerKt.traceEventStart(1397420093, $dirty2, $dirty13, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:276)");
            } else {
                snackbarHost2 = snackbarHost;
                gesturesEnabled3 = gesturesEnabled2;
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$BackdropScaffold_BZszfkY_u24lambda_u241 = (Density) objConsume;
            final float peekHeightPx = $this$BackdropScaffold_BZszfkY_u24lambda_u241.mo518toPx0680j_4(peekHeight2);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$BackdropScaffold_BZszfkY_u24lambda_u242 = (Density) objConsume2;
            final float headerHeightPx = $this$BackdropScaffold_BZszfkY_u24lambda_u242.mo518toPx0680j_4(headerHeight2);
            boolean persistentAppBar5 = persistentAppBar2;
            final Function2 backLayer = ComposableLambdaKt.composableLambda($composer3, 1744778315, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1
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
                    Function0 factory$iv$iv$iv;
                    int $changed$iv;
                    ComposerKt.sourceInformation($composer4, "C:BackdropScaffold.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1744778315, $changed2, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:281)");
                        }
                        if (!persistentAppBar2) {
                            $composer4.startReplaceableGroup(-1017265173);
                            ComposerKt.sourceInformation($composer4, "287@13034L72");
                            BackdropScaffoldKt.BackLayerTransition(scaffoldState2.getTargetValue(), function2, function22, $composer4, 0);
                            $composer4.endReplaceableGroup();
                        } else {
                            $composer4.startReplaceableGroup(-1017265285);
                            ComposerKt.sourceInformation($composer4, "282@12922L82");
                            Function2<Composer, Integer, Unit> function24 = function2;
                            Function2<Composer, Integer, Unit> function25 = function22;
                            $composer4.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation($composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            Modifier modifier$iv = Modifier.INSTANCE;
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv = (0 << 3) & 112;
                            $composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
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
                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                                $changed$iv = 0;
                            } else {
                                $changed$iv = 0;
                                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                }
                                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                $composer4.startReplaceableGroup(2058660585);
                                int i17 = ($changed$iv$iv$iv >> 9) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                int i18 = (($changed$iv >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer4, -1993300157, "C283@12947L8,284@12972L18:BackdropScaffold.kt#jmzs0o");
                                function24.invoke($composer4, 0);
                                function25.invoke($composer4, 0);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer4.endReplaceableGroup();
                                $composer4.endNode();
                                $composer4.endReplaceableGroup();
                                $composer4.endReplaceableGroup();
                                $composer4.endReplaceableGroup();
                            }
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                            $composer4.startReplaceableGroup(2058660585);
                            int i172 = ($changed$iv$iv$iv >> 9) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            int i182 = (($changed$iv >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1993300157, "C283@12947L8,284@12972L18:BackdropScaffold.kt#jmzs0o");
                            function24.invoke($composer4, 0);
                            function25.invoke($composer4, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endReplaceableGroup();
                            $composer4.endNode();
                            $composer4.endReplaceableGroup();
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
            });
            $composer3.startReplaceableGroup(-874716113);
            boolean invalid$iv = $composer3.changed(headerHeightPx);
            Object value$iv = $composer3.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<Constraints, Constraints>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Constraints invoke(Constraints constraints) {
                        return Constraints.m6241boximpl(m1430invokeZezNO4M(constraints.getValue()));
                    }

                    /* renamed from: invoke-ZezNO4M, reason: not valid java name */
                    public final long m1430invokeZezNO4M(long it) {
                        return ConstraintsKt.m6270offsetNN6EwU$default(Constraints.m6243copyZbe2FdA(it, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(it) : 0, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(it) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(it) : 0, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(it) : 0), 0, -MathKt.roundToInt(headerHeightPx), 1, null);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            }
            final Function1 calculateBackLayerConstraints = (Function1) value$iv;
            $composer3.endReplaceableGroup();
            final float headerHeight3 = headerHeight2;
            final BackdropScaffoldState scaffoldState4 = scaffoldState2;
            final float peekHeight5 = peekHeight2;
            final Modifier modifier5 = modifier2;
            final boolean stickyFrontLayer4 = stickyFrontLayer2;
            final Shape frontLayerShape4 = frontLayerShape2;
            final long frontLayerContentColor3 = frontLayerContentColor2;
            final long frontLayerBackgroundColor7 = frontLayerBackgroundColor3;
            final long frontLayerScrimColor3 = frontLayerScrimColor2;
            boolean gesturesEnabled5 = gesturesEnabled3;
            float frontLayerElevation5 = frontLayerElevation2;
            Function3 snackbarHost4 = snackbarHost2;
            SurfaceKt.m1669SurfaceFjzlyU(null, null, backLayerBackgroundColor2, backLayerContentColor2, null, 0.0f, ComposableLambdaKt.composableLambda($composer3, -1049909631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1
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
                    Object value$iv$iv$iv;
                    ComposerKt.sourceInformation($composer4, "C299@13441L24,300@13474L3119:BackdropScaffold.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1049909631, $changed2, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:299)");
                        }
                        $composer4.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation($composer4, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        $composer4.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer4, "CC(remember):Composables.kt#9igjgp");
                        Object it$iv$iv$iv = $composer4.rememberedValue();
                        if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4));
                            $composer4.updateRememberedValue(value$iv$iv$iv);
                        } else {
                            value$iv$iv$iv = it$iv$iv$iv;
                        }
                        $composer4.endReplaceableGroup();
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                        final CoroutineScope scope = wrapper$iv.getCoroutineScope();
                        $composer4.endReplaceableGroup();
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier5, 0.0f, 1, null);
                        Function2<Composer, Integer, Unit> function24 = backLayer;
                        Function1<Constraints, Constraints> function1 = calculateBackLayerConstraints;
                        final float f2 = headerHeightPx;
                        final boolean z2 = stickyFrontLayer4;
                        final boolean z3 = gesturesEnabled3;
                        final BackdropScaffoldState backdropScaffoldState2 = scaffoldState4;
                        final float f3 = peekHeightPx;
                        final Shape shape2 = frontLayerShape4;
                        final long j = frontLayerBackgroundColor7;
                        final long j2 = frontLayerContentColor3;
                        final float f4 = frontLayerElevation2;
                        final float f5 = headerHeight3;
                        final float f6 = peekHeight5;
                        final Function2<Composer, Integer, Unit> function25 = function23;
                        final long j3 = frontLayerScrimColor3;
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function33 = snackbarHost2;
                        BackdropScaffoldKt.BackdropStack(modifierFillMaxSize$default, function24, function1, ComposableLambdaKt.composableLambda($composer4, 1800047509, true, new Function4<Constraints, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(Constraints constraints, Float f7, Composer composer, Integer num) {
                                m1428invokejYbf7pk(constraints.getValue(), f7.floatValue(), composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:48:0x018d  */
                            /* renamed from: invoke-jYbf7pk, reason: not valid java name */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public final void m1428invokejYbf7pk(long r36, float r38, androidx.compose.runtime.Composer r39, int r40) {
                                /*
                                    Method dump skipped, instructions count: 748
                                    To view this dump change 'Code comments level' option to 'DEBUG'
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.C09321.m1428invokejYbf7pk(long, float, androidx.compose.runtime.Composer, int):void");
                            }
                        }), $composer4, 3120);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, (($dirty13 << 6) & 896) | 1572864 | (($dirty13 << 6) & 7168), 51);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            peekHeight3 = peekHeight2;
            modifier3 = modifier2;
            stickyFrontLayer3 = stickyFrontLayer4;
            persistentAppBar3 = persistentAppBar5;
            frontLayerElevation3 = frontLayerElevation5;
            peekHeight4 = headerHeight2;
            scaffoldState3 = scaffoldState2;
            gesturesEnabled4 = gesturesEnabled5;
            backLayerBackgroundColor3 = backLayerBackgroundColor2;
            frontLayerShape3 = frontLayerShape4;
            frontLayerBackgroundColor5 = frontLayerBackgroundColor3;
            backLayerContentColor3 = backLayerContentColor2;
            frontLayerBackgroundColor6 = frontLayerContentColor3;
            snackbarHost3 = snackbarHost4;
            backLayerContentColor4 = frontLayerScrimColor3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2
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

                public final void invoke(Composer composer, int i17) {
                    BackdropScaffoldKt.m1425BackdropScaffoldBZszfkY(function2, function22, function23, modifier3, scaffoldState3, gesturesEnabled4, peekHeight3, peekHeight4, persistentAppBar3, stickyFrontLayer3, backLayerBackgroundColor3, backLayerContentColor3, frontLayerShape3, frontLayerElevation3, frontLayerBackgroundColor5, frontLayerBackgroundColor6, backLayerContentColor4, snackbarHost3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1426Scrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissModifier;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-92141505);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)390@16754L121,399@17055L171:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(visible) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92141505, $dirty2, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:388)");
            }
            if ((color != Color.INSTANCE.m3985getUnspecified0d7_KjU() ? 1 : 0) != 0) {
                final State alpha$delegate = AnimateAsStateKt.animateFloatAsState(visible ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer2, 48, 28);
                if (visible) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Unit unit = Unit.INSTANCE;
                    $composer2.startReplaceableGroup(-874712345);
                    boolean invalid$iv = $composer2.changedInstance(function0);
                    BackdropScaffoldKt$Scrim$dismissModifier$1$1 value$iv2 = $composer2.rememberedValue();
                    if (invalid$iv || value$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv2);
                    }
                    $composer2.endReplaceableGroup();
                    dismissModifier = SuspendingPointerInputFilterKt.pointerInput(companion, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2);
                } else {
                    dismissModifier = Modifier.INSTANCE;
                }
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissModifier);
                $composer2.startReplaceableGroup(-874712142);
                boolean invalid$iv2 = $composer2.changed(color) | $composer2.changed(alpha$delegate);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$1$1
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
                            DrawScope.m4493drawRectnJ9OG0$default($this$Canvas, color, 0L, 0L, BackdropScaffoldKt.Scrim_3J_VO9M$lambda$4(alpha$delegate), null, null, 0, 118, null);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$2
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
                    BackdropScaffoldKt.m1426Scrim3JVO9M(color, function0, visible, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$4(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackLayerTransition(final BackdropValue target, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer3 = $composer.startRestartGroup(-950970976);
        ComposerKt.sourceInformation($composer3, "C(BackLayerTransition)P(2)423@17886L112,*426@18048L7,431@18222L486:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(target) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-950970976, $dirty2, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:420)");
            }
            State animationProgress$delegate = AnimateAsStateKt.animateFloatAsState(target == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer3, 48, 28);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$BackLayerTransition_u24lambda_u248 = (Density) objConsume;
            float animationSlideOffset = $this$BackLayerTransition_u24lambda_u248.mo518toPx0680j_4(AnimationSlideOffset);
            float f = 1;
            float appBarFloat = RangesKt.coerceIn(BackLayerTransition$lambda$7(animationProgress$delegate) - f, 0.0f, 1.0f);
            float contentFloat = RangesKt.coerceIn(f - BackLayerTransition$lambda$7(animationProgress$delegate), 0.0f, 1.0f);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifier$iv);
            int $changed$iv = $changed$iv$iv << 9;
            int $changed$iv$iv$iv = ($changed$iv & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3479constructorimpl($composer3);
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1538629116, "C432@18236L226,440@18471L231:BackdropScaffold.kt#jmzs0o");
            Modifier modifier$iv2 = GraphicsLayerModifierKt.m4110graphicsLayerAp8cVGQ$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, appBarFloat), 0.0f, 0.0f, appBarFloat, 0.0f, (f - appBarFloat) * animationSlideOffset, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131051, null);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Function0 factory$iv$iv$iv5 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.modifierMaterializerOf(modifier$iv2);
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3479constructorimpl($composer3);
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
            }
            skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i3 = ($changed$iv$iv$iv2 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -481855243, "C438@18444L8:BackdropScaffold.kt#jmzs0o");
            function2.invoke($composer3, Integer.valueOf(($dirty2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            Modifier modifier$iv3 = GraphicsLayerModifierKt.m4110graphicsLayerAp8cVGQ$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, contentFloat), 0.0f, 0.0f, contentFloat, 0.0f, (f - contentFloat) * (-animationSlideOffset), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131051, null);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Function0 factory$iv$iv$iv6 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.modifierMaterializerOf(modifier$iv3);
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3479constructorimpl($composer3);
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), block$iv$iv$iv3);
            }
            skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i5 = ($changed$iv$iv$iv3 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -481855004, "C446@18683L9:BackdropScaffold.kt#jmzs0o");
            function22.invoke($composer3, Integer.valueOf(($dirty2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackLayerTransition.2
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

                public final void invoke(Composer composer, int i7) {
                    BackdropScaffoldKt.BackLayerTransition(target, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final float BackLayerTransition$lambda$7(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackdropStack(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function1<? super Constraints, Constraints> function1, final Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1248995194);
        ComposerKt.sourceInformation($composer2, "C(BackdropStack)P(3)459@18986L917:BackdropScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1248995194, $dirty, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:458)");
            }
            $composer2.startReplaceableGroup(-874710293);
            boolean invalid$iv = $composer2.changedInstance(function2) | $composer2.changedInstance(function1) | $composer2.changedInstance(function4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1431invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1431invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, final long constraints) {
                        final Placeable backLayerPlaceable = ((Measurable) CollectionsKt.first((List) $this$SubcomposeLayout.subcompose(BackdropLayers.Back, function2))).mo5219measureBRTryo0(function1.invoke(Constraints.m6241boximpl(constraints)).getValue());
                        final float backLayerHeight = backLayerPlaceable.getHeight();
                        BackdropLayers backdropLayers = BackdropLayers.Front;
                        final Function4<Constraints, Float, Composer, Integer, Unit> function42 = function4;
                        List $this$fastMap$iv = $this$SubcomposeLayout.subcompose(backdropLayers, ComposableLambdaKt.composableLambdaInstance(-1222642649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1$placeables$1
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
                                ComposerKt.sourceInformation($composer3, "C468@19351L40:BackdropScaffold.kt#jmzs0o");
                                if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                                    $composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1222642649, $changed2, -1, "androidx.compose.material.BackdropStack.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:468)");
                                }
                                function42.invoke(Constraints.m6241boximpl(constraints), Float.valueOf(backLayerHeight), $composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        List target$iv = new ArrayList($this$fastMap$iv.size());
                        int size = $this$fastMap$iv.size();
                        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                            target$iv.add(((Measurable) item$iv$iv).mo5219measureBRTryo0(constraints));
                        }
                        final List placeables = target$iv;
                        int maxWidth = Math.max(Constraints.m6255getMinWidthimpl(constraints), backLayerPlaceable.getWidth());
                        int maxHeight = Math.max(Constraints.m6254getMinHeightimpl(constraints), backLayerPlaceable.getHeight());
                        int size2 = placeables.size();
                        int maxWidth2 = maxWidth;
                        int maxHeight2 = maxHeight;
                        for (int index$iv = 0; index$iv < size2; index$iv++) {
                            Object item$iv = placeables.get(index$iv);
                            Placeable it = (Placeable) item$iv;
                            maxWidth2 = Math.max(maxWidth2, it.getWidth());
                            maxHeight2 = Math.max(maxHeight2, it.getHeight());
                        }
                        return MeasureScope.layout$default($this$SubcomposeLayout, maxWidth2, maxHeight2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                Placeable.PlacementScope.placeRelative$default($this$layout, backLayerPlaceable, 0, 0, 0.0f, 4, null);
                                List $this$fastForEach$iv = placeables;
                                int size3 = $this$fastForEach$iv.size();
                                for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
                                    Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
                                    Placeable it2 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.placeRelative$default($this$layout, it2, 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) value$iv, $composer2, $dirty & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropStack.2
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

                public final void invoke(Composer composer, int i) {
                    BackdropScaffoldKt.BackdropStack(modifier, function2, function1, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
