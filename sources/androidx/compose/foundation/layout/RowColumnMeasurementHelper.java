package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: RowColumnMeasurementHelper.kt */
@Metadata(m164d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012¢\u0006\u0002\u0010\u0014J2\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010&2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020+H\u0002J(\u00102\u001a\u0002032\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u0002032\u0006\u00102\u001a\u0002032\u0006\u00106\u001a\u000207H\u0002J0\u00108\u001a\u0002092\u0006\u00106\u001a\u0002072\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b>\u0010?J&\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020+2\u0006\u0010/\u001a\u000200J\n\u0010\n\u001a\u00020+*\u00020\u0013J\n\u0010F\u001a\u00020+*\u00020\u0013R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001b\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0018\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, m165d2 = {"Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;", "", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/foundation/layout/LayoutOrientation;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getArrangementSpacing-D9Ej5fM", "()F", "F", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisSize", "()Landroidx/compose/foundation/layout/SizeMode;", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getMeasurables", "()Ljava/util/List;", "getOrientation", "()Landroidx/compose/foundation/layout/LayoutOrientation;", "getPlaceables", "()[Landroidx/compose/ui/layout/Placeable;", "[Landroidx/compose/ui/layout/Placeable;", "rowColumnParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "[Landroidx/compose/foundation/layout/RowColumnParentData;", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getCrossAxisPosition", "", "placeable", "parentData", "crossAxisLayoutSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeCrossAxisAlignmentLine", "mainAxisPositions", "", "mainAxisLayoutSize", "childrenMainAxisSize", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measureWithoutPlacing", "Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "startIndex", "endIndex", "measureWithoutPlacing-_EkL_-Y", "(Landroidx/compose/ui/layout/MeasureScope;JII)Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "placeHelper", "", "placeableScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "measureResult", "crossAxisOffset", "mainAxisSize", "foundation-layout_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RowColumnMeasurementHelper {
    public static final int $stable = 8;
    private final float arrangementSpacing;
    private final CrossAxisAlignment crossAxisAlignment;
    private final SizeMode crossAxisSize;
    private final Arrangement.Horizontal horizontalArrangement;
    private final List<Measurable> measurables;
    private final LayoutOrientation orientation;
    private final Placeable[] placeables;
    private final RowColumnParentData[] rowColumnParentData;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment, List list, Placeable[] placeableArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutOrientation, horizontal, vertical, f, sizeMode, crossAxisAlignment, list, placeableArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RowColumnMeasurementHelper(LayoutOrientation orientation, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, float arrangementSpacing, SizeMode crossAxisSize, CrossAxisAlignment crossAxisAlignment, List<? extends Measurable> list, Placeable[] placeables) {
        this.orientation = orientation;
        this.horizontalArrangement = horizontalArrangement;
        this.verticalArrangement = verticalArrangement;
        this.arrangementSpacing = arrangementSpacing;
        this.crossAxisSize = crossAxisSize;
        this.crossAxisAlignment = crossAxisAlignment;
        this.measurables = list;
        this.placeables = placeables;
        int size = this.measurables.size();
        RowColumnParentData[] rowColumnParentDataArr = new RowColumnParentData[size];
        for (int i = 0; i < size; i++) {
            rowColumnParentDataArr[i] = RowColumnImplKt.getRowColumnParentData(this.measurables.get(i));
        }
        this.rowColumnParentData = rowColumnParentDataArr;
    }

    public final LayoutOrientation getOrientation() {
        return this.orientation;
    }

    public final Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public final Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    /* renamed from: getArrangementSpacing-D9Ej5fM, reason: not valid java name and from getter */
    public final float getArrangementSpacing() {
        return this.arrangementSpacing;
    }

    public final SizeMode getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final List<Measurable> getMeasurables() {
        return this.measurables;
    }

    public final Placeable[] getPlaceables() {
        return this.placeables;
    }

    public final int mainAxisSize(Placeable $this$mainAxisSize) {
        return this.orientation == LayoutOrientation.Horizontal ? $this$mainAxisSize.getWidth() : $this$mainAxisSize.getHeight();
    }

    public final int crossAxisSize(Placeable $this$crossAxisSize) {
        return this.orientation == LayoutOrientation.Horizontal ? $this$crossAxisSize.getHeight() : $this$crossAxisSize.getWidth();
    }

    /* renamed from: measureWithoutPlacing-_EkL_-Y, reason: not valid java name */
    public final RowColumnMeasureHelperResult m796measureWithoutPlacing_EkL_Y(MeasureScope measureScope, long constraints, int startIndex, int endIndex) {
        int subSize;
        int spaceAfterLastNoWeight;
        int targetSpace;
        int weightedSpace;
        int crossAxisSpace;
        int targetSpace2;
        long arrangementSpacingTotal;
        int i;
        int beforeCrossAxisAlignmentLine;
        int afterCrossAxisAlignmentLine;
        int crossAxisLayoutSize;
        int iCrossAxisSize;
        long fixedSpace;
        int i2;
        int subSize2;
        int spaceAfterLastNoWeight2;
        long j;
        int iCoerceAtLeast;
        long constraints2 = OrientationIndependentConstraints.m736constructorimpl(constraints, this.orientation);
        long arrangementSpacingPx = measureScope.mo512roundToPx0680j_4(this.arrangementSpacing);
        long fixedSpace2 = 0;
        int crossAxisSpace2 = 0;
        int subSize3 = endIndex - startIndex;
        int spaceAfterLastNoWeight3 = 0;
        float totalWeight = 0.0f;
        int weightChildrenCount = 0;
        char totalWeight2 = 0;
        int weightChildrenCount2 = startIndex;
        while (true) {
            subSize = subSize3;
            spaceAfterLastNoWeight = spaceAfterLastNoWeight3;
            char c = 1;
            if (weightChildrenCount2 >= endIndex) {
                break;
            }
            Measurable child = this.measurables.get(weightChildrenCount2);
            RowColumnParentData parentData = this.rowColumnParentData[weightChildrenCount2];
            float weight = RowColumnImplKt.getWeight(parentData);
            if (weight > 0.0f) {
                totalWeight += weight;
                weightChildrenCount++;
                i2 = weightChildrenCount2;
                subSize2 = subSize;
                spaceAfterLastNoWeight3 = spaceAfterLastNoWeight;
            } else {
                int iM6253getMaxWidthimpl = Constraints.m6253getMaxWidthimpl(constraints2);
                char c2 = totalWeight2;
                Placeable placeable = this.placeables[weightChildrenCount2];
                if (placeable == null) {
                    if (iM6253getMaxWidthimpl == Integer.MAX_VALUE) {
                        fixedSpace = fixedSpace2;
                        iCoerceAtLeast = Integer.MAX_VALUE;
                        j = 0;
                    } else {
                        fixedSpace = fixedSpace2;
                        long fixedSpace3 = iM6253getMaxWidthimpl;
                        j = 0;
                        iCoerceAtLeast = (int) RangesKt.coerceAtLeast(fixedSpace3 - fixedSpace, 0L);
                    }
                    int i3 = weightChildrenCount2;
                    int subSize4 = iCoerceAtLeast;
                    spaceAfterLastNoWeight2 = iM6253getMaxWidthimpl;
                    subSize2 = subSize;
                    i2 = i3;
                    placeable = child.mo5219measureBRTryo0(OrientationIndependentConstraints.m749toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m737copyyUG9Ft0(constraints2, (8 & 1) != 0 ? Constraints.m6255getMinWidthimpl(constraints2) : 0, (8 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(constraints2) : subSize4, (8 & 4) != 0 ? Constraints.m6254getMinHeightimpl(constraints2) : 0, (8 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(constraints2) : 0), this.orientation));
                } else {
                    fixedSpace = fixedSpace2;
                    i2 = weightChildrenCount2;
                    subSize2 = subSize;
                    spaceAfterLastNoWeight2 = iM6253getMaxWidthimpl;
                }
                int spaceAfterLastNoWeight4 = Math.min((int) arrangementSpacingPx, (int) RangesKt.coerceAtLeast((spaceAfterLastNoWeight2 - fixedSpace) - mainAxisSize(placeable), 0L));
                long fixedSpace4 = fixedSpace + mainAxisSize(placeable) + spaceAfterLastNoWeight4;
                crossAxisSpace2 = Math.max(crossAxisSpace2, crossAxisSize(placeable));
                if (c2 == 0 && !RowColumnImplKt.isRelative(parentData)) {
                    c = 0;
                }
                this.placeables[i2] = placeable;
                spaceAfterLastNoWeight3 = spaceAfterLastNoWeight4;
                fixedSpace2 = fixedSpace4;
                totalWeight2 = c;
            }
            weightChildrenCount2 = i2 + 1;
            subSize3 = subSize2;
        }
        char c3 = totalWeight2;
        long fixedSpace5 = fixedSpace2;
        int weightedSpace2 = 0;
        if (weightChildrenCount == 0) {
            fixedSpace5 -= spaceAfterLastNoWeight;
            weightedSpace = 0;
            crossAxisSpace = crossAxisSpace2;
        } else {
            if (totalWeight > 0.0f && Constraints.m6253getMaxWidthimpl(constraints2) != Integer.MAX_VALUE) {
                targetSpace = Constraints.m6253getMaxWidthimpl(constraints2);
            } else {
                targetSpace = Constraints.m6255getMinWidthimpl(constraints2);
            }
            long arrangementSpacingTotal2 = (weightChildrenCount - 1) * arrangementSpacingPx;
            long remainingToTarget = RangesKt.coerceAtLeast((targetSpace - fixedSpace5) - arrangementSpacingTotal2, 0L);
            float weightUnitSpace = totalWeight > 0.0f ? remainingToTarget / totalWeight : 0.0f;
            Iterator<Integer> it = RangesKt.until(startIndex, endIndex).iterator();
            int iRoundToInt = 0;
            while (it.hasNext()) {
                float weightUnitSpace2 = weightUnitSpace;
                iRoundToInt += MathKt.roundToInt(RowColumnImplKt.getWeight(this.rowColumnParentData[((IntIterator) it).nextInt()]) * weightUnitSpace2);
                weightUnitSpace = weightUnitSpace2;
            }
            float weightUnitSpace3 = weightUnitSpace;
            long remainder = remainingToTarget - iRoundToInt;
            int i4 = startIndex;
            while (i4 < endIndex) {
                if (this.placeables[i4] == null) {
                    Measurable child2 = this.measurables.get(i4);
                    long remainder2 = remainder;
                    RowColumnParentData parentData2 = this.rowColumnParentData[i4];
                    float weight2 = RowColumnImplKt.getWeight(parentData2);
                    if (!(weight2 > 0.0f)) {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                    int remainderUnit = MathKt.getSign(remainder2);
                    targetSpace2 = targetSpace;
                    arrangementSpacingTotal = arrangementSpacingTotal2;
                    long remainder3 = remainder2 - remainderUnit;
                    int childMainAxisSize = Math.max(0, MathKt.roundToInt(weightUnitSpace3 * weight2) + remainderUnit);
                    if (RowColumnImplKt.getFill(parentData2) && childMainAxisSize != Integer.MAX_VALUE) {
                        i = childMainAxisSize;
                    } else {
                        i = 0;
                    }
                    Placeable placeable2 = child2.mo5219measureBRTryo0(OrientationIndependentConstraints.m749toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m734constructorimpl(i, childMainAxisSize, 0, Constraints.m6252getMaxHeightimpl(constraints2)), this.orientation));
                    weightedSpace2 += mainAxisSize(placeable2);
                    crossAxisSpace2 = Math.max(crossAxisSpace2, crossAxisSize(placeable2));
                    c3 = (c3 != 0 || RowColumnImplKt.isRelative(parentData2)) ? (char) 1 : (char) 0;
                    this.placeables[i4] = placeable2;
                    remainder = remainder3;
                } else {
                    targetSpace2 = targetSpace;
                    arrangementSpacingTotal = arrangementSpacingTotal2;
                }
                i4++;
                targetSpace = targetSpace2;
                arrangementSpacingTotal2 = arrangementSpacingTotal;
            }
            weightedSpace = (int) RangesKt.coerceIn(weightedSpace2 + arrangementSpacingTotal2, 0L, Constraints.m6253getMaxWidthimpl(constraints2) - fixedSpace5);
            crossAxisSpace = crossAxisSpace2;
        }
        int beforeCrossAxisAlignmentLine2 = 0;
        int afterCrossAxisAlignmentLine2 = 0;
        if (c3 == 0) {
            beforeCrossAxisAlignmentLine = 0;
            afterCrossAxisAlignmentLine = 0;
        } else {
            for (int i5 = startIndex; i5 < endIndex; i5++) {
                Placeable placeable3 = this.placeables[i5];
                Intrinsics.checkNotNull(placeable3);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(this.rowColumnParentData[i5]);
                Integer alignmentLinePosition = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable3) : null;
                if (alignmentLinePosition != null) {
                    int it2 = alignmentLinePosition.intValue();
                    if (it2 == Integer.MIN_VALUE) {
                        it2 = 0;
                    }
                    beforeCrossAxisAlignmentLine2 = Math.max(beforeCrossAxisAlignmentLine2, it2);
                    int iCrossAxisSize2 = crossAxisSize(placeable3);
                    int it3 = alignmentLinePosition.intValue();
                    if (it3 != Integer.MIN_VALUE) {
                        iCrossAxisSize = it3;
                    } else {
                        iCrossAxisSize = crossAxisSize(placeable3);
                    }
                    afterCrossAxisAlignmentLine2 = Math.max(afterCrossAxisAlignmentLine2, iCrossAxisSize2 - iCrossAxisSize);
                }
            }
            beforeCrossAxisAlignmentLine = beforeCrossAxisAlignmentLine2;
            afterCrossAxisAlignmentLine = afterCrossAxisAlignmentLine2;
        }
        int mainAxisLayoutSize = Math.max((int) RangesKt.coerceAtLeast(fixedSpace5 + weightedSpace, 0L), Constraints.m6255getMinWidthimpl(constraints2));
        if (Constraints.m6252getMaxHeightimpl(constraints2) == Integer.MAX_VALUE || this.crossAxisSize != SizeMode.Expand) {
            crossAxisLayoutSize = Math.max(crossAxisSpace, Math.max(Constraints.m6254getMinHeightimpl(constraints2), beforeCrossAxisAlignmentLine + afterCrossAxisAlignmentLine));
        } else {
            crossAxisLayoutSize = Constraints.m6252getMaxHeightimpl(constraints2);
        }
        int[] mainAxisPositions = new int[subSize];
        for (int i6 = 0; i6 < subSize; i6++) {
            mainAxisPositions[i6] = 0;
        }
        int[] childrenMainAxisSize = new int[subSize];
        for (int i7 = 0; i7 < subSize; i7++) {
            Placeable placeable4 = this.placeables[i7 + startIndex];
            Intrinsics.checkNotNull(placeable4);
            childrenMainAxisSize[i7] = mainAxisSize(placeable4);
        }
        return new RowColumnMeasureHelperResult(crossAxisLayoutSize, mainAxisLayoutSize, startIndex, endIndex, beforeCrossAxisAlignmentLine, mainAxisPositions(mainAxisLayoutSize, childrenMainAxisSize, mainAxisPositions, measureScope));
    }

    private final int[] mainAxisPositions(int mainAxisLayoutSize, int[] childrenMainAxisSize, int[] mainAxisPositions, MeasureScope measureScope) {
        if (this.orientation == LayoutOrientation.Vertical) {
            Arrangement.Vertical $this$mainAxisPositions_u24lambda_u246 = this.verticalArrangement;
            if ($this$mainAxisPositions_u24lambda_u246 == null) {
                throw new IllegalArgumentException("null verticalArrangement in Column".toString());
            }
            $this$mainAxisPositions_u24lambda_u246.arrange(measureScope, mainAxisLayoutSize, childrenMainAxisSize, mainAxisPositions);
            return mainAxisPositions;
        }
        Arrangement.Horizontal $this$mainAxisPositions_u24lambda_u248 = this.horizontalArrangement;
        if ($this$mainAxisPositions_u24lambda_u248 == null) {
            throw new IllegalArgumentException("null horizontalArrangement in Row".toString());
        }
        $this$mainAxisPositions_u24lambda_u248.arrange(measureScope, mainAxisLayoutSize, childrenMainAxisSize, measureScope.getLayoutDirection(), mainAxisPositions);
        return mainAxisPositions;
    }

    private final int getCrossAxisPosition(Placeable placeable, RowColumnParentData parentData, int crossAxisLayoutSize, LayoutDirection layoutDirection, int beforeCrossAxisAlignmentLine) {
        CrossAxisAlignment childCrossAlignment;
        LayoutDirection layoutDirection2;
        if (parentData == null || (childCrossAlignment = parentData.getCrossAxisAlignment()) == null) {
            childCrossAlignment = this.crossAxisAlignment;
        }
        int iCrossAxisSize = crossAxisLayoutSize - crossAxisSize(placeable);
        if (this.orientation == LayoutOrientation.Horizontal) {
            layoutDirection2 = LayoutDirection.Ltr;
        } else {
            layoutDirection2 = layoutDirection;
        }
        return childCrossAlignment.align$foundation_layout_release(iCrossAxisSize, layoutDirection2, placeable, beforeCrossAxisAlignmentLine);
    }

    public final void placeHelper(Placeable.PlacementScope placeableScope, RowColumnMeasureHelperResult measureResult, int crossAxisOffset, LayoutDirection layoutDirection) {
        Placeable.PlacementScope $this$placeHelper_u24lambda_u249;
        Placeable.PlacementScope $this$placeHelper_u24lambda_u2492 = placeableScope;
        int i = measureResult.getStartIndex();
        int endIndex = measureResult.getEndIndex();
        int i2 = i;
        while (i2 < endIndex) {
            Placeable placeable = this.placeables[i2];
            Intrinsics.checkNotNull(placeable);
            int[] mainAxisPositions = measureResult.getMainAxisPositions();
            Object parentData = this.measurables.get(i2).getParentData();
            int crossAxisPosition = getCrossAxisPosition(placeable, parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null, measureResult.getCrossAxisSize(), layoutDirection, measureResult.getBeforeCrossAxisAlignmentLine()) + crossAxisOffset;
            if (this.orientation == LayoutOrientation.Horizontal) {
                $this$placeHelper_u24lambda_u249 = $this$placeHelper_u24lambda_u2492;
                Placeable.PlacementScope.place$default($this$placeHelper_u24lambda_u249, placeable, mainAxisPositions[i2 - measureResult.getStartIndex()], crossAxisPosition, 0.0f, 4, null);
            } else {
                $this$placeHelper_u24lambda_u249 = $this$placeHelper_u24lambda_u2492;
                Placeable.PlacementScope.place$default($this$placeHelper_u24lambda_u249, placeable, crossAxisPosition, mainAxisPositions[i2 - measureResult.getStartIndex()], 0.0f, 4, null);
            }
            i2++;
            $this$placeHelper_u24lambda_u2492 = $this$placeHelper_u24lambda_u249;
        }
    }
}
