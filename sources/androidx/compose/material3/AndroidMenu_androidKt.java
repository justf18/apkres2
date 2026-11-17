package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.TransformOrigin;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.DpKt;
import androidx.compose.p000ui.unit.IntRect;
import androidx.compose.p000ui.window.AndroidPopup_androidKt;
import androidx.compose.p000ui.window.PopupProperties;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: AndroidMenu.android.kt */
@Metadata(m164d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001ad\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u008e\u0001\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007¢\u0006\u0002\u0010#\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, m165d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "text", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidMenu_androidKt {
    /* renamed from: DropdownMenu-4kj-_NE, reason: not valid java name */
    public static final void m1768DropdownMenu4kj_NE(boolean expanded, final Function0<Unit> function0, Modifier modifier, long offset, ScrollState scrollState, PopupProperties properties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        boolean z;
        Modifier modifier2;
        long offset2;
        ScrollState scrollState2;
        PopupProperties popupProperties;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        int $dirty;
        final Modifier modifier3;
        long offset3;
        final ScrollState scrollState3;
        PopupProperties properties2;
        Object value$iv;
        PopupProperties properties3;
        Object value$iv2;
        Object value$iv3;
        Composer $composer2;
        final PopupProperties properties4;
        final ScrollState scrollState4;
        final Modifier modifier4;
        final long offset4;
        Composer $composer3 = $composer.startRestartGroup(-1137929566);
        ComposerKt.sourceInformation($composer3, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,6,5)88@4529L21,92@4697L42,96@4884L51,97@4971L7,98@5015L281,107@5306L441:AndroidMenu.android.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
            z = expanded;
        } else if (($changed & 6) == 0) {
            z = expanded;
            $dirty2 |= $composer3.changed(z) ? 4 : 2;
        } else {
            z = expanded;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            offset2 = offset;
        } else if (($changed & 3072) == 0) {
            offset2 = offset;
            $dirty2 |= $composer3.changed(offset2) ? 2048 : 1024;
        } else {
            offset2 = offset;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                scrollState2 = scrollState;
                int i4 = $composer3.changed(scrollState2) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                scrollState2 = scrollState;
            }
            $dirty2 |= i4;
        } else {
            scrollState2 = scrollState;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            popupProperties = properties;
        } else if ((196608 & $changed) == 0) {
            popupProperties = properties;
            $dirty2 |= $composer3.changed(popupProperties) ? 131072 : 65536;
        } else {
            popupProperties = properties;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
            function32 = function3;
        } else if (($changed & 1572864) == 0) {
            function32 = function3;
            $dirty2 |= $composer3.changedInstance(function32) ? 1048576 : 524288;
        } else {
            function32 = function3;
        }
        if (($dirty2 & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            offset4 = offset2;
            modifier4 = modifier2;
            scrollState4 = scrollState2;
            properties4 = popupProperties;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    offset2 = DpKt.m6318DpOffsetYgX7TsA(C1956Dp.m6297constructorimpl(0), C1956Dp.m6297constructorimpl(0));
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    scrollState2 = ScrollKt.rememberScrollState(0, $composer3, 0, 1);
                }
                if (i5 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    offset3 = offset2;
                    scrollState3 = scrollState2;
                    properties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                    offset3 = offset2;
                    scrollState3 = scrollState2;
                    properties2 = popupProperties;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                offset3 = offset2;
                scrollState3 = scrollState2;
                properties2 = popupProperties;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1137929566, $dirty, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:91)");
            }
            $composer3.startReplaceableGroup(463006278);
            ComposerKt.sourceInformation($composer3, "CC(remember):AndroidMenu.android.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MutableTransitionState(false);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableTransitionState expandedState = (MutableTransitionState) value$iv;
            $composer3.endReplaceableGroup();
            expandedState.setTargetState(Boolean.valueOf(z));
            if (((Boolean) expandedState.getCurrentState()).booleanValue() || ((Boolean) expandedState.getTargetState()).booleanValue()) {
                $composer3.startReplaceableGroup(463006465);
                ComposerKt.sourceInformation($composer3, "CC(remember):AndroidMenu.android.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                    properties3 = properties2;
                    value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m4326boximpl(TransformOrigin.INSTANCE.m4339getCenterSzJe1aQ()), null, 2, null);
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    properties3 = properties2;
                    value$iv2 = it$iv2;
                }
                final MutableState transformOriginState = (MutableState) value$iv2;
                $composer3.endReplaceableGroup();
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = $composer3.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density = (Density) objConsume;
                $composer3.startReplaceableGroup(463006596);
                ComposerKt.sourceInformation($composer3, "CC(remember):AndroidMenu.android.kt#9igjgp");
                boolean invalid$iv = (($dirty & 7168) == 2048) | $composer3.changed(density);
                Object it$iv3 = $composer3.rememberedValue();
                if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new DropdownMenuPositionProvider(offset3, density, 0, new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                            invoke2(intRect, intRect2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(IntRect parentBounds, IntRect menuBounds) {
                            transformOriginState.setValue(TransformOrigin.m4326boximpl(MenuKt.calculateTransformOrigin(parentBounds, menuBounds)));
                        }
                    }, 4, null);
                    $composer3.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv3;
                }
                DropdownMenuPositionProvider popupPositionProvider = (DropdownMenuPositionProvider) value$iv3;
                $composer3.endReplaceableGroup();
                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                properties2 = properties3;
                AndroidPopup_androidKt.Popup(popupPositionProvider, function0, properties2, ComposableLambdaKt.composableLambda($composer3, -848116919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
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
                        ComposerKt.sourceInformation($composer4, "C112@5481L256:AndroidMenu.android.kt#uh7d8r");
                        if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-848116919, $changed2, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:112)");
                            }
                            MenuKt.DropdownMenuContent(expandedState, transformOriginState, scrollState3, modifier3, function33, $composer4, MutableTransitionState.$stable | 48, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }), $composer3, ($dirty & 112) | 3072 | (($dirty >> 9) & 896), 0);
                $composer2 = $composer3;
            } else {
                $composer2 = $composer3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            properties4 = properties2;
            scrollState4 = scrollState3;
            modifier4 = modifier3;
            offset4 = offset3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z2 = z;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$2
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
                    AndroidMenu_androidKt.m1768DropdownMenu4kj_NE(z2, function0, modifier4, offset4, scrollState4, properties4, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    public static final /* synthetic */ void m1769DropdownMenuILWXrKs(final boolean expanded, final Function0 onDismissRequest, Modifier modifier, long offset, PopupProperties properties, final Function3 content, Composer $composer, final int $changed, final int i) {
        boolean z;
        Function0 function0;
        Modifier modifier2;
        long offset2;
        PopupProperties popupProperties;
        Function3 function3;
        Composer $composer2;
        final Modifier modifier3;
        final long offset3;
        final PopupProperties properties2;
        Composer $composer3 = $composer.startRestartGroup(354826666);
        ComposerKt.sourceInformation($composer3, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,5)146@6601L21,141@6457L219:AndroidMenu.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            z = expanded;
        } else if (($changed & 6) == 0) {
            z = expanded;
            $dirty |= $composer3.changed(z) ? 4 : 2;
        } else {
            z = expanded;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
            function0 = onDismissRequest;
        } else if (($changed & 48) == 0) {
            function0 = onDismissRequest;
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        } else {
            function0 = onDismissRequest;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            offset2 = offset;
        } else if (($changed & 3072) == 0) {
            offset2 = offset;
            $dirty |= $composer3.changed(offset2) ? 2048 : 1024;
        } else {
            offset2 = offset;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            popupProperties = properties;
        } else if (($changed & 24576) == 0) {
            popupProperties = properties;
            $dirty |= $composer3.changed(popupProperties) ? 16384 : 8192;
        } else {
            popupProperties = properties;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            function3 = content;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            function3 = content;
            $dirty |= $composer3.changedInstance(function3) ? 131072 : 65536;
        } else {
            function3 = content;
        }
        if ((74899 & $dirty) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
            offset3 = offset2;
            properties2 = popupProperties;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (i3 != 0) {
                offset2 = DpKt.m6318DpOffsetYgX7TsA(C1956Dp.m6297constructorimpl(0), C1956Dp.m6297constructorimpl(0));
            }
            PopupProperties properties3 = i4 != 0 ? new PopupProperties(true, false, false, null, false, false, 62, null) : popupProperties;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(354826666, $dirty, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:141)");
            }
            $composer2 = $composer3;
            Modifier modifier5 = modifier4;
            long offset4 = offset2;
            m1768DropdownMenu4kj_NE(z, function0, modifier5, offset4, ScrollKt.rememberScrollState(0, $composer3, 0, 1), properties3, function3, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 3) & 458752) | (3670016 & ($dirty << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            offset3 = offset4;
            properties2 = properties3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$3
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

                public final void invoke(Composer composer, int i5) {
                    AndroidMenu_androidKt.m1769DropdownMenuILWXrKs(expanded, onDismissRequest, modifier3, offset3, properties2, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void DropdownMenuItem(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, boolean enabled, MenuItemColors colors, PaddingValues contentPadding, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function0<Unit> function02;
        Modifier modifier2;
        Function2 leadingIcon;
        Function2 trailingIcon;
        boolean enabled2;
        MenuItemColors colors2;
        int i2;
        int i3;
        int $dirty;
        PaddingValues contentPadding2;
        MutableInteractionSource interactionSource2;
        Function2 trailingIcon2;
        boolean enabled3;
        MenuItemColors colors3;
        int i4;
        Modifier modifier3;
        Function2 leadingIcon2;
        Object value$iv;
        Composer $composer2;
        final Modifier modifier4;
        final Function2 leadingIcon3;
        final Function2 trailingIcon3;
        final boolean enabled4;
        final MenuItemColors colors4;
        final PaddingValues contentPadding3;
        final MutableInteractionSource interactionSource3;
        Composer $composer3 = $composer.startRestartGroup(1826340448);
        ComposerKt.sourceInformation($composer3, "C(DropdownMenuItem)P(7,6,5,4,8,2)186@8615L12,188@8760L39,190@8809L319:AndroidMenu.android.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
            function24 = function2;
        } else if (($changed & 6) == 0) {
            function24 = function2;
            $dirty2 |= $composer3.changedInstance(function24) ? 4 : 2;
        } else {
            function24 = function2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
            function02 = function0;
        } else if (($changed & 48) == 0) {
            function02 = function0;
            $dirty2 |= $composer3.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            leadingIcon = function22;
        } else if (($changed & 3072) == 0) {
            leadingIcon = function22;
            $dirty2 |= $composer3.changedInstance(leadingIcon) ? 2048 : 1024;
        } else {
            leadingIcon = function22;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            trailingIcon = function23;
        } else if (($changed & 24576) == 0) {
            trailingIcon = function23;
            $dirty2 |= $composer3.changedInstance(trailingIcon) ? 16384 : 8192;
        } else {
            trailingIcon = function23;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            enabled2 = enabled;
        } else if ((196608 & $changed) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer3.changed(enabled2) ? 131072 : 65536;
        } else {
            enabled2 = enabled;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                colors2 = colors;
                int i9 = $composer3.changed(colors2) ? 1048576 : 524288;
                $dirty2 |= i9;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i9;
        } else {
            colors2 = colors;
        }
        int i10 = i & 128;
        if (i10 != 0) {
            $dirty2 |= 12582912;
            i2 = i10;
        } else if (($changed & 12582912) == 0) {
            i2 = i10;
            $dirty2 |= $composer3.changed(contentPadding) ? 8388608 : 4194304;
        } else {
            i2 = i10;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty2 |= 100663296;
            i3 = i11;
        } else if (($changed & 100663296) == 0) {
            i3 = i11;
            $dirty2 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i11;
        }
        int $dirty3 = $dirty2;
        if (($dirty2 & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            interactionSource3 = interactionSource;
            $composer2 = $composer3;
            modifier4 = modifier2;
            leadingIcon3 = leadingIcon;
            trailingIcon3 = trailingIcon;
            enabled4 = enabled2;
            colors4 = colors2;
            contentPadding3 = contentPadding;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    leadingIcon = null;
                }
                if (i7 != 0) {
                    trailingIcon = null;
                }
                if (i8 != 0) {
                    enabled2 = true;
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty3 & (-3670017);
                    colors2 = MenuDefaults.INSTANCE.itemColors($composer3, 6);
                } else {
                    $dirty = $dirty3;
                }
                PaddingValues contentPadding4 = i2 != 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : contentPadding;
                if (i3 != 0) {
                    $composer3.startReplaceableGroup(1989948114);
                    ComposerKt.sourceInformation($composer3, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    PaddingValues contentPadding5 = contentPadding4;
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceableGroup();
                    contentPadding2 = contentPadding5;
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    trailingIcon2 = trailingIcon;
                    enabled3 = enabled2;
                    colors3 = colors2;
                    i4 = 1826340448;
                    modifier3 = modifier2;
                    leadingIcon2 = leadingIcon;
                } else {
                    contentPadding2 = contentPadding4;
                    interactionSource2 = interactionSource;
                    trailingIcon2 = trailingIcon;
                    enabled3 = enabled2;
                    colors3 = colors2;
                    i4 = 1826340448;
                    modifier3 = modifier2;
                    leadingIcon2 = leadingIcon;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    contentPadding2 = contentPadding;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty3 & (-3670017);
                    trailingIcon2 = trailingIcon;
                    enabled3 = enabled2;
                    colors3 = colors2;
                    i4 = 1826340448;
                    modifier3 = modifier2;
                    leadingIcon2 = leadingIcon;
                } else {
                    contentPadding2 = contentPadding;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty3;
                    trailingIcon2 = trailingIcon;
                    enabled3 = enabled2;
                    colors3 = colors2;
                    i4 = 1826340448;
                    modifier3 = modifier2;
                    leadingIcon2 = leadingIcon;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i4, $dirty, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:189)");
            }
            $composer2 = $composer3;
            MenuKt.DropdownMenuItemContent(function24, function02, modifier3, leadingIcon2, trailingIcon2, enabled3, colors3, contentPadding2, interactionSource2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            leadingIcon3 = leadingIcon2;
            trailingIcon3 = trailingIcon2;
            enabled4 = enabled3;
            colors4 = colors3;
            contentPadding3 = contentPadding2;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidMenu_androidKt.DropdownMenuItem.2
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
                    AndroidMenu_androidKt.DropdownMenuItem(function2, function0, modifier4, leadingIcon3, trailingIcon3, enabled4, colors4, contentPadding3, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
