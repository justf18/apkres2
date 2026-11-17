package androidx.compose.p000ui.platform;

import android.view.View;
import androidx.compose.p000ui.input.pointer.AndroidPointerIcon;
import androidx.compose.p000ui.input.pointer.PointerIcon;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidComposeView.android.kt */
@Metadata(m164d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, m165d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewVerificationHelperMethodsN;", "", "()V", "setPointerIcon", "", "view", "Landroid/view/View;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "ui_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class AndroidComposeViewVerificationHelperMethodsN {
    public static final AndroidComposeViewVerificationHelperMethodsN INSTANCE = new AndroidComposeViewVerificationHelperMethodsN();

    private AndroidComposeViewVerificationHelperMethodsN() {
    }

    public final void setPointerIcon(View view, PointerIcon icon) {
        android.view.PointerIcon iconToSet;
        if (icon instanceof AndroidPointerIcon) {
            iconToSet = ((AndroidPointerIcon) icon).getPointerIcon();
        } else if (icon instanceof androidx.compose.p000ui.input.pointer.AndroidPointerIcon) {
            iconToSet = android.view.PointerIcon.getSystemIcon(view.getContext(), ((androidx.compose.p000ui.input.pointer.AndroidPointerIcon) icon).getType());
        } else {
            iconToSet = android.view.PointerIcon.getSystemIcon(view.getContext(), 1000);
        }
        if (!Intrinsics.areEqual(view.getPointerIcon(), iconToSet)) {
            view.setPointerIcon(iconToSet);
        }
    }
}
