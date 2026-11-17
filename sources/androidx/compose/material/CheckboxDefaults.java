package androidx.compose.material;

import androidx.compose.p000ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Checkbox.kt */
@Metadata(m164d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, m165d2 = {"Landroidx/compose/material/CheckboxDefaults;", "", "()V", "colors", "Landroidx/compose/material/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledColor", "disabledIndeterminateColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/CheckboxColors;", "material_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CheckboxDefaults {
    public static final int $stable = 0;
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    /* renamed from: colors-zjMxDiM, reason: not valid java name */
    public final CheckboxColors m1468colorszjMxDiM(long checkedColor, long uncheckedColor, long checkmarkColor, long disabledColor, long disabledIndeterminateColor, Composer $composer, int $changed, int i) {
        long uncheckedColor2;
        long disabledColor2;
        long disabledIndeterminateColor2;
        $composer.startReplaceableGroup(469524104);
        ComposerKt.sourceInformation($composer, "C(colors)P(0:c#ui.graphics.Color,4:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)227@9578L6,228@9642L6,229@9725L6,230@9786L6,230@9829L8,231@9923L8,233@9972L922:Checkbox.kt#jmzs0o");
        long checkedColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1492getSecondary0d7_KjU() : checkedColor;
        if ((i & 2) != 0) {
            long jM1489getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1489getOnSurface0d7_KjU();
            uncheckedColor2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU) : 0.6f, (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU) : 0.0f);
        } else {
            uncheckedColor2 = uncheckedColor;
        }
        long checkmarkColor2 = (i & 4) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1494getSurface0d7_KjU() : checkmarkColor;
        if ((i & 8) != 0) {
            long jM1489getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1489getOnSurface0d7_KjU();
            disabledColor2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU2) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU2) : 0.0f);
        } else {
            disabledColor2 = disabledColor;
        }
        if ((i & 16) != 0) {
            long checkedColor3 = checkedColor2;
            disabledIndeterminateColor2 = Color.m3947copywmQWz5c(checkedColor3, (14 & 1) != 0 ? Color.m3951getAlphaimpl(checkedColor3) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(checkedColor3) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(checkedColor3) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(checkedColor3) : 0.0f);
        } else {
            disabledIndeterminateColor2 = disabledIndeterminateColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(469524104, $changed, -1, "androidx.compose.material.CheckboxDefaults.colors (Checkbox.kt:232)");
        }
        Object[] keys$iv = {Color.m3939boximpl(checkedColor2), Color.m3939boximpl(uncheckedColor2), Color.m3939boximpl(checkmarkColor2), Color.m3939boximpl(disabledColor2), Color.m3939boximpl(disabledIndeterminateColor2)};
        $composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= $composer.changed(key$iv);
        }
        Object value$iv$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            long checkmarkColor3 = checkmarkColor2;
            long checkmarkColor4 = Color.m3947copywmQWz5c(checkmarkColor3, (14 & 1) != 0 ? Color.m3951getAlphaimpl(checkmarkColor3) : 0.0f, (14 & 2) != 0 ? Color.m3955getRedimpl(checkmarkColor3) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(checkmarkColor3) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(checkmarkColor3) : 0.0f);
            long checkedColor4 = checkedColor2;
            long jM3947copywmQWz5c = Color.m3947copywmQWz5c(checkedColor4, (14 & 1) != 0 ? Color.m3951getAlphaimpl(checkedColor4) : 0.0f, (14 & 2) != 0 ? Color.m3955getRedimpl(checkedColor4) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(checkedColor4) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(checkedColor4) : 0.0f);
            long disabledColor3 = disabledColor2;
            value$iv$iv = new DefaultCheckboxColors(checkmarkColor3, checkmarkColor4, checkedColor4, jM3947copywmQWz5c, disabledColor3, Color.m3947copywmQWz5c(disabledColor3, (14 & 1) != 0 ? Color.m3951getAlphaimpl(disabledColor3) : 0.0f, (14 & 2) != 0 ? Color.m3955getRedimpl(disabledColor3) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(disabledColor3) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(disabledColor3) : 0.0f), disabledIndeterminateColor2, checkedColor4, uncheckedColor2, disabledColor3, disabledIndeterminateColor2, null);
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        DefaultCheckboxColors defaultCheckboxColors = (DefaultCheckboxColors) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultCheckboxColors;
    }
}
