package androidx.compose.foundation.text.selection;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.style.ResolvedTextDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TextSelectionDelegate.kt */
@Metadata(m164d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¨\u0006\f"}, m165d2 = {"getSelectionHandleCoordinates", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", TypedValues.CycleType.S_WAVE_OFFSET, "", "isStart", "", "areHandlesCrossed", "(Landroidx/compose/ui/text/TextLayoutResult;IZZ)J", "getHorizontalPosition", "", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextSelectionDelegateKt {
    public static final long getSelectionHandleCoordinates(TextLayoutResult textLayoutResult, int offset, boolean isStart, boolean areHandlesCrossed) {
        int line = textLayoutResult.getLineForOffset(offset);
        if (line >= textLayoutResult.getLineCount()) {
            return Offset.INSTANCE.m3723getUnspecifiedF1C5BW0();
        }
        float x = getHorizontalPosition(textLayoutResult, offset, isStart, areHandlesCrossed);
        float y = textLayoutResult.getLineBottom(line);
        return OffsetKt.Offset(x, y);
    }

    public static final float getHorizontalPosition(TextLayoutResult $this$getHorizontalPosition, int offset, boolean isStart, boolean areHandlesCrossed) {
        int offsetToCheck = ((!isStart || areHandlesCrossed) && (isStart || !areHandlesCrossed)) ? Math.max(offset - 1, 0) : offset;
        ResolvedTextDirection bidiRunDirection = $this$getHorizontalPosition.getBidiRunDirection(offsetToCheck);
        ResolvedTextDirection paragraphDirection = $this$getHorizontalPosition.getParagraphDirection(offset);
        return $this$getHorizontalPosition.getHorizontalPosition(offset, bidiRunDirection == paragraphDirection);
    }
}
