package androidx.compose.p000ui.text.platform;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.Placeholder;
import androidx.compose.p000ui.text.PlatformParagraphStyle;
import androidx.compose.p000ui.text.PlatformTextStyle;
import androidx.compose.p000ui.text.SpanStyle;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.font.FontStyle;
import androidx.compose.p000ui.text.font.FontSynthesis;
import androidx.compose.p000ui.text.font.FontWeight;
import androidx.compose.p000ui.text.platform.extensions.PlaceholderExtensions_androidKt;
import androidx.compose.p000ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.p000ui.text.style.LineHeightStyle;
import androidx.compose.p000ui.text.style.TextDecoration;
import androidx.compose.p000ui.text.style.TextIndent;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.emoji2.text.EmojiCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidParagraphHelper.android.kt */
@Metadata(m164d1 = {"\u0000]\n\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0001\u001a\u0080\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\f2\u0006\u0010\u0011\u001a\u00020\u00122&\u0010\u0013\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0000\u001a\f\u0010\u001c\u001a\u00020\u001b*\u00020\nH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u001d"}, m165d2 = {"NoopSpan", "androidx/compose/ui/text/platform/AndroidParagraphHelper_androidKt$NoopSpan$1", "Landroidx/compose/ui/text/platform/AndroidParagraphHelper_androidKt$NoopSpan$1;", "createCharSequence", "", "text", "", "contextFontSize", "", "contextTextStyle", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "useEmojiCompat", "", "isIncludeFontPaddingEnabled", "ui-text_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidParagraphHelper_androidKt {
    private static final AndroidParagraphHelper_androidKt$NoopSpan$1 NoopSpan = new CharacterStyle() { // from class: androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt$NoopSpan$1
        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint p0) {
        }
    };

    public static final CharSequence createCharSequence(String text, float contextFontSize, TextStyle contextTextStyle, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, Density density, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4, boolean useEmojiCompat) {
        String currentText;
        SpannableString spannableString;
        float contextFontSize2;
        Density density2;
        if (useEmojiCompat && EmojiCompat.isConfigured()) {
            currentText = EmojiCompat.get().process(text);
            Intrinsics.checkNotNull(currentText);
        } else {
            currentText = text;
        }
        if (list.isEmpty() && list2.isEmpty() && Intrinsics.areEqual(contextTextStyle.getTextIndent(), TextIndent.INSTANCE.getNone()) && TextUnitKt.m6506isUnspecifiedR2X_6o(contextTextStyle.m5813getLineHeightXSAIIZE())) {
            return currentText;
        }
        if (currentText instanceof Spannable) {
            spannableString = (Spannable) currentText;
        } else {
            spannableString = new SpannableString(currentText);
        }
        Spannable spannableString2 = spannableString;
        if (Intrinsics.areEqual(contextTextStyle.getTextDecoration(), TextDecoration.INSTANCE.getUnderline())) {
            SpannableExtensions_androidKt.setSpan(spannableString2, NoopSpan, 0, text.length());
        }
        if (isIncludeFontPaddingEnabled(contextTextStyle) && contextTextStyle.getLineHeightStyle() == null) {
            SpannableExtensions_androidKt.m6045setLineHeightr9BaKPg(spannableString2, contextTextStyle.m5813getLineHeightXSAIIZE(), contextFontSize, density);
            contextFontSize2 = contextFontSize;
            density2 = density;
        } else {
            LineHeightStyle lineHeightStyle = contextTextStyle.getLineHeightStyle();
            if (lineHeightStyle == null) {
                lineHeightStyle = LineHeightStyle.INSTANCE.getDefault();
            }
            LineHeightStyle lineHeightStyle2 = lineHeightStyle;
            contextFontSize2 = contextFontSize;
            density2 = density;
            SpannableExtensions_androidKt.m6044setLineHeightKmRG4DE(spannableString2, contextTextStyle.m5813getLineHeightXSAIIZE(), contextFontSize2, density2, lineHeightStyle2);
        }
        SpannableExtensions_androidKt.setTextIndent(spannableString2, contextTextStyle.getTextIndent(), contextFontSize2, density2);
        SpannableExtensions_androidKt.setSpanStyles(spannableString2, contextTextStyle, list, density2, function4);
        PlaceholderExtensions_androidKt.setPlaceholders(spannableString2, list2, density2);
        return spannableString2;
    }

    public static final boolean isIncludeFontPaddingEnabled(TextStyle $this$isIncludeFontPaddingEnabled) {
        PlatformParagraphStyle paragraphSyle;
        PlatformTextStyle platformStyle = $this$isIncludeFontPaddingEnabled.getPlatformStyle();
        if (platformStyle == null || (paragraphSyle = platformStyle.getParagraphSyle()) == null) {
            return false;
        }
        return paragraphSyle.getIncludeFontPadding();
    }
}
