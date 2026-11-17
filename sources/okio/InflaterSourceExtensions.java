package okio;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InflaterSource.kt */
@Metadata(m164d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, m165d2 = {"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "okio"}, m166k = 2, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: okio.-InflaterSourceExtensions, reason: invalid class name */
/* loaded from: classes5.dex */
public final class InflaterSourceExtensions {
    public static /* synthetic */ InflaterSource inflate$default(Source $this$inflate_u24default, Inflater inflater, int i, Object obj) {
        if ((i & 1) != 0) {
            inflater = new Inflater();
        }
        Intrinsics.checkNotNullParameter($this$inflate_u24default, "<this>");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return new InflaterSource($this$inflate_u24default, inflater);
    }

    public static final InflaterSource inflate(Source $this$inflate, Inflater inflater) {
        Intrinsics.checkNotNullParameter($this$inflate, "<this>");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return new InflaterSource($this$inflate, inflater);
    }
}
