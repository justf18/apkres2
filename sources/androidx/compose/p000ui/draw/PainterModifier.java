package androidx.compose.p000ui.draw;

import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.geometry.SizeKt;
import androidx.compose.p000ui.graphics.ColorFilter;
import androidx.compose.p000ui.graphics.painter.Painter;
import androidx.compose.p000ui.layout.ContentScale;
import androidx.compose.p000ui.layout.IntrinsicMeasurable;
import androidx.compose.p000ui.layout.IntrinsicMeasureScope;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.layout.ScaleFactorKt;
import androidx.compose.p000ui.node.DrawModifierNode;
import androidx.compose.p000ui.node.LayoutModifierNode;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

/* compiled from: PainterModifier.kt */
@Metadata(m164d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001a\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00101J\b\u00106\u001a\u000207H\u0016J\f\u00108\u001a\u000209*\u00020:H\u0016J\u0016\u0010;\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0016\u0010>\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010=J\u001c\u0010@\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010F\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016J&\u0010H\u001a\u00020I*\u00020J2\u0006\u0010C\u001a\u00020K2\u0006\u00104\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u001c\u0010N\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010O\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010'\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006P"}, m165d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "getSizeToIntrinsics", "setSizeToIntrinsics", "(Z)V", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: androidx.compose.ui.draw.PainterNode, reason: from toString */
/* loaded from: classes.dex */
final class PainterModifier extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    public /* synthetic */ PainterModifier(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i & 8) != 0 ? ContentScale.INSTANCE.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(Painter painter) {
        this.painter = painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public PainterModifier(Painter painter, boolean sizeToIntrinsics, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter) {
        this.painter = painter;
        this.sizeToIntrinsics = sizeToIntrinsics;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = alpha;
        this.colorFilter = colorFilter;
    }

    private final boolean getUseIntrinsicSize() {
        if (!this.sizeToIntrinsics) {
            return false;
        }
        long $this$isSpecified$iv = this.painter.getIntrinsicSize();
        return (($this$isSpecified$iv > Size.INSTANCE.m3785getUnspecifiedNHjbRc() ? 1 : ($this$isSpecified$iv == Size.INSTANCE.m3785getUnspecifiedNHjbRc() ? 0 : -1)) != 0 ? 1 : 0) != 0;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.p000ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo295measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        final Placeable placeable = measurable.mo5219measureBRTryo0(m3619modifyConstraintsZezNO4M(constraints));
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope $this$layout) {
                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.p000ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        if (getUseIntrinsicSize()) {
            long constraints = m3619modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null));
            int layoutWidth = measurable.minIntrinsicWidth(height);
            return Math.max(Constraints.m6255getMinWidthimpl(constraints), layoutWidth);
        }
        return measurable.minIntrinsicWidth(height);
    }

    @Override // androidx.compose.p000ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        if (getUseIntrinsicSize()) {
            long constraints = m3619modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null));
            int layoutWidth = measurable.maxIntrinsicWidth(height);
            return Math.max(Constraints.m6255getMinWidthimpl(constraints), layoutWidth);
        }
        return measurable.maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.p000ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        if (getUseIntrinsicSize()) {
            long constraints = m3619modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null));
            int layoutHeight = measurable.minIntrinsicHeight(width);
            return Math.max(Constraints.m6254getMinHeightimpl(constraints), layoutHeight);
        }
        return measurable.minIntrinsicHeight(width);
    }

    @Override // androidx.compose.p000ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        if (getUseIntrinsicSize()) {
            long constraints = m3619modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null));
            int layoutHeight = measurable.maxIntrinsicHeight(width);
            return Math.max(Constraints.m6254getMinHeightimpl(constraints), layoutHeight);
        }
        return measurable.maxIntrinsicHeight(width);
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m3616calculateScaledSizeE7KxVPU(long dstSize) {
        float srcWidth;
        float srcHeight;
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        if (!m3618hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.getIntrinsicSize())) {
            srcWidth = Size.m3777getWidthimpl(dstSize);
        } else {
            srcWidth = Size.m3777getWidthimpl(this.painter.getIntrinsicSize());
        }
        if (!m3617hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.getIntrinsicSize())) {
            srcHeight = Size.m3774getHeightimpl(dstSize);
        } else {
            srcHeight = Size.m3774getHeightimpl(this.painter.getIntrinsicSize());
        }
        long srcSize = SizeKt.Size(srcWidth, srcHeight);
        if (!(Size.m3777getWidthimpl(dstSize) == 0.0f)) {
            if (!(Size.m3774getHeightimpl(dstSize) == 0.0f)) {
                return ScaleFactorKt.m5304timesUQTWf7w(srcSize, this.contentScale.mo5210computeScaleFactorH7hwNQA(srcSize, dstSize));
            }
        }
        return Size.INSTANCE.m3786getZeroNHjbRc();
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m3619modifyConstraintsZezNO4M(long constraints) {
        int iM6255getMinWidthimpl;
        int iM6254getMinHeightimpl;
        boolean hasBoundedDimens = Constraints.m6249getHasBoundedWidthimpl(constraints) && Constraints.m6248getHasBoundedHeightimpl(constraints);
        boolean hasFixedDimens = Constraints.m6251getHasFixedWidthimpl(constraints) && Constraints.m6250getHasFixedHeightimpl(constraints);
        if ((!getUseIntrinsicSize() && hasBoundedDimens) || hasFixedDimens) {
            return Constraints.m6243copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(constraints) : Constraints.m6253getMaxWidthimpl(constraints), (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(constraints) : Constraints.m6252getMaxHeightimpl(constraints), (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(constraints) : 0);
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (m3618hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize)) {
            iM6255getMinWidthimpl = MathKt.roundToInt(Size.m3777getWidthimpl(intrinsicSize));
        } else {
            iM6255getMinWidthimpl = Constraints.m6255getMinWidthimpl(constraints);
        }
        int intrinsicWidth = iM6255getMinWidthimpl;
        if (m3617hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize)) {
            iM6254getMinHeightimpl = MathKt.roundToInt(Size.m3774getHeightimpl(intrinsicSize));
        } else {
            iM6254getMinHeightimpl = Constraints.m6254getMinHeightimpl(constraints);
        }
        int intrinsicHeight = iM6254getMinHeightimpl;
        int constrainedWidth = ConstraintsKt.m6267constrainWidthK40F9xA(constraints, intrinsicWidth);
        int constrainedHeight = ConstraintsKt.m6266constrainHeightK40F9xA(constraints, intrinsicHeight);
        long scaledSize = m3616calculateScaledSizeE7KxVPU(SizeKt.Size(constrainedWidth, constrainedHeight));
        int minWidth = ConstraintsKt.m6267constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m3777getWidthimpl(scaledSize)));
        int minHeight = ConstraintsKt.m6266constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m3774getHeightimpl(scaledSize)));
        return Constraints.m6243copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(constraints) : minWidth, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(constraints) : minHeight, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(constraints) : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    @Override // androidx.compose.p000ui.node.DrawModifierNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(androidx.compose.p000ui.graphics.drawscope.ContentDrawScope r22) {
        /*
            r21 = this;
            r0 = r21
            androidx.compose.ui.graphics.painter.Painter r1 = r0.painter
            long r1 = r1.getIntrinsicSize()
            boolean r3 = r0.m3618hasSpecifiedAndFiniteWidthuvyYCjk(r1)
            if (r3 == 0) goto L13
            float r3 = androidx.compose.p000ui.geometry.Size.m3777getWidthimpl(r1)
            goto L1b
        L13:
            long r3 = r22.mo4498getSizeNHjbRc()
            float r3 = androidx.compose.p000ui.geometry.Size.m3777getWidthimpl(r3)
        L1b:
            boolean r4 = r0.m3617hasSpecifiedAndFiniteHeightuvyYCjk(r1)
            if (r4 == 0) goto L27
            float r4 = androidx.compose.p000ui.geometry.Size.m3774getHeightimpl(r1)
            goto L2f
        L27:
            long r4 = r22.mo4498getSizeNHjbRc()
            float r4 = androidx.compose.p000ui.geometry.Size.m3774getHeightimpl(r4)
        L2f:
            long r5 = androidx.compose.p000ui.geometry.SizeKt.Size(r3, r4)
            long r7 = r22.mo4498getSizeNHjbRc()
            float r7 = androidx.compose.p000ui.geometry.Size.m3777getWidthimpl(r7)
            r8 = 0
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            r9 = 1
            r10 = 0
            if (r7 != 0) goto L45
            r7 = r9
            goto L46
        L45:
            r7 = r10
        L46:
            if (r7 != 0) goto L67
            long r11 = r22.mo4498getSizeNHjbRc()
            float r7 = androidx.compose.p000ui.geometry.Size.m3774getHeightimpl(r11)
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L55
            goto L56
        L55:
            r9 = r10
        L56:
            if (r9 != 0) goto L67
            androidx.compose.ui.layout.ContentScale r7 = r0.contentScale
            long r8 = r22.mo4498getSizeNHjbRc()
            long r7 = r7.mo5210computeScaleFactorH7hwNQA(r5, r8)
            long r7 = androidx.compose.p000ui.layout.ScaleFactorKt.m5304timesUQTWf7w(r5, r7)
            goto L6d
        L67:
            androidx.compose.ui.geometry.Size$Companion r7 = androidx.compose.p000ui.geometry.Size.INSTANCE
            long r7 = r7.m3786getZeroNHjbRc()
        L6d:
            r11 = r7
            androidx.compose.ui.Alignment r13 = r0.alignment
            float r7 = androidx.compose.p000ui.geometry.Size.m3777getWidthimpl(r11)
            int r7 = kotlin.math.MathKt.roundToInt(r7)
            float r8 = androidx.compose.p000ui.geometry.Size.m3774getHeightimpl(r11)
            int r8 = kotlin.math.MathKt.roundToInt(r8)
            long r14 = androidx.compose.p000ui.unit.IntSizeKt.IntSize(r7, r8)
            long r7 = r22.mo4498getSizeNHjbRc()
            float r7 = androidx.compose.p000ui.geometry.Size.m3777getWidthimpl(r7)
            int r7 = kotlin.math.MathKt.roundToInt(r7)
            long r8 = r22.mo4498getSizeNHjbRc()
            float r8 = androidx.compose.p000ui.geometry.Size.m3774getHeightimpl(r8)
            int r8 = kotlin.math.MathKt.roundToInt(r8)
            long r16 = androidx.compose.p000ui.unit.IntSizeKt.IntSize(r7, r8)
            androidx.compose.ui.unit.LayoutDirection r18 = r22.getLayoutDirection()
            long r7 = r13.mo3585alignKFBX0sM(r14, r16, r18)
            int r9 = androidx.compose.p000ui.unit.IntOffset.m6425getXimpl(r7)
            float r15 = (float) r9
            int r9 = androidx.compose.p000ui.unit.IntOffset.m6426getYimpl(r7)
            float r9 = (float) r9
            r16 = r22
            androidx.compose.ui.graphics.drawscope.DrawScope r16 = (androidx.compose.p000ui.graphics.drawscope.DrawScope) r16
            r17 = 0
            androidx.compose.ui.graphics.drawscope.DrawContext r10 = r16.getDrawContext()
            androidx.compose.ui.graphics.drawscope.DrawTransform r10 = r10.getTransform()
            r10.translate(r15, r9)
            r10 = r16
            r18 = 0
            r13 = r9
            androidx.compose.ui.graphics.painter.Painter r9 = r0.painter
            r19 = 0
            r14 = r13
            float r13 = r0.alpha
            r20 = r14
            androidx.compose.ui.graphics.ColorFilter r14 = r0.colorFilter
            r0 = r20
            r9.m4574drawx_KDEd0(r10, r11, r13, r14)
            androidx.compose.ui.graphics.drawscope.DrawContext r9 = r16.getDrawContext()
            androidx.compose.ui.graphics.drawscope.DrawTransform r9 = r9.getTransform()
            float r10 = -r15
            float r13 = -r0
            r9.translate(r10, r13)
            r22.drawContent()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p000ui.draw.PainterModifier.draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope):void");
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m3618hasSpecifiedAndFiniteWidthuvyYCjk(long $this$hasSpecifiedAndFiniteWidth_u2duvyYCjk) {
        if (Size.m3773equalsimpl0($this$hasSpecifiedAndFiniteWidth_u2duvyYCjk, Size.INSTANCE.m3785getUnspecifiedNHjbRc())) {
            return false;
        }
        float fM3777getWidthimpl = Size.m3777getWidthimpl($this$hasSpecifiedAndFiniteWidth_u2duvyYCjk);
        return !Float.isInfinite(fM3777getWidthimpl) && !Float.isNaN(fM3777getWidthimpl);
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m3617hasSpecifiedAndFiniteHeightuvyYCjk(long $this$hasSpecifiedAndFiniteHeight_u2duvyYCjk) {
        if (Size.m3773equalsimpl0($this$hasSpecifiedAndFiniteHeight_u2duvyYCjk, Size.INSTANCE.m3785getUnspecifiedNHjbRc())) {
            return false;
        }
        float fM3774getHeightimpl = Size.m3774getHeightimpl($this$hasSpecifiedAndFiniteHeight_u2duvyYCjk);
        return !Float.isInfinite(fM3774getHeightimpl) && !Float.isNaN(fM3774getHeightimpl);
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
