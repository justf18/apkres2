package androidx.compose.p000ui.platform;

import androidx.compose.p000ui.semantics.SemanticsNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Comparisons.kt */
@Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m165d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2 */
/* loaded from: classes.dex */
public final class C1833xaf6f85ce<T> implements Comparator {
    final /* synthetic */ Comparator $this_thenBy;

    public C1833xaf6f85ce(Comparator comparator) {
        this.$this_thenBy = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int previousCompare = this.$this_thenBy.compare(t, t2);
        if (previousCompare != 0) {
            return previousCompare;
        }
        SemanticsNode it = (SemanticsNode) t;
        Integer numValueOf = Integer.valueOf(it.getId());
        SemanticsNode it2 = (SemanticsNode) t2;
        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(it2.getId()));
    }
}
