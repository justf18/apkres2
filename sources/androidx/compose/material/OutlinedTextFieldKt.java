package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.p000ui.Alignment;
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
import androidx.compose.p000ui.layout.LayoutIdKt;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
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
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: OutlinedTextField.kt */
@Metadata(m164d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010+\u001a\u0091\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010,\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010.\u001a\u0091\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010,\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010/\u001aÁ\u0001\u00100\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u00101\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0002\b\u00172\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010\"\u001a\u00020\u00112\u0006\u00104\u001a\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\t0\r2\u0011\u00108\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\u0010;\u001aZ\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001aZ\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010F\u001a&\u0010N\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010O\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0000ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a|\u0010R\u001a\u00020\t*\u00020S2\u0006\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020$2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010Y\u001a\u00020W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010\\\u001a\u00020W2\u0006\u00104\u001a\u0002052\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010D\u001a\u0002052\u0006\u0010]\u001a\u00020^2\u0006\u00109\u001a\u00020:H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006_"}, m165d2 = {"BorderId", "", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", OutlinedTextFieldKt.BorderId, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-O3s9Psw", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class OutlinedTextFieldKt {
    public static final String BorderId = "border";
    private static final float OutlinedTextFieldInnerPadding = C1956Dp.m6297constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = C1956Dp.m6297constructorimpl(8);

    public static final void OutlinedTextField(final String value, final Function1<? super String, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        Function2 function25;
        Function2 function26;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        TextFieldColors textFieldColors;
        int $dirty1;
        Modifier.Companion modifier3;
        TextStyle textStyle3;
        int $dirty;
        Function2 label;
        Function2 placeholder;
        Function2 leadingIcon;
        Function2 trailingIcon;
        int maxLines2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        int $dirty12;
        Composer $composer2;
        TextFieldColors colors2;
        TextStyle textStyle4;
        int $dirty2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        int maxLines3;
        int minLines2;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        int $dirty13;
        Object value$iv$iv;
        boolean readOnly3;
        KeyboardOptions keyboardOptions3;
        int $dirty14;
        Composer $composer3;
        final Modifier modifier4;
        final boolean singleLine3;
        final VisualTransformation visualTransformation3;
        final TextFieldColors colors3;
        final boolean enabled3;
        final boolean readOnly4;
        final int maxLines4;
        final MutableInteractionSource interactionSource4;
        final TextStyle textStyle5;
        final Function2 label2;
        final Function2 placeholder2;
        final Function2 leadingIcon2;
        final Shape shape4;
        final KeyboardOptions keyboardOptions4;
        final int minLines3;
        final Function2 trailingIcon2;
        final KeyboardActions keyboardActions3;
        final boolean isError3;
        int $dirty15;
        int i9;
        Composer $composer4 = $composer.startRestartGroup(-621914704);
        ComposerKt.sourceInformation($composer4, "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)141@7857L7,153@8463L39,154@8537L6,155@8599L25,175@9370L24,176@9453L38,185@9820L20,164@8927L2135:OutlinedTextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty16 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer4.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        int i10 = i & 4;
        if (i10 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i11 = i & 8;
        if (i11 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 7168) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer4.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i12 = i & 16;
        if (i12 != 0) {
            $dirty3 |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 57344) == 0) {
            readOnly2 = readOnly;
            $dirty3 |= $composer4.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                if ($composer4.changed(textStyle2)) {
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
            function25 = function2;
        } else if (($changed & 3670016) == 0) {
            function25 = function2;
            $dirty3 |= $composer4.changedInstance(function25) ? 1048576 : 524288;
        } else {
            function25 = function2;
        }
        int i14 = i & 128;
        if (i14 != 0) {
            $dirty3 |= 12582912;
            function26 = function22;
        } else if (($changed & 29360128) == 0) {
            function26 = function22;
            $dirty3 |= $composer4.changedInstance(function26) ? 8388608 : 4194304;
        } else {
            function26 = function22;
        }
        int i15 = i & 256;
        if (i15 != 0) {
            $dirty3 |= 100663296;
            i2 = i15;
        } else if (($changed & 234881024) == 0) {
            i2 = i15;
            $dirty3 |= $composer4.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i15;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty3 |= 805306368;
            i3 = i16;
        } else if (($changed & 1879048192) == 0) {
            i3 = i16;
            $dirty3 |= $composer4.changedInstance(function24) ? 536870912 : 268435456;
        } else {
            i3 = i16;
        }
        int i17 = i & 1024;
        if (i17 != 0) {
            $dirty16 |= 6;
            i4 = i17;
        } else if (($changed1 & 14) == 0) {
            i4 = i17;
            $dirty16 |= $composer4.changed(isError) ? 4 : 2;
        } else {
            i4 = i17;
        }
        int i18 = i & 2048;
        if (i18 != 0) {
            $dirty16 |= 48;
            i5 = i18;
        } else if (($changed1 & 112) == 0) {
            i5 = i18;
            $dirty16 |= $composer4.changed(visualTransformation) ? 32 : 16;
        } else {
            i5 = i18;
        }
        int i19 = i & 4096;
        if (i19 != 0) {
            $dirty16 |= 384;
            i6 = i19;
        } else {
            i6 = i19;
            if (($changed1 & 896) == 0) {
                $dirty16 |= $composer4.changed(keyboardOptions) ? 256 : 128;
            }
        }
        int i20 = i & 8192;
        if (i20 != 0) {
            $dirty16 |= 3072;
            i7 = i20;
        } else {
            i7 = i20;
            if (($changed1 & 7168) == 0) {
                $dirty16 |= $composer4.changed(keyboardActions) ? 2048 : 1024;
            }
        }
        int i21 = i & 16384;
        if (i21 != 0) {
            $dirty16 |= 24576;
            i8 = i21;
        } else if (($changed1 & 57344) == 0) {
            i8 = i21;
            $dirty16 |= $composer4.changed(singleLine) ? 16384 : 8192;
        } else {
            i8 = i21;
        }
        if (($changed1 & 458752) == 0) {
            $dirty16 |= ((i & 32768) == 0 && $composer4.changed(maxLines)) ? 131072 : 65536;
        }
        int i22 = i & 65536;
        if (i22 != 0) {
            $dirty16 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty16 |= $composer4.changed(minLines) ? 1048576 : 524288;
        }
        int i23 = i & 131072;
        if (i23 != 0) {
            $dirty16 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty16 |= $composer4.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            $dirty16 |= ((i & 262144) == 0 && $composer4.changed(shape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 1879048192) == 0) {
            if ((i & 524288) == 0) {
                $dirty15 = $dirty16;
                textFieldColors = colors;
                int i24 = $composer4.changed(textFieldColors) ? 536870912 : 268435456;
                $dirty1 = $dirty15 | i24;
            } else {
                $dirty15 = $dirty16;
                textFieldColors = colors;
            }
            $dirty1 = $dirty15 | i24;
        } else {
            int $dirty17 = $dirty16;
            textFieldColors = colors;
            $dirty1 = $dirty17;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty1 & 1533916891) == 306783378 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            leadingIcon2 = function23;
            visualTransformation3 = visualTransformation;
            keyboardOptions4 = keyboardOptions;
            maxLines4 = maxLines;
            minLines3 = minLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            $composer3 = $composer4;
            colors3 = textFieldColors;
            enabled3 = enabled2;
            readOnly4 = readOnly2;
            textStyle5 = textStyle2;
            label2 = function25;
            placeholder2 = function26;
            modifier4 = modifier2;
            trailingIcon2 = function24;
            isError3 = isError;
            keyboardActions3 = keyboardActions;
            singleLine3 = singleLine;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                modifier3 = i10 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i11 != 0 ? true : enabled2;
                boolean readOnly5 = i12 != 0 ? false : readOnly2;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer4.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    textStyle3 = (TextStyle) objConsume;
                    $dirty = $dirty3 & (-458753);
                } else {
                    textStyle3 = textStyle2;
                    $dirty = $dirty3;
                }
                label = i13 != 0 ? null : function25;
                placeholder = i14 != 0 ? null : function26;
                leadingIcon = i2 != 0 ? null : function23;
                trailingIcon = i3 != 0 ? null : function24;
                boolean isError4 = i4 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i5 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions5 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions4 = i7 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine4 = i8 != 0 ? false : singleLine;
                if ((32768 & i) != 0) {
                    $dirty1 &= -458753;
                    maxLines2 = singleLine4 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines4 = i22 != 0 ? 1 : minLines;
                if (i23 != 0) {
                    $composer4.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer4, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer4.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer4.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer4.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    interactionSource2 = interactionSource;
                }
                if ((262144 & i) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer4, 6).getSmall();
                    $dirty12 = $dirty1 & (-234881025);
                } else {
                    shape2 = shape;
                    $dirty12 = $dirty1;
                }
                if ((i & 524288) != 0) {
                    $composer2 = $composer4;
                    colors2 = TextFieldDefaults.INSTANCE.m1712outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer4, 0, 0, 48, 2097151);
                    $dirty13 = $dirty12 & (-1879048193);
                    enabled2 = enabled4;
                    readOnly2 = readOnly5;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions5;
                    keyboardActions2 = keyboardActions4;
                    singleLine2 = singleLine4;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                } else {
                    $composer2 = $composer4;
                    colors2 = colors;
                    enabled2 = enabled4;
                    readOnly2 = readOnly5;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions5;
                    keyboardActions2 = keyboardActions4;
                    singleLine2 = singleLine4;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    $dirty13 = $dirty12;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((32768 & i) != 0) {
                    $dirty1 &= -458753;
                }
                if ((262144 & i) != 0) {
                    $dirty1 &= -234881025;
                }
                if ((i & 524288) != 0) {
                    leadingIcon = function23;
                    trailingIcon = function24;
                    isError2 = isError;
                    singleLine2 = singleLine;
                    maxLines3 = maxLines;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    colors2 = colors;
                    $dirty13 = $dirty1 & (-1879048193);
                    $composer2 = $composer4;
                    $dirty2 = $dirty3;
                    textStyle4 = textStyle2;
                    label = function25;
                    placeholder = function26;
                    modifier3 = modifier2;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    minLines2 = minLines;
                } else {
                    leadingIcon = function23;
                    trailingIcon = function24;
                    isError2 = isError;
                    singleLine2 = singleLine;
                    maxLines3 = maxLines;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    colors2 = colors;
                    $composer2 = $composer4;
                    $dirty2 = $dirty3;
                    textStyle4 = textStyle2;
                    label = function25;
                    placeholder = function26;
                    modifier3 = modifier2;
                    $dirty13 = $dirty1;
                    visualTransformation2 = visualTransformation;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    minLines2 = minLines;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                readOnly3 = readOnly2;
                keyboardOptions3 = keyboardOptions2;
                ComposerKt.traceEventStart(-621914704, $dirty2, $dirty13, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:156)");
            } else {
                readOnly3 = readOnly2;
                keyboardOptions3 = keyboardOptions2;
            }
            $composer2.startReplaceableGroup(1961395303);
            ComposerKt.sourceInformation($composer2, "*159@8776L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle4.m5804getColor0d7_KjU();
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m3985getUnspecified0d7_KjU()) {
                $dirty14 = $dirty13;
            } else {
                $dirty14 = $dirty13;
                $this$takeOrElse_u2dDxMtmZc$iv = colors2.textColor(enabled2, $composer2, (($dirty2 >> 9) & 14) | (($dirty13 >> 24) & 112)).getValue().m3959unboximpl();
            }
            $composer2.endReplaceableGroup();
            long textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            TextStyle mergedTextStyle = textStyle4.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            KeyboardActions keyboardActions5 = keyboardActions2;
            Modifier modifier5 = modifier3;
            final TextFieldColors colors4 = colors2;
            final boolean isError5 = isError2;
            final boolean enabled5 = enabled2;
            final Shape shape5 = shape3;
            final boolean singleLine5 = singleLine2;
            final VisualTransformation visualTransformation5 = visualTransformation2;
            final MutableInteractionSource interactionSource5 = interactionSource3;
            final Function2 label3 = label;
            final Function2 placeholder3 = placeholder;
            final Function2 leadingIcon3 = leadingIcon;
            final Function2 trailingIcon3 = trailingIcon;
            KeyboardOptions keyboardOptions6 = keyboardOptions3;
            TextStyle textStyle6 = textStyle4;
            Composer $composer5 = $composer2;
            boolean readOnly6 = readOnly3;
            BasicTextFieldKt.BasicTextField(value, function1, SizeKt.m800defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m414backgroundbw27NRU(label != null ? PaddingKt.m771paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                }
            }), 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null) : modifier3, colors2.backgroundColor(enabled2, $composer2, (($dirty2 >> 9) & 14) | (($dirty14 >> 24) & 112)).getValue().m3959unboximpl(), shape3), isError2, Strings_androidKt.m1667getString4foXLRw(Strings.INSTANCE.m1662getDefaultErrorMessageUdPEhr4(), $composer2, 6)), TextFieldDefaults.INSTANCE.m1709getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1708getMinHeightD9Ej5fM()), enabled2, readOnly6, mergedTextStyle, keyboardOptions6, keyboardActions5, singleLine2, maxLines3, minLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, new SolidColor(colors2.cursorColor(isError2, $composer2, ($dirty14 & 14) | (($dirty14 >> 24) & 112)).getValue().m3959unboximpl(), null), ComposableLambdaKt.composableLambda($composer2, 1710364390, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function27, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function27, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function27, Composer $composer6, int $changed2) {
                    ComposerKt.sourceInformation($composer6, "C194@10212L834:OutlinedTextField.kt#jmzs0o");
                    int $dirty4 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty4 |= $composer6.changedInstance(function27) ? 4 : 2;
                    }
                    if (($dirty4 & 91) != 18 || !$composer6.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1710364390, $dirty4, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:194)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        int $dirty5 = $dirty4;
                        String str = value;
                        boolean z = enabled5;
                        boolean z2 = singleLine5;
                        VisualTransformation visualTransformation6 = visualTransformation5;
                        MutableInteractionSource mutableInteractionSource = interactionSource5;
                        boolean z3 = isError5;
                        Function2<Composer, Integer, Unit> function28 = label3;
                        Function2<Composer, Integer, Unit> function29 = placeholder3;
                        Function2<Composer, Integer, Unit> function210 = leadingIcon3;
                        Function2<Composer, Integer, Unit> function211 = trailingIcon3;
                        TextFieldColors textFieldColors2 = colors4;
                        final boolean z4 = enabled5;
                        final boolean z5 = isError5;
                        final MutableInteractionSource mutableInteractionSource2 = interactionSource5;
                        final TextFieldColors textFieldColors3 = colors4;
                        final Shape shape6 = shape5;
                        textFieldDefaults.OutlinedTextFieldDecorationBox(str, function27, z, z2, visualTransformation6, mutableInteractionSource, z3, function28, function29, function210, function211, textFieldColors2, null, ComposableLambdaKt.composableLambda($composer6, -1823843281, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer7, int $changed3) {
                                ComposerKt.sourceInformation($composer7, "C208@10811L203:OutlinedTextField.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer7.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1823843281, $changed3, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:208)");
                                    }
                                    TextFieldDefaults.INSTANCE.m1706BorderBoxnbWgWpA(z4, z5, mutableInteractionSource2, textFieldColors3, shape6, 0.0f, 0.0f, $composer7, 12582912, 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer7.skipToGroupEnd();
                            }
                        }), $composer6, ($dirty5 << 3) & 112, 27648, 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer6.skipToGroupEnd();
                }
            }), $composer5, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 7168) | ($dirty2 & 57344) | (($dirty14 << 12) & 3670016) | (($dirty14 << 12) & 29360128) | (($dirty14 << 12) & 234881024) | (($dirty14 << 12) & 1879048192), (($dirty14 >> 18) & 14) | ProfileVerifier.CompilationStatus.f249xf2722a21 | ($dirty14 & 112) | (($dirty14 >> 12) & 7168), 4096);
            $composer3 = $composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier5;
            VisualTransformation visualTransformation6 = visualTransformation2;
            singleLine3 = singleLine2;
            visualTransformation3 = visualTransformation6;
            colors3 = colors4;
            enabled3 = enabled2;
            readOnly4 = readOnly6;
            maxLines4 = maxLines3;
            interactionSource4 = interactionSource3;
            textStyle5 = textStyle6;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            shape4 = shape5;
            keyboardOptions4 = keyboardOptions6;
            minLines3 = minLines2;
            trailingIcon2 = trailingIcon;
            keyboardActions3 = keyboardActions5;
            isError3 = isError5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.4
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

                public final void invoke(Composer composer, int i25) {
                    OutlinedTextFieldKt.OutlinedTextField(value, function1, modifier4, enabled3, readOnly4, textStyle5, label2, placeholder2, leadingIcon2, trailingIcon2, isError3, visualTransformation3, keyboardOptions4, keyboardActions3, singleLine3, maxLines4, minLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void OutlinedTextField(final String value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        Function2 function2;
        Function2 function22;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        TextFieldColors textFieldColors;
        int $dirty1;
        Modifier modifier3;
        TextStyle textStyle3;
        int $dirty;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        int $dirty12;
        Composer $composer2;
        Modifier modifier4;
        TextFieldColors colors2;
        TextStyle textStyle4;
        int $dirty2;
        Function2 label2;
        Function2 placeholder2;
        Function2 leadingIcon2;
        Function2 trailingIcon2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean singleLine2;
        int maxLines2;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        int $dirty13;
        Object value$iv$iv;
        final Modifier modifier5;
        final boolean enabled3;
        final boolean readOnly3;
        final TextStyle textStyle5;
        final Function2 label3;
        final Function2 placeholder3;
        final Function2 leadingIcon3;
        final Function2 label4;
        final boolean isError3;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean singleLine3;
        final int maxLines3;
        final MutableInteractionSource interactionSource4;
        final Shape shape4;
        final TextFieldColors colors3;
        int $dirty14;
        Composer $composer3 = $composer.startRestartGroup(-2099955827);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)232@11423L7,243@11983L39,244@12057L6,245@12119L25,247@12153L416:OutlinedTextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty15 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i9 = i & 4;
        if (i9 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i10 = i & 8;
        if (i10 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 7168) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i11 = i & 16;
        if (i11 != 0) {
            $dirty3 |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 57344) == 0) {
            readOnly2 = readOnly;
            $dirty3 |= $composer3.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                int i12 = $composer3.changed(textStyle2) ? 131072 : 65536;
                $dirty3 |= i12;
            } else {
                textStyle2 = textStyle;
            }
            $dirty3 |= i12;
        } else {
            textStyle2 = textStyle;
        }
        int i13 = i & 64;
        if (i13 != 0) {
            $dirty3 |= 1572864;
            function2 = label;
        } else if (($changed & 3670016) == 0) {
            function2 = label;
            $dirty3 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        } else {
            function2 = label;
        }
        int i14 = i & 128;
        if (i14 != 0) {
            $dirty3 |= 12582912;
            function22 = placeholder;
        } else if (($changed & 29360128) == 0) {
            function22 = placeholder;
            $dirty3 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        } else {
            function22 = placeholder;
        }
        int i15 = i & 256;
        if (i15 != 0) {
            $dirty3 |= 100663296;
            i2 = i15;
        } else if (($changed & 234881024) == 0) {
            i2 = i15;
            $dirty3 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i15;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty3 |= 805306368;
            i3 = i16;
        } else if (($changed & 1879048192) == 0) {
            i3 = i16;
            $dirty3 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        } else {
            i3 = i16;
        }
        int i17 = i & 1024;
        if (i17 != 0) {
            $dirty15 |= 6;
            i4 = i17;
        } else if (($changed1 & 14) == 0) {
            i4 = i17;
            $dirty15 |= $composer3.changed(isError) ? 4 : 2;
        } else {
            i4 = i17;
        }
        int i18 = i & 2048;
        if (i18 != 0) {
            $dirty15 |= 48;
            i5 = i18;
        } else if (($changed1 & 112) == 0) {
            i5 = i18;
            $dirty15 |= $composer3.changed(visualTransformation) ? 32 : 16;
        } else {
            i5 = i18;
        }
        int i19 = i & 4096;
        if (i19 != 0) {
            $dirty15 |= 384;
            i6 = i19;
        } else {
            i6 = i19;
            if (($changed1 & 896) == 0) {
                $dirty15 |= $composer3.changed(keyboardOptions) ? 256 : 128;
            }
        }
        int i20 = i & 8192;
        if (i20 != 0) {
            $dirty15 |= 3072;
            i7 = i20;
        } else {
            i7 = i20;
            if (($changed1 & 7168) == 0) {
                $dirty15 |= $composer3.changed(keyboardActions) ? 2048 : 1024;
            }
        }
        int i21 = i & 16384;
        if (i21 != 0) {
            $dirty15 |= 24576;
            i8 = i21;
        } else if (($changed1 & 57344) == 0) {
            i8 = i21;
            $dirty15 |= $composer3.changed(singleLine) ? 16384 : 8192;
        } else {
            i8 = i21;
        }
        int i22 = i & 32768;
        if (i22 != 0) {
            $dirty15 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed1 & 458752) == 0) {
            $dirty15 |= $composer3.changed(maxLines) ? 131072 : 65536;
        }
        int i23 = i & 65536;
        if (i23 != 0) {
            $dirty15 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty15 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        if (($changed1 & 29360128) == 0) {
            $dirty15 |= ((i & 131072) == 0 && $composer3.changed(shape)) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            if ((i & 262144) == 0) {
                $dirty14 = $dirty15;
                textFieldColors = colors;
                int i24 = $composer3.changed(textFieldColors) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty1 = $dirty14 | i24;
            } else {
                $dirty14 = $dirty15;
                textFieldColors = colors;
            }
            $dirty1 = $dirty14 | i24;
        } else {
            int $dirty16 = $dirty15;
            textFieldColors = colors;
            $dirty1 = $dirty16;
        }
        if (($dirty3 & 1533916891) == 306783378 && ($dirty1 & 191739611) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            leadingIcon3 = leadingIcon;
            visualTransformation3 = visualTransformation;
            keyboardOptions3 = keyboardOptions;
            maxLines3 = maxLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            $composer2 = $composer3;
            colors3 = textFieldColors;
            enabled3 = enabled2;
            readOnly3 = readOnly2;
            textStyle5 = textStyle2;
            label3 = function2;
            placeholder3 = function22;
            modifier5 = modifier2;
            label4 = trailingIcon;
            isError3 = isError;
            keyboardActions3 = keyboardActions;
            singleLine3 = singleLine;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier6 = i9 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i10 != 0 ? true : enabled2;
                boolean readOnly4 = i11 != 0 ? false : readOnly2;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    modifier3 = modifier6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle3 = (TextStyle) objConsume;
                    $dirty = $dirty3 & (-458753);
                } else {
                    modifier3 = modifier6;
                    textStyle3 = textStyle2;
                    $dirty = $dirty3;
                }
                Function2 label5 = i13 != 0 ? null : function2;
                Function2 placeholder4 = i14 != 0 ? null : function22;
                Function2 leadingIcon4 = i2 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i3 != 0 ? null : trailingIcon;
                boolean isError4 = i4 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i5 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                KeyboardActions keyboardActions4 = i7 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                boolean singleLine4 = i8 != 0 ? false : singleLine;
                int maxLines4 = i22 != 0 ? Integer.MAX_VALUE : maxLines;
                if (i23 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    interactionSource2 = interactionSource;
                }
                if ((i & 131072) != 0) {
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall();
                    $dirty12 = $dirty1 & (-29360129);
                } else {
                    shape2 = shape;
                    $dirty12 = $dirty1;
                }
                if ((262144 & i) != 0) {
                    $composer2 = $composer3;
                    modifier4 = modifier3;
                    textStyle4 = textStyle3;
                    enabled2 = enabled4;
                    colors2 = TextFieldDefaults.INSTANCE.m1712outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 0, 48, 2097151);
                    $dirty13 = $dirty12 & (-234881025);
                    readOnly2 = readOnly4;
                    $dirty2 = $dirty;
                    label2 = label5;
                    placeholder2 = placeholder4;
                    leadingIcon2 = leadingIcon4;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions4;
                    singleLine2 = singleLine4;
                    maxLines2 = maxLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                } else {
                    $composer2 = $composer3;
                    modifier4 = modifier3;
                    colors2 = colors;
                    textStyle4 = textStyle3;
                    enabled2 = enabled4;
                    readOnly2 = readOnly4;
                    $dirty2 = $dirty;
                    label2 = label5;
                    placeholder2 = placeholder4;
                    leadingIcon2 = leadingIcon4;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions2 = keyboardActions4;
                    singleLine2 = singleLine4;
                    maxLines2 = maxLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    $dirty13 = $dirty12;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 131072) != 0) {
                    $dirty1 &= -29360129;
                }
                if ((262144 & i) != 0) {
                    int i25 = $dirty1 & (-234881025);
                    leadingIcon2 = leadingIcon;
                    trailingIcon2 = trailingIcon;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    interactionSource3 = interactionSource;
                    shape3 = shape;
                    $dirty13 = i25;
                    $composer2 = $composer3;
                    $dirty2 = $dirty3;
                    colors2 = textFieldColors;
                    textStyle4 = textStyle2;
                    label2 = function2;
                    placeholder2 = function22;
                    modifier4 = modifier2;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                } else {
                    leadingIcon2 = leadingIcon;
                    trailingIcon2 = trailingIcon;
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions2 = keyboardActions;
                    singleLine2 = singleLine;
                    maxLines2 = maxLines;
                    shape3 = shape;
                    $composer2 = $composer3;
                    $dirty2 = $dirty3;
                    colors2 = textFieldColors;
                    textStyle4 = textStyle2;
                    label2 = function2;
                    placeholder2 = function22;
                    modifier4 = modifier2;
                    $dirty13 = $dirty1;
                    isError2 = isError;
                    visualTransformation2 = visualTransformation;
                    interactionSource3 = interactionSource;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2099955827, $dirty2, $dirty13, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:246)");
            }
            OutlinedTextField(value, (Function1<? super String, Unit>) onValueChange, modifier4, enabled2, readOnly2, textStyle4, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, 1, interactionSource3, shape3, colors2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | ($dirty2 & 57344) | ($dirty2 & 458752) | ($dirty2 & 3670016) | ($dirty2 & 29360128) | ($dirty2 & 234881024) | (1879048192 & $dirty2), ($dirty13 & 14) | 1572864 | ($dirty13 & 112) | ($dirty13 & 896) | ($dirty13 & 7168) | ($dirty13 & 57344) | ($dirty13 & 458752) | (($dirty13 << 3) & 29360128) | (($dirty13 << 3) & 234881024) | (($dirty13 << 3) & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            enabled3 = enabled2;
            readOnly3 = readOnly2;
            textStyle5 = textStyle4;
            label3 = label2;
            placeholder3 = placeholder2;
            leadingIcon3 = leadingIcon2;
            label4 = trailingIcon2;
            isError3 = isError2;
            visualTransformation3 = visualTransformation2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            singleLine3 = singleLine2;
            maxLines3 = maxLines2;
            interactionSource4 = interactionSource3;
            shape4 = shape3;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.6
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
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier5, enabled3, readOnly3, textStyle5, label3, placeholder3, leadingIcon3, label4, isError3, visualTransformation3, keyboardOptions3, keyboardActions3, singleLine3, maxLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void OutlinedTextField(final TextFieldValue value, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, int minLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        Function2 function25;
        Function2 function26;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        TextFieldColors textFieldColors;
        int $dirty1;
        Modifier.Companion modifier3;
        int i8;
        int $dirty;
        TextStyle textStyle3;
        Function2 label;
        Function2 placeholder;
        Function2 leadingIcon;
        Function2 trailingIcon;
        int $dirty12;
        KeyboardActions keyboardActions2;
        int maxLines2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        int $dirty13;
        Composer $composer2;
        TextFieldColors colors2;
        KeyboardActions keyboardActions3;
        TextStyle textStyle4;
        int $dirty2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        boolean singleLine2;
        int maxLines3;
        int minLines2;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        int $dirty14;
        Object value$iv$iv;
        boolean readOnly3;
        KeyboardOptions keyboardOptions3;
        int $dirty15;
        Composer $composer3;
        final boolean singleLine3;
        final VisualTransformation visualTransformation3;
        final TextStyle textStyle5;
        final TextFieldColors colors3;
        final boolean enabled3;
        final boolean readOnly4;
        final int maxLines4;
        final MutableInteractionSource interactionSource4;
        final Modifier modifier4;
        final Function2 label2;
        final Function2 placeholder2;
        final Function2 leadingIcon2;
        final Shape shape4;
        final KeyboardOptions keyboardOptions4;
        final int minLines3;
        final Function2 trailingIcon2;
        final KeyboardActions keyboardActions4;
        final boolean isError3;
        int $dirty16;
        int i9;
        Composer $composer4 = $composer.startRestartGroup(237745923);
        ComposerKt.sourceInformation($composer4, "C(OutlinedTextField)P(18,11,10,1,13,16,6,12,7,17,3,19,5,4,15,8,9,2,14)343@17493L7,355@18093L39,356@18171L22,357@18243L25,377@19014L24,378@19097L38,387@19464L20,366@18571L2140:OutlinedTextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty17 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer4.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        int i10 = i & 4;
        if (i10 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i11 = i & 8;
        if (i11 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 7168) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer4.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i12 = i & 16;
        if (i12 != 0) {
            $dirty3 |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 57344) == 0) {
            readOnly2 = readOnly;
            $dirty3 |= $composer4.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                if ($composer4.changed(textStyle2)) {
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
            function25 = function2;
        } else if (($changed & 3670016) == 0) {
            function25 = function2;
            $dirty3 |= $composer4.changedInstance(function25) ? 1048576 : 524288;
        } else {
            function25 = function2;
        }
        int i14 = i & 128;
        if (i14 != 0) {
            $dirty3 |= 12582912;
            function26 = function22;
        } else if (($changed & 29360128) == 0) {
            function26 = function22;
            $dirty3 |= $composer4.changedInstance(function26) ? 8388608 : 4194304;
        } else {
            function26 = function22;
        }
        int i15 = i & 256;
        if (i15 != 0) {
            $dirty3 |= 100663296;
            i2 = i15;
        } else if (($changed & 234881024) == 0) {
            i2 = i15;
            $dirty3 |= $composer4.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i15;
        }
        int i16 = i & 512;
        if (i16 != 0) {
            $dirty3 |= 805306368;
            i3 = i16;
        } else if (($changed & 1879048192) == 0) {
            i3 = i16;
            $dirty3 |= $composer4.changedInstance(function24) ? 536870912 : 268435456;
        } else {
            i3 = i16;
        }
        int i17 = i & 1024;
        if (i17 != 0) {
            $dirty17 |= 6;
            i4 = i17;
        } else if (($changed1 & 14) == 0) {
            i4 = i17;
            $dirty17 |= $composer4.changed(isError) ? 4 : 2;
        } else {
            i4 = i17;
        }
        int i18 = i & 2048;
        if (i18 != 0) {
            $dirty17 |= 48;
            i5 = i18;
        } else if (($changed1 & 112) == 0) {
            i5 = i18;
            $dirty17 |= $composer4.changed(visualTransformation) ? 32 : 16;
        } else {
            i5 = i18;
        }
        int i19 = i & 4096;
        if (i19 != 0) {
            $dirty17 |= 384;
            i6 = i19;
        } else {
            i6 = i19;
            if (($changed1 & 896) == 0) {
                $dirty17 |= $composer4.changed(keyboardOptions) ? 256 : 128;
            }
        }
        if (($changed1 & 7168) == 0) {
            $dirty17 |= ((i & 8192) == 0 && $composer4.changed(keyboardActions)) ? 2048 : 1024;
        }
        int i20 = i & 16384;
        if (i20 != 0) {
            $dirty17 |= 24576;
            i7 = i20;
        } else if (($changed1 & 57344) == 0) {
            i7 = i20;
            $dirty17 |= $composer4.changed(singleLine) ? 16384 : 8192;
        } else {
            i7 = i20;
        }
        if (($changed1 & 458752) == 0) {
            $dirty17 |= ((i & 32768) == 0 && $composer4.changed(maxLines)) ? 131072 : 65536;
        }
        int i21 = i & 65536;
        if (i21 != 0) {
            $dirty17 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty17 |= $composer4.changed(minLines) ? 1048576 : 524288;
        }
        int i22 = i & 131072;
        if (i22 != 0) {
            $dirty17 |= 12582912;
        } else if (($changed1 & 29360128) == 0) {
            $dirty17 |= $composer4.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            $dirty17 |= ((i & 262144) == 0 && $composer4.changed(shape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed1 & 1879048192) == 0) {
            if ((i & 524288) == 0) {
                $dirty16 = $dirty17;
                textFieldColors = colors;
                int i23 = $composer4.changed(textFieldColors) ? 536870912 : 268435456;
                $dirty1 = $dirty16 | i23;
            } else {
                $dirty16 = $dirty17;
                textFieldColors = colors;
            }
            $dirty1 = $dirty16 | i23;
        } else {
            int $dirty18 = $dirty17;
            textFieldColors = colors;
            $dirty1 = $dirty18;
        }
        int $dirty4 = $dirty3;
        if (($dirty3 & 1533916891) == 306783378 && (1533916891 & $dirty1) == 306783378 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            leadingIcon2 = function23;
            visualTransformation3 = visualTransformation;
            keyboardOptions4 = keyboardOptions;
            maxLines4 = maxLines;
            minLines3 = minLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            $composer3 = $composer4;
            colors3 = textFieldColors;
            enabled3 = enabled2;
            readOnly4 = readOnly2;
            textStyle5 = textStyle2;
            label2 = function25;
            placeholder2 = function26;
            modifier4 = modifier2;
            trailingIcon2 = function24;
            isError3 = isError;
            keyboardActions4 = keyboardActions;
            singleLine3 = singleLine;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                modifier3 = i10 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i11 != 0 ? true : enabled2;
                boolean readOnly5 = i12 != 0 ? false : readOnly2;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    i8 = -458753;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer4.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    textStyle3 = (TextStyle) objConsume;
                    $dirty = $dirty4 & (-458753);
                } else {
                    i8 = -458753;
                    $dirty = $dirty4;
                    textStyle3 = textStyle2;
                }
                label = i13 != 0 ? null : function25;
                placeholder = i14 != 0 ? null : function26;
                leadingIcon = i2 != 0 ? null : function23;
                trailingIcon = i3 != 0 ? null : function24;
                boolean isError4 = i4 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i5 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions5 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                if ((i & 8192) != 0) {
                    $dirty12 = $dirty1 & (-7169);
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                } else {
                    $dirty12 = $dirty1;
                    keyboardActions2 = keyboardActions;
                }
                boolean singleLine4 = i7 != 0 ? false : singleLine;
                if ((32768 & i) != 0) {
                    $dirty12 &= i8;
                    maxLines2 = singleLine4 ? 1 : Integer.MAX_VALUE;
                } else {
                    maxLines2 = maxLines;
                }
                int minLines4 = i21 != 0 ? 1 : minLines;
                if (i22 != 0) {
                    $composer4.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer4, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer4.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer4.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer4.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    interactionSource2 = interactionSource;
                }
                if ((262144 & i) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape($composer4, 6);
                    $dirty13 = $dirty12 & (-234881025);
                } else {
                    shape2 = shape;
                    $dirty13 = $dirty12;
                }
                if ((i & 524288) != 0) {
                    $composer2 = $composer4;
                    keyboardActions3 = keyboardActions2;
                    colors2 = TextFieldDefaults.INSTANCE.m1712outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer4, 0, 0, 48, 2097151);
                    $dirty14 = $dirty13 & (-1879048193);
                    enabled2 = enabled4;
                    readOnly2 = readOnly5;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions5;
                    singleLine2 = singleLine4;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                } else {
                    $composer2 = $composer4;
                    colors2 = colors;
                    keyboardActions3 = keyboardActions2;
                    enabled2 = enabled4;
                    readOnly2 = readOnly5;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions5;
                    singleLine2 = singleLine4;
                    maxLines3 = maxLines2;
                    minLines2 = minLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    $dirty14 = $dirty13;
                }
            } else {
                $composer4.skipToGroupEnd();
                int $dirty5 = (i & 32) != 0 ? $dirty4 & (-458753) : $dirty4;
                if ((i & 8192) != 0) {
                    $dirty1 &= -7169;
                }
                if ((32768 & i) != 0) {
                    $dirty1 &= -458753;
                }
                if ((262144 & i) != 0) {
                    $dirty1 &= -234881025;
                }
                if ((i & 524288) != 0) {
                    $dirty1 &= -1879048193;
                }
                leadingIcon = function23;
                trailingIcon = function24;
                isError2 = isError;
                singleLine2 = singleLine;
                maxLines3 = maxLines;
                interactionSource3 = interactionSource;
                shape3 = shape;
                colors2 = colors;
                $dirty2 = $dirty5;
                $composer2 = $composer4;
                label = function25;
                placeholder = function26;
                modifier3 = modifier2;
                visualTransformation2 = visualTransformation;
                keyboardActions3 = keyboardActions;
                minLines2 = minLines;
                $dirty14 = $dirty1;
                textStyle4 = textStyle2;
                keyboardOptions2 = keyboardOptions;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                readOnly3 = readOnly2;
                keyboardOptions3 = keyboardOptions2;
                ComposerKt.traceEventStart(237745923, $dirty2, $dirty14, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:358)");
            } else {
                readOnly3 = readOnly2;
                keyboardOptions3 = keyboardOptions2;
            }
            $composer2.startReplaceableGroup(1961404947);
            ComposerKt.sourceInformation($composer2, "*361@18420L18");
            long $this$takeOrElse_u2dDxMtmZc$iv = textStyle4.m5804getColor0d7_KjU();
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m3985getUnspecified0d7_KjU()) {
                $dirty15 = $dirty14;
            } else {
                $dirty15 = $dirty14;
                $this$takeOrElse_u2dDxMtmZc$iv = colors2.textColor(enabled2, $composer2, (($dirty2 >> 9) & 14) | (($dirty14 >> 24) & 112)).getValue().m3959unboximpl();
            }
            $composer2.endReplaceableGroup();
            long textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            TextStyle mergedTextStyle = textStyle4.merge(new TextStyle(textColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            TextStyle textStyle6 = textStyle4;
            Modifier modifier5 = modifier3;
            final boolean isError5 = isError2;
            final Shape shape5 = shape3;
            final boolean enabled5 = enabled2;
            final TextFieldColors colors4 = colors2;
            final boolean singleLine5 = singleLine2;
            final VisualTransformation visualTransformation5 = visualTransformation2;
            final MutableInteractionSource interactionSource5 = interactionSource3;
            final Function2 label3 = label;
            final Function2 placeholder3 = placeholder;
            final Function2 leadingIcon3 = leadingIcon;
            final Function2 trailingIcon3 = trailingIcon;
            boolean readOnly6 = readOnly3;
            KeyboardOptions keyboardOptions6 = keyboardOptions3;
            Composer $composer5 = $composer2;
            BasicTextFieldKt.BasicTextField(value, function1, SizeKt.m800defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(BackgroundKt.m414backgroundbw27NRU(label != null ? PaddingKt.m771paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.8
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                }
            }), 0.0f, OutlinedTextFieldTopPadding, 0.0f, 0.0f, 13, null) : modifier3, colors2.backgroundColor(enabled2, $composer2, (($dirty2 >> 9) & 14) | (($dirty15 >> 24) & 112)).getValue().m3959unboximpl(), shape3), isError2, Strings_androidKt.m1667getString4foXLRw(Strings.INSTANCE.m1662getDefaultErrorMessageUdPEhr4(), $composer2, 6)), TextFieldDefaults.INSTANCE.m1709getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m1708getMinHeightD9Ej5fM()), enabled2, readOnly6, mergedTextStyle, keyboardOptions6, keyboardActions3, singleLine2, maxLines3, minLines2, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, interactionSource3, new SolidColor(colors2.cursorColor(isError2, $composer2, ($dirty15 & 14) | (($dirty15 >> 24) & 112)).getValue().m3959unboximpl(), null), ComposableLambdaKt.composableLambda($composer2, -1001528775, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function27, Composer composer, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function27, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function27, Composer $composer6, int $changed2) {
                    ComposerKt.sourceInformation($composer6, "C396@19856L839:OutlinedTextField.kt#jmzs0o");
                    int $dirty6 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty6 |= $composer6.changedInstance(function27) ? 4 : 2;
                    }
                    if (($dirty6 & 91) == 18 && $composer6.getSkipping()) {
                        $composer6.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1001528775, $dirty6, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:396)");
                    }
                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                    String text = value.getText();
                    boolean z = enabled5;
                    int $dirty7 = $dirty6;
                    boolean z2 = singleLine5;
                    VisualTransformation visualTransformation6 = visualTransformation5;
                    MutableInteractionSource mutableInteractionSource = interactionSource5;
                    boolean z3 = isError5;
                    Function2<Composer, Integer, Unit> function28 = label3;
                    Function2<Composer, Integer, Unit> function29 = placeholder3;
                    Function2<Composer, Integer, Unit> function210 = leadingIcon3;
                    Function2<Composer, Integer, Unit> function211 = trailingIcon3;
                    TextFieldColors textFieldColors2 = colors4;
                    final boolean z4 = enabled5;
                    final boolean z5 = isError5;
                    final MutableInteractionSource mutableInteractionSource2 = interactionSource5;
                    final TextFieldColors textFieldColors3 = colors4;
                    final Shape shape6 = shape5;
                    textFieldDefaults.OutlinedTextFieldDecorationBox(text, function27, z, z2, visualTransformation6, mutableInteractionSource, z3, function28, function29, function210, function211, textFieldColors2, null, ComposableLambdaKt.composableLambda($composer6, -753611134, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.9.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer7, int $changed3) {
                            ComposerKt.sourceInformation($composer7, "C410@20460L203:OutlinedTextField.kt#jmzs0o");
                            if (($changed3 & 11) != 2 || !$composer7.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-753611134, $changed3, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:410)");
                                }
                                TextFieldDefaults.INSTANCE.m1706BorderBoxnbWgWpA(z4, z5, mutableInteractionSource2, textFieldColors3, shape6, 0.0f, 0.0f, $composer7, 12582912, 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer7.skipToGroupEnd();
                        }
                    }), $composer6, ($dirty7 << 3) & 112, 27648, 4096);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer5, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 7168) | ($dirty2 & 57344) | (($dirty15 << 12) & 3670016) | (($dirty15 << 12) & 29360128) | (($dirty15 << 12) & 234881024) | (($dirty15 << 12) & 1879048192), (($dirty15 >> 18) & 14) | ProfileVerifier.CompilationStatus.f249xf2722a21 | ($dirty15 & 112) | (($dirty15 >> 12) & 7168), 4096);
            $composer3 = $composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            VisualTransformation visualTransformation6 = visualTransformation2;
            singleLine3 = singleLine2;
            visualTransformation3 = visualTransformation6;
            textStyle5 = textStyle6;
            colors3 = colors4;
            enabled3 = enabled2;
            readOnly4 = readOnly6;
            maxLines4 = maxLines3;
            interactionSource4 = interactionSource3;
            modifier4 = modifier5;
            label2 = label;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            shape4 = shape5;
            keyboardOptions4 = keyboardOptions6;
            minLines3 = minLines2;
            trailingIcon2 = trailingIcon;
            keyboardActions4 = keyboardActions3;
            isError3 = isError5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.10
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

                public final void invoke(Composer composer, int i24) {
                    OutlinedTextFieldKt.OutlinedTextField(value, function1, modifier4, enabled3, readOnly4, textStyle5, label2, placeholder2, leadingIcon2, trailingIcon2, isError3, visualTransformation3, keyboardOptions4, keyboardActions4, singleLine3, maxLines4, minLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void OutlinedTextField(final TextFieldValue value, final Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, Function2 label, Function2 placeholder, Function2 leadingIcon, Function2 trailingIcon, boolean isError, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, MutableInteractionSource interactionSource, Shape shape, TextFieldColors colors, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        boolean enabled2;
        boolean readOnly2;
        TextStyle textStyle2;
        Function2 function2;
        Function2 function22;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        TextFieldColors textFieldColors;
        int $dirty1;
        int $dirty;
        TextStyle textStyle3;
        int $dirty12;
        KeyboardActions keyboardActions2;
        MutableInteractionSource interactionSource2;
        Shape shape2;
        int $dirty13;
        Composer $composer2;
        TextFieldColors colors2;
        KeyboardActions keyboardActions3;
        Modifier modifier3;
        TextStyle textStyle4;
        int $dirty2;
        Function2 label2;
        Function2 placeholder2;
        Function2 leadingIcon2;
        Function2 trailingIcon2;
        boolean isError2;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        boolean singleLine2;
        int maxLines2;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        Object value$iv$iv;
        final Modifier modifier4;
        final boolean enabled3;
        final boolean readOnly3;
        final TextStyle textStyle5;
        final Function2 label3;
        final Function2 placeholder3;
        final Function2 leadingIcon3;
        final Function2 label4;
        final boolean isError3;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions4;
        final boolean singleLine3;
        final int maxLines3;
        final MutableInteractionSource interactionSource4;
        final Shape shape4;
        final TextFieldColors colors3;
        int $dirty14;
        Composer $composer3 = $composer.startRestartGroup(-288998816);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)434@21088L7,445@21642L39,446@21720L22,447@21792L25,449@21826L416:OutlinedTextField.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty15 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changedInstance(onValueChange) ? 32 : 16;
        }
        int i8 = i & 4;
        if (i8 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i9 = i & 8;
        if (i9 != 0) {
            $dirty3 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 7168) == 0) {
            enabled2 = enabled;
            $dirty3 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i10 = i & 16;
        if (i10 != 0) {
            $dirty3 |= 24576;
            readOnly2 = readOnly;
        } else if (($changed & 57344) == 0) {
            readOnly2 = readOnly;
            $dirty3 |= $composer3.changed(readOnly2) ? 16384 : 8192;
        } else {
            readOnly2 = readOnly;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                textStyle2 = textStyle;
                int i11 = $composer3.changed(textStyle2) ? 131072 : 65536;
                $dirty3 |= i11;
            } else {
                textStyle2 = textStyle;
            }
            $dirty3 |= i11;
        } else {
            textStyle2 = textStyle;
        }
        int i12 = i & 64;
        if (i12 != 0) {
            $dirty3 |= 1572864;
            function2 = label;
        } else if (($changed & 3670016) == 0) {
            function2 = label;
            $dirty3 |= $composer3.changedInstance(function2) ? 1048576 : 524288;
        } else {
            function2 = label;
        }
        int i13 = i & 128;
        if (i13 != 0) {
            $dirty3 |= 12582912;
            function22 = placeholder;
        } else if (($changed & 29360128) == 0) {
            function22 = placeholder;
            $dirty3 |= $composer3.changedInstance(function22) ? 8388608 : 4194304;
        } else {
            function22 = placeholder;
        }
        int i14 = i & 256;
        if (i14 != 0) {
            $dirty3 |= 100663296;
            i2 = i14;
        } else if (($changed & 234881024) == 0) {
            i2 = i14;
            $dirty3 |= $composer3.changedInstance(leadingIcon) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i14;
        }
        int i15 = i & 512;
        if (i15 != 0) {
            $dirty3 |= 805306368;
            i3 = i15;
        } else if (($changed & 1879048192) == 0) {
            i3 = i15;
            $dirty3 |= $composer3.changedInstance(trailingIcon) ? 536870912 : 268435456;
        } else {
            i3 = i15;
        }
        int i16 = i & 1024;
        if (i16 != 0) {
            $dirty15 |= 6;
            i4 = i16;
        } else if (($changed1 & 14) == 0) {
            i4 = i16;
            $dirty15 |= $composer3.changed(isError) ? 4 : 2;
        } else {
            i4 = i16;
        }
        int i17 = i & 2048;
        if (i17 != 0) {
            $dirty15 |= 48;
            i5 = i17;
        } else if (($changed1 & 112) == 0) {
            i5 = i17;
            $dirty15 |= $composer3.changed(visualTransformation) ? 32 : 16;
        } else {
            i5 = i17;
        }
        int i18 = i & 4096;
        if (i18 != 0) {
            $dirty15 |= 384;
            i6 = i18;
        } else {
            i6 = i18;
            if (($changed1 & 896) == 0) {
                $dirty15 |= $composer3.changed(keyboardOptions) ? 256 : 128;
            }
        }
        if (($changed1 & 7168) == 0) {
            $dirty15 |= ((i & 8192) == 0 && $composer3.changed(keyboardActions)) ? 2048 : 1024;
        }
        int i19 = i & 16384;
        if (i19 != 0) {
            $dirty15 |= 24576;
            i7 = i19;
        } else if (($changed1 & 57344) == 0) {
            i7 = i19;
            $dirty15 |= $composer3.changed(singleLine) ? 16384 : 8192;
        } else {
            i7 = i19;
        }
        int i20 = i & 32768;
        if (i20 != 0) {
            $dirty15 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed1 & 458752) == 0) {
            $dirty15 |= $composer3.changed(maxLines) ? 131072 : 65536;
        }
        int i21 = i & 65536;
        if (i21 != 0) {
            $dirty15 |= 1572864;
        } else if (($changed1 & 3670016) == 0) {
            $dirty15 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        if (($changed1 & 29360128) == 0) {
            $dirty15 |= ((i & 131072) == 0 && $composer3.changed(shape)) ? 8388608 : 4194304;
        }
        if (($changed1 & 234881024) == 0) {
            if ((i & 262144) == 0) {
                $dirty14 = $dirty15;
                textFieldColors = colors;
                int i22 = $composer3.changed(textFieldColors) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
                $dirty1 = $dirty14 | i22;
            } else {
                $dirty14 = $dirty15;
                textFieldColors = colors;
            }
            $dirty1 = $dirty14 | i22;
        } else {
            int $dirty16 = $dirty15;
            textFieldColors = colors;
            $dirty1 = $dirty16;
        }
        int $dirty4 = $dirty3;
        if (($dirty3 & 1533916891) == 306783378 && (191739611 & $dirty1) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            leadingIcon3 = leadingIcon;
            visualTransformation3 = visualTransformation;
            keyboardOptions3 = keyboardOptions;
            maxLines3 = maxLines;
            interactionSource4 = interactionSource;
            shape4 = shape;
            $composer2 = $composer3;
            colors3 = textFieldColors;
            enabled3 = enabled2;
            readOnly3 = readOnly2;
            textStyle5 = textStyle2;
            label3 = function2;
            placeholder3 = function22;
            modifier4 = modifier2;
            label4 = trailingIcon;
            isError3 = isError;
            keyboardActions4 = keyboardActions;
            singleLine3 = singleLine;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i8 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i9 != 0 ? true : enabled2;
                boolean readOnly4 = i10 != 0 ? false : readOnly2;
                if ((i & 32) != 0) {
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle3 = (TextStyle) objConsume;
                    $dirty = $dirty4 & (-458753);
                } else {
                    $dirty = $dirty4;
                    textStyle3 = textStyle2;
                }
                Function2 label5 = i12 != 0 ? null : function2;
                Function2 placeholder4 = i13 != 0 ? null : function22;
                Function2 leadingIcon4 = i2 != 0 ? null : leadingIcon;
                Function2 trailingIcon3 = i3 != 0 ? null : trailingIcon;
                boolean isError4 = i4 != 0 ? false : isError;
                VisualTransformation visualTransformation4 = i5 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                KeyboardOptions keyboardOptions4 = i6 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                if ((i & 8192) != 0) {
                    $dirty12 = $dirty1 & (-7169);
                    keyboardActions2 = new KeyboardActions(null, null, null, null, null, null, 63, null);
                } else {
                    $dirty12 = $dirty1;
                    keyboardActions2 = keyboardActions;
                }
                boolean singleLine4 = i7 != 0 ? false : singleLine;
                int maxLines4 = i20 != 0 ? Integer.MAX_VALUE : maxLines;
                if (i21 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    interactionSource2 = interactionSource;
                }
                if ((i & 131072) != 0) {
                    shape2 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape($composer3, 6);
                    $dirty13 = $dirty12 & (-29360129);
                } else {
                    shape2 = shape;
                    $dirty13 = $dirty12;
                }
                if ((262144 & i) != 0) {
                    $composer2 = $composer3;
                    keyboardActions3 = keyboardActions2;
                    modifier3 = modifier5;
                    colors2 = TextFieldDefaults.INSTANCE.m1712outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 0, 48, 2097151);
                    $dirty1 = $dirty13 & (-234881025);
                    enabled2 = enabled4;
                    readOnly2 = readOnly4;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    label2 = label5;
                    placeholder2 = placeholder4;
                    leadingIcon2 = leadingIcon4;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    maxLines2 = maxLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                } else {
                    $composer2 = $composer3;
                    colors2 = colors;
                    keyboardActions3 = keyboardActions2;
                    modifier3 = modifier5;
                    enabled2 = enabled4;
                    readOnly2 = readOnly4;
                    textStyle4 = textStyle3;
                    $dirty2 = $dirty;
                    label2 = label5;
                    placeholder2 = placeholder4;
                    leadingIcon2 = leadingIcon4;
                    trailingIcon2 = trailingIcon3;
                    isError2 = isError4;
                    visualTransformation2 = visualTransformation4;
                    keyboardOptions2 = keyboardOptions4;
                    singleLine2 = singleLine4;
                    maxLines2 = maxLines4;
                    interactionSource3 = interactionSource2;
                    shape3 = shape2;
                    $dirty1 = $dirty13;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty5 = (i & 32) != 0 ? $dirty4 & (-458753) : $dirty4;
                if ((i & 8192) != 0) {
                    $dirty1 &= -7169;
                }
                if ((i & 131072) != 0) {
                    $dirty1 &= -29360129;
                }
                if ((262144 & i) != 0) {
                    $dirty1 &= -234881025;
                }
                leadingIcon2 = leadingIcon;
                trailingIcon2 = trailingIcon;
                keyboardOptions2 = keyboardOptions;
                keyboardActions3 = keyboardActions;
                singleLine2 = singleLine;
                maxLines2 = maxLines;
                interactionSource3 = interactionSource;
                shape3 = shape;
                $composer2 = $composer3;
                $dirty2 = $dirty5;
                colors2 = textFieldColors;
                textStyle4 = textStyle2;
                label2 = function2;
                placeholder2 = function22;
                modifier3 = modifier2;
                isError2 = isError;
                visualTransformation2 = visualTransformation;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-288998816, $dirty2, $dirty1, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:448)");
            }
            OutlinedTextField(value, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier3, enabled2, readOnly2, textStyle4, (Function2<? super Composer, ? super Integer, Unit>) label2, (Function2<? super Composer, ? super Integer, Unit>) placeholder2, (Function2<? super Composer, ? super Integer, Unit>) leadingIcon2, (Function2<? super Composer, ? super Integer, Unit>) trailingIcon2, isError2, visualTransformation2, keyboardOptions2, keyboardActions3, singleLine2, maxLines2, 1, interactionSource3, shape3, colors2, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | ($dirty2 & 57344) | ($dirty2 & 458752) | ($dirty2 & 3670016) | ($dirty2 & 29360128) | ($dirty2 & 234881024) | (1879048192 & $dirty2), ($dirty1 & 14) | 1572864 | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | ($dirty1 & 57344) | ($dirty1 & 458752) | (($dirty1 << 3) & 29360128) | (($dirty1 << 3) & 234881024) | (($dirty1 << 3) & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            enabled3 = enabled2;
            readOnly3 = readOnly2;
            textStyle5 = textStyle4;
            label3 = label2;
            placeholder3 = placeholder2;
            leadingIcon3 = leadingIcon2;
            label4 = trailingIcon2;
            isError3 = isError2;
            visualTransformation3 = visualTransformation2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions4 = keyboardActions3;
            singleLine3 = singleLine2;
            maxLines3 = maxLines2;
            interactionSource4 = interactionSource3;
            shape4 = shape3;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField.12
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
                    OutlinedTextFieldKt.OutlinedTextField(value, onValueChange, modifier4, enabled3, readOnly3, textStyle5, label3, placeholder3, leadingIcon3, label4, isError3, visualTransformation3, keyboardOptions3, keyboardActions4, singleLine3, maxLines3, interactionSource4, shape4, colors3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void OutlinedTextFieldLayout(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean singleLine, final float animationProgress, final Function1<? super Size, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function25, final PaddingValues paddingValues, Composer $composer, final int $changed, final int $changed1) {
        Modifier modifier2;
        int $dirty;
        Function0 factory$iv$iv;
        Composer $composer2;
        float fM6297constructorimpl;
        float f;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        int $changed$iv;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Composer $composer3 = $composer.startRestartGroup(-2049536174);
        ComposerKt.sourceInformation($composer3, "C(OutlinedTextFieldLayout)P(4,9,7,2,3,10,8!1,5)493@22963L239,501@23250L7,502@23262L2308:OutlinedTextField.kt#jmzs0o");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changedInstance(function3) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changedInstance(function22) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function23) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function24) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty2 |= $composer3.changed(singleLine) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty2 |= $composer3.changed(animationProgress) ? 8388608 : 4194304;
        }
        if ((234881024 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((1879048192 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function25) ? 536870912 : 268435456;
        }
        int $dirty3 = $dirty2;
        if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(paddingValues) ? 4 : 2;
        }
        int $dirty12 = $dirty1;
        if ((1533916891 & $dirty3) != 306783378 || ($dirty12 & 11) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2049536174, $dirty3, $dirty12, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:492)");
            }
            Object[] keys$iv = {function1, Boolean.valueOf(singleLine), Float.valueOf(animationProgress), paddingValues};
            $dirty = $dirty3;
            $composer3.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            int length = keys$iv.length;
            int $dirty13 = 0;
            while ($dirty13 < length) {
                int i = length;
                Object key$iv = keys$iv[$dirty13];
                invalid$iv |= $composer3.changed(key$iv);
                $dirty13++;
                length = i;
            }
            Object value$iv$iv = $composer3.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new OutlinedTextFieldMeasurePolicy(function1, singleLine, animationProgress, paddingValues);
                $composer3.updateRememberedValue(value$iv$iv);
            }
            $composer3.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy measurePolicy = (OutlinedTextFieldMeasurePolicy) value$iv$iv;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            int $changed$iv2 = ($dirty << 3) & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv = $composer3.getCurrentCompositionLocalMap();
            Function0 factory$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.modifierMaterializerOf(modifier2);
            int $changed$iv$iv = (($changed$iv2 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv = factory$iv$iv2;
                $composer3.createNode(factory$iv$iv);
            } else {
                factory$iv$iv = factory$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3479constructorimpl($composer3);
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
            }
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i2 = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1169918312, "C510@23766L8,549@25214L182:OutlinedTextField.kt#jmzs0o");
            function25.invoke($composer3, Integer.valueOf(($dirty >> 27) & 14));
            $composer3.startReplaceableGroup(1169918334);
            ComposerKt.sourceInformation($composer3, "513@23827L219");
            if (function23 != null) {
                Modifier modifier$iv = LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Function0 factory$iv$iv$iv5 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifier$iv);
                int $changed$iv$iv$iv = ((((48 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv5;
                    $composer3.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv5;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3479constructorimpl($composer3);
                $composer2 = $composer3;
                Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                }
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i3 = ($changed$iv$iv$iv >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i4 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -905297530, "C517@24019L9:OutlinedTextField.kt#jmzs0o");
                function23.invoke($composer3, Integer.valueOf(($dirty >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            } else {
                $composer2 = $composer3;
            }
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(1169918619);
            ComposerKt.sourceInformation($composer3, "521@24113L221");
            if (function24 != null) {
                Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Function0 factory$iv$iv$iv6 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.modifierMaterializerOf(modifier$iv2);
                int $changed$iv$iv$iv2 = ((((48 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer3.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3479constructorimpl($composer3);
                Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
                }
                skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i5 = ($changed$iv$iv$iv2 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i6 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -905297243, "C525@24306L10:OutlinedTextField.kt#jmzs0o");
                function24.invoke($composer3, Integer.valueOf(($dirty >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
            float startTextFieldPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            float endTextFieldPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            Modifier.Companion companion = Modifier.INSTANCE;
            if (function23 != null) {
                float other$iv = TextFieldImplKt.getHorizontalIconPadding();
                float other$iv2 = C1956Dp.m6297constructorimpl(startTextFieldPadding - other$iv);
                float minimumValue$iv = C1956Dp.m6297constructorimpl(0);
                fM6297constructorimpl = C1956Dp.m6297constructorimpl(RangesKt.coerceAtLeast(other$iv2, minimumValue$iv));
            } else {
                fM6297constructorimpl = startTextFieldPadding;
            }
            if (function24 != null) {
                float other$iv3 = TextFieldImplKt.getHorizontalIconPadding();
                float other$iv4 = C1956Dp.m6297constructorimpl(endTextFieldPadding - other$iv3);
                float minimumValue$iv2 = C1956Dp.m6297constructorimpl(0);
                float $this$coerceAtLeast_u2dYgX7TsA$iv = C1956Dp.m6297constructorimpl(RangesKt.coerceAtLeast(other$iv4, minimumValue$iv2));
                f = $this$coerceAtLeast_u2dYgX7TsA$iv;
            } else {
                f = endTextFieldPadding;
            }
            Modifier padding = PaddingKt.m771paddingqDBjuR0$default(companion, fM6297constructorimpl, 0.0f, f, 0.0f, 10, null);
            $composer3.startReplaceableGroup(1169919630);
            ComposerKt.sourceInformation($composer3, "546@25127L59");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(padding), $composer3, Integer.valueOf(($dirty >> 3) & 112));
            }
            $composer3.endReplaceableGroup();
            Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(padding);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, true, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Function0 factory$iv$iv$iv7 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.modifierMaterializerOf(modifier$iv3);
            int $changed$iv$iv$iv3 = ((((384 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3479constructorimpl($composer3);
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), block$iv$iv$iv3);
            }
            skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i7 = ($changed$iv$iv$iv3 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            int i8 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -905296178, "C553@25371L11:OutlinedTextField.kt#jmzs0o");
            function2.invoke($composer3, Integer.valueOf(($dirty >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(-614207693);
            ComposerKt.sourceInformation($composer3, "557@25447L54");
            if (function22 != null) {
                Modifier modifier$iv4 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Label");
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv4 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv4, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                Function0 factory$iv$iv$iv8 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv4 = LayoutKt.modifierMaterializerOf(modifier$iv4);
                int $changed$iv$iv$iv4 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv8;
                    $composer3.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv8;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3479constructorimpl($composer3);
                Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                    $changed$iv = 6;
                } else {
                    $changed$iv = 6;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                    }
                    skippableUpdate$iv$iv$iv4.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & 112));
                    $composer3.startReplaceableGroup(2058660585);
                    int i9 = ($changed$iv$iv$iv4 >> 9) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    int i10 = (($changed$iv >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -905296057, "C557@25492L7:OutlinedTextField.kt#jmzs0o");
                    function22.invoke($composer3, Integer.valueOf(($dirty >> 9) & 14));
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endReplaceableGroup();
                    $composer3.endNode();
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                }
                $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), block$iv$iv$iv4);
                skippableUpdate$iv$iv$iv4.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i92 = ($changed$iv$iv$iv4 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance42 = BoxScopeInstance.INSTANCE;
                int i102 = (($changed$iv >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -905296057, "C557@25492L7:OutlinedTextField.kt#jmzs0o");
                function22.invoke($composer3, Integer.valueOf(($dirty >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $dirty = $dirty3;
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextFieldLayout.2
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
                    OutlinedTextFieldKt.OutlinedTextFieldLayout(modifier3, function2, function3, function22, function23, function24, singleLine, animationProgress, function1, function25, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-O3s9Psw, reason: not valid java name */
    public static final int m1610calculateWidthO3s9Psw(int leadingPlaceableWidth, int trailingPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        int middleSection = Math.max(textFieldPlaceableWidth, Math.max(MathHelpersKt.lerp(labelPlaceableWidth, 0, animationProgress), placeholderPlaceableWidth));
        int wrappedWidth = leadingPlaceableWidth + middleSection + trailingPlaceableWidth;
        float arg0$iv = paddingValues.mo718calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr);
        float other$iv = paddingValues.mo719calculateRightPaddingu2uoSUM(LayoutDirection.Ltr);
        float labelHorizontalPadding = C1956Dp.m6297constructorimpl(arg0$iv + other$iv) * density;
        int focusedLabelWidth = MathKt.roundToInt((labelPlaceableWidth + labelHorizontalPadding) * animationProgress);
        return Math.max(wrappedWidth, Math.max(focusedLabelWidth, Constraints.m6255getMinWidthimpl(constraints)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m1609calculateHeightO3s9Psw(int leadingPlaceableHeight, int trailingPlaceableHeight, int textFieldPlaceableHeight, int labelPlaceableHeight, int placeholderPlaceableHeight, float animationProgress, long constraints, float density, PaddingValues paddingValues) {
        int inputFieldHeight = Math.max(textFieldPlaceableHeight, Math.max(placeholderPlaceableHeight, MathHelpersKt.lerp(labelPlaceableHeight, 0, animationProgress)));
        float topPadding = paddingValues.getTop() * density;
        float actualTopPadding = MathHelpersKt.lerp(topPadding, Math.max(topPadding, labelPlaceableHeight / 2.0f), animationProgress);
        float bottomPadding = paddingValues.getBottom() * density;
        float middleSectionHeight = inputFieldHeight + actualTopPadding + bottomPadding;
        return Math.max(Constraints.m6254getMinHeightimpl(constraints), Math.max(leadingPlaceableHeight, Math.max(trailingPlaceableHeight, MathKt.roundToInt(middleSectionHeight))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope $this$place, int height, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable borderPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int iAlign;
        int iAlign2;
        int startPositionY;
        float fWidthOrZero;
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
        if (singleLine) {
            iAlign = Alignment.INSTANCE.getCenterVertically().align(textFieldPlaceable.getHeight(), height);
        } else {
            iAlign = topPadding;
        }
        int textVerticalPosition = Math.max(iAlign, TextFieldImplKt.heightOrZero(labelPlaceable) / 2);
        Placeable.PlacementScope.placeRelative$default($this$place, textFieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textVerticalPosition, 0.0f, 4, null);
        if (placeholderPlaceable != null) {
            if (singleLine) {
                iAlign2 = Alignment.INSTANCE.getCenterVertically().align(placeholderPlaceable.getHeight(), height);
            } else {
                iAlign2 = topPadding;
            }
            int placeholderVerticalPosition = Math.max(iAlign2, TextFieldImplKt.heightOrZero(labelPlaceable) / 2);
            Placeable.PlacementScope.placeRelative$default($this$place, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), placeholderVerticalPosition, 0.0f, 4, null);
        }
        Placeable.PlacementScope.m5270place70tqf50$default($this$place, borderPlaceable, IntOffset.INSTANCE.m6435getZeronOccac(), 0.0f, 2, null);
    }

    /* renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m1611outlineCutout12SF9DM(Modifier $this$outlineCutout_u2d12SF9DM, final long labelSize, final PaddingValues paddingValues) {
        return DrawModifierKt.drawWithContent($this$outlineCutout_u2d12SF9DM, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$outlineCutout$1

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
