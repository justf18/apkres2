package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: Divider.kt */
@Metadata(m164d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, m165d2 = {"DividerAlpha", "", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "thickness", "Landroidx/compose/ui/unit/Dp;", "startIndent", "Divider-oMI9zvI", "(Landroidx/compose/ui/Modifier;JFFLandroidx/compose/runtime/Composer;II)V", "material_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DividerKt {
    private static final float DividerAlpha = 0.12f;

    /* renamed from: Divider-oMI9zvI, reason: not valid java name */
    public static final void m1531DivideroMI9zvI(Modifier modifier, long color, float thickness, float startIndent, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        float thickness2;
        float startIndent2;
        Modifier.Companion modifier3;
        long color2;
        int i2;
        Modifier.Companion indentMod;
        float targetThickness;
        final Modifier modifier4;
        final long color3;
        final float thickness3;
        final float startIndent3;
        Composer $composer2 = $composer.startRestartGroup(-1249392198);
        ComposerKt.sourceInformation($composer2, "C(Divider)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,2:c#ui.unit.Dp)45@1819L6,59@2200L147:Divider.kt#jmzs0o");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                int i4 = $composer2.changed(j) ? 32 : 16;
                $dirty |= i4;
            } else {
                j = color;
            }
            $dirty |= i4;
        } else {
            j = color;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            thickness2 = thickness;
        } else if (($changed & 896) == 0) {
            thickness2 = thickness;
            $dirty |= $composer2.changed(thickness2) ? 256 : 128;
        } else {
            thickness2 = thickness;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            startIndent2 = startIndent;
        } else if (($changed & 7168) == 0) {
            startIndent2 = startIndent;
            $dirty |= $composer2.changed(startIndent2) ? 2048 : 1024;
        } else {
            startIndent2 = startIndent;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            color3 = j;
            thickness3 = thickness2;
            startIndent3 = startIndent2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    long jM1489getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer2, 6).m1489getOnSurface0d7_KjU();
                    color2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU) : 0.12f, (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU) : 0.0f);
                    $dirty &= -113;
                } else {
                    color2 = j;
                }
                if (i5 != 0) {
                    thickness2 = C1956Dp.m6297constructorimpl(1);
                }
                if (i6 != 0) {
                    startIndent2 = C1956Dp.m6297constructorimpl(0);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                modifier3 = modifier2;
                color2 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1249392198, $dirty, -1, "androidx.compose.material.Divider (Divider.kt:48)");
            }
            if (startIndent2 == 0.0f) {
                i2 = 1;
                indentMod = Modifier.INSTANCE;
            } else {
                i2 = 1;
                indentMod = PaddingKt.m771paddingqDBjuR0$default(Modifier.INSTANCE, startIndent2, 0.0f, 0.0f, 0.0f, 14, null);
            }
            $composer2.startReplaceableGroup(1228914189);
            ComposerKt.sourceInformation($composer2, "*55@2139L7");
            if (C1956Dp.m6302equalsimpl0(thickness2, C1956Dp.INSTANCE.m6315getHairlineD9Ej5fM())) {
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                float $this$dp$iv = 1.0f / ((Density) objConsume).getDensity();
                targetThickness = C1956Dp.m6297constructorimpl($this$dp$iv);
            } else {
                targetThickness = thickness2;
            }
            $composer2.endReplaceableGroup();
            BoxKt.Box(BackgroundKt.m415backgroundbw27NRU$default(SizeKt.m802height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3.then(indentMod), 0.0f, i2, null), targetThickness), color2, null, 2, null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            thickness3 = thickness2;
            startIndent3 = startIndent2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DividerKt$Divider$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) {
                    DividerKt.m1531DivideroMI9zvI(modifier4, color3, thickness3, startIndent3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
