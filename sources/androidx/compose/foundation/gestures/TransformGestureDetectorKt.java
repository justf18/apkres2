package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: TransformGestureDetector.kt */
@Metadata(m164d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u000f\u0010\u000b\u001a\u00020\u0002*\u00020\u0006¢\u0006\u0002\u0010\f\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0006\u001a~\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2`\u0010\u0013\u001a\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@¢\u0006\u0002\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, m165d2 = {"angle", "", "Landroidx/compose/ui/geometry/Offset;", "angle-k-4lQ0M", "(J)F", "calculateCentroid", "Landroidx/compose/ui/input/pointer/PointerEvent;", "useCurrent", "", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "calculateCentroidSize", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateRotation", "calculateZoom", "detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "onGesture", "Lkotlin/Function4;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "centroid", "pan", "zoom", Key.ROTATION, "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TransformGestureDetectorKt {
    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z, Function4 function4, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return detectTransformGestures(pointerInputScope, z, function4, continuation);
    }

    /* compiled from: TransformGestureDetector.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", m180f = "TransformGestureDetector.kt", m181i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m182l = {59, LockFreeTaskQueueCore.CLOSED_SHIFT}, m183m = "invokeSuspend", m184n = {"$this$awaitEachGesture", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitEachGesture", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, m185s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"})
    /* renamed from: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2 */
    static final class C04162 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
        final /* synthetic */ boolean $panZoomLock;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04162(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super C04162> continuation) {
            super(2, continuation);
            this.$panZoomLock = z;
            this.$onGesture = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C04162 c04162 = new C04162(this.$panZoomLock, this.$onGesture, continuation);
            c04162.L$0 = obj;
            return c04162;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C04162) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x00b5 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x01b1  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x01cc  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x01d3  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x00f6 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00b6 -> B:17:0x00c2). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r27) {
            /*
                Method dump skipped, instructions count: 544
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformGestureDetectorKt.C04162.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object detectTransformGestures(PointerInputScope $this$detectTransformGestures, boolean panZoomLock, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectTransformGestures, new C04162(panZoomLock, function4, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static final float calculateRotation(PointerEvent $this$calculateRotation) {
        float rotation;
        float f;
        int pointerCount;
        long previousCentroid;
        float f2;
        List $this$fastSumBy$iv = $this$calculateRotation.getChanges();
        int sum$iv = 0;
        int index$iv$iv = 0;
        int size = $this$fastSumBy$iv.size();
        while (true) {
            int i = 0;
            if (index$iv$iv >= size) {
                break;
            }
            Object item$iv$iv = $this$fastSumBy$iv.get(index$iv$iv);
            PointerInputChange it = (PointerInputChange) item$iv$iv;
            if (it.getPreviousPressed() && it.getPressed()) {
                i = 1;
            }
            sum$iv += i;
            index$iv$iv++;
        }
        float f3 = 0.0f;
        if (sum$iv < 2) {
            return 0.0f;
        }
        long currentCentroid = calculateCentroid($this$calculateRotation, true);
        long previousCentroid2 = calculateCentroid($this$calculateRotation, false);
        float rotation2 = 0.0f;
        float rotationWeight = 0.0f;
        List $this$fastForEach$iv = $this$calculateRotation.getChanges();
        int index$iv = 0;
        int size2 = $this$fastForEach$iv.size();
        while (index$iv < size2) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            PointerInputChange change = (PointerInputChange) item$iv;
            if (!change.getPressed() || !change.getPreviousPressed()) {
                rotation = rotation2;
                f = f3;
                pointerCount = sum$iv;
                previousCentroid = previousCentroid2;
            } else {
                f = f3;
                pointerCount = sum$iv;
                long currentPosition = change.getPosition();
                long previousPosition = change.getPreviousPosition();
                float rotation3 = rotation2;
                long previousOffset = Offset.m3712minusMKHz9U(previousPosition, previousCentroid2);
                previousCentroid = previousCentroid2;
                long currentOffset = Offset.m3712minusMKHz9U(currentPosition, currentCentroid);
                float previousAngle = m623anglek4lQ0M(previousOffset);
                float currentAngle = m623anglek4lQ0M(currentOffset);
                float angleDiff = currentAngle - previousAngle;
                float weight = Offset.m3706getDistanceimpl(Offset.m3713plusMKHz9U(currentOffset, previousOffset)) / 2.0f;
                if (angleDiff > 180.0f) {
                    f2 = angleDiff - 360.0f;
                } else {
                    f2 = angleDiff < -180.0f ? angleDiff + 360.0f : angleDiff;
                }
                rotation = rotation3 + (f2 * weight);
                rotationWeight += weight;
            }
            rotation2 = rotation;
            index$iv++;
            sum$iv = pointerCount;
            f3 = f;
            previousCentroid2 = previousCentroid;
        }
        float f4 = f3;
        return (rotationWeight > f4 ? 1 : (rotationWeight == f4 ? 0 : -1)) == 0 ? f4 : rotation2 / rotationWeight;
    }

    /* renamed from: angle-k-4lQ0M, reason: not valid java name */
    private static final float m623anglek4lQ0M(long $this$angle_u2dk_u2d4lQ0M) {
        if (Offset.m3708getXimpl($this$angle_u2dk_u2d4lQ0M) == 0.0f) {
            if (Offset.m3709getYimpl($this$angle_u2dk_u2d4lQ0M) == 0.0f) {
                return 0.0f;
            }
        }
        return ((-((float) Math.atan2(Offset.m3708getXimpl($this$angle_u2dk_u2d4lQ0M), Offset.m3709getYimpl($this$angle_u2dk_u2d4lQ0M)))) * 180.0f) / 3.1415927f;
    }

    public static final float calculateZoom(PointerEvent $this$calculateZoom) {
        boolean z;
        boolean z2 = true;
        float currentCentroidSize = calculateCentroidSize($this$calculateZoom, true);
        float previousCentroidSize = calculateCentroidSize($this$calculateZoom, false);
        if (currentCentroidSize == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return 1.0f;
        }
        if (previousCentroidSize != 0.0f) {
            z2 = false;
        }
        if (z2) {
            return 1.0f;
        }
        return currentCentroidSize / previousCentroidSize;
    }

    public static final long calculatePan(PointerEvent $this$calculatePan) {
        long currentCentroid = calculateCentroid($this$calculatePan, true);
        if (Offset.m3705equalsimpl0(currentCentroid, Offset.INSTANCE.m3723getUnspecifiedF1C5BW0())) {
            return Offset.INSTANCE.m3724getZeroF1C5BW0();
        }
        long previousCentroid = calculateCentroid($this$calculatePan, false);
        return Offset.m3712minusMKHz9U(currentCentroid, previousCentroid);
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroidSize(pointerEvent, z);
    }

    public static final float calculateCentroidSize(PointerEvent $this$calculateCentroidSize, boolean useCurrent) {
        long centroid = calculateCentroid($this$calculateCentroidSize, useCurrent);
        if (Offset.m3705equalsimpl0(centroid, Offset.INSTANCE.m3723getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        float distanceToCentroid = 0.0f;
        int distanceWeight = 0;
        List $this$fastForEach$iv = $this$calculateCentroidSize.getChanges();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            PointerInputChange change = (PointerInputChange) item$iv;
            if (change.getPressed() && change.getPreviousPressed()) {
                long position = useCurrent ? change.getPosition() : change.getPreviousPosition();
                distanceToCentroid += Offset.m3706getDistanceimpl(Offset.m3712minusMKHz9U(position, centroid));
                distanceWeight++;
            }
        }
        return distanceToCentroid / distanceWeight;
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z);
    }

    public static final long calculateCentroid(PointerEvent $this$calculateCentroid, boolean useCurrent) {
        long centroid = Offset.INSTANCE.m3724getZeroF1C5BW0();
        int centroidWeight = 0;
        List $this$fastForEach$iv = $this$calculateCentroid.getChanges();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            PointerInputChange change = (PointerInputChange) item$iv;
            if (change.getPressed() && change.getPreviousPressed()) {
                long position = useCurrent ? change.getPosition() : change.getPreviousPosition();
                centroid = Offset.m3713plusMKHz9U(centroid, position);
                centroidWeight++;
            }
        }
        if (centroidWeight == 0) {
            return Offset.INSTANCE.m3723getUnspecifiedF1C5BW0();
        }
        return Offset.m3703divtuRUvjQ(centroid, centroidWeight);
    }
}
