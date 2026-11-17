package com.sekolah.cbt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MainActivity.kt */
@Metadata(m164d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m165d2 = {"Lcom/sekolah/cbt/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "studentClass", "", "studentName", "studentNisn", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onWindowFocusChanged", "hasFocus", "", "redirectToMiniGame", "validateAndOpenSubjectPage", "selectedGrade", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class MainActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private String studentNisn = "";
    private String studentClass = "X-1";
    private String studentName = "Siswa";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ExamSessionManager.INSTANCE.isExamFinished(this)) {
            redirectToMiniGame();
            return;
        }
        setContentView(C2772R.layout.activity_main);
        SharedPreferences sharedPref = getSharedPreferences("CBT_USER_DATA", 0);
        String string = sharedPref.getString("STUDENT_NISN", "");
        String savedNisn = string != null ? string : "";
        String string2 = sharedPref.getString("STUDENT_CLASS", "X-1");
        String savedClass = string2 != null ? string2 : "X-1";
        String string3 = sharedPref.getString("STUDENT_NAME", "Siswa");
        String savedName = string3 != null ? string3 : "Siswa";
        String stringExtra = getIntent().getStringExtra("STUDENT_NISN");
        if (stringExtra == null) {
            stringExtra = savedNisn;
        }
        this.studentNisn = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("STUDENT_CLASS");
        if (stringExtra2 == null) {
            stringExtra2 = savedClass;
        }
        this.studentClass = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("STUDENT_NAME");
        if (stringExtra3 == null) {
            stringExtra3 = savedName;
        }
        this.studentName = stringExtra3;
        TextView tvWelcome = (TextView) findViewById(C2772R.id.tvWelcomeNisn);
        tvWelcome.setText("Selamat Datang, " + this.studentName + " (" + this.studentNisn + ") • Kelas: " + this.studentClass);
        CardView cardKelasX = (CardView) findViewById(C2772R.id.cardKelasX);
        CardView cardKelasXI = (CardView) findViewById(C2772R.id.cardKelasXI);
        CardView cardKelasXII = (CardView) findViewById(C2772R.id.cardKelasXII);
        cardKelasX.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
        cardKelasXI.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.onCreate$lambda$1(this.f$0, view);
            }
        });
        cardKelasXII.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MainActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.onCreate$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.validateAndOpenSubjectPage("X");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.validateAndOpenSubjectPage("XI");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.validateAndOpenSubjectPage("XII");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (ExamSessionManager.INSTANCE.isExamFinished(this)) {
            redirectToMiniGame();
        }
    }

    private final void redirectToMiniGame() {
        Intent intent = new Intent(this, (Class<?>) MiniGameActivity.class);
        intent.setFlags(335577088);
        startActivity(intent);
        finish();
    }

    private final void validateAndOpenSubjectPage(String selectedGrade) {
        String studentGrade = StringsKt.trim((CharSequence) StringsKt.split$default((CharSequence) StringsKt.split$default((CharSequence) this.studentClass, new String[]{"-"}, false, 0, 6, (Object) null).get(0), new String[]{" "}, false, 0, 6, (Object) null).get(0)).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(studentGrade, "toUpperCase(...)");
        if (Intrinsics.areEqual(studentGrade, selectedGrade)) {
            Intent intent = new Intent(this, (Class<?>) SubjectSelectionActivity.class);
            intent.putExtra("STUDENT_NISN", this.studentNisn);
            intent.putExtra("STUDENT_CLASS", this.studentClass);
            intent.putExtra("STUDENT_NAME", this.studentName);
            startActivity(intent);
            return;
        }
        Toast.makeText(this, "Akses Ditolak! Anda terdaftar di Kelas " + this.studentClass + " (Hanya dapat mengakses Kelas " + studentGrade + ")", 1).show();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!hasFocus && ExamState.INSTANCE.isExamActive() && Build.VERSION.SDK_INT < 31) {
            try {
                Intent closeIntent = new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS");
                sendBroadcast(closeIntent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
