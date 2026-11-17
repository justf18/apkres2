package androidx.compose.p000ui.node;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MyersDiff.kt */
@Metadata(m164d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u001a\u0010\"\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b'\u0010\u000bJ\u000f\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000b\u0088\u0001\u0002¨\u0006,"}, m165d2 = {"Landroidx/compose/ui/node/Snake;", "", "data", "", "constructor-impl", "([I)[I", "getData", "()[I", "diagonalSize", "", "getDiagonalSize-impl", "([I)I", "endX", "getEndX-impl", "endY", "getEndY-impl", "hasAdditionOrRemoval", "", "getHasAdditionOrRemoval-impl", "([I)Z", "isAddition", "isAddition-impl", "reverse", "getReverse-impl", "startX", "getStartX-impl", "startY", "getStartY-impl", "addDiagonalToStack", "", "diagonals", "Landroidx/compose/ui/node/IntStack;", "addDiagonalToStack-impl", "([ILandroidx/compose/ui/node/IntStack;)V", "equals", "other", "equals-impl", "([ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "ui_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes.dex */
final class Snake {
    private final int[] data;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Snake m5484boximpl(int[] iArr) {
        return new Snake(iArr);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m5485constructorimpl(int[] iArr) {
        return iArr;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5486equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof Snake) && Intrinsics.areEqual(iArr, ((Snake) obj).m5498unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5487equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5495hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public boolean equals(Object obj) {
        return m5486equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5495hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m5498unboximpl() {
        return this.data;
    }

    private /* synthetic */ Snake(int[] data) {
        this.data = data;
    }

    public final int[] getData() {
        return this.data;
    }

    /* renamed from: getStartX-impl, reason: not valid java name */
    public static final int m5493getStartXimpl(int[] arg0) {
        return arg0[0];
    }

    /* renamed from: getStartY-impl, reason: not valid java name */
    public static final int m5494getStartYimpl(int[] arg0) {
        return arg0[1];
    }

    /* renamed from: getEndX-impl, reason: not valid java name */
    public static final int m5489getEndXimpl(int[] arg0) {
        return arg0[2];
    }

    /* renamed from: getEndY-impl, reason: not valid java name */
    public static final int m5490getEndYimpl(int[] arg0) {
        return arg0[3];
    }

    /* renamed from: getReverse-impl, reason: not valid java name */
    public static final boolean m5492getReverseimpl(int[] arg0) {
        return arg0[4] != 0;
    }

    /* renamed from: getDiagonalSize-impl, reason: not valid java name */
    public static final int m5488getDiagonalSizeimpl(int[] arg0) {
        return Math.min(m5489getEndXimpl(arg0) - m5493getStartXimpl(arg0), m5490getEndYimpl(arg0) - m5494getStartYimpl(arg0));
    }

    /* renamed from: getHasAdditionOrRemoval-impl, reason: not valid java name */
    private static final boolean m5491getHasAdditionOrRemovalimpl(int[] arg0) {
        return m5490getEndYimpl(arg0) - m5494getStartYimpl(arg0) != m5489getEndXimpl(arg0) - m5493getStartXimpl(arg0);
    }

    /* renamed from: isAddition-impl, reason: not valid java name */
    private static final boolean m5496isAdditionimpl(int[] arg0) {
        return m5490getEndYimpl(arg0) - m5494getStartYimpl(arg0) > m5489getEndXimpl(arg0) - m5493getStartXimpl(arg0);
    }

    /* renamed from: addDiagonalToStack-impl, reason: not valid java name */
    public static final void m5483addDiagonalToStackimpl(int[] arg0, IntStack diagonals) {
        if (m5491getHasAdditionOrRemovalimpl(arg0)) {
            if (m5492getReverseimpl(arg0)) {
                diagonals.pushDiagonal(m5493getStartXimpl(arg0), m5494getStartYimpl(arg0), m5488getDiagonalSizeimpl(arg0));
                return;
            } else if (m5496isAdditionimpl(arg0)) {
                diagonals.pushDiagonal(m5493getStartXimpl(arg0), m5494getStartYimpl(arg0) + 1, m5488getDiagonalSizeimpl(arg0));
                return;
            } else {
                diagonals.pushDiagonal(m5493getStartXimpl(arg0) + 1, m5494getStartYimpl(arg0), m5488getDiagonalSizeimpl(arg0));
                return;
            }
        }
        diagonals.pushDiagonal(m5493getStartXimpl(arg0), m5494getStartYimpl(arg0), m5489getEndXimpl(arg0) - m5493getStartXimpl(arg0));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5497toStringimpl(int[] arg0) {
        return "Snake(" + m5493getStartXimpl(arg0) + ',' + m5494getStartYimpl(arg0) + ',' + m5489getEndXimpl(arg0) + ',' + m5490getEndYimpl(arg0) + ',' + m5492getReverseimpl(arg0) + ')';
    }

    public String toString() {
        return m5497toStringimpl(this.data);
    }
}
