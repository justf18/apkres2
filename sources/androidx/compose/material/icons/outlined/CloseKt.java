package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.graphics.StrokeCap;
import androidx.compose.p000ui.graphics.StrokeJoin;
import androidx.compose.p000ui.graphics.vector.ImageVector;
import androidx.compose.p000ui.graphics.vector.PathBuilder;
import androidx.compose.p000ui.graphics.vector.VectorKt;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Close.kt */
@Metadata(m164d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m165d2 = {"_close", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Close", "Landroidx/compose/material/icons/Icons$Outlined;", "getClose", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CloseKt {
    private static ImageVector _close;

    public static final ImageVector getClose(Icons.Outlined $this$Close) {
        if (_close != null) {
            ImageVector imageVector = _close;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        float $this$dp$iv$iv = C1956Dp.m6297constructorimpl(24.0f);
        float $this$dp$iv$iv2 = C1956Dp.m6297constructorimpl(24.0f);
        ImageVector.Builder $this$_get_Close__u24lambda_u241 = new ImageVector.Builder("Outlined.Close", $this$dp$iv$iv, $this$dp$iv$iv2, 24.0f, 24.0f, 0L, 0, false, 96, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m3975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m4301getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m4311getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(19.0f, 6.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(17.59f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 10.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.41f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(5.0f, 6.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(10.59f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(5.0f, 17.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.41f, 19.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 13.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(17.59f, 19.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(19.0f, 17.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(13.41f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(19.0f, 6.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        _close = ImageVector.Builder.m4582addPathoIyEayM$default($this$_get_Close__u24lambda_u241, $this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), pathFillType$iv, "", fill$iv$iv, 1.0f, null, 1.0f, 1.0f, strokeLineCap$iv$iv, strokeLineJoin$iv$iv, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        ImageVector imageVector2 = _close;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
