package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.geometry.RectKt;
import androidx.compose.p000ui.graphics.AndroidPath_androidKt;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Path;
import androidx.compose.p000ui.graphics.PathFillType;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.StrokeCap;
import androidx.compose.p000ui.graphics.drawscope.DrawContext;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawTransform;
import androidx.compose.p000ui.graphics.drawscope.Stroke;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.semantics.ProgressBarRangeInfo;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.internal.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* compiled from: PullToRefresh.kt */
@Metadata(m164d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002\u001a(\u0010\u0018\u001a\u00020\u00192\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a]\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00190%¢\u0006\u0002\b&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u001c2\b\b\u0002\u0010*\u001a\u00020\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a*\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u0002002\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u0002000\u001aH\u0007\u001a,\u00102\u001a\u00020!2\b\b\u0002\u00103\u001a\u00020\u00042\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u0002000\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aF\u00106\u001a\u00020\u0019*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a>\u0010A\u001a\u00020\u0019*\u0002072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00162\u0006\u0010B\u001a\u00020;2\u0006\u0010>\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010D\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\f\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0013\u0010\u0011\"\u0010\u0010\u0014\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E²\u0006\n\u0010F\u001a\u00020\u0002X\u008a\u0084\u0002"}, m165d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "DragMultiplier", "Elevation", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerContainerSize", "getSpinnerContainerSize", "()F", "SpinnerSize", "getSpinnerSize", "StrokeWidth", "ArrowValues", "Landroidx/compose/material3/pulltorefresh/ArrowValues;", "progress", "CircularArrowProgressIndicator", "", "Lkotlin/Function0;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "CircularArrowProgressIndicator-RPmYEkk", "(Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "PullToRefreshContainer", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "modifier", "Landroidx/compose/ui/Modifier;", "indicator", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "PullToRefreshContainer-wBJOh4Y", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "PullToRefreshState", "positionalThresholdPx", "initialRefreshing", "", "enabled", "rememberPullToRefreshState", "positionalThreshold", "rememberPullToRefreshState--orJrPs", "(FLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "strokeWidth", "drawArrow-uDrxG_w", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;F)V", "drawCircularIndicator", "arcBounds", "drawCircularIndicator-KzyDr3Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;Landroidx/compose/ui/geometry/Rect;F)V", "material3_release", "targetAlpha"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PullToRefreshKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float DragMultiplier = 0.5f;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float StrokeWidth = C1956Dp.m6297constructorimpl((float) 2.5d);
    private static final float ArcRadius = C1956Dp.m6297constructorimpl((float) 5.5d);
    private static final float SpinnerSize = C1956Dp.m6297constructorimpl(16);
    private static final float SpinnerContainerSize = C1956Dp.m6297constructorimpl(40);
    private static final float Elevation = ElevationTokens.INSTANCE.m3016getLevel2D9Ej5fM();
    private static final float ArrowWidth = C1956Dp.m6297constructorimpl(10);
    private static final float ArrowHeight = C1956Dp.m6297constructorimpl(5);
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null);

    /* renamed from: PullToRefreshContainer-wBJOh4Y, reason: not valid java name */
    public static final void m2835PullToRefreshContainerwBJOh4Y(final PullToRefreshState state, Modifier modifier, Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function3, Shape shape, long containerColor, long contentColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function3 indicator;
        Shape shape2;
        long containerColor2;
        long contentColor2;
        Modifier.Companion modifier3;
        final Modifier modifier4;
        Object value$iv;
        final Function3 indicator2;
        final long containerColor3;
        final Modifier modifier5;
        final Shape shape3;
        final long contentColor3;
        Composer $composer2 = $composer.startRestartGroup(-801976958);
        ComposerKt.sourceInformation($composer2, "C(PullToRefreshContainer)P(5,3,2,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color)113@4939L14,114@5003L12,118@5222L91,121@5318L650:PullToRefresh.kt#djiw08");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            indicator = function3;
        } else if (($changed & 384) == 0) {
            indicator = function3;
            $dirty |= $composer2.changedInstance(indicator) ? 256 : 128;
        } else {
            indicator = function3;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            shape2 = shape;
        } else if (($changed & 3072) == 0) {
            shape2 = shape;
            $dirty |= $composer2.changed(shape2) ? 2048 : 1024;
        } else {
            shape2 = shape;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                containerColor2 = containerColor;
                int i5 = $composer2.changed(containerColor2) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i5;
        } else {
            containerColor2 = containerColor;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer2.changed(contentColor2) ? 131072 : 65536;
                $dirty |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i6;
        } else {
            contentColor2 = contentColor;
        }
        if ((74899 & $dirty) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            indicator2 = indicator;
            containerColor3 = containerColor2;
            modifier5 = modifier2;
            shape3 = shape2;
            contentColor3 = contentColor2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    indicator = ComposableSingletons$PullToRefreshKt.INSTANCE.m2831getLambda1$material3_release();
                }
                if (i4 != 0) {
                    shape2 = PullToRefreshDefaults.INSTANCE.getShape();
                }
                if ((i & 16) != 0) {
                    containerColor2 = PullToRefreshDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    contentColor2 = PullToRefreshDefaults.INSTANCE.getContentColor($composer2, 6);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    modifier3 = modifier2;
                } else {
                    modifier3 = modifier2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-801976958, $dirty, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshContainer (PullToRefresh.kt:115)");
            }
            $composer2.startReplaceableGroup(751291370);
            ComposerKt.sourceInformation($composer2, "CC(remember):PullToRefresh.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                modifier4 = modifier3;
                value$iv = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$showElevation$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(state.getVerticalOffset() > 1.0f || state.isRefreshing());
                    }
                });
                $composer2.updateRememberedValue(value$iv);
            } else {
                modifier4 = modifier3;
                value$iv = it$iv;
            }
            final State showElevation = (State) value$iv;
            $composer2.endReplaceableGroup();
            final Function3 indicator3 = indicator;
            final Shape shape4 = shape2;
            final long containerColor4 = containerColor2;
            Modifier modifier6 = modifier4;
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m3939boximpl(contentColor2)), ComposableLambdaKt.composableLambda($composer2, 935555266, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1
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

                /* JADX WARN: Removed duplicated region for block: B:39:0x01e6  */
                /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r28, int r29) {
                    /*
                        Method dump skipped, instructions count: 490
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, ProvidedValue.$stable | 0 | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            indicator2 = indicator;
            containerColor3 = containerColor2;
            modifier5 = modifier6;
            shape3 = shape2;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$PullToRefreshContainer$2
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
                    PullToRefreshKt.m2835PullToRefreshContainerwBJOh4Y(state, modifier5, indicator2, shape3, containerColor3, contentColor3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: rememberPullToRefreshState--orJrPs, reason: not valid java name */
    public static final PullToRefreshState m2841rememberPullToRefreshStateorJrPs(float positionalThreshold, final Function0<Boolean> function0, Composer $composer, int $changed, int i) {
        Object value$iv;
        $composer.startReplaceableGroup(1935213334);
        ComposerKt.sourceInformation($composer, "C(rememberPullToRefreshState)P(1:c#ui.unit.Dp)253@9584L7,261@9888L176,255@9680L384:PullToRefresh.kt#djiw08");
        if ((i & 1) != 0) {
            positionalThreshold = PullToRefreshDefaults.INSTANCE.m2833getPositionalThresholdD9Ej5fM();
        }
        if ((i & 2) != 0) {
            Function0 enabled = new Function0<Boolean>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$rememberPullToRefreshState$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return true;
                }
            };
            function0 = enabled;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1935213334, $changed, -1, "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:252)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) objConsume;
        final float positionalThresholdPx = density.mo518toPx0680j_4(positionalThreshold);
        Object[] objArr = {Float.valueOf(positionalThresholdPx), function0};
        Saver<PullToRefreshState, Boolean> Saver = PullToRefreshStateImpl.INSTANCE.Saver(positionalThresholdPx, function0);
        $composer.startReplaceableGroup(804873447);
        ComposerKt.sourceInformation($composer, "CC(remember):PullToRefresh.kt#9igjgp");
        boolean invalid$iv = $composer.changed(positionalThresholdPx) | (((($changed & 112) ^ 48) > 32 && $composer.changed(function0)) || ($changed & 48) == 32);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = (Function0) new Function0<PullToRefreshState>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$rememberPullToRefreshState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PullToRefreshState invoke() {
                    return new PullToRefreshStateImpl(false, positionalThresholdPx, function0);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        $composer.endReplaceableGroup();
        PullToRefreshState pullToRefreshState = (PullToRefreshState) RememberSaveableKt.m3566rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return pullToRefreshState;
    }

    public static /* synthetic */ PullToRefreshState PullToRefreshState$default(float f, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function0 = new Function0<Boolean>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt.PullToRefreshState.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return true;
                }
            };
        }
        return PullToRefreshState(f, z, function0);
    }

    public static final PullToRefreshState PullToRefreshState(float positionalThresholdPx, boolean initialRefreshing, Function0<Boolean> function0) {
        return new PullToRefreshStateImpl(initialRefreshing, positionalThresholdPx, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularArrowProgressIndicator-RPmYEkk, reason: not valid java name */
    public static final void m2834CircularArrowProgressIndicatorRPmYEkk(final Function0<Float> function0, final long color, Composer $composer, final int $changed) {
        boolean z;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Composer $composer2 = $composer.startRestartGroup(-569718810);
        ComposerKt.sourceInformation($composer2, "C(CircularArrowProgressIndicator)P(1,0:c#ui.graphics.Color)428@15876L61,430@16038L88,433@16148L74,436@16300L118,441@16456L443,434@16227L672:PullToRefresh.kt#djiw08");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(color) ? 32 : 16;
        }
        if (($dirty & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-569718810, $dirty, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:427)");
            }
            $composer2.startReplaceableGroup(-656076138);
            ComposerKt.sourceInformation($composer2, "CC(remember):PullToRefresh.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                Path $this$CircularArrowProgressIndicator_RPmYEkk_u24lambda_u244_u24lambda_u243 = AndroidPath_androidKt.Path();
                z = false;
                $this$CircularArrowProgressIndicator_RPmYEkk_u24lambda_u244_u24lambda_u243.mo3842setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m4231getEvenOddRgk1Os());
                value$iv = $this$CircularArrowProgressIndicator_RPmYEkk_u24lambda_u244_u24lambda_u243;
                $composer2.updateRememberedValue(value$iv);
            } else {
                z = false;
                value$iv = it$iv;
            }
            final Path path = (Path) value$iv;
            $composer2.endReplaceableGroup();
            $composer2.startReplaceableGroup(-656075976);
            ComposerKt.sourceInformation($composer2, "CC(remember):PullToRefresh.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$targetAlpha$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(function0.invoke().floatValue() < 1.0f ? 0.3f : 1.0f);
                    }
                });
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            State targetAlpha$delegate = (State) value$iv2;
            $composer2.endReplaceableGroup();
            final State alphaState = AnimateAsStateKt.animateFloatAsState(CircularArrowProgressIndicator_RPmYEkk$lambda$6(targetAlpha$delegate), AlphaTween, 0.0f, null, null, $composer2, 48, 28);
            Modifier.Companion companion = Modifier.INSTANCE;
            $composer2.startReplaceableGroup(-656075714);
            ComposerKt.sourceInformation($composer2, "CC(remember):PullToRefresh.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$1$1
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
                        SemanticsPropertiesKt.setProgressBarRangeInfo($this$semantics, new ProgressBarRangeInfo(function0.invoke().floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0));
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            $composer2.endReplaceableGroup();
            Modifier modifierM816size3ABfNKs = SizeKt.m816size3ABfNKs(SemanticsModifierKt.semantics(companion, true, (Function1) value$iv3), SpinnerSize);
            $composer2.startReplaceableGroup(-656075558);
            ComposerKt.sourceInformation($composer2, "CC(remember):PullToRefresh.kt#9igjgp");
            boolean invalid$iv2 = (($dirty & 14) == 4) | $composer2.changed(alphaState) | (($dirty & 112) == 32) | $composer2.changedInstance(path);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$2$1
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
                        ArrowValues values = PullToRefreshKt.ArrowValues(function0.invoke().floatValue());
                        float alpha = alphaState.getValue().floatValue();
                        float degrees$iv = values.getRotation();
                        long j = color;
                        Path path2 = path;
                        long pivot$iv = $this$Canvas.mo4497getCenterF1C5BW0();
                        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$Canvas.getDrawContext();
                        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo4423getSizeNHjbRc();
                        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
                        DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
                        $this$rotate_Rg1IO4c_u24lambda_u240$iv.mo4429rotateUv8p0NA(degrees$iv, pivot$iv);
                        float arcRadius = $this$Canvas.mo518toPx0680j_4(PullToRefreshKt.ArcRadius) + ($this$Canvas.mo518toPx0680j_4(PullToRefreshKt.StrokeWidth) / 2.0f);
                        Rect arcBounds = RectKt.m3747Rect3MmeM6k(androidx.compose.p000ui.geometry.SizeKt.m3787getCenteruvyYCjk($this$Canvas.mo4498getSizeNHjbRc()), arcRadius);
                        PullToRefreshKt.m2840drawCircularIndicatorKzyDr3Q($this$Canvas, j, alpha, values, arcBounds, PullToRefreshKt.StrokeWidth);
                        PullToRefreshKt.m2839drawArrowuDrxG_w($this$Canvas, path2, arcBounds, j, alpha, values, PullToRefreshKt.StrokeWidth);
                        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                        $this$withTransform_u24lambda_u246$iv$iv.mo4424setSizeuvyYCjk(previousSize$iv$iv);
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(modifierM816size3ABfNKs, (Function1) value$iv4, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$3
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
                    PullToRefreshKt.m2834CircularArrowProgressIndicatorRPmYEkk(function0, color, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final float CircularArrowProgressIndicator_RPmYEkk$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCircularIndicator-KzyDr3Q, reason: not valid java name */
    public static final void m2840drawCircularIndicatorKzyDr3Q(DrawScope $this$drawCircularIndicator_u2dKzyDr3Q, long color, float alpha, ArrowValues values, Rect arcBounds, float strokeWidth) {
        DrawScope.m4478drawArcyD3GUKo$default($this$drawCircularIndicator_u2dKzyDr3Q, color, values.getStartAngle(), values.getEndAngle() - values.getStartAngle(), false, arcBounds.m3743getTopLeftF1C5BW0(), arcBounds.m3741getSizeNHjbRc(), alpha, new Stroke($this$drawCircularIndicator_u2dKzyDr3Q.mo518toPx0680j_4(strokeWidth), 0.0f, StrokeCap.INSTANCE.m4301getButtKaPHkGw(), 0, null, 26, null), null, 0, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float progress) {
        float adjustedPercent = (Math.max(Math.min(1.0f, progress) - 0.4f, 0.0f) * 5) / 3;
        float overshootPercent = Math.abs(progress) - 1.0f;
        float linearTension = RangesKt.coerceIn(overshootPercent, 0.0f, 2.0f);
        float tensionPercent = linearTension - (((float) Math.pow(linearTension, 2)) / 4);
        float endTrim = MaxProgressArc * adjustedPercent;
        float rotation = (((0.4f * adjustedPercent) - 0.25f) + tensionPercent) * 0.5f;
        float f = 360;
        float startAngle = rotation * f;
        float endAngle = (rotation + endTrim) * f;
        float scale = Math.min(1.0f, adjustedPercent);
        return new ArrowValues(rotation, startAngle, endAngle, scale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawArrow-uDrxG_w, reason: not valid java name */
    public static final void m2839drawArrowuDrxG_w(DrawScope $this$drawArrow_u2duDrxG_w, Path arrow, Rect bounds, long color, float alpha, ArrowValues values, float strokeWidth) {
        arrow.reset();
        arrow.moveTo(0.0f, 0.0f);
        arrow.lineTo(($this$drawArrow_u2duDrxG_w.mo518toPx0680j_4(ArrowWidth) * values.getScale()) / 2, $this$drawArrow_u2duDrxG_w.mo518toPx0680j_4(ArrowHeight) * values.getScale());
        arrow.lineTo($this$drawArrow_u2duDrxG_w.mo518toPx0680j_4(ArrowWidth) * values.getScale(), 0.0f);
        float radius = Math.min(bounds.getWidth(), bounds.getHeight()) / 2.0f;
        float inset = ($this$drawArrow_u2duDrxG_w.mo518toPx0680j_4(ArrowWidth) * values.getScale()) / 2.0f;
        arrow.mo3844translatek4lQ0M(OffsetKt.Offset((Offset.m3708getXimpl(bounds.m3738getCenterF1C5BW0()) + radius) - inset, Offset.m3709getYimpl(bounds.m3738getCenterF1C5BW0()) - $this$drawArrow_u2duDrxG_w.mo518toPx0680j_4(strokeWidth)));
        float degrees$iv = values.getEndAngle() - $this$drawArrow_u2duDrxG_w.mo518toPx0680j_4(strokeWidth);
        long pivot$iv = $this$drawArrow_u2duDrxG_w.mo4497getCenterF1C5BW0();
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$drawArrow_u2duDrxG_w.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo4423getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
        $this$rotate_Rg1IO4c_u24lambda_u240$iv.mo4429rotateUv8p0NA(degrees$iv, pivot$iv);
        DrawScope.m4489drawPathLG529CI$default($this$drawArrow_u2duDrxG_w, arrow, color, alpha, new Stroke($this$drawArrow_u2duDrxG_w.mo518toPx0680j_4(strokeWidth), 0.0f, 0, 0, null, 30, null), null, 0, 48, null);
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv$iv.mo4424setSizeuvyYCjk(previousSize$iv$iv);
    }

    public static final float getSpinnerSize() {
        return SpinnerSize;
    }

    public static final float getSpinnerContainerSize() {
        return SpinnerContainerSize;
    }
}
