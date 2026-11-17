package androidx.compose.foundation.draganddrop;

import androidx.compose.p000ui.draw.CacheDrawScope;
import androidx.compose.p000ui.draw.DrawResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: AndroidDragAndDropSource.android.kt */
@Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: androidx.compose.foundation.draganddrop.DragSourceNodeWithDefaultPainter$cacheDrawScopeDragShadowCallback$1$1 */
/* loaded from: classes.dex */
/* synthetic */ class C0338xadf00624 extends FunctionReferenceImpl implements Function1<CacheDrawScope, DrawResult> {
    C0338xadf00624(Object obj) {
        super(1, obj, CacheDrawScopeDragShadowCallback.class, "cachePicture", "cachePicture(Landroidx/compose/ui/draw/CacheDrawScope;)Landroidx/compose/ui/draw/DrawResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DrawResult invoke(CacheDrawScope p0) {
        return ((CacheDrawScopeDragShadowCallback) this.receiver).cachePicture(p0);
    }
}
