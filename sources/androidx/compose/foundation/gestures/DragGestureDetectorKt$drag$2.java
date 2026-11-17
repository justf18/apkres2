package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DragGestureDetector.kt */
@Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
@DebugMetadata(m179c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", m180f = "DragGestureDetector.kt", m181i = {0, 0, 0, 0, 0, 0}, m182l = {878}, m183m = "drag-VnAYq1g", m184n = {"$this$drag_u2dVnAYq1g", "onDrag", "hasDragged", "motionConsumed", "$this$awaitDragOrUp_u2djO51t88$iv", "pointer$iv"}, m185s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes.dex */
final class DragGestureDetectorKt$drag$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$drag$2(Continuation<? super DragGestureDetectorKt$drag$2> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m551dragVnAYq1g(null, 0L, null, null, null, this);
    }
}
