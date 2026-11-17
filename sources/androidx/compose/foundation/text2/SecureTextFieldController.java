package androidx.compose.foundation.text2;

import androidx.compose.foundation.text2.input.CodepointTransformation;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.focus.FocusChangedModifierKt;
import androidx.compose.p000ui.focus.FocusState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: BasicSecureTextField.kt */
@Metadata(m164d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0013H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m165d2 = {"Landroidx/compose/foundation/text2/SecureTextFieldController;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "codepointTransformation", "Landroidx/compose/foundation/text2/input/CodepointTransformation;", "getCodepointTransformation", "()Landroidx/compose/foundation/text2/input/CodepointTransformation;", "focusChangeModifier", "Landroidx/compose/ui/Modifier;", "getFocusChangeModifier", "()Landroidx/compose/ui/Modifier;", "passwordRevealFilter", "Landroidx/compose/foundation/text2/PasswordRevealFilter;", "getPasswordRevealFilter", "()Landroidx/compose/foundation/text2/PasswordRevealFilter;", "resetTimerSignal", "Lkotlinx/coroutines/channels/Channel;", "", "scheduleHide", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SecureTextFieldController {
    public static final int $stable = 8;
    private final PasswordRevealFilter passwordRevealFilter = new PasswordRevealFilter(new SecureTextFieldController$passwordRevealFilter$1(this));
    private final CodepointTransformation codepointTransformation = new CodepointTransformation() { // from class: androidx.compose.foundation.text2.SecureTextFieldController$$ExternalSyntheticLambda0
        @Override // androidx.compose.foundation.text2.input.CodepointTransformation
        public final int transform(int i, int i2) {
            return SecureTextFieldController.codepointTransformation$lambda$0(this.f$0, i, i2);
        }
    };
    private final Modifier focusChangeModifier = FocusChangedModifierKt.onFocusChanged(Modifier.INSTANCE, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text2.SecureTextFieldController$focusChangeModifier$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
            invoke2(focusState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FocusState it) {
            if (!it.isFocused()) {
                this.this$0.getPasswordRevealFilter().hide();
            }
        }
    });
    private final Channel<Unit> resetTimerSignal = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);

    public SecureTextFieldController(CoroutineScope coroutineScope) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C08381(null), 3, null);
    }

    public final PasswordRevealFilter getPasswordRevealFilter() {
        return this.passwordRevealFilter;
    }

    public final CodepointTransformation getCodepointTransformation() {
        return this.codepointTransformation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int codepointTransformation$lambda$0(SecureTextFieldController this$0, int codepointIndex, int codepoint) {
        if (codepointIndex == this$0.passwordRevealFilter.getRevealCodepointIndex$foundation_release()) {
            return codepoint;
        }
        return 8226;
    }

    public final Modifier getFocusChangeModifier() {
        return this.focusChangeModifier;
    }

    /* compiled from: BasicSecureTextField.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.SecureTextFieldController$1", m180f = "BasicSecureTextField.kt", m181i = {}, m182l = {384}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.text2.SecureTextFieldController$1 */
    static final class C08381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08381(Continuation<? super C08381> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SecureTextFieldController.this.new C08381(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (FlowKt.collectLatest(FlowKt.consumeAsFlow(SecureTextFieldController.this.resetTimerSignal), new AnonymousClass1(SecureTextFieldController.this, null), this) != coroutine_suspended) {
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

        /* compiled from: BasicSecureTextField.kt */
        @Metadata(m164d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m165d2 = {"<anonymous>", "", "it"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.SecureTextFieldController$1$1", m180f = "BasicSecureTextField.kt", m181i = {}, m182l = {385}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.SecureTextFieldController$1$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SecureTextFieldController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SecureTextFieldController secureTextFieldController, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = secureTextFieldController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                AnonymousClass1 anonymousClass1;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (DelayKt.delay(1500L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anonymousClass1 = this;
                        break;
                    case 1:
                        anonymousClass1 = this;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                anonymousClass1.this$0.getPasswordRevealFilter().hide();
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleHide() {
        Object result = this.resetTimerSignal.mo8106trySendJP2dKIU(Unit.INSTANCE);
        if (!ChannelResult.m8126isSuccessimpl(result)) {
            this.passwordRevealFilter.hide();
        }
    }
}
