package androidx.compose.foundation.text;

import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* compiled from: BasicText.kt */
@Metadata(m164d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, m165d2 = {"Landroidx/compose/foundation/text/TextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "placements", "Lkotlin/Function0;", "", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class TextMeasurePolicy implements MeasurePolicy {
    private final Function0<List<Rect>> placements;

    /* JADX WARN: Multi-variable type inference failed */
    public TextMeasurePolicy(Function0<? extends List<Rect>> function0) {
        this.placements = function0;
    }

    @Override // androidx.compose.p000ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo243measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> list, long constraints) {
        final ArrayList toPlace;
        List $this$fastMapIndexedNotNull$iv;
        int $i$f$fastMapIndexedNotNull;
        ArrayList target$iv;
        Pair pair;
        List $this$fastMapIndexedNotNull$iv2 = this.placements.invoke();
        if ($this$fastMapIndexedNotNull$iv2 == null) {
            toPlace = null;
        } else {
            int $i$f$fastMapIndexedNotNull2 = 0;
            ArrayList target$iv2 = new ArrayList($this$fastMapIndexedNotNull$iv2.size());
            int index$iv$iv = 0;
            int size = $this$fastMapIndexedNotNull$iv2.size();
            while (index$iv$iv < size) {
                Object item$iv$iv = $this$fastMapIndexedNotNull$iv2.get(index$iv$iv);
                int index$iv = index$iv$iv;
                Rect rect = (Rect) item$iv$iv;
                if (rect != null) {
                    $this$fastMapIndexedNotNull$iv = $this$fastMapIndexedNotNull$iv2;
                    $i$f$fastMapIndexedNotNull = $i$f$fastMapIndexedNotNull2;
                    target$iv = target$iv2;
                    pair = new Pair(list.get(index$iv).mo5219measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) Math.floor(rect.getWidth()), 0, (int) Math.floor(rect.getHeight()), 5, null)), IntOffset.m6416boximpl(IntOffsetKt.IntOffset(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()))));
                } else {
                    $this$fastMapIndexedNotNull$iv = $this$fastMapIndexedNotNull$iv2;
                    $i$f$fastMapIndexedNotNull = $i$f$fastMapIndexedNotNull2;
                    target$iv = target$iv2;
                    pair = null;
                }
                if (pair != null) {
                    target$iv.add(pair);
                }
                index$iv$iv++;
                $this$fastMapIndexedNotNull$iv2 = $this$fastMapIndexedNotNull$iv;
                $i$f$fastMapIndexedNotNull2 = $i$f$fastMapIndexedNotNull;
                target$iv2 = target$iv;
            }
            toPlace = target$iv2;
        }
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, Constraints.m6253getMaxWidthimpl(constraints), Constraints.m6252getMaxHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextMeasurePolicy$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope $this$layout) {
                List $this$fastForEach$iv = toPlace;
                if ($this$fastForEach$iv == null) {
                    return;
                }
                int size2 = $this$fastForEach$iv.size();
                for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                    Object item$iv = $this$fastForEach$iv.get(index$iv2);
                    Pair<Placeable, IntOffset> pair2 = (Pair) item$iv;
                    Placeable placeable = pair2.component1();
                    long position = pair2.component2().getPackedValue();
                    Placeable.PlacementScope.m5270place70tqf50$default($this$layout, placeable, position, 0.0f, 2, null);
                }
            }
        }, 4, null);
    }
}
