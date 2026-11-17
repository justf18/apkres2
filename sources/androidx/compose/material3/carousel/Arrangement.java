package androidx.compose.material3.carousel;

import androidx.annotation.FloatRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Arrangement.kt */
@Metadata(m164d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0015"}, m165d2 = {"Landroidx/compose/material3/carousel/Arrangement;", "", "priority", "", "smallSize", "", "smallCount", "mediumSize", "mediumCount", "largeSize", "largeCount", "(IFIFIFI)V", "getLargeSize", "()F", "getMediumSize", "getSmallSize", "cost", "targetLargeSize", "isValid", "", "Companion", "material3_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Arrangement {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float MediumItemFlexPercentage = 0.1f;
    private final int largeCount;
    private final float largeSize;
    private final int mediumCount;
    private final float mediumSize;
    private final int priority;
    private final int smallCount;
    private final float smallSize;

    public Arrangement(int priority, float smallSize, int smallCount, float mediumSize, int mediumCount, float largeSize, int largeCount) {
        this.priority = priority;
        this.smallSize = smallSize;
        this.smallCount = smallCount;
        this.mediumSize = mediumSize;
        this.mediumCount = mediumCount;
        this.largeSize = largeSize;
        this.largeCount = largeCount;
    }

    public final float getSmallSize() {
        return this.smallSize;
    }

    public final float getMediumSize() {
        return this.mediumSize;
    }

    public final float getLargeSize() {
        return this.largeSize;
    }

    private final boolean isValid() {
        return (this.largeCount <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) ? this.largeCount <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize : this.largeSize > this.mediumSize && this.mediumSize > this.smallSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float cost(float targetLargeSize) {
        if (!isValid()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(targetLargeSize - this.largeSize) * this.priority;
    }

    /* compiled from: Arrangement.kt */
    @Metadata(m164d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002JH\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0012JP\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m165d2 = {"Landroidx/compose/material3/carousel/Arrangement$Companion;", "", "()V", "MediumItemFlexPercentage", "", "calculateLargeSize", "availableSpace", "smallCount", "", "smallSize", "mediumCount", "largeCount", "findLowestCostArrangement", "Landroidx/compose/material3/carousel/Arrangement;", "targetSmallSize", "smallSizeRange", "Landroidx/annotation/FloatRange;", "smallCounts", "", "targetMediumSize", "mediumCounts", "targetLargeSize", "largeCounts", "fit", "priority", "mediumSize", "largeSize", "material3_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Arrangement findLowestCostArrangement(float availableSpace, float targetSmallSize, FloatRange smallSizeRange, int[] smallCounts, float targetMediumSize, int[] mediumCounts, float targetLargeSize, int[] largeCounts) {
            int[] iArr = smallCounts;
            Arrangement lowestCostArrangement = null;
            int priority = 1;
            int length = largeCounts.length;
            int i = 0;
            while (i < length) {
                int largeCount = largeCounts[i];
                int length2 = mediumCounts.length;
                int i2 = 0;
                while (i2 < length2) {
                    int mediumCount = mediumCounts[i2];
                    int length3 = iArr.length;
                    int i3 = 0;
                    while (i3 < length3) {
                        int i4 = i2;
                        int smallCount = iArr[i3];
                        Arrangement lowestCostArrangement2 = lowestCostArrangement;
                        int i5 = length2;
                        int i6 = length3;
                        int i7 = i3;
                        Arrangement arrangement = fit(priority, availableSpace, smallCount, targetSmallSize, smallSizeRange, mediumCount, targetMediumSize, largeCount, targetLargeSize);
                        if (lowestCostArrangement2 == null || arrangement.cost(targetLargeSize) < lowestCostArrangement2.cost(targetLargeSize)) {
                            lowestCostArrangement = arrangement;
                            if (lowestCostArrangement.cost(targetLargeSize) == 0.0f) {
                                return lowestCostArrangement;
                            }
                        } else {
                            lowestCostArrangement = lowestCostArrangement2;
                        }
                        priority++;
                        i3 = i7 + 1;
                        iArr = smallCounts;
                        length2 = i5;
                        i2 = i4;
                        length3 = i6;
                    }
                    i2++;
                    iArr = smallCounts;
                }
                i++;
                iArr = smallCounts;
            }
            return lowestCostArrangement;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final androidx.compose.material3.carousel.Arrangement fit(int r16, float r17, int r18, float r19, androidx.annotation.FloatRange r20, int r21, float r22, int r23, float r24) {
            /*
                r15 = this;
                r2 = r18
                r4 = r21
                r7 = r23
                double r0 = r20.from()
                float r0 = (float) r0
                double r5 = r20.m1to()
                float r1 = (float) r5
                r8 = r19
                float r0 = kotlin.ranges.RangesKt.coerceIn(r8, r0, r1)
                r6 = r22
                r9 = r24
                float r1 = (float) r7
                float r1 = r1 * r9
                float r3 = (float) r4
                float r3 = r3 * r6
                float r1 = r1 + r3
                float r3 = (float) r2
                float r3 = r3 * r0
                float r10 = r1 + r3
                float r11 = r17 - r10
                r12 = 0
                if (r2 <= 0) goto L3c
                int r1 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
                if (r1 <= 0) goto L3c
            L2d:
                float r1 = (float) r2
                float r1 = r11 / r1
                double r13 = r20.m1to()
                float r3 = (float) r13
                float r3 = r3 - r0
                float r1 = java.lang.Math.min(r1, r3)
                float r0 = r0 + r1
                goto L51
            L3c:
                if (r2 <= 0) goto L51
                int r1 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
                if (r1 >= 0) goto L51
            L43:
                float r1 = (float) r2
                float r1 = r11 / r1
                double r13 = r20.from()
                float r3 = (float) r13
                float r3 = r3 - r0
                float r1 = java.lang.Math.max(r1, r3)
                float r0 = r0 + r1
            L51:
                if (r2 <= 0) goto L55
                r3 = r0
                goto L56
            L55:
                r3 = r12
            L56:
                r0 = r15
                r1 = r17
                r5 = r7
                float r7 = r0.calculateLargeSize(r1, r2, r3, r4, r5)
                r2 = r3
                float r3 = r7 + r2
                r0 = 1073741824(0x40000000, float:2.0)
                float r3 = r3 / r0
                if (r4 <= 0) goto L9d
                int r0 = (r7 > r24 ? 1 : (r7 == r24 ? 0 : -1))
                if (r0 != 0) goto L6f
                r0 = 1
                goto L70
            L6f:
                r0 = 0
            L70:
                if (r0 != 0) goto L9d
                float r0 = r24 - r7
                float r1 = (float) r5
                float r0 = r0 * r1
                r1 = 1036831949(0x3dcccccd, float:0.1)
                float r1 = r1 * r3
                float r6 = (float) r4
                float r1 = r1 * r6
                float r6 = java.lang.Math.abs(r0)
                float r6 = java.lang.Math.min(r6, r1)
                int r9 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
                if (r9 <= 0) goto L93
                float r9 = (float) r4
                float r9 = r6 / r9
                float r3 = r3 - r9
                float r9 = (float) r5
                float r9 = r6 / r9
                float r7 = r7 + r9
                r6 = r7
                goto L9e
            L93:
                float r9 = (float) r4
                float r9 = r6 / r9
                float r3 = r3 + r9
                float r9 = (float) r5
                float r9 = r6 / r9
                float r7 = r7 - r9
                r6 = r7
                goto L9e
            L9d:
                r6 = r7
            L9e:
                androidx.compose.material3.carousel.Arrangement r0 = new androidx.compose.material3.carousel.Arrangement
                r1 = r16
                r7 = r5
                r5 = r4
                r4 = r3
                r3 = r18
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.Arrangement.Companion.fit(int, float, int, float, androidx.annotation.FloatRange, int, float, int, float):androidx.compose.material3.carousel.Arrangement");
        }

        private final float calculateLargeSize(float availableSpace, int smallCount, float smallSize, int mediumCount, int largeCount) {
            return (availableSpace - ((smallCount + (mediumCount / 2.0f)) * smallSize)) / (largeCount + (mediumCount / 2.0f));
        }
    }
}
