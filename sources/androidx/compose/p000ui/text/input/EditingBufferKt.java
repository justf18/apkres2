package androidx.compose.p000ui.text.input;

import androidx.compose.p000ui.text.TextRange;
import androidx.compose.p000ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, m165d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m5934updateRangeAfterDeletepWDy79M(long target, long deleted) {
        int targetMin = TextRange.m5772getMinimpl(target);
        int targetMax = TextRange.m5771getMaximpl(target);
        if (TextRange.m5776intersects5zctL8(deleted, target)) {
            if (TextRange.m5764contains5zctL8(deleted, target)) {
                targetMin = TextRange.m5772getMinimpl(deleted);
                targetMax = targetMin;
            } else if (TextRange.m5764contains5zctL8(target, deleted)) {
                targetMax -= TextRange.m5770getLengthimpl(deleted);
            } else if (TextRange.m5765containsimpl(deleted, targetMin)) {
                targetMin = TextRange.m5772getMinimpl(deleted);
                targetMax -= TextRange.m5770getLengthimpl(deleted);
            } else {
                targetMax = TextRange.m5772getMinimpl(deleted);
            }
        } else if (targetMax > TextRange.m5772getMinimpl(deleted)) {
            targetMin -= TextRange.m5770getLengthimpl(deleted);
            targetMax -= TextRange.m5770getLengthimpl(deleted);
        }
        return TextRangeKt.TextRange(targetMin, targetMax);
    }
}
