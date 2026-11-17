package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text2.input.internal.TextLayoutState;
import androidx.compose.foundation.text2.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text2.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.geometry.RectKt;
import androidx.compose.p000ui.hapticfeedback.HapticFeedback;
import androidx.compose.p000ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.platform.ClipboardManager;
import androidx.compose.p000ui.platform.TextToolbar;
import androidx.compose.p000ui.platform.TextToolbarStatus;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextRange;
import androidx.compose.p000ui.text.TextRangeKt;
import androidx.compose.p000ui.text.style.ResolvedTextDirection;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: TextFieldSelectionState.kt */
@Metadata(m164d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\b\u0010Z\u001a\u00020[H\u0002J\u0010\u0010\\\u001a\u00020[2\b\b\u0002\u0010]\u001a\u00020\tJ\u0006\u0010^\u001a\u00020[J\u0006\u0010_\u001a\u00020[J\u0006\u0010`\u001a\u00020[J\b\u0010a\u001a\u00020\u001eH\u0002J\u001d\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\u00142\u0006\u0010c\u001a\u00020\tH\u0002J<\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020:2\u0006\u0010j\u001a\u00020:2\b\u0010k\u001a\u0004\u0018\u00010h2\u0006\u0010c\u001a\u00020\t2\u0006\u0010l\u001a\u00020mH\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010oJ\b\u0010p\u001a\u00020[H\u0002J\b\u0010q\u001a\u00020[H\u0002J\u000e\u0010r\u001a\u00020[H\u0086@¢\u0006\u0002\u0010sJ\u000e\u0010t\u001a\u00020[H\u0082@¢\u0006\u0002\u0010sJ\u000e\u0010u\u001a\u00020[H\u0082@¢\u0006\u0002\u0010sJ\u0006\u0010v\u001a\u00020[J\u0010\u0010w\u001a\u00020[2\u0006\u0010x\u001a\u00020\u001eH\u0002J6\u0010y\u001a\u00020[2\u0006\u00102\u001a\u0002032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\"\u0010z\u001a\u00020[2\u0006\u0010{\u001a\u00020#2\u0006\u0010|\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b}\u0010~JN\u0010\u007f\u001a\u00020h2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020:2\u0007\u0010\u0083\u0001\u001a\u00020:2\u0006\u0010c\u001a\u00020\t2\u0006\u0010l\u001a\u00020m2\t\b\u0002\u0010\u0084\u0001\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u000f\u0010\u0087\u0001\u001a\u00020[2\u0006\u0010T\u001a\u00020SJ\u0015\u0010\u0088\u0001\u001a\u00020[*\u00030\u0089\u0001H\u0086@¢\u0006\u0003\u0010\u008a\u0001J\u0015\u0010\u008b\u0001\u001a\u00020[*\u00030\u0089\u0001H\u0082@¢\u0006\u0003\u0010\u008a\u0001J\u001d\u0010\u008c\u0001\u001a\u00020[*\u00030\u0089\u00012\u0006\u0010c\u001a\u00020\tH\u0082@¢\u0006\u0003\u0010\u008d\u0001J%\u0010\u008e\u0001\u001a\u00020[*\u00030\u0089\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u0001H\u0082@¢\u0006\u0003\u0010\u0091\u0001J5\u0010\u0092\u0001\u001a\u00020[*\u00030\u0089\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u00012\u000e\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u0001H\u0082@¢\u0006\u0003\u0010\u0094\u0001J\u0015\u0010\u0095\u0001\u001a\u00020[*\u00030\u0089\u0001H\u0082@¢\u0006\u0003\u0010\u008a\u0001J\u001d\u0010\u0096\u0001\u001a\u00020[*\u00030\u0089\u00012\u0006\u0010c\u001a\u00020\tH\u0086@¢\u0006\u0003\u0010\u008d\u0001J5\u0010\u0097\u0001\u001a\u00020[*\u00030\u0089\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u00012\u000e\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u0001H\u0086@¢\u0006\u0003\u0010\u0094\u0001R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001bR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0018\u001a\u0004\b.\u0010\u0016R\u0017\u00100\u001a\u00020\u00108Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b1\u0010\u0012R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b4\u00105R+\u00106\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010*\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u00105R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010=\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00108B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bA\u0010*\u001a\u0004\b>\u0010\u0012\"\u0004\b?\u0010@R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010B\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010*\u001a\u0004\bC\u0010\u001b\"\u0004\bD\u00105R1\u0010F\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00108B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bI\u0010*\u001a\u0004\bG\u0010\u0012\"\u0004\bH\u0010@R\u001b\u0010J\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0018\u001a\u0004\bK\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010M\u001a\u0004\u0018\u00010N8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010T\u001a\u00020S2\u0006\u0010\"\u001a\u00020S8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010*\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0098\u0001"}, m165d2 = {"Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "(Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZ)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "currentContentVisibleOffset", "Landroidx/compose/ui/geometry/Offset;", "getCurrentContentVisibleOffset-F1C5BW0", "()J", "cursorHandle", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "getCursorHandle", "()Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "cursorHandle$delegate", "Landroidx/compose/runtime/State;", "cursorHandleInBounds", "getCursorHandleInBounds", "()Z", "cursorHandleInBounds$delegate", "cursorRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorRect", "()Landroidx/compose/ui/geometry/Rect;", "cursorRect$delegate", "<set-?>", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "Landroidx/compose/runtime/MutableState;", "editable", "getEditable", "endSelectionHandle", "getEndSelectionHandle", "endSelectionHandle$delegate", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setFocused", "(Z)V", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "previousRawDragOffset", "", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "(J)V", "rawHandleDragPosition$delegate", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "startContentVisibleOffset", "getStartContentVisibleOffset-F1C5BW0", "setStartContentVisibleOffset-k-4lQ0M", "startContentVisibleOffset$delegate", "startSelectionHandle", "getStartSelectionHandle", "startSelectionHandle$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "Landroidx/compose/foundation/text2/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text2/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text2/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "clearHandleDragging", "", "copy", "cancelSelection", "cut", "deselect", "dispose", "getContentRect", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ", "(Z)J", "getSelectionHandleState", "getTextFieldSelection", "Landroidx/compose/ui/text/TextRange;", "rawStartOffset", "rawEndOffset", "previousSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "hideTextToolbar", "markStartContentVisibleOffset", "observeChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTextChanges", "observeTextToolbarVisibility", "paste", "showTextToolbar", "contentRect", "update", "updateHandleDragging", "handle", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "updateSelection", "textFieldCharSequence", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "startOffset", "endOffset", "allowPreviousSelectionCollapsed", "updateSelection-QNhciaU", "(Landroidx/compose/foundation/text2/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "updateTextToolbarState", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectCursorHandleDragGestures", "detectSelectionHandleDragGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldLongPressAndAfterDrag", "requestFocus", "Lkotlin/Function0;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldTapGestures", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTouchMode", "selectionHandleGestures", "textFieldGestures", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldSelectionState {
    public static final int $stable = 8;
    private ClipboardManager clipboardManager;
    private Density density;
    private boolean enabled;
    private HapticFeedback hapticFeedBack;
    private boolean isFocused;
    private SelectionLayout previousSelectionLayout;
    private boolean readOnly;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private TextToolbar textToolbar;

    /* renamed from: isInTouchMode$delegate, reason: from kotlin metadata */
    private final MutableState isInTouchMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);

    /* renamed from: startContentVisibleOffset$delegate, reason: from kotlin metadata */
    private final MutableState startContentVisibleOffset = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3697boximpl(Offset.INSTANCE.m3723getUnspecifiedF1C5BW0()), null, 2, null);

    /* renamed from: rawHandleDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState rawHandleDragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3697boximpl(Offset.INSTANCE.m3723getUnspecifiedF1C5BW0()), null, 2, null);

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* renamed from: showCursorHandle$delegate, reason: from kotlin metadata */
    private final MutableState showCursorHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* renamed from: textToolbarState$delegate, reason: from kotlin metadata */
    private final MutableState textToolbarState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, null, 2, null);
    private int previousRawDragOffset = -1;

    /* renamed from: cursorHandle$delegate, reason: from kotlin metadata */
    private final State cursorHandle = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextFieldHandleState invoke() {
            TextFieldCharSequence text = this.this$0.textFieldState.getText();
            boolean visible = false;
            if (this.this$0.getShowCursorHandle() && TextRange.m5768getCollapsedimpl(text.getSelectionInChars())) {
                if ((text.length() > 0) && (this.this$0.getDraggingHandle() == Handle.Cursor || this.this$0.getCursorHandleInBounds())) {
                    visible = true;
                }
            }
            return !visible ? TextFieldHandleState.INSTANCE.getHidden() : new TextFieldHandleState(true, this.this$0.getCursorRect().m3735getBottomCenterF1C5BW0(), ResolvedTextDirection.Ltr, false, null);
        }
    });

    /* renamed from: cursorHandleInBounds$delegate, reason: from kotlin metadata */
    private final State cursorHandleInBounds = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandleInBounds$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Rect rectVisibleBounds;
            Snapshot.Companion this_$iv = Snapshot.INSTANCE;
            TextFieldSelectionState textFieldSelectionState = this.this$0;
            Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
            try {
                Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
                try {
                    long position = textFieldSelectionState.getCursorRect().m3735getBottomCenterF1C5BW0();
                    snapshot$iv.dispose();
                    LayoutCoordinates textLayoutCoordinates = this.this$0.getTextLayoutCoordinates();
                    return Boolean.valueOf((textLayoutCoordinates == null || (rectVisibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? false : SelectionManagerKt.m1245containsInclusiveUv8p0NA(rectVisibleBounds, position));
                } finally {
                    snapshot$iv.restoreCurrent(previous$iv$iv);
                }
            } catch (Throwable th) {
                snapshot$iv.dispose();
                throw th;
            }
        }
    });

    /* renamed from: cursorRect$delegate, reason: from kotlin metadata */
    private final State cursorRect = SnapshotStateKt.derivedStateOf(new Function0<Rect>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorRect$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Rect invoke() {
            float cursorCenterX;
            TextLayoutResult layoutResult = this.this$0.textLayoutState.getLayoutResult();
            if (layoutResult == null) {
                return Rect.INSTANCE.getZero();
            }
            TextFieldCharSequence value = this.this$0.textFieldState.getText();
            if (!TextRange.m5768getCollapsedimpl(value.getSelectionInChars())) {
                return Rect.INSTANCE.getZero();
            }
            Rect cursorRect = layoutResult.getCursorRect(TextRange.m5774getStartimpl(value.getSelectionInChars()));
            Density $this$invoke_u24lambda_u240 = this.this$0.density;
            float cursorWidth = $this$invoke_u24lambda_u240.mo518toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
            if (layoutResult.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr) {
                cursorCenterX = cursorRect.getLeft() + (cursorWidth / 2);
            } else {
                cursorCenterX = cursorRect.getRight() - (cursorWidth / 2);
            }
            float f = 2;
            float coercedCursorCenterX = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(cursorCenterX, IntSize.m6467getWidthimpl(layoutResult.getSize()) - (cursorWidth / f)), cursorWidth / f);
            return new Rect(coercedCursorCenterX - (cursorWidth / f), cursorRect.getTop(), (cursorWidth / f) + coercedCursorCenterX, cursorRect.getBottom());
        }
    });

    /* renamed from: startSelectionHandle$delegate, reason: from kotlin metadata */
    private final State startSelectionHandle = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$startSelectionHandle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextFieldHandleState invoke() {
            return this.this$0.getSelectionHandleState(true);
        }
    });

    /* renamed from: endSelectionHandle$delegate, reason: from kotlin metadata */
    private final State endSelectionHandle = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$endSelectionHandle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextFieldHandleState invoke() {
            return this.this$0.getSelectionHandleState(false);
        }
    });

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState", m180f = "TextFieldSelectionState.kt", m181i = {0, 0, 0}, m182l = {498}, m183m = "detectCursorHandleDragGestures", m184n = {"this", "cursorDragStart", "cursorDragDelta"}, m185s = {"L$0", "L$1", "L$2"})
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 */
    static final class C08841 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C08841(Continuation<? super C08841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.detectCursorHandleDragGestures(null, this);
        }
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState", m180f = "TextFieldSelectionState.kt", m181i = {0, 0, 0, 0}, m182l = {740}, m183m = "detectSelectionHandleDragGestures", m184n = {"this", "dragBeginPosition", "dragTotalDistance", "handle"}, m185s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1 */
    static final class C08891 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C08891(Continuation<? super C08891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.detectSelectionHandleDragGestures(null, false, this);
        }
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState", m180f = "TextFieldSelectionState.kt", m181i = {0}, m182l = {393}, m183m = "observeChanges", m184n = {"this"}, m185s = {"L$0"})
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1 */
    static final class C09021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09021(Continuation<? super C09021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.observeChanges(this);
        }
    }

    public TextFieldSelectionState(TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, Density density, boolean enabled, boolean readOnly, boolean isFocused) {
        this.textFieldState = textFieldState;
        this.textLayoutState = textLayoutState;
        this.density = density;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.isFocused = isFocused;
    }

    /* renamed from: isFocused, reason: from getter */
    public final boolean getIsFocused() {
        return this.isFocused;
    }

    public final void setFocused(boolean z) {
        this.isFocused = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInTouchMode(boolean z) {
        MutableState $this$setValue$iv = this.isInTouchMode;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final boolean isInTouchMode() {
        State $this$getValue$iv = this.isInTouchMode;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* renamed from: getStartContentVisibleOffset-F1C5BW0, reason: not valid java name */
    private final long m1387getStartContentVisibleOffsetF1C5BW0() {
        State $this$getValue$iv = this.startContentVisibleOffset;
        return ((Offset) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* renamed from: setStartContentVisibleOffset-k-4lQ0M, reason: not valid java name */
    private final void m1390setStartContentVisibleOffsetk4lQ0M(long j) {
        MutableState $this$setValue$iv = this.startContentVisibleOffset;
        $this$setValue$iv.setValue(Offset.m3697boximpl(j));
    }

    /* renamed from: getCurrentContentVisibleOffset-F1C5BW0, reason: not valid java name */
    private final long m1384getCurrentContentVisibleOffsetF1C5BW0() {
        Rect rectVisibleBounds;
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        return (textLayoutCoordinates == null || (rectVisibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? Offset.INSTANCE.m3723getUnspecifiedF1C5BW0() : rectVisibleBounds.m3743getTopLeftF1C5BW0();
    }

    /* renamed from: getRawHandleDragPosition-F1C5BW0, reason: not valid java name */
    private final long m1386getRawHandleDragPositionF1C5BW0() {
        State $this$getValue$iv = this.rawHandleDragPosition;
        return ((Offset) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* renamed from: setRawHandleDragPosition-k-4lQ0M, reason: not valid java name */
    private final void m1389setRawHandleDragPositionk4lQ0M(long j) {
        MutableState $this$setValue$iv = this.rawHandleDragPosition;
        $this$setValue$iv.setValue(Offset.m3697boximpl(j));
    }

    /* renamed from: getHandleDragPosition-F1C5BW0, reason: not valid java name */
    public final long m1394getHandleDragPositionF1C5BW0() {
        if (OffsetKt.m3729isUnspecifiedk4lQ0M(m1386getRawHandleDragPositionF1C5BW0())) {
            return Offset.INSTANCE.m3723getUnspecifiedF1C5BW0();
        }
        if (OffsetKt.m3729isUnspecifiedk4lQ0M(m1387getStartContentVisibleOffsetF1C5BW0())) {
            return TextLayoutStateKt.m1352fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, m1386getRawHandleDragPositionF1C5BW0());
        }
        return Offset.m3712minusMKHz9U(Offset.m3713plusMKHz9U(m1386getRawHandleDragPositionF1C5BW0(), m1384getCurrentContentVisibleOffsetF1C5BW0()), m1387getStartContentVisibleOffsetF1C5BW0());
    }

    public final Handle getDraggingHandle() {
        State $this$getValue$iv = this.draggingHandle;
        return (Handle) $this$getValue$iv.getValue();
    }

    public final void setDraggingHandle(Handle handle) {
        MutableState $this$setValue$iv = this.draggingHandle;
        $this$setValue$iv.setValue(handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShowCursorHandle() {
        State $this$getValue$iv = this.showCursorHandle;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShowCursorHandle(boolean z) {
        MutableState $this$setValue$iv = this.showCursorHandle;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextToolbarState getTextToolbarState() {
        State $this$getValue$iv = this.textToolbarState;
        return (TextToolbarState) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextToolbarState(TextToolbarState textToolbarState) {
        MutableState $this$setValue$iv = this.textToolbarState;
        $this$setValue$iv.setValue(textToolbarState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates it = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (it == null || !it.isAttached()) {
            return null;
        }
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getEditable() {
        return this.enabled && !this.readOnly;
    }

    public final TextFieldHandleState getCursorHandle() {
        State $this$getValue$iv = this.cursorHandle;
        return (TextFieldHandleState) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getCursorHandleInBounds() {
        State $this$getValue$iv = this.cursorHandleInBounds;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final Rect getCursorRect() {
        State $this$getValue$iv = this.cursorRect;
        return (Rect) $this$getValue$iv.getValue();
    }

    public final TextFieldHandleState getStartSelectionHandle() {
        State $this$getValue$iv = this.startSelectionHandle;
        return (TextFieldHandleState) $this$getValue$iv.getValue();
    }

    public final TextFieldHandleState getEndSelectionHandle() {
        State $this$getValue$iv = this.endSelectionHandle;
        return (TextFieldHandleState) $this$getValue$iv.getValue();
    }

    public final void update(HapticFeedback hapticFeedBack, ClipboardManager clipboardManager, TextToolbar textToolbar, Density density, boolean enabled, boolean readOnly) {
        if (!enabled) {
            hideTextToolbar();
        }
        this.hapticFeedBack = hapticFeedBack;
        this.clipboardManager = clipboardManager;
        this.textToolbar = textToolbar;
        this.density = density;
        this.enabled = enabled;
        this.readOnly = readOnly;
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2 */
    static final class C08832 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08832(PointerInputScope pointerInputScope, Continuation<? super C08832> continuation) {
            super(2, continuation);
            this.$this_cursorHandleGestures = pointerInputScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08832 c08832 = TextFieldSelectionState.this.new C08832(this.$this_cursorHandleGestures, continuation);
            c08832.L$0 = obj;
            return c08832;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C08832) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: TextFieldSelectionState.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {TypedValues.AttributesType.TYPE_PIVOT_TARGET}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_cursorHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$this_cursorHandleGestures, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (this.this$0.detectTouchMode(this.$this_cursorHandleGestures, this) != coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(TextFieldSelectionState.this, this.$this_cursorHandleGestures, null), 1, null);
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(TextFieldSelectionState.this, this.$this_cursorHandleGestures, null), 1, null);
                    return BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass3(this.$this_cursorHandleGestures, TextFieldSelectionState.this, null), 1, null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: TextFieldSelectionState.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {321}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_cursorHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$this_cursorHandleGestures, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (this.this$0.detectCursorHandleDragGestures(this.$this_cursorHandleGestures, this) != coroutine_suspended) {
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

        /* compiled from: TextFieldSelectionState.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {324}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3, reason: invalid class name */
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(PointerInputScope pointerInputScope, TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$this_cursorHandleGestures = pointerInputScope;
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$this_cursorHandleGestures, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        PointerInputScope pointerInputScope = this.$this_cursorHandleGestures;
                        final TextFieldSelectionState textFieldSelectionState = this.this$0;
                        this.label = 1;
                        if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.cursorHandleGestures.2.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                m1395invokek4lQ0M(offset.getPackedValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                            public final void m1395invokek4lQ0M(long it) {
                                TextToolbarState textToolbarState;
                                TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                                if (textFieldSelectionState.getTextToolbarState() == TextToolbarState.Cursor) {
                                    textToolbarState = TextToolbarState.None;
                                } else {
                                    textToolbarState = TextToolbarState.Cursor;
                                }
                                textFieldSelectionState2.setTextToolbarState(textToolbarState);
                            }
                        }, this, 7, null) != coroutine_suspended) {
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

    public final Object cursorHandleGestures(PointerInputScope $this$cursorHandleGestures, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C08832($this$cursorHandleGestures, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$textFieldGestures$2", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$textFieldGestures$2 */
    static final class C09102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ Function0<Unit> $requestFocus;
        final /* synthetic */ Function0<Unit> $showKeyboard;
        final /* synthetic */ PointerInputScope $this_textFieldGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09102(PointerInputScope pointerInputScope, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C09102> continuation) {
            super(2, continuation);
            this.$this_textFieldGestures = pointerInputScope;
            this.$requestFocus = function0;
            this.$showKeyboard = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09102 c09102 = TextFieldSelectionState.this.new C09102(this.$this_textFieldGestures, this.$requestFocus, this.$showKeyboard, continuation);
            c09102.L$0 = obj;
            return c09102;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C09102) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: TextFieldSelectionState.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$textFieldGestures$2$1", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {344}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$textFieldGestures$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_textFieldGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_textFieldGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$this_textFieldGestures, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (this.this$0.detectTouchMode(this.$this_textFieldGestures, this) != coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(TextFieldSelectionState.this, this.$this_textFieldGestures, null), 1, null);
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(TextFieldSelectionState.this, this.$this_textFieldGestures, this.$requestFocus, this.$showKeyboard, null), 1, null);
                    return BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass3(TextFieldSelectionState.this, this.$this_textFieldGestures, this.$requestFocus, null), 1, null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: TextFieldSelectionState.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$textFieldGestures$2$2", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {347}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$textFieldGestures$2$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $requestFocus;
            final /* synthetic */ Function0<Unit> $showKeyboard;
            final /* synthetic */ PointerInputScope $this_textFieldGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_textFieldGestures = pointerInputScope;
                this.$requestFocus = function0;
                this.$showKeyboard = function02;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$this_textFieldGestures, this.$requestFocus, this.$showKeyboard, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (this.this$0.detectTextFieldTapGestures(this.$this_textFieldGestures, this.$requestFocus, this.$showKeyboard, this) != coroutine_suspended) {
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

        /* compiled from: TextFieldSelectionState.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$textFieldGestures$2$3", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {350}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$textFieldGestures$2$3, reason: invalid class name */
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $requestFocus;
            final /* synthetic */ PointerInputScope $this_textFieldGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Function0<Unit> function0, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_textFieldGestures = pointerInputScope;
                this.$requestFocus = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, this.$this_textFieldGestures, this.$requestFocus, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (this.this$0.detectTextFieldLongPressAndAfterDrag(this.$this_textFieldGestures, this.$requestFocus, this) != coroutine_suspended) {
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

    public final Object textFieldGestures(PointerInputScope $this$textFieldGestures, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C09102($this$textFieldGestures, function0, function02, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2 */
    static final class C09092 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ boolean $isStartHandle;
        final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09092(PointerInputScope pointerInputScope, boolean z, Continuation<? super C09092> continuation) {
            super(2, continuation);
            this.$this_selectionHandleGestures = pointerInputScope;
            this.$isStartHandle = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09092 c09092 = TextFieldSelectionState.this.new C09092(this.$this_selectionHandleGestures, this.$isStartHandle, continuation);
            c09092.L$0 = obj;
            return c09092;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C09092) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: TextFieldSelectionState.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {361}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_selectionHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$this_selectionHandleGestures, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (this.this$0.detectTouchMode(this.$this_selectionHandleGestures, this) != coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(TextFieldSelectionState.this, this.$this_selectionHandleGestures, null), 1, null);
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this.$this_selectionHandleGestures, TextFieldSelectionState.this, this.$isStartHandle, null), 1, null);
                    return BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass3(TextFieldSelectionState.this, this.$this_selectionHandleGestures, this.$isStartHandle, null), 1, null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: TextFieldSelectionState.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {364}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isStartHandle;
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(PointerInputScope pointerInputScope, TextFieldSelectionState textFieldSelectionState, boolean z, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$this_selectionHandleGestures = pointerInputScope;
                this.this$0 = textFieldSelectionState;
                this.$isStartHandle = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$this_selectionHandleGestures, this.this$0, this.$isStartHandle, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        PointerInputScope pointerInputScope = this.$this_selectionHandleGestures;
                        final TextFieldSelectionState textFieldSelectionState = this.this$0;
                        final boolean z = this.$isStartHandle;
                        TapOnPosition tapOnPosition = new TapOnPosition() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.selectionHandleGestures.2.2.1
                            @Override // androidx.compose.foundation.text2.input.internal.selection.TapOnPosition
                            /* renamed from: onEvent-k-4lQ0M */
                            public final void mo1367onEventk4lQ0M(long it) {
                                Handle handle;
                                textFieldSelectionState.markStartContentVisibleOffset();
                                TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                                if (z) {
                                    handle = Handle.SelectionStart;
                                } else {
                                    handle = Handle.SelectionEnd;
                                }
                                textFieldSelectionState2.m1391updateHandleDraggingUv8p0NA(handle, SelectionHandlesKt.m1208getAdjustedCoordinatesk4lQ0M(textFieldSelectionState.m1385getHandlePositiontuRUvjQ(z)));
                            }
                        };
                        final TextFieldSelectionState textFieldSelectionState2 = this.this$0;
                        this.label = 1;
                        if (PressDownGestureKt.detectPressDownGesture(pointerInputScope, tapOnPosition, new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.selectionHandleGestures.2.2.2
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
                                textFieldSelectionState2.clearHandleDragging();
                            }
                        }, this) != coroutine_suspended) {
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

        /* compiled from: TextFieldSelectionState.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$3", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {382}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$3, reason: invalid class name */
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isStartHandle;
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, boolean z, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
                this.$this_selectionHandleGestures = pointerInputScope;
                this.$isStartHandle = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, this.$this_selectionHandleGestures, this.$isStartHandle, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (this.this$0.detectSelectionHandleDragGestures(this.$this_selectionHandleGestures, this.$isStartHandle, this) != coroutine_suspended) {
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

    public final Object selectionHandleGestures(PointerInputScope $this$selectionHandleGestures, boolean isStartHandle, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C09092($this$selectionHandleGestures, isStartHandle, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object observeChanges(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.C09021
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1 r0 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.C09021) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1 r0 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            switch(r2) {
                case 0: goto L37;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L2d:
            java.lang.Object r1 = r0.L$0
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r1 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState) r1
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L35
            goto L51
        L35:
            r2 = move-exception
            goto L67
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = r7
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$2 r4 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$2     // Catch: java.lang.Throwable -> L63
            r5 = 0
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L63
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.lang.Throwable -> L63
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L63
            r5 = 1
            r0.label = r5     // Catch: java.lang.Throwable -> L63
            java.lang.Object r4 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r4, r0)     // Catch: java.lang.Throwable -> L63
            if (r4 != r1) goto L50
            return r1
        L50:
            r1 = r2
        L51:
            r1.setShowCursorHandle(r3)
            androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r2 = r1.getTextToolbarState()
            androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r3 = androidx.compose.foundation.text2.input.internal.selection.TextToolbarState.None
            if (r2 == r3) goto L5f
            r1.hideTextToolbar()
        L5f:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L63:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
        L67:
            r1.setShowCursorHandle(r3)
            androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r3 = r1.getTextToolbarState()
            androidx.compose.foundation.text2.input.internal.selection.TextToolbarState r4 = androidx.compose.foundation.text2.input.internal.selection.TextToolbarState.None
            if (r3 == r4) goto L75
            r1.hideTextToolbar()
        L75:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.observeChanges(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$2", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$2 */
    static final class C09032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C09032(Continuation<? super C09032> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09032 c09032 = TextFieldSelectionState.this.new C09032(continuation);
            c09032.L$0 = obj;
            return c09032;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((C09032) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: TextFieldSelectionState.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$2$1", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {394}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (this.this$0.observeTextChanges(this) != coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new AnonymousClass1(TextFieldSelectionState.this, null), 3, null);
                    return BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new AnonymousClass2(TextFieldSelectionState.this, null), 3, null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: TextFieldSelectionState.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$2$2", m180f = "TextFieldSelectionState.kt", m181i = {}, m182l = {395}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeChanges$2$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (this.this$0.observeTextToolbarVisibility(this) != coroutine_suspended) {
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

    public final void updateTextToolbarState(TextToolbarState textToolbarState) {
        setTextToolbarState(textToolbarState);
    }

    public final void dispose() {
        hideTextToolbar();
        this.textToolbar = null;
        this.clipboardManager = null;
        this.hapticFeedBack = null;
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTouchMode$2", m180f = "TextFieldSelectionState.kt", m181i = {0}, m182l = {TypedValues.CycleType.TYPE_WAVE_PHASE}, m183m = "invokeSuspend", m184n = {"$this$awaitPointerEventScope"}, m185s = {"L$0"})
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTouchMode$2 */
    static final class C09012 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C09012(Continuation<? super C09012> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09012 c09012 = TextFieldSelectionState.this.new C09012(continuation);
            c09012.L$0 = obj;
            return c09012;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C09012) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0037 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0038 -> B:12:0x003e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 1
                switch(r1) {
                    case 0: goto L1f;
                    case 1: goto L12;
                    default: goto La;
                }
            La:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L12:
                r1 = r8
                java.lang.Object r3 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.p000ui.input.pointer.AwaitPointerEventScope) r3
                kotlin.ResultKt.throwOnFailure(r9)
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                goto L3e
            L1f:
                kotlin.ResultKt.throwOnFailure(r9)
                r1 = r8
                java.lang.Object r3 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.p000ui.input.pointer.AwaitPointerEventScope) r3
            L27:
                androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.p000ui.input.pointer.PointerEventPass.Initial
                r5 = r1
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r1.L$0 = r3
                r1.label = r2
                java.lang.Object r4 = r3.awaitPointerEvent(r4, r5)
                if (r4 != r0) goto L38
                return r0
            L38:
                r7 = r0
                r0 = r9
                r9 = r4
                r4 = r3
                r3 = r1
                r1 = r7
            L3e:
                androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.p000ui.input.pointer.PointerEvent) r9
                androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r5 = androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.this
                boolean r6 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r9)
                if (r6 != 0) goto L4a
                r9 = r2
                goto L4b
            L4a:
                r9 = 0
            L4b:
                androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.access$setInTouchMode(r5, r9)
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L27
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.C09012.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object detectTouchMode(PointerInputScope $this$detectTouchMode, Continuation<? super Unit> continuation) {
        Object objAwaitPointerEventScope = $this$detectTouchMode.awaitPointerEventScope(new C09012(null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object detectTextFieldTapGestures(PointerInputScope $this$detectTextFieldTapGestures, final Function0<Unit> function0, final Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object objDetectTapAndDoubleTap = TapAndDoubleTapGestureKt.detectTapAndDoubleTap($this$detectTextFieldTapGestures, new TapOnPosition() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectTextFieldTapGestures.2
            @Override // androidx.compose.foundation.text2.input.internal.selection.TapOnPosition
            /* renamed from: onEvent-k-4lQ0M */
            public final void mo1367onEventk4lQ0M(long offset) {
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectTextFieldTapGestures.2.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onTapTextField";
                    }
                });
                function0.invoke();
                if (this.getEditable() && this.getIsFocused()) {
                    function02.invoke();
                    if (this.textFieldState.getText().length() > 0) {
                        this.setShowCursorHandle(true);
                    }
                    this.updateTextToolbarState(TextToolbarState.None);
                    int cursorIndex = TextLayoutState.m1345getOffsetForPosition3MmeM6k$default(this.textLayoutState, offset, false, 2, null);
                    if (cursorIndex >= 0) {
                        this.textFieldState.placeCursorBeforeCharAt(cursorIndex);
                    }
                }
            }
        }, new TapOnPosition() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectTextFieldTapGestures.3
            @Override // androidx.compose.foundation.text2.input.internal.selection.TapOnPosition
            /* renamed from: onEvent-k-4lQ0M */
            public final void mo1367onEventk4lQ0M(long offset) {
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectTextFieldTapGestures.3.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onDoubleTapTextField";
                    }
                });
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
                int index = TextLayoutState.m1345getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, offset, false, 2, null);
                long newSelection = TextFieldSelectionState.m1393updateSelectionQNhciaU$default(TextFieldSelectionState.this, TextFieldCharSequenceKt.m1292TextFieldCharSequence3r_uNRQ$default(TextFieldSelectionState.this.textFieldState.getText(), TextRange.INSTANCE.m5779getZerod9O1mEE(), null, 4, null), index, index, false, SelectionAdjustment.INSTANCE.getWord(), false, 32, null);
                TextFieldSelectionState.this.textFieldState.m1361selectCharsIn5zctL8(newSelection);
            }
        }, continuation);
        return objDetectTapAndDoubleTap == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapAndDoubleTap : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object detectCursorHandleDragGestures(androidx.compose.p000ui.input.pointer.PointerInputScope r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.C08841
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.C08841) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1
            r0.<init>(r12)
        L19:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            switch(r1) {
                case 0: goto L41;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L2d:
            java.lang.Object r11 = r6.L$2
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r0 = r6.L$1
            r1 = r0
            kotlin.jvm.internal.Ref$LongRef r1 = (kotlin.jvm.internal.Ref.LongRef) r1
            java.lang.Object r0 = r6.L$0
            r2 = r0
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r2 = (androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState) r2
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L3f
            goto L91
        L3f:
            r0 = move-exception
            goto L9c
        L41:
            kotlin.ResultKt.throwOnFailure(r12)
            r7 = r10
            r1 = r11
            kotlin.jvm.internal.Ref$LongRef r11 = new kotlin.jvm.internal.Ref$LongRef
            r11.<init>()
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.p000ui.geometry.Offset.INSTANCE
            long r2 = r2.m3723getUnspecifiedF1C5BW0()
            r11.element = r2
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef
            r2.<init>()
            r8 = r2
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.p000ui.geometry.Offset.INSTANCE
            long r2 = r2.m3723getUnspecifiedF1C5BW0()
            r8.element = r2
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2 r2 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2     // Catch: java.lang.Throwable -> L98
            r2.<init>()     // Catch: java.lang.Throwable -> L98
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch: java.lang.Throwable -> L98
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3 r3 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3     // Catch: java.lang.Throwable -> L98
            r3.<init>()     // Catch: java.lang.Throwable -> L98
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3     // Catch: java.lang.Throwable -> L98
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4 r4 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4     // Catch: java.lang.Throwable -> L98
            r4.<init>()     // Catch: java.lang.Throwable -> L98
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4     // Catch: java.lang.Throwable -> L98
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5 r5 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5     // Catch: java.lang.Throwable -> L98
            r5.<init>()     // Catch: java.lang.Throwable -> L98
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch: java.lang.Throwable -> L98
            r6.L$0 = r7     // Catch: java.lang.Throwable -> L98
            r6.L$1 = r11     // Catch: java.lang.Throwable -> L98
            r6.L$2 = r8     // Catch: java.lang.Throwable -> L98
            r9 = 1
            r6.label = r9     // Catch: java.lang.Throwable -> L98
            java.lang.Object r2 = androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L98
            if (r2 != r0) goto L8e
            return r0
        L8e:
            r1 = r11
            r2 = r7
            r11 = r8
        L91:
            detectCursorHandleDragGestures$onDragStop(r1, r11, r2)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L98:
            r0 = move-exception
            r1 = r11
            r2 = r7
            r11 = r8
        L9c:
            detectCursorHandleDragGestures$onDragStop(r1, r11, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectCursorHandleDragGestures$onDragStop(Ref.LongRef cursorDragStart, Ref.LongRef cursorDragDelta, TextFieldSelectionState this$0) {
        if (OffsetKt.m3727isSpecifiedk4lQ0M(cursorDragStart.element)) {
            cursorDragStart.element = Offset.INSTANCE.m3723getUnspecifiedF1C5BW0();
            cursorDragDelta.element = Offset.INSTANCE.m3723getUnspecifiedF1C5BW0();
            this$0.clearHandleDragging();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, androidx.compose.foundation.text.Handle] */
    public final Object detectTextFieldLongPressAndAfterDrag(PointerInputScope $this$detectTextFieldLongPressAndAfterDrag, final Function0<Unit> function0, Continuation<? super Unit> continuation) {
        final Ref.IntRef dragBeginOffsetInText = new Ref.IntRef();
        dragBeginOffsetInText.element = -1;
        final Ref.LongRef dragBeginPosition = new Ref.LongRef();
        dragBeginPosition.element = Offset.INSTANCE.m3723getUnspecifiedF1C5BW0();
        final Ref.LongRef dragTotalDistance = new Ref.LongRef();
        dragTotalDistance.element = Offset.INSTANCE.m3724getZeroF1C5BW0();
        final Ref.ObjectRef actingHandle = new Ref.ObjectRef();
        actingHandle.element = Handle.SelectionEnd;
        Object objDetectDragGesturesAfterLongPress = DragGestureDetectorKt.detectDragGesturesAfterLongPress($this$detectTextFieldLongPressAndAfterDrag, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m1400invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m1400invokek4lQ0M(final long dragStartOffset) {
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onDragStart after longPress " + ((Object) Offset.m3716toStringimpl(dragStartOffset));
                    }
                });
                function0.invoke();
                this.m1391updateHandleDraggingUv8p0NA(actingHandle.element, dragStartOffset);
                dragBeginPosition.element = dragStartOffset;
                dragTotalDistance.element = Offset.INSTANCE.m3724getZeroF1C5BW0();
                this.previousRawDragOffset = -1;
                if (!this.textLayoutState.m1348isPositionOnTextk4lQ0M(dragStartOffset)) {
                    int offset = TextLayoutState.m1345getOffsetForPosition3MmeM6k$default(this.textLayoutState, dragStartOffset, false, 2, null);
                    HapticFeedback hapticFeedback = this.hapticFeedBack;
                    if (hapticFeedback != null) {
                        hapticFeedback.mo4620performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4629getTextHandleMove5zf0vsI());
                    }
                    this.textFieldState.placeCursorBeforeCharAt(offset);
                    this.setShowCursorHandle(true);
                    this.updateTextToolbarState(TextToolbarState.Cursor);
                    return;
                }
                if (this.textFieldState.getText().length() == 0) {
                    return;
                }
                int offset2 = TextLayoutState.m1345getOffsetForPosition3MmeM6k$default(this.textLayoutState, dragStartOffset, false, 2, null);
                long newSelection = TextFieldSelectionState.m1393updateSelectionQNhciaU$default(this, TextFieldCharSequenceKt.m1292TextFieldCharSequence3r_uNRQ$default(this.textFieldState.getText(), TextRange.INSTANCE.m5779getZerod9O1mEE(), null, 4, null), offset2, offset2, false, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), false, 32, null);
                this.textFieldState.m1361selectCharsIn5zctL8(newSelection);
                this.updateTextToolbarState(TextToolbarState.Selection);
                dragBeginOffsetInText.element = TextRange.m5774getStartimpl(newSelection);
            }
        }, new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag$onDragStop$1(dragBeginPosition, this, dragBeginOffsetInText, dragTotalDistance);
            }
        }, new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag$onDragStop$1(dragBeginPosition, this, dragBeginOffsetInText, dragTotalDistance);
            }
        }, new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                m1401invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
            public final void m1401invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                int i;
                int i2;
                SelectionAdjustment word;
                T t;
                SelectionAdjustment word2;
                if (TextFieldSelectionState.this.textFieldState.getText().length() == 0) {
                    return;
                }
                dragTotalDistance.element = Offset.m3713plusMKHz9U(dragTotalDistance.element, j);
                final long jM3713plusMKHz9U = Offset.m3713plusMKHz9U(dragBeginPosition.element, dragTotalDistance.element);
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag.5.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onDrag after longPress " + ((Object) Offset.m3716toStringimpl(jM3713plusMKHz9U));
                    }
                });
                if (dragBeginOffsetInText.element < 0 && !TextFieldSelectionState.this.textLayoutState.m1348isPositionOnTextk4lQ0M(jM3713plusMKHz9U)) {
                    int iM1345getOffsetForPosition3MmeM6k$default = TextLayoutState.m1345getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, dragBeginPosition.element, false, 2, null);
                    int iM1345getOffsetForPosition3MmeM6k$default2 = TextLayoutState.m1345getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, jM3713plusMKHz9U, false, 2, null);
                    if (iM1345getOffsetForPosition3MmeM6k$default == iM1345getOffsetForPosition3MmeM6k$default2) {
                        word2 = SelectionAdjustment.INSTANCE.getNone();
                    } else {
                        word2 = SelectionAdjustment.INSTANCE.getWord();
                    }
                    i = iM1345getOffsetForPosition3MmeM6k$default;
                    i2 = iM1345getOffsetForPosition3MmeM6k$default2;
                    word = word2;
                } else {
                    Integer numValueOf = Integer.valueOf(dragBeginOffsetInText.element);
                    if (!(numValueOf.intValue() >= 0)) {
                        numValueOf = null;
                    }
                    int iIntValue = numValueOf != null ? numValueOf.intValue() : TextFieldSelectionState.this.textLayoutState.m1347getOffsetForPosition3MmeM6k(dragBeginPosition.element, false);
                    int iM1347getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.textLayoutState.m1347getOffsetForPosition3MmeM6k(jM3713plusMKHz9U, false);
                    if (dragBeginOffsetInText.element < 0 && iIntValue == iM1347getOffsetForPosition3MmeM6k) {
                        return;
                    }
                    i = iIntValue;
                    i2 = iM1347getOffsetForPosition3MmeM6k;
                    word = SelectionAdjustment.INSTANCE.getWord();
                }
                long selectionInChars = TextFieldSelectionState.this.textFieldState.getText().getSelectionInChars();
                long jM1392updateSelectionQNhciaU = TextFieldSelectionState.this.m1392updateSelectionQNhciaU(TextFieldSelectionState.this.textFieldState.getText(), i, i2, false, word, false);
                if (TextRange.m5773getReversedimpl(jM1392updateSelectionQNhciaU)) {
                    jM1392updateSelectionQNhciaU = TextFieldSelectionStateKt.m1403reverse5zctL8(jM1392updateSelectionQNhciaU);
                }
                if (dragBeginOffsetInText.element == -1 && !TextRange.m5768getCollapsedimpl(jM1392updateSelectionQNhciaU)) {
                    dragBeginOffsetInText.element = TextRange.m5774getStartimpl(jM1392updateSelectionQNhciaU);
                }
                if (!TextRange.m5767equalsimpl0(jM1392updateSelectionQNhciaU, selectionInChars)) {
                    Ref.ObjectRef<Handle> objectRef = actingHandle;
                    if (TextRange.m5774getStartimpl(jM1392updateSelectionQNhciaU) != TextRange.m5774getStartimpl(selectionInChars) && TextRange.m5769getEndimpl(jM1392updateSelectionQNhciaU) == TextRange.m5769getEndimpl(selectionInChars)) {
                        t = Handle.SelectionStart;
                    } else if ((TextRange.m5774getStartimpl(jM1392updateSelectionQNhciaU) == TextRange.m5774getStartimpl(selectionInChars) && TextRange.m5769getEndimpl(jM1392updateSelectionQNhciaU) != TextRange.m5769getEndimpl(selectionInChars)) || (TextRange.m5774getStartimpl(jM1392updateSelectionQNhciaU) + TextRange.m5769getEndimpl(jM1392updateSelectionQNhciaU)) / 2.0f > (TextRange.m5774getStartimpl(selectionInChars) + TextRange.m5769getEndimpl(selectionInChars)) / 2.0f) {
                        t = Handle.SelectionEnd;
                    } else {
                        t = Handle.SelectionStart;
                    }
                    objectRef.element = t;
                }
                if (TextRange.m5768getCollapsedimpl(selectionInChars) || !TextRange.m5768getCollapsedimpl(jM1392updateSelectionQNhciaU)) {
                    TextFieldSelectionState.this.textFieldState.m1361selectCharsIn5zctL8(jM1392updateSelectionQNhciaU);
                }
                TextFieldSelectionState.this.m1391updateHandleDraggingUv8p0NA(actingHandle.element, jM3713plusMKHz9U);
            }
        }, continuation);
        return objDetectDragGesturesAfterLongPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDragGesturesAfterLongPress : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectTextFieldLongPressAndAfterDrag$onDragStop$1(Ref.LongRef dragBeginPosition, TextFieldSelectionState this$0, Ref.IntRef dragBeginOffsetInText, Ref.LongRef dragTotalDistance) {
        if (OffsetKt.m3727isSpecifiedk4lQ0M(dragBeginPosition.element)) {
            this$0.clearHandleDragging();
            dragBeginOffsetInText.element = -1;
            dragBeginPosition.element = Offset.INSTANCE.m3723getUnspecifiedF1C5BW0();
            dragTotalDistance.element = Offset.INSTANCE.m3724getZeroF1C5BW0();
            this$0.previousRawDragOffset = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object detectSelectionHandleDragGestures(androidx.compose.p000ui.input.pointer.PointerInputScope r18, boolean r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectSelectionHandleDragGestures$onDragStop$2(Ref.LongRef dragBeginPosition, TextFieldSelectionState this$0, Ref.LongRef dragTotalDistance) {
        if (OffsetKt.m3727isSpecifiedk4lQ0M(dragBeginPosition.element)) {
            this$0.clearHandleDragging();
            dragBeginPosition.element = Offset.INSTANCE.m3723getUnspecifiedF1C5BW0();
            dragTotalDistance.element = Offset.INSTANCE.m3724getZeroF1C5BW0();
            this$0.previousRawDragOffset = -1;
        }
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeTextChanges$3 */
    /* synthetic */ class C09053 extends FunctionReferenceImpl implements Function2<TextFieldCharSequence, CharSequence, Boolean> {
        public static final C09053 INSTANCE = new C09053();

        C09053() {
            super(2, TextFieldCharSequence.class, "contentEquals", "contentEquals(Ljava/lang/CharSequence;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Boolean invoke(TextFieldCharSequence p0, CharSequence p1) {
            return Boolean.valueOf(p0.contentEquals(p1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextChanges(Continuation<? super Unit> continuation) {
        Object objCollect = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0<TextFieldCharSequence>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.observeTextChanges.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextFieldCharSequence invoke() {
                return TextFieldSelectionState.this.textFieldState.getText();
            }
        }), C09053.INSTANCE), 1).collect(new FlowCollector() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.observeTextChanges.4
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit((TextFieldCharSequence) value, (Continuation<? super Unit>) $completion);
            }

            public final Object emit(TextFieldCharSequence it, Continuation<? super Unit> continuation2) {
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
                return Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextToolbarVisibility(Continuation<? super Unit> continuation) {
        Object objCollect = SnapshotStateKt.snapshotFlow(new Function0<Rect>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.observeTextToolbarVisibility.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Rect invoke() {
                Rect visibleBounds;
                boolean isCollapsed = TextRange.m5768getCollapsedimpl(TextFieldSelectionState.this.textFieldState.getText().getSelectionInChars());
                boolean textToolbarStateVisible = (isCollapsed && TextFieldSelectionState.this.getTextToolbarState() == TextToolbarState.Cursor) || (!isCollapsed && TextFieldSelectionState.this.getTextToolbarState() == TextToolbarState.Selection);
                boolean textToolbarVisible = textToolbarStateVisible && TextFieldSelectionState.this.getDraggingHandle() == null && TextFieldSelectionState.this.isInTouchMode();
                if (textToolbarVisible) {
                    LayoutCoordinates textLayoutCoordinates = TextFieldSelectionState.this.getTextLayoutCoordinates();
                    Rect visibleBounds2 = textLayoutCoordinates != null ? SelectionManagerKt.visibleBounds(textLayoutCoordinates) : null;
                    if (visibleBounds2 != null) {
                        LayoutCoordinates textLayoutCoordinates2 = TextFieldSelectionState.this.getTextLayoutCoordinates();
                        Offset visibleBoundsTopLeftInRoot = textLayoutCoordinates2 != null ? Offset.m3697boximpl(textLayoutCoordinates2.mo5228localToRootMKHz9U(visibleBounds2.m3743getTopLeftF1C5BW0())) : null;
                        Intrinsics.checkNotNull(visibleBoundsTopLeftInRoot);
                        Rect visibleBoundsInRoot = RectKt.m3748Recttz77jQw(visibleBoundsTopLeftInRoot.getPackedValue(), visibleBounds2.m3741getSizeNHjbRc());
                        Rect it = TextFieldSelectionState.this.getContentRect();
                        Rect rect = visibleBoundsInRoot.overlaps(it) ? it : null;
                        if (rect == null || (visibleBounds = rect.intersect(visibleBoundsInRoot)) == null) {
                            return Rect.INSTANCE.getZero();
                        }
                        return visibleBounds;
                    }
                    return Rect.INSTANCE.getZero();
                }
                return Rect.INSTANCE.getZero();
            }
        }).collect(new FlowCollector() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.observeTextToolbarVisibility.3
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit((Rect) value, (Continuation<? super Unit>) $completion);
            }

            public final Object emit(Rect rect, Continuation<? super Unit> continuation2) {
                if (Intrinsics.areEqual(rect, Rect.INSTANCE.getZero())) {
                    TextFieldSelectionState.this.hideTextToolbar();
                } else {
                    TextFieldSelectionState.this.showTextToolbar(rect);
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getContentRect() {
        float startTop;
        Rect cursorRect;
        Rect cursorRect2;
        TextFieldCharSequence text = this.textFieldState.getText();
        if (TextRange.m5768getCollapsedimpl(text.getSelectionInChars())) {
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            long topLeft = textLayoutCoordinates != null ? textLayoutCoordinates.mo5228localToRootMKHz9U(getCursorRect().m3743getTopLeftF1C5BW0()) : Offset.INSTANCE.m3724getZeroF1C5BW0();
            return RectKt.m3748Recttz77jQw(topLeft, getCursorRect().m3741getSizeNHjbRc());
        }
        LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
        long startOffset = textLayoutCoordinates2 != null ? textLayoutCoordinates2.mo5228localToRootMKHz9U(m1385getHandlePositiontuRUvjQ(true)) : Offset.INSTANCE.m3724getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates3 = getTextLayoutCoordinates();
        long endOffset = textLayoutCoordinates3 != null ? textLayoutCoordinates3.mo5228localToRootMKHz9U(m1385getHandlePositiontuRUvjQ(false)) : Offset.INSTANCE.m3724getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates4 = getTextLayoutCoordinates();
        float endTop = 0.0f;
        if (textLayoutCoordinates4 != null) {
            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
            startTop = Offset.m3709getYimpl(textLayoutCoordinates4.mo5228localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (cursorRect2 = layoutResult.getCursorRect(TextRange.m5774getStartimpl(text.getSelectionInChars()))) == null) ? 0.0f : cursorRect2.getTop())));
        } else {
            startTop = 0.0f;
        }
        LayoutCoordinates textLayoutCoordinates5 = getTextLayoutCoordinates();
        if (textLayoutCoordinates5 != null) {
            TextLayoutResult layoutResult2 = this.textLayoutState.getLayoutResult();
            endTop = Offset.m3709getYimpl(textLayoutCoordinates5.mo5228localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (cursorRect = layoutResult2.getCursorRect(TextRange.m5769getEndimpl(text.getSelectionInChars()))) == null) ? 0.0f : cursorRect.getTop())));
        }
        return new Rect(Math.min(Offset.m3708getXimpl(startOffset), Offset.m3708getXimpl(endOffset)), Math.min(startTop, endTop), Math.max(Offset.m3708getXimpl(startOffset), Offset.m3708getXimpl(endOffset)), Math.max(Offset.m3709getYimpl(startOffset), Offset.m3709getYimpl(endOffset)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState getSelectionHandleState(boolean r17) {
        /*
            r16 = this;
            r0 = r16
            if (r17 == 0) goto L7
            androidx.compose.foundation.text.Handle r1 = androidx.compose.foundation.text.Handle.SelectionStart
            goto L9
        L7:
            androidx.compose.foundation.text.Handle r1 = androidx.compose.foundation.text.Handle.SelectionEnd
        L9:
            androidx.compose.foundation.text2.input.internal.TextLayoutState r2 = r0.textLayoutState
            androidx.compose.ui.text.TextLayoutResult r2 = r2.getLayoutResult()
            if (r2 != 0) goto L18
            androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState$Companion r2 = androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState.INSTANCE
            androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState r2 = r2.getHidden()
            return r2
        L18:
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r3 = r0.textFieldState
            androidx.compose.foundation.text2.input.TextFieldCharSequence r3 = r3.getText()
            long r3 = r3.getSelectionInChars()
            boolean r5 = androidx.compose.p000ui.text.TextRange.m5768getCollapsedimpl(r3)
            if (r5 == 0) goto L2f
            androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState$Companion r5 = androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState.INSTANCE
            androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState r5 = r5.getHidden()
            return r5
        L2f:
            long r5 = r16.m1385getHandlePositiontuRUvjQ(r17)
            androidx.compose.foundation.text.Handle r7 = r0.getDraggingHandle()
            r8 = 1
            r9 = 0
            if (r7 == r1) goto L54
            androidx.compose.ui.layout.LayoutCoordinates r7 = r0.getTextLayoutCoordinates()
            if (r7 == 0) goto L4e
        L42:
            androidx.compose.ui.geometry.Rect r7 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r7)
            if (r7 == 0) goto L4e
        L49:
            boolean r7 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1245containsInclusiveUv8p0NA(r7, r5)
            goto L4f
        L4e:
            r7 = r9
        L4f:
            if (r7 == 0) goto L52
            goto L54
        L52:
            r7 = r9
            goto L55
        L54:
            r7 = r8
        L55:
            if (r7 != 0) goto L5f
            androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState$Companion r8 = androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState.INSTANCE
            androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState r8 = r8.getHidden()
            return r8
        L5f:
            if (r17 == 0) goto L66
            int r8 = androidx.compose.p000ui.text.TextRange.m5774getStartimpl(r3)
            goto L6f
        L66:
            int r10 = androidx.compose.p000ui.text.TextRange.m5769getEndimpl(r3)
            int r10 = r10 - r8
            int r8 = java.lang.Math.max(r10, r9)
        L6f:
            androidx.compose.ui.text.style.ResolvedTextDirection r13 = r2.getBidiRunDirection(r8)
            boolean r14 = androidx.compose.p000ui.text.TextRange.m5773getReversedimpl(r3)
            androidx.compose.ui.layout.LayoutCoordinates r9 = r0.getTextLayoutCoordinates()
            if (r9 == 0) goto L8a
            androidx.compose.ui.geometry.Rect r9 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r9)
            if (r9 == 0) goto L8a
            r10 = 0
            long r9 = androidx.compose.foundation.text2.input.internal.TextLayoutStateKt.m1351coerceIn3MmeM6k(r5, r9)
            r11 = r9
            goto L8b
        L8a:
            r11 = r5
        L8b:
            androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState r9 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState
            r10 = 1
            r15 = 0
            r9.<init>(r10, r11, r13, r14, r15)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.getSelectionHandleState(boolean):androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getHandlePosition-tuRUvjQ, reason: not valid java name */
    public final long m1385getHandlePositiontuRUvjQ(boolean isStartHandle) {
        int offset;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.INSTANCE.m3724getZeroF1C5BW0();
        }
        long selection = this.textFieldState.getText().getSelectionInChars();
        if (isStartHandle) {
            offset = TextRange.m5774getStartimpl(selection);
        } else {
            offset = TextRange.m5769getEndimpl(selection);
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, offset, isStartHandle, TextRange.m5773getReversedimpl(selection));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateHandleDragging-Uv8p0NA, reason: not valid java name */
    public final void m1391updateHandleDraggingUv8p0NA(Handle handle, long position) {
        setDraggingHandle(handle);
        m1389setRawHandleDragPositionk4lQ0M(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markStartContentVisibleOffset() {
        Rect rectVisibleBounds;
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        m1390setStartContentVisibleOffsetk4lQ0M((textLayoutCoordinates == null || (rectVisibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? Offset.INSTANCE.m3723getUnspecifiedF1C5BW0() : rectVisibleBounds.m3743getTopLeftF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearHandleDragging() {
        setDraggingHandle(null);
        m1389setRawHandleDragPositionk4lQ0M(Offset.INSTANCE.m3723getUnspecifiedF1C5BW0());
        m1390setStartContentVisibleOffsetk4lQ0M(Offset.INSTANCE.m3723getUnspecifiedF1C5BW0());
    }

    public final void cut() {
        TextFieldCharSequence text = this.textFieldState.getText();
        if (TextRange.m5768getCollapsedimpl(text.getSelectionInChars())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(text).toString(), null, null, 6, null));
        }
        this.textFieldState.deleteSelectedText();
    }

    public static /* synthetic */ void copy$default(TextFieldSelectionState textFieldSelectionState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionState.copy(z);
    }

    public final void copy(boolean cancelSelection) {
        TextFieldCharSequence text = this.textFieldState.getText();
        if (TextRange.m5768getCollapsedimpl(text.getSelectionInChars())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(text).toString(), null, null, 6, null));
        }
        if (cancelSelection) {
            this.textFieldState.collapseSelectionToMax();
        }
    }

    public final void paste() {
        AnnotatedString text;
        String clipboardText;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null || (clipboardText = text.getText()) == null) {
            return;
        }
        TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, clipboardText, false, TextFieldEditUndoBehavior.NeverMerge, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showTextToolbar(androidx.compose.p000ui.geometry.Rect r11) {
        /*
            r10 = this;
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r0 = r10.textFieldState
            androidx.compose.foundation.text2.input.TextFieldCharSequence r0 = r0.getText()
            long r0 = r0.getSelectionInChars()
            boolean r2 = r10.getEditable()
            r3 = 0
            if (r2 == 0) goto L28
            androidx.compose.ui.platform.ClipboardManager r2 = r10.clipboardManager
            r4 = 0
            if (r2 == 0) goto L1e
            boolean r2 = r2.hasText()
            r5 = 1
            if (r2 != r5) goto L1e
            r4 = r5
        L1e:
            if (r4 == 0) goto L28
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$paste$1 r2 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$paste$1
            r2.<init>()
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            goto L29
        L28:
            r2 = r3
        L29:
            r7 = r2
            boolean r2 = androidx.compose.p000ui.text.TextRange.m5768getCollapsedimpl(r0)
            if (r2 != 0) goto L39
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$copy$1 r2 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$copy$1
            r2.<init>()
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r6 = r2
            goto L3a
        L39:
            r6 = r3
        L3a:
            boolean r2 = androidx.compose.p000ui.text.TextRange.m5768getCollapsedimpl(r0)
            if (r2 != 0) goto L50
            boolean r2 = r10.getEditable()
            if (r2 == 0) goto L50
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$cut$1 r2 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$cut$1
            r2.<init>()
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r8 = r2
            goto L51
        L50:
            r8 = r3
        L51:
            int r2 = androidx.compose.p000ui.text.TextRange.m5770getLengthimpl(r0)
            androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r4 = r10.textFieldState
            androidx.compose.foundation.text2.input.TextFieldCharSequence r4 = r4.getText()
            int r4 = r4.length()
            if (r2 == r4) goto L6c
            androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$selectAll$1 r2 = new androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$selectAll$1
            r2.<init>()
            r3 = r2
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r9 = r3
            goto L6d
        L6c:
            r9 = r3
        L6d:
            androidx.compose.ui.platform.TextToolbar r4 = r10.textToolbar
            if (r4 == 0) goto L7c
        L77:
            r5 = r11
            r4.showMenu(r5, r6, r7, r8, r9)
            goto L7d
        L7c:
            r5 = r11
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState.showTextToolbar(androidx.compose.ui.geometry.Rect):void");
    }

    public final void deselect() {
        if (!TextRange.m5768getCollapsedimpl(this.textFieldState.getText().getSelectionInChars())) {
            this.textFieldState.collapseSelectionToEnd();
        }
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTextToolbar() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    /* renamed from: updateSelection-QNhciaU$default, reason: not valid java name */
    static /* synthetic */ long m1393updateSelectionQNhciaU$default(TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, int i3, Object obj) {
        boolean z3;
        if ((i3 & 32) == 0) {
            z3 = z2;
        } else {
            z3 = false;
        }
        return textFieldSelectionState.m1392updateSelectionQNhciaU(textFieldCharSequence, i, i2, z, selectionAdjustment, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-QNhciaU, reason: not valid java name */
    public final long m1392updateSelectionQNhciaU(TextFieldCharSequence textFieldCharSequence, int startOffset, int endOffset, boolean isStartHandle, SelectionAdjustment adjustment, boolean allowPreviousSelectionCollapsed) {
        HapticFeedback hapticFeedback;
        TextRange textRangeM5762boximpl = TextRange.m5762boximpl(textFieldCharSequence.getSelectionInChars());
        long it = textRangeM5762boximpl.getPackedValue();
        boolean onlyChangeIsReversed = false;
        if (!(allowPreviousSelectionCollapsed || !TextRange.m5768getCollapsedimpl(it))) {
            textRangeM5762boximpl = null;
        }
        long newSelection = m1388getTextFieldSelectionqeG_v_k(startOffset, endOffset, textRangeM5762boximpl, isStartHandle, adjustment);
        if (TextRange.m5767equalsimpl0(newSelection, textFieldCharSequence.getSelectionInChars())) {
            return newSelection;
        }
        if (TextRange.m5773getReversedimpl(newSelection) != TextRange.m5773getReversedimpl(textFieldCharSequence.getSelectionInChars())) {
            long $this$updateSelection_QNhciaU_u24lambda_u245 = TextRangeKt.TextRange(TextRange.m5769getEndimpl(newSelection), TextRange.m5774getStartimpl(newSelection));
            if (TextRange.m5767equalsimpl0($this$updateSelection_QNhciaU_u24lambda_u245, textFieldCharSequence.getSelectionInChars())) {
                onlyChangeIsReversed = true;
            }
        }
        if (isInTouchMode() && !onlyChangeIsReversed && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo4620performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4629getTextHandleMove5zf0vsI());
        }
        return newSelection;
    }

    /* renamed from: getTextFieldSelection-qeG_v_k, reason: not valid java name */
    private final long m1388getTextFieldSelectionqeG_v_k(int rawStartOffset, int rawEndOffset, TextRange previousSelection, boolean isStartHandle, SelectionAdjustment adjustment) {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextRange.INSTANCE.m5779getZerod9O1mEE();
        }
        if (previousSelection == null && Intrinsics.areEqual(adjustment, SelectionAdjustment.INSTANCE.getCharacter())) {
            return TextRangeKt.TextRange(rawStartOffset, rawEndOffset);
        }
        SelectionLayout selectionLayout = SelectionLayoutKt.m1211getTextFieldSelectionLayoutRcvTLA(layoutResult, rawStartOffset, rawEndOffset, this.previousRawDragOffset, previousSelection != null ? previousSelection.getPackedValue() : TextRange.INSTANCE.m5779getZerod9O1mEE(), previousSelection == null, isStartHandle);
        if (previousSelection != null && !selectionLayout.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return previousSelection.getPackedValue();
        }
        long result = adjustment.adjust(selectionLayout).m1199toTextRanged9O1mEE();
        this.previousSelectionLayout = selectionLayout;
        this.previousRawDragOffset = isStartHandle ? rawStartOffset : rawEndOffset;
        return result;
    }
}
