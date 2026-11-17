package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p000ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: PagerLayoutInfo.kt */
@Metadata(m164d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m165d2 = {"mainAxisViewportSize", "", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getMainAxisViewportSize$annotations", "(Landroidx/compose/foundation/pager/PagerLayoutInfo;)V", "getMainAxisViewportSize", "(Landroidx/compose/foundation/pager/PagerLayoutInfo;)I", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerLayoutInfoKt {
    public static /* synthetic */ void getMainAxisViewportSize$annotations(PagerLayoutInfo pagerLayoutInfo) {
    }

    public static final int getMainAxisViewportSize(PagerLayoutInfo $this$mainAxisViewportSize) {
        return $this$mainAxisViewportSize.getOrientation() == Orientation.Vertical ? IntSize.m6466getHeightimpl($this$mainAxisViewportSize.mo996getViewportSizeYbymL2g()) : IntSize.m6467getWidthimpl($this$mainAxisViewportSize.mo996getViewportSizeYbymL2g());
    }
}
