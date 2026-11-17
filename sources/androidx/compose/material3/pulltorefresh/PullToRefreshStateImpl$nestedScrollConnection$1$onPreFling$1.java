package androidx.compose.material3.pulltorefresh;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: PullToRefresh.kt */
@Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m179c = "androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$nestedScrollConnection$1", m180f = "PullToRefresh.kt", m181i = {}, m182l = {341}, m183m = "onPreFling-QWom1Mo", m184n = {}, m185s = {})
/* loaded from: classes.dex */
final class PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1 extends ContinuationImpl {
    float F$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PullToRefreshStateImpl$nestedScrollConnection$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1(PullToRefreshStateImpl$nestedScrollConnection$1 pullToRefreshStateImpl$nestedScrollConnection$1, Continuation<? super PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1> continuation) {
        super(continuation);
        this.this$0 = pullToRefreshStateImpl$nestedScrollConnection$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo846onPreFlingQWom1Mo(0L, this);
    }
}
