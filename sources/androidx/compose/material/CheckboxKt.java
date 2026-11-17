package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.CornerRadiusKt;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.StrokeCap;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.graphics.drawscope.Fill;
import androidx.compose.p000ui.graphics.drawscope.Stroke;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.state.ToggleableState;
import androidx.compose.p000ui.state.ToggleableStateKt;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.util.MathHelpersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: Checkbox.kt */
@Metadata(m164d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u001c\u001aM\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010!\u001a6\u0010\"\u001a\u00020\f*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a>\u0010,\u001a\u00020\f*\u00020#2\u0006\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065²\u0006\n\u00106\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u00107\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020%X\u008a\u0084\u0002"}, m165d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxRippleRadius", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/CheckboxColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material/CheckDrawingCache;)V", "material_release", "checkDrawFraction", "checkCenterGravitationShiftFraction"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxRippleRadius = C1956Dp.m6297constructorimpl(24);
    private static final float CheckboxDefaultPadding = C1956Dp.m6297constructorimpl(2);
    private static final float CheckboxSize = C1956Dp.m6297constructorimpl(20);
    private static final float StrokeWidth = C1956Dp.m6297constructorimpl(2);
    private static final float RadiusSize = C1956Dp.m6297constructorimpl(2);

    /* compiled from: Checkbox.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void Checkbox(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, CheckboxColors colors, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        MutableInteractionSource mutableInteractionSource;
        CheckboxColors checkboxColors;
        MutableInteractionSource interactionSource2;
        CheckboxColors colors2;
        MutableInteractionSource interactionSource3;
        Modifier modifier3;
        boolean enabled2;
        Object value$iv$iv;
        Function0 function0;
        final Modifier modifier4;
        final boolean enabled3;
        final MutableInteractionSource interactionSource4;
        final CheckboxColors colors3;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-2118660998);
        ComposerKt.sourceInformation($composer2, "C(Checkbox)P(!1,5,4,2,3)90@4153L39,91@4240L8,93@4257L284:Checkbox.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(checked) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 57344) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty |= $composer2.changed(mutableInteractionSource) ? 16384 : 8192;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                checkboxColors = colors;
                int i5 = $composer2.changed(checkboxColors) ? 131072 : 65536;
                $dirty |= i5;
            } else {
                checkboxColors = colors;
            }
            $dirty |= i5;
        } else {
            checkboxColors = colors;
        }
        if ((374491 & $dirty) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            enabled3 = z;
            interactionSource4 = mutableInteractionSource;
            colors3 = checkboxColors;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i3 != 0 ? true : z;
                if (i4 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    interactionSource2 = mutableInteractionSource;
                }
                if ((i & 32) != 0) {
                    CheckboxColors colors4 = CheckboxDefaults.INSTANCE.m1468colorszjMxDiM(0L, 0L, 0L, 0L, 0L, $composer2, ProfileVerifier.CompilationStatus.f249xf2722a21, 31);
                    $composer2 = $composer2;
                    $dirty &= -458753;
                    interactionSource3 = interactionSource2;
                    modifier3 = modifier5;
                    enabled2 = enabled4;
                    colors2 = colors4;
                } else {
                    colors2 = colors;
                    interactionSource3 = interactionSource2;
                    modifier3 = modifier5;
                    enabled2 = enabled4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                interactionSource3 = mutableInteractionSource;
                colors2 = checkboxColors;
                modifier3 = modifier2;
                enabled2 = z;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2118660998, $dirty, -1, "androidx.compose.material.Checkbox (Checkbox.kt:92)");
            }
            ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(checked);
            if (function1 != null) {
                $composer2.startReplaceableGroup(-1264222645);
                boolean invalid$iv = $composer2.changedInstance(function1) | $composer2.changed(checked);
                Composer $this$cache$iv = $composer2;
                Object it$iv = $this$cache$iv.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.CheckboxKt$Checkbox$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function1.invoke(Boolean.valueOf(!checked));
                        }
                    };
                    $this$cache$iv.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                function0 = (Function0) value$iv;
                $composer2.endReplaceableGroup();
            } else {
                function0 = null;
            }
            TriStateCheckbox(ToggleableState, function0, modifier3, enabled2, interactionSource3, colors2, $composer2, ($dirty & 896) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            enabled3 = enabled2;
            interactionSource4 = interactionSource3;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.Checkbox.3
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

                public final void invoke(Composer composer, int i6) {
                    CheckboxKt.Checkbox(checked, function1, modifier4, enabled3, interactionSource4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void TriStateCheckbox(final ToggleableState state, final Function0<Unit> function0, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, CheckboxColors colors, Composer $composer, final int $changed, final int i) {
        ToggleableState toggleableState;
        Modifier modifier2;
        boolean z;
        MutableInteractionSource mutableInteractionSource;
        CheckboxColors checkboxColors;
        MutableInteractionSource interactionSource2;
        CheckboxColors colors2;
        MutableInteractionSource interactionSource3;
        int $dirty;
        Modifier modifier3;
        boolean enabled2;
        Object value$iv$iv;
        int $dirty2;
        MutableInteractionSource interactionSource4;
        Modifier.Companion toggleableModifier;
        final CheckboxColors colors3;
        final Modifier modifier4;
        final boolean enabled3;
        final MutableInteractionSource interactionSource5;
        Composer $composer2 = $composer.startRestartGroup(2031255194);
        ComposerKt.sourceInformation($composer2, "C(TriStateCheckbox)P(5,4,3,1,2)136@6460L39,137@6547L8,155@7071L412:Checkbox.kt#jmzs0o");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
            toggleableState = state;
        } else if (($changed & 14) == 0) {
            toggleableState = state;
            $dirty3 |= $composer2.changed(toggleableState) ? 4 : 2;
        } else {
            toggleableState = state;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty3 |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty3 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty3 |= 24576;
            mutableInteractionSource = interactionSource;
        } else if ((57344 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty3 |= $composer2.changed(mutableInteractionSource) ? 16384 : 8192;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                checkboxColors = colors;
                int i5 = $composer2.changed(checkboxColors) ? 131072 : 65536;
                $dirty3 |= i5;
            } else {
                checkboxColors = colors;
            }
            $dirty3 |= i5;
        } else {
            checkboxColors = colors;
        }
        if ((374491 & $dirty3) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            enabled3 = z;
            colors3 = checkboxColors;
            interactionSource5 = mutableInteractionSource;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i3 != 0 ? true : z;
                if (i4 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    interactionSource2 = mutableInteractionSource;
                }
                if ((i & 32) != 0) {
                    CheckboxColors colors4 = CheckboxDefaults.INSTANCE.m1468colorszjMxDiM(0L, 0L, 0L, 0L, 0L, $composer2, ProfileVerifier.CompilationStatus.f249xf2722a21, 31);
                    $composer2 = $composer2;
                    interactionSource3 = interactionSource2;
                    $dirty = $dirty3 & (-458753);
                    modifier3 = modifier5;
                    enabled2 = enabled4;
                    colors2 = colors4;
                } else {
                    colors2 = colors;
                    interactionSource3 = interactionSource2;
                    $dirty = $dirty3;
                    modifier3 = modifier5;
                    enabled2 = enabled4;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                $dirty = $dirty3;
                modifier3 = modifier2;
                enabled2 = z;
                interactionSource3 = mutableInteractionSource;
                colors2 = checkboxColors;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2031255194, $dirty, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:138)");
            }
            $composer2.startReplaceableGroup(-1517549514);
            ComposerKt.sourceInformation($composer2, "147@6884L120");
            if (function0 != null) {
                $dirty2 = $dirty;
                boolean enabled5 = enabled2;
                toggleableModifier = ToggleableKt.m1015triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, interactionSource3, RippleKt.m1756rememberRipple9IZ8Weo(false, CheckboxRippleRadius, 0L, $composer2, 54, 4), enabled5, Role.m5595boximpl(Role.INSTANCE.m5603getCheckboxo7Vup1c()), function0);
                interactionSource4 = interactionSource3;
                enabled2 = enabled5;
            } else {
                $dirty2 = $dirty;
                interactionSource4 = interactionSource3;
                toggleableModifier = Modifier.INSTANCE;
            }
            $composer2.endReplaceableGroup();
            CheckboxColors colors5 = colors2;
            CheckboxImpl(enabled2, state, PaddingKt.m767padding3ABfNKs(modifier3.then(function0 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(toggleableModifier), CheckboxDefaultPadding), colors5, $composer2, (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty2 >> 6) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors3 = colors5;
            modifier4 = modifier3;
            enabled3 = enabled2;
            interactionSource5 = interactionSource4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.TriStateCheckbox.2
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
                    CheckboxKt.TriStateCheckbox(state, function0, modifier4, enabled3, interactionSource5, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CheckboxImpl(final boolean enabled, final ToggleableState value, final Modifier modifier, final CheckboxColors colors, Composer $composer, final int $changed) {
        Composer $composer2;
        Transition $this$animateValue$iv$iv;
        float f;
        Composer $composer3;
        ToggleableState it;
        float f2;
        int $changed$iv$iv;
        Transition $this$animateValue$iv$iv2;
        ToggleableState it2;
        float f3;
        Object initialValue$iv$iv;
        float f4;
        Object value$iv$iv;
        Object value$iv;
        Composer $composer4 = $composer.startRestartGroup(-2118895727);
        ComposerKt.sourceInformation($composer4, "C(CheckboxImpl)P(1,3,2)264@11068L23,265@11132L443,281@11635L458,296@12115L32,297@12177L21,298@12226L24,299@12281L27,300@12313L586:Checkbox.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer4.changed(enabled) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer4.changed(value) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer4.changed(modifier) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer4.changed(colors) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2118895727, $dirty2, -1, "androidx.compose.material.CheckboxImpl (Checkbox.kt:263)");
            }
            Transition transition = TransitionKt.updateTransition(value, (String) null, $composer4, ($dirty2 >> 3) & 14, 2);
            Function3 transitionSpec$iv = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$checkDrawFraction$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer $composer5, int $changed2) {
                    SpringSpec springSpecSnap;
                    $composer5.startReplaceableGroup(-1707702900);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1707702900, $changed2, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:267)");
                    }
                    if (segment.getInitialState() == ToggleableState.Off) {
                        springSpecSnap = AnimationSpecKt.tween$default(100, 0, null, 6, null);
                    } else {
                        springSpecSnap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer5.endReplaceableGroup();
                    return springSpecSnap;
                }
            };
            $composer4.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer4, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
            TwoWayConverter typeConverter$iv$iv = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv2 = (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168) | ((0 << 3) & 57344);
            $composer4.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer4, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            int $changed2 = ($changed$iv$iv2 >> 9) & 112;
            ToggleableState it3 = (ToggleableState) transition.getCurrentState();
            $composer4.startReplaceableGroup(-1798345588);
            ComposerKt.sourceInformation($composer4, "C:Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                $composer2 = $composer4;
                $this$animateValue$iv$iv = transition;
                ComposerKt.traceEventStart(-1798345588, $changed2, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:274)");
            } else {
                $composer2 = $composer4;
                $this$animateValue$iv$iv = transition;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it3.ordinal()]) {
                case 1:
                    f = 1.0f;
                    break;
                case 2:
                    f = 0.0f;
                    break;
                case 3:
                    f = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object initialValue$iv$iv2 = Float.valueOf(f);
            int $changed3 = ($changed$iv$iv2 >> 9) & 112;
            ToggleableState it4 = (ToggleableState) $this$animateValue$iv$iv.getTargetState();
            $composer4.startReplaceableGroup(-1798345588);
            ComposerKt.sourceInformation($composer4, "C:Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                $composer3 = $composer4;
                it = it4;
                ComposerKt.traceEventStart(-1798345588, $changed3, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:274)");
            } else {
                $composer3 = $composer4;
                it = it4;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                case 1:
                    f2 = 1.0f;
                    break;
                case 2:
                    f2 = 0.0f;
                    break;
                case 3:
                    f2 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer3.endReplaceableGroup();
            Object targetValue$iv$iv = Float.valueOf(f2);
            FiniteAnimationSpec<Float> animationSpec$iv$iv = transitionSpec$iv.invoke($this$animateValue$iv$iv.getSegment(), $composer4, Integer.valueOf(($changed$iv$iv2 >> 3) & 112));
            final State checkDrawFraction$delegate = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv, initialValue$iv$iv2, targetValue$iv$iv, animationSpec$iv$iv, typeConverter$iv$iv, "FloatAnimation", $composer4, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
            $composer4.endReplaceableGroup();
            $composer4.endReplaceableGroup();
            Function3 transitionSpec$iv2 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer $composer5, int $changed4) {
                    TweenSpec tweenSpecSnap;
                    $composer5.startReplaceableGroup(1075283605);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1075283605, $changed4, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:283)");
                    }
                    if (segment.getInitialState() == ToggleableState.Off) {
                        tweenSpecSnap = AnimationSpecKt.snap$default(0, 1, null);
                    } else {
                        tweenSpecSnap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer5.endReplaceableGroup();
                    return tweenSpecSnap;
                }
            };
            $composer4.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer4, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
            TwoWayConverter typeConverter$iv$iv2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv3 = (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168) | ((0 << 3) & 57344);
            $composer4.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer4, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            int $changed4 = ($changed$iv$iv3 >> 9) & 112;
            ToggleableState it5 = (ToggleableState) transition.getCurrentState();
            $composer4.startReplaceableGroup(-2098942571);
            ComposerKt.sourceInformation($composer4, "C:Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                $changed$iv$iv = $changed$iv$iv3;
                $this$animateValue$iv$iv2 = transition;
                it2 = it5;
                ComposerKt.traceEventStart(-2098942571, $changed4, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:290)");
            } else {
                $changed$iv$iv = $changed$iv$iv3;
                $this$animateValue$iv$iv2 = transition;
                it2 = it5;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it2.ordinal()]) {
                case 1:
                    f3 = 0.0f;
                    break;
                case 2:
                    f3 = 0.0f;
                    break;
                case 3:
                    f3 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer4.endReplaceableGroup();
            Object initialValue$iv$iv3 = Float.valueOf(f3);
            int $changed5 = ($changed$iv$iv >> 9) & 112;
            ToggleableState it6 = (ToggleableState) $this$animateValue$iv$iv2.getTargetState();
            $composer4.startReplaceableGroup(-2098942571);
            ComposerKt.sourceInformation($composer4, "C:Checkbox.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                initialValue$iv$iv = initialValue$iv$iv3;
                ComposerKt.traceEventStart(-2098942571, $changed5, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:290)");
            } else {
                initialValue$iv$iv = initialValue$iv$iv3;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it6.ordinal()]) {
                case 1:
                    f4 = 0.0f;
                    break;
                case 2:
                    f4 = 0.0f;
                    break;
                case 3:
                    f4 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer4.endReplaceableGroup();
            Object targetValue$iv$iv2 = Float.valueOf(f4);
            FiniteAnimationSpec<Float> animationSpec$iv$iv2 = transitionSpec$iv2.invoke($this$animateValue$iv$iv2.getSegment(), $composer4, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            final State checkCenterGravitationShiftFraction$delegate = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv2, initialValue$iv$iv, targetValue$iv$iv2, animationSpec$iv$iv2, typeConverter$iv$iv2, "FloatAnimation", $composer4, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            $composer4.endReplaceableGroup();
            $composer4.endReplaceableGroup();
            $composer4.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer4, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer4.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CheckDrawingCache(null, null, null, 7, null);
                $composer4.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer4.endReplaceableGroup();
            final CheckDrawingCache checkCache = (CheckDrawingCache) value$iv$iv;
            final State checkColor$delegate = colors.checkmarkColor(value, $composer4, (($dirty2 >> 3) & 14) | (($dirty2 >> 6) & 112));
            final State boxColor$delegate = colors.boxColor(enabled, value, $composer4, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
            final State borderColor$delegate = colors.borderColor(enabled, value, $composer4, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
            Modifier modifierM808requiredSize3ABfNKs = SizeKt.m808requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
            $composer4.startReplaceableGroup(-1264214620);
            boolean invalid$iv = $composer4.changed(boxColor$delegate) | $composer4.changed(borderColor$delegate) | $composer4.changed(checkColor$delegate) | $composer4.changed(checkDrawFraction$delegate) | $composer4.changed(checkCenterGravitationShiftFraction$delegate) | $composer4.changed(checkCache);
            Object it$iv = $composer4.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.CheckboxKt$CheckboxImpl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope $this$Canvas) {
                        float strokeWidthPx = (float) Math.floor($this$Canvas.mo518toPx0680j_4(CheckboxKt.StrokeWidth));
                        CheckboxKt.m1471drawBox1wkBAMs($this$Canvas, CheckboxKt.CheckboxImpl$lambda$9(boxColor$delegate), CheckboxKt.CheckboxImpl$lambda$10(borderColor$delegate), $this$Canvas.mo518toPx0680j_4(CheckboxKt.RadiusSize), strokeWidthPx);
                        CheckboxKt.m1472drawCheck3IgeMak($this$Canvas, CheckboxKt.CheckboxImpl$lambda$8(checkColor$delegate), CheckboxKt.CheckboxImpl$lambda$4(checkDrawFraction$delegate), CheckboxKt.CheckboxImpl$lambda$6(checkCenterGravitationShiftFraction$delegate), strokeWidthPx, checkCache);
                    }
                };
                $composer4.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer4.endReplaceableGroup();
            CanvasKt.Canvas(modifierM808requiredSize3ABfNKs, (Function1) value$iv, $composer4, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer4.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.CheckboxKt.CheckboxImpl.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    CheckboxKt.CheckboxImpl(enabled, value, modifier, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CheckboxImpl$lambda$4(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CheckboxImpl$lambda$6(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long CheckboxImpl$lambda$8(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m3959unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long CheckboxImpl$lambda$9(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m3959unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long CheckboxImpl$lambda$10(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m3959unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawBox-1wkBAMs, reason: not valid java name */
    public static final void m1471drawBox1wkBAMs(DrawScope $this$drawBox_u2d1wkBAMs, long boxColor, long borderColor, float radius, float strokeWidth) {
        float halfStrokeWidth = strokeWidth / 2.0f;
        Stroke stroke = new Stroke(strokeWidth, 0.0f, 0, 0, null, 30, null);
        float checkboxSize = Size.m3777getWidthimpl($this$drawBox_u2d1wkBAMs.mo4498getSizeNHjbRc());
        if (Color.m3950equalsimpl0(boxColor, borderColor)) {
            DrawScope.m4495drawRoundRectuAw5IA$default($this$drawBox_u2d1wkBAMs, boxColor, 0L, androidx.compose.p000ui.geometry.SizeKt.Size(checkboxSize, checkboxSize), CornerRadiusKt.CornerRadius$default(radius, 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 226, null);
            return;
        }
        float f = 2;
        DrawScope.m4495drawRoundRectuAw5IA$default($this$drawBox_u2d1wkBAMs, boxColor, OffsetKt.Offset(strokeWidth, strokeWidth), androidx.compose.p000ui.geometry.SizeKt.Size(checkboxSize - (strokeWidth * f), checkboxSize - (f * strokeWidth)), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, radius - strokeWidth), 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 224, null);
        DrawScope.m4495drawRoundRectuAw5IA$default($this$drawBox_u2d1wkBAMs, borderColor, OffsetKt.Offset(halfStrokeWidth, halfStrokeWidth), androidx.compose.p000ui.geometry.SizeKt.Size(checkboxSize - strokeWidth, checkboxSize - strokeWidth), CornerRadiusKt.CornerRadius$default(radius - halfStrokeWidth, 0.0f, 2, null), stroke, 0.0f, null, 0, 224, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCheck-3IgeMak, reason: not valid java name */
    public static final void m1472drawCheck3IgeMak(DrawScope $this$drawCheck_u2d3IgeMak, long checkColor, float checkFraction, float crossCenterGravitation, float strokeWidthPx, CheckDrawingCache drawingCache) {
        Stroke stroke = new Stroke(strokeWidthPx, 0.0f, StrokeCap.INSTANCE.m4303getSquareKaPHkGw(), 0, null, 26, null);
        float width = Size.m3777getWidthimpl($this$drawCheck_u2d3IgeMak.mo4498getSizeNHjbRc());
        float gravitatedCrossX = MathHelpersKt.lerp(0.4f, 0.5f, crossCenterGravitation);
        float gravitatedCrossY = MathHelpersKt.lerp(0.7f, 0.5f, crossCenterGravitation);
        float gravitatedLeftY = MathHelpersKt.lerp(0.5f, 0.5f, crossCenterGravitation);
        float gravitatedRightY = MathHelpersKt.lerp(0.3f, 0.5f, crossCenterGravitation);
        drawingCache.getCheckPath().reset();
        drawingCache.getCheckPath().moveTo(width * 0.2f, width * gravitatedLeftY);
        drawingCache.getCheckPath().lineTo(width * gravitatedCrossX, width * gravitatedCrossY);
        drawingCache.getCheckPath().lineTo(width * 0.8f, width * gravitatedRightY);
        drawingCache.getPathMeasure().setPath(drawingCache.getCheckPath(), false);
        drawingCache.getPathToDraw().reset();
        drawingCache.getPathMeasure().getSegment(0.0f, drawingCache.getPathMeasure().getLength() * checkFraction, drawingCache.getPathToDraw(), true);
        DrawScope.m4489drawPathLG529CI$default($this$drawCheck_u2d3IgeMak, drawingCache.getPathToDraw(), checkColor, 0.0f, stroke, null, 0, 52, null);
    }
}
