package androidx.compose.foundation.gestures;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DragGestureDetector.kt */
@Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m179c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", m180f = "DragGestureDetector.kt", m181i = {0, 0}, m182l = {878}, m183m = "awaitHorizontalDragOrCancellation-rnUCldI", m184n = {"$this$awaitDragOrUp_u2djO51t88$iv", "pointer$iv"}, m185s = {"L$0", "L$1"})
/* loaded from: classes.dex */
final class DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1(Continuation<? super DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m541awaitHorizontalDragOrCancellationrnUCldI(null, 0L, this);
    }
}
