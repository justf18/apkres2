package androidx.compose.material;

import androidx.compose.material.ModalBottomSheetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ModalBottomSheet.kt */
@Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m179c = "androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", m180f = "ModalBottomSheet.kt", m181i = {0}, m182l = {789}, m183m = "onPreFling-QWom1Mo", m184n = {"available"}, m185s = {"J$0"})
/* renamed from: androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 */
/* loaded from: classes.dex */
final class C1033x8819a6ee extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ModalBottomSheetKt.C10311 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1033x8819a6ee(ModalBottomSheetKt.C10311 c10311, Continuation<? super C1033x8819a6ee> continuation) {
        super(continuation);
        this.this$0 = c10311;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo846onPreFlingQWom1Mo(0L, this);
    }
}
