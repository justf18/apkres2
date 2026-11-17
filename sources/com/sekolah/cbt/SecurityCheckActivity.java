package com.sekolah.cbt;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.sekolah.cbt.ServerConfig;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SecurityCheckActivity.kt */
@Metadata(m164d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020\u0011H\u0002J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0002J\n\u0010(\u001a\u0004\u0018\u00010\rH\u0002J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0*2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0011H\u0002J\b\u0010.\u001a\u00020\u0011H\u0002J\b\u0010/\u001a\u00020\u0011H\u0002J\b\u00100\u001a\u00020\u0011H\u0002J\b\u00101\u001a\u00020\u0011H\u0002J\b\u00102\u001a\u00020\u0011H\u0002J\b\u00103\u001a\u00020\u0011H\u0002J\b\u00104\u001a\u00020\u0011H\u0002J\u0010\u00105\u001a\u00020\u00112\u0006\u0010+\u001a\u00020,H\u0002J\b\u00106\u001a\u00020\u0011H\u0002J\b\u00107\u001a\u00020\u0011H\u0002J\b\u00108\u001a\u00020\u0011H\u0002J\u0012\u00109\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u00010;H\u0014J\b\u0010<\u001a\u00020'H\u0014J-\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020?2\u000e\u0010@\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0A2\u0006\u0010B\u001a\u00020CH\u0016¢\u0006\u0002\u0010DJ\b\u0010E\u001a\u00020'H\u0014J\u0010\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u00020\u0011H\u0016J\b\u0010H\u001a\u00020'H\u0002J\b\u0010I\u001a\u00020'H\u0002J\b\u0010J\u001a\u00020'H\u0002J\b\u0010K\u001a\u00020'H\u0002J\b\u0010L\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000¨\u0006M"}, m165d2 = {"Lcom/sekolah/cbt/SecurityCheckActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnFixDnd", "Landroid/widget/Button;", "btnFixKeyboard", "btnFixOverlay", "btnFixUsageAccess", "btnFixWriteSettings", "btnPinApp", "btnProceed", "btnRefresh", "examUrl", "", "handler", "Landroid/os/Handler;", "isNavigatingToExam", "", "isObscuredByOverlay", "securityCheckRunnable", "Ljava/lang/Runnable;", "studentClass", "studentName", "studentNisn", "subjectId", "subjectName", "tvStatusDevMode", "Landroid/widget/TextView;", "tvStatusDnd", "tvStatusKeyboard", "tvStatusOverlay", "tvStatusPin", "tvStatusUsageAccess", "tvStatusVpn", "canWriteSettings", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "fetchAndSaveProctorSettingsFromSupabase", "", "getActiveBubblePackageName", "getActiveOverlayApps", "", "context", "Landroid/content/Context;", "isApkSignatureValid", "isAppInLockTaskMode", "isDeveloperOptionsEnabled", "isDeviceRooted", "isDoNotDisturbEnabled", "isNotificationPermissionGranted", "isPrivateDnsActive", "isProxyActive", "isRecentBubbleAppActive", "isUsageAccessGranted", "isUsingSimpleKeyboard", "isVpnActive", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onWindowFocusChanged", "hasFocus", "openAppNotificationSettings", "promptUsageAccessPermission", "requestNotificationPermission", "startSecurityPolling", "validateAllConditions", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class SecurityCheckActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private Button btnFixDnd;
    private Button btnFixKeyboard;
    private Button btnFixOverlay;
    private Button btnFixUsageAccess;
    private Button btnFixWriteSettings;
    private Button btnPinApp;
    private Button btnProceed;
    private Button btnRefresh;
    private boolean isNavigatingToExam;
    private boolean isObscuredByOverlay;
    private Runnable securityCheckRunnable;
    private TextView tvStatusDevMode;
    private TextView tvStatusDnd;
    private TextView tvStatusKeyboard;
    private TextView tvStatusOverlay;
    private TextView tvStatusPin;
    private TextView tvStatusUsageAccess;
    private TextView tvStatusVpn;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private String examUrl = "";
    private String studentNisn = "";
    private String studentClass = "";
    private String studentName = "";
    private String subjectId = "0";
    private String subjectName = "";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ExamSessionManager.INSTANCE.isExamFinished(this)) {
            Intent intent = new Intent(this, (Class<?>) MiniGameActivity.class);
            intent.setFlags(335577088);
            startActivity(intent);
            finish();
            return;
        }
        setContentView(C2772R.layout.activity_security_check);
        fetchAndSaveProctorSettingsFromSupabase();
        String stringExtra = getIntent().getStringExtra("EXAM_URL");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.examUrl = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("STUDENT_NISN");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.studentNisn = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("STUDENT_CLASS");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.studentClass = stringExtra3;
        String stringExtra4 = getIntent().getStringExtra("STUDENT_NAME");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        this.studentName = stringExtra4;
        String stringExtra5 = getIntent().getStringExtra("SUBJECT_ID");
        if (stringExtra5 == null) {
            stringExtra5 = "0";
        }
        this.subjectId = stringExtra5;
        String stringExtra6 = getIntent().getStringExtra("SUBJECT_NAME");
        this.subjectName = stringExtra6 != null ? stringExtra6 : "";
        if ((this.examUrl.length() > 0) && !Intrinsics.areEqual(this.examUrl, "https://forms.google.com")) {
            getSharedPreferences("CBT_EXAM_SESSION", 0).edit().putString("exam_url", this.examUrl).apply();
        } else {
            String string = getSharedPreferences("CBT_EXAM_SESSION", 0).getString("exam_url", "https://forms.google.com");
            this.examUrl = string != null ? string : "https://forms.google.com";
        }
        View viewFindViewById = findViewById(C2772R.id.tvStatusKeyboard);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.tvStatusKeyboard = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(C2772R.id.tvStatusOverlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.tvStatusOverlay = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(C2772R.id.tvStatusVpn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.tvStatusVpn = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(C2772R.id.tvStatusDevMode);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.tvStatusDevMode = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(C2772R.id.tvStatusDnd);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.tvStatusDnd = (TextView) viewFindViewById5;
        View viewFindViewById6 = findViewById(C2772R.id.tvStatusPin);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.tvStatusPin = (TextView) viewFindViewById6;
        View viewFindViewById7 = findViewById(C2772R.id.tvStatusAccessibility);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.tvStatusUsageAccess = (TextView) viewFindViewById7;
        View viewFindViewById8 = findViewById(C2772R.id.btnFixKeyboard);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.btnFixKeyboard = (Button) viewFindViewById8;
        View viewFindViewById9 = findViewById(C2772R.id.btnFixOverlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.btnFixOverlay = (Button) viewFindViewById9;
        View viewFindViewById10 = findViewById(C2772R.id.btnFixDnd);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.btnFixDnd = (Button) viewFindViewById10;
        View viewFindViewById11 = findViewById(C2772R.id.btnFixWriteSettings);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.btnFixWriteSettings = (Button) viewFindViewById11;
        View viewFindViewById12 = findViewById(C2772R.id.btnFixAccessibility);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.btnFixUsageAccess = (Button) viewFindViewById12;
        View viewFindViewById13 = findViewById(C2772R.id.btnPinApp);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.btnPinApp = (Button) viewFindViewById13;
        View viewFindViewById14 = findViewById(C2772R.id.btnRefresh);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.btnRefresh = (Button) viewFindViewById14;
        View viewFindViewById15 = findViewById(C2772R.id.btnProceed);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.btnProceed = (Button) viewFindViewById15;
        Button button = this.btnFixKeyboard;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnFixKeyboard");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.SecurityCheckActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecurityCheckActivity.onCreate$lambda$1(this.f$0, view);
            }
        });
        Button button3 = this.btnFixOverlay;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnFixOverlay");
            button3 = null;
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.SecurityCheckActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecurityCheckActivity.onCreate$lambda$2(this.f$0, view);
            }
        });
        Button button4 = this.btnFixDnd;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnFixDnd");
            button4 = null;
        }
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.SecurityCheckActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecurityCheckActivity.onCreate$lambda$3(this.f$0, view);
            }
        });
        Button button5 = this.btnFixWriteSettings;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnFixWriteSettings");
            button5 = null;
        }
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.SecurityCheckActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecurityCheckActivity.onCreate$lambda$5(this.f$0, view);
            }
        });
        Button button6 = this.btnFixUsageAccess;
        if (button6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnFixUsageAccess");
            button6 = null;
        }
        button6.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.SecurityCheckActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecurityCheckActivity.onCreate$lambda$6(this.f$0, view);
            }
        });
        Button button7 = this.btnPinApp;
        if (button7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPinApp");
            button7 = null;
        }
        button7.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.SecurityCheckActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
                SecurityCheckActivity.onCreate$lambda$8(this.f$0, view);
            }
        });
        Button button8 = this.btnRefresh;
        if (button8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRefresh");
            button8 = null;
        }
        button8.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.SecurityCheckActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
                SecurityCheckActivity.onCreate$lambda$9(this.f$0, view);
            }
        });
        Button button9 = this.btnProceed;
        if (button9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnProceed");
        } else {
            button2 = button9;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.SecurityCheckActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
                SecurityCheckActivity.onCreate$lambda$12(this.f$0, view);
            }
        });
        if (!isNotificationPermissionGranted()) {
            requestNotificationPermission();
        }
        startSecurityPolling();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(SecurityCheckActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object systemService = this$0.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager imm = (InputMethodManager) systemService;
        imm.showInputMethodPicker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(SecurityCheckActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(SecurityCheckActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Intent intent = new Intent("android.settings.ZEN_MODE_SETTINGS");
            this$0.startActivity(intent);
        } catch (Exception e) {
            try {
                this$0.startActivity(new Intent("android.settings.SOUND_SETTINGS"));
            } catch (Exception e2) {
                Toast.makeText(this$0, "Tarik panel atas layar HP lalu aktifkan ikon 'Jangan Ganggu'", 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(SecurityCheckActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + this$0.getPackageName()));
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(SecurityCheckActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.promptUsageAccessPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$8(final SecurityCheckActivity this$0, View it) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isAppInLockTaskMode()) {
            try {
                this$0.startLockTask();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sekolah.cbt.SecurityCheckActivity$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
                        SecurityCheckActivity.onCreate$lambda$8$lambda$7(this.f$0);
                    }
                }, 500L);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this$0, "Tekan 'Sematkan' pada dialog sistem yang muncul", 0).show();
                return;
            }
        }
        this$0.validateAllConditions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$8$lambda$7(SecurityCheckActivity this$0) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.validateAllConditions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$9(SecurityCheckActivity this$0, View it) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isObscuredByOverlay = false;
        this$0.validateAllConditions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$12(final SecurityCheckActivity this$0, View it) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.validateAllConditions()) {
            Toast.makeText(this$0, "Harap sematkan aplikasi dan lengkapi opsi berwarna merah!", 0).show();
            return;
        }
        this$0.isNavigatingToExam = true;
        Button button = this$0.btnProceed;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnProceed");
            button = null;
        }
        button.setEnabled(false);
        ExamSessionManager.INSTANCE.setExamFinished(this$0, false);
        Intent intent = new Intent(this$0, (Class<?>) ExamActivity.class);
        intent.putExtra("EXAM_URL", this$0.examUrl);
        intent.putExtra("STUDENT_NISN", this$0.studentNisn);
        intent.putExtra("STUDENT_CLASS", this$0.studentClass);
        intent.putExtra("STUDENT_NAME", this$0.studentName);
        intent.putExtra("SUBJECT_ID", this$0.subjectId);
        intent.putExtra("SUBJECT_NAME", this$0.subjectName);
        intent.setFlags(536870912);
        try {
            this$0.startActivity(intent);
            this$0.handler.postDelayed(new Runnable() { // from class: com.sekolah.cbt.SecurityCheckActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    SecurityCheckActivity.onCreate$lambda$12$lambda$11(this.f$0);
                }
            }, 1000L);
        } catch (Exception e) {
            this$0.isNavigatingToExam = false;
            Log.e("CBT_NAV", "Gagal membuka ExamActivity", e);
            Toast.makeText(this$0, "Gagal membuka ujian: " + e.getMessage(), 1).show();
            this$0.validateAllConditions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$12$lambda$11(SecurityCheckActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isFinishing() && !this$0.isDestroyed()) {
            this$0.finish();
        }
    }

    private final void fetchAndSaveProctorSettingsFromSupabase() {
        final ServerConfig.SupabaseEndpoint server = ServerConfig.INSTANCE.current(this);
        new Thread(new Runnable() { // from class: com.sekolah.cbt.SecurityCheckActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                SecurityCheckActivity.fetchAndSaveProctorSettingsFromSupabase$lambda$13(server, this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchAndSaveProctorSettingsFromSupabase$lambda$13(ServerConfig.SupabaseEndpoint server, SecurityCheckActivity this$0) throws JSONException {
        Intrinsics.checkNotNullParameter(server, "$server");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            OkHttpClient client = new OkHttpClient.Builder().connectTimeout(3L, TimeUnit.SECONDS).readTimeout(3L, TimeUnit.SECONDS).build();
            Request request = new Request.Builder().url(server.getUrl() + "/rest/v1/app_settings?select=*&limit=1").addHeader("apikey", server.getAnonKey()).addHeader("Authorization", "Bearer " + server.getAnonKey()).get().build();
            Response response = client.newCall(request).execute();
            ResponseBody responseBodyBody = response.body();
            String responseData = responseBodyBody != null ? responseBodyBody.string() : null;
            String str = responseData;
            if (!(str == null || str.length() == 0) && !Intrinsics.areEqual(responseData, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                JSONArray jsonArray = new JSONArray(responseData);
                JSONObject obj = jsonArray.getJSONObject(0);
                String strOptString = obj.optString("enter_password", "12345");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                String enterPasswordAdmin = StringsKt.trim((CharSequence) strOptString).toString();
                String strOptString2 = obj.optString("exit_password", "adminsman120262027");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                String exitPasswordAdmin = StringsKt.trim((CharSequence) strOptString2).toString();
                ExamState.INSTANCE.setExitPassword(exitPasswordAdmin);
                this$0.getSharedPreferences("CBT_APP_SETTINGS", 0).edit().putString("admin_enter_password", enterPasswordAdmin).putString("admin_exit_password", exitPasswordAdmin).apply();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        super.onResume();
        if (!this.isNavigatingToExam) {
            validateAllConditions();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && !this.isNavigatingToExam) {
            validateAllConditions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean validateAllConditions() throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        boolean isKeyboardOk;
        String str;
        boolean isKeyboardOk2 = isUsingSimpleKeyboard();
        String detectedBubbleApp = getActiveBubblePackageName();
        boolean isOverlayOk = !this.isObscuredByOverlay && detectedBubbleApp == null;
        boolean isVpnOk = (isVpnActive() || isProxyActive() || isPrivateDnsActive()) ? false : true;
        boolean isDevModeOk = !isDeveloperOptionsEnabled();
        boolean isDndOk = isDoNotDisturbEnabled();
        boolean isUsageAccessOk = isUsageAccessGranted();
        boolean isPinnedOk = isAppInLockTaskMode();
        boolean isBrightnessOk = canWriteSettings();
        boolean isRootOk = !isDeviceRooted();
        boolean isSignatureOk = isApkSignatureValid();
        boolean isNotificationOk = isNotificationPermissionGranted();
        TextView textView = this.tvStatusKeyboard;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusKeyboard");
            textView = null;
        }
        textView.setText(isKeyboardOk2 ? "✓ Simple Keyboard Aktif" : "✗ Gunakan Simple Keyboard");
        TextView textView2 = this.tvStatusKeyboard;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusKeyboard");
            textView2 = null;
        }
        textView2.setTextColor(isKeyboardOk2 ? -16744448 : -65536);
        Button button = this.btnFixKeyboard;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnFixKeyboard");
            button = null;
        }
        button.setVisibility(isKeyboardOk2 ? 8 : 0);
        TextView textView3 = this.tvStatusOverlay;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusOverlay");
            textView3 = null;
        }
        if (isOverlayOk) {
            isKeyboardOk = isKeyboardOk2;
        } else if (detectedBubbleApp != null) {
            isKeyboardOk = isKeyboardOk2;
            str = "✗ Terdeteksi '" + detectedBubbleApp + "' Melayang Aktif!";
        } else {
            isKeyboardOk = isKeyboardOk2;
        }
        textView3.setText(str);
        TextView textView4 = this.tvStatusOverlay;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusOverlay");
            textView4 = null;
        }
        textView4.setTextColor(isOverlayOk ? -16744448 : -65536);
        Button button2 = this.btnFixOverlay;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnFixOverlay");
            button2 = null;
        }
        button2.setVisibility(isOverlayOk ? 8 : 0);
        TextView textView5 = this.tvStatusVpn;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusVpn");
            textView5 = null;
        }
        textView5.setText(isVpnOk ? "✓ Jaringan Steril (No VPN/Proxy)" : "✗ Matikan VPN / Proxy / Private DNS");
        TextView textView6 = this.tvStatusVpn;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusVpn");
            textView6 = null;
        }
        textView6.setTextColor(isVpnOk ? -16744448 : -65536);
        TextView textView7 = this.tvStatusDevMode;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusDevMode");
            textView7 = null;
        }
        textView7.setText(isDevModeOk ? "✓ Opsi Pengembang Off" : "✗ Matikan Opsi Pengembang & USB Debugging");
        TextView textView8 = this.tvStatusDevMode;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusDevMode");
            textView8 = null;
        }
        textView8.setTextColor(isDevModeOk ? -16744448 : -65536);
        TextView textView9 = this.tvStatusDnd;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusDnd");
            textView9 = null;
        }
        textView9.setText(isDndOk ? "✓ Mode Jangan Ganggu (DND) Aktif" : "✗ Aktifkan Mode Jangan Ganggu (Jangan pilih Hening Total)");
        TextView textView10 = this.tvStatusDnd;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusDnd");
            textView10 = null;
        }
        textView10.setTextColor(isDndOk ? -16744448 : -65536);
        Button button3 = this.btnFixDnd;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnFixDnd");
            button3 = null;
        }
        button3.setVisibility(isDndOk ? 8 : 0);
        TextView textView11 = this.tvStatusUsageAccess;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusUsageAccess");
            textView11 = null;
        }
        textView11.setText(isUsageAccessOk ? "✓ Akses Penggunaan Diizinkan" : "✗ Izinkan Akses Penggunaan");
        TextView textView12 = this.tvStatusUsageAccess;
        if (textView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusUsageAccess");
            textView12 = null;
        }
        textView12.setTextColor(isUsageAccessOk ? -16744448 : -65536);
        Button button4 = this.btnFixUsageAccess;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnFixUsageAccess");
            button4 = null;
        }
        button4.setVisibility(isUsageAccessOk ? 8 : 0);
        TextView textView13 = this.tvStatusPin;
        if (textView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusPin");
            textView13 = null;
        }
        textView13.setText(isPinnedOk ? "✓ Aplikasi Tersemat (Pinned)" : "✗ Sematkan Aplikasi Terlebih Dahulu");
        TextView textView14 = this.tvStatusPin;
        if (textView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStatusPin");
            textView14 = null;
        }
        textView14.setTextColor(isPinnedOk ? -16744448 : -65536);
        Button button5 = this.btnPinApp;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPinApp");
            button5 = null;
        }
        button5.setVisibility(isPinnedOk ? 8 : 0);
        Button button6 = this.btnFixWriteSettings;
        if (button6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnFixWriteSettings");
            button6 = null;
        }
        button6.setVisibility(isBrightnessOk ? 8 : 0);
        boolean allPassed = isKeyboardOk && isOverlayOk && isVpnOk && isDevModeOk && isDndOk && isUsageAccessOk && isPinnedOk && isBrightnessOk && isRootOk && isSignatureOk && isNotificationOk;
        if (!this.isNavigatingToExam) {
            Button button7 = this.btnProceed;
            if (button7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnProceed");
                button7 = null;
            }
            button7.setEnabled(allPassed);
        }
        return allPassed;
    }

    private final boolean isNotificationPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 33) {
            return ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0;
        }
        return NotificationManagerCompat.from(this).areNotificationsEnabled();
    }

    private final void requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= 33) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.POST_NOTIFICATIONS")) {
                new AlertDialog.Builder(this).setTitle("Izin Notifikasi Wajib").setMessage("Aplikasi CBT memerlukan izin Notifikasi agar alarm pembekuan layar dapat bekerja.\n\nHarap izinkan Notifikasi di halaman Pengaturan.").setCancelable(false).setPositiveButton("Buka Pengaturan", new DialogInterface.OnClickListener() { // from class: com.sekolah.cbt.SecurityCheckActivity$$ExternalSyntheticLambda6
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SecurityCheckActivity.requestNotificationPermission$lambda$14(this.f$0, dialogInterface, i);
                    }
                }).setNegativeButton("Batal", (DialogInterface.OnClickListener) null).show();
                return;
            } else {
                requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, TypedValues.TYPE_TARGET);
                return;
            }
        }
        openAppNotificationSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestNotificationPermission$lambda$14(SecurityCheckActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openAppNotificationSettings();
    }

    private final void openAppNotificationSettings() {
        try {
            Intent intent = new Intent();
            if (Build.VERSION.SDK_INT >= 26) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
            } else {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + getPackageName()));
            }
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Intent fallbackIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            fallbackIntent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(fallbackIntent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            validateAllConditions();
            if ((grantResults.length == 0) || grantResults[0] != 0) {
                Toast.makeText(this, "Buka Pengaturan dan aktifkan Izin Notifikasi!", 1).show();
                openAppNotificationSettings();
            }
        }
    }

    private final boolean isDeviceRooted() {
        String[] paths = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        for (String path : paths) {
            if (new File(path).exists()) {
                return true;
            }
        }
        String buildTags = Build.TAGS;
        return buildTags != null && StringsKt.contains$default((CharSequence) buildTags, (CharSequence) "test-keys", false, 2, (Object) null);
    }

    private final boolean isApkSignatureValid() throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        PackageInfo packageInfo;
        Signature[] signatures;
        boolean isDebuggable = (getApplicationInfo().flags & 2) != 0;
        if (isDebuggable) {
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                packageInfo = getPackageManager().getPackageInfo(getPackageName(), 134217728);
            } else {
                packageInfo = getPackageManager().getPackageInfo(getPackageName(), 64);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                signatures = packageInfo.signingInfo.getApkContentsSigners();
            } else {
                signatures = packageInfo.signatures;
            }
            Intrinsics.checkNotNull(signatures);
            for (Signature sig : signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(sig.toByteArray());
                byte[] bArrDigest = md.digest();
                Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
                String currentHash = ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.sekolah.cbt.SecurityCheckActivity$isApkSignatureValid$currentHash$1
                    public final CharSequence invoke(byte it) {
                        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                        return invoke(b.byteValue());
                    }
                }, 30, (Object) null);
                if (StringsKt.equals(currentHash, "c1d4a830960394ccdfeddd39a494ee0335a8f9c901bdf563039121de78c325ab", true)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private final boolean isUsageAccessGranted() {
        int mode;
        Object systemService = getSystemService("appops");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AppOpsManager");
        AppOpsManager appOps = (AppOpsManager) systemService;
        if (Build.VERSION.SDK_INT >= 29) {
            mode = appOps.unsafeCheckOpNoThrow("android:get_usage_stats", Process.myUid(), getPackageName());
        } else {
            mode = appOps.checkOpNoThrow("android:get_usage_stats", Process.myUid(), getPackageName());
        }
        return mode == 0;
    }

    private final void promptUsageAccessPermission() {
        new AlertDialog.Builder(this).setTitle("Izin Keamanan Ujian").setMessage("Aplikasi CBT memerlukan izin 'Akses Penggunaan' untuk keamanan selama ujian.").setCancelable(false).setPositiveButton("Buka Pengaturan", new DialogInterface.OnClickListener() { // from class: com.sekolah.cbt.SecurityCheckActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SecurityCheckActivity.promptUsageAccessPermission$lambda$17(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton("Batal", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void promptUsageAccessPermission$lambda$17(SecurityCheckActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
    }

    private final boolean isUsingSimpleKeyboard() {
        String defaultKeyboard = Settings.Secure.getString(getContentResolver(), "default_input_method");
        return defaultKeyboard != null && StringsKt.contains((CharSequence) defaultKeyboard, (CharSequence) "simplekeyboard", true);
    }

    private final boolean isVpnActive() {
        NetworkCapabilities caps;
        Object systemService = getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager cm = (ConnectivityManager) systemService;
        Network activeNetwork = cm.getActiveNetwork();
        if (activeNetwork == null || (caps = cm.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return caps.hasTransport(4);
    }

    private final boolean isProxyActive() {
        String proxyHost = System.getProperty("http.proxyHost");
        String proxyPort = System.getProperty("http.proxyPort");
        String str = proxyHost;
        if (str == null || str.length() == 0) {
            String str2 = proxyPort;
            if (str2 == null || str2.length() == 0) {
                return false;
            }
        }
        return true;
    }

    private final boolean isPrivateDnsActive() {
        String dnsMode;
        return (Build.VERSION.SDK_INT < 28 || (dnsMode = Settings.Global.getString(getContentResolver(), "private_dns_mode")) == null || Intrinsics.areEqual(dnsMode, DebugKt.DEBUG_PROPERTY_VALUE_OFF)) ? false : true;
    }

    private final boolean isDeveloperOptionsEnabled() {
        return Settings.Global.getInt(getContentResolver(), "development_settings_enabled", 0) != 0;
    }

    private final boolean isDoNotDisturbEnabled() {
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        int filter = notificationManager.getCurrentInterruptionFilter();
        return filter == 2 || filter == 4;
    }

    private final boolean isAppInLockTaskMode() {
        Object systemService = getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        return activityManager.getLockTaskModeState() != 0;
    }

    private final void startSecurityPolling() {
        this.securityCheckRunnable = new Runnable() { // from class: com.sekolah.cbt.SecurityCheckActivity.startSecurityPolling.1
            @Override // java.lang.Runnable
            public void run() throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
                SecurityCheckActivity.this.validateAllConditions();
                SecurityCheckActivity.this.handler.postDelayed(this, 500L);
            }
        };
        Handler handler = this.handler;
        Runnable runnable = this.securityCheckRunnable;
        Intrinsics.checkNotNull(runnable);
        handler.postDelayed(runnable, 500L);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(ev, "ev");
        boolean isObscured = (ev.getFlags() & 1) != 0;
        boolean isPartiallyObscured = Build.VERSION.SDK_INT >= 29 && (ev.getFlags() & 2) != 0;
        if (isObscured || isPartiallyObscured) {
            this.isObscuredByOverlay = true;
            validateAllConditions();
            Toast.makeText(this, "Peringatan: Matikan aplikasi melayang / bubble terlebih dahulu!", 0).show();
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    private final boolean canWriteSettings() {
        return Settings.System.canWrite(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Runnable it = this.securityCheckRunnable;
        if (it != null) {
            this.handler.removeCallbacks(it);
        }
    }

    private final String getActiveBubblePackageName() throws PackageManager.NameNotFoundException {
        List activeOverlays = getActiveOverlayApps(this);
        if (!activeOverlays.isEmpty()) {
            return (String) CollectionsKt.first(activeOverlays);
        }
        if (isRecentBubbleAppActive(this)) {
            return "Aplikasi Melayang (Bubble)";
        }
        return null;
    }

    private final List<String> getActiveOverlayApps(Context context) throws PackageManager.NameNotFoundException {
        PackageManager pm = context.getPackageManager();
        Object systemService = context.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager am = (ActivityManager) systemService;
        List detectedOverlayApps = new ArrayList();
        List runningProcesses = am.getRunningAppProcesses();
        if (runningProcesses == null) {
            return CollectionsKt.emptyList();
        }
        for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
            String pkgName = processInfo.processName;
            if (!Intrinsics.areEqual(pkgName, context.getPackageName())) {
                try {
                    ApplicationInfo appInfo = pm.getApplicationInfo(pkgName, 0);
                    Intrinsics.checkNotNullExpressionValue(appInfo, "getApplicationInfo(...)");
                    boolean isSystem = ((appInfo.flags & 1) == 0 && (appInfo.flags & 128) == 0) ? false : true;
                    if (!isSystem) {
                        PackageInfo pkgInfo = pm.getPackageInfo(pkgName, 4096);
                        String[] permissions = pkgInfo.requestedPermissions;
                        if (permissions != null && ArraysKt.contains(permissions, "android.permission.SYSTEM_ALERT_WINDOW")) {
                            detectedOverlayApps.add(appInfo.loadLabel(pm).toString());
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        return detectedOverlayApps;
    }

    private final boolean isRecentBubbleAppActive(Context context) {
        Object systemService = context.getSystemService("usagestats");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.usage.UsageStatsManager");
        UsageStatsManager usm = (UsageStatsManager) systemService;
        long endTime = System.currentTimeMillis();
        long startTime = endTime - 30000;
        UsageEvents usageEvents = usm.queryEvents(startTime, endTime);
        UsageEvents.Event event = new UsageEvents.Event();
        List ignoredPackages = CollectionsKt.listOf((Object[]) new String[]{context.getPackageName(), "com.android.systemui", "com.miui.securitycenter", "com.samsung.android.game"});
        String lastActivePackage = null;
        while (usageEvents.hasNextEvent()) {
            usageEvents.getNextEvent(event);
            if (event.getEventType() == 1) {
                lastActivePackage = event.getPackageName();
            }
        }
        return (lastActivePackage == null || ignoredPackages.contains(lastActivePackage) || StringsKt.contains((CharSequence) lastActivePackage, (CharSequence) "launcher", true)) ? false : true;
    }
}
