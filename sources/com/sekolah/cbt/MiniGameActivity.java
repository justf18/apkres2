package com.sekolah.cbt;

import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.sekolah.cbt.MiniGameActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* compiled from: MiniGameActivity.kt */
@Metadata(m164d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\rH\u0002J\b\u0010'\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\u0012\u0010+\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020\u001dH\u0014J\b\u0010/\u001a\u00020\u001dH\u0014J\b\u00100\u001a\u00020\u001dH\u0014J\b\u00101\u001a\u00020\u001dH\u0014J\b\u00102\u001a\u00020\u001dH\u0014J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\rH\u0016J\b\u00105\u001a\u00020\u001dH\u0002J\b\u00106\u001a\u00020\u001dH\u0002J\b\u00107\u001a\u00020\u001dH\u0002J\b\u00108\u001a\u00020\u001dH\u0002J\b\u00109\u001a\u00020\u001dH\u0002J\b\u0010:\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, m165d2 = {"Lcom/sekolah/cbt/MiniGameActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "bgHandler", "Landroid/os/Handler;", "bgThread", "Landroid/os/HandlerThread;", "exitPasswordAdmin", "", "handler", "ignoredPrefixes", "", "isBypassingForDialog", "", "isBypassingForLockTask", "isMonitoringReady", "isPasswordUnlocked", "isShowingDialog", "isViolationActive", "mainContainer", "Landroid/widget/FrameLayout;", "strictSecurityCheckRunnable", "Ljava/lang/Runnable;", "createGameCard", "Landroid/widget/LinearLayout;", "title", "accentColor", "onClick", "Lkotlin/Function0;", "", "detectForeignForegroundApp", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "exitToLogin", "forceLockTask", "getSavedExitPassword", "handleViolationOccurred", "isAppInLockTaskMode", "launchPongGameEngine", "launchSnakeGameEngine", "launchSudokuGameEngine", "launchTetrisGameEngine", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStop", "onUserLeaveHint", "onWindowFocusChanged", "hasFocus", "showExitPasswordDialog", "showFreezeDialogInternal", "showMainMenu", "startStrictSecurityMonitoring", "stopAlarmService", "triggerViolationAlarm", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class MiniGameActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private final Handler bgHandler;
    private final HandlerThread bgThread;
    private String exitPasswordAdmin = "adminsman120262027";
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final List<String> ignoredPrefixes;
    private boolean isBypassingForDialog;
    private boolean isBypassingForLockTask;
    private boolean isMonitoringReady;
    private boolean isPasswordUnlocked;
    private boolean isShowingDialog;
    private boolean isViolationActive;
    private FrameLayout mainContainer;
    private Runnable strictSecurityCheckRunnable;

    public MiniGameActivity() {
        HandlerThread $this$bgThread_u24lambda_u240 = new HandlerThread("cbt-monitor");
        $this$bgThread_u24lambda_u240.start();
        this.bgThread = $this$bgThread_u24lambda_u240;
        this.bgHandler = new Handler(this.bgThread.getLooper());
        this.ignoredPrefixes = CollectionsKt.listOf((Object[]) new String[]{"com.android.systemui", "com.android.launcher", "com.android.inputmethod", "com.google.android.inputmethod", "com.google.android.apps.nexuslauncher", "com.miui.home", "com.miui.securitycenter", "com.sec.android.app.launcher", "com.samsung.android.game", "android"});
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(8192, 8192);
        getWindow().addFlags(128);
        this.exitPasswordAdmin = getSavedExitPassword();
        FrameLayout $this$onCreate_u24lambda_u241 = new FrameLayout(this);
        $this$onCreate_u24lambda_u241.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        $this$onCreate_u24lambda_u241.setBackgroundColor(Color.parseColor("#0F172A"));
        $this$onCreate_u24lambda_u241.setFilterTouchesWhenObscured(true);
        this.mainContainer = $this$onCreate_u24lambda_u241;
        FrameLayout frameLayout = this.mainContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
            frameLayout = null;
        }
        setContentView(frameLayout);
        showMainMenu();
        forceLockTask();
        this.handler.postDelayed(new Runnable() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameActivity.onCreate$lambda$2(this.f$0);
            }
        }, 1500L);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.sekolah.cbt.MiniGameActivity.onCreate.3
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (!MiniGameActivity.this.isViolationActive && !MiniGameActivity.this.isShowingDialog && !MiniGameActivity.this.isBypassingForDialog && !MiniGameActivity.this.isFinishing() && !MiniGameActivity.this.isDestroyed()) {
                    MiniGameActivity.this.showExitPasswordDialog();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(MiniGameActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isMonitoringReady = true;
        this$0.startStrictSecurityMonitoring();
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

    /* compiled from: MiniGameActivity.kt */
    @Metadata(m164d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m165d2 = {"com/sekolah/cbt/MiniGameActivity$startStrictSecurityMonitoring$1", "Ljava/lang/Runnable;", "run", "", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: com.sekolah.cbt.MiniGameActivity$startStrictSecurityMonitoring$1 */
    public static final class RunnableC27711 implements Runnable {
        RunnableC27711() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!MiniGameActivity.this.isPasswordUnlocked && !MiniGameActivity.this.isShowingDialog && !MiniGameActivity.this.isBypassingForDialog && !MiniGameActivity.this.isBypassingForLockTask) {
                Handler handler = MiniGameActivity.this.bgHandler;
                final MiniGameActivity miniGameActivity = MiniGameActivity.this;
                handler.post(new Runnable() { // from class: com.sekolah.cbt.MiniGameActivity$startStrictSecurityMonitoring$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() throws PackageManager.NameNotFoundException {
                        MiniGameActivity.RunnableC27711.run$lambda$1(miniGameActivity);
                    }
                });
            }
            MiniGameActivity.this.handler.postDelayed(this, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$1(final MiniGameActivity this$0) throws PackageManager.NameNotFoundException {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            final boolean foreign = this$0.detectForeignForegroundApp();
            this$0.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.MiniGameActivity$startStrictSecurityMonitoring$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameActivity.RunnableC27711.run$lambda$1$lambda$0(this$0, foreign);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$1$lambda$0(MiniGameActivity this$0, boolean $foreign) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!this$0.isPasswordUnlocked && !this$0.isShowingDialog && !this$0.isBypassingForDialog && !this$0.isBypassingForLockTask) {
                if (!this$0.isAppInLockTaskMode() || !this$0.hasWindowFocus() || $foreign) {
                    this$0.handleViolationOccurred();
                }
            }
        }
    }

    private final void startStrictSecurityMonitoring() {
        this.strictSecurityCheckRunnable = new RunnableC27711();
        Handler handler = this.handler;
        Runnable runnable = this.strictSecurityCheckRunnable;
        Intrinsics.checkNotNull(runnable);
        handler.postDelayed(runnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean detectForeignForegroundApp() throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sekolah.cbt.MiniGameActivity.detectForeignForegroundApp():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAppInLockTaskMode() {
        Object systemService = getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        return activityManager.getLockTaskModeState() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleViolationOccurred() {
        if (!this.isMonitoringReady || this.isPasswordUnlocked || this.isViolationActive || this.isBypassingForDialog || this.isBypassingForLockTask) {
            return;
        }
        this.isViolationActive = true;
        FrameLayout frameLayout = this.mainContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
            frameLayout = null;
        }
        frameLayout.setVisibility(4);
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
        btnUnlock.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.showFreezeDialogInternal$lambda$5(etPassword, this, dialog, view);
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
    public static final void showFreezeDialogInternal$lambda$5(EditText $etPassword, final MiniGameActivity this$0, AlertDialog dialog, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        String entered = StringsKt.trim((CharSequence) $etPassword.getText().toString()).toString();
        String validPassword = this$0.getSavedExitPassword();
        if (Intrinsics.areEqual(entered, validPassword)) {
            this$0.isBypassingForLockTask = true;
            this$0.stopAlarmService();
            this$0.isViolationActive = false;
            this$0.isShowingDialog = false;
            this$0.isBypassingForDialog = false;
            FrameLayout frameLayout = this$0.mainContainer;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
                frameLayout = null;
            }
            frameLayout.setVisibility(0);
            dialog.dismiss();
            this$0.forceLockTask();
            this$0.handler.postDelayed(new Runnable() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameActivity.showFreezeDialogInternal$lambda$5$lambda$4(this.f$0);
                }
            }, 1500L);
            return;
        }
        Toast.makeText(this$0, "Password Salah!", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFreezeDialogInternal$lambda$5$lambda$4(MiniGameActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isBypassingForLockTask = false;
        if (!this$0.isAppInLockTaskMode() && !this$0.isPasswordUnlocked) {
            this$0.handleViolationOccurred();
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

    private final void showMainMenu() {
        FrameLayout frameLayout = this.mainContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(1);
        root.setGravity(17);
        root.setPadding(40, 40, 40, 40);
        TextView $this$showMainMenu_u24lambda_u249 = new TextView(this);
        $this$showMainMenu_u24lambda_u249.setText("🎮 TERIMA KASIH");
        $this$showMainMenu_u24lambda_u249.setTextSize(24.0f);
        $this$showMainMenu_u24lambda_u249.setTextColor(Color.parseColor("#38BDF8"));
        $this$showMainMenu_u24lambda_u249.setGravity(17);
        TextView $this$showMainMenu_u24lambda_u2410 = new TextView(this);
        $this$showMainMenu_u24lambda_u2410.setText("Ujian Selesai! Silakan menunggu rilis password keluar dari pengawas.");
        $this$showMainMenu_u24lambda_u2410.setTextSize(12.0f);
        $this$showMainMenu_u24lambda_u2410.setTextColor(Color.parseColor("#94A3B8"));
        $this$showMainMenu_u24lambda_u2410.setGravity(17);
        $this$showMainMenu_u24lambda_u2410.setPadding(0, 8, 0, 32);
        root.addView($this$showMainMenu_u24lambda_u249);
        root.addView($this$showMainMenu_u24lambda_u2410);
        LinearLayout btnPong = createGameCard("🏓 Pingpong Destruction", "#F59E0B", new Function0<Unit>() { // from class: com.sekolah.cbt.MiniGameActivity$showMainMenu$btnPong$1
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
                this.this$0.launchPongGameEngine();
            }
        });
        LinearLayout btnTetris = createGameCard("🧩 Tetris", "#6366F1", new Function0<Unit>() { // from class: com.sekolah.cbt.MiniGameActivity$showMainMenu$btnTetris$1
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
                this.this$0.launchTetrisGameEngine();
            }
        });
        LinearLayout btnSnake = createGameCard("🐍 Cyber Snake", "#10B981", new Function0<Unit>() { // from class: com.sekolah.cbt.MiniGameActivity$showMainMenu$btnSnake$1
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
                this.this$0.launchSnakeGameEngine();
            }
        });
        LinearLayout btnSudoku = createGameCard("🔢 Sudoku Master", "#EC4899", new Function0<Unit>() { // from class: com.sekolah.cbt.MiniGameActivity$showMainMenu$btnSudoku$1
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
                this.this$0.launchSudokuGameEngine();
            }
        });
        Button $this$showMainMenu_u24lambda_u2413 = new Button(this);
        $this$showMainMenu_u24lambda_u2413.setText("🔒 Keluar");
        $this$showMainMenu_u24lambda_u2413.setTextSize(14.0f);
        $this$showMainMenu_u24lambda_u2413.setTextColor(-1);
        $this$showMainMenu_u24lambda_u2413.setBackgroundColor(Color.parseColor("#EF4444"));
        $this$showMainMenu_u24lambda_u2413.setPadding(0, 20, 0, 20);
        LinearLayout.LayoutParams $this$showMainMenu_u24lambda_u2413_u24lambda_u2411 = new LinearLayout.LayoutParams(-1, -2);
        $this$showMainMenu_u24lambda_u2413_u24lambda_u2411.topMargin = 24;
        $this$showMainMenu_u24lambda_u2413.setLayoutParams($this$showMainMenu_u24lambda_u2413_u24lambda_u2411);
        $this$showMainMenu_u24lambda_u2413.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.showMainMenu$lambda$13$lambda$12(this.f$0, view);
            }
        });
        root.addView(btnPong);
        root.addView(btnTetris);
        root.addView(btnSnake);
        root.addView(btnSudoku);
        root.addView($this$showMainMenu_u24lambda_u2413);
        FrameLayout frameLayout2 = this.mainContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
            frameLayout2 = null;
        }
        frameLayout2.addView(root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMainMenu$lambda$13$lambda$12(MiniGameActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showExitPasswordDialog();
    }

    private final LinearLayout createGameCard(String title, String accentColor, final Function0<Unit> onClick) {
        LinearLayout $this$createGameCard_u24lambda_u2417 = new LinearLayout(this);
        $this$createGameCard_u24lambda_u2417.setOrientation(1);
        $this$createGameCard_u24lambda_u2417.setPadding(28, 24, 28, 24);
        $this$createGameCard_u24lambda_u2417.setBackgroundColor(Color.parseColor("#1E293B"));
        LinearLayout.LayoutParams $this$createGameCard_u24lambda_u2417_u24lambda_u2414 = new LinearLayout.LayoutParams(-1, -2);
        $this$createGameCard_u24lambda_u2417_u24lambda_u2414.bottomMargin = 14;
        $this$createGameCard_u24lambda_u2417.setLayoutParams($this$createGameCard_u24lambda_u2417_u24lambda_u2414);
        $this$createGameCard_u24lambda_u2417.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.createGameCard$lambda$17$lambda$15(onClick, view);
            }
        });
        TextView $this$createGameCard_u24lambda_u2417_u24lambda_u2416 = new TextView($this$createGameCard_u24lambda_u2417.getContext());
        $this$createGameCard_u24lambda_u2417_u24lambda_u2416.setText(title);
        $this$createGameCard_u24lambda_u2417_u24lambda_u2416.setTextSize(16.0f);
        $this$createGameCard_u24lambda_u2417_u24lambda_u2416.setTextColor(Color.parseColor(accentColor));
        $this$createGameCard_u24lambda_u2417.addView($this$createGameCard_u24lambda_u2417_u24lambda_u2416);
        return $this$createGameCard_u24lambda_u2417;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createGameCard$lambda$17$lambda$15(Function0 onClick, View it) {
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        onClick.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchPongGameEngine() {
        FrameLayout frameLayout = this.mainContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(1);
        LinearLayout topBar = new LinearLayout(this);
        topBar.setOrientation(0);
        topBar.setPadding(24, 20, 24, 12);
        Button $this$launchPongGameEngine_u24lambda_u2421 = new Button(this);
        $this$launchPongGameEngine_u24lambda_u2421.setText("← Menu");
        $this$launchPongGameEngine_u24lambda_u2421.setTextColor(-1);
        $this$launchPongGameEngine_u24lambda_u2421.setBackgroundColor(Color.parseColor("#334155"));
        $this$launchPongGameEngine_u24lambda_u2421.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.launchPongGameEngine$lambda$21$lambda$20(this.f$0, view);
            }
        });
        TextView $this$launchPongGameEngine_u24lambda_u2422 = new TextView(this);
        $this$launchPongGameEngine_u24lambda_u2422.setText("LVL 1 | SKOR: 0");
        $this$launchPongGameEngine_u24lambda_u2422.setTextSize(15.0f);
        $this$launchPongGameEngine_u24lambda_u2422.setTextColor(Color.parseColor("#F59E0B"));
        $this$launchPongGameEngine_u24lambda_u2422.setGravity(GravityCompat.END);
        $this$launchPongGameEngine_u24lambda_u2422.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        topBar.addView($this$launchPongGameEngine_u24lambda_u2421);
        topBar.addView($this$launchPongGameEngine_u24lambda_u2422);
        rootLayout.addView(topBar);
        FrameLayout boardFrame = new FrameLayout(this);
        boardFrame.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        final PongGameEngine $this$launchPongGameEngine_u24lambda_u2424 = new PongGameEngine(this, null, 0, 6, null);
        $this$launchPongGameEngine_u24lambda_u2424.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        $this$launchPongGameEngine_u24lambda_u2424.setOnScoreUpdated(new MiniGameActivity$launchPongGameEngine$pongEngine$1$1(this, $this$launchPongGameEngine_u24lambda_u2422));
        final Button btnRestart = new Button(this);
        btnRestart.setText("▶ MULAI GAME");
        btnRestart.setTextSize(16.0f);
        btnRestart.setTextColor(-1);
        btnRestart.setBackgroundColor(Color.parseColor("#F59E0B"));
        btnRestart.setPadding(40, 20, 40, 20);
        btnRestart.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        $this$launchPongGameEngine_u24lambda_u2424.setOnGameOver(new C27651(btnRestart));
        btnRestart.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.launchPongGameEngine$lambda$26(btnRestart, $this$launchPongGameEngine_u24lambda_u2424, view);
            }
        });
        boardFrame.addView($this$launchPongGameEngine_u24lambda_u2424);
        boardFrame.addView(btnRestart);
        rootLayout.addView(boardFrame);
        $this$launchPongGameEngine_u24lambda_u2424.setOnTouchListener(new View.OnTouchListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return MiniGameActivity.launchPongGameEngine$lambda$27($this$launchPongGameEngine_u24lambda_u2424, view, motionEvent);
            }
        });
        FrameLayout frameLayout2 = this.mainContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
            frameLayout2 = null;
        }
        frameLayout2.addView(rootLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchPongGameEngine$lambda$21$lambda$20(MiniGameActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showMainMenu();
    }

    /* compiled from: MiniGameActivity.kt */
    @Metadata(m164d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m165d2 = {"<anonymous>", "", "invoke"}, m166k = 3, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: com.sekolah.cbt.MiniGameActivity$launchPongGameEngine$1 */
    static final class C27651 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Button $btnRestart;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27651(Button button) {
            super(0);
            this.$btnRestart = button;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(Button btnRestart) {
            Intrinsics.checkNotNullParameter(btnRestart, "$btnRestart");
            btnRestart.setText("GAME OVER! MULAI ULANG");
            btnRestart.setBackgroundColor(Color.parseColor("#EF4444"));
            btnRestart.setVisibility(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MiniGameActivity miniGameActivity = MiniGameActivity.this;
            final Button button = this.$btnRestart;
            miniGameActivity.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.MiniGameActivity$launchPongGameEngine$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameActivity.C27651.invoke$lambda$0(button);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchPongGameEngine$lambda$26(Button btnRestart, PongGameEngine pongEngine, View it) {
        Intrinsics.checkNotNullParameter(btnRestart, "$btnRestart");
        Intrinsics.checkNotNullParameter(pongEngine, "$pongEngine");
        btnRestart.setVisibility(8);
        pongEngine.startGame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean launchPongGameEngine$lambda$27(PongGameEngine pongEngine, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(pongEngine, "$pongEngine");
        if (event.getAction() == 2 || event.getAction() == 0) {
            pongEngine.updatePaddleTouch(event.getX());
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchTetrisGameEngine() {
        FrameLayout frameLayout = this.mainContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(1);
        LinearLayout topBar = new LinearLayout(this);
        topBar.setOrientation(0);
        topBar.setPadding(24, 20, 24, 12);
        Button $this$launchTetrisGameEngine_u24lambda_u2431 = new Button(this);
        $this$launchTetrisGameEngine_u24lambda_u2431.setText("← Menu");
        $this$launchTetrisGameEngine_u24lambda_u2431.setTextColor(-1);
        $this$launchTetrisGameEngine_u24lambda_u2431.setBackgroundColor(Color.parseColor("#334155"));
        $this$launchTetrisGameEngine_u24lambda_u2431.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.launchTetrisGameEngine$lambda$31$lambda$30(this.f$0, view);
            }
        });
        TextView $this$launchTetrisGameEngine_u24lambda_u2432 = new TextView(this);
        $this$launchTetrisGameEngine_u24lambda_u2432.setText("SKOR: 0");
        $this$launchTetrisGameEngine_u24lambda_u2432.setTextSize(16.0f);
        $this$launchTetrisGameEngine_u24lambda_u2432.setTextColor(Color.parseColor("#6366F1"));
        $this$launchTetrisGameEngine_u24lambda_u2432.setGravity(GravityCompat.END);
        $this$launchTetrisGameEngine_u24lambda_u2432.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        topBar.addView($this$launchTetrisGameEngine_u24lambda_u2431);
        topBar.addView($this$launchTetrisGameEngine_u24lambda_u2432);
        rootLayout.addView(topBar);
        FrameLayout boardFrame = new FrameLayout(this);
        boardFrame.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        final TetrisGameEngine $this$launchTetrisGameEngine_u24lambda_u2434 = new TetrisGameEngine(this, null, 0, 6, null);
        $this$launchTetrisGameEngine_u24lambda_u2434.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        $this$launchTetrisGameEngine_u24lambda_u2434.setOnScoreUpdated(new MiniGameActivity$launchTetrisGameEngine$tetrisEngine$1$1(this, $this$launchTetrisGameEngine_u24lambda_u2432));
        final Button btnRestart = new Button(this);
        btnRestart.setText("▶ MULAI GAME");
        btnRestart.setTextSize(16.0f);
        btnRestart.setTextColor(-1);
        btnRestart.setBackgroundColor(Color.parseColor("#6366F1"));
        btnRestart.setPadding(40, 20, 40, 20);
        btnRestart.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        $this$launchTetrisGameEngine_u24lambda_u2434.setOnGameOver(new C27691(btnRestart));
        btnRestart.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.launchTetrisGameEngine$lambda$36(btnRestart, $this$launchTetrisGameEngine_u24lambda_u2434, view);
            }
        });
        LinearLayout ctrlLayout = new LinearLayout(this);
        ctrlLayout.setOrientation(0);
        ctrlLayout.setGravity(17);
        ctrlLayout.setPadding(12, 12, 12, 20);
        Button $this$launchTetrisGameEngine_u24lambda_u2439 = new Button(this);
        $this$launchTetrisGameEngine_u24lambda_u2439.setText("◄");
        $this$launchTetrisGameEngine_u24lambda_u2439.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.launchTetrisGameEngine$lambda$39$lambda$38($this$launchTetrisGameEngine_u24lambda_u2434, view);
            }
        });
        Button $this$launchTetrisGameEngine_u24lambda_u2441 = new Button(this);
        $this$launchTetrisGameEngine_u24lambda_u2441.setText("🔄 ROTATE");
        $this$launchTetrisGameEngine_u24lambda_u2441.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.launchTetrisGameEngine$lambda$41$lambda$40($this$launchTetrisGameEngine_u24lambda_u2434, view);
            }
        });
        Button $this$launchTetrisGameEngine_u24lambda_u2443 = new Button(this);
        $this$launchTetrisGameEngine_u24lambda_u2443.setText("►");
        $this$launchTetrisGameEngine_u24lambda_u2443.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.launchTetrisGameEngine$lambda$43$lambda$42($this$launchTetrisGameEngine_u24lambda_u2434, view);
            }
        });
        Button $this$launchTetrisGameEngine_u24lambda_u2445 = new Button(this);
        $this$launchTetrisGameEngine_u24lambda_u2445.setText("▼");
        $this$launchTetrisGameEngine_u24lambda_u2445.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.launchTetrisGameEngine$lambda$45$lambda$44($this$launchTetrisGameEngine_u24lambda_u2434, view);
            }
        });
        ctrlLayout.addView($this$launchTetrisGameEngine_u24lambda_u2439);
        ctrlLayout.addView($this$launchTetrisGameEngine_u24lambda_u2441);
        ctrlLayout.addView($this$launchTetrisGameEngine_u24lambda_u2443);
        ctrlLayout.addView($this$launchTetrisGameEngine_u24lambda_u2445);
        boardFrame.addView($this$launchTetrisGameEngine_u24lambda_u2434);
        boardFrame.addView(btnRestart);
        rootLayout.addView(boardFrame);
        rootLayout.addView(ctrlLayout);
        FrameLayout frameLayout2 = this.mainContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
            frameLayout2 = null;
        }
        frameLayout2.addView(rootLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchTetrisGameEngine$lambda$31$lambda$30(MiniGameActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showMainMenu();
    }

    /* compiled from: MiniGameActivity.kt */
    @Metadata(m164d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m165d2 = {"<anonymous>", "", "invoke"}, m166k = 3, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: com.sekolah.cbt.MiniGameActivity$launchTetrisGameEngine$1 */
    static final class C27691 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Button $btnRestart;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27691(Button button) {
            super(0);
            this.$btnRestart = button;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(Button btnRestart) {
            Intrinsics.checkNotNullParameter(btnRestart, "$btnRestart");
            btnRestart.setText("GAME OVER! RESTART");
            btnRestart.setBackgroundColor(Color.parseColor("#EF4444"));
            btnRestart.setVisibility(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MiniGameActivity miniGameActivity = MiniGameActivity.this;
            final Button button = this.$btnRestart;
            miniGameActivity.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.MiniGameActivity$launchTetrisGameEngine$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameActivity.C27691.invoke$lambda$0(button);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchTetrisGameEngine$lambda$36(Button btnRestart, TetrisGameEngine tetrisEngine, View it) {
        Intrinsics.checkNotNullParameter(btnRestart, "$btnRestart");
        Intrinsics.checkNotNullParameter(tetrisEngine, "$tetrisEngine");
        btnRestart.setVisibility(8);
        tetrisEngine.resetGame();
        tetrisEngine.startGame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchTetrisGameEngine$lambda$39$lambda$38(TetrisGameEngine tetrisEngine, View it) {
        Intrinsics.checkNotNullParameter(tetrisEngine, "$tetrisEngine");
        tetrisEngine.moveLeft();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchTetrisGameEngine$lambda$41$lambda$40(TetrisGameEngine tetrisEngine, View it) {
        Intrinsics.checkNotNullParameter(tetrisEngine, "$tetrisEngine");
        tetrisEngine.rotate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchTetrisGameEngine$lambda$43$lambda$42(TetrisGameEngine tetrisEngine, View it) {
        Intrinsics.checkNotNullParameter(tetrisEngine, "$tetrisEngine");
        tetrisEngine.moveRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchTetrisGameEngine$lambda$45$lambda$44(TetrisGameEngine tetrisEngine, View it) {
        Intrinsics.checkNotNullParameter(tetrisEngine, "$tetrisEngine");
        tetrisEngine.moveDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchSnakeGameEngine() {
        FrameLayout frameLayout = this.mainContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(1);
        LinearLayout topBar = new LinearLayout(this);
        topBar.setOrientation(0);
        topBar.setPadding(24, 20, 24, 12);
        Button $this$launchSnakeGameEngine_u24lambda_u2449 = new Button(this);
        $this$launchSnakeGameEngine_u24lambda_u2449.setText("← Menu");
        $this$launchSnakeGameEngine_u24lambda_u2449.setTextColor(-1);
        $this$launchSnakeGameEngine_u24lambda_u2449.setBackgroundColor(Color.parseColor("#334155"));
        $this$launchSnakeGameEngine_u24lambda_u2449.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.launchSnakeGameEngine$lambda$49$lambda$48(this.f$0, view);
            }
        });
        TextView $this$launchSnakeGameEngine_u24lambda_u2450 = new TextView(this);
        $this$launchSnakeGameEngine_u24lambda_u2450.setText("SKOR: 0");
        $this$launchSnakeGameEngine_u24lambda_u2450.setTextSize(16.0f);
        $this$launchSnakeGameEngine_u24lambda_u2450.setTextColor(Color.parseColor("#10B981"));
        $this$launchSnakeGameEngine_u24lambda_u2450.setGravity(GravityCompat.END);
        $this$launchSnakeGameEngine_u24lambda_u2450.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        topBar.addView($this$launchSnakeGameEngine_u24lambda_u2449);
        topBar.addView($this$launchSnakeGameEngine_u24lambda_u2450);
        rootLayout.addView(topBar);
        FrameLayout boardFrame = new FrameLayout(this);
        boardFrame.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        final CyberSnakeEngine $this$launchSnakeGameEngine_u24lambda_u2452 = new CyberSnakeEngine(this, null, 0, 6, null);
        $this$launchSnakeGameEngine_u24lambda_u2452.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        $this$launchSnakeGameEngine_u24lambda_u2452.setOnScoreUpdated(new MiniGameActivity$launchSnakeGameEngine$snakeEngine$1$1(this, $this$launchSnakeGameEngine_u24lambda_u2450));
        final Button btnRestart = new Button(this);
        btnRestart.setText("▶ MULAI GAME");
        btnRestart.setTextSize(16.0f);
        btnRestart.setTextColor(-1);
        btnRestart.setBackgroundColor(Color.parseColor("#10B981"));
        btnRestart.setPadding(40, 20, 40, 20);
        btnRestart.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        $this$launchSnakeGameEngine_u24lambda_u2452.setOnGameOver(new C27661(btnRestart));
        btnRestart.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.launchSnakeGameEngine$lambda$54(btnRestart, $this$launchSnakeGameEngine_u24lambda_u2452, view);
            }
        });
        boardFrame.addView($this$launchSnakeGameEngine_u24lambda_u2452);
        boardFrame.addView(btnRestart);
        rootLayout.addView(boardFrame);
        $this$launchSnakeGameEngine_u24lambda_u2452.setOnTouchListener(new View.OnTouchListener() { // from class: com.sekolah.cbt.MiniGameActivity.launchSnakeGameEngine.3
            private float downX;
            private float downY;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event.getAction() == 0) {
                    this.downX = event.getX();
                    this.downY = event.getY();
                    return true;
                }
                if (event.getAction() == 1) {
                    float deltaX = event.getX() - this.downX;
                    float deltaY = event.getY() - this.downY;
                    if (Math.abs(deltaX) > Math.abs(deltaY)) {
                        if (deltaX > 40.0f) {
                            $this$launchSnakeGameEngine_u24lambda_u2452.setDirection(1, 0);
                        } else if (deltaX < -40.0f) {
                            $this$launchSnakeGameEngine_u24lambda_u2452.setDirection(-1, 0);
                        }
                    } else if (deltaY > 40.0f) {
                        $this$launchSnakeGameEngine_u24lambda_u2452.setDirection(0, 1);
                    } else if (deltaY < -40.0f) {
                        $this$launchSnakeGameEngine_u24lambda_u2452.setDirection(0, -1);
                    }
                }
                return true;
            }
        });
        FrameLayout frameLayout2 = this.mainContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
            frameLayout2 = null;
        }
        frameLayout2.addView(rootLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchSnakeGameEngine$lambda$49$lambda$48(MiniGameActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showMainMenu();
    }

    /* compiled from: MiniGameActivity.kt */
    @Metadata(m164d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m165d2 = {"<anonymous>", "", "invoke"}, m166k = 3, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: com.sekolah.cbt.MiniGameActivity$launchSnakeGameEngine$1 */
    static final class C27661 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Button $btnRestart;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27661(Button button) {
            super(0);
            this.$btnRestart = button;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(Button btnRestart) {
            Intrinsics.checkNotNullParameter(btnRestart, "$btnRestart");
            btnRestart.setText("GAME OVER! MULAI ULANG");
            btnRestart.setBackgroundColor(Color.parseColor("#EF4444"));
            btnRestart.setVisibility(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MiniGameActivity miniGameActivity = MiniGameActivity.this;
            final Button button = this.$btnRestart;
            miniGameActivity.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.MiniGameActivity$launchSnakeGameEngine$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameActivity.C27661.invoke$lambda$0(button);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchSnakeGameEngine$lambda$54(Button btnRestart, CyberSnakeEngine snakeEngine, View it) {
        Intrinsics.checkNotNullParameter(btnRestart, "$btnRestart");
        Intrinsics.checkNotNullParameter(snakeEngine, "$snakeEngine");
        btnRestart.setVisibility(8);
        snakeEngine.startGame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchSudokuGameEngine() {
        FrameLayout frameLayout = this.mainContainer;
        String str = "mainContainer";
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(1);
        rootLayout.setBackgroundColor(Color.parseColor("#F8FAFC"));
        LinearLayout topBar = new LinearLayout(this);
        topBar.setOrientation(0);
        topBar.setPadding(24, 20, 24, 12);
        Button $this$launchSudokuGameEngine_u24lambda_u2458 = new Button(this);
        $this$launchSudokuGameEngine_u24lambda_u2458.setText("← Menu");
        $this$launchSudokuGameEngine_u24lambda_u2458.setTextColor(-1);
        $this$launchSudokuGameEngine_u24lambda_u2458.setBackgroundColor(Color.parseColor("#475569"));
        $this$launchSudokuGameEngine_u24lambda_u2458.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.launchSudokuGameEngine$lambda$58$lambda$57(this.f$0, view);
            }
        });
        TextView $this$launchSudokuGameEngine_u24lambda_u2459 = new TextView(this);
        $this$launchSudokuGameEngine_u24lambda_u2459.setText("SUDOKU PUZZLE");
        $this$launchSudokuGameEngine_u24lambda_u2459.setTextSize(16.0f);
        $this$launchSudokuGameEngine_u24lambda_u2459.setTextColor(Color.parseColor("#0284C7"));
        $this$launchSudokuGameEngine_u24lambda_u2459.setGravity(GravityCompat.END);
        $this$launchSudokuGameEngine_u24lambda_u2459.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        topBar.addView($this$launchSudokuGameEngine_u24lambda_u2458);
        topBar.addView($this$launchSudokuGameEngine_u24lambda_u2459);
        rootLayout.addView(topBar);
        FrameLayout boardFrame = new FrameLayout(this);
        boardFrame.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        final SudokuGameEngine $this$launchSudokuGameEngine_u24lambda_u2461 = new SudokuGameEngine(this, null, 0, 6, null);
        $this$launchSudokuGameEngine_u24lambda_u2461.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        $this$launchSudokuGameEngine_u24lambda_u2461.setOnScoreUpdated(new MiniGameActivity$launchSudokuGameEngine$sudokuEngine$1$1(this, $this$launchSudokuGameEngine_u24lambda_u2459));
        final Button btnRestart = new Button(this);
        btnRestart.setText("▶ MULAI GAME");
        btnRestart.setTextSize(16.0f);
        btnRestart.setTextColor(-1);
        btnRestart.setBackgroundColor(Color.parseColor("#0284C7"));
        btnRestart.setPadding(40, 20, 40, 20);
        btnRestart.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        $this$launchSudokuGameEngine_u24lambda_u2461.setOnGameOver(new C27681(btnRestart));
        btnRestart.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameActivity.launchSudokuGameEngine$lambda$63(btnRestart, $this$launchSudokuGameEngine_u24lambda_u2461, view);
            }
        });
        boardFrame.addView($this$launchSudokuGameEngine_u24lambda_u2461);
        boardFrame.addView(btnRestart);
        rootLayout.addView(boardFrame);
        LinearLayout padLayout = new LinearLayout(this);
        padLayout.setOrientation(0);
        padLayout.setGravity(17);
        padLayout.setPadding(8, 12, 8, 20);
        final int num = 1;
        while (num < 10) {
            Button $this$launchSudokuGameEngine_u24lambda_u2467 = new Button(this);
            $this$launchSudokuGameEngine_u24lambda_u2467.setText(String.valueOf(num));
            $this$launchSudokuGameEngine_u24lambda_u2467.setTextSize(18.0f);
            $this$launchSudokuGameEngine_u24lambda_u2467.setTextColor(Color.parseColor("#0F172A"));
            $this$launchSudokuGameEngine_u24lambda_u2467.setBackgroundColor(Color.parseColor("#E2E8F0"));
            LinearLayout.LayoutParams $this$launchSudokuGameEngine_u24lambda_u2467_u24lambda_u2465 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            $this$launchSudokuGameEngine_u24lambda_u2467_u24lambda_u2465.setMarginEnd(4);
            $this$launchSudokuGameEngine_u24lambda_u2467.setLayoutParams($this$launchSudokuGameEngine_u24lambda_u2467_u24lambda_u2465);
            $this$launchSudokuGameEngine_u24lambda_u2467.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniGameActivity.launchSudokuGameEngine$lambda$67$lambda$66($this$launchSudokuGameEngine_u24lambda_u2461, num, view);
                }
            });
            padLayout.addView($this$launchSudokuGameEngine_u24lambda_u2467);
            num++;
            str = str;
            topBar = topBar;
        }
        String str2 = str;
        rootLayout.addView(padLayout);
        FrameLayout frameLayout2 = this.mainContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            frameLayout2 = null;
        }
        frameLayout2.addView(rootLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchSudokuGameEngine$lambda$58$lambda$57(MiniGameActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showMainMenu();
    }

    /* compiled from: MiniGameActivity.kt */
    @Metadata(m164d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m165d2 = {"<anonymous>", "", "invoke"}, m166k = 3, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: com.sekolah.cbt.MiniGameActivity$launchSudokuGameEngine$1 */
    static final class C27681 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Button $btnRestart;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27681(Button button) {
            super(0);
            this.$btnRestart = button;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(Button btnRestart) {
            Intrinsics.checkNotNullParameter(btnRestart, "$btnRestart");
            btnRestart.setText("SELAMAT! MAIN LAGI");
            btnRestart.setBackgroundColor(Color.parseColor("#16A34A"));
            btnRestart.setVisibility(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MiniGameActivity miniGameActivity = MiniGameActivity.this;
            final Button button = this.$btnRestart;
            miniGameActivity.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.MiniGameActivity$launchSudokuGameEngine$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameActivity.C27681.invoke$lambda$0(button);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchSudokuGameEngine$lambda$63(Button btnRestart, SudokuGameEngine sudokuEngine, View it) {
        Intrinsics.checkNotNullParameter(btnRestart, "$btnRestart");
        Intrinsics.checkNotNullParameter(sudokuEngine, "$sudokuEngine");
        btnRestart.setVisibility(8);
        sudokuEngine.startGame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchSudokuGameEngine$lambda$67$lambda$66(SudokuGameEngine sudokuEngine, int $num, View it) {
        Intrinsics.checkNotNullParameter(sudokuEngine, "$sudokuEngine");
        sudokuEngine.inputNumber($num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showExitPasswordDialog() {
        if (this.isShowingDialog || isFinishing() || isDestroyed()) {
            return;
        }
        this.isShowingDialog = true;
        this.isBypassingForDialog = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(1);
        layout.setPadding(50, 40, 50, 40);
        layout.setBackgroundColor(Color.parseColor("#1E293B"));
        TextView $this$showExitPasswordDialog_u24lambda_u2469 = new TextView(this);
        $this$showExitPasswordDialog_u24lambda_u2469.setText("Masukkan Password");
        $this$showExitPasswordDialog_u24lambda_u2469.setTextSize(18.0f);
        $this$showExitPasswordDialog_u24lambda_u2469.setTextColor(-1);
        $this$showExitPasswordDialog_u24lambda_u2469.setPadding(0, 0, 0, 24);
        final EditText $this$showExitPasswordDialog_u24lambda_u2470 = new EditText(this);
        $this$showExitPasswordDialog_u24lambda_u2470.setHint("Password");
        $this$showExitPasswordDialog_u24lambda_u2470.setHintTextColor(Color.parseColor("#9CA3AF"));
        $this$showExitPasswordDialog_u24lambda_u2470.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        $this$showExitPasswordDialog_u24lambda_u2470.setBackgroundColor(-1);
        $this$showExitPasswordDialog_u24lambda_u2470.setPadding(32, 24, 32, 24);
        $this$showExitPasswordDialog_u24lambda_u2470.setInputType(129);
        layout.addView($this$showExitPasswordDialog_u24lambda_u2469);
        layout.addView($this$showExitPasswordDialog_u24lambda_u2470);
        builder.setView(layout).setCancelable(false);
        builder.setPositiveButton("Buka Kunci", new DialogInterface.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MiniGameActivity.showExitPasswordDialog$lambda$71($this$showExitPasswordDialog_u24lambda_u2470, this, dialogInterface, i);
            }
        });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() { // from class: com.sekolah.cbt.MiniGameActivity$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MiniGameActivity.showExitPasswordDialog$lambda$72(this.f$0, dialogInterface, i);
            }
        });
        AlertDialog dialog = builder.create();
        Intrinsics.checkNotNullExpressionValue(dialog, "create(...)");
        try {
            ExamActivityKt.showSecurely(dialog, this);
        } catch (Exception e) {
            e.printStackTrace();
            this.isShowingDialog = false;
            this.isBypassingForDialog = false;
        }
        Button button = dialog.getButton(-1);
        if (button != null) {
            button.setTextColor(Color.parseColor("#38BDF8"));
        }
        Button button2 = dialog.getButton(-2);
        if (button2 != null) {
            button2.setTextColor(Color.parseColor("#EF4444"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExitPasswordDialog$lambda$71(EditText etInputPassword, MiniGameActivity this$0, DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(etInputPassword, "$etInputPassword");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String enteredPassword = StringsKt.trim((CharSequence) etInputPassword.getText().toString()).toString();
        String validPassword = this$0.getSavedExitPassword();
        if (Intrinsics.areEqual(enteredPassword, validPassword)) {
            this$0.isPasswordUnlocked = true;
            this$0.isShowingDialog = false;
            this$0.isBypassingForDialog = false;
            dialog.dismiss();
            this$0.exitToLogin();
            return;
        }
        Toast.makeText(this$0, "Password Salah!", 0).show();
        this$0.isShowingDialog = false;
        this$0.isBypassingForDialog = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExitPasswordDialog$lambda$72(MiniGameActivity this$0, DialogInterface dialog, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isShowingDialog = false;
        this$0.isBypassingForDialog = false;
        dialog.dismiss();
        this$0.forceLockTask();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!hasFocus && !this.isPasswordUnlocked && !this.isBypassingForLockTask && !this.isBypassingForDialog && Build.VERSION.SDK_INT < 31) {
            try {
                Intent closeIntent = new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS");
                sendBroadcast(closeIntent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.isPasswordUnlocked || this.isShowingDialog || this.isBypassingForDialog || this.isViolationActive || this.isBypassingForLockTask) {
            return;
        }
        if (!hasFocus) {
            handleViolationOccurred();
        } else {
            forceLockTask();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.isPasswordUnlocked && !this.isBypassingForLockTask && !this.isBypassingForDialog) {
            forceLockTask();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (!this.isPasswordUnlocked && !this.isBypassingForLockTask && !this.isBypassingForDialog) {
            triggerViolationAlarm();
            handleViolationOccurred();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (!this.isPasswordUnlocked && !this.isBypassingForLockTask && !this.isBypassingForDialog) {
            handleViolationOccurred();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (!this.isPasswordUnlocked && !this.isBypassingForLockTask && !this.isBypassingForDialog) {
            triggerViolationAlarm();
            handleViolationOccurred();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        boolean isObscured = (ev.getFlags() & 1) != 0;
        if (isObscured) {
            if (!this.isViolationActive && !this.isPasswordUnlocked && !this.isBypassingForLockTask && !this.isBypassingForDialog) {
                handleViolationOccurred();
            }
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    private final void exitToLogin() {
        ExamState.INSTANCE.resetAll();
        ExamSessionManager.INSTANCE.clearSession(this);
        new UserSession(this).clearSession();
        Runnable it = this.strictSecurityCheckRunnable;
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Runnable it = this.strictSecurityCheckRunnable;
        if (it != null) {
            this.handler.removeCallbacks(it);
        }
        this.bgThread.quitSafely();
    }
}
