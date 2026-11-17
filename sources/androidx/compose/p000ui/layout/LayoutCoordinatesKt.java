package androidx.compose.p000ui.layout;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.node.NodeCoordinator;
import androidx.compose.p000ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.ranges.RangesKt;

/* compiled from: LayoutCoordinates.kt */
@Metadata(m164d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0002\u001a\u000f\u0010\u0006\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\n\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b¨\u0006\u000b"}, m165d2 = {"boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsInRoot", "boundsInWindow", "findRootCoordinates", "positionInParent", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInRoot", "positionInWindow", "ui_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LayoutCoordinatesKt {
    public static final long positionInRoot(LayoutCoordinates $this$positionInRoot) {
        return $this$positionInRoot.mo5228localToRootMKHz9U(Offset.INSTANCE.m3724getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates $this$positionInWindow) {
        return $this$positionInWindow.mo5229localToWindowMKHz9U(Offset.INSTANCE.m3724getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(LayoutCoordinates $this$boundsInRoot) {
        return LayoutCoordinates.localBoundingBoxOf$default(findRootCoordinates($this$boundsInRoot), $this$boundsInRoot, false, 2, null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates $this$boundsInWindow) {
        LayoutCoordinates root = findRootCoordinates($this$boundsInWindow);
        Rect bounds = boundsInRoot($this$boundsInWindow);
        float rootWidth = IntSize.m6467getWidthimpl(root.mo5226getSizeYbymL2g());
        float rootHeight = IntSize.m6466getHeightimpl(root.mo5226getSizeYbymL2g());
        float boundsLeft = RangesKt.coerceIn(bounds.getLeft(), 0.0f, rootWidth);
        float boundsTop = RangesKt.coerceIn(bounds.getTop(), 0.0f, rootHeight);
        float boundsRight = RangesKt.coerceIn(bounds.getRight(), 0.0f, rootWidth);
        float boundsBottom = RangesKt.coerceIn(bounds.getBottom(), 0.0f, rootHeight);
        if (!(boundsLeft == boundsRight)) {
            if (!(boundsTop == boundsBottom)) {
                long topLeft = root.mo5229localToWindowMKHz9U(OffsetKt.Offset(boundsLeft, boundsTop));
                long topRight = root.mo5229localToWindowMKHz9U(OffsetKt.Offset(boundsRight, boundsTop));
                long bottomRight = root.mo5229localToWindowMKHz9U(OffsetKt.Offset(boundsRight, boundsBottom));
                long bottomLeft = root.mo5229localToWindowMKHz9U(OffsetKt.Offset(boundsLeft, boundsBottom));
                float left = ComparisonsKt.minOf(Offset.m3708getXimpl(topLeft), Offset.m3708getXimpl(topRight), Offset.m3708getXimpl(bottomLeft), Offset.m3708getXimpl(bottomRight));
                float top = ComparisonsKt.minOf(Offset.m3709getYimpl(topLeft), Offset.m3709getYimpl(topRight), Offset.m3709getYimpl(bottomLeft), Offset.m3709getYimpl(bottomRight));
                float right = ComparisonsKt.maxOf(Offset.m3708getXimpl(topLeft), Offset.m3708getXimpl(topRight), Offset.m3708getXimpl(bottomLeft), Offset.m3708getXimpl(bottomRight));
                float bottom = ComparisonsKt.maxOf(Offset.m3709getYimpl(topLeft), Offset.m3709getYimpl(topRight), Offset.m3709getYimpl(bottomLeft), Offset.m3709getYimpl(bottomRight));
                return new Rect(left, top, right, bottom);
            }
        }
        return Rect.INSTANCE.getZero();
    }

    public static final long positionInParent(LayoutCoordinates $this$positionInParent) {
        LayoutCoordinates parentLayoutCoordinates = $this$positionInParent.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.mo5227localPositionOfR5De75A($this$positionInParent, Offset.INSTANCE.m3724getZeroF1C5BW0()) : Offset.INSTANCE.m3724getZeroF1C5BW0();
    }

    public static final Rect boundsInParent(LayoutCoordinates $this$boundsInParent) {
        Rect rectLocalBoundingBoxOf$default;
        LayoutCoordinates parentLayoutCoordinates = $this$boundsInParent.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (rectLocalBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(parentLayoutCoordinates, $this$boundsInParent, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m6467getWidthimpl($this$boundsInParent.mo5226getSizeYbymL2g()), IntSize.m6466getHeightimpl($this$boundsInParent.mo5226getSizeYbymL2g())) : rectLocalBoundingBoxOf$default;
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates $this$findRootCoordinates) {
        LayoutCoordinates root = $this$findRootCoordinates;
        LayoutCoordinates parent = root.getParentLayoutCoordinates();
        while (parent != null) {
            root = parent;
            parent = root.getParentLayoutCoordinates();
        }
        NodeCoordinator rootCoordinator = root instanceof NodeCoordinator ? (NodeCoordinator) root : null;
        if (rootCoordinator == null) {
            return root;
        }
        for (NodeCoordinator parentCoordinator = rootCoordinator.getWrappedBy(); parentCoordinator != null; parentCoordinator = parentCoordinator.getWrappedBy()) {
            rootCoordinator = parentCoordinator;
        }
        return rootCoordinator;
    }
}
