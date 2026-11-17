package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.node.DelegatableNodeKt;
import androidx.compose.p000ui.node.DelegatingNode;
import androidx.compose.p000ui.node.NodeKind;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: FocusInvalidationManager.kt */
@Metadata(m164d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\rJ%\u0010\u000f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\b2\u0006\u0010\u0010\u001a\u0002H\u0011H\u0002¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m165d2 = {"Landroidx/compose/ui/focus/FocusInvalidationManager;", "", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function1;)V", "focusEventNodes", "", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "focusPropertiesNodes", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "focusTargetNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "invalidateNodes", "scheduleInvalidation", "node", "T", "(Ljava/util/Set;Ljava/lang/Object;)V", "ui_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FocusInvalidationManager {
    public static final int $stable = 8;
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;
    private Set<FocusTargetNode> focusTargetNodes = new LinkedHashSet();
    private Set<FocusEventModifierNode> focusEventNodes = new LinkedHashSet();
    private Set<FocusPropertiesModifierNode> focusPropertiesNodes = new LinkedHashSet();
    private final Function0<Unit> invalidateNodes = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusInvalidationManager$invalidateNodes$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r35v0, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r3v28, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r4v11, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v16 */
        /* JADX WARN: Type inference failed for: r4v21 */
        /* JADX WARN: Type inference failed for: r7v14, types: [androidx.compose.ui.Modifier$Node] */
        /* JADX WARN: Type inference failed for: r7v15 */
        /* JADX WARN: Type inference failed for: r7v16 */
        /* JADX WARN: Type inference failed for: r7v17 */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v19 */
        /* JADX WARN: Type inference failed for: r7v20 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Set set;
            FocusInvalidationManager focusInvalidationManager;
            int i;
            FocusStateImpl focusState;
            FocusStateImpl focusState2;
            Modifier.Node node;
            MutableVector mutableVector;
            Object obj;
            DelegatingNode delegatingNode;
            FocusTargetNode focusTargetNode;
            int i2;
            MutableVector mutableVector2;
            FocusInvalidationManager focusInvalidationManager2;
            int i3;
            DelegatingNode delegatingNode2;
            int i4;
            int i5;
            MutableVector mutableVector3;
            Set set2;
            FocusInvalidationManager focusInvalidationManager3;
            int i6;
            int i7;
            DelegatingNode delegatingNode3;
            int i8;
            MutableVector mutableVector4;
            Set set3;
            FocusInvalidationManager focusInvalidationManager4;
            int i9;
            FocusInvalidationManager focusInvalidationManager5;
            int i10;
            int i11;
            MutableVector mutableVector5;
            Set set4 = this.this$0.focusPropertiesNodes;
            FocusInvalidationManager focusInvalidationManager6 = this.this$0;
            int i12 = 0;
            Iterator it = set4.iterator();
            while (true) {
                int i13 = 1024;
                if (!it.hasNext()) {
                    this.this$0.focusPropertiesNodes.clear();
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    Set<FocusEventModifierNode> set5 = this.this$0.focusEventNodes;
                    FocusInvalidationManager focusInvalidationManager7 = this.this$0;
                    int i14 = 0;
                    for (FocusEventModifierNode focusEventModifierNode : set5) {
                        if (focusEventModifierNode.getNode().getIsAttached()) {
                            boolean z = true;
                            boolean z2 = false;
                            FocusTargetNode focusTargetNode2 = null;
                            FocusEventModifierNode focusEventModifierNode2 = focusEventModifierNode;
                            int iM5425constructorimpl = NodeKind.m5425constructorimpl(i13);
                            MutableVector mutableVector6 = null;
                            Modifier.Node node2 = focusEventModifierNode2.getNode();
                            while (node2 != null) {
                                Set set6 = set5;
                                if (node2 instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode3 = node2;
                                    if (focusTargetNode2 != null) {
                                        z2 = true;
                                    }
                                    focusTargetNode2 = focusTargetNode3;
                                    focusInvalidationManager2 = focusInvalidationManager7;
                                    if (focusInvalidationManager2.focusTargetNodes.contains(focusTargetNode3)) {
                                        z = false;
                                        linkedHashSet.add(focusTargetNode3);
                                    }
                                    i3 = i14;
                                } else {
                                    focusInvalidationManager2 = focusInvalidationManager7;
                                    if (((node2.getKindSet() & iM5425constructorimpl) != 0) && (node2 instanceof DelegatingNode)) {
                                        int i15 = 0;
                                        DelegatingNode delegatingNode4 = node2;
                                        Modifier.Node delegate = delegatingNode4.getDelegate();
                                        while (delegate != null) {
                                            Modifier.Node node3 = delegate;
                                            if ((node3.getKindSet() & iM5425constructorimpl) != 0) {
                                                i15++;
                                                delegatingNode2 = delegatingNode4;
                                                if (i15 == 1) {
                                                    node2 = node3;
                                                    i4 = i14;
                                                } else {
                                                    if (mutableVector6 == null) {
                                                        i5 = i15;
                                                        i4 = i14;
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        i5 = i15;
                                                        i4 = i14;
                                                        mutableVector3 = mutableVector6;
                                                    }
                                                    Object obj2 = node2;
                                                    if (obj2 != null) {
                                                        if (mutableVector3 != null) {
                                                            Boolean.valueOf(mutableVector3.add(obj2));
                                                        }
                                                        node2 = null;
                                                    }
                                                    if (mutableVector3 != null) {
                                                        Boolean.valueOf(mutableVector3.add(node3));
                                                    }
                                                    mutableVector6 = mutableVector3;
                                                    i15 = i5;
                                                }
                                            } else {
                                                delegatingNode2 = delegatingNode4;
                                                i4 = i14;
                                            }
                                            delegate = delegate.getChild();
                                            delegatingNode4 = delegatingNode2;
                                            i14 = i4;
                                        }
                                        i3 = i14;
                                        if (i15 == 1) {
                                            set5 = set6;
                                            focusInvalidationManager7 = focusInvalidationManager2;
                                            i14 = i3;
                                        }
                                    } else {
                                        i3 = i14;
                                    }
                                }
                                node2 = DelegatableNodeKt.pop(mutableVector6);
                                set5 = set6;
                                focusInvalidationManager7 = focusInvalidationManager2;
                                i14 = i3;
                            }
                            set = set5;
                            focusInvalidationManager = focusInvalidationManager7;
                            i = i14;
                            if (!focusEventModifierNode2.getNode().getIsAttached()) {
                                throw new IllegalStateException("visitChildren called on an unattached node".toString());
                            }
                            MutableVector mutableVector7 = new MutableVector(new Modifier.Node[16], 0);
                            Modifier.Node child = focusEventModifierNode2.getNode().getChild();
                            if (child == null) {
                                DelegatableNodeKt.addLayoutNodeChildren(mutableVector7, focusEventModifierNode2.getNode());
                            } else {
                                mutableVector7.add(child);
                            }
                            while (mutableVector7.isNotEmpty()) {
                                ?? r4 = (Modifier.Node) mutableVector7.removeAt(mutableVector7.getSize() - 1);
                                if ((r4.getAggregateChildKindSet() & iM5425constructorimpl) == 0) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector7, r4);
                                    node = child;
                                    mutableVector = mutableVector7;
                                } else {
                                    for (FocusTargetNode child2 = r4; child2 != null; child2 = child2.getChild()) {
                                        if ((child2.getKindSet() & iM5425constructorimpl) != 0) {
                                            MutableVector mutableVector8 = null;
                                            Modifier.Node node4 = child;
                                            FocusTargetNode focusTargetNodePop = child2;
                                            while (focusTargetNodePop != null) {
                                                MutableVector mutableVector9 = mutableVector7;
                                                if (focusTargetNodePop instanceof FocusTargetNode) {
                                                    FocusTargetNode focusTargetNode4 = focusTargetNodePop;
                                                    if (focusTargetNode2 != null) {
                                                        z2 = true;
                                                    }
                                                    focusTargetNode2 = focusTargetNode4;
                                                    obj = r4;
                                                    if (focusInvalidationManager.focusTargetNodes.contains(focusTargetNode4)) {
                                                        z = false;
                                                        linkedHashSet.add(focusTargetNode4);
                                                    }
                                                } else {
                                                    obj = r4;
                                                    if (((focusTargetNodePop.getKindSet() & iM5425constructorimpl) != 0) && (focusTargetNodePop instanceof DelegatingNode)) {
                                                        int i16 = 0;
                                                        DelegatingNode delegatingNode5 = (DelegatingNode) focusTargetNodePop;
                                                        for (FocusTargetNode delegate2 = delegatingNode5.getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                                            FocusTargetNode focusTargetNode5 = delegate2;
                                                            if ((focusTargetNode5.getKindSet() & iM5425constructorimpl) != 0) {
                                                                i16++;
                                                                FocusTargetNode focusTargetNode6 = focusTargetNodePop;
                                                                if (i16 == 1) {
                                                                    focusTargetNode = focusTargetNode5;
                                                                    delegatingNode = delegatingNode5;
                                                                } else {
                                                                    if (mutableVector8 == null) {
                                                                        i2 = i16;
                                                                        delegatingNode = delegatingNode5;
                                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                                    } else {
                                                                        i2 = i16;
                                                                        delegatingNode = delegatingNode5;
                                                                        mutableVector2 = mutableVector8;
                                                                    }
                                                                    if (focusTargetNode6 != null) {
                                                                        if (mutableVector2 != null) {
                                                                            Boolean.valueOf(mutableVector2.add(focusTargetNode6));
                                                                        }
                                                                        focusTargetNode = null;
                                                                    } else {
                                                                        focusTargetNode = focusTargetNode6;
                                                                    }
                                                                    if (mutableVector2 != null) {
                                                                        Boolean.valueOf(mutableVector2.add(focusTargetNode5));
                                                                    }
                                                                    mutableVector8 = mutableVector2;
                                                                    i16 = i2;
                                                                }
                                                            } else {
                                                                delegatingNode = delegatingNode5;
                                                                focusTargetNode = focusTargetNodePop;
                                                            }
                                                            focusTargetNodePop = focusTargetNode;
                                                            delegatingNode5 = delegatingNode;
                                                        }
                                                        FocusTargetNode focusTargetNode7 = focusTargetNodePop;
                                                        if (i16 == 1) {
                                                            mutableVector7 = mutableVector9;
                                                            r4 = obj;
                                                            focusTargetNodePop = focusTargetNode7;
                                                        }
                                                    }
                                                }
                                                focusTargetNodePop = DelegatableNodeKt.pop(mutableVector8);
                                                mutableVector7 = mutableVector9;
                                                r4 = obj;
                                            }
                                            child = node4;
                                        } else {
                                            child = child;
                                        }
                                    }
                                    node = child;
                                    mutableVector = mutableVector7;
                                }
                                child = node;
                                mutableVector7 = mutableVector;
                            }
                            if (z) {
                                if (z2) {
                                    focusState2 = FocusEventModifierNodeKt.getFocusState(focusEventModifierNode);
                                } else {
                                    if (focusTargetNode2 == null || (focusState = focusTargetNode2.getFocusState()) == null) {
                                        focusState = FocusStateImpl.Inactive;
                                    }
                                    focusState2 = focusState;
                                }
                                focusEventModifierNode.onFocusEvent(focusState2);
                            }
                        } else {
                            focusEventModifierNode.onFocusEvent(FocusStateImpl.Inactive);
                            set = set5;
                            focusInvalidationManager = focusInvalidationManager7;
                            i = i14;
                        }
                        set5 = set;
                        focusInvalidationManager7 = focusInvalidationManager;
                        i14 = i;
                        i13 = 1024;
                    }
                    this.this$0.focusEventNodes.clear();
                    for (FocusTargetNode focusTargetNode8 : this.this$0.focusTargetNodes) {
                        if (focusTargetNode8.getIsAttached()) {
                            FocusStateImpl focusState3 = focusTargetNode8.getFocusState();
                            focusTargetNode8.invalidateFocus$ui_release();
                            if (focusState3 != focusTargetNode8.getFocusState() || linkedHashSet.contains(focusTargetNode8)) {
                                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode8);
                            }
                        }
                    }
                    this.this$0.focusTargetNodes.clear();
                    linkedHashSet.clear();
                    if (!this.this$0.focusPropertiesNodes.isEmpty()) {
                        throw new IllegalStateException("Unprocessed FocusProperties nodes".toString());
                    }
                    if (!this.this$0.focusEventNodes.isEmpty()) {
                        throw new IllegalStateException("Unprocessed FocusEvent nodes".toString());
                    }
                    if (!this.this$0.focusTargetNodes.isEmpty()) {
                        throw new IllegalStateException("Unprocessed FocusTarget nodes".toString());
                    }
                    return;
                }
                FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) it.next();
                if (focusPropertiesModifierNode.getNode().getIsAttached()) {
                    FocusPropertiesModifierNode focusPropertiesModifierNode2 = focusPropertiesModifierNode;
                    int iM5425constructorimpl2 = NodeKind.m5425constructorimpl(1024);
                    MutableVector mutableVector10 = null;
                    Modifier.Node node5 = focusPropertiesModifierNode2.getNode();
                    while (node5 != null) {
                        if (node5 instanceof FocusTargetNode) {
                            set3 = set4;
                            focusInvalidationManager6.focusTargetNodes.add((FocusTargetNode) node5);
                            focusInvalidationManager4 = focusInvalidationManager6;
                            i9 = i12;
                        } else {
                            set3 = set4;
                            if (((node5.getKindSet() & iM5425constructorimpl2) != 0) && (node5 instanceof DelegatingNode)) {
                                int i17 = 0;
                                Modifier.Node delegate3 = ((DelegatingNode) node5).getDelegate();
                                while (delegate3 != null) {
                                    Modifier.Node node6 = delegate3;
                                    if ((node6.getKindSet() & iM5425constructorimpl2) != 0) {
                                        i17++;
                                        focusInvalidationManager5 = focusInvalidationManager6;
                                        if (i17 == 1) {
                                            node5 = node6;
                                            i10 = i12;
                                        } else {
                                            if (mutableVector10 == null) {
                                                i11 = i17;
                                                i10 = i12;
                                                mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                i11 = i17;
                                                i10 = i12;
                                                mutableVector5 = mutableVector10;
                                            }
                                            Modifier.Node node7 = node5;
                                            if (node7 != null) {
                                                if (mutableVector5 != null) {
                                                    Boolean.valueOf(mutableVector5.add(node7));
                                                }
                                                node5 = null;
                                            }
                                            if (mutableVector5 != null) {
                                                Boolean.valueOf(mutableVector5.add(node6));
                                            }
                                            mutableVector10 = mutableVector5;
                                            i17 = i11;
                                        }
                                    } else {
                                        focusInvalidationManager5 = focusInvalidationManager6;
                                        i10 = i12;
                                    }
                                    delegate3 = delegate3.getChild();
                                    focusInvalidationManager6 = focusInvalidationManager5;
                                    i12 = i10;
                                }
                                focusInvalidationManager4 = focusInvalidationManager6;
                                i9 = i12;
                                if (i17 == 1) {
                                    set4 = set3;
                                    focusInvalidationManager6 = focusInvalidationManager4;
                                    i12 = i9;
                                }
                            } else {
                                focusInvalidationManager4 = focusInvalidationManager6;
                                i9 = i12;
                            }
                        }
                        node5 = DelegatableNodeKt.pop(mutableVector10);
                        set4 = set3;
                        focusInvalidationManager6 = focusInvalidationManager4;
                        i12 = i9;
                    }
                    set2 = set4;
                    focusInvalidationManager3 = focusInvalidationManager6;
                    i6 = i12;
                    FocusPropertiesModifierNode focusPropertiesModifierNode3 = focusPropertiesModifierNode2;
                    int i18 = 0;
                    if (!focusPropertiesModifierNode3.getNode().getIsAttached()) {
                        throw new IllegalStateException("visitChildren called on an unattached node".toString());
                    }
                    MutableVector mutableVector11 = new MutableVector(new Modifier.Node[16], 0);
                    Modifier.Node child3 = focusPropertiesModifierNode3.getNode().getChild();
                    if (child3 == null) {
                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector11, focusPropertiesModifierNode3.getNode());
                    } else {
                        mutableVector11.add(child3);
                    }
                    while (mutableVector11.isNotEmpty()) {
                        Modifier.Node node8 = (Modifier.Node) mutableVector11.removeAt(mutableVector11.getSize() - 1);
                        if ((node8.getAggregateChildKindSet() & iM5425constructorimpl2) == 0) {
                            DelegatableNodeKt.addLayoutNodeChildren(mutableVector11, node8);
                        } else {
                            Modifier.Node child4 = node8;
                            while (true) {
                                if (child4 == null) {
                                    break;
                                }
                                if ((child4.getKindSet() & iM5425constructorimpl2) != 0) {
                                    MutableVector mutableVector12 = null;
                                    Modifier.Node node9 = child3;
                                    Modifier.Node nodePop = child4;
                                    while (nodePop != null) {
                                        FocusPropertiesModifierNode focusPropertiesModifierNode4 = focusPropertiesModifierNode3;
                                        if (nodePop instanceof FocusTargetNode) {
                                            i7 = i18;
                                            focusInvalidationManager3.focusTargetNodes.add((FocusTargetNode) nodePop);
                                        } else {
                                            i7 = i18;
                                            if (((nodePop.getKindSet() & iM5425constructorimpl2) != 0) && (nodePop instanceof DelegatingNode)) {
                                                int i19 = 0;
                                                DelegatingNode delegatingNode6 = (DelegatingNode) nodePop;
                                                Modifier.Node delegate4 = delegatingNode6.getDelegate();
                                                while (delegate4 != null) {
                                                    Modifier.Node node10 = delegate4;
                                                    if ((node10.getKindSet() & iM5425constructorimpl2) != 0) {
                                                        i19++;
                                                        Modifier.Node node11 = nodePop;
                                                        if (i19 == 1) {
                                                            nodePop = node10;
                                                            delegatingNode3 = delegatingNode6;
                                                        } else {
                                                            if (mutableVector12 == null) {
                                                                i8 = i19;
                                                                delegatingNode3 = delegatingNode6;
                                                                mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                                            } else {
                                                                i8 = i19;
                                                                delegatingNode3 = delegatingNode6;
                                                                mutableVector4 = mutableVector12;
                                                            }
                                                            if (node11 != null) {
                                                                if (mutableVector4 != null) {
                                                                    Boolean.valueOf(mutableVector4.add(node11));
                                                                }
                                                                node11 = null;
                                                            }
                                                            if (mutableVector4 != null) {
                                                                Boolean.valueOf(mutableVector4.add(node10));
                                                            }
                                                            mutableVector12 = mutableVector4;
                                                            nodePop = node11;
                                                            i19 = i8;
                                                        }
                                                    } else {
                                                        delegatingNode3 = delegatingNode6;
                                                    }
                                                    delegate4 = delegate4.getChild();
                                                    delegatingNode6 = delegatingNode3;
                                                }
                                                Modifier.Node node12 = nodePop;
                                                if (i19 == 1) {
                                                    focusPropertiesModifierNode3 = focusPropertiesModifierNode4;
                                                    i18 = i7;
                                                    nodePop = node12;
                                                }
                                            }
                                        }
                                        nodePop = DelegatableNodeKt.pop(mutableVector12);
                                        focusPropertiesModifierNode3 = focusPropertiesModifierNode4;
                                        i18 = i7;
                                    }
                                    child3 = node9;
                                } else {
                                    child4 = child4.getChild();
                                }
                            }
                        }
                    }
                } else {
                    set2 = set4;
                    focusInvalidationManager3 = focusInvalidationManager6;
                    i6 = i12;
                }
                set4 = set2;
                focusInvalidationManager6 = focusInvalidationManager3;
                i12 = i6;
            }
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public FocusInvalidationManager(Function1<? super Function0<Unit>, Unit> function1) {
        this.onRequestApplyChangesListener = function1;
    }

    public final void scheduleInvalidation(FocusTargetNode node) {
        scheduleInvalidation(this.focusTargetNodes, node);
    }

    public final void scheduleInvalidation(FocusEventModifierNode node) {
        scheduleInvalidation(this.focusEventNodes, node);
    }

    public final void scheduleInvalidation(FocusPropertiesModifierNode node) {
        scheduleInvalidation(this.focusPropertiesNodes, node);
    }

    private final <T> void scheduleInvalidation(Set<T> set, T t) {
        if (set.add(t) && this.focusTargetNodes.size() + this.focusEventNodes.size() + this.focusPropertiesNodes.size() == 1) {
            this.onRequestApplyChangesListener.invoke(this.invalidateNodes);
        }
    }
}
