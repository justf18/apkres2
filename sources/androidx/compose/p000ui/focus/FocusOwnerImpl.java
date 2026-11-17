package androidx.compose.p000ui.focus;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.input.key.KeyEventType;
import androidx.compose.p000ui.input.key.KeyEvent_androidKt;
import androidx.compose.p000ui.input.key.KeyInputModifierNode;
import androidx.compose.p000ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.p000ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.p000ui.input.rotary.RotaryScrollEvent;
import androidx.compose.p000ui.node.DelegatableNode;
import androidx.compose.p000ui.node.DelegatableNodeKt;
import androidx.compose.p000ui.node.DelegatingNode;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.ModifierNodeElement;
import androidx.compose.p000ui.node.NodeChain;
import androidx.compose.p000ui.node.NodeKind;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: FocusOwnerImpl.kt */
@Metadata(m164d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J\u001a\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001a\u0010(\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\b)\u0010'J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001a\u0010/\u001a\u00020!2\u0006\u00100\u001a\u000201H\u0016ø\u0001\u0000¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u000207H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u000208H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u001aH\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\u001a\u0010:\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010'J\u001a\u0010<\u001a\u00020!2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u00103J\u000e\u0010>\u001a\u0004\u0018\u00010?*\u00020@H\u0002JY\u0010A\u001a\u00020\u0005\"\n\b\u0000\u0010B\u0018\u0001*\u00020@*\u00020@2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HB0D2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bø\u0001\u0000¢\u0006\u0004\bG\u0010HR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006I"}, m165d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function1;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "getFocusTransactionManager", "()Landroidx/compose/ui/focus/FocusTransactionManager;", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "clearFocus", "force", "", "refreshFocusEvents", "dispatchInterceptedSoftKeyboardEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEvent", "dispatchKeyEvent-ZmokQxo", "dispatchRotaryEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "getFocusRect", "Landroidx/compose/ui/geometry/Rect;", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "wrapAroundFocus", "wrapAroundFocus-3ESFkO8", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "traverseAncestors", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "traverseAncestors-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;
    private final FocusInvalidationManager focusInvalidationManager;
    private MutableLongSet keysCurrentlyDown;
    public LayoutDirection layoutDirection;
    private FocusTargetNode rootFocusNode = new FocusTargetNode();
    private final FocusTransactionManager focusTransactionManager = new FocusTransactionManager();
    private final Modifier modifier = new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // androidx.compose.p000ui.node.ModifierNodeElement
        public FocusTargetNode create() {
            return this.this$0.getRootFocusNode();
        }

        @Override // androidx.compose.p000ui.node.ModifierNodeElement
        public void update(FocusTargetNode node) {
        }

        @Override // androidx.compose.p000ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
            $this$inspectableProperties.setName("RootFocusTarget");
        }

        @Override // androidx.compose.p000ui.node.ModifierNodeElement
        public int hashCode() {
            return this.this$0.getRootFocusNode().hashCode();
        }

        @Override // androidx.compose.p000ui.node.ModifierNodeElement
        public boolean equals(Object other) {
            return other == this;
        }
    };

    /* compiled from: FocusOwnerImpl.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> function1) {
        this.focusInvalidationManager = new FocusInvalidationManager(function1);
    }

    /* renamed from: getRootFocusNode$ui_release, reason: from getter */
    public final FocusTargetNode getRootFocusNode() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    @Override // androidx.compose.p000ui.focus.FocusOwner
    public FocusTransactionManager getFocusTransactionManager() {
        return this.focusTransactionManager;
    }

    @Override // androidx.compose.p000ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.p000ui.focus.FocusOwner
    public LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection = this.layoutDirection;
        if (layoutDirection != null) {
            return layoutDirection;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        return null;
    }

    @Override // androidx.compose.p000ui.focus.FocusOwner
    public void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection = layoutDirection;
    }

    @Override // androidx.compose.p000ui.focus.FocusOwner
    public void takeFocus() {
        if (this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.rootFocusNode.setFocusState(FocusStateImpl.Active);
        }
    }

    @Override // androidx.compose.p000ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.p000ui.focus.FocusManager
    public void clearFocus(boolean force) {
        clearFocus(force, true);
    }

    @Override // androidx.compose.p000ui.focus.FocusOwner
    public void clearFocus(boolean force, boolean refreshFocusEvents) {
        FocusStateImpl focusStateImpl;
        FocusTransactionManager $this$iv = getFocusTransactionManager();
        try {
            if ($this$iv.ongoingTransaction) {
                $this$iv.cancelTransaction();
            }
            $this$iv.beginTransaction();
            if (!force) {
                switch (WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m3656performCustomClearFocusMxy_nc0(this.rootFocusNode, FocusDirection.INSTANCE.m3636getExitdhqQ8s()).ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        return;
                }
            }
            FocusStateImpl rootInitialState = this.rootFocusNode.getFocusState();
            if (FocusTransactionsKt.clearFocus(this.rootFocusNode, force, refreshFocusEvents)) {
                FocusTargetNode focusTargetNode = this.rootFocusNode;
                switch (WhenMappings.$EnumSwitchMapping$1[rootInitialState.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        focusStateImpl = FocusStateImpl.Active;
                        break;
                    case 4:
                        focusStateImpl = FocusStateImpl.Inactive;
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                focusTargetNode.setFocusState(focusStateImpl);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            $this$iv.commitTransaction();
        }
    }

    @Override // androidx.compose.p000ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo3642moveFocus3ESFkO8(final int focusDirection) {
        final FocusTargetNode source = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (source == null) {
            return false;
        }
        FocusRequester it = FocusTraversalKt.m3660customFocusSearchOMvw8(source, focusDirection, getLayoutDirection());
        if (it != FocusRequester.INSTANCE.getDefault()) {
            return it != FocusRequester.INSTANCE.getCancel() && it.focus$ui_release();
        }
        final Ref.BooleanRef isCancelled = new Ref.BooleanRef();
        boolean foundNextItem = FocusTraversalKt.m3661focusSearchsMXa3k8(this.rootFocusNode, focusDirection, getLayoutDirection(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$foundNextItem$1

            /* compiled from: FocusOwnerImpl.kt */
            @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[CustomDestinationResult.values().length];
                    try {
                        iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    try {
                        iArr[CustomDestinationResult.None.ordinal()] = 4;
                    } catch (NoSuchFieldError e4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode destination) {
                Modifier.Node nodePop;
                boolean zPerformRequestFocus;
                DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
                int type$iv;
                int type$iv2;
                NodeChain nodes;
                DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
                int type$iv3;
                int type$iv4;
                DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
                int type$iv5;
                int count$iv$iv$iv;
                MutableVector mutableVector;
                int count$iv$iv$iv2 = 0;
                if (Intrinsics.areEqual(destination, source)) {
                    return false;
                }
                FocusTargetNode $this$nearestAncestor_u2d64DMado$iv4 = destination;
                int type$iv6 = NodeKind.m5425constructorimpl(1024);
                if (!$this$nearestAncestor_u2d64DMado$iv4.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                Modifier.Node node$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv4.getNode().getParent();
                LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$nearestAncestor_u2d64DMado$iv4);
                loop0: while (true) {
                    int i = 1;
                    if (layout$iv$iv$iv == null) {
                        nodePop = null;
                        break;
                    }
                    Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
                    if ((head$iv$iv$iv.getAggregateChildKindSet() & type$iv6) != 0) {
                        while (node$iv$iv$iv != null) {
                            if ((node$iv$iv$iv.getKindSet() & type$iv6) != 0) {
                                Modifier.Node it$iv$iv = node$iv$iv$iv;
                                MutableVector mutableVector2 = null;
                                nodePop = it$iv$iv;
                                while (nodePop != null) {
                                    if (nodePop instanceof FocusTargetNode) {
                                        break loop0;
                                    }
                                    Modifier.Node this_$iv$iv$iv$iv = nodePop;
                                    if (((this_$iv$iv$iv$iv.getKindSet() & type$iv6) != 0 ? i : 0) == 0 || !(nodePop instanceof DelegatingNode)) {
                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                        type$iv3 = type$iv6;
                                        type$iv4 = 0;
                                        nodePop = DelegatableNodeKt.pop(mutableVector2);
                                        count$iv$iv$iv2 = type$iv4;
                                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                        type$iv6 = type$iv3;
                                        i = 1;
                                    } else {
                                        int count$iv$iv$iv3 = 0;
                                        DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) nodePop;
                                        Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                        while (node$iv$iv$iv$iv != null) {
                                            Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                            if (((next$iv$iv$iv.getKindSet() & type$iv6) != 0 ? i : 0) != 0) {
                                                count$iv$iv$iv3++;
                                                if (count$iv$iv$iv3 == i) {
                                                    nodePop = next$iv$iv$iv;
                                                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                    type$iv5 = type$iv6;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                        count$iv$iv$iv = count$iv$iv$iv3;
                                                        type$iv5 = type$iv6;
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                        count$iv$iv$iv = count$iv$iv$iv3;
                                                        type$iv5 = type$iv6;
                                                        mutableVector = mutableVector2;
                                                    }
                                                    Modifier.Node theNode$iv$iv$iv = nodePop;
                                                    if (theNode$iv$iv$iv != null) {
                                                        if (mutableVector != null) {
                                                            mutableVector.add(theNode$iv$iv$iv);
                                                        }
                                                        nodePop = null;
                                                    }
                                                    if (mutableVector != null) {
                                                        mutableVector.add(next$iv$iv$iv);
                                                    }
                                                    mutableVector2 = mutableVector;
                                                    count$iv$iv$iv3 = count$iv$iv$iv;
                                                }
                                            } else {
                                                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                type$iv5 = type$iv6;
                                            }
                                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                                            type$iv6 = type$iv5;
                                            i = 1;
                                        }
                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                        type$iv3 = type$iv6;
                                        type$iv4 = 0;
                                        if (count$iv$iv$iv3 == 1) {
                                            count$iv$iv$iv2 = 0;
                                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                            type$iv6 = type$iv3;
                                            i = 1;
                                        } else {
                                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                                            count$iv$iv$iv2 = type$iv4;
                                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                            type$iv6 = type$iv3;
                                            i = 1;
                                        }
                                    }
                                }
                            }
                            node$iv$iv$iv = node$iv$iv$iv.getParent();
                            count$iv$iv$iv2 = count$iv$iv$iv2;
                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv4;
                            type$iv6 = type$iv6;
                            i = 1;
                        }
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                        type$iv = type$iv6;
                        type$iv2 = count$iv$iv$iv2;
                    } else {
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                        type$iv = type$iv6;
                        type$iv2 = count$iv$iv$iv2;
                    }
                    layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                    node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes = layout$iv$iv$iv.getNodes()) == null) ? null : nodes.getTail();
                    count$iv$iv$iv2 = type$iv2;
                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv;
                    type$iv6 = type$iv;
                }
                if (nodePop == null) {
                    throw new IllegalStateException("Focus search landed at the root.".toString());
                }
                FocusTransactionManager $this$iv = this.getFocusTransactionManager();
                int i2 = focusDirection;
                Ref.BooleanRef booleanRef = isCancelled;
                try {
                    if ($this$iv.ongoingTransaction) {
                        $this$iv.cancelTransaction();
                    }
                    $this$iv.beginTransaction();
                    switch (WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m3659performCustomRequestFocusMxy_nc0(destination, i2).ordinal()]) {
                        case 1:
                            zPerformRequestFocus = true;
                            break;
                        case 2:
                        case 3:
                            booleanRef.element = true;
                            zPerformRequestFocus = true;
                            break;
                        case 4:
                            zPerformRequestFocus = FocusTransactionsKt.performRequestFocus(destination);
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    return Boolean.valueOf(zPerformRequestFocus);
                } finally {
                    $this$iv.commitTransaction();
                }
            }
        });
        if (isCancelled.element) {
            return false;
        }
        return foundNextItem || m3647wrapAroundFocus3ESFkO8(focusDirection);
    }

    @Override // androidx.compose.p000ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-ZmokQxo */
    public boolean mo3644dispatchKeyEventZmokQxo(KeyEvent keyEvent) {
        int i;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        int i2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
        int i3;
        MutableVector mutableVector;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
        int i4;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
        int i5;
        MutableVector mutableVector2;
        DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv;
        int type$iv;
        NodeChain nodes;
        int type$iv2;
        int type$iv3;
        Modifier.Node node;
        int count$iv$iv$iv$iv;
        Modifier.Node node2;
        MutableVector mutableVector3;
        Modifier.Node node3;
        Modifier.Node node4;
        Object obj;
        FocusTargetNode activeFocusTarget;
        int i6;
        NodeChain nodes2;
        FocusTargetNode activeFocusTarget2;
        FocusTargetNode activeFocusTarget3;
        FocusTargetNode activeFocusTarget4;
        MutableVector mutableVector4;
        if (!m3646validateKeyEventZmokQxo(keyEvent)) {
            return false;
        }
        FocusTargetNode activeFocusTarget5 = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (activeFocusTarget5 == null) {
            throw new IllegalStateException("Event can't be processed because we do not have an active focus target.".toString());
        }
        Modifier.Node focusedKeyInputNode = lastLocalKeyInputNode(activeFocusTarget5);
        int i7 = 8192;
        int i8 = 1;
        if (focusedKeyInputNode == null) {
            FocusTargetNode $this$nearestAncestor_u2d64DMado$iv = activeFocusTarget5;
            int iM5425constructorimpl = NodeKind.m5425constructorimpl(8192);
            if (!$this$nearestAncestor_u2d64DMado$iv.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node node$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv.getNode().getParent();
            LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$nearestAncestor_u2d64DMado$iv);
            loop0: while (true) {
                if (layout$iv$iv$iv == null) {
                    i = i7;
                    obj = null;
                    break;
                }
                Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
                if ((head$iv$iv$iv.getAggregateChildKindSet() & iM5425constructorimpl) != 0) {
                    while (node$iv$iv$iv != null) {
                        if ((node$iv$iv$iv.getKindSet() & iM5425constructorimpl) != 0) {
                            Modifier.Node it$iv$iv = node$iv$iv$iv;
                            MutableVector mutableVector5 = null;
                            i = i7;
                            Modifier.Node nodePop = it$iv$iv;
                            while (nodePop != null) {
                                if (nodePop instanceof KeyInputModifierNode) {
                                    obj = nodePop;
                                    break loop0;
                                }
                                Modifier.Node this_$iv$iv$iv$iv = nodePop;
                                if (((this_$iv$iv$iv$iv.getKindSet() & iM5425constructorimpl) != 0 ? i8 : 0) == 0 || !(nodePop instanceof DelegatingNode)) {
                                    activeFocusTarget3 = activeFocusTarget5;
                                    nodePop = DelegatableNodeKt.pop(mutableVector5);
                                    activeFocusTarget5 = activeFocusTarget3;
                                    i8 = 1;
                                } else {
                                    int count$iv$iv$iv = 0;
                                    DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) nodePop;
                                    Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                        if (((next$iv$iv$iv.getKindSet() & iM5425constructorimpl) != 0 ? i8 : 0) != 0) {
                                            count$iv$iv$iv++;
                                            if (count$iv$iv$iv == i8) {
                                                nodePop = next$iv$iv$iv;
                                                activeFocusTarget4 = activeFocusTarget5;
                                            } else {
                                                if (mutableVector5 == null) {
                                                    activeFocusTarget4 = activeFocusTarget5;
                                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    activeFocusTarget4 = activeFocusTarget5;
                                                    mutableVector4 = mutableVector5;
                                                }
                                                Modifier.Node theNode$iv$iv$iv = nodePop;
                                                if (theNode$iv$iv$iv != null) {
                                                    if (mutableVector4 != null) {
                                                        mutableVector4.add(theNode$iv$iv$iv);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector4 != null) {
                                                    mutableVector4.add(next$iv$iv$iv);
                                                }
                                                mutableVector5 = mutableVector4;
                                            }
                                        } else {
                                            activeFocusTarget4 = activeFocusTarget5;
                                        }
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                        activeFocusTarget5 = activeFocusTarget4;
                                        i8 = 1;
                                    }
                                    activeFocusTarget3 = activeFocusTarget5;
                                    if (count$iv$iv$iv == 1) {
                                        activeFocusTarget5 = activeFocusTarget3;
                                        i8 = 1;
                                    } else {
                                        nodePop = DelegatableNodeKt.pop(mutableVector5);
                                        activeFocusTarget5 = activeFocusTarget3;
                                        i8 = 1;
                                    }
                                }
                            }
                            activeFocusTarget2 = activeFocusTarget5;
                        } else {
                            activeFocusTarget2 = activeFocusTarget5;
                            i = i7;
                        }
                        node$iv$iv$iv = node$iv$iv$iv.getParent();
                        i8 = 1;
                        i7 = i;
                        activeFocusTarget5 = activeFocusTarget2;
                    }
                    activeFocusTarget = activeFocusTarget5;
                    i6 = i7;
                } else {
                    activeFocusTarget = activeFocusTarget5;
                    i6 = i7;
                }
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes2 = layout$iv$iv$iv.getNodes()) == null) ? null : nodes2.getTail();
                i8 = 1;
                i7 = i6;
                activeFocusTarget5 = activeFocusTarget;
            }
            KeyInputModifierNode keyInputModifierNode = (KeyInputModifierNode) obj;
            focusedKeyInputNode = keyInputModifierNode != null ? keyInputModifierNode.getNode() : null;
        } else {
            i = 8192;
        }
        if (focusedKeyInputNode == null) {
            return false;
        }
        Modifier.Node $this$traverseAncestors_u2dY_u2dYKmho$iv2 = focusedKeyInputNode;
        int type$iv4 = NodeKind.m5425constructorimpl(i);
        List ancestors$iv = null;
        if (!$this$traverseAncestors_u2dY_u2dYKmho$iv2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node$iv$iv$iv$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv2.getNode().getParent();
        LayoutNode layout$iv$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$traverseAncestors_u2dY_u2dYKmho$iv2);
        while (layout$iv$iv$iv$iv != null) {
            Modifier.Node head$iv$iv$iv$iv = layout$iv$iv$iv$iv.getNodes().getHead();
            if ((head$iv$iv$iv$iv.getAggregateChildKindSet() & type$iv4) != 0) {
                while (node$iv$iv$iv$iv2 != null) {
                    if ((node$iv$iv$iv$iv2.getKindSet() & type$iv4) != 0) {
                        Modifier.Node it$iv$iv$iv = node$iv$iv$iv$iv2;
                        MutableVector mutableVector6 = null;
                        Modifier.Node nodePop2 = it$iv$iv$iv;
                        while (nodePop2 != null) {
                            DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv3 = $this$traverseAncestors_u2dY_u2dYKmho$iv2;
                            if (nodePop2 instanceof KeyInputModifierNode) {
                                Modifier.Node node5 = nodePop2;
                                if (ancestors$iv == null) {
                                    Object result$iv$iv = new ArrayList();
                                    ancestors$iv = (List) result$iv$iv;
                                }
                                ancestors$iv.add(node5);
                                type$iv2 = type$iv4;
                            } else {
                                Modifier.Node this_$iv$iv$iv$iv$iv = nodePop2;
                                if (((this_$iv$iv$iv$iv$iv.getKindSet() & type$iv4) != 0) && (nodePop2 instanceof DelegatingNode)) {
                                    int count$iv$iv$iv$iv2 = 0;
                                    DelegatingNode this_$iv$iv$iv$iv$iv2 = (DelegatingNode) nodePop2;
                                    Modifier.Node node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv$iv$iv = node$iv$iv$iv$iv$iv;
                                        if ((next$iv$iv$iv$iv.getKindSet() & type$iv4) != 0) {
                                            count$iv$iv$iv$iv2++;
                                            type$iv3 = type$iv4;
                                            if (count$iv$iv$iv$iv2 == 1) {
                                                node = next$iv$iv$iv$iv;
                                            } else {
                                                if (mutableVector6 == null) {
                                                    count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                                    node2 = nodePop2;
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                                    node2 = nodePop2;
                                                    mutableVector3 = mutableVector6;
                                                }
                                                Modifier.Node theNode$iv$iv$iv$iv = node2;
                                                if (theNode$iv$iv$iv$iv != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(theNode$iv$iv$iv$iv);
                                                    }
                                                    node3 = null;
                                                } else {
                                                    node3 = node2;
                                                }
                                                if (mutableVector3 != null) {
                                                    node4 = node3;
                                                    mutableVector3.add(next$iv$iv$iv$iv);
                                                } else {
                                                    node4 = node3;
                                                }
                                                node = node4;
                                                count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                                mutableVector6 = mutableVector3;
                                            }
                                        } else {
                                            type$iv3 = type$iv4;
                                            node = nodePop2;
                                        }
                                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild();
                                        type$iv4 = type$iv3;
                                        nodePop2 = node;
                                    }
                                    type$iv2 = type$iv4;
                                    Modifier.Node node6 = nodePop2;
                                    if (count$iv$iv$iv$iv2 == 1) {
                                        $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                                        type$iv4 = type$iv2;
                                        nodePop2 = node6;
                                    }
                                } else {
                                    type$iv2 = type$iv4;
                                }
                            }
                            nodePop2 = DelegatableNodeKt.pop(mutableVector6);
                            $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv3;
                            type$iv4 = type$iv2;
                        }
                    }
                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getParent();
                    $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv2;
                    type$iv4 = type$iv4;
                }
                $this$traverseAncestors_u2dY_u2dYKmho$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv2;
                type$iv = type$iv4;
            } else {
                $this$traverseAncestors_u2dY_u2dYKmho$iv = $this$traverseAncestors_u2dY_u2dYKmho$iv2;
                type$iv = type$iv4;
            }
            layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
            node$iv$iv$iv$iv2 = (layout$iv$iv$iv$iv == null || (nodes = layout$iv$iv$iv$iv.getNodes()) == null) ? null : nodes.getTail();
            $this$traverseAncestors_u2dY_u2dYKmho$iv2 = $this$traverseAncestors_u2dY_u2dYKmho$iv;
            type$iv4 = type$iv;
        }
        DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv4 = $this$traverseAncestors_u2dY_u2dYKmho$iv2;
        int type$iv5 = type$iv4;
        if (ancestors$iv != null) {
            List $this$fastForEachReversed$iv$iv = ancestors$iv;
            int size = $this$fastForEachReversed$iv$iv.size() - 1;
            if (size >= 0) {
                do {
                    int index$iv$iv = size;
                    size--;
                    Object item$iv$iv = $this$fastForEachReversed$iv$iv.get(index$iv$iv);
                    KeyInputModifierNode it = (KeyInputModifierNode) item$iv$iv;
                    if (it.mo385onPreKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                } while (size >= 0);
            }
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$traverseAncestors_u2dY_u2dYKmho$iv4.getNode();
        int i9 = 0;
        MutableVector mutableVector7 = null;
        Modifier.Node nodePop3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
        while (nodePop3 != null) {
            if (nodePop3 instanceof KeyInputModifierNode) {
                KeyInputModifierNode it2 = (KeyInputModifierNode) nodePop3;
                if (it2.mo385onPreKeyEventZmokQxo(keyEvent)) {
                    return true;
                }
                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                i4 = i9;
            } else {
                Modifier.Node this_$iv$iv$iv = nodePop3;
                if (((this_$iv$iv$iv.getKindSet() & type$iv5) != 0) && (nodePop3 instanceof DelegatingNode)) {
                    int count$iv$iv = 0;
                    DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) nodePop3;
                    Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv2.getDelegate();
                    while (node$iv$iv$iv2 != null) {
                        Modifier.Node next$iv$iv = node$iv$iv$iv2;
                        if ((next$iv$iv.getKindSet() & type$iv5) != 0) {
                            count$iv$iv++;
                            if (count$iv$iv == 1) {
                                nodePop3 = next$iv$iv;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                i5 = i9;
                            } else {
                                if (mutableVector7 == null) {
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                    i5 = i9;
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                    i5 = i9;
                                    mutableVector2 = mutableVector7;
                                }
                                mutableVector7 = mutableVector2;
                                Modifier.Node theNode$iv$iv = nodePop3;
                                if (theNode$iv$iv != null) {
                                    if (mutableVector7 != null) {
                                        mutableVector7.add(theNode$iv$iv);
                                    }
                                    nodePop3 = null;
                                }
                                if (mutableVector7 != null) {
                                    mutableVector7.add(next$iv$iv);
                                }
                            }
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                            i5 = i9;
                        }
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                        i9 = i5;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                    i4 = i9;
                    MutableVector mutableVector8 = mutableVector7;
                    if (count$iv$iv == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                        i9 = i4;
                        mutableVector7 = mutableVector8;
                    } else {
                        mutableVector7 = mutableVector8;
                    }
                } else {
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                    i4 = i9;
                }
            }
            nodePop3 = DelegatableNodeKt.pop(mutableVector7);
            $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
            i9 = i4;
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$traverseAncestors_u2dY_u2dYKmho$iv4.getNode();
        int i10 = 0;
        MutableVector mutableVector9 = null;
        Modifier.Node nodePop4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
        while (nodePop4 != null) {
            if (nodePop4 instanceof KeyInputModifierNode) {
                KeyInputModifierNode it3 = (KeyInputModifierNode) nodePop4;
                if (it3.mo383onKeyEventZmokQxo(keyEvent)) {
                    return true;
                }
                $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                i2 = i10;
            } else {
                Modifier.Node this_$iv$iv$iv3 = nodePop4;
                if (((this_$iv$iv$iv3.getKindSet() & type$iv5) != 0) && (nodePop4 instanceof DelegatingNode)) {
                    int count$iv$iv2 = 0;
                    DelegatingNode this_$iv$iv$iv4 = (DelegatingNode) nodePop4;
                    Modifier.Node node$iv$iv$iv3 = this_$iv$iv$iv4.getDelegate();
                    while (node$iv$iv$iv3 != null) {
                        Modifier.Node next$iv$iv2 = node$iv$iv$iv3;
                        if ((next$iv$iv2.getKindSet() & type$iv5) != 0) {
                            count$iv$iv2++;
                            if (count$iv$iv2 == 1) {
                                nodePop4 = next$iv$iv2;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                i3 = i10;
                            } else {
                                if (mutableVector9 == null) {
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                    i3 = i10;
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                    i3 = i10;
                                    mutableVector = mutableVector9;
                                }
                                mutableVector9 = mutableVector;
                                Modifier.Node theNode$iv$iv2 = nodePop4;
                                if (theNode$iv$iv2 != null) {
                                    if (mutableVector9 != null) {
                                        mutableVector9.add(theNode$iv$iv2);
                                    }
                                    nodePop4 = null;
                                }
                                if (mutableVector9 != null) {
                                    mutableVector9.add(next$iv$iv2);
                                }
                            }
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                            i3 = i10;
                        }
                        node$iv$iv$iv3 = node$iv$iv$iv3.getChild();
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                        i10 = i3;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                    i2 = i10;
                    MutableVector mutableVector10 = mutableVector9;
                    if (count$iv$iv2 == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                        i10 = i2;
                        mutableVector9 = mutableVector10;
                    } else {
                        mutableVector9 = mutableVector10;
                    }
                } else {
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                    i2 = i10;
                }
            }
            nodePop4 = DelegatableNodeKt.pop(mutableVector9);
            $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
            i10 = i2;
        }
        if (ancestors$iv == null) {
            return false;
        }
        List $this$fastForEach$iv$iv = ancestors$iv;
        int size2 = $this$fastForEach$iv$iv.size();
        for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
            Object item$iv$iv2 = $this$fastForEach$iv$iv.get(index$iv$iv2);
            KeyInputModifierNode it4 = (KeyInputModifierNode) item$iv$iv2;
            if (it4.mo383onKeyEventZmokQxo(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.Modifier$Node] */
    @Override // androidx.compose.p000ui.focus.FocusOwner
    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo3643dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        int i;
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode;
        Modifier.Node node;
        int i2;
        Modifier.Node node2;
        int i3;
        MutableVector mutableVector;
        Modifier.Node node3;
        int i4;
        Modifier.Node node4;
        int i5;
        MutableVector mutableVector2;
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode2;
        int i6;
        NodeChain nodes;
        int i7;
        Modifier.Node node5;
        int i8;
        Modifier.Node node6;
        int i9;
        MutableVector mutableVector3;
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode3;
        FocusTargetNode focusTargetNode;
        int i10;
        NodeChain nodes2;
        FocusTargetNode focusTargetNode2;
        FocusTargetNode focusTargetNode3;
        FocusTargetNode focusTargetNode4;
        MutableVector mutableVector4;
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        int i11 = 131072;
        int i12 = 1;
        if (focusTargetNodeFindActiveFocusNode != null) {
            FocusTargetNode focusTargetNode5 = focusTargetNodeFindActiveFocusNode;
            int iM5425constructorimpl = NodeKind.m5425constructorimpl(131072);
            if (!focusTargetNode5.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node parent = focusTargetNode5.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode5);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    i = i11;
                    softKeyboardInterceptionModifierNode3 = null;
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM5425constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM5425constructorimpl) != 0) {
                            MutableVector mutableVector5 = null;
                            i = i11;
                            Modifier.Node nodePop = parent;
                            while (nodePop != 0) {
                                if (nodePop instanceof SoftKeyboardInterceptionModifierNode) {
                                    softKeyboardInterceptionModifierNode3 = nodePop;
                                    break loop0;
                                }
                                if (((nodePop.getKindSet() & iM5425constructorimpl) != 0 ? i12 : 0) == 0 || !(nodePop instanceof DelegatingNode)) {
                                    focusTargetNode3 = focusTargetNode5;
                                    nodePop = DelegatableNodeKt.pop(mutableVector5);
                                    focusTargetNode5 = focusTargetNode3;
                                    i12 = 1;
                                } else {
                                    int i13 = 0;
                                    Modifier.Node delegate = nodePop.getDelegate();
                                    nodePop = nodePop;
                                    while (delegate != null) {
                                        Modifier.Node node7 = delegate;
                                        if (((node7.getKindSet() & iM5425constructorimpl) != 0 ? i12 : 0) != 0) {
                                            i13++;
                                            if (i13 == i12) {
                                                nodePop = node7;
                                                focusTargetNode4 = focusTargetNode5;
                                            } else {
                                                if (mutableVector5 == null) {
                                                    focusTargetNode4 = focusTargetNode5;
                                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    focusTargetNode4 = focusTargetNode5;
                                                    mutableVector4 = mutableVector5;
                                                }
                                                Object obj = nodePop;
                                                nodePop = nodePop;
                                                if (obj != null) {
                                                    if (mutableVector4 != null) {
                                                        mutableVector4.add(obj);
                                                    }
                                                    nodePop = 0;
                                                }
                                                if (mutableVector4 != null) {
                                                    mutableVector4.add(node7);
                                                }
                                                mutableVector5 = mutableVector4;
                                            }
                                        } else {
                                            focusTargetNode4 = focusTargetNode5;
                                        }
                                        delegate = delegate.getChild();
                                        focusTargetNode5 = focusTargetNode4;
                                        i12 = 1;
                                        nodePop = nodePop;
                                    }
                                    focusTargetNode3 = focusTargetNode5;
                                    if (i13 == 1) {
                                        focusTargetNode5 = focusTargetNode3;
                                        i12 = 1;
                                    } else {
                                        nodePop = DelegatableNodeKt.pop(mutableVector5);
                                        focusTargetNode5 = focusTargetNode3;
                                        i12 = 1;
                                    }
                                }
                            }
                            focusTargetNode2 = focusTargetNode5;
                        } else {
                            focusTargetNode2 = focusTargetNode5;
                            i = i11;
                        }
                        parent = parent.getParent();
                        i12 = 1;
                        i11 = i;
                        focusTargetNode5 = focusTargetNode2;
                    }
                    focusTargetNode = focusTargetNode5;
                    i10 = i11;
                } else {
                    focusTargetNode = focusTargetNode5;
                    i10 = i11;
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                parent = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
                i12 = 1;
                i11 = i10;
                focusTargetNode5 = focusTargetNode;
            }
            softKeyboardInterceptionModifierNode = softKeyboardInterceptionModifierNode3;
        } else {
            i = 131072;
            softKeyboardInterceptionModifierNode = null;
        }
        if (softKeyboardInterceptionModifierNode == null) {
            return false;
        }
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode4 = softKeyboardInterceptionModifierNode;
        int iM5425constructorimpl2 = NodeKind.m5425constructorimpl(i);
        ArrayList arrayList = null;
        if (!softKeyboardInterceptionModifierNode4.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent2 = softKeyboardInterceptionModifierNode4.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(softKeyboardInterceptionModifierNode4);
        while (layoutNodeRequireLayoutNode2 != null) {
            if ((layoutNodeRequireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & iM5425constructorimpl2) != 0) {
                while (parent2 != null) {
                    if ((parent2.getKindSet() & iM5425constructorimpl2) != 0) {
                        MutableVector mutableVector6 = null;
                        Modifier.Node nodePop2 = parent2;
                        while (nodePop2 != null) {
                            SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode5 = softKeyboardInterceptionModifierNode4;
                            if (nodePop2 instanceof SoftKeyboardInterceptionModifierNode) {
                                Modifier.Node node8 = nodePop2;
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(node8);
                                i7 = iM5425constructorimpl2;
                                node5 = parent2;
                            } else if (((nodePop2.getKindSet() & iM5425constructorimpl2) != 0) && (nodePop2 instanceof DelegatingNode)) {
                                int i14 = 0;
                                Modifier.Node delegate2 = ((DelegatingNode) nodePop2).getDelegate();
                                while (delegate2 != null) {
                                    Modifier.Node node9 = delegate2;
                                    if ((node9.getKindSet() & iM5425constructorimpl2) != 0) {
                                        i14++;
                                        i8 = iM5425constructorimpl2;
                                        if (i14 == 1) {
                                            nodePop2 = node9;
                                            node6 = parent2;
                                        } else {
                                            if (mutableVector6 == null) {
                                                i9 = i14;
                                                node6 = parent2;
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                i9 = i14;
                                                node6 = parent2;
                                                mutableVector3 = mutableVector6;
                                            }
                                            Modifier.Node node10 = nodePop2;
                                            if (node10 != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node10);
                                                }
                                                nodePop2 = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(node9);
                                            }
                                            mutableVector6 = mutableVector3;
                                            i14 = i9;
                                        }
                                    } else {
                                        i8 = iM5425constructorimpl2;
                                        node6 = parent2;
                                    }
                                    delegate2 = delegate2.getChild();
                                    iM5425constructorimpl2 = i8;
                                    parent2 = node6;
                                }
                                i7 = iM5425constructorimpl2;
                                node5 = parent2;
                                if (i14 == 1) {
                                    softKeyboardInterceptionModifierNode4 = softKeyboardInterceptionModifierNode5;
                                    iM5425constructorimpl2 = i7;
                                    parent2 = node5;
                                }
                            } else {
                                i7 = iM5425constructorimpl2;
                                node5 = parent2;
                            }
                            nodePop2 = DelegatableNodeKt.pop(mutableVector6);
                            softKeyboardInterceptionModifierNode4 = softKeyboardInterceptionModifierNode5;
                            iM5425constructorimpl2 = i7;
                            parent2 = node5;
                        }
                    }
                    parent2 = parent2.getParent();
                    softKeyboardInterceptionModifierNode4 = softKeyboardInterceptionModifierNode4;
                    iM5425constructorimpl2 = iM5425constructorimpl2;
                }
                softKeyboardInterceptionModifierNode2 = softKeyboardInterceptionModifierNode4;
                i6 = iM5425constructorimpl2;
            } else {
                softKeyboardInterceptionModifierNode2 = softKeyboardInterceptionModifierNode4;
                i6 = iM5425constructorimpl2;
            }
            layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
            parent2 = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            softKeyboardInterceptionModifierNode4 = softKeyboardInterceptionModifierNode2;
            iM5425constructorimpl2 = i6;
        }
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode6 = softKeyboardInterceptionModifierNode4;
        int i15 = iM5425constructorimpl2;
        if (arrayList != null) {
            List list = arrayList;
            int size = list.size() - 1;
            if (size >= 0) {
                do {
                    int i16 = size;
                    size--;
                    if (((SoftKeyboardInterceptionModifierNode) list.get(i16)).mo4645onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } while (size >= 0);
            }
        }
        Modifier.Node node11 = softKeyboardInterceptionModifierNode6.getNode();
        int i17 = 0;
        MutableVector mutableVector7 = null;
        Modifier.Node nodePop3 = node11;
        while (nodePop3 != null) {
            if (nodePop3 instanceof SoftKeyboardInterceptionModifierNode) {
                if (((SoftKeyboardInterceptionModifierNode) nodePop3).mo4645onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                    return true;
                }
                node3 = node11;
                i4 = i17;
            } else if (((nodePop3.getKindSet() & i15) != 0) && (nodePop3 instanceof DelegatingNode)) {
                int i18 = 0;
                Modifier.Node delegate3 = ((DelegatingNode) nodePop3).getDelegate();
                while (delegate3 != null) {
                    Modifier.Node node12 = delegate3;
                    if ((node12.getKindSet() & i15) != 0) {
                        i18++;
                        if (i18 == 1) {
                            nodePop3 = node12;
                            node4 = node11;
                            i5 = i17;
                        } else {
                            if (mutableVector7 == null) {
                                node4 = node11;
                                i5 = i17;
                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                            } else {
                                node4 = node11;
                                i5 = i17;
                                mutableVector2 = mutableVector7;
                            }
                            mutableVector7 = mutableVector2;
                            Modifier.Node node13 = nodePop3;
                            if (node13 != null) {
                                if (mutableVector7 != null) {
                                    mutableVector7.add(node13);
                                }
                                nodePop3 = null;
                            }
                            if (mutableVector7 != null) {
                                mutableVector7.add(node12);
                            }
                        }
                    } else {
                        node4 = node11;
                        i5 = i17;
                    }
                    delegate3 = delegate3.getChild();
                    node11 = node4;
                    i17 = i5;
                }
                node3 = node11;
                i4 = i17;
                MutableVector mutableVector8 = mutableVector7;
                if (i18 == 1) {
                    node11 = node3;
                    i17 = i4;
                    mutableVector7 = mutableVector8;
                } else {
                    mutableVector7 = mutableVector8;
                }
            } else {
                node3 = node11;
                i4 = i17;
            }
            nodePop3 = DelegatableNodeKt.pop(mutableVector7);
            node11 = node3;
            i17 = i4;
        }
        Modifier.Node node14 = softKeyboardInterceptionModifierNode6.getNode();
        int i19 = 0;
        MutableVector mutableVector9 = null;
        Modifier.Node nodePop4 = node14;
        while (nodePop4 != null) {
            if (nodePop4 instanceof SoftKeyboardInterceptionModifierNode) {
                if (((SoftKeyboardInterceptionModifierNode) nodePop4).mo4644onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                    return true;
                }
                node = node14;
                i2 = i19;
            } else if (((nodePop4.getKindSet() & i15) != 0) && (nodePop4 instanceof DelegatingNode)) {
                int i20 = 0;
                Modifier.Node delegate4 = ((DelegatingNode) nodePop4).getDelegate();
                while (delegate4 != null) {
                    Modifier.Node node15 = delegate4;
                    if ((node15.getKindSet() & i15) != 0) {
                        i20++;
                        if (i20 == 1) {
                            nodePop4 = node15;
                            node2 = node14;
                            i3 = i19;
                        } else {
                            if (mutableVector9 == null) {
                                node2 = node14;
                                i3 = i19;
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            } else {
                                node2 = node14;
                                i3 = i19;
                                mutableVector = mutableVector9;
                            }
                            mutableVector9 = mutableVector;
                            Modifier.Node node16 = nodePop4;
                            if (node16 != null) {
                                if (mutableVector9 != null) {
                                    mutableVector9.add(node16);
                                }
                                nodePop4 = null;
                            }
                            if (mutableVector9 != null) {
                                mutableVector9.add(node15);
                            }
                        }
                    } else {
                        node2 = node14;
                        i3 = i19;
                    }
                    delegate4 = delegate4.getChild();
                    node14 = node2;
                    i19 = i3;
                }
                node = node14;
                i2 = i19;
                MutableVector mutableVector10 = mutableVector9;
                if (i20 == 1) {
                    node14 = node;
                    i19 = i2;
                    mutableVector9 = mutableVector10;
                } else {
                    mutableVector9 = mutableVector10;
                }
            } else {
                node = node14;
                i2 = i19;
            }
            nodePop4 = DelegatableNodeKt.pop(mutableVector9);
            node14 = node;
            i19 = i2;
        }
        if (arrayList == null) {
            return false;
        }
        List list2 = arrayList;
        int size2 = list2.size();
        for (int i21 = 0; i21 < size2; i21++) {
            if (((SoftKeyboardInterceptionModifierNode) list2.get(i21)).mo4644onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.Modifier$Node] */
    @Override // androidx.compose.p000ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent event) {
        int i;
        RotaryInputModifierNode rotaryInputModifierNode;
        Modifier.Node node;
        int i2;
        Modifier.Node node2;
        int i3;
        MutableVector mutableVector;
        Modifier.Node node3;
        int i4;
        Modifier.Node node4;
        int i5;
        MutableVector mutableVector2;
        RotaryInputModifierNode rotaryInputModifierNode2;
        int i6;
        NodeChain nodes;
        int i7;
        Modifier.Node node5;
        int i8;
        Modifier.Node node6;
        int i9;
        MutableVector mutableVector3;
        RotaryInputModifierNode rotaryInputModifierNode3;
        FocusTargetNode focusTargetNode;
        int i10;
        NodeChain nodes2;
        FocusTargetNode focusTargetNode2;
        FocusTargetNode focusTargetNode3;
        FocusTargetNode focusTargetNode4;
        MutableVector mutableVector4;
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        int i11 = 16384;
        int i12 = 1;
        if (focusTargetNodeFindActiveFocusNode != null) {
            FocusTargetNode focusTargetNode5 = focusTargetNodeFindActiveFocusNode;
            int iM5425constructorimpl = NodeKind.m5425constructorimpl(16384);
            if (!focusTargetNode5.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node parent = focusTargetNode5.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode5);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    i = i11;
                    rotaryInputModifierNode3 = null;
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM5425constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM5425constructorimpl) != 0) {
                            MutableVector mutableVector5 = null;
                            i = i11;
                            Modifier.Node nodePop = parent;
                            while (nodePop != 0) {
                                if (nodePop instanceof RotaryInputModifierNode) {
                                    rotaryInputModifierNode3 = nodePop;
                                    break loop0;
                                }
                                if (((nodePop.getKindSet() & iM5425constructorimpl) != 0 ? i12 : 0) == 0 || !(nodePop instanceof DelegatingNode)) {
                                    focusTargetNode3 = focusTargetNode5;
                                    nodePop = DelegatableNodeKt.pop(mutableVector5);
                                    focusTargetNode5 = focusTargetNode3;
                                    i12 = 1;
                                } else {
                                    int i13 = 0;
                                    Modifier.Node delegate = nodePop.getDelegate();
                                    nodePop = nodePop;
                                    while (delegate != null) {
                                        Modifier.Node node7 = delegate;
                                        if (((node7.getKindSet() & iM5425constructorimpl) != 0 ? i12 : 0) != 0) {
                                            i13++;
                                            if (i13 == i12) {
                                                nodePop = node7;
                                                focusTargetNode4 = focusTargetNode5;
                                            } else {
                                                if (mutableVector5 == null) {
                                                    focusTargetNode4 = focusTargetNode5;
                                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    focusTargetNode4 = focusTargetNode5;
                                                    mutableVector4 = mutableVector5;
                                                }
                                                Object obj = nodePop;
                                                nodePop = nodePop;
                                                if (obj != null) {
                                                    if (mutableVector4 != null) {
                                                        mutableVector4.add(obj);
                                                    }
                                                    nodePop = 0;
                                                }
                                                if (mutableVector4 != null) {
                                                    mutableVector4.add(node7);
                                                }
                                                mutableVector5 = mutableVector4;
                                            }
                                        } else {
                                            focusTargetNode4 = focusTargetNode5;
                                        }
                                        delegate = delegate.getChild();
                                        focusTargetNode5 = focusTargetNode4;
                                        i12 = 1;
                                        nodePop = nodePop;
                                    }
                                    focusTargetNode3 = focusTargetNode5;
                                    if (i13 == 1) {
                                        focusTargetNode5 = focusTargetNode3;
                                        i12 = 1;
                                    } else {
                                        nodePop = DelegatableNodeKt.pop(mutableVector5);
                                        focusTargetNode5 = focusTargetNode3;
                                        i12 = 1;
                                    }
                                }
                            }
                            focusTargetNode2 = focusTargetNode5;
                        } else {
                            focusTargetNode2 = focusTargetNode5;
                            i = i11;
                        }
                        parent = parent.getParent();
                        i12 = 1;
                        i11 = i;
                        focusTargetNode5 = focusTargetNode2;
                    }
                    focusTargetNode = focusTargetNode5;
                    i10 = i11;
                } else {
                    focusTargetNode = focusTargetNode5;
                    i10 = i11;
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                parent = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
                i12 = 1;
                i11 = i10;
                focusTargetNode5 = focusTargetNode;
            }
            rotaryInputModifierNode = rotaryInputModifierNode3;
        } else {
            i = 16384;
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode == null) {
            return false;
        }
        RotaryInputModifierNode rotaryInputModifierNode4 = rotaryInputModifierNode;
        int iM5425constructorimpl2 = NodeKind.m5425constructorimpl(i);
        ArrayList arrayList = null;
        if (!rotaryInputModifierNode4.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent2 = rotaryInputModifierNode4.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(rotaryInputModifierNode4);
        while (layoutNodeRequireLayoutNode2 != null) {
            if ((layoutNodeRequireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & iM5425constructorimpl2) != 0) {
                while (parent2 != null) {
                    if ((parent2.getKindSet() & iM5425constructorimpl2) != 0) {
                        MutableVector mutableVector6 = null;
                        Modifier.Node nodePop2 = parent2;
                        while (nodePop2 != null) {
                            RotaryInputModifierNode rotaryInputModifierNode5 = rotaryInputModifierNode4;
                            if (nodePop2 instanceof RotaryInputModifierNode) {
                                Modifier.Node node8 = nodePop2;
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(node8);
                                i7 = iM5425constructorimpl2;
                                node5 = parent2;
                            } else if (((nodePop2.getKindSet() & iM5425constructorimpl2) != 0) && (nodePop2 instanceof DelegatingNode)) {
                                int i14 = 0;
                                Modifier.Node delegate2 = ((DelegatingNode) nodePop2).getDelegate();
                                while (delegate2 != null) {
                                    Modifier.Node node9 = delegate2;
                                    if ((node9.getKindSet() & iM5425constructorimpl2) != 0) {
                                        i14++;
                                        i8 = iM5425constructorimpl2;
                                        if (i14 == 1) {
                                            nodePop2 = node9;
                                            node6 = parent2;
                                        } else {
                                            if (mutableVector6 == null) {
                                                i9 = i14;
                                                node6 = parent2;
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                i9 = i14;
                                                node6 = parent2;
                                                mutableVector3 = mutableVector6;
                                            }
                                            Modifier.Node node10 = nodePop2;
                                            if (node10 != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node10);
                                                }
                                                nodePop2 = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(node9);
                                            }
                                            mutableVector6 = mutableVector3;
                                            i14 = i9;
                                        }
                                    } else {
                                        i8 = iM5425constructorimpl2;
                                        node6 = parent2;
                                    }
                                    delegate2 = delegate2.getChild();
                                    iM5425constructorimpl2 = i8;
                                    parent2 = node6;
                                }
                                i7 = iM5425constructorimpl2;
                                node5 = parent2;
                                if (i14 == 1) {
                                    rotaryInputModifierNode4 = rotaryInputModifierNode5;
                                    iM5425constructorimpl2 = i7;
                                    parent2 = node5;
                                }
                            } else {
                                i7 = iM5425constructorimpl2;
                                node5 = parent2;
                            }
                            nodePop2 = DelegatableNodeKt.pop(mutableVector6);
                            rotaryInputModifierNode4 = rotaryInputModifierNode5;
                            iM5425constructorimpl2 = i7;
                            parent2 = node5;
                        }
                    }
                    parent2 = parent2.getParent();
                    rotaryInputModifierNode4 = rotaryInputModifierNode4;
                    iM5425constructorimpl2 = iM5425constructorimpl2;
                }
                rotaryInputModifierNode2 = rotaryInputModifierNode4;
                i6 = iM5425constructorimpl2;
            } else {
                rotaryInputModifierNode2 = rotaryInputModifierNode4;
                i6 = iM5425constructorimpl2;
            }
            layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
            parent2 = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            rotaryInputModifierNode4 = rotaryInputModifierNode2;
            iM5425constructorimpl2 = i6;
        }
        RotaryInputModifierNode rotaryInputModifierNode6 = rotaryInputModifierNode4;
        int i15 = iM5425constructorimpl2;
        if (arrayList != null) {
            List list = arrayList;
            int size = list.size() - 1;
            if (size >= 0) {
                do {
                    int i16 = size;
                    size--;
                    if (((RotaryInputModifierNode) list.get(i16)).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                } while (size >= 0);
            }
        }
        Modifier.Node node11 = rotaryInputModifierNode6.getNode();
        int i17 = 0;
        MutableVector mutableVector7 = null;
        Modifier.Node nodePop3 = node11;
        while (nodePop3 != null) {
            if (nodePop3 instanceof RotaryInputModifierNode) {
                if (((RotaryInputModifierNode) nodePop3).onPreRotaryScrollEvent(event)) {
                    return true;
                }
                node3 = node11;
                i4 = i17;
            } else if (((nodePop3.getKindSet() & i15) != 0) && (nodePop3 instanceof DelegatingNode)) {
                int i18 = 0;
                Modifier.Node delegate3 = ((DelegatingNode) nodePop3).getDelegate();
                while (delegate3 != null) {
                    Modifier.Node node12 = delegate3;
                    if ((node12.getKindSet() & i15) != 0) {
                        i18++;
                        if (i18 == 1) {
                            nodePop3 = node12;
                            node4 = node11;
                            i5 = i17;
                        } else {
                            if (mutableVector7 == null) {
                                node4 = node11;
                                i5 = i17;
                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                            } else {
                                node4 = node11;
                                i5 = i17;
                                mutableVector2 = mutableVector7;
                            }
                            mutableVector7 = mutableVector2;
                            Modifier.Node node13 = nodePop3;
                            if (node13 != null) {
                                if (mutableVector7 != null) {
                                    mutableVector7.add(node13);
                                }
                                nodePop3 = null;
                            }
                            if (mutableVector7 != null) {
                                mutableVector7.add(node12);
                            }
                        }
                    } else {
                        node4 = node11;
                        i5 = i17;
                    }
                    delegate3 = delegate3.getChild();
                    node11 = node4;
                    i17 = i5;
                }
                node3 = node11;
                i4 = i17;
                MutableVector mutableVector8 = mutableVector7;
                if (i18 == 1) {
                    node11 = node3;
                    i17 = i4;
                    mutableVector7 = mutableVector8;
                } else {
                    mutableVector7 = mutableVector8;
                }
            } else {
                node3 = node11;
                i4 = i17;
            }
            nodePop3 = DelegatableNodeKt.pop(mutableVector7);
            node11 = node3;
            i17 = i4;
        }
        Modifier.Node node14 = rotaryInputModifierNode6.getNode();
        int i19 = 0;
        MutableVector mutableVector9 = null;
        Modifier.Node nodePop4 = node14;
        while (nodePop4 != null) {
            if (nodePop4 instanceof RotaryInputModifierNode) {
                if (((RotaryInputModifierNode) nodePop4).onRotaryScrollEvent(event)) {
                    return true;
                }
                node = node14;
                i2 = i19;
            } else if (((nodePop4.getKindSet() & i15) != 0) && (nodePop4 instanceof DelegatingNode)) {
                int i20 = 0;
                Modifier.Node delegate4 = ((DelegatingNode) nodePop4).getDelegate();
                while (delegate4 != null) {
                    Modifier.Node node15 = delegate4;
                    if ((node15.getKindSet() & i15) != 0) {
                        i20++;
                        if (i20 == 1) {
                            nodePop4 = node15;
                            node2 = node14;
                            i3 = i19;
                        } else {
                            if (mutableVector9 == null) {
                                node2 = node14;
                                i3 = i19;
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            } else {
                                node2 = node14;
                                i3 = i19;
                                mutableVector = mutableVector9;
                            }
                            mutableVector9 = mutableVector;
                            Modifier.Node node16 = nodePop4;
                            if (node16 != null) {
                                if (mutableVector9 != null) {
                                    mutableVector9.add(node16);
                                }
                                nodePop4 = null;
                            }
                            if (mutableVector9 != null) {
                                mutableVector9.add(node15);
                            }
                        }
                    } else {
                        node2 = node14;
                        i3 = i19;
                    }
                    delegate4 = delegate4.getChild();
                    node14 = node2;
                    i19 = i3;
                }
                node = node14;
                i2 = i19;
                MutableVector mutableVector10 = mutableVector9;
                if (i20 == 1) {
                    node14 = node;
                    i19 = i2;
                    mutableVector9 = mutableVector10;
                } else {
                    mutableVector9 = mutableVector10;
                }
            } else {
                node = node14;
                i2 = i19;
            }
            nodePop4 = DelegatableNodeKt.pop(mutableVector9);
            node14 = node;
            i19 = i2;
        }
        if (arrayList == null) {
            return false;
        }
        List list2 = arrayList;
        int size2 = list2.size();
        for (int i21 = 0; i21 < size2; i21++) {
            if (((RotaryInputModifierNode) list2.get(i21)).onRotaryScrollEvent(event)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.p000ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.p000ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.p000ui.focus.FocusOwner
    public void scheduleInvalidation(FocusPropertiesModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    /* renamed from: traverseAncestors-Y-YKmho, reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m3645traverseAncestorsYYKmho(DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho, int type, Function1<? super T, Unit> function1, Function1<? super T, Unit> function12) {
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv;
        int i;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv2;
        int i2;
        List ancestors;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv3;
        List ancestors2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv4;
        int size;
        int i3;
        DelegatableNode $this$ancestors_u2d64DMado$iv;
        int i4;
        NodeChain nodes;
        int i5;
        DelegatableNode $this$ancestors_u2d64DMado$iv2;
        int i6;
        DelegatableNode $this$ancestors_u2d64DMado$iv3;
        int i7;
        int i8;
        Object result$iv;
        int count$iv$iv$iv;
        Function1<? super T, Unit> function13 = function1;
        int count$iv$iv$iv2 = 0;
        DelegatableNode $this$ancestors_u2d64DMado$iv4 = $this$traverseAncestors_u2dY_u2dYKmho;
        int i9 = 0;
        Object result$iv2 = null;
        if (!$this$ancestors_u2d64DMado$iv4.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node$iv$iv$iv = $this$ancestors_u2d64DMado$iv4.getNode().getParent();
        LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$ancestors_u2d64DMado$iv4);
        while (layout$iv$iv$iv != null) {
            Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
            if ((head$iv$iv$iv.getAggregateChildKindSet() & type) != 0) {
                while (node$iv$iv$iv != null) {
                    if ((node$iv$iv$iv.getKindSet() & type) != 0) {
                        Modifier.Node it$iv$iv = node$iv$iv$iv;
                        Object stack$iv$iv$iv = null;
                        Modifier.Node this_$iv$iv$iv$iv = it$iv$iv;
                        while (this_$iv$iv$iv$iv != null) {
                            int i10 = count$iv$iv$iv2;
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if (this_$iv$iv$iv$iv instanceof Object) {
                                Modifier.Node node = this_$iv$iv$iv$iv;
                                if (result$iv2 == null) {
                                    Object result$iv3 = new ArrayList();
                                    result$iv2 = (List) result$iv3;
                                }
                                $this$ancestors_u2d64DMado$iv3 = $this$ancestors_u2d64DMado$iv4;
                                ((List) result$iv2).add(node);
                                i7 = i9;
                            } else {
                                $this$ancestors_u2d64DMado$iv3 = $this$ancestors_u2d64DMado$iv4;
                                if (((this_$iv$iv$iv$iv.getKindSet() & type) != 0) && (this_$iv$iv$iv$iv instanceof DelegatingNode)) {
                                    int count$iv$iv$iv3 = 0;
                                    DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) this_$iv$iv$iv$iv;
                                    Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv$iv != null) {
                                        DelegatingNode this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                        Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                        if ((next$iv$iv$iv.getKindSet() & type) != 0) {
                                            count$iv$iv$iv3++;
                                            i8 = i9;
                                            if (count$iv$iv$iv3 == 1) {
                                                this_$iv$iv$iv$iv = next$iv$iv$iv;
                                                result$iv = result$iv2;
                                            } else {
                                                Object mutableVector = (MutableVector) stack$iv$iv$iv;
                                                if (mutableVector == null) {
                                                    count$iv$iv$iv = count$iv$iv$iv3;
                                                    result$iv = result$iv2;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    count$iv$iv$iv = count$iv$iv$iv3;
                                                    result$iv = result$iv2;
                                                }
                                                stack$iv$iv$iv = mutableVector;
                                                Modifier.Node theNode$iv$iv$iv = this_$iv$iv$iv$iv;
                                                if (theNode$iv$iv$iv != null) {
                                                    MutableVector mutableVector2 = (MutableVector) stack$iv$iv$iv;
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv$iv$iv);
                                                    }
                                                    this_$iv$iv$iv$iv = null;
                                                }
                                                MutableVector mutableVector3 = (MutableVector) stack$iv$iv$iv;
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(next$iv$iv$iv);
                                                }
                                                count$iv$iv$iv3 = count$iv$iv$iv;
                                            }
                                        } else {
                                            i8 = i9;
                                            result$iv = result$iv2;
                                        }
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                        this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                        i9 = i8;
                                        result$iv2 = result$iv;
                                    }
                                    i7 = i9;
                                    Object result$iv4 = result$iv2;
                                    if (count$iv$iv$iv3 == 1) {
                                        count$iv$iv$iv2 = i10;
                                        $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv3;
                                        i9 = i7;
                                        result$iv2 = result$iv4;
                                    } else {
                                        result$iv2 = result$iv4;
                                    }
                                } else {
                                    i7 = i9;
                                    result$iv2 = result$iv2;
                                }
                            }
                            this_$iv$iv$iv$iv = DelegatableNodeKt.pop((MutableVector) stack$iv$iv$iv);
                            count$iv$iv$iv2 = i10;
                            $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv3;
                            i9 = i7;
                        }
                        i5 = count$iv$iv$iv2;
                        $this$ancestors_u2d64DMado$iv2 = $this$ancestors_u2d64DMado$iv4;
                        i6 = i9;
                    } else {
                        i5 = count$iv$iv$iv2;
                        $this$ancestors_u2d64DMado$iv2 = $this$ancestors_u2d64DMado$iv4;
                        i6 = i9;
                    }
                    node$iv$iv$iv = node$iv$iv$iv.getParent();
                    count$iv$iv$iv2 = i5;
                    $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv2;
                    i9 = i6;
                }
                i3 = count$iv$iv$iv2;
                $this$ancestors_u2d64DMado$iv = $this$ancestors_u2d64DMado$iv4;
                i4 = i9;
            } else {
                i3 = count$iv$iv$iv2;
                $this$ancestors_u2d64DMado$iv = $this$ancestors_u2d64DMado$iv4;
                i4 = i9;
            }
            layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
            node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes = layout$iv$iv$iv.getNodes()) == null) ? null : nodes.getTail();
            count$iv$iv$iv2 = i3;
            $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv;
            i9 = i4;
        }
        List ancestors3 = (List) result$iv2;
        if (ancestors3 != null && ancestors3.size() - 1 >= 0) {
            do {
                int index$iv = size;
                size--;
                Object item$iv = ancestors3.get(index$iv);
                function13.invoke(item$iv);
            } while (size >= 0);
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv5 = $this$traverseAncestors_u2dY_u2dYKmho.getNode();
        Object stack$iv = null;
        Modifier.Node node$iv = $this$dispatchForKind_u2d6rFNWt0$iv5;
        while (node$iv != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (node$iv instanceof Object) {
                function13.invoke(node$iv);
                ancestors = ancestors3;
                $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv5;
            } else {
                Modifier.Node this_$iv$iv = node$iv;
                if (((this_$iv$iv.getKindSet() & type) != 0) && (node$iv instanceof DelegatingNode)) {
                    int count$iv = 0;
                    DelegatingNode this_$iv$iv2 = (DelegatingNode) node$iv;
                    Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if ((next$iv.getKindSet() & type) != 0) {
                            count$iv++;
                            if (count$iv == 1) {
                                node$iv = next$iv;
                                ancestors2 = ancestors3;
                                $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                            } else {
                                Object obj = (MutableVector) stack$iv;
                                if (obj == null) {
                                    ancestors2 = ancestors3;
                                    $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                                    Object mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                    obj = mutableVector4;
                                } else {
                                    ancestors2 = ancestors3;
                                    $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                                }
                                stack$iv = obj;
                                Modifier.Node theNode$iv = node$iv;
                                if (theNode$iv != null) {
                                    MutableVector mutableVector5 = (MutableVector) stack$iv;
                                    if (mutableVector5 != null) {
                                        mutableVector5.add(theNode$iv);
                                    }
                                    node$iv = null;
                                }
                                MutableVector mutableVector6 = (MutableVector) stack$iv;
                                if (mutableVector6 != null) {
                                    mutableVector6.add(next$iv);
                                }
                            }
                        } else {
                            ancestors2 = ancestors3;
                            $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                        }
                        node$iv$iv = node$iv$iv.getChild();
                        ancestors3 = ancestors2;
                        $this$dispatchForKind_u2d6rFNWt0$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv4;
                    }
                    ancestors = ancestors3;
                    $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                    if (count$iv == 1) {
                        function13 = function1;
                        ancestors3 = ancestors;
                        $this$dispatchForKind_u2d6rFNWt0$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                    }
                } else {
                    ancestors = ancestors3;
                    $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                }
            }
            node$iv = DelegatableNodeKt.pop((MutableVector) stack$iv);
            function13 = function1;
            ancestors3 = ancestors;
            $this$dispatchForKind_u2d6rFNWt0$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv3;
        }
        List ancestors4 = ancestors3;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv6 = $this$traverseAncestors_u2dY_u2dYKmho.getNode();
        int i11 = 0;
        Object stack$iv2 = null;
        Modifier.Node node$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
        while (node$iv2 != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (node$iv2 instanceof Object) {
                function12.invoke(node$iv2);
                $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv6;
                i = i11;
            } else {
                Modifier.Node this_$iv$iv3 = node$iv2;
                if (((this_$iv$iv3.getKindSet() & type) != 0) && (node$iv2 instanceof DelegatingNode)) {
                    int count$iv2 = 0;
                    DelegatingNode this_$iv$iv4 = (DelegatingNode) node$iv2;
                    Modifier.Node node$iv$iv2 = this_$iv$iv4.getDelegate();
                    while (node$iv$iv2 != null) {
                        Modifier.Node next$iv2 = node$iv$iv2;
                        if ((next$iv2.getKindSet() & type) != 0) {
                            count$iv2++;
                            if (count$iv2 == 1) {
                                node$iv2 = next$iv2;
                                $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
                                i2 = i11;
                            } else {
                                Object obj2 = (MutableVector) stack$iv2;
                                if (obj2 == null) {
                                    $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
                                    i2 = i11;
                                    Object mutableVector7 = new MutableVector(new Modifier.Node[16], 0);
                                    obj2 = mutableVector7;
                                } else {
                                    $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
                                    i2 = i11;
                                }
                                stack$iv2 = obj2;
                                Modifier.Node theNode$iv2 = node$iv2;
                                if (theNode$iv2 != null) {
                                    MutableVector mutableVector8 = (MutableVector) stack$iv2;
                                    if (mutableVector8 != null) {
                                        mutableVector8.add(theNode$iv2);
                                    }
                                    node$iv2 = null;
                                }
                                MutableVector mutableVector9 = (MutableVector) stack$iv2;
                                if (mutableVector9 != null) {
                                    mutableVector9.add(next$iv2);
                                }
                            }
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
                            i2 = i11;
                        }
                        node$iv$iv2 = node$iv$iv2.getChild();
                        $this$dispatchForKind_u2d6rFNWt0$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv2;
                        i11 = i2;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv6;
                    i = i11;
                    if (count$iv2 == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv;
                        i11 = i;
                    }
                } else {
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv6;
                    i = i11;
                }
            }
            node$iv2 = DelegatableNodeKt.pop((MutableVector) stack$iv2);
            $this$dispatchForKind_u2d6rFNWt0$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv;
            i11 = i;
        }
        if (ancestors4 != null) {
            int size2 = ancestors4.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                Object item$iv2 = ancestors4.get(index$iv2);
                function12.invoke(item$iv2);
            }
        }
    }

    @Override // androidx.compose.p000ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(focusTargetNodeFindActiveFocusNode);
        }
        return null;
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode $this$lastLocalKeyInputNode) {
        Modifier.Node node = null;
        int mask$iv = NodeKind.m5425constructorimpl(1024) | NodeKind.m5425constructorimpl(8192);
        if (!$this$lastLocalKeyInputNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
        }
        Modifier.Node self$iv = $this$lastLocalKeyInputNode.getNode();
        if ((self$iv.getAggregateChildKindSet() & mask$iv) != 0) {
            for (Modifier.Node next$iv = self$iv.getChild(); next$iv != null; next$iv = next$iv.getChild()) {
                if ((next$iv.getKindSet() & mask$iv) != 0) {
                    Modifier.Node modifierNode = next$iv;
                    if ((modifierNode.getKindSet() & NodeKind.m5425constructorimpl(1024)) != 0) {
                        return node;
                    }
                    node = modifierNode;
                }
            }
        }
        return node;
    }

    /* renamed from: wrapAroundFocus-3ESFkO8, reason: not valid java name */
    private final boolean m3647wrapAroundFocus3ESFkO8(int focusDirection) {
        if (!this.rootFocusNode.getFocusState().getHasFocus() || this.rootFocusNode.getFocusState().isFocused()) {
            return false;
        }
        if (!(FocusDirection.m3628equalsimpl0(focusDirection, FocusDirection.INSTANCE.m3638getNextdhqQ8s()) ? true : FocusDirection.m3628equalsimpl0(focusDirection, FocusDirection.INSTANCE.m3639getPreviousdhqQ8s()))) {
            return false;
        }
        clearFocus(false);
        if (this.rootFocusNode.getFocusState().isFocused()) {
            return mo3642moveFocus3ESFkO8(focusDirection);
        }
        return false;
    }

    /* renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    private final boolean m3646validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long keyCode = KeyEvent_androidKt.m4957getKeyZmokQxo(keyEvent);
        int iM4958getTypeZmokQxo = KeyEvent_androidKt.m4958getTypeZmokQxo(keyEvent);
        if (KeyEventType.m4950equalsimpl0(iM4958getTypeZmokQxo, KeyEventType.INSTANCE.m4954getKeyDownCS__XNY())) {
            MutableLongSet it = this.keysCurrentlyDown;
            if (it == null) {
                it = new MutableLongSet(3);
                this.keysCurrentlyDown = it;
            }
            it.plusAssign(keyCode);
        } else if (KeyEventType.m4950equalsimpl0(iM4958getTypeZmokQxo, KeyEventType.INSTANCE.m4955getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (!(mutableLongSet != null && mutableLongSet.contains(keyCode))) {
                return false;
            }
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 != null) {
                mutableLongSet2.remove(keyCode);
            }
        }
        return true;
    }
}
