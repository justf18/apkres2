package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p000ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.SubcomposeLayoutKt;
import androidx.compose.p000ui.layout.SubcomposeMeasureScope;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.Velocity;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: BottomSheetScaffold.kt */
@Metadata(m164d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0093\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2'\u0010\r\u001a#\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f¢\u0006\u0002\b H\u0003ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001aÞ\u0002\u0010#\u001a\u00020\b2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f¢\u0006\u0002\b 2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010%\u001a\u00020&2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\u0019\b\u0002\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020\u00012 \b\u0002\u0010/\u001a\u001a\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e¢\u0006\u0002\b\u001f¢\u0006\u0002\b 2\b\b\u0002\u00100\u001a\u00020\f2\b\b\u0002\u00101\u001a\u00020\u00162\b\b\u0002\u00102\u001a\u00020\u00012\b\b\u0002\u00103\u001a\u00020\u00192\b\b\u0002\u00104\u001a\u00020\u00192\b\b\u0002\u00105\u001a\u00020\u00192\b\b\u0002\u00106\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u00020\u00192\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u0080\u0002\u0010#\u001a\u00020\b2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f¢\u0006\u0002\b 2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010%\u001a\u00020&2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\u0019\b\u0002\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020\u00012\b\b\u0002\u00106\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u00020\u00192\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001aÅ\u0001\u0010=\u001a\u00020\b2\u0013\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2&\u0010>\u001a\"\u0012\u0013\u0012\u001108¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f2&\u0010@\u001a\"\u0012\u0013\u0012\u00110A¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\b0(¢\u0006\u0002\b\u001f2\u0006\u0010.\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020D0(2\u0006\u0010E\u001a\u00020\nH\u0003ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001a4\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u00142\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020D0K2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u000eH\u0007\u001a \u0010H\u001a\u00020&2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020*H\u0007\u001a>\u0010Q\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u00142\u0006\u0010R\u001a\u00020S2\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020D0K2\u0014\b\u0002\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u000eH\u0007\u001a\u001c\u0010U\u001a\u00020V2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030W2\u0006\u0010X\u001a\u00020YH\u0002\u001a!\u0010Z\u001a\u00020&2\b\b\u0002\u0010O\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020*H\u0007¢\u0006\u0002\u0010[\u001a+\u0010Z\u001a\u00020&2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020*H\u0007¢\u0006\u0002\u0010\\\u001a;\u0010]\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u00142\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020D0K2\u0014\b\u0002\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u000eH\u0007¢\u0006\u0002\u0010^\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006_"}, m165d2 = {"BottomSheetScaffoldPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheetScaffoldVelocityThreshold", "BottomSheetScaffoldWithDrawerDeprecated", "", "FabSpacing", "BottomSheet", "", "state", "Landroidx/compose/material/BottomSheetState;", "sheetGesturesEnabled", "", "calculateAnchors", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "sheetSize", "Landroidx/compose/material/DraggableAnchors;", "Landroidx/compose/material/BottomSheetValue;", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomSheet-0cLKjW4", "(Landroidx/compose/material/BottomSheetState;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;FJJLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffold", "sheetContent", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetPeekHeight", "drawerContent", "drawerGesturesEnabled", "drawerShape", "drawerElevation", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-bGncdBI", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "BottomSheetScaffold-HnlDQGw", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "", "sheetState", "BottomSheetScaffoldLayout-KCBPh4w", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FILkotlin/jvm/functions/Function0;Landroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "BottomSheetScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "drawerState", "Landroidx/compose/material/DrawerState;", "bottomSheetState", "snackbarHostState", "BottomSheetState", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "rememberBottomSheetScaffoldState", "(Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BottomSheetScaffoldKt {
    private static final String BottomSheetScaffoldWithDrawerDeprecated = "BottomSheetScaffold with a drawer has been deprecated. To achieve the same functionality, wrap your BottomSheetScaffold in aModalDrawer. See BottomSheetScaffoldWithDrawerSample for more details.";
    private static final float FabSpacing = C1956Dp.m6297constructorimpl(16);
    private static final float BottomSheetScaffoldPositionalThreshold = C1956Dp.m6297constructorimpl(56);
    private static final float BottomSheetScaffoldVelocityThreshold = C1956Dp.m6297constructorimpl(125);

    public static /* synthetic */ BottomSheetState BottomSheetScaffoldState$default(BottomSheetValue bottomSheetValue, AnimationSpec animationSpec, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
        }
        return BottomSheetScaffoldState(bottomSheetValue, (AnimationSpec<Float>) animationSpec, (Function1<? super BottomSheetValue, Boolean>) function1);
    }

    @Deprecated(message = "This constructor is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "BottomSheetScaffoldState(initialValue, animationSpec, confirmStateChange)", imports = {}))
    public static final BottomSheetState BottomSheetScaffoldState(BottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> function1) {
        return new BottomSheetState(initialValue, animationSpec, function1);
    }

    public static /* synthetic */ BottomSheetState BottomSheetState$default(BottomSheetValue bottomSheetValue, Density density, AnimationSpec animationSpec, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            animationSpec = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 8) != 0) {
            function1 = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.BottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomSheetValue it) {
                    return true;
                }
            };
        }
        return BottomSheetState(bottomSheetValue, density, animationSpec, function1);
    }

    public static final BottomSheetState BottomSheetState(BottomSheetValue initialValue, Density density, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> function1) {
        BottomSheetState it = new BottomSheetState(initialValue, animationSpec, function1);
        it.setDensity$material_release(density);
        return it;
    }

    public static final BottomSheetState rememberBottomSheetState(final BottomSheetValue initialValue, final AnimationSpec<Float> animationSpec, final Function1<? super BottomSheetValue, Boolean> function1, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(1808153344);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetState)P(2)306@11010L7,307@11029L433:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            Function1 confirmStateChange = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.rememberBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomSheetValue it) {
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1808153344, $changed, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:305)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) objConsume;
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.m3566rememberSaveable(new Object[]{animationSpec}, (Saver) BottomSheetState.INSTANCE.Saver(animationSpec, function1, density), (String) null, (Function0) new Function0<BottomSheetState>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.rememberBottomSheetState.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomSheetState invoke() {
                return BottomSheetScaffoldKt.BottomSheetState(initialValue, density, animationSpec, function1);
            }
        }, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return bottomSheetState;
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Composer $composer2;
        Object value$iv$iv;
        Object value$iv$iv2;
        $composer.startReplaceableGroup(-1022285988);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetScaffoldState)346@12196L35,347@12276L32,349@12350L196:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            $composer2 = $composer;
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, $composer2, 6, 6);
        } else {
            $composer2 = $composer;
        }
        if ((i & 2) != 0) {
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = new SnackbarHostState();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) value$iv$iv2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1022285988, $changed, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:348)");
        }
        int i2 = ($changed & 14) | ($changed & 112);
        $composer2.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed(bottomSheetState) | $composer2.changed(snackbarHostState);
        Composer $this$cache$iv$iv2 = $composer2;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new BottomSheetScaffoldState(bottomSheetState, snackbarHostState);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer2.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer2.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = BottomSheetScaffoldWithDrawerDeprecated)
    public static final BottomSheetScaffoldState BottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState) {
        throw new IllegalStateException(BottomSheetScaffoldWithDrawerDeprecated.toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = BottomSheetScaffoldWithDrawerDeprecated)
    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Composer $composer2;
        Object value$iv$iv;
        $composer.startReplaceableGroup(-1353009744);
        ComposerKt.sourceInformation($composer, "C(rememberBottomSheetScaffoldState)P(1)385@13723L39,386@13805L35,387@13885L32:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            DrawerKt.rememberDrawerState(DrawerValue.Closed, null, $composer, 6, 2);
        }
        if ((i & 2) == 0) {
            $composer2 = $composer;
        } else {
            $composer2 = $composer;
            rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, $composer2, 6, 6);
        }
        if ((i & 4) != 0) {
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new SnackbarHostState();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1353009744, $changed, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:388)");
        }
        throw new IllegalStateException(BottomSheetScaffoldWithDrawerDeprecated.toString());
    }

    /* renamed from: BottomSheetScaffold-HnlDQGw, reason: not valid java name */
    public static final void m1447BottomSheetScaffoldHnlDQGw(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, Function2<? super Composer, ? super Integer, Unit> function22, int floatingActionButtonPosition, boolean sheetGesturesEnabled, Shape sheetShape, float sheetElevation, long sheetBackgroundColor, long sheetContentColor, float sheetPeekHeight, long backgroundColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        final BottomSheetScaffoldState scaffoldState2;
        Function2 topBar;
        Function3 snackbarHost;
        Function2 floatingActionButton;
        int floatingActionButtonPosition2;
        int i2;
        int $dirty1;
        long sheetContentColor2;
        int $dirty12;
        CornerBasedShape sheetShape2;
        float sheetElevation2;
        boolean sheetGesturesEnabled2;
        long sheetBackgroundColor2;
        int $dirty13;
        long sheetBackgroundColor3;
        long backgroundColor2;
        long contentColor2;
        long backgroundColor3;
        boolean sheetGesturesEnabled3;
        float sheetPeekHeight2;
        final boolean sheetGesturesEnabled4;
        Composer $composer2;
        final Function2 topBar2;
        final Modifier modifier3;
        final BottomSheetScaffoldState scaffoldState3;
        final float sheetPeekHeight3;
        final boolean sheetGesturesEnabled5;
        final long sheetContentColor3;
        final Function3 snackbarHost2;
        final Shape sheetShape3;
        final Function2 floatingActionButton2;
        final int floatingActionButtonPosition3;
        final float sheetElevation3;
        final long sheetBackgroundColor4;
        final long contentColor3;
        final long backgroundColor4;
        int $dirty14;
        Composer $composer3 = $composer.startRestartGroup(-423121424);
        ComposerKt.sourceInformation($composer3, "C(BottomSheetScaffold)P(8,5,6,15,14,3,4:c#material.FabPosition,11,13,10:c#ui.unit.Dp,7:c#ui.graphics.Color,9:c#ui.graphics.Color,12:c#ui.unit.Dp,0:c#ui.graphics.Color,2:c#ui.graphics.Color)438@17024L34,444@17393L6,446@17524L6,447@17571L37,449@17724L6,450@17769L32,454@17970L7,455@17982L75,*459@18100L7,460@18140L2377:BottomSheetScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                scaffoldState2 = scaffoldState;
                int i4 = $composer3.changed(scaffoldState2) ? 256 : 128;
                $dirty |= i4;
            } else {
                scaffoldState2 = scaffoldState;
            }
            $dirty |= i4;
        } else {
            scaffoldState2 = scaffoldState;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            topBar = function2;
        } else if (($changed & 7168) == 0) {
            topBar = function2;
            $dirty |= $composer3.changedInstance(topBar) ? 2048 : 1024;
        } else {
            topBar = function2;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            snackbarHost = function32;
        } else if (($changed & 57344) == 0) {
            snackbarHost = function32;
            $dirty |= $composer3.changedInstance(snackbarHost) ? 16384 : 8192;
        } else {
            snackbarHost = function32;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            floatingActionButton = function22;
        } else if (($changed & 458752) == 0) {
            floatingActionButton = function22;
            $dirty |= $composer3.changedInstance(floatingActionButton) ? 131072 : 65536;
        } else {
            floatingActionButton = function22;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        } else if (($changed & 3670016) == 0) {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
            $dirty |= $composer3.changed(floatingActionButtonPosition2) ? 1048576 : 524288;
        } else {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer3.changed(sheetGesturesEnabled) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            $dirty |= ((i & 256) == 0 && $composer3.changed(sheetShape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
            i2 = i10;
        } else if (($changed & 1879048192) == 0) {
            i2 = i10;
            $dirty |= $composer3.changed(sheetElevation) ? 536870912 : 268435456;
        } else {
            i2 = i10;
        }
        if (($changed1 & 14) == 0) {
            if ((i & 1024) == 0) {
                $dirty14 = $changed1;
                int i11 = $composer3.changed(sheetBackgroundColor) ? 4 : 2;
                $dirty1 = $dirty14 | i11;
            } else {
                $dirty14 = $changed1;
            }
            $dirty1 = $dirty14 | i11;
        } else {
            $dirty1 = $changed1;
        }
        if (($changed1 & 112) == 0) {
            int $dirty15 = $dirty1;
            int $dirty16 = i & 2048;
            if ($dirty16 == 0) {
                sheetContentColor2 = sheetContentColor;
                int i12 = $composer3.changed(sheetContentColor2) ? 32 : 16;
                $dirty1 = $dirty15 | i12;
            } else {
                sheetContentColor2 = sheetContentColor;
            }
            $dirty1 = $dirty15 | i12;
        } else {
            sheetContentColor2 = sheetContentColor;
        }
        int i13 = i & 4096;
        if (i13 != 0) {
            $dirty12 = $dirty1 | 384;
        } else {
            $dirty12 = $dirty1;
            int $dirty17 = $changed1 & 896;
            if ($dirty17 == 0) {
                $dirty12 |= $composer3.changed(sheetPeekHeight) ? 256 : 128;
            }
        }
        if (($changed1 & 7168) == 0) {
            $dirty12 |= ((i & 8192) == 0 && $composer3.changed(backgroundColor)) ? 2048 : 1024;
        }
        if (($changed1 & 57344) == 0) {
            $dirty12 |= ((i & 16384) == 0 && $composer3.changed(contentColor)) ? 16384 : 8192;
        }
        if ((i & 32768) != 0) {
            $dirty12 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed1 & 458752) == 0) {
            $dirty12 |= $composer3.changedInstance(function33) ? 131072 : 65536;
        }
        if ((1533916891 & $dirty) == 306783378 && ($dirty12 & 374491) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            sheetElevation3 = sheetElevation;
            sheetPeekHeight3 = sheetPeekHeight;
            backgroundColor4 = backgroundColor;
            contentColor3 = contentColor;
            snackbarHost2 = snackbarHost;
            modifier3 = modifier2;
            scaffoldState3 = scaffoldState2;
            sheetShape3 = sheetShape;
            $composer2 = $composer3;
            sheetContentColor3 = sheetContentColor2;
            topBar2 = topBar;
            floatingActionButton2 = floatingActionButton;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            sheetGesturesEnabled5 = sheetGesturesEnabled;
            sheetBackgroundColor4 = sheetBackgroundColor;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    scaffoldState2 = rememberBottomSheetScaffoldState(null, null, $composer3, 0, 3);
                }
                if (i5 != 0) {
                    topBar = null;
                }
                if (i6 != 0) {
                    snackbarHost = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1516getLambda1$material_release();
                }
                if (i7 != 0) {
                    floatingActionButton = null;
                }
                if (i8 != 0) {
                    floatingActionButtonPosition2 = FabPosition.INSTANCE.m1567getEnd5ygKITE();
                }
                boolean sheetGesturesEnabled6 = i9 != 0 ? true : sheetGesturesEnabled;
                if ((i & 256) != 0) {
                    sheetShape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getLarge();
                    $dirty &= -234881025;
                } else {
                    sheetShape2 = sheetShape;
                }
                sheetElevation2 = i2 != 0 ? BottomSheetScaffoldDefaults.INSTANCE.m1444getSheetElevationD9Ej5fM() : sheetElevation;
                if ((i & 1024) != 0) {
                    $dirty12 &= -15;
                    sheetGesturesEnabled2 = sheetGesturesEnabled6;
                    sheetBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1494getSurface0d7_KjU();
                } else {
                    sheetGesturesEnabled2 = sheetGesturesEnabled6;
                    sheetBackgroundColor2 = sheetBackgroundColor;
                }
                if ((i & 2048) != 0) {
                    sheetContentColor2 = ColorsKt.m1508contentColorForek8zF_U(sheetBackgroundColor2, $composer3, $dirty12 & 14);
                    $dirty13 = $dirty12 & (-113);
                } else {
                    $dirty13 = $dirty12;
                }
                float sheetPeekHeight4 = i13 != 0 ? BottomSheetScaffoldDefaults.INSTANCE.m1445getSheetPeekHeightD9Ej5fM() : sheetPeekHeight;
                sheetBackgroundColor3 = sheetBackgroundColor2;
                if ((i & 8192) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1483getBackground0d7_KjU();
                    $dirty13 &= -7169;
                } else {
                    backgroundColor2 = backgroundColor;
                }
                float sheetPeekHeight5 = sheetPeekHeight4;
                if ((i & 16384) != 0) {
                    long contentColor4 = ColorsKt.m1508contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty13 >> 9) & 14);
                    $dirty13 = (-57345) & $dirty13;
                    contentColor2 = contentColor4;
                    backgroundColor3 = backgroundColor2;
                    sheetGesturesEnabled3 = sheetGesturesEnabled2;
                    sheetPeekHeight2 = sheetPeekHeight5;
                } else {
                    contentColor2 = contentColor;
                    backgroundColor3 = backgroundColor2;
                    sheetGesturesEnabled3 = sheetGesturesEnabled2;
                    sheetPeekHeight2 = sheetPeekHeight5;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 256) != 0) {
                    $dirty &= -234881025;
                }
                if ((i & 1024) != 0) {
                    $dirty12 &= -15;
                }
                if ((i & 2048) != 0) {
                    $dirty12 &= -113;
                }
                int $dirty18 = $dirty12;
                if ((i & 8192) != 0) {
                    $dirty18 &= -7169;
                }
                if ((i & 16384) != 0) {
                    $dirty18 &= -57345;
                }
                sheetShape2 = sheetShape;
                sheetElevation2 = sheetElevation;
                sheetBackgroundColor3 = sheetBackgroundColor;
                sheetPeekHeight2 = sheetPeekHeight;
                backgroundColor3 = backgroundColor;
                contentColor2 = contentColor;
                $dirty13 = $dirty18;
                sheetGesturesEnabled3 = sheetGesturesEnabled;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                sheetGesturesEnabled4 = sheetGesturesEnabled3;
                ComposerKt.traceEventStart(-423121424, $dirty, $dirty13, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:452)");
            } else {
                sheetGesturesEnabled4 = sheetGesturesEnabled3;
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) objConsume;
            $composer3.startReplaceableGroup(750835211);
            boolean invalid$iv = $composer3.changed(scaffoldState2) | $composer3.changed(density);
            Object value$iv = $composer3.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        scaffoldState2.getBottomSheetState().setDensity$material_release(density);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            }
            $composer3.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) value$iv, $composer3, 0);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density $this$BottomSheetScaffold_HnlDQGw_u24lambda_u245 = (Density) objConsume2;
            final float peekHeightPx = $this$BottomSheetScaffold_HnlDQGw_u24lambda_u245.mo518toPx0680j_4(sheetPeekHeight2);
            final float sheetPeekHeight6 = sheetPeekHeight2;
            final long sheetContentColor4 = sheetContentColor2;
            final Function2 topBar3 = topBar;
            final Function3 snackbarHost3 = snackbarHost;
            final Shape sheetShape4 = sheetShape2;
            final Function2 floatingActionButton3 = floatingActionButton;
            final int floatingActionButtonPosition4 = floatingActionButtonPosition2;
            final BottomSheetScaffoldState scaffoldState4 = scaffoldState2;
            final float sheetElevation4 = sheetElevation2;
            final long sheetBackgroundColor5 = sheetBackgroundColor3;
            boolean sheetGesturesEnabled7 = sheetGesturesEnabled4;
            long backgroundColor5 = backgroundColor3;
            long contentColor5 = contentColor2;
            SurfaceKt.m1669SurfaceFjzlyU(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), null, backgroundColor5, contentColor5, null, 0.0f, ComposableLambdaKt.composableLambda($composer3, -131096268, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    Object value$iv2;
                    ComposerKt.sourceInformation($composer4, "C466@18279L2232:BottomSheetScaffold.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-131096268, $changed2, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:466)");
                        }
                        BottomSheetState bottomSheetState = scaffoldState4.getBottomSheetState();
                        Function2<Composer, Integer, Unit> function23 = topBar3;
                        Function3<PaddingValues, Composer, Integer, Unit> function34 = function33;
                        final boolean z = sheetGesturesEnabled4;
                        final BottomSheetScaffoldState bottomSheetScaffoldState = scaffoldState4;
                        final float f = sheetPeekHeight6;
                        final float f2 = peekHeightPx;
                        final Shape shape = sheetShape4;
                        final float f3 = sheetElevation4;
                        final long j = sheetBackgroundColor5;
                        final long j2 = sheetContentColor4;
                        final Function3<ColumnScope, Composer, Integer, Unit> function35 = function3;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda($composer4, -1900337132, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer, Integer num2) {
                                invoke(num.intValue(), composer, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final int layoutHeight, Composer $composer5, int $changed3) {
                                Modifier.Companion nestedScroll;
                                Object value$iv3;
                                Object value$iv$iv;
                                ComposerKt.sourceInformation($composer5, "C481@19031L1038:BottomSheetScaffold.kt#jmzs0o");
                                int $dirty2 = $changed3;
                                if (($changed3 & 14) == 0) {
                                    $dirty2 |= $composer5.changed(layoutHeight) ? 4 : 2;
                                }
                                if (($dirty2 & 91) != 18 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1900337132, $dirty2, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:470)");
                                    }
                                    $composer5.startReplaceableGroup(-816851224);
                                    ComposerKt.sourceInformation($composer5, "473@18566L390");
                                    if (z) {
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        Object key1$iv = bottomSheetScaffoldState.getBottomSheetState().getAnchoredDraggableState$material_release();
                                        BottomSheetScaffoldState bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                                        $composer5.startReplaceableGroup(1157296644);
                                        ComposerKt.sourceInformation($composer5, "CC(remember)P(1):Composables.kt#9igjgp");
                                        boolean invalid$iv$iv = $composer5.changed(key1$iv);
                                        Object it$iv$iv = $composer5.rememberedValue();
                                        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                                            value$iv$iv = BottomSheetScaffoldKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(bottomSheetScaffoldState2.getBottomSheetState().getAnchoredDraggableState$material_release(), Orientation.Vertical);
                                            $composer5.updateRememberedValue(value$iv$iv);
                                        } else {
                                            value$iv$iv = it$iv$iv;
                                        }
                                        $composer5.endReplaceableGroup();
                                        nestedScroll = NestedScrollModifierKt.nestedScroll$default(companion, (NestedScrollConnection) value$iv$iv, null, 2, null);
                                    } else {
                                        nestedScroll = Modifier.INSTANCE;
                                    }
                                    $composer5.endReplaceableGroup();
                                    BottomSheetState bottomSheetState2 = bottomSheetScaffoldState.getBottomSheetState();
                                    Modifier modifierM807requiredHeightInVpY3zN4$default = SizeKt.m807requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(nestedScroll, 0.0f, 1, null), f, 0.0f, 2, null);
                                    boolean z2 = z;
                                    $composer5.startReplaceableGroup(750836511);
                                    boolean invalid$iv2 = $composer5.changed(layoutHeight) | $composer5.changed(f2);
                                    final float f4 = f2;
                                    Object it$iv = $composer5.rememberedValue();
                                    if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                                        value$iv3 = (Function1) new Function1<IntSize, DraggableAnchors<BottomSheetValue>>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ DraggableAnchors<BottomSheetValue> invoke(IntSize intSize) {
                                                return m1453invokeozmzZPI(intSize.getPackedValue());
                                            }

                                            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                            public final DraggableAnchors<BottomSheetValue> m1453invokeozmzZPI(long sheetSize) {
                                                final float sheetHeight = IntSize.m6466getHeightimpl(sheetSize);
                                                final int i14 = layoutHeight;
                                                final float f5 = f4;
                                                return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomSheetValue>, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$1$1$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                                        invoke2(draggableAnchorsConfig);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                                        draggableAnchorsConfig.m12at(BottomSheetValue.Collapsed, i14 - f5);
                                                        if (sheetHeight > 0.0f) {
                                                            if (!(sheetHeight == f5)) {
                                                                draggableAnchorsConfig.m12at(BottomSheetValue.Expanded, i14 - sheetHeight);
                                                            }
                                                        }
                                                    }
                                                });
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv3);
                                    } else {
                                        value$iv3 = it$iv;
                                    }
                                    $composer5.endReplaceableGroup();
                                    BottomSheetScaffoldKt.m1446BottomSheet0cLKjW4(bottomSheetState2, z2, (Function1) value$iv3, shape, f3, j, j2, modifierM807requiredHeightInVpY3zN4$default, function35, $composer5, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        });
                        Function2<Composer, Integer, Unit> function24 = floatingActionButton3;
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function36 = snackbarHost3;
                        final BottomSheetScaffoldState bottomSheetScaffoldState2 = scaffoldState4;
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda($composer4, -1011922215, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C505@20187L45:BottomSheetScaffold.kt#jmzs0o");
                                if (($changed3 & 11) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1011922215, $changed3, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:505)");
                                }
                                function36.invoke(bottomSheetScaffoldState2.getSnackbarHostState(), $composer5, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        float f4 = sheetPeekHeight6;
                        int i14 = floatingActionButtonPosition4;
                        $composer4.startReplaceableGroup(750837492);
                        boolean invalid$iv2 = $composer4.changed(scaffoldState4);
                        final BottomSheetScaffoldState bottomSheetScaffoldState3 = scaffoldState4;
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$3$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(bottomSheetScaffoldState3.getBottomSheetState().requireOffset());
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv;
                        }
                        $composer4.endReplaceableGroup();
                        BottomSheetScaffoldKt.m1449BottomSheetScaffoldLayoutKCBPh4w(function23, function34, composableLambda, function24, composableLambda2, f4, i14, (Function0) value$iv2, bottomSheetState, $composer4, 24960);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, (($dirty13 >> 3) & 896) | 1572864 | (($dirty13 >> 3) & 7168), 50);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            topBar2 = topBar;
            modifier3 = modifier2;
            scaffoldState3 = scaffoldState2;
            sheetPeekHeight3 = sheetPeekHeight6;
            sheetGesturesEnabled5 = sheetGesturesEnabled7;
            sheetContentColor3 = sheetContentColor2;
            snackbarHost2 = snackbarHost;
            sheetShape3 = sheetShape2;
            floatingActionButton2 = floatingActionButton;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            sheetElevation3 = sheetElevation2;
            sheetBackgroundColor4 = sheetBackgroundColor3;
            contentColor3 = contentColor5;
            backgroundColor4 = backgroundColor5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i14) {
                    BottomSheetScaffoldKt.m1447BottomSheetScaffoldHnlDQGw(function3, modifier3, scaffoldState3, topBar2, snackbarHost2, floatingActionButton2, floatingActionButtonPosition3, sheetGesturesEnabled5, sheetShape3, sheetElevation3, sheetBackgroundColor4, sheetContentColor3, sheetPeekHeight3, backgroundColor4, contentColor3, function33, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0311  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = androidx.compose.material.BottomSheetScaffoldKt.BottomSheetScaffoldWithDrawerDeprecated)
    /* renamed from: BottomSheetScaffold-bGncdBI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1448BottomSheetScaffoldbGncdBI(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, final androidx.compose.p000ui.Modifier r42, final androidx.compose.material.BottomSheetScaffoldState r43, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, final kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, final int r47, final boolean r48, final androidx.compose.p000ui.graphics.Shape r49, final float r50, long r51, final long r53, final float r55, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, final boolean r57, final androidx.compose.p000ui.graphics.Shape r58, final float r59, long r60, final long r62, final long r64, long r66, final long r68, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r70, androidx.compose.runtime.Composer r71, final int r72, final int r73, final int r74, final int r75) {
        /*
            Method dump skipped, instructions count: 801
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m1448BottomSheetScaffoldbGncdBI(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomSheetScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, androidx.compose.ui.graphics.Shape, float, long, long, float, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* renamed from: BottomSheet-0cLKjW4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1446BottomSheet0cLKjW4(final androidx.compose.material.BottomSheetState r28, final boolean r29, final kotlin.jvm.functions.Function1<? super androidx.compose.p000ui.unit.IntSize, ? extends androidx.compose.material.DraggableAnchors<androidx.compose.material.BottomSheetValue>> r30, final androidx.compose.p000ui.graphics.Shape r31, final float r32, final long r33, final long r35, androidx.compose.p000ui.Modifier r37, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m1446BottomSheet0cLKjW4(androidx.compose.material.BottomSheetState, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.graphics.Shape, float, long, long, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-KCBPh4w, reason: not valid java name */
    public static final void m1449BottomSheetScaffoldLayoutKCBPh4w(final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final float sheetPeekHeight, final int floatingActionButtonPosition, final Function0<Float> function0, final BottomSheetState sheetState, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1621720523);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetScaffoldLayout)P(8!3,7,5:c#ui.unit.Dp,3:c#material.FabPosition)687@28825L3007:BottomSheetScaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function32) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function23) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changed(sheetPeekHeight) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer2.changed(floatingActionButtonPosition) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 8388608 : 4194304;
        }
        if ((234881024 & $changed) == 0) {
            $dirty |= $composer2.changed(sheetState) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((191739611 & $dirty) != 38347922 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1621720523, $dirty, -1, "androidx.compose.material.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:686)");
            }
            $composer2.startReplaceableGroup(750846060);
            boolean invalid$iv = $composer2.changedInstance(function32) | $composer2.changedInstance(function2) | $composer2.changedInstance(function3) | $composer2.changed(sheetPeekHeight) | $composer2.changedInstance(function22) | $composer2.changedInstance(function23) | $composer2.changedInstance(function0) | $composer2.changed(floatingActionButtonPosition) | $composer2.changed(sheetState);
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1454invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX WARN: Removed duplicated region for block: B:108:0x035e  */
                    /* JADX WARN: Removed duplicated region for block: B:109:0x0364  */
                    /* JADX WARN: Removed duplicated region for block: B:28:0x010d  */
                    /* JADX WARN: Removed duplicated region for block: B:58:0x0227  */
                    /* JADX WARN: Removed duplicated region for block: B:73:0x0276  */
                    /* JADX WARN: Removed duplicated region for block: B:77:0x0297 A[LOOP:4: B:76:0x0295->B:77:0x0297, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:80:0x02cf  */
                    /* JADX WARN: Removed duplicated region for block: B:81:0x02d3  */
                    /* JADX WARN: Removed duplicated region for block: B:92:0x030f  */
                    /* JADX WARN: Removed duplicated region for block: B:93:0x0315  */
                    /* JADX WARN: Removed duplicated region for block: B:96:0x0320  */
                    /* JADX WARN: Removed duplicated region for block: B:97:0x0322  */
                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final androidx.compose.p000ui.layout.MeasureResult m1454invoke0kLqBqw(final androidx.compose.p000ui.layout.SubcomposeMeasureScope r33, long r34) {
                        /*
                            Method dump skipped, instructions count: 917
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.m1454invoke0kLqBqw(androidx.compose.ui.layout.SubcomposeMeasureScope, long):androidx.compose.ui.layout.MeasureResult");
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) value$iv, $composer2, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    BottomSheetScaffoldKt.m1449BottomSheetScaffoldLayoutKCBPh4w(function2, function3, function32, function22, function23, sheetPeekHeight, floatingActionButtonPosition, function0, sheetState, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* compiled from: BottomSheetScaffold.kt */
    @Metadata(m164d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, m165d2 = {"androidx/compose/material/BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1 */
    public static final class C09571 implements NestedScrollConnection {
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ AnchoredDraggableState<?> $state;

        C09571(AnchoredDraggableState<?> anchoredDraggableState, Orientation $orientation) {
            this.$state = anchoredDraggableState;
            this.$orientation = $orientation;
        }

        @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPreScroll-OzD1aCk */
        public long mo606onPreScrollOzD1aCk(long available, int source) {
            float delta = offsetToFloat(available);
            if (delta < 0.0f && NestedScrollSource.m4982equalsimpl0(source, NestedScrollSource.INSTANCE.m4987getDragWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(delta));
            }
            return Offset.INSTANCE.m3724getZeroF1C5BW0();
        }

        @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPostScroll-DzOQY0M */
        public long mo605onPostScrollDzOQY0M(long consumed, long available, int source) {
            if (NestedScrollSource.m4982equalsimpl0(source, NestedScrollSource.INSTANCE.m4987getDragWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(offsetToFloat(available)));
            }
            return Offset.INSTANCE.m3724getZeroF1C5BW0();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPreFling-QWom1Mo */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object mo846onPreFlingQWom1Mo(long r7, kotlin.coroutines.Continuation<? super androidx.compose.p000ui.unit.Velocity> r9) {
            /*
                r6 = this;
                boolean r0 = r9 instanceof androidx.compose.material.C0959xe2eca24b
                if (r0 == 0) goto L14
                r0 = r9
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material.C0959xe2eca24b) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L19
            L14:
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
                r0.<init>(r6, r9)
            L19:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                switch(r2) {
                    case 0: goto L32;
                    case 1: goto L2c;
                    default: goto L24;
                }
            L24:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L2c:
                long r7 = r0.J$0
                kotlin.ResultKt.throwOnFailure(r9)
                goto L61
            L32:
                kotlin.ResultKt.throwOnFailure(r9)
                r2 = r6
                float r3 = r2.velocityToFloat(r7)
                androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
                float r4 = r4.requireOffset()
                r5 = 0
                int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r5 >= 0) goto L62
                androidx.compose.material.AnchoredDraggableState<?> r5 = r2.$state
                androidx.compose.material.DraggableAnchors r5 = r5.getAnchors()
                float r5 = r5.minAnchor()
                int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r5 <= 0) goto L62
                androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
                r0.J$0 = r7
                r5 = 1
                r0.label = r5
                java.lang.Object r2 = r4.settle(r3, r0)
                if (r2 != r1) goto L61
                return r1
            L61:
                goto L68
            L62:
                androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.p000ui.unit.Velocity.INSTANCE
                long r7 = r7.m6543getZero9UxMQ8M()
            L68:
                androidx.compose.ui.unit.Velocity r7 = androidx.compose.p000ui.unit.Velocity.m6523boximpl(r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.C09571.mo846onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPostFling-RZ2iAVY */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object mo604onPostFlingRZ2iAVY(long r5, long r7, kotlin.coroutines.Continuation<? super androidx.compose.p000ui.unit.Velocity> r9) {
            /*
                r4 = this;
                boolean r5 = r9 instanceof androidx.compose.material.C0958x8eaee744
                if (r5 == 0) goto L14
                r5 = r9
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = (androidx.compose.material.C0958x8eaee744) r5
                int r6 = r5.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = r6 & r0
                if (r6 == 0) goto L14
                int r6 = r5.label
                int r6 = r6 - r0
                r5.label = r6
                goto L19
            L14:
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = new androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
                r5.<init>(r4, r9)
            L19:
                java.lang.Object r6 = r5.result
                java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r5.label
                switch(r0) {
                    case 0: goto L32;
                    case 1: goto L2c;
                    default: goto L24;
                }
            L24:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2c:
                long r7 = r5.J$0
                kotlin.ResultKt.throwOnFailure(r6)
                goto L48
            L32:
                kotlin.ResultKt.throwOnFailure(r6)
                r0 = r4
                androidx.compose.material.AnchoredDraggableState<?> r1 = r0.$state
                float r2 = r0.velocityToFloat(r7)
                r5.J$0 = r7
                r3 = 1
                r5.label = r3
                java.lang.Object r0 = r1.settle(r2, r5)
                if (r0 != r9) goto L48
                return r9
            L48:
                androidx.compose.ui.unit.Velocity r9 = androidx.compose.p000ui.unit.Velocity.m6523boximpl(r7)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.C09571.mo604onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private final long toOffset(float $this$toOffset) {
            return OffsetKt.Offset(this.$orientation == Orientation.Horizontal ? $this$toOffset : 0.0f, this.$orientation == Orientation.Vertical ? $this$toOffset : 0.0f);
        }

        private final float velocityToFloat(long $this$toFloat) {
            return this.$orientation == Orientation.Horizontal ? Velocity.m6532getXimpl($this$toFloat) : Velocity.m6533getYimpl($this$toFloat);
        }

        private final float offsetToFloat(long $this$toFloat) {
            return this.$orientation == Orientation.Horizontal ? Offset.m3708getXimpl($this$toFloat) : Offset.m3709getYimpl($this$toFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new C09571(anchoredDraggableState, orientation);
    }
}
