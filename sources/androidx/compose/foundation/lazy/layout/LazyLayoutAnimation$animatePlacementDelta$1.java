package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyLayoutAnimation.kt */
@Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m179c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animatePlacementDelta$1", m180f = "LazyLayoutAnimation.kt", m181i = {0}, m182l = {127, 133}, m183m = "invokeSuspend", m184n = {"finalSpec"}, m185s = {"L$0"})
/* loaded from: classes.dex */
final class LazyLayoutAnimation$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<IntOffset> $spec;
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutAnimation$animatePlacementDelta$1(LazyLayoutAnimation lazyLayoutAnimation, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, long j, Continuation<? super LazyLayoutAnimation$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutAnimation;
        this.$spec = finiteAnimationSpec;
        this.$totalDelta = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutAnimation$animatePlacementDelta$1(this.this$0, this.$spec, this.$totalDelta, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutAnimation$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d3 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r20
            int r2 = r1.label
            switch(r2) {
                case 0: goto L2b;
                case 1: goto L1f;
                case 2: goto L13;
                default: goto Lb;
            }
        Lb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L13:
            r2 = r20
            r3 = r21
            kotlin.ResultKt.throwOnFailure(r3)     // Catch: java.util.concurrent.CancellationException -> L1c
            goto Ld4
        L1c:
            r0 = move-exception
            goto Lda
        L1f:
            r2 = r20
            r3 = r21
            java.lang.Object r4 = r2.L$0
            androidx.compose.animation.core.FiniteAnimationSpec r4 = (androidx.compose.animation.core.FiniteAnimationSpec) r4
            kotlin.ResultKt.throwOnFailure(r3)     // Catch: java.util.concurrent.CancellationException -> L1c
            goto L7b
        L2b:
            kotlin.ResultKt.throwOnFailure(r21)
            r2 = r20
            r3 = r21
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation r4 = r2.this$0     // Catch: java.util.concurrent.CancellationException -> L1c
            androidx.compose.animation.core.Animatable r4 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.access$getPlacementDeltaAnimation$p(r4)     // Catch: java.util.concurrent.CancellationException -> L1c
            boolean r4 = r4.isRunning()     // Catch: java.util.concurrent.CancellationException -> L1c
            if (r4 == 0) goto L51
            androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.unit.IntOffset> r4 = r2.$spec     // Catch: java.util.concurrent.CancellationException -> L1c
            boolean r4 = r4 instanceof androidx.compose.animation.core.SpringSpec     // Catch: java.util.concurrent.CancellationException -> L1c
            if (r4 == 0) goto L4a
            androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.unit.IntOffset> r4 = r2.$spec     // Catch: java.util.concurrent.CancellationException -> L1c
            androidx.compose.animation.core.SpringSpec r4 = (androidx.compose.animation.core.SpringSpec) r4     // Catch: java.util.concurrent.CancellationException -> L1c
            goto L4e
        L4a:
            androidx.compose.animation.core.SpringSpec r4 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimationKt.access$getInterruptionSpec$p()     // Catch: java.util.concurrent.CancellationException -> L1c
        L4e:
            androidx.compose.animation.core.FiniteAnimationSpec r4 = (androidx.compose.animation.core.FiniteAnimationSpec) r4     // Catch: java.util.concurrent.CancellationException -> L1c
            goto L53
        L51:
            androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.unit.IntOffset> r4 = r2.$spec     // Catch: java.util.concurrent.CancellationException -> L1c
        L53:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation r5 = r2.this$0     // Catch: java.util.concurrent.CancellationException -> L1c
            androidx.compose.animation.core.Animatable r5 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.access$getPlacementDeltaAnimation$p(r5)     // Catch: java.util.concurrent.CancellationException -> L1c
            boolean r5 = r5.isRunning()     // Catch: java.util.concurrent.CancellationException -> L1c
            if (r5 != 0) goto L7c
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation r5 = r2.this$0     // Catch: java.util.concurrent.CancellationException -> L1c
            androidx.compose.animation.core.Animatable r5 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.access$getPlacementDeltaAnimation$p(r5)     // Catch: java.util.concurrent.CancellationException -> L1c
            long r6 = r2.$totalDelta     // Catch: java.util.concurrent.CancellationException -> L1c
            androidx.compose.ui.unit.IntOffset r6 = androidx.compose.p000ui.unit.IntOffset.m6416boximpl(r6)     // Catch: java.util.concurrent.CancellationException -> L1c
            r7 = r2
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.util.concurrent.CancellationException -> L1c
            r2.L$0 = r4     // Catch: java.util.concurrent.CancellationException -> L1c
            r8 = 1
            r2.label = r8     // Catch: java.util.concurrent.CancellationException -> L1c
            java.lang.Object r5 = r5.snapTo(r6, r7)     // Catch: java.util.concurrent.CancellationException -> L1c
            if (r5 != r0) goto L7b
            return r0
        L7b:
        L7c:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation r5 = r2.this$0     // Catch: java.util.concurrent.CancellationException -> L1c
            androidx.compose.animation.core.Animatable r5 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.access$getPlacementDeltaAnimation$p(r5)     // Catch: java.util.concurrent.CancellationException -> L1c
            java.lang.Object r5 = r5.getValue()     // Catch: java.util.concurrent.CancellationException -> L1c
            androidx.compose.ui.unit.IntOffset r5 = (androidx.compose.p000ui.unit.IntOffset) r5     // Catch: java.util.concurrent.CancellationException -> L1c
            long r5 = r5.getPackedValue()     // Catch: java.util.concurrent.CancellationException -> L1c
            long r7 = r2.$totalDelta     // Catch: java.util.concurrent.CancellationException -> L1c
            r9 = 0
            int r10 = androidx.compose.p000ui.unit.IntOffset.m6425getXimpl(r5)     // Catch: java.util.concurrent.CancellationException -> L1c
            int r11 = androidx.compose.p000ui.unit.IntOffset.m6425getXimpl(r7)     // Catch: java.util.concurrent.CancellationException -> L1c
            int r10 = r10 - r11
            int r11 = androidx.compose.p000ui.unit.IntOffset.m6426getYimpl(r5)     // Catch: java.util.concurrent.CancellationException -> L1c
            int r12 = androidx.compose.p000ui.unit.IntOffset.m6426getYimpl(r7)     // Catch: java.util.concurrent.CancellationException -> L1c
            int r11 = r11 - r12
            long r10 = androidx.compose.p000ui.unit.IntOffsetKt.IntOffset(r10, r11)     // Catch: java.util.concurrent.CancellationException -> L1c
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation r5 = r2.this$0     // Catch: java.util.concurrent.CancellationException -> L1c
            androidx.compose.animation.core.Animatable r12 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.access$getPlacementDeltaAnimation$p(r5)     // Catch: java.util.concurrent.CancellationException -> L1c
            androidx.compose.ui.unit.IntOffset r13 = androidx.compose.p000ui.unit.IntOffset.m6416boximpl(r10)     // Catch: java.util.concurrent.CancellationException -> L1c
            r14 = r4
            androidx.compose.animation.core.AnimationSpec r14 = (androidx.compose.animation.core.AnimationSpec) r14     // Catch: java.util.concurrent.CancellationException -> L1c
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animatePlacementDelta$1$1 r5 = new androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animatePlacementDelta$1$1     // Catch: java.util.concurrent.CancellationException -> L1c
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation r6 = r2.this$0     // Catch: java.util.concurrent.CancellationException -> L1c
            r5.<init>()     // Catch: java.util.concurrent.CancellationException -> L1c
            r16 = r5
            kotlin.jvm.functions.Function1 r16 = (kotlin.jvm.functions.Function1) r16     // Catch: java.util.concurrent.CancellationException -> L1c
            r17 = r2
            kotlin.coroutines.Continuation r17 = (kotlin.coroutines.Continuation) r17     // Catch: java.util.concurrent.CancellationException -> L1c
            r5 = 0
            r2.L$0 = r5     // Catch: java.util.concurrent.CancellationException -> L1c
            r5 = 2
            r2.label = r5     // Catch: java.util.concurrent.CancellationException -> L1c
            r15 = 0
            r18 = 4
            r19 = 0
            java.lang.Object r5 = androidx.compose.animation.core.Animatable.animateTo$default(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch: java.util.concurrent.CancellationException -> L1c
            if (r5 != r0) goto Ld4
            return r0
        Ld4:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation r0 = r2.this$0     // Catch: java.util.concurrent.CancellationException -> L1c
            r4 = 0
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.access$setPlacementAnimationInProgress(r0, r4)     // Catch: java.util.concurrent.CancellationException -> L1c
        Lda:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animatePlacementDelta$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
