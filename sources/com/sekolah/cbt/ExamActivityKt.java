package com.sekolah.cbt;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamActivity.kt */
@Metadata(m164d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m165d2 = {"showSecurely", "", "Landroidx/appcompat/app/AlertDialog;", "activity", "Landroid/app/Activity;", "app_debug"}, m166k = 2, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ExamActivityKt {
    public static final void showSecurely(AlertDialog $this$showSecurely, Activity activity) {
        Intrinsics.checkNotNullParameter($this$showSecurely, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = $this$showSecurely.getWindow();
        if (window != null) {
            window.setFlags(8, 8);
        }
        $this$showSecurely.show();
        Window window2 = $this$showSecurely.getWindow();
        View decorView = window2 != null ? window2.getDecorView() : null;
        if (decorView != null) {
            decorView.setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
        }
        Window window3 = $this$showSecurely.getWindow();
        if (window3 != null) {
            window3.clearFlags(8);
        }
    }
}
