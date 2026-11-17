package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.p000ui.input.key.Key;
import androidx.compose.p000ui.input.key.KeyEvent_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: KeyMapping.android.kt */
@Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m165d2 = {"platformDefaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getPlatformDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class KeyMapping_androidKt {
    private static final KeyMapping platformDefaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMapping_androidKt$platformDefaultKeyMapping$1
        @Override // androidx.compose.foundation.text.KeyMapping
        /* renamed from: map-ZmokQxo */
        public KeyCommand mo1064mapZmokQxo(KeyEvent event) {
            KeyCommand keyCommand = null;
            if (KeyEvent_androidKt.m4963isShiftPressedZmokQxo(event) && KeyEvent_androidKt.m4960isAltPressedZmokQxo(event)) {
                long jM4957getKeyZmokQxo = KeyEvent_androidKt.m4957getKeyZmokQxo(event);
                if (Key.m4649equalsimpl0(jM4957getKeyZmokQxo, MappedKeys.INSTANCE.m1086getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_LEFT;
                } else if (Key.m4649equalsimpl0(jM4957getKeyZmokQxo, MappedKeys.INSTANCE.m1087getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                } else if (Key.m4649equalsimpl0(jM4957getKeyZmokQxo, MappedKeys.INSTANCE.m1088getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_HOME;
                } else if (Key.m4649equalsimpl0(jM4957getKeyZmokQxo, MappedKeys.INSTANCE.m1085getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_END;
                }
            } else if (KeyEvent_androidKt.m4960isAltPressedZmokQxo(event)) {
                long jM4957getKeyZmokQxo2 = KeyEvent_androidKt.m4957getKeyZmokQxo(event);
                if (Key.m4649equalsimpl0(jM4957getKeyZmokQxo2, MappedKeys.INSTANCE.m1086getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_LEFT;
                } else if (Key.m4649equalsimpl0(jM4957getKeyZmokQxo2, MappedKeys.INSTANCE.m1087getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_RIGHT;
                } else if (Key.m4649equalsimpl0(jM4957getKeyZmokQxo2, MappedKeys.INSTANCE.m1088getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.HOME;
                } else if (Key.m4649equalsimpl0(jM4957getKeyZmokQxo2, MappedKeys.INSTANCE.m1085getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.END;
                }
            }
            return keyCommand == null ? KeyMappingKt.getDefaultKeyMapping().mo1064mapZmokQxo(event) : keyCommand;
        }
    };

    public static final KeyMapping getPlatformDefaultKeyMapping() {
        return platformDefaultKeyMapping;
    }
}
