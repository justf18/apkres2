package androidx.compose.p000ui.text;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shadow;
import androidx.compose.p000ui.graphics.drawscope.DrawContext;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawStyle;
import androidx.compose.p000ui.graphics.drawscope.DrawTransform;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.style.TextDecoration;
import androidx.compose.p000ui.text.style.TextOverflow;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.IntSize;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* compiled from: TextPainter.kt */
@Metadata(m164d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001af\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001ah\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0080\u0001\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001aj\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020/2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a&\u00102\u001a\u000203*\u00020\u00062\u0006\u0010+\u001a\u00020,2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, m165d2 = {"clip", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawText", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawText-LVfH_YU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Brush;JFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "drawText-d8-rzKo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;JJFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "size", "Landroidx/compose/ui/geometry/Size;", "drawText-JFhB2K4", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextStyle;IZILjava/util/List;JI)V", "", "drawText-TPWCCtM", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;IZIJI)V", "textLayoutConstraints", "Landroidx/compose/ui/unit/Constraints;", "textLayoutConstraints-v_w8tDc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJ)J", "ui-text_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextPainterKt {
    /* renamed from: drawText-JFhB2K4, reason: not valid java name */
    public static final void m5753drawTextJFhB2K4(DrawScope $this$drawText_u2dJFhB2K4, TextMeasurer textMeasurer, AnnotatedString text, long topLeft, TextStyle style, int overflow, boolean softWrap, int maxLines, List<AnnotatedString.Range<Placeholder>> list, long size, int blendMode) {
        TextLayoutResult textLayoutResult = TextMeasurer.m5750measurexDpz5zY$default(textMeasurer, text, style, overflow, softWrap, maxLines, list, m5761textLayoutConstraintsv_w8tDc($this$drawText_u2dJFhB2K4, size, topLeft), $this$drawText_u2dJFhB2K4.getLayoutDirection(), $this$drawText_u2dJFhB2K4, null, false, 1536, null);
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$drawText_u2dJFhB2K4.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4423getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$drawText_JFhB2K4_u24lambda_u240 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$drawText_JFhB2K4_u24lambda_u240.translate(Offset.m3708getXimpl(topLeft), Offset.m3709getYimpl(topLeft));
        clip($this$drawText_JFhB2K4_u24lambda_u240, textLayoutResult);
        textLayoutResult.getMultiParagraph().m5653paintLG529CI($this$drawText_u2dJFhB2K4.getDrawContext().getCanvas(), (32 & 2) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : 0L, (32 & 4) != 0 ? null : null, (32 & 8) != 0 ? null : null, (32 & 16) == 0 ? null : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m4499getDefaultBlendMode0nO6VwU() : blendMode);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo4424setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: drawText-TPWCCtM, reason: not valid java name */
    public static final void m5757drawTextTPWCCtM(DrawScope $this$drawText_u2dTPWCCtM, TextMeasurer textMeasurer, String text, long topLeft, TextStyle style, int overflow, boolean softWrap, int maxLines, long size, int blendMode) {
        TextLayoutResult textLayoutResult = TextMeasurer.m5750measurexDpz5zY$default(textMeasurer, new AnnotatedString(text, null, null, 6, null), style, overflow, softWrap, maxLines, null, m5761textLayoutConstraintsv_w8tDc($this$drawText_u2dTPWCCtM, size, topLeft), $this$drawText_u2dTPWCCtM.getLayoutDirection(), $this$drawText_u2dTPWCCtM, null, false, 1568, null);
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$drawText_u2dTPWCCtM.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4423getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$drawText_TPWCCtM_u24lambda_u242 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$drawText_TPWCCtM_u24lambda_u242.translate(Offset.m3708getXimpl(topLeft), Offset.m3709getYimpl(topLeft));
        clip($this$drawText_TPWCCtM_u24lambda_u242, textLayoutResult);
        textLayoutResult.getMultiParagraph().m5653paintLG529CI($this$drawText_u2dTPWCCtM.getDrawContext().getCanvas(), (32 & 2) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : 0L, (32 & 4) != 0 ? null : null, (32 & 8) != 0 ? null : null, (32 & 16) == 0 ? null : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m4499getDefaultBlendMode0nO6VwU() : blendMode);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo4424setSizeuvyYCjk(previousSize$iv);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b3  */
    /* renamed from: drawText-d8-rzKo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m5759drawTextd8rzKo(androidx.compose.p000ui.graphics.drawscope.DrawScope r27, androidx.compose.p000ui.text.TextLayoutResult r28, long r29, long r31, float r33, androidx.compose.p000ui.graphics.Shadow r34, androidx.compose.p000ui.text.style.TextDecoration r35, androidx.compose.p000ui.graphics.drawscope.DrawStyle r36, int r37) {
        /*
            if (r34 != 0) goto Lf
            androidx.compose.ui.text.TextLayoutInput r0 = r28.getLayoutInput()
            androidx.compose.ui.text.TextStyle r0 = r0.getStyle()
            androidx.compose.ui.graphics.Shadow r0 = r0.getShadow()
            goto L11
        Lf:
            r0 = r34
        L11:
            r5 = r0
            if (r35 != 0) goto L22
            androidx.compose.ui.text.TextLayoutInput r0 = r28.getLayoutInput()
            androidx.compose.ui.text.TextStyle r0 = r0.getStyle()
            androidx.compose.ui.text.style.TextDecoration r0 = r0.getTextDecoration()
            r6 = r0
            goto L24
        L22:
            r6 = r35
        L24:
            if (r36 != 0) goto L34
            androidx.compose.ui.text.TextLayoutInput r0 = r28.getLayoutInput()
            androidx.compose.ui.text.TextStyle r0 = r0.getStyle()
            androidx.compose.ui.graphics.drawscope.DrawStyle r0 = r0.getDrawStyle()
            r7 = r0
            goto L36
        L34:
            r7 = r36
        L36:
            r0 = r27
            r9 = 0
            androidx.compose.ui.graphics.drawscope.DrawContext r10 = r0.getDrawContext()
            r11 = 0
            long r12 = r10.mo4423getSizeNHjbRc()
            androidx.compose.ui.graphics.Canvas r1 = r10.getCanvas()
            r1.save()
            androidx.compose.ui.graphics.drawscope.DrawTransform r1 = r10.getTransform()
            r2 = 0
            float r3 = androidx.compose.p000ui.geometry.Offset.m3708getXimpl(r31)
            float r4 = androidx.compose.p000ui.geometry.Offset.m3709getYimpl(r31)
            r1.translate(r3, r4)
            r14 = r28
            clip(r1, r14)
            r15 = r0
            r16 = 0
            androidx.compose.ui.text.TextLayoutInput r1 = r14.getLayoutInput()
            androidx.compose.ui.text.TextStyle r1 = r1.getStyle()
            androidx.compose.ui.graphics.Brush r3 = r1.getBrush()
            r1 = 1
            r2 = 0
            if (r3 == 0) goto Lb3
            r17 = r29
            r4 = 0
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.p000ui.graphics.Color.INSTANCE
            long r19 = r8.m3985getUnspecified0d7_KjU()
            int r8 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r8 != 0) goto L82
            r4 = r1
            goto L83
        L82:
            r4 = r2
        L83:
            if (r4 == 0) goto Lb3
            androidx.compose.ui.text.MultiParagraph r1 = r14.getMultiParagraph()
            androidx.compose.ui.graphics.drawscope.DrawContext r2 = r15.getDrawContext()
            androidx.compose.ui.graphics.Canvas r2 = r2.getCanvas()
            boolean r4 = java.lang.Float.isNaN(r33)
            if (r4 != 0) goto L9b
            r4 = r33
            goto La7
        L9b:
            androidx.compose.ui.text.TextLayoutInput r4 = r14.getLayoutInput()
            androidx.compose.ui.text.TextStyle r4 = r4.getStyle()
            float r4 = r4.getAlpha()
        La7:
            r8 = r37
            r1.m5655painthn5TExg(r2, r3, r4, r5, r6, r7, r8)
            r17 = r3
            goto Lfb
        Lb3:
            r17 = r3
            r3 = r1
            androidx.compose.ui.text.MultiParagraph r1 = r14.getMultiParagraph()
            androidx.compose.ui.graphics.drawscope.DrawContext r4 = r15.getDrawContext()
            androidx.compose.ui.graphics.Canvas r4 = r4.getCanvas()
            r18 = r29
            r8 = 0
            r20 = r18
            r22 = 0
            androidx.compose.ui.graphics.Color$Companion r23 = androidx.compose.p000ui.graphics.Color.INSTANCE
            long r23 = r23.m3985getUnspecified0d7_KjU()
            int r23 = (r20 > r23 ? 1 : (r20 == r23 ? 0 : -1))
            if (r23 == 0) goto Ld4
            r2 = r3
        Ld4:
            if (r2 == 0) goto Ld9
            r2 = r18
            goto Le7
        Ld9:
            r2 = 0
            androidx.compose.ui.text.TextLayoutInput r3 = r14.getLayoutInput()
            androidx.compose.ui.text.TextStyle r3 = r3.getStyle()
            long r2 = r3.m5804getColor0d7_KjU()
        Le7:
            r8 = r33
            long r2 = androidx.compose.p000ui.text.style.TextDrawStyleKt.m6187modulateDxMtmZc(r2, r8)
            r25 = r2
            r2 = r4
            r3 = r25
            r8 = r37
            r1.m5653paintLG529CI(r2, r3, r5, r6, r7, r8)
        Lfb:
            androidx.compose.ui.graphics.Canvas r1 = r10.getCanvas()
            r1.restore()
            r10.mo4424setSizeuvyYCjk(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p000ui.text.TextPainterKt.m5759drawTextd8rzKo(androidx.compose.ui.graphics.drawscope.DrawScope, androidx.compose.ui.text.TextLayoutResult, long, long, float, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.drawscope.DrawStyle, int):void");
    }

    /* renamed from: drawText-LVfH_YU, reason: not valid java name */
    public static final void m5755drawTextLVfH_YU(DrawScope $this$drawText_u2dLVfH_YU, TextLayoutResult textLayoutResult, Brush brush, long topLeft, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        Shadow newShadow = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration newTextDecoration = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle newDrawStyle = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$drawText_u2dLVfH_YU.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.mo4423getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$drawText_LVfH_YU_u24lambda_u247 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$drawText_LVfH_YU_u24lambda_u247.translate(Offset.m3708getXimpl(topLeft), Offset.m3709getYimpl(topLeft));
        clip($this$drawText_LVfH_YU_u24lambda_u247, textLayoutResult);
        textLayoutResult.getMultiParagraph().m5655painthn5TExg($this$drawText_u2dLVfH_YU.getDrawContext().getCanvas(), brush, !Float.isNaN(alpha) ? alpha : textLayoutResult.getLayoutInput().getStyle().getAlpha(), newShadow, newTextDecoration, newDrawStyle, blendMode);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.mo4424setSizeuvyYCjk(previousSize$iv);
    }

    private static final void clip(DrawTransform $this$clip, TextLayoutResult textLayoutResult) {
        if (textLayoutResult.getHasVisualOverflow() && !TextOverflow.m6209equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m6218getVisiblegIe3tQ8())) {
            DrawTransform.m4550clipRectN_I0leg$default($this$clip, 0.0f, 0.0f, IntSize.m6467getWidthimpl(textLayoutResult.getSize()), IntSize.m6466getHeightimpl(textLayoutResult.getSize()), 0, 16, null);
        }
    }

    /* renamed from: textLayoutConstraints-v_w8tDc, reason: not valid java name */
    private static final long m5761textLayoutConstraintsv_w8tDc(DrawScope $this$textLayoutConstraints_u2dv_w8tDc, long size, long topLeft) {
        int minWidth;
        int maxWidth;
        int minHeight;
        int maxHeight;
        boolean isHeightNaN = true;
        boolean isWidthNaN = ((size > Size.INSTANCE.m3785getUnspecifiedNHjbRc() ? 1 : (size == Size.INSTANCE.m3785getUnspecifiedNHjbRc() ? 0 : -1)) == 0) || Float.isNaN(Size.m3777getWidthimpl(size));
        if (isWidthNaN) {
            minWidth = 0;
            maxWidth = MathKt.roundToInt((float) Math.ceil(Size.m3777getWidthimpl($this$textLayoutConstraints_u2dv_w8tDc.mo4498getSizeNHjbRc()) - Offset.m3708getXimpl(topLeft)));
        } else {
            int fixedWidth = MathKt.roundToInt((float) Math.ceil(Size.m3777getWidthimpl(size)));
            minWidth = fixedWidth;
            maxWidth = fixedWidth;
        }
        if ((size == Size.INSTANCE.m3785getUnspecifiedNHjbRc() ? 1 : 0) == 0 && !Float.isNaN(Size.m3774getHeightimpl(size))) {
            isHeightNaN = false;
        }
        if (isHeightNaN) {
            minHeight = 0;
            maxHeight = MathKt.roundToInt((float) Math.ceil(Size.m3774getHeightimpl($this$textLayoutConstraints_u2dv_w8tDc.mo4498getSizeNHjbRc()) - Offset.m3709getYimpl(topLeft)));
        } else {
            int fixedHeight = MathKt.roundToInt((float) Math.ceil(Size.m3774getHeightimpl(size)));
            minHeight = fixedHeight;
            maxHeight = fixedHeight;
        }
        return ConstraintsKt.Constraints(minWidth, maxWidth, minHeight, maxHeight);
    }
}
