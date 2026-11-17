package com.sekolah.cbt;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: MiniGameActivity.kt */
@Metadata(m164d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m165d2 = {"<anonymous>", "", "score", "", "invoke"}, m166k = 3, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
final class MiniGameActivity$launchTetrisGameEngine$tetrisEngine$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ TextView $tvScore;
    final /* synthetic */ MiniGameActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MiniGameActivity$launchTetrisGameEngine$tetrisEngine$1$1(MiniGameActivity miniGameActivity, TextView textView) {
        super(1);
        this.this$0 = miniGameActivity;
        this.$tvScore = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(TextView tvScore, int $score) {
        Intrinsics.checkNotNullParameter(tvScore, "$tvScore");
        tvScore.setText("SKOR: " + $score);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final int score) {
        MiniGameActivity miniGameActivity = this.this$0;
        final TextView textView = this.$tvScore;
        miniGameActivity.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.MiniGameActivity$launchTetrisGameEngine$tetrisEngine$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameActivity$launchTetrisGameEngine$tetrisEngine$1$1.invoke$lambda$0(textView, score);
            }
        });
    }
}
