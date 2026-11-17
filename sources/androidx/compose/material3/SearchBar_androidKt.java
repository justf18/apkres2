package androidx.compose.material3;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.ZIndexModifierKt;
import androidx.compose.p000ui.focus.FocusManager;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SearchBar.android.kt */
@Metadata(m164d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0087\u0002\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\u00102\b\b\u0002\u00109\u001a\u00020:2\u001c\u0010;\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b=H\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u0091\u0002\u0010@\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u00109\u001a\u00020:2\u001c\u0010;\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b=H\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001aÆ\u0001\u0010E\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00105\u001a\u00020F2\b\b\u0002\u00109\u001a\u00020:H\u0003¢\u0006\u0002\u0010G\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0018\u001a\u00020\u0010X\u0082\u0004¢\u0006\n\n\u0002\u0010\u0013\u0012\u0004\b\u0019\u0010\u001a\"\u0010\u0010\u001b\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013\"\u0010\u0010\u001c\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013\"\u0016\u0010\u001d\u001a\u00020\u0010X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012\"\u0016\u0010\u001f\u001a\u00020\u0010X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b \u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H²\u0006\n\u0010I\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020)X\u008a\u0084\u0002"}, m165d2 = {"AnimationDelayMillis", "", "AnimationEnterDurationMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitDurationMillis", "AnimationExitEasing", "AnimationExitFloatSpec", "AnimationExitSizeSpec", "DockedActiveTableMaxHeightScreenRatio", "DockedActiveTableMinHeight", "Landroidx/compose/ui/unit/Dp;", "getDockedActiveTableMinHeight", "()F", "F", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "SearchBarIconOffsetX", "SearchBarMaxWidth", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "DockedSearchBar", "", "query", "", "onQueryChange", "Lkotlin/Function1;", "onSearch", "active", "", "onActiveChange", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "placeholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "shadowElevation", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "SearchBar-WuY5d9Q", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarInputField", "Landroidx/compose/material3/TextFieldColors;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "material3_release", "useFullScreenShape", "showResults"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SearchBar_androidKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    private static final float DockedActiveTableMaxHeightScreenRatio = 0.6666667f;
    private static final float DockedActiveTableMinHeight;
    private static final EnterTransition DockedEnterTransition;
    private static final ExitTransition DockedExitTransition;
    private static final float SearchBarCornerRadius;
    private static final float SearchBarIconOffsetX;
    private static final float SearchBarMaxWidth;
    private static final float SearchBarMinWidth;
    private static final float SearchBarVerticalPadding;

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:325:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0731  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0733  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x073e  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x074b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0771  */
    /* renamed from: SearchBar-WuY5d9Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2341SearchBarWuY5d9Q(final java.lang.String r42, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r43, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r44, boolean r45, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r46, androidx.compose.p000ui.Modifier r47, boolean r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.p000ui.graphics.Shape r52, androidx.compose.material3.SearchBarColors r53, float r54, float r55, androidx.compose.foundation.layout.WindowInsets r56, androidx.compose.foundation.interaction.MutableInteractionSource r57, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, androidx.compose.runtime.Composer r59, final int r60, final int r61, final int r62) {
        /*
            Method dump skipped, instructions count: 1970
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.m2341SearchBarWuY5d9Q(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final boolean SearchBar_WuY5d9Q$lambda$2(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* renamed from: DockedSearchBar-eWTbjVg, reason: not valid java name */
    public static final void m2340DockedSearchBareWTbjVg(final String query, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, boolean active, Function1<? super Boolean, Unit> function13, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SearchBarColors colors, float tonalElevation, float shadowElevation, MutableInteractionSource interactionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function1<? super String, Unit> function14;
        boolean z;
        Function2 function24;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Shape shape2;
        int $dirty1;
        SearchBarColors colors2;
        String str;
        Modifier modifier2;
        int $dirty12;
        final boolean enabled2;
        final Function2 placeholder;
        final Function2 placeholder2;
        final Function2 trailingIcon;
        float tonalElevation2;
        float shadowElevation2;
        Shape shape3;
        final SearchBarColors colors3;
        final MutableInteractionSource interactionSource2;
        Object value$iv;
        Composer $composer2;
        SearchBar_androidKt$DockedSearchBar$3$1 value$iv2;
        Object value$iv3;
        final SearchBarColors colors4;
        final MutableInteractionSource interactionSource3;
        final Shape shape4;
        final float tonalElevation3;
        final float shadowElevation3;
        final Function2 trailingIcon2;
        final Function2 trailingIcon3;
        final Function2 leadingIcon;
        final boolean enabled3;
        final Modifier modifier3;
        final boolean z2 = active;
        final Function1<? super Boolean, Unit> function15 = function13;
        Composer $composer3 = $composer.startRestartGroup(1299054533);
        ComposerKt.sourceInformation($composer3, "C(DockedSearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,4)358@17745L11,359@17806L8,362@17986L39,365@18121L7,370@18228L38,367@18134L1617,413@19791L25,415@19898L292,415@19875L315,424@20226L37,424@20196L67:SearchBar.android.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty13 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(query) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
            function14 = function12;
        } else if (($changed & 384) == 0) {
            function14 = function12;
            $dirty |= $composer3.changedInstance(function14) ? 256 : 128;
        } else {
            function14 = function12;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(z2) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function15) ? 16384 : 8192;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            $dirty |= $composer3.changed(modifier) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
            z = enabled;
        } else if (($changed & 1572864) == 0) {
            z = enabled;
            $dirty |= $composer3.changed(z) ? 1048576 : 524288;
        } else {
            z = enabled;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
            function24 = function2;
        } else if (($changed & 12582912) == 0) {
            function24 = function2;
            $dirty |= $composer3.changedInstance(function24) ? 8388608 : 4194304;
        } else {
            function24 = function2;
        }
        int i10 = i & 256;
        if (i10 != 0) {
            $dirty |= 100663296;
            i2 = i10;
        } else if (($changed & 100663296) == 0) {
            i2 = i10;
            $dirty |= $composer3.changedInstance(function22) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i10;
        }
        int i11 = i & 512;
        if (i11 != 0) {
            $dirty |= 805306368;
            i3 = i11;
        } else if (($changed & 805306368) == 0) {
            i3 = i11;
            $dirty |= $composer3.changedInstance(function23) ? 536870912 : 268435456;
        } else {
            i3 = i11;
        }
        if (($changed1 & 6) == 0) {
            $dirty13 |= ((i & 1024) == 0 && $composer3.changed(shape)) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty13 |= ((i & 2048) == 0 && $composer3.changed(colors)) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty13 |= 384;
            i4 = i12;
        } else {
            i4 = i12;
            if (($changed1 & 384) == 0) {
                $dirty13 |= $composer3.changed(tonalElevation) ? 256 : 128;
            }
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty13 |= 3072;
            i5 = i13;
        } else {
            i5 = i13;
            if (($changed1 & 3072) == 0) {
                $dirty13 |= $composer3.changed(shadowElevation) ? 2048 : 1024;
            }
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty13 |= 24576;
            i6 = i14;
        } else {
            i6 = i14;
            if (($changed1 & 24576) == 0) {
                $dirty13 |= $composer3.changed(interactionSource) ? 16384 : 8192;
            }
        }
        if ((i & 32768) != 0) {
            $dirty13 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            $dirty13 |= $composer3.changedInstance(function3) ? 131072 : 65536;
        }
        int $dirty14 = $dirty13;
        if (($dirty & 306783379) == 306783378 && ($dirty14 & 74899) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            trailingIcon3 = function22;
            trailingIcon2 = function23;
            colors4 = colors;
            tonalElevation3 = tonalElevation;
            shadowElevation3 = shadowElevation;
            interactionSource3 = interactionSource;
            $composer2 = $composer3;
            enabled3 = z;
            leadingIcon = function24;
            shape4 = shape;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i7 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i8 != 0 ? true : z;
                Function2 placeholder3 = i9 != 0 ? null : function24;
                Function2 leadingIcon2 = i2 != 0 ? null : function22;
                Function2 trailingIcon4 = i3 != 0 ? null : function23;
                Modifier modifier5 = modifier4;
                if ((i & 1024) != 0) {
                    shape2 = SearchBarDefaults.INSTANCE.getDockedShape($composer3, 6);
                    $dirty1 = $dirty14 & (-15);
                } else {
                    shape2 = shape;
                    $dirty1 = $dirty14;
                }
                Shape shape5 = shape2;
                if ((i & 2048) != 0) {
                    colors2 = SearchBarDefaults.INSTANCE.m2333colorsKlgxPg(0L, 0L, null, $composer3, 3072, 7);
                    $dirty1 &= -113;
                } else {
                    colors2 = colors;
                }
                float tonalElevation4 = i4 != 0 ? SearchBarDefaults.INSTANCE.m2337getTonalElevationD9Ej5fM() : tonalElevation;
                float shadowElevation4 = i5 != 0 ? SearchBarDefaults.INSTANCE.m2336getShadowElevationD9Ej5fM() : shadowElevation;
                if (i6 != 0) {
                    SearchBarColors colors5 = colors2;
                    $composer3.startReplaceableGroup(-32072212);
                    ComposerKt.sourceInformation($composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    str = "CC(remember):SearchBar.android.kt#9igjgp";
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    MutableInteractionSource interactionSource4 = (MutableInteractionSource) value$iv;
                    $composer3.endReplaceableGroup();
                    $dirty12 = $dirty1;
                    enabled2 = enabled4;
                    placeholder = placeholder3;
                    placeholder2 = leadingIcon2;
                    trailingIcon = trailingIcon4;
                    tonalElevation2 = tonalElevation4;
                    shadowElevation2 = shadowElevation4;
                    shape3 = shape5;
                    colors3 = colors5;
                    interactionSource2 = interactionSource4;
                    modifier2 = modifier5;
                } else {
                    SearchBarColors colors6 = colors2;
                    str = "CC(remember):SearchBar.android.kt#9igjgp";
                    modifier2 = modifier5;
                    $dirty12 = $dirty1;
                    enabled2 = enabled4;
                    placeholder = placeholder3;
                    placeholder2 = leadingIcon2;
                    trailingIcon = trailingIcon4;
                    tonalElevation2 = tonalElevation4;
                    shadowElevation2 = shadowElevation4;
                    shape3 = shape5;
                    colors3 = colors6;
                    interactionSource2 = interactionSource;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 1024) != 0) {
                    $dirty14 &= -15;
                }
                if ((i & 2048) != 0) {
                    trailingIcon = function23;
                    shape3 = shape;
                    colors3 = colors;
                    tonalElevation2 = tonalElevation;
                    shadowElevation2 = shadowElevation;
                    str = "CC(remember):SearchBar.android.kt#9igjgp";
                    enabled2 = z;
                    placeholder = function24;
                    placeholder2 = function22;
                    interactionSource2 = interactionSource;
                    $dirty12 = $dirty14 & (-113);
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    trailingIcon = function23;
                    shape3 = shape;
                    colors3 = colors;
                    tonalElevation2 = tonalElevation;
                    shadowElevation2 = shadowElevation;
                    str = "CC(remember):SearchBar.android.kt#9igjgp";
                    enabled2 = z;
                    placeholder = function24;
                    $dirty12 = $dirty14;
                    placeholder2 = function22;
                    interactionSource2 = interactionSource;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1299054533, $dirty, $dirty12, "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:364)");
            }
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            int $dirty2 = $dirty;
            int $dirty15 = $dirty12;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            FocusManager focusManager = (FocusManager) objConsume;
            Modifier modifier6 = modifier2;
            function15 = function13;
            String str2 = str;
            final Function1<? super String, Unit> function16 = function14;
            z2 = active;
            SurfaceKt.m2519SurfaceT9BRK9s(SizeKt.m821width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth), shape3, colors3.getContainerColor(), ColorSchemeKt.m1935contentColorForek8zF_U(colors3.getContainerColor(), $composer3, 0), tonalElevation2, shadowElevation2, null, ComposableLambdaKt.composableLambda($composer3, 1088676554, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x01d7  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r40, int r41) {
                    /*
                        Method dump skipped, instructions count: 475
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer3, (($dirty15 << 3) & 112) | 12582912 | (($dirty15 << 6) & 57344) | (($dirty15 << 6) & 458752), 64);
            $composer2 = $composer3;
            boolean isFocused = FocusInteractionKt.collectIsFocusedAsState(interactionSource2, $composer2, ($dirty15 >> 12) & 14).getValue().booleanValue();
            boolean shouldClearFocus = !z2 && isFocused;
            Boolean boolValueOf = Boolean.valueOf(z2);
            $composer2.startReplaceableGroup(-32070300);
            ComposerKt.sourceInformation($composer2, str2);
            boolean invalid$iv = $composer2.changed(shouldClearFocus) | $composer2.changedInstance(focusManager);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new SearchBar_androidKt$DockedSearchBar$3$1(shouldClearFocus, focusManager, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer2, ($dirty2 >> 9) & 14);
            $composer2.startReplaceableGroup(-32069972);
            ComposerKt.sourceInformation($composer2, str2);
            boolean invalid$iv2 = ($dirty2 & 57344) == 16384;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        function15.invoke(false);
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            $composer2.endReplaceableGroup();
            BackHandlerKt.BackHandler(z2, (Function0) value$iv3, $composer2, ($dirty2 >> 9) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors4 = colors3;
            interactionSource3 = interactionSource2;
            shape4 = shape3;
            tonalElevation3 = tonalElevation2;
            shadowElevation3 = shadowElevation2;
            trailingIcon2 = trailingIcon;
            trailingIcon3 = placeholder2;
            leadingIcon = placeholder;
            enabled3 = enabled2;
            modifier3 = modifier6;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$5
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

                public final void invoke(Composer composer, int i15) {
                    SearchBar_androidKt.m2340DockedSearchBareWTbjVg(query, function1, function12, z2, function15, modifier3, enabled3, leadingIcon, trailingIcon3, trailingIcon2, shape4, colors4, tonalElevation3, shadowElevation3, interactionSource3, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:230:0x05bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void SearchBarInputField(final java.lang.String r78, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r79, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r80, final boolean r81, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r82, androidx.compose.p000ui.Modifier r83, boolean r84, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r85, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r86, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r87, androidx.compose.material3.TextFieldColors r88, androidx.compose.foundation.interaction.MutableInteractionSource r89, androidx.compose.runtime.Composer r90, final int r91, final int r92, final int r93) {
        /*
            Method dump skipped, instructions count: 1521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt.SearchBarInputField(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    static {
        float arg0$iv = SearchBarDefaults.INSTANCE.m2335getInputFieldHeightD9Ej5fM();
        SearchBarCornerRadius = C1956Dp.m6297constructorimpl(arg0$iv / 2);
        DockedActiveTableMinHeight = C1956Dp.m6297constructorimpl(240);
        SearchBarMinWidth = C1956Dp.m6297constructorimpl(360);
        SearchBarMaxWidth = C1956Dp.m6297constructorimpl(720);
        SearchBarVerticalPadding = C1956Dp.m6297constructorimpl(8);
        SearchBarIconOffsetX = C1956Dp.m6297constructorimpl(4);
        AnimationEnterEasing = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationExitEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationEnterFloatSpec = AnimationSpecKt.tween(600, 100, AnimationEnterEasing);
        AnimationExitFloatSpec = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, AnimationExitEasing);
        AnimationEnterSizeSpec = AnimationSpecKt.tween(600, 100, AnimationEnterEasing);
        AnimationExitSizeSpec = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, AnimationExitEasing);
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(AnimationEnterFloatSpec, 0.0f, 2, null).plus(EnterExitTransitionKt.expandVertically$default(AnimationEnterSizeSpec, null, false, null, 14, null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(AnimationExitFloatSpec, 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkVertically$default(AnimationExitSizeSpec, null, false, null, 14, null));
    }

    public static final float getDockedActiveTableMinHeight() {
        return DockedActiveTableMinHeight;
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }
}
