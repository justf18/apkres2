package kotlinx.coroutines.channels;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BufferedChannel.kt */
@Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m179c = "kotlinx.coroutines.channels.BufferedChannel", m180f = "BufferedChannel.kt", m181i = {0, 0, 0, 0}, m182l = {3056}, m183m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", m184n = {"this", "segment", "index", "r"}, m185s = {"L$0", "L$1", "I$0", "J$0"})
/* loaded from: classes5.dex */
final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, Continuation<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM8109receiveCatchingOnNoWaiterSuspendGKJJFZk = this.this$0.m8109receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        return objM8109receiveCatchingOnNoWaiterSuspendGKJJFZk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM8109receiveCatchingOnNoWaiterSuspendGKJJFZk : ChannelResult.m8116boximpl(objM8109receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
