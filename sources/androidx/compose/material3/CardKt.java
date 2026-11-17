package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Shape;
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
import kotlin.jvm.functions.Function3;

/* compiled from: Card.kt */
@Metadata(m164d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0081\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018\u001au\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001aS\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001b\u001a\u007f\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a]\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u001d"}, m165d2 = {"Card", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/CardColors;", "elevation", "Landroidx/compose/material3/CardElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedCard", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedCard", "material3_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CardKt {
    public static final void Card(Modifier modifier, Shape shape, CardColors colors, CardElevation elevation, BorderStroke border, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape shape2;
        CardColors cardColors;
        CardElevation cardElevation;
        BorderStroke borderStroke;
        Shape shape3;
        CardColors colors2;
        CardElevation elevation2;
        BorderStroke border2;
        Modifier modifier3;
        Shape shape4;
        final CardColors colors3;
        final CardElevation elevation3;
        final Modifier modifier4;
        final Shape shape5;
        final BorderStroke border3;
        Composer $composer2 = $composer.startRestartGroup(1179621553);
        ComposerKt.sourceInformation($composer2, "C(Card)P(4,5,1,3)78@3662L5,79@3707L12,80@3765L15,90@4151L57,84@3872L416:Card.kt#uh7d8r");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                shape2 = shape;
                int i3 = $composer2.changed(shape2) ? 32 : 16;
                $dirty |= i3;
            } else {
                shape2 = shape;
            }
            $dirty |= i3;
        } else {
            shape2 = shape;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                cardColors = colors;
                int i4 = $composer2.changed(cardColors) ? 256 : 128;
                $dirty |= i4;
            } else {
                cardColors = colors;
            }
            $dirty |= i4;
        } else {
            cardColors = colors;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                cardElevation = elevation;
                int i5 = $composer2.changed(cardElevation) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                cardElevation = elevation;
            }
            $dirty |= i5;
        } else {
            cardElevation = elevation;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            borderStroke = border;
        } else if (($changed & 24576) == 0) {
            borderStroke = border;
            $dirty |= $composer2.changed(borderStroke) ? 16384 : 8192;
        } else {
            borderStroke = border;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 131072 : 65536;
        }
        if ((74899 & $dirty) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            colors3 = cardColors;
            border3 = borderStroke;
            shape5 = shape2;
            elevation3 = cardElevation;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    shape3 = CardDefaults.INSTANCE.getShape($composer2, 6);
                    $dirty &= -113;
                } else {
                    shape3 = shape2;
                }
                if ((i & 4) != 0) {
                    colors2 = CardDefaults.INSTANCE.cardColors($composer2, 6);
                    $dirty &= -897;
                } else {
                    colors2 = cardColors;
                }
                if ((i & 8) != 0) {
                    elevation2 = CardDefaults.INSTANCE.m1831cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer2, 1572864, 63);
                    $dirty &= -7169;
                } else {
                    elevation2 = elevation;
                }
                if (i6 != 0) {
                    shape4 = shape3;
                    border2 = null;
                    modifier3 = modifier5;
                } else {
                    border2 = border;
                    modifier3 = modifier5;
                    shape4 = shape3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                border2 = borderStroke;
                shape4 = shape2;
                colors2 = cardColors;
                elevation2 = cardElevation;
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1179621553, $dirty, -1, "androidx.compose.material3.Card (Card.kt:83)");
            }
            int $dirty2 = $dirty;
            SurfaceKt.m2519SurfaceT9BRK9s(modifier3, shape4, colors2.m1823containerColorvNxB06k$material3_release(true), colors2.m1824contentColorvNxB06k$material3_release(true), elevation2.m1836tonalElevationu2uoSUM$material3_release(true), elevation2.shadowElevation$material3_release(true, null, $composer2, (($dirty >> 3) & 896) | 54).getValue().m6311unboximpl(), border2, ComposableLambdaKt.composableLambda($composer2, 664103990, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.Card.1
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x014a  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r25, int r26) {
                    /*
                        Method dump skipped, instructions count: 334
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CardKt.C12511.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, ($dirty2 & 14) | 12582912 | ($dirty2 & 112) | (($dirty2 << 6) & 3670016), 0);
            $composer2 = $composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors3 = colors2;
            elevation3 = elevation2;
            modifier4 = modifier3;
            shape5 = shape4;
            border3 = border2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.Card.2
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
                    CardKt.Card(modifier4, shape5, colors3, elevation3, border3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void Card(final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, CardColors colors, CardElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        Shape shape2;
        CardColors cardColors;
        CardElevation cardElevation;
        BorderStroke borderStroke;
        CardColors colors2;
        Composer $composer2;
        int i2;
        CardElevation elevation2;
        MutableInteractionSource interactionSource2;
        BorderStroke border2;
        Modifier modifier3;
        boolean enabled3;
        Shape shape3;
        int i3;
        Object value$iv;
        Composer $composer3;
        final CardColors colors3;
        final CardElevation elevation3;
        final Modifier modifier4;
        final boolean enabled4;
        final Shape shape4;
        final BorderStroke border3;
        final MutableInteractionSource interactionSource3;
        Composer $composer4 = $composer.startRestartGroup(-2024281376);
        ComposerKt.sourceInformation($composer4, "C(Card)P(7,6,4,8,1,3!1,5)135@6329L5,136@6374L12,137@6432L15,139@6533L39,150@6942L43,142@6630L482:Card.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            enabled2 = enabled;
        } else if (($changed & 384) == 0) {
            enabled2 = enabled;
            $dirty |= $composer4.changed(enabled2) ? 256 : 128;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                int i6 = $composer4.changed(shape2) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                shape2 = shape;
            }
            $dirty |= i6;
        } else {
            shape2 = shape;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                cardColors = colors;
                int i7 = $composer4.changed(cardColors) ? 16384 : 8192;
                $dirty |= i7;
            } else {
                cardColors = colors;
            }
            $dirty |= i7;
        } else {
            cardColors = colors;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                cardElevation = elevation;
                int i8 = $composer4.changed(cardElevation) ? 131072 : 65536;
                $dirty |= i8;
            } else {
                cardElevation = elevation;
            }
            $dirty |= i8;
        } else {
            cardElevation = elevation;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
            borderStroke = border;
        } else if ((1572864 & $changed) == 0) {
            borderStroke = border;
            $dirty |= $composer4.changed(borderStroke) ? 1048576 : 524288;
        } else {
            borderStroke = border;
        }
        int i10 = i & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer4.changed(interactionSource) ? 8388608 : 4194304;
        }
        if ((i & 256) != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer4.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & $dirty) == 38347922 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            modifier4 = modifier2;
            colors3 = cardColors;
            $composer3 = $composer4;
            enabled4 = enabled2;
            shape4 = shape2;
            elevation3 = cardElevation;
            border3 = borderStroke;
            interactionSource3 = interactionSource;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    enabled2 = true;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    shape2 = CardDefaults.INSTANCE.getShape($composer4, 6);
                }
                if ((i & 16) != 0) {
                    colors2 = CardDefaults.INSTANCE.cardColors($composer4, 6);
                    $dirty &= -57345;
                } else {
                    colors2 = cardColors;
                }
                if ((i & 32) != 0) {
                    i2 = i10;
                    elevation2 = CardDefaults.INSTANCE.m1831cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer4, 1572864, 63);
                    $composer2 = $composer4;
                    $dirty &= -458753;
                } else {
                    $composer2 = $composer4;
                    i2 = i10;
                    elevation2 = elevation;
                }
                BorderStroke border4 = i9 != 0 ? null : border;
                if (i2 != 0) {
                    $composer2.startReplaceableGroup(63758450);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Card.kt#9igjgp");
                    Composer $this$cache$iv = $composer2;
                    Object it$iv = $this$cache$iv.rememberedValue();
                    CardColors colors4 = colors2;
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    border2 = border4;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    i3 = -2024281376;
                    colors2 = colors4;
                } else {
                    interactionSource2 = interactionSource;
                    border2 = border4;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    i3 = -2024281376;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    interactionSource2 = interactionSource;
                    $dirty &= -458753;
                    $composer2 = $composer4;
                    shape3 = shape2;
                    colors2 = cardColors;
                    elevation2 = cardElevation;
                    border2 = borderStroke;
                    i3 = -2024281376;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                } else {
                    interactionSource2 = interactionSource;
                    $composer2 = $composer4;
                    shape3 = shape2;
                    colors2 = cardColors;
                    elevation2 = cardElevation;
                    border2 = borderStroke;
                    i3 = -2024281376;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i3, $dirty, -1, "androidx.compose.material3.Card (Card.kt:141)");
            }
            $composer3 = $composer2;
            SurfaceKt.m2522Surfaceo_FOJdg(function0, modifier3, enabled3, shape3, colors2.m1823containerColorvNxB06k$material3_release(enabled3), colors2.m1824contentColorvNxB06k$material3_release(enabled3), elevation2.m1836tonalElevationu2uoSUM$material3_release(enabled3), elevation2.shadowElevation$material3_release(enabled3, interactionSource2, $composer2, (($dirty >> 6) & 14) | (($dirty >> 18) & 112) | (($dirty >> 9) & 896)).getValue().m6311unboximpl(), border2, interactionSource2, ComposableLambdaKt.composableLambda($composer2, 776921067, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.Card.4
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x014a  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r25, int r26) {
                    /*
                        Method dump skipped, instructions count: 334
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CardKt.C12534.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer3, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 6) & 234881024) | (($dirty << 6) & 1879048192), 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors3 = colors2;
            elevation3 = elevation2;
            modifier4 = modifier3;
            enabled4 = enabled3;
            shape4 = shape3;
            border3 = border2;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.Card.5
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
                    CardKt.Card(function0, modifier4, enabled4, shape4, colors3, elevation3, border3, interactionSource3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void ElevatedCard(Modifier modifier, Shape shape, CardColors colors, CardElevation elevation, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape shape2;
        CardColors cardColors;
        CardElevation cardElevation;
        Shape shape3;
        CardColors colors2;
        Composer $composer2;
        CardElevation elevation2;
        Modifier modifier3;
        Shape shape4;
        CardColors colors3;
        Composer $composer3;
        final Shape shape5;
        final CardColors colors4;
        final CardElevation elevation3;
        final Modifier modifier4;
        Composer $composer4 = $composer.startRestartGroup(895940201);
        ComposerKt.sourceInformation($composer4, "C(ElevatedCard)P(3,4!1,2)185@8559L13,186@8612L20,187@8678L23,189@8755L140:Card.kt#uh7d8r");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                shape2 = shape;
                int i3 = $composer4.changed(shape2) ? 32 : 16;
                $dirty |= i3;
            } else {
                shape2 = shape;
            }
            $dirty |= i3;
        } else {
            shape2 = shape;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                cardColors = colors;
                int i4 = $composer4.changed(cardColors) ? 256 : 128;
                $dirty |= i4;
            } else {
                cardColors = colors;
            }
            $dirty |= i4;
        } else {
            cardColors = colors;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                cardElevation = elevation;
                int i5 = $composer4.changed(cardElevation) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                cardElevation = elevation;
            }
            $dirty |= i5;
        } else {
            cardElevation = elevation;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer4.changedInstance(function3) ? 16384 : 8192;
        }
        if (($dirty & 9363) == 9362 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            modifier4 = modifier2;
            shape5 = shape2;
            colors4 = cardColors;
            elevation3 = cardElevation;
            $composer3 = $composer4;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    shape3 = CardDefaults.INSTANCE.getElevatedShape($composer4, 6);
                    $dirty &= -113;
                } else {
                    shape3 = shape2;
                }
                if ((i & 4) != 0) {
                    colors2 = CardDefaults.INSTANCE.elevatedCardColors($composer4, 6);
                    $dirty &= -897;
                } else {
                    colors2 = cardColors;
                }
                if ((i & 8) != 0) {
                    $composer2 = $composer4;
                    $dirty &= -7169;
                    modifier3 = modifier5;
                    shape4 = shape3;
                    colors3 = colors2;
                    elevation2 = CardDefaults.INSTANCE.m1833elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer2, 1572864, 63);
                } else {
                    $composer2 = $composer4;
                    elevation2 = elevation;
                    modifier3 = modifier5;
                    shape4 = shape3;
                    colors3 = colors2;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                shape4 = shape2;
                colors3 = cardColors;
                elevation2 = cardElevation;
                $composer2 = $composer4;
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(895940201, $dirty, -1, "androidx.compose.material3.ElevatedCard (Card.kt:189)");
            }
            Composer $composer5 = $composer2;
            Card(modifier3, shape4, colors3, elevation2, null, function3, $composer5, ($dirty & 14) | 24576 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty << 3) & 458752), 0);
            $composer3 = $composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape5 = shape4;
            colors4 = colors3;
            elevation3 = elevation2;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.ElevatedCard.1
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

                public final void invoke(Composer composer, int i6) {
                    CardKt.ElevatedCard(modifier4, shape5, colors4, elevation3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void ElevatedCard(final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, CardColors colors, CardElevation elevation, MutableInteractionSource interactionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Modifier modifier2;
        boolean enabled2;
        Shape shape2;
        CardColors cardColors;
        CardElevation cardElevation;
        MutableInteractionSource mutableInteractionSource;
        CardColors colors2;
        Composer $composer2;
        CardElevation elevation2;
        MutableInteractionSource interactionSource2;
        CardColors colors3;
        CardElevation elevation3;
        Modifier modifier3;
        boolean enabled3;
        Shape shape3;
        Object value$iv;
        Composer $composer3;
        final MutableInteractionSource interactionSource3;
        final Modifier modifier4;
        final boolean enabled4;
        final Shape shape4;
        final CardColors colors4;
        final CardElevation elevation4;
        Composer $composer4 = $composer.startRestartGroup(-1850977784);
        ComposerKt.sourceInformation($composer4, "C(ElevatedCard)P(6,5,3,7!1,2,4)233@10876L13,234@10929L20,235@10995L23,236@11070L39,238@11163L229:Card.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            function02 = function0;
        } else if (($changed & 6) == 0) {
            function02 = function0;
            $dirty |= $composer4.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            enabled2 = enabled;
        } else if (($changed & 384) == 0) {
            enabled2 = enabled;
            $dirty |= $composer4.changed(enabled2) ? 256 : 128;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                int i4 = $composer4.changed(shape2) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                shape2 = shape;
            }
            $dirty |= i4;
        } else {
            shape2 = shape;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                cardColors = colors;
                int i5 = $composer4.changed(cardColors) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                cardColors = colors;
            }
            $dirty |= i5;
        } else {
            cardColors = colors;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                cardElevation = elevation;
                int i6 = $composer4.changed(cardElevation) ? 131072 : 65536;
                $dirty |= i6;
            } else {
                cardElevation = elevation;
            }
            $dirty |= i6;
        } else {
            cardElevation = elevation;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty |= 1572864;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 1572864) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty |= $composer4.changed(mutableInteractionSource) ? 1048576 : 524288;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i & 128) != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer4.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ((4793491 & $dirty) == 4793490 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            modifier4 = modifier2;
            colors4 = cardColors;
            $composer3 = $composer4;
            enabled4 = enabled2;
            shape4 = shape2;
            elevation4 = cardElevation;
            interactionSource3 = mutableInteractionSource;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    enabled2 = true;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    shape2 = CardDefaults.INSTANCE.getElevatedShape($composer4, 6);
                }
                if ((i & 16) != 0) {
                    colors2 = CardDefaults.INSTANCE.elevatedCardColors($composer4, 6);
                    $dirty &= -57345;
                } else {
                    colors2 = cardColors;
                }
                if ((i & 32) != 0) {
                    elevation2 = CardDefaults.INSTANCE.m1833elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer4, 1572864, 63);
                    $composer2 = $composer4;
                    $dirty &= -458753;
                } else {
                    $composer2 = $composer4;
                    elevation2 = elevation;
                }
                if (i7 != 0) {
                    $composer2.startReplaceableGroup(1166350241);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Card.kt#9igjgp");
                    Composer $this$cache$iv = $composer2;
                    Object it$iv = $this$cache$iv.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    MutableInteractionSource interactionSource4 = (MutableInteractionSource) value$iv;
                    $composer2.endReplaceableGroup();
                    colors3 = colors2;
                    elevation3 = elevation2;
                    modifier3 = modifier2;
                    interactionSource2 = interactionSource4;
                    enabled3 = enabled2;
                    shape3 = shape2;
                } else {
                    interactionSource2 = interactionSource;
                    colors3 = colors2;
                    elevation3 = elevation2;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    $composer2 = $composer4;
                    shape3 = shape2;
                    colors3 = cardColors;
                    elevation3 = cardElevation;
                    interactionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                } else {
                    $composer2 = $composer4;
                    shape3 = shape2;
                    colors3 = cardColors;
                    elevation3 = cardElevation;
                    interactionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1850977784, $dirty, -1, "androidx.compose.material3.ElevatedCard (Card.kt:238)");
            }
            Composer $composer5 = $composer2;
            Card(function02, modifier3, enabled3, shape3, colors3, elevation3, null, interactionSource2, function3, $composer5, ($dirty & 14) | 1572864 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (($dirty << 3) & 29360128) | (234881024 & ($dirty << 3)), 0);
            MutableInteractionSource interactionSource5 = interactionSource2;
            $composer3 = $composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interactionSource3 = interactionSource5;
            modifier4 = modifier3;
            enabled4 = enabled3;
            shape4 = shape3;
            colors4 = colors3;
            elevation4 = elevation3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.ElevatedCard.3
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
                    CardKt.ElevatedCard(function0, modifier4, enabled4, shape4, colors4, elevation4, interactionSource3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void OutlinedCard(Modifier modifier, Shape shape, CardColors colors, CardElevation elevation, BorderStroke border, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape shape2;
        CardColors cardColors;
        CardElevation cardElevation;
        BorderStroke borderStroke;
        Shape shape3;
        CardColors colors2;
        Composer $composer2;
        CardElevation elevation2;
        BorderStroke border2;
        Modifier modifier3;
        Shape shape4;
        CardColors colors3;
        CardElevation elevation3;
        Composer $composer3;
        final Shape shape5;
        final CardColors colors4;
        final CardElevation elevation4;
        final BorderStroke border3;
        final Modifier modifier4;
        Composer $composer4 = $composer.startRestartGroup(740336179);
        ComposerKt.sourceInformation($composer4, "C(OutlinedCard)P(4,5,1,3)278@12927L13,279@12980L20,280@13046L23,281@13111L20,283@13185L142:Card.kt#uh7d8r");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                shape2 = shape;
                int i3 = $composer4.changed(shape2) ? 32 : 16;
                $dirty |= i3;
            } else {
                shape2 = shape;
            }
            $dirty |= i3;
        } else {
            shape2 = shape;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                cardColors = colors;
                int i4 = $composer4.changed(cardColors) ? 256 : 128;
                $dirty |= i4;
            } else {
                cardColors = colors;
            }
            $dirty |= i4;
        } else {
            cardColors = colors;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                cardElevation = elevation;
                int i5 = $composer4.changed(cardElevation) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                cardElevation = elevation;
            }
            $dirty |= i5;
        } else {
            cardElevation = elevation;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                borderStroke = border;
                int i6 = $composer4.changed(borderStroke) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                borderStroke = border;
            }
            $dirty |= i6;
        } else {
            borderStroke = border;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            $dirty |= $composer4.changedInstance(function3) ? 131072 : 65536;
        }
        if ((74899 & $dirty) == 74898 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            modifier4 = modifier2;
            shape5 = shape2;
            colors4 = cardColors;
            elevation4 = cardElevation;
            border3 = borderStroke;
            $composer3 = $composer4;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    shape3 = CardDefaults.INSTANCE.getOutlinedShape($composer4, 6);
                    $dirty &= -113;
                } else {
                    shape3 = shape2;
                }
                if ((i & 4) != 0) {
                    colors2 = CardDefaults.INSTANCE.outlinedCardColors($composer4, 6);
                    $dirty &= -897;
                } else {
                    colors2 = cardColors;
                }
                if ((i & 8) != 0) {
                    $composer2 = $composer4;
                    elevation2 = CardDefaults.INSTANCE.m1835outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer2, 1572864, 63);
                    $dirty &= -7169;
                } else {
                    $composer2 = $composer4;
                    elevation2 = cardElevation;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    modifier3 = modifier5;
                    shape4 = shape3;
                    colors3 = colors2;
                    elevation3 = elevation2;
                    border2 = CardDefaults.INSTANCE.outlinedCardBorder(false, $composer2, 48, 1);
                } else {
                    border2 = border;
                    modifier3 = modifier5;
                    shape4 = shape3;
                    colors3 = colors2;
                    elevation3 = elevation2;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                shape4 = shape2;
                colors3 = cardColors;
                elevation3 = cardElevation;
                border2 = borderStroke;
                $composer2 = $composer4;
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(740336179, $dirty, -1, "androidx.compose.material3.OutlinedCard (Card.kt:283)");
            }
            Composer $composer5 = $composer2;
            Card(modifier3, shape4, colors3, elevation3, border2, function3, $composer5, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty), 0);
            $composer3 = $composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape5 = shape4;
            colors4 = colors3;
            elevation4 = elevation3;
            border3 = border2;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.OutlinedCard.1
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
                    CardKt.OutlinedCard(modifier4, shape5, colors4, elevation4, border3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void OutlinedCard(final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, CardColors colors, CardElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        Shape shape2;
        CardColors colors2;
        CardElevation cardElevation;
        BorderStroke borderStroke;
        MutableInteractionSource mutableInteractionSource;
        Composer $composer2;
        int i2;
        CardElevation elevation2;
        BorderStroke border2;
        MutableInteractionSource interactionSource2;
        CardElevation elevation3;
        Modifier modifier3;
        BorderStroke border3;
        boolean enabled3;
        Shape shape3;
        CardColors colors3;
        Object value$iv;
        Composer $composer3;
        final Modifier modifier4;
        final boolean enabled4;
        final Shape shape4;
        final CardColors colors4;
        final CardElevation elevation4;
        final BorderStroke border4;
        final MutableInteractionSource interactionSource3;
        Composer $composer4 = $composer.startRestartGroup(-727137250);
        ComposerKt.sourceInformation($composer4, "C(OutlinedCard)P(7,6,4,8,1,3!1,5)328@15398L13,329@15451L20,330@15517L23,331@15582L27,332@15661L39,334@15754L231:Card.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            enabled2 = enabled;
        } else if (($changed & 384) == 0) {
            enabled2 = enabled;
            $dirty |= $composer4.changed(enabled2) ? 256 : 128;
        } else {
            enabled2 = enabled;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                int i5 = $composer4.changed(shape2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                shape2 = shape;
            }
            $dirty |= i5;
        } else {
            shape2 = shape;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                colors2 = colors;
                int i6 = $composer4.changed(colors2) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                colors2 = colors;
            }
            $dirty |= i6;
        } else {
            colors2 = colors;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                cardElevation = elevation;
                int i7 = $composer4.changed(cardElevation) ? 131072 : 65536;
                $dirty |= i7;
            } else {
                cardElevation = elevation;
            }
            $dirty |= i7;
        } else {
            cardElevation = elevation;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                borderStroke = border;
                int i8 = $composer4.changed(borderStroke) ? 1048576 : 524288;
                $dirty |= i8;
            } else {
                borderStroke = border;
            }
            $dirty |= i8;
        } else {
            borderStroke = border;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
            mutableInteractionSource = interactionSource;
        } else if ((12582912 & $changed) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty |= $composer4.changed(mutableInteractionSource) ? 8388608 : 4194304;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if ((i & 256) != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer4.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) == 38347922 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            $composer3 = $composer4;
            enabled4 = enabled2;
            shape4 = shape2;
            elevation4 = cardElevation;
            border4 = borderStroke;
            interactionSource3 = mutableInteractionSource;
            modifier4 = modifier2;
            colors4 = colors2;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    enabled2 = true;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    shape2 = CardDefaults.INSTANCE.getOutlinedShape($composer4, 6);
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    colors2 = CardDefaults.INSTANCE.outlinedCardColors($composer4, 6);
                }
                if ((i & 32) != 0) {
                    i2 = i9;
                    elevation2 = CardDefaults.INSTANCE.m1835outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer4, 1572864, 63);
                    $composer2 = $composer4;
                    $dirty &= -458753;
                } else {
                    $composer2 = $composer4;
                    i2 = i9;
                    elevation2 = elevation;
                }
                if ((i & 64) != 0) {
                    border2 = CardDefaults.INSTANCE.outlinedCardBorder(enabled2, $composer2, (($dirty >> 6) & 14) | 48, 0);
                    $dirty &= -3670017;
                } else {
                    border2 = border;
                }
                if (i2 != 0) {
                    $composer2.startReplaceableGroup(1028043736);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Card.kt#9igjgp");
                    Composer $this$cache$iv = $composer2;
                    Object it$iv = $this$cache$iv.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    elevation3 = elevation2;
                    modifier3 = modifier2;
                    border3 = border2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    colors3 = colors2;
                } else {
                    interactionSource2 = interactionSource;
                    elevation3 = elevation2;
                    modifier3 = modifier2;
                    border3 = border2;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    colors3 = colors2;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                    $composer2 = $composer4;
                    enabled3 = enabled2;
                    colors3 = colors2;
                    elevation3 = cardElevation;
                    border3 = borderStroke;
                    interactionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    shape3 = shape2;
                } else {
                    $composer2 = $composer4;
                    enabled3 = enabled2;
                    colors3 = colors2;
                    elevation3 = cardElevation;
                    border3 = borderStroke;
                    interactionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    shape3 = shape2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-727137250, $dirty, -1, "androidx.compose.material3.OutlinedCard (Card.kt:334)");
            }
            $composer3 = $composer2;
            Card(function0, modifier3, enabled3, shape3, colors3, elevation3, border3, interactionSource2, function3, $composer3, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            enabled4 = enabled3;
            shape4 = shape3;
            colors4 = colors3;
            elevation4 = elevation3;
            border4 = border3;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CardKt.OutlinedCard.3
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

                public final void invoke(Composer composer, int i10) {
                    CardKt.OutlinedCard(function0, modifier4, enabled4, shape4, colors4, elevation4, border4, interactionSource3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
