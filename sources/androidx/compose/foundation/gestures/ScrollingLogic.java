package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p000ui.unit.Velocity;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: Scrollable.kt */
@Metadata(m164d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b \u0010\u001cJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\tJ\u0006\u0010(\u001a\u00020\tJ8\u0010)\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ$\u0010*\u001a\u00020\"*\u00020+2\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020.ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0014\u00101\u001a\u00020\"*\u00020\"ø\u0001\u0000¢\u0006\u0004\b2\u0010%J\n\u00101\u001a\u000203*\u000203J\u0014\u00104\u001a\u00020\"*\u00020\"ø\u0001\u0000¢\u0006\u0004\b5\u0010%J\u0014\u00106\u001a\u00020\u0019*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b7\u0010%J\u0014\u00108\u001a\u000203*\u00020\"ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0014\u00108\u001a\u000203*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b;\u0010:J\u0017\u0010<\u001a\u00020\"*\u000203ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001c\u0010)\u001a\u00020\u0019*\u00020\u00192\u0006\u0010?\u001a\u000203ø\u0001\u0000¢\u0006\u0004\b@\u0010AR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, m165d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "reverseDirection", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/OverscrollEffect;ZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "isNestedFlinging", "Landroidx/compose/runtime/MutableState;", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/ScrollableState;)V", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "()Z", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "", "initialVelocity", "onDragStopped-sF-c-tU", "performRawScroll", "Landroidx/compose/ui/geometry/Offset;", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "registerNestedFling", "isFlinging", "shouldScrollImmediately", "update", "dispatchScroll", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialAvailableDelta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class ScrollingLogic {
    private FlingBehavior flingBehavior;
    private final MutableState<Boolean> isNestedFlinging = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    private NestedScrollDispatcher nestedScrollDispatcher;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private boolean reverseDirection;
    private ScrollableState scrollableState;

    public ScrollingLogic(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean reverseDirection, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        this.scrollableState = scrollableState;
        this.orientation = orientation;
        this.overscrollEffect = overscrollEffect;
        this.reverseDirection = reverseDirection;
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final void setScrollableState(ScrollableState scrollableState) {
        this.scrollableState = scrollableState;
    }

    /* renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m616toOffsettuRUvjQ(float $this$toOffset_u2dtuRUvjQ) {
        if ($this$toOffset_u2dtuRUvjQ == 0.0f) {
            return Offset.INSTANCE.m3724getZeroF1C5BW0();
        }
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset($this$toOffset_u2dtuRUvjQ, 0.0f);
        }
        return OffsetKt.Offset(0.0f, $this$toOffset_u2dtuRUvjQ);
    }

    /* renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m612singleAxisOffsetMKHz9U(long $this$singleAxisOffset_u2dMK_u2dHz9U) {
        return this.orientation == Orientation.Horizontal ? Offset.m3702copydBAh8RU$default($this$singleAxisOffset_u2dMK_u2dHz9U, 0.0f, 0.0f, 1, null) : Offset.m3702copydBAh8RU$default($this$singleAxisOffset_u2dMK_u2dHz9U, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m615toFloatk4lQ0M(long $this$toFloat_u2dk_u2d4lQ0M) {
        return this.orientation == Orientation.Horizontal ? Offset.m3708getXimpl($this$toFloat_u2dk_u2d4lQ0M) : Offset.m3709getYimpl($this$toFloat_u2dk_u2d4lQ0M);
    }

    /* renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m614toFloatTH1AsA0(long $this$toFloat_u2dTH1AsA0) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6532getXimpl($this$toFloat_u2dTH1AsA0) : Velocity.m6533getYimpl($this$toFloat_u2dTH1AsA0);
    }

    /* renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    public final long m613singleAxisVelocityAH228Gc(long $this$singleAxisVelocity_u2dAH228Gc) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6528copyOhffZ5M$default($this$singleAxisVelocity_u2dAH228Gc, 0.0f, 0.0f, 1, null) : Velocity.m6528copyOhffZ5M$default($this$singleAxisVelocity_u2dAH228Gc, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m617updateQWom1Mo(long $this$update_u2dQWom1Mo, float newValue) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6528copyOhffZ5M$default($this$update_u2dQWom1Mo, newValue, 0.0f, 2, null) : Velocity.m6528copyOhffZ5M$default($this$update_u2dQWom1Mo, 0.0f, newValue, 1, null);
    }

    public final float reverseIfNeeded(float $this$reverseIfNeeded) {
        return this.reverseDirection ? (-1) * $this$reverseIfNeeded : $this$reverseIfNeeded;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m611reverseIfNeededMKHz9U(long $this$reverseIfNeeded_u2dMK_u2dHz9U) {
        return this.reverseDirection ? Offset.m3715timestuRUvjQ($this$reverseIfNeeded_u2dMK_u2dHz9U, -1.0f) : $this$reverseIfNeeded_u2dMK_u2dHz9U;
    }

    /* renamed from: dispatchScroll-3eAAhYA, reason: not valid java name */
    public final long m607dispatchScroll3eAAhYA(final ScrollScope $this$dispatchScroll_u2d3eAAhYA, long initialAvailableDelta, final int source) {
        Function1 performScroll = new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$dispatchScroll$performScroll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Offset invoke(Offset offset) {
                return Offset.m3697boximpl(m618invokeMKHz9U(offset.getPackedValue()));
            }

            /* renamed from: invoke-MK-Hz9U, reason: not valid java name */
            public final long m618invokeMKHz9U(long delta) {
                long consumedByPreScroll = this.this$0.nestedScrollDispatcher.m4978dispatchPreScrollOzD1aCk(delta, source);
                long scrollAvailableAfterPreScroll = Offset.m3712minusMKHz9U(delta, consumedByPreScroll);
                float singleAxisDeltaForSelfScroll = this.this$0.m615toFloatk4lQ0M(this.this$0.m611reverseIfNeededMKHz9U(this.this$0.m612singleAxisOffsetMKHz9U(scrollAvailableAfterPreScroll)));
                long consumedBySelfScroll = this.this$0.m611reverseIfNeededMKHz9U(this.this$0.m616toOffsettuRUvjQ($this$dispatchScroll_u2d3eAAhYA.scrollBy(singleAxisDeltaForSelfScroll)));
                long deltaAvailableAfterScroll = Offset.m3712minusMKHz9U(scrollAvailableAfterPreScroll, consumedBySelfScroll);
                long consumedByPostScroll = this.this$0.nestedScrollDispatcher.m4976dispatchPostScrollDzOQY0M(consumedBySelfScroll, deltaAvailableAfterScroll, source);
                return Offset.m3713plusMKHz9U(Offset.m3713plusMKHz9U(consumedByPreScroll, consumedBySelfScroll), consumedByPostScroll);
            }
        };
        OverscrollEffect overscroll = this.overscrollEffect;
        if (NestedScrollSource.m4982equalsimpl0(source, NestedScrollSource.INSTANCE.m4990getWheelWNlRxjI())) {
            return performScroll.invoke(Offset.m3697boximpl(initialAvailableDelta)).getPackedValue();
        }
        if (overscroll != null && getShouldDispatchOverscroll()) {
            return overscroll.mo396applyToScrollRhakbz0(initialAvailableDelta, source, performScroll);
        }
        return performScroll.invoke(Offset.m3697boximpl(initialAvailableDelta)).getPackedValue();
    }

    private final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m610performRawScrollMKHz9U(long scroll) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.INSTANCE.m3724getZeroF1C5BW0();
        }
        return m616toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m615toFloatk4lQ0M(scroll)))));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* renamed from: onDragStopped-sF-c-tU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m609onDragStoppedsFctU(long r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            r0.<init>(r7, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            switch(r2) {
                case 0: goto L3c;
                case 1: goto L34;
                case 2: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2c:
            java.lang.Object r8 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r8 = (androidx.compose.foundation.gestures.ScrollingLogic) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L78
        L34:
            java.lang.Object r8 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r8 = (androidx.compose.foundation.gestures.ScrollingLogic) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L66
        L3c:
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r7
            r3 = 1
            r2.registerNestedFling(r3)
            long r8 = r2.m613singleAxisVelocityAH228Gc(r8)
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1 r4 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1
            r5 = 0
            r4.<init>(r2, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            androidx.compose.foundation.OverscrollEffect r5 = r2.overscrollEffect
            if (r5 == 0) goto L67
            boolean r6 = r2.getShouldDispatchOverscroll()
            if (r6 == 0) goto L67
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r5.mo395applyToFlingBMRW4eQ(r8, r4, r0)
            if (r8 != r1) goto L65
            return r1
        L65:
            r8 = r2
        L66:
            goto L79
        L67:
            androidx.compose.ui.unit.Velocity r3 = androidx.compose.p000ui.unit.Velocity.m6523boximpl(r8)
            r0.L$0 = r2
            r5 = 2
            r0.label = r5
            java.lang.Object r8 = r4.invoke(r3, r0)
            if (r8 != r1) goto L77
            return r1
        L77:
            r8 = r2
        L78:
        L79:
            r9 = 0
            r8.registerNestedFling(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m609onDragStoppedsFctU(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m608doFlingAnimationQWom1Mo(long r12, kotlin.coroutines.Continuation<? super androidx.compose.p000ui.unit.Velocity> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L14
            r0 = r14
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r11, r14)
        L19:
            r4 = r0
            java.lang.Object r14 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            switch(r1) {
                case 0: goto L35;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L2d:
            java.lang.Object r12 = r4.L$0
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            kotlin.ResultKt.throwOnFailure(r14)
            goto L5d
        L35:
            kotlin.ResultKt.throwOnFailure(r14)
            r6 = r11
            r8 = r12
            kotlin.jvm.internal.Ref$LongRef r7 = new kotlin.jvm.internal.Ref$LongRef
            r7.<init>()
            r7.element = r8
            androidx.compose.foundation.gestures.ScrollableState r1 = r6.scrollableState
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r5 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r10 = 0
            r5.<init>(r6, r7, r8, r10)
            r12 = r6
            r3 = r5
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4.L$0 = r7
            r13 = 1
            r4.label = r13
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r12 = androidx.compose.foundation.gestures.ScrollableState.scroll$default(r1, r2, r3, r4, r5, r6)
            if (r12 != r0) goto L5c
            return r0
        L5c:
            r12 = r7
        L5d:
            long r0 = r12.element
            androidx.compose.ui.unit.Velocity r13 = androidx.compose.p000ui.unit.Velocity.m6523boximpl(r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m608doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress() && !this.isNestedFlinging.getValue().booleanValue()) {
            OverscrollEffect overscrollEffect = this.overscrollEffect;
            if (!(overscrollEffect != null ? overscrollEffect.isInProgress() : false)) {
                return false;
            }
        }
        return true;
    }

    public final void registerNestedFling(boolean isFlinging) {
        this.isNestedFlinging.setValue(Boolean.valueOf(isFlinging));
    }

    public final void update(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean reverseDirection, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        this.scrollableState = scrollableState;
        this.orientation = orientation;
        this.overscrollEffect = overscrollEffect;
        this.reverseDirection = reverseDirection;
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
    }
}
