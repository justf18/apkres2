package androidx.compose.p000ui.platform;

import androidx.compose.p000ui.geometry.CornerRadius;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.geometry.RoundRect;
import androidx.compose.p000ui.graphics.AndroidPath_androidKt;
import androidx.compose.p000ui.graphics.Outline;
import androidx.compose.p000ui.graphics.Path;
import androidx.compose.p000ui.graphics.PathOperation;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: ShapeContainingUtil.kt */
@Metadata(m164d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0000\u001a4\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u001a \u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a4\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0002\u001a:\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u001bH\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, m165d2 = {"isInOutline", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "x", "", "y", "tmpTouchPointPath", "Landroidx/compose/ui/graphics/Path;", "tmpOpPath", "isInPath", "path", "isInRectangle", "rect", "Landroidx/compose/ui/geometry/Rect;", "isInRoundedRect", "Landroidx/compose/ui/graphics/Outline$Rounded;", "touchPointPath", "opPath", "isWithinEllipse", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "centerX", "centerY", "isWithinEllipse-VE1yxkc", "(FFJFF)Z", "cornersFit", "Landroidx/compose/ui/geometry/RoundRect;", "ui_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ShapeContainingUtilKt {
    public static /* synthetic */ boolean isInOutline$default(Outline outline, float f, float f2, Path path, Path path2, int i, Object obj) {
        if ((i & 8) != 0) {
            path = null;
        }
        if ((i & 16) != 0) {
            path2 = null;
        }
        return isInOutline(outline, f, f2, path, path2);
    }

    public static final boolean isInOutline(Outline outline, float x, float y, Path tmpTouchPointPath, Path tmpOpPath) {
        if (outline instanceof Outline.Rectangle) {
            return isInRectangle(((Outline.Rectangle) outline).getRect(), x, y);
        }
        if (outline instanceof Outline.Rounded) {
            return isInRoundedRect((Outline.Rounded) outline, x, y, tmpTouchPointPath, tmpOpPath);
        }
        if (outline instanceof Outline.Generic) {
            return isInPath(((Outline.Generic) outline).getPath(), x, y, tmpTouchPointPath, tmpOpPath);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean isInRectangle(Rect rect, float x, float y) {
        return rect.getLeft() <= x && x < rect.getRight() && rect.getTop() <= y && y < rect.getBottom();
    }

    private static final boolean isInRoundedRect(Outline.Rounded outline, float x, float y, Path touchPointPath, Path opPath) {
        RoundRect rrect = outline.getRoundRect();
        if (x < rrect.getLeft() || x >= rrect.getRight() || y < rrect.getTop()) {
            return false;
        }
        if (y >= rrect.getBottom()) {
            return false;
        }
        if (!cornersFit(rrect)) {
            Path path = opPath == null ? AndroidPath_androidKt.Path() : opPath;
            path.addRoundRect(rrect);
            return isInPath(path, x, y, touchPointPath, opPath);
        }
        float topLeftX = rrect.getLeft() + CornerRadius.m3683getXimpl(rrect.m3758getTopLeftCornerRadiuskKHJgLs());
        float topLeftY = rrect.getTop() + CornerRadius.m3684getYimpl(rrect.m3758getTopLeftCornerRadiuskKHJgLs());
        float topRightX = rrect.getRight() - CornerRadius.m3683getXimpl(rrect.m3759getTopRightCornerRadiuskKHJgLs());
        float topRightY = rrect.getTop() + CornerRadius.m3684getYimpl(rrect.m3759getTopRightCornerRadiuskKHJgLs());
        float bottomRightX = rrect.getRight() - CornerRadius.m3683getXimpl(rrect.m3757getBottomRightCornerRadiuskKHJgLs());
        float bottomRightY = rrect.getBottom() - CornerRadius.m3684getYimpl(rrect.m3757getBottomRightCornerRadiuskKHJgLs());
        float bottomLeftX = rrect.getBottom() - CornerRadius.m3684getYimpl(rrect.m3756getBottomLeftCornerRadiuskKHJgLs());
        float bottomLeftY = rrect.getLeft() + CornerRadius.m3683getXimpl(rrect.m3756getBottomLeftCornerRadiuskKHJgLs());
        if (x < topLeftX && y < topLeftY) {
            return m5576isWithinEllipseVE1yxkc(x, y, rrect.m3758getTopLeftCornerRadiuskKHJgLs(), topLeftX, topLeftY);
        }
        if (x < bottomLeftY && y > bottomLeftX) {
            return m5576isWithinEllipseVE1yxkc(x, y, rrect.m3756getBottomLeftCornerRadiuskKHJgLs(), bottomLeftY, bottomLeftX);
        }
        if (x > topRightX && y < topRightY) {
            return m5576isWithinEllipseVE1yxkc(x, y, rrect.m3759getTopRightCornerRadiuskKHJgLs(), topRightX, topRightY);
        }
        if (x > bottomRightX && y > bottomRightY) {
            return m5576isWithinEllipseVE1yxkc(x, y, rrect.m3757getBottomRightCornerRadiuskKHJgLs(), bottomRightX, bottomRightY);
        }
        return true;
    }

    private static final boolean cornersFit(RoundRect $this$cornersFit) {
        return CornerRadius.m3683getXimpl($this$cornersFit.m3758getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m3683getXimpl($this$cornersFit.m3759getTopRightCornerRadiuskKHJgLs()) <= $this$cornersFit.getWidth() && CornerRadius.m3683getXimpl($this$cornersFit.m3756getBottomLeftCornerRadiuskKHJgLs()) + CornerRadius.m3683getXimpl($this$cornersFit.m3757getBottomRightCornerRadiuskKHJgLs()) <= $this$cornersFit.getWidth() && CornerRadius.m3684getYimpl($this$cornersFit.m3758getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m3684getYimpl($this$cornersFit.m3756getBottomLeftCornerRadiuskKHJgLs()) <= $this$cornersFit.getHeight() && CornerRadius.m3684getYimpl($this$cornersFit.m3759getTopRightCornerRadiuskKHJgLs()) + CornerRadius.m3684getYimpl($this$cornersFit.m3757getBottomRightCornerRadiuskKHJgLs()) <= $this$cornersFit.getHeight();
    }

    /* renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    private static final boolean m5576isWithinEllipseVE1yxkc(float x, float y, long cornerRadius, float centerX, float centerY) {
        float px = x - centerX;
        float py = y - centerY;
        float radiusX = CornerRadius.m3683getXimpl(cornerRadius);
        float radiusY = CornerRadius.m3684getYimpl(cornerRadius);
        return ((px * px) / (radiusX * radiusX)) + ((py * py) / (radiusY * radiusY)) <= 1.0f;
    }

    private static final boolean isInPath(Path path, float x, float y, Path tmpTouchPointPath, Path tmpOpPath) {
        Rect rect = new Rect(x - 0.005f, y - 0.005f, x + 0.005f, 0.005f + y);
        Path touchPointPath = tmpTouchPointPath == null ? AndroidPath_androidKt.Path() : tmpTouchPointPath;
        touchPointPath.addRect(rect);
        Path opPath = tmpOpPath == null ? AndroidPath_androidKt.Path() : tmpOpPath;
        opPath.mo3841opN5in7k0(path, touchPointPath, PathOperation.INSTANCE.m4241getIntersectb3I0S0c());
        boolean isClipped = opPath.isEmpty();
        opPath.reset();
        touchPointPath.reset();
        return !isClipped;
    }
}
