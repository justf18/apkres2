package com.sekolah.cbt;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CbtAccessibilityService.kt */
@Metadata(m164d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, m165d2 = {"Lcom/sekolah/cbt/CbtAccessibilityService;", "Landroid/accessibilityservice/AccessibilityService;", "()V", "onAccessibilityEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/accessibility/AccessibilityEvent;", "onInterrupt", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class CbtAccessibilityService extends AccessibilityService {
    public static final int $stable = 0;

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent event) {
        String packageName;
        String string;
        if (!ExamState.INSTANCE.isExamActive() || ExamSessionManager.INSTANCE.isExamFinished(this)) {
            ExamState.INSTANCE.setLastDetectedOverlayPackage(null);
            return;
        }
        boolean isIgnored = true;
        if (event != null && event.getEventType() == 32) {
            CharSequence packageName2 = event.getPackageName();
            if (packageName2 == null || (string = packageName2.toString()) == null) {
                packageName = null;
            } else {
                packageName = string.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(packageName, "toLowerCase(...)");
            }
            String str = packageName;
            if (!(str == null || str.length() == 0)) {
                String packageName3 = getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName3, "getPackageName(...)");
                String lowerCase = packageName3.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (!Intrinsics.areEqual(packageName, lowerCase) && !StringsKt.contains$default((CharSequence) packageName, (CharSequence) "launcher", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) packageName, (CharSequence) "home", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) packageName, (CharSequence) "systemui", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) packageName, (CharSequence) "android", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) packageName, (CharSequence) "keyguard", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) packageName, (CharSequence) "inputmethod", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) packageName, (CharSequence) "miui.securitycenter", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) packageName, (CharSequence) "samsung.android.game", false, 2, (Object) null)) {
                    isIgnored = false;
                }
                if (!isIgnored) {
                    ExamState.INSTANCE.setLastDetectedOverlayPackage(packageName);
                }
            }
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        ExamState.INSTANCE.setLastDetectedOverlayPackage(null);
    }
}
