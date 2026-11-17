package androidx.compose.material3;

import android.content.res.Resources;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.CacheDrawScope;
import androidx.compose.p000ui.draw.DrawModifierKt;
import androidx.compose.p000ui.draw.DrawResult;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.window.PopupPositionProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Label.kt */
@Metadata(m164d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\b\u001a\\\u0010\t\u001a\u00020\u00012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002"}, m165d2 = {"HandleInteractions", "", "enabled", "", "state", "Landroidx/compose/material3/BasicTooltipState;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLandroidx/compose/material3/BasicTooltipState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "Label", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/CaretScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "isPersistent", "content", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release", "anchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LabelKt {
    public static final void Label(final Function3<? super CaretScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, MutableInteractionSource interactionSource, boolean isPersistent, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) throws Resources.NotFoundException {
        Modifier modifier2;
        MutableInteractionSource mutableInteractionSource;
        boolean z;
        MutableInteractionSource interactionSource2;
        PopupPositionProvider positionProvider;
        Modifier modifier3;
        boolean z2;
        BasicTooltipState state;
        boolean z3;
        Object value$iv;
        Object value$iv2;
        final MutableInteractionSource interactionSource3;
        final boolean isPersistent2;
        Object value$iv3;
        Object value$iv4;
        Composer $composer2 = $composer.startRestartGroup(-544399326);
        ComposerKt.sourceInformation($composer2, "C(Label)P(3,4,1,2)66@2846L39,71@3060L38,77@3290L33,78@3340L257,95@3793L249,104@4047L127:Label.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 384) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty |= $composer2.changed(mutableInteractionSource) ? 256 : 128;
        } else {
            mutableInteractionSource = interactionSource;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            z = isPersistent;
        } else if (($changed & 3072) == 0) {
            z = isPersistent;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = isPersistent;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 16384 : 8192;
        }
        if (($dirty & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            interactionSource3 = mutableInteractionSource;
            isPersistent2 = z;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (i3 != 0) {
                $composer2.startReplaceableGroup(-2061465011);
                ComposerKt.sourceInformation($composer2, "CC(remember):Label.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = InteractionSourceKt.MutableInteractionSource();
                    $composer2.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv;
                }
                interactionSource2 = (MutableInteractionSource) value$iv4;
                $composer2.endReplaceableGroup();
            } else {
                interactionSource2 = mutableInteractionSource;
            }
            boolean isPersistent3 = i4 != 0 ? false : z;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-544399326, $dirty, -1, "androidx.compose.material3.Label (Label.kt:69)");
            }
            PopupPositionProvider positionProvider2 = TooltipDefaults.INSTANCE.m2807rememberPlainTooltipPositionProviderkHDZbjc(0.0f, $composer2, 48, 1);
            if (isPersistent3) {
                $composer2.startReplaceableGroup(-2061464716);
                ComposerKt.sourceInformation($composer2, "73@3141L29");
                $composer2.startReplaceableGroup(-2061464716);
                ComposerKt.sourceInformation($composer2, "CC(remember):Label.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                    positionProvider = positionProvider2;
                    modifier3 = modifier4;
                    value$iv3 = new LabelStateImpl(false, false, 3, null);
                    $composer2.updateRememberedValue(value$iv3);
                } else {
                    positionProvider = positionProvider2;
                    modifier3 = modifier4;
                    value$iv3 = it$iv2;
                }
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                state = (LabelStateImpl) value$iv3;
                z2 = false;
            } else {
                positionProvider = positionProvider2;
                modifier3 = modifier4;
                $composer2.startReplaceableGroup(-2061464669);
                ComposerKt.sourceInformation($composer2, "75@3188L56");
                z2 = false;
                BasicTooltipState basicTooltipStateRememberBasicTooltipState = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), $composer2, 0, 3);
                $composer2.endReplaceableGroup();
                state = basicTooltipStateRememberBasicTooltipState;
            }
            $composer2.startReplaceableGroup(-2061464567);
            ComposerKt.sourceInformation($composer2, "CC(remember):Label.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                z3 = z2;
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                z3 = z2;
                value$iv = it$iv3;
            }
            final MutableState anchorBounds$delegate = (MutableState) value$iv;
            $composer2.endReplaceableGroup();
            $composer2.startReplaceableGroup(-2061464517);
            ComposerKt.sourceInformation($composer2, "CC(remember):Label.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new CaretScope() { // from class: androidx.compose.material3.LabelKt$Label$scope$1$1
                    @Override // androidx.compose.material3.CaretScope
                    public Modifier drawCaret(Modifier $this$drawCaret, final Function2<? super CacheDrawScope, ? super LayoutCoordinates, DrawResult> function22) {
                        final MutableState<LayoutCoordinates> mutableState = anchorBounds$delegate;
                        return DrawModifierKt.drawWithCache($this$drawCaret, new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.material3.LabelKt$Label$scope$1$1$drawCaret$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DrawResult invoke(CacheDrawScope $this$drawWithCache) {
                                return function22.invoke($this$drawWithCache, LabelKt.Label$lambda$3(mutableState));
                            }
                        });
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv4;
            }
            final LabelKt$Label$scope$1$1 scope = (LabelKt$Label$scope$1$1) value$iv2;
            $composer2.endReplaceableGroup();
            Function2 wrappedContent = ComposableLambdaKt.composableLambda($composer2, 1950723216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$wrappedContent$1
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

                /* JADX WARN: Removed duplicated region for block: B:32:0x019a  */
                /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r27, int r28) {
                    /*
                        Method dump skipped, instructions count: 414
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.LabelKt$Label$wrappedContent$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            });
            BasicTooltip_androidKt.BasicTooltipBox(positionProvider, ComposableLambdaKt.composableLambda($composer2, 784196780, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt.Label.2
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

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C97@3881L7:Label.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(784196780, $changed2, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:97)");
                    }
                    function3.invoke(scope, $composer3, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), state, modifier3, false, false, wrappedContent, $composer2, (($dirty << 6) & 7168) | 1794096, 0);
            $composer2 = $composer2;
            HandleInteractions(!isPersistent3, state, interactionSource2, $composer2, $dirty & 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource3 = interactionSource2;
            isPersistent2 = isPersistent3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt.Label.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Resources.NotFoundException {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) throws Resources.NotFoundException {
                    LabelKt.Label(function3, modifier5, interactionSource3, isPersistent2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates Label$lambda$3(MutableState<LayoutCoordinates> mutableState) {
        MutableState<LayoutCoordinates> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HandleInteractions(final boolean enabled, final BasicTooltipState state, final MutableInteractionSource interactionSource, Composer $composer, final int $changed) {
        LabelKt$HandleInteractions$1$1 value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1479255681);
        ComposerKt.sourceInformation($composer2, "C(HandleInteractions)P(!1,2)119@4427L499,119@4393L533:Label.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(enabled) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1479255681, $dirty, -1, "androidx.compose.material3.HandleInteractions (Label.kt:117)");
            }
            if (enabled) {
                $composer2.startReplaceableGroup(-404204353);
                ComposerKt.sourceInformation($composer2, "CC(remember):Label.kt#9igjgp");
                boolean invalid$iv = (($dirty & 896) == 256) | (($dirty & 112) == 32);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new LabelKt$HandleInteractions$1$1(interactionSource, state, null);
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer2.endReplaceableGroup();
                EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv, $composer2, ($dirty >> 6) & 14);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt.HandleInteractions.2
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
                    LabelKt.HandleInteractions(enabled, state, interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
