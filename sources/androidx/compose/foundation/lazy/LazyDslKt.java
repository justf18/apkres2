package androidx.compose.foundation.lazy;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;

/* compiled from: LazyDsl.kt */
@Metadata(m164d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001al\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001av\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0016\u001al\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001av\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001d\u001a©\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\b\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u0010+\u001a\u0082\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u0010,\u001a©\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\b\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u0010.\u001a\u0082\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u0010/\u001aè\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\b\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u00104\u001a¬\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u00105\u001aè\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\b\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\b¢\u0006\u0002\u00106\u001a¬\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\b¢\u0006\u0002\u00107¨\u00068"}, m165d2 = {"LazyColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "userScrollEnabled", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyRow", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "items", "T", "", "key", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "item", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyDslKt {
    public static /* synthetic */ void items$default(LazyListScope $this$items_u24default, List items, Function1 key, Function1 contentType, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function1 contentType2 = C05331.INSTANCE;
            contentType = contentType2;
        }
        $this$items_u24default.items(items.size(), key != null ? new C05342(key, items) : null, new C05353(contentType, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new C05364(itemContent, items)));
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m165d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Void;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$1 */
    public static final class C05331 extends Lambda implements Function1 {
        public static final C05331 INSTANCE = new C05331();

        public C05331() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
            return invoke((C05331) p1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(T t) {
            return null;
        }
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m165d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$2 */
    public static final class C05342 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05342(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
            super(1);
            this.$key = function1;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final Object invoke(int index) {
            return this.$key.invoke(this.$items.get(index));
        }
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m165d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$3 */
    public static final class C05353 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05353(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
            super(1);
            this.$contentType = function1;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final Object invoke(int index) {
            return this.$contentType.invoke(this.$items.get(index));
        }
    }

    public static final <T> void items(LazyListScope $this$items, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        $this$items.items(list.size(), function1 != null ? new C05342(function1, list) : null, new C05353(function12, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new C05364(function4, list)));
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m165d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$4 */
    public static final class C05364 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05364(Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, List<? extends T> list) {
            super(4);
            this.$itemContent = function4;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C148@6730L22:LazyDsl.kt#428nma");
            int $dirty = $changed;
            if (($changed & 14) == 0) {
                $dirty |= $composer.changed($this$items) ? 4 : 2;
            }
            if (($changed & 112) == 0) {
                $dirty |= $composer.changed(it) ? 32 : 16;
            }
            if (($dirty & 731) == 146 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-632812321, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:148)");
            }
            this.$itemContent.invoke($this$items, this.$items.get(it), $composer, Integer.valueOf($dirty & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static /* synthetic */ void items$default(LazyListScope $this$items_u24default, List items, Function1 key, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        Function1 contentType$iv = C05331.INSTANCE;
        $this$items_u24default.items(items.size(), key != null ? new C05342(key, items) : null, new C05353(contentType$iv, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new C05364(itemContent, items)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void items(LazyListScope $this$items, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Function1 contentType$iv = C05331.INSTANCE;
        $this$items.items(list.size(), function1 != null ? new C05342(function1, list) : null, new C05353(contentType$iv, list), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new C05364(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope $this$itemsIndexed_u24default, List items, Function2 key, Function2 contentType, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function2 contentType2 = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return invoke(((Number) p1).intValue(), (int) p2);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        $this$itemsIndexed_u24default.items(items.size(), key != null ? new C05422(key, items) : null, new C05433(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C05444(itemContent, items)));
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m165d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$2 */
    public static final class C05422 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05422(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
            super(1);
            this.$key = function2;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final Object invoke(int index) {
            return this.$key.invoke(Integer.valueOf(index), this.$items.get(index));
        }
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m165d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$3 */
    public static final class C05433 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05433(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
            super(1);
            this.$contentType = function2;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final Object invoke(int index) {
            return this.$contentType.invoke(Integer.valueOf(index), this.$items.get(index));
        }
    }

    public static final <T> void itemsIndexed(LazyListScope $this$itemsIndexed, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        $this$itemsIndexed.items(list.size(), function2 != null ? new C05422(function2, list) : null, new C05433(function22, list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C05444(function5, list)));
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m165d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$4 */
    public static final class C05444 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05444(Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, List<? extends T> list) {
            super(4);
            this.$itemContent = function5;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C183@8439L26:LazyDsl.kt#428nma");
            int $dirty = $changed;
            if (($changed & 14) == 0) {
                $dirty |= $composer.changed($this$items) ? 4 : 2;
            }
            if (($changed & 112) == 0) {
                $dirty |= $composer.changed(it) ? 32 : 16;
            }
            if (($dirty & 731) == 146 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1091073711, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:183)");
            }
            this.$itemContent.invoke($this$items, Integer.valueOf(it), this.$items.get(it), $composer, Integer.valueOf(($dirty & 14) | ($dirty & 112)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope $this$itemsIndexed_u24default, List items, Function2 key, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        $this$itemsIndexed_u24default.items(items.size(), key != null ? new C05422(key, items) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C05444(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope $this$items_u24default, Object[] items, Function1 key, Function1 contentType, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function1 contentType2 = C05375.INSTANCE;
            contentType = contentType2;
        }
        $this$items_u24default.items(items.length, key != null ? new C05386(key, items) : null, new C05397(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new C05408(itemContent, items)));
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m165d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Void;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$5 */
    public static final class C05375 extends Lambda implements Function1 {
        public static final C05375 INSTANCE = new C05375();

        public C05375() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
            return invoke((C05375) p1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(T t) {
            return null;
        }
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m165d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$6 */
    public static final class C05386 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05386(Function1<? super T, ? extends Object> function1, T[] tArr) {
            super(1);
            this.$key = function1;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final Object invoke(int index) {
            return this.$key.invoke(this.$items[index]);
        }
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m165d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$7 */
    public static final class C05397 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05397(Function1<? super T, ? extends Object> function1, T[] tArr) {
            super(1);
            this.$contentType = function1;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final Object invoke(int index) {
            return this.$contentType.invoke(this.$items[index]);
        }
    }

    public static final <T> void items(LazyListScope $this$items, T[] tArr, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        $this$items.items(tArr.length, function1 != null ? new C05386(function1, tArr) : null, new C05397(function12, tArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new C05408(function4, tArr)));
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m165d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$8 */
    public static final class C05408 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05408(Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
            super(4);
            this.$itemContent = function4;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C218@10080L22:LazyDsl.kt#428nma");
            int $dirty = $changed;
            if (($changed & 14) == 0) {
                $dirty |= $composer.changed($this$items) ? 4 : 2;
            }
            if (($changed & 112) == 0) {
                $dirty |= $composer.changed(it) ? 32 : 16;
            }
            if (($dirty & 731) == 146 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1043393750, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:218)");
            }
            this.$itemContent.invoke($this$items, this.$items[it], $composer, Integer.valueOf($dirty & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static /* synthetic */ void items$default(LazyListScope $this$items_u24default, Object[] items, Function1 key, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        Function1 contentType$iv = C05375.INSTANCE;
        $this$items_u24default.items(items.length, key != null ? new C05386(key, items) : null, new C05397(contentType$iv, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new C05408(itemContent, items)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void items(LazyListScope $this$items, T[] tArr, Function1<? super T, ? extends Object> function1, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Function1 contentType$iv = C05375.INSTANCE;
        $this$items.items(tArr.length, function1 != null ? new C05386(function1, tArr) : null, new C05397(contentType$iv, tArr), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new C05408(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function2 contentType, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        if ((i & 4) != 0) {
            Function2 contentType2 = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return invoke(((Number) p1).intValue(), (int) p2);
                }

                public final Void invoke(int i2, T t) {
                    return null;
                }
            };
            contentType = contentType2;
        }
        $this$itemsIndexed_u24default.items(items.length, key != null ? new C05466(key, items) : null, new C05477(contentType, items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C05488(itemContent, items)));
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m165d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$6 */
    public static final class C05466 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05466(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
            super(1);
            this.$key = function2;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final Object invoke(int index) {
            return this.$key.invoke(Integer.valueOf(index), this.$items[index]);
        }
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m165d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$7 */
    public static final class C05477 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05477(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
            super(1);
            this.$contentType = function2;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final Object invoke(int index) {
            return this.$contentType.invoke(Integer.valueOf(index), this.$items[index]);
        }
    }

    public static final <T> void itemsIndexed(LazyListScope $this$itemsIndexed, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        $this$itemsIndexed.items(tArr.length, function2 != null ? new C05466(function2, tArr) : null, new C05477(function22, tArr), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C05488(function5, tArr)));
    }

    /* compiled from: LazyDsl.kt */
    @Metadata(m164d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, m165d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = 176)
    /* renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$8 */
    public static final class C05488 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C05488(Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, T[] tArr) {
            super(4);
            this.$itemContent = function5;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C253@11794L26:LazyDsl.kt#428nma");
            int $dirty = $changed;
            if (($changed & 14) == 0) {
                $dirty |= $composer.changed($this$items) ? 4 : 2;
            }
            if (($changed & 112) == 0) {
                $dirty |= $composer.changed(it) ? 32 : 16;
            }
            if (($dirty & 731) == 146 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1600639390, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:253)");
            }
            this.$itemContent.invoke($this$items, Integer.valueOf(it), this.$items[it], $composer, Integer.valueOf(($dirty & 14) | ($dirty & 112)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            key = null;
        }
        $this$itemsIndexed_u24default.items(items.length, key != null ? new C05466(key, items) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C05488(itemContent, items)));
    }

    public static final void LazyRow(Modifier modifier, LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, FlingBehavior flingBehavior, boolean userScrollEnabled, final Function1<? super LazyListScope, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        LazyListState state2;
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        Arrangement.Horizontal horizontalArrangement2;
        Alignment.Vertical verticalAlignment2;
        int i2;
        FlingBehavior flingBehavior2;
        int i3;
        boolean userScrollEnabled2;
        LazyListState state3;
        Arrangement.Horizontal horizontalArrangement3;
        FlingBehavior flingBehavior3;
        Alignment.Vertical verticalAlignment3;
        int $dirty;
        int $dirty2;
        Modifier modifier3;
        PaddingValues contentPadding3;
        boolean reverseLayout3;
        Composer $composer2;
        final Modifier modifier4;
        final LazyListState state4;
        final PaddingValues contentPadding4;
        final boolean reverseLayout4;
        final FlingBehavior flingBehavior4;
        final boolean userScrollEnabled3;
        final Alignment.Vertical verticalAlignment4;
        final Arrangement.Horizontal horizontalArrangement4;
        Composer $composer3 = $composer.startRestartGroup(-1724297413);
        ComposerKt.sourceInformation($composer3, "C(LazyRow)P(4,6,1,5,3,8,2,7)294@14218L23,300@14569L15,304@14671L389:LazyDsl.kt#428nma");
        int $dirty3 = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty3 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                state2 = state;
                int i5 = $composer3.changed(state2) ? 32 : 16;
                $dirty3 |= i5;
            } else {
                state2 = state;
            }
            $dirty3 |= i5;
        } else {
            state2 = state;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty3 |= 384;
            contentPadding2 = contentPadding;
        } else if (($changed & 896) == 0) {
            contentPadding2 = contentPadding;
            $dirty3 |= $composer3.changed(contentPadding2) ? 256 : 128;
        } else {
            contentPadding2 = contentPadding;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty3 |= 3072;
            reverseLayout2 = reverseLayout;
        } else if (($changed & 7168) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty3 |= $composer3.changed(reverseLayout2) ? 2048 : 1024;
        } else {
            reverseLayout2 = reverseLayout;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                horizontalArrangement2 = horizontalArrangement;
                int i8 = $composer3.changed(horizontalArrangement2) ? 16384 : 8192;
                $dirty3 |= i8;
            } else {
                horizontalArrangement2 = horizontalArrangement;
            }
            $dirty3 |= i8;
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        int i9 = i & 32;
        if (i9 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            verticalAlignment2 = verticalAlignment;
        } else if (($changed & 458752) == 0) {
            verticalAlignment2 = verticalAlignment;
            $dirty3 |= $composer3.changed(verticalAlignment2) ? 131072 : 65536;
        } else {
            verticalAlignment2 = verticalAlignment;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                i2 = 458752;
                flingBehavior2 = flingBehavior;
                int i10 = $composer3.changed(flingBehavior2) ? 1048576 : 524288;
                $dirty3 |= i10;
            } else {
                i2 = 458752;
                flingBehavior2 = flingBehavior;
            }
            $dirty3 |= i10;
        } else {
            i2 = 458752;
            flingBehavior2 = flingBehavior;
        }
        int i11 = i & 128;
        if (i11 != 0) {
            $dirty3 |= 12582912;
            i3 = i11;
        } else if (($changed & 29360128) == 0) {
            i3 = i11;
            $dirty3 |= $composer3.changed(userScrollEnabled) ? 8388608 : 4194304;
        } else {
            i3 = i11;
        }
        if ((i & 256) != 0) {
            $dirty3 |= 100663296;
        } else if ((234881024 & $changed) == 0) {
            $dirty3 |= $composer3.changedInstance(function1) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty4 = $dirty3;
        if (($dirty3 & 191739611) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            userScrollEnabled3 = userScrollEnabled;
            $composer2 = $composer3;
            modifier4 = modifier2;
            state4 = state2;
            contentPadding4 = contentPadding2;
            reverseLayout4 = reverseLayout2;
            horizontalArrangement4 = horizontalArrangement2;
            flingBehavior4 = flingBehavior2;
            verticalAlignment4 = verticalAlignment2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 2) != 0) {
                    state2 = LazyListStateKt.rememberLazyListState(0, 0, $composer3, 0, 3);
                    $dirty4 &= -113;
                }
                if (i6 != 0) {
                    contentPadding2 = PaddingKt.m760PaddingValues0680j_4(C1956Dp.m6297constructorimpl(0));
                }
                if (i7 != 0) {
                    reverseLayout2 = false;
                }
                if ((i & 16) != 0) {
                    Arrangement arrangement = Arrangement.INSTANCE;
                    $dirty4 &= -57345;
                    horizontalArrangement2 = !reverseLayout2 ? arrangement.getStart() : arrangement.getEnd();
                }
                if (i9 != 0) {
                    verticalAlignment2 = Alignment.INSTANCE.getTop();
                }
                if ((i & 64) != 0) {
                    $dirty4 &= -3670017;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer3, 6);
                }
                if (i3 != 0) {
                    userScrollEnabled2 = true;
                    state3 = state2;
                    horizontalArrangement3 = horizontalArrangement2;
                    flingBehavior3 = flingBehavior2;
                    verticalAlignment3 = verticalAlignment2;
                    $dirty = $dirty4;
                    $dirty2 = -1724297413;
                    modifier3 = modifier2;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                } else {
                    userScrollEnabled2 = userScrollEnabled;
                    state3 = state2;
                    horizontalArrangement3 = horizontalArrangement2;
                    flingBehavior3 = flingBehavior2;
                    verticalAlignment3 = verticalAlignment2;
                    $dirty = $dirty4;
                    $dirty2 = -1724297413;
                    modifier3 = modifier2;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty5 = (i & 2) != 0 ? $dirty4 & (-113) : $dirty4;
                if ((i & 16) != 0) {
                    $dirty5 &= -57345;
                }
                if ((i & 64) != 0) {
                    $dirty5 &= -3670017;
                }
                userScrollEnabled2 = userScrollEnabled;
                $dirty = $dirty5;
                state3 = state2;
                horizontalArrangement3 = horizontalArrangement2;
                flingBehavior3 = flingBehavior2;
                verticalAlignment3 = verticalAlignment2;
                $dirty2 = -1724297413;
                modifier3 = modifier2;
                contentPadding3 = contentPadding2;
                reverseLayout3 = reverseLayout2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart($dirty2, $dirty, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:303)");
            }
            $composer2 = $composer3;
            LazyListKt.LazyList(modifier3, state3, contentPadding3, reverseLayout3, false, flingBehavior3, userScrollEnabled2, 0, null, null, verticalAlignment3, horizontalArrangement3, function1, $composer2, ($dirty & 14) | 24576 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 3) & i2) | (($dirty >> 3) & 3670016), (($dirty >> 15) & 14) | (($dirty >> 9) & 112) | (($dirty >> 18) & 896), 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            state4 = state3;
            contentPadding4 = contentPadding3;
            reverseLayout4 = reverseLayout3;
            flingBehavior4 = flingBehavior3;
            userScrollEnabled3 = userScrollEnabled2;
            verticalAlignment4 = verticalAlignment3;
            horizontalArrangement4 = horizontalArrangement3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i12) {
                    LazyDslKt.LazyRow(modifier4, state4, contentPadding4, reverseLayout4, horizontalArrangement4, verticalAlignment4, flingBehavior4, userScrollEnabled3, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void LazyColumn(Modifier modifier, LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, FlingBehavior flingBehavior, boolean userScrollEnabled, final Function1<? super LazyListScope, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        LazyListState state2;
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        Arrangement.Vertical verticalArrangement2;
        Alignment.Horizontal horizontalAlignment2;
        int i2;
        FlingBehavior flingBehavior2;
        int i3;
        boolean userScrollEnabled2;
        LazyListState state3;
        Arrangement.Vertical verticalArrangement3;
        FlingBehavior flingBehavior3;
        int $dirty;
        int i4;
        Modifier modifier3;
        PaddingValues contentPadding3;
        Alignment.Horizontal horizontalAlignment3;
        boolean reverseLayout3;
        Composer $composer2;
        final Modifier modifier4;
        final PaddingValues contentPadding4;
        final boolean reverseLayout4;
        final FlingBehavior flingBehavior4;
        final boolean userScrollEnabled3;
        final Alignment.Horizontal horizontalAlignment4;
        final Arrangement.Vertical verticalArrangement4;
        final LazyListState state4;
        Composer $composer3 = $composer.startRestartGroup(-740714857);
        ComposerKt.sourceInformation($composer3, "C(LazyColumn)P(4,6,1,5,8,3,2,7)350@17150L23,356@17504L15,360@17606L388:LazyDsl.kt#428nma");
        int $dirty2 = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                state2 = state;
                int i6 = $composer3.changed(state2) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                state2 = state;
            }
            $dirty2 |= i6;
        } else {
            state2 = state;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty2 |= 384;
            contentPadding2 = contentPadding;
        } else if (($changed & 896) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer3.changed(contentPadding2) ? 256 : 128;
        } else {
            contentPadding2 = contentPadding;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty2 |= 3072;
            reverseLayout2 = reverseLayout;
        } else if (($changed & 7168) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty2 |= $composer3.changed(reverseLayout2) ? 2048 : 1024;
        } else {
            reverseLayout2 = reverseLayout;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                verticalArrangement2 = verticalArrangement;
                int i9 = $composer3.changed(verticalArrangement2) ? 16384 : 8192;
                $dirty2 |= i9;
            } else {
                verticalArrangement2 = verticalArrangement;
            }
            $dirty2 |= i9;
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            horizontalAlignment2 = horizontalAlignment;
        } else if (($changed & 458752) == 0) {
            horizontalAlignment2 = horizontalAlignment;
            $dirty2 |= $composer3.changed(horizontalAlignment2) ? 131072 : 65536;
        } else {
            horizontalAlignment2 = horizontalAlignment;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                i2 = 458752;
                flingBehavior2 = flingBehavior;
                int i11 = $composer3.changed(flingBehavior2) ? 1048576 : 524288;
                $dirty2 |= i11;
            } else {
                i2 = 458752;
                flingBehavior2 = flingBehavior;
            }
            $dirty2 |= i11;
        } else {
            i2 = 458752;
            flingBehavior2 = flingBehavior;
        }
        int i12 = i & 128;
        if (i12 != 0) {
            $dirty2 |= 12582912;
            i3 = i12;
        } else if (($changed & 29360128) == 0) {
            i3 = i12;
            $dirty2 |= $composer3.changed(userScrollEnabled) ? 8388608 : 4194304;
        } else {
            i3 = i12;
        }
        if ((i & 256) != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty3 = $dirty2;
        if (($dirty2 & 191739611) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            userScrollEnabled3 = userScrollEnabled;
            $composer2 = $composer3;
            modifier4 = modifier2;
            state4 = state2;
            contentPadding4 = contentPadding2;
            reverseLayout4 = reverseLayout2;
            verticalArrangement4 = verticalArrangement2;
            flingBehavior4 = flingBehavior2;
            horizontalAlignment4 = horizontalAlignment2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 2) != 0) {
                    state2 = LazyListStateKt.rememberLazyListState(0, 0, $composer3, 0, 3);
                    $dirty3 &= -113;
                }
                if (i7 != 0) {
                    contentPadding2 = PaddingKt.m760PaddingValues0680j_4(C1956Dp.m6297constructorimpl(0));
                }
                if (i8 != 0) {
                    reverseLayout2 = false;
                }
                if ((i & 16) != 0) {
                    Arrangement arrangement = Arrangement.INSTANCE;
                    $dirty3 &= -57345;
                    verticalArrangement2 = !reverseLayout2 ? arrangement.getTop() : arrangement.getBottom();
                }
                if (i10 != 0) {
                    horizontalAlignment2 = Alignment.INSTANCE.getStart();
                }
                if ((i & 64) != 0) {
                    $dirty3 &= -3670017;
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior($composer3, 6);
                }
                if (i3 != 0) {
                    userScrollEnabled2 = true;
                    state3 = state2;
                    verticalArrangement3 = verticalArrangement2;
                    flingBehavior3 = flingBehavior2;
                    $dirty = $dirty3;
                    i4 = -740714857;
                    modifier3 = modifier2;
                    contentPadding3 = contentPadding2;
                    horizontalAlignment3 = horizontalAlignment2;
                    reverseLayout3 = reverseLayout2;
                } else {
                    userScrollEnabled2 = userScrollEnabled;
                    state3 = state2;
                    verticalArrangement3 = verticalArrangement2;
                    flingBehavior3 = flingBehavior2;
                    $dirty = $dirty3;
                    i4 = -740714857;
                    modifier3 = modifier2;
                    contentPadding3 = contentPadding2;
                    horizontalAlignment3 = horizontalAlignment2;
                    reverseLayout3 = reverseLayout2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty3 &= -113;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 64) != 0) {
                    userScrollEnabled2 = userScrollEnabled;
                    $dirty = $dirty3 & (-3670017);
                    state3 = state2;
                    verticalArrangement3 = verticalArrangement2;
                    flingBehavior3 = flingBehavior2;
                    horizontalAlignment3 = horizontalAlignment2;
                    i4 = -740714857;
                    modifier3 = modifier2;
                    contentPadding3 = contentPadding2;
                    reverseLayout3 = reverseLayout2;
                } else {
                    userScrollEnabled2 = userScrollEnabled;
                    state3 = state2;
                    verticalArrangement3 = verticalArrangement2;
                    flingBehavior3 = flingBehavior2;
                    $dirty = $dirty3;
                    i4 = -740714857;
                    modifier3 = modifier2;
                    contentPadding3 = contentPadding2;
                    horizontalAlignment3 = horizontalAlignment2;
                    reverseLayout3 = reverseLayout2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i4, $dirty, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:359)");
            }
            $composer2 = $composer3;
            LazyListKt.LazyList(modifier3, state3, contentPadding3, reverseLayout3, true, flingBehavior3, userScrollEnabled2, 0, horizontalAlignment3, verticalArrangement3, null, null, function1, $composer2, ($dirty & 14) | 24576 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 3) & i2) | (($dirty >> 3) & 3670016) | (($dirty << 9) & 234881024) | (($dirty << 15) & 1879048192), ($dirty >> 18) & 896, 3200);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            contentPadding4 = contentPadding3;
            reverseLayout4 = reverseLayout3;
            flingBehavior4 = flingBehavior3;
            userScrollEnabled3 = userScrollEnabled2;
            horizontalAlignment4 = horizontalAlignment3;
            verticalArrangement4 = verticalArrangement3;
            state4 = state3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i13) {
                    LazyDslKt.LazyColumn(modifier4, state4, contentPadding4, reverseLayout4, verticalArrangement4, horizontalAlignment4, flingBehavior4, userScrollEnabled3, function1, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyColumn(Modifier modifier, LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, FlingBehavior flingBehavior, final Function1 content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        LazyListState state2;
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        Arrangement.Vertical verticalArrangement2;
        int i2;
        Alignment.Horizontal horizontalAlignment2;
        int i3;
        FlingBehavior flingBehavior2;
        boolean reverseLayout3;
        int i4;
        int $dirty;
        Modifier modifier3;
        FlingBehavior flingBehavior3;
        int $dirty2;
        Alignment.Horizontal horizontalAlignment3;
        Arrangement.Vertical verticalArrangement3;
        LazyListState state3;
        PaddingValues contentPadding3;
        Composer $composer2;
        final Modifier modifier4;
        final PaddingValues contentPadding4;
        final boolean reverseLayout4;
        final Arrangement.Vertical verticalArrangement4;
        final Alignment.Horizontal horizontalAlignment4;
        final FlingBehavior flingBehavior4;
        final LazyListState state4;
        Composer $composer3 = $composer.startRestartGroup(-563353797);
        ComposerKt.sourceInformation($composer3, "C(LazyColumn)P(4,6,1,5,7,3,2)378@18168L23,384@18522L15,387@18585L350:LazyDsl.kt#428nma");
        int $dirty3 = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty3 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                state2 = state;
                int i6 = $composer3.changed(state2) ? 32 : 16;
                $dirty3 |= i6;
            } else {
                state2 = state;
            }
            $dirty3 |= i6;
        } else {
            state2 = state;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty3 |= 384;
            contentPadding2 = contentPadding;
        } else if (($changed & 896) == 0) {
            contentPadding2 = contentPadding;
            $dirty3 |= $composer3.changed(contentPadding2) ? 256 : 128;
        } else {
            contentPadding2 = contentPadding;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty3 |= 3072;
            reverseLayout2 = reverseLayout;
        } else if (($changed & 7168) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty3 |= $composer3.changed(reverseLayout2) ? 2048 : 1024;
        } else {
            reverseLayout2 = reverseLayout;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                verticalArrangement2 = verticalArrangement;
                int i9 = $composer3.changed(verticalArrangement2) ? 16384 : 8192;
                $dirty3 |= i9;
            } else {
                verticalArrangement2 = verticalArrangement;
            }
            $dirty3 |= i9;
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            i2 = 57344;
            horizontalAlignment2 = horizontalAlignment;
        } else if (($changed & 458752) == 0) {
            i2 = 57344;
            horizontalAlignment2 = horizontalAlignment;
            $dirty3 |= $composer3.changed(horizontalAlignment2) ? 131072 : 65536;
        } else {
            i2 = 57344;
            horizontalAlignment2 = horizontalAlignment;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                i3 = 458752;
                flingBehavior2 = flingBehavior;
                int i11 = $composer3.changed(flingBehavior2) ? 1048576 : 524288;
                $dirty3 |= i11;
            } else {
                i3 = 458752;
                flingBehavior2 = flingBehavior;
            }
            $dirty3 |= i11;
        } else {
            i3 = 458752;
            flingBehavior2 = flingBehavior;
        }
        if ((i & 128) != 0) {
            $dirty3 |= 12582912;
        } else if ((29360128 & $changed) == 0) {
            $dirty3 |= $composer3.changedInstance(content) ? 8388608 : 4194304;
        }
        int $dirty4 = $dirty3;
        if (($dirty3 & 23967451) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            reverseLayout4 = reverseLayout2;
            state4 = state2;
            contentPadding4 = contentPadding2;
            horizontalAlignment4 = horizontalAlignment2;
            verticalArrangement4 = verticalArrangement2;
            flingBehavior4 = flingBehavior2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    state2 = LazyListStateKt.rememberLazyListState(0, 0, $composer3, 0, 3);
                    $dirty4 &= -113;
                }
                if (i7 != 0) {
                    contentPadding2 = PaddingKt.m760PaddingValues0680j_4(C1956Dp.m6297constructorimpl(0));
                }
                if (i8 != 0) {
                    reverseLayout2 = false;
                }
                if ((i & 16) != 0) {
                    Arrangement arrangement = Arrangement.INSTANCE;
                    $dirty4 &= -57345;
                    verticalArrangement2 = !reverseLayout2 ? arrangement.getTop() : arrangement.getBottom();
                }
                if (i10 != 0) {
                    horizontalAlignment2 = Alignment.INSTANCE.getStart();
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty4 & (-3670017);
                    int i12 = i3;
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior($composer3, 6);
                    i4 = i12;
                    reverseLayout3 = reverseLayout2;
                    verticalArrangement3 = verticalArrangement2;
                    modifier3 = modifier5;
                    contentPadding3 = contentPadding2;
                    $dirty2 = 3670016;
                    horizontalAlignment3 = horizontalAlignment2;
                    state3 = state2;
                } else {
                    reverseLayout3 = reverseLayout2;
                    i4 = i3;
                    $dirty = $dirty4;
                    modifier3 = modifier5;
                    flingBehavior3 = flingBehavior2;
                    $dirty2 = 3670016;
                    horizontalAlignment3 = horizontalAlignment2;
                    verticalArrangement3 = verticalArrangement2;
                    state3 = state2;
                    contentPadding3 = contentPadding2;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty5 = (i & 2) != 0 ? $dirty4 & (-113) : $dirty4;
                if ((i & 16) != 0) {
                    $dirty5 &= -57345;
                }
                if ((i & 64) != 0) {
                    $dirty5 &= -3670017;
                }
                $dirty = $dirty5;
                reverseLayout3 = reverseLayout2;
                $dirty2 = 3670016;
                i4 = i3;
                modifier3 = modifier2;
                horizontalAlignment3 = horizontalAlignment2;
                flingBehavior3 = flingBehavior2;
                state3 = state2;
                verticalArrangement3 = verticalArrangement2;
                contentPadding3 = contentPadding2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-563353797, $dirty, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:386)");
            }
            $composer2 = $composer3;
            LazyColumn(modifier3, state3, contentPadding3, reverseLayout3, verticalArrangement3, horizontalAlignment3, flingBehavior3, true, content, $composer2, ($dirty2 & $dirty) | (i4 & $dirty) | ($dirty & 14) | 12582912 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & i2) | (($dirty << 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            contentPadding4 = contentPadding3;
            reverseLayout4 = reverseLayout3;
            verticalArrangement4 = verticalArrangement3;
            horizontalAlignment4 = horizontalAlignment3;
            flingBehavior4 = flingBehavior3;
            state4 = state3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i13) {
                    LazyDslKt.LazyColumn(modifier4, state4, contentPadding4, reverseLayout4, verticalArrangement4, horizontalAlignment4, flingBehavior4, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyRow(Modifier modifier, LazyListState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, FlingBehavior flingBehavior, final Function1 content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        LazyListState state2;
        PaddingValues contentPadding2;
        boolean reverseLayout2;
        Arrangement.Horizontal horizontalArrangement2;
        int i2;
        Alignment.Vertical verticalAlignment2;
        int i3;
        FlingBehavior flingBehavior2;
        boolean reverseLayout3;
        int i4;
        int $dirty;
        Modifier modifier3;
        FlingBehavior flingBehavior3;
        int $dirty2;
        Alignment.Vertical verticalAlignment3;
        Arrangement.Horizontal horizontalArrangement3;
        LazyListState state3;
        PaddingValues contentPadding3;
        Composer $composer2;
        final Modifier modifier4;
        final PaddingValues contentPadding4;
        final boolean reverseLayout4;
        final Arrangement.Horizontal horizontalArrangement4;
        final Alignment.Vertical verticalAlignment4;
        final FlingBehavior flingBehavior4;
        final LazyListState state4;
        Composer $composer3 = $composer.startRestartGroup(407929823);
        ComposerKt.sourceInformation($composer3, "C(LazyRow)P(4,6,1,5,3,7,2)404@19106L23,410@19457L15,413@19520L347:LazyDsl.kt#428nma");
        int $dirty3 = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty3 |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                state2 = state;
                int i6 = $composer3.changed(state2) ? 32 : 16;
                $dirty3 |= i6;
            } else {
                state2 = state;
            }
            $dirty3 |= i6;
        } else {
            state2 = state;
        }
        int i7 = i & 4;
        if (i7 != 0) {
            $dirty3 |= 384;
            contentPadding2 = contentPadding;
        } else if (($changed & 896) == 0) {
            contentPadding2 = contentPadding;
            $dirty3 |= $composer3.changed(contentPadding2) ? 256 : 128;
        } else {
            contentPadding2 = contentPadding;
        }
        int i8 = i & 8;
        if (i8 != 0) {
            $dirty3 |= 3072;
            reverseLayout2 = reverseLayout;
        } else if (($changed & 7168) == 0) {
            reverseLayout2 = reverseLayout;
            $dirty3 |= $composer3.changed(reverseLayout2) ? 2048 : 1024;
        } else {
            reverseLayout2 = reverseLayout;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                horizontalArrangement2 = horizontalArrangement;
                int i9 = $composer3.changed(horizontalArrangement2) ? 16384 : 8192;
                $dirty3 |= i9;
            } else {
                horizontalArrangement2 = horizontalArrangement;
            }
            $dirty3 |= i9;
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            i2 = 57344;
            verticalAlignment2 = verticalAlignment;
        } else if (($changed & 458752) == 0) {
            i2 = 57344;
            verticalAlignment2 = verticalAlignment;
            $dirty3 |= $composer3.changed(verticalAlignment2) ? 131072 : 65536;
        } else {
            i2 = 57344;
            verticalAlignment2 = verticalAlignment;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                i3 = 458752;
                flingBehavior2 = flingBehavior;
                int i11 = $composer3.changed(flingBehavior2) ? 1048576 : 524288;
                $dirty3 |= i11;
            } else {
                i3 = 458752;
                flingBehavior2 = flingBehavior;
            }
            $dirty3 |= i11;
        } else {
            i3 = 458752;
            flingBehavior2 = flingBehavior;
        }
        if ((i & 128) != 0) {
            $dirty3 |= 12582912;
        } else if ((29360128 & $changed) == 0) {
            $dirty3 |= $composer3.changedInstance(content) ? 8388608 : 4194304;
        }
        int $dirty4 = $dirty3;
        if (($dirty3 & 23967451) == 4793490 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
            reverseLayout4 = reverseLayout2;
            state4 = state2;
            contentPadding4 = contentPadding2;
            verticalAlignment4 = verticalAlignment2;
            horizontalArrangement4 = horizontalArrangement2;
            flingBehavior4 = flingBehavior2;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    state2 = LazyListStateKt.rememberLazyListState(0, 0, $composer3, 0, 3);
                    $dirty4 &= -113;
                }
                if (i7 != 0) {
                    contentPadding2 = PaddingKt.m760PaddingValues0680j_4(C1956Dp.m6297constructorimpl(0));
                }
                if (i8 != 0) {
                    reverseLayout2 = false;
                }
                if ((i & 16) != 0) {
                    Arrangement arrangement = Arrangement.INSTANCE;
                    $dirty4 &= -57345;
                    horizontalArrangement2 = !reverseLayout2 ? arrangement.getStart() : arrangement.getEnd();
                }
                if (i10 != 0) {
                    verticalAlignment2 = Alignment.INSTANCE.getTop();
                }
                if ((i & 64) != 0) {
                    $dirty = $dirty4 & (-3670017);
                    int i12 = i3;
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior($composer3, 6);
                    i4 = i12;
                    reverseLayout3 = reverseLayout2;
                    horizontalArrangement3 = horizontalArrangement2;
                    modifier3 = modifier5;
                    contentPadding3 = contentPadding2;
                    $dirty2 = 3670016;
                    verticalAlignment3 = verticalAlignment2;
                    state3 = state2;
                } else {
                    reverseLayout3 = reverseLayout2;
                    i4 = i3;
                    $dirty = $dirty4;
                    modifier3 = modifier5;
                    flingBehavior3 = flingBehavior2;
                    $dirty2 = 3670016;
                    verticalAlignment3 = verticalAlignment2;
                    horizontalArrangement3 = horizontalArrangement2;
                    state3 = state2;
                    contentPadding3 = contentPadding2;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty5 = (i & 2) != 0 ? $dirty4 & (-113) : $dirty4;
                if ((i & 16) != 0) {
                    $dirty5 &= -57345;
                }
                if ((i & 64) != 0) {
                    $dirty5 &= -3670017;
                }
                $dirty = $dirty5;
                reverseLayout3 = reverseLayout2;
                $dirty2 = 3670016;
                i4 = i3;
                modifier3 = modifier2;
                verticalAlignment3 = verticalAlignment2;
                flingBehavior3 = flingBehavior2;
                state3 = state2;
                horizontalArrangement3 = horizontalArrangement2;
                contentPadding3 = contentPadding2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(407929823, $dirty, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:412)");
            }
            $composer2 = $composer3;
            LazyRow(modifier3, state3, contentPadding3, reverseLayout3, horizontalArrangement3, verticalAlignment3, flingBehavior3, true, content, $composer2, ($dirty2 & $dirty) | (i4 & $dirty) | ($dirty & 14) | 12582912 | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & i2) | (($dirty << 3) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            contentPadding4 = contentPadding3;
            reverseLayout4 = reverseLayout3;
            horizontalArrangement4 = horizontalArrangement3;
            verticalAlignment4 = verticalAlignment3;
            flingBehavior4 = flingBehavior3;
            state4 = state3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i13) {
                    LazyDslKt.LazyRow(modifier4, state4, contentPadding4, reverseLayout4, horizontalArrangement4, verticalAlignment4, flingBehavior4, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }
}
