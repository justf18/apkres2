package com.sekolah.cbt;

import android.app.ActivityManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.sekolah.cbt.ServerConfig;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ExamActivity.kt */
@Metadata(m164d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0002J\u001c\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\"2\b\u0010*\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020$H\u0002J\b\u0010/\u001a\u00020$H\u0002J\u0016\u00100\u001a\u00020$2\f\u00101\u001a\b\u0012\u0004\u0012\u00020$02H\u0002J\b\u00103\u001a\u00020$H\u0002J\n\u00104\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u00105\u001a\u00020\u0006H\u0002J\b\u00106\u001a\u00020\u0006H\u0002J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u00020\fH\u0002J\b\u00109\u001a\u00020\fH\u0002J\u0010\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020<H\u0016J\u0012\u0010=\u001a\u00020$2\b\u0010>\u001a\u0004\u0018\u00010?H\u0014J\b\u0010@\u001a\u00020$H\u0014J\b\u0010A\u001a\u00020$H\u0002J\u0010\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020DH\u0014J\b\u0010E\u001a\u00020$H\u0014J\b\u0010F\u001a\u00020$H\u0014J\b\u0010G\u001a\u00020$H\u0014J\u0010\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020\fH\u0016J\b\u0010J\u001a\u00020$H\u0002J\b\u0010K\u001a\u00020$H\u0002J\b\u0010L\u001a\u00020$H\u0002J\u0010\u0010M\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0006H\u0002J\b\u0010N\u001a\u00020$H\u0002J\b\u0010O\u001a\u00020$H\u0002J\b\u0010P\u001a\u00020$H\u0002J\b\u0010Q\u001a\u00020$H\u0002J\b\u0010R\u001a\u00020$H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000¨\u0006S"}, m165d2 = {"Lcom/sekolah/cbt/ExamActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "activeExitDialog", "Landroidx/appcompat/app/AlertDialog;", "enableZoomJs", "", "enterPasswordExam", "exitPasswordAdmin", "handler", "Landroid/os/Handler;", "isBypassingForDialog", "", "isExamStarted", "isFormAlreadySubmitted", "isPasswordUnlocked", "isSecurityMonitoringReady", "isShowingDialog", "isViolationActive", "lastConfigChangeAt", "", "lockTaskCheckRunnable", "Ljava/lang/Runnable;", "screenBrightnessLevel", "", "soundVolumeLevel", "studentClass", "studentName", "studentNisn", "subjectId", "successMediaPlayer", "Landroid/media/MediaPlayer;", "textZoomLevel", "webView", "Landroid/webkit/WebView;", "addZoomButtons", "", "applyDeviceSettings", "brightness", "volume", "checkIfFormSubmitted", "view", "url", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "enterImmersive", "exitExamToLoginActivity", "fetchGlobalSettingsFromSupabase", "onComplete", "Lkotlin/Function0;", "forceLockTask", "getActiveBubblePackageName", "getSavedEnterPassword", "getSavedExitPassword", "handleViolationOccurred", "inRotationGrace", "isAppInLockTaskMode", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onExamSubmittedSuccessfully", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onStop", "onUserLeaveHint", "onWindowFocusChanged", "hasFocus", "openMiniGameActivityDirect", "playSuccessSoundAndOpenGame", "saveExamCompletionToSupabase", "showEnterPasswordDialog", "showExitPasswordDialog", "showFreezeDialogInternal", "startMonitoringLockTaskStateWithDelay", "stopAlarmService", "triggerViolationAlarm", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ExamActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private AlertDialog activeExitDialog;
    private boolean isBypassingForDialog;
    private boolean isExamStarted;
    private boolean isFormAlreadySubmitted;
    private boolean isPasswordUnlocked;
    private boolean isSecurityMonitoringReady;
    private boolean isShowingDialog;
    private boolean isViolationActive;
    private long lastConfigChangeAt;
    private Runnable lockTaskCheckRunnable;
    private MediaPlayer successMediaPlayer;
    private WebView webView;
    private String enterPasswordExam = "12345";
    private String exitPasswordAdmin = "adminsman120262027";
    private int screenBrightnessLevel = 100;
    private int soundVolumeLevel = 100;
    private int textZoomLevel = 100;
    private final String enableZoomJs = "(function() {\n  var m = document.querySelector('meta[name=viewport]');\n  if (!m) { m = document.createElement('meta'); m.name = 'viewport'; document.head.appendChild(m); }\n  m.setAttribute('content', 'width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=5.0, user-scalable=yes');\n})();";
    private String studentNisn = "";
    private String studentClass = "";
    private String studentName = "";
    private String subjectId = "";
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean inRotationGrace() {
        return System.currentTimeMillis() - this.lastConfigChangeAt < 1500;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v2 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ExamSessionManager.INSTANCE.isExamFinished(this)) {
            openMiniGameActivityDirect();
            return;
        }
        this.enterPasswordExam = getSavedEnterPassword();
        this.exitPasswordAdmin = getSavedExitPassword();
        getWindow().setFlags(8192, 8192);
        getWindow().addFlags(128);
        setContentView(C2772R.layout.activity_exam);
        enterImmersive();
        UserSession userSession = new UserSession(this);
        SharedPreferences sharedPreferences = getSharedPreferences("CBT_USER_DATA", 0);
        String nisn = userSession.getNisn();
        if (nisn.length() == 0) {
            String stringExtra = getIntent().getStringExtra("STUDENT_NISN");
            if (stringExtra == null) {
                stringExtra = "00000";
                String string = sharedPreferences.getString("STUDENT_NISN", "00000");
                if (string != null) {
                    stringExtra = string;
                }
            }
            Intrinsics.checkNotNull(stringExtra);
            nisn = stringExtra;
        }
        this.studentNisn = nisn;
        String str = userSession.getClass();
        if (str.length() == 0) {
            String stringExtra2 = getIntent().getStringExtra("STUDENT_CLASS");
            if (stringExtra2 == null) {
                stringExtra2 = "X-1";
                String string2 = sharedPreferences.getString("STUDENT_CLASS", "X-1");
                if (string2 != null) {
                    stringExtra2 = string2;
                }
            }
            Intrinsics.checkNotNull(stringExtra2);
            str = stringExtra2;
        }
        this.studentClass = str;
        String name = userSession.getName();
        if (name.length() == 0) {
            String stringExtra3 = getIntent().getStringExtra("STUDENT_NAME");
            if (stringExtra3 == null) {
                stringExtra3 = "Siswa";
                String string3 = sharedPreferences.getString("STUDENT_NAME", "Siswa");
                if (string3 != null) {
                    stringExtra3 = string3;
                }
            }
            Intrinsics.checkNotNull(stringExtra3);
            name = stringExtra3;
        }
        this.studentName = name;
        String stringExtra4 = getIntent().getStringExtra("SUBJECT_ID");
        if (stringExtra4 == null) {
            stringExtra4 = "0";
        }
        this.subjectId = stringExtra4;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String stringExtra5 = getIntent().getStringExtra("EXAM_URL");
        T t = stringExtra5;
        if (stringExtra5 == null) {
            t = "";
        }
        objectRef.element = t;
        SharedPreferences sharedPreferences2 = getSharedPreferences("CBT_EXAM_SESSION", 0);
        T t2 = "https://forms.google.com";
        if ((((CharSequence) objectRef.element).length() > 0) && !Intrinsics.areEqual(objectRef.element, "https://forms.google.com")) {
            sharedPreferences2.edit().putString("exam_url", (String) objectRef.element).apply();
        } else {
            String string4 = sharedPreferences2.getString("exam_url", "");
            String str2 = string4 != null ? string4 : "";
            if ((str2.length() > 0) && !Intrinsics.areEqual(str2, "https://forms.google.com")) {
                t2 = str2;
            }
            objectRef.element = t2;
        }
        View viewFindViewById = findViewById(C2772R.id.webViewForm);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.webView = (WebView) viewFindViewById;
        WebView webView = this.webView;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.getSettings().setJavaScriptEnabled(true);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView3 = null;
        }
        webView3.getSettings().setDomStorageEnabled(true);
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView4 = null;
        }
        webView4.getSettings().setDatabaseEnabled(true);
        WebView webView5 = this.webView;
        if (webView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView5 = null;
        }
        webView5.getSettings().setUseWideViewPort(true);
        WebView webView6 = this.webView;
        if (webView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView6 = null;
        }
        webView6.getSettings().setLoadWithOverviewMode(true);
        WebView webView7 = this.webView;
        if (webView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView7 = null;
        }
        webView7.getSettings().setSupportZoom(true);
        WebView webView8 = this.webView;
        if (webView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView8 = null;
        }
        webView8.getSettings().setBuiltInZoomControls(true);
        WebView webView9 = this.webView;
        if (webView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView9 = null;
        }
        webView9.getSettings().setDisplayZoomControls(false);
        addZoomButtons();
        WebView webView10 = this.webView;
        if (webView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView10 = null;
        }
        webView10.setLongClickable(false);
        WebView webView11 = this.webView;
        if (webView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView11 = null;
        }
        webView11.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return ExamActivity.onCreate$lambda$3(view);
            }
        });
        WebView webView12 = this.webView;
        if (webView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView12 = null;
        }
        webView12.setFilterTouchesWhenObscured(true);
        WebView webView13 = this.webView;
        if (webView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView2 = webView13;
        }
        webView2.setWebViewClient(new WebViewClient() { // from class: com.sekolah.cbt.ExamActivity.onCreate.5
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) throws IllegalStateException {
                super.onPageFinished(view, url);
                if (view != null) {
                    view.evaluateJavascript(ExamActivity.this.enableZoomJs, null);
                }
                ExamActivity.this.checkIfFormSubmitted(view, url);
            }

            @Override // android.webkit.WebViewClient
            public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) throws IllegalStateException {
                super.doUpdateVisitedHistory(view, url, isReload);
                ExamActivity.this.checkIfFormSubmitted(view, url);
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.sekolah.cbt.ExamActivity.onCreate.6
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (!ExamActivity.this.isViolationActive && !ExamActivity.this.isShowingDialog && !ExamActivity.this.isFinishing() && !ExamActivity.this.isDestroyed()) {
                    ExamActivity.this.showExitPasswordDialog();
                }
            }
        });
        fetchGlobalSettingsFromSupabase(new Function0<Unit>() { // from class: com.sekolah.cbt.ExamActivity.onCreate.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ExamActivity.this.showEnterPasswordDialog(objectRef.element);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$3(View it) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v2 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        UserSession userSession = new UserSession(this);
        SharedPreferences sharedPreferences = getSharedPreferences("CBT_USER_DATA", 0);
        String nisn = userSession.getNisn();
        if (nisn.length() == 0) {
            String stringExtra = intent.getStringExtra("STUDENT_NISN");
            if (stringExtra == null) {
                stringExtra = "00000";
                String string = sharedPreferences.getString("STUDENT_NISN", "00000");
                if (string != null) {
                    stringExtra = string;
                }
            }
            Intrinsics.checkNotNull(stringExtra);
            nisn = stringExtra;
        }
        this.studentNisn = nisn;
        String str = userSession.getClass();
        if (str.length() == 0) {
            String stringExtra2 = intent.getStringExtra("STUDENT_CLASS");
            if (stringExtra2 == null) {
                stringExtra2 = "X-1";
                String string2 = sharedPreferences.getString("STUDENT_CLASS", "X-1");
                if (string2 != null) {
                    stringExtra2 = string2;
                }
            }
            Intrinsics.checkNotNull(stringExtra2);
            str = stringExtra2;
        }
        this.studentClass = str;
        String name = userSession.getName();
        if (name.length() == 0) {
            String stringExtra3 = intent.getStringExtra("STUDENT_NAME");
            if (stringExtra3 == null) {
                stringExtra3 = "Siswa";
                String string3 = sharedPreferences.getString("STUDENT_NAME", "Siswa");
                if (string3 != null) {
                    stringExtra3 = string3;
                }
            }
            Intrinsics.checkNotNull(stringExtra3);
            name = stringExtra3;
        }
        this.studentName = name;
        String stringExtra4 = intent.getStringExtra("SUBJECT_ID");
        if (stringExtra4 == null) {
            stringExtra4 = "0";
        }
        this.subjectId = stringExtra4;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String stringExtra5 = intent.getStringExtra("EXAM_URL");
        T t = stringExtra5;
        if (stringExtra5 == null) {
            t = "";
        }
        objectRef.element = t;
        SharedPreferences sharedPreferences2 = getSharedPreferences("CBT_EXAM_SESSION", 0);
        T t2 = "https://forms.google.com";
        if ((((CharSequence) objectRef.element).length() > 0) && !Intrinsics.areEqual(objectRef.element, "https://forms.google.com")) {
            sharedPreferences2.edit().putString("exam_url", (String) objectRef.element).apply();
        } else {
            String string4 = sharedPreferences2.getString("exam_url", "");
            String str2 = string4 != null ? string4 : "";
            if ((str2.length() > 0) && !Intrinsics.areEqual(str2, "https://forms.google.com")) {
                t2 = str2;
            }
            objectRef.element = t2;
        }
        if (!this.isExamStarted) {
            fetchGlobalSettingsFromSupabase(new Function0<Unit>() { // from class: com.sekolah.cbt.ExamActivity.onNewIntent.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ExamActivity.this.showEnterPasswordDialog(objectRef.element);
                }
            });
            return;
        }
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.loadUrl((String) objectRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void checkIfFormSubmitted(android.webkit.WebView r10, java.lang.String r11) throws java.lang.IllegalStateException {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sekolah.cbt.ExamActivity.checkIfFormSubmitted(android.webkit.WebView, java.lang.String):void");
    }

    private final String getSavedEnterPassword() {
        String prefPass = getSharedPreferences("CBT_APP_SETTINGS", 0).getString("admin_enter_password", "");
        String str = prefPass;
        return !(str == null || str.length() == 0) ? prefPass : "12345";
    }

    private final String getSavedExitPassword() {
        String prefPass = getSharedPreferences("CBT_APP_SETTINGS", 0).getString("admin_exit_password", "");
        String exitPassword = ExamState.INSTANCE.getExitPassword();
        if (!(exitPassword == null || exitPassword.length() == 0)) {
            return ExamState.INSTANCE.getExitPassword();
        }
        String str = prefPass;
        return !(str == null || str.length() == 0) ? prefPass : "adminsman120262027";
    }

    private final void fetchGlobalSettingsFromSupabase(final Function0<Unit> onComplete) {
        final ServerConfig.SupabaseEndpoint server = ServerConfig.INSTANCE.current(this);
        new Thread(new Runnable() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                ExamActivity.fetchGlobalSettingsFromSupabase$lambda$8(server, this, onComplete);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchGlobalSettingsFromSupabase$lambda$8(ServerConfig.SupabaseEndpoint server, final ExamActivity this$0, final Function0 onComplete) {
        Runnable runnable;
        Intrinsics.checkNotNullParameter(server, "$server");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        try {
            try {
                OkHttpClient client = new OkHttpClient.Builder().connectTimeout(3L, TimeUnit.SECONDS).readTimeout(3L, TimeUnit.SECONDS).build();
                Request request = new Request.Builder().url(server.getUrl() + "/rest/v1/app_settings?select=*&limit=1").addHeader("apikey", server.getAnonKey()).addHeader("Authorization", "Bearer " + server.getAnonKey()).get().build();
                Response response = client.newCall(request).execute();
                ResponseBody responseBodyBody = response.body();
                String responseData = responseBodyBody != null ? responseBodyBody.string() : null;
                String str = responseData;
                boolean z = true;
                if (!(str == null || str.length() == 0) && !Intrinsics.areEqual(responseData, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                    JSONArray jsonArray = new JSONArray(responseData);
                    JSONObject obj = jsonArray.getJSONObject(0);
                    this$0.screenBrightnessLevel = obj.optInt("screen_brightness", 100);
                    this$0.soundVolumeLevel = obj.optInt("sound_volume", 100);
                    String strOptString = obj.optString("enter_password", "");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    String fetchedEnter = StringsKt.trim((CharSequence) strOptString).toString();
                    String strOptString2 = obj.optString("exit_password", "");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    String fetchedExit = StringsKt.trim((CharSequence) strOptString2).toString();
                    SharedPreferences.Editor editor = this$0.getSharedPreferences("CBT_APP_SETTINGS", 0).edit();
                    if (fetchedEnter.length() > 0) {
                        this$0.enterPasswordExam = fetchedEnter;
                        editor.putString("admin_enter_password", fetchedEnter);
                    }
                    if (fetchedExit.length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        this$0.exitPasswordAdmin = fetchedExit;
                        ExamState.INSTANCE.setExitPassword(fetchedExit);
                        editor.putString("admin_exit_password", fetchedExit);
                    }
                    editor.apply();
                }
                runnable = new Runnable() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExamActivity.fetchGlobalSettingsFromSupabase$lambda$8$lambda$7(this.f$0, onComplete);
                    }
                };
            } catch (Exception e) {
                e.printStackTrace();
                runnable = new Runnable() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExamActivity.fetchGlobalSettingsFromSupabase$lambda$8$lambda$7(this.f$0, onComplete);
                    }
                };
            }
            this$0.runOnUiThread(runnable);
        } catch (Throwable th) {
            this$0.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    ExamActivity.fetchGlobalSettingsFromSupabase$lambda$8$lambda$7(this.f$0, onComplete);
                }
            });
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchGlobalSettingsFromSupabase$lambda$8$lambda$7(ExamActivity this$0, Function0 onComplete) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        this$0.applyDeviceSettings(this$0.screenBrightnessLevel, this$0.soundVolumeLevel);
        onComplete.invoke();
    }

    private final void onExamSubmittedSuccessfully() throws IllegalStateException {
        this.isPasswordUnlocked = true;
        this.isSecurityMonitoringReady = false;
        this.isExamStarted = false;
        Runnable it = this.lockTaskCheckRunnable;
        if (it != null) {
            this.handler.removeCallbacks(it);
        }
        ExamSessionManager.INSTANCE.setExamFinished(this, true);
        saveExamCompletionToSupabase();
        Toast.makeText(this, "Jawaban Berhasil Terkirim! Menuju halaman permainan...", 0).show();
        playSuccessSoundAndOpenGame();
    }

    private final void playSuccessSoundAndOpenGame() throws IllegalStateException {
        try {
            Object systemService = getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            int maxVol = audioManager.getStreamMaxVolume(3);
            audioManager.setStreamVolume(3, maxVol, 0);
            MediaPlayer mediaPlayer = this.successMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            MediaPlayer $this$playSuccessSoundAndOpenGame_u24lambda_u2411 = MediaPlayer.create(this, C2772R.raw.success_sound);
            if ($this$playSuccessSoundAndOpenGame_u24lambda_u2411 != null) {
                $this$playSuccessSoundAndOpenGame_u24lambda_u2411.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda9
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer2) {
                        ExamActivity.playSuccessSoundAndOpenGame$lambda$11$lambda$10(this.f$0, mediaPlayer2);
                    }
                });
                $this$playSuccessSoundAndOpenGame_u24lambda_u2411.start();
            } else {
                $this$playSuccessSoundAndOpenGame_u24lambda_u2411 = null;
            }
            this.successMediaPlayer = $this$playSuccessSoundAndOpenGame_u24lambda_u2411;
            if (this.successMediaPlayer == null) {
                this.handler.postDelayed(new Runnable() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExamActivity.playSuccessSoundAndOpenGame$lambda$12(this.f$0);
                    }
                }, 1500L);
            }
        } catch (Exception e) {
            e.printStackTrace();
            openMiniGameActivityDirect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playSuccessSoundAndOpenGame$lambda$11$lambda$10(ExamActivity this$0, MediaPlayer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openMiniGameActivityDirect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playSuccessSoundAndOpenGame$lambda$12(ExamActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openMiniGameActivityDirect();
    }

    private final void openMiniGameActivityDirect() {
        this.isPasswordUnlocked = true;
        this.isSecurityMonitoringReady = false;
        this.isExamStarted = false;
        Runnable it = this.lockTaskCheckRunnable;
        if (it != null) {
            this.handler.removeCallbacks(it);
        }
        ExamSessionManager.INSTANCE.setExamFinished(this, true);
        startActivity(new Intent(this, (Class<?>) MiniGameActivity.class));
        finish();
    }

    private final void saveExamCompletionToSupabase() {
        final ServerConfig.SupabaseEndpoint server = ServerConfig.INSTANCE.current(this);
        new Thread(new Runnable() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                ExamActivity.saveExamCompletionToSupabase$lambda$14(this.f$0, server);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveExamCompletionToSupabase$lambda$14(ExamActivity this$0, ServerConfig.SupabaseEndpoint server) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(server, "$server");
        try {
            OkHttpClient client = new OkHttpClient();
            String jsonPayload = StringsKt.trimIndent("\n                {\n                    \"nisn\": \"" + this$0.studentNisn + "\",\n                    \"student_name\": \"" + this$0.studentName + "\",\n                    \"student_class\": \"" + this$0.studentClass + "\",\n                    \"subject_id\": \"" + this$0.subjectId + "\",\n                    \"is_completed\": true\n                }\n            ");
            RequestBody body = RequestBody.INSTANCE.create(jsonPayload, MediaType.INSTANCE.get("application/json; charset=utf-8"));
            Request request = new Request.Builder().url(server.getUrl() + "/rest/v1/exam_submissions?on_conflict=nisn,subject_id").addHeader("apikey", server.getAnonKey()).addHeader("Authorization", "Bearer " + server.getAnonKey()).addHeader("Content-Type", "application/json").addHeader("Prefer", "resolution=merge-duplicates").post(body).build();
            Response response = client.newCall(request).execute();
            Log.d("CBT_SUPABASE", "Status Pengiriman Submission Server " + this$0.studentClass + ": " + response.code());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void exitExamToLoginActivity() {
        this.isPasswordUnlocked = true;
        this.isExamStarted = false;
        this.isShowingDialog = false;
        this.isBypassingForDialog = false;
        this.isSecurityMonitoringReady = false;
        ExamState.INSTANCE.resetAll();
        ExamSessionManager.INSTANCE.clearSession(this);
        new UserSession(this).clearSession();
        Runnable it = this.lockTaskCheckRunnable;
        if (it != null) {
            this.handler.removeCallbacks(it);
        }
        stopAlarmService();
        try {
            stopLockTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this, (Class<?>) LoginActivity.class);
        intent.setFlags(335577088);
        startActivity(intent);
        finish();
    }

    private final void applyDeviceSettings(int brightness, int volume) {
        try {
            int validBrightness = RangesKt.coerceIn(brightness, 10, 100);
            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
            layoutParams.screenBrightness = validBrightness / 100.0f;
            getWindow().setAttributes(layoutParams);
            Object systemService = getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            int validVolume = RangesKt.coerceIn(volume, 0, 100);
            int maxMusicVol = audioManager.getStreamMaxVolume(3);
            int targetVol = (int) (maxMusicVol * (validVolume / 100.0d));
            audioManager.setStreamVolume(3, targetVol, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void startMonitoringLockTaskStateWithDelay() {
        this.lockTaskCheckRunnable = new Runnable() { // from class: com.sekolah.cbt.ExamActivity.startMonitoringLockTaskStateWithDelay.1
            @Override // java.lang.Runnable
            public void run() throws PackageManager.NameNotFoundException {
                boolean exitDialogUp = ExamActivity.this.activeExitDialog != null;
                if (ExamActivity.this.isExamStarted && !ExamActivity.this.isPasswordUnlocked && ExamActivity.this.isSecurityMonitoringReady && !ExamActivity.this.isViolationActive && ((!ExamActivity.this.isShowingDialog && !ExamActivity.this.isBypassingForDialog) || exitDialogUp)) {
                    boolean notInLockTask = !ExamActivity.this.isAppInLockTaskMode();
                    boolean notHasFocus = (exitDialogUp || ExamActivity.this.hasWindowFocus() || ExamActivity.this.inRotationGrace()) ? false : true;
                    boolean isForeignAppInForeground = ExamActivity.this.getActiveBubblePackageName() != null;
                    if (notInLockTask || notHasFocus || isForeignAppInForeground) {
                        ExamActivity.this.handleViolationOccurred();
                        return;
                    }
                }
                ExamActivity.this.handler.postDelayed(this, 300L);
            }
        };
        Handler handler = this.handler;
        Runnable runnable = this.lockTaskCheckRunnable;
        Intrinsics.checkNotNull(runnable);
        handler.postDelayed(runnable, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getActiveBubblePackageName() {
        UsageStatsManager usageStatsManager;
        boolean isIgnoredPackage;
        try {
            Object systemService = getSystemService("usagestats");
            usageStatsManager = systemService instanceof UsageStatsManager ? (UsageStatsManager) systemService : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (usageStatsManager == null) {
            return null;
        }
        long time = System.currentTimeMillis();
        UsageEvents usageEvents = usageStatsManager.queryEvents(time - 2000, time);
        UsageEvents.Event event = new UsageEvents.Event();
        String lastPackage = "";
        long lastEventTime = 0;
        while (true) {
            isIgnoredPackage = true;
            if (!usageEvents.hasNextEvent()) {
                break;
            }
            usageEvents.getNextEvent(event);
            if (event.getEventType() == 1 || event.getEventType() == 1) {
                if (event.getTimeStamp() >= lastEventTime) {
                    lastEventTime = event.getTimeStamp();
                    String packageName = event.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                    lastPackage = packageName;
                }
            }
        }
        if (!(lastPackage.length() == 0) && !Intrinsics.areEqual(lastPackage, getPackageName()) && !StringsKt.contains((CharSequence) lastPackage, (CharSequence) "launcher", true) && !StringsKt.contains((CharSequence) lastPackage, (CharSequence) "home", true) && !StringsKt.contains((CharSequence) lastPackage, (CharSequence) "systemui", true) && !StringsKt.contains((CharSequence) lastPackage, (CharSequence) "android", true) && !StringsKt.contains((CharSequence) lastPackage, (CharSequence) "keyguard", true) && !StringsKt.contains((CharSequence) lastPackage, (CharSequence) "inputmethod", true) && !StringsKt.contains((CharSequence) lastPackage, (CharSequence) "miui.securitycenter", true)) {
            if (!StringsKt.contains((CharSequence) lastPackage, (CharSequence) "samsung", true)) {
                isIgnoredPackage = false;
            }
        }
        if (isIgnoredPackage) {
            return null;
        }
        return lastPackage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAppInLockTaskMode() {
        Object systemService = getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        return activityManager.getLockTaskModeState() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleViolationOccurred() throws PackageManager.NameNotFoundException {
        String appName;
        if (this.isPasswordUnlocked || this.isViolationActive) {
            return;
        }
        AlertDialog exitDlg = this.activeExitDialog;
        WebView webView = null;
        if (exitDlg != null) {
            try {
                exitDlg.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.activeExitDialog = null;
            this.isShowingDialog = false;
            this.isBypassingForDialog = false;
        } else if (this.isBypassingForDialog) {
            return;
        }
        this.isViolationActive = true;
        WebView webView2 = this.webView;
        if (webView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            webView = webView2;
        }
        webView.setVisibility(4);
        String offendingApp = getActiveBubblePackageName();
        if (offendingApp == null) {
            Toast.makeText(this, "Terdeteksi Pelanggaran! Layar dibekukan.", 1).show();
        } else {
            try {
                ApplicationInfo appInfo = getPackageManager().getApplicationInfo(offendingApp, 0);
                Intrinsics.checkNotNullExpressionValue(appInfo, "getApplicationInfo(...)");
                appName = getPackageManager().getApplicationLabel(appInfo).toString();
            } catch (Exception e2) {
                appName = offendingApp;
            }
            Toast.makeText(this, "Deteksi Pelanggaran: Harap tutup aplikasi '" + appName + "' yang berjalan melayang!", 1).show();
        }
        triggerViolationAlarm();
        showFreezeDialogInternal();
    }

    private final void showFreezeDialogInternal() {
        this.isShowingDialog = true;
        this.isBypassingForDialog = true;
        View dialogView = getLayoutInflater().inflate(C2772R.layout.overlay_freeze_screen, (ViewGroup) null);
        final EditText etPassword = (EditText) dialogView.findViewById(C2772R.id.etFreezeExitPassword);
        Button btnUnlock = (Button) dialogView.findViewById(C2772R.id.btnFreezeUnlock);
        etPassword.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        etPassword.setHintTextColor(Color.parseColor("#9CA3AF"));
        etPassword.setBackgroundColor(-1);
        final AlertDialog dialog = new AlertDialog.Builder(this, android.R.style.Theme.Black.NoTitleBar.Fullscreen).setView(dialogView).setCancelable(false).create();
        Intrinsics.checkNotNullExpressionValue(dialog, "create(...)");
        btnUnlock.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamActivity.showFreezeDialogInternal$lambda$18(etPassword, this, dialog, view);
            }
        });
        try {
            ExamActivityKt.showSecurely(dialog, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFreezeDialogInternal$lambda$18(EditText $etPassword, ExamActivity this$0, AlertDialog dialog, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        String entered = StringsKt.trim((CharSequence) $etPassword.getText().toString()).toString();
        String validPassword = this$0.getSavedExitPassword();
        if (Intrinsics.areEqual(entered, validPassword)) {
            this$0.stopAlarmService();
            this$0.isViolationActive = false;
            this$0.isShowingDialog = false;
            this$0.isBypassingForDialog = false;
            this$0.isExamStarted = false;
            this$0.isSecurityMonitoringReady = false;
            Runnable it2 = this$0.lockTaskCheckRunnable;
            if (it2 != null) {
                this$0.handler.removeCallbacks(it2);
            }
            dialog.dismiss();
            if (this$0.isFormAlreadySubmitted || ExamSessionManager.INSTANCE.isExamFinished(this$0)) {
                this$0.openMiniGameActivityDirect();
                return;
            } else {
                Toast.makeText(this$0, "Kecurangan terdeteksi! Ujian dibatalkan dan dikembalikan ke menu awal.", 1).show();
                this$0.exitExamToLoginActivity();
                return;
            }
        }
        Toast.makeText(this$0, "Password Salah!", 0).show();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) throws PackageManager.NameNotFoundException {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            enterImmersive();
        }
        if (!hasFocus && this.isExamStarted && !this.isPasswordUnlocked && Build.VERSION.SDK_INT < 31) {
            try {
                Intent closeIntent = new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS");
                sendBroadcast(closeIntent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!this.isShowingDialog && !this.isBypassingForDialog && this.isSecurityMonitoringReady && this.isExamStarted && !this.isPasswordUnlocked) {
            if (hasFocus) {
                forceLockTask();
            } else if (inRotationGrace()) {
                this.handler.postDelayed(new Runnable() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() throws PackageManager.NameNotFoundException {
                        ExamActivity.onWindowFocusChanged$lambda$19(this.f$0);
                    }
                }, 1600L);
            } else {
                handleViolationOccurred();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onWindowFocusChanged$lambda$19(ExamActivity this$0) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.hasWindowFocus() && !this$0.isShowingDialog && !this$0.isBypassingForDialog && this$0.isExamStarted && !this$0.isPasswordUnlocked && this$0.isSecurityMonitoringReady) {
            this$0.handleViolationOccurred();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() throws PackageManager.NameNotFoundException {
        super.onUserLeaveHint();
        if (this.isExamStarted && !this.isPasswordUnlocked && this.isSecurityMonitoringReady && !this.isViolationActive) {
            triggerViolationAlarm();
            handleViolationOccurred();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() throws PackageManager.NameNotFoundException {
        super.onPause();
        if (this.isExamStarted && !this.isPasswordUnlocked && this.isSecurityMonitoringReady && !this.isViolationActive) {
            handleViolationOccurred();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() throws PackageManager.NameNotFoundException {
        super.onStop();
        if (this.isExamStarted && !this.isPasswordUnlocked && this.isSecurityMonitoringReady && !this.isViolationActive) {
            triggerViolationAlarm();
            handleViolationOccurred();
        }
    }

    private final void forceLockTask() {
        if (!isAppInLockTaskMode() && !this.isPasswordUnlocked) {
            try {
                startLockTask();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private final void enterImmersive() {
        WindowInsetsControllerCompat controller = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        controller.hide(WindowInsetsCompat.Type.systemBars());
        controller.setSystemBarsBehavior(2);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(lp);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.lastConfigChangeAt = System.currentTimeMillis();
        enterImmersive();
    }

    private static final Button addZoomButtons$makeBtn(final ExamActivity this$0, String label, final int delta) {
        Button $this$addZoomButtons_u24makeBtn_u24lambda_u2421 = new Button(this$0);
        $this$addZoomButtons_u24makeBtn_u24lambda_u2421.setText(label);
        $this$addZoomButtons_u24makeBtn_u24lambda_u2421.setTextColor(-1);
        $this$addZoomButtons_u24makeBtn_u24lambda_u2421.setBackgroundColor(Color.parseColor("#CC1E293B"));
        $this$addZoomButtons_u24makeBtn_u24lambda_u2421.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamActivity.addZoomButtons$makeBtn$lambda$21$lambda$20(this.f$0, delta, view);
            }
        });
        return $this$addZoomButtons_u24makeBtn_u24lambda_u2421;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addZoomButtons$makeBtn$lambda$21$lambda$20(ExamActivity this$0, int $delta, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.textZoomLevel = $delta == 0 ? 100 : RangesKt.coerceIn(this$0.textZoomLevel + $delta, 60, 220);
        WebView webView = this$0.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            webView = null;
        }
        webView.getSettings().setTextZoom(this$0.textZoomLevel);
    }

    private final void addZoomButtons() {
        LinearLayout $this$addZoomButtons_u24lambda_u2422 = new LinearLayout(this);
        $this$addZoomButtons_u24lambda_u2422.setOrientation(0);
        $this$addZoomButtons_u24lambda_u2422.addView(addZoomButtons$makeBtn(this, "A−", -10));
        $this$addZoomButtons_u24lambda_u2422.addView(addZoomButtons$makeBtn(this, "100%", 0));
        $this$addZoomButtons_u24lambda_u2422.addView(addZoomButtons$makeBtn(this, "A+", 10));
        FrameLayout.LayoutParams $this$addZoomButtons_u24lambda_u2423 = new FrameLayout.LayoutParams(-2, -2, 8388693);
        $this$addZoomButtons_u24lambda_u2423.setMargins(0, 0, 24, 24);
        addContentView($this$addZoomButtons_u24lambda_u2422, $this$addZoomButtons_u24lambda_u2423);
    }

    private final void triggerViolationAlarm() {
        try {
            Object systemService = getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            int maxVol = audioManager.getStreamMaxVolume(3);
            audioManager.setStreamVolume(3, maxVol, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Intent serviceIntent = new Intent(this, (Class<?>) AlarmService.class);
            serviceIntent.setAction("START_ALARM");
            if (Build.VERSION.SDK_INT >= 26) {
                startForegroundService(serviceIntent);
            } else {
                startService(serviceIntent);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void stopAlarmService() {
        try {
            Intent serviceIntent = new Intent(this, (Class<?>) AlarmService.class);
            serviceIntent.setAction("STOP_ALARM");
            startService(serviceIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEnterPasswordDialog(final String url) {
        if (isFinishing() || isDestroyed() || this.isShowingDialog) {
            return;
        }
        this.isShowingDialog = true;
        this.isBypassingForDialog = true;
        View dialogView = getLayoutInflater().inflate(C2772R.layout.dialog_enter_password, (ViewGroup) null);
        final EditText etInputPassword = (EditText) dialogView.findViewById(C2772R.id.etInputPassword);
        Button btnCancel = (Button) dialogView.findViewById(C2772R.id.btnCancel);
        Button btnSubmit = (Button) dialogView.findViewById(C2772R.id.btnSubmit);
        final AlertDialog dialog = new AlertDialog.Builder(this).setView(dialogView).setCancelable(false).create();
        Intrinsics.checkNotNullExpressionValue(dialog, "create(...)");
        btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamActivity.showEnterPasswordDialog$lambda$26(this.f$0, dialog, view);
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws PackageManager.NameNotFoundException {
                ExamActivity.showEnterPasswordDialog$lambda$27(etInputPassword, this, dialog, url, view);
            }
        });
        try {
            ExamActivityKt.showSecurely(dialog, this);
        } catch (Exception e) {
            e.printStackTrace();
            this.isShowingDialog = false;
            this.isBypassingForDialog = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showEnterPasswordDialog$lambda$26(ExamActivity this$0, AlertDialog dialog, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.isShowingDialog = false;
        this$0.isBypassingForDialog = false;
        dialog.dismiss();
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showEnterPasswordDialog$lambda$27(EditText $etInputPassword, ExamActivity this$0, AlertDialog dialog, String url, View it) throws PackageManager.NameNotFoundException {
        String appName;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(url, "$url");
        String enteredPassword = StringsKt.trim((CharSequence) $etInputPassword.getText().toString()).toString();
        if (Intrinsics.areEqual(enteredPassword, this$0.enterPasswordExam)) {
            String offendingApp = this$0.getActiveBubblePackageName();
            if (offendingApp != null) {
                try {
                    ApplicationInfo appInfo = this$0.getPackageManager().getApplicationInfo(offendingApp, 0);
                    Intrinsics.checkNotNullExpressionValue(appInfo, "getApplicationInfo(...)");
                    appName = this$0.getPackageManager().getApplicationLabel(appInfo).toString();
                } catch (Exception e) {
                    appName = offendingApp;
                }
                Toast.makeText(this$0, "Ujian Ditolak! Terdeteksi '" + appName + "' berjalan melayang. Harap tutup terlebih dahulu!", 1).show();
                return;
            }
            dialog.dismiss();
            this$0.isShowingDialog = false;
            this$0.isBypassingForDialog = false;
            this$0.isExamStarted = true;
            ExamState.INSTANCE.setExamActive(true);
            this$0.isSecurityMonitoringReady = true;
            this$0.forceLockTask();
            WebView webView = this$0.webView;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView = null;
            }
            webView.loadUrl(url);
            Toast.makeText(this$0, "Ujian Dimulai. Layar Terkunci!", 0).show();
            this$0.startMonitoringLockTaskStateWithDelay();
            return;
        }
        Toast.makeText(this$0, "Password Masuk Salah!", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showExitPasswordDialog() {
        if (isFinishing() || isDestroyed() || this.isShowingDialog) {
            return;
        }
        this.isShowingDialog = true;
        this.isBypassingForDialog = true;
        View dialogView = getLayoutInflater().inflate(C2772R.layout.dialog_exit_password, (ViewGroup) null);
        final EditText etInputPassword = (EditText) dialogView.findViewById(C2772R.id.etInputExitPassword);
        Button btnCancel = (Button) dialogView.findViewById(C2772R.id.btnCancelExit);
        Button btnUnlock = (Button) dialogView.findViewById(C2772R.id.btnUnlock);
        final AlertDialog dialog = new AlertDialog.Builder(this).setView(dialogView).setCancelable(false).create();
        Intrinsics.checkNotNullExpressionValue(dialog, "create(...)");
        this.activeExitDialog = dialog;
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ExamActivity.showExitPasswordDialog$lambda$28(this.f$0, dialog, dialogInterface);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamActivity.showExitPasswordDialog$lambda$29(this.f$0, dialog, view);
            }
        });
        btnUnlock.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.ExamActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamActivity.showExitPasswordDialog$lambda$30(etInputPassword, this, dialog, view);
            }
        });
        try {
            ExamActivityKt.showSecurely(dialog, this);
        } catch (Exception e) {
            e.printStackTrace();
            this.isShowingDialog = false;
            this.isBypassingForDialog = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExitPasswordDialog$lambda$28(ExamActivity this$0, AlertDialog dialog, DialogInterface it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (this$0.activeExitDialog == dialog) {
            this$0.activeExitDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExitPasswordDialog$lambda$29(ExamActivity this$0, AlertDialog dialog, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.isShowingDialog = false;
        this$0.isBypassingForDialog = false;
        dialog.dismiss();
        this$0.enterImmersive();
        this$0.forceLockTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExitPasswordDialog$lambda$30(EditText $etInputPassword, ExamActivity this$0, AlertDialog dialog, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        String enteredPassword = StringsKt.trim((CharSequence) $etInputPassword.getText().toString()).toString();
        String validPassword = this$0.getSavedExitPassword();
        if (Intrinsics.areEqual(enteredPassword, validPassword)) {
            this$0.isShowingDialog = false;
            this$0.isBypassingForDialog = false;
            dialog.dismiss();
            this$0.exitExamToLoginActivity();
            return;
        }
        Toast.makeText(this$0, "Password Salah!", 0).show();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MediaPlayer mediaPlayer = this.successMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        Runnable it = this.lockTaskCheckRunnable;
        if (it != null) {
            this.handler.removeCallbacks(it);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getRawX() < 10.0f || ev.getRawX() > getResources().getDisplayMetrics().widthPixels - 10.0f || ev.getRawY() < 10.0f || ev.getRawY() > getResources().getDisplayMetrics().heightPixels - 10.0f) {
            boolean isObscured = super.dispatchTouchEvent(ev);
            return isObscured;
        }
        boolean isPartiallyObscured = false;
        boolean isObscured2 = (ev.getFlags() & 1) != 0;
        if (Build.VERSION.SDK_INT >= 29 && (ev.getFlags() & 2) != 0) {
            isPartiallyObscured = true;
        }
        if (isObscured2 || isPartiallyObscured) {
            if (this.isExamStarted && !this.isViolationActive && !this.isPasswordUnlocked && this.isSecurityMonitoringReady && !this.isBypassingForDialog) {
                handleViolationOccurred();
            }
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }
}
