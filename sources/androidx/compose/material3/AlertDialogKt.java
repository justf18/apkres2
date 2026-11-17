package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: AlertDialog.kt */
@Metadata(m164d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a¦\u0001\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\b\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a5\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00012\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, m165d2 = {"DialogMaxWidth", "Landroidx/compose/ui/unit/Dp;", "getDialogMaxWidth", "()F", "F", "DialogMinWidth", "getDialogMinWidth", "DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "TextPadding", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "buttonContentColor", "iconContentColor", "titleContentColor", "textContentColor", "AlertDialogContent-4hvqGtA", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogFlowRow", "mainAxisSpacing", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AlertDialogKt {
    private static final float DialogMinWidth = C1956Dp.m6297constructorimpl(280);
    private static final float DialogMaxWidth = C1956Dp.m6297constructorimpl(560);
    private static final PaddingValues DialogPadding = PaddingKt.m760PaddingValues0680j_4(C1956Dp.m6297constructorimpl(24));
    private static final PaddingValues IconPadding = PaddingKt.m764PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, C1956Dp.m6297constructorimpl(16), 7, null);
    private static final PaddingValues TitlePadding = PaddingKt.m764PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, C1956Dp.m6297constructorimpl(16), 7, null);
    private static final PaddingValues TextPadding = PaddingKt.m764PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, C1956Dp.m6297constructorimpl(24), 7, null);

    /* renamed from: AlertDialogContent-4hvqGtA, reason: not valid java name */
    public static final void m1763AlertDialogContent4hvqGtA(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Shape shape, final long containerColor, final float tonalElevation, final long buttonContentColor, final long iconContentColor, final long titleContentColor, final long textContentColor, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function25;
        Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Shape shape2;
        int i2;
        float f;
        int $dirty;
        long j;
        Composer $composer2;
        final Modifier modifier3;
        Composer $composer3 = $composer.startRestartGroup(1522575799);
        ComposerKt.sourceInformation($composer3, "C(AlertDialogContent)P(1,5,3,9,7,6,2:c#ui.graphics.Color,11:c#ui.unit.Dp,0:c#ui.graphics.Color,4:c#ui.graphics.Color,10:c#ui.graphics.Color,8:c#ui.graphics.Color)53@1918L2445:AlertDialog.kt#uh7d8r");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
            function25 = function2;
        } else if (($changed & 6) == 0) {
            function25 = function2;
            $dirty2 |= $composer3.changedInstance(function25) ? 4 : 2;
        } else {
            function25 = function2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
            function26 = function22;
        } else if (($changed & 384) == 0) {
            function26 = function22;
            $dirty2 |= $composer3.changedInstance(function26) ? 256 : 128;
        } else {
            function26 = function22;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
            function27 = function23;
        } else if (($changed & 3072) == 0) {
            function27 = function23;
            $dirty2 |= $composer3.changedInstance(function27) ? 2048 : 1024;
        } else {
            function27 = function23;
        }
        if ((i & 16) != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changedInstance(function24) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            shape2 = shape;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            shape2 = shape;
            $dirty2 |= $composer3.changed(shape2) ? 131072 : 65536;
        } else {
            shape2 = shape;
        }
        if ((i & 64) != 0) {
            $dirty2 |= 1572864;
            i2 = i3;
        } else if (($changed & 1572864) == 0) {
            i2 = i3;
            $dirty2 |= $composer3.changed(containerColor) ? 1048576 : 524288;
        } else {
            i2 = i3;
        }
        if ((i & 128) != 0) {
            $dirty2 |= 12582912;
            f = tonalElevation;
        } else if (($changed & 12582912) == 0) {
            f = tonalElevation;
            $dirty2 |= $composer3.changed(f) ? 8388608 : 4194304;
        } else {
            f = tonalElevation;
        }
        if ((i & 256) != 0) {
            $dirty = $dirty2 | 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty = $dirty2 | ($composer3.changed(buttonContentColor) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432);
        } else {
            $dirty = $dirty2;
        }
        if ((i & 512) != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changed(iconContentColor) ? 536870912 : 268435456;
        }
        int $dirty3 = $dirty;
        if ((i & 1024) != 0) {
            $dirty1 |= 6;
            j = titleContentColor;
        } else if (($changed1 & 6) == 0) {
            j = titleContentColor;
            $dirty1 |= $composer3.changed(j) ? 4 : 2;
        } else {
            j = titleContentColor;
        }
        if ((i & 2048) != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changed(textContentColor) ? 32 : 16;
        }
        if (($dirty3 & 306783379) != 306783378 || ($dirty1 & 19) != 18 || !$composer3.getSkipping()) {
            if (i2 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1522575799, $dirty3, $dirty1, "androidx.compose.material3.AlertDialogContent (AlertDialog.kt:52)");
            }
            final long j2 = j;
            final Function2<? super Composer, ? super Integer, Unit> function28 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
            Modifier modifier4 = modifier2;
            SurfaceKt.m2519SurfaceT9BRK9s(modifier4, shape2, containerColor, 0L, f, 0.0f, null, ComposableLambdaKt.composableLambda($composer3, -2126308228, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x017f  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x0184  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x01c3  */
                /* JADX WARN: Removed duplicated region for block: B:33:0x01cd  */
                /* JADX WARN: Removed duplicated region for block: B:36:0x021b  */
                /* JADX WARN: Removed duplicated region for block: B:37:0x021e  */
                /* JADX WARN: Removed duplicated region for block: B:40:0x02ba  */
                /* JADX WARN: Removed duplicated region for block: B:43:0x02c6  */
                /* JADX WARN: Removed duplicated region for block: B:44:0x02ca  */
                /* JADX WARN: Removed duplicated region for block: B:47:0x02f9  */
                /* JADX WARN: Removed duplicated region for block: B:51:0x030f  */
                /* JADX WARN: Removed duplicated region for block: B:55:0x03cf  */
                /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r52, int r53) {
                    /*
                        Method dump skipped, instructions count: 979
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt$AlertDialogContent$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer3, (($dirty3 >> 3) & 14) | 12582912 | (($dirty3 >> 12) & 112) | (($dirty3 >> 12) & 896) | (($dirty3 >> 9) & 57344), LocationRequestCompat.QUALITY_LOW_POWER);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogContent$2
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

                public final void invoke(Composer composer, int i4) {
                    AlertDialogKt.m1763AlertDialogContent4hvqGtA(function2, modifier3, function22, function23, function24, shape, containerColor, tonalElevation, buttonContentColor, iconContentColor, titleContentColor, textContentColor, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m1764AlertDialogFlowRowixp7dh8(final float mainAxisSpacing, final float crossAxisSpacing, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        MeasurePolicy value$iv;
        Composer $composer2 = $composer.startRestartGroup(586821353);
        ComposerKt.sourceInformation($composer2, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)130@4637L3306,130@4621L3322:AlertDialog.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(mainAxisSpacing) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(crossAxisSpacing) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586821353, $dirty, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:129)");
            }
            $composer2.startReplaceableGroup(-1133133582);
            ComposerKt.sourceInformation($composer2, "CC(remember):AlertDialog.kt#9igjgp");
            boolean invalid$iv = (($dirty & 14) == 4) | (($dirty & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1$1
                    @Override // androidx.compose.p000ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo243measure3p2s80s(final MeasureScope $this$Layout, List<? extends Measurable> list, long constraints) {
                        Ref.IntRef currentCrossAxisSize;
                        int index$iv;
                        List sequences = new ArrayList();
                        List crossAxisSizes = new ArrayList();
                        final List crossAxisPositions = new ArrayList();
                        Ref.IntRef mainAxisSpace = new Ref.IntRef();
                        Ref.IntRef crossAxisSpace = new Ref.IntRef();
                        List currentSequence = new ArrayList();
                        Ref.IntRef currentMainAxisSize = new Ref.IntRef();
                        Ref.IntRef currentCrossAxisSize2 = new Ref.IntRef();
                        float f = mainAxisSpacing;
                        float f2 = crossAxisSpacing;
                        List $this$fastForEach$iv = list;
                        int index$iv2 = 0;
                        int size = $this$fastForEach$iv.size();
                        while (index$iv2 < size) {
                            Object item$iv = $this$fastForEach$iv.get(index$iv2);
                            Measurable measurable = (Measurable) item$iv;
                            List $this$fastForEach$iv2 = $this$fastForEach$iv;
                            List sequences2 = sequences;
                            Placeable placeable = measurable.mo5219measureBRTryo0(constraints);
                            int i = size;
                            Ref.IntRef currentMainAxisSize2 = currentMainAxisSize;
                            currentMainAxisSize = currentMainAxisSize2;
                            if (measure_3p2s80s$canAddToCurrentSequence(currentSequence, currentMainAxisSize2, $this$Layout, f, constraints, placeable)) {
                                index$iv = index$iv2;
                                sequences = sequences2;
                            } else {
                                index$iv = index$iv2;
                                sequences = sequences2;
                                measure_3p2s80s$startNewSequence(sequences, crossAxisSpace, $this$Layout, f2, currentSequence, crossAxisSizes, currentCrossAxisSize2, crossAxisPositions, mainAxisSpace, currentMainAxisSize);
                            }
                            if (!currentSequence.isEmpty()) {
                                currentMainAxisSize.element += $this$Layout.mo512roundToPx0680j_4(f);
                            }
                            currentSequence.add(placeable);
                            currentMainAxisSize.element += placeable.getWidth();
                            currentCrossAxisSize2.element = Math.max(currentCrossAxisSize2.element, placeable.getHeight());
                            index$iv2 = index$iv + 1;
                            size = i;
                            $this$fastForEach$iv = $this$fastForEach$iv2;
                        }
                        if (currentSequence.isEmpty()) {
                            currentCrossAxisSize = crossAxisSpace;
                        } else {
                            measure_3p2s80s$startNewSequence(sequences, crossAxisSpace, $this$Layout, crossAxisSpacing, currentSequence, crossAxisSizes, currentCrossAxisSize2, crossAxisPositions, mainAxisSpace, currentMainAxisSize);
                            currentCrossAxisSize = crossAxisSpace;
                        }
                        final int mainAxisLayoutSize = Math.max(mainAxisSpace.element, Constraints.m6255getMinWidthimpl(constraints));
                        int crossAxisLayoutSize = Math.max(currentCrossAxisSize.element, Constraints.m6254getMinHeightimpl(constraints));
                        final List sequences3 = sequences;
                        final float f3 = mainAxisSpacing;
                        return MeasureScope.layout$default($this$Layout, mainAxisLayoutSize, crossAxisLayoutSize, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                List $this$fastForEachIndexed$iv = sequences3;
                                MeasureScope measureScope = $this$Layout;
                                float f4 = f3;
                                int i2 = mainAxisLayoutSize;
                                List<Integer> list2 = crossAxisPositions;
                                int size2 = $this$fastForEachIndexed$iv.size();
                                int index$iv3 = 0;
                                while (index$iv3 < size2) {
                                    Object item$iv2 = $this$fastForEachIndexed$iv.get(index$iv3);
                                    List placeables = (List) item$iv2;
                                    int i3 = index$iv3;
                                    int size3 = placeables.size();
                                    int[] childrenMainAxisSizes = new int[size3];
                                    int i4 = 0;
                                    while (i4 < size3) {
                                        childrenMainAxisSizes[i4] = placeables.get(i4).getWidth() + (i4 < CollectionsKt.getLastIndex(placeables) ? measureScope.mo512roundToPx0680j_4(f4) : 0);
                                        i4++;
                                    }
                                    Arrangement.Horizontal arrangement = Arrangement.INSTANCE.getEnd();
                                    int length = childrenMainAxisSizes.length;
                                    int[] mainAxisPositions = new int[length];
                                    for (int i5 = 0; i5 < length; i5++) {
                                        mainAxisPositions[i5] = 0;
                                    }
                                    arrangement.arrange(measureScope, i2, childrenMainAxisSizes, measureScope.getLayoutDirection(), mainAxisPositions);
                                    List $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv;
                                    int size4 = placeables.size();
                                    for (int index$iv4 = 0; index$iv4 < size4; index$iv4++) {
                                        Object item$iv3 = placeables.get(index$iv4);
                                        Placeable placeable2 = (Placeable) item$iv3;
                                        int j = index$iv4;
                                        Placeable.PlacementScope.place$default($this$layout, placeable2, mainAxisPositions[j], list2.get(i3).intValue(), 0.0f, 4, null);
                                    }
                                    index$iv3++;
                                    $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                                }
                            }
                        }, 4, null);
                    }

                    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef currentMainAxisSize, MeasureScope $this_Layout, float $mainAxisSpacing, long $constraints, Placeable placeable) {
                        return list.isEmpty() || (currentMainAxisSize.element + $this_Layout.mo512roundToPx0680j_4($mainAxisSpacing)) + placeable.getWidth() <= Constraints.m6253getMaxWidthimpl($constraints);
                    }

                    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef crossAxisSpace, MeasureScope $this_Layout, float $crossAxisSpacing, List<Placeable> list2, List<Integer> list3, Ref.IntRef currentCrossAxisSize, List<Integer> list4, Ref.IntRef mainAxisSpace, Ref.IntRef currentMainAxisSize) {
                        if (!list.isEmpty()) {
                            crossAxisSpace.element += $this_Layout.mo512roundToPx0680j_4($crossAxisSpacing);
                        }
                        list.add(0, CollectionsKt.toList(list2));
                        list3.add(Integer.valueOf(currentCrossAxisSize.element));
                        list4.add(Integer.valueOf(crossAxisSpace.element));
                        crossAxisSpace.element += currentCrossAxisSize.element;
                        mainAxisSpace.element = Math.max(mainAxisSpace.element, currentMainAxisSize.element);
                        list2.clear();
                        currentMainAxisSize.element = 0;
                        currentCrossAxisSize.element = 0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv;
            $composer2.endReplaceableGroup();
            int $changed$iv = ($dirty >> 6) & 14;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.INSTANCE;
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.modifierMaterializerOf(modifier$iv);
            int $changed$iv$iv = (($changed$iv << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3479constructorimpl($composer2);
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
            }
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            function2.invoke($composer2, Integer.valueOf(($changed$iv$iv >> 9) & 14));
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$2
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
                    AlertDialogKt.m1764AlertDialogFlowRowixp7dh8(mainAxisSpacing, crossAxisSpacing, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final float getDialogMinWidth() {
        return DialogMinWidth;
    }

    public static final float getDialogMaxWidth() {
        return DialogMaxWidth;
    }
}
