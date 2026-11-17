package androidx.compose.foundation;

import android.view.View;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutCoordinatesKt;
import androidx.compose.p000ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.p000ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.p000ui.node.DrawModifierNode;
import androidx.compose.p000ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.p000ui.node.ObserverModifierNode;
import androidx.compose.p000ui.node.ObserverModifierNodeKt;
import androidx.compose.p000ui.node.SemanticsModifierNode;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.DpSize;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Magnifier.android.kt */
@Metadata(m164d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0099\u0001\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b\u0012\u001b\b\u0002\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000b\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\b\u0010J\u001a\u00020\u000fH\u0016J\b\u0010K\u001a\u00020\u000fH\u0016J\u0010\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\u000fH\u0016J\b\u0010P\u001a\u00020\u000fH\u0002J\u0092\u0001\u0010Q\u001a\u00020\u000f2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b2\u0019\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00132\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\b\u0010T\u001a\u00020\u000fH\u0002J\b\u0010U\u001a\u00020\u000fH\u0002J\f\u0010V\u001a\u00020\u000f*\u00020WH\u0016J\f\u0010X\u001a\u00020\u000f*\u00020YH\u0016R1\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n8B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\u0015\u001a\u00020\u0016X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010-\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u00020\u0016X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00103\"\u0004\b7\u00105R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u00020\u000eX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010!R+\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00103\"\u0004\bB\u00105R\u0016\u0010C\u001a\u00020\nX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010@R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010%\"\u0004\bE\u0010'R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010)\"\u0004\bI\u0010+\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, m165d2 = {"Landroidx/compose/foundation/MagnifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "anchorPositionInRoot", "getAnchorPositionInRoot-F1C5BW0", "()J", "setAnchorPositionInRoot-k-4lQ0M", "(J)V", "anchorPositionInRoot$delegate", "Landroidx/compose/runtime/MutableState;", "getClippingEnabled", "()Z", "setClippingEnabled", "(Z)V", "getCornerRadius-D9Ej5fM", "()F", "setCornerRadius-0680j_4", "(F)V", "F", "density", "getElevation-D9Ej5fM", "setElevation-0680j_4", "magnifier", "Landroidx/compose/foundation/PlatformMagnifier;", "getMagnifierCenter", "()Lkotlin/jvm/functions/Function1;", "setMagnifierCenter", "(Lkotlin/jvm/functions/Function1;)V", "getOnSizeChanged", "setOnSizeChanged", "getPlatformMagnifierFactory", "()Landroidx/compose/foundation/PlatformMagnifierFactory;", "setPlatformMagnifierFactory", "(Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "previousSize", "Landroidx/compose/ui/unit/IntSize;", "getSize-MYxV2XQ", "setSize-EaSLcWc", "J", "getSourceCenter", "setSourceCenter", "sourceCenterInRoot", "getUseTextDefault", "setUseTextDefault", "view", "Landroid/view/View;", "getZoom", "setZoom", "onAttach", "onDetach", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onObservedReadsChanged", "recreateMagnifier", "update", "update-5F03MCQ", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "updateMagnifier", "updateSizeIfNecessary", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MagnifierNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, DrawModifierNode, SemanticsModifierNode, ObserverModifierNode {
    public static final int $stable = 8;

    /* renamed from: anchorPositionInRoot$delegate, reason: from kotlin metadata */
    private final MutableState anchorPositionInRoot;
    private boolean clippingEnabled;
    private float cornerRadius;
    private Density density;
    private float elevation;
    private PlatformMagnifier magnifier;
    private Function1<? super Density, Offset> magnifierCenter;
    private Function1<? super DpSize, Unit> onSizeChanged;
    private PlatformMagnifierFactory platformMagnifierFactory;
    private IntSize previousSize;
    private long size;
    private Function1<? super Density, Offset> sourceCenter;
    private long sourceCenterInRoot;
    private boolean useTextDefault;
    private View view;
    private float zoom;

    public /* synthetic */ MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, function13, f, z, j, f2, f3, z2, platformMagnifierFactory);
    }

    public /* synthetic */ MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? null : function12, (i & 4) != 0 ? null : function13, (i & 8) != 0 ? Float.NaN : f, (i & 16) != 0 ? false : z, (i & 32) != 0 ? DpSize.INSTANCE.m6404getUnspecifiedMYxV2XQ() : j, (i & 64) != 0 ? C1956Dp.INSTANCE.m6317getUnspecifiedD9Ej5fM() : f2, (i & 128) != 0 ? C1956Dp.INSTANCE.m6317getUnspecifiedD9Ej5fM() : f3, (i & 256) != 0 ? true : z2, (i & 512) != 0 ? PlatformMagnifierFactory.INSTANCE.getForCurrentPlatform() : platformMagnifierFactory, null);
    }

    public final Function1<Density, Offset> getSourceCenter() {
        return this.sourceCenter;
    }

    public final void setSourceCenter(Function1<? super Density, Offset> function1) {
        this.sourceCenter = function1;
    }

    public final Function1<Density, Offset> getMagnifierCenter() {
        return this.magnifierCenter;
    }

    public final void setMagnifierCenter(Function1<? super Density, Offset> function1) {
        this.magnifierCenter = function1;
    }

    public final Function1<DpSize, Unit> getOnSizeChanged() {
        return this.onSizeChanged;
    }

    public final void setOnSizeChanged(Function1<? super DpSize, Unit> function1) {
        this.onSizeChanged = function1;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public final boolean getUseTextDefault() {
        return this.useTextDefault;
    }

    public final void setUseTextDefault(boolean z) {
        this.useTextDefault = z;
    }

    /* renamed from: getSize-MYxV2XQ, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: setSize-EaSLcWc, reason: not valid java name */
    public final void m479setSizeEaSLcWc(long j) {
        this.size = j;
    }

    /* renamed from: getCornerRadius-D9Ej5fM, reason: not valid java name and from getter */
    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    /* renamed from: setCornerRadius-0680j_4, reason: not valid java name */
    public final void m477setCornerRadius0680j_4(float f) {
        this.cornerRadius = f;
    }

    /* renamed from: getElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getElevation() {
        return this.elevation;
    }

    /* renamed from: setElevation-0680j_4, reason: not valid java name */
    public final void m478setElevation0680j_4(float f) {
        this.elevation = f;
    }

    public final boolean getClippingEnabled() {
        return this.clippingEnabled;
    }

    public final void setClippingEnabled(boolean z) {
        this.clippingEnabled = z;
    }

    public final PlatformMagnifierFactory getPlatformMagnifierFactory() {
        return this.platformMagnifierFactory;
    }

    public final void setPlatformMagnifierFactory(PlatformMagnifierFactory platformMagnifierFactory) {
        this.platformMagnifierFactory = platformMagnifierFactory;
    }

    private MagnifierNode(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, Function1<? super DpSize, Unit> function13, float zoom, boolean useTextDefault, long size, float cornerRadius, float elevation, boolean clippingEnabled, PlatformMagnifierFactory platformMagnifierFactory) {
        this.sourceCenter = function1;
        this.magnifierCenter = function12;
        this.onSizeChanged = function13;
        this.zoom = zoom;
        this.useTextDefault = useTextDefault;
        this.size = size;
        this.cornerRadius = cornerRadius;
        this.elevation = elevation;
        this.clippingEnabled = clippingEnabled;
        this.platformMagnifierFactory = platformMagnifierFactory;
        this.anchorPositionInRoot = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3697boximpl(Offset.INSTANCE.m3723getUnspecifiedF1C5BW0()), null, 2, null);
        this.sourceCenterInRoot = Offset.INSTANCE.m3723getUnspecifiedF1C5BW0();
    }

    /* renamed from: getAnchorPositionInRoot-F1C5BW0, reason: not valid java name */
    private final long m472getAnchorPositionInRootF1C5BW0() {
        State $this$getValue$iv = this.anchorPositionInRoot;
        return ((Offset) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* renamed from: setAnchorPositionInRoot-k-4lQ0M, reason: not valid java name */
    private final void m473setAnchorPositionInRootk4lQ0M(long j) {
        MutableState $this$setValue$iv = this.anchorPositionInRoot;
        $this$setValue$iv.setValue(Offset.m3697boximpl(j));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* renamed from: update-5F03MCQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m480update5F03MCQ(kotlin.jvm.functions.Function1<? super androidx.compose.p000ui.unit.Density, androidx.compose.p000ui.geometry.Offset> r18, kotlin.jvm.functions.Function1<? super androidx.compose.p000ui.unit.Density, androidx.compose.p000ui.geometry.Offset> r19, float r20, boolean r21, long r22, float r24, float r25, boolean r26, kotlin.jvm.functions.Function1<? super androidx.compose.p000ui.unit.DpSize, kotlin.Unit> r27, androidx.compose.foundation.PlatformMagnifierFactory r28) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            r2 = r22
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r28
            float r8 = r0.zoom
            long r9 = r0.size
            float r11 = r0.cornerRadius
            float r12 = r0.elevation
            boolean r13 = r0.clippingEnabled
            androidx.compose.foundation.PlatformMagnifierFactory r14 = r0.platformMagnifierFactory
            r15 = r18
            r0.sourceCenter = r15
            r16 = r8
            r8 = r19
            r0.magnifierCenter = r8
            r0.zoom = r1
            r1 = r21
            r0.useTextDefault = r1
            r0.size = r2
            r0.cornerRadius = r4
            r0.elevation = r5
            r0.clippingEnabled = r6
            r1 = r27
            r0.onSizeChanged = r1
            r0.platformMagnifierFactory = r7
            androidx.compose.foundation.PlatformMagnifier r1 = r0.magnifier
            if (r1 == 0) goto L66
            int r1 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1))
            if (r1 != 0) goto L43
            r1 = 1
            goto L44
        L43:
            r1 = 0
        L44:
            if (r1 != 0) goto L4c
            boolean r1 = r7.getCanUpdateZoom()
            if (r1 == 0) goto L66
        L4c:
            boolean r1 = androidx.compose.p000ui.unit.DpSize.m6392equalsimpl0(r2, r9)
            if (r1 == 0) goto L66
            boolean r1 = androidx.compose.p000ui.unit.C1956Dp.m6302equalsimpl0(r4, r11)
            if (r1 == 0) goto L66
            boolean r1 = androidx.compose.p000ui.unit.C1956Dp.m6302equalsimpl0(r5, r12)
            if (r1 == 0) goto L66
            if (r6 != r13) goto L66
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r14)
            if (r1 != 0) goto L69
        L66:
            r0.recreateMagnifier()
        L69:
            r0.updateMagnifier()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.m480update5F03MCQ(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, float, boolean, long, float, float, boolean, kotlin.jvm.functions.Function1, androidx.compose.foundation.PlatformMagnifierFactory):void");
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        onObservedReadsChanged();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        this.magnifier = null;
    }

    @Override // androidx.compose.p000ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.foundation.MagnifierNode.onObservedReadsChanged.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                View previousView = MagnifierNode.this.view;
                Object objCurrentValueOf = CompositionLocalConsumerModifierNodeKt.currentValueOf(MagnifierNode.this, AndroidCompositionLocals_androidKt.getLocalView());
                View it = (View) objCurrentValueOf;
                MagnifierNode.this.view = it;
                View view = (View) objCurrentValueOf;
                Density previousDensity = MagnifierNode.this.density;
                Object objCurrentValueOf2 = CompositionLocalConsumerModifierNodeKt.currentValueOf(MagnifierNode.this, CompositionLocalsKt.getLocalDensity());
                Density it2 = (Density) objCurrentValueOf2;
                MagnifierNode.this.density = it2;
                Density density = (Density) objCurrentValueOf2;
                if (MagnifierNode.this.magnifier == null || !Intrinsics.areEqual(view, previousView) || !Intrinsics.areEqual(density, previousDensity)) {
                    MagnifierNode.this.recreateMagnifier();
                }
                MagnifierNode.this.updateMagnifier();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recreateMagnifier() {
        Density density;
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        View view = this.view;
        if (view == null || (density = this.density) == null) {
            return;
        }
        this.magnifier = this.platformMagnifierFactory.mo507createnHHXs2Y(view, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, density, this.zoom);
        updateSizeIfNecessary();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateMagnifier() {
        /*
            r9 = this;
            androidx.compose.foundation.PlatformMagnifier r0 = r9.magnifier
            if (r0 != 0) goto L5
            return
        L5:
            r1 = r0
            androidx.compose.ui.unit.Density r0 = r9.density
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.unit.Density, androidx.compose.ui.geometry.Offset> r2 = r9.sourceCenter
            java.lang.Object r2 = r2.invoke(r0)
            androidx.compose.ui.geometry.Offset r2 = (androidx.compose.p000ui.geometry.Offset) r2
            long r7 = r2.getPackedValue()
            long r2 = r9.m472getAnchorPositionInRootF1C5BW0()
            boolean r2 = androidx.compose.p000ui.geometry.OffsetKt.m3727isSpecifiedk4lQ0M(r2)
            if (r2 == 0) goto L31
            boolean r2 = androidx.compose.p000ui.geometry.OffsetKt.m3727isSpecifiedk4lQ0M(r7)
            if (r2 == 0) goto L31
            long r2 = r9.m472getAnchorPositionInRootF1C5BW0()
            long r2 = androidx.compose.p000ui.geometry.Offset.m3713plusMKHz9U(r2, r7)
            goto L37
        L31:
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.p000ui.geometry.Offset.INSTANCE
            long r2 = r2.m3723getUnspecifiedF1C5BW0()
        L37:
            r9.sourceCenterInRoot = r2
            long r2 = r9.sourceCenterInRoot
            boolean r2 = androidx.compose.p000ui.geometry.OffsetKt.m3727isSpecifiedk4lQ0M(r2)
            if (r2 == 0) goto L88
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.unit.Density, androidx.compose.ui.geometry.Offset> r2 = r9.magnifierCenter
            if (r2 == 0) goto L73
            java.lang.Object r2 = r2.invoke(r0)
            androidx.compose.ui.geometry.Offset r2 = (androidx.compose.p000ui.geometry.Offset) r2
            long r2 = r2.getPackedValue()
            androidx.compose.ui.geometry.Offset r2 = androidx.compose.p000ui.geometry.Offset.m3697boximpl(r2)
            long r3 = r2.getPackedValue()
            r5 = 0
            boolean r3 = androidx.compose.p000ui.geometry.OffsetKt.m3727isSpecifiedk4lQ0M(r3)
            if (r3 == 0) goto L60
            goto L61
        L60:
            r2 = 0
        L61:
            if (r2 == 0) goto L73
        L64:
            long r2 = r2.getPackedValue()
            r4 = 0
            long r5 = r9.m472getAnchorPositionInRootF1C5BW0()
            long r2 = androidx.compose.p000ui.geometry.Offset.m3713plusMKHz9U(r5, r2)
            r4 = r2
            goto L7a
        L73:
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.p000ui.geometry.Offset.INSTANCE
            long r2 = r2.m3723getUnspecifiedF1C5BW0()
            r4 = r2
        L7a:
            long r2 = r9.sourceCenterInRoot
            float r6 = r9.zoom
            r1.mo506updateWko1d7g(r2, r4, r6)
            r9.updateSizeIfNecessary()
            goto L8b
        L88:
            r1.dismiss()
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.updateMagnifier():void");
    }

    private final void updateSizeIfNecessary() {
        Density density;
        PlatformMagnifier magnifier = this.magnifier;
        if (magnifier != null && (density = this.density) != null && !IntSize.m6464equalsimpl(magnifier.mo505getSizeYbymL2g(), this.previousSize)) {
            Function1<? super DpSize, Unit> function1 = this.onSizeChanged;
            if (function1 != null) {
                function1.invoke(DpSize.m6383boximpl(density.mo516toDpSizekrfVVM(IntSizeKt.m6477toSizeozmzZPI(magnifier.mo505getSizeYbymL2g()))));
            }
            this.previousSize = IntSize.m6459boximpl(magnifier.mo505getSizeYbymL2g());
        }
    }

    @Override // androidx.compose.p000ui.node.DrawModifierNode
    public void draw(ContentDrawScope $this$draw) {
        $this$draw.drawContent();
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C03231(null), 3, null);
    }

    /* compiled from: Magnifier.android.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(m179c = "androidx.compose.foundation.MagnifierNode$draw$1", m180f = "Magnifier.android.kt", m181i = {}, m182l = {447}, m183m = "invokeSuspend", m184n = {}, m185s = {})
    /* renamed from: androidx.compose.foundation.MagnifierNode$draw$1 */
    static final class C03231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03231(Continuation<? super C03231> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MagnifierNode.this.new C03231(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C03231 c03231;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (MonotonicFrameClockKt.withFrameMillis(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.MagnifierNode.draw.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                            invoke(l.longValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(long it) {
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c03231 = this;
                    break;
                case 1:
                    c03231 = this;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            PlatformMagnifier platformMagnifier = MagnifierNode.this.magnifier;
            if (platformMagnifier != null) {
                platformMagnifier.updateContent();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.p000ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        m473setAnchorPositionInRootk4lQ0M(LayoutCoordinatesKt.positionInRoot(coordinates));
    }

    @Override // androidx.compose.p000ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        $this$applySemantics.set(Magnifier_androidKt.getMagnifierPositionInRoot(), new Function0<Offset>() { // from class: androidx.compose.foundation.MagnifierNode.applySemantics.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Offset invoke() {
                return Offset.m3697boximpl(m481invokeF1C5BW0());
            }

            /* renamed from: invoke-F1C5BW0, reason: not valid java name */
            public final long m481invokeF1C5BW0() {
                return MagnifierNode.this.sourceCenterInRoot;
            }
        });
    }
}
