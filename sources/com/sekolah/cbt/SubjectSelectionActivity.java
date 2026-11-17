package com.sekolah.cbt;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sekolah.cbt.ServerConfig;
import com.sekolah.cbt.SubjectSelectionActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SubjectSelectionActivity.kt */
@Metadata(m164d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0011H\u0014J \u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m165d2 = {"Lcom/sekolah/cbt/SubjectSelectionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/sekolah/cbt/SubjectSelectionActivity$ExamAdapter;", "blockedMediaPlayer", "Landroid/media/MediaPlayer;", "examList", "", "Lcom/sekolah/cbt/SubjectSelectionActivity$ExamItem;", "rvSubjectList", "Landroidx/recyclerview/widget/RecyclerView;", "studentClass", "", "studentName", "studentNisn", "checkSubmissionAndOpen", "", "examId", "", "subjectName", "url", "fetchExamsFromSupabase", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "openExam", "playBlockedSound", "ExamAdapter", "ExamItem", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class SubjectSelectionActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private ExamAdapter adapter;
    private MediaPlayer blockedMediaPlayer;
    private RecyclerView rvSubjectList;
    private String studentNisn = "";
    private String studentClass = "";
    private String studentName = "Siswa";
    private final List<ExamItem> examList = new ArrayList();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C2772R.layout.activity_subject_selection);
        ExamState.INSTANCE.resetAll();
        UserSession session = new UserSession(this);
        SharedPreferences sharedPref = getSharedPreferences("CBT_USER_DATA", 0);
        String string = sharedPref.getString("STUDENT_NISN", "");
        String savedNisn = string != null ? string : "";
        String string2 = sharedPref.getString("STUDENT_CLASS", "X-1");
        String savedClass = string2 != null ? string2 : "X-1";
        String string3 = sharedPref.getString("STUDENT_NAME", "Siswa");
        String savedName = string3 != null ? string3 : "Siswa";
        String nisn = session.getNisn();
        if (nisn.length() == 0) {
            String stringExtra = getIntent().getStringExtra("STUDENT_NISN");
            if (stringExtra == null) {
                stringExtra = savedNisn;
            }
            Intrinsics.checkNotNull(stringExtra);
            nisn = stringExtra;
        }
        this.studentNisn = nisn;
        String str = session.getClass();
        if (str.length() == 0) {
            String stringExtra2 = getIntent().getStringExtra("STUDENT_CLASS");
            if (stringExtra2 == null) {
                stringExtra2 = savedClass;
            }
            Intrinsics.checkNotNull(stringExtra2);
            str = stringExtra2;
        }
        this.studentClass = str;
        String name = session.getName();
        if (name.length() == 0) {
            name = getIntent().getStringExtra("STUDENT_NAME");
            if (name == null) {
                name = savedName;
            }
            Intrinsics.checkNotNull(name);
        }
        this.studentName = name;
        ((TextView) findViewById(C2772R.id.tvHeaderGrade)).setText("Pilihan Soal • Rombel " + this.studentClass);
        ((TextView) findViewById(C2772R.id.tvStudentClassInfo)).setText(this.studentName + " • Kelas: " + this.studentClass + " • NISN: " + this.studentNisn);
        View viewFindViewById = findViewById(C2772R.id.rvSubjectList);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rvSubjectList = (RecyclerView) viewFindViewById;
        RecyclerView recyclerView = this.rvSubjectList;
        ExamAdapter examAdapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvSubjectList");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new ExamAdapter(this, this.examList, new Function1<ExamItem, Unit>() { // from class: com.sekolah.cbt.SubjectSelectionActivity.onCreate.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExamItem examItem) {
                invoke2(examItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExamItem exam) {
                Intrinsics.checkNotNullParameter(exam, "exam");
                SubjectSelectionActivity.this.checkSubmissionAndOpen(exam.getId(), exam.getSubjectName(), exam.getFormUrl());
            }
        });
        RecyclerView recyclerView2 = this.rvSubjectList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvSubjectList");
            recyclerView2 = null;
        }
        ExamAdapter examAdapter2 = this.adapter;
        if (examAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            examAdapter = examAdapter2;
        }
        recyclerView2.setAdapter(examAdapter);
        fetchExamsFromSupabase();
    }

    private final void fetchExamsFromSupabase() {
        final ServerConfig.SupabaseEndpoint server = ServerConfig.INSTANCE.current(this);
        new Thread(new Runnable() { // from class: com.sekolah.cbt.SubjectSelectionActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                SubjectSelectionActivity.fetchExamsFromSupabase$lambda$5(server, this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchExamsFromSupabase$lambda$5(ServerConfig.SupabaseEndpoint server, final SubjectSelectionActivity this$0) throws JSONException {
        Request examRequest;
        Response examResponse;
        Date endDate;
        Date startDate;
        Intrinsics.checkNotNullParameter(server, "$server");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            OkHttpClient client = new OkHttpClient();
            Request examRequest2 = new Request.Builder().url(server.getUrl() + "/rest/v1/exams?student_class=eq." + this$0.studentClass + "&is_active=eq.true").addHeader("apikey", server.getAnonKey()).addHeader("Authorization", "Bearer " + server.getAnonKey()).get().build();
            Response examResponse2 = client.newCall(examRequest2).execute();
            ResponseBody responseBodyBody = examResponse2.body();
            String examDataString = responseBodyBody != null ? responseBodyBody.string() : null;
            final List fetchedExams = new ArrayList();
            String str = examDataString;
            if (!(str == null || str.length() == 0)) {
                JSONArray jsonArray = new JSONArray(examDataString);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date now = new Date();
                int i = 0;
                int length = jsonArray.length();
                while (i < length) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    long id = obj.getLong("id");
                    String subject = obj.getString("subject_name");
                    String url = obj.getString("form_url");
                    OkHttpClient client2 = client;
                    String startTimeStr = obj.optString("start_time", null);
                    String endTimeStr = obj.optString("end_time", null);
                    boolean isTimeValid = true;
                    String str2 = startTimeStr;
                    if ((str2 == null || str2.length() == 0) || Intrinsics.areEqual(startTimeStr, "null") || (startDate = sdf.parse(startTimeStr)) == null) {
                        examRequest = examRequest2;
                    } else {
                        examRequest = examRequest2;
                        if (now.before(startDate)) {
                            isTimeValid = false;
                        }
                    }
                    String str3 = endTimeStr;
                    if (!(str3 == null || str3.length() == 0) && !Intrinsics.areEqual(endTimeStr, "null") && (endDate = sdf.parse(endTimeStr)) != null && now.after(endDate)) {
                        isTimeValid = false;
                    }
                    if (!isTimeValid) {
                        examResponse = examResponse2;
                    } else {
                        Intrinsics.checkNotNull(subject);
                        Intrinsics.checkNotNull(url);
                        examResponse = examResponse2;
                        fetchedExams.add(new ExamItem(id, subject, url));
                    }
                    i++;
                    client = client2;
                    examRequest2 = examRequest;
                    examResponse2 = examResponse;
                }
            }
            this$0.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.SubjectSelectionActivity$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    SubjectSelectionActivity.fetchExamsFromSupabase$lambda$5$lambda$3(this.f$0, fetchedExams);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            this$0.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.SubjectSelectionActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    SubjectSelectionActivity.fetchExamsFromSupabase$lambda$5$lambda$4(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchExamsFromSupabase$lambda$5$lambda$3(SubjectSelectionActivity this$0, List fetchedExams) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fetchedExams, "$fetchedExams");
        this$0.examList.clear();
        this$0.examList.addAll(fetchedExams);
        ExamAdapter examAdapter = this$0.adapter;
        if (examAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            examAdapter = null;
        }
        examAdapter.notifyDataSetChanged();
        if (this$0.examList.isEmpty()) {
            Toast.makeText(this$0, "Tidak ada ujian yang sedang aktif/tayang saat ini", 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchExamsFromSupabase$lambda$5$lambda$4(SubjectSelectionActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0, "Gagal memuat soal dari server", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkSubmissionAndOpen(final long examId, final String subjectName, final String url) {
        final ServerConfig.SupabaseEndpoint server = ServerConfig.INSTANCE.current(this);
        new Thread(new Runnable() { // from class: com.sekolah.cbt.SubjectSelectionActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                SubjectSelectionActivity.checkSubmissionAndOpen$lambda$8(examId, server, this, subjectName, url);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSubmissionAndOpen$lambda$8(final long $examId, ServerConfig.SupabaseEndpoint server, final SubjectSelectionActivity this$0, final String subjectName, final String url) throws JSONException {
        final SubjectSelectionActivity this$02 = this$0;
        Intrinsics.checkNotNullParameter(server, "$server");
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter(subjectName, "$subjectName");
        Intrinsics.checkNotNullParameter(url, "$url");
        try {
            OkHttpClient client = new OkHttpClient();
            String examIdString = String.valueOf($examId);
            Request request = new Request.Builder().url(server.getUrl() + "/rest/v1/exam_submissions?nisn=eq." + this$02.studentNisn + "&subject_id=eq." + examIdString).addHeader("apikey", server.getAnonKey()).addHeader("Authorization", "Bearer " + server.getAnonKey()).get().build();
            Response response = client.newCall(request).execute();
            ResponseBody responseBodyBody = response.body();
            String dataString = responseBodyBody != null ? responseBodyBody.string() : null;
            final Ref.BooleanRef isBlocked = new Ref.BooleanRef();
            String str = dataString;
            if (!(str == null || str.length() == 0) && !Intrinsics.areEqual(dataString, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                JSONArray jsonArray = new JSONArray(dataString);
                JSONObject lastSubmission = jsonArray.getJSONObject(0);
                boolean isCompleted = lastSubmission.optBoolean("is_completed", false);
                if (isCompleted) {
                    isBlocked.element = true;
                }
            }
            try {
                try {
                    this$02 = this$0;
                    this$02.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.SubjectSelectionActivity$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() throws IllegalStateException {
                            SubjectSelectionActivity.checkSubmissionAndOpen$lambda$8$lambda$6(isBlocked, this$0, $examId, subjectName, url);
                        }
                    });
                } catch (Exception e) {
                    e = e;
                    this$02 = this$0;
                    e.printStackTrace();
                    this$02.runOnUiThread(new Runnable() { // from class: com.sekolah.cbt.SubjectSelectionActivity$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            SubjectSelectionActivity.checkSubmissionAndOpen$lambda$8$lambda$7(this.f$0, $examId, subjectName, url);
                        }
                    });
                }
            } catch (Exception e2) {
                e = e2;
                this$02 = this$0;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSubmissionAndOpen$lambda$8$lambda$6(Ref.BooleanRef isBlocked, SubjectSelectionActivity this$0, long $examId, String subjectName, String url) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(isBlocked, "$isBlocked");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(subjectName, "$subjectName");
        Intrinsics.checkNotNullParameter(url, "$url");
        if (isBlocked.element) {
            this$0.playBlockedSound();
            new AlertDialog.Builder(this$0).setTitle("Akses Ditolak!").setMessage("Anda sudah pernah mengirimkan jawaban untuk mata pelajaran ini. Silakan hubungi Panitia jika memerlukan izin ujian ulang.").setIcon(android.R.drawable.ic_dialog_alert).setPositiveButton("Baiklah, suhu", (DialogInterface.OnClickListener) null).show();
        } else {
            this$0.openExam($examId, subjectName, url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSubmissionAndOpen$lambda$8$lambda$7(SubjectSelectionActivity this$0, long $examId, String subjectName, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(subjectName, "$subjectName");
        Intrinsics.checkNotNullParameter(url, "$url");
        this$0.openExam($examId, subjectName, url);
    }

    private final void playBlockedSound() throws IllegalStateException {
        try {
            Object systemService = getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioManager audioManager = (AudioManager) systemService;
            int maxVol = audioManager.getStreamMaxVolume(3);
            audioManager.setStreamVolume(3, maxVol, 0);
            MediaPlayer mediaPlayer = this.blockedMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            MediaPlayer $this$playBlockedSound_u24lambda_u2410 = MediaPlayer.create(this, C2772R.raw.blocked_sound);
            if ($this$playBlockedSound_u24lambda_u2410 != null) {
                $this$playBlockedSound_u24lambda_u2410.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.sekolah.cbt.SubjectSelectionActivity$$ExternalSyntheticLambda3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer2) {
                        SubjectSelectionActivity.playBlockedSound$lambda$10$lambda$9(this.f$0, mediaPlayer2);
                    }
                });
                $this$playBlockedSound_u24lambda_u2410.start();
            } else {
                $this$playBlockedSound_u24lambda_u2410 = null;
            }
            this.blockedMediaPlayer = $this$playBlockedSound_u24lambda_u2410;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playBlockedSound$lambda$10$lambda$9(SubjectSelectionActivity this$0, MediaPlayer mp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mp.release();
        this$0.blockedMediaPlayer = null;
    }

    private final void openExam(long examId, String subjectName, String url) {
        ExamState.INSTANCE.resetAll();
        ExamSessionManager.INSTANCE.setExamFinished(this, false);
        ExamSessionManager.INSTANCE.saveStudentData(this, url, this.studentNisn, this.studentClass, this.studentName, String.valueOf(examId), subjectName);
        Intent intent = new Intent(this, (Class<?>) SecurityCheckActivity.class);
        intent.putExtra("EXAM_URL", url);
        intent.putExtra("SUBJECT_ID", String.valueOf(examId));
        intent.putExtra("SUBJECT_NAME", subjectName);
        intent.putExtra("STUDENT_NISN", this.studentNisn);
        intent.putExtra("STUDENT_CLASS", this.studentClass);
        intent.putExtra("STUDENT_NAME", this.studentName);
        startActivity(intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MediaPlayer mediaPlayer = this.blockedMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.blockedMediaPlayer = null;
    }

    /* compiled from: SubjectSelectionActivity.kt */
    @Metadata(m164d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, m165d2 = {"Lcom/sekolah/cbt/SubjectSelectionActivity$ExamItem;", "", "id", "", "subjectName", "", "formUrl", "(JLjava/lang/String;Ljava/lang/String;)V", "getFormUrl", "()Ljava/lang/String;", "getId", "()J", "getSubjectName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class ExamItem {
        public static final int $stable = 0;
        private final String formUrl;
        private final long id;
        private final String subjectName;

        public static /* synthetic */ ExamItem copy$default(ExamItem examItem, long j, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = examItem.id;
            }
            if ((i & 2) != 0) {
                str = examItem.subjectName;
            }
            if ((i & 4) != 0) {
                str2 = examItem.formUrl;
            }
            return examItem.copy(j, str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSubjectName() {
            return this.subjectName;
        }

        /* renamed from: component3, reason: from getter */
        public final String getFormUrl() {
            return this.formUrl;
        }

        public final ExamItem copy(long id, String subjectName, String formUrl) {
            Intrinsics.checkNotNullParameter(subjectName, "subjectName");
            Intrinsics.checkNotNullParameter(formUrl, "formUrl");
            return new ExamItem(id, subjectName, formUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExamItem)) {
                return false;
            }
            ExamItem examItem = (ExamItem) other;
            return this.id == examItem.id && Intrinsics.areEqual(this.subjectName, examItem.subjectName) && Intrinsics.areEqual(this.formUrl, examItem.formUrl);
        }

        public int hashCode() {
            return (((Long.hashCode(this.id) * 31) + this.subjectName.hashCode()) * 31) + this.formUrl.hashCode();
        }

        public String toString() {
            return "ExamItem(id=" + this.id + ", subjectName=" + this.subjectName + ", formUrl=" + this.formUrl + ")";
        }

        public ExamItem(long id, String subjectName, String formUrl) {
            Intrinsics.checkNotNullParameter(subjectName, "subjectName");
            Intrinsics.checkNotNullParameter(formUrl, "formUrl");
            this.id = id;
            this.subjectName = subjectName;
            this.formUrl = formUrl;
        }

        public final long getId() {
            return this.id;
        }

        public final String getSubjectName() {
            return this.subjectName;
        }

        public final String getFormUrl() {
            return this.formUrl;
        }
    }

    /* compiled from: SubjectSelectionActivity.kt */
    @Metadata(m164d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0014B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\t2\u000e\u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u0010\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m165d2 = {"Lcom/sekolah/cbt/SubjectSelectionActivity$ExamAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sekolah/cbt/SubjectSelectionActivity$ExamAdapter$ViewHolder;", "Lcom/sekolah/cbt/SubjectSelectionActivity;", "items", "", "Lcom/sekolah/cbt/SubjectSelectionActivity$ExamItem;", "onItemClick", "Lkotlin/Function1;", "", "(Lcom/sekolah/cbt/SubjectSelectionActivity;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public final class ExamAdapter extends RecyclerView.Adapter<ViewHolder> {
        private final List<ExamItem> items;
        private final Function1<ExamItem, Unit> onItemClick;
        final /* synthetic */ SubjectSelectionActivity this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public ExamAdapter(SubjectSelectionActivity this$0, List<ExamItem> items, Function1<? super ExamItem, Unit> onItemClick) {
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
            this.this$0 = this$0;
            this.items = items;
            this.onItemClick = onItemClick;
        }

        /* compiled from: SubjectSelectionActivity.kt */
        @Metadata(m164d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, m165d2 = {"Lcom/sekolah/cbt/SubjectSelectionActivity$ExamAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/sekolah/cbt/SubjectSelectionActivity$ExamAdapter;Landroid/view/View;)V", "btnStart", "Landroid/widget/Button;", "getBtnStart", "()Landroid/widget/Button;", "tvSubtitle", "Landroid/widget/TextView;", "getTvSubtitle", "()Landroid/widget/TextView;", "tvTitle", "getTvTitle", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public final class ViewHolder extends RecyclerView.ViewHolder {
            private final Button btnStart;
            final /* synthetic */ ExamAdapter this$0;
            private final TextView tvSubtitle;
            private final TextView tvTitle;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(ExamAdapter this$0, View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "view");
                this.this$0 = this$0;
                View viewFindViewById = view.findViewById(C2772R.id.tvSubjectTitle);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.tvTitle = (TextView) viewFindViewById;
                View viewFindViewById2 = view.findViewById(C2772R.id.tvSubjectClassTarget);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.tvSubtitle = (TextView) viewFindViewById2;
                View viewFindViewById3 = view.findViewById(C2772R.id.btnStartExamItem);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                this.btnStart = (Button) viewFindViewById3;
            }

            public final TextView getTvTitle() {
                return this.tvTitle;
            }

            public final TextView getTvSubtitle() {
                return this.tvSubtitle;
            }

            public final Button getBtnStart() {
                return this.btnStart;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(C2772R.layout.item_subject_card, parent, false);
            Intrinsics.checkNotNull(view);
            return new ViewHolder(this, view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            final ExamItem item = this.items.get(position);
            holder.getTvTitle().setText(item.getSubjectName());
            holder.getTvSubtitle().setText("Soal Aktif Rombel " + this.this$0.studentClass);
            holder.getBtnStart().setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.SubjectSelectionActivity$ExamAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectSelectionActivity.ExamAdapter.onBindViewHolder$lambda$0(this.f$0, item, view);
                }
            });
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.sekolah.cbt.SubjectSelectionActivity$ExamAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectSelectionActivity.ExamAdapter.onBindViewHolder$lambda$1(this.f$0, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$0(ExamAdapter this$0, ExamItem item, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onItemClick.invoke(item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$1(ExamAdapter this$0, ExamItem item, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.onItemClick.invoke(item);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }
    }
}
