package com.sekolah.cbt;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: MiniGameActivity.kt */
@Metadata(m164d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, m165d2 = {"<anonymous>", "", "lvl", "", "score", "invoke"}, m166k = 3, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
final class MiniGameActivity$launchPongGameEngine$pongEngine$1$1 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ TextView $tvScore;
    final /* synthetic */ MiniGameActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MiniGameActivity$launchPongGameEngine$pongEngine$1$1(MiniGameActivity miniGameActivity, TextView textView) {
        super(2);
        this.this$0 = miniGameActivity;
        this.$tvScore = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(TextView tvScore, int $lvl, int $score) {
        Intrinsics.checkNotNullParameter(tvScore, "$tvScore");
        tvScore.setText("LVL " + $lvl + " | SKOR: " + $score);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final int lvl, final int score) {
        MiniGameActivity miniGameActivity = this.this$0;
        final TextView textView = this.$tvScore;
        miniGameActivity.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.MiniGameActivity$launchPongGameEngine$pongEngine$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameActivity$launchPongGameEngine$pongEngine$1$1.invoke$lambda$0(textView, lvl, score);
            }
        });
    }
}
