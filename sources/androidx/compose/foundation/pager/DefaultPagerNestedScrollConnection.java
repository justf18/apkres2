package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p000ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.ranges.RangesKt;

/* compiled from: Pager.kt */
@Metadata(m164d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001a\u001a\u00020\f*\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, m165d2 = {"Landroidx/compose/foundation/pager/DefaultPagerNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/foundation/pager/PagerState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "consumeOnOrientation", "consumeOnOrientation-8S9VItk", "(JLandroidx/compose/foundation/gestures/Orientation;)J", "consumeOnOrientation-QWom1Mo", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class DefaultPagerNestedScrollConnection implements NestedScrollConnection {
    private final Orientation orientation;
    private final PagerState state;

    public DefaultPagerNestedScrollConnection(PagerState state, Orientation orientation) {
        this.state = state;
        this.orientation = orientation;
    }

    public final PagerState getState() {
        return this.state;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* renamed from: consumeOnOrientation-QWom1Mo, reason: not valid java name */
    public final long m988consumeOnOrientationQWom1Mo(long $this$consumeOnOrientation_u2dQWom1Mo, Orientation orientation) {
        if (orientation == Orientation.Vertical) {
            return Velocity.m6528copyOhffZ5M$default($this$consumeOnOrientation_u2dQWom1Mo, 0.0f, 0.0f, 2, null);
        }
        return Velocity.m6528copyOhffZ5M$default($this$consumeOnOrientation_u2dQWom1Mo, 0.0f, 0.0f, 1, null);
    }

    /* renamed from: consumeOnOrientation-8S9VItk, reason: not valid java name */
    public final long m987consumeOnOrientation8S9VItk(long $this$consumeOnOrientation_u2d8S9VItk, Orientation orientation) {
        if (orientation == Orientation.Vertical) {
            return Offset.m3702copydBAh8RU$default($this$consumeOnOrientation_u2d8S9VItk, 0.0f, 0.0f, 2, null);
        }
        return Offset.m3702copydBAh8RU$default($this$consumeOnOrientation_u2d8S9VItk, 0.0f, 0.0f, 1, null);
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo606onPreScrollOzD1aCk(long available, int source) {
        float minBound;
        float maxBound;
        if (NestedScrollSource.m4982equalsimpl0(source, NestedScrollSource.INSTANCE.m4987getDragWNlRxjI()) && Math.abs(this.state.getCurrentPageOffsetFraction()) > 0.0d) {
            float currentPageOffset = this.state.getCurrentPageOffsetFraction() * this.state.getPageSize$foundation_release();
            int pageAvailableSpace = this.state.getLayoutInfo().getPageSize() + this.state.getLayoutInfo().getPageSpacing();
            float nextClosestPageOffset = (pageAvailableSpace * (-Math.signum(this.state.getCurrentPageOffsetFraction()))) + currentPageOffset;
            if (this.state.getCurrentPageOffsetFraction() > 0.0f) {
                minBound = nextClosestPageOffset;
                maxBound = currentPageOffset;
            } else {
                minBound = currentPageOffset;
                maxBound = nextClosestPageOffset;
            }
            float delta = this.orientation == Orientation.Horizontal ? Offset.m3708getXimpl(available) : Offset.m3709getYimpl(available);
            float coerced = RangesKt.coerceIn(delta, minBound, maxBound);
            float consumed = -this.state.dispatchRawDelta(-coerced);
            return Offset.m3701copydBAh8RU(available, this.orientation == Orientation.Horizontal ? consumed : Offset.m3708getXimpl(available), this.orientation == Orientation.Vertical ? consumed : Offset.m3709getYimpl(available));
        }
        return Offset.INSTANCE.m3724getZeroF1C5BW0();
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo605onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (NestedScrollSource.m4982equalsimpl0(source, NestedScrollSource.INSTANCE.m4988getFlingWNlRxjI()) && !Offset.m3705equalsimpl0(available, Offset.INSTANCE.m3724getZeroF1C5BW0())) {
            throw new CancellationException();
        }
        return Offset.INSTANCE.m3724getZeroF1C5BW0();
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    public Object mo604onPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> continuation) {
        return Velocity.m6523boximpl(m988consumeOnOrientationQWom1Mo(available, this.orientation));
    }
}
