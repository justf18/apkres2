package androidx.compose.foundation.text2;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text2.input.CodepointTransformation;
import androidx.compose.foundation.text2.input.CodepointTransformationKt;
import androidx.compose.foundation.text2.input.ImeActionHandler;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.InputTransformationKt;
import androidx.compose.foundation.text2.input.TextFieldLineLimits;
import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.foundation.text2.input.TextObfuscationMode;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.TextToolbar;
import androidx.compose.p000ui.platform.TextToolbarStatus;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.input.ImeAction;
import androidx.compose.p000ui.text.input.KeyboardType;
import androidx.compose.p000ui.text.input.TextFieldValue;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.Typography;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BasicSecureTextField.kt */
@Metadata(m164d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u001aÔ\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u001928\b\u0002\u0010\u001a\u001a2\u0012\u0004\u0012\u00020\u001c\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b¢\u0006\u0002\b\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aè\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00030,2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u001928\b\u0002\u0010\u001a\u001a2\u0012\u0004\u0012\u00020\u001c\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b¢\u0006\u0002\b\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a \u0010/\u001a\u00020\u00032\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020\u00030\u001d¢\u0006\u0002\b1H\u0003¢\u0006\u0002\u00102\u001a\u0010\u00103\u001a\u0002042\u0006\u0010\b\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065²\u0006\n\u00106\u001a\u000207X\u008a\u008e\u0002"}, m165d2 = {"LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "BasicSecureTextField", "", "state", "Landroidx/compose/foundation/text2/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "onSubmit", "Landroidx/compose/foundation/text2/input/ImeActionHandler;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "textObfuscationMode", "Landroidx/compose/foundation/text2/input/TextObfuscationMode;", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "enabled", "", "inputTransformation", "Landroidx/compose/foundation/text2/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "getResult", "Lkotlin/ExtensionFunctionType;", "decorator", "Landroidx/compose/foundation/text2/TextFieldDecorator;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "BasicSecureTextField-mMrxcSU", "(Landroidx/compose/foundation/text2/input/TextFieldState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text2/input/ImeActionHandler;IIIZLandroidx/compose/foundation/text2/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text2/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "value", "", "onValueChange", "Lkotlin/Function1;", "BasicSecureTextField-TLP4tmw", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text2/input/ImeActionHandler;IIIZLandroidx/compose/foundation/text2/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text2/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "DisableCutCopy", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "KeyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "foundation_release", "valueWithSelection", "Landroidx/compose/ui/text/input/TextFieldValue;"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BasicSecureTextFieldKt {
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;

    /* JADX WARN: Removed duplicated region for block: B:239:0x04e7  */
    /* renamed from: BasicSecureTextField-TLP4tmw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1274BasicSecureTextFieldTLP4tmw(final java.lang.String r38, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r39, androidx.compose.p000ui.Modifier r40, androidx.compose.foundation.text2.input.ImeActionHandler r41, int r42, int r43, int r44, boolean r45, androidx.compose.foundation.text2.input.InputTransformation r46, androidx.compose.p000ui.text.TextStyle r47, androidx.compose.foundation.interaction.MutableInteractionSource r48, androidx.compose.p000ui.graphics.Brush r49, kotlin.jvm.functions.Function2<? super androidx.compose.p000ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.p000ui.text.TextLayoutResult>, kotlin.Unit> r50, androidx.compose.foundation.text2.TextFieldDecorator r51, androidx.compose.foundation.ScrollState r52, androidx.compose.runtime.Composer r53, final int r54, final int r55, final int r56) {
        /*
            Method dump skipped, instructions count: 1305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.BasicSecureTextFieldKt.m1274BasicSecureTextFieldTLP4tmw(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.foundation.text2.input.ImeActionHandler, int, int, int, boolean, androidx.compose.foundation.text2.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function2, androidx.compose.foundation.text2.TextFieldDecorator, androidx.compose.foundation.ScrollState, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue BasicSecureTextField_TLP4tmw$lambda$2(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* renamed from: BasicSecureTextField-mMrxcSU, reason: not valid java name */
    public static final void m1275BasicSecureTextFieldmMrxcSU(final TextFieldState state, Modifier modifier, ImeActionHandler onSubmit, int imeAction, int textObfuscationMode, int keyboardType, boolean enabled, InputTransformation inputTransformation, TextStyle textStyle, MutableInteractionSource interactionSource, Brush cursorBrush, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, TextFieldDecorator decorator, ScrollState scrollState, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        ImeActionHandler onSubmit2;
        int imeAction2;
        int i2;
        int i3;
        boolean enabled2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int textObfuscationMode2;
        Modifier modifier3;
        ImeActionHandler onSubmit3;
        SolidColor cursorBrush2;
        final ImeActionHandler onSubmit4;
        final ScrollState scrollState2;
        final Brush cursorBrush3;
        final Function2 onTextLayout;
        final TextFieldDecorator decorator2;
        final int imeAction3;
        final int keyboardType2;
        final InputTransformation inputTransformation2;
        final TextStyle textStyle2;
        final MutableInteractionSource interactionSource2;
        final boolean enabled3;
        int i10;
        Object value$iv$iv$iv;
        Object value$iv$iv;
        Composer $composer2;
        int $dirty;
        final Modifier modifier4;
        final InputTransformation inputTransformation3;
        final int keyboardType3;
        final int $dirty2;
        final ImeActionHandler onSubmit5;
        final boolean enabled4;
        final Function2 onTextLayout2;
        final MutableInteractionSource interactionSource3;
        final Brush cursorBrush4;
        final TextFieldDecorator decorator3;
        final ScrollState scrollState3;
        final int $dirty1;
        final TextStyle textStyle3;
        Composer $composer3 = $composer.startRestartGroup(1073441926);
        ComposerKt.sourceInformation($composer3, "C(BasicSecureTextField)P(11,7,8,3:c#ui.text.input.ImeAction,12:c#foundation.text2.input.TextObfuscationMode,6:c#ui.text.input.KeyboardType,2,4,13,5!1,9)277@16038L21,281@16205L24,282@16266L82,322@17467L1064:BasicSecureTextField.kt#g98mwb");
        int $dirty3 = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(state) ? 4 : 2;
        }
        int i11 = i & 2;
        if (i11 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i12 = i & 4;
        if (i12 != 0) {
            $dirty3 |= 384;
            onSubmit2 = onSubmit;
        } else if (($changed & 896) == 0) {
            onSubmit2 = onSubmit;
            $dirty3 |= $composer3.changed(onSubmit2) ? 256 : 128;
        } else {
            onSubmit2 = onSubmit;
        }
        int i13 = i & 8;
        if (i13 != 0) {
            $dirty3 |= 3072;
            imeAction2 = imeAction;
        } else if (($changed & 7168) == 0) {
            imeAction2 = imeAction;
            $dirty3 |= $composer3.changed(imeAction2) ? 2048 : 1024;
        } else {
            imeAction2 = imeAction;
        }
        int i14 = i & 16;
        if (i14 != 0) {
            $dirty3 |= 24576;
            i2 = textObfuscationMode;
        } else if (($changed & 57344) == 0) {
            i2 = textObfuscationMode;
            $dirty3 |= $composer3.changed(i2) ? 16384 : 8192;
        } else {
            i2 = textObfuscationMode;
        }
        int i15 = i & 32;
        if (i15 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            i3 = keyboardType;
        } else if (($changed & 458752) == 0) {
            i3 = keyboardType;
            $dirty3 |= $composer3.changed(i3) ? 131072 : 65536;
        } else {
            i3 = keyboardType;
        }
        int i16 = i & 64;
        if (i16 != 0) {
            $dirty3 |= 1572864;
            enabled2 = enabled;
        } else if (($changed & 3670016) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 1048576 : 524288;
        } else {
            enabled2 = enabled;
        }
        int i17 = i & 128;
        if (i17 != 0) {
            $dirty3 |= 12582912;
            i4 = i17;
        } else if (($changed & 29360128) == 0) {
            i4 = i17;
            $dirty3 |= $composer3.changed(inputTransformation) ? 8388608 : 4194304;
        } else {
            i4 = i17;
        }
        int i18 = i & 256;
        if (i18 != 0) {
            $dirty3 |= 100663296;
            i5 = i18;
        } else if (($changed & 234881024) == 0) {
            i5 = i18;
            $dirty3 |= $composer3.changed(textStyle) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i5 = i18;
        }
        int i19 = i & 512;
        if (i19 != 0) {
            $dirty3 |= 805306368;
            i6 = i19;
        } else if (($changed & 1879048192) == 0) {
            i6 = i19;
            $dirty3 |= $composer3.changed(interactionSource) ? 536870912 : 268435456;
        } else {
            i6 = i19;
        }
        int i20 = i & 1024;
        if (i20 != 0) {
            $dirty12 |= 6;
            i7 = i20;
        } else if (($changed1 & 14) == 0) {
            i7 = i20;
            $dirty12 |= $composer3.changed(cursorBrush) ? 4 : 2;
        } else {
            i7 = i20;
        }
        int i21 = i & 2048;
        if (i21 != 0) {
            $dirty12 |= 48;
            i8 = i21;
        } else if (($changed1 & 112) == 0) {
            i8 = i21;
            $dirty12 |= $composer3.changedInstance(function2) ? 32 : 16;
        } else {
            i8 = i21;
        }
        int i22 = i & 4096;
        if (i22 != 0) {
            $dirty12 |= 384;
            i9 = i22;
        } else {
            i9 = i22;
            if (($changed1 & 896) == 0) {
                $dirty12 |= $composer3.changed(decorator) ? 256 : 128;
            }
        }
        if (($changed1 & 7168) == 0) {
            $dirty12 |= ((i & 8192) == 0 && $composer3.changed(scrollState)) ? 2048 : 1024;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty12 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            textStyle3 = textStyle;
            decorator3 = decorator;
            $composer2 = $composer3;
            $dirty = $dirty3;
            onSubmit5 = onSubmit2;
            $dirty2 = imeAction2;
            $dirty1 = i2;
            keyboardType3 = i3;
            modifier4 = modifier2;
            enabled4 = enabled2;
            inputTransformation3 = inputTransformation;
            interactionSource3 = interactionSource;
            cursorBrush4 = cursorBrush;
            onTextLayout2 = function2;
            scrollState3 = scrollState;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i11 != 0 ? Modifier.INSTANCE : modifier2;
                if (i12 != 0) {
                    onSubmit2 = null;
                }
                if (i13 != 0) {
                    imeAction2 = ImeAction.INSTANCE.m5950getDefaulteUduSuo();
                }
                textObfuscationMode2 = i14 != 0 ? TextObfuscationMode.INSTANCE.m1304getRevealLastTypedpyid5Pk() : i2;
                int keyboardType4 = i15 != 0 ? KeyboardType.INSTANCE.m6003getPasswordPjHm6EE() : i3;
                if (i16 != 0) {
                    enabled2 = true;
                }
                InputTransformation inputTransformation4 = i4 != 0 ? null : inputTransformation;
                TextStyle textStyle4 = i5 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                MutableInteractionSource interactionSource4 = i6 != 0 ? null : interactionSource;
                if (i7 != 0) {
                    onSubmit3 = onSubmit2;
                    modifier3 = modifier5;
                    cursorBrush2 = new SolidColor(Color.INSTANCE.m3975getBlack0d7_KjU(), null);
                } else {
                    modifier3 = modifier5;
                    onSubmit3 = onSubmit2;
                    cursorBrush2 = cursorBrush;
                }
                Function2 onTextLayout3 = i8 != 0 ? null : function2;
                TextFieldDecorator decorator4 = i9 != 0 ? null : decorator;
                if ((i & 8192) != 0) {
                    $dirty12 &= -7169;
                    onSubmit4 = onSubmit3;
                    cursorBrush3 = cursorBrush2;
                    onTextLayout = onTextLayout3;
                    decorator2 = decorator4;
                    imeAction3 = imeAction2;
                    keyboardType2 = keyboardType4;
                    textStyle2 = textStyle4;
                    interactionSource2 = interactionSource4;
                    enabled3 = enabled2;
                    modifier2 = modifier3;
                    scrollState2 = ScrollKt.rememberScrollState(0, $composer3, 0, 1);
                    i10 = 1073441926;
                    inputTransformation2 = inputTransformation4;
                } else {
                    onSubmit4 = onSubmit3;
                    scrollState2 = scrollState;
                    cursorBrush3 = cursorBrush2;
                    onTextLayout = onTextLayout3;
                    decorator2 = decorator4;
                    imeAction3 = imeAction2;
                    keyboardType2 = keyboardType4;
                    inputTransformation2 = inputTransformation4;
                    textStyle2 = textStyle4;
                    interactionSource2 = interactionSource4;
                    enabled3 = enabled2;
                    modifier2 = modifier3;
                    i10 = 1073441926;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8192) != 0) {
                    $dirty12 &= -7169;
                }
                inputTransformation2 = inputTransformation;
                textStyle2 = textStyle;
                interactionSource2 = interactionSource;
                cursorBrush3 = cursorBrush;
                onTextLayout = function2;
                decorator2 = decorator;
                scrollState2 = scrollState;
                onSubmit4 = onSubmit2;
                imeAction3 = imeAction2;
                textObfuscationMode2 = i2;
                keyboardType2 = i3;
                enabled3 = enabled2;
                i10 = 1073441926;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i10, $dirty3, $dirty12, "androidx.compose.foundation.text2.BasicSecureTextField (BasicSecureTextField.kt:280)");
            }
            $composer3.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation($composer3, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                $composer3.updateRememberedValue(value$iv$iv$iv);
            } else {
                value$iv$iv$iv = it$iv$iv$iv;
            }
            $composer3.endReplaceableGroup();
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
            CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer3.changed(coroutineScope);
            Object it$iv$iv = $composer3.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new SecureTextFieldController(coroutineScope);
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer3.endReplaceableGroup();
            final SecureTextFieldController secureTextFieldController = (SecureTextFieldController) value$iv$iv;
            final boolean revealLastTypedEnabled = TextObfuscationMode.m1299equalsimpl0(textObfuscationMode2, TextObfuscationMode.INSTANCE.m1304getRevealLastTypedpyid5Pk());
            if (!revealLastTypedEnabled) {
                secureTextFieldController.getPasswordRevealFilter().hide();
            }
            final CodepointTransformation codepointTransformation = revealLastTypedEnabled ? secureTextFieldController.getCodepointTransformation() : TextObfuscationMode.m1299equalsimpl0(textObfuscationMode2, TextObfuscationMode.INSTANCE.m1303getHiddenpyid5Pk()) ? CodepointTransformationKt.mask(CodepointTransformation.INSTANCE, Typography.bullet) : null;
            final Modifier secureTextFieldModifier = SemanticsModifierKt.semantics(modifier2, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.password($this$semantics);
                    SemanticsPropertiesKt.copyText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return false;
                        }
                    }, 1, null);
                    SemanticsPropertiesKt.cutText$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return false;
                        }
                    }, 1, null);
                }
            }).then(revealLastTypedEnabled ? secureTextFieldController.getFocusChangeModifier() : Modifier.INSTANCE);
            DisableCutCopy(ComposableLambdaKt.composableLambda($composer3, -1415093334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3
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
                    KeyboardActions KeyboardActions;
                    ComposerKt.sourceInformation($composer4, "C323@17492L1033:BasicSecureTextField.kt#g98mwb");
                    if (($changed2 & 11) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1415093334, $changed2, -1, "androidx.compose.foundation.text2.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:323)");
                    }
                    InputTransformation inputTransformationThenOrNull = revealLastTypedEnabled ? InputTransformationKt.thenOrNull(inputTransformation2, secureTextFieldController.getPasswordRevealFilter()) : inputTransformation2;
                    TextFieldLineLimits.SingleLine singleLine = TextFieldLineLimits.SingleLine.INSTANCE;
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, keyboardType2, imeAction3, null, 17, null);
                    ImeActionHandler it = onSubmit4;
                    BasicTextField2Kt.BasicTextField2(state, secureTextFieldModifier, enabled3, false, inputTransformationThenOrNull, textStyle2, keyboardOptions, (it == null || (KeyboardActions = BasicSecureTextFieldKt.KeyboardActions(new BasicSecureTextFieldKt$BasicSecureTextField$3$1$1(it))) == null) ? KeyboardActions.INSTANCE.getDefault() : KeyboardActions, singleLine, onTextLayout, interactionSource2, cursorBrush3, codepointTransformation, decorator2, scrollState2, $composer4, 100666368, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer3, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2 = $composer3;
            $dirty = $dirty3;
            modifier4 = modifier2;
            inputTransformation3 = inputTransformation2;
            keyboardType3 = keyboardType2;
            $dirty2 = imeAction3;
            onSubmit5 = onSubmit4;
            enabled4 = enabled3;
            onTextLayout2 = onTextLayout;
            interactionSource3 = interactionSource2;
            cursorBrush4 = cursorBrush3;
            decorator3 = decorator2;
            scrollState3 = scrollState2;
            $dirty1 = textObfuscationMode2;
            textStyle3 = textStyle2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$4
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

                public final void invoke(Composer composer, int i23) {
                    BasicSecureTextFieldKt.m1275BasicSecureTextFieldmMrxcSU(state, modifier4, onSubmit5, $dirty2, $dirty1, keyboardType3, enabled4, inputTransformation3, textStyle3, interactionSource3, cursorBrush4, onTextLayout2, decorator3, scrollState3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeyboardActions KeyboardActions(final ImeActionHandler onSubmit) {
        return new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope $this$$receiver) {
                if (!onSubmit.mo1276onImeActionKlQnJC8(ImeAction.INSTANCE.m5951getDoneeUduSuo())) {
                    $this$$receiver.mo1065defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m5951getDoneeUduSuo());
                }
            }
        }, new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope $this$$receiver) {
                if (!onSubmit.mo1276onImeActionKlQnJC8(ImeAction.INSTANCE.m5952getGoeUduSuo())) {
                    $this$$receiver.mo1065defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m5952getGoeUduSuo());
                }
            }
        }, new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope $this$$receiver) {
                if (!onSubmit.mo1276onImeActionKlQnJC8(ImeAction.INSTANCE.m5953getNexteUduSuo())) {
                    $this$$receiver.mo1065defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m5953getNexteUduSuo());
                }
            }
        }, new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope $this$$receiver) {
                if (!onSubmit.mo1276onImeActionKlQnJC8(ImeAction.INSTANCE.m5955getPreviouseUduSuo())) {
                    $this$$receiver.mo1065defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m5955getPreviouseUduSuo());
                }
            }
        }, new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope $this$$receiver) {
                if (!onSubmit.mo1276onImeActionKlQnJC8(ImeAction.INSTANCE.m5956getSearcheUduSuo())) {
                    $this$$receiver.mo1065defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m5956getSearcheUduSuo());
                }
            }
        }, new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope $this$$receiver) {
                if (!onSubmit.mo1276onImeActionKlQnJC8(ImeAction.INSTANCE.m5957getSendeUduSuo())) {
                    $this$$receiver.mo1065defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m5957getSendeUduSuo());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DisableCutCopy(final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(930154034);
        ComposerKt.sourceInformation($composer2, "C(DisableCutCopy)491@23154L7,492@23192L680,511@23877L434:BasicSecureTextField.kt#g98mwb");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(930154034, $dirty, -1, "androidx.compose.foundation.text2.DisableCutCopy (BasicSecureTextField.kt:490)");
            }
            ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localTextToolbar);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final TextToolbar currentToolbar = (TextToolbar) objConsume;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(currentToolbar);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new TextToolbar() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1
                    private final /* synthetic */ TextToolbar $$delegate_0;

                    @Override // androidx.compose.p000ui.platform.TextToolbar
                    public TextToolbarStatus getStatus() {
                        return this.$$delegate_0.getStatus();
                    }

                    @Override // androidx.compose.p000ui.platform.TextToolbar
                    public void hide() {
                        this.$$delegate_0.hide();
                    }

                    {
                        this.$$delegate_0 = this.$currentToolbar;
                    }

                    @Override // androidx.compose.p000ui.platform.TextToolbar
                    public void showMenu(Rect rect, Function0<Unit> onCopyRequested, Function0<Unit> onPasteRequested, Function0<Unit> onCutRequested, Function0<Unit> onSelectAllRequested) {
                        this.$currentToolbar.showMenu(rect, null, onPasteRequested, null, onSelectAllRequested);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1 copyDisabledToolbar = (BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1) value$iv$iv;
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalTextToolbar().provides(copyDisabledToolbar), ComposableLambdaKt.composableLambda($composer2, -1741121166, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt.DisableCutCopy.1
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
                public final void invoke(androidx.compose.runtime.Composer r27, int r28) {
                    /*
                        Method dump skipped, instructions count: 364
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.BasicSecureTextFieldKt.C08191.invoke(androidx.compose.runtime.Composer, int):void");
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt.DisableCutCopy.2
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
                    BasicSecureTextFieldKt.DisableCutCopy(function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
