package com.sekolah.cbt;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamState.kt */
@Metadata(m164d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u0013"}, m165d2 = {"Lcom/sekolah/cbt/ExamState;", "", "()V", "exitPassword", "", "getExitPassword", "()Ljava/lang/String;", "setExitPassword", "(Ljava/lang/String;)V", "isExamActive", "", "()Z", "setExamActive", "(Z)V", "lastDetectedOverlayPackage", "getLastDetectedOverlayPackage", "setLastDetectedOverlayPackage", "resetAll", "", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ExamState {
    private static volatile boolean isExamActive;
    private static volatile String lastDetectedOverlayPackage;
    public static final ExamState INSTANCE = new ExamState();
    private static volatile String exitPassword = "adminsman120262027";
    public static final int $stable = 8;

    private ExamState() {
    }

    public final boolean isExamActive() {
        return isExamActive;
    }

    public final void setExamActive(boolean z) {
        isExamActive = z;
    }

    public final String getExitPassword() {
        return exitPassword;
    }

    public final void setExitPassword(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        exitPassword = str;
    }

    public final String getLastDetectedOverlayPackage() {
        return lastDetectedOverlayPackage;
    }

    public final void setLastDetectedOverlayPackage(String str) {
        lastDetectedOverlayPackage = str;
    }

    public final void resetAll() {
        isExamActive = false;
        exitPassword = "adminsman120262027";
        lastDetectedOverlayPackage = null;
    }
}
