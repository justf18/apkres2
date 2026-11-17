package androidx.compose.p000ui.graphics.drawscope;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.geometry.SizeKt;
import androidx.compose.p000ui.graphics.Canvas;
import androidx.compose.p000ui.graphics.Path;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: CanvasDrawScope.kt */
@Metadata(m164d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m165d2 = {"asDrawTransform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "ui-graphics_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CanvasDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext $this$asDrawTransform) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt.asDrawTransform.1
            @Override // androidx.compose.p000ui.graphics.drawscope.DrawTransform
            /* renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long mo4428getSizeNHjbRc() {
                return $this$asDrawTransform.mo4423getSizeNHjbRc();
            }

            @Override // androidx.compose.p000ui.graphics.drawscope.DrawTransform
            /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
            public long mo4427getCenterF1C5BW0() {
                return SizeKt.m3787getCenteruvyYCjk(mo4428getSizeNHjbRc());
            }

            @Override // androidx.compose.p000ui.graphics.drawscope.DrawTransform
            public void inset(float left, float top, float right, float bottom) {
                Canvas it = $this$asDrawTransform.getCanvas();
                DrawContext drawContext = $this$asDrawTransform;
                long updatedSize = SizeKt.Size(Size.m3777getWidthimpl(mo4428getSizeNHjbRc()) - (left + right), Size.m3774getHeightimpl(mo4428getSizeNHjbRc()) - (top + bottom));
                if (!(Size.m3777getWidthimpl(updatedSize) >= 0.0f && Size.m3774getHeightimpl(updatedSize) >= 0.0f)) {
                    throw new IllegalArgumentException("Width and height must be greater than or equal to zero".toString());
                }
                drawContext.mo4424setSizeuvyYCjk(updatedSize);
                it.translate(left, top);
            }

            @Override // androidx.compose.p000ui.graphics.drawscope.DrawTransform
            /* renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo4426clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
                $this$asDrawTransform.getCanvas().mo3803clipRectN_I0leg(left, top, right, bottom, clipOp);
            }

            @Override // androidx.compose.p000ui.graphics.drawscope.DrawTransform
            /* renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo4425clipPathmtrdDE(Path path, int clipOp) {
                $this$asDrawTransform.getCanvas().mo3802clipPathmtrdDE(path, clipOp);
            }

            @Override // androidx.compose.p000ui.graphics.drawscope.DrawTransform
            public void translate(float left, float top) {
                $this$asDrawTransform.getCanvas().translate(left, top);
            }

            @Override // androidx.compose.p000ui.graphics.drawscope.DrawTransform
            /* renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo4429rotateUv8p0NA(float degrees, long pivot) {
                Canvas $this$rotate_Uv8p0NA_u24lambda_u242 = $this$asDrawTransform.getCanvas();
                $this$rotate_Uv8p0NA_u24lambda_u242.translate(Offset.m3708getXimpl(pivot), Offset.m3709getYimpl(pivot));
                $this$rotate_Uv8p0NA_u24lambda_u242.rotate(degrees);
                $this$rotate_Uv8p0NA_u24lambda_u242.translate(-Offset.m3708getXimpl(pivot), -Offset.m3709getYimpl(pivot));
            }

            @Override // androidx.compose.p000ui.graphics.drawscope.DrawTransform
            /* renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo4430scale0AR0LA0(float scaleX, float scaleY, long pivot) {
                Canvas $this$scale_0AR0LA0_u24lambda_u243 = $this$asDrawTransform.getCanvas();
                $this$scale_0AR0LA0_u24lambda_u243.translate(Offset.m3708getXimpl(pivot), Offset.m3709getYimpl(pivot));
                $this$scale_0AR0LA0_u24lambda_u243.scale(scaleX, scaleY);
                $this$scale_0AR0LA0_u24lambda_u243.translate(-Offset.m3708getXimpl(pivot), -Offset.m3709getYimpl(pivot));
            }

            @Override // androidx.compose.p000ui.graphics.drawscope.DrawTransform
            /* renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo4431transform58bKbWc(float[] matrix) {
                $this$asDrawTransform.getCanvas().mo3804concat58bKbWc(matrix);
            }
        };
    }
}
