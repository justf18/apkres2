package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.text.input.VisualTransformation;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: TextFieldDefaults.kt */
@Metadata(m164d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%J×\u0001\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+H\u0007¢\u0006\u0002\u00106JÂ\u0001\u00107\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u000204H\u0007¢\u0006\u0002\u00108Jä\u0001\u00109\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010@\u001a\u00020;2\b\b\u0002\u0010A\u001a\u00020;2\b\b\u0002\u0010B\u001a\u00020;2\b\b\u0002\u0010C\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ:\u0010R\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\bW\u0010XJä\u0001\u0010Y\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010Z\u001a\u00020;2\b\b\u0002\u0010[\u001a\u00020;2\b\b\u0002\u0010\\\u001a\u00020;2\b\b\u0002\u0010]\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0000¢\u0006\u0004\b^\u0010QJ:\u0010_\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b`\u0010XJ:\u0010a\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\bb\u0010XJJ\u0010c\u001a\u00020d*\u00020d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010e\u001a\u00020\u00062\b\b\u0002\u0010f\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\bg\u0010hR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\f\u0010\bR\u0019\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\u0015\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0016\u0010\bR\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, m165d2 = {"Landroidx/compose/material/TextFieldDefaults;", "", "()V", "BackgroundOpacity", "", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "IconOpacity", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedTextFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getOutlinedTextFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "TextFieldShape", "getTextFieldShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorLineOpacity", "BorderBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "shape", "focusedBorderThickness", "unfocusedBorderThickness", "BorderBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", OutlinedTextFieldKt.BorderId, "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "outlinedTextFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-dx8h9Zs", "(JJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldPadding", "start", "top", "end", "bottom", "outlinedTextFieldPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-dx8h9Zs", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldDefaults {
    public static final int $stable = 0;
    public static final float BackgroundOpacity = 0.12f;
    public static final float IconOpacity = 0.54f;
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = C1956Dp.m6297constructorimpl(56);
    private static final float MinWidth = C1956Dp.m6297constructorimpl(280);
    private static final float UnfocusedBorderThickness = C1956Dp.m6297constructorimpl(1);
    private static final float FocusedBorderThickness = C1956Dp.m6297constructorimpl(2);

    private TextFieldDefaults() {
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1708getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1709getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final Shape getTextFieldShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1117199624, "C233@8407L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1117199624, $changed, -1, "androidx.compose.material.TextFieldDefaults.<get-TextFieldShape> (TextFieldDefaults.kt:233)");
        }
        CornerBasedShape cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return cornerBasedShapeCopy$default;
    }

    public final Shape getOutlinedTextFieldShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1899109048, "C242@8709L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1899109048, $changed, -1, "androidx.compose.material.TextFieldDefaults.<get-OutlinedTextFieldShape> (TextFieldDefaults.kt:242)");
        }
        CornerBasedShape small = MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return small;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1710getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1707getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1702indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        float f3;
        float f4;
        if ((i & 16) == 0) {
            f3 = f;
        } else {
            f3 = FocusedBorderThickness;
        }
        if ((i & 32) == 0) {
            f4 = f2;
        } else {
            f4 = UnfocusedBorderThickness;
        }
        return textFieldDefaults.m1711indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f3, f4);
    }

    /* renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m1711indicatorLinegv0btCI(Modifier $this$indicatorLine_u2dgv0btCI, final boolean enabled, final boolean isError, final InteractionSource interactionSource, final TextFieldColors colors, final float focusedIndicatorLineThickness, final float unfocusedIndicatorLineThickness) {
        return ComposedModifierKt.composed($this$indicatorLine_u2dgv0btCI, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                $this$null.setName("indicatorLine");
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("isError", Boolean.valueOf(isError));
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("colors", colors);
                $this$null.getProperties().set("focusedIndicatorLineThickness", C1956Dp.m6295boximpl(focusedIndicatorLineThickness));
                $this$null.getProperties().set("unfocusedIndicatorLineThickness", C1956Dp.m6295boximpl(unfocusedIndicatorLineThickness));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
                $composer.startReplaceableGroup(1398930845);
                ComposerKt.sourceInformation($composer, "C299@11111L217:TextFieldDefaults.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1398930845, $changed, -1, "androidx.compose.material.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:299)");
                }
                State stroke = TextFieldDefaultsKt.m1718animateBorderStrokeAsStateNuRrP5Q(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness, $composer, 0);
                Modifier modifierDrawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, (BorderStroke) stroke.getValue());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return modifierDrawIndicatorLine;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0117  */
    /* renamed from: BorderBox-nbWgWpA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1706BorderBoxnbWgWpA(final boolean r20, final boolean r21, final androidx.compose.foundation.interaction.InteractionSource r22, final androidx.compose.material.TextFieldColors r23, androidx.compose.p000ui.graphics.Shape r24, float r25, float r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.m1706BorderBoxnbWgWpA(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1704textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getFirstBaselineOffset();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.m1715textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1715textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m763PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1705textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1716textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1716textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m763PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1703outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1713outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1713outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m763PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: textFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1714textFieldColorsdx8h9Zs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long backgroundColor2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long unfocusedIndicatorColor3;
        long disabledIndicatorColor2;
        long leadingIconColor2;
        long leadingIconColor3;
        long leadingIconColor4;
        long trailingIconColor2;
        long trailingIconColor3;
        long trailingIconColor4;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long unfocusedLabelColor3;
        long unfocusedLabelColor4;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        $composer.startReplaceableGroup(231892599);
        ComposerKt.sourceInformation($composer, "C(textFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)395@14785L7,395@14816L7,396@14889L8,397@14947L6,398@15040L6,399@15104L6,401@15183L6,401@15224L4,403@15298L6,404@15450L8,405@15512L6,407@15586L6,408@15715L8,411@15844L6,412@15975L8,413@16040L6,415@16115L6,415@16156L4,416@16214L6,416@16249L6,417@16332L8,418@16390L6,419@16452L6,419@16487L6,420@16573L8:TextFieldDefaults.kt#jmzs0o");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long jM3959unboximpl = ((Color) objConsume).m3959unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m3947copywmQWz5c(jM3959unboximpl, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM3959unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m3955getRedimpl(jM3959unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM3959unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM3959unboximpl) : 0.0f);
        } else {
            textColor2 = textColor;
        }
        long disabledTextColor2 = (i & 2) != 0 ? Color.m3947copywmQWz5c(textColor2, (14 & 1) != 0 ? Color.m3951getAlphaimpl(textColor2) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(textColor2) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(textColor2) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(textColor2) : 0.0f) : disabledTextColor;
        if ((i & 4) != 0) {
            long jM1489getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1489getOnSurface0d7_KjU();
            backgroundColor2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU) : 0.12f, (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU) : 0.0f);
        } else {
            backgroundColor2 = backgroundColor;
        }
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1490getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1484getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            long jM1490getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1490getPrimary0d7_KjU();
            focusedIndicatorColor2 = Color.m3947copywmQWz5c(jM1490getPrimary0d7_KjU, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1490getPrimary0d7_KjU) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(jM1490getPrimary0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1490getPrimary0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1490getPrimary0d7_KjU) : 0.0f);
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i & 64) != 0) {
            long jM1489getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1489getOnSurface0d7_KjU();
            unfocusedIndicatorColor2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU2) : 0.42f, (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU2) : 0.0f);
        } else {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        }
        if ((i & 128) != 0) {
            long unfocusedIndicatorColor4 = unfocusedIndicatorColor2;
            unfocusedIndicatorColor3 = unfocusedIndicatorColor4;
            disabledIndicatorColor2 = Color.m3947copywmQWz5c(unfocusedIndicatorColor4, (14 & 1) != 0 ? Color.m3951getAlphaimpl(unfocusedIndicatorColor4) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(unfocusedIndicatorColor4) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(unfocusedIndicatorColor4) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(unfocusedIndicatorColor4) : 0.0f);
        } else {
            unfocusedIndicatorColor3 = unfocusedIndicatorColor2;
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        long errorIndicatorColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1484getError0d7_KjU() : errorIndicatorColor;
        if ((i & 512) != 0) {
            long jM1489getOnSurface0d7_KjU3 = MaterialTheme.INSTANCE.getColors($composer, 6).m1489getOnSurface0d7_KjU();
            leadingIconColor2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU3, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU3) : 0.54f, (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU3) : 0.0f);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            long leadingIconColor5 = leadingIconColor2;
            leadingIconColor4 = Color.m3947copywmQWz5c(leadingIconColor5, (14 & 1) != 0 ? Color.m3951getAlphaimpl(leadingIconColor5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(leadingIconColor5) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(leadingIconColor5) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(leadingIconColor5) : 0.0f);
            leadingIconColor3 = leadingIconColor5;
        } else {
            leadingIconColor3 = leadingIconColor2;
            leadingIconColor4 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor3 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            long jM1489getOnSurface0d7_KjU4 = MaterialTheme.INSTANCE.getColors($composer, 6).m1489getOnSurface0d7_KjU();
            trailingIconColor2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU4, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU4) : 0.54f, (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU4) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU4) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU4) : 0.0f);
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            long trailingIconColor5 = trailingIconColor2;
            trailingIconColor4 = Color.m3947copywmQWz5c(trailingIconColor5, (14 & 1) != 0 ? Color.m3951getAlphaimpl(trailingIconColor5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(trailingIconColor5) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(trailingIconColor5) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(trailingIconColor5) : 0.0f);
            trailingIconColor3 = trailingIconColor5;
        } else {
            trailingIconColor3 = trailingIconColor2;
            trailingIconColor4 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (i & 16384) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1484getError0d7_KjU() : errorTrailingIconColor;
        if ((32768 & i) != 0) {
            long jM1490getPrimary0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1490getPrimary0d7_KjU();
            focusedLabelColor2 = Color.m3947copywmQWz5c(jM1490getPrimary0d7_KjU2, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1490getPrimary0d7_KjU2) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(jM1490getPrimary0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1490getPrimary0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1490getPrimary0d7_KjU2) : 0.0f);
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((65536 & i) != 0) {
            long jM1489getOnSurface0d7_KjU5 = MaterialTheme.INSTANCE.getColors($composer, 6).m1489getOnSurface0d7_KjU();
            unfocusedLabelColor2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU5, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU5) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU5) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU5) : 0.0f);
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((131072 & i) != 0) {
            long unfocusedLabelColor5 = unfocusedLabelColor2;
            unfocusedLabelColor4 = Color.m3947copywmQWz5c(unfocusedLabelColor5, (14 & 1) != 0 ? Color.m3951getAlphaimpl(unfocusedLabelColor5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(unfocusedLabelColor5) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(unfocusedLabelColor5) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(unfocusedLabelColor5) : 0.0f);
            unfocusedLabelColor3 = unfocusedLabelColor5;
        } else {
            unfocusedLabelColor3 = unfocusedLabelColor2;
            unfocusedLabelColor4 = disabledLabelColor;
        }
        long errorLabelColor2 = (262144 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1484getError0d7_KjU() : errorLabelColor;
        if ((524288 & i) != 0) {
            long jM1489getOnSurface0d7_KjU6 = MaterialTheme.INSTANCE.getColors($composer, 6).m1489getOnSurface0d7_KjU();
            placeholderColor2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU6, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU6) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU6) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU6) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU6) : 0.0f);
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 1048576) != 0) {
            long placeholderColor3 = placeholderColor2;
            disabledPlaceholderColor2 = Color.m3947copywmQWz5c(placeholderColor3, (14 & 1) != 0 ? Color.m3951getAlphaimpl(placeholderColor3) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(placeholderColor3) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(placeholderColor3) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(placeholderColor3) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231892599, $changed, $changed1, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:422)");
        }
        long unfocusedIndicatorColor5 = unfocusedIndicatorColor3;
        long unfocusedIndicatorColor6 = errorIndicatorColor2;
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedIndicatorColor2, unfocusedIndicatorColor5, unfocusedIndicatorColor6, disabledIndicatorColor2, leadingIconColor3, leadingIconColor4, errorLeadingIconColor2, trailingIconColor3, trailingIconColor4, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor3, unfocusedLabelColor4, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* renamed from: outlinedTextFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1712outlinedTextFieldColorsdx8h9Zs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long unfocusedBorderColor3;
        long disabledBorderColor2;
        long leadingIconColor2;
        long leadingIconColor3;
        long leadingIconColor4;
        long trailingIconColor2;
        long trailingIconColor3;
        long trailingIconColor4;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long unfocusedLabelColor3;
        long unfocusedLabelColor4;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        $composer.startReplaceableGroup(1762667317);
        ComposerKt.sourceInformation($composer, "C(outlinedTextFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)453@18101L7,453@18132L7,454@18205L8,456@18311L6,457@18375L6,459@18451L6,459@18492L4,461@18563L6,461@18606L8,462@18701L8,463@18760L6,465@18834L6,466@18963L8,469@19092L6,470@19223L8,471@19288L6,473@19363L6,473@19404L4,474@19462L6,474@19497L6,475@19580L8,476@19638L6,477@19700L6,477@19735L6,478@19821L8:TextFieldDefaults.kt#jmzs0o");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long jM3959unboximpl = ((Color) objConsume).m3959unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m3947copywmQWz5c(jM3959unboximpl, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM3959unboximpl) : ((Number) objConsume2).floatValue(), (14 & 2) != 0 ? Color.m3955getRedimpl(jM3959unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM3959unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM3959unboximpl) : 0.0f);
        } else {
            textColor2 = textColor;
        }
        long disabledTextColor2 = (i & 2) != 0 ? Color.m3947copywmQWz5c(textColor2, (14 & 1) != 0 ? Color.m3951getAlphaimpl(textColor2) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(textColor2) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(textColor2) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(textColor2) : 0.0f) : disabledTextColor;
        long backgroundColor2 = (i & 4) != 0 ? Color.INSTANCE.m3984getTransparent0d7_KjU() : backgroundColor;
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1490getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1484getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            long jM1490getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1490getPrimary0d7_KjU();
            focusedBorderColor2 = Color.m3947copywmQWz5c(jM1490getPrimary0d7_KjU, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1490getPrimary0d7_KjU) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(jM1490getPrimary0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1490getPrimary0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1490getPrimary0d7_KjU) : 0.0f);
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i & 64) != 0) {
            long jM1489getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1489getOnSurface0d7_KjU();
            unfocusedBorderColor2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU) : 0.0f);
        } else {
            unfocusedBorderColor2 = unfocusedBorderColor;
        }
        if ((i & 128) != 0) {
            long unfocusedBorderColor4 = unfocusedBorderColor2;
            unfocusedBorderColor3 = unfocusedBorderColor4;
            disabledBorderColor2 = Color.m3947copywmQWz5c(unfocusedBorderColor4, (14 & 1) != 0 ? Color.m3951getAlphaimpl(unfocusedBorderColor4) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(unfocusedBorderColor4) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(unfocusedBorderColor4) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(unfocusedBorderColor4) : 0.0f);
        } else {
            unfocusedBorderColor3 = unfocusedBorderColor2;
            disabledBorderColor2 = disabledBorderColor;
        }
        long errorBorderColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1484getError0d7_KjU() : errorBorderColor;
        if ((i & 512) != 0) {
            long jM1489getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1489getOnSurface0d7_KjU();
            leadingIconColor2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU2) : 0.54f, (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU2) : 0.0f);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            long leadingIconColor5 = leadingIconColor2;
            leadingIconColor4 = Color.m3947copywmQWz5c(leadingIconColor5, (14 & 1) != 0 ? Color.m3951getAlphaimpl(leadingIconColor5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(leadingIconColor5) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(leadingIconColor5) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(leadingIconColor5) : 0.0f);
            leadingIconColor3 = leadingIconColor5;
        } else {
            leadingIconColor3 = leadingIconColor2;
            leadingIconColor4 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor3 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            long jM1489getOnSurface0d7_KjU3 = MaterialTheme.INSTANCE.getColors($composer, 6).m1489getOnSurface0d7_KjU();
            trailingIconColor2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU3, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU3) : 0.54f, (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU3) : 0.0f);
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            long trailingIconColor5 = trailingIconColor2;
            trailingIconColor4 = Color.m3947copywmQWz5c(trailingIconColor5, (14 & 1) != 0 ? Color.m3951getAlphaimpl(trailingIconColor5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(trailingIconColor5) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(trailingIconColor5) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(trailingIconColor5) : 0.0f);
            trailingIconColor3 = trailingIconColor5;
        } else {
            trailingIconColor3 = trailingIconColor2;
            trailingIconColor4 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (i & 16384) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1484getError0d7_KjU() : errorTrailingIconColor;
        if ((32768 & i) != 0) {
            long jM1490getPrimary0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1490getPrimary0d7_KjU();
            focusedLabelColor2 = Color.m3947copywmQWz5c(jM1490getPrimary0d7_KjU2, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1490getPrimary0d7_KjU2) : ContentAlpha.INSTANCE.getHigh($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(jM1490getPrimary0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1490getPrimary0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1490getPrimary0d7_KjU2) : 0.0f);
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((65536 & i) != 0) {
            long jM1489getOnSurface0d7_KjU4 = MaterialTheme.INSTANCE.getColors($composer, 6).m1489getOnSurface0d7_KjU();
            unfocusedLabelColor2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU4, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU4) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU4) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU4) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU4) : 0.0f);
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((131072 & i) != 0) {
            long unfocusedLabelColor5 = unfocusedLabelColor2;
            unfocusedLabelColor4 = Color.m3947copywmQWz5c(unfocusedLabelColor5, (14 & 1) != 0 ? Color.m3951getAlphaimpl(unfocusedLabelColor5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(unfocusedLabelColor5) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(unfocusedLabelColor5) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(unfocusedLabelColor5) : 0.0f);
            unfocusedLabelColor3 = unfocusedLabelColor5;
        } else {
            unfocusedLabelColor3 = unfocusedLabelColor2;
            unfocusedLabelColor4 = disabledLabelColor;
        }
        long errorLabelColor2 = (262144 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1484getError0d7_KjU() : errorLabelColor;
        if ((524288 & i) != 0) {
            long jM1489getOnSurface0d7_KjU5 = MaterialTheme.INSTANCE.getColors($composer, 6).m1489getOnSurface0d7_KjU();
            placeholderColor2 = Color.m3947copywmQWz5c(jM1489getOnSurface0d7_KjU5, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jM1489getOnSurface0d7_KjU5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(jM1489getOnSurface0d7_KjU5) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jM1489getOnSurface0d7_KjU5) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jM1489getOnSurface0d7_KjU5) : 0.0f);
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 1048576) != 0) {
            long placeholderColor3 = placeholderColor2;
            disabledPlaceholderColor2 = Color.m3947copywmQWz5c(placeholderColor3, (14 & 1) != 0 ? Color.m3951getAlphaimpl(placeholderColor3) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m3955getRedimpl(placeholderColor3) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(placeholderColor3) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(placeholderColor3) : 0.0f);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1762667317, $changed, $changed1, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:480)");
        }
        long unfocusedBorderColor5 = unfocusedBorderColor3;
        long unfocusedBorderColor6 = errorBorderColor2;
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedBorderColor2, unfocusedBorderColor5, unfocusedBorderColor6, disabledBorderColor2, leadingIconColor3, leadingIconColor4, errorLeadingIconColor2, trailingIconColor3, trailingIconColor4, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor3, unfocusedLabelColor4, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    public final void TextFieldDecorationBox(final String value, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean enabled, final boolean singleLine, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean isError, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, TextFieldColors colors, PaddingValues contentPadding, Composer $composer, final int $changed, final int $changed1, final int i) {
        String str;
        Function2<? super Composer, ? super Integer, Unit> function26;
        boolean z;
        boolean z2;
        VisualTransformation visualTransformation2;
        InteractionSource interactionSource2;
        boolean z3;
        Function2 label;
        int i2;
        int i3;
        int i4;
        Composer $composer2;
        TextFieldColors colors2;
        boolean isError2;
        PaddingValues contentPadding2;
        TextFieldColors colors3;
        Function2 placeholder;
        Function2 leadingIcon;
        Function2 trailingIcon;
        Function2 label2;
        final Function2 label3;
        final Function2 placeholder2;
        final Function2 leadingIcon2;
        final Function2 trailingIcon2;
        final boolean isError3;
        final PaddingValues contentPadding3;
        final TextFieldColors colors4;
        Composer $composer3 = $composer.startRestartGroup(1171040065);
        ComposerKt.sourceInformation($composer3, "C(TextFieldDecorationBox)P(11,3,2,9,12,4,5,6,8,7,10)572@25710L17,580@25944L569:TextFieldDefaults.kt#jmzs0o");
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
            function26 = function2;
        } else if (($changed & 112) == 0) {
            function26 = function2;
            $dirty |= $composer3.changedInstance(function26) ? 32 : 16;
        } else {
            function26 = function2;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
            z = enabled;
        } else if (($changed & 896) == 0) {
            z = enabled;
            $dirty |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = enabled;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
            z2 = singleLine;
        } else if (($changed & 7168) == 0) {
            z2 = singleLine;
            $dirty |= $composer3.changed(z2) ? 2048 : 1024;
        } else {
            z2 = singleLine;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
            visualTransformation2 = visualTransformation;
        } else if (($changed & 57344) == 0) {
            visualTransformation2 = visualTransformation;
            $dirty |= $composer3.changed(visualTransformation2) ? 16384 : 8192;
        } else {
            visualTransformation2 = visualTransformation;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            interactionSource2 = interactionSource;
        } else if (($changed & 458752) == 0) {
            interactionSource2 = interactionSource;
            $dirty |= $composer3.changed(interactionSource2) ? 131072 : 65536;
        } else {
            interactionSource2 = interactionSource;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty |= 1572864;
            z3 = isError;
        } else if (($changed & 3670016) == 0) {
            z3 = isError;
            $dirty |= $composer3.changed(z3) ? 1048576 : 524288;
        } else {
            z3 = isError;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
            label = function22;
        } else if (($changed & 29360128) == 0) {
            label = function22;
            $dirty |= $composer3.changedInstance(label) ? 8388608 : 4194304;
        } else {
            label = function22;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty |= 100663296;
            i2 = i7;
        } else if (($changed & 234881024) == 0) {
            i2 = i7;
            $dirty |= $composer3.changedInstance(function23) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i2 = i7;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty |= 805306368;
            i3 = i8;
        } else if (($changed & 1879048192) == 0) {
            i3 = i8;
            $dirty |= $composer3.changedInstance(function24) ? 536870912 : 268435456;
        } else {
            i3 = i8;
        }
        int i9 = i & 1024;
        if (i9 != 0) {
            $dirty1 |= 6;
            i4 = i9;
        } else if (($changed1 & 14) == 0) {
            i4 = i9;
            $dirty1 |= $composer3.changedInstance(function25) ? 4 : 2;
        } else {
            i4 = i9;
        }
        if (($changed1 & 112) == 0) {
            $dirty1 |= ((i & 2048) == 0 && $composer3.changed(colors)) ? 32 : 16;
        }
        if (($changed1 & 896) == 0) {
            $dirty1 |= ((i & 4096) == 0 && $composer3.changed(contentPadding)) ? 256 : 128;
        }
        if ((i & 8192) != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty1 |= $composer3.changed(this) ? 2048 : 1024;
        }
        if (($dirty & 1533916891) == 306783378 && ($dirty1 & 5851) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            placeholder2 = function23;
            trailingIcon2 = function25;
            colors4 = colors;
            $composer2 = $composer3;
            isError3 = z3;
            label3 = label;
            leadingIcon2 = function24;
            contentPadding3 = contentPadding;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                boolean isError4 = i5 != 0 ? false : z3;
                if (i6 != 0) {
                    label = null;
                }
                Function2 placeholder3 = i2 != 0 ? null : function23;
                Function2 leadingIcon3 = i3 != 0 ? null : function24;
                Function2 trailingIcon3 = i4 != 0 ? null : function25;
                boolean isError5 = isError4;
                if ((i & 2048) != 0) {
                    $composer2 = $composer3;
                    colors2 = m1714textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 0, ($dirty1 >> 6) & 112, 2097151);
                    $dirty1 &= -113;
                } else {
                    $composer2 = $composer3;
                    colors2 = colors;
                }
                if ((i & 4096) != 0) {
                    $dirty1 &= -897;
                    isError2 = isError5;
                    colors3 = colors2;
                    placeholder = placeholder3;
                    contentPadding2 = label == null ? m1705textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : m1704textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    label2 = label;
                } else {
                    isError2 = isError5;
                    contentPadding2 = contentPadding;
                    colors3 = colors2;
                    placeholder = placeholder3;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    label2 = label;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 2048) != 0) {
                    $dirty1 &= -113;
                }
                if ((i & 4096) != 0) {
                    placeholder = function23;
                    leadingIcon = function24;
                    trailingIcon = function25;
                    colors3 = colors;
                    contentPadding2 = contentPadding;
                    $dirty1 &= -897;
                    $composer2 = $composer3;
                    isError2 = z3;
                    label2 = label;
                } else {
                    placeholder = function23;
                    leadingIcon = function24;
                    trailingIcon = function25;
                    colors3 = colors;
                    contentPadding2 = contentPadding;
                    $composer2 = $composer3;
                    isError2 = z3;
                    label2 = label;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1171040065, $dirty, $dirty1, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:579)");
            }
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function26, visualTransformation2, label2, placeholder, leadingIcon, trailingIcon, z2, z, isError2, interactionSource2, contentPadding2, colors3, null, $composer2, (($dirty << 3) & 112) | 6 | (($dirty << 3) & 896) | (($dirty >> 3) & 7168) | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752) | (3670016 & ($dirty >> 9)) | (($dirty1 << 21) & 29360128) | (($dirty << 15) & 234881024) | (($dirty << 21) & 1879048192), (($dirty >> 18) & 14) | (($dirty >> 12) & 112) | ($dirty1 & 896) | (($dirty1 << 6) & 7168), 16384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            label3 = label2;
            placeholder2 = placeholder;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            isError3 = isError2;
            contentPadding3 = contentPadding2;
            colors4 = colors3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox.1
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
                    TextFieldDefaults.this.TextFieldDecorationBox(value, function2, enabled, singleLine, visualTransformation, interactionSource, isError3, label3, placeholder2, leadingIcon2, trailingIcon2, colors4, contentPadding3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void OutlinedTextFieldDecorationBox(final java.lang.String r63, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r64, final boolean r65, final boolean r66, final androidx.compose.p000ui.text.input.VisualTransformation r67, final androidx.compose.foundation.interaction.InteractionSource r68, boolean r69, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r70, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r71, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r72, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, androidx.compose.material.TextFieldColors r74, androidx.compose.foundation.layout.PaddingValues r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, androidx.compose.runtime.Composer r77, final int r78, final int r79, final int r80) {
        /*
            Method dump skipped, instructions count: 1030
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
