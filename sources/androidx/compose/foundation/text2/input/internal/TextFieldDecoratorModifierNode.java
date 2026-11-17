package androidx.compose.foundation.text2.input.internal;

import android.view.KeyEvent;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text2.input.internal.selection.TextToolbarState;
import androidx.compose.p000ui.focus.FocusEventModifierNode;
import androidx.compose.p000ui.focus.FocusManager;
import androidx.compose.p000ui.focus.FocusRequesterModifierNode;
import androidx.compose.p000ui.focus.FocusRequesterModifierNodeKt;
import androidx.compose.p000ui.focus.FocusState;
import androidx.compose.p000ui.input.key.KeyInputModifierNode;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p000ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.p000ui.node.DelegatingNode;
import androidx.compose.p000ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.p000ui.node.ObserverModifierNode;
import androidx.compose.p000ui.node.ObserverModifierNodeKt;
import androidx.compose.p000ui.node.PointerInputModifierNode;
import androidx.compose.p000ui.node.SemanticsModifierNode;
import androidx.compose.p000ui.node.SemanticsModifierNodeKt;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.PlatformTextInputModifierNode;
import androidx.compose.p000ui.platform.PlatformTextInputModifierNodeKt;
import androidx.compose.p000ui.platform.PlatformTextInputSessionScope;
import androidx.compose.p000ui.platform.SoftwareKeyboardController;
import androidx.compose.p000ui.platform.WindowInfo;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextRange;
import androidx.compose.p000ui.text.TextRangeKt;
import androidx.compose.p000ui.text.input.ImeAction;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: TextFieldDecoratorModifier.kt */
@Metadata(m164d1 = {"\u0000Ë\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001)\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\nBO\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0014¢\u0006\u0002\u0010\u001bJ\b\u0010N\u001a\u000205H\u0002J\b\u0010O\u001a\u000205H\u0016J\b\u0010P\u001a\u000205H\u0016J\b\u0010Q\u001a\u000205H\u0016J\u0010\u0010R\u001a\u0002052\u0006\u0010S\u001a\u00020TH\u0016J\u0010\u0010U\u001a\u0002052\u0006\u0010V\u001a\u00020WH\u0016J\u001a\u0010X\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020ZH\u0016ø\u0001\u0000¢\u0006\u0004\b[\u0010\\J\b\u0010]\u001a\u000205H\u0016J*\u0010^\u001a\u0002052\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020dH\u0016ø\u0001\u0000¢\u0006\u0004\be\u0010fJ\u001a\u0010g\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020ZH\u0016ø\u0001\u0000¢\u0006\u0004\bh\u0010\\J\b\u0010i\u001a\u00020jH\u0002J\b\u0010k\u001a\u000205H\u0002J\b\u0010l\u001a\u000205H\u0002JP\u0010m\u001a\u0002052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014J\f\u0010n\u001a\u000205*\u00020oH\u0016R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001dR\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020503X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001d\"\u0004\b9\u0010\u001fR\u0014\u0010:\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u001dR\u001a\u0010\u001a\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001d\"\u0004\b=\u0010\u001fR\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006p"}, m165d2 = {"Landroidx/compose/foundation/text2/input/internal/TextFieldDecoratorModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "filter", "Landroidx/compose/foundation/text2/input/InputTransformation;", "enabled", "", "readOnly", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "(Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/TextLayoutState;Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text2/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Z)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getFilter", "()Landroidx/compose/foundation/text2/input/InputTransformation;", "setFilter", "(Landroidx/compose/foundation/text2/input/InputTransformation;)V", "inputSessionJob", "Lkotlinx/coroutines/Job;", "isElementFocused", "isFocused", "keyboardActionScope", "androidx/compose/foundation/text2/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1", "Landroidx/compose/foundation/text2/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1;", "getKeyboardActions", "()Landroidx/compose/foundation/text/KeyboardActions;", "setKeyboardActions", "(Landroidx/compose/foundation/text/KeyboardActions;)V", "<set-?>", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "onImeActionPerformed", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "getReadOnly", "setReadOnly", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "getSingleLine", "setSingleLine", "textFieldKeyEventHandler", "Landroidx/compose/foundation/text2/input/internal/TextFieldKeyEventHandler;", "getTextFieldSelectionState", "()Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "setTextFieldSelectionState", "(Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;)V", "getTextFieldState", "()Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "setTextFieldState", "(Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;)V", "getTextLayoutState", "()Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "setTextLayoutState", "(Landroidx/compose/foundation/text2/input/internal/TextLayoutState;)V", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "disposeInputSession", "onAttach", "onCancelPointerInput", "onDetach", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onObservedReadsChanged", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "requireKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "startInputSession", "startOrDisposeInputSessionOnWindowFocusChange", "updateNode", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldDecoratorModifierNode extends DelegatingNode implements PlatformTextInputModifierNode, SemanticsModifierNode, FocusRequesterModifierNode, FocusEventModifierNode, GlobalPositionAwareModifierNode, PointerInputModifierNode, KeyInputModifierNode, CompositionLocalConsumerModifierNode, ObserverModifierNode {
    public static final int $stable = 8;
    private boolean enabled;
    private InputTransformation filter;
    private Job inputSessionJob;
    private boolean isElementFocused;
    private final TextFieldDecoratorModifierNode$keyboardActionScope$1 keyboardActionScope;
    private KeyboardActions keyboardActions;
    private KeyboardOptions keyboardOptions;
    private final Function1<ImeAction, Unit> onImeActionPerformed;
    private final SuspendingPointerInputModifierNode pointerInputNode = (SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new TextFieldDecoratorModifierNode$pointerInputNode$1(this, null)));
    private boolean readOnly;
    private boolean singleLine;
    private final TextFieldKeyEventHandler textFieldKeyEventHandler;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private WindowInfo windowInfo;

    public final TransformedTextFieldState getTextFieldState() {
        return this.textFieldState;
    }

    public final void setTextFieldState(TransformedTextFieldState transformedTextFieldState) {
        this.textFieldState = transformedTextFieldState;
    }

    public final TextLayoutState getTextLayoutState() {
        return this.textLayoutState;
    }

    public final void setTextLayoutState(TextLayoutState textLayoutState) {
        this.textLayoutState = textLayoutState;
    }

    public final TextFieldSelectionState getTextFieldSelectionState() {
        return this.textFieldSelectionState;
    }

    public final void setTextFieldSelectionState(TextFieldSelectionState textFieldSelectionState) {
        this.textFieldSelectionState = textFieldSelectionState;
    }

    public final InputTransformation getFilter() {
        return this.filter;
    }

    public final void setFilter(InputTransformation inputTransformation) {
        this.filter = inputTransformation;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final void setReadOnly(boolean z) {
        this.readOnly = z;
    }

    public final KeyboardActions getKeyboardActions() {
        return this.keyboardActions;
    }

    public final void setKeyboardActions(KeyboardActions keyboardActions) {
        this.keyboardActions = keyboardActions;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final void setSingleLine(boolean z) {
        this.singleLine = z;
    }

    public TextFieldDecoratorModifierNode(TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation filter, boolean enabled, boolean readOnly, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine) {
        this.textFieldState = textFieldState;
        this.textLayoutState = textLayoutState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.filter = filter;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.keyboardActions = keyboardActions;
        this.singleLine = singleLine;
        InputTransformation inputTransformation = this.filter;
        this.keyboardOptions = TextFieldDecoratorModifierKt.withDefaultsFrom(keyboardOptions, inputTransformation != null ? inputTransformation.getKeyboardOptions() : null);
        this.textFieldKeyEventHandler = TextFieldKeyEventHandler_androidKt.createTextFieldKeyEventHandler();
        this.keyboardActionScope = new TextFieldDecoratorModifierNode$keyboardActionScope$1(this);
        this.onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode$onImeActionPerformed$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ImeAction imeAction) {
                m1334invokeKlQnJC8(imeAction.getValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-KlQnJC8, reason: not valid java name */
            public final void m1334invokeKlQnJC8(int imeAction) {
                Function1 keyboardAction;
                Unit unit = null;
                if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5951getDoneeUduSuo())) {
                    keyboardAction = this.this$0.getKeyboardActions().getOnDone();
                } else if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5952getGoeUduSuo())) {
                    keyboardAction = this.this$0.getKeyboardActions().getOnGo();
                } else if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5953getNexteUduSuo())) {
                    keyboardAction = this.this$0.getKeyboardActions().getOnNext();
                } else if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5955getPreviouseUduSuo())) {
                    keyboardAction = this.this$0.getKeyboardActions().getOnPrevious();
                } else if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5956getSearcheUduSuo())) {
                    keyboardAction = this.this$0.getKeyboardActions().getOnSearch();
                } else if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5957getSendeUduSuo())) {
                    keyboardAction = this.this$0.getKeyboardActions().getOnSend();
                } else {
                    if (!(ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5950getDefaulteUduSuo()) ? true : ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5954getNoneeUduSuo()))) {
                        throw new IllegalStateException("invalid ImeAction".toString());
                    }
                    keyboardAction = null;
                }
                if (keyboardAction != null) {
                    keyboardAction.invoke(this.this$0.keyboardActionScope);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    this.this$0.keyboardActionScope.mo1065defaultKeyboardActionKlQnJC8(imeAction);
                }
            }
        };
    }

    public final KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFocused() {
        if (!this.isElementFocused) {
            return false;
        }
        WindowInfo windowInfo = this.windowInfo;
        return windowInfo != null && windowInfo.isWindowFocused();
    }

    public final void updateNode(TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation filter, boolean enabled, boolean readOnly, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine) {
        boolean previousWriteable = this.enabled && !this.readOnly;
        boolean writeable = enabled && !readOnly;
        boolean previousEnabled = this.enabled;
        TransformedTextFieldState previousTextFieldState = this.textFieldState;
        KeyboardOptions previousKeyboardOptions = this.keyboardOptions;
        TextFieldSelectionState previousTextFieldSelectionState = this.textFieldSelectionState;
        InputTransformation previousFilter = this.filter;
        this.textFieldState = textFieldState;
        this.textLayoutState = textLayoutState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.filter = filter;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.keyboardOptions = TextFieldDecoratorModifierKt.withDefaultsFrom(keyboardOptions, filter != null ? filter.getKeyboardOptions() : null);
        this.keyboardActions = keyboardActions;
        this.singleLine = singleLine;
        if (writeable != previousWriteable || !Intrinsics.areEqual(textFieldState, previousTextFieldState) || !Intrinsics.areEqual(keyboardOptions, previousKeyboardOptions) || !Intrinsics.areEqual(filter, previousFilter)) {
            if (writeable && isFocused()) {
                startInputSession();
            } else if (!writeable) {
                disposeInputSession();
            }
        }
        if (previousEnabled != enabled) {
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (!Intrinsics.areEqual(textFieldSelectionState, previousTextFieldSelectionState)) {
            this.pointerInputNode.resetPointerInputHandler();
        }
    }

    @Override // androidx.compose.p000ui.node.SemanticsModifierNode
    public boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    @Override // androidx.compose.p000ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        TextFieldCharSequence text = this.textFieldState.getUntransformedText();
        long selection = text.getSelectionInChars();
        SemanticsPropertiesKt.setEditableText($this$applySemantics, new AnnotatedString(text.toString(), null, null, 6, null));
        SemanticsPropertiesKt.m5619setTextSelectionRangeFDrldGo($this$applySemantics, selection);
        SemanticsPropertiesKt.getTextLayoutResult$default($this$applySemantics, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode.applySemantics.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<TextLayoutResult> list) {
                TextLayoutResult result = TextFieldDecoratorModifierNode.this.getTextLayoutState().getLayoutResult();
                return Boolean.valueOf(result != null ? list.add(result) : false);
            }
        }, 1, null);
        if (!this.enabled) {
            SemanticsPropertiesKt.disabled($this$applySemantics);
        }
        SemanticsPropertiesKt.setText$default($this$applySemantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode.applySemantics.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AnnotatedString newText) {
                if (TextFieldDecoratorModifierNode.this.getReadOnly() || !TextFieldDecoratorModifierNode.this.getEnabled()) {
                    return false;
                }
                TextFieldDecoratorModifierNode.this.getTextFieldState().replaceAll(newText);
                return true;
            }
        }, 1, null);
        SemanticsPropertiesKt.setSelection$default($this$applySemantics, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode.applySemantics.3
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
            }

            public final Boolean invoke(int start, int end, boolean relativeToOriginal) {
                TextFieldCharSequence text2;
                if (relativeToOriginal) {
                    text2 = TextFieldDecoratorModifierNode.this.getTextFieldState().getUntransformedText();
                } else {
                    text2 = TextFieldDecoratorModifierNode.this.getTextFieldState().getText();
                }
                long selection2 = text2.getSelectionInChars();
                if (!TextFieldDecoratorModifierNode.this.getEnabled() || Math.min(start, end) < 0 || Math.max(start, end) > text2.length()) {
                    return false;
                }
                if (start == TextRange.m5774getStartimpl(selection2) && end == TextRange.m5769getEndimpl(selection2)) {
                    return true;
                }
                long selectionRange = TextRangeKt.TextRange(start, end);
                if (relativeToOriginal || start == end) {
                    TextFieldDecoratorModifierNode.this.getTextFieldSelectionState().updateTextToolbarState(TextToolbarState.None);
                } else {
                    TextFieldDecoratorModifierNode.this.getTextFieldSelectionState().updateTextToolbarState(TextToolbarState.Selection);
                }
                if (relativeToOriginal) {
                    TextFieldDecoratorModifierNode.this.getTextFieldState().m1362selectUntransformedCharsIn5zctL8(selectionRange);
                } else {
                    TextFieldDecoratorModifierNode.this.getTextFieldState().m1361selectCharsIn5zctL8(selectionRange);
                }
                return true;
            }
        }, 1, null);
        SemanticsPropertiesKt.insertTextAtCursor$default($this$applySemantics, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode.applySemantics.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AnnotatedString newText) {
                if (TextFieldDecoratorModifierNode.this.getReadOnly() || !TextFieldDecoratorModifierNode.this.getEnabled()) {
                    return false;
                }
                TransformedTextFieldState.replaceSelectedText$default(TextFieldDecoratorModifierNode.this.getTextFieldState(), newText, true, null, 4, null);
                return true;
            }
        }, 1, null);
        SemanticsPropertiesKt.m5615onImeAction9UiTYpY$default($this$applySemantics, this.keyboardOptions.getImeAction(), null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode.applySemantics.5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                TextFieldDecoratorModifierNode.this.onImeActionPerformed.invoke(ImeAction.m5935boximpl(TextFieldDecoratorModifierNode.this.getKeyboardOptions().getImeAction()));
                return true;
            }
        }, 2, null);
        SemanticsPropertiesKt.onClick$default($this$applySemantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode.applySemantics.6
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                if (!TextFieldDecoratorModifierNode.this.isFocused()) {
                    FocusRequesterModifierNodeKt.requestFocus(TextFieldDecoratorModifierNode.this);
                } else if (!TextFieldDecoratorModifierNode.this.getReadOnly()) {
                    TextFieldDecoratorModifierNode.this.requireKeyboardController().show();
                }
                return true;
            }
        }, 1, null);
        SemanticsPropertiesKt.onLongClick$default($this$applySemantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode.applySemantics.7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                if (!TextFieldDecoratorModifierNode.this.isFocused()) {
                    FocusRequesterModifierNodeKt.requestFocus(TextFieldDecoratorModifierNode.this);
                }
                TextFieldDecoratorModifierNode.this.getTextFieldSelectionState().updateTextToolbarState(TextToolbarState.Selection);
                return true;
            }
        }, 1, null);
        if (!TextRange.m5768getCollapsedimpl(selection)) {
            SemanticsPropertiesKt.copyText$default($this$applySemantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode.applySemantics.8
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    TextFieldSelectionState.copy$default(TextFieldDecoratorModifierNode.this.getTextFieldSelectionState(), false, 1, null);
                    return true;
                }
            }, 1, null);
            if (this.enabled && !this.readOnly) {
                SemanticsPropertiesKt.cutText$default($this$applySemantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode.applySemantics.9
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        TextFieldDecoratorModifierNode.this.getTextFieldSelectionState().cut();
                        return true;
                    }
                }, 1, null);
            }
        }
        if (this.enabled && !this.readOnly) {
            SemanticsPropertiesKt.pasteText$default($this$applySemantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode.applySemantics.10
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    TextFieldDecoratorModifierNode.this.getTextFieldSelectionState().paste();
                    return true;
                }
            }, 1, null);
        }
    }

    @Override // androidx.compose.p000ui.focus.FocusEventModifierNode
    public void onFocusEvent(FocusState focusState) {
        if (this.isElementFocused == focusState.isFocused()) {
            return;
        }
        this.isElementFocused = focusState.isFocused();
        this.textFieldSelectionState.setFocused(isFocused());
        if (focusState.isFocused()) {
            if (this.enabled && !this.readOnly) {
                startInputSession();
                return;
            }
            return;
        }
        disposeInputSession();
        this.textFieldState.collapseSelectionToMax();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        onObservedReadsChanged();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        disposeInputSession();
    }

    @Override // androidx.compose.p000ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.textLayoutState.setDecoratorNodeCoordinates(coordinates);
    }

    @Override // androidx.compose.p000ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo384onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.pointerInputNode.mo384onPointerEventH0pRuoY(pointerEvent, pass, bounds);
    }

    @Override // androidx.compose.p000ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.p000ui.input.key.KeyInputModifierNode
    /* renamed from: onPreKeyEvent-ZmokQxo */
    public boolean mo385onPreKeyEventZmokQxo(KeyEvent event) {
        return this.textFieldKeyEventHandler.mo1306onPreKeyEventMyFupTE(event, this.textFieldState, this.textFieldSelectionState, (FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager()), requireKeyboardController());
    }

    @Override // androidx.compose.p000ui.input.key.KeyInputModifierNode
    /* renamed from: onKeyEvent-ZmokQxo */
    public boolean mo383onKeyEventZmokQxo(KeyEvent event) {
        return this.textFieldKeyEventHandler.m1335onKeyEvent6ptp14s(event, this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.enabled && !this.readOnly, this.singleLine, new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode$onKeyEvent$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.onImeActionPerformed.invoke(ImeAction.m5935boximpl(this.this$0.getKeyboardOptions().getImeAction()));
            }
        });
    }

    @Override // androidx.compose.p000ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode.onObservedReadsChanged.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TextFieldDecoratorModifierNode.this.windowInfo = (WindowInfo) CompositionLocalConsumerModifierNodeKt.currentValueOf(TextFieldDecoratorModifierNode.this, CompositionLocalsKt.getLocalWindowInfo());
                TextFieldDecoratorModifierNode.this.startOrDisposeInputSessionOnWindowFocusChange();
            }
        });
    }

    /* compiled from: TextFieldDecoratorModifier.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode$startInputSession$1", m180f = "TextFieldDecoratorModifier.kt", m181i = {}, m182l = {479}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode$startInputSession$1 */
    static final class C08721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08721(Continuation<? super C08721> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TextFieldDecoratorModifierNode.this.new C08721(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (PlatformTextInputModifierNodeKt.establishTextInputSession(TextFieldDecoratorModifierNode.this, new AnonymousClass1(TextFieldDecoratorModifierNode.this, null), this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }

        /* compiled from: TextFieldDecoratorModifier.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1", m180f = "TextFieldDecoratorModifier.kt", m181i = {}, m182l = {485}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<PlatformTextInputSessionScope, Continuation<?>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TextFieldDecoratorModifierNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldDecoratorModifierNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(PlatformTextInputSessionScope platformTextInputSessionScope, Continuation<?> continuation) {
                return ((AnonymousClass1) create(platformTextInputSessionScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        PlatformTextInputSessionScope $this$establishTextInputSession = (PlatformTextInputSessionScope) this.L$0;
                        BuildersKt__Builders_commonKt.launch$default($this$establishTextInputSession, null, CoroutineStart.UNDISPATCHED, new C31731(this.this$0, null), 1, null);
                        this.label = 1;
                        if (AndroidTextInputSession_androidKt.platformSpecificTextInputSession($this$establishTextInputSession, this.this$0.getTextFieldState(), this.this$0.getKeyboardOptions().toImeOptions$foundation_release(this.this$0.getSingleLine()), this.this$0.onImeActionPerformed, this) != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                throw new KotlinNothingValueException();
            }

            /* compiled from: TextFieldDecoratorModifier.kt */
            @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1$1", m180f = "TextFieldDecoratorModifier.kt", m181i = {}, m182l = {482}, m183m = "invokeSuspend", m184n = {}, m185s = {})
            /* renamed from: androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1$1, reason: invalid class name and collision with other inner class name */
            static final class C31731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ TextFieldDecoratorModifierNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C31731(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, Continuation<? super C31731> continuation) {
                    super(2, continuation);
                    this.this$0 = textFieldDecoratorModifierNode;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C31731(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C31731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (this.this$0.getTextFieldSelectionState().observeChanges(this) != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
        }
    }

    private final void startInputSession() {
        this.inputSessionJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C08721(null), 3, null);
    }

    private final void disposeInputSession() {
        Job job = this.inputSessionJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.inputSessionJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startOrDisposeInputSessionOnWindowFocusChange() {
        if (this.windowInfo == null) {
            return;
        }
        WindowInfo windowInfo = this.windowInfo;
        boolean z = false;
        if (windowInfo != null && windowInfo.isWindowFocused()) {
            z = true;
        }
        if (z && this.isElementFocused) {
            startInputSession();
        } else {
            disposeInputSession();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SoftwareKeyboardController requireKeyboardController() {
        SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalSoftwareKeyboardController());
        if (softwareKeyboardController != null) {
            return softwareKeyboardController;
        }
        throw new IllegalStateException("No software keyboard controller".toString());
    }
}
