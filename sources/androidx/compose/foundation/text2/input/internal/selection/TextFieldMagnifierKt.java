package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TextFieldMagnifier.kt */
@Metadata(m164d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, m165d2 = {"calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "selectionState", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-hUlJWOE", "(Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text2/input/internal/TextLayoutState;J)J", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldMagnifierKt {

    /* compiled from: TextFieldMagnifier.kt */
    @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.Cursor.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Handle.SelectionStart.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c9  */
    /* renamed from: calculateSelectionMagnifierCenterAndroid-hUlJWOE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long m1372calculateSelectionMagnifierCenterAndroidhUlJWOE(androidx.compose.foundation.text2.input.internal.TransformedTextFieldState r22, androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState r23, androidx.compose.foundation.text2.input.internal.TextLayoutState r24, long r25) {
        /*
            long r0 = r23.m1394getHandleDragPositionF1C5BW0()
            boolean r2 = androidx.compose.p000ui.geometry.OffsetKt.m3729isUnspecifiedk4lQ0M(r0)
            if (r2 != 0) goto Ldc
            androidx.compose.foundation.text2.input.TextFieldCharSequence r2 = r22.getText()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L18
            r2 = 1
            goto L19
        L18:
            r2 = 0
        L19:
            if (r2 == 0) goto L21
            r2 = r24
            r18 = r0
            goto Le0
        L21:
            androidx.compose.foundation.text2.input.TextFieldCharSequence r2 = r22.getText()
            long r2 = r2.getSelectionInChars()
            androidx.compose.foundation.text.Handle r4 = r23.getDraggingHandle()
            if (r4 != 0) goto L31
            r4 = -1
            goto L39
        L31:
            int[] r5 = androidx.compose.foundation.text2.input.internal.selection.TextFieldMagnifierKt.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r5[r4]
        L39:
            switch(r4) {
                case -1: goto Ld3;
                case 0: goto L3c;
                case 1: goto L49;
                case 2: goto L49;
                case 3: goto L44;
                default: goto L3c;
            }
        L3c:
            r18 = r0
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L44:
            int r4 = androidx.compose.p000ui.text.TextRange.m5769getEndimpl(r2)
            goto L4d
        L49:
            int r4 = androidx.compose.p000ui.text.TextRange.m5774getStartimpl(r2)
        L4d:
            androidx.compose.ui.text.TextLayoutResult r5 = r24.getLayoutResult()
            if (r5 != 0) goto L5b
            androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.p000ui.geometry.Offset.INSTANCE
            long r5 = r5.m3723getUnspecifiedF1C5BW0()
            return r5
        L5b:
            float r6 = androidx.compose.p000ui.geometry.Offset.m3708getXimpl(r0)
            int r7 = r5.getLineForOffset(r4)
            float r8 = r5.getLineLeft(r7)
            float r9 = r5.getLineRight(r7)
            float r10 = java.lang.Math.min(r8, r9)
            float r11 = java.lang.Math.max(r8, r9)
            float r12 = kotlin.ranges.RangesKt.coerceIn(r6, r10, r11)
            float r13 = r6 - r12
            float r13 = java.lang.Math.abs(r13)
            int r14 = androidx.compose.p000ui.unit.IntSize.m6467getWidthimpl(r25)
            r15 = 2
            int r14 = r14 / r15
            float r14 = (float) r14
            int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r13 <= 0) goto L8f
            androidx.compose.ui.geometry.Offset$Companion r13 = androidx.compose.p000ui.geometry.Offset.INSTANCE
            long r13 = r13.m3723getUnspecifiedF1C5BW0()
            return r13
        L8f:
            float r13 = r5.getLineTop(r7)
            float r14 = r5.getLineBottom(r7)
            float r16 = r14 - r13
            float r15 = (float) r15
            float r16 = r16 / r15
            float r15 = r16 + r13
            r16 = 0
            r18 = r0
            long r0 = androidx.compose.p000ui.geometry.OffsetKt.Offset(r12, r15)
            androidx.compose.ui.layout.LayoutCoordinates r16 = r24.getTextLayoutNodeCoordinates()
            if (r16 == 0) goto Lc9
            r17 = r16
            r20 = 0
            boolean r17 = r17.isAttached()
            if (r17 == 0) goto Lb7
            goto Lb9
        Lb7:
            r16 = 0
        Lb9:
            if (r16 == 0) goto Lc9
            r17 = 0
            r20 = r2
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r16)
            long r0 = androidx.compose.foundation.text2.input.internal.TextLayoutStateKt.m1351coerceIn3MmeM6k(r0, r2)
            goto Lcb
        Lc9:
            r20 = r2
        Lcb:
            r2 = r24
            long r16 = androidx.compose.foundation.text2.input.internal.TextLayoutStateKt.m1353fromTextLayoutToCoreUv8p0NA(r2, r0)
            return r16
        Ld3:
            r18 = r0
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.p000ui.geometry.Offset.INSTANCE
            long r0 = r0.m3723getUnspecifiedF1C5BW0()
            return r0
        Ldc:
            r2 = r24
            r18 = r0
        Le0:
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.p000ui.geometry.Offset.INSTANCE
            long r0 = r0.m3723getUnspecifiedF1C5BW0()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.TextFieldMagnifierKt.m1372calculateSelectionMagnifierCenterAndroidhUlJWOE(androidx.compose.foundation.text2.input.internal.TransformedTextFieldState, androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState, androidx.compose.foundation.text2.input.internal.TextLayoutState, long):long");
    }
}
