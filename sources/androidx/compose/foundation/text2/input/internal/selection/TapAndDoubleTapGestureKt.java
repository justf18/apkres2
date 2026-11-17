package androidx.compose.foundation.text2.input.internal.selection;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.p000ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p000ui.input.pointer.PointerInputChange;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: TapAndDoubleTapGesture.kt */
@Metadata(m164d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u0007\u001a*\u0010\b\u001a\u00020\u0006*\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0080@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m165d2 = {"awaitSecondDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndDoubleTap", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onTap", "Landroidx/compose/foundation/text2/input/internal/selection/TapOnPosition;", "onDoubleTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text2/input/internal/selection/TapOnPosition;Landroidx/compose/foundation/text2/input/internal/selection/TapOnPosition;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TapAndDoubleTapGestureKt {

    /* compiled from: TapAndDoubleTapGesture.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt", m180f = "TapAndDoubleTapGesture.kt", m181i = {0}, m182l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m183m = "consumeUntilUp", m184n = {"$this$consumeUntilUp"}, m185s = {"L$0"})
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$consumeUntilUp$1 */
    static final class C08801 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08801(Continuation<? super C08801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TapAndDoubleTapGestureKt.consumeUntilUp(null, this);
        }
    }

    public static /* synthetic */ Object detectTapAndDoubleTap$default(PointerInputScope pointerInputScope, TapOnPosition tapOnPosition, TapOnPosition tapOnPosition2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            tapOnPosition = null;
        }
        if ((i & 2) != 0) {
            tapOnPosition2 = null;
        }
        return detectTapAndDoubleTap(pointerInputScope, tapOnPosition, tapOnPosition2, continuation);
    }

    /* compiled from: TapAndDoubleTapGesture.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2", m180f = "TapAndDoubleTapGesture.kt", m181i = {}, m182l = {43}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2 */
    static final class C08812 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TapOnPosition $onDoubleTap;
        final /* synthetic */ TapOnPosition $onTap;
        final /* synthetic */ PointerInputScope $this_detectTapAndDoubleTap;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08812(PointerInputScope pointerInputScope, TapOnPosition tapOnPosition, TapOnPosition tapOnPosition2, Continuation<? super C08812> continuation) {
            super(2, continuation);
            this.$this_detectTapAndDoubleTap = pointerInputScope;
            this.$onTap = tapOnPosition;
            this.$onDoubleTap = tapOnPosition2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08812(this.$this_detectTapAndDoubleTap, this.$onTap, this.$onDoubleTap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08812) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: TapAndDoubleTapGesture.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1", m180f = "TapAndDoubleTapGesture.kt", m181i = {0, 1, 1, 2, 2, 3, 3, 4}, m182l = {44, 50, ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE, 64, 69, 77}, m183m = "invokeSuspend", m184n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "longPressTimeout", "$this$awaitEachGesture", "longPressTimeout", "$this$awaitEachGesture", "longPressTimeout", "$this$awaitEachGesture"}, m185s = {"L$0", "L$0", "J$0", "L$0", "J$0", "L$0", "J$0", "L$0"})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ TapOnPosition $onDoubleTap;
            final /* synthetic */ TapOnPosition $onTap;
            long J$0;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TapOnPosition tapOnPosition, TapOnPosition tapOnPosition2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$onTap = tapOnPosition;
                this.$onDoubleTap = tapOnPosition2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onTap, this.$onDoubleTap, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:27:0x00b0 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00b1  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x00d5 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x00dc  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x0138 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:62:0x013c  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    Method dump skipped, instructions count: 340
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt.C08812.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* compiled from: TapAndDoubleTapGesture.kt */
            @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$1", m180f = "TapAndDoubleTapGesture.kt", m181i = {}, m182l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m183m = "invokeSuspend", m184n = {}, m185s = {})
            /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$1, reason: invalid class name and collision with other inner class name */
            static final class C31741 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
                private /* synthetic */ Object L$0;
                int label;

                C31741(Continuation<? super C31741> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C31741 c31741 = new C31741(continuation);
                    c31741.L$0 = obj;
                    return c31741;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
                    return ((C31741) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            AwaitPointerEventScope $this$withTimeout = (AwaitPointerEventScope) this.L$0;
                            this.label = 1;
                            Object objWaitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default($this$withTimeout, null, this, 1, null);
                            return objWaitForUpOrCancellation$default == coroutine_suspended ? coroutine_suspended : objWaitForUpOrCancellation$default;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            return $result;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }

            /* compiled from: TapAndDoubleTapGesture.kt */
            @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$2", m180f = "TapAndDoubleTapGesture.kt", m181i = {}, m182l = {70}, m183m = "invokeSuspend", m184n = {}, m185s = {})
            /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$2, reason: invalid class name */
            static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ TapOnPosition $onDoubleTap;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(TapOnPosition tapOnPosition, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$onDoubleTap = tapOnPosition;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$onDoubleTap, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    AnonymousClass2 anonymousClass2;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            anonymousClass2 = this;
                            AwaitPointerEventScope $this$withTimeout = (AwaitPointerEventScope) anonymousClass2.L$0;
                            anonymousClass2.label = 1;
                            Object objWaitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default($this$withTimeout, null, anonymousClass2, 1, null);
                            if (objWaitForUpOrCancellation$default != coroutine_suspended) {
                                $result = objWaitForUpOrCancellation$default;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            ResultKt.throwOnFailure($result);
                            anonymousClass2 = this;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    PointerInputChange secondUp = (PointerInputChange) $result;
                    if (secondUp != null) {
                        secondUp.consume();
                        anonymousClass2.$onDoubleTap.mo1367onEventk4lQ0M(secondUp.getPosition());
                    }
                    return Unit.INSTANCE;
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(this.$this_detectTapAndDoubleTap, new AnonymousClass1(this.$onTap, this.$onDoubleTap, null), this) != coroutine_suspended) {
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

    public static final Object detectTapAndDoubleTap(PointerInputScope $this$detectTapAndDoubleTap, TapOnPosition onTap, TapOnPosition onDoubleTap, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C08812($this$detectTapAndDoubleTap, onTap, onDoubleTap, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* compiled from: TapAndDoubleTapGesture.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$awaitSecondDown$2", m180f = "TapAndDoubleTapGesture.kt", m181i = {0, 0}, m182l = {97}, m183m = "invokeSuspend", m184n = {"$this$withTimeoutOrNull", "minUptime"}, m185s = {"L$0", "J$0"})
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$awaitSecondDown$2 */
    static final class C08792 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
        final /* synthetic */ PointerInputChange $firstUp;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08792(PointerInputChange pointerInputChange, Continuation<? super C08792> continuation) {
            super(2, continuation);
            this.$firstUp = pointerInputChange;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08792 c08792 = new C08792(this.$firstUp, continuation);
            c08792.L$0 = obj;
            return c08792;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
            return ((C08792) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x004c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x005c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x004d -> B:12:0x0052). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                switch(r1) {
                    case 0: goto L20;
                    case 1: goto L11;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L11:
                r1 = r10
                long r2 = r1.J$0
                java.lang.Object r4 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.p000ui.input.pointer.AwaitPointerEventScope) r4
                kotlin.ResultKt.throwOnFailure(r11)
                r8 = r2
                r2 = r1
                r1 = r0
                r0 = r11
                goto L52
            L20:
                kotlin.ResultKt.throwOnFailure(r11)
                r1 = r10
                java.lang.Object r2 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.p000ui.input.pointer.AwaitPointerEventScope) r2
                androidx.compose.ui.input.pointer.PointerInputChange r3 = r1.$firstUp
                long r3 = r3.getUptimeMillis()
                androidx.compose.ui.platform.ViewConfiguration r5 = r2.getViewConfiguration()
                long r5 = r5.getDoubleTapMinTimeMillis()
                long r3 = r3 + r5
                r8 = r3
            L38:
                r5 = r1
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r1.L$0 = r2
                r1.J$0 = r8
                r3 = 1
                r1.label = r3
                r3 = 0
                r4 = 0
                r6 = 3
                r7 = 0
                java.lang.Object r3 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r2, r3, r4, r5, r6, r7)
                if (r3 != r0) goto L4d
                return r0
            L4d:
                r4 = r2
                r2 = r1
                r1 = r0
                r0 = r11
                r11 = r3
            L52:
                androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.p000ui.input.pointer.PointerInputChange) r11
                long r5 = r11.getUptimeMillis()
                int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r3 < 0) goto L5d
                return r11
            L5d:
                r11 = r0
                r0 = r1
                r1 = r2
                r2 = r4
                goto L38
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt.C08792.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope $this$awaitSecondDown, PointerInputChange firstUp, Continuation<? super PointerInputChange> continuation) {
        return $this$awaitSecondDown.withTimeoutOrNull($this$awaitSecondDown.getViewConfiguration().getDoubleTapTimeoutMillis(), new C08792(firstUp, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b A[LOOP:0: B:19:0x0059->B:20:0x005b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0047 -> B:18:0x004c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object consumeUntilUp(androidx.compose.p000ui.input.pointer.AwaitPointerEventScope r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            boolean r0 = r15 instanceof androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt.C08801
            if (r0 == 0) goto L14
            r0 = r15
            androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt.C08801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$consumeUntilUp$1
            r0.<init>(r15)
        L19:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            switch(r2) {
                case 0: goto L38;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L2d:
            java.lang.Object r14 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.p000ui.input.pointer.AwaitPointerEventScope) r14
            kotlin.ResultKt.throwOnFailure(r15)
            r2 = r1
            r1 = r0
            r0 = r15
            goto L4c
        L38:
            kotlin.ResultKt.throwOnFailure(r15)
        L3b:
            r0.L$0 = r14
            r0.label = r3
            r2 = 0
            java.lang.Object r2 = androidx.compose.p000ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r14, r2, r0, r3, r2)
            if (r2 != r1) goto L47
            return r1
        L47:
            r13 = r0
            r0 = r15
            r15 = r2
            r2 = r1
            r1 = r13
        L4c:
            androidx.compose.ui.input.pointer.PointerEvent r15 = (androidx.compose.p000ui.input.pointer.PointerEvent) r15
            java.util.List r4 = r15.getChanges()
            r5 = 0
            r6 = 0
            int r7 = r4.size()
        L59:
            if (r6 >= r7) goto L6a
            java.lang.Object r8 = r4.get(r6)
            r9 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.p000ui.input.pointer.PointerInputChange) r9
            r10 = 0
            r9.consume()
            int r6 = r6 + 1
            goto L59
        L6a:
            java.util.List r15 = r15.getChanges()
            r4 = 0
            r5 = 0
            r6 = 0
            int r7 = r15.size()
        L79:
            if (r6 >= r7) goto L91
            java.lang.Object r8 = r15.get(r6)
            r9 = r8
            r10 = 0
            r11 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.p000ui.input.pointer.PointerInputChange) r11
            r12 = 0
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L8d
            r15 = r3
            goto L93
        L8d:
            int r6 = r6 + 1
            goto L79
        L91:
            r15 = 0
        L93:
            if (r15 != 0) goto L98
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L98:
            r15 = r0
            r0 = r1
            r1 = r2
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt.consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
