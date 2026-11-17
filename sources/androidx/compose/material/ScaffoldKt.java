package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.layout.SubcomposeLayoutKt;
import androidx.compose.p000ui.layout.SubcomposeMeasureScope;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: Scaffold.kt */
@Metadata(m164d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¨\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0006\u0010!\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a§\u0002\u0010&\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\u0013\b\u0002\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a2\u0013\b\u0002\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010.\u001a\u00020\u00172\b\b\u0002\u0010/\u001a\u00020\t2 \b\u0002\u00100\u001a\u001a\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b22\b\b\u0002\u00103\u001a\u00020\t2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00012\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u0002082\b\b\u0002\u0010:\u001a\u0002082\b\b\u0002\u0010;\u001a\u0002082\b\b\u0002\u0010<\u001a\u0002082\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a\u009f\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\u0013\b\u0002\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a2\u0013\b\u0002\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010.\u001a\u00020\u00172\b\b\u0002\u0010/\u001a\u00020\t2 \b\u0002\u00100\u001a\u001a\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b22\b\b\u0002\u00103\u001a\u00020\t2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00012\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u0002082\b\b\u0002\u0010:\u001a\u0002082\b\b\u0002\u0010;\u001a\u0002082\b\b\u0002\u0010<\u001a\u0002082\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a¨\u0001\u0010A\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0006\u0010!\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\bB\u0010%\u001a¨\u0001\u0010C\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0006\u0010!\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\bD\u0010%\u001a!\u0010E\u001a\u00020*2\b\b\u0002\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020,H\u0007¢\u0006\u0002\u0010I\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"1\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J"}, m165d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "<set-?>", "", "ScaffoldSubcomposeInMeasureFix", "getScaffoldSubcomposeInMeasureFix$annotations", "()V", "getScaffoldSubcomposeInMeasureFix", "()Z", "setScaffoldSubcomposeInMeasureFix", "(Z)V", "ScaffoldSubcomposeInMeasureFix$delegate", "Landroidx/compose/runtime/MutableState;", "LegacyScaffoldLayout", "", "isFabDocked", "fabPosition", "Landroidx/compose/material/FabPosition;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "snackbar", "fab", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "bottomBar", "LegacyScaffoldLayout-i1QSOvI", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Scaffold", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "isFloatingActionButtonDocked", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "Scaffold-u4IkXBM", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "ScaffoldLayout-i1QSOvI", "ScaffoldLayoutWithMeasureFix", "ScaffoldLayoutWithMeasureFix-i1QSOvI", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ScaffoldKt {
    private static final MutableState ScaffoldSubcomposeInMeasureFix$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = C1956Dp.m6297constructorimpl(16);

    public static /* synthetic */ void getScaffoldSubcomposeInMeasureFix$annotations() {
    }

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        $composer.startReplaceableGroup(1569641925);
        ComposerKt.sourceInformation($composer, "C(rememberScaffoldState)74@2854L39,75@2938L32,76@2990L62:Scaffold.kt#jmzs0o");
        if ((i & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, $composer, 6, 2);
        }
        if ((i & 2) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = new SnackbarHostState();
                $composer.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) value$iv$iv2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1569641925, $changed, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:76)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv2 = $composer.rememberedValue();
        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new ScaffoldState(drawerState, snackbarHostState);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return scaffoldState;
    }

    /* renamed from: Scaffold-u4IkXBM, reason: not valid java name */
    public static final void m1636Scaffoldu4IkXBM(final WindowInsets contentWindowInsets, Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, int floatingActionButtonPosition, final boolean isFloatingActionButtonDocked, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        ScaffoldState scaffoldState2;
        Function2 topBar;
        Function2 bottomBar;
        Function3 snackbarHost;
        Function2 floatingActionButton;
        int floatingActionButtonPosition2;
        int i2;
        int i3;
        int i4;
        int i5;
        int $dirty1;
        int i6;
        long j;
        int $dirty12;
        CornerBasedShape drawerShape2;
        int $dirty13;
        float drawerElevation2;
        boolean isFloatingActionButtonDocked2;
        int $dirty;
        boolean drawerGesturesEnabled2;
        long drawerBackgroundColor2;
        long drawerContentColor2;
        int i7;
        long drawerScrimColor2;
        Function3 drawerContent;
        long backgroundColor2;
        long contentColor2;
        int $dirty2;
        long backgroundColor3;
        int $dirty14;
        Function3 drawerContent2;
        boolean drawerGesturesEnabled3;
        Function3 drawerContent3;
        boolean drawerGesturesEnabled4;
        boolean drawerGesturesEnabled5;
        boolean isFloatingActionButtonDocked3;
        Composer $composer2;
        Function3 drawerContent4;
        final Function2 topBar2;
        final int floatingActionButtonPosition3;
        final long drawerBackgroundColor3;
        final Function2 bottomBar2;
        final Function3 snackbarHost2;
        final boolean isFloatingActionButtonDocked4;
        final Function3 snackbarHost3;
        final Modifier modifier3;
        final Shape drawerShape3;
        final Function2 floatingActionButton2;
        final boolean drawerGesturesEnabled6;
        final ScaffoldState scaffoldState3;
        final float drawerElevation3;
        final long drawerContentColor3;
        final long drawerScrimColor3;
        final long backgroundColor4;
        final long contentColor3;
        int $dirty15;
        Composer $composer3 = $composer.startRestartGroup(-1288630565);
        ComposerKt.sourceInformation($composer3, "C(Scaffold)P(4,15,16,18,1,17,12,13:c#material.FabPosition,14,6,9,11,8:c#ui.unit.Dp,5:c#ui.graphics.Color,7:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)187@8483L23,196@8993L6,198@9108L6,199@9156L38,200@9241L10,201@9296L6,202@9341L32,205@9449L86:Scaffold.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty16 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(contentWindowInsets) ? 4 : 2;
        }
        int i8 = i & 2;
        if (i8 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                scaffoldState2 = scaffoldState;
                int i9 = $composer3.changed(scaffoldState2) ? 256 : 128;
                $dirty3 |= i9;
            } else {
                scaffoldState2 = scaffoldState;
            }
            $dirty3 |= i9;
        } else {
            scaffoldState2 = scaffoldState;
        }
        int i10 = i & 8;
        int i11 = 1024;
        if (i10 != 0) {
            $dirty3 |= 3072;
            topBar = function2;
        } else if (($changed & 7168) == 0) {
            topBar = function2;
            $dirty3 |= $composer3.changedInstance(topBar) ? 2048 : 1024;
        } else {
            topBar = function2;
        }
        int i12 = i & 16;
        if (i12 != 0) {
            $dirty3 |= 24576;
            bottomBar = function22;
        } else if (($changed & 57344) == 0) {
            bottomBar = function22;
            $dirty3 |= $composer3.changedInstance(bottomBar) ? 16384 : 8192;
        } else {
            bottomBar = function22;
        }
        int i13 = i & 32;
        if (i13 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            snackbarHost = function3;
        } else if (($changed & 458752) == 0) {
            snackbarHost = function3;
            $dirty3 |= $composer3.changedInstance(snackbarHost) ? 131072 : 65536;
        } else {
            snackbarHost = function3;
        }
        int i14 = i & 64;
        if (i14 != 0) {
            $dirty3 |= 1572864;
            floatingActionButton = function23;
        } else if (($changed & 3670016) == 0) {
            floatingActionButton = function23;
            $dirty3 |= $composer3.changedInstance(floatingActionButton) ? 1048576 : 524288;
        } else {
            floatingActionButton = function23;
        }
        int i15 = i & 128;
        if (i15 != 0) {
            $dirty3 |= 12582912;
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        } else if (($changed & 29360128) == 0) {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
            $dirty3 |= $composer3.changed(floatingActionButtonPosition2) ? 8388608 : 4194304;
        } else {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        }
        int i16 = i & 256;
        if (i16 != 0) {
            $dirty3 |= 100663296;
            i2 = i16;
        } else if (($changed & 234881024) == 0) {
            i2 = i16;
            $dirty3 |= $composer3.changed(isFloatingActionButtonDocked) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i16;
        }
        int i17 = i & 512;
        if (i17 != 0) {
            $dirty3 |= 805306368;
            i3 = i17;
        } else if (($changed & 1879048192) == 0) {
            i3 = i17;
            $dirty3 |= $composer3.changedInstance(function32) ? 536870912 : 268435456;
        } else {
            i3 = i17;
        }
        int i18 = i & 1024;
        if (i18 != 0) {
            $dirty16 |= 6;
            i4 = i18;
        } else if (($changed1 & 14) == 0) {
            i4 = i18;
            $dirty16 |= $composer3.changed(drawerGesturesEnabled) ? 4 : 2;
        } else {
            i4 = i18;
        }
        if (($changed1 & 112) == 0) {
            $dirty16 |= ((i & 2048) == 0 && $composer3.changed(drawerShape)) ? 32 : 16;
        }
        int i19 = i & 4096;
        if (i19 != 0) {
            $dirty16 |= 384;
            i5 = i19;
        } else {
            i5 = i19;
            if (($changed1 & 896) == 0) {
                $dirty16 |= $composer3.changed(drawerElevation) ? 256 : 128;
            }
        }
        if (($changed1 & 7168) == 0) {
            if ((i & 8192) == 0) {
                $dirty15 = $dirty16;
                i6 = i8;
                if ($composer3.changed(drawerBackgroundColor)) {
                    i11 = 2048;
                }
            } else {
                $dirty15 = $dirty16;
                i6 = i8;
            }
            $dirty1 = $dirty15 | i11;
        } else {
            $dirty1 = $dirty16;
            i6 = i8;
        }
        if (($changed1 & 57344) == 0) {
            $dirty1 |= ((i & 16384) == 0 && $composer3.changed(drawerContentColor)) ? 16384 : 8192;
        }
        if (($changed1 & 458752) == 0) {
            $dirty1 |= ((i & 32768) == 0 && $composer3.changed(drawerScrimColor)) ? 131072 : 65536;
        }
        if (($changed1 & 3670016) == 0) {
            $dirty1 |= ((i & 65536) == 0 && $composer3.changed(backgroundColor)) ? 1048576 : 524288;
        }
        if (($changed1 & 29360128) == 0) {
            if ((i & 131072) == 0) {
                j = contentColor;
                int i20 = $composer3.changed(j) ? 8388608 : 4194304;
                $dirty1 |= i20;
            } else {
                j = contentColor;
            }
            $dirty1 |= i20;
        } else {
            j = contentColor;
        }
        if ((i & 262144) != 0) {
            $dirty12 = $dirty1 | 100663296;
        } else if (($changed1 & 234881024) == 0) {
            $dirty12 = $dirty1 | ($composer3.changedInstance(function33) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432);
        } else {
            $dirty12 = $dirty1;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty12 & 191739611) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            drawerScrimColor3 = drawerScrimColor;
            backgroundColor4 = backgroundColor;
            $composer2 = $composer3;
            contentColor3 = j;
            topBar2 = topBar;
            bottomBar2 = bottomBar;
            snackbarHost2 = snackbarHost;
            floatingActionButton2 = floatingActionButton;
            modifier3 = modifier2;
            scaffoldState3 = scaffoldState2;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            isFloatingActionButtonDocked4 = isFloatingActionButtonDocked;
            snackbarHost3 = function32;
            drawerGesturesEnabled6 = drawerGesturesEnabled;
            drawerShape3 = drawerShape;
            drawerElevation3 = drawerElevation;
            drawerBackgroundColor3 = drawerBackgroundColor;
            drawerContentColor3 = drawerContentColor;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                    scaffoldState2 = rememberScaffoldState(null, null, $composer3, 0, 3);
                }
                if (i10 != 0) {
                    topBar = ComposableSingletons$ScaffoldKt.INSTANCE.m1518getLambda1$material_release();
                }
                if (i12 != 0) {
                    bottomBar = ComposableSingletons$ScaffoldKt.INSTANCE.m1519getLambda2$material_release();
                }
                if (i13 != 0) {
                    snackbarHost = ComposableSingletons$ScaffoldKt.INSTANCE.m1520getLambda3$material_release();
                }
                if (i14 != 0) {
                    floatingActionButton = ComposableSingletons$ScaffoldKt.INSTANCE.m1521getLambda4$material_release();
                }
                if (i15 != 0) {
                    floatingActionButtonPosition2 = FabPosition.INSTANCE.m1567getEnd5ygKITE();
                }
                boolean isFloatingActionButtonDocked5 = i2 != 0 ? false : isFloatingActionButtonDocked;
                Function3 drawerContent5 = i3 != 0 ? null : function32;
                boolean drawerGesturesEnabled7 = i4 != 0 ? true : drawerGesturesEnabled;
                if ((i & 2048) != 0) {
                    drawerShape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getLarge();
                    $dirty13 = $dirty12 & (-113);
                } else {
                    drawerShape2 = drawerShape;
                    $dirty13 = $dirty12;
                }
                drawerElevation2 = i5 != 0 ? DrawerDefaults.INSTANCE.m1536getElevationD9Ej5fM() : drawerElevation;
                if ((i & 8192) != 0) {
                    isFloatingActionButtonDocked2 = isFloatingActionButtonDocked5;
                    $dirty = $dirty3;
                    drawerGesturesEnabled2 = drawerGesturesEnabled7;
                    drawerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1494getSurface0d7_KjU();
                    $dirty13 &= -7169;
                } else {
                    isFloatingActionButtonDocked2 = isFloatingActionButtonDocked5;
                    $dirty = $dirty3;
                    drawerGesturesEnabled2 = drawerGesturesEnabled7;
                    drawerBackgroundColor2 = drawerBackgroundColor;
                }
                if ((i & 16384) != 0) {
                    drawerContentColor2 = ColorsKt.m1508contentColorForek8zF_U(drawerBackgroundColor2, $composer3, ($dirty13 >> 9) & 14);
                    $dirty13 &= -57345;
                } else {
                    drawerContentColor2 = drawerContentColor;
                }
                if ((32768 & i) != 0) {
                    i7 = 6;
                    drawerScrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer3, 6);
                    $dirty13 &= -458753;
                } else {
                    i7 = 6;
                    drawerScrimColor2 = drawerScrimColor;
                }
                if ((i & 65536) != 0) {
                    $dirty13 &= -3670017;
                    drawerContent = drawerContent5;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, i7).m1483getBackground0d7_KjU();
                } else {
                    drawerContent = drawerContent5;
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 131072) != 0) {
                    $dirty14 = $dirty13 & (-29360129);
                    isFloatingActionButtonDocked = isFloatingActionButtonDocked2;
                    $dirty2 = $dirty;
                    contentColor2 = ColorsKt.m1508contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty13 >> 18) & 14);
                    backgroundColor3 = backgroundColor2;
                    drawerContent2 = drawerContent;
                    drawerGesturesEnabled3 = drawerGesturesEnabled2;
                } else {
                    isFloatingActionButtonDocked = isFloatingActionButtonDocked2;
                    contentColor2 = contentColor;
                    $dirty2 = $dirty;
                    backgroundColor3 = backgroundColor2;
                    $dirty14 = $dirty13;
                    drawerContent2 = drawerContent;
                    drawerGesturesEnabled3 = drawerGesturesEnabled2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 2048) != 0) {
                    $dirty12 &= -113;
                }
                $dirty14 = $dirty12;
                if ((i & 8192) != 0) {
                    $dirty14 &= -7169;
                }
                if ((i & 16384) != 0) {
                    $dirty14 &= -57345;
                }
                if ((32768 & i) != 0) {
                    $dirty14 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty14 &= -3670017;
                }
                if ((i & 131072) != 0) {
                    $dirty14 &= -29360129;
                }
                drawerContent2 = function32;
                drawerGesturesEnabled3 = drawerGesturesEnabled;
                drawerElevation2 = drawerElevation;
                drawerContentColor2 = drawerContentColor;
                drawerScrimColor2 = drawerScrimColor;
                backgroundColor3 = backgroundColor;
                $dirty2 = $dirty3;
                contentColor2 = j;
                drawerShape2 = drawerShape;
                drawerBackgroundColor2 = drawerBackgroundColor;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                drawerContent3 = drawerContent2;
                drawerGesturesEnabled4 = drawerGesturesEnabled3;
                ComposerKt.traceEventStart(-1288630565, $dirty2, $dirty14, "androidx.compose.material.Scaffold (Scaffold.kt:204)");
            } else {
                drawerContent3 = drawerContent2;
                drawerGesturesEnabled4 = drawerGesturesEnabled3;
            }
            int i21 = $dirty2 & 14;
            int $dirty17 = $dirty14;
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer3.changed(contentWindowInsets);
            Object value$iv$iv = $composer3.rememberedValue();
            if (invalid$iv$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new MutableWindowInsets(contentWindowInsets);
                $composer3.updateRememberedValue(value$iv$iv);
            }
            $composer3.endReplaceableGroup();
            final MutableWindowInsets safeInsets = (MutableWindowInsets) value$iv$iv;
            final Function2 topBar3 = topBar;
            final Function2 bottomBar3 = bottomBar;
            final Function3 snackbarHost4 = snackbarHost;
            final Function2 floatingActionButton3 = floatingActionButton;
            final ScaffoldState scaffoldState4 = scaffoldState2;
            final int floatingActionButtonPosition4 = floatingActionButtonPosition2;
            final long backgroundColor5 = backgroundColor3;
            final long contentColor4 = contentColor2;
            boolean isFloatingActionButtonDocked6 = isFloatingActionButtonDocked;
            final Function3 child = ComposableLambdaKt.composableLambda($composer3, -219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier4, Composer composer, Integer num) {
                    invoke(modifier4, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Modifier childModifier, Composer $composer4, int $changed2) {
                    Object value$iv;
                    ComposerKt.sourceInformation($composer4, "C209@9601L905:Scaffold.kt#jmzs0o");
                    int $dirty4 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty4 |= $composer4.changed(childModifier) ? 4 : 2;
                    }
                    int $dirty5 = $dirty4;
                    if (($dirty5 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-219833176, $dirty5, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:209)");
                        }
                        $composer4.startReplaceableGroup(188860046);
                        boolean invalid$iv = $composer4.changed(safeInsets) | $composer4.changed(contentWindowInsets);
                        final MutableWindowInsets mutableWindowInsets = safeInsets;
                        final WindowInsets windowInsets = contentWindowInsets;
                        Object it$iv = $composer4.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets2) {
                                    invoke2(windowInsets2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(WindowInsets consumedWindowInsets) {
                                    mutableWindowInsets.setInsets(WindowInsetsKt.exclude(windowInsets, consumedWindowInsets));
                                }
                            };
                            $composer4.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer4.endReplaceableGroup();
                        Modifier modifierOnConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(childModifier, (Function1) value$iv);
                        long j2 = backgroundColor5;
                        long j3 = contentColor4;
                        final boolean z = isFloatingActionButtonDocked;
                        final int i22 = floatingActionButtonPosition4;
                        final Function2<Composer, Integer, Unit> function24 = topBar3;
                        final Function3<PaddingValues, Composer, Integer, Unit> function34 = function33;
                        final Function2<Composer, Integer, Unit> function25 = floatingActionButton3;
                        final MutableWindowInsets mutableWindowInsets2 = safeInsets;
                        final Function2<Composer, Integer, Unit> function26 = bottomBar3;
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function35 = snackbarHost4;
                        final ScaffoldState scaffoldState5 = scaffoldState4;
                        SurfaceKt.m1669SurfaceFjzlyU(modifierOnConsumedWindowInsetsChanged, null, j2, j3, null, 0.0f, ComposableLambdaKt.composableLambda($composer4, 1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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
                                ComposerKt.sourceInformation($composer5, "C218@10033L463:Scaffold.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1772955108, $changed3, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:218)");
                                    }
                                    boolean z2 = z;
                                    int i23 = i22;
                                    Function2<Composer, Integer, Unit> function27 = function24;
                                    Function3<PaddingValues, Composer, Integer, Unit> function36 = function34;
                                    final Function3<SnackbarHostState, Composer, Integer, Unit> function37 = function35;
                                    final ScaffoldState scaffoldState6 = scaffoldState5;
                                    ScaffoldKt.m1637ScaffoldLayouti1QSOvI(z2, i23, function27, function36, ComposableLambdaKt.composableLambda($composer5, 433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                                        public final void invoke(Composer $composer6, int $changed4) {
                                            ComposerKt.sourceInformation($composer6, "C225@10336L45:Scaffold.kt#jmzs0o");
                                            if (($changed4 & 11) == 2 && $composer6.getSkipping()) {
                                                $composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(433906483, $changed4, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:225)");
                                            }
                                            function37.invoke(scaffoldState6.getSnackbarHostState(), $composer6, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), function25, mutableWindowInsets2, function26, $composer5, 24576);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }), $composer4, 1572864, 50);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            });
            if (drawerContent3 != null) {
                $composer3.startReplaceableGroup(-1013846315);
                ComposerKt.sourceInformation($composer3, "234@10555L487");
                isFloatingActionButtonDocked3 = isFloatingActionButtonDocked6;
                Function3 drawerContent6 = drawerContent3;
                boolean drawerGesturesEnabled8 = drawerGesturesEnabled4;
                DrawerKt.m1539ModalDrawerGs3lGvM(drawerContent6, modifier2, scaffoldState2.getDrawerState(), drawerGesturesEnabled8, drawerShape2, drawerElevation2, drawerBackgroundColor2, drawerContentColor2, drawerScrimColor2, ComposableLambdaKt.composableLambda($composer3, -1409196448, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
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
                        ComposerKt.sourceInformation($composer4, "C244@11015L15:Scaffold.kt#jmzs0o");
                        if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1409196448, $changed2, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:244)");
                        }
                        child.invoke(Modifier.INSTANCE, $composer4, 54);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), $composer3, (($dirty2 >> 27) & 14) | 805306368 | ($dirty2 & 112) | (($dirty17 << 9) & 7168) | (($dirty17 << 9) & 57344) | (($dirty17 << 9) & 458752) | (($dirty17 << 9) & 3670016) | (($dirty17 << 9) & 29360128) | (($dirty17 << 9) & 234881024), 0);
                drawerContent4 = drawerContent6;
                drawerGesturesEnabled5 = drawerGesturesEnabled8;
                $composer2 = $composer3;
                $composer2.endReplaceableGroup();
            } else {
                drawerGesturesEnabled5 = drawerGesturesEnabled4;
                isFloatingActionButtonDocked3 = isFloatingActionButtonDocked6;
                $composer2 = $composer3;
                drawerContent4 = drawerContent3;
                $composer2.startReplaceableGroup(-1013845806);
                ComposerKt.sourceInformation($composer2, "247@11064L15");
                child.invoke(modifier2, $composer2, Integer.valueOf((($dirty2 >> 3) & 14) | 48));
                $composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            topBar2 = topBar;
            floatingActionButtonPosition3 = floatingActionButtonPosition2;
            drawerBackgroundColor3 = drawerBackgroundColor2;
            bottomBar2 = bottomBar;
            snackbarHost2 = snackbarHost;
            isFloatingActionButtonDocked4 = isFloatingActionButtonDocked3;
            snackbarHost3 = drawerContent4;
            modifier3 = modifier2;
            drawerShape3 = drawerShape2;
            floatingActionButton2 = floatingActionButton;
            drawerGesturesEnabled6 = drawerGesturesEnabled5;
            scaffoldState3 = scaffoldState2;
            drawerElevation3 = drawerElevation2;
            drawerContentColor3 = drawerContentColor2;
            drawerScrimColor3 = drawerScrimColor2;
            backgroundColor4 = backgroundColor3;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
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

                public final void invoke(Composer composer, int i22) {
                    ScaffoldKt.m1636Scaffoldu4IkXBM(contentWindowInsets, modifier3, scaffoldState3, topBar2, bottomBar2, snackbarHost2, floatingActionButton2, floatingActionButtonPosition3, isFloatingActionButtonDocked4, snackbarHost3, drawerGesturesEnabled6, drawerShape3, drawerElevation3, drawerBackgroundColor3, drawerContentColor3, drawerScrimColor3, backgroundColor4, contentColor3, function33, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* renamed from: Scaffold-27mzLpw, reason: not valid java name */
    public static final void m1635Scaffold27mzLpw(Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, int floatingActionButtonPosition, boolean isFloatingActionButtonDocked, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        ScaffoldState scaffoldState2;
        Function2 topBar;
        Function2 bottomBar;
        Function3 snackbarHost;
        Function2 floatingActionButton;
        int floatingActionButtonPosition2;
        int i2;
        int i3;
        int i4;
        int $dirty;
        int $dirty1;
        long j;
        int $dirty2;
        CornerBasedShape drawerShape2;
        int $dirty12;
        float drawerElevation2;
        boolean isFloatingActionButtonDocked2;
        Function3 drawerContent;
        long drawerBackgroundColor2;
        long drawerContentColor2;
        long drawerBackgroundColor3;
        long drawerScrimColor2;
        long backgroundColor2;
        int $dirty3;
        int $dirty4;
        long drawerScrimColor3;
        long backgroundColor3;
        boolean drawerGesturesEnabled2;
        Modifier modifier3;
        Function3 snackbarHost2;
        int floatingActionButtonPosition3;
        long drawerBackgroundColor4;
        long drawerContentColor3;
        Function3 drawerContent2;
        long contentColor2;
        int $dirty13;
        Shape drawerShape3;
        ScaffoldState scaffoldState3;
        Function2 floatingActionButton2;
        boolean isFloatingActionButtonDocked3;
        int i5;
        Composer $composer2;
        final Modifier modifier4;
        final ScaffoldState scaffoldState4;
        final Function2 topBar2;
        final Function2 bottomBar2;
        final Function3 snackbarHost3;
        final Function2 floatingActionButton3;
        final int floatingActionButtonPosition4;
        final boolean isFloatingActionButtonDocked4;
        final Function3 snackbarHost4;
        final boolean drawerGesturesEnabled3;
        final Shape drawerShape4;
        final float drawerElevation3;
        final long drawerBackgroundColor5;
        final long drawerContentColor4;
        final long drawerBackgroundColor6;
        final long drawerContentColor5;
        final long drawerScrimColor4;
        int $dirty14;
        Composer $composer3 = $composer.startRestartGroup(1037492569);
        ComposerKt.sourceInformation($composer3, "C(Scaffold)P(14,15,17,1,16,11,12:c#material.FabPosition,13,5,8,10,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)315@14928L23,324@15438L6,326@15553L6,327@15601L38,328@15686L10,329@15741L6,330@15786L32,333@15877L495:Scaffold.kt#jmzs0o");
        int $dirty5 = $changed;
        int $dirty15 = $changed1;
        int i6 = i & 1;
        if (i6 != 0) {
            $dirty5 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty5 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                scaffoldState2 = scaffoldState;
                int i7 = $composer3.changed(scaffoldState2) ? 32 : 16;
                $dirty5 |= i7;
            } else {
                scaffoldState2 = scaffoldState;
            }
            $dirty5 |= i7;
        } else {
            scaffoldState2 = scaffoldState;
        }
        int i8 = i & 4;
        if (i8 != 0) {
            $dirty5 |= 384;
            topBar = function2;
        } else if (($changed & 896) == 0) {
            topBar = function2;
            $dirty5 |= $composer3.changedInstance(topBar) ? 256 : 128;
        } else {
            topBar = function2;
        }
        int i9 = i & 8;
        if (i9 != 0) {
            $dirty5 |= 3072;
            bottomBar = function22;
        } else if (($changed & 7168) == 0) {
            bottomBar = function22;
            $dirty5 |= $composer3.changedInstance(bottomBar) ? 2048 : 1024;
        } else {
            bottomBar = function22;
        }
        int i10 = i & 16;
        if (i10 != 0) {
            $dirty5 |= 24576;
            snackbarHost = function3;
        } else if (($changed & 57344) == 0) {
            snackbarHost = function3;
            $dirty5 |= $composer3.changedInstance(snackbarHost) ? 16384 : 8192;
        } else {
            snackbarHost = function3;
        }
        int i11 = i & 32;
        if (i11 != 0) {
            $dirty5 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            floatingActionButton = function23;
        } else if (($changed & 458752) == 0) {
            floatingActionButton = function23;
            $dirty5 |= $composer3.changedInstance(floatingActionButton) ? 131072 : 65536;
        } else {
            floatingActionButton = function23;
        }
        int i12 = i & 64;
        if (i12 != 0) {
            $dirty5 |= 1572864;
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        } else if (($changed & 3670016) == 0) {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
            $dirty5 |= $composer3.changed(floatingActionButtonPosition2) ? 1048576 : 524288;
        } else {
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        }
        int i13 = i & 128;
        if (i13 != 0) {
            $dirty5 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty5 |= $composer3.changed(isFloatingActionButtonDocked) ? 8388608 : 4194304;
        }
        int i14 = i & 256;
        if (i14 != 0) {
            $dirty5 |= 100663296;
            i2 = i14;
        } else if (($changed & 234881024) == 0) {
            i2 = i14;
            $dirty5 |= $composer3.changedInstance(function32) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i14;
        }
        int i15 = i & 512;
        if (i15 != 0) {
            $dirty5 |= 805306368;
            i3 = i15;
        } else if (($changed & 1879048192) == 0) {
            i3 = i15;
            $dirty5 |= $composer3.changed(drawerGesturesEnabled) ? 536870912 : 268435456;
        } else {
            i3 = i15;
        }
        if (($changed1 & 14) == 0) {
            $dirty15 |= ((i & 1024) == 0 && $composer3.changed(drawerShape)) ? 4 : 2;
        }
        int i16 = i & 2048;
        if (i16 != 0) {
            $dirty15 |= 48;
            i4 = i16;
        } else if (($changed1 & 112) == 0) {
            i4 = i16;
            $dirty15 |= $composer3.changed(drawerElevation) ? 32 : 16;
        } else {
            i4 = i16;
        }
        if (($changed1 & 896) == 0) {
            if ((i & 4096) == 0) {
                $dirty = $dirty5;
                $dirty14 = $dirty15;
                j = drawerBackgroundColor;
                int i17 = $composer3.changed(j) ? 256 : 128;
                $dirty1 = $dirty14 | i17;
            } else {
                $dirty = $dirty5;
                $dirty14 = $dirty15;
                j = drawerBackgroundColor;
            }
            $dirty1 = $dirty14 | i17;
        } else {
            $dirty = $dirty5;
            $dirty1 = $dirty15;
            j = drawerBackgroundColor;
        }
        int $dirty16 = $dirty1;
        if (($changed1 & 7168) == 0) {
            $dirty16 |= ((i & 8192) == 0 && $composer3.changed(drawerContentColor)) ? 2048 : 1024;
        }
        if (($changed1 & 57344) == 0) {
            $dirty16 |= ((i & 16384) == 0 && $composer3.changed(drawerScrimColor)) ? 16384 : 8192;
        }
        if (($changed1 & 458752) == 0) {
            $dirty16 |= ((i & 32768) == 0 && $composer3.changed(backgroundColor)) ? 131072 : 65536;
        }
        if (($changed1 & 3670016) == 0) {
            $dirty16 |= ((i & 65536) == 0 && $composer3.changed(contentColor)) ? 1048576 : 524288;
        }
        if ((i & 131072) != 0) {
            $dirty16 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty16 |= $composer3.changedInstance(function33) ? 8388608 : 4194304;
        }
        if (($dirty & 1533916891) == 306783378 && ($dirty16 & 23967451) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            drawerContentColor4 = drawerContentColor;
            drawerBackgroundColor6 = drawerScrimColor;
            drawerContentColor5 = backgroundColor;
            drawerScrimColor4 = contentColor;
            $composer2 = $composer3;
            topBar2 = topBar;
            modifier4 = modifier2;
            scaffoldState4 = scaffoldState2;
            floatingActionButton3 = floatingActionButton;
            floatingActionButtonPosition4 = floatingActionButtonPosition2;
            snackbarHost4 = function32;
            drawerGesturesEnabled3 = drawerGesturesEnabled;
            drawerElevation3 = drawerElevation;
            drawerBackgroundColor5 = j;
            bottomBar2 = bottomBar;
            snackbarHost3 = snackbarHost;
            isFloatingActionButtonDocked4 = isFloatingActionButtonDocked;
            drawerShape4 = drawerShape;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 2) != 0) {
                    $dirty2 = $dirty & (-113);
                    scaffoldState2 = rememberScaffoldState(null, null, $composer3, 0, 3);
                } else {
                    $dirty2 = $dirty;
                }
                if (i8 != 0) {
                    topBar = ComposableSingletons$ScaffoldKt.INSTANCE.m1522getLambda5$material_release();
                }
                if (i9 != 0) {
                    bottomBar = ComposableSingletons$ScaffoldKt.INSTANCE.m1523getLambda6$material_release();
                }
                if (i10 != 0) {
                    snackbarHost = ComposableSingletons$ScaffoldKt.INSTANCE.m1524getLambda7$material_release();
                }
                if (i11 != 0) {
                    floatingActionButton = ComposableSingletons$ScaffoldKt.INSTANCE.m1525getLambda8$material_release();
                }
                if (i12 != 0) {
                    floatingActionButtonPosition2 = FabPosition.INSTANCE.m1567getEnd5ygKITE();
                }
                boolean isFloatingActionButtonDocked5 = i13 != 0 ? false : isFloatingActionButtonDocked;
                Function3 drawerContent3 = i2 != 0 ? null : function32;
                boolean drawerGesturesEnabled4 = i3 != 0 ? true : drawerGesturesEnabled;
                if ((i & 1024) != 0) {
                    drawerShape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getLarge();
                    $dirty12 = $dirty16 & (-15);
                } else {
                    drawerShape2 = drawerShape;
                    $dirty12 = $dirty16;
                }
                drawerElevation2 = i4 != 0 ? DrawerDefaults.INSTANCE.m1536getElevationD9Ej5fM() : drawerElevation;
                if ((i & 4096) != 0) {
                    isFloatingActionButtonDocked2 = isFloatingActionButtonDocked5;
                    $dirty12 &= -897;
                    drawerContent = drawerContent3;
                    drawerBackgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1494getSurface0d7_KjU();
                } else {
                    isFloatingActionButtonDocked2 = isFloatingActionButtonDocked5;
                    drawerContent = drawerContent3;
                    drawerBackgroundColor2 = drawerBackgroundColor;
                }
                if ((i & 8192) != 0) {
                    drawerContentColor2 = ColorsKt.m1508contentColorForek8zF_U(drawerBackgroundColor2, $composer3, ($dirty12 >> 6) & 14);
                    $dirty12 &= -7169;
                } else {
                    drawerContentColor2 = drawerContentColor;
                }
                if ((i & 16384) != 0) {
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    drawerScrimColor2 = DrawerDefaults.INSTANCE.getScrimColor($composer3, 6);
                    $dirty12 &= -57345;
                } else {
                    drawerBackgroundColor3 = drawerBackgroundColor2;
                    drawerScrimColor2 = drawerScrimColor;
                }
                if ((32768 & i) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1483getBackground0d7_KjU();
                    $dirty12 &= -458753;
                } else {
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 65536) != 0) {
                    long contentColor3 = ColorsKt.m1508contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty12 >> 15) & 14);
                    int i18 = (-3670017) & $dirty12;
                    int $dirty17 = floatingActionButtonPosition2;
                    drawerGesturesEnabled2 = drawerGesturesEnabled4;
                    modifier3 = modifier2;
                    snackbarHost2 = snackbarHost;
                    floatingActionButtonPosition3 = $dirty17;
                    long j2 = drawerBackgroundColor3;
                    drawerBackgroundColor4 = drawerContentColor2;
                    drawerContentColor3 = j2;
                    drawerShape3 = drawerShape2;
                    scaffoldState3 = scaffoldState2;
                    floatingActionButton2 = floatingActionButton;
                    contentColor2 = contentColor3;
                    isFloatingActionButtonDocked3 = isFloatingActionButtonDocked2;
                    drawerContent2 = drawerContent;
                    long j3 = backgroundColor2;
                    $dirty3 = $dirty2;
                    $dirty13 = i18;
                    $dirty4 = 57344;
                    drawerScrimColor3 = drawerScrimColor2;
                    backgroundColor3 = j3;
                } else {
                    long j4 = backgroundColor2;
                    $dirty3 = $dirty2;
                    $dirty4 = 57344;
                    drawerScrimColor3 = drawerScrimColor2;
                    backgroundColor3 = j4;
                    int i19 = floatingActionButtonPosition2;
                    drawerGesturesEnabled2 = drawerGesturesEnabled4;
                    modifier3 = modifier2;
                    snackbarHost2 = snackbarHost;
                    floatingActionButtonPosition3 = i19;
                    long j5 = drawerBackgroundColor3;
                    drawerBackgroundColor4 = drawerContentColor2;
                    drawerContentColor3 = j5;
                    drawerContent2 = drawerContent;
                    contentColor2 = contentColor;
                    $dirty13 = $dirty12;
                    drawerShape3 = drawerShape2;
                    scaffoldState3 = scaffoldState2;
                    floatingActionButton2 = floatingActionButton;
                    isFloatingActionButtonDocked3 = isFloatingActionButtonDocked2;
                }
            } else {
                $composer3.skipToGroupEnd();
                $dirty3 = (i & 2) != 0 ? $dirty & (-113) : $dirty;
                if ((i & 1024) != 0) {
                    $dirty16 &= -15;
                }
                $dirty13 = $dirty16;
                if ((i & 4096) != 0) {
                    $dirty13 &= -897;
                }
                if ((i & 8192) != 0) {
                    $dirty13 &= -7169;
                }
                if ((i & 16384) != 0) {
                    $dirty13 &= -57345;
                }
                if ((32768 & i) != 0) {
                    $dirty13 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty13 &= -3670017;
                }
                drawerContent2 = function32;
                drawerShape3 = drawerShape;
                drawerElevation2 = drawerElevation;
                drawerBackgroundColor4 = drawerContentColor;
                backgroundColor3 = backgroundColor;
                contentColor2 = contentColor;
                drawerContentColor3 = j;
                modifier3 = modifier2;
                scaffoldState3 = scaffoldState2;
                snackbarHost2 = snackbarHost;
                floatingActionButton2 = floatingActionButton;
                floatingActionButtonPosition3 = floatingActionButtonPosition2;
                $dirty4 = 57344;
                isFloatingActionButtonDocked3 = isFloatingActionButtonDocked;
                drawerGesturesEnabled2 = drawerGesturesEnabled;
                drawerScrimColor3 = drawerScrimColor;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                i5 = $dirty4;
                ComposerKt.traceEventStart(1037492569, $dirty3, $dirty13, "androidx.compose.material.Scaffold (Scaffold.kt:332)");
            } else {
                i5 = $dirty4;
            }
            int $dirty6 = $dirty3;
            $composer2 = $composer3;
            m1636Scaffoldu4IkXBM(WindowInsetsKt.m841WindowInsetsa9UjIt4$default(C1956Dp.m6297constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), modifier3, scaffoldState3, topBar, bottomBar, snackbarHost2, floatingActionButton2, floatingActionButtonPosition3, isFloatingActionButtonDocked3, drawerContent2, drawerGesturesEnabled2, drawerShape3, drawerElevation2, drawerContentColor3, drawerBackgroundColor4, drawerScrimColor3, backgroundColor3, contentColor2, function33, $composer2, (($dirty6 << 3) & 112) | (($dirty6 << 3) & 896) | (($dirty6 << 3) & 7168) | (($dirty6 << 3) & i5) | (($dirty6 << 3) & 458752) | (($dirty6 << 3) & 3670016) | (($dirty6 << 3) & 29360128) | (($dirty6 << 3) & 234881024) | (($dirty6 << 3) & 1879048192), (($dirty6 >> 27) & 14) | (($dirty13 << 3) & 112) | (($dirty13 << 3) & 896) | (($dirty13 << 3) & 7168) | (($dirty13 << 3) & i5) | (($dirty13 << 3) & 458752) | (($dirty13 << 3) & 3670016) | (($dirty13 << 3) & 29360128) | (($dirty13 << 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            scaffoldState4 = scaffoldState3;
            topBar2 = topBar;
            bottomBar2 = bottomBar;
            snackbarHost3 = snackbarHost2;
            floatingActionButton3 = floatingActionButton2;
            floatingActionButtonPosition4 = floatingActionButtonPosition3;
            isFloatingActionButtonDocked4 = isFloatingActionButtonDocked3;
            snackbarHost4 = drawerContent2;
            drawerGesturesEnabled3 = drawerGesturesEnabled2;
            drawerShape4 = drawerShape3;
            drawerElevation3 = drawerElevation2;
            drawerBackgroundColor5 = drawerContentColor3;
            drawerContentColor4 = drawerBackgroundColor4;
            drawerBackgroundColor6 = drawerScrimColor3;
            drawerContentColor5 = backgroundColor3;
            drawerScrimColor4 = contentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$3
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

                public final void invoke(Composer composer, int i20) {
                    ScaffoldKt.m1635Scaffold27mzLpw(modifier4, scaffoldState4, topBar2, bottomBar2, snackbarHost3, floatingActionButton3, floatingActionButtonPosition4, isFloatingActionButtonDocked4, snackbarHost4, drawerGesturesEnabled3, drawerShape4, drawerElevation3, drawerBackgroundColor5, drawerContentColor4, drawerBackgroundColor6, drawerContentColor5, drawerScrimColor4, function33, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final boolean getScaffoldSubcomposeInMeasureFix() {
        State $this$getValue$iv = ScaffoldSubcomposeInMeasureFix$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public static final void setScaffoldSubcomposeInMeasureFix(boolean z) {
        MutableState $this$setValue$iv = ScaffoldSubcomposeInMeasureFix$delegate;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-i1QSOvI, reason: not valid java name */
    public static final void m1637ScaffoldLayouti1QSOvI(final boolean isFabDocked, final int fabPosition, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets contentWindowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer $composer, final int $changed) {
        boolean z;
        int i;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        WindowInsets windowInsets;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-468424875);
        ComposerKt.sourceInformation($composer3, "C(ScaffoldLayout)P(5,4:c#material.FabPosition,7,1,6,3,2):Scaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            z = isFabDocked;
            $dirty |= $composer3.changed(z) ? 4 : 2;
        } else {
            z = isFabDocked;
        }
        if (($changed & 112) == 0) {
            i = fabPosition;
            $dirty |= $composer3.changed(i) ? 32 : 16;
        } else {
            i = fabPosition;
        }
        if (($changed & 896) == 0) {
            function25 = function2;
            $dirty |= $composer3.changedInstance(function25) ? 256 : 128;
        } else {
            function25 = function2;
        }
        if (($changed & 7168) == 0) {
            function32 = function3;
            $dirty |= $composer3.changedInstance(function32) ? 2048 : 1024;
        } else {
            function32 = function3;
        }
        if (($changed & 57344) == 0) {
            function26 = function22;
            $dirty |= $composer3.changedInstance(function26) ? 16384 : 8192;
        } else {
            function26 = function22;
        }
        if (($changed & 458752) == 0) {
            function27 = function23;
            $dirty |= $composer3.changedInstance(function27) ? 131072 : 65536;
        } else {
            function27 = function23;
        }
        if (($changed & 3670016) == 0) {
            windowInsets = contentWindowInsets;
            $dirty |= $composer3.changed(windowInsets) ? 1048576 : 524288;
        } else {
            windowInsets = contentWindowInsets;
        }
        if (($changed & 29360128) == 0) {
            function28 = function24;
            $dirty |= $composer3.changedInstance(function28) ? 8388608 : 4194304;
        } else {
            function28 = function24;
        }
        if (($dirty & 23967451) != 4793490 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-468424875, $dirty, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:409)");
            }
            if (getScaffoldSubcomposeInMeasureFix()) {
                $composer3.startReplaceableGroup(-2103098080);
                ComposerKt.sourceInformation($composer3, "411@18576L322");
                $composer2 = $composer3;
                m1638ScaffoldLayoutWithMeasureFixi1QSOvI(z, i, function25, function32, function26, function27, windowInsets, function28, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752) | ($dirty & 3670016) | ($dirty & 29360128));
                $composer2.endReplaceableGroup();
            } else {
                $composer3.startReplaceableGroup(-2103097736);
                ComposerKt.sourceInformation($composer3, "422@18920L314");
                $composer2 = $composer3;
                m1634LegacyScaffoldLayouti1QSOvI(isFabDocked, fabPosition, function2, function3, function22, function23, contentWindowInsets, function24, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752) | ($dirty & 3670016) | ($dirty & 29360128));
                $composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1
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

                public final void invoke(Composer composer, int i2) {
                    ScaffoldKt.m1637ScaffoldLayouti1QSOvI(isFabDocked, fabPosition, function2, function3, function22, function23, contentWindowInsets, function24, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayoutWithMeasureFix-i1QSOvI, reason: not valid java name */
    public static final void m1638ScaffoldLayoutWithMeasureFixi1QSOvI(final boolean isFabDocked, final int fabPosition, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets contentWindowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(1285900760);
        ComposerKt.sourceInformation($composer2, "C(ScaffoldLayoutWithMeasureFix)P(5,4:c#material.FabPosition,7,1,6,3,2)450@19773L6694:Scaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(isFabDocked) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(fabPosition) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer2.changed(contentWindowInsets) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((23967451 & $dirty) != 4793490 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1285900760, $dirty, -1, "androidx.compose.material.ScaffoldLayoutWithMeasureFix (Scaffold.kt:449)");
            }
            $composer2.startReplaceableGroup(188870142);
            boolean invalid$iv = $composer2.changedInstance(function2) | $composer2.changedInstance(function22) | $composer2.changed(contentWindowInsets) | $composer2.changedInstance(function23) | $composer2.changed(fabPosition) | $composer2.changed(isFabDocked) | $composer2.changedInstance(function24) | $composer2.changedInstance(function3);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1643invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1643invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
                        Object maxElem$iv;
                        Object maxElem$iv2;
                        FabPlacement fabPlacement;
                        Object maxElem$iv3;
                        final Integer fabOffsetFromBottom;
                        final int snackbarOffsetFromBottom;
                        Object maxElem$iv4;
                        Object maxElem$iv5;
                        int layoutWidth = Constraints.m6253getMaxWidthimpl(constraints);
                        final int layoutHeight = Constraints.m6252getMaxHeightimpl(constraints);
                        long looseConstraints = Constraints.m6243copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(constraints) : 0);
                        List $this$fastMap$iv = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.TopBar, function2);
                        List target$iv = new ArrayList($this$fastMap$iv.size());
                        int index$iv$iv = 0;
                        int size = $this$fastMap$iv.size();
                        while (index$iv$iv < size) {
                            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                            List $this$fastMap$iv2 = $this$fastMap$iv;
                            Measurable it = (Measurable) item$iv$iv;
                            target$iv.add(it.mo5219measureBRTryo0(looseConstraints));
                            index$iv$iv++;
                            $this$fastMap$iv = $this$fastMap$iv2;
                        }
                        List topBarPlaceables = target$iv;
                        if (topBarPlaceables.isEmpty()) {
                            maxElem$iv = null;
                        } else {
                            maxElem$iv = topBarPlaceables.get(0);
                            Placeable it2 = (Placeable) maxElem$iv;
                            int maxValue$iv = it2.getHeight();
                            int i$iv = 1;
                            int lastIndex = CollectionsKt.getLastIndex(topBarPlaceables);
                            if (1 <= lastIndex) {
                                while (true) {
                                    Object e$iv = topBarPlaceables.get(i$iv);
                                    Placeable it3 = (Placeable) e$iv;
                                    int v$iv = it3.getHeight();
                                    if (maxValue$iv < v$iv) {
                                        maxElem$iv = e$iv;
                                        maxValue$iv = v$iv;
                                    }
                                    if (i$iv == lastIndex) {
                                        break;
                                    }
                                    i$iv++;
                                }
                            }
                        }
                        Placeable placeable = (Placeable) maxElem$iv;
                        final int topBarHeight = placeable != null ? placeable.getHeight() : 0;
                        List $this$fastMap$iv3 = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.Snackbar, function22);
                        WindowInsets windowInsets = contentWindowInsets;
                        int $i$f$fastMap = 0;
                        List target$iv2 = new ArrayList($this$fastMap$iv3.size());
                        int index$iv$iv2 = 0;
                        int size2 = $this$fastMap$iv3.size();
                        while (index$iv$iv2 < size2) {
                            Object item$iv$iv2 = $this$fastMap$iv3.get(index$iv$iv2);
                            List $this$fastMap$iv4 = $this$fastMap$iv3;
                            Measurable it4 = (Measurable) item$iv$iv2;
                            List topBarPlaceables2 = topBarPlaceables;
                            int $i$f$fastMap2 = $i$f$fastMap;
                            int leftInset = windowInsets.getLeft($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int i = size2;
                            int rightInset = windowInsets.getRight($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int bottomInset = windowInsets.getBottom($this$SubcomposeLayout);
                            WindowInsets windowInsets2 = windowInsets;
                            int i2 = (-leftInset) - rightInset;
                            int leftInset2 = -bottomInset;
                            target$iv2.add(it4.mo5219measureBRTryo0(ConstraintsKt.m6269offsetNN6EwU(looseConstraints, i2, leftInset2)));
                            index$iv$iv2++;
                            $this$fastMap$iv3 = $this$fastMap$iv4;
                            topBarPlaceables = topBarPlaceables2;
                            $i$f$fastMap = $i$f$fastMap2;
                            size2 = i;
                            windowInsets = windowInsets2;
                        }
                        final List topBarPlaceables3 = topBarPlaceables;
                        final List snackbarPlaceables = target$iv2;
                        if (snackbarPlaceables.isEmpty()) {
                            maxElem$iv2 = null;
                        } else {
                            maxElem$iv2 = snackbarPlaceables.get(0);
                            Placeable it5 = (Placeable) maxElem$iv2;
                            int maxValue$iv2 = it5.getHeight();
                            int i$iv2 = 1;
                            int lastIndex2 = CollectionsKt.getLastIndex(snackbarPlaceables);
                            if (1 <= lastIndex2) {
                                while (true) {
                                    Object e$iv2 = snackbarPlaceables.get(i$iv2);
                                    Placeable it6 = (Placeable) e$iv2;
                                    int v$iv2 = it6.getHeight();
                                    if (maxValue$iv2 < v$iv2) {
                                        maxElem$iv2 = e$iv2;
                                        maxValue$iv2 = v$iv2;
                                    }
                                    if (i$iv2 == lastIndex2) {
                                        break;
                                    }
                                    i$iv2++;
                                }
                            }
                        }
                        Placeable placeable2 = (Placeable) maxElem$iv2;
                        int snackbarHeight = placeable2 != null ? placeable2.getHeight() : 0;
                        List $this$fastMap$iv5 = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.Fab, function23);
                        WindowInsets windowInsets3 = contentWindowInsets;
                        int $i$f$fastMap3 = 0;
                        ArrayList target$iv3 = new ArrayList($this$fastMap$iv5.size());
                        List $this$fastForEach$iv$iv = $this$fastMap$iv5;
                        int $i$f$fastForEach = 0;
                        int index$iv$iv3 = 0;
                        int size3 = $this$fastForEach$iv$iv.size();
                        while (index$iv$iv3 < size3) {
                            Object item$iv$iv3 = $this$fastForEach$iv$iv.get(index$iv$iv3);
                            List $this$fastMap$iv6 = $this$fastMap$iv5;
                            ArrayList arrayList = target$iv3;
                            int $i$f$fastMap4 = $i$f$fastMap3;
                            Measurable measurable = (Measurable) item$iv$iv3;
                            ArrayList target$iv4 = target$iv3;
                            List $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                            int leftInset3 = windowInsets3.getLeft($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int $i$f$fastForEach2 = $i$f$fastForEach;
                            int rightInset2 = windowInsets3.getRight($this$SubcomposeLayout, $this$SubcomposeLayout.getLayoutDirection());
                            int bottomInset2 = windowInsets3.getBottom($this$SubcomposeLayout);
                            WindowInsets windowInsets4 = windowInsets3;
                            int i3 = (-leftInset3) - rightInset2;
                            int leftInset4 = -bottomInset2;
                            arrayList.add(measurable.mo5219measureBRTryo0(ConstraintsKt.m6269offsetNN6EwU(looseConstraints, i3, leftInset4)));
                            index$iv$iv3++;
                            $this$fastMap$iv5 = $this$fastMap$iv6;
                            $i$f$fastMap3 = $i$f$fastMap4;
                            target$iv3 = target$iv4;
                            $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                            $i$f$fastForEach = $i$f$fastForEach2;
                            windowInsets3 = windowInsets4;
                        }
                        final ArrayList fabPlaceables = target$iv3;
                        if (fabPlaceables.isEmpty()) {
                            fabPlacement = null;
                        } else {
                            if (fabPlaceables.isEmpty()) {
                                maxElem$iv4 = null;
                            } else {
                                maxElem$iv4 = fabPlaceables.get(0);
                                Placeable it7 = (Placeable) maxElem$iv4;
                                int maxValue$iv3 = it7.getWidth();
                                int i$iv3 = 1;
                                int lastIndex3 = CollectionsKt.getLastIndex(fabPlaceables);
                                if (1 <= lastIndex3) {
                                    while (true) {
                                        Object e$iv3 = fabPlaceables.get(i$iv3);
                                        Placeable it8 = (Placeable) e$iv3;
                                        int v$iv3 = it8.getWidth();
                                        if (maxValue$iv3 < v$iv3) {
                                            maxElem$iv4 = e$iv3;
                                            maxValue$iv3 = v$iv3;
                                        }
                                        if (i$iv3 == lastIndex3) {
                                            break;
                                        }
                                        i$iv3++;
                                    }
                                }
                            }
                            Placeable placeable3 = (Placeable) maxElem$iv4;
                            int fabWidth = placeable3 != null ? placeable3.getWidth() : 0;
                            List $this$fastMaxBy$iv = fabPlaceables;
                            if ($this$fastMaxBy$iv.isEmpty()) {
                                maxElem$iv5 = null;
                            } else {
                                maxElem$iv5 = $this$fastMaxBy$iv.get(0);
                                Placeable it9 = (Placeable) maxElem$iv5;
                                int maxValue$iv4 = it9.getHeight();
                                int i$iv4 = 1;
                                int lastIndex4 = CollectionsKt.getLastIndex($this$fastMaxBy$iv);
                                if (1 <= lastIndex4) {
                                    while (true) {
                                        Object e$iv4 = $this$fastMaxBy$iv.get(i$iv4);
                                        Placeable it10 = (Placeable) e$iv4;
                                        int height = it10.getHeight();
                                        List $this$fastMaxBy$iv2 = $this$fastMaxBy$iv;
                                        if (maxValue$iv4 < height) {
                                            maxElem$iv5 = e$iv4;
                                            maxValue$iv4 = height;
                                        }
                                        if (i$iv4 == lastIndex4) {
                                            break;
                                        }
                                        i$iv4++;
                                        $this$fastMaxBy$iv = $this$fastMaxBy$iv2;
                                    }
                                }
                            }
                            Placeable placeable4 = (Placeable) maxElem$iv5;
                            int fabHeight = placeable4 != null ? placeable4.getHeight() : 0;
                            if (fabWidth == 0 || fabHeight == 0) {
                                fabPlacement = null;
                            } else {
                                int i4 = fabPosition;
                                int fabLeftOffset = FabPosition.m1562equalsimpl0(i4, FabPosition.INSTANCE.m1568getStart5ygKITE()) ? $this$SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? $this$SubcomposeLayout.mo512roundToPx0680j_4(ScaffoldKt.FabSpacing) : (layoutWidth - $this$SubcomposeLayout.mo512roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth : FabPosition.m1562equalsimpl0(i4, FabPosition.INSTANCE.m1567getEnd5ygKITE()) ? $this$SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? (layoutWidth - $this$SubcomposeLayout.mo512roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth : $this$SubcomposeLayout.mo512roundToPx0680j_4(ScaffoldKt.FabSpacing) : (layoutWidth - fabWidth) / 2;
                                fabPlacement = new FabPlacement(isFabDocked, fabLeftOffset, fabWidth, fabHeight);
                            }
                        }
                        final FabPlacement fabPlacement2 = fabPlacement;
                        ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                        final Function2<Composer, Integer, Unit> function25 = function24;
                        List $this$fastMap$iv7 = $this$SubcomposeLayout.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(-1617485343, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bottomBarPlaceables$1
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

                            public final void invoke(Composer $composer3, int $changed2) {
                                ComposerKt.sourceInformation($composer3, "C535@23290L132:Scaffold.kt#jmzs0o");
                                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1617485343, $changed2, -1, "androidx.compose.material.ScaffoldLayoutWithMeasureFix.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:535)");
                                    }
                                    CompositionLocalKt.CompositionLocalProvider(ScaffoldKt.getLocalFabPlacement().provides(fabPlacement2), function25, $composer3, ProvidedValue.$stable | 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }));
                        int $i$f$fastMap5 = 0;
                        List target$iv5 = new ArrayList($this$fastMap$iv7.size());
                        int index$iv$iv4 = 0;
                        int size4 = $this$fastMap$iv7.size();
                        while (index$iv$iv4 < size4) {
                            Object item$iv$iv4 = $this$fastMap$iv7.get(index$iv$iv4);
                            int $i$f$fastMap6 = $i$f$fastMap5;
                            Measurable it11 = (Measurable) item$iv$iv4;
                            target$iv5.add(it11.mo5219measureBRTryo0(looseConstraints));
                            index$iv$iv4++;
                            $this$fastMap$iv7 = $this$fastMap$iv7;
                            $i$f$fastMap5 = $i$f$fastMap6;
                        }
                        final List bottomBarPlaceables = target$iv5;
                        List $this$fastMaxBy$iv3 = bottomBarPlaceables;
                        if ($this$fastMaxBy$iv3.isEmpty()) {
                            maxElem$iv3 = null;
                        } else {
                            maxElem$iv3 = $this$fastMaxBy$iv3.get(0);
                            Placeable it12 = (Placeable) maxElem$iv3;
                            int maxValue$iv5 = it12.getHeight();
                            int i$iv5 = 1;
                            int lastIndex5 = CollectionsKt.getLastIndex($this$fastMaxBy$iv3);
                            if (1 <= lastIndex5) {
                                while (true) {
                                    Object e$iv5 = $this$fastMaxBy$iv3.get(i$iv5);
                                    Placeable it13 = (Placeable) e$iv5;
                                    int height2 = it13.getHeight();
                                    List $this$fastMaxBy$iv4 = $this$fastMaxBy$iv3;
                                    if (maxValue$iv5 < height2) {
                                        maxElem$iv3 = e$iv5;
                                        maxValue$iv5 = height2;
                                    }
                                    if (i$iv5 == lastIndex5) {
                                        break;
                                    }
                                    i$iv5++;
                                    $this$fastMaxBy$iv3 = $this$fastMaxBy$iv4;
                                }
                            }
                        }
                        Placeable placeable5 = (Placeable) maxElem$iv3;
                        final Integer bottomBarHeight = placeable5 != null ? Integer.valueOf(placeable5.getHeight()) : null;
                        if (fabPlacement2 != null) {
                            fabOffsetFromBottom = Integer.valueOf(bottomBarHeight == null ? fabPlacement2.getHeight() + $this$SubcomposeLayout.mo512roundToPx0680j_4(ScaffoldKt.FabSpacing) + contentWindowInsets.getBottom($this$SubcomposeLayout) : isFabDocked ? (fabPlacement2.getHeight() / 2) + bottomBarHeight.intValue() : $this$SubcomposeLayout.mo512roundToPx0680j_4(ScaffoldKt.FabSpacing) + bottomBarHeight.intValue() + fabPlacement2.getHeight());
                        } else {
                            fabOffsetFromBottom = null;
                        }
                        if (snackbarHeight != 0) {
                            snackbarOffsetFromBottom = snackbarHeight + (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : bottomBarHeight != null ? bottomBarHeight.intValue() : contentWindowInsets.getBottom($this$SubcomposeLayout));
                        } else {
                            snackbarOffsetFromBottom = 0;
                        }
                        int bodyContentHeight = layoutHeight - topBarHeight;
                        ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                        final WindowInsets windowInsets5 = contentWindowInsets;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        List $this$fastMap$iv8 = $this$SubcomposeLayout.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-914494158, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bodyContentPlaceables$1
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

                            public final void invoke(Composer $composer3, int $changed2) {
                                float fM6297constructorimpl;
                                float bottom;
                                ComposerKt.sourceInformation($composer3, "C586@25446L21:Scaffold.kt#jmzs0o");
                                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-914494158, $changed2, -1, "androidx.compose.material.ScaffoldLayoutWithMeasureFix.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:569)");
                                    }
                                    PaddingValues insets = WindowInsetsKt.asPaddingValues(windowInsets5, $this$SubcomposeLayout);
                                    if (topBarPlaceables3.isEmpty()) {
                                        fM6297constructorimpl = insets.getTop();
                                    } else {
                                        fM6297constructorimpl = C1956Dp.m6297constructorimpl(0);
                                    }
                                    if (bottomBarPlaceables.isEmpty() || bottomBarHeight == null) {
                                        bottom = insets.getBottom();
                                    } else {
                                        bottom = $this$SubcomposeLayout.mo515toDpu2uoSUM(bottomBarHeight.intValue());
                                    }
                                    PaddingValues innerPadding = PaddingKt.m763PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(insets, $this$SubcomposeLayout.getLayoutDirection()), fM6297constructorimpl, PaddingKt.calculateEndPadding(insets, $this$SubcomposeLayout.getLayoutDirection()), bottom);
                                    function32.invoke(innerPadding, $composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }));
                        List target$iv6 = new ArrayList($this$fastMap$iv8.size());
                        int size5 = $this$fastMap$iv8.size();
                        int index$iv$iv5 = 0;
                        while (index$iv$iv5 < size5) {
                            Object item$iv$iv5 = $this$fastMap$iv8.get(index$iv$iv5);
                            int index$iv$iv6 = index$iv$iv5;
                            Measurable it14 = (Measurable) item$iv$iv5;
                            long looseConstraints2 = looseConstraints;
                            target$iv6.add(it14.mo5219measureBRTryo0(Constraints.m6243copyZbe2FdA(looseConstraints2, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(looseConstraints2) : 0, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(looseConstraints2) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(looseConstraints2) : 0, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(looseConstraints2) : bodyContentHeight)));
                            index$iv$iv5 = index$iv$iv6 + 1;
                            size5 = size5;
                            looseConstraints = looseConstraints2;
                        }
                        final List bodyContentPlaceables = target$iv6;
                        final Integer bottomBarHeight2 = bottomBarHeight;
                        return MeasureScope.layout$default($this$SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout) {
                                List $this$fastForEach$iv = bodyContentPlaceables;
                                int i5 = topBarHeight;
                                int size6 = $this$fastForEach$iv.size();
                                for (int index$iv = 0; index$iv < size6; index$iv++) {
                                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                                    Placeable it15 = (Placeable) item$iv;
                                    Placeable.PlacementScope.place$default($this$layout, it15, 0, i5, 0.0f, 4, null);
                                }
                                List $this$fastForEach$iv2 = topBarPlaceables3;
                                int size7 = $this$fastForEach$iv2.size();
                                for (int index$iv2 = 0; index$iv2 < size7; index$iv2++) {
                                    Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
                                    Placeable it16 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.place$default($this$layout, it16, 0, 0, 0.0f, 4, null);
                                }
                                List $this$fastForEach$iv3 = snackbarPlaceables;
                                int i6 = layoutHeight;
                                int i7 = snackbarOffsetFromBottom;
                                int size8 = $this$fastForEach$iv3.size();
                                for (int index$iv3 = 0; index$iv3 < size8; index$iv3++) {
                                    Object item$iv3 = $this$fastForEach$iv3.get(index$iv3);
                                    Placeable it17 = (Placeable) item$iv3;
                                    Placeable.PlacementScope.place$default($this$layout, it17, 0, i6 - i7, 0.0f, 4, null);
                                }
                                List $this$fastForEach$iv4 = bottomBarPlaceables;
                                int i8 = layoutHeight;
                                Integer num = bottomBarHeight2;
                                int index$iv4 = 0;
                                int size9 = $this$fastForEach$iv4.size();
                                while (true) {
                                    int iIntValue = 0;
                                    if (index$iv4 >= size9) {
                                        break;
                                    }
                                    Object item$iv4 = $this$fastForEach$iv4.get(index$iv4);
                                    Placeable it18 = (Placeable) item$iv4;
                                    if (num != null) {
                                        iIntValue = num.intValue();
                                    }
                                    Placeable.PlacementScope.place$default($this$layout, it18, 0, i8 - iIntValue, 0.0f, 4, null);
                                    index$iv4++;
                                }
                                List $this$fastForEach$iv5 = fabPlaceables;
                                FabPlacement fabPlacement3 = fabPlacement2;
                                int i9 = layoutHeight;
                                Integer num2 = fabOffsetFromBottom;
                                int size10 = $this$fastForEach$iv5.size();
                                for (int index$iv5 = 0; index$iv5 < size10; index$iv5++) {
                                    Object item$iv5 = $this$fastForEach$iv5.get(index$iv5);
                                    Placeable it19 = (Placeable) item$iv5;
                                    Placeable.PlacementScope.place$default($this$layout, it19, fabPlacement3 != null ? fabPlacement3.getLeft() : 0, i9 - (num2 != null ? num2.intValue() : 0), 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$2
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
                    ScaffoldKt.m1638ScaffoldLayoutWithMeasureFixi1QSOvI(isFabDocked, fabPosition, function2, function3, function22, function23, contentWindowInsets, function24, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LegacyScaffoldLayout-i1QSOvI, reason: not valid java name */
    public static final void m1634LegacyScaffoldLayouti1QSOvI(final boolean isFabDocked, final int fabPosition, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets contentWindowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(141059468);
        ComposerKt.sourceInformation($composer2, "C(LegacyScaffoldLayout)P(5,4:c#material.FabPosition,7,1,6,3,2)628@26997L7169:Scaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(isFabDocked) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(fabPosition) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer2.changed(contentWindowInsets) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((23967451 & $dirty) != 4793490 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(141059468, $dirty, -1, "androidx.compose.material.LegacyScaffoldLayout (Scaffold.kt:627)");
            }
            $composer2.startReplaceableGroup(188877366);
            boolean invalid$iv = $composer2.changedInstance(function2) | $composer2.changedInstance(function22) | $composer2.changed(contentWindowInsets) | $composer2.changedInstance(function23) | $composer2.changed(fabPosition) | $composer2.changed(isFabDocked) | $composer2.changedInstance(function24) | $composer2.changedInstance(function3);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1642invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1642invoke0kLqBqw(final SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
                        final int layoutWidth = Constraints.m6253getMaxWidthimpl(constraints);
                        final int layoutHeight = Constraints.m6252getMaxHeightimpl(constraints);
                        final long looseConstraints = Constraints.m6243copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(constraints) : 0);
                        final Function2<Composer, Integer, Unit> function25 = function2;
                        final Function2<Composer, Integer, Unit> function26 = function22;
                        final Function2<Composer, Integer, Unit> function27 = function23;
                        final int i = fabPosition;
                        final boolean z = isFabDocked;
                        final WindowInsets windowInsets = contentWindowInsets;
                        final Function2<Composer, Integer, Unit> function28 = function24;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        return MeasureScope.layout$default($this$SubcomposeLayout, layoutWidth, layoutHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout) {
                                Object maxElem$iv;
                                Object maxElem$iv2;
                                FabPlacement fabPlacement;
                                int i2;
                                Object maxElem$iv3;
                                Integer numValueOf;
                                Object maxElem$iv4;
                                Object maxElem$iv5;
                                List $this$fastMap$iv = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.TopBar, function25);
                                long j = looseConstraints;
                                List target$iv = new ArrayList($this$fastMap$iv.size());
                                int size = $this$fastMap$iv.size();
                                for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                                    Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv);
                                    Measurable it = (Measurable) item$iv$iv;
                                    target$iv.add(it.mo5219measureBRTryo0(j));
                                }
                                List $this$fastMap$iv2 = target$iv;
                                List topBarPlaceables = $this$fastMap$iv2;
                                if ($this$fastMap$iv2.isEmpty()) {
                                    maxElem$iv = null;
                                } else {
                                    maxElem$iv = $this$fastMap$iv2.get(0);
                                    Placeable it2 = (Placeable) maxElem$iv;
                                    int maxValue$iv = it2.getHeight();
                                    int i$iv = 1;
                                    int lastIndex = CollectionsKt.getLastIndex($this$fastMap$iv2);
                                    if (1 <= lastIndex) {
                                        while (true) {
                                            Object e$iv = $this$fastMap$iv2.get(i$iv);
                                            Placeable it3 = (Placeable) e$iv;
                                            int v$iv = it3.getHeight();
                                            if (maxValue$iv < v$iv) {
                                                maxElem$iv = e$iv;
                                                maxValue$iv = v$iv;
                                            }
                                            if (i$iv == lastIndex) {
                                                break;
                                            } else {
                                                i$iv++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable = (Placeable) maxElem$iv;
                                int topBarHeight = placeable != null ? placeable.getHeight() : 0;
                                List $this$fastMap$iv3 = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.Snackbar, function26);
                                WindowInsets windowInsets2 = windowInsets;
                                SubcomposeMeasureScope subcomposeMeasureScope = $this$SubcomposeLayout;
                                long j2 = looseConstraints;
                                List target$iv2 = new ArrayList($this$fastMap$iv3.size());
                                int index$iv$iv2 = 0;
                                int size2 = $this$fastMap$iv3.size();
                                while (index$iv$iv2 < size2) {
                                    Object item$iv$iv2 = $this$fastMap$iv3.get(index$iv$iv2);
                                    Measurable it4 = (Measurable) item$iv$iv2;
                                    List $this$fastMap$iv4 = $this$fastMap$iv3;
                                    SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                    SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                    int leftInset = windowInsets2.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope3.getLayoutDirection());
                                    List topBarPlaceables2 = topBarPlaceables;
                                    int rightInset = windowInsets2.getRight(subcomposeMeasureScope2, subcomposeMeasureScope3.getLayoutDirection());
                                    int bottomInset = windowInsets2.getBottom(subcomposeMeasureScope2);
                                    WindowInsets windowInsets3 = windowInsets2;
                                    int i3 = (-leftInset) - rightInset;
                                    int leftInset2 = -bottomInset;
                                    target$iv2.add(it4.mo5219measureBRTryo0(ConstraintsKt.m6269offsetNN6EwU(j2, i3, leftInset2)));
                                    index$iv$iv2++;
                                    $this$fastMap$iv3 = $this$fastMap$iv4;
                                    subcomposeMeasureScope = subcomposeMeasureScope3;
                                    topBarPlaceables = topBarPlaceables2;
                                    windowInsets2 = windowInsets3;
                                }
                                final List topBarPlaceables3 = topBarPlaceables;
                                List snackbarPlaceables = target$iv2;
                                if (snackbarPlaceables.isEmpty()) {
                                    maxElem$iv2 = null;
                                } else {
                                    maxElem$iv2 = snackbarPlaceables.get(0);
                                    Placeable it5 = (Placeable) maxElem$iv2;
                                    int maxValue$iv2 = it5.getHeight();
                                    int i$iv2 = 1;
                                    int lastIndex2 = CollectionsKt.getLastIndex(snackbarPlaceables);
                                    if (1 <= lastIndex2) {
                                        while (true) {
                                            Object e$iv2 = snackbarPlaceables.get(i$iv2);
                                            Placeable it6 = (Placeable) e$iv2;
                                            int v$iv2 = it6.getHeight();
                                            if (maxValue$iv2 < v$iv2) {
                                                maxElem$iv2 = e$iv2;
                                                maxValue$iv2 = v$iv2;
                                            }
                                            if (i$iv2 == lastIndex2) {
                                                break;
                                            } else {
                                                i$iv2++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable2 = (Placeable) maxElem$iv2;
                                int snackbarHeight = placeable2 != null ? placeable2.getHeight() : 0;
                                List $this$fastMap$iv5 = $this$SubcomposeLayout.subcompose(ScaffoldLayoutContent.Fab, function27);
                                WindowInsets windowInsets4 = windowInsets;
                                SubcomposeMeasureScope subcomposeMeasureScope4 = $this$SubcomposeLayout;
                                long j3 = looseConstraints;
                                int $i$f$fastMap = 0;
                                ArrayList target$iv3 = new ArrayList($this$fastMap$iv5.size());
                                int index$iv$iv3 = 0;
                                int size3 = $this$fastMap$iv5.size();
                                while (index$iv$iv3 < size3) {
                                    Object item$iv$iv3 = $this$fastMap$iv5.get(index$iv$iv3);
                                    List snackbarPlaceables2 = snackbarPlaceables;
                                    ArrayList arrayList = target$iv3;
                                    List $this$fastMap$iv6 = $this$fastMap$iv5;
                                    Measurable measurable = (Measurable) item$iv$iv3;
                                    SubcomposeMeasureScope subcomposeMeasureScope5 = subcomposeMeasureScope4;
                                    SubcomposeMeasureScope subcomposeMeasureScope6 = subcomposeMeasureScope5;
                                    int $i$f$fastMap2 = $i$f$fastMap;
                                    int leftInset3 = windowInsets4.getLeft(subcomposeMeasureScope6, subcomposeMeasureScope5.getLayoutDirection());
                                    ArrayList target$iv4 = target$iv3;
                                    int rightInset2 = windowInsets4.getRight(subcomposeMeasureScope6, subcomposeMeasureScope5.getLayoutDirection());
                                    int bottomInset2 = windowInsets4.getBottom(subcomposeMeasureScope6);
                                    WindowInsets windowInsets5 = windowInsets4;
                                    int i4 = (-leftInset3) - rightInset2;
                                    int leftInset4 = -bottomInset2;
                                    arrayList.add(measurable.mo5219measureBRTryo0(ConstraintsKt.m6269offsetNN6EwU(j3, i4, leftInset4)));
                                    index$iv$iv3++;
                                    snackbarPlaceables = snackbarPlaceables2;
                                    $this$fastMap$iv5 = $this$fastMap$iv6;
                                    subcomposeMeasureScope4 = subcomposeMeasureScope5;
                                    $i$f$fastMap = $i$f$fastMap2;
                                    target$iv3 = target$iv4;
                                    windowInsets4 = windowInsets5;
                                }
                                List snackbarPlaceables3 = snackbarPlaceables;
                                ArrayList fabPlaceables = target$iv3;
                                if (fabPlaceables.isEmpty()) {
                                    fabPlacement = null;
                                } else {
                                    if (fabPlaceables.isEmpty()) {
                                        maxElem$iv4 = null;
                                    } else {
                                        maxElem$iv4 = fabPlaceables.get(0);
                                        Placeable it7 = (Placeable) maxElem$iv4;
                                        int maxValue$iv3 = it7.getWidth();
                                        int i$iv3 = 1;
                                        int lastIndex3 = CollectionsKt.getLastIndex(fabPlaceables);
                                        if (1 <= lastIndex3) {
                                            while (true) {
                                                Object e$iv3 = fabPlaceables.get(i$iv3);
                                                Placeable it8 = (Placeable) e$iv3;
                                                int v$iv3 = it8.getWidth();
                                                if (maxValue$iv3 < v$iv3) {
                                                    maxElem$iv4 = e$iv3;
                                                    maxValue$iv3 = v$iv3;
                                                }
                                                if (i$iv3 == lastIndex3) {
                                                    break;
                                                } else {
                                                    i$iv3++;
                                                }
                                            }
                                        }
                                    }
                                    Placeable placeable3 = (Placeable) maxElem$iv4;
                                    int fabWidth = placeable3 != null ? placeable3.getWidth() : 0;
                                    if (fabPlaceables.isEmpty()) {
                                        maxElem$iv5 = null;
                                    } else {
                                        maxElem$iv5 = fabPlaceables.get(0);
                                        Placeable it9 = (Placeable) maxElem$iv5;
                                        int maxValue$iv4 = it9.getHeight();
                                        int i$iv4 = 1;
                                        int lastIndex4 = CollectionsKt.getLastIndex(fabPlaceables);
                                        if (1 <= lastIndex4) {
                                            while (true) {
                                                Object e$iv4 = fabPlaceables.get(i$iv4);
                                                Placeable it10 = (Placeable) e$iv4;
                                                int v$iv4 = it10.getHeight();
                                                if (maxValue$iv4 < v$iv4) {
                                                    maxElem$iv5 = e$iv4;
                                                    maxValue$iv4 = v$iv4;
                                                }
                                                if (i$iv4 == lastIndex4) {
                                                    break;
                                                } else {
                                                    i$iv4++;
                                                }
                                            }
                                        }
                                    }
                                    Placeable placeable4 = (Placeable) maxElem$iv5;
                                    int fabHeight = placeable4 != null ? placeable4.getHeight() : 0;
                                    if (fabWidth == 0 || fabHeight == 0) {
                                        fabPlacement = null;
                                    } else {
                                        int i5 = i;
                                        int fabLeftOffset = FabPosition.m1562equalsimpl0(i5, FabPosition.INSTANCE.m1568getStart5ygKITE()) ? $this$SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? $this$SubcomposeLayout.mo512roundToPx0680j_4(ScaffoldKt.FabSpacing) : (layoutWidth - $this$SubcomposeLayout.mo512roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth : FabPosition.m1562equalsimpl0(i5, FabPosition.INSTANCE.m1567getEnd5ygKITE()) ? $this$SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? (layoutWidth - $this$SubcomposeLayout.mo512roundToPx0680j_4(ScaffoldKt.FabSpacing)) - fabWidth : $this$SubcomposeLayout.mo512roundToPx0680j_4(ScaffoldKt.FabSpacing) : (layoutWidth - fabWidth) / 2;
                                        fabPlacement = new FabPlacement(z, fabLeftOffset, fabWidth, fabHeight);
                                    }
                                }
                                final FabPlacement fabPlacement2 = fabPlacement;
                                SubcomposeMeasureScope subcomposeMeasureScope7 = $this$SubcomposeLayout;
                                ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                                final Function2<Composer, Integer, Unit> function29 = function28;
                                List $this$fastMap$iv7 = subcomposeMeasureScope7.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(-252607998, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1$1$bottomBarPlaceables$1
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

                                    public final void invoke(Composer $composer3, int $changed2) {
                                        ComposerKt.sourceInformation($composer3, "C714@30842L144:Scaffold.kt#jmzs0o");
                                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-252607998, $changed2, -1, "androidx.compose.material.LegacyScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:714)");
                                            }
                                            CompositionLocalKt.CompositionLocalProvider(ScaffoldKt.getLocalFabPlacement().provides(fabPlacement2), function29, $composer3, ProvidedValue.$stable | 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer3.skipToGroupEnd();
                                    }
                                }));
                                long j4 = looseConstraints;
                                List target$iv5 = new ArrayList($this$fastMap$iv7.size());
                                int index$iv$iv4 = 0;
                                int size4 = $this$fastMap$iv7.size();
                                while (index$iv$iv4 < size4) {
                                    Object item$iv$iv4 = $this$fastMap$iv7.get(index$iv$iv4);
                                    List fabPlaceables2 = fabPlaceables;
                                    Measurable it11 = (Measurable) item$iv$iv4;
                                    target$iv5.add(it11.mo5219measureBRTryo0(j4));
                                    index$iv$iv4++;
                                    fabPlaceables = fabPlaceables2;
                                }
                                List fabPlaceables3 = fabPlaceables;
                                final List bottomBarPlaceables = target$iv5;
                                if (bottomBarPlaceables.isEmpty()) {
                                    maxElem$iv3 = null;
                                    i2 = 0;
                                } else {
                                    i2 = 0;
                                    maxElem$iv3 = bottomBarPlaceables.get(0);
                                    Placeable it12 = (Placeable) maxElem$iv3;
                                    int maxValue$iv5 = it12.getHeight();
                                    int i$iv5 = 1;
                                    int lastIndex5 = CollectionsKt.getLastIndex(bottomBarPlaceables);
                                    if (1 <= lastIndex5) {
                                        while (true) {
                                            Object e$iv5 = bottomBarPlaceables.get(i$iv5);
                                            Placeable it13 = (Placeable) e$iv5;
                                            int v$iv5 = it13.getHeight();
                                            if (maxValue$iv5 < v$iv5) {
                                                maxElem$iv3 = e$iv5;
                                                maxValue$iv5 = v$iv5;
                                            }
                                            if (i$iv5 == lastIndex5) {
                                                break;
                                            } else {
                                                i$iv5++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable5 = (Placeable) maxElem$iv3;
                                final Integer bottomBarHeight = placeable5 != null ? Integer.valueOf(placeable5.getHeight()) : null;
                                if (fabPlacement2 != null) {
                                    SubcomposeMeasureScope subcomposeMeasureScope8 = $this$SubcomposeLayout;
                                    numValueOf = Integer.valueOf(bottomBarHeight == null ? fabPlacement2.getHeight() + subcomposeMeasureScope8.mo512roundToPx0680j_4(ScaffoldKt.FabSpacing) + windowInsets.getBottom(subcomposeMeasureScope8) : z ? bottomBarHeight.intValue() + (fabPlacement2.getHeight() / 2) : bottomBarHeight.intValue() + fabPlacement2.getHeight() + subcomposeMeasureScope8.mo512roundToPx0680j_4(ScaffoldKt.FabSpacing));
                                } else {
                                    numValueOf = null;
                                }
                                Integer fabOffsetFromBottom = numValueOf;
                                int snackbarOffsetFromBottom = snackbarHeight != 0 ? snackbarHeight + (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : bottomBarHeight != null ? bottomBarHeight.intValue() : windowInsets.getBottom($this$SubcomposeLayout)) : i2;
                                int bodyContentHeight = layoutHeight - topBarHeight;
                                SubcomposeMeasureScope subcomposeMeasureScope9 = $this$SubcomposeLayout;
                                ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                                final WindowInsets windowInsets6 = windowInsets;
                                final SubcomposeMeasureScope subcomposeMeasureScope10 = $this$SubcomposeLayout;
                                final Function3<PaddingValues, Composer, Integer, Unit> function33 = function32;
                                List $this$fastMap$iv8 = subcomposeMeasureScope9.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(230985361, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1$1$bodyContentPlaceables$1
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

                                    public final void invoke(Composer $composer3, int $changed2) {
                                        float fM6297constructorimpl;
                                        float bottom;
                                        ComposerKt.sourceInformation($composer3, "C765@33186L21:Scaffold.kt#jmzs0o");
                                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(230985361, $changed2, -1, "androidx.compose.material.LegacyScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:748)");
                                            }
                                            PaddingValues insets = WindowInsetsKt.asPaddingValues(windowInsets6, subcomposeMeasureScope10);
                                            if (topBarPlaceables3.isEmpty()) {
                                                fM6297constructorimpl = insets.getTop();
                                            } else {
                                                fM6297constructorimpl = C1956Dp.m6297constructorimpl(0);
                                            }
                                            if (bottomBarPlaceables.isEmpty() || bottomBarHeight == null) {
                                                bottom = insets.getBottom();
                                            } else {
                                                bottom = subcomposeMeasureScope10.mo515toDpu2uoSUM(bottomBarHeight.intValue());
                                            }
                                            PaddingValues innerPadding = PaddingKt.m763PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(insets, subcomposeMeasureScope10.getLayoutDirection()), fM6297constructorimpl, PaddingKt.calculateEndPadding(insets, subcomposeMeasureScope10.getLayoutDirection()), bottom);
                                            function33.invoke(innerPadding, $composer3, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer3.skipToGroupEnd();
                                    }
                                }));
                                long j5 = looseConstraints;
                                List target$iv6 = new ArrayList($this$fastMap$iv8.size());
                                int size5 = $this$fastMap$iv8.size();
                                int index$iv$iv5 = 0;
                                while (index$iv$iv5 < size5) {
                                    Object item$iv$iv5 = $this$fastMap$iv8.get(index$iv$iv5);
                                    List $this$fastMap$iv9 = $this$fastMap$iv8;
                                    Measurable it14 = (Measurable) item$iv$iv5;
                                    long j6 = j5;
                                    target$iv6.add(it14.mo5219measureBRTryo0(Constraints.m6243copyZbe2FdA(j6, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(j6) : 0, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(j6) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(j6) : 0, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(j6) : bodyContentHeight)));
                                    index$iv$iv5++;
                                    j5 = j6;
                                    $this$fastMap$iv8 = $this$fastMap$iv9;
                                }
                                List bodyContentPlaceables = target$iv6;
                                int index$iv = 0;
                                int size6 = bodyContentPlaceables.size();
                                while (index$iv < size6) {
                                    Object item$iv = bodyContentPlaceables.get(index$iv);
                                    Placeable it15 = (Placeable) item$iv;
                                    Placeable.PlacementScope.place$default($this$layout, it15, 0, topBarHeight, 0.0f, 4, null);
                                    index$iv++;
                                    fabPlacement2 = fabPlacement2;
                                }
                                FabPlacement fabPlacement3 = fabPlacement2;
                                int size7 = topBarPlaceables3.size();
                                for (int index$iv2 = 0; index$iv2 < size7; index$iv2++) {
                                    Object item$iv2 = topBarPlaceables3.get(index$iv2);
                                    Placeable it16 = (Placeable) item$iv2;
                                    Placeable.PlacementScope.place$default($this$layout, it16, 0, 0, 0.0f, 4, null);
                                }
                                int i6 = layoutHeight;
                                int size8 = snackbarPlaceables3.size();
                                for (int index$iv3 = 0; index$iv3 < size8; index$iv3++) {
                                    Object item$iv3 = snackbarPlaceables3.get(index$iv3);
                                    Placeable it17 = (Placeable) item$iv3;
                                    Placeable.PlacementScope.place$default($this$layout, it17, 0, i6 - snackbarOffsetFromBottom, 0.0f, 4, null);
                                }
                                int i7 = layoutHeight;
                                int size9 = bottomBarPlaceables.size();
                                for (int index$iv4 = 0; index$iv4 < size9; index$iv4++) {
                                    Object item$iv4 = bottomBarPlaceables.get(index$iv4);
                                    Placeable it18 = (Placeable) item$iv4;
                                    Placeable.PlacementScope.place$default($this$layout, it18, 0, i7 - (bottomBarHeight != null ? bottomBarHeight.intValue() : 0), 0.0f, 4, null);
                                }
                                int i8 = layoutHeight;
                                int size10 = fabPlaceables3.size();
                                for (int index$iv5 = 0; index$iv5 < size10; index$iv5++) {
                                    Object item$iv5 = fabPlaceables3.get(index$iv5);
                                    Placeable it19 = (Placeable) item$iv5;
                                    Placeable.PlacementScope.place$default($this$layout, it19, fabPlacement3 != null ? fabPlacement3.getLeft() : 0, i8 - (fabOffsetFromBottom != null ? fabOffsetFromBottom.intValue() : 0), 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$2
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
                    ScaffoldKt.m1634LegacyScaffoldLayouti1QSOvI(isFabDocked, fabPosition, function2, function3, function22, function23, contentWindowInsets, function24, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
