package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.p000ui.input.key.KeyEventType;
import androidx.compose.p000ui.input.key.KeyEvent_androidKt;
import androidx.compose.p000ui.input.key.Key_androidKt;
import androidx.compose.p000ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p000ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Clickable.android.kt */
@Metadata(m164d1 = {"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\r\u001a\u00020\u0005*\u00020\u000eH\u0000\u001a\f\u0010\u000f\u001a\u00020\u0005*\u00020\u0010H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\u0005*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u0018\u0010\u000b\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0011"}, m165d2 = {"TapIndicationDelay", "", "getTapIndicationDelay", "()J", "isClick", "", "Landroidx/compose/ui/input/key/KeyEvent;", "isClick-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEnter", "isEnter-ZmokQxo", "isPress", "isPress-ZmokQxo", "isComposeRootInScrollableContainer", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "isInScrollableViewGroup", "Landroid/view/View;", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Clickable_androidKt {
    private static final long TapIndicationDelay = ViewConfiguration.getTapTimeout();

    public static final boolean isComposeRootInScrollableContainer(CompositionLocalConsumerModifierNode $this$isComposeRootInScrollableContainer) {
        return isInScrollableViewGroup((View) CompositionLocalConsumerModifierNodeKt.currentValueOf($this$isComposeRootInScrollableContainer, AndroidCompositionLocals_androidKt.getLocalView()));
    }

    private static final boolean isInScrollableViewGroup(View $this$isInScrollableViewGroup) {
        for (ViewParent p = $this$isInScrollableViewGroup.getParent(); p != null && (p instanceof ViewGroup); p = ((ViewGroup) p).getParent()) {
            if (((ViewGroup) p).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public static final long getTapIndicationDelay() {
        return TapIndicationDelay;
    }

    /* renamed from: isPress-ZmokQxo, reason: not valid java name */
    public static final boolean m464isPressZmokQxo(KeyEvent $this$isPress) {
        return KeyEventType.m4950equalsimpl0(KeyEvent_androidKt.m4958getTypeZmokQxo($this$isPress), KeyEventType.INSTANCE.m4954getKeyDownCS__XNY()) && m463isEnterZmokQxo($this$isPress);
    }

    /* renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m462isClickZmokQxo(KeyEvent $this$isClick) {
        return KeyEventType.m4950equalsimpl0(KeyEvent_androidKt.m4958getTypeZmokQxo($this$isClick), KeyEventType.INSTANCE.m4955getKeyUpCS__XNY()) && m463isEnterZmokQxo($this$isClick);
    }

    /* renamed from: isEnter-ZmokQxo, reason: not valid java name */
    private static final boolean m463isEnterZmokQxo(KeyEvent $this$isEnter) {
        switch (Key_androidKt.m4964getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m4957getKeyZmokQxo($this$isEnter))) {
            case 23:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case 160:
                return true;
            default:
                return false;
        }
    }
}
