package com.sekolah.cbt;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserSession.kt */
@Metadata(m164d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m165d2 = {"Lcom/sekolah/cbt/UserSession;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "pref", "Landroid/content/SharedPreferences;", "clearSession", "", "getClass", "", "getName", "getNisn", "isLoggedIn", "", "saveSession", "nisn", "studentClass", HintConstants.AUTOFILL_HINT_NAME, "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class UserSession {
    public static final int $stable = 8;
    private final SharedPreferences pref;

    public UserSession(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("CBT_USER_DATA", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.pref = sharedPreferences;
    }

    public final void saveSession(String nisn, String studentClass, String name) {
        Intrinsics.checkNotNullParameter(nisn, "nisn");
        Intrinsics.checkNotNullParameter(studentClass, "studentClass");
        Intrinsics.checkNotNullParameter(name, "name");
        SharedPreferences.Editor $this$saveSession_u24lambda_u240 = this.pref.edit();
        $this$saveSession_u24lambda_u240.putString("STUDENT_NISN", nisn);
        $this$saveSession_u24lambda_u240.putString("STUDENT_CLASS", studentClass);
        $this$saveSession_u24lambda_u240.putString("STUDENT_NAME", name);
        $this$saveSession_u24lambda_u240.putBoolean("IS_LOGGED_IN", true);
        $this$saveSession_u24lambda_u240.commit();
    }

    public final String getNisn() {
        String string = this.pref.getString("STUDENT_NISN", "");
        return string == null ? "" : string;
    }

    public final String getClass() {
        String string = this.pref.getString("STUDENT_CLASS", "X-1");
        return string == null ? "X-1" : string;
    }

    public final String getName() {
        String string = this.pref.getString("STUDENT_NAME", "Siswa");
        return string == null ? "Siswa" : string;
    }

    public final boolean isLoggedIn() {
        return this.pref.getBoolean("IS_LOGGED_IN", false);
    }

    public final void clearSession() {
        this.pref.edit().clear().commit();
    }
}
