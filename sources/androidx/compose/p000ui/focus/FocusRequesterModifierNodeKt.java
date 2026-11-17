package androidx.compose.p000ui.focus;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.node.DelegatableNode;
import androidx.compose.p000ui.node.DelegatableNodeKt;
import androidx.compose.p000ui.node.DelegatingNode;
import androidx.compose.p000ui.node.NodeKind;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: FocusRequesterModifierNode.kt */
@Metadata(m164d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0007"}, m165d2 = {"captureFocus", "", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "freeFocus", "requestFocus", "restoreFocusedChild", "saveFocusedChild", "ui_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FocusRequesterModifierNodeKt {
    public static final boolean requestFocus(FocusRequesterModifierNode $this$requestFocus) {
        int i;
        DelegatingNode this_$iv$iv$iv;
        int i2;
        int count$iv$iv;
        MutableVector mutableVector;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int type$iv;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int type$iv2;
        MutableVector mutableVector2;
        FocusRequesterModifierNode $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$requestFocus;
        int type$iv3 = NodeKind.m5425constructorimpl(1024);
        int i3 = 0;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3.getNode();
        MutableVector mutableVector3 = null;
        Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        while (true) {
            boolean z = false;
            int i4 = 1;
            if (nodePop == null) {
                DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                int type$iv4 = type$iv3;
                int count$iv$iv2 = type$iv4;
                DelegatableNode $this$visitChildren$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                if (!$this$visitChildren$iv$iv.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                }
                MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child$iv$iv = $this$visitChildren$iv$iv.getNode().getChild();
                if (child$iv$iv == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren$iv$iv.getNode());
                } else {
                    branches$iv$iv.add(child$iv$iv);
                }
                while (branches$iv$iv.isNotEmpty()) {
                    Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                    if ((branch$iv$iv.getAggregateChildKindSet() & count$iv$iv2) != 0) {
                        Modifier.Node node$iv$iv = branch$iv$iv;
                        while (true) {
                            if (node$iv$iv == null) {
                                z = false;
                                break;
                            }
                            if ((node$iv$iv.getKindSet() & count$iv$iv2) != 0) {
                                Modifier.Node it$iv = node$iv$iv;
                                MutableVector mutableVector4 = null;
                                Modifier.Node this_$iv$iv$iv2 = it$iv;
                                while (this_$iv$iv$iv2 != null) {
                                    if (this_$iv$iv$iv2 instanceof FocusTargetNode) {
                                        FocusTargetNode focusTarget = (FocusTargetNode) this_$iv$iv$iv2;
                                        FocusProperties focusProperties = focusTarget.fetchFocusProperties$ui_release();
                                        return focusProperties.getCanFocus() ? FocusTransactionsKt.requestFocus(focusTarget) : TwoDimensionalFocusSearchKt.m3669findChildCorrespondingToFocusEnterOMvw8(focusTarget, FocusDirection.INSTANCE.m3635getEnterdhqQ8s(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierNodeKt$requestFocus$1$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Boolean invoke(FocusTargetNode it) {
                                                return Boolean.valueOf(FocusTransactionsKt.requestFocus(it));
                                            }
                                        });
                                    }
                                    int mask$iv$iv = count$iv$iv2;
                                    DelegatableNode $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv;
                                    if (((this_$iv$iv$iv2.getKindSet() & type$iv4) != 0 ? true : z) && (this_$iv$iv$iv2 instanceof DelegatingNode)) {
                                        int count$iv$iv3 = 0;
                                        DelegatingNode this_$iv$iv$iv3 = (DelegatingNode) this_$iv$iv$iv2;
                                        Modifier.Node node$iv$iv$iv = this_$iv$iv$iv3.getDelegate();
                                        while (node$iv$iv$iv != null) {
                                            Modifier.Node next$iv$iv = node$iv$iv$iv;
                                            if ((next$iv$iv.getKindSet() & type$iv4) != 0 ? true : z) {
                                                count$iv$iv3++;
                                                if (count$iv$iv3 == 1) {
                                                    this_$iv$iv$iv2 = next$iv$iv;
                                                    this_$iv$iv$iv = this_$iv$iv$iv3;
                                                    i2 = i3;
                                                } else {
                                                    if (mutableVector4 == null) {
                                                        count$iv$iv = count$iv$iv3;
                                                        this_$iv$iv$iv = this_$iv$iv$iv3;
                                                        i2 = i3;
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        count$iv$iv = count$iv$iv3;
                                                        this_$iv$iv$iv = this_$iv$iv$iv3;
                                                        i2 = i3;
                                                        mutableVector = mutableVector4;
                                                    }
                                                    mutableVector4 = mutableVector;
                                                    Modifier.Node theNode$iv$iv = this_$iv$iv$iv2;
                                                    if (theNode$iv$iv != null) {
                                                        if (mutableVector4 != null) {
                                                            mutableVector4.add(theNode$iv$iv);
                                                        }
                                                        this_$iv$iv$iv2 = null;
                                                    }
                                                    if (mutableVector4 != null) {
                                                        mutableVector4.add(next$iv$iv);
                                                    }
                                                    count$iv$iv3 = count$iv$iv;
                                                }
                                            } else {
                                                this_$iv$iv$iv = this_$iv$iv$iv3;
                                                i2 = i3;
                                            }
                                            node$iv$iv$iv = node$iv$iv$iv.getChild();
                                            this_$iv$iv$iv3 = this_$iv$iv$iv;
                                            i3 = i2;
                                            z = false;
                                        }
                                        i = i3;
                                        if (count$iv$iv3 == 1) {
                                            count$iv$iv2 = mask$iv$iv;
                                            $this$visitChildren$iv$iv = $this$visitChildren$iv$iv2;
                                            i3 = i;
                                            z = false;
                                        } else {
                                            this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector4);
                                            count$iv$iv2 = mask$iv$iv;
                                            $this$visitChildren$iv$iv = $this$visitChildren$iv$iv2;
                                            i3 = i;
                                            z = false;
                                        }
                                    } else {
                                        i = i3;
                                        this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector4);
                                        count$iv$iv2 = mask$iv$iv;
                                        $this$visitChildren$iv$iv = $this$visitChildren$iv$iv2;
                                        i3 = i;
                                        z = false;
                                    }
                                }
                                z = false;
                            } else {
                                node$iv$iv = node$iv$iv.getChild();
                                z = false;
                            }
                        }
                    } else {
                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                    }
                }
                return false;
            }
            if (nodePop instanceof FocusTargetNode) {
                FocusTargetNode focusTarget2 = (FocusTargetNode) nodePop;
                FocusProperties focusProperties2 = focusTarget2.fetchFocusProperties$ui_release();
                return focusProperties2.getCanFocus() ? FocusTransactionsKt.requestFocus(focusTarget2) : TwoDimensionalFocusSearchKt.m3669findChildCorrespondingToFocusEnterOMvw8(focusTarget2, FocusDirection.INSTANCE.m3635getEnterdhqQ8s(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierNodeKt$requestFocus$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusTargetNode it) {
                        return Boolean.valueOf(FocusTransactionsKt.requestFocus(it));
                    }
                });
            }
            Modifier.Node this_$iv$iv$iv4 = nodePop;
            Modifier.Node this_$iv$iv$iv5 = (this_$iv$iv$iv4.getKindSet() & type$iv3) != 0 ? 1 : null;
            if (this_$iv$iv$iv5 == null || !(nodePop instanceof DelegatingNode)) {
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                type$iv = type$iv3;
                nodePop = DelegatableNodeKt.pop(mutableVector3);
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                type$iv3 = type$iv;
            } else {
                int count$iv$iv4 = 0;
                DelegatingNode this_$iv$iv$iv6 = (DelegatingNode) nodePop;
                Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv6.getDelegate();
                while (node$iv$iv$iv2 != null) {
                    Modifier.Node next$iv$iv2 = node$iv$iv$iv2;
                    if (((next$iv$iv2.getKindSet() & type$iv3) != 0 ? i4 : 0) != 0) {
                        count$iv$iv4++;
                        if (count$iv$iv4 == i4) {
                            nodePop = next$iv$iv2;
                            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                            type$iv2 = type$iv3;
                        } else {
                            if (mutableVector3 == null) {
                                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                type$iv2 = type$iv3;
                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                            } else {
                                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                type$iv2 = type$iv3;
                                mutableVector2 = mutableVector3;
                            }
                            mutableVector3 = mutableVector2;
                            Modifier.Node theNode$iv$iv2 = nodePop;
                            if (theNode$iv$iv2 != null) {
                                if (mutableVector3 != null) {
                                    mutableVector3.add(theNode$iv$iv2);
                                }
                                nodePop = null;
                            }
                            if (mutableVector3 != null) {
                                mutableVector3.add(next$iv$iv2);
                            }
                        }
                    } else {
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                        type$iv2 = type$iv3;
                    }
                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                    type$iv3 = type$iv2;
                    i4 = 1;
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                type$iv = type$iv3;
                if (count$iv$iv4 == 1) {
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    type$iv3 = type$iv;
                } else {
                    nodePop = DelegatableNodeKt.pop(mutableVector3);
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    type$iv3 = type$iv;
                }
            }
        }
    }

    public static final boolean captureFocus(FocusRequesterModifierNode $this$captureFocus) {
        int mask$iv$iv;
        DelegatableNode $this$visitChildren$iv$iv;
        int i;
        int mask$iv$iv2;
        DelegatableNode $this$visitChildren$iv$iv2;
        int i2;
        MutableVector mutableVector;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int type$iv;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int type$iv2;
        MutableVector mutableVector2;
        FocusRequesterModifierNode $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$captureFocus;
        int type$iv3 = NodeKind.m5425constructorimpl(1024);
        int i3 = 0;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3.getNode();
        MutableVector mutableVector3 = null;
        Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        while (true) {
            boolean z = false;
            int i4 = 1;
            if (nodePop == null) {
                DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                int type$iv4 = type$iv3;
                int mask$iv$iv3 = type$iv4;
                DelegatableNode $this$visitChildren$iv$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                if (!$this$visitChildren$iv$iv3.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                }
                MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child$iv$iv = $this$visitChildren$iv$iv3.getNode().getChild();
                if (child$iv$iv == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren$iv$iv3.getNode());
                } else {
                    branches$iv$iv.add(child$iv$iv);
                }
                while (branches$iv$iv.isNotEmpty()) {
                    Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                    if ((branch$iv$iv.getAggregateChildKindSet() & mask$iv$iv3) != 0) {
                        Modifier.Node node$iv$iv = branch$iv$iv;
                        while (true) {
                            if (node$iv$iv == null) {
                                mask$iv$iv3 = mask$iv$iv3;
                                z = false;
                                break;
                            }
                            if ((node$iv$iv.getKindSet() & mask$iv$iv3) != 0) {
                                Modifier.Node it$iv = node$iv$iv;
                                MutableVector mutableVector4 = null;
                                Modifier.Node nodePop2 = it$iv;
                                while (nodePop2 != null) {
                                    if (nodePop2 instanceof FocusTargetNode) {
                                        FocusTargetNode it = (FocusTargetNode) nodePop2;
                                        if (FocusTransactionsKt.captureFocus(it)) {
                                            return true;
                                        }
                                        mask$iv$iv = mask$iv$iv3;
                                        $this$visitChildren$iv$iv = $this$visitChildren$iv$iv3;
                                        i = i3;
                                    } else {
                                        Modifier.Node this_$iv$iv$iv = nodePop2;
                                        if (((this_$iv$iv$iv.getKindSet() & type$iv4) != 0 ? true : z) && (nodePop2 instanceof DelegatingNode)) {
                                            int count$iv$iv = 0;
                                            DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) nodePop2;
                                            Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                            while (node$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                if ((next$iv$iv.getKindSet() & type$iv4) != 0 ? true : z) {
                                                    count$iv$iv++;
                                                    if (count$iv$iv == 1) {
                                                        nodePop2 = next$iv$iv;
                                                        mask$iv$iv2 = mask$iv$iv3;
                                                        $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                        i2 = i3;
                                                    } else {
                                                        if (mutableVector4 == null) {
                                                            mask$iv$iv2 = mask$iv$iv3;
                                                            $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                            i2 = i3;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            mask$iv$iv2 = mask$iv$iv3;
                                                            $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                            i2 = i3;
                                                            mutableVector = mutableVector4;
                                                        }
                                                        mutableVector4 = mutableVector;
                                                        Modifier.Node theNode$iv$iv = nodePop2;
                                                        if (theNode$iv$iv != null) {
                                                            if (mutableVector4 != null) {
                                                                mutableVector4.add(theNode$iv$iv);
                                                            }
                                                            nodePop2 = null;
                                                        }
                                                        if (mutableVector4 != null) {
                                                            mutableVector4.add(next$iv$iv);
                                                        }
                                                    }
                                                } else {
                                                    mask$iv$iv2 = mask$iv$iv3;
                                                    $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                    i2 = i3;
                                                }
                                                node$iv$iv$iv = node$iv$iv$iv.getChild();
                                                mask$iv$iv3 = mask$iv$iv2;
                                                $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv2;
                                                i3 = i2;
                                                z = false;
                                            }
                                            mask$iv$iv = mask$iv$iv3;
                                            $this$visitChildren$iv$iv = $this$visitChildren$iv$iv3;
                                            i = i3;
                                            if (count$iv$iv == 1) {
                                                mask$iv$iv3 = mask$iv$iv;
                                                $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv;
                                                i3 = i;
                                                z = false;
                                            }
                                        } else {
                                            mask$iv$iv = mask$iv$iv3;
                                            $this$visitChildren$iv$iv = $this$visitChildren$iv$iv3;
                                            i = i3;
                                        }
                                    }
                                    nodePop2 = DelegatableNodeKt.pop(mutableVector4);
                                    mask$iv$iv3 = mask$iv$iv;
                                    $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv;
                                    i3 = i;
                                    z = false;
                                }
                                mask$iv$iv3 = mask$iv$iv3;
                                z = false;
                            } else {
                                node$iv$iv = node$iv$iv.getChild();
                                mask$iv$iv3 = mask$iv$iv3;
                                z = false;
                            }
                        }
                    } else {
                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                    }
                }
                return false;
            }
            if (nodePop instanceof FocusTargetNode) {
                FocusTargetNode it2 = (FocusTargetNode) nodePop;
                if (FocusTransactionsKt.captureFocus(it2)) {
                    return true;
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                type$iv = type$iv3;
            } else {
                Modifier.Node this_$iv$iv$iv3 = nodePop;
                Modifier.Node this_$iv$iv$iv4 = (this_$iv$iv$iv3.getKindSet() & type$iv3) != 0 ? 1 : null;
                if (this_$iv$iv$iv4 == null || !(nodePop instanceof DelegatingNode)) {
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    type$iv = type$iv3;
                } else {
                    int count$iv$iv2 = 0;
                    DelegatingNode this_$iv$iv$iv5 = (DelegatingNode) nodePop;
                    Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv5.getDelegate();
                    while (node$iv$iv$iv2 != null) {
                        Modifier.Node next$iv$iv2 = node$iv$iv$iv2;
                        if (((next$iv$iv2.getKindSet() & type$iv3) != 0 ? i4 : 0) != 0) {
                            count$iv$iv2++;
                            if (count$iv$iv2 == i4) {
                                nodePop = next$iv$iv2;
                                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                type$iv2 = type$iv3;
                            } else {
                                if (mutableVector3 == null) {
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    type$iv2 = type$iv3;
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    type$iv2 = type$iv3;
                                    mutableVector2 = mutableVector3;
                                }
                                mutableVector3 = mutableVector2;
                                Modifier.Node theNode$iv$iv2 = nodePop;
                                if (theNode$iv$iv2 != null) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(theNode$iv$iv2);
                                    }
                                    nodePop = null;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(next$iv$iv2);
                                }
                            }
                        } else {
                            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                            type$iv2 = type$iv3;
                        }
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                        type$iv3 = type$iv2;
                        i4 = 1;
                    }
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    type$iv = type$iv3;
                    if (count$iv$iv2 == 1) {
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                        type$iv3 = type$iv;
                    }
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector3);
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            type$iv3 = type$iv;
        }
    }

    public static final boolean freeFocus(FocusRequesterModifierNode $this$freeFocus) {
        int mask$iv$iv;
        DelegatableNode $this$visitChildren$iv$iv;
        int i;
        int mask$iv$iv2;
        DelegatableNode $this$visitChildren$iv$iv2;
        int i2;
        MutableVector mutableVector;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int type$iv;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int type$iv2;
        MutableVector mutableVector2;
        FocusRequesterModifierNode $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$freeFocus;
        int type$iv3 = NodeKind.m5425constructorimpl(1024);
        int i3 = 0;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3.getNode();
        MutableVector mutableVector3 = null;
        Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        while (true) {
            boolean z = false;
            int i4 = 1;
            if (nodePop == null) {
                DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                int type$iv4 = type$iv3;
                int mask$iv$iv3 = type$iv4;
                DelegatableNode $this$visitChildren$iv$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                if (!$this$visitChildren$iv$iv3.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                }
                MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child$iv$iv = $this$visitChildren$iv$iv3.getNode().getChild();
                if (child$iv$iv == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren$iv$iv3.getNode());
                } else {
                    branches$iv$iv.add(child$iv$iv);
                }
                while (branches$iv$iv.isNotEmpty()) {
                    Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                    if ((branch$iv$iv.getAggregateChildKindSet() & mask$iv$iv3) != 0) {
                        Modifier.Node node$iv$iv = branch$iv$iv;
                        while (true) {
                            if (node$iv$iv == null) {
                                mask$iv$iv3 = mask$iv$iv3;
                                z = false;
                                break;
                            }
                            if ((node$iv$iv.getKindSet() & mask$iv$iv3) != 0) {
                                Modifier.Node it$iv = node$iv$iv;
                                MutableVector mutableVector4 = null;
                                Modifier.Node nodePop2 = it$iv;
                                while (nodePop2 != null) {
                                    if (nodePop2 instanceof FocusTargetNode) {
                                        FocusTargetNode it = (FocusTargetNode) nodePop2;
                                        if (FocusTransactionsKt.freeFocus(it)) {
                                            return true;
                                        }
                                        mask$iv$iv = mask$iv$iv3;
                                        $this$visitChildren$iv$iv = $this$visitChildren$iv$iv3;
                                        i = i3;
                                    } else {
                                        Modifier.Node this_$iv$iv$iv = nodePop2;
                                        if (((this_$iv$iv$iv.getKindSet() & type$iv4) != 0 ? true : z) && (nodePop2 instanceof DelegatingNode)) {
                                            int count$iv$iv = 0;
                                            DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) nodePop2;
                                            Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                            while (node$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                if ((next$iv$iv.getKindSet() & type$iv4) != 0 ? true : z) {
                                                    count$iv$iv++;
                                                    if (count$iv$iv == 1) {
                                                        nodePop2 = next$iv$iv;
                                                        mask$iv$iv2 = mask$iv$iv3;
                                                        $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                        i2 = i3;
                                                    } else {
                                                        if (mutableVector4 == null) {
                                                            mask$iv$iv2 = mask$iv$iv3;
                                                            $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                            i2 = i3;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            mask$iv$iv2 = mask$iv$iv3;
                                                            $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                            i2 = i3;
                                                            mutableVector = mutableVector4;
                                                        }
                                                        mutableVector4 = mutableVector;
                                                        Modifier.Node theNode$iv$iv = nodePop2;
                                                        if (theNode$iv$iv != null) {
                                                            if (mutableVector4 != null) {
                                                                mutableVector4.add(theNode$iv$iv);
                                                            }
                                                            nodePop2 = null;
                                                        }
                                                        if (mutableVector4 != null) {
                                                            mutableVector4.add(next$iv$iv);
                                                        }
                                                    }
                                                } else {
                                                    mask$iv$iv2 = mask$iv$iv3;
                                                    $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                    i2 = i3;
                                                }
                                                node$iv$iv$iv = node$iv$iv$iv.getChild();
                                                mask$iv$iv3 = mask$iv$iv2;
                                                $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv2;
                                                i3 = i2;
                                                z = false;
                                            }
                                            mask$iv$iv = mask$iv$iv3;
                                            $this$visitChildren$iv$iv = $this$visitChildren$iv$iv3;
                                            i = i3;
                                            if (count$iv$iv == 1) {
                                                mask$iv$iv3 = mask$iv$iv;
                                                $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv;
                                                i3 = i;
                                                z = false;
                                            }
                                        } else {
                                            mask$iv$iv = mask$iv$iv3;
                                            $this$visitChildren$iv$iv = $this$visitChildren$iv$iv3;
                                            i = i3;
                                        }
                                    }
                                    nodePop2 = DelegatableNodeKt.pop(mutableVector4);
                                    mask$iv$iv3 = mask$iv$iv;
                                    $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv;
                                    i3 = i;
                                    z = false;
                                }
                                mask$iv$iv3 = mask$iv$iv3;
                                z = false;
                            } else {
                                node$iv$iv = node$iv$iv.getChild();
                                mask$iv$iv3 = mask$iv$iv3;
                                z = false;
                            }
                        }
                    } else {
                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                    }
                }
                return false;
            }
            if (nodePop instanceof FocusTargetNode) {
                FocusTargetNode it2 = (FocusTargetNode) nodePop;
                if (FocusTransactionsKt.freeFocus(it2)) {
                    return true;
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                type$iv = type$iv3;
            } else {
                Modifier.Node this_$iv$iv$iv3 = nodePop;
                Modifier.Node this_$iv$iv$iv4 = (this_$iv$iv$iv3.getKindSet() & type$iv3) != 0 ? 1 : null;
                if (this_$iv$iv$iv4 == null || !(nodePop instanceof DelegatingNode)) {
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    type$iv = type$iv3;
                } else {
                    int count$iv$iv2 = 0;
                    DelegatingNode this_$iv$iv$iv5 = (DelegatingNode) nodePop;
                    Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv5.getDelegate();
                    while (node$iv$iv$iv2 != null) {
                        Modifier.Node next$iv$iv2 = node$iv$iv$iv2;
                        if (((next$iv$iv2.getKindSet() & type$iv3) != 0 ? i4 : 0) != 0) {
                            count$iv$iv2++;
                            if (count$iv$iv2 == i4) {
                                nodePop = next$iv$iv2;
                                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                type$iv2 = type$iv3;
                            } else {
                                if (mutableVector3 == null) {
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    type$iv2 = type$iv3;
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    type$iv2 = type$iv3;
                                    mutableVector2 = mutableVector3;
                                }
                                mutableVector3 = mutableVector2;
                                Modifier.Node theNode$iv$iv2 = nodePop;
                                if (theNode$iv$iv2 != null) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(theNode$iv$iv2);
                                    }
                                    nodePop = null;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(next$iv$iv2);
                                }
                            }
                        } else {
                            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                            type$iv2 = type$iv3;
                        }
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                        type$iv3 = type$iv2;
                        i4 = 1;
                    }
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    type$iv = type$iv3;
                    if (count$iv$iv2 == 1) {
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                        type$iv3 = type$iv;
                    }
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector3);
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            type$iv3 = type$iv;
        }
    }

    public static final boolean saveFocusedChild(FocusRequesterModifierNode $this$saveFocusedChild) {
        int mask$iv$iv;
        DelegatableNode $this$visitChildren$iv$iv;
        int i;
        int mask$iv$iv2;
        DelegatableNode $this$visitChildren$iv$iv2;
        int i2;
        MutableVector mutableVector;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int type$iv;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int type$iv2;
        MutableVector mutableVector2;
        FocusRequesterModifierNode $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$saveFocusedChild;
        int type$iv3 = NodeKind.m5425constructorimpl(1024);
        int i3 = 0;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3.getNode();
        MutableVector mutableVector3 = null;
        Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        while (true) {
            boolean z = false;
            int i4 = 1;
            if (nodePop == null) {
                DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                int type$iv4 = type$iv3;
                int mask$iv$iv3 = type$iv4;
                DelegatableNode $this$visitChildren$iv$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                if (!$this$visitChildren$iv$iv3.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                }
                MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child$iv$iv = $this$visitChildren$iv$iv3.getNode().getChild();
                if (child$iv$iv == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren$iv$iv3.getNode());
                } else {
                    branches$iv$iv.add(child$iv$iv);
                }
                while (branches$iv$iv.isNotEmpty()) {
                    Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                    if ((branch$iv$iv.getAggregateChildKindSet() & mask$iv$iv3) != 0) {
                        Modifier.Node node$iv$iv = branch$iv$iv;
                        while (true) {
                            if (node$iv$iv == null) {
                                mask$iv$iv3 = mask$iv$iv3;
                                z = false;
                                break;
                            }
                            if ((node$iv$iv.getKindSet() & mask$iv$iv3) != 0) {
                                Modifier.Node it$iv = node$iv$iv;
                                MutableVector mutableVector4 = null;
                                Modifier.Node nodePop2 = it$iv;
                                while (nodePop2 != null) {
                                    if (nodePop2 instanceof FocusTargetNode) {
                                        FocusTargetNode it = (FocusTargetNode) nodePop2;
                                        if (FocusRestorerKt.saveFocusedChild(it)) {
                                            return true;
                                        }
                                        mask$iv$iv = mask$iv$iv3;
                                        $this$visitChildren$iv$iv = $this$visitChildren$iv$iv3;
                                        i = i3;
                                    } else {
                                        Modifier.Node this_$iv$iv$iv = nodePop2;
                                        if (((this_$iv$iv$iv.getKindSet() & type$iv4) != 0 ? true : z) && (nodePop2 instanceof DelegatingNode)) {
                                            int count$iv$iv = 0;
                                            DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) nodePop2;
                                            Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                            while (node$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                if ((next$iv$iv.getKindSet() & type$iv4) != 0 ? true : z) {
                                                    count$iv$iv++;
                                                    if (count$iv$iv == 1) {
                                                        nodePop2 = next$iv$iv;
                                                        mask$iv$iv2 = mask$iv$iv3;
                                                        $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                        i2 = i3;
                                                    } else {
                                                        if (mutableVector4 == null) {
                                                            mask$iv$iv2 = mask$iv$iv3;
                                                            $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                            i2 = i3;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            mask$iv$iv2 = mask$iv$iv3;
                                                            $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                            i2 = i3;
                                                            mutableVector = mutableVector4;
                                                        }
                                                        mutableVector4 = mutableVector;
                                                        Modifier.Node theNode$iv$iv = nodePop2;
                                                        if (theNode$iv$iv != null) {
                                                            if (mutableVector4 != null) {
                                                                mutableVector4.add(theNode$iv$iv);
                                                            }
                                                            nodePop2 = null;
                                                        }
                                                        if (mutableVector4 != null) {
                                                            mutableVector4.add(next$iv$iv);
                                                        }
                                                    }
                                                } else {
                                                    mask$iv$iv2 = mask$iv$iv3;
                                                    $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                    i2 = i3;
                                                }
                                                node$iv$iv$iv = node$iv$iv$iv.getChild();
                                                mask$iv$iv3 = mask$iv$iv2;
                                                $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv2;
                                                i3 = i2;
                                                z = false;
                                            }
                                            mask$iv$iv = mask$iv$iv3;
                                            $this$visitChildren$iv$iv = $this$visitChildren$iv$iv3;
                                            i = i3;
                                            if (count$iv$iv == 1) {
                                                mask$iv$iv3 = mask$iv$iv;
                                                $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv;
                                                i3 = i;
                                                z = false;
                                            }
                                        } else {
                                            mask$iv$iv = mask$iv$iv3;
                                            $this$visitChildren$iv$iv = $this$visitChildren$iv$iv3;
                                            i = i3;
                                        }
                                    }
                                    nodePop2 = DelegatableNodeKt.pop(mutableVector4);
                                    mask$iv$iv3 = mask$iv$iv;
                                    $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv;
                                    i3 = i;
                                    z = false;
                                }
                                mask$iv$iv3 = mask$iv$iv3;
                                z = false;
                            } else {
                                node$iv$iv = node$iv$iv.getChild();
                                mask$iv$iv3 = mask$iv$iv3;
                                z = false;
                            }
                        }
                    } else {
                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                    }
                }
                return false;
            }
            if (nodePop instanceof FocusTargetNode) {
                FocusTargetNode it2 = (FocusTargetNode) nodePop;
                if (FocusRestorerKt.saveFocusedChild(it2)) {
                    return true;
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                type$iv = type$iv3;
            } else {
                Modifier.Node this_$iv$iv$iv3 = nodePop;
                Modifier.Node this_$iv$iv$iv4 = (this_$iv$iv$iv3.getKindSet() & type$iv3) != 0 ? 1 : null;
                if (this_$iv$iv$iv4 == null || !(nodePop instanceof DelegatingNode)) {
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    type$iv = type$iv3;
                } else {
                    int count$iv$iv2 = 0;
                    DelegatingNode this_$iv$iv$iv5 = (DelegatingNode) nodePop;
                    Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv5.getDelegate();
                    while (node$iv$iv$iv2 != null) {
                        Modifier.Node next$iv$iv2 = node$iv$iv$iv2;
                        if (((next$iv$iv2.getKindSet() & type$iv3) != 0 ? i4 : 0) != 0) {
                            count$iv$iv2++;
                            if (count$iv$iv2 == i4) {
                                nodePop = next$iv$iv2;
                                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                type$iv2 = type$iv3;
                            } else {
                                if (mutableVector3 == null) {
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    type$iv2 = type$iv3;
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    type$iv2 = type$iv3;
                                    mutableVector2 = mutableVector3;
                                }
                                mutableVector3 = mutableVector2;
                                Modifier.Node theNode$iv$iv2 = nodePop;
                                if (theNode$iv$iv2 != null) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(theNode$iv$iv2);
                                    }
                                    nodePop = null;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(next$iv$iv2);
                                }
                            }
                        } else {
                            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                            type$iv2 = type$iv3;
                        }
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                        type$iv3 = type$iv2;
                        i4 = 1;
                    }
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    type$iv = type$iv3;
                    if (count$iv$iv2 == 1) {
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                        type$iv3 = type$iv;
                    }
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector3);
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            type$iv3 = type$iv;
        }
    }

    public static final boolean restoreFocusedChild(FocusRequesterModifierNode $this$restoreFocusedChild) {
        int mask$iv$iv;
        DelegatableNode $this$visitChildren$iv$iv;
        int i;
        int mask$iv$iv2;
        DelegatableNode $this$visitChildren$iv$iv2;
        int i2;
        MutableVector mutableVector;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int type$iv;
        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int type$iv2;
        MutableVector mutableVector2;
        FocusRequesterModifierNode $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$restoreFocusedChild;
        int type$iv3 = NodeKind.m5425constructorimpl(1024);
        int i3 = 0;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3.getNode();
        MutableVector mutableVector3 = null;
        Modifier.Node nodePop = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        while (true) {
            boolean z = false;
            int i4 = 1;
            if (nodePop == null) {
                DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                int type$iv4 = type$iv3;
                int mask$iv$iv3 = type$iv4;
                DelegatableNode $this$visitChildren$iv$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                if (!$this$visitChildren$iv$iv3.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                }
                MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child$iv$iv = $this$visitChildren$iv$iv3.getNode().getChild();
                if (child$iv$iv == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren$iv$iv3.getNode());
                } else {
                    branches$iv$iv.add(child$iv$iv);
                }
                while (branches$iv$iv.isNotEmpty()) {
                    Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                    if ((branch$iv$iv.getAggregateChildKindSet() & mask$iv$iv3) != 0) {
                        Modifier.Node node$iv$iv = branch$iv$iv;
                        while (true) {
                            if (node$iv$iv == null) {
                                mask$iv$iv3 = mask$iv$iv3;
                                z = false;
                                break;
                            }
                            if ((node$iv$iv.getKindSet() & mask$iv$iv3) != 0) {
                                Modifier.Node it$iv = node$iv$iv;
                                MutableVector mutableVector4 = null;
                                Modifier.Node nodePop2 = it$iv;
                                while (nodePop2 != null) {
                                    if (nodePop2 instanceof FocusTargetNode) {
                                        FocusTargetNode it = (FocusTargetNode) nodePop2;
                                        if (FocusRestorerKt.restoreFocusedChild(it)) {
                                            return true;
                                        }
                                        mask$iv$iv = mask$iv$iv3;
                                        $this$visitChildren$iv$iv = $this$visitChildren$iv$iv3;
                                        i = i3;
                                    } else {
                                        Modifier.Node this_$iv$iv$iv = nodePop2;
                                        if (((this_$iv$iv$iv.getKindSet() & type$iv4) != 0 ? true : z) && (nodePop2 instanceof DelegatingNode)) {
                                            int count$iv$iv = 0;
                                            DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) nodePop2;
                                            Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                            while (node$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                if ((next$iv$iv.getKindSet() & type$iv4) != 0 ? true : z) {
                                                    count$iv$iv++;
                                                    if (count$iv$iv == 1) {
                                                        nodePop2 = next$iv$iv;
                                                        mask$iv$iv2 = mask$iv$iv3;
                                                        $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                        i2 = i3;
                                                    } else {
                                                        if (mutableVector4 == null) {
                                                            mask$iv$iv2 = mask$iv$iv3;
                                                            $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                            i2 = i3;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            mask$iv$iv2 = mask$iv$iv3;
                                                            $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                            i2 = i3;
                                                            mutableVector = mutableVector4;
                                                        }
                                                        mutableVector4 = mutableVector;
                                                        Modifier.Node theNode$iv$iv = nodePop2;
                                                        if (theNode$iv$iv != null) {
                                                            if (mutableVector4 != null) {
                                                                mutableVector4.add(theNode$iv$iv);
                                                            }
                                                            nodePop2 = null;
                                                        }
                                                        if (mutableVector4 != null) {
                                                            mutableVector4.add(next$iv$iv);
                                                        }
                                                    }
                                                } else {
                                                    mask$iv$iv2 = mask$iv$iv3;
                                                    $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv3;
                                                    i2 = i3;
                                                }
                                                node$iv$iv$iv = node$iv$iv$iv.getChild();
                                                mask$iv$iv3 = mask$iv$iv2;
                                                $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv2;
                                                i3 = i2;
                                                z = false;
                                            }
                                            mask$iv$iv = mask$iv$iv3;
                                            $this$visitChildren$iv$iv = $this$visitChildren$iv$iv3;
                                            i = i3;
                                            if (count$iv$iv == 1) {
                                                mask$iv$iv3 = mask$iv$iv;
                                                $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv;
                                                i3 = i;
                                                z = false;
                                            }
                                        } else {
                                            mask$iv$iv = mask$iv$iv3;
                                            $this$visitChildren$iv$iv = $this$visitChildren$iv$iv3;
                                            i = i3;
                                        }
                                    }
                                    nodePop2 = DelegatableNodeKt.pop(mutableVector4);
                                    mask$iv$iv3 = mask$iv$iv;
                                    $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv;
                                    i3 = i;
                                    z = false;
                                }
                                mask$iv$iv3 = mask$iv$iv3;
                                z = false;
                            } else {
                                node$iv$iv = node$iv$iv.getChild();
                                mask$iv$iv3 = mask$iv$iv3;
                                z = false;
                            }
                        }
                    } else {
                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                    }
                }
                return false;
            }
            if (nodePop instanceof FocusTargetNode) {
                FocusTargetNode it2 = (FocusTargetNode) nodePop;
                if (FocusRestorerKt.restoreFocusedChild(it2)) {
                    return true;
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                type$iv = type$iv3;
            } else {
                Modifier.Node this_$iv$iv$iv3 = nodePop;
                Modifier.Node this_$iv$iv$iv4 = (this_$iv$iv$iv3.getKindSet() & type$iv3) != 0 ? 1 : null;
                if (this_$iv$iv$iv4 == null || !(nodePop instanceof DelegatingNode)) {
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    type$iv = type$iv3;
                } else {
                    int count$iv$iv2 = 0;
                    DelegatingNode this_$iv$iv$iv5 = (DelegatingNode) nodePop;
                    Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv5.getDelegate();
                    while (node$iv$iv$iv2 != null) {
                        Modifier.Node next$iv$iv2 = node$iv$iv$iv2;
                        if (((next$iv$iv2.getKindSet() & type$iv3) != 0 ? i4 : 0) != 0) {
                            count$iv$iv2++;
                            if (count$iv$iv2 == i4) {
                                nodePop = next$iv$iv2;
                                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                type$iv2 = type$iv3;
                            } else {
                                if (mutableVector3 == null) {
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    type$iv2 = type$iv3;
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                                    type$iv2 = type$iv3;
                                    mutableVector2 = mutableVector3;
                                }
                                mutableVector3 = mutableVector2;
                                Modifier.Node theNode$iv$iv2 = nodePop;
                                if (theNode$iv$iv2 != null) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(theNode$iv$iv2);
                                    }
                                    nodePop = null;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(next$iv$iv2);
                                }
                            }
                        } else {
                            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                            type$iv2 = type$iv3;
                        }
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                        type$iv3 = type$iv2;
                        i4 = 1;
                    }
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                    type$iv = type$iv3;
                    if (count$iv$iv2 == 1) {
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                        type$iv3 = type$iv;
                    }
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector3);
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            type$iv3 = type$iv;
        }
    }
}
