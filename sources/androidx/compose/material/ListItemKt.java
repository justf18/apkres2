package androidx.compose.material;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.layout.AlignmentLineKt;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.style.LineHeightStyle;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListItem.kt */
@Metadata(m164d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\n\u001a\u0090\u0001\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u0013\u001a7\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\tH\u0002¢\u0006\u0002\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, m165d2 = {"BaselinesOffsetColumn", "", "offsets", "", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ListItem", "icon", "secondaryText", "singleLineSecondaryText", "", "overlineText", "trailing", "text", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OffsetToBaselineOrCenter", TypedValues.CycleType.S_WAVE_OFFSET, "OffsetToBaselineOrCenter-Kz89ssw", "(FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "applyTextStyle", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "(Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "material_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ListItemKt {
    public static final void ListItem(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean singleLineSecondaryText, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, Composer $composer, final int $changed, final int $dirty) {
        Modifier modifier2;
        Function2 function26;
        Function2 function27;
        boolean z;
        Function2 function28;
        Modifier.Companion modifier3;
        final Function2 secondaryText;
        final boolean singleLineSecondaryText2;
        final Function2 overlineText;
        final Function2 trailing;
        Function2 icon;
        final Function2 icon2;
        Composer $composer2 = $composer.startRestartGroup(-450923337);
        ComposerKt.sourceInformation($composer2, "C(ListItem)P(1!1,3,4!1,6)84@3532L10,86@3615L4,87@3705L6,88@3806L4,89@3899L4:ListItem.kt#jmzs0o");
        int $dirty2 = $changed;
        int i = $dirty & 1;
        if (i != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i2 = $dirty & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
            function26 = function2;
        } else if (($changed & 112) == 0) {
            function26 = function2;
            $dirty2 |= $composer2.changedInstance(function26) ? 32 : 16;
        } else {
            function26 = function2;
        }
        int i3 = $dirty & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            function27 = function22;
        } else if (($changed & 896) == 0) {
            function27 = function22;
            $dirty2 |= $composer2.changedInstance(function27) ? 256 : 128;
        } else {
            function27 = function22;
        }
        int i4 = $dirty & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            z = singleLineSecondaryText;
        } else if (($changed & 7168) == 0) {
            z = singleLineSecondaryText;
            $dirty2 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = singleLineSecondaryText;
        }
        int i5 = $dirty & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            function28 = function23;
        } else if ((57344 & $changed) == 0) {
            function28 = function23;
            $dirty2 |= $composer2.changedInstance(function28) ? 16384 : 8192;
        } else {
            function28 = function23;
        }
        int i6 = $dirty & 32;
        if (i6 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed & 458752) == 0) {
            $dirty2 |= $composer2.changedInstance(function24) ? 131072 : 65536;
        }
        if (($dirty & 64) != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty2 |= $composer2.changedInstance(function25) ? 1048576 : 524288;
        }
        if (($dirty2 & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            trailing = function24;
            modifier3 = modifier2;
            icon2 = function26;
            secondaryText = function27;
            singleLineSecondaryText2 = z;
            overlineText = function28;
        } else {
            modifier3 = i != 0 ? Modifier.INSTANCE : modifier2;
            Function2 icon3 = i2 != 0 ? null : function26;
            secondaryText = i3 != 0 ? null : function27;
            singleLineSecondaryText2 = i4 != 0 ? true : z;
            overlineText = i5 != 0 ? null : function28;
            trailing = i6 != 0 ? null : function24;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-450923337, $dirty2, -1, "androidx.compose.material.ListItem (ListItem.kt:83)");
            }
            Typography typography = MaterialTheme.INSTANCE.getTypography($composer2, 6);
            Function2 styledText = applyTextStyle(typography.getSubtitle1(), ContentAlpha.INSTANCE.getHigh($composer2, 6), function25);
            Intrinsics.checkNotNull(styledText);
            Function2 styledSecondaryText = applyTextStyle(typography.getBody2(), ContentAlpha.INSTANCE.getMedium($composer2, 6), secondaryText);
            Function2 styledOverlineText = applyTextStyle(typography.getOverline(), ContentAlpha.INSTANCE.getHigh($composer2, 6), overlineText);
            Function2 styledTrailing = applyTextStyle(typography.getCaption(), ContentAlpha.INSTANCE.getHigh($composer2, 6), trailing);
            Modifier semanticsModifier = SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                }
            });
            if (styledSecondaryText == null && styledOverlineText == null) {
                $composer2.startReplaceableGroup(-210280444);
                ComposerKt.sourceInformation($composer2, "94@4077L61");
                icon = icon3;
                OneLine.INSTANCE.ListItem(semanticsModifier, icon, styledText, styledTrailing, $composer2, ($dirty2 & 112) | 24576, 0);
                $composer2.endReplaceableGroup();
            } else {
                icon = icon3;
                if ((styledOverlineText == null && singleLineSecondaryText2) || styledSecondaryText == null) {
                    $composer2.startReplaceableGroup(-210280247);
                    ComposerKt.sourceInformation($composer2, "98@4274L184");
                    TwoLine.INSTANCE.ListItem(semanticsModifier, icon, styledText, styledSecondaryText, styledOverlineText, styledTrailing, $composer2, ($dirty2 & 112) | 1572864, 0);
                    $composer2 = $composer2;
                    $composer2.endReplaceableGroup();
                } else {
                    $composer2.startReplaceableGroup(-210280033);
                    ComposerKt.sourceInformation($composer2, "107@4490L184");
                    ThreeLine.INSTANCE.ListItem(semanticsModifier, icon, styledText, styledSecondaryText, styledOverlineText, styledTrailing, $composer2, ($dirty2 & 112) | 1572864, 0);
                    $composer2 = $composer2;
                    $composer2.endReplaceableGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            icon2 = icon;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.ListItem.1
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

                public final void invoke(Composer composer, int i7) {
                    ListItemKt.ListItem(modifier4, icon2, secondaryText, singleLineSecondaryText2, overlineText, trailing, function25, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), $dirty);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BaselinesOffsetColumn(final List<C1956Dp> list, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2 = $composer.startRestartGroup(1631148337);
        ComposerKt.sourceInformation($composer2, "C(BaselinesOffsetColumn)P(2,1)355@13242L1135:ListItem.kt#jmzs0o");
        if ((i & 2) != 0) {
            modifier2 = Modifier.INSTANCE;
        } else {
            modifier2 = modifier;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1631148337, $changed, -1, "androidx.compose.material.BaselinesOffsetColumn (ListItem.kt:354)");
        }
        MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.material.ListItemKt.BaselinesOffsetColumn.1
            @Override // androidx.compose.p000ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo243measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list2, long constraints) {
                int containerHeight;
                int toPreviousBaseline;
                long childConstraints = Constraints.m6243copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6255getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6253getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6254getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6252getMaxHeightimpl(constraints) : Integer.MAX_VALUE);
                List target$iv = new ArrayList(list2.size());
                int size = list2.size();
                for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                    Object item$iv$iv = list2.get(index$iv$iv);
                    Measurable it = (Measurable) item$iv$iv;
                    target$iv.add(it.mo5219measureBRTryo0(childConstraints));
                }
                final List placeables = target$iv;
                int i2 = 0;
                Object accumulator$iv = 0;
                int index$iv$iv2 = 0;
                int size2 = placeables.size();
                while (index$iv$iv2 < size2) {
                    Object item$iv$iv2 = placeables.get(index$iv$iv2);
                    int maxWidth = ((Number) accumulator$iv).intValue();
                    accumulator$iv = Integer.valueOf(Math.max(maxWidth, ((Placeable) item$iv$iv2).getWidth()));
                    index$iv$iv2++;
                    i2 = i2;
                    childConstraints = childConstraints;
                }
                int i3 = i2;
                int containerWidth = ((Number) accumulator$iv).intValue();
                int size3 = placeables.size();
                final Integer[] y = new Integer[size3];
                for (int i4 = i3; i4 < size3; i4++) {
                    y[i4] = Integer.valueOf(i3);
                }
                int containerHeight2 = 0;
                List<C1956Dp> list3 = list;
                int index$iv = 0;
                int size4 = placeables.size();
                while (index$iv < size4) {
                    Object item$iv = placeables.get(index$iv);
                    Placeable placeable = (Placeable) item$iv;
                    int index = index$iv;
                    if (index > 0) {
                        containerHeight = containerHeight2;
                        toPreviousBaseline = ((Placeable) placeables.get(index - 1)).getHeight() - ((Placeable) placeables.get(index - 1)).get(AlignmentLineKt.getLastBaseline());
                    } else {
                        containerHeight = containerHeight2;
                        toPreviousBaseline = i3;
                    }
                    int containerWidth2 = containerWidth;
                    int containerWidth3 = i3;
                    int topPadding = Math.max(containerWidth3, ($this$Layout.mo512roundToPx0680j_4(list3.get(index).m6311unboximpl()) - placeable.get(AlignmentLineKt.getFirstBaseline())) - toPreviousBaseline);
                    y[index] = Integer.valueOf(topPadding + containerHeight);
                    index$iv++;
                    i3 = containerWidth3;
                    containerWidth = containerWidth2;
                    containerHeight2 = containerHeight + topPadding + placeable.getHeight();
                }
                return MeasureScope.layout$default($this$Layout, containerWidth, containerHeight2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ListItemKt.BaselinesOffsetColumn.1.2
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
                        List $this$fastForEachIndexed$iv = placeables;
                        Integer[] numArr = y;
                        int size5 = $this$fastForEachIndexed$iv.size();
                        for (int index$iv2 = 0; index$iv2 < size5; index$iv2++) {
                            Object item$iv2 = $this$fastForEachIndexed$iv.get(index$iv2);
                            Placeable placeable2 = (Placeable) item$iv2;
                            int index2 = index$iv2;
                            Placeable.PlacementScope.placeRelative$default($this$layout, placeable2, 0, numArr[index2].intValue(), 0.0f, 4, null);
                        }
                    }
                }, 4, null);
            }
        };
        int $changed$iv = (($changed >> 6) & 14) | ($changed & 112);
        $composer2.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
        CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
        Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
        Function3 skippableUpdate$iv$iv = LayoutKt.modifierMaterializerOf(modifier2);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.BaselinesOffsetColumn.2
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
                    ListItemKt.BaselinesOffsetColumn(list, modifier2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0192  */
    /* renamed from: OffsetToBaselineOrCenter-Kz89ssw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1582OffsetToBaselineOrCenterKz89ssw(final float r20, androidx.compose.p000ui.Modifier r21, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ListItemKt.m1582OffsetToBaselineOrCenterKz89ssw(float, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function2<Composer, Integer, Unit> applyTextStyle(final TextStyle textStyle, final float contentAlpha, final Function2<? super Composer, ? super Integer, Unit> function2) {
        if (function2 == null) {
            return null;
        }
        final LineHeightStyle lineHeightStyle = new LineHeightStyle(LineHeightStyle.Alignment.INSTANCE.m6145getProportionalPIaL0Z0(), LineHeightStyle.Trim.INSTANCE.m6156getBothEVpEnUU(), null);
        return ComposableLambdaKt.composableLambdaInstance(-830176860, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.applyTextStyle.1
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

            public final void invoke(Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "C430@16067L163:ListItem.kt#jmzs0o");
                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-830176860, $changed, -1, "androidx.compose.material.applyTextStyle.<anonymous> (ListItem.kt:430)");
                    }
                    ProvidedValue<Float> providedValueProvides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(contentAlpha));
                    final TextStyle textStyle2 = textStyle;
                    final LineHeightStyle lineHeightStyle2 = lineHeightStyle;
                    final Function2<Composer, Integer, Unit> function22 = function2;
                    CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.composableLambda($composer, 1665877604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ListItemKt.applyTextStyle.1.1
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

                        public final void invoke(Composer $composer2, int $changed2) {
                            ComposerKt.sourceInformation($composer2, "C431@16147L73:ListItem.kt#jmzs0o");
                            if (($changed2 & 11) == 2 && $composer2.getSkipping()) {
                                $composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1665877604, $changed2, -1, "androidx.compose.material.applyTextStyle.<anonymous>.<anonymous> (ListItem.kt:431)");
                            }
                            TextKt.ProvideTextStyle(TextStyle.m5787copyp1EtxEg$default(textStyle2, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, lineHeightStyle2, 0, 0, null, 15728639, null), function22, $composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), $composer, ProvidedValue.$stable | 0 | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        });
    }
}
