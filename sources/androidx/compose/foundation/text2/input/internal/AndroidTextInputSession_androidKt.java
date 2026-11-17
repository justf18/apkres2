package androidx.compose.foundation.text2.input.internal;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt;
import androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.p000ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.p000ui.platform.PlatformTextInputSession;
import androidx.compose.p000ui.text.TextRange;
import androidx.compose.p000ui.text.input.ImeAction;
import androidx.compose.p000ui.text.input.ImeOptions;
import androidx.compose.p000ui.text.input.KeyboardCapitalization;
import androidx.compose.p000ui.text.input.KeyboardType;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: AndroidTextInputSession.android.kt */
@Metadata(m164d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002\u001a \u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a8\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017H\u0080@¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u00020\u000b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005¨\u0006\u001e"}, m165d2 = {"TAG", "", "TIA_DEBUG", "", "getTIA_DEBUG$annotations", "()V", "hasFlag", "bits", "", "flag", "logDebug", "", "tag", "content", "Lkotlin/Function0;", "platformSpecificTextInputSession", "", "Landroidx/compose/ui/platform/PlatformTextInputSession;", "state", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onImeAction", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "(Landroidx/compose/ui/platform/PlatformTextInputSession;Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/input/ImeOptions;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "Landroid/view/inputmethod/EditorInfo;", "textFieldValue", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidTextInputSession_androidKt {
    private static final String TAG = "AndroidTextInputSession";
    public static final boolean TIA_DEBUG = false;

    /* compiled from: AndroidTextInputSession.android.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt", m180f = "AndroidTextInputSession.android.kt", m181i = {}, m182l = {50}, m183m = "platformSpecificTextInputSession", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1 */
    static final class C08431 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08431(Continuation<? super C08431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidTextInputSession_androidKt.platformSpecificTextInputSession(null, null, null, null, this);
        }
    }

    public static /* synthetic */ void getTIA_DEBUG$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object platformSpecificTextInputSession(androidx.compose.p000ui.platform.PlatformTextInputSession r10, androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r11, androidx.compose.p000ui.text.input.ImeOptions r12, kotlin.jvm.functions.Function1<? super androidx.compose.p000ui.text.input.ImeAction, kotlin.Unit> r13, kotlin.coroutines.Continuation<?> r14) {
        /*
            boolean r0 = r14 instanceof androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt.C08431
            if (r0 == 0) goto L14
            r0 = r14
            androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1 r0 = (androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt.C08431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1 r0 = new androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1
            r0.<init>(r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            switch(r2) {
                case 0: goto L30;
                case 1: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L2c:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L51
        L30:
            kotlin.ResultKt.throwOnFailure(r14)
            r4 = r10
            r7 = r12
            r5 = r11
            r8 = r13
            android.view.View r10 = r4.getView()
            androidx.compose.foundation.text2.input.internal.ComposeInputMethodManager r6 = androidx.compose.foundation.text2.input.internal.ComposeInputMethodManager_androidKt.ComposeInputMethodManager(r10)
            androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2 r3 = new androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2
            r9 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r10 = 1
            r0.label = r10
            java.lang.Object r10 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r3, r0)
            if (r10 != r1) goto L51
            return r1
        L51:
            kotlin.KotlinNothingValueException r10 = new kotlin.KotlinNothingValueException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt.platformSpecificTextInputSession(androidx.compose.ui.platform.PlatformTextInputSession, androidx.compose.foundation.text2.input.internal.TransformedTextFieldState, androidx.compose.ui.text.input.ImeOptions, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: AndroidTextInputSession.android.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2", m180f = "AndroidTextInputSession.android.kt", m181i = {}, m182l = {73}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2 */
    static final class C08442 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ ComposeInputMethodManager $composeImm;
        final /* synthetic */ ImeOptions $imeOptions;
        final /* synthetic */ Function1<ImeAction, Unit> $onImeAction;
        final /* synthetic */ TransformedTextFieldState $state;
        final /* synthetic */ PlatformTextInputSession $this_platformSpecificTextInputSession;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08442(PlatformTextInputSession platformTextInputSession, TransformedTextFieldState transformedTextFieldState, ComposeInputMethodManager composeInputMethodManager, ImeOptions imeOptions, Function1<? super ImeAction, Unit> function1, Continuation<? super C08442> continuation) {
            super(2, continuation);
            this.$this_platformSpecificTextInputSession = platformTextInputSession;
            this.$state = transformedTextFieldState;
            this.$composeImm = composeInputMethodManager;
            this.$imeOptions = imeOptions;
            this.$onImeAction = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08442 c08442 = new C08442(this.$this_platformSpecificTextInputSession, this.$state, this.$composeImm, this.$imeOptions, this.$onImeAction, continuation);
            c08442.L$0 = obj;
            return c08442;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            return ((C08442) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: AndroidTextInputSession.android.kt */
        @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(m179c = "androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$1", m180f = "AndroidTextInputSession.android.kt", m181i = {}, m182l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, m183m = "invokeSuspend", m184n = {}, m185s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ComposeInputMethodManager $composeImm;
            final /* synthetic */ ImeOptions $imeOptions;
            final /* synthetic */ TransformedTextFieldState $state;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TransformedTextFieldState transformedTextFieldState, ComposeInputMethodManager composeInputMethodManager, ImeOptions imeOptions, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$state = transformedTextFieldState;
                this.$composeImm = composeInputMethodManager;
                this.$imeOptions = imeOptions;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$state, this.$composeImm, this.$imeOptions, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        TransformedTextFieldState transformedTextFieldState = this.$state;
                        final ComposeInputMethodManager composeInputMethodManager = this.$composeImm;
                        final ImeOptions imeOptions = this.$imeOptions;
                        this.label = 1;
                        if (transformedTextFieldState.collectImeNotifications(new TextFieldState.NotifyImeListener() { // from class: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$1$$ExternalSyntheticLambda0
                            @Override // androidx.compose.foundation.text2.input.TextFieldState.NotifyImeListener
                            public final void onChange(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2) {
                                AndroidTextInputSession_androidKt.C08442.AnonymousClass1.invokeSuspend$lambda$0(composeInputMethodManager, imeOptions, textFieldCharSequence, textFieldCharSequence2);
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
                throw new KotlinNothingValueException();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invokeSuspend$lambda$0(ComposeInputMethodManager $composeImm, ImeOptions $imeOptions, TextFieldCharSequence old, TextFieldCharSequence textFieldCharSequence) {
                boolean needUpdateSelection = (TextRange.m5767equalsimpl0(old.getSelectionInChars(), textFieldCharSequence.getSelectionInChars()) && Intrinsics.areEqual(old.getCompositionInChars(), textFieldCharSequence.getCompositionInChars())) ? false : true;
                if (needUpdateSelection) {
                    int iM5772getMinimpl = TextRange.m5772getMinimpl(textFieldCharSequence.getSelectionInChars());
                    int iM5771getMaximpl = TextRange.m5771getMaximpl(textFieldCharSequence.getSelectionInChars());
                    TextRange compositionInChars = textFieldCharSequence.getCompositionInChars();
                    int iM5772getMinimpl2 = compositionInChars != null ? TextRange.m5772getMinimpl(compositionInChars.getPackedValue()) : -1;
                    TextRange compositionInChars2 = textFieldCharSequence.getCompositionInChars();
                    $composeImm.updateSelection(iM5772getMinimpl, iM5771getMaximpl, iM5772getMinimpl2, compositionInChars2 != null ? TextRange.m5771getMaximpl(compositionInChars2.getPackedValue()) : -1);
                }
                if (!old.contentEquals(textFieldCharSequence) && !KeyboardType.m5985equalsimpl0($imeOptions.getKeyboardType(), KeyboardType.INSTANCE.m6003getPasswordPjHm6EE())) {
                    $composeImm.restartInput();
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this.$state, this.$composeImm, this.$imeOptions, null), 1, null);
                    PlatformTextInputSession platformTextInputSession = this.$this_platformSpecificTextInputSession;
                    final TransformedTextFieldState transformedTextFieldState = this.$state;
                    final ImeOptions imeOptions = this.$imeOptions;
                    final ComposeInputMethodManager composeInputMethodManager = this.$composeImm;
                    final Function1<ImeAction, Unit> function1 = this.$onImeAction;
                    this.label = 1;
                    if (platformTextInputSession.startInputMethod(new PlatformTextInputMethodRequest() { // from class: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$$ExternalSyntheticLambda0
                        @Override // androidx.compose.p000ui.platform.PlatformTextInputMethodRequest
                        public final InputConnection createInputConnection(EditorInfo editorInfo) {
                            return AndroidTextInputSession_androidKt.C08442.invokeSuspend$lambda$0(transformedTextFieldState, imeOptions, composeInputMethodManager, function1, editorInfo);
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
            throw new KotlinNothingValueException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InputConnection invokeSuspend$lambda$0(final TransformedTextFieldState $state, ImeOptions $imeOptions, final ComposeInputMethodManager $composeImm, final Function1 $onImeAction, EditorInfo outAttrs) {
            AndroidTextInputSession_androidKt.logDebug$default(null, new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$2$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "createInputConnection(value=\"" + ((Object) $state.getText()) + "\")";
                }
            }, 1, null);
            TextInputSession textInputSession = new TextInputSession() { // from class: androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$2$textInputSession$1
                @Override // androidx.compose.foundation.text2.input.internal.TextInputSession
                public TextFieldCharSequence getText() {
                    return $state.getText();
                }

                @Override // androidx.compose.foundation.text2.input.internal.TextInputSession
                public void requestEdit(Function1<? super EditingBuffer, Unit> block) {
                    TransformedTextFieldState this_$iv = $state;
                    TextFieldState $this$iv$iv = this_$iv.textFieldState;
                    InputTransformation inputTransformation$iv$iv = this_$iv.inputTransformation;
                    TextFieldEditUndoBehavior undoBehavior$iv$iv = TextFieldEditUndoBehavior.MergeIfPossible;
                    TextFieldCharSequence previousValue$iv$iv = $this$iv$iv.getText();
                    $this$iv$iv.getMainBuffer().getChangeTracker().clearChanges();
                    block.invoke($this$iv$iv.getMainBuffer());
                    if ($this$iv$iv.getMainBuffer().getChangeTracker().getChangeCount() != 0 || !TextRange.m5767equalsimpl0(previousValue$iv$iv.getSelectionInChars(), $this$iv$iv.getMainBuffer().m1310getSelectiond9O1mEE()) || !Intrinsics.areEqual(previousValue$iv$iv.getCompositionInChars(), $this$iv$iv.getMainBuffer().m1309getCompositionMzsxiRA())) {
                        $this$iv$iv.commitEditAsUser(previousValue$iv$iv, inputTransformation$iv$iv, false, undoBehavior$iv$iv);
                    }
                }

                @Override // androidx.compose.foundation.text2.input.internal.TextInputSession
                public void sendKeyEvent(KeyEvent keyEvent) {
                    $composeImm.sendKeyEvent(keyEvent);
                }

                @Override // androidx.compose.foundation.text2.input.internal.TextInputSession
                /* renamed from: onImeAction-KlQnJC8, reason: not valid java name */
                public void mo1308onImeActionKlQnJC8(int imeAction) {
                    Function1<ImeAction, Unit> function1 = $onImeAction;
                    if (function1 != null) {
                        function1.invoke(ImeAction.m5935boximpl(imeAction));
                    }
                }
            };
            AndroidTextInputSession_androidKt.update(outAttrs, $state.getText(), $imeOptions);
            return new StatelessInputConnection(textInputSession);
        }
    }

    public static final void update(EditorInfo $this$update, TextFieldCharSequence textFieldValue, ImeOptions imeOptions) {
        int imeAction = imeOptions.getImeAction();
        int i = 3;
        int i2 = 6;
        if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5950getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i2 = 0;
            }
        } else if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5954getNoneeUduSuo())) {
            i2 = 1;
        } else if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5952getGoeUduSuo())) {
            i2 = 2;
        } else if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5953getNexteUduSuo())) {
            i2 = 5;
        } else if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5955getPreviouseUduSuo())) {
            i2 = 7;
        } else if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5956getSearcheUduSuo())) {
            i2 = 3;
        } else if (ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5957getSendeUduSuo())) {
            i2 = 4;
        } else if (!ImeAction.m5938equalsimpl0(imeAction, ImeAction.INSTANCE.m5951getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        $this$update.imeOptions = i2;
        int keyboardType = imeOptions.getKeyboardType();
        if (KeyboardType.m5985equalsimpl0(keyboardType, KeyboardType.INSTANCE.m6005getTextPjHm6EE())) {
            i = 1;
        } else if (KeyboardType.m5985equalsimpl0(keyboardType, KeyboardType.INSTANCE.m5998getAsciiPjHm6EE())) {
            $this$update.imeOptions |= Integer.MIN_VALUE;
            i = 1;
        } else if (KeyboardType.m5985equalsimpl0(keyboardType, KeyboardType.INSTANCE.m6001getNumberPjHm6EE())) {
            i = 2;
        } else if (!KeyboardType.m5985equalsimpl0(keyboardType, KeyboardType.INSTANCE.m6004getPhonePjHm6EE())) {
            if (KeyboardType.m5985equalsimpl0(keyboardType, KeyboardType.INSTANCE.m6006getUriPjHm6EE())) {
                i = 17;
            } else if (KeyboardType.m5985equalsimpl0(keyboardType, KeyboardType.INSTANCE.m6000getEmailPjHm6EE())) {
                i = 33;
            } else if (KeyboardType.m5985equalsimpl0(keyboardType, KeyboardType.INSTANCE.m6003getPasswordPjHm6EE())) {
                i = 129;
            } else if (KeyboardType.m5985equalsimpl0(keyboardType, KeyboardType.INSTANCE.m6002getNumberPasswordPjHm6EE())) {
                i = 18;
            } else if (KeyboardType.m5985equalsimpl0(keyboardType, KeyboardType.INSTANCE.m5999getDecimalPjHm6EE())) {
                i = 8194;
            } else {
                throw new IllegalStateException("Invalid Keyboard Type".toString());
            }
        }
        $this$update.inputType = i;
        if (!imeOptions.getSingleLine() && hasFlag($this$update.inputType, 1)) {
            $this$update.inputType |= 131072;
            if (ImeAction.m5938equalsimpl0(imeOptions.getImeAction(), ImeAction.INSTANCE.m5950getDefaulteUduSuo())) {
                $this$update.imeOptions |= BasicMeasure.EXACTLY;
            }
        }
        if (hasFlag($this$update.inputType, 1)) {
            int capitalization = imeOptions.getCapitalization();
            if (KeyboardCapitalization.m5970equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m5978getCharactersIUNYP9k())) {
                $this$update.inputType |= 4096;
            } else if (KeyboardCapitalization.m5970equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m5981getWordsIUNYP9k())) {
                $this$update.inputType |= 8192;
            } else if (KeyboardCapitalization.m5970equalsimpl0(capitalization, KeyboardCapitalization.INSTANCE.m5980getSentencesIUNYP9k())) {
                $this$update.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                $this$update.inputType |= 32768;
            }
        }
        $this$update.initialSelStart = TextRange.m5774getStartimpl(textFieldValue.getSelectionInChars());
        $this$update.initialSelEnd = TextRange.m5769getEndimpl(textFieldValue.getSelectionInChars());
        EditorInfoCompat.setInitialSurroundingText($this$update, textFieldValue);
        $this$update.imeOptions |= 33554432;
    }

    private static final boolean hasFlag(int bits, int flag) {
        return (bits & flag) == flag;
    }

    static /* synthetic */ void logDebug$default(String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = TAG;
        }
        logDebug(str, function0);
    }

    private static final void logDebug(String tag, Function0<String> function0) {
    }
}
