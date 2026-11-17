package androidx.compose.p000ui.text.input;

import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: CursorAnchorInfoBuilder.android.kt */
@Metadata(m164d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, m165d2 = {"Landroidx/compose/ui/text/input/CursorAnchorInfoApi34Helper;", "", "()V", "addVisibleLineBounds", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "builder", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "ui_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class CursorAnchorInfoApi34Helper {
    public static final CursorAnchorInfoApi34Helper INSTANCE = new CursorAnchorInfoApi34Helper();

    private CursorAnchorInfoApi34Helper() {
    }

    @JvmStatic
    public static final CursorAnchorInfo.Builder addVisibleLineBounds(CursorAnchorInfo.Builder builder, TextLayoutResult textLayoutResult, Rect innerTextFieldBounds) {
        if (!innerTextFieldBounds.isEmpty()) {
            int firstLine = textLayoutResult.getLineForVerticalPosition(innerTextFieldBounds.getTop());
            int lastLine = textLayoutResult.getLineForVerticalPosition(innerTextFieldBounds.getBottom());
            int index = firstLine;
            if (index <= lastLine) {
                while (true) {
                    builder.addVisibleLineBounds(textLayoutResult.getLineLeft(index), textLayoutResult.getLineTop(index), textLayoutResult.getLineRight(index), textLayoutResult.getLineBottom(index));
                    if (index == lastLine) {
                        break;
                    }
                    index++;
                }
            }
        }
        return builder;
    }
}
