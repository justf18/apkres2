package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.ClipOp;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shadow;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawContext;
import androidx.compose.p000ui.graphics.drawscope.DrawStyle;
import androidx.compose.p000ui.graphics.drawscope.DrawTransform;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
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
import androidx.compose.p000ui.unit.LayoutDirection;
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
import kotlin.ranges.RangesKt;

/* compiled from: OutlinedTextField.kt */
@Metadata(m164d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010-\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010.\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00100\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00101\u001a\u0080\u0002\u00102\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0019\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0002\b\u00152\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010#\u001a\u00020\u000f2\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00070\u000b2\u0011\u0010:\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010<\u001a\u00020=H\u0001¢\u0006\u0002\u0010>\u001ar\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001aj\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a&\u0010W\u001a\u00020\r*\u00020\r2\u0006\u0010X\u001a\u0002092\u0006\u0010<\u001a\u00020=H\u0000ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\u001a\u009a\u0001\u0010[\u001a\u00020\u0007*\u00020\\2\u0006\u0010]\u001a\u00020%2\u0006\u0010^\u001a\u00020%2\b\u0010_\u001a\u0004\u0018\u00010`2\b\u0010a\u001a\u0004\u0018\u00010`2\b\u0010b\u001a\u0004\u0018\u00010`2\b\u0010c\u001a\u0004\u0018\u00010`2\u0006\u0010d\u001a\u00020`2\b\u0010e\u001a\u0004\u0018\u00010`2\b\u0010f\u001a\u0004\u0018\u00010`2\u0006\u0010g\u001a\u00020`2\b\u0010h\u001a\u0004\u0018\u00010`2\u0006\u00106\u001a\u0002072\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010J\u001a\u0002072\u0006\u0010i\u001a\u00020j2\u0006\u0010<\u001a\u00020=H\u0002\u001a\u0014\u0010k\u001a\u00020%*\u00020%2\u0006\u0010l\u001a\u00020%H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006m"}, m165d2 = {"OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "textFieldHeight", "labelHeight", "placeholderHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-DHJA7U0", "(IIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "substractConstraintSafely", TypedValues.TransitionType.S_FROM, "material3_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class OutlinedTextFieldKt {
    private static final float OutlinedTextFieldInnerPadding = C1956Dp.m6297constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = C1956Dp.m6297constructorimpl(8);

    public static final void OutlinedTextField(final String value, final Function1<? super String, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        String str;
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
        int maxLines2;
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
        final Function2 suffix;
        final Function2 supportingText;
        final VisualTransformation visualTransformation2;
        final boolean isError2;
        final int minLines2;
        final Modifier modifier3;
        final boolean enabled3;
        final int minLines3;
        final boolean singleLine2;
        final KeyboardActions keyboardActions2;
        final KeyboardOptions keyboardOptions2;
        final boolean readOnly3;
        final Function2 label2;
        final TextFieldColors colors2;
        Object value$iv;
        Composer $composer2;
        long jM3959unboximpl;
        final boolean enabled4;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean enabled5;
        final int minLines4;
        final MutableInteractionSource interactionSource4;
        final Function2 placeholder3;
        final Function2 trailingIcon2;
        final Function2 prefix2;
        final Function2 supportingText2;
        final Shape shape4;
        final Function2 label3;
        final TextFieldColors colors3;
        final boolean readOnly4;
        final int maxLines3;
        final VisualTransformation visualTransformation3;
        final Function2 label4;
        final TextStyle textStyle4;
        int i10;
        Composer $composer3 = $composer.startRestartGroup(-1922450045);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)147@8277L7,162@9029L39,163@9115L5,164@9178L8,172@9540L15,172@9474L2524:OutlinedTextField.kt#uh7d8r");
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
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
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
            prefix2 = function25;
            isError2 = isError;
            keyboardOptions3 = keyboardOptions;
            keyboardActions3 = keyboardActions;
            enabled5 = singleLine;
            maxLines3 = maxLines;
            minLines4 = minLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            $composer2 = $composer3;
            enabled4 = enabled2;
            readOnly4 = readOnly2;
            textStyle4 = textStyle2;
            label3 = label;
            trailingIcon2 = function24;
            label4 = function26;
            supportingText2 = function27;
            visualTransformation3 = visualTransformation;
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
                Function2 suffix2 = i6 != 0 ? null : function26;
                Function2 supportingText3 = i7 != 0 ? null : function27;
                boolean isError3 = i8 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i9 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i23 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions4 = i24 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine3 = i25 != 0 ? false : singleLine;
                if ((i & 262144) != 0) {
                    maxLines2 = singleLine3 ? 1 : Integer.MAX_VALUE;
                    $dirty1 &= -234881025;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines5 = i26 != 0 ? 1 : minLines;
                if (i27 != 0) {
                    placeholder = placeholder4;
                    $composer3.startReplaceableGroup(1663535677);
                    ComposerKt.sourceInformation($composer3, "CC(remember):OutlinedTextField.kt#9igjgp");
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
                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape($composer3, 6);
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
                    suffix = suffix2;
                    supportingText = supportingText3;
                    visualTransformation2 = visualTransformation4;
                    isError2 = isError3;
                    minLines2 = minLines5;
                    enabled3 = enabled2;
                    minLines3 = maxLines2;
                    singleLine2 = singleLine3;
                    keyboardActions2 = keyboardActions4;
                    keyboardOptions2 = keyboardOptions4;
                    readOnly3 = readOnly2;
                    label2 = label;
                    colors2 = OutlinedTextFieldDefaults.INSTANCE.colors($composer3, 6);
                    textStyle3 = textStyle2;
                    modifier3 = modifier2;
                } else {
                    placeholder2 = placeholder;
                    interactionSource3 = interactionSource5;
                    shape3 = shape2;
                    leadingIcon2 = leadingIcon;
                    trailingIcon = trailingIcon3;
                    textStyle3 = textStyle2;
                    prefix = prefix3;
                    suffix = suffix2;
                    supportingText = supportingText3;
                    visualTransformation2 = visualTransformation4;
                    isError2 = isError3;
                    minLines2 = minLines5;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    minLines3 = maxLines2;
                    singleLine2 = singleLine3;
                    keyboardActions2 = keyboardActions4;
                    keyboardOptions2 = keyboardOptions4;
                    readOnly3 = readOnly2;
                    label2 = label;
                    colors2 = colors;
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
                    minLines3 = maxLines;
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
                    minLines3 = maxLines;
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
                ComposerKt.traceEventStart(-1922450045, $dirty, $dirty1, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:165)");
            }
            $composer3.startReplaceableGroup(1663535958);
            ComposerKt.sourceInformation($composer3, "*168@9338L46");
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
            final String str2 = str;
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors2.getSelectionColors($composer2, ($dirty2 >> 6) & 14)), ComposableLambdaKt.composableLambda($composer2, -1886965181, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2
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
                    Modifier modifierM771paddingqDBjuR0$default;
                    ComposerKt.sourceInformation($composer4, "C184@10067L38,193@10486L20,173@9567L2425:OutlinedTextField.kt#uh7d8r");
                    if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1886965181, $changed3, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:173)");
                        }
                        if (label2 != null) {
                            modifierM771paddingqDBjuR0$default = PaddingKt.m771paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                }
                            }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null);
                        } else {
                            modifierM771paddingqDBjuR0$default = modifier3;
                        }
                        boolean z = isError2;
                        Strings.Companion companion = Strings.INSTANCE;
                        Modifier modifierM800defaultMinSizeVpY3zN4 = SizeKt.m800defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifierM771paddingqDBjuR0$default, z, Strings_androidKt.m2509getStringNWtq28(Strings.m2440constructorimpl(C1740R.string.default_error_message), $composer4, 0)), OutlinedTextFieldDefaults.INSTANCE.m2273getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m2272getMinHeightD9Ej5fM());
                        SolidColor solidColor = new SolidColor(colors2.cursorColor$material3_release(isError2, $composer4, 0).getValue().m3959unboximpl(), null);
                        final String str3 = str2;
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
                        final TextFieldColors textFieldColors = colors2;
                        final Shape shape5 = shape3;
                        BasicTextFieldKt.BasicTextField(str2, function1, modifierM800defaultMinSizeVpY3zN4, enabled3, readOnly3, mergedTextStyle, keyboardOptions2, keyboardActions2, singleLine2, minLines3, minLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, solidColor, ComposableLambdaKt.composableLambda($composer4, 1474611661, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.2
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
                                ComposerKt.sourceInformation($composer5, "C202@10922L1046:OutlinedTextField.kt#uh7d8r");
                                int $dirty3 = $changed4;
                                if (($changed4 & 6) == 0) {
                                    $dirty3 |= $composer5.changedInstance(function215) ? 4 : 2;
                                }
                                if (($dirty3 & 19) != 18 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1474611661, $dirty3, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:202)");
                                    }
                                    OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                                    int $dirty4 = $dirty3;
                                    String str4 = str3;
                                    boolean z5 = z2;
                                    boolean z6 = z3;
                                    VisualTransformation visualTransformation6 = visualTransformation5;
                                    MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                                    boolean z7 = z4;
                                    Function2<Composer, Integer, Unit> function216 = function28;
                                    Function2<Composer, Integer, Unit> function217 = function29;
                                    Function2<Composer, Integer, Unit> function218 = function210;
                                    Function2<Composer, Integer, Unit> function219 = function211;
                                    Function2<Composer, Integer, Unit> function220 = function212;
                                    Function2<Composer, Integer, Unit> function221 = function213;
                                    Function2<Composer, Integer, Unit> function222 = function214;
                                    TextFieldColors textFieldColors2 = textFieldColors;
                                    final boolean z8 = z2;
                                    final boolean z9 = z4;
                                    final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                                    final TextFieldColors textFieldColors3 = textFieldColors;
                                    final Shape shape6 = shape5;
                                    outlinedTextFieldDefaults.DecorationBox(str4, function215, z5, z6, visualTransformation6, mutableInteractionSource2, z7, function216, function217, function218, function219, function220, function221, function222, textFieldColors2, null, ComposableLambdaKt.composableLambda($composer5, 2108828640, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                            invoke(composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer6, int $changed5) {
                                            ComposerKt.sourceInformation($composer6, "C219@11698L230:OutlinedTextField.kt#uh7d8r");
                                            if (($changed5 & 3) != 2 || !$composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2108828640, $changed5, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:219)");
                                                }
                                                OutlinedTextFieldDefaults.INSTANCE.m2268ContainerBoxnbWgWpA(z8, z9, mutableInteractionSource3, textFieldColors3, shape6, 0.0f, 0.0f, $composer6, 12582912, 96);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            $composer6.skipToGroupEnd();
                                        }
                                    }), $composer5, ($dirty4 << 3) & 112, 14155776, 32768);
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
            enabled5 = singleLine2;
            minLines4 = minLines2;
            interactionSource4 = interactionSource3;
            placeholder3 = placeholder2;
            trailingIcon2 = trailingIcon;
            prefix2 = prefix;
            supportingText2 = supportingText;
            shape4 = shape3;
            label3 = label2;
            colors3 = colors2;
            readOnly4 = readOnly3;
            maxLines3 = minLines3;
            visualTransformation3 = visualTransformation2;
            label4 = suffix;
            textStyle4 = textStyle3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Function2 leadingIcon4 = leadingIcon2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.3
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
                    OutlinedTextFieldKt.OutlinedTextField(value, function1, modifier4, enabled4, readOnly4, textStyle4, label3, placeholder3, leadingIcon4, trailingIcon2, prefix2, label4, supportingText2, isError2, visualTransformation3, keyboardOptions3, keyboardActions3, enabled5, maxLines3, minLines4, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
                }
            });
        }
    }

    public static final void OutlinedTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
        TextFieldValue textFieldValue;
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
        int maxLines2;
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
        final Function2 suffix;
        final Function2 supportingText;
        final VisualTransformation visualTransformation2;
        final boolean isError2;
        final int minLines2;
        final Modifier modifier3;
        final boolean enabled3;
        final int minLines3;
        final boolean singleLine2;
        final KeyboardActions keyboardActions2;
        final KeyboardOptions keyboardOptions2;
        final boolean readOnly3;
        final Function2 label2;
        final TextFieldColors colors2;
        Object value$iv;
        Composer $composer2;
        long jM3959unboximpl;
        final boolean enabled4;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean enabled5;
        final int minLines4;
        final MutableInteractionSource interactionSource4;
        final Function2 placeholder3;
        final Function2 trailingIcon2;
        final Function2 prefix2;
        final Function2 supportingText2;
        final Shape shape4;
        final Function2 label3;
        final TextFieldColors colors3;
        final boolean readOnly4;
        final int maxLines3;
        final VisualTransformation visualTransformation3;
        final Function2 label4;
        final TextStyle textStyle4;
        int i10;
        Composer $composer3 = $composer.startRestartGroup(-1570442800);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)307@17107L7,322@17859L39,323@17945L5,324@18008L8,332@18370L15,332@18304L2529:OutlinedTextField.kt#uh7d8r");
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
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
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
            prefix2 = function25;
            isError2 = isError;
            keyboardOptions3 = keyboardOptions;
            keyboardActions3 = keyboardActions;
            enabled5 = singleLine;
            maxLines3 = maxLines;
            minLines4 = minLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            colors3 = colors;
            $composer2 = $composer3;
            enabled4 = enabled2;
            readOnly4 = readOnly2;
            textStyle4 = textStyle2;
            label3 = label;
            trailingIcon2 = function24;
            label4 = function26;
            supportingText2 = function27;
            visualTransformation3 = visualTransformation;
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
                Function2 suffix2 = i6 != 0 ? null : function26;
                Function2 supportingText3 = i7 != 0 ? null : function27;
                boolean isError3 = i8 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i9 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i23 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions4 = i24 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine3 = i25 != 0 ? false : singleLine;
                if ((i & 262144) != 0) {
                    maxLines2 = singleLine3 ? 1 : Integer.MAX_VALUE;
                    $dirty1 &= -234881025;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines5 = i26 != 0 ? 1 : minLines;
                if (i27 != 0) {
                    placeholder = placeholder4;
                    $composer3.startReplaceableGroup(1663544507);
                    ComposerKt.sourceInformation($composer3, "CC(remember):OutlinedTextField.kt#9igjgp");
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
                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape($composer3, 6);
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
                    suffix = suffix2;
                    supportingText = supportingText3;
                    visualTransformation2 = visualTransformation4;
                    isError2 = isError3;
                    minLines2 = minLines5;
                    enabled3 = enabled2;
                    minLines3 = maxLines2;
                    singleLine2 = singleLine3;
                    keyboardActions2 = keyboardActions4;
                    keyboardOptions2 = keyboardOptions4;
                    readOnly3 = readOnly2;
                    label2 = label;
                    colors2 = OutlinedTextFieldDefaults.INSTANCE.colors($composer3, 6);
                    textStyle3 = textStyle2;
                    modifier3 = modifier2;
                } else {
                    placeholder2 = placeholder;
                    interactionSource3 = interactionSource5;
                    shape3 = shape2;
                    leadingIcon2 = leadingIcon;
                    trailingIcon = trailingIcon3;
                    textStyle3 = textStyle2;
                    prefix = prefix3;
                    suffix = suffix2;
                    supportingText = supportingText3;
                    visualTransformation2 = visualTransformation4;
                    isError2 = isError3;
                    minLines2 = minLines5;
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    minLines3 = maxLines2;
                    singleLine2 = singleLine3;
                    keyboardActions2 = keyboardActions4;
                    keyboardOptions2 = keyboardOptions4;
                    readOnly3 = readOnly2;
                    label2 = label;
                    colors2 = colors;
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
                    minLines3 = maxLines;
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
                    minLines3 = maxLines;
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
                ComposerKt.traceEventStart(-1570442800, $dirty, $dirty1, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:325)");
            }
            $composer3.startReplaceableGroup(1663544788);
            ComposerKt.sourceInformation($composer3, "*328@18168L46");
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
            final TextFieldValue textFieldValue2 = textFieldValue;
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(colors2.getSelectionColors($composer2, ($dirty2 >> 6) & 14)), ComposableLambdaKt.composableLambda($composer2, 1830921872, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5
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
                    Modifier modifierM771paddingqDBjuR0$default;
                    ComposerKt.sourceInformation($composer4, "C344@18897L38,353@19316L20,333@18397L2430:OutlinedTextField.kt#uh7d8r");
                    if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1830921872, $changed3, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:333)");
                        }
                        if (label2 != null) {
                            modifierM771paddingqDBjuR0$default = PaddingKt.m771paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                }
                            }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null);
                        } else {
                            modifierM771paddingqDBjuR0$default = modifier3;
                        }
                        boolean z = isError2;
                        Strings.Companion companion = Strings.INSTANCE;
                        Modifier modifierM800defaultMinSizeVpY3zN4 = SizeKt.m800defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifierM771paddingqDBjuR0$default, z, Strings_androidKt.m2509getStringNWtq28(Strings.m2440constructorimpl(C1740R.string.default_error_message), $composer4, 0)), OutlinedTextFieldDefaults.INSTANCE.m2273getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m2272getMinHeightD9Ej5fM());
                        SolidColor solidColor = new SolidColor(colors2.cursorColor$material3_release(isError2, $composer4, 0).getValue().m3959unboximpl(), null);
                        final TextFieldValue textFieldValue3 = textFieldValue2;
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
                        final TextFieldColors textFieldColors = colors2;
                        final Shape shape5 = shape3;
                        BasicTextFieldKt.BasicTextField(textFieldValue2, function1, modifierM800defaultMinSizeVpY3zN4, enabled3, readOnly3, mergedTextStyle, keyboardOptions2, keyboardActions2, singleLine2, minLines3, minLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, solidColor, ComposableLambdaKt.composableLambda($composer4, -757328870, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.2
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
                                ComposerKt.sourceInformation($composer5, "C362@19752L1051:OutlinedTextField.kt#uh7d8r");
                                int $dirty3 = $changed4;
                                if (($changed4 & 6) == 0) {
                                    $dirty3 |= $composer5.changedInstance(function215) ? 4 : 2;
                                }
                                if (($dirty3 & 19) == 18 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-757328870, $dirty3, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:362)");
                                }
                                OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                                String text = textFieldValue3.getText();
                                boolean z5 = z2;
                                int $dirty4 = $dirty3;
                                boolean z6 = z3;
                                VisualTransformation visualTransformation6 = visualTransformation5;
                                MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                                boolean z7 = z4;
                                Function2<Composer, Integer, Unit> function216 = function28;
                                Function2<Composer, Integer, Unit> function217 = function29;
                                Function2<Composer, Integer, Unit> function218 = function210;
                                Function2<Composer, Integer, Unit> function219 = function211;
                                Function2<Composer, Integer, Unit> function220 = function212;
                                Function2<Composer, Integer, Unit> function221 = function213;
                                Function2<Composer, Integer, Unit> function222 = function214;
                                TextFieldColors textFieldColors2 = textFieldColors;
                                final boolean z8 = z2;
                                final boolean z9 = z4;
                                final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                                final TextFieldColors textFieldColors3 = textFieldColors;
                                final Shape shape6 = shape5;
                                outlinedTextFieldDefaults.DecorationBox(text, function215, z5, z6, visualTransformation6, mutableInteractionSource2, z7, function216, function217, function218, function219, function220, function221, function222, textFieldColors2, null, ComposableLambdaKt.composableLambda($composer5, 255570733, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer6, int $changed5) {
                                        ComposerKt.sourceInformation($composer6, "C379@20533L230:OutlinedTextField.kt#uh7d8r");
                                        if (($changed5 & 3) != 2 || !$composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(255570733, $changed5, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:379)");
                                            }
                                            OutlinedTextFieldDefaults.INSTANCE.m2268ContainerBoxnbWgWpA(z8, z9, mutableInteractionSource3, textFieldColors3, shape6, 0.0f, 0.0f, $composer6, 12582912, 96);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer6.skipToGroupEnd();
                                    }
                                }), $composer5, ($dirty4 << 3) & 112, 14155776, 32768);
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
            enabled5 = singleLine2;
            minLines4 = minLines2;
            interactionSource4 = interactionSource3;
            placeholder3 = placeholder2;
            trailingIcon2 = trailingIcon;
            prefix2 = prefix;
            supportingText2 = supportingText;
            shape4 = shape3;
            label3 = label2;
            colors3 = colors2;
            readOnly4 = readOnly3;
            maxLines3 = minLines3;
            visualTransformation3 = visualTransformation2;
            label4 = suffix;
            textStyle4 = textStyle3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Function2 leadingIcon4 = leadingIcon2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.6
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
                    OutlinedTextFieldKt.OutlinedTextField(value, function1, modifier4, enabled4, readOnly4, textStyle4, label3, placeholder3, leadingIcon4, trailingIcon2, prefix2, label4, supportingText2, isError2, visualTransformation3, keyboardOptions3, keyboardActions3, enabled5, maxLines3, minLines4, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    public static final /* synthetic */ void OutlinedTextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, Function2 supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
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
        Composer $composer3 = $composer.startRestartGroup(-1575225237);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)402@21186L7,415@21846L39,416@21932L5,417@21995L8,419@22012L771:OutlinedTextField.kt#uh7d8r");
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
                    $composer3.startReplaceableGroup(1663548494);
                    ComposerKt.sourceInformation($composer3, "CC(remember):OutlinedTextField.kt#9igjgp");
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
                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty12 &= -1879048193;
                } else {
                    shape2 = shape;
                }
                if ((i & 1048576) != 0) {
                    Shape shape5 = shape2;
                    int i25 = $dirty22 & (-15);
                    interactionSource3 = interactionSource5;
                    shape3 = shape5;
                    colors2 = OutlinedTextFieldDefaults.INSTANCE.colors($composer3, 6);
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
                ComposerKt.traceEventStart(-1575225237, $dirty, $dirty1, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:418)");
            }
            $composer2 = $composer3;
            OutlinedTextField(value, (Function1<? super String, Unit>) onValueChange, modifier3, enabled3, readOnly3, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) label3, (Function2<? super Composer, ? super Integer, Unit>) placeholder3, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon3, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) supportingText2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines3, minLines2, interactionSource3, shape3, colors2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), (($dirty1 << 6) & 896) | 54 | (($dirty1 << 6) & 7168) | (($dirty1 << 6) & 57344) | (($dirty1 << 6) & 458752) | (($dirty1 << 6) & 3670016) | (($dirty1 << 6) & 29360128) | (($dirty1 << 6) & 234881024) | (($dirty1 << 6) & 1879048192), (($dirty1 >> 24) & 14) | (($dirty1 >> 24) & 112) | (($dirty2 << 6) & 896), 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.8
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
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier4, enabled4, readOnly4, textStyle4, label4, placeholder4, leadingIcon4, label5, placeholder5, isError3, visualTransformation3, keyboardOptions3, keyboardActions3, singleLine3, maxLines4, minLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    public static final /* synthetic */ void OutlinedTextField(final TextFieldValue value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, Function2 supportingText, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int $changed2, final int i) {
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
        Composer $composer3 = $composer.startRestartGroup(-989817544);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)455@23152L7,468@23812L39,469@23898L5,470@23961L8,472@23978L771:OutlinedTextField.kt#uh7d8r");
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
                    $composer3.startReplaceableGroup(1663550460);
                    ComposerKt.sourceInformation($composer3, "CC(remember):OutlinedTextField.kt#9igjgp");
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
                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape($composer3, 6);
                    $dirty12 &= -1879048193;
                } else {
                    shape2 = shape;
                }
                if ((i & 1048576) != 0) {
                    Shape shape5 = shape2;
                    int i25 = $dirty22 & (-15);
                    interactionSource3 = interactionSource5;
                    shape3 = shape5;
                    colors2 = OutlinedTextFieldDefaults.INSTANCE.colors($composer3, 6);
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
                ComposerKt.traceEventStart(-989817544, $dirty, $dirty1, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:471)");
            }
            $composer2 = $composer3;
            OutlinedTextField(value, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier3, enabled3, readOnly3, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) label3, (Function2<? super Composer, ? super Integer, Unit>) placeholder3, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon3, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) supportingText2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines3, minLines2, interactionSource3, shape3, colors2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), (($dirty1 << 6) & 896) | 54 | (($dirty1 << 6) & 7168) | (($dirty1 << 6) & 57344) | (($dirty1 << 6) & 458752) | (($dirty1 << 6) & 3670016) | (($dirty1 << 6) & 29360128) | (($dirty1 << 6) & 234881024) | (($dirty1 << 6) & 1879048192), (($dirty1 >> 24) & 14) | (($dirty1 >> 24) & 112) | (($dirty2 << 6) & 896), 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.10
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
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier4, enabled4, readOnly4, textStyle4, label4, placeholder4, leadingIcon4, label5, placeholder5, isError3, visualTransformation3, keyboardOptions3, keyboardActions3, singleLine3, maxLines4, minLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), RecomposeScopeImplKt.updateChangedFlags($changed2), i);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:263:0x0ab2  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0c0f  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0c23  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0d8b  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0da6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void OutlinedTextFieldLayout(final androidx.compose.p000ui.Modifier r63, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r64, final kotlin.jvm.functions.Function3<? super androidx.compose.p000ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r65, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r66, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r67, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r70, final boolean r71, float r72, final kotlin.jvm.functions.Function1<? super androidx.compose.p000ui.geometry.Size, kotlin.Unit> r73, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, androidx.compose.foundation.layout.PaddingValues r76, androidx.compose.runtime.Composer r77, final int r78, final int r79) {
        /*
            Method dump skipped, instructions count: 3545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int substractConstraintSafely(int $this$substractConstraintSafely, int from) {
        if ($this$substractConstraintSafely == Integer.MAX_VALUE) {
            return $this$substractConstraintSafely;
        }
        return $this$substractConstraintSafely - from;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-DHJA7U0, reason: not valid java name */
    public static final int m2278calculateWidthDHJA7U0(int leadingPlaceableWidth, int trailingPlaceableWidth, int prefixPlaceableWidth, int suffixPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        int affixTotalWidth = prefixPlaceableWidth + suffixPlaceableWidth;
        int middleSection = Math.max(textFieldPlaceableWidth + affixTotalWidth, Math.max(placeholderPlaceableWidth + affixTotalWidth, MathHelpersKt.lerp(labelPlaceableWidth, 0, animationProgress)));
        int wrappedWidth = leadingPlaceableWidth + middleSection + trailingPlaceableWidth;
        float arg0$iv = paddingValues.mo718calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr);
        float other$iv = paddingValues.mo719calculateRightPaddingu2uoSUM(LayoutDirection.Ltr);
        float labelHorizontalPadding = C1956Dp.m6297constructorimpl(arg0$iv + other$iv) * density;
        int focusedLabelWidth = MathKt.roundToInt((labelPlaceableWidth + labelHorizontalPadding) * animationProgress);
        return Math.max(wrappedWidth, Math.max(focusedLabelWidth, Constraints.m6255getMinWidthimpl(constraints)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    public static final int m2277calculateHeightmKXJcVc(int leadingHeight, int trailingHeight, int prefixHeight, int suffixHeight, int textFieldHeight, int labelHeight, int placeholderHeight, int supportingHeight, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        int inputFieldHeight = ComparisonsKt.maxOf(textFieldHeight, placeholderHeight, prefixHeight, suffixHeight, MathHelpersKt.lerp(labelHeight, 0, animationProgress));
        float topPadding = paddingValues.getTop() * density;
        float actualTopPadding = MathHelpersKt.lerp(topPadding, Math.max(topPadding, labelHeight / 2.0f), animationProgress);
        float bottomPadding = paddingValues.getBottom() * density;
        float middleSectionHeight = inputFieldHeight + actualTopPadding + bottomPadding;
        return Math.max(Constraints.m6254getMinHeightimpl(constraints), Math.max(leadingHeight, Math.max(trailingHeight, MathKt.roundToInt(middleSectionHeight))) + supportingHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope $this$place, int totalHeight, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable prefixPlaceable, Placeable suffixPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int startPositionY;
        float fWidthOrZero;
        Placeable.PlacementScope.m5270place70tqf50$default($this$place, containerPlaceable, IntOffset.INSTANCE.m6435getZeronOccac(), 0.0f, 2, null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        int topPadding = MathKt.roundToInt(paddingValues.getTop() * density);
        int startPadding = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * density);
        float iconPadding = TextFieldImplKt.getHorizontalIconPadding() * density;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, leadingPlaceable, 0, Alignment.INSTANCE.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.INSTANCE.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, null);
        }
        if (labelPlaceable != null) {
            if (singleLine) {
                startPositionY = Alignment.INSTANCE.getCenterVertically().align(labelPlaceable.getHeight(), height);
            } else {
                startPositionY = topPadding;
            }
            int positionY = MathHelpersKt.lerp(startPositionY, -(labelPlaceable.getHeight() / 2), animationProgress);
            if (leadingPlaceable == null) {
                fWidthOrZero = 0.0f;
            } else {
                fWidthOrZero = (TextFieldImplKt.widthOrZero(leadingPlaceable) - iconPadding) * (1 - animationProgress);
            }
            int positionX = MathKt.roundToInt(fWidthOrZero) + startPadding;
            Placeable.PlacementScope.placeRelative$default($this$place, labelPlaceable, positionX, positionY, 0.0f, 4, null);
        }
        if (prefixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, prefixPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), place$calculateVerticalPosition(singleLine, height, topPadding, labelPlaceable, prefixPlaceable), 0.0f, 4, null);
        }
        if (suffixPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, suffixPlaceable, (width - TextFieldImplKt.widthOrZero(trailingPlaceable)) - suffixPlaceable.getWidth(), place$calculateVerticalPosition(singleLine, height, topPadding, labelPlaceable, suffixPlaceable), 0.0f, 4, null);
        }
        int textHorizontalPosition = TextFieldImplKt.widthOrZero(leadingPlaceable) + TextFieldImplKt.widthOrZero(prefixPlaceable);
        Placeable.PlacementScope.placeRelative$default($this$place, textFieldPlaceable, textHorizontalPosition, place$calculateVerticalPosition(singleLine, height, topPadding, labelPlaceable, textFieldPlaceable), 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, placeholderPlaceable, textHorizontalPosition, place$calculateVerticalPosition(singleLine, height, topPadding, labelPlaceable, placeholderPlaceable), 0.0f, 4, null);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, supportingPlaceable, 0, height, 0.0f, 4, null);
        }
    }

    private static final int place$calculateVerticalPosition(boolean $singleLine, int height, int topPadding, Placeable $labelPlaceable, Placeable placeable) {
        int iAlign;
        if ($singleLine) {
            iAlign = Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), height);
        } else {
            iAlign = topPadding;
        }
        return Math.max(iAlign, TextFieldImplKt.heightOrZero($labelPlaceable) / 2);
    }

    /* renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m2279outlineCutout12SF9DM(Modifier $this$outlineCutout_u2d12SF9DM, final long labelSize, final PaddingValues paddingValues) {
        return DrawModifierKt.drawWithContent($this$outlineCutout_u2d12SF9DM, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$outlineCutout$1

            /* compiled from: OutlinedTextField.kt */
            @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

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
                float right;
                float labelWidth = Size.m3777getWidthimpl(labelSize);
                if (labelWidth > 0.0f) {
                    float innerPadding = $this$drawWithContent.mo518toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
                    float leftLtr = $this$drawWithContent.mo518toPx0680j_4(paddingValues.mo718calculateLeftPaddingu2uoSUM($this$drawWithContent.getLayoutDirection())) - innerPadding;
                    float f = 2;
                    float rightLtr = leftLtr + labelWidth + (f * innerPadding);
                    float left = WhenMappings.$EnumSwitchMapping$0[$this$drawWithContent.getLayoutDirection().ordinal()] == 1 ? Size.m3777getWidthimpl($this$drawWithContent.mo4498getSizeNHjbRc()) - rightLtr : RangesKt.coerceAtLeast(leftLtr, 0.0f);
                    if (WhenMappings.$EnumSwitchMapping$0[$this$drawWithContent.getLayoutDirection().ordinal()] == 1) {
                        right = Size.m3777getWidthimpl($this$drawWithContent.mo4498getSizeNHjbRc()) - RangesKt.coerceAtLeast(leftLtr, 0.0f);
                    } else {
                        right = rightLtr;
                    }
                    float labelHeight = Size.m3774getHeightimpl(labelSize);
                    ContentDrawScope $this$clipRect_u2drOu3jXo$iv = $this$drawWithContent;
                    float top$iv = (-labelHeight) / f;
                    float bottom$iv = labelHeight / f;
                    int clipOp$iv = ClipOp.INSTANCE.m3937getDifferencertfAjoo();
                    DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$clipRect_u2drOu3jXo$iv.getDrawContext();
                    long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo4423getSizeNHjbRc();
                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
                    DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
                    $this$clipRect_rOu3jXo_u24lambda_u244$iv.mo4426clipRectN_I0leg(left, top$iv, right, bottom$iv, clipOp$iv);
                    $this$drawWithContent.drawContent();
                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                    $this$withTransform_u24lambda_u246$iv$iv.mo4424setSizeuvyYCjk(previousSize$iv$iv);
                    return;
                }
                $this$drawWithContent.drawContent();
            }
        });
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }
}
