package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.p000ui.text.input.ImeAction;
import androidx.compose.p000ui.text.input.KeyboardCapitalization;
import androidx.compose.p000ui.text.input.KeyboardType;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TextFieldDecoratorModifier.kt */
@Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0003"}, m165d2 = {"withDefaultsFrom", "Landroidx/compose/foundation/text/KeyboardOptions;", "defaults", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldDecoratorModifierKt {
    public static final KeyboardOptions withDefaultsFrom(KeyboardOptions $this$withDefaultsFrom, KeyboardOptions defaults) {
        int capitalization;
        int keyboardType;
        int imeAction;
        if (defaults == null) {
            return $this$withDefaultsFrom;
        }
        if (!KeyboardCapitalization.m5970equalsimpl0($this$withDefaultsFrom.getCapitalization(), KeyboardCapitalization.INSTANCE.m5979getNoneIUNYP9k())) {
            capitalization = $this$withDefaultsFrom.getCapitalization();
        } else {
            capitalization = defaults.getCapitalization();
        }
        boolean z = $this$withDefaultsFrom.getAutoCorrect() && defaults.getAutoCorrect();
        if (!KeyboardType.m5985equalsimpl0($this$withDefaultsFrom.getKeyboardType(), KeyboardType.INSTANCE.m6005getTextPjHm6EE())) {
            keyboardType = $this$withDefaultsFrom.getKeyboardType();
        } else {
            keyboardType = defaults.getKeyboardType();
        }
        if (!ImeAction.m5938equalsimpl0($this$withDefaultsFrom.getImeAction(), ImeAction.INSTANCE.m5950getDefaulteUduSuo())) {
            imeAction = $this$withDefaultsFrom.getImeAction();
        } else {
            imeAction = defaults.getImeAction();
        }
        return new KeyboardOptions(capitalization, z, keyboardType, imeAction, null, 16, null);
    }
}
