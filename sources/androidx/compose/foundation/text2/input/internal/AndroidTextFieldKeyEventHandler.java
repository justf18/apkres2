package androidx.compose.foundation.text2.input.internal;

import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import androidx.compose.p000ui.focus.FocusDirection;
import androidx.compose.p000ui.focus.FocusManager;
import androidx.compose.p000ui.input.key.KeyEventType;
import androidx.compose.p000ui.input.key.KeyEvent_androidKt;
import androidx.compose.p000ui.platform.SoftwareKeyboardController;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;

/* compiled from: TextFieldKeyEventHandler.android.kt */
@Metadata(m164d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, m165d2 = {"Landroidx/compose/foundation/text2/input/internal/AndroidTextFieldKeyEventHandler;", "Landroidx/compose/foundation/text2/input/internal/TextFieldKeyEventHandler;", "()V", "onPreKeyEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidTextFieldKeyEventHandler extends TextFieldKeyEventHandler {
    public static final int $stable = 0;

    @Override // androidx.compose.foundation.text2.input.internal.TextFieldKeyEventHandler
    /* renamed from: onPreKeyEvent-MyFupTE, reason: not valid java name */
    public boolean mo1306onPreKeyEventMyFupTE(KeyEvent event, TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController keyboardController) {
        if (super.mo1306onPreKeyEventMyFupTE(event, textFieldState, textFieldSelectionState, focusManager, keyboardController)) {
            return true;
        }
        InputDevice device = event.getDevice();
        if (device != null && device.supportsSource(InputDeviceCompat.SOURCE_DPAD) && !device.isVirtual() && KeyEventType.m4950equalsimpl0(KeyEvent_androidKt.m4958getTypeZmokQxo(event), KeyEventType.INSTANCE.m4954getKeyDownCS__XNY())) {
            if (TextFieldKeyEventHandler_androidKt.m1337isKeyCodeYhN2O0w(event, 19)) {
                return focusManager.mo3642moveFocus3ESFkO8(FocusDirection.INSTANCE.m3641getUpdhqQ8s());
            }
            if (TextFieldKeyEventHandler_androidKt.m1337isKeyCodeYhN2O0w(event, 20)) {
                return focusManager.mo3642moveFocus3ESFkO8(FocusDirection.INSTANCE.m3634getDowndhqQ8s());
            }
            if (TextFieldKeyEventHandler_androidKt.m1337isKeyCodeYhN2O0w(event, 21)) {
                return focusManager.mo3642moveFocus3ESFkO8(FocusDirection.INSTANCE.m3637getLeftdhqQ8s());
            }
            if (TextFieldKeyEventHandler_androidKt.m1337isKeyCodeYhN2O0w(event, 22)) {
                return focusManager.mo3642moveFocus3ESFkO8(FocusDirection.INSTANCE.m3640getRightdhqQ8s());
            }
            if (!TextFieldKeyEventHandler_androidKt.m1337isKeyCodeYhN2O0w(event, 23)) {
                return false;
            }
            keyboardController.show();
            return true;
        }
        return false;
    }
}
