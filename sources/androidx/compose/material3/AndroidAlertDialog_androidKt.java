package androidx.compose.material3;

import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.window.AndroidDialog_androidKt;
import androidx.compose.p000ui.window.DialogProperties;
import androidx.compose.p000ui.window.SecureFlagPolicy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AndroidAlertDialog.android.kt */
@Metadata(m164d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aß\u0001\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aB\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u001d\u001aB\u0010\u001e\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, m165d2 = {"ButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonsMainAxisSpacing", "AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-Oix01E0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "content", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BasicAlertDialog", "material3_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt {
    private static final float ButtonsMainAxisSpacing = C1956Dp.m6297constructorimpl(8);
    private static final float ButtonsCrossAxisSpacing = C1956Dp.m6297constructorimpl(12);

    /* renamed from: AlertDialog-Oix01E0, reason: not valid java name */
    public static final void m1767AlertDialogOix01E0(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape, long containerColor, long iconContentColor, long titleContentColor, long textContentColor, float tonalElevation, DialogProperties properties, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Modifier modifier2;
        Function2 function27;
        Function2 icon;
        Function2 title;
        Function2 text;
        Shape shape2;
        int $dirty;
        int $dirty1;
        int $dirty12;
        long textContentColor2;
        int $dirty13;
        int $dirty14;
        Modifier.Companion modifier3;
        Function2 dismissButton;
        long containerColor2;
        long iconContentColor2;
        long titleContentColor2;
        float tonalElevation2;
        DialogProperties properties2;
        int $dirty2;
        Modifier modifier4;
        Composer $composer2;
        final float tonalElevation3;
        final Function2 dismissButton2;
        final DialogProperties properties3;
        final Function2 text2;
        final Shape shape3;
        final long containerColor3;
        final long titleContentColor3;
        final Modifier modifier5;
        final long textContentColor3;
        final Function2 icon2;
        final Function2 title2;
        final long iconContentColor3;
        int $dirty3;
        Composer $composer3 = $composer.startRestartGroup(-2081346864);
        ComposerKt.sourceInformation($composer3, "C(AlertDialog)P(6!1,5,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)85@4239L5,86@4294L14,87@4360L16,88@4429L17,89@4498L16,92@4635L1119:AndroidAlertDialog.android.kt#uh7d8r");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
            function02 = function0;
        } else if (($changed & 6) == 0) {
            function02 = function0;
            $dirty4 |= $composer3.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
            function26 = function2;
        } else if (($changed & 48) == 0) {
            function26 = function2;
            $dirty4 |= $composer3.changedInstance(function26) ? 32 : 16;
        } else {
            function26 = function2;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty4 |= 3072;
            function27 = function22;
        } else if (($changed & 3072) == 0) {
            function27 = function22;
            $dirty4 |= $composer3.changedInstance(function27) ? 2048 : 1024;
        } else {
            function27 = function22;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty4 |= 24576;
            icon = function23;
        } else if (($changed & 24576) == 0) {
            icon = function23;
            $dirty4 |= $composer3.changedInstance(icon) ? 16384 : 8192;
        } else {
            icon = function23;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            title = function24;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            title = function24;
            $dirty4 |= $composer3.changedInstance(title) ? 131072 : 65536;
        } else {
            title = function24;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty4 |= 1572864;
            text = function25;
        } else if (($changed & 1572864) == 0) {
            text = function25;
            $dirty4 |= $composer3.changedInstance(text) ? 1048576 : 524288;
        } else {
            text = function25;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                shape2 = shape;
                int i7 = $composer3.changed(shape2) ? 8388608 : 4194304;
                $dirty4 |= i7;
            } else {
                shape2 = shape;
            }
            $dirty4 |= i7;
        } else {
            shape2 = shape;
        }
        if (($changed & 100663296) == 0) {
            if ((i & 256) == 0) {
                $dirty3 = $dirty4;
                $dirty1 = $changed1;
                int i8 = $composer3.changed(containerColor) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty = $dirty3 | i8;
            } else {
                $dirty3 = $dirty4;
                $dirty1 = $changed1;
            }
            $dirty = $dirty3 | i8;
        } else {
            $dirty = $dirty4;
            $dirty1 = $changed1;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= ((i & 512) == 0 && $composer3.changed(iconContentColor)) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty12 = $dirty1 | (((i & 1024) == 0 && $composer3.changed(titleContentColor)) ? 4 : 2);
        } else {
            $dirty12 = $dirty1;
        }
        int $dirty15 = $changed1 & 48;
        if ($dirty15 == 0) {
            if ((i & 2048) == 0) {
                textContentColor2 = textContentColor;
                int i9 = $composer3.changed(textContentColor2) ? 32 : 16;
                $dirty12 |= i9;
            } else {
                textContentColor2 = textContentColor;
            }
            $dirty12 |= i9;
        } else {
            textContentColor2 = textContentColor;
        }
        int i10 = i & 4096;
        if (i10 != 0) {
            $dirty13 = $dirty12 | 384;
        } else {
            int $dirty16 = $dirty12;
            int $dirty17 = $changed1 & 384;
            if ($dirty17 == 0) {
                $dirty16 |= $composer3.changed(tonalElevation) ? 256 : 128;
            }
            $dirty13 = $dirty16;
        }
        int i11 = i & 8192;
        if (i11 != 0) {
            $dirty14 = $dirty13 | 3072;
        } else {
            int $dirty18 = $dirty13;
            int $dirty19 = $changed1 & 3072;
            if ($dirty19 == 0) {
                $dirty14 = $dirty18 | ($composer3.changed(properties) ? 2048 : 1024);
            } else {
                $dirty14 = $dirty18;
            }
        }
        if (($dirty & 306783379) == 306783378 && ($dirty14 & 1171) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            tonalElevation3 = tonalElevation;
            properties3 = properties;
            $composer2 = $composer3;
            modifier5 = modifier2;
            dismissButton2 = function27;
            text2 = text;
            shape3 = shape2;
            containerColor3 = containerColor;
            titleContentColor3 = titleContentColor;
            textContentColor3 = textContentColor2;
            icon2 = icon;
            title2 = title;
            iconContentColor3 = iconContentColor;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                dismissButton = i3 != 0 ? null : function27;
                if (i4 != 0) {
                    icon = null;
                }
                if (i5 != 0) {
                    title = null;
                }
                if (i6 != 0) {
                    text = null;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                    shape2 = AlertDialogDefaults.INSTANCE.getShape($composer3, 6);
                }
                if ((i & 256) != 0) {
                    containerColor2 = AlertDialogDefaults.INSTANCE.getContainerColor($composer3, 6);
                    $dirty &= -234881025;
                } else {
                    containerColor2 = containerColor;
                }
                if ((i & 512) != 0) {
                    iconContentColor2 = AlertDialogDefaults.INSTANCE.getIconContentColor($composer3, 6);
                    $dirty &= -1879048193;
                } else {
                    iconContentColor2 = iconContentColor;
                }
                if ((i & 1024) != 0) {
                    titleContentColor2 = AlertDialogDefaults.INSTANCE.getTitleContentColor($composer3, 6);
                    $dirty14 &= -15;
                } else {
                    titleContentColor2 = titleContentColor;
                }
                if ((i & 2048) != 0) {
                    textContentColor2 = AlertDialogDefaults.INSTANCE.getTextContentColor($composer3, 6);
                    $dirty14 &= -113;
                }
                tonalElevation2 = i10 != 0 ? AlertDialogDefaults.INSTANCE.m1762getTonalElevationD9Ej5fM() : tonalElevation;
                if (i11 != 0) {
                    properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                    $dirty2 = $dirty;
                } else {
                    properties2 = properties;
                    $dirty2 = $dirty;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty &= -234881025;
                }
                if ((i & 512) != 0) {
                    $dirty &= -1879048193;
                }
                if ((i & 1024) != 0) {
                    $dirty14 &= -15;
                }
                if ((i & 2048) != 0) {
                    $dirty14 &= -113;
                }
                containerColor2 = containerColor;
                iconContentColor2 = iconContentColor;
                titleContentColor2 = titleContentColor;
                tonalElevation2 = tonalElevation;
                modifier3 = modifier2;
                dismissButton = function27;
                $dirty2 = $dirty;
                properties2 = properties;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                modifier4 = modifier3;
                ComposerKt.traceEventStart(-2081346864, $dirty2, $dirty14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:92)");
            } else {
                modifier4 = modifier3;
            }
            final float tonalElevation4 = tonalElevation2;
            final long textContentColor4 = textContentColor2;
            final Function2 dismissButton3 = dismissButton;
            final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
            final Function2 icon3 = icon;
            final Function2 title3 = title;
            final Function2 text3 = text;
            final Shape shape4 = shape2;
            final long containerColor4 = containerColor2;
            final long iconContentColor4 = iconContentColor2;
            final long titleContentColor4 = titleContentColor2;
            Modifier modifier6 = modifier4;
            BasicAlertDialog(function02, modifier6, properties2, ComposableLambdaKt.composableLambda($composer3, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1
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
                    ComposerKt.sourceInformation($composer4, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(461081686, $changed2, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                        }
                        final Function2<Composer, Integer, Unit> function29 = dismissButton3;
                        final Function2<Composer, Integer, Unit> function210 = function28;
                        AlertDialogKt.m1763AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda($composer4, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1
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
                                ComposerKt.sourceInformation($composer5, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-3244296, $changed3, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                    }
                                    float f = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                    float f2 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                    final Function2<Composer, Integer, Unit> function211 = function29;
                                    final Function2<Composer, Integer, Unit> function212 = function210;
                                    AlertDialogKt.m1764AlertDialogFlowRowixp7dh8(f, f2, ComposableLambdaKt.composableLambda($composer5, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
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
                                            ComposerKt.sourceInformation($composer6, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                            if (($changed4 & 3) != 2 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-909933713, $changed4, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                }
                                                Function2<Composer, Integer, Unit> function213 = function211;
                                                $composer6.startReplaceableGroup(-1969500671);
                                                ComposerKt.sourceInformation($composer6, "103@4991L8");
                                                if (function213 != null) {
                                                    function213.invoke($composer6, 0);
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                $composer6.endReplaceableGroup();
                                                function212.invoke($composer6, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    }), $composer5, 438);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }), null, icon3, title3, text3, shape4, containerColor4, tonalElevation4, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), $composer4, 6), iconContentColor4, titleContentColor4, textContentColor4, $composer4, 6, 0, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, ($dirty2 & 14) | 3072 | (($dirty2 >> 3) & 112) | (($dirty14 >> 3) & 896), 0);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            tonalElevation3 = tonalElevation2;
            dismissButton2 = dismissButton;
            properties3 = properties2;
            text2 = text;
            shape3 = shape2;
            containerColor3 = containerColor2;
            titleContentColor3 = titleContentColor2;
            modifier5 = modifier6;
            textContentColor3 = textContentColor2;
            icon2 = icon;
            title2 = title;
            iconContentColor3 = iconContentColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.2
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

                public final void invoke(Composer composer, int i12) {
                    AndroidAlertDialog_androidKt.m1767AlertDialogOix01E0(function0, function2, modifier5, dismissButton2, icon2, title2, text2, shape3, containerColor3, iconContentColor3, titleContentColor3, textContentColor3, tonalElevation3, properties3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void BasicAlertDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties properties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Modifier modifier2;
        DialogProperties dialogProperties;
        final Modifier modifier3;
        final DialogProperties properties2;
        Composer $composer2 = $composer.startRestartGroup(-543157267);
        ComposerKt.sourceInformation($composer2, "C(BasicAlertDialog)P(2,1,3)156@7271L452:AndroidAlertDialog.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            function02 = function0;
        } else if (($changed & 6) == 0) {
            function02 = function0;
            $dirty |= $composer2.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            dialogProperties = properties;
        } else if (($changed & 384) == 0) {
            dialogProperties = properties;
            $dirty |= $composer2.changed(dialogProperties) ? 256 : 128;
        } else {
            dialogProperties = properties;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            properties2 = dialogProperties;
        } else {
            final Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            DialogProperties properties3 = i3 != 0 ? new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null) : dialogProperties;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-543157267, $dirty2, -1, "androidx.compose.material3.BasicAlertDialog (AndroidAlertDialog.android.kt:155)");
            }
            AndroidDialog_androidKt.Dialog(function02, properties3, ComposableLambdaKt.composableLambda($composer2, -777289724, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.BasicAlertDialog.1
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

                /* JADX WARN: Removed duplicated region for block: B:35:0x01cd  */
                /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r28, int r29) {
                    /*
                        Method dump skipped, instructions count: 465
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AndroidAlertDialog_androidKt.C12011.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, ($dirty2 & 14) | 384 | (($dirty2 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            properties2 = properties3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.BasicAlertDialog.2
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
                    AndroidAlertDialog_androidKt.BasicAlertDialog(function0, modifier3, properties2, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(message = "Use BasicAlertDialog instead", replaceWith = @ReplaceWith(expression = "BasicAlertDialog(onDismissRequest, modifier, properties, content)", imports = {}))
    public static final void AlertDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties properties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Modifier modifier2;
        DialogProperties dialogProperties;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Modifier.Companion modifier3;
        DialogProperties properties2;
        final Modifier modifier4;
        final DialogProperties properties3;
        Composer $composer2 = $composer.startRestartGroup(63450171);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)P(2,1,3)209@9397L65:AndroidAlertDialog.android.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            function02 = function0;
        } else if (($changed & 6) == 0) {
            function02 = function0;
            $dirty |= $composer2.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            dialogProperties = properties;
        } else if (($changed & 384) == 0) {
            dialogProperties = properties;
            $dirty |= $composer2.changed(dialogProperties) ? 256 : 128;
        } else {
            dialogProperties = properties;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
            function22 = function2;
        } else if (($changed & 3072) == 0) {
            function22 = function2;
            $dirty |= $composer2.changedInstance(function22) ? 2048 : 1024;
        } else {
            function22 = function2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            properties3 = dialogProperties;
        } else {
            if (i2 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                properties2 = dialogProperties;
            } else {
                properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(63450171, $dirty2, -1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:209)");
            }
            Modifier modifier5 = modifier3;
            BasicAlertDialog(function02, modifier5, properties2, function22, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier5;
            properties3 = properties2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.3
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
                    AndroidAlertDialog_androidKt.AlertDialog(function0, modifier4, properties3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
