package androidx.compose.foundation.gestures;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DragGestureDetector.kt */
@Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m179c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", m180f = "DragGestureDetector.kt", m181i = {0, 0}, m182l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m183m = "drag-jO51t88", m184n = {"$this$drag_u2djO51t88", "onDrag"}, m185s = {"L$0", "L$1"})
/* loaded from: classes.dex */
final class DragGestureDetectorKt$drag$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$drag$1(Continuation<? super DragGestureDetectorKt$drag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m553dragjO51t88(null, 0L, null, this);
    }
}
