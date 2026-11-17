package androidx.compose.material;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.font.FontStyle;
import androidx.compose.p000ui.text.font.FontWeight;
import androidx.compose.p000ui.text.style.TextAlign;
import androidx.compose.p000ui.text.style.TextDecoration;
import androidx.compose.p000ui.text.style.TextOverflow;
import androidx.compose.p000ui.unit.TextUnit;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: Text.kt */
@Metadata(m164d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aæ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aÜ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aÆ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aÒ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00106\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, m165d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material.TextKt$LocalTextStyle$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextStyle invoke() {
            return TypographyKt.getDefaultTextStyle();
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:282:0x053f  */
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1729Text4IGK_g(final java.lang.String r66, androidx.compose.p000ui.Modifier r67, long r68, long r70, androidx.compose.p000ui.text.font.FontStyle r72, androidx.compose.p000ui.text.font.FontWeight r73, androidx.compose.p000ui.text.font.FontFamily r74, long r75, androidx.compose.p000ui.text.style.TextDecoration r77, androidx.compose.p000ui.text.style.TextAlign r78, long r79, int r81, boolean r82, int r83, int r84, kotlin.jvm.functions.Function1<? super androidx.compose.p000ui.text.TextLayoutResult, kotlin.Unit> r85, androidx.compose.p000ui.text.TextStyle r86, androidx.compose.runtime.Composer r87, final int r88, final int r89, final int r90) {
        /*
            Method dump skipped, instructions count: 1413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m1729Text4IGK_g(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text-fLXpl1I, reason: not valid java name */
    public static final /* synthetic */ void m1731TextfLXpl1I(final String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Function1 onTextLayout, TextStyle style, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        int i2;
        long color2;
        long fontSize2;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        int $dirty;
        int $dirty1;
        int i3;
        int i4;
        int $dirty12;
        int i5;
        boolean softWrap2;
        int $dirty13;
        int $dirty14;
        TextStyle style2;
        int maxLines2;
        Modifier modifier3;
        TextAlign textAlign2;
        long letterSpacing2;
        int $dirty15;
        int $dirty16;
        long letterSpacing3;
        Function1 onTextLayout2;
        boolean softWrap3;
        long color3;
        FontStyle fontStyle3;
        long fontSize3;
        FontWeight fontWeight3;
        FontFamily fontFamily2;
        TextDecoration textDecoration2;
        Composer $composer2;
        final Modifier modifier4;
        final long color4;
        final long fontSize4;
        final FontStyle fontStyle4;
        final FontWeight fontWeight4;
        final FontFamily fontFamily3;
        final long letterSpacing4;
        final TextDecoration textDecoration3;
        final TextAlign textAlign3;
        final long lineHeight2;
        final int overflow2;
        final boolean softWrap4;
        final int maxLines3;
        final Function1 onTextLayout3;
        final TextStyle style3;
        Composer $composer3 = $composer.startRestartGroup(-366126944);
        ComposerKt.sourceInformation($composer3, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)181@8616L7,183@8632L322:Text.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(text) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty2 |= 384;
            i2 = i6;
            color2 = color;
        } else if (($changed & 896) == 0) {
            i2 = i6;
            color2 = color;
            $dirty2 |= $composer3.changed(color2) ? 256 : 128;
        } else {
            i2 = i6;
            color2 = color;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty2 |= 3072;
            fontSize2 = fontSize;
        } else if (($changed & 7168) == 0) {
            fontSize2 = fontSize;
            $dirty2 |= $composer3.changed(fontSize2) ? 2048 : 1024;
        } else {
            fontSize2 = fontSize;
        }
        int i9 = i & 16;
        if (i9 != 0) {
            $dirty2 |= 24576;
            fontStyle2 = fontStyle;
        } else if (($changed & 57344) == 0) {
            fontStyle2 = fontStyle;
            $dirty2 |= $composer3.changed(fontStyle2) ? 16384 : 8192;
        } else {
            fontStyle2 = fontStyle;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            fontWeight2 = fontWeight;
        } else if (($changed & 458752) == 0) {
            fontWeight2 = fontWeight;
            $dirty2 |= $composer3.changed(fontWeight2) ? 131072 : 65536;
        } else {
            fontWeight2 = fontWeight;
        }
        int i11 = i & 64;
        if (i11 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty2 |= $composer3.changed(fontFamily) ? 1048576 : 524288;
        }
        int $dirty3 = i & 128;
        if ($dirty3 != 0) {
            $dirty = $dirty2 | 12582912;
            $dirty1 = $changed1;
        } else if (($changed & 29360128) == 0) {
            $dirty1 = $changed1;
            $dirty = $dirty2 | ($composer3.changed(letterSpacing) ? 8388608 : 4194304);
        } else {
            $dirty = $dirty2;
            $dirty1 = $changed1;
        }
        int i12 = i & 256;
        if (i12 != 0) {
            $dirty |= 100663296;
            i3 = i12;
        } else if (($changed & 234881024) == 0) {
            i3 = i12;
            $dirty |= $composer3.changed(textDecoration) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i12;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty |= 805306368;
            i4 = i13;
        } else if (($changed & 1879048192) == 0) {
            i4 = i13;
            $dirty |= $composer3.changed(textAlign) ? 536870912 : 268435456;
        } else {
            i4 = i13;
        }
        int $dirty4 = $dirty;
        int i14 = i & 1024;
        if (i14 != 0) {
            $dirty12 = $dirty1 | 6;
        } else if (($changed1 & 14) == 0) {
            $dirty12 = $dirty1 | ($composer3.changed(lineHeight) ? 4 : 2);
        } else {
            $dirty12 = $dirty1;
        }
        int i15 = i & 2048;
        if (i15 != 0) {
            $dirty12 |= 48;
            i5 = i15;
        } else if (($changed1 & 112) == 0) {
            i5 = i15;
            $dirty12 |= $composer3.changed(overflow) ? 32 : 16;
        } else {
            i5 = i15;
        }
        int $dirty17 = $dirty12;
        int i16 = i & 4096;
        if (i16 != 0) {
            $dirty17 |= 384;
            softWrap2 = softWrap;
        } else if (($changed1 & 896) == 0) {
            softWrap2 = softWrap;
            $dirty17 |= $composer3.changed(softWrap2) ? 256 : 128;
        } else {
            softWrap2 = softWrap;
        }
        int i17 = i & 8192;
        if (i17 != 0) {
            $dirty13 = $dirty17 | 3072;
        } else {
            int $dirty18 = $dirty17;
            int $dirty19 = $changed1 & 7168;
            if ($dirty19 == 0) {
                $dirty13 = $dirty18 | ($composer3.changed(maxLines) ? 2048 : 1024);
            } else {
                $dirty13 = $dirty18;
            }
        }
        int i18 = i & 16384;
        if (i18 != 0) {
            $dirty14 = $dirty13 | 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty14 = $dirty13 | ($composer3.changedInstance(onTextLayout) ? 16384 : 8192);
        } else {
            $dirty14 = $dirty13;
        }
        if (($changed1 & 458752) == 0) {
            $dirty14 |= ((i & 32768) == 0 && $composer3.changed(style)) ? 131072 : 65536;
        }
        if (($dirty4 & 1533916891) == 306783378 && ($dirty14 & 374491) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            overflow2 = overflow;
            maxLines3 = maxLines;
            style3 = style;
            $composer2 = $composer3;
            softWrap4 = softWrap2;
            fontStyle4 = fontStyle2;
            color4 = color2;
            fontSize4 = fontSize2;
            modifier4 = modifier2;
            fontWeight4 = fontWeight2;
            fontFamily3 = fontFamily;
            letterSpacing4 = letterSpacing;
            textDecoration3 = textDecoration;
            textAlign3 = textAlign;
            lineHeight2 = lineHeight;
            onTextLayout3 = onTextLayout;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i7 != 0) {
                    color2 = Color.INSTANCE.m3985getUnspecified0d7_KjU();
                }
                if (i8 != 0) {
                    fontSize2 = TextUnit.INSTANCE.m6499getUnspecifiedXSAIIZE();
                }
                if (i9 != 0) {
                    fontStyle2 = null;
                }
                if (i10 != 0) {
                    fontWeight2 = null;
                }
                FontFamily fontFamily4 = i11 != 0 ? null : fontFamily;
                long letterSpacing5 = $dirty3 != 0 ? TextUnit.INSTANCE.m6499getUnspecifiedXSAIIZE() : letterSpacing;
                TextDecoration textDecoration4 = i3 != 0 ? null : textDecoration;
                TextAlign textAlign4 = i4 != 0 ? null : textAlign;
                long lineHeight3 = i14 != 0 ? TextUnit.INSTANCE.m6499getUnspecifiedXSAIIZE() : lineHeight;
                int overflow3 = i5 != 0 ? TextOverflow.INSTANCE.m6216getClipgIe3tQ8() : overflow;
                if (i16 != 0) {
                    softWrap2 = true;
                }
                int maxLines4 = i17 != 0 ? Integer.MAX_VALUE : maxLines;
                TextKt$Text$3 onTextLayout4 = i18 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                    }
                } : onTextLayout;
                if ((i & 32768) != 0) {
                    FontFamily fontFamily5 = fontFamily4;
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                    TextDecoration textDecoration5 = textDecoration4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    style2 = (TextStyle) objConsume;
                    $dirty15 = $dirty14 & (-458753);
                    maxLines2 = maxLines4;
                    modifier3 = modifier2;
                    textAlign2 = textAlign4;
                    letterSpacing2 = letterSpacing5;
                    $dirty16 = overflow3;
                    letterSpacing3 = lineHeight3;
                    onTextLayout2 = onTextLayout4;
                    softWrap3 = softWrap2;
                    color3 = color2;
                    fontStyle3 = fontStyle2;
                    fontSize3 = fontSize2;
                    fontWeight3 = fontWeight2;
                    fontFamily2 = fontFamily5;
                    textDecoration2 = textDecoration5;
                } else {
                    FontFamily fontFamily6 = fontFamily4;
                    style2 = style;
                    maxLines2 = maxLines4;
                    modifier3 = modifier2;
                    textAlign2 = textAlign4;
                    letterSpacing2 = letterSpacing5;
                    $dirty15 = $dirty14;
                    $dirty16 = overflow3;
                    letterSpacing3 = lineHeight3;
                    onTextLayout2 = onTextLayout4;
                    softWrap3 = softWrap2;
                    color3 = color2;
                    fontStyle3 = fontStyle2;
                    fontSize3 = fontSize2;
                    fontWeight3 = fontWeight2;
                    fontFamily2 = fontFamily6;
                    textDecoration2 = textDecoration4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32768) != 0) {
                    $dirty15 = $dirty14 & (-458753);
                    textAlign2 = textAlign;
                    letterSpacing3 = lineHeight;
                    $dirty16 = overflow;
                    maxLines2 = maxLines;
                    onTextLayout2 = onTextLayout;
                    style2 = style;
                    softWrap3 = softWrap2;
                    color3 = color2;
                    modifier3 = modifier2;
                    letterSpacing2 = letterSpacing;
                    fontStyle3 = fontStyle2;
                    fontSize3 = fontSize2;
                    fontWeight3 = fontWeight2;
                    fontFamily2 = fontFamily;
                    textDecoration2 = textDecoration;
                } else {
                    textAlign2 = textAlign;
                    letterSpacing3 = lineHeight;
                    maxLines2 = maxLines;
                    onTextLayout2 = onTextLayout;
                    style2 = style;
                    softWrap3 = softWrap2;
                    color3 = color2;
                    modifier3 = modifier2;
                    $dirty15 = $dirty14;
                    letterSpacing2 = letterSpacing;
                    $dirty16 = overflow;
                    fontStyle3 = fontStyle2;
                    fontSize3 = fontSize2;
                    fontWeight3 = fontWeight2;
                    fontFamily2 = fontFamily;
                    textDecoration2 = textDecoration;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-366126944, $dirty4, $dirty15, "androidx.compose.material.Text (Text.kt:182)");
            }
            $composer2 = $composer3;
            m1729Text4IGK_g(text, modifier3, color3, fontSize3, fontStyle3, fontWeight3, fontFamily2, letterSpacing2, textDecoration2, textAlign2, letterSpacing3, $dirty16, softWrap3, maxLines2, 1, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, style2, $composer2, ($dirty4 & 14) | ($dirty4 & 112) | ($dirty4 & 896) | ($dirty4 & 7168) | ($dirty4 & 57344) | ($dirty4 & 458752) | ($dirty4 & 3670016) | (29360128 & $dirty4) | (234881024 & $dirty4) | (1879048192 & $dirty4), ($dirty15 & 14) | 24576 | ($dirty15 & 112) | ($dirty15 & 896) | ($dirty15 & 7168) | (($dirty15 << 3) & 458752) | (($dirty15 << 3) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color4 = color3;
            fontSize4 = fontSize3;
            fontStyle4 = fontStyle3;
            fontWeight4 = fontWeight3;
            fontFamily3 = fontFamily2;
            letterSpacing4 = letterSpacing2;
            textDecoration3 = textDecoration2;
            textAlign3 = textAlign2;
            lineHeight2 = letterSpacing3;
            overflow2 = $dirty16;
            softWrap4 = softWrap3;
            maxLines3 = maxLines2;
            onTextLayout3 = onTextLayout2;
            style3 = style2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
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

                public final void invoke(Composer composer, int i19) {
                    TextKt.m1731TextfLXpl1I(text, modifier4, color4, fontSize4, fontStyle4, fontWeight4, fontFamily3, letterSpacing4, textDecoration3, textAlign3, lineHeight2, overflow2, softWrap4, maxLines3, onTextLayout3, style3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:291:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x05ab  */
    /* renamed from: Text-IbK3jfQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1730TextIbK3jfQ(final androidx.compose.p000ui.text.AnnotatedString r68, androidx.compose.p000ui.Modifier r69, long r70, long r72, androidx.compose.p000ui.text.font.FontStyle r74, androidx.compose.p000ui.text.font.FontWeight r75, androidx.compose.p000ui.text.font.FontFamily r76, long r77, androidx.compose.p000ui.text.style.TextDecoration r79, androidx.compose.p000ui.text.style.TextAlign r80, long r81, int r83, boolean r84, int r85, int r86, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r87, kotlin.jvm.functions.Function1<? super androidx.compose.p000ui.text.TextLayoutResult, kotlin.Unit> r88, androidx.compose.p000ui.text.TextStyle r89, androidx.compose.runtime.Composer r90, final int r91, final int r92, final int r93) {
        /*
            Method dump skipped, instructions count: 1454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m1730TextIbK3jfQ(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    public static final /* synthetic */ void m1728Text4IGK_g(final AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Map inlineContent, Function1 onTextLayout, TextStyle style, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        int i2;
        long color2;
        long fontSize2;
        FontStyle fontStyle2;
        FontFamily fontFamily2;
        int $dirty;
        int $dirty1;
        int i3;
        int i4;
        int $dirty12;
        int i5;
        boolean softWrap2;
        int $dirty13;
        int $dirty14;
        TextStyle style2;
        Function1 onTextLayout2;
        int $dirty15;
        int overflow2;
        Map inlineContent2;
        boolean softWrap3;
        long color3;
        TextAlign textAlign2;
        FontStyle fontStyle3;
        TextDecoration textDecoration2;
        FontWeight fontWeight2;
        FontFamily fontFamily3;
        long fontSize3;
        int maxLines2;
        Modifier modifier3;
        long letterSpacing2;
        long letterSpacing3;
        Composer $composer2;
        final Modifier modifier4;
        final long color4;
        final long fontSize4;
        final FontStyle fontStyle4;
        final FontWeight fontWeight3;
        final FontFamily fontFamily4;
        final long letterSpacing4;
        final TextDecoration textDecoration3;
        final TextAlign textAlign3;
        final long lineHeight2;
        final int overflow3;
        final boolean softWrap4;
        final int maxLines3;
        final Map inlineContent3;
        final Function1 onTextLayout3;
        final TextStyle style3;
        Composer $composer3 = $composer.startRestartGroup(-422393234);
        ComposerKt.sourceInformation($composer3, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)351@16320L7,353@16336L345:Text.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(text) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty2 |= 384;
            i2 = i6;
            color2 = color;
        } else if (($changed & 896) == 0) {
            i2 = i6;
            color2 = color;
            $dirty2 |= $composer3.changed(color2) ? 256 : 128;
        } else {
            i2 = i6;
            color2 = color;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty2 |= 3072;
            fontSize2 = fontSize;
        } else if (($changed & 7168) == 0) {
            fontSize2 = fontSize;
            $dirty2 |= $composer3.changed(fontSize2) ? 2048 : 1024;
        } else {
            fontSize2 = fontSize;
        }
        int i9 = i & 16;
        if (i9 != 0) {
            $dirty2 |= 24576;
            fontStyle2 = fontStyle;
        } else if (($changed & 57344) == 0) {
            fontStyle2 = fontStyle;
            $dirty2 |= $composer3.changed(fontStyle2) ? 16384 : 8192;
        } else {
            fontStyle2 = fontStyle;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed & 458752) == 0) {
            $dirty2 |= $composer3.changed(fontWeight) ? 131072 : 65536;
        }
        int i11 = i & 64;
        if (i11 != 0) {
            $dirty2 |= 1572864;
            fontFamily2 = fontFamily;
        } else if (($changed & 3670016) == 0) {
            fontFamily2 = fontFamily;
            $dirty2 |= $composer3.changed(fontFamily2) ? 1048576 : 524288;
        } else {
            fontFamily2 = fontFamily;
        }
        int $dirty3 = i & 128;
        if ($dirty3 != 0) {
            $dirty = $dirty2 | 12582912;
            $dirty1 = $changed1;
        } else if (($changed & 29360128) == 0) {
            $dirty1 = $changed1;
            $dirty = $dirty2 | ($composer3.changed(letterSpacing) ? 8388608 : 4194304);
        } else {
            $dirty = $dirty2;
            $dirty1 = $changed1;
        }
        int i12 = i & 256;
        if (i12 != 0) {
            $dirty |= 100663296;
            i3 = i12;
        } else if (($changed & 234881024) == 0) {
            i3 = i12;
            $dirty |= $composer3.changed(textDecoration) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i12;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty |= 805306368;
            i4 = i13;
        } else if (($changed & 1879048192) == 0) {
            i4 = i13;
            $dirty |= $composer3.changed(textAlign) ? 536870912 : 268435456;
        } else {
            i4 = i13;
        }
        int $dirty4 = $dirty;
        int i14 = i & 1024;
        if (i14 != 0) {
            $dirty12 = $dirty1 | 6;
        } else if (($changed1 & 14) == 0) {
            $dirty12 = $dirty1 | ($composer3.changed(lineHeight) ? 4 : 2);
        } else {
            $dirty12 = $dirty1;
        }
        int i15 = i & 2048;
        if (i15 != 0) {
            $dirty12 |= 48;
            i5 = i15;
        } else if (($changed1 & 112) == 0) {
            i5 = i15;
            $dirty12 |= $composer3.changed(overflow) ? 32 : 16;
        } else {
            i5 = i15;
        }
        int $dirty16 = $dirty12;
        int i16 = i & 4096;
        if (i16 != 0) {
            $dirty16 |= 384;
            softWrap2 = softWrap;
        } else if (($changed1 & 896) == 0) {
            softWrap2 = softWrap;
            $dirty16 |= $composer3.changed(softWrap2) ? 256 : 128;
        } else {
            softWrap2 = softWrap;
        }
        int i17 = i & 8192;
        if (i17 != 0) {
            $dirty13 = $dirty16 | 3072;
        } else {
            int $dirty17 = $dirty16;
            int $dirty18 = $changed1 & 7168;
            if ($dirty18 == 0) {
                $dirty13 = $dirty17 | ($composer3.changed(maxLines) ? 2048 : 1024);
            } else {
                $dirty13 = $dirty17;
            }
        }
        int i18 = i & 16384;
        if (i18 != 0) {
            $dirty13 |= 8192;
        }
        int i19 = i & 32768;
        if (i19 != 0) {
            $dirty14 = $dirty13 | ProfileVerifier.CompilationStatus.f249xf2722a21;
        } else if (($changed1 & 458752) == 0) {
            $dirty14 = $dirty13 | ($composer3.changedInstance(onTextLayout) ? 131072 : 65536);
        } else {
            $dirty14 = $dirty13;
        }
        if (($changed1 & 3670016) == 0) {
            $dirty14 |= ((i & 65536) == 0 && $composer3.changed(style)) ? 1048576 : 524288;
        }
        if (i18 == 16384 && (1533916891 & $dirty4) == 306783378 && ($dirty14 & 2995931) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            overflow3 = overflow;
            maxLines3 = maxLines;
            inlineContent3 = inlineContent;
            style3 = style;
            $composer2 = $composer3;
            softWrap4 = softWrap2;
            color4 = color2;
            fontSize4 = fontSize2;
            modifier4 = modifier2;
            fontStyle4 = fontStyle2;
            letterSpacing4 = letterSpacing;
            textDecoration3 = textDecoration;
            textAlign3 = textAlign;
            lineHeight2 = lineHeight;
            onTextLayout3 = onTextLayout;
            fontFamily4 = fontFamily2;
            fontWeight3 = fontWeight;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i7 != 0) {
                    color2 = Color.INSTANCE.m3985getUnspecified0d7_KjU();
                }
                if (i8 != 0) {
                    fontSize2 = TextUnit.INSTANCE.m6499getUnspecifiedXSAIIZE();
                }
                if (i9 != 0) {
                    fontStyle2 = null;
                }
                FontWeight fontWeight4 = i10 != 0 ? null : fontWeight;
                if (i11 != 0) {
                    fontFamily2 = null;
                }
                long letterSpacing5 = $dirty3 != 0 ? TextUnit.INSTANCE.m6499getUnspecifiedXSAIIZE() : letterSpacing;
                TextDecoration textDecoration4 = i3 != 0 ? null : textDecoration;
                TextAlign textAlign4 = i4 != 0 ? null : textAlign;
                long lineHeight3 = i14 != 0 ? TextUnit.INSTANCE.m6499getUnspecifiedXSAIIZE() : lineHeight;
                int overflow4 = i5 != 0 ? TextOverflow.INSTANCE.m6216getClipgIe3tQ8() : overflow;
                if (i16 != 0) {
                    softWrap2 = true;
                }
                int maxLines4 = i17 != 0 ? Integer.MAX_VALUE : maxLines;
                Map inlineContent4 = i18 != 0 ? MapsKt.emptyMap() : inlineContent;
                TextKt$Text$8 onTextLayout4 = i19 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$8
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                    }
                } : onTextLayout;
                if ((i & 65536) != 0) {
                    FontWeight fontWeight5 = fontWeight4;
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                    TextDecoration textDecoration5 = textDecoration4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    style2 = (TextStyle) objConsume;
                    $dirty15 = $dirty14 & (-3670017);
                    softWrap3 = softWrap2;
                    color3 = color2;
                    fontStyle3 = fontStyle2;
                    onTextLayout2 = onTextLayout4;
                    overflow2 = overflow4;
                    textDecoration2 = textDecoration5;
                    inlineContent2 = inlineContent4;
                    textAlign2 = textAlign4;
                    long j = fontSize2;
                    fontWeight2 = fontWeight5;
                    fontFamily3 = fontFamily2;
                    fontSize3 = j;
                    long j2 = lineHeight3;
                    maxLines2 = maxLines4;
                    modifier3 = modifier2;
                    letterSpacing2 = letterSpacing5;
                    letterSpacing3 = j2;
                } else {
                    FontWeight fontWeight6 = fontWeight4;
                    style2 = style;
                    onTextLayout2 = onTextLayout4;
                    $dirty15 = $dirty14;
                    overflow2 = overflow4;
                    inlineContent2 = inlineContent4;
                    softWrap3 = softWrap2;
                    color3 = color2;
                    textAlign2 = textAlign4;
                    fontStyle3 = fontStyle2;
                    textDecoration2 = textDecoration4;
                    long j3 = fontSize2;
                    fontWeight2 = fontWeight6;
                    fontFamily3 = fontFamily2;
                    fontSize3 = j3;
                    long j4 = lineHeight3;
                    maxLines2 = maxLines4;
                    modifier3 = modifier2;
                    letterSpacing2 = letterSpacing5;
                    letterSpacing3 = j4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 65536) != 0) {
                    $dirty15 = $dirty14 & (-3670017);
                    textAlign2 = textAlign;
                    letterSpacing3 = lineHeight;
                    overflow2 = overflow;
                    maxLines2 = maxLines;
                    inlineContent2 = inlineContent;
                    onTextLayout2 = onTextLayout;
                    style2 = style;
                    softWrap3 = softWrap2;
                    color3 = color2;
                    modifier3 = modifier2;
                    fontStyle3 = fontStyle2;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    long j5 = fontSize2;
                    fontWeight2 = fontWeight;
                    fontFamily3 = fontFamily2;
                    fontSize3 = j5;
                } else {
                    textAlign2 = textAlign;
                    letterSpacing3 = lineHeight;
                    overflow2 = overflow;
                    maxLines2 = maxLines;
                    inlineContent2 = inlineContent;
                    onTextLayout2 = onTextLayout;
                    style2 = style;
                    modifier3 = modifier2;
                    $dirty15 = $dirty14;
                    letterSpacing2 = letterSpacing;
                    softWrap3 = softWrap2;
                    color3 = color2;
                    fontStyle3 = fontStyle2;
                    textDecoration2 = textDecoration;
                    long j6 = fontSize2;
                    fontWeight2 = fontWeight;
                    fontFamily3 = fontFamily2;
                    fontSize3 = j6;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-422393234, $dirty4, $dirty15, "androidx.compose.material.Text (Text.kt:352)");
            }
            $composer2 = $composer3;
            m1730TextIbK3jfQ(text, modifier3, color3, fontSize3, fontStyle3, fontWeight2, fontFamily3, letterSpacing2, textDecoration2, textAlign2, letterSpacing3, overflow2, softWrap3, maxLines2, 1, inlineContent2, onTextLayout2, style2, $composer2, ($dirty4 & 14) | ($dirty4 & 112) | ($dirty4 & 896) | ($dirty4 & 7168) | (57344 & $dirty4) | ($dirty4 & 458752) | ($dirty4 & 3670016) | ($dirty4 & 29360128) | (234881024 & $dirty4) | (1879048192 & $dirty4), 286720 | ($dirty15 & 14) | ($dirty15 & 112) | ($dirty15 & 896) | ($dirty15 & 7168) | (($dirty15 << 3) & 3670016) | (($dirty15 << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color4 = color3;
            fontSize4 = fontSize3;
            fontStyle4 = fontStyle3;
            fontWeight3 = fontWeight2;
            fontFamily4 = fontFamily3;
            letterSpacing4 = letterSpacing2;
            textDecoration3 = textDecoration2;
            textAlign3 = textAlign2;
            lineHeight2 = letterSpacing3;
            overflow3 = overflow2;
            softWrap4 = softWrap3;
            maxLines3 = maxLines2;
            inlineContent3 = inlineContent2;
            onTextLayout3 = onTextLayout2;
            style3 = style2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$9
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

                public final void invoke(Composer composer, int i20) {
                    TextKt.m1728Text4IGK_g(text, modifier4, color4, fontSize4, fontStyle4, fontWeight3, fontFamily4, letterSpacing4, textDecoration3, textAlign3, lineHeight2, overflow3, softWrap4, maxLines3, inlineContent3, onTextLayout3, style3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(final TextStyle value, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1772272796);
        ComposerKt.sourceInformation($composer2, "C(ProvideTextStyle)P(1)394@17636L7,395@17661L80:Text.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(value) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772272796, $dirty, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:393)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TextStyle mergedStyle = ((TextStyle) objConsume).merge(value);
            CompositionLocalKt.CompositionLocalProvider(LocalTextStyle.provides(mergedStyle), function2, $composer2, ProvidedValue.$stable | 0 | ($dirty & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt.ProvideTextStyle.1
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
                    TextKt.ProvideTextStyle(value, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }
}
