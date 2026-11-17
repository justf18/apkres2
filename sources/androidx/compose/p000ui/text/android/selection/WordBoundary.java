package androidx.compose.p000ui.text.android.selection;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Locale;
import kotlin.Metadata;

/* compiled from: WordBoundary.kt */
@Metadata(m164d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m165d2 = {"Landroidx/compose/ui/text/android/selection/WordBoundary;", "", "locale", "Ljava/util/Locale;", "text", "", "(Ljava/util/Locale;Ljava/lang/CharSequence;)V", "wordIterator", "Landroidx/compose/ui/text/android/selection/WordIterator;", "getWordEnd", "", TypedValues.CycleType.S_WAVE_OFFSET, "getWordStart", "ui-text_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class WordBoundary {
    public static final int $stable = 8;
    private final WordIterator wordIterator;

    public WordBoundary(Locale locale, CharSequence text) {
        this.wordIterator = new WordIterator(text, 0, text.length(), locale);
    }

    public final int getWordStart(int offset) {
        int retOffset;
        int retOffset2 = this.wordIterator.prevBoundary(offset);
        if (this.wordIterator.isOnPunctuation(retOffset2)) {
            retOffset = this.wordIterator.getPunctuationBeginning(offset);
        } else {
            retOffset = this.wordIterator.getPrevWordBeginningOnTwoWordsBoundary(offset);
        }
        if (retOffset == -1) {
            return offset;
        }
        return retOffset;
    }

    public final int getWordEnd(int offset) {
        int retOffset;
        int retOffset2 = this.wordIterator.nextBoundary(offset);
        if (this.wordIterator.isAfterPunctuation(retOffset2)) {
            retOffset = this.wordIterator.getPunctuationEnd(offset);
        } else {
            retOffset = this.wordIterator.getNextWordEndOnTwoWordBoundary(offset);
        }
        if (retOffset == -1) {
            return offset;
        }
        return retOffset;
    }
}
