package com.sekolah.cbt;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: ServerConfig.kt */
@Metadata(m164d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, m165d2 = {"Lcom/sekolah/cbt/ServerConfig;", "", "()V", "KEY_TINGKAT", "", "PREF", "SERVER_KELAS_X", "Lcom/sekolah/cbt/ServerConfig$SupabaseEndpoint;", "SERVER_KELAS_XI", "SERVER_KELAS_XII", "endpoints", "", "tingkatLabels", "getTingkatLabels", "()Ljava/util/List;", "current", "context", "Landroid/content/Context;", "getEndpointForClass", "className", "getEndpointForTingkat", "index", "", "saveTingkat", "", "SupabaseEndpoint", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ServerConfig {
    private static final String KEY_TINGKAT = "TINGKAT_INDEX";
    private static final String PREF = "CBT_USER_DATA";
    public static final ServerConfig INSTANCE = new ServerConfig();
    private static final SupabaseEndpoint SERVER_KELAS_X = new SupabaseEndpoint("https://ulroqkrnwzzrgkasrqit.supabase.co", "sb_publishable_DJm-HRJpia9X3CzOlBq61Q_Dqct-DPi");
    private static final SupabaseEndpoint SERVER_KELAS_XI = new SupabaseEndpoint("https://oypvpmhvkqhuhamjpjnu.supabase.co", "sb_publishable_H1n_goBAP5xaUrso_sAoWA_F491hDVE");
    private static final SupabaseEndpoint SERVER_KELAS_XII = new SupabaseEndpoint("https://uqxzhrdmpplnlfwvlkag.supabase.co", "sb_publishable_pXrBRuXMyM65VUv_jIC7HQ_hza_4hTJ");
    private static final List<String> tingkatLabels = CollectionsKt.listOf((Object[]) new String[]{"Kelas X", "Kelas XI", "Kelas XII"});
    private static final List<SupabaseEndpoint> endpoints = CollectionsKt.listOf((Object[]) new SupabaseEndpoint[]{SERVER_KELAS_X, SERVER_KELAS_XI, SERVER_KELAS_XII});
    public static final int $stable = 8;

    private ServerConfig() {
    }

    /* compiled from: ServerConfig.kt */
    @Metadata(m164d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m165d2 = {"Lcom/sekolah/cbt/ServerConfig$SupabaseEndpoint;", "", "url", "", "anonKey", "(Ljava/lang/String;Ljava/lang/String;)V", "getAnonKey", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class SupabaseEndpoint {
        public static final int $stable = 0;
        private final String anonKey;
        private final String url;

        public static /* synthetic */ SupabaseEndpoint copy$default(SupabaseEndpoint supabaseEndpoint, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = supabaseEndpoint.url;
            }
            if ((i & 2) != 0) {
                str2 = supabaseEndpoint.anonKey;
            }
            return supabaseEndpoint.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAnonKey() {
            return this.anonKey;
        }

        public final SupabaseEndpoint copy(String url, String anonKey) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(anonKey, "anonKey");
            return new SupabaseEndpoint(url, anonKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SupabaseEndpoint)) {
                return false;
            }
            SupabaseEndpoint supabaseEndpoint = (SupabaseEndpoint) other;
            return Intrinsics.areEqual(this.url, supabaseEndpoint.url) && Intrinsics.areEqual(this.anonKey, supabaseEndpoint.anonKey);
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + this.anonKey.hashCode();
        }

        public String toString() {
            return "SupabaseEndpoint(url=" + this.url + ", anonKey=" + this.anonKey + ")";
        }

        public SupabaseEndpoint(String url, String anonKey) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(anonKey, "anonKey");
            this.url = url;
            this.anonKey = anonKey;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getAnonKey() {
            return this.anonKey;
        }
    }

    public final List<String> getTingkatLabels() {
        return tingkatLabels;
    }

    public final SupabaseEndpoint getEndpointForTingkat(int index) {
        return endpoints.get(RangesKt.coerceIn(index, 0, endpoints.size() - 1));
    }

    public final void saveTingkat(Context context, int index) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.getSharedPreferences(PREF, 0).edit().putInt(KEY_TINGKAT, index).commit();
    }

    public final SupabaseEndpoint current(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int idx = context.getSharedPreferences(PREF, 0).getInt(KEY_TINGKAT, 0);
        return getEndpointForTingkat(idx);
    }

    public final SupabaseEndpoint getEndpointForClass(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        String c = StringsKt.trim((CharSequence) className).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(c, "toUpperCase(...)");
        return StringsKt.startsWith$default(c, "XII", false, 2, (Object) null) ? SERVER_KELAS_XII : StringsKt.startsWith$default(c, "XI", false, 2, (Object) null) ? SERVER_KELAS_XI : SERVER_KELAS_X;
    }
}
