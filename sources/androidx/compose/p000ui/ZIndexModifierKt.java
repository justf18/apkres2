package androidx.compose.p000ui;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: ZIndexModifier.kt */
@Metadata(m164d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007¨\u0006\u0003"}, m165d2 = {"zIndex", "Landroidx/compose/ui/Modifier;", "", "ui_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ZIndexModifierKt {
    public static final Modifier zIndex(Modifier $this$zIndex, float zIndex) {
        return $this$zIndex.then(new ZIndexElement(zIndex));
    }
}
