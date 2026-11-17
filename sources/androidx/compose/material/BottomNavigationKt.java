package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.ColorKt;
import androidx.compose.p000ui.layout.AlignmentLineKt;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.style.TextAlign;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: BottomNavigation.kt */
@Metadata(m164d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a`\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aX\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u000b2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u000b0\u001e¢\u0006\u0002\b\u00162\u0013\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e¢\u0006\u0002\b\u00162\b\b\u0001\u0010 \u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010!\u001aR\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&2&\u0010\u0013\u001a\"\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u0092\u0001\u0010,\u001a\u00020\u000b*\u00020\u00152\u0006\u0010%\u001a\u00020&2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u000b0\u001e¢\u0006\u0002\b\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020&2\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e¢\u0006\u0002\b\u00162\b\b\u0002\u0010/\u001a\u00020&2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u00020\u00102\b\b\u0002\u00103\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a&\u00106\u001a\u000207*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a8\u0010?\u001a\u000207*\u0002082\u0006\u0010@\u001a\u00020:2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\b\b\u0001\u0010 \u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C²\u0006\n\u0010)\u001a\u00020\u0002X\u008a\u0084\u0002"}, m165d2 = {"BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomNavigationHeight", "Landroidx/compose/ui/unit/Dp;", "F", "BottomNavigationItemHorizontalPadding", "CombinedItemTextBaseline", "ZeroInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomNavigation", "", "windowInsets", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomNavigation-_UMDTes", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigation-PEIptTM", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigationItemBaselineLayout", "icon", "Lkotlin/Function0;", "label", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "BottomNavigationTransition", "activeColor", "inactiveColor", "selected", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "animationProgress", "BottomNavigationTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "BottomNavigationItem", "onClick", "enabled", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "BottomNavigationItem-jY6E1Zs", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;III)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BottomNavigationKt {
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = new TweenSpec<>(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float BottomNavigationHeight = C1956Dp.m6297constructorimpl(56);
    private static final float BottomNavigationItemHorizontalPadding = C1956Dp.m6297constructorimpl(12);
    private static final float CombinedItemTextBaseline = C1956Dp.m6297constructorimpl(12);
    private static final WindowInsets ZeroInsets = WindowInsetsKt.m840WindowInsetsa9UjIt4(C1956Dp.m6297constructorimpl(0), C1956Dp.m6297constructorimpl(0), C1956Dp.m6297constructorimpl(0), C1956Dp.m6297constructorimpl(0));

    /* JADX WARN: Removed duplicated region for block: B:100:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x013f  */
    /* renamed from: BottomNavigation-_UMDTes, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1436BottomNavigation_UMDTes(final androidx.compose.foundation.layout.WindowInsets r24, androidx.compose.p000ui.Modifier r25, long r26, long r28, float r30, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomNavigationKt.m1436BottomNavigation_UMDTes(androidx.compose.foundation.layout.WindowInsets, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: BottomNavigation-PEIptTM, reason: not valid java name */
    public static final void m1435BottomNavigationPEIptTM(Modifier modifier, long backgroundColor, long contentColor, float elevation, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long contentColor2;
        float f;
        long backgroundColor2;
        Modifier modifier3;
        int i2;
        long contentColor3;
        float elevation2;
        long backgroundColor3;
        int i3;
        Composer $composer2;
        final Modifier modifier4;
        final long contentColor4;
        final float elevation3;
        final long backgroundColor4;
        Composer $composer3 = $composer.startRestartGroup(456489494);
        ComposerKt.sourceInformation($composer3, "C(BottomNavigation)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)158@6919L6,159@6968L32,163@7111L89:BottomNavigation.kt#jmzs0o");
        int $dirty = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                j = backgroundColor;
                int i5 = $composer3.changed(j) ? 32 : 16;
                $dirty |= i5;
            } else {
                j = backgroundColor;
            }
            $dirty |= i5;
        } else {
            j = backgroundColor;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                int i6 = $composer3.changed(contentColor2) ? 256 : 128;
                $dirty |= i6;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i6;
        } else {
            contentColor2 = contentColor;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            f = elevation;
        } else if (($changed & 7168) == 0) {
            f = elevation;
            $dirty |= $composer3.changed(f) ? 2048 : 1024;
        } else {
            f = elevation;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 16384 : 8192;
        }
        if ((46811 & $dirty) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            backgroundColor4 = j;
            contentColor4 = contentColor2;
            elevation3 = f;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer3, 6));
                    $dirty &= -113;
                } else {
                    backgroundColor2 = j;
                }
                if ((i & 4) != 0) {
                    contentColor2 = ColorsKt.m1508contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty >> 3) & 14);
                    $dirty &= -897;
                }
                if (i7 != 0) {
                    modifier3 = modifier5;
                    i2 = 57344;
                    contentColor3 = contentColor2;
                    backgroundColor3 = backgroundColor2;
                    i3 = 6;
                    elevation2 = BottomNavigationDefaults.INSTANCE.m1434getElevationD9Ej5fM();
                } else {
                    modifier3 = modifier5;
                    i2 = 57344;
                    contentColor3 = contentColor2;
                    elevation2 = f;
                    backgroundColor3 = backgroundColor2;
                    i3 = 6;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                i2 = 57344;
                contentColor3 = contentColor2;
                modifier3 = modifier2;
                i3 = 6;
                elevation2 = f;
                backgroundColor3 = j;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(456489494, $dirty, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:162)");
            }
            $composer2 = $composer3;
            m1436BottomNavigation_UMDTes(ZeroInsets, modifier3, backgroundColor3, contentColor3, elevation2, function3, $composer2, (($dirty << 3) & 112) | i3 | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (i2 & ($dirty << 3)) | (458752 & ($dirty << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            contentColor4 = contentColor3;
            elevation3 = elevation2;
            backgroundColor4 = backgroundColor3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$3
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

                public final void invoke(Composer composer, int i8) {
                    BottomNavigationKt.m1435BottomNavigationPEIptTM(modifier4, backgroundColor4, contentColor4, elevation3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: BottomNavigationItem-jY6E1Zs, reason: not valid java name */
    public static final void m1437BottomNavigationItemjY6E1Zs(final RowScope $this$BottomNavigationItem_u2djY6E1Zs, final boolean selected, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function22, boolean alwaysShowLabel, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        Function0<Unit> function02;
        Modifier modifier2;
        boolean enabled2;
        final Function2 label;
        int $dirty1;
        long unselectedContentColor2;
        final boolean alwaysShowLabel2;
        Modifier modifier3;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        long selectedContentColor2;
        int $dirty;
        MutableInteractionSource interactionSource4;
        int $dirty12;
        Object value$iv$iv;
        MutableInteractionSource interactionSource5;
        final Function2 styledLabel;
        Composer $composer2;
        final long unselectedContentColor3;
        final MutableInteractionSource interactionSource6;
        final boolean alwaysShowLabel3;
        final Modifier modifier4;
        final long selectedContentColor3;
        final boolean enabled3;
        Composer $composer3 = $composer.startRestartGroup(-1473735525);
        ComposerKt.sourceInformation($composer3, "C(BottomNavigationItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)207@9524L39,208@9617L7,209@9709L6,220@10212L61,222@10279L804:BottomNavigation.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((Integer.MIN_VALUE & i) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed($this$BottomNavigationItem_u2djY6E1Zs) ? 4 : 2;
        }
        if ((i & 1) != 0) {
            $dirty2 |= 48;
            z = selected;
        } else if (($changed & 112) == 0) {
            z = selected;
            $dirty2 |= $composer3.changed(z) ? 32 : 16;
        } else {
            z = selected;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 384;
            function02 = function0;
        } else if (($changed & 896) == 0) {
            function02 = function0;
            $dirty2 |= $composer3.changedInstance(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= 24576;
            modifier2 = modifier;
        } else if ((57344 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            enabled2 = enabled;
        } else if ((458752 & $changed) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer3.changed(enabled2) ? 131072 : 65536;
        } else {
            enabled2 = enabled;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty2 |= 1572864;
            label = function22;
        } else if (($changed & 3670016) == 0) {
            label = function22;
            $dirty2 |= $composer3.changedInstance(label) ? 1048576 : 524288;
        } else {
            label = function22;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty2 |= $composer3.changed(alwaysShowLabel) ? 8388608 : 4194304;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 1879048192) == 0) {
            if ((i & 256) == 0) {
                $dirty1 = $changed1;
                int i7 = $composer3.changed(selectedContentColor) ? 536870912 : 268435456;
                $dirty2 |= i7;
            } else {
                $dirty1 = $changed1;
            }
            $dirty2 |= i7;
        } else {
            $dirty1 = $changed1;
        }
        if (($changed1 & 14) == 0) {
            int $dirty13 = $dirty1;
            int $dirty14 = i & 512;
            if ($dirty14 == 0) {
                unselectedContentColor2 = unselectedContentColor;
                int i8 = $composer3.changed(unselectedContentColor2) ? 4 : 2;
                $dirty1 = $dirty13 | i8;
            } else {
                unselectedContentColor2 = unselectedContentColor;
            }
            $dirty1 = $dirty13 | i8;
        } else {
            unselectedContentColor2 = unselectedContentColor;
        }
        int $dirty15 = $dirty1;
        int $dirty16 = $dirty2 & 1533916891;
        int $dirty3 = $dirty2;
        if ($dirty16 == 306783378 && ($dirty15 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            long j = unselectedContentColor2;
            modifier4 = modifier2;
            unselectedContentColor3 = j;
            alwaysShowLabel3 = alwaysShowLabel;
            interactionSource6 = interactionSource;
            selectedContentColor3 = selectedContentColor;
            $composer2 = $composer3;
            enabled3 = enabled2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if (i3 != 0) {
                    enabled2 = true;
                }
                if (i4 != 0) {
                    label = null;
                }
                alwaysShowLabel2 = i5 != 0 ? true : alwaysShowLabel;
                if (i6 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    modifier3 = modifier5;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier3 = modifier5;
                    interactionSource2 = interactionSource;
                }
                if ((i & 256) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    interactionSource3 = interactionSource2;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $dirty = $dirty3 & (-1879048193);
                    selectedContentColor2 = ((Color) objConsume).m3959unboximpl();
                } else {
                    interactionSource3 = interactionSource2;
                    selectedContentColor2 = selectedContentColor;
                    $dirty = $dirty3;
                }
                if ((i & 512) != 0) {
                    unselectedContentColor2 = Color.m3947copywmQWz5c(selectedContentColor2, (14 & 1) != 0 ? Color.m3951getAlphaimpl(selectedContentColor2) : ContentAlpha.INSTANCE.getMedium($composer3, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(selectedContentColor2) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(selectedContentColor2) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(selectedContentColor2) : 0.0f);
                    $dirty12 = $dirty15 & (-15);
                    interactionSource4 = interactionSource3;
                } else {
                    interactionSource4 = interactionSource3;
                    $dirty12 = $dirty15;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty4 = (i & 256) != 0 ? $dirty3 & (-1879048193) : $dirty3;
                if ((i & 512) != 0) {
                    $dirty12 = $dirty15 & (-15);
                    alwaysShowLabel2 = alwaysShowLabel;
                    selectedContentColor2 = selectedContentColor;
                    $dirty = $dirty4;
                    modifier3 = modifier2;
                    interactionSource4 = interactionSource;
                } else {
                    alwaysShowLabel2 = alwaysShowLabel;
                    selectedContentColor2 = selectedContentColor;
                    $dirty12 = $dirty15;
                    $dirty = $dirty4;
                    modifier3 = modifier2;
                    interactionSource4 = interactionSource;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1473735525, $dirty, $dirty12, "androidx.compose.material.BottomNavigationItem (BottomNavigation.kt:210)");
            }
            if (label != null) {
                interactionSource5 = interactionSource4;
                styledLabel = ComposableLambdaKt.composableLambda($composer3, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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
                        ComposerKt.sourceInformation($composer4, "C213@9843L10,214@9909L40:BottomNavigation.kt#jmzs0o");
                        if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1343298261, $changed2, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:213)");
                            }
                            TextStyle style = TextStyle.m5787copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer4, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6167getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
                            TextKt.ProvideTextStyle(style, label, $composer4, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                });
            } else {
                interactionSource5 = interactionSource4;
                styledLabel = null;
            }
            Indication ripple = RippleKt.m1756rememberRipple9IZ8Weo(false, 0.0f, selectedContentColor2, $composer3, (($dirty >> 21) & 896) | 6, 2);
            MutableInteractionSource interactionSource7 = interactionSource5;
            Modifier modifier$iv = RowScope.weight$default($this$BottomNavigationItem_u2djY6E1Zs, SelectableKt.m1007selectableO2vRcR0(modifier3, z, interactionSource7, ripple, enabled2, Role.m5595boximpl(Role.INSTANCE.m5608getTabo7Vup1c()), function02), 1.0f, false, 2, null);
            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            int $dirty5 = $dirty;
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifier$iv);
            long unselectedContentColor4 = unselectedContentColor2;
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3479constructorimpl($composer3);
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i9 = ($changed$iv$iv$iv >> 9) & 14;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i10 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1277961335, "C235@10656L421:BottomNavigation.kt#jmzs0o");
            m1438BottomNavigationTransitionKlgxPg(selectedContentColor2, unselectedContentColor4, selected, ComposableLambdaKt.composableLambda($composer3, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer, Integer num) {
                    invoke(f.floatValue(), composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float progress, Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C242@10886L181:BottomNavigation.kt#jmzs0o");
                    int $dirty6 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty6 |= $composer4.changed(progress) ? 4 : 2;
                    }
                    if (($dirty6 & 91) != 18 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1411872801, $dirty6, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:240)");
                        }
                        float animationProgress = alwaysShowLabel2 ? 1.0f : progress;
                        BottomNavigationKt.BottomNavigationItemBaselineLayout(function2, styledLabel, animationProgress, $composer4, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, (($dirty5 >> 27) & 14) | 3072 | (($dirty12 << 3) & 112) | (($dirty5 << 3) & 896));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            unselectedContentColor3 = unselectedContentColor4;
            interactionSource6 = interactionSource7;
            alwaysShowLabel3 = alwaysShowLabel2;
            modifier4 = modifier3;
            selectedContentColor3 = selectedContentColor2;
            enabled3 = enabled2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                public final void invoke(Composer composer, int i11) {
                    BottomNavigationKt.m1437BottomNavigationItemjY6E1Zs($this$BottomNavigationItem_u2djY6E1Zs, selected, function0, function2, modifier4, enabled3, label, alwaysShowLabel3, interactionSource6, selectedContentColor3, unselectedContentColor3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomNavigationTransition-Klgx-Pg, reason: not valid java name */
    public static final void m1438BottomNavigationTransitionKlgxPg(final long activeColor, final long inactiveColor, final boolean selected, final Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-985175058);
        ComposerKt.sourceInformation($composer2, "C(BottomNavigationTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)288@12485L128,295@12688L181:BottomNavigation.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(activeColor) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(inactiveColor) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(selected) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-985175058, $dirty, -1, "androidx.compose.material.BottomNavigationTransition (BottomNavigation.kt:287)");
            }
            final State animationProgress$delegate = AnimateAsStateKt.animateFloatAsState(selected ? 1065353216 : 0, BottomNavigationAnimationSpec, 0.0f, null, null, $composer2, 48, 28);
            long color = ColorKt.m4000lerpjxsXWHM(inactiveColor, activeColor, BottomNavigationTransition_Klgx_Pg$lambda$3(animationProgress$delegate));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3939boximpl(Color.m3947copywmQWz5c(color, (14 & 1) != 0 ? Color.m3951getAlphaimpl(color) : 1.0f, (14 & 2) != 0 ? Color.m3955getRedimpl(color) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(color) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(color) : 0.0f))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3951getAlphaimpl(color)))}, ComposableLambdaKt.composableLambda($composer2, -138092754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationTransition$1
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
                    ComposerKt.sourceInformation($composer3, "C299@12837L26:BottomNavigation.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-138092754, $changed2, -1, "androidx.compose.material.BottomNavigationTransition.<anonymous> (BottomNavigation.kt:299)");
                        }
                        function3.invoke(Float.valueOf(BottomNavigationKt.BottomNavigationTransition_Klgx_Pg$lambda$3(animationProgress$delegate)), $composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationTransition$2
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
                    BottomNavigationKt.m1438BottomNavigationTransitionKlgxPg(activeColor, inactiveColor, selected, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomNavigationTransition_Klgx_Pg$lambda$3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0449  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void BottomNavigationItemBaselineLayout(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, final float r52, androidx.compose.runtime.Composer r53, final int r54) {
        /*
            Method dump skipped, instructions count: 1117
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomNavigationKt.BottomNavigationItemBaselineLayout(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, float, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m1442placeIcon3p2s80s(MeasureScope $this$placeIcon_u2d3p2s80s, final Placeable iconPlaceable, long constraints) {
        int height = ConstraintsKt.m6266constrainHeightK40F9xA(constraints, $this$placeIcon_u2d3p2s80s.mo512roundToPx0680j_4(BottomNavigationHeight));
        final int iconY = (height - iconPlaceable.getHeight()) / 2;
        return MeasureScope.layout$default($this$placeIcon_u2d3p2s80s, iconPlaceable.getWidth(), height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$placeIcon$1
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
                Placeable.PlacementScope.placeRelative$default($this$layout, iconPlaceable, 0, iconY, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m1443placeLabelAndIconDIyivk0(MeasureScope $this$placeLabelAndIcon_u2dDIyivk0, final Placeable labelPlaceable, final Placeable iconPlaceable, long constraints, final float iconPositionAnimationProgress) {
        int firstBaseline = labelPlaceable.get(AlignmentLineKt.getFirstBaseline());
        int baselineOffset = $this$placeLabelAndIcon_u2dDIyivk0.mo512roundToPx0680j_4(CombinedItemTextBaseline);
        int netBaselineAdjustment = baselineOffset - firstBaseline;
        int contentHeight = iconPlaceable.getHeight() + labelPlaceable.getHeight() + netBaselineAdjustment;
        int height = ConstraintsKt.m6266constrainHeightK40F9xA(constraints, Math.max(contentHeight, $this$placeLabelAndIcon_u2dDIyivk0.mo512roundToPx0680j_4(BottomNavigationHeight)));
        final int contentVerticalPadding = RangesKt.coerceAtLeast((height - contentHeight) / 2, 0);
        int unselectedIconY = (height - iconPlaceable.getHeight()) / 2;
        final int labelY = iconPlaceable.getHeight() + contentVerticalPadding + netBaselineAdjustment;
        int containerWidth = Math.max(labelPlaceable.getWidth(), iconPlaceable.getWidth());
        final int labelX = (containerWidth - labelPlaceable.getWidth()) / 2;
        final int iconX = (containerWidth - iconPlaceable.getWidth()) / 2;
        int iconDistance = unselectedIconY - contentVerticalPadding;
        final int offset = MathKt.roundToInt(iconDistance * (1 - iconPositionAnimationProgress));
        return MeasureScope.layout$default($this$placeLabelAndIcon_u2dDIyivk0, containerWidth, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$placeLabelAndIcon$1
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
                if (!(iconPositionAnimationProgress == 0.0f)) {
                    Placeable.PlacementScope.placeRelative$default($this$layout, labelPlaceable, labelX, labelY + offset, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default($this$layout, iconPlaceable, iconX, contentVerticalPadding + offset, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
