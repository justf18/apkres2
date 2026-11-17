package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.DpKt;
import androidx.compose.p000ui.unit.DpOffset;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimePicker.kt */
@Metadata(m164d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 d2\u00020\u0001:\u0001dB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010G\u001a\u00020HH\u0080@¢\u0006\u0004\bI\u0010JJ\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0015\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u0003H\u0000¢\u0006\u0002\bMJ%\u0010N\u001a\u00020H2\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u0013H\u0000¢\u0006\u0002\bRJ\u0010\u0010S\u001a\u00020\u00132\u0006\u0010T\u001a\u00020\u0013H\u0002J0\u0010U\u001a\u00020H2\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\u0006H\u0080@¢\u0006\u0004\bW\u0010XJ\u0015\u0010Y\u001a\u00020H2\u0006\u0010\u0017\u001a\u00020\u0003H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020H2\u0006\u00101\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\\J\u000e\u0010]\u001a\u00020HH\u0086@¢\u0006\u0002\u0010JJ\"\u0010^\u001a\u00020H2\u0006\u0010L\u001a\u00020\u00132\b\b\u0002\u0010_\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b`\u0010aJ\f\u0010b\u001a\u00020\u0003*\u00020\u0013H\u0002J\f\u0010c\u001a\u00020\u0003*\u00020\u0013H\u0002R1\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R+\u0010\u001a\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019R\u0011\u0010#\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b%\u0010$R+\u0010(\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0010\u001a\u0004\b)\u0010$\"\u0004\b*\u0010+R+\u0010-\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0010\u001a\u0004\b.\u0010$\"\u0004\b/\u0010+R\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\u0019R+\u00103\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010 \u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010:\u001a\u0002092\u0006\u0010\b\u001a\u0002098@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b>\u0010\u0010\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010=R!\u0010?\u001a\u00020@8@X\u0080\u0084\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bB\u0010'\u001a\u0004\bA\u0010\fR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030D8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006e"}, m165d2 = {"Landroidx/compose/material3/TimePickerState;", "", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZ)V", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "center", "getCenter-nOcc-ac$material3_release", "()J", "setCenter--gyyYBs$material3_release", "(J)V", "center$delegate", "Landroidx/compose/runtime/MutableState;", "currentAngle", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "getCurrentAngle$material3_release", "()Landroidx/compose/animation/core/Animatable;", "hour", "getHour", "()I", "hourAngle", "getHourAngle$material3_release", "()F", "setHourAngle$material3_release", "(F)V", "hourAngle$delegate", "Landroidx/compose/runtime/MutableFloatState;", "hourForDisplay", "getHourForDisplay$material3_release", "is24hour", "()Z", "isAfternoon", "isAfternoon$delegate", "Landroidx/compose/runtime/State;", "isAfternoonToggle", "isAfternoonToggle$material3_release", "setAfternoonToggle$material3_release", "(Z)V", "isAfternoonToggle$delegate", "isInnerCircle", "isInnerCircle$material3_release", "setInnerCircle$material3_release", "isInnerCircle$delegate", "minute", "getMinute", "minuteAngle", "getMinuteAngle$material3_release", "setMinuteAngle$material3_release", "minuteAngle$delegate", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "Landroidx/compose/material3/Selection;", "selection", "getSelection-JiIwxys$material3_release", "setSelection-iHAOin8$material3_release", "(I)V", "selection$delegate", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "getSelectorPos-RKDOV3M$material3_release", "selectorPos$delegate", "values", "", "getValues$material3_release", "()Ljava/util/List;", "animateToCurrent", "", "animateToCurrent$material3_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSelected", "value", "isSelected$material3_release", "moveSelector", "x", "y", "maxDist", "moveSelector$material3_release", "offsetHour", "angle", "onTap", "autoSwitchToMinute", "onTap$material3_release", "(FFFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHour", "setHour$material3_release", "setMinute", "setMinute$material3_release", "settle", "update", "fromTap", "update$material3_release", "(FZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHour", "toMinute", "Companion", "material3_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TimePickerState {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: center$delegate, reason: from kotlin metadata */
    private final MutableState center;
    private final Animatable<Float, AnimationVector1D> currentAngle;

    /* renamed from: hourAngle$delegate, reason: from kotlin metadata */
    private final MutableFloatState hourAngle;
    private final boolean is24hour;

    /* renamed from: isAfternoon$delegate, reason: from kotlin metadata */
    private final State isAfternoon;

    /* renamed from: isAfternoonToggle$delegate, reason: from kotlin metadata */
    private final MutableState isAfternoonToggle;

    /* renamed from: isInnerCircle$delegate, reason: from kotlin metadata */
    private final MutableState isInnerCircle;

    /* renamed from: minuteAngle$delegate, reason: from kotlin metadata */
    private final MutableFloatState minuteAngle;
    private final MutatorMutex mutex;

    /* renamed from: selection$delegate, reason: from kotlin metadata */
    private final MutableState selection;

    /* renamed from: selectorPos$delegate, reason: from kotlin metadata */
    private final State selectorPos;

    /* compiled from: TimePicker.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.material3.TimePickerState", m180f = "TimePicker.kt", m181i = {0, 0}, m182l = {733, 734}, m183m = "settle", m184n = {"this", "targetValue"}, m185s = {"L$0", "L$1"})
    /* renamed from: androidx.compose.material3.TimePickerState$settle$1 */
    static final class C16101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C16101(Continuation<? super C16101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TimePickerState.this.settle(this);
        }
    }

    public TimePickerState(int initialHour, int initialMinute, final boolean is24Hour) {
        if (!(initialHour >= 0 && initialHour < 24)) {
            throw new IllegalArgumentException("initialHour should in [0..23] range".toString());
        }
        if (!(initialMinute >= 0 && initialMinute < 60)) {
            throw new IllegalArgumentException("initialMinute should be in [0..59] range".toString());
        }
        this.is24hour = is24Hour;
        this.selectorPos = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<DpOffset>() { // from class: androidx.compose.material3.TimePickerState$selectorPos$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ DpOffset invoke() {
                return DpOffset.m6352boximpl(m2719invokeRKDOV3M());
            }

            /* renamed from: invoke-RKDOV3M, reason: not valid java name */
            public final long m2719invokeRKDOV3M() {
                boolean inInnerCircle = this.this$0.isInnerCircle$material3_release();
                float arg0$iv = C1956Dp.m6297constructorimpl(TimePickerTokens.INSTANCE.m3378getClockDialSelectorHandleContainerSizeD9Ej5fM() / 2);
                float length = C1956Dp.m6297constructorimpl(C1956Dp.m6297constructorimpl(((is24Hour && inInnerCircle && Selection.m2387equalsimpl0(this.this$0.m2715getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2391getHourJiIwxys())) ? TimePickerKt.InnerCircleRadius : TimePickerKt.OuterCircleSizeRadius) - arg0$iv) + arg0$iv);
                float other$iv = (float) Math.cos(this.this$0.getCurrentAngle$material3_release().getValue().floatValue());
                float arg0$iv2 = C1956Dp.m6297constructorimpl(C1956Dp.m6297constructorimpl(length * other$iv) + C1956Dp.m6297constructorimpl(TimePickerTokens.INSTANCE.m3376getClockDialContainerSizeD9Ej5fM() / 2));
                float other$iv2 = (float) Math.sin(this.this$0.getCurrentAngle$material3_release().getValue().floatValue());
                return DpKt.m6318DpOffsetYgX7TsA(arg0$iv2, C1956Dp.m6297constructorimpl(C1956Dp.m6297constructorimpl(length * other$iv2) + C1956Dp.m6297constructorimpl(TimePickerTokens.INSTANCE.m3376getClockDialContainerSizeD9Ej5fM() / 2)));
            }
        });
        this.center = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m6416boximpl(IntOffset.INSTANCE.m6435getZeronOccac()), null, 2, null);
        this.selection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Selection.m2384boximpl(Selection.INSTANCE.m2391getHourJiIwxys()), null, 2, null);
        this.isAfternoonToggle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(initialHour >= 12 && !is24Hour), null, 2, null);
        this.isInnerCircle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(initialHour >= 12), null, 2, null);
        this.hourAngle = PrimitiveSnapshotStateKt.mutableFloatStateOf(((initialHour % 12) * 0.5235988f) - 1.5707964f);
        this.minuteAngle = PrimitiveSnapshotStateKt.mutableFloatStateOf((initialMinute * 0.10471976f) - 1.5707964f);
        this.mutex = new MutatorMutex();
        this.isAfternoon = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material3.TimePickerState.isAfternoon.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf((TimePickerState.this.getIs24hour() && TimePickerState.this.isInnerCircle$material3_release()) || TimePickerState.this.isAfternoonToggle$material3_release());
            }
        });
        this.currentAngle = AnimatableKt.Animatable$default(getHourAngle$material3_release(), 0.0f, 2, null);
    }

    public final int getMinute() {
        return toMinute(getMinuteAngle$material3_release());
    }

    public final int getHour() {
        return toHour(getHourAngle$material3_release()) + (isAfternoon() ? 12 : 0);
    }

    /* renamed from: is24hour, reason: from getter */
    public final boolean getIs24hour() {
        return this.is24hour;
    }

    public final int getHourForDisplay$material3_release() {
        return hourForDisplay(getHour());
    }

    /* renamed from: getSelectorPos-RKDOV3M$material3_release, reason: not valid java name */
    public final long m2716getSelectorPosRKDOV3M$material3_release() {
        State $this$getValue$iv = this.selectorPos;
        return ((DpOffset) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* renamed from: getCenter-nOcc-ac$material3_release, reason: not valid java name */
    public final long m2714getCenternOccac$material3_release() {
        State $this$getValue$iv = this.center;
        return ((IntOffset) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* renamed from: setCenter--gyyYBs$material3_release, reason: not valid java name */
    public final void m2717setCentergyyYBs$material3_release(long j) {
        MutableState $this$setValue$iv = this.center;
        $this$setValue$iv.setValue(IntOffset.m6416boximpl(j));
    }

    public final List<Integer> getValues$material3_release() {
        return Selection.m2387equalsimpl0(m2715getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2392getMinuteJiIwxys()) ? TimePickerKt.Minutes : TimePickerKt.Hours;
    }

    /* renamed from: getSelection-JiIwxys$material3_release, reason: not valid java name */
    public final int m2715getSelectionJiIwxys$material3_release() {
        State $this$getValue$iv = this.selection;
        return ((Selection) $this$getValue$iv.getValue()).m2390unboximpl();
    }

    /* renamed from: setSelection-iHAOin8$material3_release, reason: not valid java name */
    public final void m2718setSelectioniHAOin8$material3_release(int i) {
        MutableState $this$setValue$iv = this.selection;
        $this$setValue$iv.setValue(Selection.m2384boximpl(i));
    }

    public final boolean isAfternoonToggle$material3_release() {
        State $this$getValue$iv = this.isAfternoonToggle;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setAfternoonToggle$material3_release(boolean z) {
        MutableState $this$setValue$iv = this.isAfternoonToggle;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final boolean isInnerCircle$material3_release() {
        State $this$getValue$iv = this.isInnerCircle;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setInnerCircle$material3_release(boolean z) {
        MutableState $this$setValue$iv = this.isInnerCircle;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final float getHourAngle$material3_release() {
        FloatState $this$getValue$iv = this.hourAngle;
        return $this$getValue$iv.getFloatValue();
    }

    public final void setHourAngle$material3_release(float f) {
        MutableFloatState $this$setValue$iv = this.hourAngle;
        $this$setValue$iv.setFloatValue(f);
    }

    public final float getMinuteAngle$material3_release() {
        FloatState $this$getValue$iv = this.minuteAngle;
        return $this$getValue$iv.getFloatValue();
    }

    public final void setMinuteAngle$material3_release(float f) {
        MutableFloatState $this$setValue$iv = this.minuteAngle;
        $this$setValue$iv.setFloatValue(f);
    }

    private final boolean isAfternoon() {
        State $this$getValue$iv = this.isAfternoon;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final Animatable<Float, AnimationVector1D> getCurrentAngle$material3_release() {
        return this.currentAngle;
    }

    public final void setMinute$material3_release(int minute) {
        setMinuteAngle$material3_release((minute * 0.10471976f) - 1.5707964f);
    }

    public final void setHour$material3_release(int hour) {
        setInnerCircle$material3_release(hour >= 12);
        setHourAngle$material3_release(((hour % 12) * 0.5235988f) - 1.5707964f);
    }

    public final void moveSelector$material3_release(float x, float y, float maxDist) {
        if (!Selection.m2387equalsimpl0(m2715getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2391getHourJiIwxys()) || !this.is24hour) {
            return;
        }
        setInnerCircle$material3_release(TimePickerKt.dist(x, y, IntOffset.m6425getXimpl(m2714getCenternOccac$material3_release()), IntOffset.m6426getYimpl(m2714getCenternOccac$material3_release())) < maxDist);
    }

    public final boolean isSelected$material3_release(int value) {
        if (Selection.m2387equalsimpl0(m2715getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2392getMinuteJiIwxys())) {
            return value == getMinute();
        }
        return getHour() == (isAfternoon() ? 12 : 0) + value;
    }

    public static /* synthetic */ Object update$material3_release$default(TimePickerState timePickerState, float f, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return timePickerState.update$material3_release(f, z, continuation);
    }

    public final Object update$material3_release(float value, boolean fromTap, Continuation<? super Unit> continuation) {
        Object objMutate = this.mutex.mutate(MutatePriority.UserInput, new TimePickerState$update$2(this, value, fromTap, null), continuation);
        return objMutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object animateToCurrent$material3_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.compose.material3.TimePickerState$animateToCurrent$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.TimePickerState$animateToCurrent$1 r0 = (androidx.compose.material3.TimePickerState$animateToCurrent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.material3.TimePickerState$animateToCurrent$1 r0 = new androidx.compose.material3.TimePickerState$animateToCurrent$1
            r0.<init>(r11, r12)
        L19:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            switch(r1) {
                case 0: goto L3e;
                case 1: goto L32;
                case 2: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L2d:
            kotlin.ResultKt.throwOnFailure(r12)
            goto Lb7
        L32:
            float r1 = r6.F$0
            java.lang.Object r2 = r6.L$0
            androidx.compose.material3.TimePickerState r2 = (androidx.compose.material3.TimePickerState) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r9 = r1
            r10 = r2
            goto L95
        L3e:
            kotlin.ResultKt.throwOnFailure(r12)
            r2 = r11
            int r1 = r2.m2715getSelectionJiIwxys$material3_release()
            androidx.compose.material3.Selection$Companion r3 = androidx.compose.material3.Selection.INSTANCE
            int r3 = r3.m2391getHourJiIwxys()
            boolean r1 = androidx.compose.material3.Selection.m2387equalsimpl0(r1, r3)
            if (r1 == 0) goto L5f
            float r1 = r2.getMinuteAngle$material3_release()
            float r3 = r2.getHourAngle$material3_release()
            kotlin.Pair r1 = androidx.compose.material3.TimePickerKt.access$valuesForAnimation(r1, r3)
            goto L6b
        L5f:
            float r1 = r2.getHourAngle$material3_release()
            float r3 = r2.getMinuteAngle$material3_release()
            kotlin.Pair r1 = androidx.compose.material3.TimePickerKt.access$valuesForAnimation(r1, r3)
        L6b:
            java.lang.Object r3 = r1.component1()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            java.lang.Object r1 = r1.component2()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r4 = r2.currentAngle
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
            r6.L$0 = r2
            r6.F$0 = r1
            r7 = 1
            r6.label = r7
            java.lang.Object r3 = r4.snapTo(r5, r6)
            if (r3 != r0) goto L93
            return r0
        L93:
            r9 = r1
            r10 = r2
        L95:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r1 = r10.currentAngle
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r9)
            r3 = 0
            r4 = 6
            r5 = 200(0xc8, float:2.8E-43)
            r7 = 0
            androidx.compose.animation.core.TweenSpec r3 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r5, r3, r7, r4, r7)
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r6.L$0 = r7
            r4 = 2
            r6.label = r4
            r4 = 0
            r5 = 0
            r7 = 12
            r8 = 0
            java.lang.Object r1 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r1 != r0) goto Lb7
            return r0
        Lb7:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.animateToCurrent$material3_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int hourForDisplay(int hour) {
        if (this.is24hour) {
            return hour % 24;
        }
        if (hour % 12 == 0) {
            return 12;
        }
        return isAfternoon() ? hour - 12 : hour;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float offsetHour(float angle) {
        float ret = 1.5707964f + angle;
        return ret < 0.0f ? 6.2831855f + ret : ret;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toHour(float $this$toHour) {
        double totalOffset = 0.2617994f + 1.5707963267948966d;
        return ((int) (($this$toHour + totalOffset) / 0.5235988f)) % 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toMinute(float $this$toMinute) {
        double totalOffset = 0.05235988f + 1.5707963267948966d;
        return ((int) (($this$toMinute + totalOffset) / 0.10471976f)) % 60;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object settle(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.compose.material3.TimePickerState.C16101
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.TimePickerState$settle$1 r0 = (androidx.compose.material3.TimePickerState.C16101) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.material3.TimePickerState$settle$1 r0 = new androidx.compose.material3.TimePickerState$settle$1
            r0.<init>(r12)
        L19:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            switch(r1) {
                case 0: goto L3f;
                case 1: goto L31;
                case 2: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L2d:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L91
        L31:
            java.lang.Object r1 = r6.L$1
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r2 = r6.L$0
            androidx.compose.material3.TimePickerState r2 = (androidx.compose.material3.TimePickerState) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r9 = r1
            r10 = r2
            goto L6d
        L3f:
            kotlin.ResultKt.throwOnFailure(r12)
            r2 = r11
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r1 = r2.currentAngle
            java.lang.Object r1 = r1.getValue()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r3 = r2.getMinuteAngle$material3_release()
            kotlin.Pair r1 = androidx.compose.material3.TimePickerKt.access$valuesForAnimation(r1, r3)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r3 = r2.currentAngle
            java.lang.Object r4 = r1.getFirst()
            r6.L$0 = r2
            r6.L$1 = r1
            r5 = 1
            r6.label = r5
            java.lang.Object r3 = r3.snapTo(r4, r6)
            if (r3 != r0) goto L6b
            return r0
        L6b:
            r9 = r1
            r10 = r2
        L6d:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r1 = r10.currentAngle
            java.lang.Object r2 = r9.getSecond()
            r3 = 0
            r4 = 6
            r5 = 200(0xc8, float:2.8E-43)
            r7 = 0
            androidx.compose.animation.core.TweenSpec r3 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r5, r3, r7, r4, r7)
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r6.L$0 = r7
            r6.L$1 = r7
            r4 = 2
            r6.label = r4
            r4 = 0
            r5 = 0
            r7 = 12
            r8 = 0
            java.lang.Object r1 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r1 != r0) goto L91
            return r0
        L91:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.settle(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onTap$material3_release(float r11, float r12, float r13, boolean r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.onTap$material3_release(float, float, float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: TimePicker.kt */
    @Metadata(m164d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¨\u0006\u0006"}, m165d2 = {"Landroidx/compose/material3/TimePickerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TimePickerState;", "material3_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<TimePickerState, ?> Saver() {
            return SaverKt.Saver(new Function2<SaverScope, TimePickerState, List<? extends Object>>() { // from class: androidx.compose.material3.TimePickerState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final List<Object> invoke(SaverScope $this$Saver, TimePickerState it) {
                    return CollectionsKt.listOf(Integer.valueOf(it.getHour()), Integer.valueOf(it.getMinute()), Boolean.valueOf(it.getIs24hour()));
                }
            }, new Function1<List, TimePickerState>() { // from class: androidx.compose.material3.TimePickerState$Companion$Saver$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ TimePickerState invoke(List list) {
                    return invoke2((List<? extends Object>) list);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final TimePickerState invoke2(List<? extends Object> list) {
                    Object obj = list.get(0);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue = ((Integer) obj).intValue();
                    Object obj2 = list.get(1);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue2 = ((Integer) obj2).intValue();
                    Object obj3 = list.get(2);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    return new TimePickerState(iIntValue, iIntValue2, ((Boolean) obj3).booleanValue());
                }
            });
        }
    }
}
