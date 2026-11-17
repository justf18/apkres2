package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.Strings;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.C1740R;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.DrawModifierKt;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shadow;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawStyle;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.text.PlatformTextStyle;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.font.FontStyle;
import androidx.compose.p000ui.text.font.FontSynthesis;
import androidx.compose.p000ui.text.font.FontWeight;
import androidx.compose.p000ui.text.input.TextFieldValue;
import androidx.compose.p000ui.text.input.VisualTransformation;
import androidx.compose.p000ui.text.intl.LocaleList;
import androidx.compose.p000ui.text.style.BaselineShift;
import androidx.compose.p000ui.text.style.LineHeightStyle;
import androidx.compose.p000ui.text.style.TextDecoration;
import androidx.compose.p000ui.text.style.TextGeometricTransform;
import androidx.compose.p000ui.text.style.TextIndent;
import androidx.compose.p000ui.text.style.TextMotion;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.util.MathHelpersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

/* compiled from: TextField.kt */
@Metadata(m164d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u001aÖ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a¨\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010-\u001aÖ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020.2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010/\u001a¨\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020.2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00100\u001aì\u0001\u00101\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0019\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0002\b\u00142\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u0010\"\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u00108\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\u0010;\u001ar\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020$2\u0006\u00105\u001a\u0002062\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001aR\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020$2\u0006\u0010P\u001a\u00020$2\u0006\u0010Q\u001a\u00020$2\u0006\u0010E\u001a\u00020FH\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001a\u0014\u0010T\u001a\u00020\f*\u00020\f2\u0006\u0010U\u001a\u00020VH\u0000\u001a\u009a\u0001\u0010W\u001a\u00020\u0006*\u00020X2\u0006\u0010Y\u001a\u00020$2\u0006\u0010Z\u001a\u00020$2\u0006\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010\\2\b\u0010^\u001a\u0004\u0018\u00010\\2\b\u0010_\u001a\u0004\u0018\u00010\\2\b\u0010`\u001a\u0004\u0018\u00010\\2\b\u0010a\u001a\u0004\u0018\u00010\\2\b\u0010b\u001a\u0004\u0018\u00010\\2\u0006\u0010c\u001a\u00020\\2\b\u0010d\u001a\u0004\u0018\u00010\\2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010e\u001a\u00020$2\u0006\u0010f\u001a\u00020$2\u0006\u00105\u001a\u0002062\u0006\u0010G\u001a\u000206H\u0002\u001a\u0080\u0001\u0010g\u001a\u00020\u0006*\u00020X2\u0006\u0010Y\u001a\u00020$2\u0006\u0010Z\u001a\u00020$2\u0006\u0010h\u001a\u00020\\2\b\u0010^\u001a\u0004\u0018\u00010\\2\b\u0010_\u001a\u0004\u0018\u00010\\2\b\u0010`\u001a\u0004\u0018\u00010\\2\b\u0010a\u001a\u0004\u0018\u00010\\2\b\u0010b\u001a\u0004\u0018\u00010\\2\u0006\u0010c\u001a\u00020\\2\b\u0010d\u001a\u0004\u0018\u00010\\2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010G\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0002\u001a\u0014\u0010i\u001a\u00020$*\u00020$2\u0006\u0010j\u001a\u00020$H\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006k"}, m165d2 = {"TextFieldWithLabelVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldWithLabelVerticalPadding", "()F", "F", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "substractConstraintSafely", TypedValues.TransitionType.S_FROM, "material3_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldKt {
    private static final float TextFieldWithLabelVerticalPadding = C1956Dp.m6297constructorimpl(8);

    public static final void TextField(final String value, final Function1<? super String, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        final String str;
        Function1<? super String, Unit> function12;
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        Function2 label;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        final KeyboardActions keyboardActions2;
        final boolean singleLine2;
        final int maxLines2;
        final int minLines2;
        Function2 placeholder;
        Function2 leadingIcon;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        final Function2 placeholder2;
        final MutableInteractionSource interactionSource3;
        final Shape shape3;
        final Function2 leadingIcon2;
        final Function2 trailingIcon;
        TextStyle textStyle3;
        final Function2 prefix;
        final Function2 label2;
        final Function2 suffix;
        final Function2 supportingText;
        final VisualTransformation visualTransformation2;
        final boolean isError2;
        final TextFieldColors colors2;
        final Modifier modifier3;
        final boolean enabled3;
        final boolean readOnly3;
        final KeyboardOptions keyboardOptions2;
        Object value$iv;
        Composer $composer2;
        long jM3959unboximpl;
        final boolean enabled4;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final int maxLines3;
        final int minLines3;
        final VisualTransformation visualTransformation3;
        final MutableInteractionSource interactionSource4;
        final Function2 placeholder3;
        final Function2 trailingIcon2;
        final Function2 prefix2;
        final Function2 suffix2;
        final TextFieldColors colors3;
        final boolean readOnly4;
        final boolean readOnly5;
        final Function2 label3;
        final Shape shape4;
        final TextStyle textStyle4;
        final boolean isError3;
        final Function2 supportingText2;
        int i10;
        Composer $composer3 = $composer.startRestartGroup(-676242365);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)174@9072L7,189@9824L39,190@9902L5,191@9957L8,199@10319L15,199@10253L1913:TextField.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        int $dirty2 = $changed2;
        if ((i & 1) != 0) {
            $dirty |= 6;
            str = value;
        } else if (($changed & 6) == 0) {
            str = value;
            $dirty |= $composer3.changed(str) ? 4 : 2;
        } else {
            str = value;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
            function12 = function1;
        } else if (($changed & 48) == 0) {
            function12 = function1;
            $dirty |= $composer3.changedInstance(function12) ? 32 : 16;
        } else {
            function12 = function1;
        }
        int i11 = i & 4;
        if (i11 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i12 = i & 8;
        if (i12 != 0) {
            $dirty |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i13 = i & 16;
        if (i13 != 0) {
            $dirty |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 24576) == 0) {
            readOnly2 = readOnly;
            $dirty |= $composer3.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                if ($composer3.changed(textStyle2)) {
                    i10 = 131072;
                }
                $dirty |= i10;
            } else {
                textStyle2 = textStyle;
            }
            i10 = 65536;
            $dirty |= i10;
        } else {
            textStyle2 = textStyle;
        }
        int i14 = i & 64;
        if (i14 != 0) {
            $dirty |= 1572864;
            label = function2;
        } else if (($changed & 1572864) == 0) {
            label = function2;
            $dirty |= $composer3.changedInstance(label) ? 1048576 : 524288;
        } else {
            label = function2;
        }
        int i15 = i & 128;
        if (i15 != 0) {
            $dirty |= 12582912;
            i2 = i15;
        } else if (($changed & 12582912) == 0) {
            i2 = i15;
            $dirty |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        } else {
            i2 = i15;
        }
        int i16 = i & 256;
        if (i16 != 0) {
            $dirty |= 100663296;
            i3 = i16;
        } else if (($changed & 100663296) == 0) {
            i3 = i16;
            $dirty |= $composer3.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i16;
        }
        int i17 = i & 512;
        if (i17 != 0) {
            $dirty |= 805306368;
            i4 = i17;
        } else if (($changed & 805306368) == 0) {
            i4 = i17;
            $dirty |= $composer3.changedInstance(function24) ? 536870912 : 268435456;
        } else {
            i4 = i17;
        }
        int i18 = i & 1024;
        if (i18 != 0) {
            $dirty1 |= 6;
            i5 = i18;
        } else if (($changed1 & 6) == 0) {
            i5 = i18;
            $dirty1 |= $composer3.changedInstance(function25) ? 4 : 2;
        } else {
            i5 = i18;
        }
        int i19 = i & 2048;
        if (i19 != 0) {
            $dirty1 |= 48;
            i6 = i19;
        } else if (($changed1 & 48) == 0) {
            i6 = i19;
            $dirty1 |= $composer3.changedInstance(function26) ? 32 : 16;
        } else {
            i6 = i19;
        }
        int i20 = i & 4096;
        if (i20 != 0) {
            $dirty1 |= 384;
            i7 = i20;
        } else {
            i7 = i20;
            if (($changed1 & 384) == 0) {
                $dirty1 |= $composer3.changedInstance(function27) ? 256 : 128;
            }
        }
        int i21 = i & 8192;
        if (i21 != 0) {
            $dirty1 |= 3072;
            i8 = i21;
        } else {
            i8 = i21;
            if (($changed1 & 3072) == 0) {
                $dirty1 |= $composer3.changed(isError) ? 2048 : 1024;
            }
        }
        int i22 = i & 16384;
        if (i22 != 0) {
            $dirty1 |= 24576;
            i9 = i22;
        } else {
            i9 = i22;
            if (($changed1 & 24576) == 0) {
                $dirty1 |= $composer3.changed(visualTransformation) ? 16384 : 8192;
            }
        }
        int i23 = i & 32768;
        if (i23 != 0) {
            $dirty1 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            $dirty1 |= $composer3.changed(keyboardOptions) ? 131072 : 65536;
        }
        int i24 = i & 65536;
        if (i24 != 0) {
            $dirty1 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty1 |= $composer3.changed(keyboardActions) ? 1048576 : 524288;
        }
        int i25 = i & 131072;
        if (i25 != 0) {
            $dirty1 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty1 |= $composer3.changed(singleLine) ? 8388608 : 4194304;
        }
        if (($changed1 & 100663296) == 0) {
            $dirty1 |= ((i & 262144) == 0 && $composer3.changed(maxLines)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i26 = i & 524288;
        if (i26 != 0) {
            $dirty1 |= 805306368;
        } else if (($changed1 & 805306368) == 0) {
            $dirty1 |= $composer3.changed(minLines) ? 536870912 : 268435456;
        }
        int i27 = i & 1048576;
        if (i27 != 0) {
            $dirty2 |= 6;
        } else if (($changed2 & 6) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? 4 : 2;
        }
        if (($changed2 & 48) == 0) {
            $dirty2 |= ((i & 2097152) == 0 && $composer3.changed(shape)) ? 32 : 16;
        }
        if (($changed2 & 384) == 0) {
            $dirty2 |= ((i & 4194304) == 0 && $composer3.changed(colors)) ? 256 : 128;
        }
        if (($dirty & 306783379) == 306783378 && (306783379 & $dirty1) == 306783378 && ($dirty2 & 147) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            placeholder3 = function22;
            leadingIcon2 = function23;
            supportingText2 = function27;
            visualTransformation3 = visualTransformation;
            keyboardOptions3 = keyboardOptions;
            keyboardActions3 = keyboardActions;
            readOnly5 = singleLine;
            maxLines3 = maxLines;
            minLines3 = minLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            $composer2 = $composer3;
            enabled4 = enabled2;
            readOnly4 = readOnly2;
            textStyle4 = textStyle2;
            label3 = label;
            trailingIcon2 = function24;
            prefix2 = function25;
            suffix2 = function26;
            isError3 = isError;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i12 != 0) {
                    enabled2 = true;
                }
                if (i13 != 0) {
                    readOnly2 = false;
                }
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $dirty &= -458753;
                    textStyle2 = (TextStyle) objConsume;
                }
                if (i14 != 0) {
                    label = null;
                }
                Function2 placeholder4 = i2 != 0 ? null : function22;
                Function2 leadingIcon3 = i3 != 0 ? null : function23;
                Function2 trailingIcon3 = i4 != 0 ? null : function24;
                Function2 prefix3 = i5 != 0 ? null : function25;
                Function2 suffix3 = i6 != 0 ? null : function26;
                Function2 supportingText3 = i7 != 0 ? null : function27;
                boolean isError4 = i8 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i9 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i23 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                keyboardActions2 = i24 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                singleLine2 = i25 != 0 ? false : singleLine;
                if ((i & 262144) != 0) {
                    maxLines2 = singleLine2 ? 1 : Integer.MAX_VALUE;
                    $dirty1 &= -234881025;
                } else {
                    maxLines2 = maxLines;
                }
                minLines2 = i26 != 0 ? 1 : minLines;
                if (i27 != 0) {
                    placeholder = placeholder4;
                    $composer3.startReplaceableGroup(-1263331754);
                    ComposerKt.sourceInformation($composer3, "CC(remember):TextField.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    leadingIcon = leadingIcon3;
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    $composer3.endReplaceableGroup();
                } else {
                    placeholder = placeholder4;
                    leadingIcon = leadingIcon3;
                    interactionSource2 = interactionSource;
                }
                MutableInteractionSource interactionSource5 = interactionSource2;
                if ((2097152 & i) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty2 &= -113;
                } else {
                    shape2 = shape;
                }
                if ((i & 4194304) != 0) {
                    placeholder2 = placeholder;
                    interactionSource3 = interactionSource5;
                    shape3 = shape2;
                    leadingIcon2 = leadingIcon;
                    $dirty2 &= -897;
                    trailingIcon = trailingIcon3;
                    prefix = prefix3;
                    label2 = label;
                    suffix = suffix3;
                    supportingText = supportingText3;
                    visualTransformation2 = visualTransformation4;
                    isError2 = isError4;
                    colors2 = TextFieldDefaults.INSTANCE.colors($composer3, 6);
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    textStyle3 = textStyle2;
                    keyboardOptions2 = keyboardOptions4;
                    modifier3 = modifier2;
                } else {
                    placeholder2 = placeholder;
                    interactionSource3 = interactionSource5;
                    shape3 = shape2;
                    leadingIcon2 = leadingIcon;
                    trailingIcon = trailingIcon3;
                    textStyle3 = textStyle2;
                    prefix = prefix3;
                    label2 = label;
                    suffix = suffix3;
                    supportingText = supportingText3;
                    visualTransformation2 = visualTransformation4;
                    isError2 = isError4;
                    colors2 = colors;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    keyboardOptions2 = keyboardOptions4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((262144 & i) != 0) {
                    $dirty1 &= -234881025;
                }
                if ((2097152 & i) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4194304) != 0) {
                    placeholder2 = function22;
                    leadingIcon2 = function23;
                    trailingIcon = function24;
                    prefix = function25;
                    suffix = function26;
                    supportingText = function27;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    minLines2 = minLines;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    $dirty2 &= -897;
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    textStyle3 = textStyle2;
                    label2 = label;
                    colors2 = colors;
                    modifier3 = modifier2;
                } else {
                    placeholder2 = function22;
                    leadingIcon2 = function23;
                    trailingIcon = function24;
                    prefix = function25;
                    suffix = function26;
                    supportingText = function27;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    minLines2 = minLines;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    textStyle3 = textStyle2;
                    label2 = label;
                    colors2 = colors;
                    modifier3 = modifier2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-676242365, $dirty, $dirty1, "androidx.compose.material3.TextField (TextField.kt:192)");
            }
            $composer3.startReplaceableGroup(-1263331489);
            ComposerKt.sourceInformation($composer3, "*195@10117L46");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m5804getColor0d7_KjU();
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m3985getUnspecified0d7_KjU()) {
                jM3959unboximpl = $this$takeOrElse_u2dDxMtmZc$iv;
                $composer2 = $composer3;
            } else {
                $composer2 = $composer3;
                jM3959unboximpl = colors2.textColor$material3_release(enabled3, isError2, interactionSource3, $composer3, (($dirty >> 9) & 14) | (($dirty1 >> 6) & 112) | (($dirty2 << 6) & 896) | (($dirty2 << 3) & 7168)).getValue().m3959unboximpl();
            }
            $composer2.endReplaceableGroup();
            long textColor = jM3959unboximpl;
            final TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            final Function1<? super String, Unit> function13 = function12;
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors2.getSelectionColors($composer2, ($dirty2 >> 6) & 14)), ComposableLambdaKt.composableLambda($composer2, 1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.2
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

                public final void invoke(Composer $composer4, int $changed3) {
                    ComposerKt.sourceInformation($composer4, "C203@10469L38,212@10872L20,200@10346L1814:TextField.kt#uh7d8r");
                    if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1859145987, $changed3, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:200)");
                        }
                        Modifier modifier4 = modifier3;
                        boolean z = isError2;
                        Strings.Companion companion = Strings.INSTANCE;
                        Modifier modifierM800defaultMinSizeVpY3zN4 = SizeKt.m800defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier4, z, Strings_androidKt.m2509getStringNWtq28(Strings.m2440constructorimpl(C1740R.string.default_error_message), $composer4, 0)), TextFieldDefaults.INSTANCE.m2643getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2642getMinHeightD9Ej5fM());
                        SolidColor solidColor = new SolidColor(colors2.cursorColor$material3_release(isError2, $composer4, 0).getValue().m3959unboximpl(), null);
                        final String str2 = str;
                        final boolean z2 = enabled3;
                        final boolean z3 = singleLine2;
                        final VisualTransformation visualTransformation5 = visualTransformation2;
                        final MutableInteractionSource mutableInteractionSource = interactionSource3;
                        final boolean z4 = isError2;
                        final Function2<Composer, Integer, Unit> function28 = label2;
                        final Function2<Composer, Integer, Unit> function29 = placeholder2;
                        final Function2<Composer, Integer, Unit> function210 = leadingIcon2;
                        final Function2<Composer, Integer, Unit> function211 = trailingIcon;
                        final Function2<Composer, Integer, Unit> function212 = prefix;
                        final Function2<Composer, Integer, Unit> function213 = suffix;
                        final Function2<Composer, Integer, Unit> function214 = supportingText;
                        final Shape shape5 = shape3;
                        final TextFieldColors textFieldColors = colors2;
                        BasicTextFieldKt.BasicTextField(str, function13, modifierM800defaultMinSizeVpY3zN4, enabled3, readOnly3, mergedTextStyle, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, minLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, solidColor, ComposableLambdaKt.composableLambda($composer4, -288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function215, Composer composer, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function215, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function215, Composer $composer5, int $changed4) {
                                Function2<? super Composer, ? super Integer, Unit> function216;
                                ComposerKt.sourceInformation($composer5, "C222@11393L743:TextField.kt#uh7d8r");
                                int $dirty3 = $changed4;
                                if (($changed4 & 6) == 0) {
                                    function216 = function215;
                                    $dirty3 |= $composer5.changedInstance(function216) ? 4 : 2;
                                } else {
                                    function216 = function215;
                                }
                                if (($dirty3 & 19) != 18 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-288211827, $dirty3, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:222)");
                                    }
                                    TextFieldDefaults.INSTANCE.DecorationBox(str2, function216, z2, z3, visualTransformation5, mutableInteractionSource, z4, function28, function29, function210, function211, function212, function213, function214, shape5, textFieldColors, null, null, $composer5, ($dirty3 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.f249xf2722a21);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }), $composer4, 0, ProfileVerifier.CompilationStatus.f249xf2722a21, 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, ProvidedValue.$stable | 0 | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            enabled4 = enabled3;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            maxLines3 = maxLines2;
            minLines3 = minLines2;
            visualTransformation3 = visualTransformation2;
            interactionSource4 = interactionSource3;
            placeholder3 = placeholder2;
            trailingIcon2 = trailingIcon;
            prefix2 = prefix;
            suffix2 = suffix;
            colors3 = colors2;
            readOnly4 = readOnly3;
            readOnly5 = singleLine2;
            label3 = label2;
            shape4 = shape3;
            textStyle4 = textStyle3;
            isError3 = isError2;
            supportingText2 = supportingText;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Function2 leadingIcon4 = leadingIcon2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.3
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

                public final void invoke(Composer composer, int i28) {
                    TextFieldKt.TextField(value, function1, modifier4, enabled4, readOnly4, textStyle4, label3, placeholder3, leadingIcon4, trailingIcon2, prefix2, suffix2, supportingText2, isError3, visualTransformation3, keyboardOptions3, keyboardActions3, readOnly5, maxLines3, minLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
                }
            });
        }
    }

    public static final void TextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        final TextFieldValue textFieldValue;
        Function1<? super TextFieldValue, Unit> function12;
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        Function2 label;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        final KeyboardActions keyboardActions2;
        final boolean singleLine2;
        final int maxLines2;
        final int minLines2;
        Function2 placeholder;
        Function2 leadingIcon;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        final Function2 placeholder2;
        final MutableInteractionSource interactionSource3;
        final Shape shape3;
        final Function2 leadingIcon2;
        final Function2 trailingIcon;
        TextStyle textStyle3;
        final Function2 prefix;
        final Function2 label2;
        final Function2 suffix;
        final Function2 supportingText;
        final VisualTransformation visualTransformation2;
        final boolean isError2;
        final TextFieldColors colors2;
        final Modifier modifier3;
        final boolean enabled3;
        final boolean readOnly3;
        final KeyboardOptions keyboardOptions2;
        Object value$iv;
        Composer $composer2;
        long jM3959unboximpl;
        final boolean enabled4;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final int maxLines3;
        final int minLines3;
        final VisualTransformation visualTransformation3;
        final MutableInteractionSource interactionSource4;
        final Function2 placeholder3;
        final Function2 trailingIcon2;
        final Function2 prefix2;
        final Function2 suffix2;
        final TextFieldColors colors3;
        final boolean readOnly4;
        final boolean readOnly5;
        final Function2 label3;
        final Shape shape4;
        final TextStyle textStyle4;
        final boolean isError3;
        final Function2 supportingText2;
        int i10;
        Composer $composer3 = $composer.startRestartGroup(-1268528240);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)320@17250L7,335@18002L39,336@18080L5,337@18135L8,345@18497L15,345@18431L1918:TextField.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        int $dirty2 = $changed2;
        if ((i & 1) != 0) {
            $dirty |= 6;
            textFieldValue = value;
        } else if (($changed & 6) == 0) {
            textFieldValue = value;
            $dirty |= $composer3.changed(textFieldValue) ? 4 : 2;
        } else {
            textFieldValue = value;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
            function12 = function1;
        } else if (($changed & 48) == 0) {
            function12 = function1;
            $dirty |= $composer3.changedInstance(function12) ? 32 : 16;
        } else {
            function12 = function1;
        }
        int i11 = i & 4;
        if (i11 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i12 = i & 8;
        if (i12 != 0) {
            $dirty |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i13 = i & 16;
        if (i13 != 0) {
            $dirty |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 24576) == 0) {
            readOnly2 = readOnly;
            $dirty |= $composer3.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                if ($composer3.changed(textStyle2)) {
                    i10 = 131072;
                }
                $dirty |= i10;
            } else {
                textStyle2 = textStyle;
            }
            i10 = 65536;
            $dirty |= i10;
        } else {
            textStyle2 = textStyle;
        }
        int i14 = i & 64;
        if (i14 != 0) {
            $dirty |= 1572864;
            label = function2;
        } else if (($changed & 1572864) == 0) {
            label = function2;
            $dirty |= $composer3.changedInstance(label) ? 1048576 : 524288;
        } else {
            label = function2;
        }
        int i15 = i & 128;
        if (i15 != 0) {
            $dirty |= 12582912;
            i2 = i15;
        } else if (($changed & 12582912) == 0) {
            i2 = i15;
            $dirty |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        } else {
            i2 = i15;
        }
        int i16 = i & 256;
        if (i16 != 0) {
            $dirty |= 100663296;
            i3 = i16;
        } else if (($changed & 100663296) == 0) {
            i3 = i16;
            $dirty |= $composer3.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i16;
        }
        int i17 = i & 512;
        if (i17 != 0) {
            $dirty |= 805306368;
            i4 = i17;
        } else if (($changed & 805306368) == 0) {
            i4 = i17;
            $dirty |= $composer3.changedInstance(function24) ? 536870912 : 268435456;
        } else {
            i4 = i17;
        }
        int i18 = i & 1024;
        if (i18 != 0) {
            $dirty1 |= 6;
            i5 = i18;
        } else if (($changed1 & 6) == 0) {
            i5 = i18;
            $dirty1 |= $composer3.changedInstance(function25) ? 4 : 2;
        } else {
            i5 = i18;
        }
        int i19 = i & 2048;
        if (i19 != 0) {
            $dirty1 |= 48;
            i6 = i19;
        } else if (($changed1 & 48) == 0) {
            i6 = i19;
            $dirty1 |= $composer3.changedInstance(function26) ? 32 : 16;
        } else {
            i6 = i19;
        }
        int i20 = i & 4096;
        if (i20 != 0) {
            $dirty1 |= 384;
            i7 = i20;
        } else {
            i7 = i20;
            if (($changed1 & 384) == 0) {
                $dirty1 |= $composer3.changedInstance(function27) ? 256 : 128;
            }
        }
        int i21 = i & 8192;
        if (i21 != 0) {
            $dirty1 |= 3072;
            i8 = i21;
        } else {
            i8 = i21;
            if (($changed1 & 3072) == 0) {
                $dirty1 |= $composer3.changed(isError) ? 2048 : 1024;
            }
        }
        int i22 = i & 16384;
        if (i22 != 0) {
            $dirty1 |= 24576;
            i9 = i22;
        } else {
            i9 = i22;
            if (($changed1 & 24576) == 0) {
                $dirty1 |= $composer3.changed(visualTransformation) ? 16384 : 8192;
            }
        }
        int i23 = i & 32768;
        if (i23 != 0) {
            $dirty1 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            $dirty1 |= $composer3.changed(keyboardOptions) ? 131072 : 65536;
        }
        int i24 = i & 65536;
        if (i24 != 0) {
            $dirty1 |= 1572864;
        } else if (($changed1 & 1572864) == 0) {
            $dirty1 |= $composer3.changed(keyboardActions) ? 1048576 : 524288;
        }
        int i25 = i & 131072;
        if (i25 != 0) {
            $dirty1 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty1 |= $composer3.changed(singleLine) ? 8388608 : 4194304;
        }
        if (($changed1 & 100663296) == 0) {
            $dirty1 |= ((i & 262144) == 0 && $composer3.changed(maxLines)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i26 = i & 524288;
        if (i26 != 0) {
            $dirty1 |= 805306368;
        } else if (($changed1 & 805306368) == 0) {
            $dirty1 |= $composer3.changed(minLines) ? 536870912 : 268435456;
        }
        int i27 = i & 1048576;
        if (i27 != 0) {
            $dirty2 |= 6;
        } else if (($changed2 & 6) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? 4 : 2;
        }
        if (($changed2 & 48) == 0) {
            $dirty2 |= ((i & 2097152) == 0 && $composer3.changed(shape)) ? 32 : 16;
        }
        if (($changed2 & 384) == 0) {
            $dirty2 |= ((i & 4194304) == 0 && $composer3.changed(colors)) ? 256 : 128;
        }
        if (($dirty & 306783379) == 306783378 && (306783379 & $dirty1) == 306783378 && ($dirty2 & 147) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            placeholder3 = function22;
            leadingIcon2 = function23;
            supportingText2 = function27;
            visualTransformation3 = visualTransformation;
            keyboardOptions3 = keyboardOptions;
            keyboardActions3 = keyboardActions;
            readOnly5 = singleLine;
            maxLines3 = maxLines;
            minLines3 = minLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            $composer2 = $composer3;
            enabled4 = enabled2;
            readOnly4 = readOnly2;
            textStyle4 = textStyle2;
            label3 = label;
            trailingIcon2 = function24;
            prefix2 = function25;
            suffix2 = function26;
            isError3 = isError;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i12 != 0) {
                    enabled2 = true;
                }
                if (i13 != 0) {
                    readOnly2 = false;
                }
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $dirty &= -458753;
                    textStyle2 = (TextStyle) objConsume;
                }
                if (i14 != 0) {
                    label = null;
                }
                Function2 placeholder4 = i2 != 0 ? null : function22;
                Function2 leadingIcon3 = i3 != 0 ? null : function23;
                Function2 trailingIcon3 = i4 != 0 ? null : function24;
                Function2 prefix3 = i5 != 0 ? null : function25;
                Function2 suffix3 = i6 != 0 ? null : function26;
                Function2 supportingText3 = i7 != 0 ? null : function27;
                boolean isError4 = i8 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i9 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i23 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                keyboardActions2 = i24 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                singleLine2 = i25 != 0 ? false : singleLine;
                if ((i & 262144) != 0) {
                    maxLines2 = singleLine2 ? 1 : Integer.MAX_VALUE;
                    $dirty1 &= -234881025;
                } else {
                    maxLines2 = maxLines;
                }
                minLines2 = i26 != 0 ? 1 : minLines;
                if (i27 != 0) {
                    placeholder = placeholder4;
                    $composer3.startReplaceableGroup(-1263323576);
                    ComposerKt.sourceInformation($composer3, "CC(remember):TextField.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    leadingIcon = leadingIcon3;
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    $composer3.endReplaceableGroup();
                } else {
                    placeholder = placeholder4;
                    leadingIcon = leadingIcon3;
                    interactionSource2 = interactionSource;
                }
                MutableInteractionSource interactionSource5 = interactionSource2;
                if ((2097152 & i) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty2 &= -113;
                } else {
                    shape2 = shape;
                }
                if ((i & 4194304) != 0) {
                    placeholder2 = placeholder;
                    interactionSource3 = interactionSource5;
                    shape3 = shape2;
                    leadingIcon2 = leadingIcon;
                    $dirty2 &= -897;
                    trailingIcon = trailingIcon3;
                    prefix = prefix3;
                    label2 = label;
                    suffix = suffix3;
                    supportingText = supportingText3;
                    visualTransformation2 = visualTransformation4;
                    isError2 = isError4;
                    colors2 = TextFieldDefaults.INSTANCE.colors($composer3, 6);
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    textStyle3 = textStyle2;
                    keyboardOptions2 = keyboardOptions4;
                    modifier3 = modifier2;
                } else {
                    placeholder2 = placeholder;
                    interactionSource3 = interactionSource5;
                    shape3 = shape2;
                    leadingIcon2 = leadingIcon;
                    trailingIcon = trailingIcon3;
                    textStyle3 = textStyle2;
                    prefix = prefix3;
                    label2 = label;
                    suffix = suffix3;
                    supportingText = supportingText3;
                    visualTransformation2 = visualTransformation4;
                    isError2 = isError4;
                    colors2 = colors;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    keyboardOptions2 = keyboardOptions4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((262144 & i) != 0) {
                    $dirty1 &= -234881025;
                }
                if ((2097152 & i) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4194304) != 0) {
                    placeholder2 = function22;
                    leadingIcon2 = function23;
                    trailingIcon = function24;
                    prefix = function25;
                    suffix = function26;
                    supportingText = function27;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    minLines2 = minLines;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    $dirty2 &= -897;
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    textStyle3 = textStyle2;
                    label2 = label;
                    colors2 = colors;
                    modifier3 = modifier2;
                } else {
                    placeholder2 = function22;
                    leadingIcon2 = function23;
                    trailingIcon = function24;
                    prefix = function25;
                    suffix = function26;
                    supportingText = function27;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    minLines2 = minLines;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    textStyle3 = textStyle2;
                    label2 = label;
                    colors2 = colors;
                    modifier3 = modifier2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1268528240, $dirty, $dirty1, "androidx.compose.material3.TextField (TextField.kt:338)");
            }
            $composer3.startReplaceableGroup(-1263323311);
            ComposerKt.sourceInformation($composer3, "*341@18295L46");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle3.m5804getColor0d7_KjU();
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m3985getUnspecified0d7_KjU()) {
                jM3959unboximpl = $this$takeOrElse_u2dDxMtmZc$iv;
                $composer2 = $composer3;
            } else {
                $composer2 = $composer3;
                jM3959unboximpl = colors2.textColor$material3_release(enabled3, isError2, interactionSource3, $composer3, (($dirty >> 9) & 14) | (($dirty1 >> 6) & 112) | (($dirty2 << 6) & 896) | (($dirty2 << 3) & 7168)).getValue().m3959unboximpl();
            }
            $composer2.endReplaceableGroup();
            long textColor = jM3959unboximpl;
            final TextStyle mergedTextStyle = textStyle3.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            final Function1<? super TextFieldValue, Unit> function13 = function12;
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors2.getSelectionColors($composer2, ($dirty2 >> 6) & 14)), ComposableLambdaKt.composableLambda($composer2, -1163788208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.5
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

                public final void invoke(Composer $composer4, int $changed3) {
                    ComposerKt.sourceInformation($composer4, "C349@18647L38,358@19050L20,346@18524L1819:TextField.kt#uh7d8r");
                    if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1163788208, $changed3, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:346)");
                        }
                        Modifier modifier4 = modifier3;
                        boolean z = isError2;
                        Strings.Companion companion = Strings.INSTANCE;
                        Modifier modifierM800defaultMinSizeVpY3zN4 = SizeKt.m800defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier4, z, Strings_androidKt.m2509getStringNWtq28(Strings.m2440constructorimpl(C1740R.string.default_error_message), $composer4, 0)), TextFieldDefaults.INSTANCE.m2643getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2642getMinHeightD9Ej5fM());
                        SolidColor solidColor = new SolidColor(colors2.cursorColor$material3_release(isError2, $composer4, 0).getValue().m3959unboximpl(), null);
                        final TextFieldValue textFieldValue2 = textFieldValue;
                        final boolean z2 = enabled3;
                        final boolean z3 = singleLine2;
                        final VisualTransformation visualTransformation5 = visualTransformation2;
                        final MutableInteractionSource mutableInteractionSource = interactionSource3;
                        final boolean z4 = isError2;
                        final Function2<Composer, Integer, Unit> function28 = label2;
                        final Function2<Composer, Integer, Unit> function29 = placeholder2;
                        final Function2<Composer, Integer, Unit> function210 = leadingIcon2;
                        final Function2<Composer, Integer, Unit> function211 = trailingIcon;
                        final Function2<Composer, Integer, Unit> function212 = prefix;
                        final Function2<Composer, Integer, Unit> function213 = suffix;
                        final Function2<Composer, Integer, Unit> function214 = supportingText;
                        final Shape shape5 = shape3;
                        final TextFieldColors textFieldColors = colors2;
                        BasicTextFieldKt.BasicTextField(textFieldValue, function13, modifierM800defaultMinSizeVpY3zN4, enabled3, readOnly3, mergedTextStyle, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, minLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, solidColor, ComposableLambdaKt.composableLambda($composer4, 1751957978, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function215, Composer composer, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function215, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function215, Composer $composer5, int $changed4) {
                                Function2<? super Composer, ? super Integer, Unit> function216;
                                ComposerKt.sourceInformation($composer5, "C368@19571L748:TextField.kt#uh7d8r");
                                int $dirty3 = $changed4;
                                if (($changed4 & 6) == 0) {
                                    function216 = function215;
                                    $dirty3 |= $composer5.changedInstance(function216) ? 4 : 2;
                                } else {
                                    function216 = function215;
                                }
                                if (($dirty3 & 19) == 18 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1751957978, $dirty3, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:368)");
                                }
                                TextFieldDefaults.INSTANCE.DecorationBox(textFieldValue2.getText(), function216, z2, z3, visualTransformation5, mutableInteractionSource, z4, function28, function29, function210, function211, function212, function213, function214, shape5, textFieldColors, null, null, $composer5, ($dirty3 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.f249xf2722a21);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), $composer4, 0, ProfileVerifier.CompilationStatus.f249xf2722a21, 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, ProvidedValue.$stable | 0 | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            enabled4 = enabled3;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            maxLines3 = maxLines2;
            minLines3 = minLines2;
            visualTransformation3 = visualTransformation2;
            interactionSource4 = interactionSource3;
            placeholder3 = placeholder2;
            trailingIcon2 = trailingIcon;
            prefix2 = prefix;
            suffix2 = suffix;
            colors3 = colors2;
            readOnly4 = readOnly3;
            readOnly5 = singleLine2;
            label3 = label2;
            shape4 = shape3;
            textStyle4 = textStyle3;
            isError3 = isError2;
            supportingText2 = supportingText;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Function2 leadingIcon4 = leadingIcon2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.6
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

                public final void invoke(Composer composer, int i28) {
                    TextFieldKt.TextField(value, function1, modifier4, enabled4, readOnly4, textStyle4, label3, placeholder3, leadingIcon4, trailingIcon2, prefix2, suffix2, supportingText2, isError3, visualTransformation3, keyboardOptions3, keyboardActions3, readOnly5, maxLines3, minLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    public static final /* synthetic */ void TextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, Function2 supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        Function2 label2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        KeyboardOptions keyboardOptions2;
        int maxLines2;
        Function2 placeholder2;
        Function2 leadingIcon2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        TextFieldColors colors2;
        int $dirty;
        int $dirty1;
        boolean enabled3;
        Function2 label3;
        int maxLines3;
        int minLines2;
        Function2 placeholder3;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        Function2 trailingIcon2;
        int $dirty2;
        Modifier modifier3;
        Function2 supportingText2;
        boolean readOnly3;
        TextStyle textStyle3;
        Function2 leadingIcon3;
        Object value$iv;
        Composer $composer2;
        final Modifier modifier4;
        final boolean enabled4;
        final boolean readOnly4;
        final TextStyle textStyle4;
        final Function2 label4;
        final Function2 placeholder4;
        final Function2 leadingIcon4;
        final Function2 label5;
        final Function2 placeholder5;
        final boolean isError3;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean singleLine3;
        final int maxLines4;
        final int minLines3;
        final MutableInteractionSource interactionSource4;
        final Shape shape4;
        final TextFieldColors colors3;
        int i9;
        Composer $composer3 = $composer.startRestartGroup(-1500728277);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)400@20694L7,413@21354L39,414@21432L5,415@21487L8,417@21504L763:TextField.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty12 = $changed1;
        int $dirty22 = $changed2;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i10 = i & 4;
        if (i10 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i11 = i & 8;
        if (i11 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i12 = i & 16;
        if (i12 != 0) {
            $dirty3 |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 24576) == 0) {
            readOnly2 = readOnly;
            $dirty3 |= $composer3.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                if ($composer3.changed(textStyle2)) {
                    i9 = 131072;
                }
                $dirty3 |= i9;
            } else {
                textStyle2 = textStyle;
            }
            i9 = 65536;
            $dirty3 |= i9;
        } else {
            textStyle2 = textStyle;
        }
        int i13 = i & 64;
        if (i13 != 0) {
            $dirty3 |= 1572864;
            label2 = label;
        } else if (($changed & 1572864) == 0) {
            label2 = label;
            $dirty3 |= $composer3.changedInstance(label2) ? 1048576 : 524288;
        } else {
            label2 = label;
        }
        int i14 = i & 128;
        if (i14 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer3.changedInstance(placeholder) ? 8388608 : 4194304;
        }
        int i15 = i & 256;
        if (i15 != 0) {
            $dirty3 |= 100663296;
            i2 = i15;
        } else if (($changed & 100663296) == 0) {
            i2 = i15;
            $dirty3 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i15;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty3 |= 805306368;
            i3 = i16;
        } else if (($changed & 805306368) == 0) {
            i3 = i16;
            $dirty3 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        } else {
            i3 = i16;
        }
        int i17 = i & 1024;
        if (i17 != 0) {
            $dirty12 |= 6;
            i4 = i17;
        } else if (($changed1 & 6) == 0) {
            i4 = i17;
            $dirty12 |= $composer3.changedInstance(supportingText) ? 4 : 2;
        } else {
            i4 = i17;
        }
        int i18 = i & 2048;
        if (i18 != 0) {
            $dirty12 |= 48;
            i5 = i18;
        } else if (($changed1 & 48) == 0) {
            i5 = i18;
            $dirty12 |= $composer3.changed(isError) ? 32 : 16;
        } else {
            i5 = i18;
        }
        int i19 = i & 4096;
        if (i19 != 0) {
            $dirty12 |= 384;
            i6 = i19;
        } else {
            i6 = i19;
            if (($changed1 & 384) == 0) {
                $dirty12 |= $composer3.changed(visualTransformation) ? 256 : 128;
            }
        }
        int i20 = i & 8192;
        if (i20 != 0) {
            $dirty12 |= 3072;
            i7 = i20;
        } else {
            i7 = i20;
            if (($changed1 & 3072) == 0) {
                $dirty12 |= $composer3.changed(keyboardOptions) ? 2048 : 1024;
            }
        }
        int i21 = i & 16384;
        if (i21 != 0) {
            $dirty12 |= 24576;
            i8 = i21;
        } else {
            i8 = i21;
            if (($changed1 & 24576) == 0) {
                $dirty12 |= $composer3.changed(keyboardActions) ? 16384 : 8192;
            }
        }
        int i22 = i & 32768;
        if (i22 != 0) {
            $dirty12 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            $dirty12 |= $composer3.changed(singleLine) ? 131072 : 65536;
        }
        if (($changed1 & 1572864) == 0) {
            $dirty12 |= ((i & 65536) == 0 && $composer3.changed(maxLines)) ? 1048576 : 524288;
        }
        int i23 = i & 131072;
        if (i23 != 0) {
            $dirty12 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty12 |= $composer3.changed(minLines) ? 8388608 : 4194304;
        }
        int i24 = i & 262144;
        if (i24 != 0) {
            $dirty12 |= 100663296;
        } else if (($changed1 & 100663296) == 0) {
            $dirty12 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 805306368) == 0) {
            $dirty12 |= ((i & 524288) == 0 && $composer3.changed(shape)) ? 536870912 : 268435456;
        }
        if (($changed2 & 6) == 0) {
            $dirty22 |= ((i & 1048576) == 0 && $composer3.changed(colors)) ? 4 : 2;
        }
        if (($dirty3 & 306783379) == 306783378 && (306783379 & $dirty12) == 306783378 && ($dirty22 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            leadingIcon4 = leadingIcon;
            label5 = trailingIcon;
            visualTransformation3 = visualTransformation;
            singleLine3 = singleLine;
            maxLines4 = maxLines;
            minLines3 = minLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            $composer2 = $composer3;
            modifier4 = modifier2;
            enabled4 = enabled2;
            readOnly4 = readOnly2;
            textStyle4 = textStyle2;
            label4 = label2;
            placeholder4 = placeholder;
            placeholder5 = supportingText;
            isError3 = isError;
            keyboardOptions3 = keyboardOptions;
            keyboardActions3 = keyboardActions;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i10 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i11 != 0) {
                    enabled2 = true;
                }
                if (i12 != 0) {
                    readOnly2 = false;
                }
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $dirty3 &= -458753;
                    textStyle2 = (TextStyle) objConsume;
                }
                if (i13 != 0) {
                    label2 = null;
                }
                Function2 placeholder6 = i14 != 0 ? null : placeholder;
                Function2 leadingIcon5 = i2 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i3 != 0 ? null : trailingIcon;
                Function2 supportingText3 = i4 != 0 ? null : supportingText;
                boolean isError4 = i5 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i6 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                keyboardOptions2 = i7 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions4 = i8 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine4 = i22 != 0 ? false : singleLine;
                if ((i & 65536) != 0) {
                    maxLines2 = singleLine4 ? 1 : Integer.MAX_VALUE;
                    $dirty12 &= -3670017;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines4 = i23 != 0 ? 1 : minLines;
                if (i24 != 0) {
                    placeholder2 = placeholder6;
                    $composer3.startReplaceableGroup(-1263320224);
                    ComposerKt.sourceInformation($composer3, "CC(remember):TextField.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    leadingIcon2 = leadingIcon5;
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    $composer3.endReplaceableGroup();
                } else {
                    placeholder2 = placeholder6;
                    leadingIcon2 = leadingIcon5;
                    interactionSource2 = interactionSource;
                }
                MutableInteractionSource interactionSource5 = interactionSource2;
                if ((i & 524288) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty12 &= -1879048193;
                } else {
                    shape2 = shape;
                }
                if ((i & 1048576) != 0) {
                    Shape shape5 = shape2;
                    int i25 = $dirty22 & (-15);
                    interactionSource3 = interactionSource5;
                    shape3 = shape5;
                    colors2 = TextFieldDefaults.INSTANCE.colors($composer3, 6);
                    $dirty = $dirty3;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    label3 = label2;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                    placeholder3 = placeholder2;
                    leadingIcon3 = leadingIcon2;
                    keyboardActions2 = keyboardActions4;
                    singleLine2 = singleLine4;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    trailingIcon2 = trailingIcon3;
                    supportingText2 = supportingText3;
                    textStyle3 = textStyle2;
                    $dirty2 = i25;
                    $dirty1 = $dirty12;
                } else {
                    interactionSource3 = interactionSource5;
                    shape3 = shape2;
                    colors2 = colors;
                    $dirty = $dirty3;
                    $dirty1 = $dirty12;
                    enabled3 = enabled2;
                    label3 = label2;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                    placeholder3 = placeholder2;
                    keyboardActions2 = keyboardActions4;
                    singleLine2 = singleLine4;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    trailingIcon2 = trailingIcon3;
                    $dirty2 = $dirty22;
                    modifier3 = modifier2;
                    supportingText2 = supportingText3;
                    readOnly3 = readOnly2;
                    textStyle3 = textStyle2;
                    leadingIcon3 = leadingIcon2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty12 &= -3670017;
                }
                if ((i & 524288) != 0) {
                    $dirty12 &= -1879048193;
                }
                if ((i & 1048576) != 0) {
                    trailingIcon2 = trailingIcon;
                    supportingText2 = supportingText;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines3 = maxLines;
                    minLines2 = minLines;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    colors2 = colors;
                    $dirty2 = $dirty22 & (-15);
                    $dirty = $dirty3;
                    $dirty1 = $dirty12;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    textStyle3 = textStyle2;
                    label3 = label2;
                    placeholder3 = placeholder;
                    leadingIcon3 = leadingIcon;
                } else {
                    trailingIcon2 = trailingIcon;
                    supportingText2 = supportingText;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines3 = maxLines;
                    minLines2 = minLines;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    colors2 = colors;
                    $dirty = $dirty3;
                    $dirty1 = $dirty12;
                    $dirty2 = $dirty22;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    textStyle3 = textStyle2;
                    label3 = label2;
                    placeholder3 = placeholder;
                    leadingIcon3 = leadingIcon;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1500728277, $dirty, $dirty1, "androidx.compose.material3.TextField (TextField.kt:416)");
            }
            $composer2 = $composer3;
            TextField(value, (Function1<? super String, Unit>) onValueChange, modifier3, enabled3, readOnly3, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) label3, (Function2<? super Composer, ? super Integer, Unit>) placeholder3, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon3, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) supportingText2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines3, minLines2, interactionSource3, shape3, colors2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), (($dirty1 << 6) & 896) | 54 | (($dirty1 << 6) & 7168) | (($dirty1 << 6) & 57344) | (($dirty1 << 6) & 458752) | (($dirty1 << 6) & 3670016) | (($dirty1 << 6) & 29360128) | (($dirty1 << 6) & 234881024) | (($dirty1 << 6) & 1879048192), (($dirty1 >> 24) & 14) | (($dirty1 >> 24) & 112) | (($dirty2 << 6) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            enabled4 = enabled3;
            readOnly4 = readOnly3;
            textStyle4 = textStyle3;
            label4 = label3;
            placeholder4 = placeholder3;
            leadingIcon4 = leadingIcon3;
            label5 = trailingIcon2;
            placeholder5 = supportingText2;
            isError3 = isError2;
            visualTransformation3 = visualTransformation2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            singleLine3 = singleLine2;
            maxLines4 = maxLines3;
            minLines3 = minLines2;
            interactionSource4 = interactionSource3;
            shape4 = shape3;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.8
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

                public final void invoke(Composer composer, int i26) {
                    TextFieldKt.TextField(value, onValueChange, modifier4, enabled4, readOnly4, textStyle4, label4, placeholder4, leadingIcon4, label5, placeholder5, isError3, visualTransformation3, keyboardOptions3, keyboardActions3, singleLine3, maxLines4, minLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    public static final /* synthetic */ void TextField(final TextFieldValue value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, Function2 supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        Function2 label2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        KeyboardOptions keyboardOptions2;
        int maxLines2;
        Function2 placeholder2;
        Function2 leadingIcon2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        TextFieldColors colors2;
        int $dirty;
        int $dirty1;
        boolean enabled3;
        Function2 label3;
        int maxLines3;
        int minLines2;
        Function2 placeholder3;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        Function2 trailingIcon2;
        int $dirty2;
        Modifier modifier3;
        Function2 supportingText2;
        boolean readOnly3;
        TextStyle textStyle3;
        Function2 leadingIcon3;
        Object value$iv;
        Composer $composer2;
        final Modifier modifier4;
        final boolean enabled4;
        final boolean readOnly4;
        final TextStyle textStyle4;
        final Function2 label4;
        final Function2 placeholder4;
        final Function2 leadingIcon4;
        final Function2 label5;
        final Function2 placeholder5;
        final boolean isError3;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean singleLine3;
        final int maxLines4;
        final int minLines3;
        final MutableInteractionSource interactionSource4;
        final Shape shape4;
        final TextFieldColors colors3;
        int i9;
        Composer $composer3 = $composer.startRestartGroup(1523846136);
        ComposerKt.sourceInformation($composer3, "C(TextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)453@22628L7,466@23288L39,467@23366L5,468@23421L8,470@23438L763:TextField.kt#uh7d8r");
        int $dirty3 = $changed;
        int $dirty12 = $changed1;
        int $dirty22 = $changed2;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i10 = i & 4;
        if (i10 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i11 = i & 8;
        if (i11 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i12 = i & 16;
        if (i12 != 0) {
            $dirty3 |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 24576) == 0) {
            readOnly2 = readOnly;
            $dirty3 |= $composer3.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                if ($composer3.changed(textStyle2)) {
                    i9 = 131072;
                }
                $dirty3 |= i9;
            } else {
                textStyle2 = textStyle;
            }
            i9 = 65536;
            $dirty3 |= i9;
        } else {
            textStyle2 = textStyle;
        }
        int i13 = i & 64;
        if (i13 != 0) {
            $dirty3 |= 1572864;
            label2 = label;
        } else if (($changed & 1572864) == 0) {
            label2 = label;
            $dirty3 |= $composer3.changedInstance(label2) ? 1048576 : 524288;
        } else {
            label2 = label;
        }
        int i14 = i & 128;
        if (i14 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer3.changedInstance(placeholder) ? 8388608 : 4194304;
        }
        int i15 = i & 256;
        if (i15 != 0) {
            $dirty3 |= 100663296;
            i2 = i15;
        } else if (($changed & 100663296) == 0) {
            i2 = i15;
            $dirty3 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i15;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty3 |= 805306368;
            i3 = i16;
        } else if (($changed & 805306368) == 0) {
            i3 = i16;
            $dirty3 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        } else {
            i3 = i16;
        }
        int i17 = i & 1024;
        if (i17 != 0) {
            $dirty12 |= 6;
            i4 = i17;
        } else if (($changed1 & 6) == 0) {
            i4 = i17;
            $dirty12 |= $composer3.changedInstance(supportingText) ? 4 : 2;
        } else {
            i4 = i17;
        }
        int i18 = i & 2048;
        if (i18 != 0) {
            $dirty12 |= 48;
            i5 = i18;
        } else if (($changed1 & 48) == 0) {
            i5 = i18;
            $dirty12 |= $composer3.changed(isError) ? 32 : 16;
        } else {
            i5 = i18;
        }
        int i19 = i & 4096;
        if (i19 != 0) {
            $dirty12 |= 384;
            i6 = i19;
        } else {
            i6 = i19;
            if (($changed1 & 384) == 0) {
                $dirty12 |= $composer3.changed(visualTransformation) ? 256 : 128;
            }
        }
        int i20 = i & 8192;
        if (i20 != 0) {
            $dirty12 |= 3072;
            i7 = i20;
        } else {
            i7 = i20;
            if (($changed1 & 3072) == 0) {
                $dirty12 |= $composer3.changed(keyboardOptions) ? 2048 : 1024;
            }
        }
        int i21 = i & 16384;
        if (i21 != 0) {
            $dirty12 |= 24576;
            i8 = i21;
        } else {
            i8 = i21;
            if (($changed1 & 24576) == 0) {
                $dirty12 |= $composer3.changed(keyboardActions) ? 16384 : 8192;
            }
        }
        int i22 = i & 32768;
        if (i22 != 0) {
            $dirty12 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed1 & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            $dirty12 |= $composer3.changed(singleLine) ? 131072 : 65536;
        }
        if (($changed1 & 1572864) == 0) {
            $dirty12 |= ((i & 65536) == 0 && $composer3.changed(maxLines)) ? 1048576 : 524288;
        }
        int i23 = i & 131072;
        if (i23 != 0) {
            $dirty12 |= 12582912;
        } else if (($changed1 & 12582912) == 0) {
            $dirty12 |= $composer3.changed(minLines) ? 8388608 : 4194304;
        }
        int i24 = i & 262144;
        if (i24 != 0) {
            $dirty12 |= 100663296;
        } else if (($changed1 & 100663296) == 0) {
            $dirty12 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 805306368) == 0) {
            $dirty12 |= ((i & 524288) == 0 && $composer3.changed(shape)) ? 536870912 : 268435456;
        }
        if (($changed2 & 6) == 0) {
            $dirty22 |= ((i & 1048576) == 0 && $composer3.changed(colors)) ? 4 : 2;
        }
        if (($dirty3 & 306783379) == 306783378 && (306783379 & $dirty12) == 306783378 && ($dirty22 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            leadingIcon4 = leadingIcon;
            label5 = trailingIcon;
            visualTransformation3 = visualTransformation;
            singleLine3 = singleLine;
            maxLines4 = maxLines;
            minLines3 = minLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            $composer2 = $composer3;
            modifier4 = modifier2;
            enabled4 = enabled2;
            readOnly4 = readOnly2;
            textStyle4 = textStyle2;
            label4 = label2;
            placeholder4 = placeholder;
            placeholder5 = supportingText;
            isError3 = isError;
            keyboardOptions3 = keyboardOptions;
            keyboardActions3 = keyboardActions;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i10 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i11 != 0) {
                    enabled2 = true;
                }
                if (i12 != 0) {
                    readOnly2 = false;
                }
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $dirty3 &= -458753;
                    textStyle2 = (TextStyle) objConsume;
                }
                if (i13 != 0) {
                    label2 = null;
                }
                Function2 placeholder6 = i14 != 0 ? null : placeholder;
                Function2 leadingIcon5 = i2 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i3 != 0 ? null : trailingIcon;
                Function2 supportingText3 = i4 != 0 ? null : supportingText;
                boolean isError4 = i5 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i6 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                keyboardOptions2 = i7 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions4 = i8 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine4 = i22 != 0 ? false : singleLine;
                if ((i & 65536) != 0) {
                    maxLines2 = singleLine4 ? 1 : Integer.MAX_VALUE;
                    $dirty12 &= -3670017;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines4 = i23 != 0 ? 1 : minLines;
                if (i24 != 0) {
                    placeholder2 = placeholder6;
                    $composer3.startReplaceableGroup(-1263318290);
                    ComposerKt.sourceInformation($composer3, "CC(remember):TextField.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    leadingIcon2 = leadingIcon5;
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    $composer3.endReplaceableGroup();
                } else {
                    placeholder2 = placeholder6;
                    leadingIcon2 = leadingIcon5;
                    interactionSource2 = interactionSource;
                }
                MutableInteractionSource interactionSource5 = interactionSource2;
                if ((i & 524288) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty12 &= -1879048193;
                } else {
                    shape2 = shape;
                }
                if ((i & 1048576) != 0) {
                    Shape shape5 = shape2;
                    int i25 = $dirty22 & (-15);
                    interactionSource3 = interactionSource5;
                    shape3 = shape5;
                    colors2 = TextFieldDefaults.INSTANCE.colors($composer3, 6);
                    $dirty = $dirty3;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    label3 = label2;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                    placeholder3 = placeholder2;
                    leadingIcon3 = leadingIcon2;
                    keyboardActions2 = keyboardActions4;
                    singleLine2 = singleLine4;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    trailingIcon2 = trailingIcon3;
                    supportingText2 = supportingText3;
                    textStyle3 = textStyle2;
                    $dirty2 = i25;
                    $dirty1 = $dirty12;
                } else {
                    interactionSource3 = interactionSource5;
                    shape3 = shape2;
                    colors2 = colors;
                    $dirty = $dirty3;
                    $dirty1 = $dirty12;
                    enabled3 = enabled2;
                    label3 = label2;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                    placeholder3 = placeholder2;
                    keyboardActions2 = keyboardActions4;
                    singleLine2 = singleLine4;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    trailingIcon2 = trailingIcon3;
                    $dirty2 = $dirty22;
                    modifier3 = modifier2;
                    supportingText2 = supportingText3;
                    readOnly3 = readOnly2;
                    textStyle3 = textStyle2;
                    leadingIcon3 = leadingIcon2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 65536) != 0) {
                    $dirty12 &= -3670017;
                }
                if ((i & 524288) != 0) {
                    $dirty12 &= -1879048193;
                }
                if ((i & 1048576) != 0) {
                    trailingIcon2 = trailingIcon;
                    supportingText2 = supportingText;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines3 = maxLines;
                    minLines2 = minLines;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    colors2 = colors;
                    $dirty2 = $dirty22 & (-15);
                    $dirty = $dirty3;
                    $dirty1 = $dirty12;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    textStyle3 = textStyle2;
                    label3 = label2;
                    placeholder3 = placeholder;
                    leadingIcon3 = leadingIcon;
                } else {
                    trailingIcon2 = trailingIcon;
                    supportingText2 = supportingText;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines3 = maxLines;
                    minLines2 = minLines;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    colors2 = colors;
                    $dirty = $dirty3;
                    $dirty1 = $dirty12;
                    $dirty2 = $dirty22;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    readOnly3 = readOnly2;
                    textStyle3 = textStyle2;
                    label3 = label2;
                    placeholder3 = placeholder;
                    leadingIcon3 = leadingIcon;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1523846136, $dirty, $dirty1, "androidx.compose.material3.TextField (TextField.kt:469)");
            }
            $composer2 = $composer3;
            TextField(value, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier3, enabled3, readOnly3, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) label3, (Function2<? super Composer, ? super Integer, Unit>) placeholder3, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon3, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) supportingText2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines3, minLines2, interactionSource3, shape3, colors2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), (($dirty1 << 6) & 896) | 54 | (($dirty1 << 6) & 7168) | (($dirty1 << 6) & 57344) | (($dirty1 << 6) & 458752) | (($dirty1 << 6) & 3670016) | (($dirty1 << 6) & 29360128) | (($dirty1 << 6) & 234881024) | (($dirty1 << 6) & 1879048192), (($dirty1 >> 24) & 14) | (($dirty1 >> 24) & 112) | (($dirty2 << 6) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            enabled4 = enabled3;
            readOnly4 = readOnly3;
            textStyle4 = textStyle3;
            label4 = label3;
            placeholder4 = placeholder3;
            leadingIcon4 = leadingIcon3;
            label5 = trailingIcon2;
            placeholder5 = supportingText2;
            isError3 = isError2;
            visualTransformation3 = visualTransformation2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            singleLine3 = singleLine2;
            maxLines4 = maxLines3;
            minLines3 = minLines2;
            interactionSource4 = interactionSource3;
            shape4 = shape3;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.10
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

                public final void invoke(Composer composer, int i26) {
                    TextFieldKt.TextField(value, onValueChange, modifier4, enabled4, readOnly4, textStyle4, label4, placeholder4, leadingIcon4, label5, placeholder5, isError3, visualTransformation3, keyboardOptions3, keyboardActions3, singleLine3, maxLines4, minLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x074c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0760  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x08d6  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0a5b  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0a5e  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0a6a  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0a6d  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0a90  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0aac  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0b20  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0b2c  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0b32  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0c0c  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0d76  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0d91  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TextFieldLayout(final androidx.compose.p000ui.Modifier r62, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r63, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r64, kotlin.jvm.functions.Function3<? super androidx.compose.p000ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r65, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r66, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r67, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, final boolean r70, final float r71, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r72, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, final androidx.compose.foundation.layout.PaddingValues r74, androidx.compose.runtime.Composer r75, final int r76, final int r77) {
        /*
            Method dump skipped, instructions count: 3518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int substractConstraintSafely(int $this$substractConstraintSafely, int from) {
        if ($this$substractConstraintSafely == Integer.MAX_VALUE) {
            return $this$substractConstraintSafely;
        }
        return $this$substractConstraintSafely - from;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-yeHjK3Y, reason: not valid java name */
    public static final int m2664calculateWidthyeHjK3Y(int leadingWidth, int trailingWidth, int prefixWidth, int suffixWidth, int textFieldWidth, int labelWidth, int placeholderWidth, long constraints) {
        int affixTotalWidth = prefixWidth + suffixWidth;
        int middleSection = Math.max(textFieldWidth + affixTotalWidth, Math.max(placeholderWidth + affixTotalWidth, labelWidth));
        int wrappedWidth = leadingWidth + middleSection + trailingWidth;
        return Math.max(wrappedWidth, Constraints.m6255getMinWidthimpl(constraints));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    public static final int m2663calculateHeightmKXJcVc(int textFieldHeight, int labelHeight, int leadingHeight, int trailingHeight, int prefixHeight, int suffixHeight, int placeholderHeight, int supportingHeight, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        float actualVerticalPadding;
        boolean hasLabel = labelHeight > 0;
        float arg0$iv = paddingValues.getTop();
        float other$iv = paddingValues.getBottom();
        float verticalPadding = C1956Dp.m6297constructorimpl(arg0$iv + other$iv) * density;
        if (hasLabel) {
            float arg0$iv2 = TextFieldImplKt.getTextFieldPadding();
            actualVerticalPadding = MathHelpersKt.lerp(C1956Dp.m6297constructorimpl(2 * arg0$iv2) * density, verticalPadding, animationProgress);
        } else {
            actualVerticalPadding = verticalPadding;
        }
        int inputFieldHeight = ComparisonsKt.maxOf(textFieldHeight, placeholderHeight, prefixHeight, suffixHeight, MathHelpersKt.lerp(labelHeight, 0, animationProgress));
        float middleSectionHeight = MathHelpersKt.lerp(0, labelHeight, animationProgress) + actualVerticalPadding + inputFieldHeight;
        return Math.max(Constraints.m6254getMinHeightimpl(constraints), Math.max(leadingHeight, Math.max(trailingHeight, MathKt.roundToInt(middleSectionHeight))) + supportingHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope $this$placeWithLabel, int width, int totalHeight, Placeable textfieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, int labelEndPosition, int textPosition, float animationProgress, float density) {
        int startPosition;
        Placeable.PlacementScope.m5270place70tqf50$default($this$placeWithLabel, containerPlaceable, IntOffset.INSTANCE.m6435getZeronOccac(), 0.0f, 2, null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (labelPlaceable != null) {
            if (singleLine) {
                startPosition = Alignment.INSTANCE.getCenterVertically().align(labelPlaceable.getHeight(), height);
            } else {
                startPosition = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * density);
            }
            int distance = startPosition - labelEndPosition;
            int positionY = startPosition - MathKt.roundToInt(distance * animationProgress);
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, labelPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), positionY, 0.0f, 4, null);
        }
        if (prefixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, prefixPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0.0f, 4, null);
        }
        if (suffixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, suffixPlaceable, (width - TextFieldImplKt.widthOrZero(trailingPlaceable)) - suffixPlaceable.getWidth(), textPosition, 0.0f, 4, null);
        }
        int textHorizontalPosition = TextFieldImplKt.widthOrZero(leadingPlaceable) + TextFieldImplKt.widthOrZero(prefixPlaceable);
        Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, textfieldPlaceable, textHorizontalPosition, textPosition, 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeholderPlaceable, textHorizontalPosition, textPosition, 0.0f, 4, null);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, supportingPlaceable, 0, height, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope $this$placeWithoutLabel, int width, int totalHeight, Placeable textPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, float density, PaddingValues paddingValues) {
        Placeable.PlacementScope.m5270place70tqf50$default($this$placeWithoutLabel, containerPlaceable, IntOffset.INSTANCE.m6435getZeronOccac(), 0.0f, 2, null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        int topPadding = MathKt.roundToInt(paddingValues.getTop() * density);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (prefixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, prefixPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), placeWithoutLabel$calculateVerticalPosition(singleLine, height, topPadding, prefixPlaceable), 0.0f, 4, null);
        }
        if (suffixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, suffixPlaceable, (width - TextFieldImplKt.widthOrZero(trailingPlaceable)) - suffixPlaceable.getWidth(), placeWithoutLabel$calculateVerticalPosition(singleLine, height, topPadding, suffixPlaceable), 0.0f, 4, null);
        }
        int textHorizontalPosition = TextFieldImplKt.widthOrZero(prefixPlaceable) + TextFieldImplKt.widthOrZero(leadingPlaceable);
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, textPlaceable, textHorizontalPosition, placeWithoutLabel$calculateVerticalPosition(singleLine, height, topPadding, textPlaceable), 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, placeholderPlaceable, textHorizontalPosition, placeWithoutLabel$calculateVerticalPosition(singleLine, height, topPadding, placeholderPlaceable), 0.0f, 4, null);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, supportingPlaceable, 0, height, 0.0f, 4, null);
        }
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(boolean $singleLine, int height, int topPadding, Placeable placeable) {
        if ($singleLine) {
            return Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), height);
        }
        return topPadding;
    }

    public static final Modifier drawIndicatorLine(Modifier $this$drawIndicatorLine, final BorderStroke indicatorBorder) {
        final float strokeWidthDp = indicatorBorder.getWidth();
        return DrawModifierKt.drawWithContent($this$drawIndicatorLine, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TextFieldKt.drawIndicatorLine.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope $this$drawWithContent) {
                $this$drawWithContent.drawContent();
                if (C1956Dp.m6302equalsimpl0(strokeWidthDp, C1956Dp.INSTANCE.m6315getHairlineD9Ej5fM())) {
                    return;
                }
                float strokeWidth = strokeWidthDp * $this$drawWithContent.getDensity();
                float y = Size.m3774getHeightimpl($this$drawWithContent.mo4498getSizeNHjbRc()) - (strokeWidth / 2);
                DrawScope.m4484drawLine1RTmtNc$default($this$drawWithContent, indicatorBorder.getBrush(), OffsetKt.Offset(0.0f, y), OffsetKt.Offset(Size.m3777getWidthimpl($this$drawWithContent.mo4498getSizeNHjbRc()), y), strokeWidth, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldWithLabelVerticalPadding;
    }
}
