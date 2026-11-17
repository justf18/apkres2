package androidx.compose.foundation.gestures;

import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.node.LayoutAwareModifierNode;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: ContentInViewNode.kt */
@Metadata(m164d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\u001e\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150!H\u0096@¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020%H\u0002J\"\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\n\u0010+\u001a\u0004\u0018\u00010\u0015H\u0002J\n\u0010,\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\u0010\u0010.\u001a\u00020\u001f2\b\u0010/\u001a\u0004\u0018\u00010\u0012J\u0010\u00100\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b3\u00104J\"\u00105\u001a\u0002062\u0006\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00108J&\u00109\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001f\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020=H\u0082\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001f\u0010;\u001a\u00020<*\u00020\u00192\u0006\u0010>\u001a\u00020\u0019H\u0082\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010@J \u0010B\u001a\u00020\t*\u00020\u00152\b\b\u0002\u00102\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010DR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, m165d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollState", "Landroidx/compose/foundation/gestures/ScrollableState;", "reverseDirection", "", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "(Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollableState;ZLandroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "animationState", "Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "bringIntoViewRequests", "Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusedChild", "focusedChildBoundsFromPreviousRemeasure", "Landroidx/compose/ui/geometry/Rect;", "isAnimationRunning", "trackingFocusedChild", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "viewportSize", "getViewportSize-YbymL2g$foundation_release", "()J", "J", "bringChildIntoView", "", "localRect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRectForParent", "calculateScrollDelta", "", "computeDestination", "childBounds", "containerSize", "computeDestination-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "findBringIntoViewRequest", "getFocusedChildBounds", "launchAnimation", "onFocusBoundsChanged", "newBounds", "onPlaced", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "relocationOffset", "Landroidx/compose/ui/geometry/Offset;", "relocationOffset-BMxPBkI", "(Landroidx/compose/ui/geometry/Rect;J)J", "update", "state", "compareTo", "", "Landroidx/compose/ui/geometry/Size;", "other", "compareTo-iLBOSCw", "(JJ)I", "compareTo-TemP2vQ", "isMaxVisible", "isMaxVisible-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Z", "Request", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ContentInViewNode extends Modifier.Node implements BringIntoViewResponder, LayoutAwareModifierNode {
    public static final int $stable = 8;
    private final UpdatableAnimationState animationState;
    private BringIntoViewSpec bringIntoViewSpec;
    private LayoutCoordinates coordinates;
    private LayoutCoordinates focusedChild;
    private Rect focusedChildBoundsFromPreviousRemeasure;
    private boolean isAnimationRunning;
    private Orientation orientation;
    private boolean reverseDirection;
    private ScrollableState scrollState;
    private boolean trackingFocusedChild;
    private final BringIntoViewRequestPriorityQueue bringIntoViewRequests = new BringIntoViewRequestPriorityQueue();
    private long viewportSize = IntSize.INSTANCE.m6472getZeroYbymL2g();

    /* compiled from: ContentInViewNode.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ContentInViewNode(Orientation orientation, ScrollableState scrollState, boolean reverseDirection, BringIntoViewSpec bringIntoViewSpec) {
        this.orientation = orientation;
        this.scrollState = scrollState;
        this.reverseDirection = reverseDirection;
        this.bringIntoViewSpec = bringIntoViewSpec;
        this.animationState = new UpdatableAnimationState(this.bringIntoViewSpec.getScrollAnimationSpec());
    }

    /* renamed from: getViewportSize-YbymL2g$foundation_release, reason: not valid java name and from getter */
    public final long getViewportSize() {
        return this.viewportSize;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Rect calculateRectForParent(Rect localRect) {
        if (IntSize.m6465equalsimpl0(this.viewportSize, IntSize.INSTANCE.m6472getZeroYbymL2g())) {
            throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
        }
        return m527computeDestinationO0kMr_c(localRect, this.viewportSize);
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Object bringChildIntoView(Function0<Rect> function0, Continuation<? super Unit> continuation) {
        Rect rectInvoke = function0.invoke();
        boolean z = false;
        if (rectInvoke != null && !m529isMaxVisibleO0kMr_c$default(this, rectInvoke, 0L, 1, null)) {
            z = true;
        }
        if (!z) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl continuation2 = cancellable$iv;
        Request request = new Request(function0, continuation2);
        if (this.bringIntoViewRequests.enqueue(request) && !this.isAnimationRunning) {
            launchAnimation();
        }
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    public final void onFocusBoundsChanged(LayoutCoordinates newBounds) {
        this.focusedChild = newBounds;
    }

    @Override // androidx.compose.p000ui.node.LayoutAwareModifierNode
    public void onPlaced(LayoutCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override // androidx.compose.p000ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI */
    public void mo508onRemeasuredozmzZPI(long size) {
        Rect focusedChild;
        long oldSize = this.viewportSize;
        this.viewportSize = size;
        if (m525compareToTemP2vQ(size, oldSize) < 0 && (focusedChild = getFocusedChildBounds()) != null) {
            Rect previousFocusedChildBounds = this.focusedChildBoundsFromPreviousRemeasure;
            if (previousFocusedChildBounds == null) {
                previousFocusedChildBounds = focusedChild;
            }
            if (!this.isAnimationRunning && !this.trackingFocusedChild && m528isMaxVisibleO0kMr_c(previousFocusedChildBounds, oldSize) && !m528isMaxVisibleO0kMr_c(focusedChild, size)) {
                this.trackingFocusedChild = true;
                launchAnimation();
            }
            this.focusedChildBoundsFromPreviousRemeasure = focusedChild;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getFocusedChildBounds() {
        LayoutCoordinates focusedChild;
        LayoutCoordinates coordinates = this.coordinates;
        if (coordinates != null) {
            if (!coordinates.isAttached()) {
                coordinates = null;
            }
            if (coordinates != null && (focusedChild = this.focusedChild) != null) {
                if (!focusedChild.isAttached()) {
                    focusedChild = null;
                }
                if (focusedChild != null) {
                    return coordinates.localBoundingBoxOf(focusedChild, false);
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchAnimation() {
        if (this.isAnimationRunning) {
            throw new IllegalStateException("launchAnimation called when previous animation was running".toString());
        }
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new C03562(null), 1, null);
    }

    /* compiled from: ContentInViewNode.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2", m180f = "ContentInViewNode.kt", m181i = {}, m182l = {190}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2 */
    static final class C03562 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C03562(Continuation<? super C03562> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03562 c03562 = ContentInViewNode.this.new C03562(continuation);
            c03562.L$0 = obj;
            return c03562;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03562) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CancellationException cancellationException;
            C03562 c03562;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            C03562 c035622 = this.label;
            try {
                switch (c035622) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        c035622 = this;
                        Job job = JobKt.getJob(((CoroutineScope) c035622.L$0).getCoroutineContext());
                        try {
                            ContentInViewNode.this.isAnimationRunning = true;
                            c035622.label = 1;
                            if (ScrollableState.scroll$default(ContentInViewNode.this.scrollState, null, new AnonymousClass1(ContentInViewNode.this, job, null), (Continuation) c035622, 1, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            cancellationException = null;
                            c03562 = c035622;
                            ContentInViewNode.this.bringIntoViewRequests.resumeAndRemoveAll();
                            ContentInViewNode.this.isAnimationRunning = false;
                            ContentInViewNode.this.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                            ContentInViewNode.this.trackingFocusedChild = false;
                            return Unit.INSTANCE;
                        } catch (CancellationException e) {
                            e = e;
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            ContentInViewNode.this.isAnimationRunning = false;
                            ContentInViewNode.this.bringIntoViewRequests.cancelAndRemoveAll((Throwable) null);
                            ContentInViewNode.this.trackingFocusedChild = false;
                            throw th;
                        }
                    case 1:
                        c03562 = this;
                        cancellationException = null;
                        try {
                            ResultKt.throwOnFailure(obj);
                            ContentInViewNode.this.bringIntoViewRequests.resumeAndRemoveAll();
                            ContentInViewNode.this.isAnimationRunning = false;
                            ContentInViewNode.this.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                            ContentInViewNode.this.trackingFocusedChild = false;
                            return Unit.INSTANCE;
                        } catch (CancellationException e2) {
                            e = e2;
                            throw e;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        /* compiled from: ContentInViewNode.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1", m180f = "ContentInViewNode.kt", m181i = {}, m182l = {195}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Job $animationJob;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContentInViewNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ContentInViewNode contentInViewNode, Job job, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = contentInViewNode;
                this.$animationJob = job;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$animationJob, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final ScrollScope $this$scroll = (ScrollScope) this.L$0;
                        this.this$0.animationState.setValue(this.this$0.calculateScrollDelta());
                        UpdatableAnimationState updatableAnimationState = this.this$0.animationState;
                        final ContentInViewNode contentInViewNode = this.this$0;
                        final Job job = this.$animationJob;
                        Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                                invoke(f.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float delta) {
                                float scrollMultiplier = contentInViewNode.reverseDirection ? 1.0f : -1.0f;
                                float adjustedDelta = scrollMultiplier * delta;
                                float consumedScroll = $this$scroll.scrollBy(adjustedDelta) * scrollMultiplier;
                                if (Math.abs(consumedScroll) < Math.abs(delta)) {
                                    JobKt__JobKt.cancel$default(job, "Scroll animation cancelled because scroll was not consumed (" + consumedScroll + " < " + delta + ')', null, 2, null);
                                }
                            }
                        };
                        final ContentInViewNode contentInViewNode2 = this.this$0;
                        this.label = 1;
                        if (updatableAnimationState.animateToZero(function1, new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                BringIntoViewRequestPriorityQueue this_$iv = contentInViewNode2.bringIntoViewRequests;
                                ContentInViewNode contentInViewNode3 = contentInViewNode2;
                                while (true) {
                                    if (!this_$iv.requests.isNotEmpty()) {
                                        break;
                                    }
                                    Rect bounds = ((Request) this_$iv.requests.last()).getCurrentBounds().invoke();
                                    if (!(bounds == null ? true : ContentInViewNode.m529isMaxVisibleO0kMr_c$default(contentInViewNode3, bounds, 0L, 1, null))) {
                                        break;
                                    }
                                    MutableVector mutableVector = this_$iv.requests;
                                    MutableVector this_$iv$iv = this_$iv.requests;
                                    CancellableContinuation<Unit> continuation = ((Request) mutableVector.removeAt(this_$iv$iv.getSize() - 1)).getContinuation();
                                    Unit unit = Unit.INSTANCE;
                                    Result.Companion companion = Result.INSTANCE;
                                    continuation.resumeWith(Result.m6604constructorimpl(unit));
                                }
                                if (contentInViewNode2.trackingFocusedChild) {
                                    Rect focusedChildBounds = contentInViewNode2.getFocusedChildBounds();
                                    if (focusedChildBounds != null && ContentInViewNode.m529isMaxVisibleO0kMr_c$default(contentInViewNode2, focusedChildBounds, 0L, 1, null)) {
                                        contentInViewNode2.trackingFocusedChild = false;
                                    }
                                }
                                contentInViewNode2.animationState.setValue(contentInViewNode2.calculateScrollDelta());
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float calculateScrollDelta() {
        if (IntSize.m6465equalsimpl0(this.viewportSize, IntSize.INSTANCE.m6472getZeroYbymL2g())) {
            return 0.0f;
        }
        Rect rectangleToMakeVisible = findBringIntoViewRequest();
        if (rectangleToMakeVisible == null) {
            rectangleToMakeVisible = this.trackingFocusedChild ? getFocusedChildBounds() : null;
            if (rectangleToMakeVisible == null) {
                return 0.0f;
            }
        }
        long size = IntSizeKt.m6477toSizeozmzZPI(this.viewportSize);
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return this.bringIntoViewSpec.calculateScrollDistance(rectangleToMakeVisible.getTop(), rectangleToMakeVisible.getBottom() - rectangleToMakeVisible.getTop(), Size.m3774getHeightimpl(size));
            case 2:
                return this.bringIntoViewSpec.calculateScrollDistance(rectangleToMakeVisible.getLeft(), rectangleToMakeVisible.getRight() - rectangleToMakeVisible.getLeft(), Size.m3777getWidthimpl(size));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final Rect findBringIntoViewRequest() {
        BringIntoViewRequestPriorityQueue this_$iv;
        Rect rect = null;
        BringIntoViewRequestPriorityQueue this_$iv2 = this.bringIntoViewRequests;
        MutableVector this_$iv$iv = this_$iv2.requests;
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = size$iv$iv - 1;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            while (true) {
                Request it$iv = (Request) content$iv$iv[i$iv$iv];
                Rect bounds = it$iv.getCurrentBounds().invoke();
                if (bounds != null) {
                    Rect rect2 = rect;
                    this_$iv = this_$iv2;
                    if (m526compareToiLBOSCw(bounds.m3741getSizeNHjbRc(), IntSizeKt.m6477toSizeozmzZPI(this.viewportSize)) > 0) {
                        return rect2 == null ? bounds : rect2;
                    }
                    rect = bounds;
                } else {
                    this_$iv = this_$iv2;
                }
                i$iv$iv--;
                if (i$iv$iv < 0) {
                    break;
                }
                this_$iv2 = this_$iv;
            }
        }
        return rect;
    }

    /* renamed from: computeDestination-O0kMr_c, reason: not valid java name */
    private final Rect m527computeDestinationO0kMr_c(Rect childBounds, long containerSize) {
        return childBounds.m3745translatek4lQ0M(Offset.m3717unaryMinusF1C5BW0(m530relocationOffsetBMxPBkI(childBounds, containerSize)));
    }

    /* renamed from: isMaxVisible-O0kMr_c$default, reason: not valid java name */
    static /* synthetic */ boolean m529isMaxVisibleO0kMr_c$default(ContentInViewNode contentInViewNode, Rect rect, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = contentInViewNode.viewportSize;
        }
        return contentInViewNode.m528isMaxVisibleO0kMr_c(rect, j);
    }

    /* renamed from: isMaxVisible-O0kMr_c, reason: not valid java name */
    private final boolean m528isMaxVisibleO0kMr_c(Rect $this$isMaxVisible_u2dO0kMr_c, long size) {
        long relocationOffset = m530relocationOffsetBMxPBkI($this$isMaxVisible_u2dO0kMr_c, size);
        return Math.abs(Offset.m3708getXimpl(relocationOffset)) <= 0.5f && Math.abs(Offset.m3709getYimpl(relocationOffset)) <= 0.5f;
    }

    /* renamed from: relocationOffset-BMxPBkI, reason: not valid java name */
    private final long m530relocationOffsetBMxPBkI(Rect childBounds, long containerSize) {
        long size = IntSizeKt.m6477toSizeozmzZPI(containerSize);
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return OffsetKt.Offset(0.0f, this.bringIntoViewSpec.calculateScrollDistance(childBounds.getTop(), childBounds.getBottom() - childBounds.getTop(), Size.m3774getHeightimpl(size)));
            case 2:
                return OffsetKt.Offset(this.bringIntoViewSpec.calculateScrollDistance(childBounds.getLeft(), childBounds.getRight() - childBounds.getLeft(), Size.m3777getWidthimpl(size)), 0.0f);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: compareTo-TemP2vQ, reason: not valid java name */
    private final int m525compareToTemP2vQ(long $this$compareTo_u2dTemP2vQ, long other) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return Intrinsics.compare(IntSize.m6466getHeightimpl($this$compareTo_u2dTemP2vQ), IntSize.m6466getHeightimpl(other));
            case 2:
                return Intrinsics.compare(IntSize.m6467getWidthimpl($this$compareTo_u2dTemP2vQ), IntSize.m6467getWidthimpl(other));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: compareTo-iLBOSCw, reason: not valid java name */
    private final int m526compareToiLBOSCw(long $this$compareTo_u2diLBOSCw, long other) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()]) {
            case 1:
                return Float.compare(Size.m3774getHeightimpl($this$compareTo_u2diLBOSCw), Size.m3774getHeightimpl(other));
            case 2:
                return Float.compare(Size.m3777getWidthimpl($this$compareTo_u2diLBOSCw), Size.m3777getWidthimpl(other));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void update(Orientation orientation, ScrollableState state, boolean reverseDirection, BringIntoViewSpec bringIntoViewSpec) {
        this.orientation = orientation;
        this.scrollState = state;
        this.reverseDirection = reverseDirection;
        this.bringIntoViewSpec = bringIntoViewSpec;
    }

    /* compiled from: ContentInViewNode.kt */
    @Metadata(m164d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m165d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "", "currentBounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CancellableContinuation;)V", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "getCurrentBounds", "()Lkotlin/jvm/functions/Function0;", "toString", "", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Request {
        public static final int $stable = 8;
        private final CancellableContinuation<Unit> continuation;
        private final Function0<Rect> currentBounds;

        /* JADX WARN: Multi-variable type inference failed */
        public Request(Function0<Rect> function0, CancellableContinuation<? super Unit> cancellableContinuation) {
            this.currentBounds = function0;
            this.continuation = cancellableContinuation;
        }

        public final Function0<Rect> getCurrentBounds() {
            return this.currentBounds;
        }

        public final CancellableContinuation<Unit> getContinuation() {
            return this.continuation;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                kotlinx.coroutines.CancellableContinuation<kotlin.Unit> r0 = r6.continuation
                kotlin.coroutines.CoroutineContext r0 = r0.get$context()
                kotlinx.coroutines.CoroutineName$Key r1 = kotlinx.coroutines.CoroutineName.INSTANCE
                kotlin.coroutines.CoroutineContext$Key r1 = (kotlin.coroutines.CoroutineContext.Key) r1
                kotlin.coroutines.CoroutineContext$Element r0 = r0.get(r1)
                kotlinx.coroutines.CoroutineName r0 = (kotlinx.coroutines.CoroutineName) r0
                if (r0 == 0) goto L17
                java.lang.String r0 = r0.getName()
                goto L18
            L17:
                r0 = 0
            L18:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Request@"
                java.lang.StringBuilder r1 = r1.append(r2)
                int r2 = r6.hashCode()
                r3 = 16
                int r3 = kotlin.text.CharsKt.checkRadix(r3)
                java.lang.String r2 = java.lang.Integer.toString(r2, r3)
                java.lang.String r3 = "toString(this, checkRadix(radix))"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                java.lang.StringBuilder r1 = r1.append(r2)
                if (r0 == 0) goto L5a
                r2 = r0
                r3 = 0
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r5 = 91
                java.lang.StringBuilder r4 = r4.append(r5)
                java.lang.StringBuilder r4 = r4.append(r2)
                java.lang.String r5 = "]("
                java.lang.StringBuilder r4 = r4.append(r5)
                java.lang.String r2 = r4.toString()
                if (r2 != 0) goto L5c
            L5a:
                java.lang.String r2 = "("
            L5c:
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r2 = "currentBounds()="
                java.lang.StringBuilder r1 = r1.append(r2)
                kotlin.jvm.functions.Function0<androidx.compose.ui.geometry.Rect> r2 = r6.currentBounds
                java.lang.Object r2 = r2.invoke()
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r2 = ", continuation="
                java.lang.StringBuilder r1 = r1.append(r2)
                kotlinx.coroutines.CancellableContinuation<kotlin.Unit> r2 = r6.continuation
                java.lang.StringBuilder r1 = r1.append(r2)
                r2 = 41
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ContentInViewNode.Request.toString():java.lang.String");
        }
    }
}
