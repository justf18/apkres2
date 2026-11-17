package androidx.documentfile.provider;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import java.util.concurrent.ExecutorService;

/* compiled from: D8$$SyntheticClass */
/* renamed from: androidx.documentfile.provider.DocumentsContractApi19$$ExternalSyntheticAutoCloseableDispatcher0 */
/* loaded from: classes5.dex */
public final /* synthetic */ class C2154xf0829228 {
    /* renamed from: m */
    public static /* synthetic */ void m61m(Object obj) throws Exception {
        if (obj instanceof AutoCloseable) {
            ((AutoCloseable) obj).close();
            return;
        }
        if (obj instanceof ExecutorService) {
            DocumentsContractApi19$$ExternalSyntheticAutoCloseableForwarder1.m62m((ExecutorService) obj);
            return;
        }
        if (obj instanceof TypedArray) {
            ((TypedArray) obj).recycle();
            return;
        }
        if (obj instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) obj).release();
        } else if (obj instanceof MediaDrm) {
            ((MediaDrm) obj).release();
        } else {
            DocumentsContractApi19$$ExternalSyntheticThrowIAE2.m63m(obj);
        }
    }
}
