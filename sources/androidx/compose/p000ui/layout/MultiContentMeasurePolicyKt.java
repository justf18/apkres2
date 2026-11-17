package androidx.compose.p000ui.layout;

import androidx.compose.p000ui.node.MeasureScopeWithLayoutNodeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;

/* compiled from: MultiContentMeasurePolicy.kt */
@Metadata(m164d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\u0004"}, m165d2 = {"createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "ui_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MultiContentMeasurePolicyKt {
    public static final MeasurePolicy createMeasurePolicy(final MultiContentMeasurePolicy measurePolicy) {
        return new MeasurePolicy() { // from class: androidx.compose.ui.layout.MultiContentMeasurePolicyKt$createMeasurePolicy$1$1
            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo243measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> list, long constraints) {
                return measurePolicy.mo2188measure3p2s80s($this$measure_u2d3p2s80s, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren($this$measure_u2d3p2s80s), constraints);
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> list, int height) {
                return measurePolicy.minIntrinsicWidth($this$minIntrinsicWidth, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren($this$minIntrinsicWidth), height);
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> list, int width) {
                return measurePolicy.minIntrinsicHeight($this$minIntrinsicHeight, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren($this$minIntrinsicHeight), width);
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> list, int height) {
                return measurePolicy.maxIntrinsicWidth($this$maxIntrinsicWidth, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren($this$maxIntrinsicWidth), height);
            }

            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> list, int width) {
                return measurePolicy.maxIntrinsicHeight($this$maxIntrinsicHeight, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren($this$maxIntrinsicHeight), width);
            }
        };
    }
}
