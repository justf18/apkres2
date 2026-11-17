package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.p000ui.graphics.GraphicsLayerScope;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyLayoutAnimation.kt */
@Metadata(m164d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 C2\u00020\u0001:\u0001CB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010=\u001a\u00020\u001cJ\u0018\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b@\u0010%J\u0006\u0010A\u001a\u00020\u001cJ\u0006\u0010B\u001a\u00020\u001cR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R+\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020!X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R1\u0010'\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020!8F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b*\u0010\u0015\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010.\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\t\"\u0004\b0\u0010\u000bR\"\u00101\u001a\u00020!X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b2\u0010#\"\u0004\b3\u0010%R+\u00104\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020<0,X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006D"}, m165d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "appearanceSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "getAppearanceSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAppearanceSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "", "isAppearanceAnimationInProgress", "()Z", "setAppearanceAnimationInProgress", "(Z)V", "isAppearanceAnimationInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "isPlacementAnimationInProgress", "setPlacementAnimationInProgress", "isPlacementAnimationInProgress$delegate", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "lookaheadOffset", "Landroidx/compose/ui/unit/IntOffset;", "getLookaheadOffset-nOcc-ac", "()J", "setLookaheadOffset--gyyYBs", "(J)V", "J", "placementDelta", "getPlacementDelta-nOcc-ac", "setPlacementDelta--gyyYBs", "placementDelta$delegate", "placementDeltaAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector2D;", "placementSpec", "getPlacementSpec", "setPlacementSpec", "rawOffset", "getRawOffset-nOcc-ac", "setRawOffset--gyyYBs", "visibility", "getVisibility", "()F", "setVisibility", "(F)V", "visibility$delegate", "Landroidx/compose/runtime/MutableFloatState;", "visibilityAnimation", "Landroidx/compose/animation/core/AnimationVector1D;", "animateAppearance", "animatePlacementDelta", "delta", "animatePlacementDelta--gyyYBs", "cancelPlacementAnimation", "stopAnimations", "Companion", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyLayoutAnimation {
    private FiniteAnimationSpec<Float> appearanceSpec;
    private final CoroutineScope coroutineScope;
    private final Animatable<IntOffset, AnimationVector2D> placementDeltaAnimation;
    private FiniteAnimationSpec<IntOffset> placementSpec;
    private final Animatable<Float, AnimationVector1D> visibilityAnimation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final long NotInitialized = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);

    /* renamed from: isPlacementAnimationInProgress$delegate, reason: from kotlin metadata */
    private final MutableState isPlacementAnimationInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* renamed from: isAppearanceAnimationInProgress$delegate, reason: from kotlin metadata */
    private final MutableState isAppearanceAnimationInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    private long rawOffset = NotInitialized;

    /* renamed from: placementDelta$delegate, reason: from kotlin metadata */
    private final MutableState placementDelta = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m6416boximpl(IntOffset.INSTANCE.m6435getZeronOccac()), null, 2, null);

    /* renamed from: visibility$delegate, reason: from kotlin metadata */
    private final MutableFloatState visibility = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
    private final Function1<GraphicsLayerScope, Unit> layerBlock = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$layerBlock$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
            invoke2(graphicsLayerScope);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GraphicsLayerScope $this$null) {
            $this$null.setAlpha(this.this$0.getVisibility());
        }
    };
    private long lookaheadOffset = NotInitialized;

    public LazyLayoutAnimation(CoroutineScope coroutineScope) {
        this.coroutineScope = coroutineScope;
        String str = null;
        this.placementDeltaAnimation = new Animatable<>(IntOffset.m6416boximpl(IntOffset.INSTANCE.m6435getZeronOccac()), VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE), null, str, 12, null);
        this.visibilityAnimation = new Animatable<>(Float.valueOf(1.0f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), str, null, 12, null);
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final FiniteAnimationSpec<Float> getAppearanceSpec() {
        return this.appearanceSpec;
    }

    public final void setAppearanceSpec(FiniteAnimationSpec<Float> finiteAnimationSpec) {
        this.appearanceSpec = finiteAnimationSpec;
    }

    public final FiniteAnimationSpec<IntOffset> getPlacementSpec() {
        return this.placementSpec;
    }

    public final void setPlacementSpec(FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        this.placementSpec = finiteAnimationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPlacementAnimationInProgress(boolean z) {
        MutableState $this$setValue$iv = this.isPlacementAnimationInProgress;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final boolean isPlacementAnimationInProgress() {
        State $this$getValue$iv = this.isPlacementAnimationInProgress;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAppearanceAnimationInProgress(boolean z) {
        MutableState $this$setValue$iv = this.isAppearanceAnimationInProgress;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final boolean isAppearanceAnimationInProgress() {
        State $this$getValue$iv = this.isAppearanceAnimationInProgress;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* renamed from: getRawOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getRawOffset() {
        return this.rawOffset;
    }

    /* renamed from: setRawOffset--gyyYBs, reason: not valid java name */
    public final void m920setRawOffsetgyyYBs(long j) {
        this.rawOffset = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setPlacementDelta--gyyYBs, reason: not valid java name */
    public final void m914setPlacementDeltagyyYBs(long j) {
        MutableState $this$setValue$iv = this.placementDelta;
        $this$setValue$iv.setValue(IntOffset.m6416boximpl(j));
    }

    /* renamed from: getPlacementDelta-nOcc-ac, reason: not valid java name */
    public final long m917getPlacementDeltanOccac() {
        State $this$getValue$iv = this.placementDelta;
        return ((IntOffset) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVisibility(float f) {
        MutableFloatState $this$setValue$iv = this.visibility;
        $this$setValue$iv.setFloatValue(f);
    }

    public final float getVisibility() {
        FloatState $this$getValue$iv = this.visibility;
        return $this$getValue$iv.getFloatValue();
    }

    public final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    /* compiled from: LazyLayoutAnimation.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$cancelPlacementAnimation$1", m180f = "LazyLayoutAnimation.kt", m181i = {}, m182l = {92}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$cancelPlacementAnimation$1 */
    static final class C06071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06071(Continuation<? super C06071> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutAnimation.this.new C06071(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C06071 c06071;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (LazyLayoutAnimation.this.placementDeltaAnimation.snapTo(IntOffset.m6416boximpl(IntOffset.INSTANCE.m6435getZeronOccac()), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c06071 = this;
                    break;
                case 1:
                    c06071 = this;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LazyLayoutAnimation.this.m914setPlacementDeltagyyYBs(IntOffset.INSTANCE.m6435getZeronOccac());
            LazyLayoutAnimation.this.setPlacementAnimationInProgress(false);
            return Unit.INSTANCE;
        }
    }

    public final void cancelPlacementAnimation() {
        if (isPlacementAnimationInProgress()) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C06071(null), 3, null);
        }
    }

    /* renamed from: getLookaheadOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getLookaheadOffset() {
        return this.lookaheadOffset;
    }

    /* renamed from: setLookaheadOffset--gyyYBs, reason: not valid java name */
    public final void m919setLookaheadOffsetgyyYBs(long j) {
        this.lookaheadOffset = j;
    }

    /* renamed from: animatePlacementDelta--gyyYBs, reason: not valid java name */
    public final void m915animatePlacementDeltagyyYBs(long delta) {
        FiniteAnimationSpec spec = this.placementSpec;
        if (spec == null) {
            return;
        }
        long arg0$iv = m917getPlacementDeltanOccac();
        long totalDelta = IntOffsetKt.IntOffset(IntOffset.m6425getXimpl(arg0$iv) - IntOffset.m6425getXimpl(delta), IntOffset.m6426getYimpl(arg0$iv) - IntOffset.m6426getYimpl(delta));
        m914setPlacementDeltagyyYBs(totalDelta);
        setPlacementAnimationInProgress(true);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new LazyLayoutAnimation$animatePlacementDelta$1(this, spec, totalDelta, null), 3, null);
    }

    public final void animateAppearance() {
        FiniteAnimationSpec spec = this.appearanceSpec;
        if (isAppearanceAnimationInProgress() || spec == null) {
            return;
        }
        setAppearanceAnimationInProgress(true);
        setVisibility(0.0f);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C06051(spec, null), 3, null);
    }

    /* compiled from: LazyLayoutAnimation.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$1", m180f = "LazyLayoutAnimation.kt", m181i = {}, m182l = {155, 156}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$1 */
    static final class C06051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FiniteAnimationSpec<Float> $spec;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06051(FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super C06051> continuation) {
            super(2, continuation);
            this.$spec = finiteAnimationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutAnimation.this.new C06051(this.$spec, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0065 A[RETURN] */
        /* JADX WARN: Type inference failed for: r1v0, types: [androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$1, int] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.label
                r2 = 0
                switch(r1) {
                    case 0: goto L1e;
                    case 1: goto L17;
                    case 2: goto L12;
                    default: goto La;
                }
            La:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L12:
                r1 = r12
                kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L1c
                goto L66
            L17:
                r1 = r12
                kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L1c
                goto L3b
            L1c:
                r0 = move-exception
                goto L6f
            L1e:
                kotlin.ResultKt.throwOnFailure(r13)
                r1 = r12
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimation r3 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.this     // Catch: java.lang.Throwable -> L1c
                androidx.compose.animation.core.Animatable r3 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.access$getVisibilityAnimation$p(r3)     // Catch: java.lang.Throwable -> L1c
                r4 = 0
                java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)     // Catch: java.lang.Throwable -> L1c
                r5 = r1
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L1c
                r6 = 1
                r1.label = r6     // Catch: java.lang.Throwable -> L1c
                java.lang.Object r3 = r3.snapTo(r4, r5)     // Catch: java.lang.Throwable -> L1c
                if (r3 != r0) goto L3b
                return r0
            L3b:
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimation r3 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.this     // Catch: java.lang.Throwable -> L1c
                androidx.compose.animation.core.Animatable r4 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.access$getVisibilityAnimation$p(r3)     // Catch: java.lang.Throwable -> L1c
                r3 = 1065353216(0x3f800000, float:1.0)
                java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)     // Catch: java.lang.Throwable -> L1c
                androidx.compose.animation.core.FiniteAnimationSpec<java.lang.Float> r3 = r1.$spec     // Catch: java.lang.Throwable -> L1c
                r6 = r3
                androidx.compose.animation.core.AnimationSpec r6 = (androidx.compose.animation.core.AnimationSpec) r6     // Catch: java.lang.Throwable -> L1c
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$1$1 r3 = new androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$1$1     // Catch: java.lang.Throwable -> L1c
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimation r7 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.this     // Catch: java.lang.Throwable -> L1c
                r3.<init>()     // Catch: java.lang.Throwable -> L1c
                r8 = r3
                kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8     // Catch: java.lang.Throwable -> L1c
                r9 = r1
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch: java.lang.Throwable -> L1c
                r3 = 2
                r1.label = r3     // Catch: java.lang.Throwable -> L1c
                r7 = 0
                r10 = 4
                r11 = 0
                java.lang.Object r3 = androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L1c
                if (r3 != r0) goto L66
                return r0
            L66:
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimation r0 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.this
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.access$setAppearanceAnimationInProgress(r0, r2)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L6f:
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimation r3 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.this
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.access$setAppearanceAnimationInProgress(r3, r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.C06051.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void stopAnimations() {
        if (isPlacementAnimationInProgress()) {
            setPlacementAnimationInProgress(false);
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C06081(null), 3, null);
        }
        if (isAppearanceAnimationInProgress()) {
            setAppearanceAnimationInProgress(false);
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C06092(null), 3, null);
        }
        m914setPlacementDeltagyyYBs(IntOffset.INSTANCE.m6435getZeronOccac());
        this.rawOffset = NotInitialized;
        setVisibility(1.0f);
    }

    /* compiled from: LazyLayoutAnimation.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$stopAnimations$1", m180f = "LazyLayoutAnimation.kt", m181i = {}, m182l = {169}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$stopAnimations$1 */
    static final class C06081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06081(Continuation<? super C06081> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutAnimation.this.new C06081(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (LazyLayoutAnimation.this.placementDeltaAnimation.stop(this) != coroutine_suspended) {
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

    /* compiled from: LazyLayoutAnimation.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$stopAnimations$2", m180f = "LazyLayoutAnimation.kt", m181i = {}, m182l = {175}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$stopAnimations$2 */
    static final class C06092 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06092(Continuation<? super C06092> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LazyLayoutAnimation.this.new C06092(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06092) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (LazyLayoutAnimation.this.visibilityAnimation.stop(this) != coroutine_suspended) {
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

    /* compiled from: LazyLayoutAnimation.kt */
    @Metadata(m164d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, m165d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation$Companion;", "", "()V", "NotInitialized", "Landroidx/compose/ui/unit/IntOffset;", "getNotInitialized-nOcc-ac", "()J", "J", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNotInitialized-nOcc-ac, reason: not valid java name */
        public final long m921getNotInitializednOccac() {
            return LazyLayoutAnimation.NotInitialized;
        }
    }
}
