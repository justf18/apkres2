package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.semantics.SemanticsPropertyKey;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.DpSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: Magnifier.android.kt */
@Metadata(m164d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001\u001a\u0094\u0001\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f2\u001b\b\u0002\u0010\u0010\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\b\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a¬\u0001\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f2\u001b\b\u0002\u0010\u0010\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\b\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0000ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\" \u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m165d2 = {"MagnifierPositionInRoot", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Offset;", "getMagnifierPositionInRoot", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "isPlatformMagnifierSupported", "", "sdkVersion", "", "magnifier", "Landroidx/compose/ui/Modifier;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clip", "magnifier-UpNRX3w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FJFFZ)Landroidx/compose/ui/Modifier;", "useTextDefault", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "magnifier-jPUL71Q", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;)Landroidx/compose/ui/Modifier;", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Magnifier_androidKt {
    private static final SemanticsPropertyKey<Function0<Offset>> MagnifierPositionInRoot = new SemanticsPropertyKey<>("MagnifierPositionInRoot", null, 2, null);

    public static final SemanticsPropertyKey<Function0<Offset>> getMagnifierPositionInRoot() {
        return MagnifierPositionInRoot;
    }

    /* renamed from: magnifier-UpNRX3w$default, reason: not valid java name */
    public static /* synthetic */ Modifier m483magnifierUpNRX3w$default(Modifier modifier, Function1 function1, Function1 function12, Function1 function13, float f, long j, float f2, float f3, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            function12 = null;
        }
        if ((i & 4) != 0) {
            function13 = null;
        }
        if ((i & 8) != 0) {
            f = Float.NaN;
        }
        if ((i & 16) != 0) {
            j = DpSize.INSTANCE.m6404getUnspecifiedMYxV2XQ();
        }
        if ((i & 32) != 0) {
            f2 = C1956Dp.INSTANCE.m6317getUnspecifiedD9Ej5fM();
        }
        if ((i & 64) != 0) {
            f3 = C1956Dp.INSTANCE.m6317getUnspecifiedD9Ej5fM();
        }
        if ((i & 128) != 0) {
            z = true;
        }
        return m482magnifierUpNRX3w(modifier, function1, function12, function13, f, j, f2, f3, z);
    }

    /* renamed from: magnifier-UpNRX3w, reason: not valid java name */
    public static final Modifier m482magnifierUpNRX3w(Modifier $this$magnifier_u2dUpNRX3w, Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, Function1<? super DpSize, Unit> function13, float zoom, long size, float cornerRadius, float elevation, boolean clip) {
        return m485magnifierjPUL71Q$default($this$magnifier_u2dUpNRX3w, function1, function12, function13, zoom, false, size, cornerRadius, elevation, clip, null, 512, null);
    }

    /* renamed from: magnifier-jPUL71Q$default, reason: not valid java name */
    public static /* synthetic */ Modifier m485magnifierjPUL71Q$default(Modifier modifier, Function1 function1, Function1 function12, Function1 function13, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory, int i, Object obj) {
        if ((i & 2) != 0) {
            function12 = null;
        }
        if ((i & 4) != 0) {
            function13 = null;
        }
        if ((i & 8) != 0) {
            f = Float.NaN;
        }
        if ((i & 16) != 0) {
            z = false;
        }
        if ((i & 32) != 0) {
            j = DpSize.INSTANCE.m6404getUnspecifiedMYxV2XQ();
        }
        if ((i & 64) != 0) {
            f2 = C1956Dp.INSTANCE.m6317getUnspecifiedD9Ej5fM();
        }
        if ((i & 128) != 0) {
            f3 = C1956Dp.INSTANCE.m6317getUnspecifiedD9Ej5fM();
        }
        if ((i & 256) != 0) {
            z2 = true;
        }
        if ((i & 512) != 0) {
            platformMagnifierFactory = null;
        }
        return m484magnifierjPUL71Q(modifier, function1, function12, function13, f, z, j, f2, f3, z2, platformMagnifierFactory);
    }

    /* renamed from: magnifier-jPUL71Q, reason: not valid java name */
    public static final Modifier m484magnifierjPUL71Q(Modifier $this$magnifier_u2djPUL71Q, final Function1<? super Density, Offset> function1, final Function1<? super Density, Offset> function12, Function1<? super DpSize, Unit> function13, final float zoom, boolean useTextDefault, final long size, final float cornerRadius, final float elevation, final boolean clippingEnabled, PlatformMagnifierFactory platformMagnifierFactory) {
        PlatformMagnifierFactory forCurrentPlatform;
        if (isPlatformMagnifierSupported$default(0, 1, null)) {
            if (platformMagnifierFactory != null) {
                forCurrentPlatform = platformMagnifierFactory;
            } else {
                forCurrentPlatform = PlatformMagnifierFactory.INSTANCE.getForCurrentPlatform();
            }
            Modifier $this$inspectable$iv = $this$magnifier_u2djPUL71Q.then(new MagnifierElement(function1, function12, function13, zoom, useTextDefault, size, cornerRadius, elevation, clippingEnabled, forCurrentPlatform, null));
            return $this$inspectable$iv;
        }
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.Magnifier_androidKt$magnifier-jPUL71Q$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                $this$null.setName("magnifier (not supported)");
                $this$null.getProperties().set("sourceCenter", function1);
                $this$null.getProperties().set("magnifierCenter", function12);
                $this$null.getProperties().set("zoom", Float.valueOf(zoom));
                $this$null.getProperties().set("size", DpSize.m6383boximpl(size));
                $this$null.getProperties().set("cornerRadius", C1956Dp.m6295boximpl(cornerRadius));
                $this$null.getProperties().set("elevation", C1956Dp.m6295boximpl(elevation));
                $this$null.getProperties().set("clippingEnabled", Boolean.valueOf(clippingEnabled));
            }
        } : InspectableValueKt.getNoInspectorInfo();
        Modifier $this$magnifier_jPUL71Q_u24lambda_u241 = Modifier.INSTANCE;
        Modifier $this$inspectable$iv2 = InspectableValueKt.inspectableWrapper($this$magnifier_u2djPUL71Q, inspectorInfo$iv, $this$magnifier_jPUL71Q_u24lambda_u241);
        return $this$inspectable$iv2;
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return isPlatformMagnifierSupported(i);
    }

    public static final boolean isPlatformMagnifierSupported(int sdkVersion) {
        return sdkVersion >= 28;
    }
}
