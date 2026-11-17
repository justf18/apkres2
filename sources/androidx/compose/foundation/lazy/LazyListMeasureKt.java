package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyListMeasure.kt */
@Metadata(m164d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u008c\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\\\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002\u001a4\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010#\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002\u001a\u0095\u0002\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00100\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u00102\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u00010!2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072/\u00108\u001a+\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:¢\u0006\u0002\b=\u0012\u0004\u0012\u00020>09H\u0000ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A"}, m165d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "items", "", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "createItemsAfterList", "visibleItems", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "itemsCount", "beyondBoundsItemCount", "pinnedItems", "consumedScroll", "", "isLookingAhead", "lastPostLookaheadLayoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "createItemsBeforeList", "currentFirstItemIndex", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "itemAnimator", "Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "hasLookaheadPassOccurred", "postLookaheadLayoutInfo", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-5IMabDg", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/LazyListItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyListMeasureKt {
    /* renamed from: measureLazyList-5IMabDg, reason: not valid java name */
    public static final LazyListMeasureResult m876measureLazyList5IMabDg(int itemsCount, LazyListMeasuredItemProvider measuredItemProvider, int mainAxisAvailableSize, int beforeContentPadding, int afterContentPadding, int spaceBetweenItems, int firstVisibleItemIndex, int firstVisibleItemScrollOffset, float scrollToBeConsumed, long constraints, boolean isVertical, List<Integer> list, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density, LazyListItemAnimator itemAnimator, int beyondBoundsItemCount, List<Integer> list2, boolean hasLookaheadPassOccurred, final boolean isLookingAhead, LazyListLayoutInfo postLookaheadLayoutInfo, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int index;
        int currentFirstItemIndex;
        int currentFirstItemScrollOffset;
        int maxOffset;
        int currentMainAxisOffset;
        int currentFirstItemIndex2;
        int maxCrossAxis;
        int preScrollBackScrollDelta;
        int scrollDelta;
        int currentFirstItemScrollOffset2;
        int i;
        int layoutWidth;
        int layoutHeight;
        LazyListMeasuredItem lazyListMeasuredItemFindOrComposeLazyListHeader;
        List positionedItems;
        boolean z;
        ArrayList arrayList;
        int scrollDelta2;
        int currentFirstItemScrollOffset3;
        int i2 = beforeContentPadding;
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException("invalid beforeContentPadding".toString());
        }
        if (!(afterContentPadding >= 0)) {
            throw new IllegalArgumentException("invalid afterContentPadding".toString());
        }
        if (itemsCount <= 0) {
            int layoutWidth2 = Constraints.m6255getMinWidthimpl(constraints);
            int layoutHeight2 = Constraints.m6254getMinHeightimpl(constraints);
            itemAnimator.onMeasured(0, layoutWidth2, layoutHeight2, new ArrayList(), measuredItemProvider, isVertical, isLookingAhead, hasLookaheadPassOccurred, coroutineScope);
            return new LazyListMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(layoutWidth2), Integer.valueOf(layoutHeight2), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope $this$invoke) {
                }
            }), 0.0f, false, CollectionsKt.emptyList(), -i2, mainAxisAvailableSize + afterContentPadding, 0, reverseLayout, isVertical ? Orientation.Vertical : Orientation.Horizontal, afterContentPadding, spaceBetweenItems);
        }
        int currentFirstItemIndex3 = firstVisibleItemIndex;
        int currentFirstItemScrollOffset4 = firstVisibleItemScrollOffset;
        if (currentFirstItemIndex3 >= itemsCount) {
            currentFirstItemIndex3 = itemsCount - 1;
            currentFirstItemScrollOffset4 = 0;
        }
        int scrollDelta3 = MathKt.roundToInt(scrollToBeConsumed);
        int currentFirstItemScrollOffset5 = currentFirstItemScrollOffset4 - scrollDelta3;
        if (currentFirstItemIndex3 == 0 && currentFirstItemScrollOffset5 < 0) {
            scrollDelta3 += currentFirstItemScrollOffset5;
            currentFirstItemScrollOffset5 = 0;
        }
        ArrayDeque visibleItems = new ArrayDeque();
        int minOffset = (-i2) + (spaceBetweenItems < 0 ? spaceBetweenItems : 0);
        int maxOffset2 = mainAxisAvailableSize;
        int currentFirstItemScrollOffset6 = currentFirstItemScrollOffset5 + minOffset;
        int maxCrossAxis2 = 0;
        boolean remeasureNeeded = false;
        while (currentFirstItemScrollOffset6 < 0 && currentFirstItemIndex3 > 0) {
            int previous = currentFirstItemIndex3 - 1;
            LazyListMeasuredItem measuredItem = measuredItemProvider.getAndMeasure(previous);
            visibleItems.add(i3, measuredItem);
            maxCrossAxis2 = Math.max(maxCrossAxis2, measuredItem.getCrossAxisSize());
            currentFirstItemScrollOffset6 += measuredItem.getSizeWithSpacings();
            currentFirstItemIndex3 = previous;
            i3 = 0;
        }
        int currentFirstItemIndex4 = currentFirstItemIndex3;
        if (currentFirstItemScrollOffset6 < minOffset) {
            scrollDelta3 += currentFirstItemScrollOffset6;
            currentFirstItemScrollOffset6 = minOffset;
        }
        int currentFirstItemIndex5 = currentFirstItemScrollOffset6 - minOffset;
        int index2 = currentFirstItemIndex4;
        int maxMainAxis = RangesKt.coerceAtLeast(maxOffset2 + afterContentPadding, 0);
        int currentMainAxisOffset2 = -currentFirstItemIndex5;
        int indexInVisibleItems = 0;
        while (true) {
            index = index2;
            int index3 = visibleItems.size();
            if (indexInVisibleItems >= index3) {
                break;
            }
            if (currentMainAxisOffset2 >= maxMainAxis) {
                visibleItems.remove(indexInVisibleItems);
                remeasureNeeded = true;
                index2 = index;
            } else {
                index2 = index + 1;
                currentMainAxisOffset2 += ((LazyListMeasuredItem) visibleItems.get(indexInVisibleItems)).getSizeWithSpacings();
                indexInVisibleItems++;
            }
        }
        boolean remeasureNeeded2 = remeasureNeeded;
        int currentMainAxisOffset3 = currentMainAxisOffset2;
        int currentMainAxisOffset4 = index;
        int currentFirstItemIndex6 = currentFirstItemIndex4;
        while (true) {
            if (currentMainAxisOffset4 >= itemsCount) {
                currentFirstItemIndex = currentFirstItemIndex6;
                currentFirstItemScrollOffset = currentFirstItemIndex5;
                break;
            }
            if (currentMainAxisOffset3 >= maxMainAxis && currentMainAxisOffset3 > 0 && !visibleItems.isEmpty()) {
                currentFirstItemIndex = currentFirstItemIndex6;
                currentFirstItemScrollOffset = currentFirstItemIndex5;
                break;
            }
            int currentFirstItemScrollOffset7 = currentFirstItemIndex6;
            LazyListMeasuredItem measuredItem2 = measuredItemProvider.getAndMeasure(currentMainAxisOffset4);
            currentMainAxisOffset3 += measuredItem2.getSizeWithSpacings();
            if (currentMainAxisOffset3 > minOffset) {
                currentFirstItemScrollOffset3 = currentFirstItemIndex5;
            } else {
                currentFirstItemScrollOffset3 = currentFirstItemIndex5;
                int currentFirstItemScrollOffset8 = itemsCount - 1;
                if (currentMainAxisOffset4 != currentFirstItemScrollOffset8) {
                    currentFirstItemScrollOffset7 = currentMainAxisOffset4 + 1;
                    currentFirstItemIndex5 = currentFirstItemScrollOffset3 - measuredItem2.getSizeWithSpacings();
                    remeasureNeeded2 = true;
                }
                currentMainAxisOffset4++;
                currentFirstItemIndex6 = currentFirstItemScrollOffset7;
            }
            int currentFirstItemScrollOffset9 = measuredItem2.getCrossAxisSize();
            int maxCrossAxis3 = Math.max(maxCrossAxis2, currentFirstItemScrollOffset9);
            visibleItems.add(measuredItem2);
            maxCrossAxis2 = maxCrossAxis3;
            currentFirstItemIndex5 = currentFirstItemScrollOffset3;
            currentMainAxisOffset4++;
            currentFirstItemIndex6 = currentFirstItemScrollOffset7;
        }
        int currentFirstItemIndex7 = scrollDelta3;
        if (currentMainAxisOffset3 < maxOffset2) {
            int toScrollBack = maxOffset2 - currentMainAxisOffset3;
            int currentFirstItemScrollOffset10 = currentFirstItemScrollOffset - toScrollBack;
            int currentMainAxisOffset5 = currentMainAxisOffset3 + toScrollBack;
            int maxCrossAxis4 = maxCrossAxis2;
            int maxCrossAxis5 = currentFirstItemScrollOffset10;
            while (true) {
                if (maxCrossAxis5 >= i2) {
                    scrollDelta2 = scrollDelta3;
                    maxOffset = maxOffset2;
                    break;
                }
                if (currentFirstItemIndex <= 0) {
                    scrollDelta2 = scrollDelta3;
                    maxOffset = maxOffset2;
                    break;
                }
                int scrollDelta4 = scrollDelta3;
                int scrollDelta5 = currentFirstItemIndex - 1;
                int maxOffset3 = maxOffset2;
                LazyListMeasuredItem measuredItem3 = measuredItemProvider.getAndMeasure(scrollDelta5);
                visibleItems.add(0, measuredItem3);
                maxCrossAxis4 = Math.max(maxCrossAxis4, measuredItem3.getCrossAxisSize());
                maxCrossAxis5 += measuredItem3.getSizeWithSpacings();
                currentFirstItemIndex = scrollDelta5;
                i2 = beforeContentPadding;
                scrollDelta3 = scrollDelta4;
                maxOffset2 = maxOffset3;
            }
            scrollDelta3 = scrollDelta2 + toScrollBack;
            if (maxCrossAxis5 >= 0) {
                int i4 = maxCrossAxis5;
                maxCrossAxis2 = maxCrossAxis4;
                maxCrossAxis = i4;
                currentMainAxisOffset = currentMainAxisOffset5;
                currentFirstItemIndex2 = currentFirstItemIndex;
            } else {
                scrollDelta3 += maxCrossAxis5;
                int currentMainAxisOffset6 = currentMainAxisOffset5 + maxCrossAxis5;
                maxCrossAxis2 = maxCrossAxis4;
                maxCrossAxis = 0;
                currentMainAxisOffset = currentMainAxisOffset6;
                currentFirstItemIndex2 = currentFirstItemIndex;
            }
        } else {
            maxOffset = maxOffset2;
            currentMainAxisOffset = currentMainAxisOffset3;
            currentFirstItemIndex2 = currentFirstItemIndex;
            maxCrossAxis = currentFirstItemScrollOffset;
        }
        float consumedScroll = (MathKt.getSign(MathKt.roundToInt(scrollToBeConsumed)) == MathKt.getSign(scrollDelta3) && Math.abs(MathKt.roundToInt(scrollToBeConsumed)) >= Math.abs(scrollDelta3)) ? scrollDelta3 : scrollToBeConsumed;
        float unconsumedScroll = scrollToBeConsumed - consumedScroll;
        float f = 0.0f;
        if (isLookingAhead && scrollDelta3 > currentFirstItemIndex7 && unconsumedScroll <= 0.0f) {
            f = (scrollDelta3 - currentFirstItemIndex7) + unconsumedScroll;
        }
        float scrollBackAmount = f;
        if (!(maxCrossAxis >= 0)) {
            throw new IllegalArgumentException("negative currentFirstItemScrollOffset".toString());
        }
        int visibleItemsScrollOffset = -maxCrossAxis;
        LazyListMeasuredItem firstItem = (LazyListMeasuredItem) visibleItems.first();
        if (beforeContentPadding > 0 || spaceBetweenItems < 0) {
            preScrollBackScrollDelta = currentFirstItemIndex7;
            int preScrollBackScrollDelta2 = visibleItems.size();
            scrollDelta = scrollDelta3;
            int scrollDelta6 = 0;
            while (scrollDelta6 < preScrollBackScrollDelta2) {
                int i5 = preScrollBackScrollDelta2;
                int size = ((LazyListMeasuredItem) visibleItems.get(scrollDelta6)).getSizeWithSpacings();
                if (maxCrossAxis == 0 || size > maxCrossAxis) {
                    break;
                }
                if (scrollDelta6 == CollectionsKt.getLastIndex(visibleItems)) {
                    break;
                }
                maxCrossAxis -= size;
                firstItem = (LazyListMeasuredItem) visibleItems.get(scrollDelta6 + 1);
                scrollDelta6++;
                preScrollBackScrollDelta2 = i5;
            }
            currentFirstItemScrollOffset2 = maxCrossAxis;
        } else {
            preScrollBackScrollDelta = currentFirstItemIndex7;
            scrollDelta = scrollDelta3;
            currentFirstItemScrollOffset2 = maxCrossAxis;
        }
        int maxCrossAxis6 = maxCrossAxis2;
        float consumedScroll2 = consumedScroll;
        List extraItemsBefore = createItemsBeforeList(currentFirstItemIndex2, measuredItemProvider, beyondBoundsItemCount, list2);
        int index$iv = 0;
        int maxCrossAxis7 = maxCrossAxis6;
        for (int maxCrossAxis8 = extraItemsBefore.size(); index$iv < maxCrossAxis8; maxCrossAxis8 = maxCrossAxis8) {
            Object item$iv = extraItemsBefore.get(index$iv);
            maxCrossAxis7 = Math.max(maxCrossAxis7, ((LazyListMeasuredItem) item$iv).getCrossAxisSize());
            index$iv++;
        }
        LazyListMeasuredItem firstItem2 = firstItem;
        List extraItemsAfter = createItemsAfterList(visibleItems, measuredItemProvider, itemsCount, beyondBoundsItemCount, list2, consumedScroll2, isLookingAhead, postLookaheadLayoutInfo);
        List $this$fastForEach$iv = extraItemsAfter;
        int index$iv2 = 0;
        int size2 = $this$fastForEach$iv.size();
        int maxCrossAxis9 = maxCrossAxis7;
        while (index$iv2 < size2) {
            Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
            maxCrossAxis9 = Math.max(maxCrossAxis9, ((LazyListMeasuredItem) item$iv2).getCrossAxisSize());
            index$iv2++;
            $this$fastForEach$iv = $this$fastForEach$iv;
        }
        boolean noExtraItems = Intrinsics.areEqual(firstItem2, visibleItems.first()) && extraItemsBefore.isEmpty() && extraItemsAfter.isEmpty();
        int layoutWidth3 = ConstraintsKt.m6267constrainWidthK40F9xA(constraints, isVertical ? maxCrossAxis9 : currentMainAxisOffset);
        int layoutHeight3 = ConstraintsKt.m6266constrainHeightK40F9xA(constraints, isVertical ? currentMainAxisOffset : maxCrossAxis9);
        final List positionedItems2 = calculateItemsOffsets(visibleItems, extraItemsBefore, extraItemsAfter, layoutWidth3, layoutHeight3, currentMainAxisOffset, maxOffset, visibleItemsScrollOffset, isVertical, verticalArrangement, horizontalArrangement, reverseLayout, density);
        int currentMainAxisOffset7 = currentMainAxisOffset;
        int maxOffset4 = maxOffset;
        itemAnimator.onMeasured((int) consumedScroll2, layoutWidth3, layoutHeight3, positionedItems2, measuredItemProvider, isVertical, isLookingAhead, hasLookaheadPassOccurred, coroutineScope);
        if (!list.isEmpty()) {
            lazyListMeasuredItemFindOrComposeLazyListHeader = LazyListHeadersKt.findOrComposeLazyListHeader(positionedItems2, measuredItemProvider, list, beforeContentPadding, layoutWidth3, layoutHeight3);
            i = beforeContentPadding;
            layoutWidth = layoutWidth3;
            layoutHeight = layoutHeight3;
        } else {
            i = beforeContentPadding;
            layoutWidth = layoutWidth3;
            layoutHeight = layoutHeight3;
            lazyListMeasuredItemFindOrComposeLazyListHeader = null;
        }
        final LazyListMeasuredItem headerItem = lazyListMeasuredItemFindOrComposeLazyListHeader;
        boolean z2 = currentMainAxisOffset4 < itemsCount || currentMainAxisOffset7 > maxOffset4;
        MeasureResult measureResultInvoke = function3.invoke(Integer.valueOf(layoutWidth), Integer.valueOf(layoutHeight), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$7
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
            public final void invoke2(Placeable.PlacementScope $this$invoke) {
                List $this$fastForEach$iv2 = positionedItems2;
                LazyListMeasuredItem lazyListMeasuredItem = headerItem;
                boolean z3 = isLookingAhead;
                int size3 = $this$fastForEach$iv2.size();
                for (int index$iv3 = 0; index$iv3 < size3; index$iv3++) {
                    Object item$iv3 = $this$fastForEach$iv2.get(index$iv3);
                    LazyListMeasuredItem it = (LazyListMeasuredItem) item$iv3;
                    if (it != lazyListMeasuredItem) {
                        it.place($this$invoke, z3);
                    }
                }
                LazyListMeasuredItem lazyListMeasuredItem2 = headerItem;
                if (lazyListMeasuredItem2 != null) {
                    lazyListMeasuredItem2.place($this$invoke, isLookingAhead);
                }
                ObservableScopeInvalidator.m935attachToScopeimpl(mutableState);
            }
        });
        if (noExtraItems) {
            arrayList = positionedItems2;
            positionedItems = arrayList;
            z = z2;
        } else {
            positionedItems = positionedItems2;
            ArrayList target$iv = new ArrayList(positionedItems2.size());
            List $this$fastForEach$iv$iv = positionedItems2;
            z = z2;
            int size3 = $this$fastForEach$iv$iv.size();
            int index$iv$iv = 0;
            while (index$iv$iv < size3) {
                LazyListMeasuredItem lazyListMeasuredItem = $this$fastForEach$iv$iv.get(index$iv$iv);
                List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                LazyListMeasuredItem it = lazyListMeasuredItem;
                int i6 = size3;
                int index4 = it.getIndex();
                int index$iv$iv2 = index$iv$iv;
                int index$iv$iv3 = ((LazyListMeasuredItem) visibleItems.first()).getIndex();
                if ((index4 >= index$iv$iv3 && it.getIndex() <= ((LazyListMeasuredItem) visibleItems.last()).getIndex()) || it == headerItem) {
                    target$iv.add(lazyListMeasuredItem);
                }
                index$iv$iv = index$iv$iv2 + 1;
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                size3 = i6;
            }
            arrayList = target$iv;
        }
        return new LazyListMeasureResult(firstItem2, currentFirstItemScrollOffset2, z, consumedScroll2, measureResultInvoke, scrollBackAmount, remeasureNeeded2, arrayList, -i, maxOffset4 + afterContentPadding, itemsCount, reverseLayout, isVertical ? Orientation.Vertical : Orientation.Horizontal, afterContentPadding, spaceBetweenItems);
    }

    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider measuredItemProvider, int itemsCount, int beyondBoundsItemCount, List<Integer> list2, float consumedScroll, boolean isLookingAhead, LazyListLayoutInfo lastPostLookaheadLayoutInfo) {
        boolean z;
        LazyListMeasuredItem item;
        Object it$iv;
        Object it$iv2;
        int i;
        int iMin;
        LazyListMeasuredItem lazyListMeasuredItem;
        Object it$iv3;
        int i2 = itemsCount;
        List list3 = null;
        int end = Math.min(((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + beyondBoundsItemCount, i2 - 1);
        boolean z2 = true;
        int i3 = ((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + 1;
        if (i3 <= end) {
            while (true) {
                if (list3 == null) {
                    Object list4 = new ArrayList();
                    list3 = (List) list4;
                }
                list3.add(measuredItemProvider.getAndMeasure(i3));
                if (i3 == end) {
                    break;
                }
                i3++;
            }
        }
        if (isLookingAhead && lastPostLookaheadLayoutInfo != null && !lastPostLookaheadLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            List $this$createItemsAfterList_u24lambda_u246 = lastPostLookaheadLayoutInfo.getVisibleItemsInfo();
            LazyListItemInfo found = null;
            for (int i4 = $this$createItemsAfterList_u24lambda_u246.size() - 1; -1 < i4; i4--) {
                if ($this$createItemsAfterList_u24lambda_u246.get(i4).getIndex() > end && (i4 == 0 || $this$createItemsAfterList_u24lambda_u246.get(i4 - 1).getIndex() <= end)) {
                    LazyListItemInfo found2 = $this$createItemsAfterList_u24lambda_u246.get(i4);
                    found = found2;
                    break;
                }
            }
            LazyListItemInfo lastVisibleItem = (LazyListItemInfo) CollectionsKt.last((List) lastPostLookaheadLayoutInfo.getVisibleItemsInfo());
            if (found != null && (i = found.getIndex()) <= (iMin = Math.min(lastVisibleItem.getIndex(), i2 - 1))) {
                while (true) {
                    if (list3 != null) {
                        List $this$fastFirstOrNull$iv = list3;
                        int index$iv$iv = 0;
                        z = z2;
                        int size = $this$fastFirstOrNull$iv.size();
                        while (true) {
                            if (index$iv$iv < size) {
                                Object item$iv$iv = $this$fastFirstOrNull$iv.get(index$iv$iv);
                                it$iv3 = item$iv$iv;
                                if (((LazyListMeasuredItem) it$iv3).getIndex() == i ? z : false) {
                                    break;
                                }
                                index$iv$iv++;
                            } else {
                                it$iv3 = null;
                                break;
                            }
                        }
                        lazyListMeasuredItem = (LazyListMeasuredItem) it$iv3;
                    } else {
                        z = z2;
                        lazyListMeasuredItem = null;
                    }
                    if (lazyListMeasuredItem == null) {
                        if (list3 == null) {
                            Object list5 = new ArrayList();
                            list3 = (List) list5;
                        }
                        list3.add(measuredItemProvider.getAndMeasure(i));
                    }
                    if (i == iMin) {
                        break;
                    }
                    i++;
                    z2 = z;
                }
            } else {
                z = true;
            }
            float additionalOffset = ((lastPostLookaheadLayoutInfo.getViewportEndOffset() - lastVisibleItem.getOffset()) - lastVisibleItem.getSize()) - consumedScroll;
            if (additionalOffset > 0.0f) {
                int index = lastVisibleItem.getIndex() + 1;
                int totalOffset = 0;
                while (index < i2 && totalOffset < additionalOffset) {
                    if (index > end) {
                        if (list3 == null) {
                            item = null;
                        } else {
                            List $this$fastFirstOrNull$iv2 = list3;
                            int index$iv$iv2 = 0;
                            int size2 = $this$fastFirstOrNull$iv2.size();
                            while (true) {
                                if (index$iv$iv2 < size2) {
                                    Object item$iv$iv2 = $this$fastFirstOrNull$iv2.get(index$iv$iv2);
                                    it$iv = item$iv$iv2;
                                    if (((LazyListMeasuredItem) it$iv).getIndex() == index ? z : false) {
                                        break;
                                    }
                                    index$iv$iv2++;
                                } else {
                                    it$iv = null;
                                    break;
                                }
                            }
                            item = (LazyListMeasuredItem) it$iv;
                        }
                    } else {
                        int index$iv$iv3 = 0;
                        int size3 = list.size();
                        while (true) {
                            if (index$iv$iv3 < size3) {
                                Object item$iv$iv3 = list.get(index$iv$iv3);
                                it$iv2 = item$iv$iv3;
                                if (((LazyListMeasuredItem) it$iv2).getIndex() == index ? z : false) {
                                    break;
                                }
                                index$iv$iv3++;
                            } else {
                                it$iv2 = null;
                                break;
                            }
                        }
                        item = (LazyListMeasuredItem) it$iv2;
                    }
                    if (item != null) {
                        index++;
                        totalOffset += item.getSizeWithSpacings();
                        i2 = itemsCount;
                    } else {
                        if (list3 == null) {
                            Object list6 = new ArrayList();
                            list3 = (List) list6;
                        }
                        list3.add(measuredItemProvider.getAndMeasure(index));
                        index++;
                        totalOffset += ((LazyListMeasuredItem) CollectionsKt.last(list3)).getSizeWithSpacings();
                        i2 = itemsCount;
                    }
                }
            }
        }
        if (list3 != null) {
            List it = list3;
            if (((LazyListMeasuredItem) CollectionsKt.last(it)).getIndex() > end) {
                end = ((LazyListMeasuredItem) CollectionsKt.last(it)).getIndex();
            }
        }
        int size4 = list2.size();
        for (int index$iv = 0; index$iv < size4; index$iv++) {
            Object item$iv = list2.get(index$iv);
            int index2 = ((Number) item$iv).intValue();
            if (index2 > end) {
                if (list3 == null) {
                    List list7 = new ArrayList();
                    list3 = list7;
                }
                list3.add(measuredItemProvider.getAndMeasure(index2));
            }
        }
        return list3 == null ? CollectionsKt.emptyList() : list3;
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int currentFirstItemIndex, LazyListMeasuredItemProvider measuredItemProvider, int beyondBoundsItemCount, List<Integer> list) {
        ArrayList arrayList = null;
        int start = Math.max(0, currentFirstItemIndex - beyondBoundsItemCount);
        int i = currentFirstItemIndex - 1;
        if (start <= i) {
            while (true) {
                if (arrayList == null) {
                    Object list2 = new ArrayList();
                    arrayList = (List) list2;
                }
                arrayList.add(measuredItemProvider.getAndMeasure(i));
                if (i == start) {
                    break;
                }
                i--;
            }
        }
        int size = list.size() - 1;
        if (size >= 0) {
            do {
                int index$iv = size;
                size--;
                Object item$iv = list.get(index$iv);
                int index = ((Number) item$iv).intValue();
                if (index < start) {
                    if (arrayList == null) {
                        Object list3 = new ArrayList();
                        arrayList = (List) list3;
                    }
                    arrayList.add(measuredItemProvider.getAndMeasure(index));
                }
            } while (size >= 0);
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int itemsScrollOffset, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density) {
        int size;
        List<LazyListMeasuredItem> list4 = list;
        int mainAxisLayoutSize = isVertical ? layoutHeight : layoutWidth;
        boolean hasSpareSpace = finalMainAxisOffset < Math.min(mainAxisLayoutSize, maxOffset);
        if (hasSpareSpace) {
            if (!(itemsScrollOffset == 0)) {
                throw new IllegalStateException("non-zero itemsScrollOffset".toString());
            }
        }
        ArrayList positionedItems = new ArrayList(list4.size() + list2.size() + list3.size());
        if (hasSpareSpace) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                throw new IllegalArgumentException("no extra items".toString());
            }
            int itemsCount = list4.size();
            int[] sizes = new int[itemsCount];
            for (int i = 0; i < itemsCount; i++) {
                sizes[i] = list4.get(calculateItemsOffsets$reverseAware(i, reverseLayout, itemsCount)).getSize();
            }
            int[] offsets = new int[itemsCount];
            for (int i2 = 0; i2 < itemsCount; i2++) {
                offsets[i2] = 0;
            }
            if (isVertical) {
                if (verticalArrangement != null) {
                    verticalArrangement.arrange(density, mainAxisLayoutSize, sizes, offsets);
                } else {
                    throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
                }
            } else if (horizontalArrangement != null) {
                horizontalArrangement.arrange(density, mainAxisLayoutSize, sizes, LayoutDirection.Ltr, offsets);
            } else {
                throw new IllegalArgumentException("null horizontalArrangement when isVertical == false".toString());
            }
            IntRange reverseAwareOffsetIndices = ArraysKt.getIndices(offsets);
            if (reverseLayout) {
                reverseAwareOffsetIndices = RangesKt.reversed(reverseAwareOffsetIndices);
            }
            int index = reverseAwareOffsetIndices.getFirst();
            int last = reverseAwareOffsetIndices.getLast();
            int step = reverseAwareOffsetIndices.getStep();
            if ((step > 0 && index <= last) || (step < 0 && last <= index)) {
                while (true) {
                    int absoluteOffset = offsets[index];
                    LazyListMeasuredItem item = list4.get(calculateItemsOffsets$reverseAware(index, reverseLayout, itemsCount));
                    if (reverseLayout) {
                        size = (mainAxisLayoutSize - absoluteOffset) - item.getSize();
                    } else {
                        size = absoluteOffset;
                    }
                    int relativeOffset = size;
                    item.position(relativeOffset, layoutWidth, layoutHeight);
                    positionedItems.add(item);
                    if (index == last) {
                        break;
                    }
                    index += step;
                    list4 = list;
                }
            }
        } else {
            int currentMainAxis = itemsScrollOffset;
            int size2 = list2.size();
            for (int index$iv = 0; index$iv < size2; index$iv++) {
                Object item$iv = list2.get(index$iv);
                LazyListMeasuredItem it = (LazyListMeasuredItem) item$iv;
                currentMainAxis -= it.getSizeWithSpacings();
                it.position(currentMainAxis, layoutWidth, layoutHeight);
                positionedItems.add(it);
            }
            int currentMainAxis2 = itemsScrollOffset;
            int size3 = list.size();
            for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
                Object item$iv2 = list.get(index$iv2);
                LazyListMeasuredItem it2 = (LazyListMeasuredItem) item$iv2;
                it2.position(currentMainAxis2, layoutWidth, layoutHeight);
                positionedItems.add(it2);
                currentMainAxis2 += it2.getSizeWithSpacings();
            }
            int size4 = list3.size();
            for (int index$iv3 = 0; index$iv3 < size4; index$iv3++) {
                Object item$iv3 = list3.get(index$iv3);
                LazyListMeasuredItem it3 = (LazyListMeasuredItem) item$iv3;
                it3.position(currentMainAxis2, layoutWidth, layoutHeight);
                positionedItems.add(it3);
                currentMainAxis2 += it3.getSizeWithSpacings();
            }
        }
        return positionedItems;
    }

    private static final int calculateItemsOffsets$reverseAware(int $this$calculateItemsOffsets_u24reverseAware, boolean $reverseLayout, int itemsCount) {
        return !$reverseLayout ? $this$calculateItemsOffsets_u24reverseAware : (itemsCount - $this$calculateItemsOffsets_u24reverseAware) - 1;
    }
}
