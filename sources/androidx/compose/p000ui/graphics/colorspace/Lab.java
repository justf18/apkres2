package androidx.compose.p000ui.graphics.colorspace;

import androidx.autofill.HintConstants;
import androidx.compose.p000ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: Lab.kt */
@Metadata(m164d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J%\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0019J=\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, m165d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", HintConstants.AUTOFILL_HINT_NAME, "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", "v", "getMaxValue", "", "component", "getMinValue", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Lab extends ColorSpace {

    /* renamed from: A */
    private static final float f74A = 0.008856452f;

    /* renamed from: B */
    private static final float f75B = 7.787037f;

    /* renamed from: C */
    private static final float f76C = 0.13793103f;

    /* renamed from: D */
    private static final float f77D = 0.20689656f;

    public Lab(String name, int id) {
        super(name, ColorModel.INSTANCE.m4361getLabxdoWZVw(), id, null);
    }

    @Override // androidx.compose.p000ui.graphics.colorspace.ColorSpace
    /* renamed from: isWideGamut */
    public boolean getIsWideGamut() {
        return true;
    }

    @Override // androidx.compose.p000ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return component == 0 ? 0.0f : -128.0f;
    }

    @Override // androidx.compose.p000ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return component == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.p000ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v) {
        v[0] = RangesKt.coerceIn(v[0], 0.0f, 100.0f);
        v[1] = RangesKt.coerceIn(v[1], -128.0f, 128.0f);
        v[2] = RangesKt.coerceIn(v[2], -128.0f, 128.0f);
        float fy = (v[0] + 16.0f) / 116.0f;
        float fx = (v[1] * 0.002f) + fy;
        float fz = fy - (v[2] * 0.005f);
        float x = fx > f77D ? fx * fx * fx : (fx - f76C) * 0.12841855f;
        float y = fy > f77D ? fy * fy * fy : (fy - f76C) * 0.12841855f;
        float z = fz > f77D ? fz * fz * fz : (fz - f76C) * 0.12841855f;
        v[0] = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0] * x;
        v[1] = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1] * y;
        v[2] = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2] * z;
        return v;
    }

    @Override // androidx.compose.p000ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v0, float v1, float v2) {
        float v00 = RangesKt.coerceIn(v0, 0.0f, 100.0f);
        float v10 = RangesKt.coerceIn(v1, -128.0f, 128.0f);
        float fy = (16.0f + v00) / 116.0f;
        float fx = (0.002f * v10) + fy;
        float x = fx > f77D ? fx * fx * fx : (fx - f76C) * 0.12841855f;
        float y = fy > f77D ? fy * fy * fy : (fy - f76C) * 0.12841855f;
        float val1$iv = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0] * x;
        float val2$iv = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1] * y;
        long v1$iv = Float.floatToRawIntBits(val1$iv);
        long v2$iv = Float.floatToRawIntBits(val2$iv);
        return (v1$iv << 32) | (v2$iv & 4294967295L);
    }

    @Override // androidx.compose.p000ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v0, float v1, float v2) {
        float v00 = RangesKt.coerceIn(v0, 0.0f, 100.0f);
        float v20 = RangesKt.coerceIn(v2, -128.0f, 128.0f);
        float fy = (16.0f + v00) / 116.0f;
        float fz = fy - (0.005f * v20);
        float z = fz > f77D ? fz * fz * fz : (fz - f76C) * 0.12841855f;
        return Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2] * z;
    }

    @Override // androidx.compose.p000ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo4365xyzaToColorJlNiLsg$ui_graphics_release(float x, float y, float z, float a, ColorSpace colorSpace) {
        float x1 = x / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0];
        float y1 = y / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1];
        float z1 = z / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
        float fx = x1 > f74A ? (float) Math.pow(x1, 0.33333334f) : (x1 * f75B) + f76C;
        float fy = y1 > f74A ? (float) Math.pow(y1, 0.33333334f) : (y1 * f75B) + f76C;
        float fz = z1 > f74A ? (float) Math.pow(z1, 0.33333334f) : (f75B * z1) + f76C;
        float l = (116.0f * fy) - 16.0f;
        float a1 = (fx - fy) * 500.0f;
        float b = (fy - fz) * 200.0f;
        return ColorKt.Color(RangesKt.coerceIn(l, 0.0f, 100.0f), RangesKt.coerceIn(a1, -128.0f, 128.0f), RangesKt.coerceIn(b, -128.0f, 128.0f), a, colorSpace);
    }

    @Override // androidx.compose.p000ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v) {
        float x = v[0] / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0];
        float y = v[1] / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1];
        float z = v[2] / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
        float fx = x > f74A ? (float) Math.pow(x, 0.33333334f) : (x * f75B) + f76C;
        float fy = y > f74A ? (float) Math.pow(y, 0.33333334f) : (y * f75B) + f76C;
        float fz = z > f74A ? (float) Math.pow(z, 0.33333334f) : (f75B * z) + f76C;
        float l = (116.0f * fy) - 16.0f;
        float a = (fx - fy) * 500.0f;
        float b = (fy - fz) * 200.0f;
        v[0] = RangesKt.coerceIn(l, 0.0f, 100.0f);
        v[1] = RangesKt.coerceIn(a, -128.0f, 128.0f);
        v[2] = RangesKt.coerceIn(b, -128.0f, 128.0f);
        return v;
    }
}
