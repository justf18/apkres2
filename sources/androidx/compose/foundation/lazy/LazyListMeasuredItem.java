package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimationKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* compiled from: LazyListMeasuredItem.kt */
@Metadata(m164d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0083\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u0016\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\bJ\u001b\u0010,\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u0010\u0010B\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u0010C\u001a\u00020=2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\bJ\u001e\u0010G\u001a\u00020=2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0003J+\u0010J\u001a\u00020\u0014*\u00020\u00142\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030LH\u0082\bø\u0001\u0000¢\u0006\u0004\bM\u0010NR\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010!R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010!\"\u0004\b(\u0010)R\u001e\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u001fR\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0011\u00103\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u00020\u0014X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00105R\u0018\u00106\u001a\u00020\u0003*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0018\u00109\u001a\u00020\u0003*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006O"}, m165d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "contentType", "animator", "Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIIJLjava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/LazyListItemAnimator;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentType", "()Ljava/lang/Object;", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "getKey", "mainAxisLayoutSize", "maxMainAxisOffset", "minMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "<set-?>", TypedValues.CycleType.S_WAVE_OFFSET, "getOffset", "placeableOffsets", "", "placeablesCount", "getPlaceablesCount", "size", "getSize", "sizeWithSpacings", "getSizeWithSpacings", "J", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "updateAnimations", "getOffset-Bjo55l4", "(I)J", "getParentData", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "isLookingAhead", "position", "layoutWidth", "layoutHeight", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyListMeasuredItem implements LazyListItemInfo {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyListItemAnimator animator;
    private final int beforeContentPadding;
    private final Object contentType;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int sizeWithSpacings;
    private final int spacing;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyListItemAnimator lazyListItemAnimator, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z, horizontal, vertical, layoutDirection, z2, i2, i3, i4, j, obj, obj2, lazyListItemAnimator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyListMeasuredItem(int index, List<? extends Placeable> list, boolean isVertical, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, LayoutDirection layoutDirection, boolean reverseLayout, int beforeContentPadding, int afterContentPadding, int spacing, long visualOffset, Object key, Object contentType, LazyListItemAnimator animator) {
        this.index = index;
        this.placeables = list;
        this.isVertical = isVertical;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = reverseLayout;
        this.beforeContentPadding = beforeContentPadding;
        this.afterContentPadding = afterContentPadding;
        this.spacing = spacing;
        this.visualOffset = visualOffset;
        this.key = key;
        this.contentType = contentType;
        this.animator = animator;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        List $this$fastForEach$iv = this.placeables;
        int size = $this$fastForEach$iv.size();
        int maxCrossAxis = 0;
        int mainAxisSize = 0;
        int index$iv = 0;
        while (index$iv < size) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            Placeable it = (Placeable) item$iv;
            List $this$fastForEach$iv2 = $this$fastForEach$iv;
            mainAxisSize += this.isVertical ? it.getHeight() : it.getWidth();
            maxCrossAxis = Math.max(maxCrossAxis, !this.isVertical ? it.getHeight() : it.getWidth());
            index$iv++;
            $this$fastForEach$iv = $this$fastForEach$iv2;
        }
        this.size = mainAxisSize;
        this.sizeWithSpacings = RangesKt.coerceAtLeast(getSize() + this.spacing, 0);
        this.crossAxisSize = maxCrossAxis;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getIndex() {
        return this.index;
    }

    /* renamed from: isVertical, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    public final void setNonScrollableItem(boolean z) {
        this.nonScrollableItem = z;
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final Object getParentData(int index) {
        return this.placeables.get(index).getParentData();
    }

    public final void position(int offset, int layoutWidth, int layoutHeight) {
        this.offset = offset;
        this.mainAxisLayoutSize = this.isVertical ? layoutHeight : layoutWidth;
        int mainAxisOffset = offset;
        List $this$fastForEachIndexed$iv = this.placeables;
        int size = $this$fastForEachIndexed$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
            Placeable placeable = (Placeable) item$iv;
            int index = index$iv;
            int indexInArray = index * 2;
            if (!this.isVertical) {
                this.placeableOffsets[indexInArray] = mainAxisOffset;
                int[] iArr = this.placeableOffsets;
                int i = indexInArray + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalAlignment when isVertical == false".toString());
                }
                iArr[i] = vertical.align(placeable.getHeight(), layoutHeight);
                mainAxisOffset += placeable.getWidth();
            } else {
                int[] iArr2 = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal != null) {
                    iArr2[indexInArray] = horizontal.align(placeable.getWidth(), layoutWidth, this.layoutDirection);
                    this.placeableOffsets[indexInArray + 1] = mainAxisOffset;
                    mainAxisOffset += placeable.getHeight();
                } else {
                    throw new IllegalArgumentException("null horizontalAlignment when isVertical == true".toString());
                }
            }
        }
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    /* renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public final long m879getOffsetBjo55l4(int index) {
        return IntOffsetKt.IntOffset(this.placeableOffsets[index * 2], this.placeableOffsets[(index * 2) + 1]);
    }

    public final void applyScrollDelta(int delta, boolean updateAnimations) {
        int iIntValue;
        int mainAxis;
        if (this.nonScrollableItem) {
            return;
        }
        this.offset = getOffset() + delta;
        int length = this.placeableOffsets.length;
        for (int i = 0; i < length; i++) {
            int index = i;
            if ((this.isVertical && index % 2 == 1) || (!this.isVertical && index % 2 == 0)) {
                int[] iArr = this.placeableOffsets;
                iArr[index] = iArr[index] + delta;
            }
        }
        if (updateAnimations) {
            int placeablesCount = getPlaceablesCount();
            for (int index2 = 0; index2 < placeablesCount; index2++) {
                LazyLayoutAnimation animation = this.animator.getAnimation(getKey(), index2);
                if (animation != null) {
                    long $this$copy_u2d4Tuh3kE$iv = animation.getRawOffset();
                    if (this.isVertical) {
                        iIntValue = IntOffset.m6425getXimpl($this$copy_u2d4Tuh3kE$iv);
                    } else {
                        int mainAxis2 = IntOffset.m6425getXimpl($this$copy_u2d4Tuh3kE$iv);
                        iIntValue = Integer.valueOf(mainAxis2 + delta).intValue();
                    }
                    if (this.isVertical) {
                        int mainAxis3 = IntOffset.m6426getYimpl($this$copy_u2d4Tuh3kE$iv);
                        mainAxis = mainAxis3 + delta;
                    } else {
                        mainAxis = IntOffset.m6426getYimpl($this$copy_u2d4Tuh3kE$iv);
                    }
                    animation.m920setRawOffsetgyyYBs(IntOffsetKt.IntOffset(iIntValue, mainAxis));
                }
            }
        }
    }

    public final void place(Placeable.PlacementScope scope, boolean isLookingAhead) {
        Placeable.PlacementScope $this$place_u24lambda_u2410;
        Function1 layerBlock;
        int mainAxisSize;
        int iM6426getYimpl;
        long targetOffset;
        LazyLayoutAnimation animation;
        Placeable.PlacementScope $this$place_u24lambda_u24102 = scope;
        if (!(this.mainAxisLayoutSize != Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("position() should be called first".toString());
        }
        int placeablesCount = getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            int index = i;
            Placeable placeable = this.placeables.get(index);
            int minOffset = this.minMainAxisOffset - getMainAxisSize(placeable);
            int maxOffset = this.maxMainAxisOffset;
            long targetOffset2 = m879getOffsetBjo55l4(index);
            LazyLayoutAnimation animation2 = this.animator.getAnimation(getKey(), index);
            if (animation2 != null) {
                if (isLookingAhead) {
                    animation2.m919setLookaheadOffsetgyyYBs(targetOffset2);
                    $this$place_u24lambda_u2410 = $this$place_u24lambda_u24102;
                    animation = animation2;
                } else {
                    long lookaheadOffset = animation2.getLookaheadOffset();
                    long offset = LazyLayoutAnimation.INSTANCE.m921getNotInitializednOccac();
                    if (!IntOffset.m6424equalsimpl0(lookaheadOffset, offset)) {
                        targetOffset = animation2.getLookaheadOffset();
                    } else {
                        targetOffset = targetOffset2;
                    }
                    long other$iv = animation2.m917getPlacementDeltanOccac();
                    $this$place_u24lambda_u2410 = $this$place_u24lambda_u24102;
                    animation = animation2;
                    long other$iv2 = IntOffsetKt.IntOffset(IntOffset.m6425getXimpl(targetOffset) + IntOffset.m6425getXimpl(other$iv), IntOffset.m6426getYimpl(targetOffset) + IntOffset.m6426getYimpl(other$iv));
                    if ((m878getMainAxisgyyYBs(targetOffset) <= minOffset && m878getMainAxisgyyYBs(other$iv2) <= minOffset) || (m878getMainAxisgyyYBs(targetOffset) >= maxOffset && m878getMainAxisgyyYBs(other$iv2) >= maxOffset)) {
                        animation.cancelPlacementAnimation();
                    }
                    targetOffset2 = other$iv2;
                }
                layerBlock = animation.getLayerBlock();
            } else {
                $this$place_u24lambda_u2410 = $this$place_u24lambda_u24102;
                layerBlock = LazyLayoutAnimationKt.getDefaultLayerBlock();
            }
            if (this.reverseLayout) {
                long $this$copy_u2d4Tuh3kE$iv = targetOffset2;
                if (this.isVertical) {
                    mainAxisSize = IntOffset.m6425getXimpl($this$copy_u2d4Tuh3kE$iv);
                } else {
                    int mainAxisOffset = IntOffset.m6425getXimpl($this$copy_u2d4Tuh3kE$iv);
                    int mainAxisOffset2 = this.mainAxisLayoutSize;
                    mainAxisSize = (mainAxisOffset2 - mainAxisOffset) - getMainAxisSize(placeable);
                }
                if (this.isVertical) {
                    int mainAxisOffset3 = IntOffset.m6426getYimpl($this$copy_u2d4Tuh3kE$iv);
                    iM6426getYimpl = (this.mainAxisLayoutSize - mainAxisOffset3) - getMainAxisSize(placeable);
                } else {
                    iM6426getYimpl = IntOffset.m6426getYimpl($this$copy_u2d4Tuh3kE$iv);
                }
                targetOffset2 = IntOffsetKt.IntOffset(mainAxisSize, iM6426getYimpl);
            }
            long other$iv3 = this.visualOffset;
            long other$iv4 = IntOffsetKt.IntOffset(IntOffset.m6425getXimpl(targetOffset2) + IntOffset.m6425getXimpl(other$iv3), IntOffset.m6426getYimpl(targetOffset2) + IntOffset.m6426getYimpl(other$iv3));
            if (this.isVertical) {
                $this$place_u24lambda_u24102 = $this$place_u24lambda_u2410;
                Placeable.PlacementScope.m5273placeWithLayeraW9wM$default($this$place_u24lambda_u24102, placeable, other$iv4, 0.0f, layerBlock, 2, null);
            } else {
                $this$place_u24lambda_u24102 = $this$place_u24lambda_u2410;
                Placeable.PlacementScope.m5272placeRelativeWithLayeraW9wM$default($this$place_u24lambda_u24102, placeable, other$iv4, 0.0f, layerBlock, 2, null);
            }
        }
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m878getMainAxisgyyYBs(long $this$mainAxis) {
        return this.isVertical ? IntOffset.m6426getYimpl($this$mainAxis) : IntOffset.m6425getXimpl($this$mainAxis);
    }

    private final int getMainAxisSize(Placeable $this$mainAxisSize) {
        return this.isVertical ? $this$mainAxisSize.getHeight() : $this$mainAxisSize.getWidth();
    }

    /* renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m877copy4Tuh3kE(long $this$copy_u2d4Tuh3kE, Function1<? super Integer, Integer> function1) {
        return IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m6425getXimpl($this$copy_u2d4Tuh3kE) : function1.invoke(Integer.valueOf(IntOffset.m6425getXimpl($this$copy_u2d4Tuh3kE))).intValue(), this.isVertical ? function1.invoke(Integer.valueOf(IntOffset.m6426getYimpl($this$copy_u2d4Tuh3kE))).intValue() : IntOffset.m6426getYimpl($this$copy_u2d4Tuh3kE));
    }
}
