package androidx.compose.p000ui.unit;

import android.content.Context;
import androidx.compose.p000ui.unit.fontscaling.FontScaleConverterFactory;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: AndroidDensity.android.kt */
@Metadata(m164d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, m165d2 = {"Density", "Landroidx/compose/ui/unit/Density;", "context", "Landroid/content/Context;", "ui-unit_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidDensity_androidKt {
    public static final Density Density(Context context) {
        LinearFontScaleConverter converter;
        float fontScale = context.getResources().getConfiguration().fontScale;
        if (FontScalingKt.getDisableNonLinearFontScalingInCompose() || (converter = FontScaleConverterFactory.INSTANCE.forScale(fontScale)) == null) {
            converter = new LinearFontScaleConverter(fontScale);
        }
        return new DensityWithConverter(context.getResources().getDisplayMetrics().density, fontScale, converter);
    }
}
