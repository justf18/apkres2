package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* compiled from: NavigationBar.kt */
@Metadata(m164d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tJD\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011JX\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, m165d2 = {"Landroidx/compose/material3/NavigationBarItemDefaults;", "", "()V", "defaultNavigationBarItemColors", "Landroidx/compose/material3/NavigationBarItemColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultNavigationBarItemColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationBarItemColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationBarItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "indicatorColor", "unselectedIconColor", "unselectedTextColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationBarItemColors;", "material3_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NavigationBarItemDefaults {
    public static final int $stable = 0;
    public static final NavigationBarItemDefaults INSTANCE = new NavigationBarItemDefaults();

    private NavigationBarItemDefaults() {
    }

    public final NavigationBarItemColors colors(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1018883954);
        ComposerKt.sourceInformation($composer, "C(colors)297@12710L11:NavigationBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1018883954, $changed, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:297)");
        }
        NavigationBarItemColors defaultNavigationBarItemColors$material3_release = getDefaultNavigationBarItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultNavigationBarItemColors$material3_release;
    }

    /* renamed from: colors-69fazGs, reason: not valid java name */
    public final NavigationBarItemColors m2231colors69fazGs(long selectedIconColor, long selectedTextColor, long indicatorColor, long unselectedIconColor, long unselectedTextColor, long disabledIconColor, long disabledTextColor, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-1618564327);
        ComposerKt.sourceInformation($composer, "C(colors)P(3:c#ui.graphics.Color,4:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color):NavigationBar.kt#uh7d8r");
        long selectedIconColor2 = (i & 1) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : selectedIconColor;
        long selectedTextColor2 = (i & 2) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : selectedTextColor;
        long indicatorColor2 = (i & 4) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : indicatorColor;
        long unselectedIconColor2 = (i & 8) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : unselectedIconColor;
        long unselectedTextColor2 = (i & 16) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : unselectedTextColor;
        long disabledIconColor2 = (i & 32) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : disabledIconColor;
        long disabledTextColor2 = (i & 64) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : disabledTextColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1618564327, $changed, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:321)");
        }
        NavigationBarItemColors navigationBarItemColors = new NavigationBarItemColors(selectedIconColor2, selectedTextColor2, indicatorColor2, unselectedIconColor2, unselectedTextColor2, disabledIconColor2, disabledTextColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return navigationBarItemColors;
    }

    public final NavigationBarItemColors getDefaultNavigationBarItemColors$material3_release(ColorScheme $this$defaultNavigationBarItemColors) {
        NavigationBarItemColors defaultNavigationBarItemColorsCached = $this$defaultNavigationBarItemColors.getDefaultNavigationBarItemColorsCached();
        if (defaultNavigationBarItemColorsCached == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultNavigationBarItemColors, NavigationBarTokens.INSTANCE.getActiveIconColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultNavigationBarItemColors, NavigationBarTokens.INSTANCE.getActiveLabelTextColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultNavigationBarItemColors, NavigationBarTokens.INSTANCE.getActiveIndicatorColor());
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultNavigationBarItemColors, NavigationBarTokens.INSTANCE.getInactiveIconColor());
            long jFromToken5 = ColorSchemeKt.fromToken($this$defaultNavigationBarItemColors, NavigationBarTokens.INSTANCE.getInactiveLabelTextColor());
            long jFromToken6 = ColorSchemeKt.fromToken($this$defaultNavigationBarItemColors, NavigationBarTokens.INSTANCE.getInactiveIconColor());
            long jM3947copywmQWz5c = Color.m3947copywmQWz5c(jFromToken6, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jFromToken6) : 0.38f, (14 & 2) != 0 ? Color.m3955getRedimpl(jFromToken6) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jFromToken6) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jFromToken6) : 0.0f);
            long jFromToken7 = ColorSchemeKt.fromToken($this$defaultNavigationBarItemColors, NavigationBarTokens.INSTANCE.getInactiveLabelTextColor());
            NavigationBarItemColors it = new NavigationBarItemColors(jFromToken, jFromToken2, jFromToken3, jFromToken4, jFromToken5, jM3947copywmQWz5c, Color.m3947copywmQWz5c(jFromToken7, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jFromToken7) : 0.38f, (14 & 2) != 0 ? Color.m3955getRedimpl(jFromToken7) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jFromToken7) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jFromToken7) : 0.0f), null);
            $this$defaultNavigationBarItemColors.setDefaultNavigationBarItemColorsCached$material3_release(it);
            return it;
        }
        return defaultNavigationBarItemColorsCached;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with disabledIconColor and disabledTextColor")
    /* renamed from: colors-zjMxDiM, reason: not valid java name */
    public final /* synthetic */ NavigationBarItemColors m2232colorszjMxDiM(long selectedIconColor, long selectedTextColor, long indicatorColor, long unselectedIconColor, long unselectedTextColor, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-213647161);
        ComposerKt.sourceInformation($composer, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)355@15685L5,356@15768L5,357@15848L5,358@15930L5,359@16017L5:NavigationBar.kt#uh7d8r");
        long selectedIconColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getActiveIconColor(), $composer, 6) : selectedIconColor;
        long selectedTextColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getActiveLabelTextColor(), $composer, 6) : selectedTextColor;
        long indicatorColor2 = (i & 4) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorColor(), $composer, 6) : indicatorColor;
        long unselectedIconColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getInactiveIconColor(), $composer, 6) : unselectedIconColor;
        long unselectedTextColor2 = (i & 16) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getInactiveLabelTextColor(), $composer, 6) : unselectedTextColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-213647161, $changed, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:360)");
        }
        long unselectedIconColor3 = unselectedIconColor2;
        long jM3947copywmQWz5c = Color.m3947copywmQWz5c(unselectedIconColor3, (14 & 1) != 0 ? Color.m3951getAlphaimpl(unselectedIconColor3) : 0.38f, (14 & 2) != 0 ? Color.m3955getRedimpl(unselectedIconColor3) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(unselectedIconColor3) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(unselectedIconColor3) : 0.0f);
        long unselectedTextColor3 = unselectedTextColor2;
        NavigationBarItemColors navigationBarItemColors = new NavigationBarItemColors(selectedIconColor2, selectedTextColor2, indicatorColor2, unselectedIconColor2, unselectedTextColor2, jM3947copywmQWz5c, Color.m3947copywmQWz5c(unselectedTextColor3, (14 & 1) != 0 ? Color.m3951getAlphaimpl(unselectedTextColor3) : 0.38f, (14 & 2) != 0 ? Color.m3955getRedimpl(unselectedTextColor3) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(unselectedTextColor3) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(unselectedTextColor3) : 0.0f), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return navigationBarItemColors;
    }
}
