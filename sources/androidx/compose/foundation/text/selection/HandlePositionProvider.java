package androidx.compose.foundation.text.selection;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.IntRect;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.p000ui.window.PopupPositionProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.math.MathKt;

/* compiled from: AndroidSelectionHandles.android.kt */
@Metadata(m164d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, m165d2 = {"Landroidx/compose/foundation/text/selection/HandlePositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "handleReferencePoint", "Landroidx/compose/foundation/text/selection/HandleReferencePoint;", "positionProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "(Landroidx/compose/foundation/text/selection/HandleReferencePoint;Landroidx/compose/foundation/text/selection/OffsetProvider;)V", "prevPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class HandlePositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final HandleReferencePoint handleReferencePoint;
    private final OffsetProvider positionProvider;
    private long prevPosition = Offset.INSTANCE.m3724getZeroF1C5BW0();

    /* compiled from: AndroidSelectionHandles.android.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HandleReferencePoint.values().length];
            try {
                iArr[HandleReferencePoint.TopLeft.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[HandleReferencePoint.TopMiddle.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[HandleReferencePoint.TopRight.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HandlePositionProvider(HandleReferencePoint handleReferencePoint, OffsetProvider positionProvider) {
        this.handleReferencePoint = handleReferencePoint;
        this.positionProvider = positionProvider;
    }

    @Override // androidx.compose.p000ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long mo1192calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        int xAdjustment;
        long $this$takeOrElse_u2d3MmeM6k$iv = this.positionProvider.mo1040provideF1C5BW0();
        if (!OffsetKt.m3727isSpecifiedk4lQ0M($this$takeOrElse_u2d3MmeM6k$iv)) {
            $this$takeOrElse_u2d3MmeM6k$iv = this.prevPosition;
        }
        this.prevPosition = $this$takeOrElse_u2d3MmeM6k$iv;
        switch (WhenMappings.$EnumSwitchMapping$0[this.handleReferencePoint.ordinal()]) {
            case 1:
                xAdjustment = 0;
                break;
            case 2:
                xAdjustment = IntSize.m6467getWidthimpl(popupContentSize) / 2;
                break;
            case 3:
                xAdjustment = IntSize.m6467getWidthimpl(popupContentSize);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        long $this$round_u2dk_u2d4lQ0M$iv = $this$takeOrElse_u2d3MmeM6k$iv;
        long $this$round_u2dk_u2d4lQ0M$iv2 = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m3708getXimpl($this$round_u2dk_u2d4lQ0M$iv)), MathKt.roundToInt(Offset.m3709getYimpl($this$round_u2dk_u2d4lQ0M$iv)));
        int x = (anchorBounds.getLeft() + IntOffset.m6425getXimpl($this$round_u2dk_u2d4lQ0M$iv2)) - xAdjustment;
        int y = anchorBounds.getTop() + IntOffset.m6426getYimpl($this$round_u2dk_u2d4lQ0M$iv2);
        return IntOffsetKt.IntOffset(x, y);
    }
}
