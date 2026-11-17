package androidx.compose.foundation.text2.input.internal;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: TextLayoutState.kt */
@Metadata(m164d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u000202ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0018\u00105\u001a\u0002022\u0006\u00106\u001a\u000200ø\u0001\u0000¢\u0006\u0004\b7\u00108J0\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ&\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u0002022\u0006\u0010I\u001a\u000202J\u0016\u0010J\u001a\u000200*\u000200H\u0002ø\u0001\u0000¢\u0006\u0004\bK\u0010LR/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR/\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R1\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR;\u0010\u001f\u001a#\u0012\u0004\u0012\u00020!\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\"\u0012\u0004\u0012\u00020#\u0018\u00010 ¢\u0006\u0002\b$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R/\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, m165d2 = {"Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "", "()V", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "coreNodeCoordinates", "getCoreNodeCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setCoreNodeCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "coreNodeCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "decoratorNodeCoordinates", "getDecoratorNodeCoordinates", "setDecoratorNodeCoordinates", "decoratorNodeCoordinates$delegate", "layoutCache", "Landroidx/compose/foundation/text2/input/internal/TextFieldLayoutStateCache;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult$delegate", "Landroidx/compose/foundation/text2/input/internal/TextFieldLayoutStateCache;", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField$delegate", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "", "Lkotlin/ExtensionFunctionType;", "getOnTextLayout", "()Lkotlin/jvm/functions/Function2;", "setOnTextLayout", "(Lkotlin/jvm/functions/Function2;)V", "textLayoutNodeCoordinates", "getTextLayoutNodeCoordinates", "setTextLayoutNodeCoordinates", "textLayoutNodeCoordinates$delegate", "getOffsetForPosition", "", "position", "Landroidx/compose/ui/geometry/Offset;", "coerceInVisibleBounds", "", "getOffsetForPosition-3MmeM6k", "(JZ)I", "isPositionOnText", TypedValues.CycleType.S_WAVE_OFFSET, "isPositionOnText-k-4lQ0M", "(J)Z", "layoutWithNewMeasureInputs", "density", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutWithNewMeasureInputs--hBUhpc", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Landroidx/compose/ui/text/TextLayoutResult;", "updateNonMeasureInputs", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "softWrap", "coercedInVisibleBoundsOfInputText", "coercedInVisibleBoundsOfInputText-MK-Hz9U", "(J)J", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextLayoutState {
    public static final int $stable = 8;
    private Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout;
    private TextFieldLayoutStateCache layoutCache = new TextFieldLayoutStateCache();

    /* renamed from: layoutResult$delegate, reason: from kotlin metadata */
    private final TextFieldLayoutStateCache layoutResult = this.layoutCache;

    /* renamed from: textLayoutNodeCoordinates$delegate, reason: from kotlin metadata */
    private final MutableState textLayoutNodeCoordinates = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());

    /* renamed from: coreNodeCoordinates$delegate, reason: from kotlin metadata */
    private final MutableState coreNodeCoordinates = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());

    /* renamed from: decoratorNodeCoordinates$delegate, reason: from kotlin metadata */
    private final MutableState decoratorNodeCoordinates = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());

    /* renamed from: minHeightForSingleLineField$delegate, reason: from kotlin metadata */
    private final MutableState minHeightForSingleLineField = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(C1956Dp.m6295boximpl(C1956Dp.m6297constructorimpl(0)), null, 2, null);

    public final Function2<Density, Function0<TextLayoutResult>, Unit> getOnTextLayout() {
        return this.onTextLayout;
    }

    public final void setOnTextLayout(Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2) {
        this.onTextLayout = function2;
    }

    public final TextLayoutResult getLayoutResult() {
        State $this$getValue$iv = this.layoutResult;
        return $this$getValue$iv.getValue();
    }

    public final LayoutCoordinates getTextLayoutNodeCoordinates() {
        State $this$getValue$iv = this.textLayoutNodeCoordinates;
        return (LayoutCoordinates) $this$getValue$iv.getValue();
    }

    public final void setTextLayoutNodeCoordinates(LayoutCoordinates layoutCoordinates) {
        MutableState $this$setValue$iv = this.textLayoutNodeCoordinates;
        $this$setValue$iv.setValue(layoutCoordinates);
    }

    public final LayoutCoordinates getCoreNodeCoordinates() {
        State $this$getValue$iv = this.coreNodeCoordinates;
        return (LayoutCoordinates) $this$getValue$iv.getValue();
    }

    public final void setCoreNodeCoordinates(LayoutCoordinates layoutCoordinates) {
        MutableState $this$setValue$iv = this.coreNodeCoordinates;
        $this$setValue$iv.setValue(layoutCoordinates);
    }

    public final LayoutCoordinates getDecoratorNodeCoordinates() {
        State $this$getValue$iv = this.decoratorNodeCoordinates;
        return (LayoutCoordinates) $this$getValue$iv.getValue();
    }

    public final void setDecoratorNodeCoordinates(LayoutCoordinates layoutCoordinates) {
        MutableState $this$setValue$iv = this.decoratorNodeCoordinates;
        $this$setValue$iv.setValue(layoutCoordinates);
    }

    /* renamed from: getMinHeightForSingleLineField-D9Ej5fM, reason: not valid java name */
    public final float m1346getMinHeightForSingleLineFieldD9Ej5fM() {
        State $this$getValue$iv = this.minHeightForSingleLineField;
        return ((C1956Dp) $this$getValue$iv.getValue()).m6311unboximpl();
    }

    /* renamed from: setMinHeightForSingleLineField-0680j_4, reason: not valid java name */
    public final void m1350setMinHeightForSingleLineField0680j_4(float f) {
        MutableState $this$setValue$iv = this.minHeightForSingleLineField;
        $this$setValue$iv.setValue(C1956Dp.m6295boximpl(f));
    }

    public final void updateNonMeasureInputs(TransformedTextFieldState textFieldState, TextStyle textStyle, boolean singleLine, boolean softWrap) {
        this.layoutCache.updateNonMeasureInputs(textFieldState, textStyle, singleLine, softWrap);
    }

    /* renamed from: layoutWithNewMeasureInputs--hBUhpc, reason: not valid java name */
    public final TextLayoutResult m1349layoutWithNewMeasureInputshBUhpc(Density density, LayoutDirection layoutDirection, FontFamily.Resolver fontFamilyResolver, long constraints) {
        TextLayoutResult layoutResult = this.layoutCache.m1338layoutWithNewMeasureInputshBUhpc(density, layoutDirection, fontFamilyResolver, constraints);
        Function2 onTextLayout = this.onTextLayout;
        if (onTextLayout != null) {
            Function0 textLayoutProvider = new Function0<TextLayoutResult>() { // from class: androidx.compose.foundation.text2.input.internal.TextLayoutState$layoutWithNewMeasureInputs$1$textLayoutProvider$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextLayoutResult invoke() {
                    return this.this$0.layoutCache.getValue();
                }
            };
            onTextLayout.invoke(density, textLayoutProvider);
        }
        return layoutResult;
    }

    /* renamed from: getOffsetForPosition-3MmeM6k$default, reason: not valid java name */
    public static /* synthetic */ int m1345getOffsetForPosition3MmeM6k$default(TextLayoutState textLayoutState, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return textLayoutState.m1347getOffsetForPosition3MmeM6k(j, z);
    }

    /* renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public final int m1347getOffsetForPosition3MmeM6k(long position, boolean coerceInVisibleBounds) {
        long coercedPosition;
        TextLayoutResult layoutResult = getLayoutResult();
        if (layoutResult == null) {
            return -1;
        }
        if (coerceInVisibleBounds) {
            coercedPosition = m1344coercedInVisibleBoundsOfInputTextMKHz9U(position);
        } else {
            coercedPosition = position;
        }
        long relativePosition = TextLayoutStateKt.m1352fromDecorationToTextLayoutUv8p0NA(this, coercedPosition);
        return layoutResult.m5746getOffsetForPositionk4lQ0M(relativePosition);
    }

    /* renamed from: isPositionOnText-k-4lQ0M, reason: not valid java name */
    public final boolean m1348isPositionOnTextk4lQ0M(long offset) {
        TextLayoutResult layoutResult = getLayoutResult();
        if (layoutResult == null) {
            return false;
        }
        long relativeOffset = TextLayoutStateKt.m1352fromDecorationToTextLayoutUv8p0NA(this, m1344coercedInVisibleBoundsOfInputTextMKHz9U(offset));
        int line = layoutResult.getLineForVerticalPosition(Offset.m3709getYimpl(relativeOffset));
        return Offset.m3708getXimpl(relativeOffset) >= layoutResult.getLineLeft(line) && Offset.m3708getXimpl(relativeOffset) <= layoutResult.getLineRight(line);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long m1344coercedInVisibleBoundsOfInputTextMKHz9U(long r7) {
        /*
            r6 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r6.getTextLayoutNodeCoordinates()
            if (r0 == 0) goto L24
            r1 = 0
            boolean r2 = r0.isAttached()
            if (r2 == 0) goto L1b
            androidx.compose.ui.layout.LayoutCoordinates r2 = r6.getDecoratorNodeCoordinates()
            r3 = 0
            if (r2 == 0) goto L21
            r4 = 0
            r5 = 2
            androidx.compose.ui.geometry.Rect r3 = androidx.compose.p000ui.layout.LayoutCoordinates.localBoundingBoxOf$default(r2, r0, r4, r5, r3)
            goto L21
        L1b:
            androidx.compose.ui.geometry.Rect$Companion r2 = androidx.compose.p000ui.geometry.Rect.INSTANCE
            androidx.compose.ui.geometry.Rect r3 = r2.getZero()
        L21:
            if (r3 != 0) goto L2a
        L24:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.p000ui.geometry.Rect.INSTANCE
            androidx.compose.ui.geometry.Rect r3 = r0.getZero()
        L2a:
            long r0 = androidx.compose.foundation.text2.input.internal.TextLayoutStateKt.m1351coerceIn3MmeM6k(r7, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.TextLayoutState.m1344coercedInVisibleBoundsOfInputTextMKHz9U(long):long");
    }
}
