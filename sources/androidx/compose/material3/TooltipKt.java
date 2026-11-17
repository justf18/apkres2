package androidx.compose.material3;

import android.content.res.Resources;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.CacheDrawScope;
import androidx.compose.p000ui.draw.DrawModifierKt;
import androidx.compose.p000ui.draw.DrawResult;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.window.PopupPositionProvider;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tooltip.kt */
@Metadata(m164d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0085\u0001\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0015\b\u0002\u0010 \u001a\u000f\u0012\u0004\u0012\u00020\u001d\u0018\u00010!¢\u0006\u0002\b\"2\u0015\b\u0002\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u001d\u0018\u00010!¢\u0006\u0002\b\"2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00012\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u001d0!¢\u0006\u0002\b\"H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001al\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/2\u001c\u00100\u001a\u0018\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001d01¢\u0006\u0002\b\"¢\u0006\u0002\b32\u0006\u00104\u001a\u0002052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002072\u0011\u00109\u001a\r\u0012\u0004\u0012\u00020\u001d0!¢\u0006\u0002\b\"H\u0007¢\u0006\u0002\u0010:\u001a&\u0010;\u001a\u0002052\b\b\u0002\u0010<\u001a\u0002072\b\b\u0002\u0010=\u001a\u0002072\b\b\u0002\u0010>\u001a\u00020?H\u0007\u001a+\u0010@\u001a\u0002052\b\b\u0002\u0010<\u001a\u0002072\b\b\u0002\u0010=\u001a\u0002072\b\b\u0002\u0010>\u001a\u00020?H\u0007¢\u0006\u0002\u0010A\u001a\u001a\u0010B\u001a\u00020\u001f*\u00020\u001f2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002070DH\u0000\u001a\u001c\u0010E\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010F\u001a\u0002072\u0006\u0010G\u001a\u000207H\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u000b\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\f\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u000f\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0010\u0010\r\"\u0010\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0012\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0013\u0010\r\"\u0010\u0010\u0014\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0015\u001a\u00020\u0016X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0016X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0018\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0019\u0010\r\"\u0016\u0010\u001a\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u001b\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H²\u0006\f\u0010I\u001a\u0004\u0018\u00010JX\u008a\u008e\u0002²\u0006\n\u0010K\u001a\u00020LX\u008a\u0084\u0002²\u0006\n\u0010M\u001a\u00020LX\u008a\u0084\u0002"}, m165d2 = {"ActionLabelBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ActionLabelMinHeight", "HeightFromSubheadToTextFirstLine", "HeightToSubheadFirstLine", "PlainTooltipContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getPlainTooltipContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "PlainTooltipHorizontalPadding", "PlainTooltipMaxWidth", "getPlainTooltipMaxWidth", "()F", "PlainTooltipVerticalPadding", "RichTooltipHorizontalPadding", "getRichTooltipHorizontalPadding", "RichTooltipMaxWidth", "SpacingBetweenTooltipAndAnchor", "getSpacingBetweenTooltipAndAnchor", "TextBottomPadding", "TooltipFadeInDuration", "", "TooltipFadeOutDuration", "TooltipMinHeight", "getTooltipMinHeight", "TooltipMinWidth", "getTooltipMinWidth", "RichTooltip", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/RichTooltipColors;", "tonalElevation", "shadowElevation", "text", "RichTooltip-1tP8Re8", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipBox", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function1;", "Landroidx/compose/material3/CaretScope;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/material3/TooltipState;", "focusable", "", "enableUserInput", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "rememberTooltipState", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "animateTooltip", "transition", "Landroidx/compose/animation/core/Transition;", "textVerticalPadding", "subheadExists", "actionExists", "material3_release", "anchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "scale", "", "alpha"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TooltipKt {
    public static final int TooltipFadeInDuration = 150;
    public static final int TooltipFadeOutDuration = 75;
    private static final float SpacingBetweenTooltipAndAnchor = C1956Dp.m6297constructorimpl(4);
    private static final float TooltipMinHeight = C1956Dp.m6297constructorimpl(24);
    private static final float TooltipMinWidth = C1956Dp.m6297constructorimpl(40);
    private static final float PlainTooltipMaxWidth = C1956Dp.m6297constructorimpl(200);
    private static final float PlainTooltipVerticalPadding = C1956Dp.m6297constructorimpl(4);
    private static final float PlainTooltipHorizontalPadding = C1956Dp.m6297constructorimpl(8);
    private static final PaddingValues PlainTooltipContentPadding = PaddingKt.m761PaddingValuesYgX7TsA(PlainTooltipHorizontalPadding, PlainTooltipVerticalPadding);
    private static final float RichTooltipMaxWidth = C1956Dp.m6297constructorimpl(320);
    private static final float RichTooltipHorizontalPadding = C1956Dp.m6297constructorimpl(16);
    private static final float HeightToSubheadFirstLine = C1956Dp.m6297constructorimpl(28);
    private static final float HeightFromSubheadToTextFirstLine = C1956Dp.m6297constructorimpl(24);
    private static final float TextBottomPadding = C1956Dp.m6297constructorimpl(16);
    private static final float ActionLabelMinHeight = C1956Dp.m6297constructorimpl(36);
    private static final float ActionLabelBottomPadding = C1956Dp.m6297constructorimpl(8);

    public static final void TooltipBox(final PopupPositionProvider positionProvider, final Function3<? super CaretScope, ? super Composer, ? super Integer, Unit> function3, final TooltipState state, Modifier modifier, boolean focusable, boolean enableUserInput, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) throws Resources.NotFoundException {
        PopupPositionProvider popupPositionProvider;
        Modifier modifier2;
        boolean focusable2;
        boolean enableUserInput2;
        Object value$iv;
        Object value$iv2;
        Composer $composer2;
        final boolean focusable3;
        final boolean enableUserInput3;
        Composer $composer3 = $composer.startRestartGroup(1836749106);
        ComposerKt.sourceInformation($composer3, "C(TooltipBox)P(4,6,5,3,2,1)120@5234L64,121@5343L33,122@5393L257,139@5846L310:Tooltip.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            popupPositionProvider = positionProvider;
        } else if (($changed & 6) == 0) {
            popupPositionProvider = positionProvider;
            $dirty |= $composer3.changed(popupPositionProvider) ? 4 : 2;
        } else {
            popupPositionProvider = positionProvider;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(state) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            focusable2 = focusable;
        } else if (($changed & 24576) == 0) {
            focusable2 = focusable;
            $dirty |= $composer3.changed(focusable2) ? 16384 : 8192;
        } else {
            focusable2 = focusable;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            enableUserInput2 = enableUserInput;
        } else if ((196608 & $changed) == 0) {
            enableUserInput2 = enableUserInput;
            $dirty |= $composer3.changed(enableUserInput2) ? 131072 : 65536;
        } else {
            enableUserInput2 = enableUserInput;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((599187 & $dirty) != 599186 || !$composer3.getSkipping()) {
            if (i2 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i3 != 0) {
                focusable2 = true;
            }
            if (i4 != 0) {
                enableUserInput2 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1836749106, $dirty, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:118)");
            }
            final Transition transition = TransitionKt.updateTransition((MutableTransitionState) state.getTransition(), "tooltip transition", $composer3, MutableTransitionState.$stable | 48, 0);
            $composer3.startReplaceableGroup(2029979988);
            ComposerKt.sourceInformation($composer3, "CC(remember):Tooltip.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState anchorBounds$delegate = (MutableState) value$iv;
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(2029980038);
            ComposerKt.sourceInformation($composer3, "CC(remember):Tooltip.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new CaretScope() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1
                    @Override // androidx.compose.material3.CaretScope
                    public Modifier drawCaret(Modifier $this$drawCaret, final Function2<? super CacheDrawScope, ? super LayoutCoordinates, DrawResult> function22) {
                        final MutableState<LayoutCoordinates> mutableState = anchorBounds$delegate;
                        return DrawModifierKt.drawWithCache($this$drawCaret, new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$drawCaret$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DrawResult invoke(CacheDrawScope $this$drawWithCache) {
                                return function22.invoke($this$drawWithCache, TooltipKt.TooltipBox$lambda$1(mutableState));
                            }
                        });
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final TooltipKt$TooltipBox$scope$1$1 scope = (TooltipKt$TooltipBox$scope$1$1) value$iv2;
            $composer3.endReplaceableGroup();
            Function2 wrappedContent = ComposableLambdaKt.composableLambda($composer3, -1130808188, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1
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
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            });
            $composer2 = $composer3;
            boolean focusable4 = focusable2;
            Modifier modifier3 = modifier2;
            BasicTooltip_androidKt.BasicTooltipBox(popupPositionProvider, ComposableLambdaKt.composableLambda($composer3, -149611544, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt.TooltipBox.1
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x016c  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r28, int r29) {
                    /*
                        Method dump skipped, instructions count: 368
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipKt.C16111.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), state, modifier3, focusable4, enableUserInput2, wrappedContent, $composer2, ($dirty & 896) | ($dirty & 14) | 1572912 | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            focusable3 = focusable4;
            enableUserInput3 = enableUserInput2;
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            focusable3 = focusable2;
            enableUserInput3 = enableUserInput2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt.TooltipBox.2
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
                    TooltipKt.TooltipBox(positionProvider, function3, state, modifier4, focusable3, enableUserInput3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates TooltipBox$lambda$1(MutableState<LayoutCoordinates> mutableState) {
        MutableState<LayoutCoordinates> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* renamed from: RichTooltip-1tP8Re8, reason: not valid java name */
    public static final void m2810RichTooltip1tP8Re8(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, RichTooltipColors colors, float tonalElevation, float shadowElevation, final Function2<? super Composer, ? super Integer, Unit> function23, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Function2 title;
        Function2 action;
        Shape shape2;
        RichTooltipColors colors2;
        float tonalElevation2;
        Modifier.Companion modifier3;
        int $dirty;
        final Function2 action2;
        final RichTooltipColors colors3;
        float tonalElevation3;
        int i2;
        int i3;
        float shadowElevation2;
        Composer $composer2;
        final Modifier modifier4;
        final RichTooltipColors colors4;
        final float shadowElevation3;
        final Function2 action3;
        final Function2 title2;
        final float tonalElevation4;
        final Shape shape3;
        Composer $composer3 = $composer.startRestartGroup(1589779214);
        ComposerKt.sourceInformation($composer3, "C(RichTooltip)P(2,6!1,4!1,7:c#ui.unit.Dp,3:c#ui.unit.Dp)230@9367L25,231@9442L19,236@9631L2169:Tooltip.kt#uh7d8r");
        int $dirty2 = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty2 |= 48;
            title = function2;
        } else if (($changed & 48) == 0) {
            title = function2;
            $dirty2 |= $composer3.changedInstance(title) ? 32 : 16;
        } else {
            title = function2;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            action = function22;
        } else if (($changed & 384) == 0) {
            action = function22;
            $dirty2 |= $composer3.changedInstance(action) ? 256 : 128;
        } else {
            action = function22;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                int i7 = $composer3.changed(shape2) ? 2048 : 1024;
                $dirty2 |= i7;
            } else {
                shape2 = shape;
            }
            $dirty2 |= i7;
        } else {
            shape2 = shape;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                colors2 = colors;
                int i8 = $composer3.changed(colors2) ? 16384 : 8192;
                $dirty2 |= i8;
            } else {
                colors2 = colors;
            }
            $dirty2 |= i8;
        } else {
            colors2 = colors;
        }
        int i9 = i & 32;
        if (i9 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            tonalElevation2 = tonalElevation;
        } else if ((196608 & $changed) == 0) {
            tonalElevation2 = tonalElevation;
            $dirty2 |= $composer3.changed(tonalElevation2) ? 131072 : 65536;
        } else {
            tonalElevation2 = tonalElevation;
        }
        int i10 = i & 64;
        if (i10 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changed(shadowElevation) ? 1048576 : 524288;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function23) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty2) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            shadowElevation3 = shadowElevation;
            $composer2 = $composer3;
            modifier4 = modifier2;
            action3 = action;
            colors4 = colors2;
            title2 = title;
            tonalElevation4 = tonalElevation2;
            shape3 = shape2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (i5 != 0) {
                    title = null;
                }
                if (i6 != 0) {
                    action = null;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    shape2 = TooltipDefaults.INSTANCE.getRichTooltipContainerShape($composer3, 6);
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    colors2 = TooltipDefaults.INSTANCE.richTooltipColors($composer3, 6);
                }
                if (i9 != 0) {
                    tonalElevation2 = RichTooltipTokens.INSTANCE.m3312getContainerElevationD9Ej5fM();
                }
                if (i10 != 0) {
                    $dirty = $dirty2;
                    action2 = action;
                    tonalElevation3 = tonalElevation2;
                    i2 = 12582912;
                    i3 = 1589779214;
                    shadowElevation2 = RichTooltipTokens.INSTANCE.m3312getContainerElevationD9Ej5fM();
                    colors3 = colors2;
                } else {
                    $dirty = $dirty2;
                    action2 = action;
                    colors3 = colors2;
                    tonalElevation3 = tonalElevation2;
                    i2 = 12582912;
                    i3 = 1589779214;
                    shadowElevation2 = shadowElevation;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    int i11 = $dirty2 & (-57345);
                    Modifier modifier5 = modifier2;
                    $dirty = i11;
                    modifier3 = modifier5;
                    action2 = action;
                    colors3 = colors2;
                    tonalElevation3 = tonalElevation2;
                    i2 = 12582912;
                    i3 = 1589779214;
                    shadowElevation2 = shadowElevation;
                } else {
                    modifier3 = modifier2;
                    colors3 = colors2;
                    tonalElevation3 = tonalElevation2;
                    i2 = 12582912;
                    i3 = 1589779214;
                    shadowElevation2 = shadowElevation;
                    $dirty = $dirty2;
                    action2 = action;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i3, $dirty, -1, "androidx.compose.material3.RichTooltip (Tooltip.kt:235)");
            }
            $composer2 = $composer3;
            SurfaceKt.m2519SurfaceT9BRK9s(SizeKt.m820sizeInqDBjuR0$default(modifier3, TooltipMinWidth, TooltipMinHeight, RichTooltipMaxWidth, 0.0f, 8, null), shape2, colors3.getContainerColor(), 0L, tonalElevation3, shadowElevation2, null, ComposableLambdaKt.composableLambda($composer3, 4342931, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$RichTooltip$1
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
                    Composer $composer$iv;
                    Function2 function24;
                    Function0 factory$iv$iv$iv2;
                    Function0 factory$iv$iv$iv3;
                    Function0 factory$iv$iv$iv4;
                    int $changed$iv;
                    Composer $composer5;
                    ComposerKt.sourceInformation($composer4, "C249@10055L10,251@10172L10,253@10284L10,255@10352L1442:Tooltip.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(4342931, $changed2, -1, "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.kt:248)");
                        }
                        TextStyle actionLabelTextStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer4, 6), RichTooltipTokens.INSTANCE.getActionLabelTextFont());
                        TextStyle subheadTextStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer4, 6), RichTooltipTokens.INSTANCE.getSubheadFont());
                        TextStyle supportingTextStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer4, 6), RichTooltipTokens.INSTANCE.getSupportingTextFont());
                        Modifier modifier$iv = PaddingKt.m769paddingVpY3zN4$default(Modifier.INSTANCE, TooltipKt.getRichTooltipHorizontalPadding(), 0.0f, 2, null);
                        Function2 it = title;
                        Function2 it2 = action2;
                        RichTooltipColors richTooltipColors = colors3;
                        Function2<Composer, Integer, Unit> function25 = function23;
                        $composer4.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation($composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        int $changed$iv$iv = (6 << 3) & 112;
                        $composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Function0 factory$iv$iv$iv5 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv5;
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv5;
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
                        int i12 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i13 = ((6 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1216116127, "C269@10905L349:Tooltip.kt#uh7d8r");
                        $composer4.startReplaceableGroup(-1216116120);
                        ComposerKt.sourceInformation($composer4, "*259@10496L382");
                        if (it == null) {
                            $composer$iv = $composer4;
                            function24 = it;
                        } else {
                            $composer$iv = $composer4;
                            function24 = it;
                            Modifier modifier$iv2 = AlignmentLineKt.m651paddingFromBaselineVpY3zN4$default(Modifier.INSTANCE, TooltipKt.HeightToSubheadFirstLine, 0.0f, 2, null);
                            $composer4.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                            int $changed$iv$iv2 = (6 << 3) & 112;
                            $composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                            Function0 factory$iv$iv$iv6 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.modifierMaterializerOf(modifier$iv2);
                            int $i$f$Box = $changed$iv$iv2 << 9;
                            int $changed$iv$iv$iv2 = ($i$f$Box & 7168) | 6;
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                                $composer4.createNode(factory$iv$iv$iv2);
                            } else {
                                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3479constructorimpl($composer4);
                            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
                            }
                            skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                            $composer4.startReplaceableGroup(2058660585);
                            int i14 = ($changed$iv$iv$iv2 >> 9) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int i15 = ((6 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -137016375, "C262@10633L227:Tooltip.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3939boximpl(richTooltipColors.getTitleContentColor())), TextKt.getLocalTextStyle().provides(subheadTextStyle)}, (Function2<? super Composer, ? super Integer, Unit>) it, $composer4, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endReplaceableGroup();
                            $composer4.endNode();
                            $composer4.endReplaceableGroup();
                            $composer4.endReplaceableGroup();
                            Unit unit = Unit.INSTANCE;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        $composer4.endReplaceableGroup();
                        Modifier modifier$iv3 = TooltipKt.textVerticalPadding(Modifier.INSTANCE, function24 != null, it2 != null);
                        $composer4.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv3 = (0 << 3) & 112;
                        $composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                        Function0 factory$iv$iv$iv7 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.modifierMaterializerOf(modifier$iv3);
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv7;
                            $composer4.createNode(factory$iv$iv$iv3);
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv7;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3479constructorimpl($composer4);
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), block$iv$iv$iv3);
                        }
                        skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
                        $composer4.startReplaceableGroup(2058660585);
                        int i16 = ($changed$iv$iv$iv3 >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        int i17 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1307460020, "C272@11029L211:Tooltip.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3939boximpl(richTooltipColors.getContentColor())), TextKt.getLocalTextStyle().provides(supportingTextStyle)}, function25, $composer4, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endReplaceableGroup();
                        $composer4.endNode();
                        $composer4.endReplaceableGroup();
                        $composer4.endReplaceableGroup();
                        $composer4.startReplaceableGroup(-8196376);
                        ComposerKt.sourceInformation($composer4, "*279@11297L473");
                        if (it2 == null) {
                            $composer5 = $composer4;
                        } else {
                            Modifier modifier$iv4 = PaddingKt.m771paddingqDBjuR0$default(SizeKt.m807requiredHeightInVpY3zN4$default(Modifier.INSTANCE, TooltipKt.ActionLabelMinHeight, 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TooltipKt.ActionLabelBottomPadding, 7, null);
                            $composer4.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
                            MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                            int $changed$iv$iv4 = (6 << 3) & 112;
                            $composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                            Function0 factory$iv$iv$iv8 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv4 = LayoutKt.modifierMaterializerOf(modifier$iv4);
                            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 9) & 7168) | 6;
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                                $composer4.createNode(factory$iv$iv$iv4);
                            } else {
                                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3479constructorimpl($composer4);
                            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2 block$iv$iv$iv4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                                $changed$iv = 6;
                            } else {
                                $changed$iv = 6;
                                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                                }
                                skippableUpdate$iv$iv$iv4.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & 112));
                                $composer4.startReplaceableGroup(2058660585);
                                int i18 = ($changed$iv$iv$iv4 >> 9) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                int i19 = (($changed$iv >> 6) & 112) | 6;
                                $composer5 = $composer4;
                                ComposerKt.sourceInformationMarkerStart($composer4, -137015488, "C284@11520L232:Tooltip.kt#uh7d8r");
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3939boximpl(richTooltipColors.getActionContentColor())), TextKt.getLocalTextStyle().provides(actionLabelTextStyle)}, (Function2<? super Composer, ? super Integer, Unit>) it2, $composer4, 0);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer5.endReplaceableGroup();
                                $composer5.endNode();
                                $composer5.endReplaceableGroup();
                                $composer5.endReplaceableGroup();
                                Unit unit3 = Unit.INSTANCE;
                                Unit unit4 = Unit.INSTANCE;
                            }
                            $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                            $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), block$iv$iv$iv4);
                            skippableUpdate$iv$iv$iv4.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & 112));
                            $composer4.startReplaceableGroup(2058660585);
                            int i182 = ($changed$iv$iv$iv4 >> 9) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance32 = BoxScopeInstance.INSTANCE;
                            int i192 = (($changed$iv >> 6) & 112) | 6;
                            $composer5 = $composer4;
                            ComposerKt.sourceInformationMarkerStart($composer4, -137015488, "C284@11520L232:Tooltip.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3939boximpl(richTooltipColors.getActionContentColor())), TextKt.getLocalTextStyle().provides(actionLabelTextStyle)}, (Function2<? super Composer, ? super Integer, Unit>) it2, $composer4, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer5.endReplaceableGroup();
                            $composer5.endNode();
                            $composer5.endReplaceableGroup();
                            $composer5.endReplaceableGroup();
                            Unit unit32 = Unit.INSTANCE;
                            Unit unit42 = Unit.INSTANCE;
                        }
                        $composer5.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
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
            }), $composer2, (($dirty >> 6) & 112) | i2 | (($dirty >> 3) & 57344) | (458752 & ($dirty >> 3)), 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            colors4 = colors3;
            shadowElevation3 = shadowElevation2;
            action3 = action2;
            title2 = title;
            tonalElevation4 = tonalElevation3;
            shape3 = shape2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$RichTooltip$2
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
                    TooltipKt.m2810RichTooltip1tP8Re8(modifier4, title2, action3, shape3, colors4, tonalElevation4, shadowElevation3, function23, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final TooltipState rememberTooltipState(boolean initialIsVisible, boolean isPersistent, MutatorMutex mutatorMutex, Composer $composer, int $changed, int i) {
        Object value$iv;
        $composer.startReplaceableGroup(-1413230530);
        ComposerKt.sourceInformation($composer, "C(rememberTooltipState)513@20571L232:Tooltip.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialIsVisible = false;
        }
        if ((i & 2) != 0) {
            isPersistent = false;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1413230530, $changed, -1, "androidx.compose.material3.rememberTooltipState (Tooltip.kt:513)");
        }
        $composer.startReplaceableGroup(512858205);
        ComposerKt.sourceInformation($composer, "CC(remember):Tooltip.kt#9igjgp");
        boolean invalid$iv = (((($changed & 112) ^ 48) > 32 && $composer.changed(isPersistent)) || ($changed & 48) == 32) | (((($changed & 896) ^ 384) > 256 && $composer.changed(mutatorMutex)) || ($changed & 384) == 256);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new TooltipStateImpl(initialIsVisible, isPersistent, mutatorMutex);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) value$iv;
        $composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return tooltipStateImpl;
    }

    public static /* synthetic */ TooltipState TooltipState$default(boolean z, boolean z2, MutatorMutex mutatorMutex, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return TooltipState(z, z2, mutatorMutex);
    }

    public static final TooltipState TooltipState(boolean initialIsVisible, boolean isPersistent, MutatorMutex mutatorMutex) {
        return new TooltipStateImpl(initialIsVisible, isPersistent, mutatorMutex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier textVerticalPadding(Modifier $this$textVerticalPadding, boolean subheadExists, boolean actionExists) {
        if (!subheadExists && !actionExists) {
            return PaddingKt.m769paddingVpY3zN4$default($this$textVerticalPadding, 0.0f, PlainTooltipVerticalPadding, 1, null);
        }
        return PaddingKt.m771paddingqDBjuR0$default(AlignmentLineKt.m651paddingFromBaselineVpY3zN4$default($this$textVerticalPadding, HeightFromSubheadToTextFirstLine, 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TextBottomPadding, 7, null);
    }

    public static final Modifier animateTooltip(Modifier $this$animateTooltip, final Transition<Boolean> transition) {
        return ComposedModifierKt.composed($this$animateTooltip, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                $this$null.setName("animateTooltip");
                $this$null.getProperties().set("transition", transition);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TooltipKt.animateTooltip.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            private static final float invoke$lambda$1(State<Float> state) {
                Object thisObj$iv = state.getValue();
                return ((Number) thisObj$iv).floatValue();
            }

            public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
                Transition $this$animateValue$iv$iv;
                String str;
                Composer $composer2;
                Transition $this$animateValue$iv$iv2;
                boolean it;
                boolean it2;
                $composer.startReplaceableGroup(-1498516085);
                ComposerKt.sourceInformation($composer, "C655@25162L583,674@25775L561:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1498516085, $changed, -1, "androidx.compose.material3.animateTooltip.<anonymous> (Tooltip.kt:655)");
                }
                Transition $this$animateFloat$iv = transition;
                Function3 transitionSpec$iv = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$scale$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer, Integer num) {
                        return invoke(segment, composer, num.intValue());
                    }

                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer $composer3, int $changed2) {
                        TweenSpec tweenSpecTween$default;
                        $composer3.startReplaceableGroup(386845748);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(386845748, $changed2, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:657)");
                        }
                        if (segment.isTransitioningTo(false, true)) {
                            tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                        } else {
                            tweenSpecTween$default = AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        $composer3.endReplaceableGroup();
                        return tweenSpecTween$default;
                    }
                };
                $composer.startReplaceableGroup(-1338768149);
                ComposerKt.sourceInformation($composer, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                TwoWayConverter typeConverter$iv$iv = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                int $changed$iv$iv = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
                $composer.startReplaceableGroup(-142660079);
                ComposerKt.sourceInformation($composer, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                int $changed2 = ($changed$iv$iv >> 9) & 112;
                boolean it3 = $this$animateFloat$iv.getCurrentState().booleanValue();
                $composer.startReplaceableGroup(-1553362193);
                ComposerKt.sourceInformation($composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    $this$animateValue$iv$iv = $this$animateFloat$iv;
                    str = "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli";
                    ComposerKt.traceEventStart(-1553362193, $changed2, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:672)");
                } else {
                    $this$animateValue$iv$iv = $this$animateFloat$iv;
                    str = "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli";
                }
                float f = it3 ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                Object initialValue$iv$iv = Float.valueOf(f);
                int $changed3 = ($changed$iv$iv >> 9) & 112;
                boolean it4 = $this$animateValue$iv$iv.getTargetState().booleanValue();
                $composer.startReplaceableGroup(-1553362193);
                ComposerKt.sourceInformation($composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    $composer2 = $composer;
                    ComposerKt.traceEventStart(-1553362193, $changed3, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:672)");
                } else {
                    $composer2 = $composer;
                }
                float f2 = it4 ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceableGroup();
                Object targetValue$iv$iv = Float.valueOf(f2);
                FiniteAnimationSpec<Float> animationSpec$iv$iv = transitionSpec$iv.invoke($this$animateValue$iv$iv.getSegment(), $composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
                State scale$delegate = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv, initialValue$iv$iv, targetValue$iv$iv, animationSpec$iv$iv, typeConverter$iv$iv, "tooltip transition: scaling", $composer, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
                Transition $this$animateFloat$iv2 = transition;
                Function3 transitionSpec$iv2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$alpha$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer, Integer num) {
                        return invoke(segment, composer, num.intValue());
                    }

                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer $composer3, int $changed4) {
                        TweenSpec tweenSpecTween$default;
                        $composer3.startReplaceableGroup(-281714272);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-281714272, $changed4, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:676)");
                        }
                        if (segment.isTransitioningTo(false, true)) {
                            tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearEasing(), 2, null);
                        } else {
                            tweenSpecTween$default = AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearEasing(), 2, null);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        $composer3.endReplaceableGroup();
                        return tweenSpecTween$default;
                    }
                };
                $composer.startReplaceableGroup(-1338768149);
                ComposerKt.sourceInformation($composer, str);
                TwoWayConverter typeConverter$iv$iv2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                int $changed$iv$iv2 = (384 & 14) | ((384 << 3) & 896) | ((384 << 3) & 7168) | ((384 << 3) & 57344);
                $composer.startReplaceableGroup(-142660079);
                ComposerKt.sourceInformation($composer, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                int $changed4 = ($changed$iv$iv2 >> 9) & 112;
                boolean it5 = $this$animateFloat$iv2.getCurrentState().booleanValue();
                $composer.startReplaceableGroup(2073045083);
                ComposerKt.sourceInformation($composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    $this$animateValue$iv$iv2 = $this$animateFloat$iv2;
                    it = it5;
                    ComposerKt.traceEventStart(2073045083, $changed4, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:691)");
                } else {
                    $this$animateValue$iv$iv2 = $this$animateFloat$iv2;
                    it = it5;
                }
                float f3 = it ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                Object initialValue$iv$iv2 = Float.valueOf(f3);
                int $changed5 = ($changed$iv$iv2 >> 9) & 112;
                boolean it6 = $this$animateValue$iv$iv2.getTargetState().booleanValue();
                $composer.startReplaceableGroup(2073045083);
                ComposerKt.sourceInformation($composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    it2 = it6;
                    ComposerKt.traceEventStart(2073045083, $changed5, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:691)");
                } else {
                    it2 = it6;
                }
                float f4 = it2 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                Object targetValue$iv$iv2 = Float.valueOf(f4);
                FiniteAnimationSpec<Float> animationSpec$iv$iv2 = transitionSpec$iv2.invoke($this$animateValue$iv$iv2.getSegment(), $composer, Integer.valueOf(($changed$iv$iv2 >> 3) & 112));
                State alpha$delegate = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv2, initialValue$iv$iv2, targetValue$iv$iv2, animationSpec$iv$iv2, typeConverter$iv$iv2, "tooltip transition: alpha", $composer, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
                Modifier modifierM4110graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4110graphicsLayerAp8cVGQ$default($this$composed, invoke$lambda$1(scale$delegate), invoke$lambda$1(scale$delegate), invoke$lambda$3(alpha$delegate), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return modifierM4110graphicsLayerAp8cVGQ$default;
            }

            private static final float invoke$lambda$3(State<Float> state) {
                Object thisObj$iv = state.getValue();
                return ((Number) thisObj$iv).floatValue();
            }
        });
    }

    public static final float getSpacingBetweenTooltipAndAnchor() {
        return SpacingBetweenTooltipAndAnchor;
    }

    public static final float getTooltipMinHeight() {
        return TooltipMinHeight;
    }

    public static final float getTooltipMinWidth() {
        return TooltipMinWidth;
    }

    public static final float getPlainTooltipMaxWidth() {
        return PlainTooltipMaxWidth;
    }

    public static final PaddingValues getPlainTooltipContentPadding() {
        return PlainTooltipContentPadding;
    }

    public static final float getRichTooltipHorizontalPadding() {
        return RichTooltipHorizontalPadding;
    }
}
