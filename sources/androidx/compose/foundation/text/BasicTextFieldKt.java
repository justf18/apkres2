package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.input.TextFieldValue;
import androidx.compose.p000ui.text.input.VisualTransformation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: BasicTextField.kt */
@Metadata(m164d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010\"\u001aì\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010$\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010&\u001aì\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010'¨\u0006(²\u0006\n\u0010)\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020%X\u008a\u008e\u0002"}, m165d2 = {"BasicTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation_release", "textFieldValueState", "lastTextValue"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BasicTextFieldKt {
    /* JADX WARN: Removed duplicated region for block: B:263:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0578  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void BasicTextField(final java.lang.String r37, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r38, androidx.compose.p000ui.Modifier r39, boolean r40, boolean r41, androidx.compose.p000ui.text.TextStyle r42, androidx.compose.foundation.text.KeyboardOptions r43, androidx.compose.foundation.text.KeyboardActions r44, boolean r45, int r46, int r47, androidx.compose.p000ui.text.input.VisualTransformation r48, kotlin.jvm.functions.Function1<? super androidx.compose.p000ui.text.TextLayoutResult, kotlin.Unit> r49, androidx.compose.foundation.interaction.MutableInteractionSource r50, androidx.compose.p000ui.graphics.Brush r51, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, androidx.compose.runtime.Composer r53, final int r54, final int r55, final int r56) {
        /*
            Method dump skipped, instructions count: 1458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue BasicTextField$lambda$2(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String BasicTextField$lambda$6(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:261:0x0490  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void BasicTextField(final androidx.compose.p000ui.text.input.TextFieldValue r36, final kotlin.jvm.functions.Function1<? super androidx.compose.p000ui.text.input.TextFieldValue, kotlin.Unit> r37, androidx.compose.p000ui.Modifier r38, boolean r39, boolean r40, androidx.compose.p000ui.text.TextStyle r41, androidx.compose.foundation.text.KeyboardOptions r42, androidx.compose.foundation.text.KeyboardActions r43, boolean r44, int r45, int r46, androidx.compose.p000ui.text.input.VisualTransformation r47, kotlin.jvm.functions.Function1<? super androidx.compose.p000ui.text.TextLayoutResult, kotlin.Unit> r48, androidx.compose.foundation.interaction.MutableInteractionSource r49, androidx.compose.p000ui.graphics.Brush r50, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) {
        /*
            Method dump skipped, instructions count: 1223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ void BasicTextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, final int $changed, final int $changed1, final int i) {
        String str;
        Modifier modifier2;
        boolean z;
        boolean z2;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Modifier modifier3;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Brush cursorBrush2;
        Composer $composer2;
        final Modifier modifier4;
        final boolean enabled3;
        final boolean readOnly2;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean singleLine2;
        final int maxLines2;
        final VisualTransformation visualTransformation2;
        final Function1 onTextLayout2;
        final MutableInteractionSource interactionSource4;
        final Brush cursorBrush3;
        final Function3 decorationBox2;
        Object value$iv$iv;
        Composer $composer3 = $composer.startRestartGroup(-454732590);
        ComposerKt.sourceInformation($composer3, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)335@18937L39,340@19177L579:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
            str = value;
        } else if (($changed & 14) == 0) {
            str = value;
            $dirty |= $composer3.changed(str) ? 4 : 2;
        } else {
            str = value;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i9 = i & 4;
        if (i9 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i10 = i & 8;
        if (i10 != 0) {
            $dirty |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i11 = i & 16;
        if (i11 != 0) {
            $dirty |= 24576;
            z2 = readOnly;
        } else if (($changed & 57344) == 0) {
            z2 = readOnly;
            $dirty |= $composer3.changed(z2) ? 16384 : 8192;
        } else {
            z2 = readOnly;
        }
        int i12 = i & 32;
        if (i12 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            textStyle2 = textStyle;
        } else if (($changed & 458752) == 0) {
            textStyle2 = textStyle;
            $dirty |= $composer3.changed(textStyle2) ? 131072 : 65536;
        } else {
            textStyle2 = textStyle;
        }
        int i13 = i & 64;
        if (i13 != 0) {
            $dirty |= 1572864;
            keyboardOptions2 = keyboardOptions;
        } else if (($changed & 3670016) == 0) {
            keyboardOptions2 = keyboardOptions;
            $dirty |= $composer3.changed(keyboardOptions2) ? 1048576 : 524288;
        } else {
            keyboardOptions2 = keyboardOptions;
        }
        int i14 = i & 128;
        if (i14 != 0) {
            $dirty |= 12582912;
            keyboardActions2 = keyboardActions;
        } else if (($changed & 29360128) == 0) {
            keyboardActions2 = keyboardActions;
            $dirty |= $composer3.changed(keyboardActions2) ? 8388608 : 4194304;
        } else {
            keyboardActions2 = keyboardActions;
        }
        int i15 = i & 256;
        if (i15 != 0) {
            $dirty |= 100663296;
            i2 = i15;
        } else if (($changed & 234881024) == 0) {
            i2 = i15;
            $dirty |= $composer3.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i15;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty |= 805306368;
            i3 = i16;
        } else if (($changed & 1879048192) == 0) {
            i3 = i16;
            $dirty |= $composer3.changed(maxLines) ? 536870912 : 268435456;
        } else {
            i3 = i16;
        }
        int i17 = i & 1024;
        if (i17 != 0) {
            $dirty1 |= 6;
            i4 = i17;
        } else if (($changed1 & 14) == 0) {
            i4 = i17;
            $dirty1 |= $composer3.changed(visualTransformation) ? 4 : 2;
        } else {
            i4 = i17;
        }
        int i18 = i & 2048;
        if (i18 != 0) {
            $dirty1 |= 48;
            i5 = i18;
        } else if (($changed1 & 112) == 0) {
            i5 = i18;
            $dirty1 |= $composer3.changedInstance(onTextLayout) ? 32 : 16;
        } else {
            i5 = i18;
        }
        int i19 = i & 4096;
        if (i19 != 0) {
            $dirty1 |= 384;
            i6 = i19;
        } else {
            i6 = i19;
            if (($changed1 & 896) == 0) {
                $dirty1 |= $composer3.changed(interactionSource) ? 256 : 128;
            }
        }
        int i20 = i & 8192;
        if (i20 != 0) {
            $dirty1 |= 3072;
            i7 = i20;
        } else {
            i7 = i20;
            if (($changed1 & 7168) == 0) {
                $dirty1 |= $composer3.changed(cursorBrush) ? 2048 : 1024;
            }
        }
        int i21 = i & 16384;
        if (i21 != 0) {
            $dirty1 |= 24576;
            i8 = i21;
        } else if (($changed1 & 57344) == 0) {
            i8 = i21;
            $dirty1 |= $composer3.changedInstance(decorationBox) ? 16384 : 8192;
        } else {
            i8 = i21;
        }
        if (($dirty & 1533916891) == 306783378 && (46811 & $dirty1) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            Modifier modifier5 = modifier2;
            keyboardActions3 = keyboardActions2;
            modifier4 = modifier5;
            maxLines2 = maxLines;
            interactionSource4 = interactionSource;
            decorationBox2 = decorationBox;
            $composer2 = $composer3;
            enabled3 = z;
            readOnly2 = z2;
            textStyle3 = textStyle2;
            keyboardOptions3 = keyboardOptions2;
            singleLine2 = singleLine;
            visualTransformation2 = visualTransformation;
            onTextLayout2 = onTextLayout;
            cursorBrush3 = cursorBrush;
        } else {
            Modifier.Companion modifier6 = i9 != 0 ? Modifier.INSTANCE : modifier2;
            boolean enabled4 = i10 != 0 ? true : z;
            boolean readOnly3 = i11 != 0 ? false : z2;
            TextStyle textStyle4 = i12 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
            if (i13 != 0) {
                keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
            }
            KeyboardActions keyboardActions4 = i14 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions2;
            boolean singleLine3 = i2 != 0 ? false : singleLine;
            int maxLines3 = i3 != 0 ? Integer.MAX_VALUE : maxLines;
            VisualTransformation visualTransformation3 = i4 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
            Function1 onTextLayout3 = i5 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.10
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult it) {
                }
            } : onTextLayout;
            if (i6 != 0) {
                modifier3 = modifier6;
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer3.rememberedValue();
                enabled2 = enabled4;
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer3.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer3.endReplaceableGroup();
                interactionSource2 = (MutableInteractionSource) value$iv$iv;
            } else {
                modifier3 = modifier6;
                enabled2 = enabled4;
                interactionSource2 = interactionSource;
            }
            if (i7 != 0) {
                interactionSource3 = interactionSource2;
                cursorBrush2 = new SolidColor(Color.INSTANCE.m3975getBlack0d7_KjU(), null);
            } else {
                interactionSource3 = interactionSource2;
                cursorBrush2 = cursorBrush;
            }
            Function3 decorationBox3 = i8 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m1056getLambda3$foundation_release() : decorationBox;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-454732590, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:339)");
            }
            int i22 = (($dirty1 << 3) & 112) | 6 | (($dirty1 << 3) & 896) | (($dirty1 << 3) & 7168) | (($dirty1 << 3) & 57344) | (($dirty1 << 3) & 458752);
            KeyboardOptions keyboardOptions4 = keyboardOptions2;
            MutableInteractionSource interactionSource5 = interactionSource3;
            $composer2 = $composer3;
            String str2 = str;
            Modifier modifier7 = modifier3;
            boolean enabled5 = enabled2;
            BasicTextField(str2, (Function1<? super String, Unit>) onValueChange, modifier7, enabled5, readOnly3, textStyle4, keyboardOptions4, keyboardActions4, singleLine3, maxLines3, 1, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) onTextLayout3, interactionSource5, cursorBrush2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) decorationBox3, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), i22, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier7;
            enabled3 = enabled5;
            readOnly2 = readOnly3;
            textStyle3 = textStyle4;
            keyboardOptions3 = keyboardOptions4;
            keyboardActions3 = keyboardActions4;
            singleLine2 = singleLine3;
            maxLines2 = maxLines3;
            visualTransformation2 = visualTransformation3;
            onTextLayout2 = onTextLayout3;
            interactionSource4 = interactionSource5;
            cursorBrush3 = cursorBrush2;
            decorationBox2 = decorationBox3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.12
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
                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifier4, enabled3, readOnly2, textStyle3, keyboardOptions3, keyboardActions3, singleLine2, maxLines2, visualTransformation2, onTextLayout2, interactionSource4, cursorBrush3, decorationBox2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ void BasicTextField(final TextFieldValue value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, final int $changed, final int $changed1, final int i) {
        TextFieldValue textFieldValue;
        Modifier modifier2;
        boolean z;
        boolean z2;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Modifier modifier3;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Brush cursorBrush2;
        Composer $composer2;
        final Modifier modifier4;
        final boolean enabled3;
        final boolean readOnly2;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean singleLine2;
        final int maxLines2;
        final VisualTransformation visualTransformation2;
        final Function1 onTextLayout2;
        final MutableInteractionSource interactionSource4;
        final Brush cursorBrush3;
        final Function3 decorationBox2;
        Object value$iv$iv;
        Composer $composer3 = $composer.startRestartGroup(-560482651);
        ComposerKt.sourceInformation($composer3, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)375@20462L39,380@20702L579:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
            textFieldValue = value;
        } else if (($changed & 14) == 0) {
            textFieldValue = value;
            $dirty |= $composer3.changed(textFieldValue) ? 4 : 2;
        } else {
            textFieldValue = value;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i9 = i & 4;
        if (i9 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i10 = i & 8;
        if (i10 != 0) {
            $dirty |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i11 = i & 16;
        if (i11 != 0) {
            $dirty |= 24576;
            z2 = readOnly;
        } else if (($changed & 57344) == 0) {
            z2 = readOnly;
            $dirty |= $composer3.changed(z2) ? 16384 : 8192;
        } else {
            z2 = readOnly;
        }
        int i12 = i & 32;
        if (i12 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            textStyle2 = textStyle;
        } else if (($changed & 458752) == 0) {
            textStyle2 = textStyle;
            $dirty |= $composer3.changed(textStyle2) ? 131072 : 65536;
        } else {
            textStyle2 = textStyle;
        }
        int i13 = i & 64;
        if (i13 != 0) {
            $dirty |= 1572864;
            keyboardOptions2 = keyboardOptions;
        } else if (($changed & 3670016) == 0) {
            keyboardOptions2 = keyboardOptions;
            $dirty |= $composer3.changed(keyboardOptions2) ? 1048576 : 524288;
        } else {
            keyboardOptions2 = keyboardOptions;
        }
        int i14 = i & 128;
        if (i14 != 0) {
            $dirty |= 12582912;
            keyboardActions2 = keyboardActions;
        } else if (($changed & 29360128) == 0) {
            keyboardActions2 = keyboardActions;
            $dirty |= $composer3.changed(keyboardActions2) ? 8388608 : 4194304;
        } else {
            keyboardActions2 = keyboardActions;
        }
        int i15 = i & 256;
        if (i15 != 0) {
            $dirty |= 100663296;
            i2 = i15;
        } else if (($changed & 234881024) == 0) {
            i2 = i15;
            $dirty |= $composer3.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i15;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty |= 805306368;
            i3 = i16;
        } else if (($changed & 1879048192) == 0) {
            i3 = i16;
            $dirty |= $composer3.changed(maxLines) ? 536870912 : 268435456;
        } else {
            i3 = i16;
        }
        int i17 = i & 1024;
        if (i17 != 0) {
            $dirty1 |= 6;
            i4 = i17;
        } else if (($changed1 & 14) == 0) {
            i4 = i17;
            $dirty1 |= $composer3.changed(visualTransformation) ? 4 : 2;
        } else {
            i4 = i17;
        }
        int i18 = i & 2048;
        if (i18 != 0) {
            $dirty1 |= 48;
            i5 = i18;
        } else if (($changed1 & 112) == 0) {
            i5 = i18;
            $dirty1 |= $composer3.changedInstance(onTextLayout) ? 32 : 16;
        } else {
            i5 = i18;
        }
        int i19 = i & 4096;
        if (i19 != 0) {
            $dirty1 |= 384;
            i6 = i19;
        } else {
            i6 = i19;
            if (($changed1 & 896) == 0) {
                $dirty1 |= $composer3.changed(interactionSource) ? 256 : 128;
            }
        }
        int i20 = i & 8192;
        if (i20 != 0) {
            $dirty1 |= 3072;
            i7 = i20;
        } else {
            i7 = i20;
            if (($changed1 & 7168) == 0) {
                $dirty1 |= $composer3.changed(cursorBrush) ? 2048 : 1024;
            }
        }
        int i21 = i & 16384;
        if (i21 != 0) {
            $dirty1 |= 24576;
            i8 = i21;
        } else if (($changed1 & 57344) == 0) {
            i8 = i21;
            $dirty1 |= $composer3.changedInstance(decorationBox) ? 16384 : 8192;
        } else {
            i8 = i21;
        }
        if (($dirty & 1533916891) == 306783378 && (46811 & $dirty1) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            Modifier modifier5 = modifier2;
            keyboardActions3 = keyboardActions2;
            modifier4 = modifier5;
            maxLines2 = maxLines;
            interactionSource4 = interactionSource;
            decorationBox2 = decorationBox;
            $composer2 = $composer3;
            enabled3 = z;
            readOnly2 = z2;
            textStyle3 = textStyle2;
            keyboardOptions3 = keyboardOptions2;
            singleLine2 = singleLine;
            visualTransformation2 = visualTransformation;
            onTextLayout2 = onTextLayout;
            cursorBrush3 = cursorBrush;
        } else {
            Modifier.Companion modifier6 = i9 != 0 ? Modifier.INSTANCE : modifier2;
            boolean enabled4 = i10 != 0 ? true : z;
            boolean readOnly3 = i11 != 0 ? false : z2;
            TextStyle textStyle4 = i12 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
            if (i13 != 0) {
                keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
            }
            KeyboardActions keyboardActions4 = i14 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions2;
            boolean singleLine3 = i2 != 0 ? false : singleLine;
            int maxLines3 = i3 != 0 ? Integer.MAX_VALUE : maxLines;
            VisualTransformation visualTransformation3 = i4 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
            Function1 onTextLayout3 = i5 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.13
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult it) {
                }
            } : onTextLayout;
            if (i6 != 0) {
                modifier3 = modifier6;
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer3.rememberedValue();
                enabled2 = enabled4;
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer3.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer3.endReplaceableGroup();
                interactionSource2 = (MutableInteractionSource) value$iv$iv;
            } else {
                modifier3 = modifier6;
                enabled2 = enabled4;
                interactionSource2 = interactionSource;
            }
            if (i7 != 0) {
                interactionSource3 = interactionSource2;
                cursorBrush2 = new SolidColor(Color.INSTANCE.m3975getBlack0d7_KjU(), null);
            } else {
                interactionSource3 = interactionSource2;
                cursorBrush2 = cursorBrush;
            }
            Function3 decorationBox3 = i8 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m1057getLambda4$foundation_release() : decorationBox;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-560482651, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:379)");
            }
            int i22 = (($dirty1 << 3) & 112) | 6 | (($dirty1 << 3) & 896) | (($dirty1 << 3) & 7168) | (($dirty1 << 3) & 57344) | (($dirty1 << 3) & 458752);
            KeyboardOptions keyboardOptions4 = keyboardOptions2;
            MutableInteractionSource interactionSource5 = interactionSource3;
            $composer2 = $composer3;
            TextFieldValue textFieldValue2 = textFieldValue;
            Modifier modifier7 = modifier3;
            boolean enabled5 = enabled2;
            BasicTextField(textFieldValue2, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier7, enabled5, readOnly3, textStyle4, keyboardOptions4, keyboardActions4, singleLine3, maxLines3, 1, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) onTextLayout3, interactionSource5, cursorBrush2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) decorationBox3, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), i22, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier7;
            enabled3 = enabled5;
            readOnly2 = readOnly3;
            textStyle3 = textStyle4;
            keyboardOptions3 = keyboardOptions4;
            keyboardActions3 = keyboardActions4;
            singleLine2 = singleLine3;
            maxLines2 = maxLines3;
            visualTransformation2 = visualTransformation3;
            onTextLayout2 = onTextLayout3;
            interactionSource4 = interactionSource5;
            cursorBrush3 = cursorBrush2;
            decorationBox2 = decorationBox3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField.15
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
                    BasicTextFieldKt.BasicTextField(value, onValueChange, modifier4, enabled3, readOnly2, textStyle3, keyboardOptions3, keyboardActions3, singleLine2, maxLines2, visualTransformation2, onTextLayout2, interactionSource4, cursorBrush3, decorationBox2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }
}
