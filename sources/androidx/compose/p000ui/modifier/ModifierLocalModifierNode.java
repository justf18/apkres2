package androidx.compose.p000ui.modifier;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.node.DelegatableNode;
import androidx.compose.p000ui.node.DelegatableNodeKt;
import androidx.compose.p000ui.node.DelegatingNode;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.NodeChain;
import androidx.compose.p000ui.node.NodeKind;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: ModifierLocalModifierNode.kt */
@Metadata(m164d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J)\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\t2\u0006\u0010\u000f\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, m165d2 = {"Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/DelegatableNode;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "current", "T", "Landroidx/compose/ui/modifier/ModifierLocal;", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "provide", "", "key", "value", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface ModifierLocalModifierNode extends ModifierLocalReadScope, DelegatableNode {
    default ModifierLocalMap getProvidedValues() {
        return EmptyMap.INSTANCE;
    }

    default <T> void provide(ModifierLocal<T> key, T value) {
        if (!(getProvidedValues() != EmptyMap.INSTANCE)) {
            throw new IllegalArgumentException("In order to provide locals you must override providedValues: ModifierLocalMap".toString());
        }
        if (!getProvidedValues().contains$ui_release(key)) {
            throw new IllegalArgumentException(("Any provided key must be initially provided in the overridden providedValues: ModifierLocalMap property. Key " + key + " was not found.").toString());
        }
        getProvidedValues().mo5306set$ui_release(key, value);
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalReadScope
    default <T> T getCurrent(ModifierLocal<T> modifierLocal) {
        ModifierLocal<T> modifierLocal2;
        ModifierLocalModifierNode modifierLocalModifierNode;
        int i;
        NodeChain nodes;
        ModifierLocal<T> modifierLocal3;
        ModifierLocalModifierNode modifierLocalModifierNode2;
        ModifierLocal<T> modifierLocal4;
        Modifier.Node node;
        int i2;
        MutableVector mutableVector;
        Modifier.Node node2;
        if (!getNode().getIsAttached()) {
            throw new IllegalArgumentException("ModifierLocal accessed from an unattached node".toString());
        }
        ModifierLocal<T> modifierLocal5 = modifierLocal;
        ModifierLocalModifierNode modifierLocalModifierNode3 = this;
        int iM5425constructorimpl = NodeKind.m5425constructorimpl(32);
        if (!modifierLocalModifierNode3.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent = modifierLocalModifierNode3.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(modifierLocalModifierNode3);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM5425constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM5425constructorimpl) != 0) {
                        MutableVector mutableVector2 = null;
                        modifierLocalModifierNode2 = modifierLocalModifierNode3;
                        Modifier.Node nodePop = parent;
                        while (nodePop != null) {
                            int i3 = iM5425constructorimpl;
                            if (nodePop instanceof ModifierLocalModifierNode) {
                                ModifierLocalModifierNode modifierLocalModifierNode4 = (ModifierLocalModifierNode) nodePop;
                                if (modifierLocalModifierNode4.getProvidedValues().contains$ui_release(modifierLocal5)) {
                                    return (T) modifierLocalModifierNode4.getProvidedValues().get$ui_release(modifierLocal5);
                                }
                                modifierLocal4 = modifierLocal5;
                            } else {
                                modifierLocal4 = modifierLocal5;
                                int i4 = 1;
                                if (((nodePop.getKindSet() & i3) != 0 ? 1 : null) != null && (nodePop instanceof DelegatingNode)) {
                                    int i5 = 0;
                                    Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                    while (delegate != null) {
                                        Modifier.Node node3 = delegate;
                                        if (((node3.getKindSet() & i3) != 0 ? i4 : 0) != 0) {
                                            i5++;
                                            if (i5 == i4) {
                                                nodePop = node3;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    node = nodePop;
                                                    i2 = i5;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    node = nodePop;
                                                    i2 = i5;
                                                    mutableVector = mutableVector2;
                                                }
                                                mutableVector2 = mutableVector;
                                                Modifier.Node node4 = node;
                                                if (node4 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node4);
                                                    }
                                                    node2 = null;
                                                } else {
                                                    node2 = node;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(node3);
                                                }
                                                nodePop = node2;
                                                i5 = i2;
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        i4 = 1;
                                    }
                                    Modifier.Node node5 = nodePop;
                                    if (i5 == 1) {
                                        iM5425constructorimpl = i3;
                                        modifierLocal5 = modifierLocal4;
                                        nodePop = node5;
                                    }
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                            iM5425constructorimpl = i3;
                            modifierLocal5 = modifierLocal4;
                        }
                        modifierLocal3 = modifierLocal5;
                    } else {
                        modifierLocal3 = modifierLocal5;
                        modifierLocalModifierNode2 = modifierLocalModifierNode3;
                    }
                    parent = parent.getParent();
                    modifierLocalModifierNode3 = modifierLocalModifierNode2;
                    iM5425constructorimpl = iM5425constructorimpl;
                    modifierLocal5 = modifierLocal3;
                }
                modifierLocal2 = modifierLocal5;
                modifierLocalModifierNode = modifierLocalModifierNode3;
                i = iM5425constructorimpl;
            } else {
                modifierLocal2 = modifierLocal5;
                modifierLocalModifierNode = modifierLocalModifierNode3;
                i = iM5425constructorimpl;
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
            modifierLocalModifierNode3 = modifierLocalModifierNode;
            iM5425constructorimpl = i;
            modifierLocal5 = modifierLocal2;
        }
        return modifierLocal5.getDefaultFactory$ui_release().invoke();
    }
}
