package androidx.compose.runtime.snapshots;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* compiled from: SnapshotIdSet.kt */
@Metadata(m164d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\u001d\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0012H\u0086\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0002J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0096\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m165d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "and", "bits", "andNot", "clear", "bit", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "set", "toString", "", "Companion", "runtime_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);
    private final int[] belowBound;
    private final int lowerBound;
    private final long lowerSet;
    private final long upperSet;

    private SnapshotIdSet(long upperSet, long lowerSet, int lowerBound, int[] belowBound) {
        this.upperSet = upperSet;
        this.lowerSet = lowerSet;
        this.lowerBound = lowerBound;
        this.belowBound = belowBound;
    }

    public final boolean get(int bit) {
        int[] it;
        int offset = bit - this.lowerBound;
        if (offset >= 0 && offset < 64) {
            return ((1 << offset) & this.lowerSet) != 0;
        }
        if (offset >= 64 && offset < 128) {
            return ((1 << (offset + (-64))) & this.upperSet) != 0;
        }
        if (offset <= 0 && (it = this.belowBound) != null) {
            return SnapshotIdSetKt.binarySearch(it, bit) >= 0;
        }
        return false;
    }

    public final SnapshotIdSet set(int bit) {
        int newLowerBound;
        long newLowerSet;
        int[] intArray;
        long j;
        long j2;
        char c;
        int offset = bit - this.lowerBound;
        long j3 = 1;
        long j4 = 0;
        char c2 = '@';
        if (offset >= 0 && offset < 64) {
            long mask = 1 << offset;
            if ((this.lowerSet & mask) == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet | mask, this.lowerBound, this.belowBound);
            }
        } else if (offset >= 64 && offset < 128) {
            long mask2 = 1 << (offset - 64);
            if ((this.upperSet & mask2) == 0) {
                return new SnapshotIdSet(this.upperSet | mask2, this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (offset >= 128) {
            if (!get(bit)) {
                long newUpperSet = this.upperSet;
                long newLowerSet2 = this.lowerSet;
                int newLowerBound2 = this.lowerBound;
                List list = null;
                int targetLowerBound = ((bit + 1) / 64) * 64;
                long newUpperSet2 = newUpperSet;
                while (true) {
                    if (newLowerBound2 >= targetLowerBound) {
                        newLowerBound = newLowerBound2;
                        newLowerSet = newLowerSet2;
                        break;
                    }
                    if (newLowerSet2 == j4) {
                        j = j3;
                        j2 = j4;
                        c = c2;
                    } else {
                        if (list != null) {
                            j = j3;
                            j2 = j4;
                        } else {
                            List $this$set_u24lambda_u243 = new ArrayList();
                            j = j3;
                            int[] it = this.belowBound;
                            if (it == null) {
                                j2 = j4;
                            } else {
                                j2 = j4;
                                for (int element$iv : it) {
                                    $this$set_u24lambda_u243.add(Integer.valueOf(element$iv));
                                }
                            }
                            list = $this$set_u24lambda_u243;
                        }
                        int i = 0;
                        while (true) {
                            c = '@';
                            if (i >= 64) {
                                break;
                            }
                            int bitOffset = i;
                            if (((j << bitOffset) & newLowerSet2) != j2) {
                                list.add(Integer.valueOf(bitOffset + newLowerBound2));
                            }
                            i++;
                        }
                    }
                    if (newUpperSet2 == j2) {
                        newLowerBound = targetLowerBound;
                        newLowerSet = 0;
                        break;
                    }
                    newLowerSet2 = newUpperSet2;
                    newUpperSet2 = 0;
                    newLowerBound2 += 64;
                    c2 = c;
                    j3 = j;
                    j4 = j2;
                }
                if (list == null || (intArray = CollectionsKt.toIntArray(list)) == null) {
                    intArray = this.belowBound;
                }
                return new SnapshotIdSet(newUpperSet2, newLowerSet, newLowerBound, intArray).set(bit);
            }
        } else {
            int[] array = this.belowBound;
            if (array == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, new int[]{bit});
            }
            int location = SnapshotIdSetKt.binarySearch(array, bit);
            if (location < 0) {
                int insertLocation = -(location + 1);
                int newSize = array.length + 1;
                int[] newBelowBound = new int[newSize];
                ArraysKt.copyInto(array, newBelowBound, 0, 0, insertLocation);
                ArraysKt.copyInto(array, newBelowBound, insertLocation + 1, insertLocation, newSize - 1);
                newBelowBound[insertLocation] = bit;
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, newBelowBound);
            }
        }
        return this;
    }

    public final SnapshotIdSet clear(int bit) {
        int[] array;
        int location;
        int offset = bit - this.lowerBound;
        if (offset >= 0 && offset < 64) {
            long mask = 1 << offset;
            if ((this.lowerSet & mask) != 0) {
                return new SnapshotIdSet(this.upperSet, (~mask) & this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (offset >= 64 && offset < 128) {
            long mask2 = 1 << (offset - 64);
            if ((this.upperSet & mask2) != 0) {
                return new SnapshotIdSet((~mask2) & this.upperSet, this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (offset < 0 && (array = this.belowBound) != null && (location = SnapshotIdSetKt.binarySearch(array, bit)) >= 0) {
            int newSize = array.length - 1;
            if (newSize == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, null);
            }
            int[] newBelowBound = new int[newSize];
            if (location > 0) {
                ArraysKt.copyInto(array, newBelowBound, 0, 0, location);
            }
            if (location < newSize) {
                ArraysKt.copyInto(array, newBelowBound, location, location + 1, newSize + 1);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, newBelowBound);
        }
        return this;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet bits) {
        if (bits == EMPTY) {
            return this;
        }
        if (this == EMPTY) {
            return EMPTY;
        }
        if (bits.lowerBound == this.lowerBound && bits.belowBound == this.belowBound) {
            return new SnapshotIdSet((~bits.upperSet) & this.upperSet, (~bits.lowerSet) & this.lowerSet, this.lowerBound, this.belowBound);
        }
        SnapshotIdSet $this$fold$iv = bits;
        Object accumulator$iv = this;
        for (Object element$iv : $this$fold$iv) {
            int index = ((Number) element$iv).intValue();
            SnapshotIdSet previous = (SnapshotIdSet) accumulator$iv;
            accumulator$iv = previous.clear(index);
        }
        return (SnapshotIdSet) accumulator$iv;
    }

    public final SnapshotIdSet and(SnapshotIdSet bits) {
        if (!Intrinsics.areEqual(bits, EMPTY) && !Intrinsics.areEqual(this, EMPTY)) {
            if (bits.lowerBound == this.lowerBound && bits.belowBound == this.belowBound) {
                long newUpper = this.upperSet & bits.upperSet;
                long newLower = this.lowerSet & bits.lowerSet;
                if (newUpper == 0 && newLower == 0 && this.belowBound == null) {
                    return EMPTY;
                }
                return new SnapshotIdSet(this.upperSet & bits.upperSet, this.lowerSet & bits.lowerSet, this.lowerBound, this.belowBound);
            }
            if (this.belowBound == null) {
                SnapshotIdSet $this$fold$iv = this;
                SnapshotIdSet snapshotIdSet = EMPTY;
                for (Object element$iv : $this$fold$iv) {
                    int index = ((Number) element$iv).intValue();
                    SnapshotIdSet previous = snapshotIdSet;
                    if (bits.get(index)) {
                        previous = previous.set(index);
                    }
                    snapshotIdSet = previous;
                }
                return snapshotIdSet;
            }
            SnapshotIdSet $this$fold$iv2 = bits;
            SnapshotIdSet snapshotIdSet2 = EMPTY;
            for (Object element$iv2 : $this$fold$iv2) {
                int index2 = ((Number) element$iv2).intValue();
                SnapshotIdSet previous2 = snapshotIdSet2;
                if (get(index2)) {
                    previous2 = previous2.set(index2);
                }
                snapshotIdSet2 = previous2;
            }
            return snapshotIdSet2;
        }
        return EMPTY;
    }

    /* renamed from: or */
    public final SnapshotIdSet m20or(SnapshotIdSet bits) {
        if (bits == EMPTY) {
            return this;
        }
        if (this == EMPTY) {
            return bits;
        }
        if (bits.lowerBound == this.lowerBound && bits.belowBound == this.belowBound) {
            return new SnapshotIdSet(bits.upperSet | this.upperSet, bits.lowerSet | this.lowerSet, this.lowerBound, this.belowBound);
        }
        if (this.belowBound == null) {
            SnapshotIdSet $this$fold$iv = this;
            SnapshotIdSet snapshotIdSet = bits;
            for (Object element$iv : $this$fold$iv) {
                int index = ((Number) element$iv).intValue();
                SnapshotIdSet previous = snapshotIdSet;
                snapshotIdSet = previous.set(index);
            }
            return snapshotIdSet;
        }
        SnapshotIdSet $this$fold$iv2 = bits;
        Object accumulator$iv = this;
        for (Object element$iv2 : $this$fold$iv2) {
            int index2 = ((Number) element$iv2).intValue();
            SnapshotIdSet previous2 = (SnapshotIdSet) accumulator$iv;
            accumulator$iv = previous2.set(index2);
        }
        return (SnapshotIdSet) accumulator$iv;
    }

    /* compiled from: SnapshotIdSet.kt */
    @Metadata(m164d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", m180f = "SnapshotIdSet.kt", m181i = {0, 0, 1, 1, 2, 2}, m182l = {295, 300, 307}, m183m = "invokeSuspend", m184n = {"$this$sequence", "belowBound", "$this$sequence", "index", "$this$sequence", "index"}, m185s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
    /* renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1 */
    static final class C17281 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C17281(Continuation<? super C17281> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C17281 c17281 = SnapshotIdSet.this.new C17281(continuation);
            c17281.L$0 = obj;
            return c17281;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C17281) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00e0  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0088 -> B:16:0x008b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00ad -> B:29:0x00ce). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ca -> B:29:0x00ce). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00eb -> B:41:0x010e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x010a -> B:41:0x010e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instructions count: 288
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.C17281.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return SequencesKt.sequence(new C17281(null)).iterator();
    }

    public final void fastForEach(Function1<? super Integer, Unit> block) {
        int[] belowBound = this.belowBound;
        if (belowBound != null) {
            for (int element : belowBound) {
                block.invoke(Integer.valueOf(element));
            }
        }
        if (this.lowerSet != 0) {
            for (int index = 0; index < 64; index++) {
                if ((this.lowerSet & (1 << index)) != 0) {
                    block.invoke(Integer.valueOf(this.lowerBound + index));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int index2 = 0; index2 < 64; index2++) {
                if ((this.upperSet & (1 << index2)) != 0) {
                    block.invoke(Integer.valueOf(index2 + 64 + this.lowerBound));
                }
            }
        }
    }

    public final int lowest(int i) {
        int[] belowBound = this.belowBound;
        if (belowBound != null) {
            return belowBound[0];
        }
        if (this.lowerSet != 0) {
            return this.lowerBound + SnapshotIdSetKt.lowestBitOf(this.lowerSet);
        }
        if (this.upperSet != 0) {
            return this.lowerBound + 64 + SnapshotIdSetKt.lowestBitOf(this.upperSet);
        }
        return i;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append(super.toString()).append(" [");
        SnapshotIdSet $this$map$iv = this;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            int it = ((Number) item$iv$iv).intValue();
            destination$iv$iv.add(String.valueOf(it));
        }
        return sbAppend.append(ListUtilsKt.fastJoinToString$default((List) destination$iv$iv, null, null, null, 0, null, null, 63, null)).append(']').toString();
    }

    /* compiled from: SnapshotIdSet.kt */
    @Metadata(m164d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m165d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }
}
