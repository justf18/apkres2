package androidx.compose.p000ui.platform;

import android.view.View;
import androidx.compose.p000ui.platform.WindowRecomposer_androidKt;
import androidx.compose.runtime.Recomposer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: WindowRecomposer.android.kt */
@Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(m179c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", m180f = "WindowRecomposer.android.kt", m181i = {0}, m182l = {394}, m183m = "invokeSuspend", m184n = {"durationScaleJob"}, m185s = {"L$0"})
/* renamed from: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 */
/* loaded from: classes.dex */
final class C1884x149b840a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ WindowRecomposer_androidKt.C18832 $self;
    final /* synthetic */ LifecycleOwner $source;
    final /* synthetic */ Ref.ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1884x149b840a(Ref.ObjectRef<MotionDurationScaleImpl> objectRef, Recomposer recomposer, LifecycleOwner lifecycleOwner, WindowRecomposer_androidKt.C18832 c18832, View view, Continuation<? super C1884x149b840a> continuation) {
        super(2, continuation);
        this.$systemDurationScaleSettingConsumer = objectRef;
        this.$recomposer = recomposer;
        this.$source = lifecycleOwner;
        this.$self = c18832;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C1884x149b840a c1884x149b840a = new C1884x149b840a(this.$systemDurationScaleSettingConsumer, this.$recomposer, this.$source, this.$self, this.$this_createLifecycleAwareWindowRecomposer, continuation);
        c1884x149b840a.L$0 = obj;
        return c1884x149b840a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C1884x149b840a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0089: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char] A[D('durationScaleJob' kotlinx.coroutines.Job)]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:25:0x008e, block:B:23:0x0089 */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1, int] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Job durationScaleJob;
        C1884x149b840a c1884x149b840a;
        Job jobLaunch$default;
        Job durationScaleJob2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        try {
            switch (r1) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c1884x149b840a = this;
                    CoroutineScope $this$launch = (CoroutineScope) c1884x149b840a.L$0;
                    MotionDurationScaleImpl it = c1884x149b840a.$systemDurationScaleSettingConsumer.element;
                    if (it != null) {
                        StateFlow durationScaleStateFlow = WindowRecomposer_androidKt.getAnimationScaleFlowFor(c1884x149b840a.$this_createLifecycleAwareWindowRecomposer.getContext().getApplicationContext());
                        it.setScaleFactor(((Number) durationScaleStateFlow.getValue()).floatValue());
                        jobLaunch$default = BuildersKt__Builders_commonKt.launch$default($this$launch, null, null, new C1885x93d788e4(durationScaleStateFlow, it, null), 3, null);
                    } else {
                        jobLaunch$default = null;
                    }
                    durationScaleJob2 = jobLaunch$default;
                    c1884x149b840a.L$0 = durationScaleJob2;
                    c1884x149b840a.label = 1;
                    if (c1884x149b840a.$recomposer.runRecomposeAndApplyChanges(c1884x149b840a) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    c1884x149b840a = this;
                    durationScaleJob2 = (Job) c1884x149b840a.L$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (durationScaleJob2 != null) {
                Job.DefaultImpls.cancel$default(durationScaleJob2, (CancellationException) null, 1, (Object) null);
            }
            c1884x149b840a.$source.getLifecycleRegistry().removeObserver(c1884x149b840a.$self);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            if (durationScaleJob != null) {
                Job.DefaultImpls.cancel$default(durationScaleJob, (CancellationException) null, 1, (Object) null);
            }
            r1.$source.getLifecycleRegistry().removeObserver(r1.$self);
            throw th;
        }
    }
}
