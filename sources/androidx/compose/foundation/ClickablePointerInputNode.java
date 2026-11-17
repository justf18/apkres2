package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: Clickable.kt */
@Metadata(m164d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ$\u0010\f\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0012\u0010\r\u001a\u00020\b*\u00020\u000eH\u0094@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m165d2 = {"Landroidx/compose/foundation/ClickablePointerInputNode;", "Landroidx/compose/foundation/AbstractClickablePointerInputNode;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onClick", "Lkotlin/Function0;", "", "interactionData", "Landroidx/compose/foundation/AbstractClickableNode$InteractionData;", "(ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/AbstractClickableNode$InteractionData;)V", "update", "pointerInput", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class ClickablePointerInputNode extends AbstractClickablePointerInputNode {
    public ClickablePointerInputNode(boolean enabled, MutableInteractionSource interactionSource, Function0<Unit> function0, AbstractClickableNode.InteractionData interactionData) {
        super(enabled, interactionSource, function0, interactionData, null);
    }

    @Override // androidx.compose.foundation.AbstractClickablePointerInputNode
    protected Object pointerInput(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
        AbstractClickableNode.InteractionData interactionData = getInteractionData();
        long $this$toOffset_u2d_u2dgyyYBs$iv = IntSizeKt.m6473getCenterozmzZPI($this$pointerInput.getBoundsSize());
        interactionData.m388setCentreOffsetk4lQ0M(OffsetKt.Offset(IntOffset.m6425getXimpl($this$toOffset_u2d_u2dgyyYBs$iv), IntOffset.m6426getYimpl($this$toOffset_u2d_u2dgyyYBs$iv)));
        Object objDetectTapAndPress = TapGestureDetectorKt.detectTapAndPress($this$pointerInput, new C03032(null), new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.ClickablePointerInputNode.pointerInput.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m460invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m460invokek4lQ0M(long it) {
                if (ClickablePointerInputNode.this.getEnabled()) {
                    ClickablePointerInputNode.this.getOnClick().invoke();
                }
            }
        }, continuation);
        return objDetectTapAndPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapAndPress : Unit.INSTANCE;
    }

    /* compiled from: Clickable.kt */
    @Metadata(m164d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m165d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.ClickablePointerInputNode$pointerInput$2", m180f = "Clickable.kt", m181i = {}, m182l = {984}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.ClickablePointerInputNode$pointerInput$2 */
    static final class C03032 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        C03032(Continuation<? super C03032> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
            return m459invoked4ec7I(pressGestureScope, offset.getPackedValue(), continuation);
        }

        /* renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m459invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            C03032 c03032 = ClickablePointerInputNode.this.new C03032(continuation);
            c03032.L$0 = pressGestureScope;
            c03032.J$0 = j;
            return c03032.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C03032 c03032;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PressGestureScope $this$detectTapAndPress = (PressGestureScope) this.L$0;
                    long offset = this.J$0;
                    if (ClickablePointerInputNode.this.getEnabled()) {
                        this.label = 1;
                        if (ClickablePointerInputNode.this.m389handlePressInteractiond4ec7I($this$detectTapAndPress, offset, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c03032 = this;
                    }
                    return Unit.INSTANCE;
                case 1:
                    c03032 = this;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void update(boolean enabled, MutableInteractionSource interactionSource, Function0<Unit> onClick) {
        setEnabled(enabled);
        setOnClick(onClick);
        setInteractionSource(interactionSource);
    }
}
