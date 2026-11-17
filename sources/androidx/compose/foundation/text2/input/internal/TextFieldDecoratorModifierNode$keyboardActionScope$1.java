package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.p000ui.focus.FocusDirection;
import androidx.compose.p000ui.focus.FocusManager;
import androidx.compose.p000ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.text.input.ImeAction;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TextFieldDecoratorModifier.kt */
@Metadata(m164d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, m165d2 = {"androidx/compose/foundation/text2/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1", "Landroidx/compose/foundation/text/KeyboardActionScope;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "defaultKeyboardAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "defaultKeyboardAction-KlQnJC8", "(I)V", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldDecoratorModifierNode$keyboardActionScope$1 implements KeyboardActionScope {
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    TextFieldDecoratorModifierNode$keyboardActionScope$1(TextFieldDecoratorModifierNode $receiver) {
        this.this$0 = $receiver;
    }

    private final FocusManager getFocusManager() {
        return (FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, CompositionLocalsKt.getLocalFocusManager());
    }

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    /* renamed from: defaultKeyboardAction-KlQnJC8 */
    public void mo1065defaultKeyboardActionKlQnJC8(int imeAction) {
        if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5953getNexteUduSuo())) {
            getFocusManager().mo3642moveFocus3ESFkO8(FocusDirection.INSTANCE.m3638getNextdhqQ8s());
            return;
        }
        if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5955getPreviouseUduSuo())) {
            getFocusManager().mo3642moveFocus3ESFkO8(FocusDirection.INSTANCE.m3639getPreviousdhqQ8s());
        } else {
            if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5951getDoneeUduSuo())) {
                this.this$0.requireKeyboardController().hide();
                return;
            }
            if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5952getGoeUduSuo()) ? true : ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5956getSearcheUduSuo()) ? true : ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5957getSendeUduSuo()) ? true : ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5950getDefaulteUduSuo())) {
                return;
            }
            ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5954getNoneeUduSuo());
        }
    }
}
