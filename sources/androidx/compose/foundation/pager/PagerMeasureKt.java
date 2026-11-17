package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayout;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p000ui.Alignment;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: PagerMeasure.kt */
@Metadata(m164d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a@\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001aH\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0002\u001a@\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0002\u001a\u0017\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0082\b\u001a\u008c\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f*\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bH\u0002\u001aj\u0010\u0015\u001a\u00020\u0006*\u00020 2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010)\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001aé\u0001\u0010?\u001a\u00020@*\u00020 2\u0006\u0010A\u001a\u00020\b2\u0006\u00103\u001a\u0002042\u0006\u0010B\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u0002022\u0006\u0010)\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010:2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010+\u001a\u00020\u00012\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020G2/\u0010H\u001a+\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0002\bK\u0012\u0004\u0012\u00020L0IH\u0000ø\u0001\u0000¢\u0006\u0004\bM\u0010N\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006O"}, m165d2 = {"DEBUG", "", "MaxPageOffset", "", "MinPageOffset", "calculateNewCurrentPage", "Landroidx/compose/foundation/pager/MeasuredPage;", "viewportSize", "", "visiblePagesInfo", "", "beforeContentPadding", "afterContentPadding", "itemSize", "snapPositionInLayout", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "createPagesAfterList", "currentLastPage", "pagesCount", "beyondBoundsPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", "index", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "pageCount", "mainAxisAvailableSize", "currentPage", "currentPageOffset", "constraints", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-_JDW0YA", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerMeasureKt {
    private static final boolean DEBUG = false;
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    /* renamed from: measurePager-_JDW0YA, reason: not valid java name */
    public static final PagerMeasureResult m999measurePager_JDW0YA(final LazyLayoutMeasureScope $this$measurePager_u2d_JDW0YA, int pageCount, final PagerLazyLayoutItemProvider pagerItemProvider, int mainAxisAvailableSize, int beforeContentPadding, int afterContentPadding, int spaceBetweenPages, int currentPage, int currentPageOffset, long constraints, final Orientation orientation, final Alignment.Vertical verticalAlignment, final Alignment.Horizontal horizontalAlignment, final boolean reverseLayout, final long visualPageOffset, final int pageAvailableSize, int beyondBoundsPageCount, List<Integer> list, SnapPositionInLayout snapPositionInLayout, final MutableState<Unit> mutableState, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int iM6253getMaxWidthimpl;
        int iM6252getMaxHeightimpl;
        int currentFirstPageScrollOffset;
        int index;
        int indexInVisibleItems;
        int currentMainAxisOffset;
        int maxCrossAxis;
        int maxOffset;
        int maxOffset2;
        int index2;
        int currentMainAxisOffset2;
        int currentFirstPageScrollOffset2;
        int currentFirstPageScrollOffset3;
        MeasuredPage firstPage;
        int i;
        int i2;
        List visiblePagesInfo;
        float newCurrentPageOffsetFraction;
        int currentFirstPageScrollOffset4;
        int i3;
        int i4 = beforeContentPadding;
        boolean z = true;
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException("negative beforeContentPadding".toString());
        }
        if (!(afterContentPadding >= 0)) {
            throw new IllegalArgumentException("negative afterContentPadding".toString());
        }
        int pageSizeWithSpacing = RangesKt.coerceAtLeast(pageAvailableSize + spaceBetweenPages, 0);
        if (pageCount <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), pageAvailableSize, spaceBetweenPages, afterContentPadding, orientation, -i4, mainAxisAvailableSize + afterContentPadding, false, beyondBoundsPageCount, null, null, 0.0f, 0, false, function3.invoke(Integer.valueOf(Constraints.m6255getMinWidthimpl(constraints)), Integer.valueOf(Constraints.m6254getMinHeightimpl(constraints)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope $this$invoke) {
                }
            }), false);
        }
        Orientation orientation2 = orientation;
        if (orientation2 == Orientation.Vertical) {
            iM6253getMaxWidthimpl = Constraints.m6253getMaxWidthimpl(constraints);
        } else {
            iM6253getMaxWidthimpl = pageAvailableSize;
        }
        if (orientation2 != Orientation.Vertical) {
            iM6252getMaxHeightimpl = Constraints.m6252getMaxHeightimpl(constraints);
        } else {
            iM6252getMaxHeightimpl = pageAvailableSize;
        }
        final long childConstraints = ConstraintsKt.Constraints$default(0, iM6253getMaxWidthimpl, 0, iM6252getMaxHeightimpl, 5, null);
        int firstVisiblePage = currentPage;
        int firstVisiblePageOffset = currentPageOffset;
        while (firstVisiblePage > 0 && firstVisiblePageOffset > 0) {
            firstVisiblePage--;
            firstVisiblePageOffset -= pageSizeWithSpacing;
        }
        int firstVisiblePageScrollOffset = firstVisiblePageOffset * (-1);
        int currentFirstPage = firstVisiblePage;
        int currentFirstPageScrollOffset5 = firstVisiblePageScrollOffset;
        if (currentFirstPage >= pageCount) {
            currentFirstPage = pageCount - 1;
            currentFirstPageScrollOffset5 = 0;
        }
        ArrayDeque visiblePages = new ArrayDeque();
        int minOffset = (-i4) + (spaceBetweenPages < 0 ? spaceBetweenPages : 0);
        int previous = currentFirstPageScrollOffset5 + minOffset;
        int maxCrossAxis2 = 0;
        int currentFirstPage2 = currentFirstPage;
        while (previous < 0 && currentFirstPage2 > 0) {
            int currentFirstPageScrollOffset6 = previous;
            int currentFirstPageScrollOffset7 = currentFirstPage2 - 1;
            int pageSizeWithSpacing2 = pageSizeWithSpacing;
            ArrayDeque visiblePages2 = visiblePages;
            MeasuredPage measuredPage = m998getAndMeasureSGf7dI0($this$measurePager_u2d_JDW0YA, currentFirstPageScrollOffset7, childConstraints, pagerItemProvider, visualPageOffset, orientation2, horizontalAlignment, verticalAlignment, $this$measurePager_u2d_JDW0YA.getLayoutDirection(), reverseLayout, pageAvailableSize);
            visiblePages2.add(0, measuredPage);
            maxCrossAxis2 = Math.max(maxCrossAxis2, measuredPage.getCrossAxisSize());
            currentFirstPage2 = currentFirstPageScrollOffset7;
            orientation2 = orientation;
            visiblePages = visiblePages2;
            previous = currentFirstPageScrollOffset6 + pageSizeWithSpacing2;
            pageSizeWithSpacing = pageSizeWithSpacing2;
            minOffset = minOffset;
        }
        int pageSizeWithSpacing3 = pageSizeWithSpacing;
        int currentFirstPageScrollOffset8 = previous;
        ArrayDeque visiblePages3 = visiblePages;
        int minOffset2 = minOffset;
        int maxCrossAxis3 = maxCrossAxis2;
        if (currentFirstPageScrollOffset8 >= minOffset2) {
            currentFirstPageScrollOffset = currentFirstPageScrollOffset8;
        } else {
            currentFirstPageScrollOffset = minOffset2;
        }
        int currentFirstPageScrollOffset9 = currentFirstPageScrollOffset - minOffset2;
        int index3 = currentFirstPage2;
        int maxMainAxis = RangesKt.coerceAtLeast(mainAxisAvailableSize + afterContentPadding, 0);
        int currentMainAxisOffset3 = -currentFirstPageScrollOffset9;
        boolean remeasureNeeded = false;
        int indexInVisibleItems2 = 0;
        while (true) {
            index = index3;
            int index4 = visiblePages3.size();
            if (indexInVisibleItems2 >= index4) {
                break;
            }
            if (currentMainAxisOffset3 >= maxMainAxis) {
                visiblePages3.remove(indexInVisibleItems2);
                remeasureNeeded = true;
                index3 = index;
            } else {
                index3 = index + 1;
                currentMainAxisOffset3 += pageSizeWithSpacing3;
                indexInVisibleItems2++;
            }
        }
        int index5 = currentMainAxisOffset3;
        int currentFirstPage3 = currentFirstPage2;
        int currentFirstPageScrollOffset10 = currentFirstPageScrollOffset9;
        boolean remeasureNeeded2 = remeasureNeeded;
        int currentFirstPageScrollOffset11 = index;
        int maxCrossAxis4 = maxCrossAxis3;
        while (true) {
            if (currentFirstPageScrollOffset11 >= pageCount) {
                indexInVisibleItems = index5;
                currentMainAxisOffset = currentFirstPageScrollOffset11;
                maxCrossAxis = maxCrossAxis4;
                break;
            }
            if (index5 >= maxMainAxis && index5 > 0 && !visiblePages3.isEmpty()) {
                indexInVisibleItems = index5;
                currentMainAxisOffset = currentFirstPageScrollOffset11;
                maxCrossAxis = maxCrossAxis4;
                break;
            }
            int indexInVisibleItems3 = indexInVisibleItems2;
            int indexInVisibleItems4 = index5;
            int maxMainAxis2 = maxMainAxis;
            int maxCrossAxis5 = maxCrossAxis4;
            MeasuredPage measuredPage2 = m998getAndMeasureSGf7dI0($this$measurePager_u2d_JDW0YA, currentFirstPageScrollOffset11, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, $this$measurePager_u2d_JDW0YA.getLayoutDirection(), reverseLayout, pageAvailableSize);
            int index6 = currentFirstPageScrollOffset11;
            int index7 = pageCount - 1;
            if (index6 == index7) {
                i3 = pageAvailableSize;
            } else {
                i3 = pageSizeWithSpacing3;
            }
            int currentMainAxisOffset4 = indexInVisibleItems4 + i3;
            if (currentMainAxisOffset4 <= minOffset2 && index6 != pageCount - 1) {
                currentFirstPageScrollOffset10 -= pageSizeWithSpacing3;
                currentFirstPage3 = index6 + 1;
                remeasureNeeded2 = true;
            } else {
                maxCrossAxis5 = Math.max(maxCrossAxis5, measuredPage2.getCrossAxisSize());
                visiblePages3.add(measuredPage2);
            }
            maxCrossAxis4 = maxCrossAxis5;
            currentFirstPageScrollOffset11 = index6 + 1;
            index5 = currentMainAxisOffset4;
            indexInVisibleItems2 = indexInVisibleItems3;
            maxMainAxis = maxMainAxis2;
        }
        int index8 = mainAxisAvailableSize;
        if (indexInVisibleItems >= index8) {
            maxOffset = index8;
            maxOffset2 = currentMainAxisOffset;
            index2 = 0;
            currentMainAxisOffset2 = currentFirstPageScrollOffset10;
        } else {
            int toScrollBack = index8 - indexInVisibleItems;
            indexInVisibleItems += toScrollBack;
            int previousIndex = currentFirstPageScrollOffset10 - toScrollBack;
            while (true) {
                if (previousIndex >= i4) {
                    maxOffset = index8;
                    maxOffset2 = currentMainAxisOffset;
                    currentFirstPageScrollOffset4 = previousIndex;
                    index2 = 0;
                    break;
                }
                if (currentFirstPage3 <= 0) {
                    maxOffset = index8;
                    maxOffset2 = currentMainAxisOffset;
                    currentFirstPageScrollOffset4 = previousIndex;
                    index2 = 0;
                    break;
                }
                int currentFirstPageScrollOffset12 = previousIndex;
                int currentFirstPageScrollOffset13 = currentFirstPage3 - 1;
                int maxOffset3 = index8;
                int maxOffset4 = currentMainAxisOffset;
                MeasuredPage measuredPage3 = m998getAndMeasureSGf7dI0($this$measurePager_u2d_JDW0YA, currentFirstPageScrollOffset13, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, $this$measurePager_u2d_JDW0YA.getLayoutDirection(), reverseLayout, pageAvailableSize);
                visiblePages3.add(0, measuredPage3);
                maxCrossAxis = Math.max(maxCrossAxis, measuredPage3.getCrossAxisSize());
                currentFirstPage3 = currentFirstPageScrollOffset13;
                i4 = beforeContentPadding;
                currentMainAxisOffset = maxOffset4;
                previousIndex = currentFirstPageScrollOffset12 + pageSizeWithSpacing3;
                index8 = maxOffset3;
            }
            if (currentFirstPageScrollOffset4 >= 0) {
                currentMainAxisOffset2 = currentFirstPageScrollOffset4;
            } else {
                int currentMainAxisOffset5 = indexInVisibleItems + currentFirstPageScrollOffset4;
                indexInVisibleItems = currentMainAxisOffset5;
                currentMainAxisOffset2 = 0;
            }
        }
        if ((currentMainAxisOffset2 >= 0 ? 1 : index2) == 0) {
            throw new IllegalArgumentException("invalid currentFirstPageScrollOffset".toString());
        }
        int visiblePagesScrollOffset = -currentMainAxisOffset2;
        MeasuredPage firstPage2 = (MeasuredPage) visiblePages3.first();
        if (beforeContentPadding > 0 || spaceBetweenPages < 0) {
            int i5 = 0;
            int size = visiblePages3.size();
            while (true) {
                if (i5 >= size) {
                    currentFirstPageScrollOffset2 = currentMainAxisOffset2;
                    break;
                }
                if (currentMainAxisOffset2 == 0) {
                    currentFirstPageScrollOffset2 = currentMainAxisOffset2;
                    break;
                }
                if (pageSizeWithSpacing3 > currentMainAxisOffset2) {
                    currentFirstPageScrollOffset2 = currentMainAxisOffset2;
                    break;
                }
                currentFirstPageScrollOffset2 = currentMainAxisOffset2;
                int currentFirstPageScrollOffset14 = CollectionsKt.getLastIndex(visiblePages3);
                if (i5 == currentFirstPageScrollOffset14) {
                    break;
                }
                int currentFirstPageScrollOffset15 = i5 + 1;
                firstPage2 = (MeasuredPage) visiblePages3.get(currentFirstPageScrollOffset15);
                i5++;
                currentMainAxisOffset2 = currentFirstPageScrollOffset2 - pageSizeWithSpacing3;
            }
            currentFirstPageScrollOffset3 = currentFirstPageScrollOffset2;
            firstPage = firstPage2;
        } else {
            currentFirstPageScrollOffset3 = currentMainAxisOffset2;
            firstPage = firstPage2;
        }
        int maxCrossAxis6 = maxCrossAxis;
        int maxCrossAxis7 = currentFirstPage3;
        List extraPagesBefore = createPagesBeforeList(maxCrossAxis7, beyondBoundsPageCount, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int it) {
                return PagerMeasureKt.m998getAndMeasureSGf7dI0($this$measurePager_u2d_JDW0YA, it, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, $this$measurePager_u2d_JDW0YA.getLayoutDirection(), reverseLayout, pageAvailableSize);
            }
        });
        int size2 = extraPagesBefore.size();
        int index$iv = 0;
        int maxCrossAxis8 = maxCrossAxis6;
        while (index$iv < size2) {
            Object item$iv = extraPagesBefore.get(index$iv);
            maxCrossAxis8 = Math.max(maxCrossAxis8, ((MeasuredPage) item$iv).getCrossAxisSize());
            index$iv++;
            visiblePages3 = visiblePages3;
        }
        ArrayDeque visiblePages4 = visiblePages3;
        List extraPagesAfter = createPagesAfterList(((MeasuredPage) visiblePages4.last()).getIndex(), pageCount, beyondBoundsPageCount, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int it) {
                return PagerMeasureKt.m998getAndMeasureSGf7dI0($this$measurePager_u2d_JDW0YA, it, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, $this$measurePager_u2d_JDW0YA.getLayoutDirection(), reverseLayout, pageAvailableSize);
            }
        });
        int size3 = extraPagesAfter.size();
        int maxCrossAxis9 = maxCrossAxis8;
        for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
            Object item$iv2 = extraPagesAfter.get(index$iv2);
            maxCrossAxis9 = Math.max(maxCrossAxis9, ((MeasuredPage) item$iv2).getCrossAxisSize());
        }
        boolean noExtraPages = Intrinsics.areEqual(firstPage, visiblePages4.first()) && extraPagesBefore.isEmpty() && extraPagesAfter.isEmpty();
        if (orientation == Orientation.Vertical) {
            i = maxCrossAxis9;
        } else {
            i = indexInVisibleItems;
        }
        int layoutWidth = ConstraintsKt.m6267constrainWidthK40F9xA(constraints, i);
        if (orientation == Orientation.Vertical) {
            i2 = indexInVisibleItems;
        } else {
            i2 = maxCrossAxis9;
        }
        int layoutHeight = ConstraintsKt.m6266constrainHeightK40F9xA(constraints, i2);
        int currentMainAxisOffset6 = indexInVisibleItems;
        int maxOffset5 = maxOffset;
        final List positionedPages = calculatePagesOffsets($this$measurePager_u2d_JDW0YA, visiblePages4, extraPagesBefore, extraPagesAfter, layoutWidth, layoutHeight, currentMainAxisOffset6, maxOffset5, visiblePagesScrollOffset, orientation, reverseLayout, $this$measurePager_u2d_JDW0YA, spaceBetweenPages, pageAvailableSize);
        if (noExtraPages) {
            visiblePagesInfo = positionedPages;
        } else {
            int $i$f$fastFilter = 0;
            ArrayList target$iv = new ArrayList(positionedPages.size());
            int index$iv$iv = 0;
            int size4 = positionedPages.size();
            while (index$iv$iv < size4) {
                MeasuredPage measuredPage4 = positionedPages.get(index$iv$iv);
                MeasuredPage it = measuredPage4;
                int i6 = size4;
                int index9 = it.getIndex();
                int $i$f$fastFilter2 = $i$f$fastFilter;
                int $i$f$fastFilter3 = ((MeasuredPage) visiblePages4.first()).getIndex();
                if (index9 >= $i$f$fastFilter3 && it.getIndex() <= ((MeasuredPage) visiblePages4.last()).getIndex()) {
                    target$iv.add(measuredPage4);
                }
                index$iv$iv++;
                size4 = i6;
                $i$f$fastFilter = $i$f$fastFilter2;
            }
            visiblePagesInfo = target$iv;
        }
        MeasuredPage firstPage3 = firstPage;
        MeasuredPage newCurrentPage = calculateNewCurrentPage(orientation == Orientation.Vertical ? layoutHeight : layoutWidth, visiblePagesInfo, beforeContentPadding, afterContentPadding, pageSizeWithSpacing3, snapPositionInLayout);
        int currentPagePositionOffset = newCurrentPage != null ? newCurrentPage.getOffset() : 0;
        if (pageSizeWithSpacing3 == 0) {
            newCurrentPageOffsetFraction = 0.0f;
        } else {
            newCurrentPageOffsetFraction = RangesKt.coerceIn((-currentPagePositionOffset) / pageSizeWithSpacing3, -0.5f, 0.5f);
        }
        MeasureResult measureResultInvoke = function3.invoke(Integer.valueOf(layoutWidth), Integer.valueOf(layoutHeight), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$9
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
                List $this$fastForEach$iv = positionedPages;
                int size5 = $this$fastForEach$iv.size();
                for (int index$iv3 = 0; index$iv3 < size5; index$iv3++) {
                    Object item$iv3 = $this$fastForEach$iv.get(index$iv3);
                    MeasuredPage it2 = (MeasuredPage) item$iv3;
                    it2.place($this$invoke);
                }
                ObservableScopeInvalidator.m935attachToScopeimpl(mutableState);
            }
        });
        int i7 = -beforeContentPadding;
        int i8 = maxOffset5 + afterContentPadding;
        if (maxOffset2 >= pageCount && currentMainAxisOffset6 <= maxOffset5) {
            z = false;
        }
        return new PagerMeasureResult(visiblePagesInfo, pageAvailableSize, spaceBetweenPages, afterContentPadding, orientation, i7, i8, reverseLayout, beyondBoundsPageCount, firstPage3, newCurrentPage, newCurrentPageOffsetFraction, currentFirstPageScrollOffset3, z, measureResultInvoke, remeasureNeeded2);
    }

    private static final List<MeasuredPage> createPagesAfterList(int currentLastPage, int pagesCount, int beyondBoundsPageCount, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        ArrayList arrayList = null;
        int end = Math.min(currentLastPage + beyondBoundsPageCount, pagesCount - 1);
        int i = currentLastPage + 1;
        if (i <= end) {
            while (true) {
                if (arrayList == null) {
                    Object list2 = new ArrayList();
                    arrayList = (List) list2;
                }
                arrayList.add(function1.invoke(Integer.valueOf(i)));
                if (i == end) {
                    break;
                }
                i++;
            }
        }
        int size = list.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = list.get(index$iv);
            int pageIndex = ((Number) item$iv).intValue();
            boolean z = false;
            if (end + 1 <= pageIndex && pageIndex < pagesCount) {
                z = true;
            }
            if (z) {
                if (arrayList == null) {
                    Object list3 = new ArrayList();
                    arrayList = (List) list3;
                }
                arrayList.add(function1.invoke(Integer.valueOf(pageIndex)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int currentFirstPage, int beyondBoundsPageCount, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        ArrayList arrayList = null;
        int start = Math.max(0, currentFirstPage - beyondBoundsPageCount);
        int i = currentFirstPage - 1;
        if (start <= i) {
            while (true) {
                if (arrayList == null) {
                    Object list2 = new ArrayList();
                    arrayList = (List) list2;
                }
                arrayList.add(function1.invoke(Integer.valueOf(i)));
                if (i == start) {
                    break;
                }
                i--;
            }
        }
        int size = list.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = list.get(index$iv);
            int pageIndex = ((Number) item$iv).intValue();
            if (pageIndex < start) {
                if (arrayList == null) {
                    Object list3 = new ArrayList();
                    arrayList = (List) list3;
                }
                arrayList.add(function1.invoke(Integer.valueOf(pageIndex)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final MeasuredPage calculateNewCurrentPage(int viewportSize, List<MeasuredPage> list, int beforeContentPadding, int afterContentPadding, int itemSize, SnapPositionInLayout snapPositionInLayout) {
        Object maxElem$iv;
        if (list.isEmpty()) {
            maxElem$iv = null;
        } else {
            maxElem$iv = list.get(0);
            MeasuredPage it = (MeasuredPage) maxElem$iv;
            float maxValue$iv = -Math.abs(SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(viewportSize, beforeContentPadding, afterContentPadding, itemSize, it.getOffset(), it.getIndex(), snapPositionInLayout));
            int i$iv = 1;
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                while (true) {
                    Object e$iv = list.get(i$iv);
                    MeasuredPage it2 = (MeasuredPage) e$iv;
                    float v$iv = -Math.abs(SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(viewportSize, beforeContentPadding, afterContentPadding, itemSize, it2.getOffset(), it2.getIndex(), snapPositionInLayout));
                    if (Float.compare(maxValue$iv, v$iv) < 0) {
                        maxElem$iv = e$iv;
                        maxValue$iv = v$iv;
                    }
                    if (i$iv == lastIndex) {
                        break;
                    }
                    i$iv++;
                }
            }
        }
        return (MeasuredPage) maxElem$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAndMeasure-SGf7dI0, reason: not valid java name */
    public static final MeasuredPage m998getAndMeasureSGf7dI0(LazyLayoutMeasureScope $this$getAndMeasure_u2dSGf7dI0, int index, long childConstraints, PagerLazyLayoutItemProvider pagerItemProvider, long visualPageOffset, Orientation orientation, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, LayoutDirection layoutDirection, boolean reverseLayout, int pageAvailableSize) {
        Object key = pagerItemProvider.getKey(index);
        List placeable = $this$getAndMeasure_u2dSGf7dI0.mo931measure0kLqBqw(index, childConstraints);
        return new MeasuredPage(index, pageAvailableSize, placeable, visualPageOffset, key, orientation, horizontalAlignment, verticalAlignment, layoutDirection, reverseLayout, null);
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope $this$calculatePagesOffsets, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int pagesScrollOffset, Orientation orientation, boolean reverseLayout, Density density, int spaceBetweenPages, int pageAvailableSize) {
        ArrayList positionedPages;
        int pagesCount;
        int size;
        int pageSizeWithSpacing = pageAvailableSize + spaceBetweenPages;
        int mainAxisLayoutSize = orientation == Orientation.Vertical ? layoutHeight : layoutWidth;
        boolean hasSpareSpace = finalMainAxisOffset < Math.min(mainAxisLayoutSize, maxOffset);
        if (hasSpareSpace) {
            if (!(pagesScrollOffset == 0)) {
                throw new IllegalStateException(("non-zero pagesScrollOffset=" + pagesScrollOffset).toString());
            }
        }
        ArrayList positionedPages2 = new ArrayList(list.size() + list2.size() + list3.size());
        if (hasSpareSpace) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                throw new IllegalArgumentException("No extra pages".toString());
            }
            int pagesCount2 = list.size();
            int[] sizes = new int[pagesCount2];
            for (int i = 0; i < pagesCount2; i++) {
                sizes[i] = pageAvailableSize;
            }
            int[] offsets = new int[pagesCount2];
            for (int i2 = 0; i2 < pagesCount2; i2++) {
                offsets[i2] = 0;
            }
            Arrangement.HorizontalOrVertical arrangement = Arrangement.Absolute.INSTANCE.m679spacedBy0680j_4($this$calculatePagesOffsets.mo515toDpu2uoSUM(spaceBetweenPages));
            if (orientation == Orientation.Vertical) {
                arrangement.arrange(density, mainAxisLayoutSize, sizes, offsets);
                positionedPages = positionedPages2;
                pagesCount = pagesCount2;
            } else {
                positionedPages = positionedPages2;
                pagesCount = pagesCount2;
                arrangement.arrange(density, mainAxisLayoutSize, sizes, LayoutDirection.Ltr, offsets);
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
                    int pagesCount3 = pagesCount;
                    MeasuredPage page = list.get(calculatePagesOffsets$reverseAware(index, reverseLayout, pagesCount));
                    if (reverseLayout) {
                        size = (mainAxisLayoutSize - absoluteOffset) - page.getSize();
                    } else {
                        size = absoluteOffset;
                    }
                    int relativeOffset = size;
                    page.position(relativeOffset, layoutWidth, layoutHeight);
                    positionedPages.add(page);
                    if (index == last) {
                        break;
                    }
                    index += step;
                    pagesCount = pagesCount3;
                }
            }
        } else {
            positionedPages = positionedPages2;
            int currentMainAxis = pagesScrollOffset;
            int size2 = list2.size();
            for (int index$iv = 0; index$iv < size2; index$iv++) {
                Object item$iv = list2.get(index$iv);
                MeasuredPage it = (MeasuredPage) item$iv;
                currentMainAxis -= pageSizeWithSpacing;
                it.position(currentMainAxis, layoutWidth, layoutHeight);
                positionedPages.add(it);
            }
            int currentMainAxis2 = pagesScrollOffset;
            int size3 = list.size();
            for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
                Object item$iv2 = list.get(index$iv2);
                MeasuredPage it2 = (MeasuredPage) item$iv2;
                it2.position(currentMainAxis2, layoutWidth, layoutHeight);
                positionedPages.add(it2);
                currentMainAxis2 += pageSizeWithSpacing;
            }
            int size4 = list3.size();
            for (int index$iv3 = 0; index$iv3 < size4; index$iv3++) {
                Object item$iv3 = list3.get(index$iv3);
                MeasuredPage it3 = (MeasuredPage) item$iv3;
                it3.position(currentMainAxis2, layoutWidth, layoutHeight);
                positionedPages.add(it3);
                currentMainAxis2 += pageSizeWithSpacing;
            }
        }
        return positionedPages;
    }

    private static final int calculatePagesOffsets$reverseAware(int $this$calculatePagesOffsets_u24reverseAware, boolean $reverseLayout, int pagesCount) {
        return !$reverseLayout ? $this$calculatePagesOffsets_u24reverseAware : (pagesCount - $this$calculatePagesOffsets_u24reverseAware) - 1;
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
