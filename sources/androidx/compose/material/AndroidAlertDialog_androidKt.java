package androidx.compose.material;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Shape;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AndroidAlertDialog.android.kt */
@Metadata(m164d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aª\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0093\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, m165d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt {
    /* renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    public static final void m1408AlertDialog6oU6zVQ(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Modifier modifier2;
        final Function2 dismissButton;
        Function2 title;
        int i2;
        Function2 text;
        int i3;
        Shape shape2;
        int $dirty;
        int i4;
        int i5;
        int i6;
        long backgroundColor2;
        long contentColor2;
        int i7;
        long backgroundColor3;
        Function2 text2;
        int i8;
        int $dirty2;
        long contentColor3;
        int i9;
        DialogProperties properties2;
        Function2 title2;
        Shape shape3;
        Composer $composer2;
        final Function2 dismissButton2;
        final Modifier modifier3;
        final Function2 title3;
        final Function2 text3;
        final Shape shape4;
        final long backgroundColor4;
        final long contentColor4;
        final DialogProperties properties3;
        int $dirty3;
        Composer $composer3 = $composer.startRestartGroup(-606536823);
        ComposerKt.sourceInformation($composer3, "C(AlertDialog)P(5,1,4,3,9,8,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color)70@3471L6,71@3529L6,72@3571L32,75@3667L735:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
            function02 = function0;
        } else if (($changed & 14) == 0) {
            function02 = function0;
            $dirty4 |= $composer3.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        int i10 = i & 4;
        if (i10 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i11 = i & 8;
        if (i11 != 0) {
            $dirty4 |= 3072;
            dismissButton = function22;
        } else if (($changed & 7168) == 0) {
            dismissButton = function22;
            $dirty4 |= $composer3.changedInstance(dismissButton) ? 2048 : 1024;
        } else {
            dismissButton = function22;
        }
        int i12 = i & 16;
        if (i12 != 0) {
            $dirty4 |= 24576;
            title = function23;
        } else if (($changed & 57344) == 0) {
            title = function23;
            $dirty4 |= $composer3.changedInstance(title) ? 16384 : 8192;
        } else {
            title = function23;
        }
        int i13 = i & 32;
        if (i13 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            i2 = 57344;
            text = function24;
        } else if (($changed & 458752) == 0) {
            i2 = 57344;
            text = function24;
            $dirty4 |= $composer3.changedInstance(text) ? 131072 : 65536;
        } else {
            i2 = 57344;
            text = function24;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                i3 = 458752;
                shape2 = shape;
                int i14 = $composer3.changed(shape2) ? 1048576 : 524288;
                $dirty4 |= i14;
            } else {
                i3 = 458752;
                shape2 = shape;
            }
            $dirty4 |= i14;
        } else {
            i3 = 458752;
            shape2 = shape;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                $dirty3 = $dirty4;
                i4 = i10;
                int i15 = $composer3.changed(backgroundColor) ? 8388608 : 4194304;
                $dirty = $dirty3 | i15;
            } else {
                $dirty3 = $dirty4;
                i4 = i10;
            }
            $dirty = $dirty3 | i15;
        } else {
            $dirty = $dirty4;
            i4 = i10;
        }
        if (($changed & 234881024) == 0) {
            i5 = i4;
            $dirty |= ((i & 256) == 0 && $composer3.changed(contentColor)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i5 = i4;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty |= 805306368;
            i6 = i16;
        } else if (($changed & 1879048192) == 0) {
            i6 = i16;
            $dirty |= $composer3.changed(properties) ? 536870912 : 268435456;
        } else {
            i6 = i16;
        }
        if (($dirty & 1533916891) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
            dismissButton2 = dismissButton;
            text3 = text;
            title3 = title;
            shape4 = shape2;
            backgroundColor4 = backgroundColor;
            contentColor4 = contentColor;
            properties3 = properties;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i11 != 0) {
                    dismissButton = null;
                }
                if (i12 != 0) {
                    title = null;
                }
                if (i13 != 0) {
                    text = null;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getMedium();
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1494getSurface0d7_KjU();
                } else {
                    backgroundColor2 = backgroundColor;
                }
                if ((i & 256) != 0) {
                    contentColor2 = ColorsKt.m1508contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty >> 21) & 14);
                    $dirty &= -234881025;
                } else {
                    contentColor2 = contentColor;
                }
                if (i6 != 0) {
                    long j = backgroundColor2;
                    i7 = 234881024;
                    backgroundColor3 = j;
                    text2 = text;
                    i8 = 29360128;
                    contentColor3 = contentColor2;
                    i9 = -606536823;
                    properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                    title2 = title;
                    $dirty2 = $dirty;
                    shape3 = shape2;
                } else {
                    long j2 = backgroundColor2;
                    i7 = 234881024;
                    backgroundColor3 = j2;
                    text2 = text;
                    i8 = 29360128;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                    i9 = -606536823;
                    properties2 = properties;
                    title2 = title;
                    shape3 = shape2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty2 = $dirty & (-234881025);
                    contentColor3 = contentColor;
                    properties2 = properties;
                    text2 = text;
                    shape3 = shape2;
                    i8 = 29360128;
                    i7 = 234881024;
                    i9 = -606536823;
                    backgroundColor3 = backgroundColor;
                    title2 = title;
                } else {
                    contentColor3 = contentColor;
                    properties2 = properties;
                    text2 = text;
                    i8 = 29360128;
                    $dirty2 = $dirty;
                    i7 = 234881024;
                    i9 = -606536823;
                    backgroundColor3 = backgroundColor;
                    title2 = title;
                    shape3 = shape2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i9, $dirty2, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:74)");
            }
            int i17 = ($dirty2 & 14) | 48 | ($dirty2 & 896) | (($dirty2 >> 3) & 7168) | (($dirty2 >> 3) & i2) | (($dirty2 >> 3) & i3) | (($dirty2 >> 3) & 3670016);
            $composer2 = $composer3;
            Modifier modifier4 = modifier2;
            m1409AlertDialogwqdebIU(function02, ComposableLambdaKt.composableLambda($composer3, -1849673151, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x01a6  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r28, int r29) {
                    /*
                        Method dump skipped, instructions count: 426
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), modifier4, title2, text2, shape3, backgroundColor3, contentColor3, properties2, $composer2, (i8 & ($dirty2 >> 3)) | i17 | (i7 & ($dirty2 >> 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            dismissButton2 = dismissButton;
            modifier3 = modifier4;
            title3 = title2;
            text3 = text2;
            shape4 = shape3;
            backgroundColor4 = backgroundColor3;
            contentColor4 = contentColor3;
            properties3 = properties2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$2
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

                public final void invoke(Composer composer, int i18) {
                    AndroidAlertDialog_androidKt.m1408AlertDialog6oU6zVQ(function0, function2, modifier3, dismissButton2, title3, text3, shape4, backgroundColor4, contentColor4, properties3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    public static final void m1409AlertDialogwqdebIU(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long backgroundColor, long contentColor, DialogProperties properties, Composer $composer, final int $changed, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        Function2 title;
        Function2 text;
        Shape shape2;
        long backgroundColor2;
        int $dirty;
        int i2;
        int $dirty2;
        long contentColor2;
        DialogProperties properties2;
        int $dirty3;
        Composer $composer2;
        final Modifier modifier3;
        final Function2 text2;
        final Shape shape3;
        final long contentColor3;
        final DialogProperties properties3;
        final Function2 title2;
        final long backgroundColor3;
        int $dirty4;
        Composer $composer3 = $composer.startRestartGroup(1035523925);
        ComposerKt.sourceInformation($composer3, "C(AlertDialog)P(4,1,3,8,7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color)131@6133L6,132@6191L6,133@6233L32,136@6329L366:AndroidAlertDialog.android.kt#jmzs0o");
        int $dirty5 = $changed;
        if ((i & 1) != 0) {
            $dirty5 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty5 |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty5 |= 48;
            function24 = function2;
        } else if (($changed & 112) == 0) {
            function24 = function2;
            $dirty5 |= $composer3.changedInstance(function24) ? 32 : 16;
        } else {
            function24 = function2;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty5 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty5 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty5 |= 3072;
            title = function22;
        } else if (($changed & 7168) == 0) {
            title = function22;
            $dirty5 |= $composer3.changedInstance(title) ? 2048 : 1024;
        } else {
            title = function22;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty5 |= 24576;
            text = function23;
        } else if ((57344 & $changed) == 0) {
            text = function23;
            $dirty5 |= $composer3.changedInstance(text) ? 16384 : 8192;
        } else {
            text = function23;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                shape2 = shape;
                int i6 = $composer3.changed(shape2) ? 131072 : 65536;
                $dirty5 |= i6;
            } else {
                shape2 = shape;
            }
            $dirty5 |= i6;
        } else {
            shape2 = shape;
        }
        if ((3670016 & $changed) == 0) {
            if ((i & 64) == 0) {
                backgroundColor2 = backgroundColor;
                int i7 = $composer3.changed(backgroundColor2) ? 1048576 : 524288;
                $dirty5 |= i7;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty5 |= i7;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                $dirty4 = $dirty5;
                int i8 = $composer3.changed(contentColor) ? 8388608 : 4194304;
                $dirty = $dirty4 | i8;
            } else {
                $dirty4 = $dirty5;
            }
            $dirty = $dirty4 | i8;
        } else {
            $dirty = $dirty5;
        }
        int $dirty6 = $dirty;
        int $dirty7 = i & 256;
        if ($dirty7 != 0) {
            $dirty2 = $dirty6 | 100663296;
            i2 = $dirty7;
        } else if (($changed & 234881024) == 0) {
            i2 = $dirty7;
            $dirty2 = $dirty6 | ($composer3.changed(properties) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432);
        } else {
            i2 = $dirty7;
            $dirty2 = $dirty6;
        }
        if (($dirty2 & 191739611) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
            text2 = text;
            shape3 = shape2;
            contentColor3 = contentColor;
            properties3 = properties;
            title2 = title;
            backgroundColor3 = backgroundColor2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    title = null;
                }
                if (i5 != 0) {
                    text = null;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getMedium();
                }
                if ((i & 64) != 0) {
                    backgroundColor2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1494getSurface0d7_KjU();
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    contentColor2 = ColorsKt.m1508contentColorForek8zF_U(backgroundColor2, $composer3, ($dirty2 >> 18) & 14);
                    $dirty2 &= -29360129;
                } else {
                    contentColor2 = contentColor;
                }
                if (i2 != 0) {
                    properties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                    $dirty3 = $dirty2;
                } else {
                    properties2 = properties;
                    $dirty3 = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    contentColor2 = contentColor;
                    $dirty3 = $dirty2 & (-29360129);
                    properties2 = properties;
                } else {
                    contentColor2 = contentColor;
                    properties2 = properties;
                    $dirty3 = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035523925, $dirty3, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:135)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
            final Modifier modifier4 = modifier2;
            final Function2 title3 = title;
            final Function2 text3 = text;
            final Shape shape4 = shape2;
            final long backgroundColor4 = backgroundColor2;
            final long contentColor4 = contentColor2;
            AndroidDialog_androidKt.Dialog(function0, properties2, ComposableLambdaKt.composableLambda($composer3, -1787418772, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$3
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
                    ComposerKt.sourceInformation($composer4, "C140@6430L259:AndroidAlertDialog.android.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1787418772, $changed2, -1, "androidx.compose.material.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:140)");
                        }
                        AlertDialogKt.m1406AlertDialogContentWMdw5o4(function25, modifier4, title3, text3, shape4, backgroundColor4, contentColor4, $composer4, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, ($dirty3 & 14) | 384 | (($dirty3 >> 21) & 112), 0);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            text2 = text;
            shape3 = shape2;
            contentColor3 = contentColor2;
            properties3 = properties2;
            title2 = title;
            backgroundColor3 = backgroundColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$AlertDialog$4
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

                public final void invoke(Composer composer, int i9) {
                    AndroidAlertDialog_androidKt.m1409AlertDialogwqdebIU(function0, function2, modifier3, title2, text2, shape3, backgroundColor3, contentColor3, properties3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
