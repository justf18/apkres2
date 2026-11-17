package com.sekolah.cbt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlarmRestarterReceiver.kt */
@Metadata(m164d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, m165d2 = {"Lcom/sekolah/cbt/AlarmRestarterReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AlarmRestarterReceiver extends BroadcastReceiver {
    public static final int $stable = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        String action = intent != null ? intent.getAction() : null;
        if (Intrinsics.areEqual(action, "com.sekolah.cbt.RESTART_ALARM") || Intrinsics.areEqual(action, "android.intent.action.BOOT_COMPLETED")) {
            if (ExamSessionManager.INSTANCE.isExamFinished(context)) {
                Log.d("CBT_RESTARTER", "Restart dibatalkan: Sesi ujian sudah selesai.");
                return;
            }
            SharedPreferences prefs = context.getSharedPreferences("CBT_EXAM_SESSION", 0);
            boolean isExamActivePersisted = prefs.getBoolean("is_exam_active", false);
            if (!ExamState.INSTANCE.isExamActive() && isExamActivePersisted) {
                ExamState.INSTANCE.setExamActive(true);
            }
            if (!ExamState.INSTANCE.isExamActive() && !isExamActivePersisted) {
                Log.d("CBT_RESTARTER", "Restart dibatalkan: Tidak ada ujian aktif.");
                return;
            }
            Intent serviceIntent = new Intent(context, (Class<?>) AlarmService.class);
            serviceIntent.setAction("START_ALARM");
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(serviceIntent);
                } else {
                    context.startService(serviceIntent);
                }
            } catch (Exception e) {
                Log.e("CBT_RESTARTER", "Gagal menjalankan Foreground Service dari Receiver: " + e.getMessage());
                try {
                    Intent examIntent = new Intent(context, (Class<?>) ExamActivity.class);
                    examIntent.setFlags(335544320);
                    context.startActivity(examIntent);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
