package androidx.compose.p000ui.node;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: DrawModifierNode.kt */
@Metadata(m164d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m165d2 = {"invalidateDraw", "", "Landroidx/compose/ui/node/DrawModifierNode;", "ui_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DrawModifierNodeKt {
    public static final void invalidateDraw(DrawModifierNode $this$invalidateDraw) {
        if ($this$invalidateDraw.getNode().getIsAttached()) {
            DelegatableNodeKt.m5322requireCoordinator64DMado($this$invalidateDraw, NodeKind.m5425constructorimpl(1)).invalidateLayer();
        }
    }
}
