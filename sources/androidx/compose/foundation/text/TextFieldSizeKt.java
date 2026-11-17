package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.layout.LayoutModifierKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.TextStyleKt;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.font.FontStyle;
import androidx.compose.p000ui.text.font.FontSynthesis;
import androidx.compose.p000ui.text.font.FontWeight;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* compiled from: TextFieldSize.kt */
@Metadata(m164d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004²\u0006\n\u0010\u0005\u001a\u00020\u0006X\u008a\u0084\u0002"}, m165d2 = {"textFieldMinSize", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "foundation_release", "typeface", ""}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldSizeKt {
    public static final Modifier textFieldMinSize(Modifier $this$textFieldMinSize, final TextStyle style) {
        return ComposedModifierKt.composed$default($this$textFieldMinSize, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt.textFieldMinSize.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
                Object value$iv$iv;
                TextStyle resolvedStyle;
                Object value$iv$iv2;
                Object value$iv$iv3;
                $composer.startReplaceableGroup(1582736677);
                ComposerKt.sourceInformation($composer, "C38@1591L7,39@1652L7,40@1707L7,42@1740L88,45@1849L312,54@2186L101:TextFieldSize.kt#423gt5");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1582736677, $changed, -1, "androidx.compose.foundation.text.textFieldMinSize.<anonymous> (TextFieldSize.kt:38)");
                }
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Density density = (Density) objConsume;
                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = $composer.consume(localFontFamilyResolver);
                ComposerKt.sourceInformationMarkerEnd($composer);
                FontFamily.Resolver fontFamilyResolver = (FontFamily.Resolver) objConsume2;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = $composer.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd($composer);
                LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
                Object key1$iv = style;
                TextStyle textStyle = style;
                $composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(key1$iv) | $composer.changed(layoutDirection);
                Object it$iv$iv = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                Object key1$iv2 = value$iv$iv;
                TextStyle resolvedStyle2 = (TextStyle) key1$iv2;
                $composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer.changed(fontFamilyResolver) | $composer.changed(resolvedStyle2);
                Object it$iv$iv2 = $composer.rememberedValue();
                if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    FontFamily fontFamily = resolvedStyle2.getFontFamily();
                    FontWeight fontWeight = resolvedStyle2.getFontWeight();
                    if (fontWeight == null) {
                        fontWeight = FontWeight.INSTANCE.getNormal();
                    }
                    resolvedStyle = resolvedStyle2;
                    FontWeight fontWeight2 = fontWeight;
                    FontStyle fontStyleM5806getFontStyle4Lr2A7w = resolvedStyle.m5806getFontStyle4Lr2A7w();
                    int $changed$iv = fontStyleM5806getFontStyle4Lr2A7w != null ? fontStyleM5806getFontStyle4Lr2A7w.m5886unboximpl() : FontStyle.INSTANCE.m5890getNormal_LCdwA();
                    FontSynthesis fontSynthesisM5807getFontSynthesisZQGJjVo = resolvedStyle.m5807getFontSynthesisZQGJjVo();
                    int $i$f$remember = fontSynthesisM5807getFontSynthesisZQGJjVo != null ? fontSynthesisM5807getFontSynthesisZQGJjVo.getValue() : FontSynthesis.INSTANCE.m5900getAllGVVA2EU();
                    value$iv$iv2 = fontFamilyResolver.mo5858resolveDPcqOEQ(fontFamily, fontWeight2, $changed$iv, $i$f$remember);
                    $composer.updateRememberedValue(value$iv$iv2);
                } else {
                    resolvedStyle = resolvedStyle2;
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer.endReplaceableGroup();
                State typeface$delegate = (State) value$iv$iv2;
                TextStyle textStyle2 = style;
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
                Object it$iv$iv3 = $composer.rememberedValue();
                if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv3 = new TextFieldSize(layoutDirection, density, fontFamilyResolver, textStyle2, typeface$delegate.getValue());
                    $composer.updateRememberedValue(value$iv$iv3);
                } else {
                    value$iv$iv3 = it$iv$iv3;
                }
                $composer.endReplaceableGroup();
                final TextFieldSize minSizeState = (TextFieldSize) value$iv$iv3;
                minSizeState.update(layoutDirection, density, fontFamilyResolver, resolvedStyle, typeface$delegate.getValue());
                Modifier modifierLayout = LayoutModifierKt.layout(Modifier.INSTANCE, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt.textFieldMinSize.1.1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m1134invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m1134invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                        SizeKt.m801defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, 0.0f, 3, null);
                        long minSize = minSizeState.getMinSize();
                        long childConstraints = Constraints.m6243copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(constraints) : RangesKt.coerceIn(IntSize.m6467getWidthimpl(minSize), Constraints.m6255getMinWidthimpl(constraints), Constraints.m6253getMaxWidthimpl(constraints)), (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(constraints) : RangesKt.coerceIn(IntSize.m6466getHeightimpl(minSize), Constraints.m6254getMinHeightimpl(constraints), Constraints.m6252getMaxHeightimpl(constraints)), (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(constraints) : 0);
                        final Placeable measured = measurable.mo5219measureBRTryo0(childConstraints);
                        return MeasureScope.layout$default($this$layout, measured.getWidth(), measured.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt.textFieldMinSize.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout2) {
                                Placeable.PlacementScope.placeRelative$default($this$layout2, measured, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                });
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return modifierLayout;
            }
        }, 1, null);
    }
}
