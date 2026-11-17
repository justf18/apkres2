package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.input.pointer.PointerIconKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: BasicText.android.kt */
@Metadata(m164d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¨\u0006\u0004"}, m165d2 = {"textPointerHoverIcon", "Landroidx/compose/ui/Modifier;", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BasicText_androidKt {
    public static final Modifier textPointerHoverIcon(Modifier $this$textPointerHoverIcon, SelectionRegistrar selectionRegistrar) {
        return selectionRegistrar == null ? $this$textPointerHoverIcon : PointerIconKt.pointerHoverIcon$default($this$textPointerHoverIcon, TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
    }
}
