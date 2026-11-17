package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.LayoutModifierKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SegmentedButton.kt */
@Metadata(m164d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aD\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a3\u0010\u0011\u001a\u00020\u00062\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010\u0014\u001aD\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0010\u001a\u008f\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010&\u001a\u0089\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\u00162\u0006\u0010'\u001a\u00020\u001a2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\u0013\b\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010)\u001a\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+*\u00020-H\u0003¢\u0006\u0002\u0010.\u001a\"\u0010/\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, m165d2 = {"CheckedZIndexFactor", "", "IconSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "MultiChoiceSegmentedButtonRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "space", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "MultiChoiceSegmentedButtonRow-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SegmentedButtonContent", "icon", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SingleChoiceSegmentedButtonRow", "Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;", "SingleChoiceSegmentedButtonRow-uFdPcIQ", "SegmentedButton", "checked", "", "onCheckedChange", "shape", "Landroidx/compose/ui/graphics/Shape;", "enabled", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "label", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "selected", "onClick", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "interactionCountAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "interactionZIndex", "interactionCount", "material3_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SegmentedButtonKt {
    private static final float CheckedZIndexFactor = 5.0f;
    private static final float IconSpacing = C1956Dp.m6297constructorimpl(8);

    public static final void SegmentedButton(final MultiChoiceSegmentedButtonRowScope $this$SegmentedButton, final boolean checked, final Function1<? super Boolean, Unit> function1, final Shape shape, Modifier modifier, boolean enabled, SegmentedButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        SegmentedButtonColors colors2;
        BorderStroke border2;
        int i2;
        int i3;
        Modifier modifier3;
        MutableInteractionSource interactionSource2;
        Modifier modifier4;
        MutableInteractionSource interactionSource3;
        SegmentedButtonColors colors3;
        int $dirty;
        boolean enabled3;
        BorderStroke border3;
        final Function2 icon;
        Object value$iv;
        Composer $composer2;
        int $dirty2;
        final SegmentedButtonColors colors4;
        final boolean enabled4;
        final BorderStroke border4;
        final MutableInteractionSource interactionSource4;
        final Modifier modifier5;
        final Function2 icon2;
        Composer $composer3 = $composer.startRestartGroup(-1596038053);
        ComposerKt.sourceInformation($composer3, "C(SegmentedButton)P(1,8,9,7,3,2!1,5)134@6782L8,138@6959L39,144@7288L25,146@7319L585:SegmentedButton.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed($this$SegmentedButton) ? 4 : 2;
        }
        if ((i & 1) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changed(checked) ? 32 : 16;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer3.changed(shape) ? 2048 : 1024;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            enabled2 = enabled;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 131072 : 65536;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i6 = $composer3.changed(colors2) ? 1048576 : 524288;
                $dirty3 |= i6;
            } else {
                colors2 = colors;
            }
            $dirty3 |= i6;
        } else {
            colors2 = colors;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 64) == 0) {
                border2 = border;
                int i7 = $composer3.changed(border2) ? 8388608 : 4194304;
                $dirty3 |= i7;
            } else {
                border2 = border;
            }
            $dirty3 |= i7;
        } else {
            border2 = border;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 100663296;
            i2 = i8;
        } else if (($changed & 100663296) == 0) {
            i2 = i8;
            $dirty3 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i8;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty3 |= 805306368;
            i3 = i9;
        } else if (($changed & 805306368) == 0) {
            i3 = i9;
            $dirty3 |= $composer3.changedInstance(function2) ? 536870912 : 268435456;
        } else {
            i3 = i9;
        }
        if ((i & 512) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(function22) ? 4 : 2;
        }
        int $dirty12 = $dirty1;
        if ((306783379 & $dirty3) == 306783378 && ($dirty12 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            interactionSource4 = interactionSource;
            $composer2 = $composer3;
            $dirty2 = $dirty3;
            enabled4 = enabled2;
            border4 = border2;
            icon2 = function2;
            colors4 = colors2;
            modifier5 = modifier2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier6 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (i5 != 0) {
                    enabled2 = true;
                }
                if ((i & 32) != 0) {
                    colors2 = SegmentedButtonDefaults.INSTANCE.colors($composer3, 6);
                    $dirty3 &= -3670017;
                }
                if ((i & 64) != 0) {
                    border2 = SegmentedButtonDefaults.m2362borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, colors2.m2346borderColorWaAFU9c$material3_release(enabled2, checked), 0.0f, 2, null);
                    $dirty3 &= -29360129;
                }
                if (i2 != 0) {
                    $composer3.startReplaceableGroup(-773603666);
                    ComposerKt.sourceInformation($composer3, "CC(remember):SegmentedButton.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    modifier3 = modifier6;
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    $composer3.endReplaceableGroup();
                } else {
                    modifier3 = modifier6;
                    interactionSource2 = interactionSource;
                }
                if (i3 != 0) {
                    $dirty = $dirty3;
                    icon = ComposableLambdaKt.composableLambda($composer3, 970447394, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer4, int $changed2) {
                            ComposerKt.sourceInformation($composer4, "C139@7061L13:SegmentedButton.kt#uh7d8r");
                            if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(970447394, $changed2, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:139)");
                            }
                            SegmentedButtonDefaults.INSTANCE.Icon(checked, null, null, $composer4, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    modifier4 = modifier3;
                    interactionSource3 = interactionSource2;
                    colors3 = colors2;
                    enabled3 = enabled2;
                    border3 = border2;
                } else {
                    modifier4 = modifier3;
                    interactionSource3 = interactionSource2;
                    colors3 = colors2;
                    $dirty = $dirty3;
                    enabled3 = enabled2;
                    border3 = border2;
                    icon = function2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 64) != 0) {
                    int i10 = $dirty3 & (-29360129);
                    icon = function2;
                    $dirty = i10;
                    colors3 = colors2;
                    enabled3 = enabled2;
                    border3 = border2;
                    modifier4 = modifier2;
                    interactionSource3 = interactionSource;
                } else {
                    colors3 = colors2;
                    $dirty = $dirty3;
                    enabled3 = enabled2;
                    border3 = border2;
                    modifier4 = modifier2;
                    interactionSource3 = interactionSource;
                    icon = function2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1596038053, $dirty, $dirty12, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:141)");
            }
            long containerColor = colors3.m2347containerColorWaAFU9c$material3_release(enabled3, checked);
            long contentColor = colors3.m2348contentColorWaAFU9c$material3_release(enabled3, checked);
            State interactionCount = interactionCountAsState(interactionSource3, $composer3, ($dirty >> 24) & 14);
            Modifier modifier7 = modifier4;
            SegmentedButtonColors colors5 = colors3;
            Function2 icon3 = icon;
            $composer2 = $composer3;
            int $dirty4 = $dirty;
            SurfaceKt.m2521Surfaced85dljk(checked, function1, SizeKt.m800defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default($this$SegmentedButton, modifier4, 1.0f, false, 2, null), checked, interactionCount), ButtonDefaults.INSTANCE.m1818getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1817getMinHeightD9Ej5fM()), enabled3, shape, containerColor, contentColor, 0.0f, 0.0f, border3, interactionSource3, ComposableLambdaKt.composableLambda($composer3, 1635710341, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.3
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
                    ComposerKt.sourceInformation($composer4, "C163@7863L35:SegmentedButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1635710341, $changed2, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:163)");
                        }
                        SegmentedButtonKt.SegmentedButtonContent(icon, function22, $composer4, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 6) & 7168) | (($dirty << 3) & 57344) | (($dirty << 6) & 1879048192), (($dirty >> 24) & 14) | 48, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $dirty2 = $dirty4;
            colors4 = colors5;
            enabled4 = enabled3;
            border4 = border3;
            interactionSource4 = interactionSource3;
            modifier5 = modifier7;
            icon2 = icon3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.4
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

                public final void invoke(Composer composer, int i11) {
                    SegmentedButtonKt.SegmentedButton($this$SegmentedButton, checked, function1, shape, modifier5, enabled4, colors4, border4, interactionSource4, icon2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void SegmentedButton(final SingleChoiceSegmentedButtonRowScope $this$SegmentedButton, final boolean selected, final Function0<Unit> function0, final Shape shape, Modifier modifier, boolean enabled, SegmentedButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        SegmentedButtonColors colors2;
        BorderStroke border2;
        int i2;
        int i3;
        Modifier modifier3;
        MutableInteractionSource interactionSource2;
        Modifier modifier4;
        MutableInteractionSource interactionSource3;
        SegmentedButtonColors colors3;
        int $dirty;
        boolean enabled3;
        BorderStroke border3;
        final Function2 icon;
        Object value$iv;
        Composer $composer2;
        int $dirty2;
        final boolean enabled4;
        final BorderStroke border4;
        final MutableInteractionSource interactionSource4;
        final Modifier modifier5;
        final SegmentedButtonColors colors4;
        final Function2 icon2;
        Composer $composer3 = $composer.startRestartGroup(-1016574361);
        ComposerKt.sourceInformation($composer3, "C(SegmentedButton)P(8,7,9,6,2,1!1,4)209@10206L8,213@10384L39,219@10716L25,221@10747L623:SegmentedButton.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed($this$SegmentedButton) ? 4 : 2;
        }
        if ((i & 1) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changed(selected) ? 32 : 16;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer3.changed(shape) ? 2048 : 1024;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            enabled2 = enabled;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 131072 : 65536;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 32) == 0) {
                colors2 = colors;
                int i6 = $composer3.changed(colors2) ? 1048576 : 524288;
                $dirty3 |= i6;
            } else {
                colors2 = colors;
            }
            $dirty3 |= i6;
        } else {
            colors2 = colors;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 64) == 0) {
                border2 = border;
                int i7 = $composer3.changed(border2) ? 8388608 : 4194304;
                $dirty3 |= i7;
            } else {
                border2 = border;
            }
            $dirty3 |= i7;
        } else {
            border2 = border;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 100663296;
            i2 = i8;
        } else if (($changed & 100663296) == 0) {
            i2 = i8;
            $dirty3 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i8;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty3 |= 805306368;
            i3 = i9;
        } else if (($changed & 805306368) == 0) {
            i3 = i9;
            $dirty3 |= $composer3.changedInstance(function2) ? 536870912 : 268435456;
        } else {
            i3 = i9;
        }
        if ((i & 512) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(function22) ? 4 : 2;
        }
        int $dirty12 = $dirty1;
        if ((306783379 & $dirty3) == 306783378 && ($dirty12 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            interactionSource4 = interactionSource;
            $composer2 = $composer3;
            $dirty2 = $dirty3;
            enabled4 = enabled2;
            border4 = border2;
            icon2 = function2;
            colors4 = colors2;
            modifier5 = modifier2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier6 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (i5 != 0) {
                    enabled2 = true;
                }
                if ((i & 32) != 0) {
                    colors2 = SegmentedButtonDefaults.INSTANCE.colors($composer3, 6);
                    $dirty3 &= -3670017;
                }
                if ((i & 64) != 0) {
                    border2 = SegmentedButtonDefaults.m2362borderStrokel07J4OM$default(SegmentedButtonDefaults.INSTANCE, colors2.m2346borderColorWaAFU9c$material3_release(enabled2, selected), 0.0f, 2, null);
                    $dirty3 &= -29360129;
                }
                if (i2 != 0) {
                    $composer3.startReplaceableGroup(-773600241);
                    ComposerKt.sourceInformation($composer3, "CC(remember):SegmentedButton.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    modifier3 = modifier6;
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    $composer3.endReplaceableGroup();
                } else {
                    modifier3 = modifier6;
                    interactionSource2 = interactionSource;
                }
                if (i3 != 0) {
                    $dirty = $dirty3;
                    icon = ComposableLambdaKt.composableLambda($composer3, 1235063168, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer4, int $changed2) {
                            ComposerKt.sourceInformation($composer4, "C214@10486L14:SegmentedButton.kt#uh7d8r");
                            if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1235063168, $changed2, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:214)");
                            }
                            SegmentedButtonDefaults.INSTANCE.Icon(selected, null, null, $composer4, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    modifier4 = modifier3;
                    interactionSource3 = interactionSource2;
                    colors3 = colors2;
                    enabled3 = enabled2;
                    border3 = border2;
                } else {
                    modifier4 = modifier3;
                    interactionSource3 = interactionSource2;
                    colors3 = colors2;
                    $dirty = $dirty3;
                    enabled3 = enabled2;
                    border3 = border2;
                    icon = function2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 64) != 0) {
                    int i10 = $dirty3 & (-29360129);
                    icon = function2;
                    $dirty = i10;
                    colors3 = colors2;
                    enabled3 = enabled2;
                    border3 = border2;
                    modifier4 = modifier2;
                    interactionSource3 = interactionSource;
                } else {
                    colors3 = colors2;
                    $dirty = $dirty3;
                    enabled3 = enabled2;
                    border3 = border2;
                    modifier4 = modifier2;
                    interactionSource3 = interactionSource;
                    icon = function2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1016574361, $dirty, $dirty12, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:216)");
            }
            long containerColor = colors3.m2347containerColorWaAFU9c$material3_release(enabled3, selected);
            long contentColor = colors3.m2348contentColorWaAFU9c$material3_release(enabled3, selected);
            State interactionCount = interactionCountAsState(interactionSource3, $composer3, ($dirty >> 24) & 14);
            Modifier modifier7 = modifier4;
            SegmentedButtonColors colors5 = colors3;
            Function2 icon3 = icon;
            int $dirty4 = $dirty;
            $composer2 = $composer3;
            SurfaceKt.m2520Surfaced85dljk(selected, function0, SemanticsModifierKt.semantics$default(SizeKt.m800defaultMinSizeVpY3zN4(interactionZIndex(RowScope.weight$default($this$SegmentedButton, modifier4, 1.0f, false, 2, null), selected, interactionCount), ButtonDefaults.INSTANCE.m1818getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1817getMinHeightD9Ej5fM()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.7
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m5618setRolekuIjeqM($this$semantics, Role.INSTANCE.m5606getRadioButtono7Vup1c());
                }
            }, 1, null), enabled3, shape, containerColor, contentColor, 0.0f, 0.0f, border3, interactionSource3, ComposableLambdaKt.composableLambda($composer3, 383378045, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.8
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
                    ComposerKt.sourceInformation($composer4, "C239@11329L35:SegmentedButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(383378045, $changed2, -1, "androidx.compose.material3.SegmentedButton.<anonymous> (SegmentedButton.kt:239)");
                        }
                        SegmentedButtonKt.SegmentedButtonContent(icon, function22, $composer4, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 6) & 7168) | (57344 & ($dirty << 3)) | (($dirty << 6) & 1879048192), (($dirty >> 24) & 14) | 48, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $dirty2 = $dirty4;
            enabled4 = enabled3;
            border4 = border3;
            interactionSource4 = interactionSource3;
            modifier5 = modifier7;
            colors4 = colors5;
            icon2 = icon3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButton.9
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

                public final void invoke(Composer composer, int i11) {
                    SegmentedButtonKt.SegmentedButton($this$SegmentedButton, selected, function0, shape, modifier5, enabled4, colors4, border4, interactionSource4, icon2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0239  */
    /* renamed from: SingleChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2368SingleChoiceSegmentedButtonRowuFdPcIQ(androidx.compose.p000ui.Modifier r30, float r31, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.SingleChoiceSegmentedButtonRowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 597
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SegmentedButtonKt.m2368SingleChoiceSegmentedButtonRowuFdPcIQ(androidx.compose.ui.Modifier, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0235  */
    /* renamed from: MultiChoiceSegmentedButtonRow-uFdPcIQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2367MultiChoiceSegmentedButtonRowuFdPcIQ(androidx.compose.p000ui.Modifier r30, float r31, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.MultiChoiceSegmentedButtonRowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SegmentedButtonKt.m2367MultiChoiceSegmentedButtonRowuFdPcIQ(androidx.compose.ui.Modifier, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SegmentedButtonContent(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1464121570);
        ComposerKt.sourceInformation($composer3, "C(SegmentedButtonContent)P(1)322@14458L637:SegmentedButton.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1464121570, $dirty, -1, "androidx.compose.material3.SegmentedButtonContent (SegmentedButton.kt:321)");
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, ButtonDefaults.INSTANCE.getTextButtonContentPadding());
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(center, false, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv = (54 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifierPadding);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3479constructorimpl($composer3);
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, 372432274, "C327@14644L10,328@14718L371:SegmentedButton.kt#uh7d8r");
            TextStyle typography = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), OutlinedSegmentedButtonTokens.INSTANCE.getLabelTextFont());
            TextKt.ProvideTextStyle(typography, ComposableLambdaKt.composableLambda($composer3, 1420592651, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt$SegmentedButtonContent$1$1
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
                    int i3;
                    Object value$iv$iv$iv;
                    Object value$iv;
                    Object value$iv$iv$iv2;
                    ComposerKt.sourceInformation($composer4, "C329@14773L24,330@14830L55,332@14899L180:SegmentedButton.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1420592651, $changed2, -1, "androidx.compose.material3.SegmentedButtonContent.<anonymous>.<anonymous> (SegmentedButton.kt:329)");
                        }
                        $composer4.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation($composer4, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        $composer4.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer4, "CC(remember):Composables.kt#9igjgp");
                        Object it$iv$iv$iv = $composer4.rememberedValue();
                        if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                            i3 = 0;
                            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer4));
                            $composer4.updateRememberedValue(value$iv$iv$iv);
                        } else {
                            i3 = 0;
                            value$iv$iv$iv = it$iv$iv$iv;
                        }
                        $composer4.endReplaceableGroup();
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                        CoroutineScope scope = wrapper$iv.getCoroutineScope();
                        $composer4.endReplaceableGroup();
                        $composer4.startReplaceableGroup(-1468900584);
                        ComposerKt.sourceInformation($composer4, "CC(remember):SegmentedButton.kt#9igjgp");
                        Object it$iv = $composer4.rememberedValue();
                        if (it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new SegmentedButtonContentMeasurePolicy(scope);
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        SegmentedButtonContentMeasurePolicy measurePolicy = (SegmentedButtonContentMeasurePolicy) value$iv;
                        $composer4.endReplaceableGroup();
                        Modifier modifierHeight = IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Min);
                        Function2<Composer, Integer, Unit> function23 = function2;
                        Function2<Composer, Integer, Unit> function24 = function22;
                        Function2[] function2Arr = new Function2[2];
                        function2Arr[i3] = function23;
                        function2Arr[1] = function24;
                        List listListOf = CollectionsKt.listOf((Object[]) function2Arr);
                        $composer4.startReplaceableGroup(1399185516);
                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)171@6874L62,168@6760L182:Layout.kt#80mrfh");
                        Function2 content$iv$iv = LayoutKt.combineAsVirtualLayouts(listListOf);
                        int i4 = (432 >> 6) & 14;
                        $composer4.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation($composer4, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean invalid$iv$iv$iv = $composer4.changed(measurePolicy);
                        Object it$iv$iv$iv2 = $composer4.rememberedValue();
                        if (invalid$iv$iv$iv || it$iv$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv$iv2 = MultiContentMeasurePolicyKt.createMeasurePolicy(measurePolicy);
                            $composer4.updateRememberedValue(value$iv$iv$iv2);
                        } else {
                            value$iv$iv$iv2 = it$iv$iv$iv2;
                        }
                        $composer4.endReplaceableGroup();
                        MeasurePolicy measurePolicy$iv$iv = (MeasurePolicy) value$iv$iv$iv2;
                        int $changed$iv$iv2 = 432 & 112;
                        $composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, i3);
                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.modifierMaterializerOf(modifierHeight);
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            $composer4.createNode(factory$iv$iv$iv2);
                        } else {
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3479constructorimpl($composer4);
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
                        }
                        skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                        $composer4.startReplaceableGroup(2058660585);
                        content$iv$iv.invoke($composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 9) & 14));
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
            }), $composer3, 48);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.SegmentedButtonContent.2
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

                public final void invoke(Composer composer, int i3) {
                    SegmentedButtonKt.SegmentedButtonContent(function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final State<Integer> interactionCountAsState(InteractionSource $this$interactionCountAsState, Composer $composer, int $changed) {
        Object value$iv;
        SegmentedButtonKt$interactionCountAsState$1$1 value$iv2;
        $composer.startReplaceableGroup(281890131);
        ComposerKt.sourceInformation($composer, "C(interactionCountAsState)399@17334L33,400@17393L500,400@17372L521:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(281890131, $changed, -1, "androidx.compose.material3.interactionCountAsState (SegmentedButton.kt:398)");
        }
        $composer.startReplaceableGroup(-1372284393);
        ComposerKt.sourceInformation($composer, "CC(remember):SegmentedButton.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        MutableIntState interactionCount = (MutableIntState) value$iv;
        $composer.endReplaceableGroup();
        $composer.startReplaceableGroup(-1372284334);
        ComposerKt.sourceInformation($composer, "CC(remember):SegmentedButton.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed($this$interactionCountAsState)) || ($changed & 6) == 4;
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = new SegmentedButtonKt$interactionCountAsState$1$1($this$interactionCountAsState, interactionCount, null);
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect($this$interactionCountAsState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return interactionCount;
    }

    private static final Modifier interactionZIndex(Modifier $this$interactionZIndex, final boolean checked, final State<Integer> state) {
        return LayoutModifierKt.layout($this$interactionZIndex, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SegmentedButtonKt.interactionZIndex.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m2369invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m2369invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
                final Placeable placeable = measurable.mo5219measureBRTryo0(constraints);
                int width = placeable.getWidth();
                int height = placeable.getHeight();
                final State<Integer> state2 = state;
                final boolean z = checked;
                return MeasureScope.layout$default($this$layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SegmentedButtonKt.interactionZIndex.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        float zIndex = state2.getValue().floatValue() + (z ? SegmentedButtonKt.CheckedZIndexFactor : 0.0f);
                        $this$layout2.place(placeable, 0, 0, zIndex);
                    }
                }, 4, null);
            }
        });
    }
}
