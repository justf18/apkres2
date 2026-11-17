package androidx.compose.material3;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TimePicker.kt */
@Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m179c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1", m180f = "TimePicker.kt", m181i = {}, m182l = {1292}, m183m = "invokeSuspend", m184n = {}, m185s = {})
/* loaded from: classes.dex */
final class ClockDialNode$pointerInputDragNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ClockDialNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClockDialNode$pointerInputDragNode$1(ClockDialNode clockDialNode, Continuation<? super ClockDialNode$pointerInputDragNode$1> continuation) {
        super(2, continuation);
        this.this$0 = clockDialNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClockDialNode$pointerInputDragNode$1 clockDialNode$pointerInputDragNode$1 = new ClockDialNode$pointerInputDragNode$1(this.this$0, continuation);
        clockDialNode$pointerInputDragNode$1.L$0 = obj;
        return clockDialNode$pointerInputDragNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ClockDialNode$pointerInputDragNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$SuspendingPointerInputModifierNode = (PointerInputScope) this.L$0;
                final ClockDialNode clockDialNode = this.this$0;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1.1
                    {
                        super(0);
                    }

                    /* compiled from: TimePicker.kt */
                    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m179c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$1$1", m180f = "TimePicker.kt", m181i = {}, m182l = {1296, 1298}, m183m = "invokeSuspend", m184n = {}, m185s = {})
                    /* renamed from: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$1$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ ClockDialNode this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(ClockDialNode clockDialNode, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = clockDialNode;
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
                            AnonymousClass1 anonymousClass1;
                            AnonymousClass1 anonymousClass12;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    if (!Selection.m2387equalsimpl0(this.this$0.state.m2715getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2391getHourJiIwxys()) || !this.this$0.autoSwitchToMinute) {
                                        if (Selection.m2387equalsimpl0(this.this$0.state.m2715getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2392getMinuteJiIwxys())) {
                                            this.label = 2;
                                            if (this.this$0.state.settle(this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            anonymousClass1 = this;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    this.this$0.state.m2718setSelectioniHAOin8$material3_release(Selection.INSTANCE.m2392getMinuteJiIwxys());
                                    this.label = 1;
                                    if (this.this$0.state.animateToCurrent$material3_release(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    anonymousClass12 = this;
                                    return Unit.INSTANCE;
                                case 1:
                                    anonymousClass12 = this;
                                    ResultKt.throwOnFailure($result);
                                    return Unit.INSTANCE;
                                case 2:
                                    anonymousClass1 = this;
                                    ResultKt.throwOnFailure($result);
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        BuildersKt__Builders_commonKt.launch$default(clockDialNode.getCoroutineScope(), null, null, new AnonymousClass1(clockDialNode, null), 3, null);
                    }
                };
                final ClockDialNode clockDialNode2 = this.this$0;
                this.label = 1;
                if (DragGestureDetectorKt.detectDragGestures$default($this$SuspendingPointerInputModifierNode, null, function0, null, new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1.2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                        m1889invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                        return Unit.INSTANCE;
                    }

                    /* compiled from: TimePicker.kt */
                    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                    @DebugMetadata(m179c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$2$1", m180f = "TimePicker.kt", m181i = {}, m182l = {1305}, m183m = "invokeSuspend", m184n = {}, m185s = {})
                    /* renamed from: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$2$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ long $dragAmount;
                        int label;
                        final /* synthetic */ ClockDialNode this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(ClockDialNode clockDialNode, long j, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = clockDialNode;
                            this.$dragAmount = j;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.this$0, this.$dragAmount, continuation);
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
                                    this.this$0.offsetX += Offset.m3708getXimpl(this.$dragAmount);
                                    this.this$0.offsetY += Offset.m3709getYimpl(this.$dragAmount);
                                    this.label = 1;
                                    if (TimePickerState.update$material3_release$default(this.this$0.state, TimePickerKt.atan(this.this$0.offsetY - IntOffset.m6426getYimpl(this.this$0.state.m2714getCenternOccac$material3_release()), this.this$0.offsetX - IntOffset.m6425getXimpl(this.this$0.state.m2714getCenternOccac$material3_release())), false, this, 2, null) != coroutine_suspended) {
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

                    /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                    public final void m1889invokeUv8p0NA(PointerInputChange pointerInputChange, long dragAmount) {
                        BuildersKt__Builders_commonKt.launch$default(clockDialNode2.getCoroutineScope(), null, null, new AnonymousClass1(clockDialNode2, dragAmount, null), 3, null);
                        clockDialNode2.state.moveSelector$material3_release(clockDialNode2.offsetX, clockDialNode2.offsetY, clockDialNode2.getMaxDist());
                    }
                }, this, 5, null) != coroutine_suspended) {
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
