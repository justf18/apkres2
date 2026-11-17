package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: FloatingActionButton.kt */
@Metadata(m164d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, m165d2 = {"Landroidx/compose/material/DefaultFloatingActionButtonElevation;", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "hoveredElevation", "focusedElevation", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "elevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "", "other", "", "hashCode", "", "material_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class DefaultFloatingActionButtonElevation implements FloatingActionButtonElevation {
    private final float defaultElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ DefaultFloatingActionButtonElevation(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private DefaultFloatingActionButtonElevation(float defaultElevation, float pressedElevation, float hoveredElevation, float focusedElevation) {
        this.defaultElevation = defaultElevation;
        this.pressedElevation = pressedElevation;
        this.hoveredElevation = hoveredElevation;
        this.focusedElevation = focusedElevation;
    }

    @Override // androidx.compose.material.FloatingActionButtonElevation
    public State<C1956Dp> elevation(InteractionSource interactionSource, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-478475335);
        ComposerKt.sourceInformation($composer, "C(elevation)270@11429L317,279@11756L297,288@12063L1352:FloatingActionButton.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-478475335, $changed, -1, "androidx.compose.material.DefaultFloatingActionButtonElevation.elevation (FloatingActionButton.kt:269)");
        }
        int i = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(interactionSource);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new FloatingActionButtonElevationAnimatable(this.defaultElevation, this.pressedElevation, this.hoveredElevation, this.focusedElevation, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        FloatingActionButtonElevationAnimatable animatable = (FloatingActionButtonElevationAnimatable) value$iv$iv;
        EffectsKt.LaunchedEffect(this, new C09771(animatable, this, null), $composer, (($changed >> 3) & 14) | 64);
        EffectsKt.LaunchedEffect(interactionSource, new C09782(interactionSource, animatable, null), $composer, ($changed & 14) | 64);
        State<C1956Dp> stateAsState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAsState;
    }

    /* compiled from: FloatingActionButton.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$1", m180f = "FloatingActionButton.kt", m181i = {}, m182l = {281}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$1 */
    static final class C09771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FloatingActionButtonElevationAnimatable $animatable;
        int label;
        final /* synthetic */ DefaultFloatingActionButtonElevation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09771(FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable, DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation, Continuation<? super C09771> continuation) {
            super(2, continuation);
            this.$animatable = floatingActionButtonElevationAnimatable;
            this.this$0 = defaultFloatingActionButtonElevation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09771(this.$animatable, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (this.$animatable.m1575updateElevationlDy3nrA(this.this$0.defaultElevation, this.this$0.pressedElevation, this.this$0.hoveredElevation, this.this$0.focusedElevation, this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: FloatingActionButton.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2", m180f = "FloatingActionButton.kt", m181i = {}, m182l = {291}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2 */
    static final class C09782 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FloatingActionButtonElevationAnimatable $animatable;
        final /* synthetic */ InteractionSource $interactionSource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09782(InteractionSource interactionSource, FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable, Continuation<? super C09782> continuation) {
            super(2, continuation);
            this.$interactionSource = interactionSource;
            this.$animatable = floatingActionButtonElevationAnimatable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09782 c09782 = new C09782(this.$interactionSource, this.$animatable, continuation);
            c09782.L$0 = obj;
            return c09782;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09782) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final CoroutineScope $this$LaunchedEffect = (CoroutineScope) this.L$0;
                    final List interactions = new ArrayList();
                    Flow<Interaction> interactions2 = this.$interactionSource.getInteractions();
                    final FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable = this.$animatable;
                    this.label = 1;
                    if (interactions2.collect(new FlowCollector() { // from class: androidx.compose.material.DefaultFloatingActionButtonElevation.elevation.2.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((Interaction) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
                            if (interaction instanceof HoverInteraction.Enter) {
                                interactions.add(interaction);
                            } else if (interaction instanceof HoverInteraction.Exit) {
                                interactions.remove(((HoverInteraction.Exit) interaction).getEnter());
                            } else if (interaction instanceof FocusInteraction.Focus) {
                                interactions.add(interaction);
                            } else if (interaction instanceof FocusInteraction.Unfocus) {
                                interactions.remove(((FocusInteraction.Unfocus) interaction).getFocus());
                            } else if (interaction instanceof PressInteraction.Press) {
                                interactions.add(interaction);
                            } else if (interaction instanceof PressInteraction.Release) {
                                interactions.remove(((PressInteraction.Release) interaction).getPress());
                            } else if (interaction instanceof PressInteraction.Cancel) {
                                interactions.remove(((PressInteraction.Cancel) interaction).getPress());
                            }
                            Interaction targetInteraction = (Interaction) CollectionsKt.lastOrNull((List) interactions);
                            BuildersKt__Builders_commonKt.launch$default($this$LaunchedEffect, null, null, new C31791(floatingActionButtonElevationAnimatable, targetInteraction, null), 3, null);
                            return Unit.INSTANCE;
                        }

                        /* compiled from: FloatingActionButton.kt */
                        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                        @DebugMetadata(m179c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2$1$1", m180f = "FloatingActionButton.kt", m181i = {}, m182l = {TypedValues.AttributesType.TYPE_EASING}, m183m = "invokeSuspend", m184n = {}, m185s = {})
                        /* renamed from: androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2$1$1, reason: invalid class name and collision with other inner class name */
                        static final class C31791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ FloatingActionButtonElevationAnimatable $animatable;
                            final /* synthetic */ Interaction $targetInteraction;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C31791(FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable, Interaction interaction, Continuation<? super C31791> continuation) {
                                super(2, continuation);
                                this.$animatable = floatingActionButtonElevationAnimatable;
                                this.$targetInteraction = interaction;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C31791(this.$animatable, this.$targetInteraction, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C31791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object $result) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        this.label = 1;
                                        if (this.$animatable.animateElevation(this.$targetInteraction, this) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }, this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof DefaultFloatingActionButtonElevation) && C1956Dp.m6302equalsimpl0(this.defaultElevation, ((DefaultFloatingActionButtonElevation) other).defaultElevation) && C1956Dp.m6302equalsimpl0(this.pressedElevation, ((DefaultFloatingActionButtonElevation) other).pressedElevation) && C1956Dp.m6302equalsimpl0(this.hoveredElevation, ((DefaultFloatingActionButtonElevation) other).hoveredElevation)) {
            return C1956Dp.m6302equalsimpl0(this.focusedElevation, ((DefaultFloatingActionButtonElevation) other).focusedElevation);
        }
        return false;
    }

    public int hashCode() {
        int result = C1956Dp.m6303hashCodeimpl(this.defaultElevation);
        return (((((result * 31) + C1956Dp.m6303hashCodeimpl(this.pressedElevation)) * 31) + C1956Dp.m6303hashCodeimpl(this.hoveredElevation)) * 31) + C1956Dp.m6303hashCodeimpl(this.focusedElevation);
    }
}
