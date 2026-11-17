package androidx.compose.p000ui.text.platform;

import android.text.TextPaint;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: AndroidTextPaint.android.kt */
@Metadata(m164d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m165d2 = {"setAlpha", "", "Landroid/text/TextPaint;", "alpha", "", "ui-text_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidTextPaint_androidKt {
    public static final void setAlpha(TextPaint $this$setAlpha, float alpha) {
        if (!Float.isNaN(alpha)) {
            int alphaInt = MathKt.roundToInt(RangesKt.coerceIn(alpha, 0.0f, 1.0f) * 255);
            $this$setAlpha.setAlpha(alphaInt);
        }
    }
}
