package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Button.kt */
@Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m179c = "androidx.compose.material3.ButtonElevation$animateElevation$2$1", m180f = "Button.kt", m181i = {}, m182l = {954, 962}, m183m = "invokeSuspend", m184n = {}, m185s = {})
/* loaded from: classes.dex */
final class ButtonElevation$animateElevation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<C1956Dp, AnimationVector1D> $animatable;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ float $target;
    int label;
    final /* synthetic */ ButtonElevation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ButtonElevation$animateElevation$2$1(Animatable<C1956Dp, AnimationVector1D> animatable, float f, boolean z, ButtonElevation buttonElevation, Interaction interaction, Continuation<? super ButtonElevation$animateElevation$2$1> continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.$target = f;
        this.$enabled = z;
        this.this$0 = buttonElevation;
        this.$interaction = interaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ButtonElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, this.this$0, this.$interaction, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ButtonElevation$animateElevation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        ButtonElevation$animateElevation$2$1 buttonElevation$animateElevation$2$1;
        ButtonElevation$animateElevation$2$1 buttonElevation$animateElevation$2$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!C1956Dp.m6302equalsimpl0(this.$animatable.getTargetValue().m6311unboximpl(), this.$target)) {
                    if (!this.$enabled) {
                        this.label = 1;
                        if (this.$animatable.snapTo(C1956Dp.m6295boximpl(this.$target), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        buttonElevation$animateElevation$2$12 = this;
                    } else {
                        float fM6311unboximpl = this.$animatable.getTargetValue().m6311unboximpl();
                        FocusInteraction.Focus focus = null;
                        if (C1956Dp.m6302equalsimpl0(fM6311unboximpl, this.this$0.pressedElevation)) {
                            focus = new PressInteraction.Press(Offset.INSTANCE.m3724getZeroF1C5BW0(), null);
                        } else if (C1956Dp.m6302equalsimpl0(fM6311unboximpl, this.this$0.hoveredElevation)) {
                            focus = new HoverInteraction.Enter();
                        } else if (C1956Dp.m6302equalsimpl0(fM6311unboximpl, this.this$0.focusedElevation)) {
                            focus = new FocusInteraction.Focus();
                        }
                        this.label = 2;
                        if (ElevationKt.m2082animateElevationrAjV9yQ(this.$animatable, this.$target, focus, this.$interaction, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        buttonElevation$animateElevation$2$1 = this;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                buttonElevation$animateElevation$2$12 = this;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 2:
                buttonElevation$animateElevation$2$1 = this;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
