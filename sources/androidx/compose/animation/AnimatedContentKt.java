package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedContent.kt */
@Metadata(m164d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a´\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0017\u001aP\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2>\b\u0002\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u0014\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020!2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0086\u0004\u001a\u0015\u0010'\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0087\u0004¨\u0006("}, m165d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "label", "", "contentKey", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "with", "animation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnimatedContentKt {
    public static final <S> void AnimatedContent(final S s, Modifier modifier, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, Alignment contentAlignment, String label, Function1<? super S, ? extends Object> function12, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) throws Throwable {
        Modifier modifier2;
        Function1 transitionSpec;
        Alignment contentAlignment2;
        String str;
        int i2;
        Function1 function13;
        int i3;
        Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function42;
        Modifier modifier3;
        final String label2;
        final Function1 transitionSpec2;
        final Alignment contentAlignment3;
        final Function1 contentKey;
        Composer $composer2 = $composer.startRestartGroup(2132720749);
        ComposerKt.sourceInformation($composer2, "C(AnimatedContent)P(5,4,6,1,3,2)139@7459L58,140@7533L136:AnimatedContent.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(s) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            transitionSpec = function1;
        } else if (($changed & 896) == 0) {
            transitionSpec = function1;
            $dirty |= $composer2.changedInstance(transitionSpec) ? 256 : 128;
        } else {
            transitionSpec = function1;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            contentAlignment2 = contentAlignment;
        } else if (($changed & 7168) == 0) {
            contentAlignment2 = contentAlignment;
            $dirty |= $composer2.changed(contentAlignment2) ? 2048 : 1024;
        } else {
            contentAlignment2 = contentAlignment;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            str = label;
        } else if (($changed & 57344) == 0) {
            str = label;
            $dirty |= $composer2.changed(str) ? 16384 : 8192;
        } else {
            str = label;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            i2 = 57344;
            function13 = function12;
        } else if (($changed & 458752) == 0) {
            i2 = 57344;
            function13 = function12;
            $dirty |= $composer2.changedInstance(function13) ? 131072 : 65536;
        } else {
            i2 = 57344;
            function13 = function12;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
            i3 = 458752;
            function42 = function4;
        } else if (($changed & 3670016) == 0) {
            i3 = 458752;
            function42 = function4;
            $dirty |= $composer2.changedInstance(function42) ? 1048576 : 524288;
        } else {
            i3 = 458752;
            function42 = function4;
        }
        if (($dirty & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            transitionSpec2 = transitionSpec;
            contentAlignment3 = contentAlignment2;
            contentKey = function13;
            label2 = str;
        } else {
            Modifier.Companion modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (i5 != 0) {
                transitionSpec = new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.1
                    @Override // kotlin.jvm.functions.Function1
                    public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m278scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                    }
                };
            }
            if (i6 != 0) {
                contentAlignment2 = Alignment.INSTANCE.getTopStart();
            }
            String label3 = i7 != 0 ? "AnimatedContent" : str;
            Function1 contentKey2 = i8 != 0 ? new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.2
                @Override // kotlin.jvm.functions.Function1
                public final S invoke(S s2) {
                    return s2;
                }
            } : function13;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2132720749, $dirty, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:138)");
            }
            Transition transition = androidx.compose.animation.core.TransitionKt.updateTransition(s, label3, $composer2, ($dirty & 8) | ($dirty & 14) | (($dirty >> 9) & 112), 0);
            modifier3 = modifier4;
            Function1 transitionSpec3 = transitionSpec;
            Alignment contentAlignment4 = contentAlignment2;
            AnimatedContent(transition, modifier3, transitionSpec3, contentAlignment4, contentKey2, function42, $composer2, ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 3) & i2) | (($dirty >> 3) & i3), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            label2 = label3;
            transitionSpec2 = transitionSpec3;
            contentAlignment3 = contentAlignment4;
            contentKey = contentKey2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Throwable {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i9) throws Throwable {
                    AnimatedContentKt.AnimatedContent(s, modifier5, transitionSpec2, contentAlignment3, label2, contentKey, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = new Function2<IntSize, IntSize, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentKt.SizeTransform.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(IntSize intSize, IntSize intSize2) {
                    return m242invokeTemP2vQ(intSize.getPackedValue(), intSize2.getPackedValue());
                }

                /* renamed from: invoke-TemP2vQ, reason: not valid java name */
                public final SpringSpec<IntSize> m242invokeTemP2vQ(long j, long j2) {
                    return AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m6459boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
                }
            };
        }
        return SizeTransform(z, function2);
    }

    public static final SizeTransform SizeTransform(boolean clip, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> function2) {
        return new SizeTransformImpl(clip, function2);
    }

    public static final ContentTransform togetherWith(EnterTransition $this$togetherWith, ExitTransition exit) {
        return new ContentTransform($this$togetherWith, exit, 0.0f, null, 12, null);
    }

    @Deprecated(message = "Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith = @ReplaceWith(expression = "togetherWith(exit)", imports = {}))
    public static final ContentTransform with(EnterTransition $this$with, ExitTransition exit) {
        return new ContentTransform($this$with, exit, 0.0f, null, 12, null);
    }

    public static final <S> void AnimatedContent(final Transition<S> transition, Modifier modifier, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, Alignment contentAlignment, Function1<? super S, ? extends Object> function12, final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, Composer $composer, final int $changed, final int i) throws Throwable {
        Modifier modifier2;
        Function1 function13;
        Alignment contentAlignment2;
        Function1 contentKey;
        Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function42;
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        int i2;
        Object value$iv$iv4;
        Function0 factory$iv$iv;
        final Function1 transitionSpec;
        final Modifier modifier3;
        final Alignment contentAlignment3;
        final Function1 contentKey2;
        Composer $composer2 = $composer.startRestartGroup(-114689412);
        ComposerKt.sourceInformation($composer2, "C(AnimatedContent)P(3,4,1,2)666@34009L7,667@34037L106,671@34231L51,672@34304L62,760@38852L58,761@38944L45,771@39263L52,762@38994L327:AnimatedContent.kt#xbi5r1");
        int $dirty = $changed;
        if ((i & Integer.MIN_VALUE) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(transition) ? 4 : 2;
        }
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 384;
            function13 = function1;
        } else if (($changed & 896) == 0) {
            function13 = function1;
            $dirty |= $composer2.changedInstance(function13) ? 256 : 128;
        } else {
            function13 = function1;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 3072;
            contentAlignment2 = contentAlignment;
        } else if (($changed & 7168) == 0) {
            contentAlignment2 = contentAlignment;
            $dirty |= $composer2.changed(contentAlignment2) ? 2048 : 1024;
        } else {
            contentAlignment2 = contentAlignment;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 24576;
            contentKey = function12;
        } else if ((57344 & $changed) == 0) {
            contentKey = function12;
            $dirty |= $composer2.changedInstance(contentKey) ? 16384 : 8192;
        } else {
            contentKey = function12;
        }
        if ((i & 16) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            function42 = function4;
        } else if ((458752 & $changed) == 0) {
            function42 = function4;
            $dirty |= $composer2.changedInstance(function42) ? 131072 : 65536;
        } else {
            function42 = function4;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            transitionSpec = function13;
            contentAlignment3 = contentAlignment2;
            contentKey2 = contentKey;
        } else {
            Modifier modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier2;
            final Function1 transitionSpec2 = i4 != 0 ? new Function1<AnimatedContentTransitionScope<S>, ContentTransform>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.4
                @Override // kotlin.jvm.functions.Function1
                public final ContentTransform invoke(AnimatedContentTransitionScope<S> animatedContentTransitionScope) {
                    return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m278scaleInL8ZKhE$default(AnimationSpecKt.tween$default(220, 90, null, 4, null), 0.92f, 0L, 4, null)), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(90, 0, null, 6, null), 0.0f, 2, null));
                }
            } : function13;
            if (i5 != 0) {
                contentAlignment2 = Alignment.INSTANCE.getTopStart();
            }
            if (i6 != 0) {
                contentKey = new Function1<S, S>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.5
                    @Override // kotlin.jvm.functions.Function1
                    public final S invoke(S s) {
                        return s;
                    }
                };
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-114689412, $dirty2, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:665)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            int i7 = $dirty2 & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(transition);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new AnimatedContentTransitionScopeImpl(transition, contentAlignment2, layoutDirection);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            final AnimatedContentTransitionScopeImpl rootScope = (AnimatedContentTransitionScopeImpl) value$iv$iv;
            int i8 = $dirty2 & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer2.changed(transition);
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = SnapshotStateKt.mutableStateListOf(transition.getCurrentState());
                $composer2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            final SnapshotStateList currentlyVisible = (SnapshotStateList) value$iv$iv2;
            int i9 = $dirty2 & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv3 = $composer2.changed(transition);
            Object it$iv$iv3 = $composer2.rememberedValue();
            if (invalid$iv$iv3 || it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = new LinkedHashMap();
                $composer2.updateRememberedValue(value$iv$iv3);
            } else {
                value$iv$iv3 = it$iv$iv3;
            }
            $composer2.endReplaceableGroup();
            Map contentMap = (Map) value$iv$iv3;
            if (!currentlyVisible.contains(transition.getCurrentState())) {
                currentlyVisible.clear();
                currentlyVisible.add(transition.getCurrentState());
            }
            if (Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState())) {
                if (currentlyVisible.size() != 1 || !Intrinsics.areEqual(currentlyVisible.get(0), transition.getCurrentState())) {
                    currentlyVisible.clear();
                    currentlyVisible.add(transition.getCurrentState());
                }
                if (contentMap.size() != 1 || contentMap.containsKey(transition.getCurrentState())) {
                    contentMap.clear();
                }
                rootScope.setContentAlignment(contentAlignment2);
                rootScope.setLayoutDirection$animation_release(layoutDirection);
            }
            if (!Intrinsics.areEqual(transition.getCurrentState(), transition.getTargetState()) && !currentlyVisible.contains(transition.getTargetState())) {
                SnapshotStateList $this$indexOfFirst$iv = currentlyVisible;
                int index$iv = 0;
                Iterator it = $this$indexOfFirst$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        index$iv = -1;
                        break;
                    }
                    List $this$indexOfFirst$iv2 = $this$indexOfFirst$iv;
                    if (Intrinsics.areEqual(contentKey.invoke(it.next()), contentKey.invoke(transition.getTargetState()))) {
                        break;
                    }
                    index$iv++;
                    $this$indexOfFirst$iv = $this$indexOfFirst$iv2;
                }
                int id = index$iv;
                if (id == -1) {
                    currentlyVisible.add(transition.getTargetState());
                } else {
                    currentlyVisible.set(id, transition.getTargetState());
                }
            }
            if (contentMap.containsKey(transition.getTargetState()) && contentMap.containsKey(transition.getCurrentState())) {
                i2 = 0;
            } else {
                contentMap.clear();
                SnapshotStateList $this$fastForEach$iv = currentlyVisible;
                int index$iv2 = 0;
                int size = $this$fastForEach$iv.size();
                while (index$iv2 < size) {
                    final Object item$iv = $this$fastForEach$iv.get(index$iv2);
                    final Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function43 = function42;
                    contentMap.put(item$iv, ComposableLambdaKt.composableLambda($composer2, 885640742, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1
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

                        /* JADX WARN: Removed duplicated region for block: B:29:0x00f9  */
                        /* JADX WARN: Removed duplicated region for block: B:30:0x010d  */
                        /* JADX WARN: Removed duplicated region for block: B:37:0x016f  */
                        /* JADX WARN: Removed duplicated region for block: B:40:0x01ae  */
                        /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final void invoke(androidx.compose.runtime.Composer r21, int r22) {
                            /*
                                Method dump skipped, instructions count: 434
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1.invoke(androidx.compose.runtime.Composer, int):void");
                        }
                    }));
                    index$iv2++;
                    size = size;
                    $this$fastForEach$iv = $this$fastForEach$iv;
                    function42 = function4;
                }
                i2 = 0;
            }
            Object key2$iv = transition.getSegment();
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv4 = $composer2.changed(rootScope) | $composer2.changed(key2$iv);
            Object it$iv$iv4 = $composer2.rememberedValue();
            if (invalid$iv$iv4 || it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv4 = (ContentTransform) transitionSpec2.invoke(rootScope);
                $composer2.updateRememberedValue(value$iv$iv4);
            } else {
                value$iv$iv4 = it$iv$iv4;
            }
            $composer2.endReplaceableGroup();
            ContentTransform contentTransform = (ContentTransform) value$iv$iv4;
            Modifier sizeModifier = rootScope.createSizeAnimationModifier$animation_release(contentTransform, $composer2, 72);
            Modifier modifierThen = modifier4.then(sizeModifier);
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Object value$iv$iv5 = $composer2.rememberedValue();
            if (value$iv$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv5 = new AnimatedContentMeasurePolicy(rootScope);
                $composer2.updateRememberedValue(value$iv$iv5);
            }
            $composer2.endReplaceableGroup();
            AnimatedContentMeasurePolicy animatedContentMeasurePolicy = (AnimatedContentMeasurePolicy) value$iv$iv5;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, i2);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Function0 factory$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.modifierMaterializerOf(modifierThen);
            int $changed$iv$iv = ((384 << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv = factory$iv$iv2;
                $composer2.createNode(factory$iv$iv);
            } else {
                factory$iv$iv = factory$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3479constructorimpl($composer2);
            Function1 transitionSpec3 = transitionSpec2;
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv, animatedContentMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
            }
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i10 = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -740835328, "C:AnimatedContent.kt#xbi5r1");
            $composer2.startReplaceableGroup(-441506448);
            ComposerKt.sourceInformation($composer2, "");
            SnapshotStateList $this$fastForEach$iv2 = currentlyVisible;
            int size2 = $this$fastForEach$iv2.size();
            int index$iv3 = 0;
            while (index$iv3 < size2) {
                Object item$iv2 = $this$fastForEach$iv2.get(index$iv3);
                List $this$fastForEach$iv3 = $this$fastForEach$iv2;
                int i11 = size2;
                int index$iv4 = index$iv3;
                $composer2.startMovableGroup(-1739558576, contentKey.invoke(item$iv2));
                ComposerKt.sourceInformation($composer2, "767@39187L8");
                Function2 function2 = (Function2) contentMap.get(item$iv2);
                if (function2 != null) {
                    function2.invoke($composer2, Integer.valueOf(i2));
                }
                $composer2.endMovableGroup();
                index$iv3 = index$iv4 + 1;
                size2 = i11;
                $this$fastForEach$iv2 = $this$fastForEach$iv3;
            }
            $composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            transitionSpec = transitionSpec3;
            modifier3 = modifier4;
            contentAlignment3 = contentAlignment2;
            contentKey2 = contentKey;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedContentKt.AnimatedContent.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Throwable {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i12) throws Throwable {
                    AnimatedContentKt.AnimatedContent(transition, modifier3, transitionSpec, contentAlignment3, contentKey2, function4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
