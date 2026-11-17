package androidx.compose.p000ui.text.android;

import android.text.Layout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: LayoutCompat.kt */
@Metadata(m164d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m165d2 = {"getLineForOffset", "", "Landroid/text/Layout;", TypedValues.CycleType.S_WAVE_OFFSET, "upstream", "", "ui-text_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LayoutCompatKt {
    public static final int getLineForOffset(Layout $this$getLineForOffset, int offset, boolean upstream) {
        if (offset <= 0) {
            return 0;
        }
        if (offset >= $this$getLineForOffset.getText().length()) {
            return $this$getLineForOffset.getLineCount() - 1;
        }
        int downstreamLineNo = $this$getLineForOffset.getLineForOffset(offset);
        int lineStart = $this$getLineForOffset.getLineStart(downstreamLineNo);
        int lineEnd = $this$getLineForOffset.getLineEnd(downstreamLineNo);
        if (lineStart != offset && lineEnd != offset) {
            return downstreamLineNo;
        }
        if (lineStart == offset) {
            if (upstream) {
                return downstreamLineNo - 1;
            }
        } else if (!upstream) {
            return downstreamLineNo + 1;
        }
        return downstreamLineNo;
    }
}
