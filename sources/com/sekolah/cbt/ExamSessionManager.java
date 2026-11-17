package com.sekolah.cbt;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExamSessionManager.kt */
@Metadata(m164d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fJ>\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010!\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, m165d2 = {"Lcom/sekolah/cbt/ExamSessionManager;", "", "()V", "KEY_EXAM_URL", "", "KEY_IS_FINISHED", "KEY_STUDENT_CLASS", "KEY_STUDENT_NAME", "KEY_STUDENT_NISN", "KEY_SUBJECT_ID", "KEY_SUBJECT_NAME", "PREF_NAME", "clearSession", "", "context", "Landroid/content/Context;", "getExamUrl", "getPrefs", "Landroid/content/SharedPreferences;", "getStudentClass", "getStudentName", "getStudentNisn", "getSubjectId", "getSubjectName", "isExamFinished", "", "saveStudentData", "url", "nisn", "className", HintConstants.AUTOFILL_HINT_NAME, "subId", "subName", "setExamFinished", "isFinished", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ExamSessionManager {
    public static final int $stable = 0;
    public static final ExamSessionManager INSTANCE = new ExamSessionManager();
    private static final String KEY_EXAM_URL = "exam_url";
    private static final String KEY_IS_FINISHED = "is_exam_finished";
    private static final String KEY_STUDENT_CLASS = "student_class";
    private static final String KEY_STUDENT_NAME = "student_name";
    private static final String KEY_STUDENT_NISN = "student_nisn";
    private static final String KEY_SUBJECT_ID = "subject_id";
    private static final String KEY_SUBJECT_NAME = "subject_name";
    private static final String PREF_NAME = "CBT_EXAM_SESSION";

    private ExamSessionManager() {
    }

    private final SharedPreferences getPrefs(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    public final void setExamFinished(Context context, boolean isFinished) {
        Intrinsics.checkNotNullParameter(context, "context");
        getPrefs(context).edit().putBoolean(KEY_IS_FINISHED, isFinished).commit();
    }

    public final boolean isExamFinished(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getPrefs(context).getBoolean(KEY_IS_FINISHED, false);
    }

    public final void saveStudentData(Context context, String url, String nisn, String className, String name, String subId, String subName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(nisn, "nisn");
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(subName, "subName");
        SharedPreferences.Editor $this$saveStudentData_u24lambda_u240 = getPrefs(context).edit();
        $this$saveStudentData_u24lambda_u240.putBoolean(KEY_IS_FINISHED, false);
        $this$saveStudentData_u24lambda_u240.putString(KEY_EXAM_URL, url);
        $this$saveStudentData_u24lambda_u240.putString(KEY_STUDENT_NISN, nisn);
        $this$saveStudentData_u24lambda_u240.putString(KEY_STUDENT_CLASS, className);
        $this$saveStudentData_u24lambda_u240.putString(KEY_STUDENT_NAME, name);
        $this$saveStudentData_u24lambda_u240.putString(KEY_SUBJECT_ID, subId);
        $this$saveStudentData_u24lambda_u240.putString(KEY_SUBJECT_NAME, subName);
        $this$saveStudentData_u24lambda_u240.commit();
    }

    public final void clearSession(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getPrefs(context).edit().clear().commit();
    }

    public final String getExamUrl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = getPrefs(context).getString(KEY_EXAM_URL, "");
        return string == null ? "" : string;
    }

    public final String getStudentNisn(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = getPrefs(context).getString(KEY_STUDENT_NISN, "");
        return string == null ? "" : string;
    }

    public final String getStudentClass(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = getPrefs(context).getString(KEY_STUDENT_CLASS, "");
        return string == null ? "" : string;
    }

    public final String getStudentName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = getPrefs(context).getString(KEY_STUDENT_NAME, "");
        return string == null ? "" : string;
    }

    public final String getSubjectId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = getPrefs(context).getString(KEY_SUBJECT_ID, "");
        return string == null ? "" : string;
    }

    public final String getSubjectName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = getPrefs(context).getString(KEY_SUBJECT_NAME, "");
        return string == null ? "" : string;
    }
}
