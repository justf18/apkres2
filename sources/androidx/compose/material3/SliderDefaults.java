package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.ShadowKt;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.ColorKt;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.StrokeCap;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Slider.kt */
@Metadata(m164d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0018J3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u001bJ3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u001eJ\r\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001fJv\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020!2\b\b\u0002\u0010&\u001a\u00020!2\b\b\u0002\u0010'\u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020!2\b\b\u0002\u0010*\u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,JN\u0010-\u001a\u00020\t*\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, m165d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "()V", "defaultSliderColors", "Landroidx/compose/material3/SliderColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSliderColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SliderColors;", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "rangeSliderState", "Landroidx/compose/material3/RangeSliderState;", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "sliderState", "Landroidx/compose/material3/SliderState;", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "tickFractions", "", "activeRangeStart", "", "activeRangeEnd", "drawTrack-LUBghH0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFJJJJ)V", "material3_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = new SliderDefaults();

    private SliderDefaults() {
    }

    public final SliderColors colors(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1376295968);
        ComposerKt.sourceInformation($composer, "C(colors)885@36081L11:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1376295968, $changed, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:885)");
        }
        SliderColors defaultSliderColors$material3_release = getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultSliderColors$material3_release;
    }

    /* renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m2411colorsq0g_0yA(long thumbColor, long activeTrackColor, long activeTickColor, long inactiveTrackColor, long inactiveTickColor, long disabledThumbColor, long disabledActiveTrackColor, long disabledActiveTickColor, long disabledInactiveTrackColor, long disabledInactiveTickColor, Composer $composer, int $changed, int $changed1, int i) {
        $composer.startReplaceableGroup(885588574);
        ComposerKt.sourceInformation($composer, "C(colors)P(9:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,8:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color)926@38380L11:Slider.kt#uh7d8r");
        long thumbColor2 = (i & 1) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : thumbColor;
        long activeTrackColor2 = (i & 2) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : activeTrackColor;
        long activeTickColor2 = (i & 4) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : activeTickColor;
        long inactiveTrackColor2 = (i & 8) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : inactiveTrackColor;
        long inactiveTickColor2 = (i & 16) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : inactiveTickColor;
        long disabledThumbColor2 = (i & 32) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : disabledThumbColor;
        long disabledActiveTrackColor2 = (i & 64) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : disabledActiveTrackColor;
        long disabledActiveTickColor2 = (i & 128) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : disabledActiveTickColor;
        long disabledInactiveTrackColor2 = (i & 256) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : disabledInactiveTrackColor;
        long disabledInactiveTickColor2 = (i & 512) != 0 ? Color.INSTANCE.m3985getUnspecified0d7_KjU() : disabledInactiveTickColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885588574, $changed, $changed1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:926)");
        }
        SliderColors sliderColorsM2394copyK518z4 = getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m2394copyK518z4(thumbColor2, activeTrackColor2, activeTickColor2, inactiveTrackColor2, inactiveTickColor2, disabledThumbColor2, disabledActiveTrackColor2, disabledActiveTickColor2, disabledInactiveTrackColor2, disabledInactiveTickColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return sliderColorsM2394copyK518z4;
    }

    public final SliderColors getDefaultSliderColors$material3_release(ColorScheme $this$defaultSliderColors) {
        SliderColors defaultSliderColorsCached = $this$defaultSliderColors.getDefaultSliderColorsCached();
        if (defaultSliderColorsCached == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getHandleColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getActiveTrackColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getTickMarksActiveContainerColor());
            long jM3947copywmQWz5c = Color.m3947copywmQWz5c(jFromToken3, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jFromToken3) : 0.38f, (14 & 2) != 0 ? Color.m3955getRedimpl(jFromToken3) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jFromToken3) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jFromToken3) : 0.0f);
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getInactiveTrackColor());
            long jFromToken5 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getTickMarksInactiveContainerColor());
            long jM3947copywmQWz5c2 = Color.m3947copywmQWz5c(jFromToken5, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jFromToken5) : 0.38f, (14 & 2) != 0 ? Color.m3955getRedimpl(jFromToken5) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jFromToken5) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jFromToken5) : 0.0f);
            long jFromToken6 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getDisabledHandleColor());
            long jM3994compositeOverOWjLjI = ColorKt.m3994compositeOverOWjLjI(Color.m3947copywmQWz5c(jFromToken6, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jFromToken6) : 0.38f, (14 & 2) != 0 ? Color.m3955getRedimpl(jFromToken6) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jFromToken6) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jFromToken6) : 0.0f), $this$defaultSliderColors.getSurface());
            long jFromToken7 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getDisabledActiveTrackColor());
            long jM3947copywmQWz5c3 = Color.m3947copywmQWz5c(jFromToken7, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jFromToken7) : 0.38f, (14 & 2) != 0 ? Color.m3955getRedimpl(jFromToken7) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jFromToken7) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jFromToken7) : 0.0f);
            long jFromToken8 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getTickMarksDisabledContainerColor());
            long jM3947copywmQWz5c4 = Color.m3947copywmQWz5c(jFromToken8, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jFromToken8) : 0.38f, (14 & 2) != 0 ? Color.m3955getRedimpl(jFromToken8) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jFromToken8) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jFromToken8) : 0.0f);
            long jFromToken9 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getDisabledInactiveTrackColor());
            long jM3947copywmQWz5c5 = Color.m3947copywmQWz5c(jFromToken9, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jFromToken9) : 0.12f, (14 & 2) != 0 ? Color.m3955getRedimpl(jFromToken9) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jFromToken9) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jFromToken9) : 0.0f);
            long jFromToken10 = ColorSchemeKt.fromToken($this$defaultSliderColors, SliderTokens.INSTANCE.getTickMarksDisabledContainerColor());
            SliderColors it = new SliderColors(jFromToken, jFromToken2, jM3947copywmQWz5c, jFromToken4, jM3947copywmQWz5c2, jM3994compositeOverOWjLjI, jM3947copywmQWz5c3, jM3947copywmQWz5c4, jM3947copywmQWz5c5, Color.m3947copywmQWz5c(jFromToken10, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jFromToken10) : 0.38f, (14 & 2) != 0 ? Color.m3955getRedimpl(jFromToken10) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jFromToken10) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jFromToken10) : 0.0f), null);
            $this$defaultSliderColors.setDefaultSliderColorsCached$material3_release(it);
            return it;
        }
        return defaultSliderColorsCached;
    }

    /* renamed from: Thumb-9LiSoMs, reason: not valid java name */
    public final void m2410Thumb9LiSoMs(final MutableInteractionSource interactionSource, Modifier modifier, SliderColors colors, boolean enabled, long thumbSize, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        SliderColors colors2;
        boolean enabled2;
        long j;
        int $dirty;
        SliderColors colors3;
        boolean enabled3;
        long thumbSize2;
        Object value$iv;
        SliderDefaults$Thumb$1$1 value$iv2;
        final boolean enabled4;
        final SliderColors colors4;
        final Modifier modifier3;
        final long thumbSize3;
        Composer $composer2 = $composer.startRestartGroup(-290277409);
        ComposerKt.sourceInformation($composer2, "C(Thumb)P(2,3!,4:c#ui.unit.DpSize)982@41514L8,986@41630L46,987@41719L658,987@41685L692,1005@42576L5,1013@42846L143,1008@42630L595:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                colors2 = colors;
                int i3 = $composer2.changed(colors2) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i3;
        } else {
            colors2 = colors;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            j = thumbSize;
        } else if (($changed & 24576) == 0) {
            j = thumbSize;
            $dirty2 |= $composer2.changed(j) ? 16384 : 8192;
        } else {
            j = thumbSize;
        }
        if ((i & 32) != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            $dirty2 |= $composer2.changed(this) ? 131072 : 65536;
        }
        if (($dirty2 & 74899) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            colors4 = colors2;
            enabled4 = enabled2;
            thumbSize3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    SliderColors colors5 = colors($composer2, ($dirty2 >> 15) & 14);
                    $dirty2 &= -897;
                    colors2 = colors5;
                }
                if (i4 != 0) {
                    enabled2 = true;
                }
                if (i5 != 0) {
                    SliderColors sliderColors = colors2;
                    $dirty = $dirty2;
                    colors3 = sliderColors;
                    thumbSize2 = SliderKt.ThumbSize;
                    enabled3 = enabled2;
                } else {
                    SliderColors sliderColors2 = colors2;
                    $dirty = $dirty2;
                    colors3 = sliderColors2;
                    enabled3 = enabled2;
                    thumbSize2 = j;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                SliderColors sliderColors3 = colors2;
                $dirty = $dirty2;
                colors3 = sliderColors3;
                enabled3 = enabled2;
                thumbSize2 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290277409, $dirty, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:985)");
            }
            $composer2.startReplaceableGroup(-1142853216);
            ComposerKt.sourceInformation($composer2, "CC(remember):Slider.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt.mutableStateListOf();
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            SnapshotStateList interactions = (SnapshotStateList) value$iv;
            $composer2.endReplaceableGroup();
            $composer2.startReplaceableGroup(-1142853127);
            ComposerKt.sourceInformation($composer2, "CC(remember):Slider.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv2 = $composer2.rememberedValue();
            int $dirty3 = $dirty;
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new SliderDefaults$Thumb$1$1(interactionSource, interactions, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer2, $dirty3 & 14);
            float elevation = !interactions.isEmpty() ? SliderKt.ThumbPressedElevation : SliderKt.ThumbDefaultElevation;
            Shape shape = ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), $composer2, 6);
            float arg0$iv = SliderTokens.INSTANCE.m3336getStateLayerSizeD9Ej5fM();
            long thumbSize4 = thumbSize2;
            SpacerKt.Spacer(BackgroundKt.m414backgroundbw27NRU(ShadowKt.m3621shadows4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m817size6HolHcs(modifier2, thumbSize2), interactionSource, RippleKt.m1756rememberRipple9IZ8Weo(false, C1956Dp.m6297constructorimpl(arg0$iv / 2), 0L, $composer2, 54, 4)), interactionSource, false, 2, null), enabled3 ? elevation : C1956Dp.m6297constructorimpl(0), shape, false, 0L, 0L, 24, null), colors3.m2405thumbColorvNxB06k$material3_release(enabled3), shape), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            enabled4 = enabled3;
            colors4 = colors3;
            modifier3 = modifier2;
            thumbSize3 = thumbSize4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Thumb$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    this.$tmp2_rcvr.m2410Thumb9LiSoMs(interactionSource, modifier3, colors4, enabled4, thumbSize3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x0190  */
    @kotlin.Deprecated(message = "Use version that supports slider state")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Track(final androidx.compose.material3.SliderPositions r26, androidx.compose.p000ui.Modifier r27, androidx.compose.material3.SliderColors r28, boolean r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.Track(androidx.compose.material3.SliderPositions, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x018f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Track(final androidx.compose.material3.SliderState r25, androidx.compose.p000ui.Modifier r26, androidx.compose.material3.SliderColors r27, boolean r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.Track(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x018f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Track(final androidx.compose.material3.RangeSliderState r25, androidx.compose.p000ui.Modifier r26, androidx.compose.material3.SliderColors r27, boolean r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.Track(androidx.compose.material3.RangeSliderState, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawTrack-LUBghH0, reason: not valid java name */
    public final void m2409drawTrackLUBghH0(DrawScope $this$drawTrack_u2dLUBghH0, float[] tickFractions, float activeRangeStart, float activeRangeEnd, long inactiveTrackColor, long activeTrackColor, long inactiveTickColor, long activeTickColor) {
        boolean isRtl = $this$drawTrack_u2dLUBghH0.getLayoutDirection() == LayoutDirection.Rtl;
        long sliderLeft = OffsetKt.Offset(0.0f, Offset.m3709getYimpl($this$drawTrack_u2dLUBghH0.mo4497getCenterF1C5BW0()));
        long sliderRight = OffsetKt.Offset(Size.m3777getWidthimpl($this$drawTrack_u2dLUBghH0.mo4498getSizeNHjbRc()), Offset.m3709getYimpl($this$drawTrack_u2dLUBghH0.mo4497getCenterF1C5BW0()));
        long sliderStart = isRtl ? sliderRight : sliderLeft;
        long sliderEnd = isRtl ? sliderLeft : sliderRight;
        float tickSize = $this$drawTrack_u2dLUBghH0.mo518toPx0680j_4(SliderKt.TickSize);
        float trackStrokeWidth = $this$drawTrack_u2dLUBghH0.mo518toPx0680j_4(SliderKt.getTrackHeight());
        DrawScope.m4485drawLineNGM6Ib0$default($this$drawTrack_u2dLUBghH0, inactiveTrackColor, sliderStart, sliderEnd, trackStrokeWidth, StrokeCap.INSTANCE.m4302getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
        long sliderValueEnd = OffsetKt.Offset(Offset.m3708getXimpl(sliderStart) + ((Offset.m3708getXimpl(sliderEnd) - Offset.m3708getXimpl(sliderStart)) * activeRangeEnd), Offset.m3709getYimpl($this$drawTrack_u2dLUBghH0.mo4497getCenterF1C5BW0()));
        long sliderValueStart = OffsetKt.Offset(Offset.m3708getXimpl(sliderStart) + ((Offset.m3708getXimpl(sliderEnd) - Offset.m3708getXimpl(sliderStart)) * activeRangeStart), Offset.m3709getYimpl($this$drawTrack_u2dLUBghH0.mo4497getCenterF1C5BW0()));
        long sliderStart2 = sliderStart;
        long sliderEnd2 = sliderEnd;
        DrawScope.m4485drawLineNGM6Ib0$default($this$drawTrack_u2dLUBghH0, activeTrackColor, sliderValueStart, sliderValueEnd, trackStrokeWidth, StrokeCap.INSTANCE.m4302getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
        int i = 0;
        for (int length = tickFractions.length; i < length; length = length) {
            float tick = tickFractions[i];
            boolean outsideFraction = tick > activeRangeEnd || tick < activeRangeStart;
            long sliderEnd3 = sliderEnd2;
            sliderEnd2 = sliderEnd3;
            DrawScope.m4480drawCircleVaOC9Bg$default($this$drawTrack_u2dLUBghH0, outsideFraction ? inactiveTickColor : activeTickColor, tickSize / 2.0f, OffsetKt.Offset(Offset.m3708getXimpl(OffsetKt.m3731lerpWko1d7g(sliderStart2, sliderEnd3, tick)), Offset.m3709getYimpl($this$drawTrack_u2dLUBghH0.mo4497getCenterF1C5BW0())), 0.0f, null, null, 0, 120, null);
            i++;
        }
    }
}
