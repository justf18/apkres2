package com.sekolah.cbt;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.EnvironmentCompat;
import com.sekolah.cbt.ServerConfig;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LoginActivity.kt */
@Metadata(m164d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0002¨\u0006\u0012"}, m165d2 = {"Lcom/sekolah/cbt/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "authenticateStudentFromSupabase", "", "nisn", "", "inputPass", "tingkat", "", "checkAppSignature", "", "fetchAndSaveProctorSettingsFromSupabase", "isDeviceRootedOrEmulator", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "requestNotificationPermission", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class LoginActivity extends AppCompatActivity {
    public static final int $stable = 0;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ExamSessionManager.INSTANCE.isExamFinished(this)) {
            startActivity(new Intent(this, (Class<?>) MiniGameActivity.class));
            finish();
            return;
        }
        if (isDeviceRootedOrEmulator()) {
            Toast.makeText(this, "Aplikasi tidak dapat dijalankan di perangkat Root / Emulator!", 1).show();
            finishAffinity();
            return;
        }
        setContentView(C2772R.layout.activity_login);
        requestNotificationPermission();
        final Spinner spTingkat = (Spinner) findViewById(C2772R.id.spTingkat);
        final EditText etNisn = (EditText) findViewById(C2772R.id.etNisn);
        final EditText etPassword = (EditText) findViewById(C2772R.id.etPassword);
        Button btnLogin = (Button) findViewById(C2772R.id.btnLogin);
        spTingkat.setAdapter((SpinnerAdapter) new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ServerConfig.INSTANCE.getTingkatLabels()));
        etNisn.setText("");
        etPassword.setText("");
        btnLogin.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.LoginActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginActivity.onCreate$lambda$0(etNisn, etPassword, spTingkat, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(EditText $etNisn, EditText $etPassword, Spinner $spTingkat, LoginActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String nisn = StringsKt.trim((CharSequence) $etNisn.getText().toString()).toString();
        String password = StringsKt.trim((CharSequence) $etPassword.getText().toString()).toString();
        int selectedTingkatIndex = $spTingkat.getSelectedItemPosition();
        if (!(nisn.length() == 0)) {
            if (!(password.length() == 0)) {
                if (!StringsKt.startsWith$default(nisn, "0", false, 2, (Object) null)) {
                    Toast.makeText(this$0, "NISN harus diawali dengan angka 0!", 1).show();
                    return;
                } else {
                    this$0.authenticateStudentFromSupabase(nisn, password, selectedTingkatIndex);
                    return;
                }
            }
        }
        Toast.makeText(this$0, "NISN dan Password wajib diisi!", 0).show();
    }

    private final void authenticateStudentFromSupabase(final String nisn, final String inputPass, final int tingkat) {
        final ServerConfig.SupabaseEndpoint server = ServerConfig.INSTANCE.getEndpointForTingkat(tingkat);
        new Thread(new Runnable() { // from class: com.sekolah.cbt.LoginActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                LoginActivity.authenticateStudentFromSupabase$lambda$5(server, nisn, inputPass, this, tingkat);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void authenticateStudentFromSupabase$lambda$5(ServerConfig.SupabaseEndpoint server, final String nisn, String inputPass, final LoginActivity this$0, final int $tingkat) throws JSONException {
        final boolean isValid;
        Intrinsics.checkNotNullParameter(server, "$server");
        Intrinsics.checkNotNullParameter(nisn, "$nisn");
        Intrinsics.checkNotNullParameter(inputPass, "$inputPass");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(server.getUrl() + "/rest/v1/students?nisn=eq." + nisn + "&select=nama,student_class,password&limit=1").addHeader("apikey", server.getAnonKey()).addHeader("Authorization", "Bearer " + server.getAnonKey()).get().build();
            Response response = client.newCall(request).execute();
            ResponseBody responseBodyBody = response.body();
            String responseData = responseBodyBody != null ? responseBodyBody.string() : null;
            String str = responseData;
            boolean z = true;
            if (!(str == null || str.length() == 0) && !Intrinsics.areEqual(responseData, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                JSONArray jsonArray = new JSONArray(responseData);
                JSONObject studentObj = jsonArray.getJSONObject(0);
                final String studentName = studentObj.optString("nama", "Siswa");
                final String studentClass = studentObj.optString("student_class", "X-1");
                String dbPassword = studentObj.optString(HintConstants.AUTOFILL_HINT_PASSWORD, "");
                Intrinsics.checkNotNull(dbPassword);
                if (dbPassword.length() <= 0) {
                    z = false;
                }
                if (z && !Intrinsics.areEqual(dbPassword, "null")) {
                    isValid = Intrinsics.areEqual(dbPassword, inputPass);
                } else {
                    isValid = Intrinsics.areEqual(nisn, inputPass);
                }
                this$0.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.LoginActivity$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LoginActivity.authenticateStudentFromSupabase$lambda$5$lambda$2(isValid, this$0, studentName, nisn, studentClass, $tingkat);
                    }
                });
                return;
            }
            try {
                this$0.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.LoginActivity$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        LoginActivity.authenticateStudentFromSupabase$lambda$5$lambda$3(this.f$0, $tingkat);
                    }
                });
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                this$0.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.LoginActivity$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        LoginActivity.authenticateStudentFromSupabase$lambda$5$lambda$4(this.f$0);
                    }
                });
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void authenticateStudentFromSupabase$lambda$5$lambda$2(boolean $isValid, LoginActivity this$0, String $studentName, String nisn, String $studentClass, int $tingkat) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(nisn, "$nisn");
        if ($isValid) {
            Toast.makeText(this$0, "Login Berhasil. Selamat Datang " + $studentName, 0).show();
            ExamSessionManager.INSTANCE.setExamFinished(this$0, false);
            ExamState.INSTANCE.resetAll();
            UserSession userSession = new UserSession(this$0);
            Intrinsics.checkNotNull($studentClass);
            Intrinsics.checkNotNull($studentName);
            userSession.saveSession(nisn, $studentClass, $studentName);
            ServerConfig.INSTANCE.saveTingkat(this$0, $tingkat);
            this$0.fetchAndSaveProctorSettingsFromSupabase($tingkat);
            Intent intent = new Intent(this$0, (Class<?>) MainActivity.class);
            intent.putExtra("STUDENT_NISN", nisn);
            intent.putExtra("STUDENT_CLASS", $studentClass);
            intent.putExtra("STUDENT_NAME", $studentName);
            this$0.startActivity(intent);
            this$0.finish();
            return;
        }
        Toast.makeText(this$0, "Password salah!", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void authenticateStudentFromSupabase$lambda$5$lambda$3(LoginActivity this$0, int $tingkat) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0, "NISN tidak terdaftar di " + ((Object) ServerConfig.INSTANCE.getTingkatLabels().get($tingkat)) + ". Periksa pilihan kelas!", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void authenticateStudentFromSupabase$lambda$5$lambda$4(LoginActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0, "Gagal terhubung ke server database", 0).show();
    }

    private final void fetchAndSaveProctorSettingsFromSupabase(int tingkat) {
        final ServerConfig.SupabaseEndpoint server = ServerConfig.INSTANCE.getEndpointForTingkat(tingkat);
        new Thread(new Runnable() { // from class: com.sekolah.cbt.LoginActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                LoginActivity.fetchAndSaveProctorSettingsFromSupabase$lambda$6(server, this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchAndSaveProctorSettingsFromSupabase$lambda$6(ServerConfig.SupabaseEndpoint server, LoginActivity this$0) throws JSONException {
        Intrinsics.checkNotNullParameter(server, "$server");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(server.getUrl() + "/rest/v1/app_settings?id=eq.1").addHeader("apikey", server.getAnonKey()).addHeader("Authorization", "Bearer " + server.getAnonKey()).get().build();
            Response response = client.newCall(request).execute();
            ResponseBody responseBodyBody = response.body();
            String responseData = responseBodyBody != null ? responseBodyBody.string() : null;
            String str = responseData;
            if (!(str == null || str.length() == 0) && !Intrinsics.areEqual(responseData, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                JSONArray jsonArray = new JSONArray(responseData);
                JSONObject obj = jsonArray.getJSONObject(0);
                String exitPasswordAdmin = obj.optString("exit_password", "adminsman120262027");
                ExamState examState = ExamState.INSTANCE;
                Intrinsics.checkNotNull(exitPasswordAdmin);
                examState.setExitPassword(exitPasswordAdmin);
                this$0.getSharedPreferences("CBT_APP_SETTINGS", 0).edit().putString("admin_exit_password", exitPasswordAdmin).commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= 33 && ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, TypedValues.TYPE_TARGET);
        }
    }

    private final boolean isDeviceRootedOrEmulator() {
        String[] paths = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (String path : paths) {
            if (new File(path).exists()) {
                return true;
            }
        }
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
            String FINGERPRINT2 = Build.FINGERPRINT;
            Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
            if (!StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
                String MODEL = Build.MODEL;
                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                    String MODEL2 = Build.MODEL;
                    Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                    if (!StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "Emulator", false, 2, (Object) null)) {
                        String MODEL3 = Build.MODEL;
                        Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                        if (!StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                            String MANUFACTURER = Build.MANUFACTURER;
                            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                            if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                String HARDWARE = Build.HARDWARE;
                                Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
                                if (!StringsKt.contains$default((CharSequence) HARDWARE, (CharSequence) "goldfish", false, 2, (Object) null)) {
                                    String HARDWARE2 = Build.HARDWARE;
                                    Intrinsics.checkNotNullExpressionValue(HARDWARE2, "HARDWARE");
                                    if (!StringsKt.contains$default((CharSequence) HARDWARE2, (CharSequence) "ranchu", false, 2, (Object) null)) {
                                        String PRODUCT = Build.PRODUCT;
                                        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
                                        if (!StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "sdk_gphone", false, 2, (Object) null)) {
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private final boolean checkAppSignature() throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        PackageInfo packageInfo;
        Signature[] signatures;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                packageInfo = getPackageManager().getPackageInfo(getPackageName(), 134217728);
            } else {
                packageInfo = getPackageManager().getPackageInfo(getPackageName(), 134217728);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                signatures = packageInfo.signingInfo.getApkContentsSigners();
            } else {
                signatures = packageInfo.signatures;
            }
            Intrinsics.checkNotNull(signatures);
            for (Signature signature : signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] digest = md.digest(signature.toByteArray());
                Intrinsics.checkNotNull(digest);
                String hexString = ArraysKt.joinToString$default(digest, (CharSequence) ":", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.sekolah.cbt.LoginActivity$checkAppSignature$hexString$1
                    public final CharSequence invoke(byte it) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                        return invoke(b.byteValue());
                    }
                }, 30, (Object) null);
                if (StringsKt.equals(hexString, "7A:44:E9:47:9C:5D:5B:41:4E:E4:70:25:95:15:E8:E5:1E:F2:5D:6C:F0:69:18:8D:74:24:4F:4D:12:92:D2:6D", true)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
