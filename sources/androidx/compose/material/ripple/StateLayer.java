package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.ClipOp;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.drawscope.DrawContext;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawTransform;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Ripple.kt */
@Metadata(m164d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J$\u0010\u0015\u001a\u00020\u0011*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, m165d2 = {"Landroidx/compose/material/ripple/StateLayer;", "", "bounded", "", "rippleAlpha", "Landroidx/compose/runtime/State;", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZLandroidx/compose/runtime/State;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "currentInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "interactions", "", "handleInteraction", "", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "Landroidx/compose/ui/unit/Dp;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-H2RKhps", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class StateLayer {
    private final boolean bounded;
    private Interaction currentInteraction;
    private final State<RippleAlpha> rippleAlpha;
    private final Animatable<Float, AnimationVector1D> animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
    private final List<Interaction> interactions = new ArrayList();

    public StateLayer(boolean bounded, State<RippleAlpha> state) {
        this.bounded = bounded;
        this.rippleAlpha = state;
    }

    public final void handleInteraction(Interaction interaction, CoroutineScope scope) {
        float targetAlpha;
        if (interaction instanceof HoverInteraction.Enter) {
            this.interactions.add(interaction);
        } else if (interaction instanceof HoverInteraction.Exit) {
            this.interactions.remove(((HoverInteraction.Exit) interaction).getEnter());
        } else if (interaction instanceof FocusInteraction.Focus) {
            this.interactions.add(interaction);
        } else if (interaction instanceof FocusInteraction.Unfocus) {
            this.interactions.remove(((FocusInteraction.Unfocus) interaction).getFocus());
        } else if (interaction instanceof DragInteraction.Start) {
            this.interactions.add(interaction);
        } else if (interaction instanceof DragInteraction.Stop) {
            this.interactions.remove(((DragInteraction.Stop) interaction).getStart());
        } else if (interaction instanceof DragInteraction.Cancel) {
            this.interactions.remove(((DragInteraction.Cancel) interaction).getStart());
        } else {
            return;
        }
        Interaction newInteraction = (Interaction) CollectionsKt.lastOrNull((List) this.interactions);
        if (!Intrinsics.areEqual(this.currentInteraction, newInteraction)) {
            if (newInteraction == null) {
                AnimationSpec outgoingAnimationSpec = RippleKt.outgoingStateLayerAnimationSpecFor(this.currentInteraction);
                BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C11842(outgoingAnimationSpec, null), 3, null);
            } else {
                if (interaction instanceof HoverInteraction.Enter) {
                    targetAlpha = this.rippleAlpha.getValue().getHoveredAlpha();
                } else {
                    targetAlpha = interaction instanceof FocusInteraction.Focus ? this.rippleAlpha.getValue().getFocusedAlpha() : interaction instanceof DragInteraction.Start ? this.rippleAlpha.getValue().getDraggedAlpha() : 0.0f;
                }
                AnimationSpec incomingAnimationSpec = RippleKt.incomingStateLayerAnimationSpecFor(newInteraction);
                BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C11831(targetAlpha, incomingAnimationSpec, null), 3, null);
            }
            this.currentInteraction = newInteraction;
        }
    }

    /* compiled from: Ripple.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.material.ripple.StateLayer$handleInteraction$1", m180f = "Ripple.kt", m181i = {}, m182l = {299}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.material.ripple.StateLayer$handleInteraction$1 */
    static final class C11831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $incomingAnimationSpec;
        final /* synthetic */ float $targetAlpha;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11831(float f, AnimationSpec<Float> animationSpec, Continuation<? super C11831> continuation) {
            super(2, continuation);
            this.$targetAlpha = f;
            this.$incomingAnimationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StateLayer.this.new C11831(this.$targetAlpha, this.$incomingAnimationSpec, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Animatable animatable = StateLayer.this.animatedAlpha;
                    Float fBoxFloat = Boxing.boxFloat(this.$targetAlpha);
                    AnimationSpec<Float> animationSpec = this.$incomingAnimationSpec;
                    this.label = 1;
                    if (animatable.animateTo(fBoxFloat, (4 & 2) != 0 ? animatable.defaultSpringSpec : animationSpec, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : null, this) != coroutine_suspended) {
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

    /* compiled from: Ripple.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.material.ripple.StateLayer$handleInteraction$2", m180f = "Ripple.kt", m181i = {}, m182l = {305}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.material.ripple.StateLayer$handleInteraction$2 */
    static final class C11842 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $outgoingAnimationSpec;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11842(AnimationSpec<Float> animationSpec, Continuation<? super C11842> continuation) {
            super(2, continuation);
            this.$outgoingAnimationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StateLayer.this.new C11842(this.$outgoingAnimationSpec, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11842) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Animatable animatable = StateLayer.this.animatedAlpha;
                    Float fBoxFloat = Boxing.boxFloat(0.0f);
                    AnimationSpec<Float> animationSpec = this.$outgoingAnimationSpec;
                    this.label = 1;
                    if (animatable.animateTo(fBoxFloat, (4 & 2) != 0 ? animatable.defaultSpringSpec : animationSpec, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : null, this) != coroutine_suspended) {
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

    /* renamed from: drawStateLayer-H2RKhps, reason: not valid java name */
    public final void m1759drawStateLayerH2RKhps(DrawScope $this$drawStateLayer_u2dH2RKhps, float radius, long color) {
        float targetRadius = Float.isNaN(radius) ? RippleAnimationKt.m1750getRippleEndRadiuscSwnlzA($this$drawStateLayer_u2dH2RKhps, this.bounded, $this$drawStateLayer_u2dH2RKhps.mo4498getSizeNHjbRc()) : $this$drawStateLayer_u2dH2RKhps.mo518toPx0680j_4(radius);
        float alpha = this.animatedAlpha.getValue().floatValue();
        if (alpha > 0.0f) {
            long modulatedColor = Color.m3947copywmQWz5c(color, (14 & 1) != 0 ? Color.m3951getAlphaimpl(color) : alpha, (14 & 2) != 0 ? Color.m3955getRedimpl(color) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(color) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(color) : 0.0f);
            if (!this.bounded) {
                DrawScope.m4480drawCircleVaOC9Bg$default($this$drawStateLayer_u2dH2RKhps, modulatedColor, targetRadius, 0L, 0.0f, null, null, 0, 124, null);
                return;
            }
            float right$iv = Size.m3777getWidthimpl($this$drawStateLayer_u2dH2RKhps.mo4498getSizeNHjbRc());
            float bottom$iv = Size.m3774getHeightimpl($this$drawStateLayer_u2dH2RKhps.mo4498getSizeNHjbRc());
            int clipOp$iv = ClipOp.INSTANCE.m3938getIntersectrtfAjoo();
            DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$drawStateLayer_u2dH2RKhps.getDrawContext();
            long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo4423getSizeNHjbRc();
            $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
            DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
            $this$clipRect_rOu3jXo_u24lambda_u244$iv.mo4426clipRectN_I0leg(0.0f, 0.0f, right$iv, bottom$iv, clipOp$iv);
            DrawScope.m4480drawCircleVaOC9Bg$default($this$drawStateLayer_u2dH2RKhps, modulatedColor, targetRadius, 0L, 0.0f, null, null, 0, 124, null);
            $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv$iv.mo4424setSizeuvyYCjk(previousSize$iv$iv);
        }
    }
}
