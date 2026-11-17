package androidx.compose.p000ui.graphics;

import android.graphics.ColorSpace;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: AndroidColorSpace.android.kt */
@Metadata(m164d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0007¨\u0006\u0004"}, m165d2 = {"toAndroidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "toComposeColorSpace", "ui-graphics_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidColorSpace_androidKt {
    public static final ColorSpace toAndroidColorSpace(androidx.compose.p000ui.graphics.colorspace.ColorSpace $this$toAndroidColorSpace) {
        ColorSpaceVerificationHelper colorSpaceVerificationHelper = ColorSpaceVerificationHelper.INSTANCE;
        return ColorSpaceVerificationHelper.androidColorSpace($this$toAndroidColorSpace);
    }

    public static final androidx.compose.p000ui.graphics.colorspace.ColorSpace toComposeColorSpace(ColorSpace $this$toComposeColorSpace) {
        ColorSpaceVerificationHelper colorSpaceVerificationHelper = ColorSpaceVerificationHelper.INSTANCE;
        return ColorSpaceVerificationHelper.composeColorSpace($this$toComposeColorSpace);
    }
}
