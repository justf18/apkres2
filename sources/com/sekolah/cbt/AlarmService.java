package com.sekolah.cbt;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlarmService.kt */
@Metadata(m164d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m165d2 = {"Lcom/sekolah/cbt/AlarmService;", "Landroid/app/Service;", "()V", "audioFocusRequest", "Landroid/media/AudioFocusRequest;", "handler", "Landroid/os/Handler;", "isStopRequested", "", "mediaPlayer", "Landroid/media/MediaPlayer;", "volumeEnforcerRunnable", "Ljava/lang/Runnable;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onDestroy", "", "onStartCommand", "", "flags", "startId", "onTaskRemoved", "rootIntent", "playAlarm", "requestAudioFocus", "routePlayerToSpeaker", "player", "scheduleServiceRestart", "startForegroundServiceNotification", "startVolumeEnforcer", "stopAlarm", "stopAlarmOnlyPlayer", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AlarmService extends Service {
    public static final int $stable = 8;
    private AudioFocusRequest audioFocusRequest;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private volatile boolean isStopRequested;
    private MediaPlayer mediaPlayer;
    private Runnable volumeEnforcerRunnable;

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent != null ? intent.getAction() : null;
        if (Intrinsics.areEqual(action, "STOP_ALARM")) {
            this.isStopRequested = true;
            stopAlarm();
            try {
                stopForeground(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            stopSelf();
            return 2;
        }
        this.isStopRequested = false;
        startForegroundServiceNotification();
        requestAudioFocus();
        playAlarm();
        startVolumeEnforcer();
        return 1;
    }

    private final void routePlayerToSpeaker(MediaPlayer player) {
        Object element$iv;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Object systemService = getSystemService("audio");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                AudioManager am = (AudioManager) systemService;
                Object[] devices = am.getDevices(2);
                Intrinsics.checkNotNullExpressionValue(devices, "getDevices(...)");
                Object[] $this$firstOrNull$iv = devices;
                int length = $this$firstOrNull$iv.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        element$iv = $this$firstOrNull$iv[i];
                        AudioDeviceInfo it = (AudioDeviceInfo) element$iv;
                        if (it.getType() == 2) {
                            break;
                        } else {
                            i++;
                        }
                    } else {
                        element$iv = null;
                        break;
                    }
                }
                AudioDeviceInfo speaker = (AudioDeviceInfo) element$iv;
                if (speaker != null) {
                    player.setPreferredDevice(speaker);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private final void requestAudioFocus() {
        Object systemService = getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(4).setContentType(4).build();
        if (Build.VERSION.SDK_INT < 26) {
            audioManager.requestAudioFocus(null, 4, 4);
            return;
        }
        this.audioFocusRequest = new AudioFocusRequest.Builder(4).setAudioAttributes(audioAttributes).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(new AudioManager.OnAudioFocusChangeListener() { // from class: com.sekolah.cbt.AlarmService$$ExternalSyntheticLambda1
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i) {
                AlarmService.requestAudioFocus$lambda$2(this.f$0, i);
            }
        }).build();
        AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
        Intrinsics.checkNotNull(audioFocusRequest);
        audioManager.requestAudioFocus(audioFocusRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestAudioFocus$lambda$2(final AlarmService this$0, int focusChange) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (focusChange) {
            case -2:
            case -1:
                this$0.handler.postDelayed(new Runnable() { // from class: com.sekolah.cbt.AlarmService$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AlarmService.requestAudioFocus$lambda$2$lambda$1(this.f$0);
                    }
                }, 300L);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestAudioFocus$lambda$2$lambda$1(AlarmService this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestAudioFocus();
    }

    private final synchronized void playAlarm() {
        try {
            stopAlarmOnlyPlayer();
            AudioAttributes attrs = new AudioAttributes.Builder().setUsage(4).setContentType(4).build();
            MediaPlayer $this$playAlarm_u24lambda_u243 = MediaPlayer.create(this, C2772R.raw.alarm_sound, attrs, 0);
            if ($this$playAlarm_u24lambda_u243 != null) {
                $this$playAlarm_u24lambda_u243.setLooping(true);
                routePlayerToSpeaker($this$playAlarm_u24lambda_u243);
                $this$playAlarm_u24lambda_u243.start();
            } else {
                $this$playAlarm_u24lambda_u243 = null;
            }
            this.mediaPlayer = $this$playAlarm_u24lambda_u243;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void startVolumeEnforcer() {
        Object systemService = getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        final AudioManager audioManager = (AudioManager) systemService;
        try {
            audioManager.setRingerMode(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Runnable it = this.volumeEnforcerRunnable;
        if (it != null) {
            this.handler.removeCallbacks(it);
        }
        this.volumeEnforcerRunnable = new Runnable() { // from class: com.sekolah.cbt.AlarmService.startVolumeEnforcer.2
            @Override // java.lang.Runnable
            public void run() {
                if (!AlarmService.this.isStopRequested) {
                    try {
                        int maxMusicVol = audioManager.getStreamMaxVolume(3);
                        int maxAlarmVol = audioManager.getStreamMaxVolume(4);
                        audioManager.setStreamVolume(3, maxMusicVol, 0);
                        audioManager.setStreamVolume(4, maxAlarmVol, 0);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    AlarmService.this.handler.postDelayed(this, 400L);
                }
            }
        };
        Handler handler = this.handler;
        Runnable runnable = this.volumeEnforcerRunnable;
        Intrinsics.checkNotNull(runnable);
        handler.post(runnable);
    }

    private final void stopAlarmOnlyPlayer() throws IllegalStateException {
        try {
            MediaPlayer it = this.mediaPlayer;
            if (it != null) {
                if (it.isPlaying()) {
                    it.stop();
                }
                it.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mediaPlayer = null;
    }

    private final synchronized void stopAlarm() {
        Runnable it = this.volumeEnforcerRunnable;
        if (it != null) {
            this.handler.removeCallbacks(it);
        }
        stopAlarmOnlyPlayer();
        Object systemService = getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest it2 = this.audioFocusRequest;
            if (it2 != null) {
                audioManager.abandonAudioFocusRequest(it2);
            }
        } else {
            audioManager.abandonAudioFocus(null);
        }
    }

    private final void startForegroundServiceNotification() {
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager manager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel channel = new NotificationChannel("CBT_ALARM_CHANNEL", "CBT Security Alarm", 4);
            channel.setSound(null, null);
            manager.createNotificationChannel(channel);
        }
        Intent notificationIntent = new Intent(this, (Class<?>) ExamActivity.class);
        notificationIntent.setFlags(335544320);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 201326592);
        int foregroundType = 2;
        Notification notification = new NotificationCompat.Builder(this, "CBT_ALARM_CHANNEL").setContentTitle("PERINGATAN KECURANGAN CBT").setContentText("Aplikasi dikunci! Masukkan password proktor untuk mematikan alarm.").setSmallIcon(C2772R.mipmap.ic_launcher).setPriority(2).setCategory(NotificationCompat.CATEGORY_ALARM).setContentIntent(pendingIntent).setOngoing(true).build();
        Intrinsics.checkNotNullExpressionValue(notification, "build(...)");
        if (Build.VERSION.SDK_INT >= 29) {
            if (Build.VERSION.SDK_INT >= 34) {
                foregroundType = BasicMeasure.EXACTLY;
            }
            startForeground(TypedValues.TYPE_TARGET, notification, foregroundType);
            return;
        }
        startForeground(TypedValues.TYPE_TARGET, notification);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (!this.isStopRequested && !ExamSessionManager.INSTANCE.isExamFinished(this)) {
            scheduleServiceRestart();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        stopAlarm();
        if (!this.isStopRequested && !ExamSessionManager.INSTANCE.isExamFinished(this)) {
            scheduleServiceRestart();
        }
        super.onDestroy();
    }

    private final void scheduleServiceRestart() {
        if (ExamSessionManager.INSTANCE.isExamFinished(this)) {
            return;
        }
        Intent restartServiceIntent = new Intent(getApplicationContext(), (Class<?>) AlarmRestarterReceiver.class);
        restartServiceIntent.setAction("com.sekolah.cbt.RESTART_ALARM");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1, restartServiceIntent, 1140850688);
        Object systemService = getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        Intent showIntent = new Intent(getApplicationContext(), (Class<?>) ExamActivity.class);
        PendingIntent showPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, showIntent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        AlarmManager.AlarmClockInfo alarmClockInfo = new AlarmManager.AlarmClockInfo(System.currentTimeMillis() + 100, showPendingIntent);
        alarmManager.setAlarmClock(alarmClockInfo, pendingIntent);
    }
}
