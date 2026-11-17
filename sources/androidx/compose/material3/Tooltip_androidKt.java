package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.CacheDrawScope;
import androidx.compose.p000ui.draw.DrawResult;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.AndroidPath_androidKt;
import androidx.compose.p000ui.graphics.Path;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutCoordinatesKt;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: Tooltip.android.kt */
@Metadata(m164d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aq\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a@\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, m165d2 = {"PlainTooltip", "", "Landroidx/compose/material3/CaretScope;", "modifier", "Landroidx/compose/ui/Modifier;", "caretProperties", "Landroidx/compose/material3/CaretProperties;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "PlainTooltip-Fg7CxbU", "(Landroidx/compose/material3/CaretScope;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CaretProperties;Landroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "drawCaretWithPath", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "density", "Landroidx/compose/ui/unit/Density;", "configuration", "Landroid/content/res/Configuration;", "anchorLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "drawCaretWithPath-Bx497Mc", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/unit/Density;Landroid/content/res/Configuration;JLandroidx/compose/material3/CaretProperties;Landroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/draw/DrawResult;", "material3_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Tooltip_androidKt {
    /* renamed from: PlainTooltip-Fg7CxbU, reason: not valid java name */
    public static final void m2811PlainTooltipFg7CxbU(final CaretScope $this$PlainTooltip_u2dFg7CxbU, Modifier modifier, CaretProperties caretProperties, Shape shape, long contentColor, long containerColor, float tonalElevation, float shadowElevation, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape shape2;
        long contentColor2;
        final long containerColor2;
        float tonalElevation2;
        Shape shape3;
        CaretProperties caretProperties2;
        int $dirty;
        final long contentColor3;
        Shape shape4;
        CaretProperties caretProperties3;
        float shadowElevation2;
        int i2;
        float tonalElevation3;
        int i3;
        int i4;
        int $dirty2;
        long containerColor3;
        CaretProperties caretProperties4;
        Modifier customModifier;
        Composer $composer2;
        final Modifier modifier3;
        final float tonalElevation4;
        final float shadowElevation3;
        final long contentColor4;
        final CaretProperties caretProperties5;
        final Shape shape5;
        Object value$iv;
        Composer $composer3 = $composer.startRestartGroup(419109811);
        ComposerKt.sourceInformation($composer3, "C(PlainTooltip)P(4!1,6,3:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)184@7877L26,184@7947L24,184@8017L26,83@3344L784:Tooltip.android.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= ($changed & 8) == 0 ? $composer3.changed($this$PlainTooltip_u2dFg7CxbU) : $composer3.changedInstance($this$PlainTooltip_u2dFg7CxbU) ? 4 : 2;
        }
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer3.changed(caretProperties) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 4) == 0) {
                shape2 = shape;
                int i7 = $composer3.changed(shape2) ? 2048 : 1024;
                $dirty3 |= i7;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i7;
        } else {
            shape2 = shape;
        }
        if (($changed & 24576) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i8 = $composer3.changed(contentColor2) ? 16384 : 8192;
                $dirty3 |= i8;
            } else {
                contentColor2 = contentColor;
            }
            $dirty3 |= i8;
        } else {
            contentColor2 = contentColor;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            if ((i & 16) == 0) {
                containerColor2 = containerColor;
                int i9 = $composer3.changed(containerColor2) ? 131072 : 65536;
                $dirty3 |= i9;
            } else {
                containerColor2 = containerColor;
            }
            $dirty3 |= i9;
        } else {
            containerColor2 = containerColor;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty3 |= 1572864;
            tonalElevation2 = tonalElevation;
        } else if (($changed & 1572864) == 0) {
            tonalElevation2 = tonalElevation;
            $dirty3 |= $composer3.changed(tonalElevation2) ? 1048576 : 524288;
        } else {
            tonalElevation2 = tonalElevation;
        }
        int i11 = i & 64;
        if (i11 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer3.changed(shadowElevation) ? 8388608 : 4194304;
        }
        if ((i & 128) != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty3 |= $composer3.changedInstance(function2) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & $dirty3) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
            shape5 = shape2;
            tonalElevation4 = tonalElevation2;
            contentColor4 = contentColor2;
            shadowElevation3 = shadowElevation;
            caretProperties5 = caretProperties;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                CaretProperties caretProperties6 = i6 != 0 ? null : caretProperties;
                if ((i & 4) != 0) {
                    shape3 = TooltipDefaults.INSTANCE.getPlainTooltipContainerShape($composer3, 6);
                    $dirty3 &= -7169;
                } else {
                    shape3 = shape2;
                }
                if ((i & 8) != 0) {
                    contentColor2 = TooltipDefaults.INSTANCE.getPlainTooltipContentColor($composer3, 6);
                    $dirty3 &= -57345;
                }
                if ((i & 16) != 0) {
                    containerColor2 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor($composer3, 6);
                    $dirty3 &= -458753;
                }
                if (i10 != 0) {
                    caretProperties2 = caretProperties6;
                    tonalElevation2 = C1956Dp.m6297constructorimpl(0);
                } else {
                    caretProperties2 = caretProperties6;
                }
                if (i11 != 0) {
                    Shape shape6 = shape3;
                    $dirty = $dirty3;
                    contentColor3 = contentColor2;
                    shape4 = shape6;
                    shadowElevation2 = C1956Dp.m6297constructorimpl(0);
                    i2 = 12582912;
                    caretProperties3 = caretProperties2;
                    tonalElevation3 = tonalElevation2;
                    i3 = 419109811;
                } else {
                    Shape shape7 = shape3;
                    $dirty = $dirty3;
                    contentColor3 = contentColor2;
                    shape4 = shape7;
                    caretProperties3 = caretProperties2;
                    shadowElevation2 = shadowElevation;
                    i2 = 12582912;
                    tonalElevation3 = tonalElevation2;
                    i3 = 419109811;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i & 8) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 16) != 0) {
                    shadowElevation2 = shadowElevation;
                    $dirty = $dirty3 & (-458753);
                    contentColor3 = contentColor2;
                    caretProperties3 = caretProperties;
                    shape4 = shape2;
                    i2 = 12582912;
                    tonalElevation3 = tonalElevation2;
                    i3 = 419109811;
                } else {
                    caretProperties3 = caretProperties;
                    shadowElevation2 = shadowElevation;
                    $dirty = $dirty3;
                    contentColor3 = contentColor2;
                    shape4 = shape2;
                    i2 = 12582912;
                    tonalElevation3 = tonalElevation2;
                    i3 = 419109811;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                i4 = i2;
                ComposerKt.traceEventStart(i3, $dirty, -1, "androidx.compose.material3.PlainTooltip (Tooltip.android.kt:67)");
            } else {
                i4 = i2;
            }
            $composer3.startReplaceableGroup(2067440203);
            ComposerKt.sourceInformation($composer3, "70@2893L7,71@2952L7,72@2991L308");
            if (caretProperties3 != null) {
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                final CaretProperties caretProperties7 = caretProperties3;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer3.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final Density density = (Density) objConsume;
                ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer3.consume(localConfiguration);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final Configuration configuration = (Configuration) objConsume2;
                Modifier.Companion companion = Modifier.INSTANCE;
                $composer3.startReplaceableGroup(2067440371);
                ComposerKt.sourceInformation($composer3, "CC(remember):Tooltip.android.kt#9igjgp");
                boolean invalid$iv = (((($dirty & 458752) ^ ProfileVerifier.CompilationStatus.f249xf2722a21) > 131072 && $composer3.changed(containerColor2)) || ($dirty & ProfileVerifier.CompilationStatus.f249xf2722a21) == 131072) | $composer3.changed(density) | $composer3.changedInstance(configuration) | (($dirty & 896) == 256);
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv) {
                    $dirty2 = $dirty;
                } else {
                    $dirty2 = $dirty;
                    if (it$iv != Composer.INSTANCE.getEmpty()) {
                        value$iv = it$iv;
                        containerColor3 = containerColor2;
                        caretProperties4 = caretProperties7;
                    }
                    $composer3.endReplaceableGroup();
                    customModifier = $this$PlainTooltip_u2dFg7CxbU.drawCaret(companion, (Function2) value$iv).then(modifier2);
                }
                final long containerColor4 = containerColor2;
                containerColor3 = containerColor4;
                caretProperties4 = caretProperties7;
                value$iv = (Function2) new Function2<CacheDrawScope, LayoutCoordinates, DrawResult>() { // from class: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$customModifier$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final DrawResult invoke(CacheDrawScope $this$drawCaret, LayoutCoordinates anchorLayoutCoordinates) {
                        return Tooltip_androidKt.m2813drawCaretWithPathBx497Mc($this$drawCaret, density, configuration, containerColor4, caretProperties7, anchorLayoutCoordinates);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                $composer3.endReplaceableGroup();
                customModifier = $this$PlainTooltip_u2dFg7CxbU.drawCaret(companion, (Function2) value$iv).then(modifier2);
            } else {
                $dirty2 = $dirty;
                containerColor3 = containerColor2;
                caretProperties4 = caretProperties3;
                customModifier = modifier2;
            }
            $composer3.endReplaceableGroup();
            long containerColor5 = containerColor3;
            $composer2 = $composer3;
            SurfaceKt.m2519SurfaceT9BRK9s(customModifier, shape4, containerColor5, 0L, tonalElevation3, shadowElevation2, null, ComposableLambdaKt.composableLambda($composer3, -705895688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:28:0x01bf  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r31, int r32) {
                    /*
                        Method dump skipped, instructions count: 451
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, (($dirty2 >> 6) & 112) | i4 | (($dirty2 >> 9) & 896) | (($dirty2 >> 6) & 57344) | (($dirty2 >> 6) & 458752), 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            tonalElevation4 = tonalElevation3;
            shadowElevation3 = shadowElevation2;
            contentColor4 = contentColor3;
            caretProperties5 = caretProperties4;
            shape5 = shape4;
            containerColor2 = containerColor5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$PlainTooltip$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i12) {
                    Tooltip_androidKt.m2811PlainTooltipFg7CxbU($this$PlainTooltip_u2dFg7CxbU, modifier3, caretProperties5, shape5, contentColor4, containerColor2, tonalElevation4, shadowElevation3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCaretWithPath-Bx497Mc, reason: not valid java name */
    public static final DrawResult m2813drawCaretWithPathBx497Mc(CacheDrawScope $this$drawCaretWithPath_u2dBx497Mc, Density density, Configuration configuration, final long containerColor, CaretProperties caretProperties, final LayoutCoordinates anchorLayoutCoordinates) {
        float anchorMidFromRightScreenEdge;
        long position;
        final Path path = AndroidPath_androidKt.Path();
        if (anchorLayoutCoordinates != null) {
            int caretHeightPx = density.mo512roundToPx0680j_4(caretProperties.m1841getCaretHeightD9Ej5fM());
            int caretWidthPx = density.mo512roundToPx0680j_4(caretProperties.m1842getCaretWidthD9Ej5fM());
            int $this$dp$iv = configuration.screenWidthDp;
            int screenWidthPx = density.mo512roundToPx0680j_4(C1956Dp.m6297constructorimpl($this$dp$iv));
            int tooltipAnchorSpacing = density.mo512roundToPx0680j_4(TooltipKt.getSpacingBetweenTooltipAndAnchor());
            Rect anchorBounds = LayoutCoordinatesKt.boundsInWindow(anchorLayoutCoordinates);
            float anchorLeft = anchorBounds.getLeft();
            float anchorRight = anchorBounds.getRight();
            float anchorTop = anchorBounds.getTop();
            float f = 2;
            float anchorMid = (anchorRight + anchorLeft) / f;
            float anchorWidth = anchorRight - anchorLeft;
            float tooltipWidth = Size.m3777getWidthimpl($this$drawCaretWithPath_u2dBx497Mc.m3615getSizeNHjbRc());
            float tooltipHeight = Size.m3774getHeightimpl($this$drawCaretWithPath_u2dBx497Mc.m3615getSizeNHjbRc());
            boolean isCaretTop = (anchorTop - tooltipHeight) - ((float) tooltipAnchorSpacing) < 0.0f;
            float caretY = isCaretTop ? 0.0f : tooltipHeight;
            if (anchorMid + (tooltipWidth / f) > screenWidthPx) {
                float caretX = tooltipWidth - (screenWidthPx - anchorMid);
                anchorMidFromRightScreenEdge = caretY;
                position = OffsetKt.Offset(caretX, anchorMidFromRightScreenEdge);
            } else {
                anchorMidFromRightScreenEdge = caretY;
                float tooltipLeft = anchorLeft - ((Size.m3777getWidthimpl($this$drawCaretWithPath_u2dBx497Mc.m3615getSizeNHjbRc()) / f) - (anchorWidth / f));
                float caretX2 = anchorMid - Math.max(tooltipLeft, 0.0f);
                position = OffsetKt.Offset(caretX2, anchorMidFromRightScreenEdge);
            }
            if (isCaretTop) {
                path.moveTo(Offset.m3708getXimpl(position), Offset.m3709getYimpl(position));
                path.lineTo(Offset.m3708getXimpl(position) + (caretWidthPx / 2), Offset.m3709getYimpl(position));
                path.lineTo(Offset.m3708getXimpl(position), Offset.m3709getYimpl(position) - caretHeightPx);
                path.lineTo(Offset.m3708getXimpl(position) - (caretWidthPx / 2), Offset.m3709getYimpl(position));
                path.close();
            } else {
                path.moveTo(Offset.m3708getXimpl(position), Offset.m3709getYimpl(position));
                path.lineTo(Offset.m3708getXimpl(position) + (caretWidthPx / 2), Offset.m3709getYimpl(position));
                path.lineTo(Offset.m3708getXimpl(position), Offset.m3709getYimpl(position) + caretHeightPx);
                path.lineTo(Offset.m3708getXimpl(position) - (caretWidthPx / 2), Offset.m3709getYimpl(position));
                path.close();
            }
        }
        return $this$drawCaretWithPath_u2dBx497Mc.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$drawCaretWithPath$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope $this$onDrawWithContent) {
                if (anchorLayoutCoordinates != null) {
                    $this$onDrawWithContent.drawContent();
                    DrawScope.m4489drawPathLG529CI$default($this$onDrawWithContent, path, containerColor, 0.0f, null, null, 0, 60, null);
                }
            }
        });
    }
}
