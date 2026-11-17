package androidx.compose.p000ui.draw;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.GraphicsLayerModifierKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Rotate.kt */
@Metadata(m164d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, m165d2 = {"rotate", "Landroidx/compose/ui/Modifier;", "degrees", "", "ui_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RotateKt {
    public static final Modifier rotate(Modifier $this$rotate, float degrees) {
        return !((degrees > 0.0f ? 1 : (degrees == 0.0f ? 0 : -1)) == 0) ? GraphicsLayerModifierKt.m4110graphicsLayerAp8cVGQ$default($this$rotate, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, degrees, 0.0f, 0L, null, false, null, 0L, 0L, 0, 130815, null) : $this$rotate;
    }
}
