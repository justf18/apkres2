package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.p000ui.focus.FocusRequester;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.hapticfeedback.HapticFeedback;
import androidx.compose.p000ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.platform.ClipboardManager;
import androidx.compose.p000ui.platform.TextToolbar;
import androidx.compose.p000ui.platform.TextToolbarStatus;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextRange;
import androidx.compose.p000ui.text.TextRangeKt;
import androidx.compose.p000ui.text.input.OffsetMapping;
import androidx.compose.p000ui.text.input.TextFieldValue;
import androidx.compose.p000ui.text.input.TextFieldValueKt;
import androidx.compose.p000ui.text.input.VisualTransformation;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: TextFieldSelectionManager.kt */
@Metadata(m164d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010n\u001a\u00020B2\u0006\u0010o\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\bp\u0010qJ\u0017\u0010r\u001a\u00020B2\b\b\u0002\u0010s\u001a\u00020!H\u0000¢\u0006\u0002\btJ\"\u0010u\u001a\u00020?2\u0006\u0010v\u001a\u00020[2\u0006\u0010w\u001a\u00020xH\u0002ø\u0001\u0000¢\u0006\u0004\by\u0010zJ\r\u0010{\u001a\u00020WH\u0000¢\u0006\u0002\b|J\r\u0010}\u001a\u00020BH\u0000¢\u0006\u0002\b~J\u001d\u0010\u007f\u001a\u00020B2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\fH\u0000ø\u0001\u0000¢\u0006\u0003\b\u0080\u0001J\u001a\u0010\u0081\u0001\u001a\u00020B2\t\b\u0002\u0010\u0082\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0085\u0001J\n\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0002J\"\u0010\u0088\u0001\u001a\u00020\f2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J!\u0010\u008d\u0001\u001a\u00020\f2\u0007\u0010\u008e\u0001\u001a\u00020!H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0018\u0010\u0091\u0001\u001a\u00020W2\u0007\u0010\u008e\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0092\u0001J\u000f\u0010\u0093\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0094\u0001J\u000f\u0010\u0095\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b\u0096\u0001J\u000f\u0010\u0097\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u0098\u0001J\u000f\u0010\u0099\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u009a\u0001J\u0013\u0010\u009b\u0001\u001a\u00020B2\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0002J\u000f\u0010\u009e\u0001\u001a\u00020BH\u0000¢\u0006\u0003\b\u009f\u0001J\u0012\u0010 \u0001\u001a\u00020B2\u0007\u0010¡\u0001\u001a\u00020!H\u0002JK\u0010¢\u0001\u001a\u00020x2\u0006\u0010b\u001a\u00020?2\u0007\u0010£\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020!2\u0007\u0010\u008e\u0001\u001a\u00020!2\b\u0010¥\u0001\u001a\u00030¦\u00012\u0007\u0010§\u0001\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0006\b¨\u0001\u0010©\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR5\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f8F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R/\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0013\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\u000205X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010@\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020B0AX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020WX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u001c\u0010Z\u001a\u0004\u0018\u00010[8@X\u0080\u0004¢\u0006\f\u0012\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR+\u0010b\u001a\u00020?2\u0006\u0010\u000b\u001a\u00020?8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bg\u0010\u0013\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001a\u0010h\u001a\u00020iX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006ª\u0001"}, m165d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "(Landroidx/compose/foundation/text/UndoManager;)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager$foundation_release", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager$foundation_release", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginOffsetInText", "", "Ljava/lang/Integer;", "dragBeginPosition", "J", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "oldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "previousRawDragOffset", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "state", "Landroidx/compose/foundation/text/TextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/TextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/TextFieldState;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "transformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getTransformedText$foundation_release$annotations", "()V", "getTransformedText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "value", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "value$delegate", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "contextMenuOpenAdjustment", "position", "contextMenuOpenAdjustment-k-4lQ0M", "(J)V", "copy", "cancelSelection", "copy$foundation_release", "createTextFieldValue", "annotatedString", "selection", "Landroidx/compose/ui/text/TextRange;", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "cursorDragObserver", "cursorDragObserver$foundation_release", "cut", "cut$foundation_release", "deselect", "deselect-_kEHs6E$foundation_release", "enterSelectionMode", "showFloatingToolbar", "enterSelectionMode$foundation_release", "exitSelectionMode", "exitSelectionMode$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "handleDragObserver", "handleDragObserver$foundation_release", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "isTextChanged", "isTextChanged$foundation_release", "paste", "paste$foundation_release", "selectAll", "selectAll$foundation_release", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "updateFloatingToolbar", "show", "updateSelection", "currentPosition", "isStartOfSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isTouchBasedSelection", "updateSelection-8UEBfa8", "(Landroidx/compose/ui/text/input/TextFieldValue;JZZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldSelectionManager {
    public static final int $stable = 8;
    private ClipboardManager clipboardManager;

    /* renamed from: currentDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState currentDragPosition;
    private Integer dragBeginOffsetInText;
    private long dragBeginPosition;
    private long dragTotalDistance;

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;

    /* renamed from: editable$delegate, reason: from kotlin metadata */
    private final MutableState editable;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1<? super TextFieldValue, Unit> onValueChange;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private TextFieldState state;
    private TextToolbar textToolbar;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;
    private VisualTransformation visualTransformation;

    public TextFieldSelectionManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void getTransformedText$foundation_release$annotations() {
    }

    public TextFieldSelectionManager(UndoManager undoManager) {
        this.undoManager = undoManager;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$onValueChange$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                invoke2(textFieldValue);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldValue it) {
            }
        };
        this.value = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
        this.visualTransformation = VisualTransformation.INSTANCE.getNone();
        this.editable = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.dragBeginPosition = Offset.INSTANCE.m3724getZeroF1C5BW0();
        this.dragTotalDistance = Offset.INSTANCE.m3724getZeroF1C5BW0();
        this.draggingHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1108onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1110onStartk4lQ0M(long startPoint) {
                TextLayoutResultProxy layoutResult;
                TextLayoutResultProxy layoutResult2;
                if (this.this$0.getDraggingHandle() != null) {
                    return;
                }
                this.this$0.setDraggingHandle(Handle.SelectionEnd);
                this.this$0.previousRawDragOffset = -1;
                this.this$0.hideSelectionToolbar$foundation_release();
                TextFieldState state = this.this$0.getState();
                if (!((state == null || (layoutResult2 = state.getLayoutResult()) == null || !layoutResult2.m1143isPositionOnTextk4lQ0M(startPoint)) ? false : true)) {
                    TextFieldState state2 = this.this$0.getState();
                    if (state2 != null && (layoutResult = state2.getLayoutResult()) != null) {
                        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                        int transformedOffset = TextLayoutResultProxy.m1141getOffsetForPosition3MmeM6k$default(layoutResult, startPoint, false, 2, null);
                        int offset = textFieldSelectionManager.getOffsetMapping().transformedToOriginal(transformedOffset);
                        TextFieldValue newValue = textFieldSelectionManager.m1259createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getText(), TextRangeKt.TextRange(offset, offset));
                        textFieldSelectionManager.enterSelectionMode$foundation_release(false);
                        textFieldSelectionManager.setHandleState(HandleState.Cursor);
                        HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                        if (hapticFeedBack != null) {
                            hapticFeedBack.mo4620performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4629getTextHandleMove5zf0vsI());
                        }
                        textFieldSelectionManager.getOnValueChange$foundation_release().invoke(newValue);
                    }
                } else {
                    if (this.this$0.getValue$foundation_release().getText().length() == 0) {
                        return;
                    }
                    this.this$0.enterSelectionMode$foundation_release(false);
                    long adjustedStartSelection = this.this$0.m1262updateSelection8UEBfa8(TextFieldValue.m6007copy3r_uNRQ$default(this.this$0.getValue$foundation_release(), (AnnotatedString) null, TextRange.INSTANCE.m5779getZerod9O1mEE(), (TextRange) null, 5, (Object) null), startPoint, true, false, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), true);
                    this.this$0.dragBeginOffsetInText = Integer.valueOf(TextRange.m5774getStartimpl(adjustedStartSelection));
                }
                this.this$0.dragBeginPosition = startPoint;
                this.this$0.m1261setCurrentDragPosition_kEHs6E(Offset.m3697boximpl(this.this$0.dragBeginPosition));
                this.this$0.dragTotalDistance = Offset.INSTANCE.m3724getZeroF1C5BW0();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1109onDragk4lQ0M(long delta) {
                TextLayoutResultProxy layoutResult;
                TextLayoutResultProxy layoutResult2;
                long jM1262updateSelection8UEBfa8;
                SelectionAdjustment adjustment;
                if (this.this$0.getValue$foundation_release().getText().length() == 0) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragTotalDistance = Offset.m3713plusMKHz9U(textFieldSelectionManager.dragTotalDistance, delta);
                TextFieldState state = this.this$0.getState();
                if (state != null && (layoutResult = state.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                    textFieldSelectionManager2.m1261setCurrentDragPosition_kEHs6E(Offset.m3697boximpl(Offset.m3713plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                    if (textFieldSelectionManager2.dragBeginOffsetInText != null) {
                        layoutResult2 = layoutResult;
                    } else {
                        Offset offsetM1265getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m1265getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(offsetM1265getCurrentDragPosition_m7T9E);
                        if (layoutResult.m1143isPositionOnTextk4lQ0M(offsetM1265getCurrentDragPosition_m7T9E.getPackedValue())) {
                            layoutResult2 = layoutResult;
                        } else {
                            int startOffset = textFieldSelectionManager2.getOffsetMapping().transformedToOriginal(TextLayoutResultProxy.m1141getOffsetForPosition3MmeM6k$default(layoutResult, textFieldSelectionManager2.dragBeginPosition, false, 2, null));
                            OffsetMapping offsetMapping = textFieldSelectionManager2.getOffsetMapping();
                            Offset offsetM1265getCurrentDragPosition_m7T9E2 = textFieldSelectionManager2.m1265getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(offsetM1265getCurrentDragPosition_m7T9E2);
                            int endOffset = offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1141getOffsetForPosition3MmeM6k$default(layoutResult, offsetM1265getCurrentDragPosition_m7T9E2.getPackedValue(), false, 2, null));
                            if (startOffset == endOffset) {
                                adjustment = SelectionAdjustment.INSTANCE.getNone();
                            } else {
                                adjustment = SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate();
                            }
                            TextFieldValue value$foundation_release = textFieldSelectionManager2.getValue$foundation_release();
                            Offset offsetM1265getCurrentDragPosition_m7T9E3 = textFieldSelectionManager2.m1265getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(offsetM1265getCurrentDragPosition_m7T9E3);
                            jM1262updateSelection8UEBfa8 = textFieldSelectionManager2.m1262updateSelection8UEBfa8(value$foundation_release, offsetM1265getCurrentDragPosition_m7T9E3.getPackedValue(), false, false, adjustment, true);
                            TextRange.m5762boximpl(jM1262updateSelection8UEBfa8);
                        }
                    }
                    Integer num = textFieldSelectionManager2.dragBeginOffsetInText;
                    int startOffset2 = num != null ? num.intValue() : layoutResult2.m1142getOffsetForPosition3MmeM6k(textFieldSelectionManager2.dragBeginPosition, false);
                    Offset offsetM1265getCurrentDragPosition_m7T9E4 = textFieldSelectionManager2.m1265getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(offsetM1265getCurrentDragPosition_m7T9E4);
                    int endOffset2 = layoutResult2.m1142getOffsetForPosition3MmeM6k(offsetM1265getCurrentDragPosition_m7T9E4.getPackedValue(), false);
                    if (textFieldSelectionManager2.dragBeginOffsetInText == null && startOffset2 == endOffset2) {
                        return;
                    }
                    TextFieldValue value$foundation_release2 = textFieldSelectionManager2.getValue$foundation_release();
                    Offset offsetM1265getCurrentDragPosition_m7T9E5 = textFieldSelectionManager2.m1265getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(offsetM1265getCurrentDragPosition_m7T9E5);
                    jM1262updateSelection8UEBfa8 = textFieldSelectionManager2.m1262updateSelection8UEBfa8(value$foundation_release2, offsetM1265getCurrentDragPosition_m7T9E5.getPackedValue(), false, false, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), true);
                    TextRange.m5762boximpl(jM1262updateSelection8UEBfa8);
                }
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m1261setCurrentDragPosition_kEHs6E(null);
                this.this$0.updateFloatingToolbar(true);
                this.this$0.dragBeginOffsetInText = null;
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }
        };
        this.mouseSelectionObserver = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtend-k-4lQ0M */
            public boolean mo1182onExtendk4lQ0M(long downPosition) {
                TextFieldState state = this.this$0.getState();
                if (state != null && state.getLayoutResult() != null) {
                    this.this$0.previousRawDragOffset = -1;
                    this.this$0.m1262updateSelection8UEBfa8(this.this$0.getValue$foundation_release(), downPosition, false, false, SelectionAdjustment.INSTANCE.getNone(), false);
                    return true;
                }
                return false;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtendDrag-k-4lQ0M */
            public boolean mo1183onExtendDragk4lQ0M(long dragPosition) {
                TextFieldState state;
                if (!(this.this$0.getValue$foundation_release().getText().length() == 0) && (state = this.this$0.getState()) != null && state.getLayoutResult() != null) {
                    this.this$0.m1262updateSelection8UEBfa8(this.this$0.getValue$foundation_release(), dragPosition, false, false, SelectionAdjustment.INSTANCE.getNone(), false);
                    return true;
                }
                return false;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onStart-3MmeM6k */
            public boolean mo1184onStart3MmeM6k(long downPosition, SelectionAdjustment adjustment) {
                TextFieldState state;
                if (!(this.this$0.getValue$foundation_release().getText().length() == 0) && (state = this.this$0.getState()) != null && state.getLayoutResult() != null) {
                    FocusRequester focusRequester = this.this$0.getFocusRequester();
                    if (focusRequester != null) {
                        focusRequester.requestFocus();
                    }
                    this.this$0.dragBeginPosition = downPosition;
                    this.this$0.previousRawDragOffset = -1;
                    TextFieldSelectionManager.enterSelectionMode$foundation_release$default(this.this$0, false, 1, null);
                    this.this$0.m1262updateSelection8UEBfa8(this.this$0.getValue$foundation_release(), this.this$0.dragBeginPosition, true, false, adjustment, false);
                    return true;
                }
                return false;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onDrag-3MmeM6k */
            public boolean mo1181onDrag3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
                TextFieldState state;
                if (!(this.this$0.getValue$foundation_release().getText().length() == 0) && (state = this.this$0.getState()) != null && state.getLayoutResult() != null) {
                    this.this$0.m1262updateSelection8UEBfa8(this.this$0.getValue$foundation_release(), dragPosition, false, false, adjustment, false);
                    return true;
                }
                return false;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public void onDragDone() {
            }
        };
    }

    public /* synthetic */ TextFieldSelectionManager(UndoManager undoManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : undoManager);
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    /* renamed from: getOffsetMapping$foundation_release, reason: from getter */
    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping offsetMapping) {
        this.offsetMapping = offsetMapping;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    public final void setOnValueChange$foundation_release(Function1<? super TextFieldValue, Unit> function1) {
        this.onValueChange = function1;
    }

    /* renamed from: getState$foundation_release, reason: from getter */
    public final TextFieldState getState() {
        return this.state;
    }

    public final void setState$foundation_release(TextFieldState textFieldState) {
        this.state = textFieldState;
    }

    public final TextFieldValue getValue$foundation_release() {
        State $this$getValue$iv = this.value;
        return (TextFieldValue) $this$getValue$iv.getValue();
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        MutableState $this$setValue$iv = this.value;
        $this$setValue$iv.setValue(textFieldValue);
    }

    public final AnnotatedString getTransformedText$foundation_release() {
        TextDelegate textDelegate;
        TextFieldState textFieldState = this.state;
        if (textFieldState == null || (textDelegate = textFieldState.getTextDelegate()) == null) {
            return null;
        }
        return textDelegate.getText();
    }

    /* renamed from: getVisualTransformation$foundation_release, reason: from getter */
    public final VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation visualTransformation) {
        this.visualTransformation = visualTransformation;
    }

    /* renamed from: getClipboardManager$foundation_release, reason: from getter */
    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public final void setClipboardManager$foundation_release(ClipboardManager clipboardManager) {
        this.clipboardManager = clipboardManager;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    public final boolean getEditable() {
        State $this$getValue$iv = this.editable;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setEditable(boolean z) {
        MutableState $this$setValue$iv = this.editable;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        MutableState $this$setValue$iv = this.draggingHandle;
        $this$setValue$iv.setValue(handle);
    }

    public final Handle getDraggingHandle() {
        State $this$getValue$iv = this.draggingHandle;
        return (Handle) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m1261setCurrentDragPosition_kEHs6E(Offset offset) {
        MutableState $this$setValue$iv = this.currentDragPosition;
        $this$setValue$iv.setValue(offset);
    }

    /* renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m1265getCurrentDragPosition_m7T9E() {
        State $this$getValue$iv = this.currentDragPosition;
        return (Offset) $this$getValue$iv.getValue();
    }

    /* renamed from: getTouchSelectionObserver$foundation_release, reason: from getter */
    public final TextDragObserver getTouchSelectionObserver() {
        return this.touchSelectionObserver;
    }

    /* renamed from: getMouseSelectionObserver$foundation_release, reason: from getter */
    public final MouseSelectionObserver getMouseSelectionObserver() {
        return this.mouseSelectionObserver;
    }

    public final TextDragObserver handleDragObserver$foundation_release(final boolean isStartHandle) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1108onDownk4lQ0M(long point) {
                TextLayoutResultProxy layoutResult;
                this.this$0.setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
                long handleCoordinates = SelectionHandlesKt.m1208getAdjustedCoordinatesk4lQ0M(this.this$0.m1267getHandlePositiontuRUvjQ$foundation_release(isStartHandle));
                TextFieldState state = this.this$0.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long translatedPosition = layoutResult.m1145translateInnerToDecorationCoordinatesMKHz9U$foundation_release(handleCoordinates);
                this.this$0.dragBeginPosition = translatedPosition;
                this.this$0.m1261setCurrentDragPosition_kEHs6E(Offset.m3697boximpl(translatedPosition));
                this.this$0.dragTotalDistance = Offset.INSTANCE.m3724getZeroF1C5BW0();
                this.this$0.previousRawDragOffset = -1;
                TextFieldState state2 = this.this$0.getState();
                if (state2 != null) {
                    state2.setInTouchMode(true);
                }
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m1261setCurrentDragPosition_kEHs6E(null);
                this.this$0.updateFloatingToolbar(true);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1110onStartk4lQ0M(long startPoint) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1109onDragk4lQ0M(long delta) {
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragTotalDistance = Offset.m3713plusMKHz9U(textFieldSelectionManager.dragTotalDistance, delta);
                this.this$0.m1261setCurrentDragPosition_kEHs6E(Offset.m3697boximpl(Offset.m3713plusMKHz9U(this.this$0.dragBeginPosition, this.this$0.dragTotalDistance)));
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                TextFieldValue value$foundation_release = this.this$0.getValue$foundation_release();
                Offset offsetM1265getCurrentDragPosition_m7T9E = this.this$0.m1265getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(offsetM1265getCurrentDragPosition_m7T9E);
                textFieldSelectionManager2.m1262updateSelection8UEBfa8(value$foundation_release, offsetM1265getCurrentDragPosition_m7T9E.getPackedValue(), false, isStartHandle, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), true);
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m1261setCurrentDragPosition_kEHs6E(null);
                this.this$0.updateFloatingToolbar(true);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }
        };
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1108onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m1261setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1110onStartk4lQ0M(long startPoint) {
                TextLayoutResultProxy layoutResult;
                long handleCoordinates = SelectionHandlesKt.m1208getAdjustedCoordinatesk4lQ0M(this.this$0.m1267getHandlePositiontuRUvjQ$foundation_release(true));
                TextFieldState state = this.this$0.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long translatedPosition = layoutResult.m1145translateInnerToDecorationCoordinatesMKHz9U$foundation_release(handleCoordinates);
                this.this$0.dragBeginPosition = translatedPosition;
                this.this$0.m1261setCurrentDragPosition_kEHs6E(Offset.m3697boximpl(translatedPosition));
                this.this$0.dragTotalDistance = Offset.INSTANCE.m3724getZeroF1C5BW0();
                this.this$0.setDraggingHandle(Handle.Cursor);
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1109onDragk4lQ0M(long delta) {
                TextLayoutResultProxy layoutResult;
                HapticFeedback hapticFeedBack;
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragTotalDistance = Offset.m3713plusMKHz9U(textFieldSelectionManager.dragTotalDistance, delta);
                TextFieldState state = this.this$0.getState();
                if (state != null && (layoutResult = state.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                    textFieldSelectionManager2.m1261setCurrentDragPosition_kEHs6E(Offset.m3697boximpl(Offset.m3713plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                    OffsetMapping offsetMapping = textFieldSelectionManager2.getOffsetMapping();
                    Offset offsetM1265getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m1265getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(offsetM1265getCurrentDragPosition_m7T9E);
                    int offset = offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1141getOffsetForPosition3MmeM6k$default(layoutResult, offsetM1265getCurrentDragPosition_m7T9E.getPackedValue(), false, 2, null));
                    long newSelection = TextRangeKt.TextRange(offset, offset);
                    if (TextRange.m5767equalsimpl0(newSelection, textFieldSelectionManager2.getValue$foundation_release().getSelection())) {
                        return;
                    }
                    TextFieldState state2 = textFieldSelectionManager2.getState();
                    boolean z = false;
                    if (state2 != null && !state2.isInTouchMode()) {
                        z = true;
                    }
                    if (!z && (hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack()) != null) {
                        hapticFeedBack.mo4620performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4629getTextHandleMove5zf0vsI());
                    }
                    textFieldSelectionManager2.getOnValueChange$foundation_release().invoke(textFieldSelectionManager2.m1259createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getText(), newSelection));
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m1261setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }
        };
    }

    public static /* synthetic */ void enterSelectionMode$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.enterSelectionMode$foundation_release(z);
    }

    public final void enterSelectionMode$foundation_release(boolean showFloatingToolbar) {
        FocusRequester focusRequester;
        TextFieldState textFieldState = this.state;
        boolean z = false;
        if (textFieldState != null && !textFieldState.getHasFocus()) {
            z = true;
        }
        if (z && (focusRequester = this.focusRequester) != null) {
            focusRequester.requestFocus();
        }
        this.oldValue = getValue$foundation_release();
        updateFloatingToolbar(showFloatingToolbar);
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        updateFloatingToolbar(false);
        setHandleState(HandleState.None);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ void m1260deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m1264deselect_kEHs6E$foundation_release(offset);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* renamed from: deselect-_kEHs6E$foundation_release, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1264deselect_kEHs6E$foundation_release(androidx.compose.p000ui.geometry.Offset r10) {
        /*
            r9 = this;
            androidx.compose.ui.text.input.TextFieldValue r0 = r9.getValue$foundation_release()
            long r0 = r0.getSelection()
            boolean r0 = androidx.compose.p000ui.text.TextRange.m5768getCollapsedimpl(r0)
            if (r0 != 0) goto L51
            androidx.compose.foundation.text.TextFieldState r0 = r9.state
            if (r0 == 0) goto L17
            androidx.compose.foundation.text.TextLayoutResultProxy r0 = r0.getLayoutResult()
            goto L18
        L17:
            r0 = 0
        L18:
            r1 = r0
            if (r10 == 0) goto L2f
            if (r1 == 0) goto L2f
            androidx.compose.ui.text.input.OffsetMapping r0 = r9.offsetMapping
            long r2 = r10.getPackedValue()
            r5 = 2
            r6 = 0
            r4 = 0
            int r2 = androidx.compose.foundation.text.TextLayoutResultProxy.m1141getOffsetForPosition3MmeM6k$default(r1, r2, r4, r5, r6)
            int r0 = r0.transformedToOriginal(r2)
            goto L3b
        L2f:
            androidx.compose.ui.text.input.TextFieldValue r0 = r9.getValue$foundation_release()
            long r2 = r0.getSelection()
            int r0 = androidx.compose.p000ui.text.TextRange.m5771getMaximpl(r2)
        L3b:
            androidx.compose.ui.text.input.TextFieldValue r2 = r9.getValue$foundation_release()
            long r4 = androidx.compose.p000ui.text.TextRangeKt.TextRange(r0)
            r7 = 5
            r8 = 0
            r3 = 0
            r6 = 0
            androidx.compose.ui.text.input.TextFieldValue r2 = androidx.compose.p000ui.text.input.TextFieldValue.m6007copy3r_uNRQ$default(r2, r3, r4, r6, r7, r8)
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r3 = r9.onValueChange
            r3.invoke(r2)
        L51:
            r0 = 0
            if (r10 == 0) goto L6c
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            java.lang.String r1 = r1.getText()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L66
            r1 = 1
            goto L67
        L66:
            r1 = r0
        L67:
            if (r1 == 0) goto L6c
            androidx.compose.foundation.text.HandleState r1 = androidx.compose.foundation.text.HandleState.Cursor
            goto L6e
        L6c:
            androidx.compose.foundation.text.HandleState r1 = androidx.compose.foundation.text.HandleState.None
        L6e:
            r9.setHandleState(r1)
            r9.updateFloatingToolbar(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.m1264deselect_kEHs6E$foundation_release(androidx.compose.ui.geometry.Offset):void");
    }

    public static /* synthetic */ void copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.copy$foundation_release(z);
    }

    public final void copy$foundation_release(boolean cancelSelection) {
        if (TextRange.m5768getCollapsedimpl(getValue$foundation_release().getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        if (cancelSelection) {
            int newCursorOffset = TextRange.m5771getMaximpl(getValue$foundation_release().getSelection());
            TextFieldValue newValue = m1259createTextFieldValueFDrldGo(getValue$foundation_release().getText(), TextRangeKt.TextRange(newCursorOffset, newCursorOffset));
            this.onValueChange.invoke(newValue);
            setHandleState(HandleState.None);
        }
    }

    public final void paste$foundation_release() {
        AnnotatedString text;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null) {
            return;
        }
        AnnotatedString newText = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(text).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int newCursorOffset = TextRange.m5772getMinimpl(getValue$foundation_release().getSelection()) + text.length();
        TextFieldValue newValue = m1259createTextFieldValueFDrldGo(newText, TextRangeKt.TextRange(newCursorOffset, newCursorOffset));
        this.onValueChange.invoke(newValue);
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    public final void cut$foundation_release() {
        if (TextRange.m5768getCollapsedimpl(getValue$foundation_release().getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        AnnotatedString newText = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int newCursorOffset = TextRange.m5772getMinimpl(getValue$foundation_release().getSelection());
        TextFieldValue newValue = m1259createTextFieldValueFDrldGo(newText, TextRangeKt.TextRange(newCursorOffset, newCursorOffset));
        this.onValueChange.invoke(newValue);
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    public final void selectAll$foundation_release() {
        TextFieldValue newValue = m1259createTextFieldValueFDrldGo(getValue$foundation_release().getText(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(newValue);
        this.oldValue = TextFieldValue.m6007copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, newValue.getSelection(), (TextRange) null, 5, (Object) null);
        enterSelectionMode$foundation_release(true);
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m1267getHandlePositiontuRUvjQ$foundation_release(boolean isStartHandle) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult textLayoutResult;
        TextFieldState textFieldState = this.state;
        if (textFieldState == null || (layoutResult = textFieldState.getLayoutResult()) == null || (textLayoutResult = layoutResult.getValue()) == null) {
            return Offset.INSTANCE.m3723getUnspecifiedF1C5BW0();
        }
        AnnotatedString transformedText = getTransformedText$foundation_release();
        if (transformedText == null) {
            return Offset.INSTANCE.m3723getUnspecifiedF1C5BW0();
        }
        String layoutInputText = textLayoutResult.getLayoutInput().getText().getText();
        if (!Intrinsics.areEqual(transformedText.getText(), layoutInputText)) {
            return Offset.INSTANCE.m3723getUnspecifiedF1C5BW0();
        }
        long selection = getValue$foundation_release().getSelection();
        int offset = isStartHandle ? TextRange.m5774getStartimpl(selection) : TextRange.m5769getEndimpl(selection);
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(textLayoutResult, this.offsetMapping.originalToTransformed(offset), isStartHandle, TextRange.m5773getReversedimpl(getValue$foundation_release().getSelection()));
    }

    /* renamed from: getCursorPosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m1266getCursorPositiontuRUvjQ$foundation_release(Density density) {
        int offset = this.offsetMapping.originalToTransformed(TextRange.m5774getStartimpl(getValue$foundation_release().getSelection()));
        TextFieldState textFieldState = this.state;
        TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult layoutResult2 = layoutResult.getValue();
        Rect cursorRect = layoutResult2.getCursorRect(RangesKt.coerceIn(offset, 0, layoutResult2.getLayoutInput().getText().length()));
        float x = cursorRect.getLeft() + (density.mo518toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness()) / 2);
        return OffsetKt.Offset(x, cursorRect.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFloatingToolbar(boolean show) {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setShowFloatingToolbar(show);
        }
        if (show) {
            showSelectionToolbar$foundation_release();
        } else {
            hideSelectionToolbar$foundation_release();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showSelectionToolbar$foundation_release() {
        /*
            r11 = this;
            androidx.compose.foundation.text.TextFieldState r0 = r11.state
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Le
            boolean r0 = r0.isInTouchMode()
            if (r0 != 0) goto Le
            r0 = r1
            goto Lf
        Le:
            r0 = r2
        Lf:
            if (r0 == 0) goto L12
            return
        L12:
            androidx.compose.ui.text.input.VisualTransformation r0 = r11.visualTransformation
            boolean r0 = r0 instanceof androidx.compose.p000ui.text.input.PasswordVisualTransformation
            androidx.compose.ui.text.input.TextFieldValue r3 = r11.getValue$foundation_release()
            long r3 = r3.getSelection()
            boolean r3 = androidx.compose.p000ui.text.TextRange.m5768getCollapsedimpl(r3)
            r4 = 0
            if (r3 != 0) goto L2f
            if (r0 != 0) goto L2f
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1 r3 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1
            r3.<init>()
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            goto L30
        L2f:
            r3 = r4
        L30:
            r7 = r3
            androidx.compose.ui.text.input.TextFieldValue r3 = r11.getValue$foundation_release()
            long r5 = r3.getSelection()
            boolean r3 = androidx.compose.p000ui.text.TextRange.m5768getCollapsedimpl(r5)
            if (r3 != 0) goto L50
            boolean r3 = r11.getEditable()
            if (r3 == 0) goto L50
            if (r0 != 0) goto L50
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1 r3 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1
            r3.<init>()
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r9 = r3
            goto L51
        L50:
            r9 = r4
        L51:
            boolean r3 = r11.getEditable()
            if (r3 == 0) goto L6f
            androidx.compose.ui.platform.ClipboardManager r3 = r11.clipboardManager
            if (r3 == 0) goto L63
            boolean r3 = r3.hasText()
            if (r3 != r1) goto L63
            goto L64
        L63:
            r1 = r2
        L64:
            if (r1 == 0) goto L6f
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1 r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1
            r1.<init>()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r8 = r1
            goto L70
        L6f:
            r8 = r4
        L70:
            androidx.compose.ui.text.input.TextFieldValue r1 = r11.getValue$foundation_release()
            long r1 = r1.getSelection()
            int r1 = androidx.compose.p000ui.text.TextRange.m5770getLengthimpl(r1)
            androidx.compose.ui.text.input.TextFieldValue r2 = r11.getValue$foundation_release()
            java.lang.String r2 = r2.getText()
            int r2 = r2.length()
            if (r1 == r2) goto L95
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1 r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1
            r1.<init>()
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r10 = r4
            goto L96
        L95:
            r10 = r4
        L96:
            androidx.compose.ui.platform.TextToolbar r5 = r11.textToolbar
            if (r5 == 0) goto La6
            androidx.compose.ui.geometry.Rect r6 = r11.getContentRect()
            r5.showMenu(r6, r7, r8, r9, r10)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar$foundation_release():void");
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M, reason: not valid java name */
    public final void m1263contextMenuOpenAdjustmentk4lQ0M(long position) {
        TextLayoutResultProxy layoutResult;
        TextFieldState textFieldState = this.state;
        if (textFieldState != null && (layoutResult = textFieldState.getLayoutResult()) != null) {
            int offset = TextLayoutResultProxy.m1141getOffsetForPosition3MmeM6k$default(layoutResult, position, false, 2, null);
            if (!TextRange.m5765containsimpl(getValue$foundation_release().getSelection(), offset)) {
                this.previousRawDragOffset = -1;
                m1262updateSelection8UEBfa8(getValue$foundation_release(), position, true, false, SelectionAdjustment.INSTANCE.getWord(), false);
            }
        }
    }

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual(this.oldValue.getText(), getValue$foundation_release().getText());
    }

    private final Rect getContentRect() {
        float startTop;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResult value;
        Rect cursorRect;
        LayoutCoordinates layoutCoordinates2;
        TextLayoutResult value2;
        Rect cursorRect2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        TextFieldState it = this.state;
        if (it != null) {
            if (it.getIsLayoutResultStale()) {
                it = null;
            }
            if (it != null) {
                int transformedStart = this.offsetMapping.originalToTransformed(TextRange.m5774getStartimpl(getValue$foundation_release().getSelection()));
                int transformedEnd = this.offsetMapping.originalToTransformed(TextRange.m5769getEndimpl(getValue$foundation_release().getSelection()));
                TextFieldState textFieldState = this.state;
                long startOffset = (textFieldState == null || (layoutCoordinates4 = textFieldState.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m3724getZeroF1C5BW0() : layoutCoordinates4.mo5228localToRootMKHz9U(m1267getHandlePositiontuRUvjQ$foundation_release(true));
                TextFieldState textFieldState2 = this.state;
                long endOffset = (textFieldState2 == null || (layoutCoordinates3 = textFieldState2.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m3724getZeroF1C5BW0() : layoutCoordinates3.mo5228localToRootMKHz9U(m1267getHandlePositiontuRUvjQ$foundation_release(false));
                TextFieldState textFieldState3 = this.state;
                float endTop = 0.0f;
                if (textFieldState3 == null || (layoutCoordinates2 = textFieldState3.getLayoutCoordinates()) == null) {
                    startTop = 0.0f;
                } else {
                    TextLayoutResultProxy layoutResult = it.getLayoutResult();
                    startTop = Offset.m3709getYimpl(layoutCoordinates2.mo5228localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(transformedStart)) == null) ? 0.0f : cursorRect2.getTop())));
                }
                TextFieldState textFieldState4 = this.state;
                if (textFieldState4 != null && (layoutCoordinates = textFieldState4.getLayoutCoordinates()) != null) {
                    TextLayoutResultProxy layoutResult2 = it.getLayoutResult();
                    endTop = Offset.m3709getYimpl(layoutCoordinates.mo5228localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(transformedEnd)) == null) ? 0.0f : cursorRect.getTop())));
                }
                float left = Math.min(Offset.m3708getXimpl(startOffset), Offset.m3708getXimpl(endOffset));
                float right = Math.max(Offset.m3708getXimpl(startOffset), Offset.m3708getXimpl(endOffset));
                float top = Math.min(startTop, endTop);
                float bottom = Math.max(Offset.m3709getYimpl(startOffset), Offset.m3709getYimpl(endOffset)) + (C1956Dp.m6297constructorimpl(25) * it.getTextDelegate().getDensity().getDensity());
                return new Rect(left, top, right, bottom);
            }
        }
        return Rect.INSTANCE.getZero();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-8UEBfa8, reason: not valid java name */
    public final long m1262updateSelection8UEBfa8(TextFieldValue value, long currentPosition, boolean isStartOfSelection, boolean isStartHandle, SelectionAdjustment adjustment, boolean isTouchBasedSelection) {
        TextLayoutResultProxy layoutResult;
        int rawStartHandleOffset;
        int rawEndHandleOffset;
        int rawPreviousHandleOffset;
        HapticFeedback hapticFeedback;
        TextFieldState textFieldState = this.state;
        if (textFieldState == null || (layoutResult = textFieldState.getLayoutResult()) == null) {
            return TextRange.INSTANCE.m5779getZerod9O1mEE();
        }
        long previousTransformedSelection = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m5774getStartimpl(value.getSelection())), this.offsetMapping.originalToTransformed(TextRange.m5769getEndimpl(value.getSelection())));
        int currentOffset = layoutResult.m1142getOffsetForPosition3MmeM6k(currentPosition, false);
        if (isStartHandle || isStartOfSelection) {
            rawStartHandleOffset = currentOffset;
        } else {
            rawStartHandleOffset = TextRange.m5774getStartimpl(previousTransformedSelection);
        }
        if (!isStartHandle || isStartOfSelection) {
            rawEndHandleOffset = currentOffset;
        } else {
            rawEndHandleOffset = TextRange.m5769getEndimpl(previousTransformedSelection);
        }
        SelectionLayout previousSelectionLayout = this.previousSelectionLayout;
        if (isStartOfSelection || previousSelectionLayout == null || this.previousRawDragOffset == -1) {
            rawPreviousHandleOffset = -1;
        } else {
            rawPreviousHandleOffset = this.previousRawDragOffset;
        }
        SelectionLayout selectionLayout = SelectionLayoutKt.m1211getTextFieldSelectionLayoutRcvTLA(layoutResult.getValue(), rawStartHandleOffset, rawEndHandleOffset, rawPreviousHandleOffset, previousTransformedSelection, isStartOfSelection, isStartHandle);
        if (!selectionLayout.shouldRecomputeSelection(previousSelectionLayout)) {
            return value.getSelection();
        }
        this.previousSelectionLayout = selectionLayout;
        this.previousRawDragOffset = currentOffset;
        Selection newTransformedSelection = adjustment.adjust(selectionLayout);
        long newSelection = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(newTransformedSelection.getStart().getOffset()), this.offsetMapping.transformedToOriginal(newTransformedSelection.getEnd().getOffset()));
        if (TextRange.m5767equalsimpl0(newSelection, value.getSelection())) {
            return value.getSelection();
        }
        boolean onlyChangeIsReversed = TextRange.m5773getReversedimpl(newSelection) != TextRange.m5773getReversedimpl(value.getSelection()) && TextRange.m5767equalsimpl0(TextRangeKt.TextRange(TextRange.m5769getEndimpl(newSelection), TextRange.m5774getStartimpl(newSelection)), value.getSelection());
        boolean bothSelectionsCollapsed = TextRange.m5768getCollapsedimpl(newSelection) && TextRange.m5768getCollapsedimpl(value.getSelection());
        if (isTouchBasedSelection) {
            if ((value.getText().length() > 0) && !onlyChangeIsReversed && !bothSelectionsCollapsed && (hapticFeedback = this.hapticFeedBack) != null) {
                hapticFeedback.mo4620performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4629getTextHandleMove5zf0vsI());
            }
        }
        TextFieldValue newValue = m1259createTextFieldValueFDrldGo(value.getText(), newSelection);
        this.onValueChange.invoke(newValue);
        HandleState handle = TextRange.m5768getCollapsedimpl(newValue.getSelection()) ? HandleState.Cursor : HandleState.Selection;
        setHandleState(handle);
        TextFieldState textFieldState2 = this.state;
        if (textFieldState2 != null) {
            textFieldState2.setInTouchMode(isTouchBasedSelection);
        }
        TextFieldState textFieldState3 = this.state;
        if (textFieldState3 != null) {
            textFieldState3.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
        }
        TextFieldState textFieldState4 = this.state;
        if (textFieldState4 != null) {
            textFieldState4.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
        }
        return newSelection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHandleState(HandleState handleState) {
        TextFieldState it = this.state;
        if (it != null) {
            if (it.getHandleState() == handleState) {
                it = null;
            }
            if (it != null) {
                it.setHandleState(handleState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    public final TextFieldValue m1259createTextFieldValueFDrldGo(AnnotatedString annotatedString, long selection) {
        return new TextFieldValue(annotatedString, selection, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }
}
