package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyList.kt */
@Metadata(m164d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u001bH\u0001¢\u0006\u0002\u0010\u001c\u001a\u008a\u0001\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001e¢\u0006\u0002\b\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003¢\u0006\u0002\u0010%¨\u0006&"}, m165d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyListKt {
    public static final void LazyList(final Modifier modifier, final LazyListState state, final PaddingValues contentPadding, boolean reverseLayout, final boolean isVertical, final FlingBehavior flingBehavior, final boolean userScrollEnabled, int beyondBoundsItemCount, Alignment.Horizontal horizontalAlignment, Arrangement.Vertical verticalArrangement, Alignment.Vertical verticalAlignment, Arrangement.Horizontal horizontalArrangement, final Function1<? super LazyListScope, Unit> function1, Composer $composer, final int $changed, final int $changed1, final int i) {
        PaddingValues paddingValues;
        int beyondBoundsItemCount2;
        int i2;
        int i3;
        int i4;
        int i5;
        Alignment.Horizontal horizontalAlignment2;
        Arrangement.Vertical verticalArrangement2;
        Alignment.Vertical verticalAlignment2;
        Arrangement.Horizontal horizontalArrangement2;
        Alignment.Horizontal horizontalAlignment3;
        Object value$iv$iv$iv;
        int $dirty;
        boolean z;
        Composer $composer2;
        final int $dirty2;
        final Alignment.Horizontal horizontalAlignment4;
        final Alignment.Vertical verticalAlignment3;
        final Arrangement.Horizontal horizontalArrangement3;
        final Arrangement.Vertical verticalArrangement3;
        Composer $composer3 = $composer.startRestartGroup(620764179);
        ComposerKt.sourceInformation($composer3, "C(LazyList)P(7,9,2,8,6,3,10!1,4,12,11,5)80@3813L50,82@3889L48,83@3954L24,86@4037L292,99@4377L18,105@4632L277,114@5029L153,120@5345L7,113@4973L481,128@5678L7,101@4487L1676:LazyList.kt#428nma");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changed(state) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 384;
            paddingValues = contentPadding;
        } else if (($changed & 896) == 0) {
            paddingValues = contentPadding;
            $dirty3 |= $composer3.changed(paddingValues) ? 256 : 128;
        } else {
            paddingValues = contentPadding;
        }
        if ((i & 8) != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer3.changed(reverseLayout) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty3 |= $composer3.changed(isVertical) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer3.changed(flingBehavior) ? 131072 : 65536;
        }
        if ((i & 64) != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer3.changed(userScrollEnabled) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty3 |= 12582912;
            beyondBoundsItemCount2 = beyondBoundsItemCount;
        } else if (($changed & 29360128) == 0) {
            beyondBoundsItemCount2 = beyondBoundsItemCount;
            $dirty3 |= $composer3.changed(beyondBoundsItemCount2) ? 8388608 : 4194304;
        } else {
            beyondBoundsItemCount2 = beyondBoundsItemCount;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty3 |= 100663296;
            i2 = i7;
        } else if (($changed & 234881024) == 0) {
            i2 = i7;
            $dirty3 |= $composer3.changed(horizontalAlignment) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i7;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty3 |= 805306368;
            i3 = i8;
        } else if (($changed & 1879048192) == 0) {
            i3 = i8;
            $dirty3 |= $composer3.changed(verticalArrangement) ? 536870912 : 268435456;
        } else {
            i3 = i8;
        }
        int i9 = i & 1024;
        if (i9 != 0) {
            $dirty1 |= 6;
            i4 = i9;
        } else if (($changed1 & 14) == 0) {
            i4 = i9;
            $dirty1 |= $composer3.changed(verticalAlignment) ? 4 : 2;
        } else {
            i4 = i9;
        }
        int i10 = i & 2048;
        if (i10 != 0) {
            $dirty1 |= 48;
            i5 = i10;
        } else if (($changed1 & 112) == 0) {
            i5 = i10;
            $dirty1 |= $composer3.changed(horizontalArrangement) ? 32 : 16;
        } else {
            i5 = i10;
        }
        if ((i & 4096) != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        int $dirty12 = $dirty1;
        if ((1533916891 & $dirty3) != 306783378 || ($dirty12 & 731) != 146 || !$composer3.getSkipping()) {
            if (i6 != 0) {
                beyondBoundsItemCount2 = 0;
            }
            if (i2 == 0) {
                horizontalAlignment2 = horizontalAlignment;
            } else {
                horizontalAlignment2 = null;
            }
            if (i3 == 0) {
                verticalArrangement2 = verticalArrangement;
            } else {
                verticalArrangement2 = null;
            }
            if (i4 == 0) {
                verticalAlignment2 = verticalAlignment;
            } else {
                verticalAlignment2 = null;
            }
            if (i5 == 0) {
                horizontalArrangement2 = horizontalArrangement;
            } else {
                horizontalArrangement2 = null;
            }
            if (!ComposerKt.isTraceInProgress()) {
                horizontalAlignment3 = horizontalAlignment2;
            } else {
                horizontalAlignment3 = horizontalAlignment2;
                ComposerKt.traceEventStart(620764179, $dirty3, $dirty12, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:79)");
            }
            Function0 itemProviderLambda = LazyListItemProviderKt.rememberLazyListItemProviderLambda(state, function1, $composer3, (($dirty3 >> 3) & 14) | (($dirty12 >> 3) & 112));
            LazyLayoutSemanticState semanticState = LazyListSemanticsKt.rememberLazyListSemanticState(state, isVertical, $composer3, (($dirty3 >> 3) & 14) | (($dirty3 >> 9) & 112));
            $composer3.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation($composer3, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
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
            CoroutineScope scope = wrapper$iv.getCoroutineScope();
            $composer3.endReplaceableGroup();
            state.setCoroutineScope$foundation_release(scope);
            int i11 = ($dirty3 & 112) | ($dirty3 & 896) | ($dirty3 & 7168) | ($dirty3 & 57344) | (($dirty3 >> 6) & 458752) | (($dirty3 >> 6) & 3670016) | (($dirty12 << 21) & 29360128) | (($dirty12 << 21) & 234881024) | (1879048192 & $dirty3);
            int i12 = $dirty3;
            Alignment.Horizontal horizontalAlignment5 = horizontalAlignment3;
            $dirty = i12;
            Arrangement.Vertical verticalArrangement4 = verticalArrangement2;
            PaddingValues paddingValues2 = paddingValues;
            Alignment.Vertical verticalAlignment4 = verticalAlignment2;
            Arrangement.Horizontal horizontalArrangement4 = horizontalArrangement2;
            Function2 measurePolicy = rememberLazyListMeasurePolicy(itemProviderLambda, state, paddingValues2, reverseLayout, isVertical, beyondBoundsItemCount2, horizontalAlignment5, verticalAlignment4, horizontalArrangement4, verticalArrangement4, $composer3, i11, 0);
            int beyondBoundsItemCount3 = beyondBoundsItemCount2;
            OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect($composer3, 6);
            Orientation orientation = isVertical ? Orientation.Vertical : Orientation.Horizontal;
            Modifier modifierClipScrollableContainer = ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(state.getRemeasurementModifier()).then(state.getAwaitLayoutModifier()), itemProviderLambda, semanticState, orientation, userScrollEnabled, reverseLayout, $composer3, (($dirty >> 6) & 57344) | (($dirty << 6) & 458752)), orientation);
            LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsStateRememberLazyListBeyondBoundsState = LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(state, beyondBoundsItemCount3, $composer3, (($dirty >> 3) & 14) | (($dirty >> 18) & 112));
            LazyLayoutBeyondBoundsInfo beyondBoundsInfo = state.getBeyondBoundsInfo();
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            z = reverseLayout;
            Modifier modifierOverscroll = OverscrollKt.overscroll(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(modifierClipScrollableContainer, lazyLayoutBeyondBoundsStateRememberLazyListBeyondBoundsState, beyondBoundsInfo, z, (LayoutDirection) objConsume, orientation, userScrollEnabled, $composer3, (MutableVector.$stable << 6) | ($dirty & 7168) | ($dirty & 3670016)), overscrollEffect);
            ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LazyLayoutKt.LazyLayout((Function0<? extends LazyLayoutItemProvider>) itemProviderLambda, ScrollableKt.scrollable$default(modifierOverscroll, state, orientation, overscrollEffect, userScrollEnabled, scrollableDefaults.reverseDirection((LayoutDirection) objConsume2, orientation, z), flingBehavior, state.getInternalInteractionSource(), null, 128, null), state.getPrefetchState(), (Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult>) measurePolicy, $composer3, 0, 0);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $dirty2 = beyondBoundsItemCount3;
            horizontalAlignment4 = horizontalAlignment5;
            verticalAlignment3 = verticalAlignment4;
            horizontalArrangement3 = horizontalArrangement4;
            verticalArrangement3 = verticalArrangement4;
        } else {
            $composer3.skipToGroupEnd();
            horizontalAlignment4 = horizontalAlignment;
            verticalArrangement3 = verticalArrangement;
            verticalAlignment3 = verticalAlignment;
            $dirty = $dirty3;
            $composer2 = $composer3;
            z = reverseLayout;
            horizontalArrangement3 = horizontalArrangement;
            $dirty2 = beyondBoundsItemCount2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z2 = z;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt.LazyList.1
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

                public final void invoke(Composer composer, int i13) {
                    LazyListKt.LazyList(modifier, state, contentPadding, z2, isVertical, flingBehavior, userScrollEnabled, $dirty2, horizontalAlignment4, verticalArrangement3, verticalAlignment3, horizontalArrangement3, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(final Function0<? extends LazyListItemProvider> function0, final LazyListState state, final PaddingValues contentPadding, final boolean reverseLayout, final boolean isVertical, final int beyondBoundsItemCount, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(183156450);
        ComposerKt.sourceInformation($composer, "C(rememberLazyListMeasurePolicy)P(5,7,1,6,4!2,8)167@7348L7990:LazyList.kt#428nma");
        Alignment.Horizontal horizontalAlignment2 = (i & 64) != 0 ? null : horizontalAlignment;
        Alignment.Vertical verticalAlignment2 = (i & 128) != 0 ? null : verticalAlignment;
        Arrangement.Horizontal horizontalArrangement2 = (i & 256) != 0 ? null : horizontalArrangement;
        Arrangement.Vertical verticalArrangement2 = (i & 512) != 0 ? null : verticalArrangement;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(183156450, $changed, -1, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:167)");
        }
        Object[] keys$iv = {state, contentPadding, Boolean.valueOf(reverseLayout), Boolean.valueOf(isVertical), horizontalAlignment2, verticalAlignment2, horizontalArrangement2, verticalArrangement2};
        $composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= $composer.changed(key$iv);
        }
        Object value$iv$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            final Arrangement.Vertical verticalArrangement3 = verticalArrangement2;
            final Arrangement.Horizontal horizontalArrangement3 = horizontalArrangement2;
            final Alignment.Horizontal horizontalAlignment3 = horizontalAlignment2;
            final Alignment.Vertical verticalAlignment3 = verticalAlignment2;
            value$iv$iv = new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m872invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyListMeasureResult m872invoke0kLqBqw(final LazyLayoutMeasureScope $this$null, final long containerConstraints) throws Throwable {
                    int i2;
                    int i3;
                    final int beforeContentPadding;
                    float spacing;
                    int iM6253getMaxWidthimpl;
                    long visualItemOffset;
                    Snapshot previous$iv$iv;
                    int firstVisibleScrollOffset;
                    float scrollToBeConsumed;
                    boolean hasLookaheadPassOccurred = state.getHasLookaheadPassOccurred() || $this$null.isLookingAhead();
                    CheckScrollableContainerConstraintsKt.m443checkScrollableContainerConstraintsK40F9xA(containerConstraints, isVertical ? Orientation.Vertical : Orientation.Horizontal);
                    if (isVertical) {
                        i2 = $this$null.mo512roundToPx0680j_4(contentPadding.mo718calculateLeftPaddingu2uoSUM($this$null.getLayoutDirection()));
                    } else {
                        i2 = $this$null.mo512roundToPx0680j_4(PaddingKt.calculateStartPadding(contentPadding, $this$null.getLayoutDirection()));
                    }
                    int startPadding = i2;
                    if (isVertical) {
                        i3 = $this$null.mo512roundToPx0680j_4(contentPadding.mo719calculateRightPaddingu2uoSUM($this$null.getLayoutDirection()));
                    } else {
                        i3 = $this$null.mo512roundToPx0680j_4(PaddingKt.calculateEndPadding(contentPadding, $this$null.getLayoutDirection()));
                    }
                    int endPadding = i3;
                    int topPadding = $this$null.mo512roundToPx0680j_4(contentPadding.getTop());
                    int bottomPadding = $this$null.mo512roundToPx0680j_4(contentPadding.getBottom());
                    final int totalVerticalPadding = topPadding + bottomPadding;
                    final int totalHorizontalPadding = startPadding + endPadding;
                    int totalMainAxisPadding = isVertical ? totalVerticalPadding : totalHorizontalPadding;
                    if (isVertical && !reverseLayout) {
                        beforeContentPadding = topPadding;
                    } else if (isVertical && reverseLayout) {
                        beforeContentPadding = bottomPadding;
                    } else {
                        beforeContentPadding = (isVertical || reverseLayout) ? endPadding : startPadding;
                    }
                    final int afterContentPadding = totalMainAxisPadding - beforeContentPadding;
                    final long contentConstraints = ConstraintsKt.m6269offsetNN6EwU(containerConstraints, -totalHorizontalPadding, -totalVerticalPadding);
                    state.setDensity$foundation_release($this$null);
                    final LazyListItemProvider itemProvider = function0.invoke();
                    itemProvider.getItemScope().setMaxSize(Constraints.m6253getMaxWidthimpl(contentConstraints), Constraints.m6252getMaxHeightimpl(contentConstraints));
                    if (isVertical) {
                        Arrangement.Vertical vertical = verticalArrangement3;
                        if (vertical == null) {
                            throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
                        }
                        spacing = vertical.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal = horizontalArrangement3;
                        if (horizontal == null) {
                            throw new IllegalArgumentException("null horizontalAlignment when isVertical == false".toString());
                        }
                        spacing = horizontal.getSpacing();
                    }
                    float spaceBetweenItemsDp = spacing;
                    final int spaceBetweenItems = $this$null.mo512roundToPx0680j_4(spaceBetweenItemsDp);
                    final int itemsCount = itemProvider.getItemCount();
                    if (!isVertical) {
                        iM6253getMaxWidthimpl = Constraints.m6253getMaxWidthimpl(containerConstraints) - totalHorizontalPadding;
                    } else {
                        iM6253getMaxWidthimpl = Constraints.m6252getMaxHeightimpl(containerConstraints) - totalVerticalPadding;
                    }
                    int mainAxisAvailableSize = iM6253getMaxWidthimpl;
                    if (!reverseLayout || mainAxisAvailableSize > 0) {
                        visualItemOffset = IntOffsetKt.IntOffset(startPadding, topPadding);
                    } else {
                        visualItemOffset = IntOffsetKt.IntOffset(isVertical ? startPadding : startPadding + mainAxisAvailableSize, isVertical ? topPadding + mainAxisAvailableSize : topPadding);
                    }
                    final boolean z = isVertical;
                    final Alignment.Horizontal horizontal2 = horizontalAlignment3;
                    final Alignment.Vertical vertical2 = verticalAlignment3;
                    final boolean z2 = reverseLayout;
                    final LazyListState lazyListState = state;
                    final long visualItemOffset2 = visualItemOffset;
                    LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(contentConstraints, z, itemProvider, $this$null, itemsCount, spaceBetweenItems, horizontal2, vertical2, z2, beforeContentPadding, afterContentPadding, visualItemOffset2, lazyListState) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ int $itemsCount;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ int $spaceBetweenItems;
                        final /* synthetic */ LazyListState $state;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ Alignment.Vertical $verticalAlignment;
                        final /* synthetic */ long $visualItemOffset;

                        {
                            this.$isVertical = z;
                            this.$this_null = $this$null;
                            this.$itemsCount = itemsCount;
                            this.$spaceBetweenItems = spaceBetweenItems;
                            this.$horizontalAlignment = horizontal2;
                            this.$verticalAlignment = vertical2;
                            this.$reverseLayout = z2;
                            this.$beforeContentPadding = beforeContentPadding;
                            this.$afterContentPadding = afterContentPadding;
                            this.$visualItemOffset = visualItemOffset2;
                            this.$state = lazyListState;
                        }

                        @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                        public LazyListMeasuredItem createItem(int index, Object key, Object contentType, List<? extends Placeable> placeables) {
                            int spacing2 = index == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems;
                            return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, spacing2, this.$visualItemOffset, key, contentType, this.$state.getItemAnimator(), null);
                        }
                    };
                    state.m883setPremeasureConstraintsBRTryo0$foundation_release(lazyListMeasuredItemProvider.getChildConstraints());
                    Snapshot.Companion this_$iv = Snapshot.INSTANCE;
                    LazyListState lazyListState2 = state;
                    Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
                    try {
                        Snapshot previous$iv$iv2 = snapshot$iv.makeCurrent();
                        int firstVisibleItemIndex = 0;
                        try {
                            int firstVisibleItemIndex2 = lazyListState2.getFirstVisibleItemIndex();
                            firstVisibleItemIndex = lazyListState2.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(itemProvider, firstVisibleItemIndex2);
                            try {
                                firstVisibleScrollOffset = lazyListState2.getFirstVisibleItemScrollOffset();
                            } catch (Throwable th) {
                                th = th;
                                previous$iv$iv = previous$iv$iv2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            previous$iv$iv = previous$iv$iv2;
                        }
                        try {
                            Unit unit = Unit.INSTANCE;
                            try {
                                snapshot$iv.restoreCurrent(previous$iv$iv2);
                                snapshot$iv.dispose();
                                List pinnedItems = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(itemProvider, state.getPinnedItems(), state.getBeyondBoundsInfo());
                                if ($this$null.isLookingAhead() || !hasLookaheadPassOccurred) {
                                    scrollToBeConsumed = state.getScrollToBeConsumed();
                                } else {
                                    scrollToBeConsumed = state.getScrollDeltaBetweenPasses$foundation_release();
                                }
                                float scrollToBeConsumed2 = scrollToBeConsumed;
                                LazyListMeasuredItemProvider lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
                                int beforeContentPadding2 = beforeContentPadding;
                                boolean z3 = isVertical;
                                List<Integer> headerIndexes = itemProvider.getHeaderIndexes();
                                Arrangement.Vertical vertical3 = verticalArrangement3;
                                Arrangement.Horizontal horizontal3 = horizontalArrangement3;
                                boolean z4 = reverseLayout;
                                LazyLayoutMeasureScope lazyLayoutMeasureScope = $this$null;
                                LazyListItemAnimator itemAnimator = state.getItemAnimator();
                                int beforeContentPadding3 = beyondBoundsItemCount;
                                boolean zIsLookingAhead = $this$null.isLookingAhead();
                                LazyListMeasureResult postLookaheadLayoutInfo = state.getPostLookaheadLayoutInfo();
                                CoroutineScope coroutineScope = state.getCoroutineScope();
                                if (coroutineScope != null) {
                                    LazyListMeasureResult it = LazyListMeasureKt.m876measureLazyList5IMabDg(itemsCount, lazyListMeasuredItemProvider2, mainAxisAvailableSize, beforeContentPadding2, afterContentPadding, spaceBetweenItems, firstVisibleItemIndex, firstVisibleScrollOffset, scrollToBeConsumed2, contentConstraints, z3, headerIndexes, vertical3, horizontal3, z4, lazyLayoutMeasureScope, itemAnimator, beforeContentPadding3, pinnedItems, hasLookaheadPassOccurred, zIsLookingAhead, postLookaheadLayoutInfo, coroutineScope, state.m881getPlacementScopeInvalidatorzYiylxw$foundation_release(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                            return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                        }

                                        public final MeasureResult invoke(int width, int height, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                            return $this$null.layout(ConstraintsKt.m6267constrainWidthK40F9xA(containerConstraints, totalHorizontalPadding + width), ConstraintsKt.m6266constrainHeightK40F9xA(containerConstraints, totalVerticalPadding + height), MapsKt.emptyMap(), function1);
                                        }
                                    });
                                    LazyListState.applyMeasureResult$foundation_release$default(state, it, $this$null.isLookingAhead(), false, 4, null);
                                    return it;
                                }
                                throw new IllegalArgumentException("coroutineScope should be not null".toString());
                            } catch (Throwable th3) {
                                th = th3;
                                snapshot$iv.dispose();
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            previous$iv$iv = previous$iv$iv2;
                            try {
                                snapshot$iv.restoreCurrent(previous$iv$iv);
                                throw th;
                            } catch (Throwable th5) {
                                th = th5;
                                snapshot$iv.dispose();
                                throw th;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function2;
    }
}
