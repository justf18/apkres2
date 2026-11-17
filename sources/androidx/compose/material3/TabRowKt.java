package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.ClipKt;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.MultiContentMeasurePolicy;
import androidx.compose.p000ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.layout.SubcomposeLayoutKt;
import androidx.compose.p000ui.layout.SubcomposeMeasureScope;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TabRow.kt */
@Metadata(m164d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a¤\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0080\u0001\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u009a\u0001\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a \u0001\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2,\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0006\u0010\f\u001a\u00020\rH\u0003ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a¤\u0001\u0010*\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001e\u001a\u0080\u0001\u0010,\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010#\u001a\u0090\u0001\u0010.\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010#\u001an\u00100\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a~\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2,\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00102\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, m165d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "PrimaryScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "tabPositions", "Landroidx/compose/runtime/Composable;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PrimaryTabRow", "Landroidx/compose/material3/TabIndicatorScope;", "Lkotlin/ExtensionFunctionType;", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowImp", "ScrollableTabRowImp-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-qhFBPw4", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "TabRow", "TabRow-pAZo6Ak", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "TabRowWithSubcomposeImpl-DTcfvLk", "material3_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = C1956Dp.m6297constructorimpl(90);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* renamed from: PrimaryTabRow-pAZo6Ak, reason: not valid java name */
    public static final void m2569PrimaryTabRowpAZo6Ak(final int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long containerColor2;
        long contentColor2;
        Function3 indicator;
        Function2 function23;
        Modifier modifier3;
        Function3 indicator2;
        Function2 divider;
        int i2;
        long containerColor3;
        long contentColor3;
        Composer $composer2;
        final long containerColor4;
        final Modifier modifier4;
        final long contentColor4;
        final Function3 indicator3;
        final Function2 divider2;
        Composer $composer3 = $composer.startRestartGroup(-1884787284);
        ComposerKt.sourceInformation($composer3, "C(PrimaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)150@7456L21,151@7520L19,166@7964L76:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(selectedTabIndex) ? 4 : 2;
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
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                containerColor2 = containerColor;
                int i4 = $composer3.changed(containerColor2) ? 256 : 128;
                $dirty |= i4;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer3.changed(contentColor2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i5;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            indicator = function3;
        } else if (($changed & 24576) == 0) {
            indicator = function3;
            $dirty |= $composer3.changedInstance(indicator) ? 16384 : 8192;
        } else {
            indicator = function3;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            function23 = function2;
        } else if ((196608 & $changed) == 0) {
            function23 = function2;
            $dirty |= $composer3.changedInstance(function23) ? 131072 : 65536;
        } else {
            function23 = function2;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            containerColor4 = containerColor2;
            indicator3 = indicator;
            $composer2 = $composer3;
            modifier4 = modifier2;
            contentColor4 = contentColor2;
            divider2 = function23;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer3, 6);
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer3, 6);
                    $dirty &= -7169;
                }
                if (i6 != 0) {
                    indicator = ComposableLambdaKt.composableLambda($composer3, -2021049253, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryTabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer, Integer num) {
                            invoke(tabIndicatorScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(TabIndicatorScope $this$null, Composer $composer4, int $changed2) {
                            ComposerKt.sourceInformation($composer4, "C153@7624L204:TabRow.kt#uh7d8r");
                            int $dirty2 = $changed2;
                            if (($changed2 & 6) == 0) {
                                $dirty2 |= ($changed2 & 8) == 0 ? $composer4.changed($this$null) : $composer4.changedInstance($this$null) ? 4 : 2;
                            }
                            int $dirty3 = $dirty2;
                            if (($dirty3 & 19) != 18 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2021049253, $dirty3, -1, "androidx.compose.material3.PrimaryTabRow.<anonymous> (TabRow.kt:153)");
                                }
                                TabRowDefaults.INSTANCE.m2565PrimaryIndicator10LGxhE($this$null.tabIndicatorOffset(Modifier.INSTANCE, selectedTabIndex, true), C1956Dp.INSTANCE.m6317getUnspecifiedD9Ej5fM(), 0.0f, 0L, null, $composer4, 196656, 28);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    });
                }
                if (i7 != 0) {
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m1978getLambda1$material3_release();
                    modifier3 = modifier2;
                    contentColor3 = contentColor2;
                    indicator2 = indicator;
                    i2 = -1884787284;
                    containerColor3 = containerColor2;
                } else {
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1884787284;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1884787284;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                } else {
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1884787284;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:165)");
            }
            $composer2 = $composer3;
            m2575TabRowImplDTcfvLk(modifier3, containerColor3, contentColor3, indicator2, divider, function22, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            containerColor4 = containerColor3;
            modifier4 = modifier3;
            contentColor4 = contentColor3;
            indicator3 = indicator2;
            divider2 = divider;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryTabRow$2
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
                    TabRowKt.m2569PrimaryTabRowpAZo6Ak(selectedTabIndex, modifier4, containerColor4, contentColor4, indicator3, divider2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: SecondaryTabRow-pAZo6Ak, reason: not valid java name */
    public static final void m2573SecondaryTabRowpAZo6Ak(final int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long containerColor2;
        long contentColor2;
        Function3 indicator;
        Function2 function23;
        Modifier modifier3;
        Function3 indicator2;
        Function2 divider;
        int i2;
        long containerColor3;
        long contentColor3;
        Composer $composer2;
        final long containerColor4;
        final Modifier modifier4;
        final long contentColor4;
        final Function3 indicator3;
        final Function2 divider2;
        Composer $composer3 = $composer.startRestartGroup(-1909540706);
        ComposerKt.sourceInformation($composer3, "C(SecondaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)207@10434L23,208@10500L21,219@10867L76:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(selectedTabIndex) ? 4 : 2;
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
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                containerColor2 = containerColor;
                int i4 = $composer3.changed(containerColor2) ? 256 : 128;
                $dirty |= i4;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer3.changed(contentColor2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i5;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            indicator = function3;
        } else if (($changed & 24576) == 0) {
            indicator = function3;
            $dirty |= $composer3.changedInstance(indicator) ? 16384 : 8192;
        } else {
            indicator = function3;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            function23 = function2;
        } else if ((196608 & $changed) == 0) {
            function23 = function2;
            $dirty |= $composer3.changedInstance(function23) ? 131072 : 65536;
        } else {
            function23 = function2;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            containerColor4 = containerColor2;
            indicator3 = indicator;
            $composer2 = $composer3;
            modifier4 = modifier2;
            contentColor4 = contentColor2;
            divider2 = function23;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getSecondaryContainerColor($composer3, 6);
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getSecondaryContentColor($composer3, 6);
                    $dirty &= -7169;
                }
                if (i6 != 0) {
                    indicator = ComposableLambdaKt.composableLambda($composer3, 286693261, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryTabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer, Integer num) {
                            invoke(tabIndicatorScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(TabIndicatorScope $this$null, Composer $composer4, int $changed2) {
                            ComposerKt.sourceInformation($composer4, "C210@10618L113:TabRow.kt#uh7d8r");
                            int $dirty2 = $changed2;
                            if (($changed2 & 6) == 0) {
                                $dirty2 |= ($changed2 & 8) == 0 ? $composer4.changed($this$null) : $composer4.changedInstance($this$null) ? 4 : 2;
                            }
                            if (($dirty2 & 19) != 18 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(286693261, $dirty2, -1, "androidx.compose.material3.SecondaryTabRow.<anonymous> (TabRow.kt:210)");
                                }
                                TabRowDefaults.INSTANCE.m2566SecondaryIndicator9IZ8Weo($this$null.tabIndicatorOffset(Modifier.INSTANCE, selectedTabIndex, false), 0.0f, 0L, $composer4, 3072, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    });
                }
                if (i7 != 0) {
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m1979getLambda2$material3_release();
                    modifier3 = modifier2;
                    contentColor3 = contentColor2;
                    indicator2 = indicator;
                    i2 = -1909540706;
                    containerColor3 = containerColor2;
                } else {
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1909540706;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1909540706;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                } else {
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1909540706;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:218)");
            }
            $composer2 = $composer3;
            m2575TabRowImplDTcfvLk(modifier3, containerColor3, contentColor3, indicator2, divider, function22, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            containerColor4 = containerColor3;
            modifier4 = modifier3;
            contentColor4 = contentColor3;
            indicator3 = indicator2;
            divider2 = divider;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryTabRow$2
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
                    TabRowKt.m2573SecondaryTabRowpAZo6Ak(selectedTabIndex, modifier4, containerColor4, contentColor4, indicator3, divider2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    public static final void m2574TabRowpAZo6Ak(final int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long containerColor2;
        long contentColor2;
        Function3 indicator;
        Function2 function23;
        Modifier modifier3;
        Function3 indicator2;
        Function2 divider;
        int i2;
        long containerColor3;
        long contentColor3;
        Composer $composer2;
        final long containerColor4;
        final Modifier modifier4;
        final long contentColor4;
        final Function3 indicator3;
        final Function2 divider2;
        Composer $composer3 = $composer.startRestartGroup(-1199178586);
        ComposerKt.sourceInformation($composer3, "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)299@15165L21,300@15229L19,313@15685L90:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(selectedTabIndex) ? 4 : 2;
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
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                containerColor2 = containerColor;
                int i4 = $composer3.changed(containerColor2) ? 256 : 128;
                $dirty |= i4;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= i4;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer3.changed(contentColor2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i5;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            indicator = function3;
        } else if (($changed & 24576) == 0) {
            indicator = function3;
            $dirty |= $composer3.changedInstance(indicator) ? 16384 : 8192;
        } else {
            indicator = function3;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            function23 = function2;
        } else if ((196608 & $changed) == 0) {
            function23 = function2;
            $dirty |= $composer3.changedInstance(function23) ? 131072 : 65536;
        } else {
            function23 = function2;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            containerColor4 = containerColor2;
            indicator3 = indicator;
            $composer2 = $composer3;
            modifier4 = modifier2;
            contentColor4 = contentColor2;
            divider2 = function23;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer3, 6);
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer3, 6);
                    $dirty &= -7169;
                }
                if (i6 != 0) {
                    indicator = ComposableLambdaKt.composableLambda($composer3, -2052073983, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
                            invoke((List<TabPosition>) list, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(List<TabPosition> list, Composer $composer4, int $changed2) {
                            ComposerKt.sourceInformation($composer4, "C303@15430L109:TabRow.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2052073983, $changed2, -1, "androidx.compose.material3.TabRow.<anonymous> (TabRow.kt:302)");
                            }
                            if (selectedTabIndex < list.size()) {
                                TabRowDefaults.INSTANCE.m2566SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(selectedTabIndex)), 0.0f, 0L, $composer4, 3072, 6);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                }
                if (i7 != 0) {
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m1980getLambda3$material3_release();
                    modifier3 = modifier2;
                    contentColor3 = contentColor2;
                    indicator2 = indicator;
                    i2 = -1199178586;
                    containerColor3 = containerColor2;
                } else {
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1199178586;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1199178586;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                } else {
                    modifier3 = modifier2;
                    indicator2 = indicator;
                    divider = function23;
                    i2 = -1199178586;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.TabRow (TabRow.kt:312)");
            }
            $composer2 = $composer3;
            m2576TabRowWithSubcomposeImplDTcfvLk(modifier3, containerColor3, contentColor3, indicator2, divider, function22, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            containerColor4 = containerColor3;
            modifier4 = modifier3;
            contentColor4 = contentColor3;
            indicator3 = indicator2;
            divider2 = divider;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2
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
                    TabRowKt.m2574TabRowpAZo6Ak(selectedTabIndex, modifier4, containerColor4, contentColor4, indicator3, divider2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabRowImpl-DTcfvLk, reason: not valid java name */
    public static final void m2575TabRowImplDTcfvLk(Modifier modifier, final long containerColor, final long contentColor, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Modifier modifier2;
        long j;
        long j2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1757425411);
        ComposerKt.sourceInformation($composer3, "C(TabRowImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)366@17359L4073:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            j = containerColor;
            $dirty |= $composer3.changed(j) ? 32 : 16;
        } else {
            j = containerColor;
        }
        if (($changed & 384) == 0) {
            j2 = contentColor;
            $dirty |= $composer3.changed(j2) ? 256 : 128;
        } else {
            j2 = contentColor;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 131072 : 65536;
        }
        if ((74899 & $dirty) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1757425411, $dirty, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:365)");
            }
            $composer2 = $composer3;
            SurfaceKt.m2519SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda($composer3, -65106680, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1
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
                    Object value$iv;
                    MultiContentMeasurePolicy value$iv2;
                    Object value$iv$iv$iv;
                    ComposerKt.sourceInformation($composer4, "C371@17511L1344,416@19062L2364,409@18865L2561:TabRow.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-65106680, $changed2, -1, "androidx.compose.material3.TabRowImpl.<anonymous> (TabRow.kt:371)");
                        }
                        $composer4.startReplaceableGroup(474062752);
                        ComposerKt.sourceInformation($composer4, "CC(remember):TabRow.kt#9igjgp");
                        Object it$iv = $composer4.rememberedValue();
                        if (it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new TabRowKt$TabRowImpl$1$scope$1$1();
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        final TabRowKt$TabRowImpl$1$scope$1$1 scope = (TabRowKt$TabRowImpl$1$scope$1$1) value$iv;
                        $composer4.endReplaceableGroup();
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        final Function3<TabIndicatorScope, Composer, Integer, Unit> function32 = function3;
                        List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function22, function2, ComposableLambdaKt.composableLambda($composer4, 1236693605, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1.1
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C414@19023L11:TabRow.kt#uh7d8r");
                                if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1236693605, $changed3, -1, "androidx.compose.material3.TabRowImpl.<anonymous>.<anonymous> (TabRow.kt:414)");
                                }
                                function32.invoke(scope, $composer5, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        })});
                        $composer4.startReplaceableGroup(474064303);
                        ComposerKt.sourceInformation($composer4, "CC(remember):TabRow.kt#9igjgp");
                        Object it$iv2 = $composer4.rememberedValue();
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1
                                @Override // androidx.compose.p000ui.layout.MultiContentMeasurePolicy
                                /* renamed from: measure-3p2s80s */
                                public final MeasureResult mo2188measure3p2s80s(MeasureScope $this$Layout, List<? extends List<? extends Measurable>> list, long constraints) {
                                    List tabMeasurables = list.get(0);
                                    List dividerMeasurables = list.get(1);
                                    List indicatorMeasurables = list.get(2);
                                    int tabRowWidth = Constraints.m6253getMaxWidthimpl(constraints);
                                    int tabCount = tabMeasurables.size();
                                    final Ref.IntRef tabWidth = new Ref.IntRef();
                                    if (tabCount > 0) {
                                        tabWidth.element = tabRowWidth / tabCount;
                                    }
                                    Object initial$iv = 0;
                                    Object accumulator$iv = initial$iv;
                                    int index$iv$iv = 0;
                                    int size = tabMeasurables.size();
                                    while (index$iv$iv < size) {
                                        Object item$iv$iv = tabMeasurables.get(index$iv$iv);
                                        Measurable curr = (Measurable) item$iv$iv;
                                        int tabRowWidth2 = tabRowWidth;
                                        int max = ((Number) accumulator$iv).intValue();
                                        accumulator$iv = Integer.valueOf(Math.max(curr.maxIntrinsicHeight(tabWidth.element), max));
                                        index$iv$iv++;
                                        tabRowWidth = tabRowWidth2;
                                        initial$iv = initial$iv;
                                    }
                                    int tabRowWidth3 = tabRowWidth;
                                    int tabRowHeight = ((Number) accumulator$iv).intValue();
                                    TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = scope;
                                    ArrayList arrayList = new ArrayList(tabCount);
                                    int i = 0;
                                    while (i < tabCount) {
                                        int index = i;
                                        float contentWidth = $this$Layout.mo515toDpu2uoSUM(Math.min(tabMeasurables.get(index).maxIntrinsicWidth(tabRowHeight), tabWidth.element));
                                        float arg0$iv = TabKt.getHorizontalTextPadding();
                                        float other$iv = C1956Dp.m6297constructorimpl(2 * arg0$iv);
                                        C1956Dp c1956DpM6295boximpl = C1956Dp.m6295boximpl(C1956Dp.m6297constructorimpl(contentWidth - other$iv));
                                        float contentWidth2 = 24;
                                        float indicatorWidth = ((C1956Dp) ComparisonsKt.maxOf(c1956DpM6295boximpl, C1956Dp.m6295boximpl(C1956Dp.m6297constructorimpl(contentWidth2)))).m6311unboximpl();
                                        float arg0$iv2 = $this$Layout.mo515toDpu2uoSUM(tabWidth.element);
                                        arrayList.add(new TabPosition(C1956Dp.m6297constructorimpl(index * arg0$iv2), $this$Layout.mo515toDpu2uoSUM(tabWidth.element), indicatorWidth, null));
                                        i++;
                                        tabRowHeight = tabRowHeight;
                                    }
                                    int tabRowHeight2 = tabRowHeight;
                                    tabRowKt$TabRowImpl$1$scope$1$1.setTabPositions(arrayList);
                                    List $this$fastMap$iv = tabMeasurables;
                                    int $i$f$fastMap = 0;
                                    ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
                                    int index$iv$iv2 = 0;
                                    int size2 = $this$fastMap$iv.size();
                                    while (index$iv$iv2 < size2) {
                                        Object item$iv$iv2 = $this$fastMap$iv.get(index$iv$iv2);
                                        List $this$fastMap$iv2 = $this$fastMap$iv;
                                        Measurable it = (Measurable) item$iv$iv2;
                                        int $i$f$fastMap2 = $i$f$fastMap;
                                        int $i$f$fastMap3 = tabWidth.element;
                                        target$iv.add(it.mo5219measureBRTryo0(Constraints.m6243copyZbe2FdA(constraints, $i$f$fastMap3, tabWidth.element, tabRowHeight2, tabRowHeight2)));
                                        index$iv$iv2++;
                                        $this$fastMap$iv = $this$fastMap$iv2;
                                        $i$f$fastMap = $i$f$fastMap2;
                                        target$iv = target$iv;
                                    }
                                    final ArrayList tabPlaceables = target$iv;
                                    List $this$fastMap$iv3 = dividerMeasurables;
                                    int $i$f$fastMap4 = 0;
                                    ArrayList target$iv2 = new ArrayList($this$fastMap$iv3.size());
                                    List $this$fastForEach$iv$iv = $this$fastMap$iv3;
                                    int index$iv$iv3 = 0;
                                    int size3 = $this$fastForEach$iv$iv.size();
                                    while (index$iv$iv3 < size3) {
                                        Object item$iv$iv3 = $this$fastForEach$iv$iv.get(index$iv$iv3);
                                        int $i$f$fastMap5 = $i$f$fastMap4;
                                        Measurable it2 = (Measurable) item$iv$iv3;
                                        target$iv2.add(it2.mo5219measureBRTryo0(Constraints.m6243copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(constraints) : 0)));
                                        index$iv$iv3++;
                                        $this$fastMap$iv3 = $this$fastMap$iv3;
                                        $i$f$fastMap4 = $i$f$fastMap5;
                                        target$iv2 = target$iv2;
                                        $this$fastForEach$iv$iv = $this$fastForEach$iv$iv;
                                    }
                                    final ArrayList dividerPlaceables = target$iv2;
                                    List $this$fastMap$iv4 = indicatorMeasurables;
                                    int $i$f$fastMap6 = 0;
                                    ArrayList target$iv3 = new ArrayList($this$fastMap$iv4.size());
                                    List $this$fastForEach$iv$iv2 = $this$fastMap$iv4;
                                    int index$iv$iv4 = 0;
                                    int size4 = $this$fastForEach$iv$iv2.size();
                                    while (index$iv$iv4 < size4) {
                                        Object item$iv$iv4 = $this$fastForEach$iv$iv2.get(index$iv$iv4);
                                        int $i$f$fastMap7 = $i$f$fastMap6;
                                        Measurable it3 = (Measurable) item$iv$iv4;
                                        int tabRowHeight3 = tabRowHeight2;
                                        tabRowHeight2 = tabRowHeight3;
                                        target$iv3.add(it3.mo5219measureBRTryo0(Constraints.m6243copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(constraints) : tabWidth.element, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(constraints) : tabWidth.element, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(constraints) : tabRowHeight3)));
                                        index$iv$iv4++;
                                        $this$fastMap$iv4 = $this$fastMap$iv4;
                                        $i$f$fastMap6 = $i$f$fastMap7;
                                        target$iv3 = target$iv3;
                                        $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv2;
                                    }
                                    final ArrayList indicatorPlaceables = target$iv3;
                                    final int tabRowHeight4 = tabRowHeight2;
                                    return MeasureScope.layout$default($this$Layout, tabRowWidth3, tabRowHeight2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1.2
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
                                            List $this$fastForEachIndexed$iv = tabPlaceables;
                                            Ref.IntRef intRef = tabWidth;
                                            int size5 = $this$fastForEachIndexed$iv.size();
                                            for (int index$iv = 0; index$iv < size5; index$iv++) {
                                                Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
                                                int index2 = index$iv;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, (Placeable) item$iv, index2 * intRef.element, 0, 0.0f, 4, null);
                                            }
                                            List $this$fastForEachIndexed$iv2 = dividerPlaceables;
                                            int i2 = tabRowHeight4;
                                            int size6 = $this$fastForEachIndexed$iv2.size();
                                            for (int index$iv2 = 0; index$iv2 < size6; index$iv2++) {
                                                Object item$iv2 = $this$fastForEachIndexed$iv2.get(index$iv2);
                                                Placeable placeable = (Placeable) item$iv2;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, i2 - placeable.getHeight(), 0.0f, 4, null);
                                            }
                                            List $this$fastForEach$iv = indicatorPlaceables;
                                            int i3 = tabRowHeight4;
                                            int size7 = $this$fastForEach$iv.size();
                                            for (int index$iv3 = 0; index$iv3 < size7; index$iv3++) {
                                                Object item$iv3 = $this$fastForEach$iv.get(index$iv3);
                                                Placeable it4 = (Placeable) item$iv3;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, it4, 0, i3 - it4.getHeight(), 0.0f, 4, null);
                                            }
                                        }
                                    }, 4, null);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) value$iv2;
                        $composer4.endReplaceableGroup();
                        $composer4.startReplaceableGroup(1399185516);
                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)171@6874L62,168@6760L182:Layout.kt#80mrfh");
                        Function2 content$iv$iv = LayoutKt.combineAsVirtualLayouts(listListOf);
                        int i = (432 >> 6) & 14;
                        $composer4.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation($composer4, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean invalid$iv$iv$iv = $composer4.changed(multiContentMeasurePolicy);
                        Object it$iv$iv$iv = $composer4.rememberedValue();
                        if (invalid$iv$iv$iv || it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv$iv = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                            $composer4.updateRememberedValue(value$iv$iv$iv);
                        } else {
                            value$iv$iv$iv = it$iv$iv$iv;
                        }
                        $composer4.endReplaceableGroup();
                        MeasurePolicy measurePolicy$iv$iv = (MeasurePolicy) value$iv$iv$iv;
                        int $changed$iv$iv = 432 & 112;
                        $composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifierFillMaxWidth$default);
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
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        $composer4.startReplaceableGroup(2058660585);
                        content$iv$iv.invoke($composer4, Integer.valueOf(($changed$iv$iv$iv >> 9) & 14));
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
            }), $composer2, (($dirty << 3) & 896) | 12582912 | (($dirty << 3) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$2
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
                    TabRowKt.m2575TabRowImplDTcfvLk(modifier3, containerColor, contentColor, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabRowWithSubcomposeImpl-DTcfvLk, reason: not valid java name */
    public static final void m2576TabRowWithSubcomposeImplDTcfvLk(Modifier modifier, final long containerColor, final long contentColor, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Modifier modifier2;
        long j;
        long j2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-160898917);
        ComposerKt.sourceInformation($composer3, "C(TabRowWithSubcomposeImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)583@24853L2206:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            j = containerColor;
            $dirty |= $composer3.changed(j) ? 32 : 16;
        } else {
            j = containerColor;
        }
        if (($changed & 384) == 0) {
            j2 = contentColor;
            $dirty |= $composer3.changed(j2) ? 256 : 128;
        } else {
            j2 = contentColor;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 131072 : 65536;
        }
        if ((74899 & $dirty) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160898917, $dirty, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:582)");
            }
            $composer2 = $composer3;
            SurfaceKt.m2519SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda($composer3, -1617702432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1
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
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C588@25035L2018,588@24993L2060:TabRow.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1617702432, $changed2, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:588)");
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    $composer4.startReplaceableGroup(-1028159188);
                    ComposerKt.sourceInformation($composer4, "CC(remember):TabRow.kt#9igjgp");
                    boolean invalid$iv = $composer4.changed(function22) | $composer4.changed(function2) | $composer4.changed(function3);
                    final Function2<Composer, Integer, Unit> function23 = function22;
                    final Function2<Composer, Integer, Unit> function24 = function2;
                    final Function3<List<TabPosition>, Composer, Integer, Unit> function32 = function3;
                    Object it$iv = $composer4.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m2582invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2582invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, final long constraints) {
                                int tabRowWidth = Constraints.m6253getMaxWidthimpl(constraints);
                                List tabMeasurables = $this$SubcomposeLayout.subcompose(TabSlots.Tabs, function23);
                                int tabCount = tabMeasurables.size();
                                final Ref.IntRef tabWidth = new Ref.IntRef();
                                if (tabCount > 0) {
                                    tabWidth.element = tabRowWidth / tabCount;
                                }
                                Object accumulator$iv = 0;
                                int index$iv$iv = 0;
                                int size = tabMeasurables.size();
                                while (index$iv$iv < size) {
                                    Object item$iv$iv = tabMeasurables.get(index$iv$iv);
                                    Measurable curr = (Measurable) item$iv$iv;
                                    int max = ((Number) accumulator$iv).intValue();
                                    accumulator$iv = Integer.valueOf(Math.max(curr.maxIntrinsicHeight(tabWidth.element), max));
                                    index$iv$iv++;
                                    tabRowWidth = tabRowWidth;
                                }
                                final int tabRowWidth2 = tabRowWidth;
                                int tabRowHeight = ((Number) accumulator$iv).intValue();
                                List $this$fastMap$iv = tabMeasurables;
                                int $i$f$fastMap = 0;
                                List target$iv = new ArrayList($this$fastMap$iv.size());
                                int index$iv$iv2 = 0;
                                int size2 = $this$fastMap$iv.size();
                                while (index$iv$iv2 < size2) {
                                    Object item$iv$iv2 = $this$fastMap$iv.get(index$iv$iv2);
                                    Measurable it = (Measurable) item$iv$iv2;
                                    int tabRowHeight2 = tabRowHeight;
                                    int tabRowHeight3 = tabWidth.element;
                                    target$iv.add(it.mo5219measureBRTryo0(Constraints.m6243copyZbe2FdA(constraints, tabRowHeight3, tabWidth.element, tabRowHeight2, tabRowHeight2)));
                                    index$iv$iv2++;
                                    tabRowHeight = tabRowHeight2;
                                    size2 = size2;
                                    $this$fastMap$iv = $this$fastMap$iv;
                                    $i$f$fastMap = $i$f$fastMap;
                                }
                                final int tabRowHeight4 = tabRowHeight;
                                final List tabPlaceables = target$iv;
                                ArrayList arrayList = new ArrayList(tabCount);
                                int i = 0;
                                while (i < tabCount) {
                                    int index = i;
                                    float contentWidth = $this$SubcomposeLayout.mo515toDpu2uoSUM(Math.min(tabMeasurables.get(index).maxIntrinsicWidth(tabRowHeight4), tabWidth.element));
                                    float arg0$iv = TabKt.getHorizontalTextPadding();
                                    float other$iv = C1956Dp.m6297constructorimpl(contentWidth - C1956Dp.m6297constructorimpl(2 * arg0$iv));
                                    float indicatorWidth = ((C1956Dp) ComparisonsKt.maxOf(C1956Dp.m6295boximpl(other$iv), C1956Dp.m6295boximpl(C1956Dp.m6297constructorimpl(24)))).m6311unboximpl();
                                    float arg0$iv2 = $this$SubcomposeLayout.mo515toDpu2uoSUM(tabWidth.element);
                                    arrayList.add(new TabPosition(C1956Dp.m6297constructorimpl(index * arg0$iv2), $this$SubcomposeLayout.mo515toDpu2uoSUM(tabWidth.element), indicatorWidth, null));
                                    i++;
                                    tabPlaceables = tabPlaceables;
                                }
                                final ArrayList tabPositions = arrayList;
                                final Function2<Composer, Integer, Unit> function25 = function24;
                                final Function3<List<TabPosition>, Composer, Integer, Unit> function33 = function32;
                                return MeasureScope.layout$default($this$SubcomposeLayout, tabRowWidth2, tabRowHeight4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1.1
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
                                        List $this$fastForEachIndexed$iv = tabPlaceables;
                                        Ref.IntRef intRef = tabWidth;
                                        int size3 = $this$fastForEachIndexed$iv.size();
                                        for (int index$iv = 0; index$iv < size3; index$iv++) {
                                            Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
                                            int index2 = index$iv;
                                            Placeable.PlacementScope.placeRelative$default($this$layout, (Placeable) item$iv, index2 * intRef.element, 0, 0.0f, 4, null);
                                        }
                                        List $this$fastForEach$iv = $this$SubcomposeLayout.subcompose(TabSlots.Divider, function25);
                                        long j3 = constraints;
                                        int i2 = tabRowHeight4;
                                        int size4 = $this$fastForEach$iv.size();
                                        for (int index$iv2 = 0; index$iv2 < size4; index$iv2++) {
                                            Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
                                            Measurable it2 = (Measurable) item$iv2;
                                            Placeable placeable = it2.mo5219measureBRTryo0(Constraints.m6243copyZbe2FdA(j3, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(j3) : 0, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(j3) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(j3) : 0, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(j3) : 0));
                                            Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, i2 - placeable.getHeight(), 0.0f, 4, null);
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                                        final List<TabPosition> list = tabPositions;
                                        List $this$fastForEach$iv2 = subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1621992604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.TabRowWithSubcomposeImpl.1.1.1.1.3
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

                                            public final void invoke(Composer $composer5, int $changed3) {
                                                ComposerKt.sourceInformation($composer5, "C631@26859L23:TabRow.kt#uh7d8r");
                                                if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                                    $composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1621992604, $changed3, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:631)");
                                                }
                                                function34.invoke(list, $composer5, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i3 = tabRowWidth2;
                                        int i4 = tabRowHeight4;
                                        int size5 = $this$fastForEach$iv2.size();
                                        for (int index$iv3 = 0; index$iv3 < size5; index$iv3++) {
                                            Object item$iv3 = $this$fastForEach$iv2.get(index$iv3);
                                            Measurable it3 = (Measurable) item$iv3;
                                            Placeable.PlacementScope.placeRelative$default($this$layout, it3.mo5219measureBRTryo0(Constraints.INSTANCE.m6261fixedJhjzzOo(i3, i4)), 0, 0, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(modifierFillMaxWidth$default, (Function2) value$iv, $composer4, 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer2, (($dirty << 3) & 896) | 12582912 | (($dirty << 3) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$2
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
                    TabRowKt.m2576TabRowWithSubcomposeImplDTcfvLk(modifier3, containerColor, contentColor, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* renamed from: PrimaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    public static final void m2568PrimaryScrollableTabRowqhFBPw4(final int selectedTabIndex, Modifier modifier, ScrollState scrollState, long containerColor, long contentColor, float edgePadding, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ScrollState scrollState2;
        long containerColor2;
        long contentColor2;
        float edgePadding2;
        int i2;
        Function3 indicator;
        ScrollState scrollState3;
        Function2 divider;
        int $dirty;
        final Modifier modifier3;
        long containerColor3;
        long contentColor3;
        float edgePadding3;
        Composer $composer2;
        final float edgePadding4;
        final long contentColor4;
        final long containerColor4;
        final ScrollState scrollState4;
        final Function2 divider2;
        final Function3 indicator2;
        Composer $composer3 = $composer.startRestartGroup(-1763241113);
        ComposerKt.sourceInformation($composer3, "C(PrimaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)677@29409L21,678@29475L21,679@29539L19,695@30196L327:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                scrollState2 = scrollState;
                int i4 = $composer3.changed(scrollState2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                scrollState2 = scrollState;
            }
            $dirty2 |= i4;
        } else {
            scrollState2 = scrollState;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i5 = $composer3.changed(containerColor2) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i5;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer3.changed(contentColor2) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            edgePadding2 = edgePadding;
        } else if ((196608 & $changed) == 0) {
            edgePadding2 = edgePadding;
            $dirty2 |= $composer3.changed(edgePadding2) ? 131072 : 65536;
        } else {
            edgePadding2 = edgePadding;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function3) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty2 |= 12582912;
            i2 = i9;
        } else if (($changed & 12582912) == 0) {
            i2 = i9;
            $dirty2 |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        } else {
            i2 = i9;
        }
        if ((i & 256) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            divider2 = function2;
            modifier3 = modifier2;
            scrollState4 = scrollState2;
            containerColor4 = containerColor2;
            contentColor4 = contentColor2;
            $composer2 = $composer3;
            edgePadding4 = edgePadding2;
            indicator2 = function3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                    scrollState2 = ScrollKt.rememberScrollState(0, $composer3, 0, 1);
                }
                if ((i & 8) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer3, 6);
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer3, 6);
                    $dirty2 &= -57345;
                }
                if (i7 != 0) {
                    edgePadding2 = TabRowDefaults.INSTANCE.m2567getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                indicator = i8 != 0 ? ComposableLambdaKt.composableLambda($composer3, 438091970, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
                        invoke((List<TabPosition>) list, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(List<TabPosition> list, Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C683@29809L75,684@29912L138:TabRow.kt#uh7d8r");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(438091970, $changed2, -1, "androidx.compose.material3.PrimaryScrollableTabRow.<anonymous> (TabRow.kt:682)");
                        }
                        if (selectedTabIndex < list.size()) {
                            State width$delegate = AnimateAsStateKt.m321animateDpAsStateAjpBEmI(list.get(selectedTabIndex).getContentWidth(), null, null, null, $composer4, 0, 14);
                            TabRowDefaults.INSTANCE.m2565PrimaryIndicator10LGxhE(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(selectedTabIndex)), invoke$lambda$0(width$delegate), 0.0f, 0L, null, $composer4, ProfileVerifier.CompilationStatus.f249xf2722a21, 28);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }

                    private static final float invoke$lambda$0(State<C1956Dp> state) {
                        Object thisObj$iv = state.getValue();
                        return ((C1956Dp) thisObj$iv).m6311unboximpl();
                    }
                }) : function3;
                if (i2 != 0) {
                    scrollState3 = scrollState2;
                    long j = contentColor2;
                    $dirty = $dirty2;
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m1981getLambda4$material3_release();
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = j;
                    edgePadding3 = edgePadding2;
                } else {
                    scrollState3 = scrollState2;
                    long j2 = contentColor2;
                    divider = function2;
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = j2;
                    edgePadding3 = edgePadding2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    int i10 = $dirty2 & (-57345);
                    modifier3 = modifier2;
                    scrollState3 = scrollState2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    divider = function2;
                    $dirty = i10;
                    indicator = function3;
                } else {
                    indicator = function3;
                    scrollState3 = scrollState2;
                    long j3 = contentColor2;
                    divider = function2;
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = j3;
                    edgePadding3 = edgePadding2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1763241113, $dirty, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:694)");
            }
            m2571ScrollableTabRowImpqhFBPw4(selectedTabIndex, indicator, modifier3, containerColor3, contentColor3, edgePadding3, divider, function22, scrollState3, $composer3, (($dirty << 18) & 234881024) | ($dirty & 14) | (($dirty >> 15) & 112) | (($dirty << 3) & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (($dirty >> 3) & 3670016) | (29360128 & ($dirty >> 3)), 0);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            Function2 function23 = divider;
            edgePadding4 = edgePadding3;
            contentColor4 = contentColor3;
            containerColor4 = containerColor3;
            scrollState4 = scrollState3;
            divider2 = function23;
            indicator2 = indicator;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$2
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

                public final void invoke(Composer composer, int i11) {
                    TabRowKt.m2568PrimaryScrollableTabRowqhFBPw4(selectedTabIndex, modifier3, scrollState4, containerColor4, contentColor4, edgePadding4, indicator2, divider2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: SecondaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    public static final void m2572SecondaryScrollableTabRowqhFBPw4(final int selectedTabIndex, Modifier modifier, ScrollState scrollState, long containerColor, long contentColor, float edgePadding, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ScrollState scrollState2;
        long containerColor2;
        long contentColor2;
        float edgePadding2;
        int i2;
        Function3 indicator;
        ScrollState scrollState3;
        Function2 divider;
        int $dirty;
        final Modifier modifier3;
        long containerColor3;
        long contentColor3;
        float edgePadding3;
        Composer $composer2;
        final float edgePadding4;
        final long contentColor4;
        final long containerColor4;
        final ScrollState scrollState4;
        final Function2 divider2;
        final Function3 indicator2;
        Composer $composer3 = $composer.startRestartGroup(1821940917);
        ComposerKt.sourceInformation($composer3, "C(SecondaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)749@33144L21,750@33210L23,751@33276L21,763@33731L326:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                scrollState2 = scrollState;
                int i4 = $composer3.changed(scrollState2) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                scrollState2 = scrollState;
            }
            $dirty2 |= i4;
        } else {
            scrollState2 = scrollState;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i5 = $composer3.changed(containerColor2) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i5;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer3.changed(contentColor2) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            edgePadding2 = edgePadding;
        } else if ((196608 & $changed) == 0) {
            edgePadding2 = edgePadding;
            $dirty2 |= $composer3.changed(edgePadding2) ? 131072 : 65536;
        } else {
            edgePadding2 = edgePadding;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function3) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty2 |= 12582912;
            i2 = i9;
        } else if (($changed & 12582912) == 0) {
            i2 = i9;
            $dirty2 |= $composer3.changedInstance(function2) ? 8388608 : 4194304;
        } else {
            i2 = i9;
        }
        if ((i & 256) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            divider2 = function2;
            modifier3 = modifier2;
            scrollState4 = scrollState2;
            containerColor4 = containerColor2;
            contentColor4 = contentColor2;
            $composer2 = $composer3;
            edgePadding4 = edgePadding2;
            indicator2 = function3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                    scrollState2 = ScrollKt.rememberScrollState(0, $composer3, 0, 1);
                }
                if ((i & 8) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getSecondaryContainerColor($composer3, 6);
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getSecondaryContentColor($composer3, 6);
                    $dirty2 &= -57345;
                }
                if (i7 != 0) {
                    edgePadding2 = TabRowDefaults.INSTANCE.m2567getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                indicator = i8 != 0 ? ComposableLambdaKt.composableLambda($composer3, -115843248, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
                        invoke((List<TabPosition>) list, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(List<TabPosition> list, Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C754@33494L101:TabRow.kt#uh7d8r");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-115843248, $changed2, -1, "androidx.compose.material3.SecondaryScrollableTabRow.<anonymous> (TabRow.kt:754)");
                        }
                        TabRowDefaults.INSTANCE.m2566SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(selectedTabIndex)), 0.0f, 0L, $composer4, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }) : function3;
                if (i2 != 0) {
                    scrollState3 = scrollState2;
                    long j = contentColor2;
                    $dirty = $dirty2;
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m1982getLambda5$material3_release();
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = j;
                    edgePadding3 = edgePadding2;
                } else {
                    scrollState3 = scrollState2;
                    long j2 = contentColor2;
                    divider = function2;
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = j2;
                    edgePadding3 = edgePadding2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    int i10 = $dirty2 & (-57345);
                    modifier3 = modifier2;
                    scrollState3 = scrollState2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    divider = function2;
                    $dirty = i10;
                    indicator = function3;
                } else {
                    indicator = function3;
                    scrollState3 = scrollState2;
                    long j3 = contentColor2;
                    divider = function2;
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = j3;
                    edgePadding3 = edgePadding2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1821940917, $dirty, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:762)");
            }
            m2571ScrollableTabRowImpqhFBPw4(selectedTabIndex, indicator, modifier3, containerColor3, contentColor3, edgePadding3, divider, function22, scrollState3, $composer3, (($dirty << 18) & 234881024) | ($dirty & 14) | (($dirty >> 15) & 112) | (($dirty << 3) & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (($dirty >> 3) & 3670016) | (29360128 & ($dirty >> 3)), 0);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            Function2 function23 = divider;
            edgePadding4 = edgePadding3;
            contentColor4 = contentColor3;
            containerColor4 = containerColor3;
            scrollState4 = scrollState3;
            divider2 = function23;
            indicator2 = indicator;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$2
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

                public final void invoke(Composer composer, int i11) {
                    TabRowKt.m2572SecondaryScrollableTabRowqhFBPw4(selectedTabIndex, modifier3, scrollState4, containerColor4, contentColor4, edgePadding4, indicator2, divider2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    public static final void m2570ScrollableTabRowsKfQg0A(final int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, float edgePadding, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long containerColor2;
        long contentColor2;
        float edgePadding2;
        Function3 indicator;
        int $dirty;
        final Modifier modifier3;
        final long containerColor3;
        final long contentColor3;
        final float edgePadding3;
        Function3 indicator2;
        Function2 divider;
        Composer $composer2;
        final Function2 divider2;
        final Function3 indicator3;
        Composer $composer3 = $composer.startRestartGroup(-497821003);
        ComposerKt.sourceInformation($composer3, "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)816@36583L21,817@36647L19,838@37409L21,829@37100L336:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                containerColor2 = containerColor;
                int i3 = $composer3.changed(containerColor2) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i4 = $composer3.changed(contentColor2) ? 2048 : 1024;
                $dirty2 |= i4;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            edgePadding2 = edgePadding;
        } else if (($changed & 24576) == 0) {
            edgePadding2 = edgePadding;
            $dirty2 |= $composer3.changed(edgePadding2) ? 16384 : 8192;
        } else {
            edgePadding2 = edgePadding;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            indicator = function3;
        } else if ((196608 & $changed) == 0) {
            indicator = function3;
            $dirty2 |= $composer3.changedInstance(indicator) ? 131072 : 65536;
        } else {
            indicator = function3;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        }
        if (($dirty2 & 4793491) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            divider2 = function2;
            modifier3 = modifier2;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            edgePadding3 = edgePadding2;
            indicator3 = indicator;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer3, 6);
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer3, 6);
                    $dirty2 &= -7169;
                }
                if (i5 != 0) {
                    edgePadding2 = TabRowDefaults.INSTANCE.m2567getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                if (i6 != 0) {
                    indicator = ComposableLambdaKt.composableLambda($composer3, -913748678, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer, Integer num) {
                            invoke((List<TabPosition>) list, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(List<TabPosition> list, Composer $composer4, int $changed2) {
                            ComposerKt.sourceInformation($composer4, "C820@36863L101:TabRow.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-913748678, $changed2, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:820)");
                            }
                            TabRowDefaults.INSTANCE.m2566SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(selectedTabIndex)), 0.0f, 0L, $composer4, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                }
                if (i7 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m1983getLambda6$material3_release();
                    indicator2 = indicator;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    indicator2 = indicator;
                    divider = function2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty = $dirty2 & (-7169);
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    indicator2 = indicator;
                    divider = function2;
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    indicator2 = indicator;
                    divider = function2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-497821003, $dirty, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:828)");
            }
            m2571ScrollableTabRowImpqhFBPw4(selectedTabIndex, indicator2, modifier3, containerColor3, contentColor3, edgePadding3, divider, function22, ScrollKt.rememberScrollState(0, $composer3, 0, 1), $composer3, ($dirty & 14) | (($dirty >> 12) & 112) | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (($dirty << 3) & 458752) | (3670016 & $dirty) | (29360128 & $dirty), 0);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            divider2 = divider;
            indicator3 = indicator2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2
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
                    TabRowKt.m2570ScrollableTabRowsKfQg0A(selectedTabIndex, modifier3, containerColor3, contentColor3, edgePadding3, indicator3, divider2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScrollableTabRowImp-qhFBPw4, reason: not valid java name */
    public static final void m2571ScrollableTabRowImpqhFBPw4(final int selectedTabIndex, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, long containerColor, long contentColor, float edgePadding, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final ScrollState scrollState, Composer $composer, final int $changed, final int i) {
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        Modifier modifier2;
        long containerColor2;
        long contentColor2;
        float edgePadding2;
        int $dirty;
        long contentColor3;
        float edgePadding3;
        int i2;
        Function2 divider;
        Modifier modifier3;
        long containerColor3;
        int i3;
        Composer $composer2;
        final Modifier modifier4;
        final float edgePadding4;
        final Function2 divider2;
        final long containerColor4;
        final long contentColor4;
        Composer $composer3 = $composer.startRestartGroup(-1696166011);
        ComposerKt.sourceInformation($composer3, "C(ScrollableTabRowImp)P(7,4,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp!1,8)847@37660L21,848@37724L19,856@37975L3984:TabRow.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(selectedTabIndex) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
            function32 = function3;
        } else if (($changed & 48) == 0) {
            function32 = function3;
            $dirty2 |= $composer3.changedInstance(function32) ? 32 : 16;
        } else {
            function32 = function3;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerColor2 = containerColor;
                int i5 = $composer3.changed(containerColor2) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= i5;
        } else {
            containerColor2 = containerColor;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer3.changed(contentColor2) ? 16384 : 8192;
                $dirty2 |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty2 |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            edgePadding2 = edgePadding;
        } else if ((196608 & $changed) == 0) {
            edgePadding2 = edgePadding;
            $dirty2 |= $composer3.changed(edgePadding2) ? 131072 : 65536;
        } else {
            edgePadding2 = edgePadding;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        }
        if ((i & 256) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changed(scrollState) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            containerColor4 = containerColor2;
            contentColor4 = contentColor2;
            edgePadding4 = edgePadding2;
            divider2 = function2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 8) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor($composer3, 6);
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    contentColor2 = TabRowDefaults.INSTANCE.getPrimaryContentColor($composer3, 6);
                    $dirty2 &= -57345;
                }
                if (i7 != 0) {
                    edgePadding2 = TabRowDefaults.INSTANCE.m2567getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                }
                if (i8 != 0) {
                    $dirty = $dirty2;
                    contentColor3 = contentColor2;
                    i2 = 12582912;
                    divider = ComposableSingletons$TabRowKt.INSTANCE.m1984getLambda7$material3_release();
                    containerColor3 = containerColor2;
                    edgePadding3 = edgePadding2;
                    modifier3 = modifier2;
                    i3 = -1696166011;
                } else {
                    $dirty = $dirty2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    i2 = 12582912;
                    divider = function2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    i3 = -1696166011;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    int i9 = $dirty2 & (-57345);
                    divider = function2;
                    $dirty = i9;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    i2 = 12582912;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    i3 = -1696166011;
                } else {
                    $dirty = $dirty2;
                    contentColor3 = contentColor2;
                    edgePadding3 = edgePadding2;
                    i2 = 12582912;
                    divider = function2;
                    modifier3 = modifier2;
                    containerColor3 = containerColor2;
                    i3 = -1696166011;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i3, $dirty, -1, "androidx.compose.material3.ScrollableTabRowImp (TabRow.kt:855)");
            }
            final float edgePadding5 = edgePadding3;
            final Function2 divider3 = divider;
            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function32;
            $composer2 = $composer3;
            SurfaceKt.m2519SurfaceT9BRK9s(modifier3, null, containerColor3, contentColor3, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda($composer3, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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
                    Object value$iv;
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer4, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1178901494, $changed2, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
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
                        CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                        $composer4.endReplaceableGroup();
                        $composer4.startReplaceableGroup(121290627);
                        ComposerKt.sourceInformation($composer4, "CC(remember):TabRow.kt#9igjgp");
                        boolean invalid$iv = $composer4.changed(scrollState) | $composer4.changed(coroutineScope);
                        ScrollState scrollState2 = scrollState;
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new ScrollableTabData(scrollState2, coroutineScope);
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        final ScrollableTabData scrollableTabData = (ScrollableTabData) value$iv;
                        $composer4.endReplaceableGroup();
                        Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollState, false, null, false, 14, null)));
                        $composer4.startReplaceableGroup(121291080);
                        ComposerKt.sourceInformation($composer4, "CC(remember):TabRow.kt#9igjgp");
                        boolean invalid$iv2 = $composer4.changed(edgePadding5) | $composer4.changed(function22) | $composer4.changed(divider3) | $composer4.changed(function33) | $composer4.changedInstance(scrollableTabData) | $composer4.changed(selectedTabIndex);
                        final float f = edgePadding5;
                        final Function2<Composer, Integer, Unit> function23 = function22;
                        final Function2<Composer, Integer, Unit> function24 = divider3;
                        final int i10 = selectedTabIndex;
                        final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                        Object it$iv2 = $composer4.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                    return m2580invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                }

                                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2580invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, final long constraints) {
                                    int minTabWidth = $this$SubcomposeLayout.mo512roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
                                    int padding = $this$SubcomposeLayout.mo512roundToPx0680j_4(f);
                                    List tabMeasurables = $this$SubcomposeLayout.subcompose(TabSlots.Tabs, function23);
                                    Object initial$iv = 0;
                                    Object accumulator$iv = initial$iv;
                                    int index$iv$iv = 0;
                                    int size = tabMeasurables.size();
                                    while (index$iv$iv < size) {
                                        Object item$iv$iv = tabMeasurables.get(index$iv$iv);
                                        Object initial$iv2 = initial$iv;
                                        Measurable measurable = (Measurable) item$iv$iv;
                                        int curr = ((Number) accumulator$iv).intValue();
                                        accumulator$iv = Integer.valueOf(Math.max(curr, measurable.maxIntrinsicHeight(Integer.MAX_VALUE)));
                                        index$iv$iv++;
                                        initial$iv = initial$iv2;
                                        padding = padding;
                                    }
                                    final int padding2 = padding;
                                    final int layoutHeight = ((Number) accumulator$iv).intValue();
                                    long tabConstraints = Constraints.m6243copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(constraints) : minTabWidth, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(constraints) : layoutHeight, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(constraints) : layoutHeight);
                                    final List tabPlaceables = new ArrayList();
                                    final List tabContentWidths = new ArrayList();
                                    int index$iv = 0;
                                    int size2 = tabMeasurables.size();
                                    while (index$iv < size2) {
                                        Object item$iv = tabMeasurables.get(index$iv);
                                        Measurable it = (Measurable) item$iv;
                                        Placeable placeable = it.mo5219measureBRTryo0(tabConstraints);
                                        long tabConstraints2 = tabConstraints;
                                        float contentWidth = $this$SubcomposeLayout.mo515toDpu2uoSUM(Math.min(it.maxIntrinsicWidth(placeable.getHeight()), placeable.getWidth()));
                                        float arg0$iv = TabKt.getHorizontalTextPadding();
                                        float arg0$iv2 = 2;
                                        float other$iv = C1956Dp.m6297constructorimpl(arg0$iv2 * arg0$iv);
                                        float other$iv2 = C1956Dp.m6297constructorimpl(contentWidth - other$iv);
                                        tabPlaceables.add(placeable);
                                        tabContentWidths.add(C1956Dp.m6295boximpl(other$iv2));
                                        index$iv++;
                                        tabConstraints = tabConstraints2;
                                    }
                                    Object accumulator$iv2 = Integer.valueOf(padding2 * 2);
                                    int size3 = tabPlaceables.size();
                                    for (int index$iv$iv2 = 0; index$iv$iv2 < size3; index$iv$iv2++) {
                                        Object item$iv$iv2 = tabPlaceables.get(index$iv$iv2);
                                        Placeable measurable2 = (Placeable) item$iv$iv2;
                                        int curr2 = ((Number) accumulator$iv2).intValue();
                                        accumulator$iv2 = Integer.valueOf(curr2 + measurable2.getWidth());
                                    }
                                    final int layoutWidth = ((Number) accumulator$iv2).intValue();
                                    final Function2<Composer, Integer, Unit> function25 = function24;
                                    final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                    final int i11 = i10;
                                    final Function3<List<TabPosition>, Composer, Integer, Unit> function35 = function34;
                                    return MeasureScope.layout$default($this$SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
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
                                            final List tabPositions = new ArrayList();
                                            int left = padding2;
                                            List $this$fastForEachIndexed$iv = tabPlaceables;
                                            SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
                                            List<C1956Dp> list = tabContentWidths;
                                            int size4 = $this$fastForEachIndexed$iv.size();
                                            int left2 = left;
                                            for (int index$iv2 = 0; index$iv2 < size4; index$iv2++) {
                                                Object item$iv2 = $this$fastForEachIndexed$iv.get(index$iv2);
                                                Placeable placeable2 = (Placeable) item$iv2;
                                                int index = index$iv2;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, placeable2, left2, 0, 0.0f, 4, null);
                                                tabPositions.add(new TabPosition(subcomposeMeasureScope.mo515toDpu2uoSUM(left2), subcomposeMeasureScope.mo515toDpu2uoSUM(placeable2.getWidth()), list.get(index).m6311unboximpl(), null));
                                                left2 += placeable2.getWidth();
                                            }
                                            List $this$fastForEach$iv = $this$SubcomposeLayout.subcompose(TabSlots.Divider, function25);
                                            long j = constraints;
                                            int i12 = layoutWidth;
                                            int i13 = layoutHeight;
                                            int size5 = $this$fastForEach$iv.size();
                                            int index$iv3 = 0;
                                            while (index$iv3 < size5) {
                                                Object item$iv3 = $this$fastForEach$iv.get(index$iv3);
                                                Measurable it2 = (Measurable) item$iv3;
                                                Placeable placeable3 = it2.mo5219measureBRTryo0(Constraints.m6243copyZbe2FdA(j, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(j) : i12, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(j) : i12, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(j) : 0, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(j) : 0));
                                                Placeable.PlacementScope.placeRelative$default($this$layout, placeable3, 0, i13 - placeable3.getHeight(), 0.0f, 4, null);
                                                index$iv3++;
                                                $this$fastForEach$iv = $this$fastForEach$iv;
                                            }
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = $this$SubcomposeLayout;
                                            TabSlots tabSlots = TabSlots.Indicator;
                                            final Function3<List<TabPosition>, Composer, Integer, Unit> function36 = function35;
                                            List $this$fastForEach$iv2 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
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

                                                public final void invoke(Composer $composer5, int $changed3) {
                                                    ComposerKt.sourceInformation($composer5, "C942@41500L23:TabRow.kt#uh7d8r");
                                                    if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                                        $composer5.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(358596038, $changed3, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                    }
                                                    function36.invoke(tabPositions, $composer5, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                            int i14 = layoutWidth;
                                            int i15 = layoutHeight;
                                            int size6 = $this$fastForEach$iv2.size();
                                            for (int index$iv4 = 0; index$iv4 < size6; index$iv4++) {
                                                Object item$iv4 = $this$fastForEach$iv2.get(index$iv4);
                                                Measurable it3 = (Measurable) item$iv4;
                                                Placeable.PlacementScope.placeRelative$default($this$layout, it3.mo5219measureBRTryo0(Constraints.INSTANCE.m6261fixedJhjzzOo(i14, i15)), 0, 0, 0.0f, 4, null);
                                            }
                                            scrollableTabData2.onLaidOut($this$SubcomposeLayout, padding2, tabPositions, i11);
                                        }
                                    }, 4, null);
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer4.endReplaceableGroup();
                        SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, (Function2) value$iv2, $composer4, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 6) & 14) | i2 | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            edgePadding4 = edgePadding5;
            divider2 = divider3;
            containerColor4 = containerColor3;
            contentColor4 = contentColor3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$2
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
                    TabRowKt.m2571ScrollableTabRowImpqhFBPw4(selectedTabIndex, function3, modifier4, containerColor4, contentColor4, edgePadding4, divider2, function22, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
