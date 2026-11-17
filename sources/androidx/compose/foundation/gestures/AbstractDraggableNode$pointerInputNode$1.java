package androidx.compose.foundation.gestures;

import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: Draggable.kt */
@Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m179c = "androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1", m180f = "Draggable.kt", m181i = {}, m182l = {456}, m183m = "invokeSuspend", m184n = {}, m185s = {})
/* loaded from: classes.dex */
final class AbstractDraggableNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AbstractDraggableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractDraggableNode$pointerInputNode$1(AbstractDraggableNode abstractDraggableNode, Continuation<? super AbstractDraggableNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = abstractDraggableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AbstractDraggableNode$pointerInputNode$1 abstractDraggableNode$pointerInputNode$1 = new AbstractDraggableNode$pointerInputNode$1(this.this$0, continuation);
        abstractDraggableNode$pointerInputNode$1.L$0 = obj;
        return abstractDraggableNode$pointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((AbstractDraggableNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$SuspendingPointerInputModifierNode = (PointerInputScope) this.L$0;
                if (!this.this$0.getEnabled()) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new C03391($this$SuspendingPointerInputModifierNode, this.this$0, null), this) != coroutine_suspended) {
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

    /* compiled from: Draggable.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1$1", m180f = "Draggable.kt", m181i = {0}, m182l = {458}, m183m = "invokeSuspend", m184n = {"$this$coroutineScope"}, m185s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1$1 */
    static final class C03391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AbstractDraggableNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03391(PointerInputScope pointerInputScope, AbstractDraggableNode abstractDraggableNode, Continuation<? super C03391> continuation) {
            super(2, continuation);
            this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
            this.this$0 = abstractDraggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03391 c03391 = new C03391(this.$$this$SuspendingPointerInputModifierNode, this.this$0, continuation);
            c03391.L$0 = obj;
            return c03391;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
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
                switch(r1) {
                    case 0: goto L1c;
                    case 1: goto L11;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L11:
                r0 = r8
                java.lang.Object r1 = r0.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.util.concurrent.CancellationException -> L1a
                goto L42
            L1a:
                r2 = move-exception
                goto L48
            L1c:
                kotlin.ResultKt.throwOnFailure(r9)
                r1 = r8
                java.lang.Object r2 = r1.L$0
                kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                androidx.compose.ui.input.pointer.PointerInputScope r3 = r1.$$this$SuspendingPointerInputModifierNode     // Catch: java.util.concurrent.CancellationException -> L43
                androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1$1$1 r4 = new androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1$1$1     // Catch: java.util.concurrent.CancellationException -> L43
                androidx.compose.foundation.gestures.AbstractDraggableNode r5 = r1.this$0     // Catch: java.util.concurrent.CancellationException -> L43
                r6 = 0
                r4.<init>(r2, r5, r6)     // Catch: java.util.concurrent.CancellationException -> L43
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.util.concurrent.CancellationException -> L43
                r5 = r1
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.util.concurrent.CancellationException -> L43
                r1.L$0 = r2     // Catch: java.util.concurrent.CancellationException -> L43
                r6 = 1
                r1.label = r6     // Catch: java.util.concurrent.CancellationException -> L43
                java.lang.Object r3 = r3.awaitPointerEventScope(r4, r5)     // Catch: java.util.concurrent.CancellationException -> L43
                if (r3 != r0) goto L40
                return r0
            L40:
                r0 = r1
                r1 = r2
            L42:
                goto L4e
            L43:
                r0 = move-exception
                r7 = r2
                r2 = r0
                r0 = r1
                r1 = r7
            L48:
                boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r3 == 0) goto L51
            L4e:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L51:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1.C03391.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: Draggable.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1$1$1", m180f = "Draggable.kt", m181i = {0, 1, 1}, m182l = {460, 475}, m183m = "invokeSuspend", m184n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "isDragSuccessful"}, m185s = {"L$0", "L$0", "I$0"})
        /* renamed from: androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1$1$1, reason: invalid class name */
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            int I$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ AbstractDraggableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CoroutineScope coroutineScope, AbstractDraggableNode abstractDraggableNode, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.this$0 = abstractDraggableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Can't wrap try/catch for region: R(9:23|(1:25)|26|79|27|28|77|29|(1:31)(8:32|81|33|34|(3:36|(1:38)(1:39)|40)(1:41)|42|15|(2:72|73)(0))) */
            /* JADX WARN: Code restructure failed: missing block: B:47:0x0156, code lost:
            
                r0 = th;
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x0157, code lost:
            
                r11 = r10;
                r9 = 0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x015f, code lost:
            
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x0160, code lost:
            
                r11 = r10;
                r10 = r11;
                r1 = r6;
                r12 = r9;
                r6 = r17;
             */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x016a, code lost:
            
                r0 = th;
             */
            /* JADX WARN: Code restructure failed: missing block: B:52:0x016b, code lost:
            
                r11 = r10;
                r9 = 0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:53:0x0176, code lost:
            
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x0177, code lost:
            
                r17 = r1;
                r11 = r10;
                r10 = r11;
                r1 = r6;
                r12 = r9;
                r6 = r17;
             */
            /* JADX WARN: Code restructure failed: missing block: B:63:0x01ca, code lost:
            
                r9 = r11.velocityTracker.m5193calculateVelocityAH228Gc(androidx.compose.p000ui.unit.VelocityKt.Velocity(r1, r1));
                r11.velocityTracker.resetTracking();
             */
            /* JADX WARN: Code restructure failed: missing block: B:64:0x01e3, code lost:
            
                if (r11.getReverseDirection() != false) goto L65;
             */
            /* JADX WARN: Code restructure failed: missing block: B:65:0x01e5, code lost:
            
                r3 = -1.0f;
             */
            /* JADX WARN: Code restructure failed: missing block: B:66:0x01e8, code lost:
            
                r3 = 1.0f;
             */
            /* JADX WARN: Code restructure failed: missing block: B:67:0x01e9, code lost:
            
                r1 = new androidx.compose.foundation.gestures.DragEvent.DragStopped(androidx.compose.p000ui.unit.Velocity.m6538timesadjELrA(r9, r3), null);
             */
            /* JADX WARN: Code restructure failed: missing block: B:68:0x01f3, code lost:
            
                r1 = androidx.compose.foundation.gestures.DragEvent.DragCancelled.INSTANCE;
             */
            /* JADX WARN: Removed duplicated region for block: B:17:0x005e  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x0115  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x013e  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x018c  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x01b3 A[Catch: all -> 0x0032, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0032, blocks: (B:7:0x002c, B:56:0x0186, B:60:0x01b3), top: B:74:0x000b }] */
            /* JADX WARN: Removed duplicated region for block: B:63:0x01ca  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x01f3  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x0200  */
            /* JADX WARN: Removed duplicated region for block: B:72:0x0209  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00ee -> B:81:0x00f9). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x018c -> B:15:0x0054). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0200 -> B:15:0x0054). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r23) {
                /*
                    Method dump skipped, instructions count: 534
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1.C03391.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }
}
