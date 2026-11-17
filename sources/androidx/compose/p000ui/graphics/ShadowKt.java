package androidx.compose.p000ui.graphics;

import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.util.MathHelpersKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Shadow.kt */
@Metadata(m164d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, m165d2 = {"lerp", "Landroidx/compose/ui/graphics/Shadow;", "start", "stop", "fraction", "", "ui-graphics_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ShadowKt {
    public static final Shadow lerp(Shadow start, Shadow stop, float fraction) {
        return new Shadow(ColorKt.m4000lerpjxsXWHM(start.getColor(), stop.getColor(), fraction), OffsetKt.m3731lerpWko1d7g(start.getOffset(), stop.getOffset(), fraction), MathHelpersKt.lerp(start.getBlurRadius(), stop.getBlurRadius(), fraction), null);
    }
}
