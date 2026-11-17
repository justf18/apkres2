package androidx.compose.material3;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.p000ui.C1740R;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.RectangleShapeKt;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* compiled from: NavigationDrawer.kt */
@Metadata(m164d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\u001al\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aQ\u0010\u001b\u001a\u00020\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\"\u001aj\u0010#\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001al\u0010&\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010\u001a\u001a`\u0010(\u001a\u00020\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u000f2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u008c\u0001\u0010,\u001a\u00020\t2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\u0006\u0010.\u001a\u00020!2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d¢\u0006\u0002\b\u00172\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000206H\u0007¢\u0006\u0002\u00107\u001al\u00108\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010\u001a\u001a=\u0010:\u001a\u00020\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010;\u001a>\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020!2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\u0006\u0010@\u001a\u00020\u000fH\u0003ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a \u0010C\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0002\u001a+\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020I2\u0014\b\u0002\u0010J\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020!0\u0015H\u0007¢\u0006\u0002\u0010K\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082D¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, m165d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "MinimumDrawerWidth", "DismissibleDrawerSheet", "", "modifier", "Landroidx/compose/ui/Modifier;", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerTonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DismissibleDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "drawerContent", "Lkotlin/Function0;", "drawerState", "Landroidx/compose/material3/DrawerState;", "gesturesEnabled", "", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DrawerSheet", "DrawerSheet-vywBR7E", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "ModalDrawerSheet-afqeVBk", "ModalNavigationDrawer", "scrimColor", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "NavigationDrawerItem", "label", "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", TypedValues.Custom.S_COLOR, "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberDrawerState", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "material3_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NavigationDrawerKt {
    private static final float DrawerPositionalThreshold = 0.5f;
    private static final float DrawerVelocityThreshold = C1956Dp.m6297constructorimpl(400);
    private static final float MinimumDrawerWidth = C1956Dp.m6297constructorimpl(240);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    public static final DrawerState rememberDrawerState(final DrawerValue initialValue, final Function1<? super DrawerValue, Boolean> function1, Composer $composer, int $changed, int i) {
        Object value$iv;
        $composer.startReplaceableGroup(2098699222);
        ComposerKt.sourceInformation($composer, "C(rememberDrawerState)P(1)280@10617L61,280@10553L125:NavigationDrawer.kt#uh7d8r");
        if ((i & 2) != 0) {
            Function1 confirmStateChange = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt.rememberDrawerState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DrawerValue it) {
                    return true;
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2098699222, $changed, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:279)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.Companion.Saver(function1);
        $composer.startReplaceableGroup(-21510967);
        ComposerKt.sourceInformation($composer, "CC(remember):NavigationDrawer.kt#9igjgp");
        boolean invalid$iv = (((($changed & 112) ^ 48) > 32 && $composer.changed(function1)) || ($changed & 48) == 32) | (((($changed & 14) ^ 6) > 4 && $composer.changed(initialValue)) || ($changed & 6) == 4);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = (Function0) new Function0<DrawerState>() { // from class: androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DrawerState invoke() {
                    return new DrawerState(initialValue, function1);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        $composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m3566rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return drawerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0342 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0468 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0538 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0567  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x058e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x05ca  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x064b  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0710  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0726  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x07c9  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x07d9  */
    /* JADX WARN: Removed duplicated region for block: B:244:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0134  */
    /* renamed from: ModalNavigationDrawer-FHprtrg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2243ModalNavigationDrawerFHprtrg(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r64, androidx.compose.p000ui.Modifier r65, androidx.compose.material3.DrawerState r66, boolean r67, long r68, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r70, androidx.compose.runtime.Composer r71, final int r72, final int r73) {
        /*
            Method dump skipped, instructions count: 2026
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m2243ModalNavigationDrawerFHprtrg(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material3.DrawerState, boolean, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x06a0  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x079c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void DismissibleNavigationDrawer(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, androidx.compose.p000ui.Modifier r79, androidx.compose.material3.DrawerState r80, boolean r81, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r82, androidx.compose.runtime.Composer r83, final int r84, final int r85) {
        /*
            Method dump skipped, instructions count: 1979
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.DismissibleNavigationDrawer(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material3.DrawerState, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x031e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void PermanentNavigationDrawer(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.p000ui.Modifier r48, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, androidx.compose.runtime.Composer r50, final int r51, final int r52) {
        /*
            Method dump skipped, instructions count: 826
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.PermanentNavigationDrawer(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: ModalDrawerSheet-afqeVBk, reason: not valid java name */
    public static final void m2242ModalDrawerSheetafqeVBk(Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape drawerShape2;
        long drawerContainerColor2;
        long drawerContentColor2;
        float drawerTonalElevation2;
        WindowInsets windowInsets2;
        long drawerContainerColor3;
        long drawerContentColor3;
        float drawerTonalElevation3;
        WindowInsets windowInsets3;
        int i2;
        Modifier modifier3;
        Shape drawerShape3;
        Composer $composer2;
        final WindowInsets windowInsets4;
        final Modifier modifier4;
        final long drawerContainerColor4;
        final long drawerContentColor4;
        final float drawerTonalElevation4;
        final Shape drawerShape4;
        Composer $composer3 = $composer.startRestartGroup(1001163336);
        ComposerKt.sourceInformation($composer3, "C(ModalDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)528@20049L5,529@20105L14,530@20153L37,532@20308L12,535@20378L183:NavigationDrawer.kt#uh7d8r");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                drawerShape2 = drawerShape;
                int i4 = $composer3.changed(drawerShape2) ? 32 : 16;
                $dirty |= i4;
            } else {
                drawerShape2 = drawerShape;
            }
            $dirty |= i4;
        } else {
            drawerShape2 = drawerShape;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                drawerContainerColor2 = drawerContainerColor;
                int i5 = $composer3.changed(drawerContainerColor2) ? 256 : 128;
                $dirty |= i5;
            } else {
                drawerContainerColor2 = drawerContainerColor;
            }
            $dirty |= i5;
        } else {
            drawerContainerColor2 = drawerContainerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                drawerContentColor2 = drawerContentColor;
                int i6 = $composer3.changed(drawerContentColor2) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                drawerContentColor2 = drawerContentColor;
            }
            $dirty |= i6;
        } else {
            drawerContentColor2 = drawerContentColor;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            drawerTonalElevation2 = drawerTonalElevation;
        } else if (($changed & 24576) == 0) {
            drawerTonalElevation2 = drawerTonalElevation;
            $dirty |= $composer3.changed(drawerTonalElevation2) ? 16384 : 8192;
        } else {
            drawerTonalElevation2 = drawerTonalElevation;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                windowInsets2 = windowInsets;
                int i8 = $composer3.changed(windowInsets2) ? 131072 : 65536;
                $dirty |= i8;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty |= i8;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((599187 & $dirty) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            drawerContainerColor4 = drawerContainerColor2;
            drawerTonalElevation4 = drawerTonalElevation2;
            drawerShape4 = drawerShape2;
            drawerContentColor4 = drawerContentColor2;
            windowInsets4 = windowInsets2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 2) != 0) {
                    $dirty &= -113;
                    drawerShape2 = DrawerDefaults.INSTANCE.getShape($composer3, 6);
                }
                if ((i & 4) != 0) {
                    drawerContainerColor2 = DrawerDefaults.INSTANCE.getContainerColor($composer3, 6);
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    drawerContentColor2 = ColorSchemeKt.m1935contentColorForek8zF_U(drawerContainerColor2, $composer3, ($dirty >> 6) & 14);
                    $dirty &= -7169;
                }
                if (i7 != 0) {
                    drawerTonalElevation2 = DrawerDefaults.INSTANCE.m2075getModalDrawerElevationD9Ej5fM();
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets($composer3, 6);
                    drawerShape3 = drawerShape2;
                    drawerContainerColor3 = drawerContainerColor2;
                    drawerContentColor3 = drawerContentColor2;
                    drawerTonalElevation3 = drawerTonalElevation2;
                    i2 = 1001163336;
                    modifier3 = modifier2;
                } else {
                    drawerContainerColor3 = drawerContainerColor2;
                    drawerContentColor3 = drawerContentColor2;
                    drawerTonalElevation3 = drawerTonalElevation2;
                    windowInsets3 = windowInsets2;
                    i2 = 1001163336;
                    modifier3 = modifier2;
                    drawerShape3 = drawerShape2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    drawerContainerColor3 = drawerContainerColor2;
                    drawerContentColor3 = drawerContentColor2;
                    drawerTonalElevation3 = drawerTonalElevation2;
                    windowInsets3 = windowInsets2;
                    i2 = 1001163336;
                    modifier3 = modifier2;
                    drawerShape3 = drawerShape2;
                } else {
                    drawerContainerColor3 = drawerContainerColor2;
                    drawerContentColor3 = drawerContentColor2;
                    drawerTonalElevation3 = drawerTonalElevation2;
                    windowInsets3 = windowInsets2;
                    i2 = 1001163336;
                    modifier3 = modifier2;
                    drawerShape3 = drawerShape2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:534)");
            }
            $composer2 = $composer3;
            m2241DrawerSheetvywBR7E(windowInsets3, modifier3, drawerShape3, drawerContainerColor3, drawerContentColor3, drawerTonalElevation3, function3, $composer2, (($dirty >> 15) & 14) | (($dirty << 3) & 112) | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (458752 & ($dirty << 3)) | (3670016 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets4 = windowInsets3;
            modifier4 = modifier3;
            drawerContainerColor4 = drawerContainerColor3;
            drawerContentColor4 = drawerContentColor3;
            drawerTonalElevation4 = drawerTonalElevation3;
            drawerShape4 = drawerShape3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$1
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
                    NavigationDrawerKt.m2242ModalDrawerSheetafqeVBk(modifier4, drawerShape4, drawerContainerColor4, drawerContentColor4, drawerTonalElevation4, windowInsets4, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: DismissibleDrawerSheet-afqeVBk, reason: not valid java name */
    public static final void m2240DismissibleDrawerSheetafqeVBk(Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape drawerShape2;
        long drawerContainerColor2;
        long drawerContentColor2;
        float drawerTonalElevation2;
        WindowInsets windowInsets2;
        long drawerContentColor3;
        float drawerTonalElevation3;
        WindowInsets windowInsets3;
        int i2;
        Modifier modifier3;
        Shape drawerShape3;
        long drawerContainerColor3;
        Composer $composer2;
        final WindowInsets windowInsets4;
        final Modifier modifier4;
        final long drawerContainerColor4;
        final long drawerContentColor4;
        final float drawerTonalElevation4;
        final Shape drawerShape4;
        Composer $composer3 = $composer.startRestartGroup(-588600583);
        ComposerKt.sourceInformation($composer3, "C(DismissibleDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)566@21732L14,567@21780L37,569@21941L12,572@22011L183:NavigationDrawer.kt#uh7d8r");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            drawerShape2 = drawerShape;
        } else if (($changed & 48) == 0) {
            drawerShape2 = drawerShape;
            $dirty |= $composer3.changed(drawerShape2) ? 32 : 16;
        } else {
            drawerShape2 = drawerShape;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                drawerContainerColor2 = drawerContainerColor;
                int i5 = $composer3.changed(drawerContainerColor2) ? 256 : 128;
                $dirty |= i5;
            } else {
                drawerContainerColor2 = drawerContainerColor;
            }
            $dirty |= i5;
        } else {
            drawerContainerColor2 = drawerContainerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                drawerContentColor2 = drawerContentColor;
                int i6 = $composer3.changed(drawerContentColor2) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                drawerContentColor2 = drawerContentColor;
            }
            $dirty |= i6;
        } else {
            drawerContentColor2 = drawerContentColor;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            drawerTonalElevation2 = drawerTonalElevation;
        } else if (($changed & 24576) == 0) {
            drawerTonalElevation2 = drawerTonalElevation;
            $dirty |= $composer3.changed(drawerTonalElevation2) ? 16384 : 8192;
        } else {
            drawerTonalElevation2 = drawerTonalElevation;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                windowInsets2 = windowInsets;
                int i8 = $composer3.changed(windowInsets2) ? 131072 : 65536;
                $dirty |= i8;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty |= i8;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            drawerShape4 = drawerShape2;
            drawerContentColor4 = drawerContentColor2;
            $composer2 = $composer3;
            modifier4 = modifier2;
            drawerContainerColor4 = drawerContainerColor2;
            drawerTonalElevation4 = drawerTonalElevation2;
            windowInsets4 = windowInsets2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    drawerShape2 = RectangleShapeKt.getRectangleShape();
                }
                if ((i & 4) != 0) {
                    drawerContainerColor2 = DrawerDefaults.INSTANCE.getContainerColor($composer3, 6);
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    drawerContentColor2 = ColorSchemeKt.m1935contentColorForek8zF_U(drawerContainerColor2, $composer3, ($dirty >> 6) & 14);
                    $dirty &= -7169;
                }
                if (i7 != 0) {
                    drawerTonalElevation2 = DrawerDefaults.INSTANCE.m2073getDismissibleDrawerElevationD9Ej5fM();
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    drawerContainerColor3 = drawerContainerColor2;
                    drawerContentColor3 = drawerContentColor2;
                    drawerTonalElevation3 = drawerTonalElevation2;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets($composer3, 6);
                    modifier3 = modifier2;
                    drawerShape3 = drawerShape2;
                    i2 = -588600583;
                } else {
                    drawerContentColor3 = drawerContentColor2;
                    drawerTonalElevation3 = drawerTonalElevation2;
                    windowInsets3 = windowInsets2;
                    i2 = -588600583;
                    modifier3 = modifier2;
                    drawerShape3 = drawerShape2;
                    drawerContainerColor3 = drawerContainerColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    drawerContentColor3 = drawerContentColor2;
                    drawerTonalElevation3 = drawerTonalElevation2;
                    windowInsets3 = windowInsets2;
                    i2 = -588600583;
                    modifier3 = modifier2;
                    drawerShape3 = drawerShape2;
                    drawerContainerColor3 = drawerContainerColor2;
                } else {
                    drawerContentColor3 = drawerContentColor2;
                    drawerTonalElevation3 = drawerTonalElevation2;
                    windowInsets3 = windowInsets2;
                    i2 = -588600583;
                    modifier3 = modifier2;
                    drawerShape3 = drawerShape2;
                    drawerContainerColor3 = drawerContainerColor2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:571)");
            }
            $composer2 = $composer3;
            m2241DrawerSheetvywBR7E(windowInsets3, modifier3, drawerShape3, drawerContainerColor3, drawerContentColor3, drawerTonalElevation3, function3, $composer2, (($dirty >> 15) & 14) | (($dirty << 3) & 112) | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (458752 & ($dirty << 3)) | (3670016 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets4 = windowInsets3;
            modifier4 = modifier3;
            drawerContainerColor4 = drawerContainerColor3;
            drawerContentColor4 = drawerContentColor3;
            drawerTonalElevation4 = drawerTonalElevation3;
            drawerShape4 = drawerShape3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$1
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
                    NavigationDrawerKt.m2240DismissibleDrawerSheetafqeVBk(modifier4, drawerShape4, drawerContainerColor4, drawerContentColor4, drawerTonalElevation4, windowInsets4, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: PermanentDrawerSheet-afqeVBk, reason: not valid java name */
    public static final void m2244PermanentDrawerSheetafqeVBk(Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape drawerShape2;
        long drawerContainerColor2;
        long drawerContentColor2;
        float drawerTonalElevation2;
        WindowInsets windowInsets2;
        long drawerContentColor3;
        float drawerTonalElevation3;
        WindowInsets windowInsets3;
        int i2;
        Shape drawerShape3;
        long drawerContainerColor3;
        Object value$iv;
        Composer $composer2;
        final Modifier modifier3;
        final WindowInsets windowInsets4;
        final Shape drawerShape4;
        final long drawerContainerColor4;
        final long drawerContentColor4;
        final float drawerTonalElevation4;
        Composer $composer3 = $composer.startRestartGroup(-1733353241);
        ComposerKt.sourceInformation($composer3, "C(PermanentDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)603@23356L14,604@23404L37,606@23563L12,609@23654L33,612@23754L50,610@23692L244:NavigationDrawer.kt#uh7d8r");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            drawerShape2 = drawerShape;
        } else if (($changed & 48) == 0) {
            drawerShape2 = drawerShape;
            $dirty |= $composer3.changed(drawerShape2) ? 32 : 16;
        } else {
            drawerShape2 = drawerShape;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                drawerContainerColor2 = drawerContainerColor;
                int i5 = $composer3.changed(drawerContainerColor2) ? 256 : 128;
                $dirty |= i5;
            } else {
                drawerContainerColor2 = drawerContainerColor;
            }
            $dirty |= i5;
        } else {
            drawerContainerColor2 = drawerContainerColor;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                drawerContentColor2 = drawerContentColor;
                int i6 = $composer3.changed(drawerContentColor2) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                drawerContentColor2 = drawerContentColor;
            }
            $dirty |= i6;
        } else {
            drawerContentColor2 = drawerContentColor;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            drawerTonalElevation2 = drawerTonalElevation;
        } else if (($changed & 24576) == 0) {
            drawerTonalElevation2 = drawerTonalElevation;
            $dirty |= $composer3.changed(drawerTonalElevation2) ? 16384 : 8192;
        } else {
            drawerTonalElevation2 = drawerTonalElevation;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                windowInsets2 = windowInsets;
                int i8 = $composer3.changed(windowInsets2) ? 131072 : 65536;
                $dirty |= i8;
            } else {
                windowInsets2 = windowInsets;
            }
            $dirty |= i8;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            drawerShape4 = drawerShape2;
            drawerContentColor4 = drawerContentColor2;
            $composer2 = $composer3;
            modifier3 = modifier2;
            drawerContainerColor4 = drawerContainerColor2;
            drawerTonalElevation4 = drawerTonalElevation2;
            windowInsets4 = windowInsets2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    drawerShape2 = RectangleShapeKt.getRectangleShape();
                }
                if ((i & 4) != 0) {
                    drawerContainerColor2 = DrawerDefaults.INSTANCE.getContainerColor($composer3, 6);
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    drawerContentColor2 = ColorSchemeKt.m1935contentColorForek8zF_U(drawerContainerColor2, $composer3, ($dirty >> 6) & 14);
                    $dirty &= -7169;
                }
                if (i7 != 0) {
                    drawerTonalElevation2 = DrawerDefaults.INSTANCE.m2076getPermanentDrawerElevationD9Ej5fM();
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    drawerContainerColor3 = drawerContainerColor2;
                    drawerContentColor3 = drawerContentColor2;
                    drawerTonalElevation3 = drawerTonalElevation2;
                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets($composer3, 6);
                    drawerShape3 = drawerShape2;
                    i2 = -1733353241;
                } else {
                    drawerContentColor3 = drawerContentColor2;
                    drawerTonalElevation3 = drawerTonalElevation2;
                    windowInsets3 = windowInsets2;
                    i2 = -1733353241;
                    drawerShape3 = drawerShape2;
                    drawerContainerColor3 = drawerContainerColor2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    drawerContentColor3 = drawerContentColor2;
                    drawerTonalElevation3 = drawerTonalElevation2;
                    windowInsets3 = windowInsets2;
                    i2 = -1733353241;
                    drawerShape3 = drawerShape2;
                    drawerContainerColor3 = drawerContainerColor2;
                } else {
                    drawerContentColor3 = drawerContentColor2;
                    drawerTonalElevation3 = drawerTonalElevation2;
                    windowInsets3 = windowInsets2;
                    i2 = -1733353241;
                    drawerShape3 = drawerShape2;
                    drawerContainerColor3 = drawerContainerColor2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:608)");
            }
            Strings.Companion companion = Strings.INSTANCE;
            final String navigationMenu = Strings_androidKt.m2509getStringNWtq28(Strings.m2440constructorimpl(C1740R.string.navigation_menu), $composer3, 0);
            $composer3.startReplaceableGroup(705343847);
            ComposerKt.sourceInformation($composer3, "CC(remember):NavigationDrawer.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(navigationMenu);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                        SemanticsPropertiesKt.setPaneTitle($this$semantics, navigationMenu);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer3.endReplaceableGroup();
            $composer2 = $composer3;
            m2241DrawerSheetvywBR7E(windowInsets3, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) value$iv, 1, null), drawerShape3, drawerContainerColor3, drawerContentColor3, drawerTonalElevation3, function3, $composer2, (($dirty >> 15) & 14) | (($dirty << 3) & 896) | (($dirty << 3) & 7168) | (($dirty << 3) & 57344) | (458752 & ($dirty << 3)) | (3670016 & $dirty), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            windowInsets4 = windowInsets3;
            drawerShape4 = drawerShape3;
            drawerContainerColor4 = drawerContainerColor3;
            drawerContentColor4 = drawerContentColor3;
            drawerTonalElevation4 = drawerTonalElevation3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$2
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
                    NavigationDrawerKt.m2244PermanentDrawerSheetafqeVBk(modifier3, drawerShape4, drawerContainerColor4, drawerContentColor4, drawerTonalElevation4, windowInsets4, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: DrawerSheet-vywBR7E, reason: not valid java name */
    public static final void m2241DrawerSheetvywBR7E(final WindowInsets windowInsets, Modifier modifier, Shape drawerShape, long drawerContainerColor, long drawerContentColor, float drawerTonalElevation, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape drawerShape2;
        long drawerContainerColor2;
        long drawerContentColor2;
        float f;
        float drawerTonalElevation2;
        int i2;
        long drawerContentColor3;
        long drawerContentColor4;
        Shape drawerShape3;
        Composer $composer2;
        final Shape drawerShape4;
        final Modifier modifier3;
        final long drawerContainerColor3;
        final long drawerContentColor5;
        final float drawerTonalElevation3;
        Composer $composer3 = $composer.startRestartGroup(175072821);
        ComposerKt.sourceInformation($composer3, "C(DrawerSheet)P(6,5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp)628@24134L14,629@24182L37,633@24349L667:NavigationDrawer.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(windowInsets) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            drawerShape2 = drawerShape;
        } else if (($changed & 384) == 0) {
            drawerShape2 = drawerShape;
            $dirty |= $composer3.changed(drawerShape2) ? 256 : 128;
        } else {
            drawerShape2 = drawerShape;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                drawerContainerColor2 = drawerContainerColor;
                int i5 = $composer3.changed(drawerContainerColor2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                drawerContainerColor2 = drawerContainerColor;
            }
            $dirty |= i5;
        } else {
            drawerContainerColor2 = drawerContainerColor;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                drawerContentColor2 = drawerContentColor;
                int i6 = $composer3.changed(drawerContentColor2) ? 16384 : 8192;
                $dirty |= i6;
            } else {
                drawerContentColor2 = drawerContentColor;
            }
            $dirty |= i6;
        } else {
            drawerContentColor2 = drawerContentColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            f = drawerTonalElevation;
        } else if ((196608 & $changed) == 0) {
            f = drawerTonalElevation;
            $dirty |= $composer3.changed(f) ? 131072 : 65536;
        } else {
            f = drawerTonalElevation;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 1048576 : 524288;
        }
        if (($dirty & 599187) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
            drawerContainerColor3 = drawerContainerColor2;
            drawerTonalElevation3 = f;
            drawerShape4 = drawerShape2;
            drawerContentColor5 = drawerContentColor2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i3 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    drawerShape2 = RectangleShapeKt.getRectangleShape();
                }
                if ((i & 8) != 0) {
                    drawerContainerColor2 = DrawerDefaults.INSTANCE.getContainerColor($composer3, 6);
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    drawerContentColor2 = ColorSchemeKt.m1935contentColorForek8zF_U(drawerContainerColor2, $composer3, ($dirty >> 9) & 14);
                    $dirty &= -57345;
                }
                if (i7 != 0) {
                    drawerTonalElevation2 = DrawerDefaults.INSTANCE.m2076getPermanentDrawerElevationD9Ej5fM();
                    drawerContentColor3 = drawerContentColor2;
                    i2 = 175072821;
                    drawerContentColor4 = drawerContainerColor2;
                    drawerShape3 = drawerShape2;
                } else {
                    drawerTonalElevation2 = f;
                    i2 = 175072821;
                    drawerContentColor3 = drawerContentColor2;
                    drawerContentColor4 = drawerContainerColor2;
                    drawerShape3 = drawerShape2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    drawerTonalElevation2 = f;
                    i2 = 175072821;
                    drawerContentColor3 = drawerContentColor2;
                    drawerContentColor4 = drawerContainerColor2;
                    drawerShape3 = drawerShape2;
                } else {
                    drawerTonalElevation2 = f;
                    i2 = 175072821;
                    drawerContentColor3 = drawerContentColor2;
                    drawerContentColor4 = drawerContainerColor2;
                    drawerShape3 = drawerShape2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:632)");
            }
            $composer2 = $composer3;
            SurfaceKt.m2519SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.m820sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m2074getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null), drawerShape3, drawerContentColor4, drawerContentColor3, drawerTonalElevation2, 0.0f, null, ComposableLambdaKt.composableLambda($composer3, 959363152, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x0168  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r25, int r26) {
                    /*
                        Method dump skipped, instructions count: 364
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, (($dirty >> 3) & 112) | 12582912 | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168) | (57344 & ($dirty >> 3)), 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            drawerShape4 = drawerShape3;
            modifier3 = modifier2;
            drawerContainerColor3 = drawerContentColor4;
            drawerContentColor5 = drawerContentColor3;
            drawerTonalElevation3 = drawerTonalElevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2
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
                    NavigationDrawerKt.m2241DrawerSheetvywBR7E(windowInsets, modifier3, drawerShape4, drawerContainerColor3, drawerContentColor5, drawerTonalElevation3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void NavigationDrawerItem(final Function2<? super Composer, ? super Integer, Unit> function2, final boolean selected, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, NavigationDrawerItemColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 function24;
        Function2 function25;
        Shape shape2;
        NavigationDrawerItemColors colors2;
        MutableInteractionSource mutableInteractionSource;
        Modifier.Companion modifier3;
        Function2 icon;
        Function2 badge;
        Shape shape3;
        int $dirty;
        NavigationDrawerItemColors colors3;
        MutableInteractionSource interactionSource2;
        Shape shape4;
        int $dirty2;
        Object value$iv;
        Composer $composer2;
        final Shape shape5;
        final MutableInteractionSource interactionSource3;
        final NavigationDrawerItemColors colors4;
        final Modifier modifier4;
        final Function2 icon2;
        final Function2 badge2;
        Composer $composer3 = $composer.startRestartGroup(-1304626543);
        ComposerKt.sourceInformation($composer3, "C(NavigationDrawerItem)P(4,7,6,5,2!1,8)729@28081L5,730@28158L8,731@28218L39,741@28543L24,733@28266L1246:NavigationDrawer.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changed(selected) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty3 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty3 |= 24576;
            function24 = function22;
        } else if (($changed & 24576) == 0) {
            function24 = function22;
            $dirty3 |= $composer3.changedInstance(function24) ? 16384 : 8192;
        } else {
            function24 = function22;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            function25 = function23;
        } else if ((196608 & $changed) == 0) {
            function25 = function23;
            $dirty3 |= $composer3.changedInstance(function25) ? 131072 : 65536;
        } else {
            function25 = function23;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                shape2 = shape;
                int i5 = $composer3.changed(shape2) ? 1048576 : 524288;
                $dirty3 |= i5;
            } else {
                shape2 = shape;
            }
            $dirty3 |= i5;
        } else {
            shape2 = shape;
        }
        if ((12582912 & $changed) == 0) {
            if ((i & 128) == 0) {
                colors2 = colors;
                int i6 = $composer3.changed(colors2) ? 8388608 : 4194304;
                $dirty3 |= i6;
            } else {
                colors2 = colors;
            }
            $dirty3 |= i6;
        } else {
            colors2 = colors;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty3 |= 100663296;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 100663296) == 0) {
            mutableInteractionSource = interactionSource;
            $dirty3 |= $composer3.changed(mutableInteractionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            mutableInteractionSource = interactionSource;
        }
        if (($dirty3 & 38347923) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            interactionSource3 = mutableInteractionSource;
            modifier4 = modifier2;
            icon2 = function24;
            badge2 = function25;
            shape5 = shape2;
            $composer2 = $composer3;
            colors4 = colors2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                icon = i3 != 0 ? null : function24;
                badge = i4 != 0 ? null : function25;
                if ((i & 64) != 0) {
                    shape3 = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), $composer3, 6);
                    $dirty = $dirty3 & (-3670017);
                } else {
                    shape3 = shape2;
                    $dirty = $dirty3;
                }
                if ((i & 128) != 0) {
                    colors3 = NavigationDrawerItemDefaults.INSTANCE.m2239colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer3, 100663296, 255);
                    $composer3 = $composer3;
                    $dirty &= -29360129;
                } else {
                    colors3 = colors;
                }
                if (i7 != 0) {
                    $composer3.startReplaceableGroup(111536735);
                    ComposerKt.sourceInformation($composer3, "CC(remember):NavigationDrawer.kt#9igjgp");
                    Composer $this$cache$iv = $composer3;
                    Object it$iv = $this$cache$iv.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    colors2 = colors3;
                    shape4 = shape3;
                    $dirty2 = $dirty;
                } else {
                    interactionSource2 = interactionSource;
                    colors2 = colors3;
                    shape4 = shape3;
                    $dirty2 = $dirty;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty2 = $dirty3 & (-29360129);
                    modifier3 = modifier2;
                    icon = function24;
                    badge = function25;
                    shape4 = shape2;
                    interactionSource2 = mutableInteractionSource;
                } else {
                    $dirty2 = $dirty3;
                    modifier3 = modifier2;
                    icon = function24;
                    badge = function25;
                    shape4 = shape2;
                    interactionSource2 = mutableInteractionSource;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1304626543, $dirty2, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:732)");
            }
            final NavigationDrawerItemColors colors5 = colors2;
            final Function2 icon3 = icon;
            final Function2 badge3 = badge;
            Modifier modifier5 = modifier3;
            SurfaceKt.m2520Surfaced85dljk(selected, function0, SizeKt.fillMaxWidth$default(SizeKt.m802height3ABfNKs(SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt.NavigationDrawerItem.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m5618setRolekuIjeqM($this$semantics, Role.INSTANCE.m5608getTabo7Vup1c());
                }
            }, 1, null), NavigationDrawerTokens.INSTANCE.m3167getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, colors2.containerColor(selected, $composer3, (($dirty2 >> 3) & 14) | (($dirty2 >> 18) & 112)).getValue().m3959unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, interactionSource2, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer3, 191488423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt.NavigationDrawerItem.3
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x017d  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x01b9  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0236  */
                /* JADX WARN: Removed duplicated region for block: B:35:0x0242  */
                /* JADX WARN: Removed duplicated region for block: B:36:0x0248  */
                /* JADX WARN: Removed duplicated region for block: B:47:0x033f  */
                /* JADX WARN: Removed duplicated region for block: B:50:0x0394  */
                /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r54, int r55) {
                    /*
                        Method dump skipped, instructions count: 920
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.C14283.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer3, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 6) & 57344), (($dirty2 >> 24) & 14) | 48, 968);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape5 = shape4;
            interactionSource3 = interactionSource2;
            colors4 = colors5;
            modifier4 = modifier5;
            icon2 = icon;
            badge2 = badge;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt.NavigationDrawerItem.4
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
                    NavigationDrawerKt.NavigationDrawerItem(function2, selected, function0, modifier4, icon2, badge2, shape5, colors4, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float a, float b, float pos) {
        return RangesKt.coerceIn((pos - a) / (b - a), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-Bx497Mc, reason: not valid java name */
    public static final void m2245ScrimBx497Mc(final boolean open, final Function0<Unit> function0, final Function0<Float> function02, final long color, Composer $composer, final int $changed) {
        Modifier.Companion dismissDrawer;
        Object value$iv;
        NavigationDrawerKt$Scrim$dismissDrawer$1$1 value$iv2;
        Object value$iv3;
        Composer $composer2 = $composer.startRestartGroup(2106487387);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)919@35520L30,935@35964L51,931@35873L142:NavigationDrawer.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(open) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(color) ? 2048 : 1024;
        }
        if (($dirty & 1171) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106487387, $dirty, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:918)");
            }
            Strings.Companion companion = Strings.INSTANCE;
            final String closeDrawer = Strings_androidKt.m2509getStringNWtq28(Strings.m2440constructorimpl(C1740R.string.close_drawer), $composer2, 0);
            $composer2.startReplaceableGroup(-1858700652);
            ComposerKt.sourceInformation($composer2, "922@35639L35,923@35723L108");
            if (open) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                $composer2.startReplaceableGroup(-1858700588);
                ComposerKt.sourceInformation($composer2, "CC(remember):NavigationDrawer.kt#9igjgp");
                boolean invalid$iv = ($dirty & 112) == 32;
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new NavigationDrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    $composer2.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv;
                }
                $composer2.endReplaceableGroup();
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2);
                $composer2.startReplaceableGroup(-1858700504);
                ComposerKt.sourceInformation($composer2, "CC(remember):NavigationDrawer.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changed(closeDrawer) | (($dirty & 112) == 32);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                            SemanticsPropertiesKt.setContentDescription($this$semantics, closeDrawer);
                            final Function0<Unit> function03 = function0;
                            SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    function03.invoke();
                                    return true;
                                }
                            }, 1, null);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv2;
                }
                $composer2.endReplaceableGroup();
                dismissDrawer = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) value$iv3);
            } else {
                dismissDrawer = Modifier.INSTANCE;
            }
            $composer2.endReplaceableGroup();
            Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissDrawer);
            $composer2.startReplaceableGroup(-1858700263);
            ComposerKt.sourceInformation($composer2, "CC(remember):NavigationDrawer.kt#9igjgp");
            boolean invalid$iv3 = (($dirty & 7168) == 2048) | (($dirty & 896) == 256);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope $this$Canvas) {
                        DrawScope.m4493drawRectnJ9OG0$default($this$Canvas, color, 0L, 0L, function02.invoke().floatValue(), null, null, 0, 118, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv3;
            }
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(modifierThen, (Function1) value$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    NavigationDrawerKt.m2245ScrimBx497Mc(open, function0, function02, color, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
