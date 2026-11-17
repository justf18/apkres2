package androidx.compose.p000ui.node;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: ParentDataModifierNode.kt */
@Metadata(m164d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m165d2 = {"invalidateParentData", "", "Landroidx/compose/ui/node/ParentDataModifierNode;", "ui_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ParentDataModifierNodeKt {
    public static final void invalidateParentData(ParentDataModifierNode $this$invalidateParentData) {
        DelegatableNodeKt.requireLayoutNode($this$invalidateParentData).invalidateParentData$ui_release();
    }
}
