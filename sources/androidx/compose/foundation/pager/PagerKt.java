package androidx.compose.foundation.pager;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Pager.kt */
@Metadata(m164d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001aØ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00012%\b\u0002\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f21\u0010 \u001a-\u0012\u0004\u0012\u00020\"\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b$¢\u0006\u0002\b%H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a.\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020/H\u0002\u001aØ\u0001\u00101\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00012%\b\u0002\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f21\u0010 \u001a-\u0012\u0004\u0012\u00020\"\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b$¢\u0006\u0002\b%H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a\u0017\u00106\u001a\u00020\u00062\f\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0082\b\u001a\f\u0010:\u001a\u00020/*\u00020\bH\u0002\u001a\f\u0010;\u001a\u00020\u0001*\u00020\bH\u0002\u001a!\u0010<\u001a\u00020\n*\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010>\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006?"}, m165d2 = {"DEBUG", "", "LowVelocityAnimationDefaultDuration", "", "PagerDebugEnable", "HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondBoundsPageCount", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "userScrollEnabled", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "pagerState", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapPositionalThreshold", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "dragGestureDelta", "isScrollingForward", "pagerSemantics", "isVertical", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerKt {
    private static final boolean DEBUG = false;
    private static final int LowVelocityAnimationDefaultDuration = 500;
    public static final boolean PagerDebugEnable = false;

    /* JADX WARN: Removed duplicated region for block: B:210:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:212:? A[RETURN, SYNTHETIC] */
    /* renamed from: HorizontalPager-xYaah8o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m994HorizontalPagerxYaah8o(final androidx.compose.foundation.pager.PagerState r34, androidx.compose.p000ui.Modifier r35, androidx.compose.foundation.layout.PaddingValues r36, androidx.compose.foundation.pager.PageSize r37, int r38, float r39, androidx.compose.ui.Alignment.Vertical r40, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r41, boolean r42, boolean r43, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r44, androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection r45, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, final int r48, final int r49, final int r50) {
        /*
            Method dump skipped, instructions count: 985
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m994HorizontalPagerxYaah8o(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:210:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:212:? A[RETURN, SYNTHETIC] */
    /* renamed from: VerticalPager-xYaah8o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m995VerticalPagerxYaah8o(final androidx.compose.foundation.pager.PagerState r35, androidx.compose.p000ui.Modifier r36, androidx.compose.foundation.layout.PaddingValues r37, androidx.compose.foundation.pager.PageSize r38, int r39, float r40, androidx.compose.ui.Alignment.Horizontal r41, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r42, boolean r43, boolean r44, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r45, androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection r46, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 984
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m995VerticalPagerxYaah8o(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final PagerState pagerState, final PagerSnapDistance pagerSnapDistance, final DecayAnimationSpec<Float> decayAnimationSpec, final float snapPositionalThreshold) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.pager.PagerKt.SnapLayoutInfoProvider.1
            public final PagerLayoutInfo getLayoutInfo() {
                return pagerState.getLayoutInfo();
            }

            public final boolean isValidDistance(float $this$isValidDistance) {
                if (!($this$isValidDistance == Float.POSITIVE_INFINITY)) {
                    if (!($this$isValidDistance == Float.NEGATIVE_INFINITY)) {
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x009f  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00ad  */
            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public float calculateSnappingOffset(float r10) {
                /*
                    r9 = this;
                    kotlin.Pair r0 = r9.searchForSnappingBounds()
                    java.lang.Object r1 = r0.component1()
                    java.lang.Number r1 = (java.lang.Number) r1
                    float r1 = r1.floatValue()
                    java.lang.Object r0 = r0.component2()
                    java.lang.Number r0 = (java.lang.Number) r0
                    float r0 = r0.floatValue()
                    androidx.compose.foundation.pager.PagerState r2 = r1
                    boolean r2 = androidx.compose.foundation.pager.PagerKt.access$isScrollingForward(r2)
                    r3 = 0
                    androidx.compose.foundation.pager.PagerState r3 = r1
                    float r3 = androidx.compose.foundation.pager.PagerKt.access$dragGestureDelta(r3)
                    androidx.compose.foundation.pager.PagerLayoutInfo r4 = r9.getLayoutInfo()
                    int r4 = r4.getPageSize()
                    float r4 = (float) r4
                    float r3 = r3 / r4
                    int r4 = (int) r3
                    float r4 = (float) r4
                    float r4 = r3 - r4
                    androidx.compose.foundation.pager.PagerState r5 = r1
                    androidx.compose.ui.unit.Density r5 = r5.getDensity()
                    r6 = 0
                    int r5 = androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(r5, r10)
                    r6 = 0
                    androidx.compose.foundation.gestures.snapping.FinalSnappingItem$Companion r6 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.INSTANCE
                    int r6 = r6.m639getClosestItembbeMdSM()
                    boolean r6 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.m635equalsimpl0(r5, r6)
                    r7 = 0
                    if (r6 == 0) goto L93
                    float r6 = java.lang.Math.abs(r4)
                    float r8 = r2
                    int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    if (r6 <= 0) goto L64
                    r6 = 0
                    if (r2 == 0) goto Lad
                    goto L9f
                L64:
                    androidx.compose.foundation.pager.PagerState r6 = r1
                    float r6 = r6.getCurrentPageOffsetFraction()
                    float r6 = java.lang.Math.abs(r6)
                    androidx.compose.foundation.pager.PagerState r8 = r1
                    float r8 = r8.getPositionThresholdFraction$foundation_release()
                    float r8 = java.lang.Math.abs(r8)
                    int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    if (r6 < 0) goto L82
                    r6 = 0
                    if (r2 == 0) goto L9f
                    goto Lad
                L82:
                    r6 = 0
                    float r6 = java.lang.Math.abs(r1)
                    float r8 = java.lang.Math.abs(r0)
                    int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    if (r6 >= 0) goto L92
                    goto Lad
                L92:
                    goto L9f
                L93:
                    androidx.compose.foundation.gestures.snapping.FinalSnappingItem$Companion r6 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.INSTANCE
                    int r6 = r6.m640getNextItembbeMdSM()
                    boolean r6 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.m635equalsimpl0(r5, r6)
                    if (r6 == 0) goto La1
                L9f:
                    r6 = r0
                    goto Lb0
                La1:
                    androidx.compose.foundation.gestures.snapping.FinalSnappingItem$Companion r6 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.INSTANCE
                    int r6 = r6.m641getPreviousItembbeMdSM()
                    boolean r6 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.m635equalsimpl0(r5, r6)
                    if (r6 == 0) goto Laf
                Lad:
                    r6 = r1
                    goto Lb0
                Laf:
                    r6 = r7
                Lb0:
                    r8 = 0
                    boolean r8 = r9.isValidDistance(r6)
                    if (r8 == 0) goto Lbc
                    r7 = r6
                    goto Lbd
                Lbc:
                Lbd:
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.C06661.calculateSnappingOffset(float):float");
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(float initialVelocity) {
                int firstVisiblePage;
                float fSignum;
                int effectivePageSizePx = pagerState.getPageSize$foundation_release() + pagerState.getPageSpacing$foundation_release();
                float animationOffsetPx = DecayAnimationSpecKt.calculateTargetValue(decayAnimationSpec, 0.0f, initialVelocity);
                if (initialVelocity < 0.0f) {
                    firstVisiblePage = pagerState.getFirstVisiblePage() + 1;
                } else {
                    firstVisiblePage = pagerState.getFirstVisiblePage();
                }
                int startPage = firstVisiblePage;
                float pagesInAnimationOffset = animationOffsetPx / effectivePageSizePx;
                int $i$f$debugLog = (int) pagesInAnimationOffset;
                int targetPage = RangesKt.coerceIn($i$f$debugLog + startPage, 0, pagerState.getPageCount());
                int correctedTargetPage = RangesKt.coerceIn(pagerSnapDistance.calculateTargetPage(startPage, targetPage, initialVelocity, pagerState.getPageSize$foundation_release(), pagerState.getPageSpacing$foundation_release()), 0, pagerState.getPageCount());
                int $i$f$debugLog2 = correctedTargetPage - startPage;
                int proposedFlingOffset = $i$f$debugLog2 * effectivePageSizePx;
                int $i$f$debugLog3 = Math.abs(proposedFlingOffset);
                int flingApproachOffsetPx = RangesKt.coerceAtLeast($i$f$debugLog3 - effectivePageSizePx, 0);
                if (flingApproachOffsetPx != 0) {
                    fSignum = flingApproachOffsetPx * Math.signum(initialVelocity);
                } else {
                    fSignum = flingApproachOffsetPx;
                }
                return fSignum;
            }

            /* JADX WARN: Incorrect condition in loop: B:18:0x009b */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private final kotlin.Pair<java.lang.Float, java.lang.Float> searchForSnappingBounds() {
                /*
                    Method dump skipped, instructions count: 259
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.C06661.searchForSnappingBounds():kotlin.Pair");
            }
        };
    }

    public static final Modifier pagerSemantics(Modifier $this$pagerSemantics, final PagerState state, final boolean isVertical, Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        $composer.startReplaceableGroup(1509835088);
        ComposerKt.sourceInformation($composer, "C(pagerSemantics)P(1)912@43239L24:Pager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1509835088, $changed, -1, "androidx.compose.foundation.pager.pagerSemantics (Pager.kt:911)");
        }
        $composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation($composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv$iv = $composer.rememberedValue();
        if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
            $composer.updateRememberedValue(value$iv$iv$iv);
        } else {
            value$iv$iv$iv = it$iv$iv$iv;
        }
        $composer.endReplaceableGroup();
        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
        final CoroutineScope scope = wrapper$iv.getCoroutineScope();
        $composer.endReplaceableGroup();
        Modifier modifierThen = $this$pagerSemantics.then(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1
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
                if (isVertical) {
                    final PagerState pagerState = state;
                    final CoroutineScope coroutineScope = scope;
                    SemanticsPropertiesKt.pageUp$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(PagerKt.pagerSemantics$performBackwardPaging(pagerState, coroutineScope));
                        }
                    }, 1, null);
                    final PagerState pagerState2 = state;
                    final CoroutineScope coroutineScope2 = scope;
                    SemanticsPropertiesKt.pageDown$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(PagerKt.pagerSemantics$performForwardPaging(pagerState2, coroutineScope2));
                        }
                    }, 1, null);
                    return;
                }
                final PagerState pagerState3 = state;
                final CoroutineScope coroutineScope3 = scope;
                SemanticsPropertiesKt.pageLeft$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(PagerKt.pagerSemantics$performBackwardPaging(pagerState3, coroutineScope3));
                    }
                }, 1, null);
                final PagerState pagerState4 = state;
                final CoroutineScope coroutineScope4 = scope;
                SemanticsPropertiesKt.pageRight$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt.pagerSemantics.1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(PagerKt.pagerSemantics$performForwardPaging(pagerState4, coroutineScope4));
                    }
                }, 1, null);
            }
        }, 1, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modifierThen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState $state, CoroutineScope scope) {
        if (!$state.getCanScrollForward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new PagerKt$pagerSemantics$performForwardPaging$1($state, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState $state, CoroutineScope scope) {
        if (!$state.getCanScrollBackward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new PagerKt$pagerSemantics$performBackwardPaging$1($state, null), 3, null);
        return true;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isScrollingForward(PagerState $this$isScrollingForward) {
        return dragGestureDelta($this$isScrollingForward) < 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float dragGestureDelta(PagerState $this$dragGestureDelta) {
        if ($this$dragGestureDelta.getLayoutInfo().getOrientation() == Orientation.Horizontal) {
            return Offset.m3708getXimpl($this$dragGestureDelta.m1004getUpDownDifferenceF1C5BW0$foundation_release());
        }
        return Offset.m3709getYimpl($this$dragGestureDelta.m1004getUpDownDifferenceF1C5BW0$foundation_release());
    }
}
