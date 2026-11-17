package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.layout.IntrinsicMeasurable;
import androidx.compose.p000ui.layout.LayoutIdParentData;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.input.TransformedText;
import androidx.compose.p000ui.text.input.VisualTransformation;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.p000ui.unit.ConstraintsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;

/* compiled from: TextFieldImpl.kt */
@Metadata(m164d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aß\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&2\u0006\u0010'\u001a\u00020(2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&H\u0001¢\u0006\u0002\u00108\u001aT\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2 \u0010@\u001a\u001c\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u0012\u0010E\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u0012\u0010H\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u001c\u0010I\u001a\u00020\b*\u00020\b2\u0006\u00100\u001a\u00020.2\u0006\u0010J\u001a\u00020\fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0012\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0013\u0010\u0005\"\u000e\u0010\u0014\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006K"}, m165d2 = {"AnimationDuration", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material/TextFieldColors;", OutlinedTextFieldKt.BorderId, "(Landroidx/compose/material/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Landroidx/compose/runtime/ComposableOpenTarget;", "index", "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "defaultErrorSemantics", "defaultErrorMessage", "material_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String TextFieldId = "TextField";
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = C1956Dp.m6297constructorimpl(16);
    private static final float HorizontalIconPadding = C1956Dp.m6297constructorimpl(12);
    private static final Modifier IconDefaultSizeModifier = SizeKt.m800defaultMinSizeVpY3zN4(Modifier.INSTANCE, C1956Dp.m6297constructorimpl(48), C1956Dp.m6297constructorimpl(48));

    public static final void CommonDecorationBox(final TextFieldType type, final String value, final Function2<? super Composer, ? super Integer, Unit> function2, final VisualTransformation visualTransformation, final Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, boolean singleLine, boolean enabled, boolean isError, final InteractionSource interactionSource, final PaddingValues contentPadding, final TextFieldColors colors, Function2<? super Composer, ? super Integer, Unit> function26, Composer $composer, final int $changed, final int $changed1, final int i) {
        final TextFieldType textFieldType;
        Function2 function27;
        Function2 placeholder;
        Function2 function28;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Function2 leadingIcon;
        Function2 trailingIcon;
        Object value$iv$iv;
        InputPhase inputPhase;
        TextFieldTransitionScope textFieldTransitionScope;
        InputPhase inputState;
        Function3 labelColor;
        long $this$takeOrElse_u2dDxMtmZc$iv;
        Composer $composer2;
        final boolean enabled2;
        final boolean isError2;
        final Function2 placeholder2;
        final Function2 leadingIcon2;
        final Function2 trailingIcon2;
        final boolean singleLine2;
        final Function2 border;
        Composer $composer3 = $composer.startRestartGroup(-712568069);
        ComposerKt.sourceInformation($composer3, "C(CommonDecorationBox)P(12,13,4,14,7,9,8,11,10,3,6,5,2,1)79@3096L105,83@3251L25,100@3861L10,107@4196L4572:TextFieldImpl.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
            textFieldType = type;
        } else if (($changed & 14) == 0) {
            textFieldType = type;
            $dirty |= $composer3.changed(textFieldType) ? 4 : 2;
        } else {
            textFieldType = type;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(value) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
            function27 = function2;
        } else if (($changed & 896) == 0) {
            function27 = function2;
            $dirty |= $composer3.changedInstance(function27) ? 256 : 128;
        } else {
            function27 = function2;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(visualTransformation) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 16384 : 8192;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            placeholder = function23;
        } else if (($changed & 458752) == 0) {
            placeholder = function23;
            $dirty |= $composer3.changedInstance(placeholder) ? 131072 : 65536;
        } else {
            placeholder = function23;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
            function28 = function24;
        } else if (($changed & 3670016) == 0) {
            function28 = function24;
            $dirty |= $composer3.changedInstance(function28) ? 1048576 : 524288;
        } else {
            function28 = function24;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
            i2 = i9;
        } else if (($changed & 29360128) == 0) {
            i2 = i9;
            $dirty |= $composer3.changedInstance(function25) ? 8388608 : 4194304;
        } else {
            i2 = i9;
        }
        int i10 = i & 256;
        if (i10 != 0) {
            $dirty |= 100663296;
            i3 = i10;
        } else if (($changed & 234881024) == 0) {
            i3 = i10;
            $dirty |= $composer3.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i10;
        }
        int i11 = i & 512;
        if (i11 != 0) {
            $dirty |= 805306368;
            i4 = i11;
        } else if (($changed & 1879048192) == 0) {
            i4 = i11;
            $dirty |= $composer3.changed(enabled) ? 536870912 : 268435456;
        } else {
            i4 = i11;
        }
        int i12 = i & 1024;
        if (i12 != 0) {
            $dirty1 |= 6;
            i5 = i12;
        } else if (($changed1 & 14) == 0) {
            i5 = i12;
            $dirty1 |= $composer3.changed(isError) ? 4 : 2;
        } else {
            i5 = i12;
        }
        if ((i & 2048) != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changed(interactionSource) ? 32 : 16;
        }
        if ((i & 4096) != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changed(contentPadding) ? 256 : 128;
        }
        if ((i & 8192) != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty1 |= $composer3.changed(colors) ? 2048 : 1024;
        }
        int i13 = i & 16384;
        if (i13 != 0) {
            $dirty1 |= 24576;
            i6 = i13;
        } else if (($changed1 & 57344) == 0) {
            i6 = i13;
            $dirty1 |= $composer3.changedInstance(function26) ? 16384 : 8192;
        } else {
            i6 = i13;
        }
        if (($dirty & 1533916891) == 306783378 && (46811 & $dirty1) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled2 = enabled;
            isError2 = isError;
            border = function26;
            $composer2 = $composer3;
            trailingIcon2 = function25;
            singleLine2 = singleLine;
            leadingIcon2 = function28;
            placeholder2 = placeholder;
        } else {
            if (i7 != 0) {
                placeholder = null;
            }
            Function2 leadingIcon3 = i8 != 0 ? null : function28;
            Function2 trailingIcon3 = i2 != 0 ? null : function25;
            final boolean singleLine3 = i3 != 0 ? false : singleLine;
            final boolean enabled3 = i4 != 0 ? true : enabled;
            final boolean isError3 = i5 != 0 ? false : isError;
            final Function2 border2 = i6 != 0 ? null : function26;
            if (ComposerKt.isTraceInProgress()) {
                leadingIcon = leadingIcon3;
                trailingIcon = trailingIcon3;
                ComposerKt.traceEventStart(-712568069, $dirty, $dirty1, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:78)");
            } else {
                leadingIcon = leadingIcon3;
                trailingIcon = trailingIcon3;
            }
            int i14 = (($dirty >> 3) & 14) | (($dirty >> 6) & 112);
            $composer3.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer3.changed(value) | $composer3.changed(visualTransformation);
            Object it$iv$iv = $composer3.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = visualTransformation.filter(new AnnotatedString(value, null, null, 6, null));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer3.endReplaceableGroup();
            final String transformedText = ((TransformedText) value$iv$iv).getText().getText();
            boolean isFocused = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer3, ($dirty1 >> 3) & 14).getValue().booleanValue();
            if (isFocused) {
                inputPhase = InputPhase.Focused;
            } else {
                inputPhase = transformedText.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            InputPhase inputState2 = inputPhase;
            Function3 labelColor2 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer, Integer num) {
                    return Color.m3939boximpl(m1722invokeXeAY9LY(inputPhase2, composer, num.intValue()));
                }

                /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                public final long m1722invokeXeAY9LY(InputPhase it, Composer $composer4, int $changed2) {
                    $composer4.startReplaceableGroup(697243846);
                    ComposerKt.sourceInformation($composer4, "C91@3539L273:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(697243846, $changed2, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                    }
                    long jM3959unboximpl = colors.labelColor(enabled3, it == InputPhase.UnfocusedEmpty ? false : isError3, interactionSource, $composer4, 0).getValue().m3959unboximpl();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer4.endReplaceableGroup();
                    return jM3959unboximpl;
                }
            };
            Typography typography = MaterialTheme.INSTANCE.getTypography($composer3, 6);
            TextStyle subtitle1 = typography.getSubtitle1();
            TextStyle caption = typography.getCaption();
            final boolean shouldOverrideTextStyleColor = (Color.m3950equalsimpl0(subtitle1.m5804getColor0d7_KjU(), Color.INSTANCE.m3985getUnspecified0d7_KjU()) && !Color.m3950equalsimpl0(caption.m5804getColor0d7_KjU(), Color.INSTANCE.m3985getUnspecified0d7_KjU())) || (!Color.m3950equalsimpl0(subtitle1.m5804getColor0d7_KjU(), Color.INSTANCE.m3985getUnspecified0d7_KjU()) && Color.m3950equalsimpl0(caption.m5804getColor0d7_KjU(), Color.INSTANCE.m3985getUnspecified0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope2 = TextFieldTransitionScope.INSTANCE;
            $composer3.startReplaceableGroup(2129140935);
            ComposerKt.sourceInformation($composer3, "*109@4292L10,110@4384L22");
            long $this$CommonDecorationBox_u24lambda_u242 = MaterialTheme.INSTANCE.getTypography($composer3, 6).getCaption().m5804getColor0d7_KjU();
            if (shouldOverrideTextStyleColor) {
                $this$takeOrElse_u2dDxMtmZc$iv = $this$CommonDecorationBox_u24lambda_u242;
                if ($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m3985getUnspecified0d7_KjU()) {
                    textFieldTransitionScope = textFieldTransitionScope2;
                    inputState = inputState2;
                    labelColor = labelColor2;
                } else {
                    textFieldTransitionScope = textFieldTransitionScope2;
                    inputState = inputState2;
                    labelColor = labelColor2;
                    $this$takeOrElse_u2dDxMtmZc$iv = labelColor.invoke(inputState, $composer3, 0).m3959unboximpl();
                }
            } else {
                textFieldTransitionScope = textFieldTransitionScope2;
                inputState = inputState2;
                labelColor = labelColor2;
                $this$takeOrElse_u2dDxMtmZc$iv = $this$CommonDecorationBox_u24lambda_u242;
            }
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(2129141126);
            ComposerKt.sourceInformation($composer3, "*112@4483L10,113@4577L22");
            long $this$CommonDecorationBox_u24lambda_u244 = MaterialTheme.INSTANCE.getTypography($composer3, 6).getSubtitle1().m5804getColor0d7_KjU();
            if (shouldOverrideTextStyleColor) {
                long $this$takeOrElse_u2dDxMtmZc$iv2 = $this$CommonDecorationBox_u24lambda_u244;
                if (($this$takeOrElse_u2dDxMtmZc$iv2 != Color.INSTANCE.m3985getUnspecified0d7_KjU() ? 1 : 0) == 0) {
                    $this$takeOrElse_u2dDxMtmZc$iv2 = labelColor.invoke(inputState, $composer3, 0).m3959unboximpl();
                }
                $this$CommonDecorationBox_u24lambda_u244 = $this$takeOrElse_u2dDxMtmZc$iv2;
            }
            $composer3.endReplaceableGroup();
            final Function2 placeholder3 = placeholder;
            final Function2 trailingIcon4 = trailingIcon;
            final Function2 placeholder4 = leadingIcon;
            final Function2 trailingIcon5 = function27;
            final boolean enabled4 = enabled3;
            boolean isError4 = isError3;
            boolean singleLine4 = singleLine3;
            Function2 border3 = border2;
            textFieldTransitionScope.m1727TransitionDTcfvLk(inputState, $this$takeOrElse_u2dDxMtmZc$iv, $this$CommonDecorationBox_u24lambda_u244, labelColor, function22 != null, ComposableLambdaKt.composableLambda($composer3, 341865432, true, new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt.CommonDecorationBox.3

                /* compiled from: TextFieldImpl.kt */
                @Metadata(m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                /* renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[TextFieldType.values().length];
                        try {
                            iArr[TextFieldType.Filled.ordinal()] = 1;
                        } catch (NoSuchFieldError e) {
                        }
                        try {
                            iArr[TextFieldType.Outlined.ordinal()] = 2;
                        } catch (NoSuchFieldError e2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(6);
                }

                @Override // kotlin.jvm.functions.Function6
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Composer composer, Integer num) {
                    m1720invokeRIQooxk(f.floatValue(), color.m3959unboximpl(), color2.m3959unboximpl(), f2.floatValue(), composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:55:0x00d6  */
                /* renamed from: invoke-RIQooxk, reason: not valid java name */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void m1720invokeRIQooxk(float r33, long r34, final long r36, final float r38, androidx.compose.runtime.Composer r39, int r40) {
                    /*
                        Method dump skipped, instructions count: 646
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt.C11393.m1720invokeRIQooxk(float, long, long, float, androidx.compose.runtime.Composer, int):void");
                }
            }), $composer3, 1769472);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            enabled2 = enabled4;
            isError2 = isError4;
            placeholder2 = placeholder3;
            leadingIcon2 = placeholder4;
            trailingIcon2 = trailingIcon4;
            singleLine2 = singleLine4;
            border = border3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt.CommonDecorationBox.4
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
                    TextFieldImplKt.CommonDecorationBox(type, value, function2, visualTransformation, function22, placeholder2, leadingIcon2, trailingIcon2, singleLine2, enabled2, isError2, interactionSource, contentPadding, colors, border, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* renamed from: Decoration-euL9pac, reason: not valid java name */
    public static final void m1719DecorationeuL9pac(final long contentColor, TextStyle typography, Float contentAlpha, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        final Float contentAlpha2;
        final Float contentAlpha3;
        final TextStyle typography2;
        Composer $composer2 = $composer.startRestartGroup(-399493340);
        ComposerKt.sourceInformation($composer2, "C(Decoration)P(2:c#ui.graphics.Color,3,1):TextFieldImpl.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(typography) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(contentAlpha) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                typography = null;
            }
            if (i3 == 0) {
                contentAlpha2 = contentAlpha;
            } else {
                contentAlpha2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-399493340, $dirty2, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:223)");
            }
            Function2 colorAndEmphasis = ComposableLambdaKt.composableLambda($composer2, 494684590, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
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

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C225@9160L476:TextFieldImpl.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(494684590, $changed2, -1, "androidx.compose.material.Decoration.<anonymous> (TextFieldImpl.kt:225)");
                        }
                        ProvidedValue<Color> providedValueProvides = ContentColorKt.getLocalContentColor().provides(Color.m3939boximpl(contentColor));
                        final Float f = contentAlpha2;
                        final Function2<Composer, Integer, Unit> function22 = function2;
                        final long j = contentColor;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.composableLambda($composer3, -1132188434, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1.1
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
                                ComposerKt.sourceInformation($composer4, "C:TextFieldImpl.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1132188434, $changed3, -1, "androidx.compose.material.Decoration.<anonymous>.<anonymous> (TextFieldImpl.kt:226)");
                                    }
                                    if (f != null) {
                                        $composer4.startReplaceableGroup(-452622690);
                                        ComposerKt.sourceInformation($composer4, "227@9284L142");
                                        CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(f), function22, $composer4, ProvidedValue.$stable | 0);
                                        $composer4.endReplaceableGroup();
                                    } else {
                                        $composer4.startReplaceableGroup(-452622510);
                                        ComposerKt.sourceInformation($composer4, "232@9464L148");
                                        CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3951getAlphaimpl(j))), function22, $composer4, ProvidedValue.$stable | 0);
                                        $composer4.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }), $composer3, ProvidedValue.$stable | 0 | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            });
            if (typography != null) {
                $composer2.startReplaceableGroup(-2009953423);
                ComposerKt.sourceInformation($composer2, "239@9671L46");
                TextKt.ProvideTextStyle(typography, colorAndEmphasis, $composer2, (($dirty2 >> 3) & 14) | 48);
            } else {
                $composer2.startReplaceableGroup(-2009953371);
                ComposerKt.sourceInformation($composer2, "239@9723L18");
                colorAndEmphasis.invoke($composer2, 6);
            }
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentAlpha3 = contentAlpha2;
            typography2 = typography;
        } else {
            $composer2.skipToGroupEnd();
            contentAlpha3 = contentAlpha;
            typography2 = typography;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$1
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

                public final void invoke(Composer composer, int i4) {
                    TextFieldImplKt.m1719DecorationeuL9pac(contentColor, typography2, contentAlpha3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final Modifier defaultErrorSemantics(Modifier $this$defaultErrorSemantics, boolean isError, final String defaultErrorMessage) {
        return isError ? SemanticsModifierKt.semantics$default($this$defaultErrorSemantics, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.TextFieldImplKt.defaultErrorSemantics.1
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
                SemanticsPropertiesKt.error($this$semantics, defaultErrorMessage);
            }
        }, 1, null) : $this$defaultErrorSemantics;
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable $this$layoutId) {
        Object parentData = $this$layoutId.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
