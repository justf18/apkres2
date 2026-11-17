package androidx.compose.material;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.colorspace.ColorSpace;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.style.TextAlign;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.TextUnitKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tab.kt */
@Metadata(m164d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0080\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0088\u0001\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001ax\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100&¢\u0006\u0002\b\u0016¢\u0006\u0002\b(H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a7\u0010+\u001a\u00020\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0002\u0010,\u001a=\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aD\u00102\u001a\u00020\u0010*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0002\u001a\u001c\u0010=\u001a\u00020\u0010*\u0002032\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u000bH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006?²\u0006\n\u0010@\u001a\u00020\u001eX\u008a\u0084\u0002"}, m165d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "LeadingIconTab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "Tab", "Tab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-EVJuX4I", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material_release", TypedValues.Custom.S_COLOR}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TabKt {
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float SmallTabHeight = C1956Dp.m6297constructorimpl(48);
    private static final float LargeTabHeight = C1956Dp.m6297constructorimpl(72);
    private static final float HorizontalTextPadding = C1956Dp.m6297constructorimpl(16);
    private static final float SingleLineTextBaselineWithIcon = C1956Dp.m6297constructorimpl(14);
    private static final float DoubleLineTextBaselineWithIcon = C1956Dp.m6297constructorimpl(6);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = C1956Dp.m6297constructorimpl(8);

    /* renamed from: Tab-0nD-MI0, reason: not valid java name */
    public static final void m1686Tab0nDMI0(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, final int $changed, final int i) {
        boolean z;
        Function0<Unit> function02;
        Modifier modifier2;
        boolean enabled2;
        final Function2 text;
        int i2;
        final Function2 icon;
        int i3;
        MutableInteractionSource interactionSource2;
        int $dirty;
        int i4;
        int i5;
        int i6;
        int i7;
        long selectedContentColor2;
        Modifier modifier3;
        int i8;
        int i9;
        int $dirty2;
        long selectedContentColor3;
        int i10;
        long unselectedContentColor2;
        boolean enabled3;
        MutableInteractionSource interactionSource3;
        Object value$iv$iv;
        Composer $composer2;
        final Function2 icon2;
        final Function2 text2;
        final Modifier modifier4;
        final boolean enabled4;
        final MutableInteractionSource interactionSource4;
        final long selectedContentColor4;
        final long unselectedContentColor3;
        int $dirty3;
        Composer $composer3 = $composer.startRestartGroup(-1486097588);
        ComposerKt.sourceInformation($composer3, "C(Tab)P(5,4,3!1,7!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)97@4392L39,98@4485L7,99@4577L6,107@4834L234:Tab.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
            z = selected;
        } else if (($changed & 14) == 0) {
            z = selected;
            $dirty4 |= $composer3.changed(z) ? 4 : 2;
        } else {
            z = selected;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
            function02 = function0;
        } else if (($changed & 112) == 0) {
            function02 = function0;
            $dirty4 |= $composer3.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        int i11 = i & 4;
        if (i11 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i12 = i & 8;
        if (i12 != 0) {
            $dirty4 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 7168) == 0) {
            enabled2 = enabled;
            $dirty4 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i13 = i & 16;
        if (i13 != 0) {
            $dirty4 |= 24576;
            text = function2;
        } else if (($changed & 57344) == 0) {
            text = function2;
            $dirty4 |= $composer3.changedInstance(text) ? 16384 : 8192;
        } else {
            text = function2;
        }
        int i14 = i & 32;
        if (i14 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            i2 = 57344;
            icon = function22;
        } else if (($changed & 458752) == 0) {
            i2 = 57344;
            icon = function22;
            $dirty4 |= $composer3.changedInstance(icon) ? 131072 : 65536;
        } else {
            i2 = 57344;
            icon = function22;
        }
        int i15 = i & 64;
        if (i15 != 0) {
            $dirty4 |= 1572864;
            i3 = 458752;
            interactionSource2 = interactionSource;
        } else if (($changed & 3670016) == 0) {
            i3 = 458752;
            interactionSource2 = interactionSource;
            $dirty4 |= $composer3.changed(interactionSource2) ? 1048576 : 524288;
        } else {
            i3 = 458752;
            interactionSource2 = interactionSource;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                $dirty3 = $dirty4;
                i4 = i11;
                int i16 = $composer3.changed(selectedContentColor) ? 8388608 : 4194304;
                $dirty = $dirty3 | i16;
            } else {
                $dirty3 = $dirty4;
                i4 = i11;
            }
            $dirty = $dirty3 | i16;
        } else {
            $dirty = $dirty4;
            i4 = i11;
        }
        if (($changed & 234881024) == 0) {
            i5 = i4;
            $dirty |= ((i & 256) == 0 && $composer3.changed(unselectedContentColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i5 = i4;
        }
        if (($dirty & 191739611) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            enabled4 = enabled2;
            icon2 = icon;
            text2 = text;
            interactionSource4 = interactionSource2;
            selectedContentColor4 = selectedContentColor;
            unselectedContentColor3 = unselectedContentColor;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i12 != 0) {
                    enabled2 = true;
                }
                if (i13 != 0) {
                    text = null;
                }
                if (i14 != 0) {
                    icon = null;
                }
                if (i15 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    i6 = -234881025;
                    Object it$iv$iv = $composer3.rememberedValue();
                    i7 = -29360129;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    i6 = -234881025;
                    i7 = -29360129;
                }
                if ((i & 128) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $dirty &= i7;
                    selectedContentColor2 = ((Color) objConsume).m3959unboximpl();
                } else {
                    selectedContentColor2 = selectedContentColor;
                }
                if ((i & 256) != 0) {
                    $dirty2 = $dirty & i6;
                    modifier3 = modifier2;
                    selectedContentColor3 = selectedContentColor2;
                    i10 = -1486097588;
                    unselectedContentColor2 = Color.m3947copywmQWz5c(selectedContentColor2, (14 & 1) != 0 ? Color.m3951getAlphaimpl(selectedContentColor2) : ContentAlpha.INSTANCE.getMedium($composer3, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(selectedContentColor2) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(selectedContentColor2) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(selectedContentColor2) : 0.0f);
                    i8 = 3670016;
                    i9 = i3;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                } else {
                    modifier3 = modifier2;
                    i8 = 3670016;
                    i9 = i3;
                    $dirty2 = $dirty;
                    selectedContentColor3 = selectedContentColor2;
                    i10 = -1486097588;
                    unselectedContentColor2 = unselectedContentColor;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty2 = $dirty & (-234881025);
                    selectedContentColor3 = selectedContentColor;
                    unselectedContentColor2 = unselectedContentColor;
                    modifier3 = modifier2;
                    i8 = 3670016;
                    i9 = i3;
                    i10 = -1486097588;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                } else {
                    unselectedContentColor2 = unselectedContentColor;
                    modifier3 = modifier2;
                    i8 = 3670016;
                    i9 = i3;
                    $dirty2 = $dirty;
                    i10 = -1486097588;
                    selectedContentColor3 = selectedContentColor;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i10, $dirty2, -1, "androidx.compose.material.Tab (Tab.kt:100)");
            }
            final Function2 styledText = text != null ? ComposableLambdaKt.composableLambda($composer3, -1729014781, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$styledText$1$1
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

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C103@4709L10,104@4774L39:Tab.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1729014781, $changed2, -1, "androidx.compose.material.Tab.<anonymous>.<anonymous> (Tab.kt:103)");
                        }
                        TextStyle style = TextStyle.m5787copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer4, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6167getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
                        TextKt.ProvideTextStyle(style, text, $composer4, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }) : null;
            $composer2 = $composer3;
            m1687TabEVJuX4I(z, function02, modifier3, enabled3, interactionSource3, selectedContentColor3, unselectedContentColor2, ComposableLambdaKt.composableLambda($composer3, -178151495, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope $this$Tab, Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C116@5013L49:Tab.kt#jmzs0o");
                    if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-178151495, $changed2, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:116)");
                        }
                        TabKt.TabBaselineLayout(styledText, icon, $composer4, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, (i9 & ($dirty2 >> 6)) | 12582912 | ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (($dirty2 >> 6) & i2) | (i8 & ($dirty2 >> 6)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            icon2 = icon;
            text2 = text;
            modifier4 = modifier3;
            enabled4 = enabled3;
            interactionSource4 = interactionSource3;
            selectedContentColor4 = selectedContentColor3;
            unselectedContentColor3 = unselectedContentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$3
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

                public final void invoke(Composer composer, int i17) {
                    TabKt.m1686Tab0nDMI0(selected, function0, modifier4, enabled4, text2, icon2, interactionSource4, selectedContentColor4, unselectedContentColor3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: LeadingIconTab-0nD-MI0, reason: not valid java name */
    public static final void m1685LeadingIconTab0nDMI0(final boolean selected, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        int $dirty;
        int i2;
        long selectedContentColor2;
        long unselectedContentColor2;
        final boolean enabled3;
        final MutableInteractionSource interactionSource3;
        int $dirty2;
        final Modifier modifier3;
        Object value$iv$iv;
        Composer $composer2;
        final long unselectedContentColor3;
        final long selectedContentColor3;
        final Modifier modifier4;
        final MutableInteractionSource interactionSource4;
        final boolean enabled4;
        int $dirty3;
        Composer $composer3 = $composer.startRestartGroup(-1499861761);
        ComposerKt.sourceInformation($composer3, "C(LeadingIconTab)P(5,4,7,1,3!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)159@6956L39,160@7049L7,161@7141L6,166@7389L60,168@7455L929:Tab.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
            function02 = function0;
        } else if (($changed & 112) == 0) {
            function02 = function0;
            $dirty4 |= $composer3.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        if ((i & 4) != 0) {
            $dirty4 |= 384;
            function23 = function2;
        } else if (($changed & 896) == 0) {
            function23 = function2;
            $dirty4 |= $composer3.changedInstance(function23) ? 256 : 128;
        } else {
            function23 = function2;
        }
        if ((i & 8) != 0) {
            $dirty4 |= 3072;
            function24 = function22;
        } else if (($changed & 7168) == 0) {
            function24 = function22;
            $dirty4 |= $composer3.changedInstance(function24) ? 2048 : 1024;
        } else {
            function24 = function22;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty4 |= 24576;
            modifier2 = modifier;
        } else if ((57344 & $changed) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            enabled2 = enabled;
        } else if ((458752 & $changed) == 0) {
            enabled2 = enabled;
            $dirty4 |= $composer3.changed(enabled2) ? 131072 : 65536;
        } else {
            enabled2 = enabled;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty4 |= 1572864;
            interactionSource2 = interactionSource;
        } else if ((3670016 & $changed) == 0) {
            interactionSource2 = interactionSource;
            $dirty4 |= $composer3.changed(interactionSource2) ? 1048576 : 524288;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((29360128 & $changed) == 0) {
            if ((i & 128) == 0) {
                $dirty3 = $dirty4;
                int i6 = $composer3.changed(selectedContentColor) ? 8388608 : 4194304;
                $dirty = $dirty3 | i6;
            } else {
                $dirty3 = $dirty4;
            }
            $dirty = $dirty3 | i6;
        } else {
            $dirty = $dirty4;
        }
        if (($changed & 234881024) == 0) {
            $dirty |= ((i & 256) == 0 && $composer3.changed(unselectedContentColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((191739611 & $dirty) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier2;
            enabled4 = enabled2;
            interactionSource4 = interactionSource2;
            selectedContentColor3 = selectedContentColor;
            unselectedContentColor3 = unselectedContentColor;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    enabled2 = true;
                }
                if (i5 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    i2 = -29360129;
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    i2 = -29360129;
                }
                if ((i & 128) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $dirty &= i2;
                    selectedContentColor2 = ((Color) objConsume).m3959unboximpl();
                } else {
                    selectedContentColor2 = selectedContentColor;
                }
                if ((i & 256) != 0) {
                    unselectedContentColor2 = Color.m3947copywmQWz5c(selectedContentColor2, (14 & 1) != 0 ? Color.m3951getAlphaimpl(selectedContentColor2) : ContentAlpha.INSTANCE.getMedium($composer3, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(selectedContentColor2) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(selectedContentColor2) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(selectedContentColor2) : 0.0f);
                    $dirty2 = $dirty & (-234881025);
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                } else {
                    unselectedContentColor2 = unselectedContentColor;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty2 = $dirty & (-234881025);
                    selectedContentColor2 = selectedContentColor;
                    unselectedContentColor2 = unselectedContentColor;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                } else {
                    selectedContentColor2 = selectedContentColor;
                    unselectedContentColor2 = unselectedContentColor;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1499861761, $dirty2, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:162)");
            }
            long selectedContentColor4 = selectedContentColor2;
            final Indication ripple = RippleKt.m1756rememberRipple9IZ8Weo(true, 0.0f, selectedContentColor4, $composer3, (($dirty2 >> 15) & 896) | 6, 2);
            final Function0<Unit> function03 = function02;
            final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
            final Function2<? super Composer, ? super Integer, Unit> function26 = function24;
            m1688TabTransitionKlgxPg(selectedContentColor4, unselectedContentColor2, selected, ComposableLambdaKt.composableLambda($composer3, 866677691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$LeadingIconTab$2
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

                public final void invoke(Composer $composer4, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer4, "C169@7535L843:Tab.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(866677691, $changed2, -1, "androidx.compose.material.LeadingIconTab.<anonymous> (Tab.kt:169)");
                        }
                        Modifier modifier$iv = SizeKt.fillMaxWidth$default(PaddingKt.m769paddingVpY3zN4$default(SelectableKt.m1007selectableO2vRcR0(SizeKt.m802height3ABfNKs(modifier3, TabKt.SmallTabHeight), selected, interactionSource3, ripple, enabled3, Role.m5595boximpl(Role.INSTANCE.m5608getTabo7Vup1c()), function03), TabKt.HorizontalTextPadding, 0.0f, 2, null), 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function27 = function26;
                        Function2<Composer, Integer, Unit> function28 = function25;
                        $composer4.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        $composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3479constructorimpl($composer4);
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        $composer4.startReplaceableGroup(2058660585);
                        int i7 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i8 = ((432 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 106889785, "C185@8147L6,186@8166L59,187@8264L10,188@8329L39:Tab.kt#jmzs0o");
                        function27.invoke($composer4, 0);
                        SpacerKt.Spacer(SizeKt.m813requiredWidth3ABfNKs(Modifier.INSTANCE, TabKt.TextDistanceFromLeadingIcon), $composer4, 6);
                        TextStyle style = TextStyle.m5787copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer4, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6167getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
                        TextKt.ProvideTextStyle(style, function28, $composer4, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endReplaceableGroup();
                        $composer4.endNode();
                        $composer4.endReplaceableGroup();
                        $composer4.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, (($dirty2 >> 21) & 14) | 3072 | (($dirty2 >> 21) & 112) | (($dirty2 << 6) & 896));
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            unselectedContentColor3 = unselectedContentColor2;
            selectedContentColor3 = selectedContentColor4;
            modifier4 = modifier3;
            interactionSource4 = interactionSource3;
            enabled4 = enabled3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$LeadingIconTab$3
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

                public final void invoke(Composer composer, int i7) {
                    TabKt.m1685LeadingIconTab0nDMI0(selected, function0, function2, function22, modifier4, enabled4, interactionSource4, selectedContentColor3, unselectedContentColor3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: Tab-EVJuX4I, reason: not valid java name */
    public static final void m1687TabEVJuX4I(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        boolean z;
        Modifier modifier2;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        long j;
        int $dirty;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        long selectedContentColor2;
        final Modifier modifier3;
        final boolean enabled3;
        int $dirty2;
        long unselectedContentColor2;
        final MutableInteractionSource interactionSource3;
        Object value$iv$iv;
        Composer $composer2;
        final long selectedContentColor3;
        final long unselectedContentColor3;
        final Modifier modifier4;
        final MutableInteractionSource interactionSource4;
        final boolean enabled4;
        int $dirty3;
        Composer $composer3 = $composer.startRestartGroup(713679175);
        ComposerKt.sourceInformation($composer3, "C(Tab)P(5,4,3,1,2,6:c#ui.graphics.Color,7:c#ui.graphics.Color)228@10125L39,229@10218L7,230@10310L6,236@10604L60,238@10670L618:Tab.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
            z = selected;
        } else if (($changed & 14) == 0) {
            z = selected;
            $dirty4 |= $composer3.changed(z) ? 4 : 2;
        } else {
            z = selected;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty4 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 7168) == 0) {
            enabled2 = enabled;
            $dirty4 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty4 |= 24576;
            interactionSource2 = interactionSource;
        } else if ((57344 & $changed) == 0) {
            interactionSource2 = interactionSource;
            $dirty4 |= $composer3.changed(interactionSource2) ? 16384 : 8192;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                j = selectedContentColor;
                int i5 = $composer3.changed(j) ? 131072 : 65536;
                $dirty4 |= i5;
            } else {
                j = selectedContentColor;
            }
            $dirty4 |= i5;
        } else {
            j = selectedContentColor;
        }
        if ((3670016 & $changed) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                int i6 = $composer3.changed(unselectedContentColor) ? 1048576 : 524288;
                $dirty = $dirty3 | i6;
            } else {
                $dirty3 = $dirty4;
            }
            $dirty = $dirty3 | i6;
        } else {
            $dirty = $dirty4;
        }
        if ((i & 128) != 0) {
            $dirty |= 12582912;
            function32 = function3;
        } else if ((29360128 & $changed) == 0) {
            function32 = function3;
            $dirty |= $composer3.changedInstance(function32) ? 8388608 : 4194304;
        } else {
            function32 = function3;
        }
        if (($dirty & 23967451) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            long j2 = j;
            $composer2 = $composer3;
            selectedContentColor3 = j2;
            modifier4 = modifier2;
            enabled4 = enabled2;
            interactionSource4 = interactionSource2;
            unselectedContentColor3 = unselectedContentColor;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    enabled2 = true;
                }
                if (i4 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                }
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $dirty &= -458753;
                    selectedContentColor2 = ((Color) objConsume).m3959unboximpl();
                } else {
                    selectedContentColor2 = j;
                }
                if ((i & 64) != 0) {
                    int i7 = $dirty & (-3670017);
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                    $dirty2 = i7;
                    unselectedContentColor2 = Color.m3947copywmQWz5c(selectedContentColor2, (14 & 1) != 0 ? Color.m3951getAlphaimpl(selectedContentColor2) : ContentAlpha.INSTANCE.getMedium($composer3, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(selectedContentColor2) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(selectedContentColor2) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(selectedContentColor2) : 0.0f);
                } else {
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    $dirty2 = $dirty;
                    unselectedContentColor2 = unselectedContentColor;
                    interactionSource3 = interactionSource2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty2 = $dirty & (-3670017);
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                    selectedContentColor2 = j;
                    modifier3 = modifier2;
                    unselectedContentColor2 = unselectedContentColor;
                } else {
                    enabled3 = enabled2;
                    selectedContentColor2 = j;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                    interactionSource3 = interactionSource2;
                    unselectedContentColor2 = unselectedContentColor;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(713679175, $dirty2, -1, "androidx.compose.material.Tab (Tab.kt:232)");
            }
            long selectedContentColor4 = selectedContentColor2;
            final Indication ripple = RippleKt.m1756rememberRipple9IZ8Weo(true, 0.0f, selectedContentColor4, $composer3, (($dirty2 >> 9) & 896) | 6, 2);
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33 = function32;
            final boolean z2 = z;
            m1688TabTransitionKlgxPg(selectedContentColor4, unselectedContentColor2, selected, ComposableLambdaKt.composableLambda($composer3, -1237246709, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$5
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

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C239@10750L532:Tab.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1237246709, $changed2, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:239)");
                        }
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1007selectableO2vRcR0(modifier3, z2, interactionSource3, ripple, enabled3, Role.m5595boximpl(Role.INSTANCE.m5608getTabo7Vup1c()), function0), 0.0f, 1, null);
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                        Function3 content$iv = function33;
                        $composer4.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation($composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(center, centerHorizontally, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        $composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifierFillMaxWidth$default);
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3479constructorimpl($composer4);
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        $composer4.startReplaceableGroup(2058660585);
                        int i8 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer4, Integer.valueOf(((432 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endReplaceableGroup();
                        $composer4.endNode();
                        $composer4.endReplaceableGroup();
                        $composer4.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, (($dirty2 << 6) & 896) | (($dirty2 >> 15) & 14) | 3072 | (($dirty2 >> 15) & 112));
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            selectedContentColor3 = selectedContentColor4;
            unselectedContentColor3 = unselectedContentColor2;
            modifier4 = modifier3;
            interactionSource4 = interactionSource3;
            enabled4 = enabled3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$6
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

                public final void invoke(Composer composer, int i8) {
                    TabKt.m1687TabEVJuX4I(selected, function0, modifier4, enabled4, interactionSource4, selectedContentColor3, unselectedContentColor3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabTransition-Klgx-Pg, reason: not valid java name */
    public static final void m1688TabTransitionKlgxPg(final long activeColor, final long inactiveColor, final boolean selected, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        long j;
        long j2;
        boolean z;
        int $dirty;
        Object value$iv$iv$iv;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-405571117);
        ComposerKt.sourceInformation($composer3, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)269@11719L26,270@11774L550,288@12329L164:Tab.kt#jmzs0o");
        int $dirty2 = $changed;
        if (($changed & 14) == 0) {
            j = activeColor;
            $dirty2 |= $composer3.changed(j) ? 4 : 2;
        } else {
            j = activeColor;
        }
        if (($changed & 112) == 0) {
            j2 = inactiveColor;
            $dirty2 |= $composer3.changed(j2) ? 32 : 16;
        } else {
            j2 = inactiveColor;
        }
        if (($changed & 896) == 0) {
            z = selected;
            $dirty2 |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = selected;
        }
        if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        if (($dirty2 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-405571117, $dirty2, -1, "androidx.compose.material.TabTransition (Tab.kt:268)");
            }
            Transition transition = TransitionKt.updateTransition(Boolean.valueOf(z), (String) null, $composer3, ($dirty2 >> 6) & 14, 2);
            Function3 transitionSpec$iv = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TabKt$TabTransition$color$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer $composer4, int $changed2) {
                    TweenSpec tweenSpecTween$default;
                    $composer4.startReplaceableGroup(-2120892502);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2120892502, $changed2, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:272)");
                    }
                    if (segment.isTransitioningTo(false, true)) {
                        tweenSpecTween$default = AnimationSpecKt.tween(150, 100, EasingKt.getLinearEasing());
                    } else {
                        tweenSpecTween$default = AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer4.endReplaceableGroup();
                    return tweenSpecTween$default;
                }
            };
            $composer3.startReplaceableGroup(-1939694975);
            ComposerKt.sourceInformation($composer3, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            int $changed2 = (0 >> 6) & 112;
            boolean it = ((Boolean) transition.getTargetState()).booleanValue();
            $composer3.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation($composer3, "C:Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                $dirty = $dirty2;
                ComposerKt.traceEventStart(1445938070, $changed2, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:286)");
            } else {
                $dirty = $dirty2;
            }
            long j3 = it ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer3.endReplaceableGroup();
            ColorSpace colorSpace$iv = Color.m3953getColorSpaceimpl(j3);
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv$iv = $composer3.changed(colorSpace$iv);
            Object it$iv$iv$iv = $composer3.rememberedValue();
            if (invalid$iv$iv$iv || it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv);
                $composer3.updateRememberedValue(value$iv$iv$iv);
            } else {
                value$iv$iv$iv = it$iv$iv$iv;
            }
            $composer3.endReplaceableGroup();
            TwoWayConverter typeConverter$iv = (TwoWayConverter) value$iv$iv$iv;
            int $changed$iv$iv = (0 & 14) | 64 | ((0 << 3) & 896) | ((0 << 3) & 7168) | ((0 << 3) & 57344);
            $composer3.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer3, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            boolean it2 = ((Boolean) transition.getCurrentState()).booleanValue();
            $composer3.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation($composer3, "C:Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445938070, $changed3, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:286)");
            }
            long j4 = it2 ? activeColor : inactiveColor;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer3.endReplaceableGroup();
            Object initialValue$iv$iv = Color.m3939boximpl(j4);
            int $changed4 = ($changed$iv$iv >> 9) & 112;
            boolean it3 = ((Boolean) transition.getTargetState()).booleanValue();
            $composer3.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation($composer3, "C:Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445938070, $changed4, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:286)");
            }
            long j5 = it3 ? activeColor : inactiveColor;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer3.endReplaceableGroup();
            Object targetValue$iv$iv = Color.m3939boximpl(j5);
            FiniteAnimationSpec<Color> animationSpec$iv$iv = transitionSpec$iv.invoke(transition.getSegment(), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            State color$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv, targetValue$iv$iv, animationSpec$iv$iv, typeConverter$iv, "ColorAnimation", $composer3, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            $composer2 = $composer3;
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            long jTabTransition_Klgx_Pg$lambda$5 = TabTransition_Klgx_Pg$lambda$5(color$delegate);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{localContentColor.provides(Color.m3939boximpl(Color.m3947copywmQWz5c(jTabTransition_Klgx_Pg$lambda$5, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jTabTransition_Klgx_Pg$lambda$5) : 1.0f, (14 & 2) != 0 ? Color.m3955getRedimpl(jTabTransition_Klgx_Pg$lambda$5) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jTabTransition_Klgx_Pg$lambda$5) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jTabTransition_Klgx_Pg$lambda$5) : 0.0f))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3951getAlphaimpl(TabTransition_Klgx_Pg$lambda$5(color$delegate))))}, function2, $composer2, (($dirty >> 6) & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$TabTransition$1
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

                public final void invoke(Composer composer, int i) {
                    TabKt.m1688TabTransitionKlgxPg(activeColor, inactiveColor, selected, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final long TabTransition_Klgx_Pg$lambda$5(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m3959unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x043a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TabBaselineLayout(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, final int r53) {
        /*
            Method dump skipped, instructions count: 1102
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.TabBaselineLayout(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope $this$placeTextOrIcon, Placeable textOrIconPlaceable, int tabHeight) {
        int contentY = (tabHeight - textOrIconPlaceable.getHeight()) / 2;
        Placeable.PlacementScope.placeRelative$default($this$placeTextOrIcon, textOrIconPlaceable, 0, contentY, 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope $this$placeTextAndIcon, Density density, Placeable textPlaceable, Placeable iconPlaceable, int tabWidth, int tabHeight, int firstBaseline, int lastBaseline) {
        float baselineOffset;
        if (firstBaseline == lastBaseline) {
            baselineOffset = SingleLineTextBaselineWithIcon;
        } else {
            baselineOffset = DoubleLineTextBaselineWithIcon;
        }
        int textOffset = density.mo512roundToPx0680j_4(baselineOffset) + density.mo512roundToPx0680j_4(TabRowDefaults.INSTANCE.m1696getIndicatorHeightD9Ej5fM());
        int iconOffset = (iconPlaceable.getHeight() + density.mo511roundToPxR2X_6o(IconDistanceFromBaseline)) - firstBaseline;
        int textPlaceableX = (tabWidth - textPlaceable.getWidth()) / 2;
        int textPlaceableY = (tabHeight - lastBaseline) - textOffset;
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, textPlaceable, textPlaceableX, textPlaceableY, 0.0f, 4, null);
        int iconPlaceableX = (tabWidth - iconPlaceable.getWidth()) / 2;
        int iconPlaceableY = textPlaceableY - iconOffset;
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, iconPlaceable, iconPlaceableX, iconPlaceableY, 0.0f, 4, null);
    }
}
