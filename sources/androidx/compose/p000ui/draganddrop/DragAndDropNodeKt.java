package androidx.compose.p000ui.draganddrop;

import androidx.autofill.HintConstants;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutCoordinatesKt;
import androidx.compose.p000ui.node.DelegatableNodeKt;
import androidx.compose.p000ui.unit.IntSize;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: DragAndDropNode.kt */
@Metadata(m164d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a1\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\n\u001a\u001e\u0010\u000b\u001a\u00020\b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, m165d2 = {"DragAndDropModifierNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "shouldStartDragAndDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, NotificationCompat.CATEGORY_EVENT, "", TypedValues.AttributesType.S_TARGET, "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "contains", "position", "Landroidx/compose/ui/geometry/Offset;", "contains-Uv8p0NA", "(Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;J)Z", "dispatchEntered", "", "ui_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DragAndDropNodeKt {
    public static final DragAndDropModifierNode DragAndDropModifierNode() {
        return new DragAndDropNode(new Function1<DragAndDropEvent, DragAndDropTarget>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNodeKt.DragAndDropModifierNode.1
            @Override // kotlin.jvm.functions.Function1
            public final DragAndDropTarget invoke(DragAndDropEvent it) {
                return null;
            }
        });
    }

    public static final DragAndDropModifierNode DragAndDropModifierNode(final Function1<? super DragAndDropEvent, Boolean> function1, final DragAndDropTarget target) {
        return new DragAndDropNode(new Function1<DragAndDropEvent, DragAndDropTarget>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNodeKt.DragAndDropModifierNode.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DragAndDropTarget invoke(DragAndDropEvent startEvent) {
                if (function1.invoke(startEvent).booleanValue()) {
                    return target;
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchEntered(DragAndDropTarget $this$dispatchEntered, DragAndDropEvent event) {
        $this$dispatchEntered.onEntered(event);
        $this$dispatchEntered.onMoved(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: contains-Uv8p0NA, reason: not valid java name */
    public static final boolean m3600containsUv8p0NA(DragAndDropModifierNode $this$contains_u2dUv8p0NA, long position) {
        if (!$this$contains_u2dUv8p0NA.getNode().getIsAttached()) {
            return false;
        }
        LayoutCoordinates currentCoordinates = DelegatableNodeKt.requireLayoutNode($this$contains_u2dUv8p0NA).getCoordinates();
        if (!currentCoordinates.isAttached()) {
            return false;
        }
        long jMo5226getSizeYbymL2g = currentCoordinates.mo5226getSizeYbymL2g();
        int iM6467getWidthimpl = IntSize.m6467getWidthimpl(jMo5226getSizeYbymL2g);
        int height = IntSize.m6466getHeightimpl(jMo5226getSizeYbymL2g);
        long jPositionInRoot = LayoutCoordinatesKt.positionInRoot(currentCoordinates);
        float x1 = Offset.m3698component1impl(jPositionInRoot);
        float y1 = Offset.m3699component2impl(jPositionInRoot);
        float x2 = iM6467getWidthimpl + x1;
        float y2 = height + y1;
        float fM3708getXimpl = Offset.m3708getXimpl(position);
        if (!(x1 <= fM3708getXimpl && fM3708getXimpl <= x2)) {
            return false;
        }
        float fM3709getYimpl = Offset.m3709getYimpl(position);
        return (y1 > fM3709getYimpl ? 1 : (y1 == fM3709getYimpl ? 0 : -1)) <= 0 && (fM3709getYimpl > y2 ? 1 : (fM3709getYimpl == y2 ? 0 : -1)) <= 0;
    }
}
