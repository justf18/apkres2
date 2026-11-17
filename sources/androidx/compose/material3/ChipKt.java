package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.p000ui.Alignment;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p000ui.graphics.GraphicsLayerScope;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.layout.LayoutKt;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.node.ComposeUiNode;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chip.kt */
@Metadata(m164d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a¦\u0001\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%\u001a¦\u0001\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010'\u001a¹\u0001\u0010(\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0003ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a\u0094\u0001\u00101\u001a\u00020\u00112\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a¦\u0001\u00107\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%\u001a¦\u0001\u00107\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010'\u001a®\u0001\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\u001a\u008f\u0001\u0010=\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010?\u001a\u008f\u0001\u0010=\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010@\u001a®\u0001\u0010A\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\u001aÅ\u0001\u0010B\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010C\u001aÎ\u0001\u0010D\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020:2\b\u0010\u001f\u001a\u0004\u0018\u00010;2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0003ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a\u008f\u0001\u0010G\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010?\u001a\u008f\u0001\u0010G\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010@\u001a&\u0010H\u001a\u00020\u00012\b\b\u0002\u0010I\u001a\u00020\u00192\b\b\u0002\u0010J\u001a\u00020\u00192\b\b\u0002\u0010K\u001a\u00020\u0019H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, m165d2 = {"AssistChipPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "FilterChipPadding", "HorizontalElementsPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LabelLayoutId", "", "LeadingIconLayoutId", "SuggestionChipPadding", "TrailingIconLayoutId", "defaultSuggestionChipColors", "Landroidx/compose/material3/ChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSuggestionChipColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "AssistChip", "", "onClick", "Lkotlin/Function0;", ChipKt.LabelLayoutId, "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", ChipKt.LeadingIconLayoutId, ChipKt.TrailingIconLayoutId, "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "elevation", "Landroidx/compose/material3/ChipElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/ChipBorder;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "minHeight", "paddingValues", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "avatar", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "ElevatedAssistChip", "ElevatedFilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedSuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "InputChip", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SuggestionChip", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "material3_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ChipKt {
    private static final String LabelLayoutId = "label";
    private static final String LeadingIconLayoutId = "leadingIcon";
    private static final String TrailingIconLayoutId = "trailingIcon";
    private static final float HorizontalElementsPadding = C1956Dp.m6297constructorimpl(8);
    private static final PaddingValues AssistChipPadding = PaddingKt.m762PaddingValuesYgX7TsA$default(HorizontalElementsPadding, 0.0f, 2, null);
    private static final PaddingValues FilterChipPadding = PaddingKt.m762PaddingValuesYgX7TsA$default(HorizontalElementsPadding, 0.0f, 2, null);
    private static final PaddingValues SuggestionChipPadding = PaddingKt.m762PaddingValuesYgX7TsA$default(HorizontalElementsPadding, 0.0f, 2, null);

    public static final void AssistChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, ChipColors colors, ChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        boolean z;
        Function2 leadingIcon;
        Function2 function25;
        ChipColors colors2;
        int i2;
        Shape shape2;
        int $dirty;
        ChipColors colors3;
        int $dirty2;
        Modifier modifier3;
        int i3;
        int $dirty1;
        ChipElevation elevation2;
        boolean enabled2;
        BorderStroke border2;
        MutableInteractionSource interactionSource2;
        BorderStroke border3;
        Function2 leadingIcon2;
        ChipElevation elevation3;
        int $dirty3;
        Modifier modifier4;
        Function2 trailingIcon;
        Shape shape3;
        Object value$iv;
        Composer $composer2;
        final Modifier modifier5;
        final boolean enabled3;
        final Function2 leadingIcon3;
        final Function2 trailingIcon2;
        final Shape shape4;
        final ChipColors colors4;
        final ChipElevation elevation4;
        final BorderStroke border4;
        final MutableInteractionSource interactionSource3;
        int $dirty4;
        Composer $composer3 = $composer.startRestartGroup(313450168);
        ComposerKt.sourceInformation($composer3, "C(AssistChip)P(8,5,7,3,6,10,9,1,2)119@6048L5,120@6099L18,121@6170L21,122@6240L25,123@6317L39,129@6493L10,124@6362L507:Chip.kt#uh7d8r");
        int $dirty5 = $changed;
        if ((i & 1) != 0) {
            $dirty5 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty5 |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty5 |= 48;
            function24 = function2;
        } else if (($changed & 48) == 0) {
            function24 = function2;
            $dirty5 |= $composer3.changedInstance(function24) ? 32 : 16;
        } else {
            function24 = function2;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty5 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty5 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty5 |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty5 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty5 |= 24576;
            leadingIcon = function22;
        } else if (($changed & 24576) == 0) {
            leadingIcon = function22;
            $dirty5 |= $composer3.changedInstance(leadingIcon) ? 16384 : 8192;
        } else {
            leadingIcon = function22;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty5 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            function25 = function23;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            function25 = function23;
            $dirty5 |= $composer3.changedInstance(function25) ? 131072 : 65536;
        } else {
            function25 = function23;
        }
        if (($changed & 1572864) == 0) {
            $dirty5 |= ((i & 64) == 0 && $composer3.changed(shape)) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                colors2 = colors;
                int i8 = $composer3.changed(colors2) ? 8388608 : 4194304;
                $dirty5 |= i8;
            } else {
                colors2 = colors;
            }
            $dirty5 |= i8;
        } else {
            colors2 = colors;
        }
        if (($changed & 100663296) == 0) {
            $dirty5 |= ((i & 256) == 0 && $composer3.changed(elevation)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty5 |= ((i & 512) == 0 && $composer3.changed(border)) ? 536870912 : 268435456;
        }
        int $dirty12 = $changed1;
        int $dirty13 = i & 1024;
        if ($dirty13 != 0) {
            $dirty12 |= 6;
            i2 = $dirty13;
        } else if (($changed1 & 6) == 0) {
            i2 = $dirty13;
            $dirty12 |= $composer3.changed(interactionSource) ? 4 : 2;
        } else {
            i2 = $dirty13;
        }
        int $dirty14 = $dirty12;
        int $dirty6 = $dirty5;
        if (($dirty5 & 306783379) == 306783378 && ($dirty14 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            shape4 = shape;
            border4 = border;
            interactionSource3 = interactionSource;
            $dirty1 = $dirty14;
            modifier5 = modifier2;
            $composer2 = $composer3;
            trailingIcon2 = function25;
            colors4 = colors2;
            enabled3 = z;
            leadingIcon3 = leadingIcon;
            elevation4 = elevation;
            $dirty4 = $dirty6;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier6 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i5 != 0 ? true : z;
                if (i6 != 0) {
                    leadingIcon = null;
                }
                Function2 trailingIcon3 = i7 != 0 ? null : function25;
                if ((i & 64) != 0) {
                    $dirty = $dirty6 & (-3670017);
                    shape2 = AssistChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    shape2 = shape;
                    $dirty = $dirty6;
                }
                if ((i & 128) != 0) {
                    colors3 = AssistChipDefaults.INSTANCE.assistChipColors($composer3, 6);
                    $dirty2 = $dirty & (-29360129);
                } else {
                    colors3 = colors2;
                    $dirty2 = $dirty;
                }
                if ((i & 256) != 0) {
                    modifier3 = modifier6;
                    $dirty1 = $dirty14;
                    i3 = 6;
                    $dirty2 &= -234881025;
                    elevation2 = AssistChipDefaults.INSTANCE.m1782assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                } else {
                    modifier3 = modifier6;
                    i3 = 6;
                    $dirty1 = $dirty14;
                    elevation2 = elevation;
                }
                if ((i & 512) != 0) {
                    enabled2 = enabled4;
                    border2 = AssistChipDefaults.INSTANCE.m1780assistChipBorderh1eTWw(enabled2, 0L, 0L, 0.0f, $composer3, (($dirty2 >> 9) & 14) | 24576, 14);
                    $dirty2 &= -1879048193;
                } else {
                    enabled2 = enabled4;
                    border2 = border;
                }
                if (i2 != 0) {
                    $composer3.startReplaceableGroup(839902005);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Chip.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceableGroup();
                    border3 = border2;
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    leadingIcon2 = leadingIcon;
                    elevation3 = elevation2;
                    colors2 = colors3;
                    $dirty3 = $dirty2;
                    modifier4 = modifier3;
                    trailingIcon = trailingIcon3;
                    shape3 = shape2;
                } else {
                    interactionSource2 = interactionSource;
                    border3 = border2;
                    leadingIcon2 = leadingIcon;
                    elevation3 = elevation2;
                    colors2 = colors3;
                    $dirty3 = $dirty2;
                    modifier4 = modifier3;
                    trailingIcon = trailingIcon3;
                    shape3 = shape2;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty7 = (i & 64) != 0 ? $dirty6 & (-3670017) : $dirty6;
                if ((i & 128) != 0) {
                    $dirty7 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty7 &= -234881025;
                }
                if ((i & 512) != 0) {
                    $dirty7 &= -1879048193;
                }
                shape3 = shape;
                elevation3 = elevation;
                border3 = border;
                interactionSource2 = interactionSource;
                $dirty3 = $dirty7;
                i3 = 6;
                trailingIcon = function25;
                enabled2 = z;
                leadingIcon2 = leadingIcon;
                $dirty1 = $dirty14;
                modifier4 = modifier2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(313450168, $dirty3, $dirty1, "androidx.compose.material3.AssistChip (Chip.kt:124)");
            }
            boolean enabled5 = enabled2;
            ChipColors colors5 = colors2;
            $composer2 = $composer3;
            m1883ChipnkUnTEs(modifier4, function0, enabled5, function24, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, i3), AssistChipTokens.INSTANCE.getLabelTextFont()), colors2.m1873labelColorvNxB06k$material3_release(enabled2), leadingIcon2, trailingIcon, shape3, colors5, elevation3, border3, AssistChipDefaults.INSTANCE.m1785getHeightD9Ej5fM(), AssistChipPadding, interactionSource2, $composer2, (($dirty3 >> 6) & 14) | (($dirty3 << 3) & 112) | (($dirty3 >> 3) & 896) | (($dirty3 << 6) & 7168) | (($dirty3 << 6) & 3670016) | (($dirty3 << 6) & 29360128) | (($dirty3 << 6) & 234881024) | (($dirty3 << 6) & 1879048192), (($dirty3 >> 24) & 14) | 3456 | (($dirty3 >> 24) & 112) | (($dirty1 << 12) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            enabled3 = enabled5;
            leadingIcon3 = leadingIcon2;
            trailingIcon2 = trailingIcon;
            shape4 = shape3;
            colors4 = colors5;
            elevation4 = elevation3;
            border4 = border3;
            interactionSource3 = interactionSource2;
            $dirty4 = $dirty3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.AssistChip.2
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

                public final void invoke(Composer composer, int i9) {
                    ChipKt.AssistChip(function0, function2, modifier5, enabled3, leadingIcon3, trailingIcon2, shape4, colors4, elevation4, border4, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with AssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "AssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    public static final /* synthetic */ void AssistChip(final Function0 onClick, final Function2 label, Modifier modifier, boolean enabled, Function2 leadingIcon, Function2 trailingIcon, Shape shape, ChipColors colors, ChipElevation elevation, ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function2 function2;
        Modifier modifier2;
        boolean enabled2;
        Function2 leadingIcon2;
        Function2 function22;
        ChipColors colors2;
        int i2;
        Shape shape2;
        int $dirty;
        ChipColors colors3;
        int $dirty2;
        Modifier modifier3;
        int i3;
        Composer $composer2;
        int $dirty1;
        ChipElevation elevation2;
        ChipBorder border2;
        MutableInteractionSource interactionSource2;
        ChipElevation elevation3;
        int $dirty3;
        Function2 leadingIcon3;
        Function2 trailingIcon2;
        Shape shape3;
        Modifier modifier4;
        Object value$iv;
        Composer $composer3;
        final ChipBorder border3;
        final Modifier modifier5;
        final boolean enabled3;
        final Function2 leadingIcon4;
        final Function2 trailingIcon3;
        final Shape shape4;
        final ChipColors colors4;
        final ChipElevation elevation4;
        final MutableInteractionSource interactionSource3;
        int $dirty4;
        Composer $composer4 = $composer.startRestartGroup(-1932300596);
        ComposerKt.sourceInformation($composer4, "C(AssistChip)P(8,5,7,3,6,10,9,1,2)199@10095L5,200@10146L18,201@10217L21,202@10285L18,203@10355L39,209@10531L10,204@10400L537:Chip.kt#uh7d8r");
        int $dirty5 = $changed;
        if ((i & 1) != 0) {
            $dirty5 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty5 |= $composer4.changedInstance(onClick) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty5 |= 48;
            function2 = label;
        } else if (($changed & 48) == 0) {
            function2 = label;
            $dirty5 |= $composer4.changedInstance(function2) ? 32 : 16;
        } else {
            function2 = label;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty5 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty5 |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty5 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty5 |= $composer4.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty5 |= 24576;
            leadingIcon2 = leadingIcon;
        } else if (($changed & 24576) == 0) {
            leadingIcon2 = leadingIcon;
            $dirty5 |= $composer4.changedInstance(leadingIcon2) ? 16384 : 8192;
        } else {
            leadingIcon2 = leadingIcon;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty5 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            function22 = trailingIcon;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            function22 = trailingIcon;
            $dirty5 |= $composer4.changedInstance(function22) ? 131072 : 65536;
        } else {
            function22 = trailingIcon;
        }
        if (($changed & 1572864) == 0) {
            $dirty5 |= ((i & 64) == 0 && $composer4.changed(shape)) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                colors2 = colors;
                int i8 = $composer4.changed(colors2) ? 8388608 : 4194304;
                $dirty5 |= i8;
            } else {
                colors2 = colors;
            }
            $dirty5 |= i8;
        } else {
            colors2 = colors;
        }
        if (($changed & 100663296) == 0) {
            $dirty5 |= ((i & 256) == 0 && $composer4.changed(elevation)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty5 |= ((i & 512) == 0 && $composer4.changed(border)) ? 536870912 : 268435456;
        }
        int $dirty12 = $changed1;
        int $dirty13 = i & 1024;
        if ($dirty13 != 0) {
            $dirty12 |= 6;
            i2 = $dirty13;
        } else if (($changed1 & 6) == 0) {
            i2 = $dirty13;
            $dirty12 |= $composer4.changed(interactionSource) ? 4 : 2;
        } else {
            i2 = $dirty13;
        }
        int $dirty14 = $dirty12;
        int $dirty6 = $dirty5;
        if (($dirty5 & 306783379) == 306783378 && ($dirty14 & 3) == 2 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            border3 = border;
            interactionSource3 = interactionSource;
            $dirty1 = $dirty14;
            colors4 = colors2;
            modifier5 = modifier2;
            $composer3 = $composer4;
            leadingIcon4 = leadingIcon2;
            shape4 = shape;
            $dirty4 = $dirty6;
            trailingIcon3 = function22;
            enabled3 = enabled2;
            elevation4 = elevation;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                Modifier.Companion modifier6 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i5 != 0 ? true : enabled2;
                if (i6 != 0) {
                    leadingIcon2 = null;
                }
                Function2 trailingIcon4 = i7 != 0 ? null : function22;
                if ((i & 64) != 0) {
                    $dirty = $dirty6 & (-3670017);
                    shape2 = AssistChipDefaults.INSTANCE.getShape($composer4, 6);
                } else {
                    shape2 = shape;
                    $dirty = $dirty6;
                }
                if ((i & 128) != 0) {
                    colors3 = AssistChipDefaults.INSTANCE.assistChipColors($composer4, 6);
                    $dirty2 = $dirty & (-29360129);
                } else {
                    colors3 = colors2;
                    $dirty2 = $dirty;
                }
                if ((i & 256) != 0) {
                    $composer2 = $composer4;
                    modifier3 = modifier6;
                    i3 = 6;
                    $dirty1 = $dirty14;
                    $dirty2 &= -234881025;
                    elevation2 = AssistChipDefaults.INSTANCE.m1782assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer2, 1572864, 63);
                } else {
                    modifier3 = modifier6;
                    i3 = 6;
                    $composer2 = $composer4;
                    $dirty1 = $dirty14;
                    elevation2 = elevation;
                }
                if ((i & 512) != 0) {
                    $composer4 = $composer2;
                    border2 = AssistChipDefaults.INSTANCE.m1779assistChipBorderd_3_b6Q(0L, 0L, 0.0f, $composer4, 3072, 7);
                    $dirty2 &= -1879048193;
                } else {
                    $composer4 = $composer2;
                    border2 = border;
                }
                if (i2 != 0) {
                    $composer4.startReplaceableGroup(839906043);
                    ComposerKt.sourceInformation($composer4, "CC(remember):Chip.kt#9igjgp");
                    Composer $this$cache$iv = $composer4;
                    Object it$iv = $this$cache$iv.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    elevation3 = elevation2;
                    enabled2 = enabled4;
                    colors2 = colors3;
                    $dirty3 = $dirty2;
                    leadingIcon3 = leadingIcon2;
                    trailingIcon2 = trailingIcon4;
                    shape3 = shape2;
                    modifier4 = modifier3;
                } else {
                    interactionSource2 = interactionSource;
                    elevation3 = elevation2;
                    enabled2 = enabled4;
                    colors2 = colors3;
                    $dirty3 = $dirty2;
                    leadingIcon3 = leadingIcon2;
                    trailingIcon2 = trailingIcon4;
                    shape3 = shape2;
                    modifier4 = modifier3;
                }
            } else {
                $composer4.skipToGroupEnd();
                int $dirty7 = (i & 64) != 0 ? $dirty6 & (-3670017) : $dirty6;
                if ((i & 128) != 0) {
                    $dirty7 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty7 &= -234881025;
                }
                if ((i & 512) != 0) {
                    $dirty7 &= -1879048193;
                }
                shape3 = shape;
                elevation3 = elevation;
                border2 = border;
                interactionSource2 = interactionSource;
                i3 = 6;
                trailingIcon2 = function22;
                leadingIcon3 = leadingIcon2;
                $dirty3 = $dirty7;
                modifier4 = modifier2;
                $dirty1 = $dirty14;
            }
            $composer4.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1932300596, $dirty3, $dirty1, "androidx.compose.material3.AssistChip (Chip.kt:204)");
            }
            TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer4, i3), AssistChipTokens.INSTANCE.getLabelTextFont());
            long jM1873labelColorvNxB06k$material3_release = colors2.m1873labelColorvNxB06k$material3_release(enabled2);
            $composer4.startReplaceableGroup(839906470);
            ComposerKt.sourceInformation($composer4, "216@10782L21");
            State<BorderStroke> stateBorderStroke$material3_release = border2 == null ? null : border2.borderStroke$material3_release(enabled2, $composer4, (($dirty3 >> 9) & 14) | (($dirty3 >> 24) & 112));
            $composer4.endReplaceableGroup();
            ChipColors colors5 = colors2;
            $composer3 = $composer4;
            boolean enabled5 = enabled2;
            m1883ChipnkUnTEs(modifier4, onClick, enabled5, function2, textStyleFromToken, jM1873labelColorvNxB06k$material3_release, leadingIcon3, trailingIcon2, shape3, colors5, elevation3, stateBorderStroke$material3_release != null ? stateBorderStroke$material3_release.getValue() : null, AssistChipDefaults.INSTANCE.m1785getHeightD9Ej5fM(), AssistChipPadding, interactionSource2, $composer3, (($dirty3 >> 6) & 14) | (($dirty3 << 3) & 112) | (($dirty3 >> 3) & 896) | (($dirty3 << 6) & 7168) | (($dirty3 << 6) & 3670016) | (($dirty3 << 6) & 29360128) | (($dirty3 << 6) & 234881024) | (($dirty3 << 6) & 1879048192), (($dirty3 >> 24) & 14) | 3456 | (($dirty1 << 12) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            border3 = border2;
            modifier5 = modifier4;
            enabled3 = enabled5;
            leadingIcon4 = leadingIcon3;
            trailingIcon3 = trailingIcon2;
            shape4 = shape3;
            colors4 = colors5;
            elevation4 = elevation3;
            interactionSource3 = interactionSource2;
            $dirty4 = $dirty3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.AssistChip.4
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

                public final void invoke(Composer composer, int i9) {
                    ChipKt.AssistChip(onClick, label, modifier5, enabled3, leadingIcon4, trailingIcon3, shape4, colors4, elevation4, border3, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void ElevatedAssistChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, ChipColors colors, ChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        boolean enabled2;
        Function2 leadingIcon;
        Function2 function25;
        ChipColors colors2;
        int i2;
        int i3;
        Shape shape2;
        int $dirty;
        ChipColors colors3;
        int $dirty2;
        Modifier modifier3;
        int i4;
        int $dirty1;
        ChipElevation elevation2;
        MutableInteractionSource interactionSource2;
        ChipElevation elevation3;
        BorderStroke border2;
        Function2 leadingIcon2;
        int $dirty3;
        Modifier modifier4;
        Function2 trailingIcon;
        Shape shape3;
        Object value$iv;
        Composer $composer2;
        final Modifier modifier5;
        final boolean enabled3;
        final Function2 leadingIcon3;
        final Function2 trailingIcon2;
        final Shape shape4;
        final ChipColors colors4;
        final ChipElevation elevation4;
        final BorderStroke border3;
        final MutableInteractionSource interactionSource3;
        int $dirty4;
        Composer $composer3 = $composer.startRestartGroup(1594789934);
        ComposerKt.sourceInformation($composer3, "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)270@13792L5,271@13843L26,272@13922L29,274@14037L39,280@14212L10,275@14081L507:Chip.kt#uh7d8r");
        int $dirty5 = $changed;
        if ((i & 1) != 0) {
            $dirty5 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty5 |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty5 |= 48;
            function24 = function2;
        } else if (($changed & 48) == 0) {
            function24 = function2;
            $dirty5 |= $composer3.changedInstance(function24) ? 32 : 16;
        } else {
            function24 = function2;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty5 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty5 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty5 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty5 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty5 |= 24576;
            leadingIcon = function22;
        } else if (($changed & 24576) == 0) {
            leadingIcon = function22;
            $dirty5 |= $composer3.changedInstance(leadingIcon) ? 16384 : 8192;
        } else {
            leadingIcon = function22;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty5 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            function25 = function23;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            function25 = function23;
            $dirty5 |= $composer3.changedInstance(function25) ? 131072 : 65536;
        } else {
            function25 = function23;
        }
        if (($changed & 1572864) == 0) {
            $dirty5 |= ((i & 64) == 0 && $composer3.changed(shape)) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                colors2 = colors;
                int i9 = $composer3.changed(colors2) ? 8388608 : 4194304;
                $dirty5 |= i9;
            } else {
                colors2 = colors;
            }
            $dirty5 |= i9;
        } else {
            colors2 = colors;
        }
        if (($changed & 100663296) == 0) {
            $dirty5 |= ((i & 256) == 0 && $composer3.changed(elevation)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty12 = $changed1;
        int $dirty13 = i & 512;
        if ($dirty13 != 0) {
            $dirty5 |= 805306368;
            i2 = $dirty13;
        } else if (($changed & 805306368) == 0) {
            i2 = $dirty13;
            $dirty5 |= $composer3.changed(border) ? 536870912 : 268435456;
        } else {
            i2 = $dirty13;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty12 |= 6;
            i3 = i10;
        } else if (($changed1 & 6) == 0) {
            i3 = i10;
            $dirty12 |= $composer3.changed(interactionSource) ? 4 : 2;
        } else {
            i3 = i10;
        }
        int $dirty14 = $dirty12;
        int $dirty6 = $dirty5;
        if (($dirty5 & 306783379) == 306783378 && ($dirty14 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            shape4 = shape;
            border3 = border;
            interactionSource3 = interactionSource;
            $dirty1 = $dirty14;
            modifier5 = modifier2;
            $composer2 = $composer3;
            trailingIcon2 = function25;
            colors4 = colors2;
            enabled3 = enabled2;
            leadingIcon3 = leadingIcon;
            elevation4 = elevation;
            $dirty4 = $dirty6;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier6 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i6 != 0 ? true : enabled2;
                if (i7 != 0) {
                    leadingIcon = null;
                }
                Function2 trailingIcon3 = i8 != 0 ? null : function25;
                if ((i & 64) != 0) {
                    $dirty = $dirty6 & (-3670017);
                    shape2 = AssistChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    shape2 = shape;
                    $dirty = $dirty6;
                }
                if ((i & 128) != 0) {
                    colors3 = AssistChipDefaults.INSTANCE.elevatedAssistChipColors($composer3, 6);
                    $dirty2 = $dirty & (-29360129);
                } else {
                    colors3 = colors2;
                    $dirty2 = $dirty;
                }
                if ((i & 256) != 0) {
                    modifier3 = modifier6;
                    $dirty1 = $dirty14;
                    i4 = 6;
                    elevation2 = AssistChipDefaults.INSTANCE.m1784elevatedAssistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty2 &= -234881025;
                } else {
                    modifier3 = modifier6;
                    i4 = 6;
                    $dirty1 = $dirty14;
                    elevation2 = elevation;
                }
                BorderStroke border4 = i2 != 0 ? null : border;
                if (i3 != 0) {
                    $composer3.startReplaceableGroup(-227035565);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Chip.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceableGroup();
                    elevation3 = elevation2;
                    border2 = border4;
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    leadingIcon2 = leadingIcon;
                    enabled2 = enabled4;
                    colors2 = colors3;
                    $dirty3 = $dirty2;
                    modifier4 = modifier3;
                    trailingIcon = trailingIcon3;
                    shape3 = shape2;
                } else {
                    interactionSource2 = interactionSource;
                    elevation3 = elevation2;
                    border2 = border4;
                    leadingIcon2 = leadingIcon;
                    enabled2 = enabled4;
                    colors2 = colors3;
                    $dirty3 = $dirty2;
                    modifier4 = modifier3;
                    trailingIcon = trailingIcon3;
                    shape3 = shape2;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty7 = (i & 64) != 0 ? $dirty6 & (-3670017) : $dirty6;
                if ((i & 128) != 0) {
                    $dirty7 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty7 &= -234881025;
                }
                shape3 = shape;
                elevation3 = elevation;
                border2 = border;
                interactionSource2 = interactionSource;
                $dirty3 = $dirty7;
                i4 = 6;
                trailingIcon = function25;
                $dirty1 = $dirty14;
                leadingIcon2 = leadingIcon;
                modifier4 = modifier2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1594789934, $dirty3, $dirty1, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:275)");
            }
            ChipColors colors5 = colors2;
            $composer2 = $composer3;
            boolean enabled5 = enabled2;
            m1883ChipnkUnTEs(modifier4, function0, enabled5, function24, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, i4), AssistChipTokens.INSTANCE.getLabelTextFont()), colors2.m1873labelColorvNxB06k$material3_release(enabled2), leadingIcon2, trailingIcon, shape3, colors5, elevation3, border2, AssistChipDefaults.INSTANCE.m1785getHeightD9Ej5fM(), AssistChipPadding, interactionSource2, $composer2, (($dirty3 >> 6) & 14) | (($dirty3 << 3) & 112) | (($dirty3 >> 3) & 896) | (($dirty3 << 6) & 7168) | (($dirty3 << 6) & 3670016) | (($dirty3 << 6) & 29360128) | (($dirty3 << 6) & 234881024) | (($dirty3 << 6) & 1879048192), (($dirty3 >> 24) & 14) | 3456 | (($dirty3 >> 24) & 112) | (($dirty1 << 12) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            enabled3 = enabled5;
            leadingIcon3 = leadingIcon2;
            trailingIcon2 = trailingIcon;
            shape4 = shape3;
            colors4 = colors5;
            elevation4 = elevation3;
            border3 = border2;
            interactionSource3 = interactionSource2;
            $dirty4 = $dirty3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.ElevatedAssistChip.2
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

                public final void invoke(Composer composer, int i11) {
                    ChipKt.ElevatedAssistChip(function0, function2, modifier5, enabled3, leadingIcon3, trailingIcon2, shape4, colors4, elevation4, border3, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedAssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "ElevatedAssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    public static final /* synthetic */ void ElevatedAssistChip(final Function0 onClick, final Function2 label, Modifier modifier, boolean enabled, Function2 leadingIcon, Function2 trailingIcon, Shape shape, ChipColors colors, ChipElevation elevation, ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function2 function2;
        Modifier modifier2;
        boolean enabled2;
        Function2 leadingIcon2;
        Function2 function22;
        ChipColors colors2;
        int i2;
        int i3;
        Shape shape2;
        int $dirty;
        ChipColors colors3;
        int $dirty2;
        Modifier modifier3;
        int i4;
        int $dirty1;
        ChipElevation elevation2;
        ChipBorder border2;
        MutableInteractionSource interactionSource2;
        ChipElevation elevation3;
        Function2 leadingIcon3;
        int $dirty3;
        Modifier modifier4;
        Function2 trailingIcon2;
        Shape shape3;
        Object value$iv;
        Composer $composer2;
        final ChipBorder border3;
        final Modifier modifier5;
        final boolean enabled3;
        final Function2 leadingIcon4;
        final Function2 trailingIcon3;
        final Shape shape4;
        final ChipColors colors4;
        final ChipElevation elevation4;
        final MutableInteractionSource interactionSource3;
        int $dirty4;
        Composer $composer3 = $composer.startRestartGroup(1295844802);
        ComposerKt.sourceInformation($composer3, "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)349@17824L5,350@17875L26,351@17954L29,353@18067L39,359@18242L10,354@18111L537:Chip.kt#uh7d8r");
        int $dirty5 = $changed;
        if ((i & 1) != 0) {
            $dirty5 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty5 |= $composer3.changedInstance(onClick) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty5 |= 48;
            function2 = label;
        } else if (($changed & 48) == 0) {
            function2 = label;
            $dirty5 |= $composer3.changedInstance(function2) ? 32 : 16;
        } else {
            function2 = label;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty5 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty5 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty5 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 3072) == 0) {
            enabled2 = enabled;
            $dirty5 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty5 |= 24576;
            leadingIcon2 = leadingIcon;
        } else if (($changed & 24576) == 0) {
            leadingIcon2 = leadingIcon;
            $dirty5 |= $composer3.changedInstance(leadingIcon2) ? 16384 : 8192;
        } else {
            leadingIcon2 = leadingIcon;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty5 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            function22 = trailingIcon;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            function22 = trailingIcon;
            $dirty5 |= $composer3.changedInstance(function22) ? 131072 : 65536;
        } else {
            function22 = trailingIcon;
        }
        if (($changed & 1572864) == 0) {
            $dirty5 |= ((i & 64) == 0 && $composer3.changed(shape)) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                colors2 = colors;
                int i9 = $composer3.changed(colors2) ? 8388608 : 4194304;
                $dirty5 |= i9;
            } else {
                colors2 = colors;
            }
            $dirty5 |= i9;
        } else {
            colors2 = colors;
        }
        if (($changed & 100663296) == 0) {
            $dirty5 |= ((i & 256) == 0 && $composer3.changed(elevation)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty12 = $changed1;
        int $dirty13 = i & 512;
        if ($dirty13 != 0) {
            $dirty5 |= 805306368;
            i2 = $dirty13;
        } else if (($changed & 805306368) == 0) {
            i2 = $dirty13;
            $dirty5 |= $composer3.changed(border) ? 536870912 : 268435456;
        } else {
            i2 = $dirty13;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty12 |= 6;
            i3 = i10;
        } else if (($changed1 & 6) == 0) {
            i3 = i10;
            $dirty12 |= $composer3.changed(interactionSource) ? 4 : 2;
        } else {
            i3 = i10;
        }
        int $dirty14 = $dirty12;
        int $dirty6 = $dirty5;
        if (($dirty5 & 306783379) == 306783378 && ($dirty14 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            shape4 = shape;
            border3 = border;
            interactionSource3 = interactionSource;
            $dirty1 = $dirty14;
            modifier5 = modifier2;
            $composer2 = $composer3;
            trailingIcon3 = function22;
            colors4 = colors2;
            enabled3 = enabled2;
            leadingIcon4 = leadingIcon2;
            elevation4 = elevation;
            $dirty4 = $dirty6;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier6 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i6 != 0 ? true : enabled2;
                if (i7 != 0) {
                    leadingIcon2 = null;
                }
                Function2 trailingIcon4 = i8 != 0 ? null : function22;
                if ((i & 64) != 0) {
                    $dirty = $dirty6 & (-3670017);
                    shape2 = AssistChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    shape2 = shape;
                    $dirty = $dirty6;
                }
                if ((i & 128) != 0) {
                    colors3 = AssistChipDefaults.INSTANCE.elevatedAssistChipColors($composer3, 6);
                    $dirty2 = $dirty & (-29360129);
                } else {
                    colors3 = colors2;
                    $dirty2 = $dirty;
                }
                if ((i & 256) != 0) {
                    modifier3 = modifier6;
                    $dirty1 = $dirty14;
                    i4 = 6;
                    elevation2 = AssistChipDefaults.INSTANCE.m1784elevatedAssistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty2 &= -234881025;
                } else {
                    modifier3 = modifier6;
                    i4 = 6;
                    $dirty1 = $dirty14;
                    elevation2 = elevation;
                }
                border2 = i2 != 0 ? null : border;
                if (i3 != 0) {
                    $composer3.startReplaceableGroup(-227031535);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Chip.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceableGroup();
                    elevation3 = elevation2;
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    leadingIcon3 = leadingIcon2;
                    enabled2 = enabled4;
                    colors2 = colors3;
                    $dirty3 = $dirty2;
                    modifier4 = modifier3;
                    trailingIcon2 = trailingIcon4;
                    shape3 = shape2;
                } else {
                    interactionSource2 = interactionSource;
                    elevation3 = elevation2;
                    leadingIcon3 = leadingIcon2;
                    enabled2 = enabled4;
                    colors2 = colors3;
                    $dirty3 = $dirty2;
                    modifier4 = modifier3;
                    trailingIcon2 = trailingIcon4;
                    shape3 = shape2;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty7 = (i & 64) != 0 ? $dirty6 & (-3670017) : $dirty6;
                if ((i & 128) != 0) {
                    $dirty7 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty7 &= -234881025;
                }
                shape3 = shape;
                elevation3 = elevation;
                interactionSource2 = interactionSource;
                $dirty3 = $dirty7;
                i4 = 6;
                trailingIcon2 = function22;
                $dirty1 = $dirty14;
                border2 = border;
                leadingIcon3 = leadingIcon2;
                modifier4 = modifier2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1295844802, $dirty3, $dirty1, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:354)");
            }
            TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, i4), AssistChipTokens.INSTANCE.getLabelTextFont());
            long jM1873labelColorvNxB06k$material3_release = colors2.m1873labelColorvNxB06k$material3_release(enabled2);
            float fM1785getHeightD9Ej5fM = AssistChipDefaults.INSTANCE.m1785getHeightD9Ej5fM();
            PaddingValues paddingValues = AssistChipPadding;
            $composer3.startReplaceableGroup(-227031027);
            ComposerKt.sourceInformation($composer3, "368@18575L21");
            State<BorderStroke> stateBorderStroke$material3_release = border2 == null ? null : border2.borderStroke$material3_release(enabled2, $composer3, (($dirty3 >> 9) & 14) | (($dirty3 >> 24) & 112));
            $composer3.endReplaceableGroup();
            ChipColors colors5 = colors2;
            $composer2 = $composer3;
            boolean enabled5 = enabled2;
            m1883ChipnkUnTEs(modifier4, onClick, enabled5, function2, textStyleFromToken, jM1873labelColorvNxB06k$material3_release, leadingIcon3, trailingIcon2, shape3, colors5, elevation3, stateBorderStroke$material3_release != null ? stateBorderStroke$material3_release.getValue() : null, fM1785getHeightD9Ej5fM, paddingValues, interactionSource2, $composer2, (($dirty3 >> 6) & 14) | (($dirty3 << 3) & 112) | (($dirty3 >> 3) & 896) | (($dirty3 << 6) & 7168) | (($dirty3 << 6) & 3670016) | (($dirty3 << 6) & 29360128) | (($dirty3 << 6) & 234881024) | (($dirty3 << 6) & 1879048192), (($dirty3 >> 24) & 14) | 3456 | (($dirty1 << 12) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            border3 = border2;
            modifier5 = modifier4;
            enabled3 = enabled5;
            leadingIcon4 = leadingIcon3;
            trailingIcon3 = trailingIcon2;
            shape4 = shape3;
            colors4 = colors5;
            elevation4 = elevation3;
            interactionSource3 = interactionSource2;
            $dirty4 = $dirty3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.ElevatedAssistChip.4
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

                public final void invoke(Composer composer, int i11) {
                    ChipKt.ElevatedAssistChip(onClick, label, modifier5, enabled3, leadingIcon4, trailingIcon3, shape4, colors4, elevation4, border3, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void FilterChip(final boolean selected, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SelectableChipColors colors, SelectableChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        boolean z2;
        Function2 function25;
        Function2 function26;
        Shape shape2;
        int i2;
        MutableInteractionSource mutableInteractionSource;
        int $dirty1;
        int $dirty;
        Shape shape3;
        SelectableChipColors colors2;
        int $dirty2;
        Modifier modifier3;
        int $dirty3;
        int i3;
        SelectableChipElevation elevation2;
        int $dirty4;
        boolean enabled2;
        BorderStroke border2;
        MutableInteractionSource interactionSource2;
        SelectableChipElevation elevation3;
        int $dirty5;
        BorderStroke border3;
        boolean enabled3;
        int $dirty12;
        Function2 leadingIcon;
        Function2 trailingIcon;
        Shape shape4;
        SelectableChipColors colors3;
        Modifier modifier4;
        Object value$iv;
        Composer $composer2;
        final Modifier modifier5;
        final boolean enabled4;
        final Function2 leadingIcon2;
        final Function2 trailingIcon2;
        final Shape shape5;
        final SelectableChipColors colors4;
        final SelectableChipElevation elevation4;
        final BorderStroke border4;
        final MutableInteractionSource interactionSource3;
        Composer $composer3 = $composer.startRestartGroup(-1711985619);
        ComposerKt.sourceInformation($composer3, "C(FilterChip)P(9,8,5,7,3,6,11,10,1,2)430@21945L5,431@22006L18,432@22087L21,433@22157L35,434@22244L39,441@22454L10,435@22288L516:Chip.kt#uh7d8r");
        int $dirty6 = $changed;
        int $dirty13 = $changed1;
        if ((i & 1) != 0) {
            $dirty6 |= 6;
            z = selected;
        } else if (($changed & 6) == 0) {
            z = selected;
            $dirty6 |= $composer3.changed(z) ? 4 : 2;
        } else {
            z = selected;
        }
        if ((i & 2) != 0) {
            $dirty6 |= 48;
            function02 = function0;
        } else if (($changed & 48) == 0) {
            function02 = function0;
            $dirty6 |= $composer3.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        if ((i & 4) != 0) {
            $dirty6 |= 384;
            function24 = function2;
        } else if (($changed & 384) == 0) {
            function24 = function2;
            $dirty6 |= $composer3.changedInstance(function24) ? 256 : 128;
        } else {
            function24 = function2;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty6 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty6 |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty6 |= 24576;
            z2 = enabled;
        } else if (($changed & 24576) == 0) {
            z2 = enabled;
            $dirty6 |= $composer3.changed(z2) ? 16384 : 8192;
        } else {
            z2 = enabled;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty6 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            function25 = function22;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            function25 = function22;
            $dirty6 |= $composer3.changedInstance(function25) ? 131072 : 65536;
        } else {
            function25 = function22;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty6 |= 1572864;
            function26 = function23;
        } else if (($changed & 1572864) == 0) {
            function26 = function23;
            $dirty6 |= $composer3.changedInstance(function26) ? 1048576 : 524288;
        } else {
            function26 = function23;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                shape2 = shape;
                int i8 = $composer3.changed(shape2) ? 8388608 : 4194304;
                $dirty6 |= i8;
            } else {
                shape2 = shape;
            }
            $dirty6 |= i8;
        } else {
            shape2 = shape;
        }
        if (($changed & 100663296) == 0) {
            $dirty6 |= ((i & 256) == 0 && $composer3.changed(colors)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty6 |= ((i & 512) == 0 && $composer3.changed(elevation)) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty13 |= ((i & 1024) == 0 && $composer3.changed(border)) ? 4 : 2;
        }
        int $dirty14 = $dirty13;
        int $dirty15 = i & 2048;
        if ($dirty15 != 0) {
            $dirty1 = $dirty14 | 48;
            i2 = $dirty15;
            mutableInteractionSource = interactionSource;
        } else if (($changed1 & 48) == 0) {
            i2 = $dirty15;
            mutableInteractionSource = interactionSource;
            $dirty1 = $dirty14 | ($composer3.changed(mutableInteractionSource) ? 32 : 16);
        } else {
            i2 = $dirty15;
            mutableInteractionSource = interactionSource;
            $dirty1 = $dirty14;
        }
        int $dirty7 = $dirty6;
        if (($dirty6 & 306783379) == 306783378 && ($dirty1 & 19) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            elevation4 = elevation;
            border4 = border;
            interactionSource3 = mutableInteractionSource;
            $composer2 = $composer3;
            shape5 = shape2;
            trailingIcon2 = function26;
            leadingIcon2 = function25;
            enabled4 = z2;
            modifier5 = modifier2;
            colors4 = colors;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier6 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled5 = i5 != 0 ? true : z2;
                Function2 leadingIcon3 = i6 != 0 ? null : function25;
                Function2 trailingIcon3 = i7 != 0 ? null : function26;
                if ((i & 128) != 0) {
                    $dirty = $dirty7 & (-29360129);
                    shape3 = FilterChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    $dirty = $dirty7;
                    shape3 = shape2;
                }
                if ((i & 256) != 0) {
                    colors2 = FilterChipDefaults.INSTANCE.filterChipColors($composer3, 6);
                    $dirty2 = $dirty & (-234881025);
                } else {
                    colors2 = colors;
                    $dirty2 = $dirty;
                }
                if ((i & 512) != 0) {
                    modifier3 = modifier6;
                    i3 = i2;
                    $dirty3 = 6;
                    elevation2 = FilterChipDefaults.INSTANCE.m2106filterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty4 = $dirty2 & (-1879048193);
                } else {
                    modifier3 = modifier6;
                    $dirty3 = 6;
                    i3 = i2;
                    elevation2 = elevation;
                    $dirty4 = $dirty2;
                }
                if ((i & 1024) != 0) {
                    enabled2 = enabled5;
                    border2 = FilterChipDefaults.INSTANCE.m2104filterChipBorder_7El2pE(enabled2, z, 0L, 0L, 0L, 0L, 0.0f, 0.0f, $composer3, (($dirty4 >> 12) & 14) | 100663296 | (($dirty4 << 3) & 112), 252);
                    $dirty1 &= -15;
                } else {
                    enabled2 = enabled5;
                    border2 = border;
                }
                if (i3 != 0) {
                    $composer3.startReplaceableGroup(276179389);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Chip.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceableGroup();
                    elevation3 = elevation2;
                    $dirty5 = $dirty4;
                    border3 = border2;
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    enabled3 = enabled2;
                    $dirty12 = $dirty1;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    shape4 = shape3;
                    colors3 = colors2;
                    modifier4 = modifier3;
                } else {
                    interactionSource2 = interactionSource;
                    elevation3 = elevation2;
                    $dirty5 = $dirty4;
                    border3 = border2;
                    enabled3 = enabled2;
                    $dirty12 = $dirty1;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    shape4 = shape3;
                    colors3 = colors2;
                    modifier4 = modifier3;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty8 = (i & 128) != 0 ? $dirty7 & (-29360129) : $dirty7;
                if ((i & 256) != 0) {
                    $dirty8 &= -234881025;
                }
                if ((i & 512) != 0) {
                    $dirty8 &= -1879048193;
                }
                if ((i & 1024) != 0) {
                    $dirty12 = $dirty1 & (-15);
                    $dirty5 = $dirty8;
                    $dirty3 = 6;
                    colors3 = colors;
                    elevation3 = elevation;
                    border3 = border;
                    interactionSource2 = mutableInteractionSource;
                    enabled3 = z2;
                    leadingIcon = function25;
                    trailingIcon = function26;
                    shape4 = shape2;
                    modifier4 = modifier2;
                } else {
                    $dirty5 = $dirty8;
                    $dirty3 = 6;
                    colors3 = colors;
                    elevation3 = elevation;
                    border3 = border;
                    interactionSource2 = mutableInteractionSource;
                    enabled3 = z2;
                    leadingIcon = function25;
                    trailingIcon = function26;
                    shape4 = shape2;
                    modifier4 = modifier2;
                    $dirty12 = $dirty1;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1711985619, $dirty5, $dirty12, "androidx.compose.material3.FilterChip (Chip.kt:435)");
            }
            $composer2 = $composer3;
            m1885SelectableChipu0RnIRE(selected, modifier4, function02, enabled3, function24, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, $dirty3), FilterChipTokens.INSTANCE.getLabelTextFont()), leadingIcon, null, trailingIcon, shape4, colors3, elevation3, border3, FilterChipDefaults.INSTANCE.m2107getHeightD9Ej5fM(), FilterChipPadding, interactionSource2, $composer2, ($dirty5 & 14) | 12582912 | (($dirty5 >> 6) & 112) | (($dirty5 << 3) & 896) | (($dirty5 >> 3) & 7168) | (($dirty5 << 6) & 57344) | (($dirty5 << 3) & 3670016) | (($dirty5 << 6) & 234881024) | (($dirty5 << 6) & 1879048192), (($dirty5 >> 24) & 14) | 27648 | (($dirty5 >> 24) & 112) | (($dirty12 << 6) & 896) | (($dirty12 << 12) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            enabled4 = enabled3;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            shape5 = shape4;
            colors4 = colors3;
            elevation4 = elevation3;
            border4 = border3;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.FilterChip.2
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

                public final void invoke(Composer composer, int i9) {
                    ChipKt.FilterChip(selected, function0, function2, modifier5, enabled4, leadingIcon2, trailingIcon2, shape5, colors4, elevation4, border4, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void ElevatedFilterChip(final boolean selected, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SelectableChipColors colors, SelectableChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1, final int i) {
        Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        boolean z;
        Function2 function25;
        Function2 function26;
        Shape shape2;
        int i2;
        int $dirty1;
        int i3;
        int $dirty;
        Shape shape3;
        SelectableChipColors colors2;
        int $dirty2;
        Modifier modifier3;
        int i4;
        int $dirty12;
        SelectableChipElevation elevation2;
        MutableInteractionSource interactionSource2;
        SelectableChipElevation elevation3;
        BorderStroke border2;
        Function2 leadingIcon;
        Function2 trailingIcon;
        boolean enabled2;
        int $dirty3;
        int i5;
        SelectableChipColors colors3;
        Shape shape4;
        Modifier modifier4;
        Object value$iv;
        Composer $composer2;
        final Modifier modifier5;
        final boolean enabled3;
        final Function2 leadingIcon2;
        final Function2 trailingIcon2;
        final Shape shape5;
        final SelectableChipColors colors4;
        final SelectableChipElevation elevation4;
        final BorderStroke border3;
        final MutableInteractionSource interactionSource3;
        Composer $composer3 = $composer.startRestartGroup(-106647389);
        ComposerKt.sourceInformation($composer3, "C(ElevatedFilterChip)P(9,8,5,7,3,6,11,10,1,2)509@25986L5,510@26047L26,511@26136L29,513@26251L39,520@26461L10,514@26295L516:Chip.kt#uh7d8r");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty4 |= $composer3.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
            function02 = function0;
        } else if (($changed & 48) == 0) {
            function02 = function0;
            $dirty4 |= $composer3.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        if ((i & 4) != 0) {
            $dirty4 |= 384;
            function24 = function2;
        } else if (($changed & 384) == 0) {
            function24 = function2;
            $dirty4 |= $composer3.changedInstance(function24) ? 256 : 128;
        } else {
            function24 = function2;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty4 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty4 |= 24576;
            z = enabled;
        } else if (($changed & 24576) == 0) {
            z = enabled;
            $dirty4 |= $composer3.changed(z) ? 16384 : 8192;
        } else {
            z = enabled;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            function25 = function22;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            function25 = function22;
            $dirty4 |= $composer3.changedInstance(function25) ? 131072 : 65536;
        } else {
            function25 = function22;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty4 |= 1572864;
            function26 = function23;
        } else if (($changed & 1572864) == 0) {
            function26 = function23;
            $dirty4 |= $composer3.changedInstance(function26) ? 1048576 : 524288;
        } else {
            function26 = function23;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0) {
                shape2 = shape;
                int i10 = $composer3.changed(shape2) ? 8388608 : 4194304;
                $dirty4 |= i10;
            } else {
                shape2 = shape;
            }
            $dirty4 |= i10;
        } else {
            shape2 = shape;
        }
        if (($changed & 100663296) == 0) {
            $dirty4 |= ((i & 256) == 0 && $composer3.changed(colors)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty4 |= ((i & 512) == 0 && $composer3.changed(elevation)) ? 536870912 : 268435456;
        }
        int $dirty13 = i & 1024;
        if ($dirty13 != 0) {
            $dirty1 = $changed1 | 6;
            i2 = $dirty13;
        } else if (($changed1 & 6) == 0) {
            i2 = $dirty13;
            $dirty1 = $changed1 | ($composer3.changed(border) ? 4 : 2);
        } else {
            i2 = $dirty13;
            $dirty1 = $changed1;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty1 |= 48;
            i3 = i11;
        } else if (($changed1 & 48) == 0) {
            i3 = i11;
            $dirty1 |= $composer3.changed(interactionSource) ? 32 : 16;
        } else {
            i3 = i11;
        }
        int $dirty14 = $dirty1;
        int $dirty5 = $dirty4;
        if (($dirty4 & 306783379) == 306783378 && ($dirty14 & 19) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            elevation4 = elevation;
            border3 = border;
            interactionSource3 = interactionSource;
            $dirty12 = $dirty14;
            $composer2 = $composer3;
            shape5 = shape2;
            trailingIcon2 = function26;
            leadingIcon2 = function25;
            enabled3 = z;
            modifier5 = modifier2;
            colors4 = colors;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier6 = i6 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i7 != 0 ? true : z;
                Function2 leadingIcon3 = i8 != 0 ? null : function25;
                Function2 trailingIcon3 = i9 != 0 ? null : function26;
                if ((i & 128) != 0) {
                    $dirty = $dirty5 & (-29360129);
                    shape3 = FilterChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    $dirty = $dirty5;
                    shape3 = shape2;
                }
                if ((i & 256) != 0) {
                    colors2 = FilterChipDefaults.INSTANCE.elevatedFilterChipColors($composer3, 6);
                    $dirty2 = $dirty & (-234881025);
                } else {
                    colors2 = colors;
                    $dirty2 = $dirty;
                }
                if ((i & 512) != 0) {
                    modifier3 = modifier6;
                    $dirty12 = $dirty14;
                    i4 = 6;
                    elevation2 = FilterChipDefaults.INSTANCE.m2103elevatedFilterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty2 &= -1879048193;
                } else {
                    modifier3 = modifier6;
                    i4 = 6;
                    $dirty12 = $dirty14;
                    elevation2 = elevation;
                }
                BorderStroke border4 = i2 != 0 ? null : border;
                if (i3 != 0) {
                    $composer3.startReplaceableGroup(-790761894);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Chip.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceableGroup();
                    elevation3 = elevation2;
                    border2 = border4;
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    enabled2 = enabled4;
                    $dirty3 = $dirty2;
                    i5 = -106647389;
                    colors3 = colors2;
                    shape4 = shape3;
                    modifier4 = modifier3;
                } else {
                    interactionSource2 = interactionSource;
                    elevation3 = elevation2;
                    border2 = border4;
                    leadingIcon = leadingIcon3;
                    trailingIcon = trailingIcon3;
                    enabled2 = enabled4;
                    $dirty3 = $dirty2;
                    i5 = -106647389;
                    colors3 = colors2;
                    shape4 = shape3;
                    modifier4 = modifier3;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty6 = (i & 128) != 0 ? $dirty5 & (-29360129) : $dirty5;
                if ((i & 256) != 0) {
                    $dirty6 &= -234881025;
                }
                if ((i & 512) != 0) {
                    $dirty6 &= -1879048193;
                }
                colors3 = colors;
                elevation3 = elevation;
                border2 = border;
                interactionSource2 = interactionSource;
                $dirty3 = $dirty6;
                i4 = 6;
                leadingIcon = function25;
                trailingIcon = function26;
                shape4 = shape2;
                modifier4 = modifier2;
                $dirty12 = $dirty14;
                i5 = -106647389;
                enabled2 = z;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i5, $dirty3, $dirty12, "androidx.compose.material3.ElevatedFilterChip (Chip.kt:514)");
            }
            $composer2 = $composer3;
            m1885SelectableChipu0RnIRE(selected, modifier4, function02, enabled2, function24, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, i4), FilterChipTokens.INSTANCE.getLabelTextFont()), leadingIcon, null, trailingIcon, shape4, colors3, elevation3, border2, FilterChipDefaults.INSTANCE.m2107getHeightD9Ej5fM(), FilterChipPadding, interactionSource2, $composer2, ($dirty3 & 14) | 12582912 | (($dirty3 >> 6) & 112) | (($dirty3 << 3) & 896) | (($dirty3 >> 3) & 7168) | (($dirty3 << 6) & 57344) | (3670016 & ($dirty3 << 3)) | (($dirty3 << 6) & 234881024) | (($dirty3 << 6) & 1879048192), (($dirty3 >> 24) & 14) | 27648 | (($dirty3 >> 24) & 112) | (($dirty12 << 6) & 896) | (($dirty12 << 12) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            enabled3 = enabled2;
            leadingIcon2 = leadingIcon;
            trailingIcon2 = trailingIcon;
            shape5 = shape4;
            colors4 = colors3;
            elevation4 = elevation3;
            border3 = border2;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.ElevatedFilterChip.2
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
                    ChipKt.ElevatedFilterChip(selected, function0, function2, modifier5, enabled3, leadingIcon2, trailingIcon2, shape5, colors4, elevation4, border3, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void InputChip(final boolean selected, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, SelectableChipColors colors, SelectableChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        Function0<Unit> function02;
        Modifier modifier2;
        boolean z2;
        Function2 function25;
        final Function2 avatar;
        Function2 function26;
        Shape shape2;
        int $dirty;
        SelectableChipColors colors2;
        int $dirty2;
        Modifier modifier3;
        int $dirty3;
        int i2;
        SelectableChipElevation elevation2;
        BorderStroke border2;
        MutableInteractionSource interactionSource2;
        SelectableChipElevation elevation3;
        BorderStroke border3;
        boolean enabled2;
        Function2 leadingIcon;
        Function2 trailingIcon;
        Shape shape3;
        SelectableChipColors colors3;
        int $dirty4;
        Modifier modifier4;
        Object value$iv;
        Function2 shapedAvatar;
        Composer $composer2;
        final Function2 avatar2;
        final Modifier modifier5;
        final boolean enabled3;
        final Function2 leadingIcon2;
        final Function2 avatar3;
        final Shape shape4;
        final SelectableChipColors colors4;
        final SelectableChipElevation elevation4;
        final BorderStroke border4;
        final MutableInteractionSource interactionSource3;
        Composer $composer3 = $composer.startRestartGroup(1658928131);
        ComposerKt.sourceInformation($composer3, "C(InputChip)P(10,9,6,8,4,7!1,12,11,2,3)593@30171L5,594@30231L17,595@30310L20,596@30378L34,597@30464L39,624@31431L10,618@31241L747:Chip.kt#uh7d8r");
        int $dirty5 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty5 |= 6;
            z = selected;
        } else if (($changed & 6) == 0) {
            z = selected;
            $dirty5 |= $composer3.changed(z) ? 4 : 2;
        } else {
            z = selected;
        }
        if ((i & 2) != 0) {
            $dirty5 |= 48;
            function02 = function0;
        } else if (($changed & 48) == 0) {
            function02 = function0;
            $dirty5 |= $composer3.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        if ((i & 4) != 0) {
            $dirty5 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty5 |= $composer3.changedInstance(function2) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty5 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty5 |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty5 |= 24576;
            z2 = enabled;
        } else if (($changed & 24576) == 0) {
            z2 = enabled;
            $dirty5 |= $composer3.changed(z2) ? 16384 : 8192;
        } else {
            z2 = enabled;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty5 |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            function25 = function22;
        } else if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            function25 = function22;
            $dirty5 |= $composer3.changedInstance(function25) ? 131072 : 65536;
        } else {
            function25 = function22;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty5 |= 1572864;
            avatar = function23;
        } else if (($changed & 1572864) == 0) {
            avatar = function23;
            $dirty5 |= $composer3.changedInstance(avatar) ? 1048576 : 524288;
        } else {
            avatar = function23;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty5 |= 12582912;
            function26 = function24;
        } else if (($changed & 12582912) == 0) {
            function26 = function24;
            $dirty5 |= $composer3.changedInstance(function26) ? 8388608 : 4194304;
        } else {
            function26 = function24;
        }
        if (($changed & 100663296) == 0) {
            $dirty5 |= ((i & 256) == 0 && $composer3.changed(shape)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty5 |= ((i & 512) == 0 && $composer3.changed(colors)) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty1 |= ((i & 1024) == 0 && $composer3.changed(elevation)) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty1 |= ((i & 2048) == 0 && $composer3.changed(border)) ? 32 : 16;
        }
        int i8 = i & 4096;
        if (i8 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changed(interactionSource) ? 256 : 128;
        }
        int $dirty6 = $dirty5;
        if (($dirty5 & 306783379) == 306783378 && ($dirty1 & 147) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            colors4 = colors;
            border4 = border;
            interactionSource3 = interactionSource;
            modifier5 = modifier2;
            enabled3 = z2;
            leadingIcon2 = function25;
            avatar2 = avatar;
            $composer2 = $composer3;
            avatar3 = function26;
            shape4 = shape;
            elevation4 = elevation;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier6 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i4 != 0 ? true : z2;
                Function2 leadingIcon3 = i5 != 0 ? null : function25;
                Function2 avatar4 = i6 != 0 ? null : avatar;
                Function2 trailingIcon2 = i7 != 0 ? null : function26;
                if ((i & 256) != 0) {
                    $dirty = $dirty6 & (-234881025);
                    shape2 = InputChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    shape2 = shape;
                    $dirty = $dirty6;
                }
                if ((i & 512) != 0) {
                    colors2 = InputChipDefaults.INSTANCE.inputChipColors($composer3, 6);
                    $dirty2 = $dirty & (-1879048193);
                } else {
                    colors2 = colors;
                    $dirty2 = $dirty;
                }
                if ((i & 1024) != 0) {
                    modifier3 = modifier6;
                    i2 = i8;
                    $dirty3 = 6;
                    elevation2 = InputChipDefaults.INSTANCE.m2153inputChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                    $dirty1 &= -15;
                } else {
                    modifier3 = modifier6;
                    $dirty3 = 6;
                    i2 = i8;
                    elevation2 = elevation;
                }
                if ((i & 2048) != 0) {
                    border2 = InputChipDefaults.INSTANCE.m2151inputChipBorder_7El2pE(enabled4, z, 0L, 0L, 0L, 0L, 0.0f, 0.0f, $composer3, (($dirty2 >> 12) & 14) | 100663296 | (($dirty2 << 3) & 112), 252);
                    $dirty1 &= -113;
                } else {
                    border2 = border;
                }
                if (i2 != 0) {
                    $composer3.startReplaceableGroup(-1371993939);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Chip.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceableGroup();
                    elevation3 = elevation2;
                    border3 = border2;
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    enabled2 = enabled4;
                    leadingIcon = leadingIcon3;
                    avatar = avatar4;
                    trailingIcon = trailingIcon2;
                    shape3 = shape2;
                    colors3 = colors2;
                    $dirty4 = $dirty2;
                    modifier4 = modifier3;
                } else {
                    interactionSource2 = interactionSource;
                    elevation3 = elevation2;
                    border3 = border2;
                    enabled2 = enabled4;
                    leadingIcon = leadingIcon3;
                    avatar = avatar4;
                    trailingIcon = trailingIcon2;
                    shape3 = shape2;
                    colors3 = colors2;
                    $dirty4 = $dirty2;
                    modifier4 = modifier3;
                }
            } else {
                $composer3.skipToGroupEnd();
                int $dirty7 = (i & 256) != 0 ? $dirty6 & (-234881025) : $dirty6;
                if ((i & 512) != 0) {
                    $dirty7 &= -1879048193;
                }
                if ((i & 1024) != 0) {
                    $dirty1 &= -15;
                }
                if ((i & 2048) != 0) {
                    $dirty1 &= -113;
                }
                $dirty4 = $dirty7;
                $dirty3 = 6;
                shape3 = shape;
                colors3 = colors;
                elevation3 = elevation;
                border3 = border;
                interactionSource2 = interactionSource;
                modifier4 = modifier2;
                enabled2 = z2;
                leadingIcon = function25;
                trailingIcon = function26;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1658928131, $dirty4, $dirty1, "androidx.compose.material3.InputChip (Chip.kt:598)");
            }
            $composer3.startReplaceableGroup(-1371993712);
            ComposerKt.sourceInformation($composer3, "604@30854L5");
            if (avatar != null) {
                final float avatarOpacity = enabled2 ? 1.0f : 0.38f;
                final Shape avatarShape = ShapesKt.getValue(InputChipTokens.INSTANCE.getAvatarShape(), $composer3, $dirty3);
                Function2 shapedAvatar2 = ComposableLambdaKt.composableLambda($composer3, 1154227507, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.InputChip.2
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

                    public final void invoke(Composer $composer4, int $changed2) {
                        Object value$iv2;
                        ComposerKt.sourceInformation($composer4, "C607@30964L148,606@30909L311:Chip.kt#uh7d8r");
                        if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1154227507, $changed2, -1, "androidx.compose.material3.InputChip.<anonymous> (Chip.kt:606)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            $composer4.startReplaceableGroup(946467138);
                            ComposerKt.sourceInformation($composer4, "CC(remember):Chip.kt#9igjgp");
                            boolean invalid$iv = $composer4.changed(avatarOpacity) | $composer4.changed(avatarShape);
                            final float f = avatarOpacity;
                            final Shape shape5 = avatarShape;
                            Object it$iv2 = $composer4.rememberedValue();
                            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                        invoke2(graphicsLayerScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(GraphicsLayerScope $this$graphicsLayer) {
                                        $this$graphicsLayer.setAlpha(f);
                                        $this$graphicsLayer.setShape(shape5);
                                        $this$graphicsLayer.setClip(true);
                                    }
                                };
                                $composer4.updateRememberedValue(value$iv2);
                            } else {
                                value$iv2 = it$iv2;
                            }
                            $composer4.endReplaceableGroup();
                            Modifier modifier$iv = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) value$iv2);
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                            Function2<Composer, Integer, Unit> function27 = avatar;
                            $composer4.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                            int $changed$iv$iv = (48 << 3) & 112;
                            $composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifier$iv);
                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                $composer4.createNode(factory$iv$iv$iv);
                            } else {
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3479constructorimpl($composer4);
                            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3486setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                            }
                            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m3470boximpl(SkippableUpdater.m3471constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                            $composer4.startReplaceableGroup(2058660585);
                            int i9 = ($changed$iv$iv$iv >> 9) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int i10 = ((48 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1294405811, "C614@31198L8:Chip.kt#uh7d8r");
                            function27.invoke($composer4, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endReplaceableGroup();
                            $composer4.endNode();
                            $composer4.endReplaceableGroup();
                            $composer4.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                });
                shapedAvatar = shapedAvatar2;
            } else {
                shapedAvatar = null;
            }
            $composer3.endReplaceableGroup();
            $composer2 = $composer3;
            m1885SelectableChipu0RnIRE(selected, modifier4, function02, enabled2, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, $dirty3), InputChipTokens.INSTANCE.getLabelTextFont()), leadingIcon, shapedAvatar, trailingIcon, shape3, colors3, elevation3, border3, InputChipDefaults.INSTANCE.m2149getHeightD9Ej5fM(), inputChipPadding(shapedAvatar != null, leadingIcon != null, trailingIcon != null), interactionSource2, $composer2, ($dirty4 & 14) | (($dirty4 >> 6) & 112) | (($dirty4 << 3) & 896) | (($dirty4 >> 3) & 7168) | (($dirty4 << 6) & 57344) | (($dirty4 << 3) & 3670016) | (($dirty4 << 3) & 234881024) | (($dirty4 << 3) & 1879048192), (($dirty4 >> 27) & 14) | 3072 | (($dirty1 << 3) & 112) | (($dirty1 << 3) & 896) | (($dirty1 << 9) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            avatar2 = avatar;
            modifier5 = modifier4;
            enabled3 = enabled2;
            leadingIcon2 = leadingIcon;
            avatar3 = trailingIcon;
            shape4 = shape3;
            colors4 = colors3;
            elevation4 = elevation3;
            border4 = border3;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.InputChip.3
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

                public final void invoke(Composer composer, int i9) {
                    ChipKt.InputChip(selected, function0, function2, modifier5, enabled3, leadingIcon2, avatar2, avatar3, shape4, colors4, elevation4, border4, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    public static final void SuggestionChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, ChipColors colors, ChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier2;
        boolean z;
        Function2 function24;
        Shape shape2;
        ChipColors colors2;
        int i2;
        ChipElevation elevation2;
        int i3;
        MutableInteractionSource mutableInteractionSource;
        int $dirty;
        Shape shape3;
        ChipColors colors3;
        int $dirty2;
        Modifier modifier3;
        int i4;
        boolean enabled2;
        BorderStroke border2;
        MutableInteractionSource interactionSource2;
        BorderStroke border3;
        Function2 icon;
        int $dirty3;
        ChipElevation elevation3;
        Shape shape4;
        boolean enabled3;
        Object value$iv;
        Composer $composer2;
        final boolean enabled4;
        final Function2 icon2;
        final Shape shape5;
        final ChipColors colors4;
        final ChipElevation elevation4;
        final BorderStroke border4;
        final MutableInteractionSource interactionSource3;
        Composer $composer3 = $composer.startRestartGroup(-1700130831);
        ComposerKt.sourceInformation($composer3, "C(SuggestionChip)P(8,6,7,3,4,9,1,2)688@34668L5,689@34723L22,690@34802L25,691@34880L29,692@34961L39,698@35137L10,693@35006L504:Chip.kt#uh7d8r");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
            function02 = function0;
        } else if (($changed & 6) == 0) {
            function02 = function0;
            $dirty4 |= $composer3.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
            function23 = function2;
        } else if (($changed & 48) == 0) {
            function23 = function2;
            $dirty4 |= $composer3.changedInstance(function23) ? 32 : 16;
        } else {
            function23 = function2;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty4 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty4 |= 24576;
            function24 = function22;
        } else if (($changed & 24576) == 0) {
            function24 = function22;
            $dirty4 |= $composer3.changedInstance(function24) ? 16384 : 8192;
        } else {
            function24 = function22;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                shape2 = shape;
                int i8 = $composer3.changed(shape2) ? 131072 : 65536;
                $dirty4 |= i8;
            } else {
                shape2 = shape;
            }
            $dirty4 |= i8;
        } else {
            shape2 = shape;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                colors2 = colors;
                int i9 = $composer3.changed(colors2) ? 1048576 : 524288;
                $dirty4 |= i9;
            } else {
                colors2 = colors;
            }
            $dirty4 |= i9;
        } else {
            colors2 = colors;
        }
        if (($changed & 12582912) == 0) {
            i2 = 12582912;
            if ((i & 128) == 0) {
                elevation2 = elevation;
                int i10 = $composer3.changed(elevation2) ? 8388608 : 4194304;
                $dirty4 |= i10;
            } else {
                elevation2 = elevation;
            }
            $dirty4 |= i10;
        } else {
            i2 = 12582912;
            elevation2 = elevation;
        }
        if (($changed & 100663296) == 0) {
            $dirty4 |= ((i & 256) == 0 && $composer3.changed(border)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i11 = i & 512;
        if (i11 != 0) {
            $dirty4 |= 805306368;
            i3 = i11;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 805306368) == 0) {
            i3 = i11;
            mutableInteractionSource = interactionSource;
            $dirty4 |= $composer3.changed(mutableInteractionSource) ? 536870912 : 268435456;
        } else {
            i3 = i11;
            mutableInteractionSource = interactionSource;
        }
        int $dirty5 = $dirty4;
        if (($dirty4 & 306783379) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled4 = z;
            icon2 = function24;
            $composer2 = $composer3;
            shape5 = shape2;
            colors4 = colors2;
            elevation4 = elevation2;
            border4 = border;
            interactionSource3 = mutableInteractionSource;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled5 = i6 != 0 ? true : z;
                Function2 icon3 = i7 != 0 ? null : function24;
                if ((i & 32) != 0) {
                    $dirty = $dirty5 & (-458753);
                    shape3 = SuggestionChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    $dirty = $dirty5;
                    shape3 = shape2;
                }
                if ((i & 64) != 0) {
                    colors3 = SuggestionChipDefaults.INSTANCE.suggestionChipColors($composer3, 6);
                    $dirty2 = $dirty & (-3670017);
                } else {
                    colors3 = colors2;
                    $dirty2 = $dirty;
                }
                if ((i & 128) != 0) {
                    modifier3 = modifier4;
                    i4 = 6;
                    $dirty2 &= -29360129;
                    elevation2 = SuggestionChipDefaults.INSTANCE.m2518suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                } else {
                    modifier3 = modifier4;
                    i4 = 6;
                }
                if ((i & 256) != 0) {
                    enabled2 = enabled5;
                    border2 = SuggestionChipDefaults.INSTANCE.m2516suggestionChipBorderh1eTWw(enabled2, 0L, 0L, 0.0f, $composer3, (($dirty2 >> 9) & 14) | 24576, 14);
                    $dirty2 &= -234881025;
                } else {
                    enabled2 = enabled5;
                    border2 = border;
                }
                if (i3 != 0) {
                    $composer3.startReplaceableGroup(2118462942);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Chip.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceableGroup();
                    border3 = border2;
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    colors2 = colors3;
                    icon = icon3;
                    $dirty3 = $dirty2;
                    modifier2 = modifier3;
                    elevation3 = elevation2;
                    shape4 = shape3;
                    enabled3 = enabled2;
                } else {
                    modifier2 = modifier3;
                    interactionSource2 = interactionSource;
                    border3 = border2;
                    colors2 = colors3;
                    icon = icon3;
                    $dirty3 = $dirty2;
                    elevation3 = elevation2;
                    shape4 = shape3;
                    enabled3 = enabled2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty5 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty5 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty5 &= -29360129;
                }
                if ((i & 256) != 0) {
                    border3 = border;
                    interactionSource2 = interactionSource;
                    $dirty3 = $dirty5 & (-234881025);
                    i4 = 6;
                    icon = function24;
                    shape4 = shape2;
                    elevation3 = elevation2;
                    enabled3 = z;
                } else {
                    border3 = border;
                    interactionSource2 = interactionSource;
                    i4 = 6;
                    icon = function24;
                    shape4 = shape2;
                    elevation3 = elevation2;
                    $dirty3 = $dirty5;
                    enabled3 = z;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1700130831, $dirty3, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:693)");
            }
            $composer2 = $composer3;
            ChipColors colors5 = colors2;
            Function2<? super Composer, ? super Integer, Unit> function25 = function23;
            Modifier modifier5 = modifier2;
            m1883ChipnkUnTEs(modifier5, function02, enabled3, function25, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, i4), SuggestionChipTokens.INSTANCE.getLabelTextFont()), colors2.m1873labelColorvNxB06k$material3_release(enabled3), icon, null, shape4, colors5, elevation3, border3, SuggestionChipDefaults.INSTANCE.m2513getHeightD9Ej5fM(), SuggestionChipPadding, interactionSource2, $composer2, (($dirty3 >> 6) & 14) | i2 | (($dirty3 << 3) & 112) | (($dirty3 >> 3) & 896) | (($dirty3 << 6) & 7168) | (($dirty3 << 6) & 3670016) | (($dirty3 << 9) & 234881024) | (($dirty3 << 9) & 1879048192), (($dirty3 >> 21) & 14) | 3456 | (($dirty3 >> 21) & 112) | (($dirty3 >> 15) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
            enabled4 = enabled3;
            icon2 = icon;
            shape5 = shape4;
            colors4 = colors5;
            elevation4 = elevation3;
            border4 = border3;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.SuggestionChip.2
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
                    ChipKt.SuggestionChip(function0, function2, modifier2, enabled4, icon2, shape5, colors4, elevation4, border4, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with SuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "SuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    public static final /* synthetic */ void SuggestionChip(final Function0 onClick, final Function2 label, Modifier modifier, boolean enabled, Function2 icon, Shape shape, ChipColors colors, ChipElevation elevation, ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Function0 function0;
        Function2 function2;
        final Modifier modifier2;
        boolean z;
        Function2 function22;
        Shape shape2;
        ChipColors colors2;
        int i2;
        ChipElevation elevation2;
        int i3;
        MutableInteractionSource mutableInteractionSource;
        int $dirty;
        Shape shape3;
        ChipColors colors3;
        int $dirty2;
        Modifier modifier3;
        int i4;
        Composer $composer2;
        ChipBorder border2;
        MutableInteractionSource interactionSource2;
        Function2 icon2;
        int $dirty3;
        ChipElevation elevation3;
        boolean enabled2;
        Shape shape4;
        Object value$iv;
        Composer $composer3;
        final ChipBorder border3;
        final boolean enabled3;
        final Function2 icon3;
        final Shape shape5;
        final ChipColors colors4;
        final ChipElevation elevation4;
        final MutableInteractionSource interactionSource3;
        Composer $composer4 = $composer.startRestartGroup(170629701);
        ComposerKt.sourceInformation($composer4, "C(SuggestionChip)P(8,6,7,3,4,9,1,2)765@38541L5,766@38596L22,767@38675L25,768@38751L22,769@38825L39,775@39001L10,770@38870L534:Chip.kt#uh7d8r");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
            function0 = onClick;
        } else if (($changed & 6) == 0) {
            function0 = onClick;
            $dirty4 |= $composer4.changedInstance(function0) ? 4 : 2;
        } else {
            function0 = onClick;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
            function2 = label;
        } else if (($changed & 48) == 0) {
            function2 = label;
            $dirty4 |= $composer4.changedInstance(function2) ? 32 : 16;
        } else {
            function2 = label;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty4 |= $composer4.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty4 |= 24576;
            function22 = icon;
        } else if (($changed & 24576) == 0) {
            function22 = icon;
            $dirty4 |= $composer4.changedInstance(function22) ? 16384 : 8192;
        } else {
            function22 = icon;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                shape2 = shape;
                int i8 = $composer4.changed(shape2) ? 131072 : 65536;
                $dirty4 |= i8;
            } else {
                shape2 = shape;
            }
            $dirty4 |= i8;
        } else {
            shape2 = shape;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                colors2 = colors;
                int i9 = $composer4.changed(colors2) ? 1048576 : 524288;
                $dirty4 |= i9;
            } else {
                colors2 = colors;
            }
            $dirty4 |= i9;
        } else {
            colors2 = colors;
        }
        if (($changed & 12582912) == 0) {
            i2 = 12582912;
            if ((i & 128) == 0) {
                elevation2 = elevation;
                int i10 = $composer4.changed(elevation2) ? 8388608 : 4194304;
                $dirty4 |= i10;
            } else {
                elevation2 = elevation;
            }
            $dirty4 |= i10;
        } else {
            i2 = 12582912;
            elevation2 = elevation;
        }
        if (($changed & 100663296) == 0) {
            $dirty4 |= ((i & 256) == 0 && $composer4.changed(border)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i11 = i & 512;
        if (i11 != 0) {
            $dirty4 |= 805306368;
            i3 = i11;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 805306368) == 0) {
            i3 = i11;
            mutableInteractionSource = interactionSource;
            $dirty4 |= $composer4.changed(mutableInteractionSource) ? 536870912 : 268435456;
        } else {
            i3 = i11;
            mutableInteractionSource = interactionSource;
        }
        int $dirty5 = $dirty4;
        if (($dirty4 & 306783379) == 306783378 && $composer4.getSkipping()) {
            $composer4.skipToGroupEnd();
            enabled3 = z;
            $composer3 = $composer4;
            icon3 = function22;
            shape5 = shape2;
            colors4 = colors2;
            elevation4 = elevation2;
            border3 = border;
            interactionSource3 = mutableInteractionSource;
        } else {
            $composer4.startDefaults();
            if (($changed & 1) == 0 || $composer4.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i6 != 0 ? true : z;
                Function2 icon4 = i7 != 0 ? null : function22;
                if ((i & 32) != 0) {
                    $dirty = $dirty5 & (-458753);
                    shape3 = SuggestionChipDefaults.INSTANCE.getShape($composer4, 6);
                } else {
                    $dirty = $dirty5;
                    shape3 = shape2;
                }
                if ((i & 64) != 0) {
                    colors3 = SuggestionChipDefaults.INSTANCE.suggestionChipColors($composer4, 6);
                    $dirty2 = $dirty & (-3670017);
                } else {
                    colors3 = colors2;
                    $dirty2 = $dirty;
                }
                if ((i & 128) != 0) {
                    $composer2 = $composer4;
                    modifier3 = modifier4;
                    i4 = 6;
                    $dirty2 &= -29360129;
                    elevation2 = SuggestionChipDefaults.INSTANCE.m2518suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer2, 1572864, 63);
                } else {
                    modifier3 = modifier4;
                    i4 = 6;
                    $composer2 = $composer4;
                }
                if ((i & 256) != 0) {
                    $composer4 = $composer2;
                    border2 = SuggestionChipDefaults.INSTANCE.m2515suggestionChipBorderd_3_b6Q(0L, 0L, 0.0f, $composer4, 3072, 7);
                    $dirty2 &= -234881025;
                } else {
                    $composer4 = $composer2;
                    border2 = border;
                }
                if (i3 != 0) {
                    $composer4.startReplaceableGroup(2118466806);
                    ComposerKt.sourceInformation($composer4, "CC(remember):Chip.kt#9igjgp");
                    Composer $this$cache$iv = $composer4;
                    Object it$iv = $this$cache$iv.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer4.endReplaceableGroup();
                    modifier2 = modifier3;
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    colors2 = colors3;
                    icon2 = icon4;
                    $dirty3 = $dirty2;
                    elevation3 = elevation2;
                    enabled2 = enabled4;
                    shape4 = shape3;
                } else {
                    modifier2 = modifier3;
                    interactionSource2 = interactionSource;
                    colors2 = colors3;
                    icon2 = icon4;
                    $dirty3 = $dirty2;
                    elevation3 = elevation2;
                    enabled2 = enabled4;
                    shape4 = shape3;
                }
            } else {
                $composer4.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty5 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty5 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty5 &= -29360129;
                }
                if ((i & 256) != 0) {
                    $dirty3 = $dirty5 & (-234881025);
                    i4 = 6;
                    border2 = border;
                    interactionSource2 = interactionSource;
                    icon2 = function22;
                    shape4 = shape2;
                    elevation3 = elevation2;
                    enabled2 = z;
                } else {
                    border2 = border;
                    interactionSource2 = interactionSource;
                    i4 = 6;
                    icon2 = function22;
                    shape4 = shape2;
                    elevation3 = elevation2;
                    $dirty3 = $dirty5;
                    enabled2 = z;
                }
            }
            $composer4.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(170629701, $dirty3, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:770)");
            }
            TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer4, i4), SuggestionChipTokens.INSTANCE.getLabelTextFont());
            long jM1873labelColorvNxB06k$material3_release = colors2.m1873labelColorvNxB06k$material3_release(enabled2);
            $composer4.startReplaceableGroup(2118467222);
            ComposerKt.sourceInformation($composer4, "782@39241L21");
            State<BorderStroke> stateBorderStroke$material3_release = border2 == null ? null : border2.borderStroke$material3_release(enabled2, $composer4, (($dirty3 >> 9) & 14) | (($dirty3 >> 21) & 112));
            $composer4.endReplaceableGroup();
            $composer3 = $composer4;
            ChipColors colors5 = colors2;
            Function2 function23 = function2;
            Modifier modifier5 = modifier2;
            m1883ChipnkUnTEs(modifier5, function0, enabled2, function23, textStyleFromToken, jM1873labelColorvNxB06k$material3_release, icon2, null, shape4, colors5, elevation3, stateBorderStroke$material3_release != null ? stateBorderStroke$material3_release.getValue() : null, SuggestionChipDefaults.INSTANCE.m2513getHeightD9Ej5fM(), SuggestionChipPadding, interactionSource2, $composer3, (($dirty3 >> 6) & 14) | i2 | (($dirty3 << 3) & 112) | (($dirty3 >> 3) & 896) | (($dirty3 << 6) & 7168) | (($dirty3 << 6) & 3670016) | (($dirty3 << 9) & 234881024) | (1879048192 & ($dirty3 << 9)), (($dirty3 >> 21) & 14) | 3456 | (($dirty3 >> 15) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            border3 = border2;
            modifier2 = modifier5;
            enabled3 = enabled2;
            icon3 = icon2;
            shape5 = shape4;
            colors4 = colors5;
            elevation4 = elevation3;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.SuggestionChip.4
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
                    ChipKt.SuggestionChip(onClick, label, modifier2, enabled3, icon3, shape5, colors4, elevation4, border3, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    public static final void ElevatedSuggestionChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, ChipColors colors, ChipElevation elevation, BorderStroke border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier2;
        boolean z;
        Function2 function24;
        Shape shape2;
        ChipColors colors2;
        int i2;
        ChipElevation elevation2;
        int i3;
        int i4;
        MutableInteractionSource mutableInteractionSource;
        int $dirty;
        Shape shape3;
        ChipColors colors3;
        int $dirty2;
        Modifier modifier3;
        int i5;
        MutableInteractionSource interactionSource2;
        BorderStroke border2;
        Function2 icon;
        int $dirty3;
        ChipElevation elevation3;
        boolean enabled2;
        Shape shape4;
        Object value$iv;
        Composer $composer2;
        final boolean enabled3;
        final Function2 icon2;
        final Shape shape5;
        final ChipColors colors4;
        final ChipElevation elevation4;
        final BorderStroke border3;
        final MutableInteractionSource interactionSource3;
        Composer $composer3 = $composer.startRestartGroup(-818834969);
        ComposerKt.sourceInformation($composer3, "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)833@42061L5,834@42116L30,835@42203L33,837@42322L39,843@42498L10,838@42367L504:Chip.kt#uh7d8r");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
            function02 = function0;
        } else if (($changed & 6) == 0) {
            function02 = function0;
            $dirty4 |= $composer3.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
            function23 = function2;
        } else if (($changed & 48) == 0) {
            function23 = function2;
            $dirty4 |= $composer3.changedInstance(function23) ? 32 : 16;
        } else {
            function23 = function2;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty4 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty4 |= 24576;
            function24 = function22;
        } else if (($changed & 24576) == 0) {
            function24 = function22;
            $dirty4 |= $composer3.changedInstance(function24) ? 16384 : 8192;
        } else {
            function24 = function22;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                shape2 = shape;
                int i9 = $composer3.changed(shape2) ? 131072 : 65536;
                $dirty4 |= i9;
            } else {
                shape2 = shape;
            }
            $dirty4 |= i9;
        } else {
            shape2 = shape;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                colors2 = colors;
                int i10 = $composer3.changed(colors2) ? 1048576 : 524288;
                $dirty4 |= i10;
            } else {
                colors2 = colors;
            }
            $dirty4 |= i10;
        } else {
            colors2 = colors;
        }
        if (($changed & 12582912) == 0) {
            i2 = 12582912;
            if ((i & 128) == 0) {
                elevation2 = elevation;
                int i11 = $composer3.changed(elevation2) ? 8388608 : 4194304;
                $dirty4 |= i11;
            } else {
                elevation2 = elevation;
            }
            $dirty4 |= i11;
        } else {
            i2 = 12582912;
            elevation2 = elevation;
        }
        int i12 = i & 256;
        if (i12 != 0) {
            $dirty4 |= 100663296;
            i3 = i6;
        } else if (($changed & 100663296) == 0) {
            i3 = i6;
            $dirty4 |= $composer3.changed(border) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i6;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty4 |= 805306368;
            i4 = i13;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 805306368) == 0) {
            i4 = i13;
            mutableInteractionSource = interactionSource;
            $dirty4 |= $composer3.changed(mutableInteractionSource) ? 536870912 : 268435456;
        } else {
            i4 = i13;
            mutableInteractionSource = interactionSource;
        }
        int $dirty5 = $dirty4;
        if (($dirty4 & 306783379) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled3 = z;
            icon2 = function24;
            $composer2 = $composer3;
            shape5 = shape2;
            colors4 = colors2;
            elevation4 = elevation2;
            border3 = border;
            interactionSource3 = mutableInteractionSource;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i7 != 0 ? true : z;
                Function2 icon3 = i8 != 0 ? null : function24;
                if ((i & 32) != 0) {
                    $dirty = $dirty5 & (-458753);
                    shape3 = SuggestionChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    $dirty = $dirty5;
                    shape3 = shape2;
                }
                if ((i & 64) != 0) {
                    colors3 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors($composer3, 6);
                    $dirty2 = $dirty & (-3670017);
                } else {
                    colors3 = colors2;
                    $dirty2 = $dirty;
                }
                if ((i & 128) != 0) {
                    modifier3 = modifier4;
                    i5 = 6;
                    $dirty2 &= -29360129;
                    elevation2 = SuggestionChipDefaults.INSTANCE.m2512elevatedSuggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                } else {
                    modifier3 = modifier4;
                    i5 = 6;
                }
                BorderStroke border4 = i12 != 0 ? null : border;
                if (i4 != 0) {
                    $composer3.startReplaceableGroup(-1455582059);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Chip.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceableGroup();
                    modifier2 = modifier3;
                    border2 = border4;
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    colors2 = colors3;
                    icon = icon3;
                    $dirty3 = $dirty2;
                    elevation3 = elevation2;
                    enabled2 = enabled4;
                    shape4 = shape3;
                } else {
                    modifier2 = modifier3;
                    interactionSource2 = interactionSource;
                    border2 = border4;
                    colors2 = colors3;
                    icon = icon3;
                    $dirty3 = $dirty2;
                    elevation3 = elevation2;
                    enabled2 = enabled4;
                    shape4 = shape3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty5 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty5 &= -3670017;
                }
                if ((i & 128) != 0) {
                    border2 = border;
                    interactionSource2 = interactionSource;
                    $dirty3 = $dirty5 & (-29360129);
                    i5 = 6;
                    icon = function24;
                    shape4 = shape2;
                    elevation3 = elevation2;
                    enabled2 = z;
                } else {
                    border2 = border;
                    interactionSource2 = interactionSource;
                    i5 = 6;
                    icon = function24;
                    shape4 = shape2;
                    elevation3 = elevation2;
                    $dirty3 = $dirty5;
                    enabled2 = z;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-818834969, $dirty3, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:838)");
            }
            $composer2 = $composer3;
            ChipColors colors5 = colors2;
            Function2<? super Composer, ? super Integer, Unit> function25 = function23;
            Modifier modifier5 = modifier2;
            m1883ChipnkUnTEs(modifier5, function02, enabled2, function25, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, i5), SuggestionChipTokens.INSTANCE.getLabelTextFont()), colors2.m1873labelColorvNxB06k$material3_release(enabled2), icon, null, shape4, colors5, elevation3, border2, SuggestionChipDefaults.INSTANCE.m2513getHeightD9Ej5fM(), SuggestionChipPadding, interactionSource2, $composer2, (($dirty3 >> 6) & 14) | i2 | (($dirty3 << 3) & 112) | (($dirty3 >> 3) & 896) | (($dirty3 << 6) & 7168) | (($dirty3 << 6) & 3670016) | (($dirty3 << 9) & 234881024) | (($dirty3 << 9) & 1879048192), (($dirty3 >> 21) & 14) | 3456 | (($dirty3 >> 21) & 112) | (($dirty3 >> 15) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
            enabled3 = enabled2;
            icon2 = icon;
            shape5 = shape4;
            colors4 = colors5;
            elevation4 = elevation3;
            border3 = border2;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.ElevatedSuggestionChip.2
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

                public final void invoke(Composer composer, int i14) {
                    ChipKt.ElevatedSuggestionChip(function0, function2, modifier2, enabled3, icon2, shape5, colors4, elevation4, border3, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedSuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "ElevatedSuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    public static final /* synthetic */ void ElevatedSuggestionChip(final Function0 onClick, final Function2 label, Modifier modifier, boolean enabled, Function2 icon, Shape shape, ChipColors colors, ChipElevation elevation, ChipBorder border, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Function0 function0;
        Function2 function2;
        final Modifier modifier2;
        boolean z;
        Function2 function22;
        Shape shape2;
        ChipColors colors2;
        int i2;
        ChipElevation elevation2;
        int i3;
        int i4;
        MutableInteractionSource mutableInteractionSource;
        int $dirty;
        Shape shape3;
        ChipColors colors3;
        int $dirty2;
        Modifier modifier3;
        int i5;
        ChipBorder border2;
        MutableInteractionSource interactionSource2;
        Function2 icon2;
        int $dirty3;
        ChipElevation elevation3;
        boolean enabled2;
        Shape shape4;
        Object value$iv;
        Composer $composer2;
        final ChipBorder border3;
        final boolean enabled3;
        final Function2 icon3;
        final Shape shape5;
        final ChipColors colors4;
        final ChipElevation elevation4;
        final MutableInteractionSource interactionSource3;
        Composer $composer3 = $composer.startRestartGroup(1668751803);
        ComposerKt.sourceInformation($composer3, "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)909@45897L5,910@45952L30,911@46039L33,913@46156L39,919@46332L10,914@46201L534:Chip.kt#uh7d8r");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
            function0 = onClick;
        } else if (($changed & 6) == 0) {
            function0 = onClick;
            $dirty4 |= $composer3.changedInstance(function0) ? 4 : 2;
        } else {
            function0 = onClick;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
            function2 = label;
        } else if (($changed & 48) == 0) {
            function2 = label;
            $dirty4 |= $composer3.changedInstance(function2) ? 32 : 16;
        } else {
            function2 = label;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty4 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty4 |= 24576;
            function22 = icon;
        } else if (($changed & 24576) == 0) {
            function22 = icon;
            $dirty4 |= $composer3.changedInstance(function22) ? 16384 : 8192;
        } else {
            function22 = icon;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                shape2 = shape;
                int i9 = $composer3.changed(shape2) ? 131072 : 65536;
                $dirty4 |= i9;
            } else {
                shape2 = shape;
            }
            $dirty4 |= i9;
        } else {
            shape2 = shape;
        }
        if ((1572864 & $changed) == 0) {
            if ((i & 64) == 0) {
                colors2 = colors;
                int i10 = $composer3.changed(colors2) ? 1048576 : 524288;
                $dirty4 |= i10;
            } else {
                colors2 = colors;
            }
            $dirty4 |= i10;
        } else {
            colors2 = colors;
        }
        if (($changed & 12582912) == 0) {
            i2 = 12582912;
            if ((i & 128) == 0) {
                elevation2 = elevation;
                int i11 = $composer3.changed(elevation2) ? 8388608 : 4194304;
                $dirty4 |= i11;
            } else {
                elevation2 = elevation;
            }
            $dirty4 |= i11;
        } else {
            i2 = 12582912;
            elevation2 = elevation;
        }
        int i12 = i & 256;
        if (i12 != 0) {
            $dirty4 |= 100663296;
            i3 = i6;
        } else if (($changed & 100663296) == 0) {
            i3 = i6;
            $dirty4 |= $composer3.changed(border) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i6;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty4 |= 805306368;
            i4 = i13;
            mutableInteractionSource = interactionSource;
        } else if (($changed & 805306368) == 0) {
            i4 = i13;
            mutableInteractionSource = interactionSource;
            $dirty4 |= $composer3.changed(mutableInteractionSource) ? 536870912 : 268435456;
        } else {
            i4 = i13;
            mutableInteractionSource = interactionSource;
        }
        int $dirty5 = $dirty4;
        if (($dirty4 & 306783379) == 306783378 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled3 = z;
            icon3 = function22;
            $composer2 = $composer3;
            shape5 = shape2;
            colors4 = colors2;
            elevation4 = elevation2;
            border3 = border;
            interactionSource3 = mutableInteractionSource;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i7 != 0 ? true : z;
                Function2 icon4 = i8 != 0 ? null : function22;
                if ((i & 32) != 0) {
                    $dirty = $dirty5 & (-458753);
                    shape3 = SuggestionChipDefaults.INSTANCE.getShape($composer3, 6);
                } else {
                    $dirty = $dirty5;
                    shape3 = shape2;
                }
                if ((i & 64) != 0) {
                    colors3 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors($composer3, 6);
                    $dirty2 = $dirty & (-3670017);
                } else {
                    colors3 = colors2;
                    $dirty2 = $dirty;
                }
                if ((i & 128) != 0) {
                    modifier3 = modifier4;
                    i5 = 6;
                    $dirty2 &= -29360129;
                    elevation2 = SuggestionChipDefaults.INSTANCE.m2512elevatedSuggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, 1572864, 63);
                } else {
                    modifier3 = modifier4;
                    i5 = 6;
                }
                border2 = i12 != 0 ? null : border;
                if (i4 != 0) {
                    $composer3.startReplaceableGroup(-1455578225);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Chip.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer3.endReplaceableGroup();
                    modifier2 = modifier3;
                    interactionSource2 = (MutableInteractionSource) value$iv;
                    colors2 = colors3;
                    icon2 = icon4;
                    $dirty3 = $dirty2;
                    elevation3 = elevation2;
                    enabled2 = enabled4;
                    shape4 = shape3;
                } else {
                    modifier2 = modifier3;
                    interactionSource2 = interactionSource;
                    colors2 = colors3;
                    icon2 = icon4;
                    $dirty3 = $dirty2;
                    elevation3 = elevation2;
                    enabled2 = enabled4;
                    shape4 = shape3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty5 &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty5 &= -3670017;
                }
                if ((i & 128) != 0) {
                    $dirty3 = $dirty5 & (-29360129);
                    i5 = 6;
                    border2 = border;
                    interactionSource2 = interactionSource;
                    icon2 = function22;
                    shape4 = shape2;
                    elevation3 = elevation2;
                    enabled2 = z;
                } else {
                    border2 = border;
                    interactionSource2 = interactionSource;
                    i5 = 6;
                    icon2 = function22;
                    shape4 = shape2;
                    elevation3 = elevation2;
                    $dirty3 = $dirty5;
                    enabled2 = z;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1668751803, $dirty3, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:914)");
            }
            TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, i5), SuggestionChipTokens.INSTANCE.getLabelTextFont());
            long jM1873labelColorvNxB06k$material3_release = colors2.m1873labelColorvNxB06k$material3_release(enabled2);
            float fM2513getHeightD9Ej5fM = SuggestionChipDefaults.INSTANCE.m2513getHeightD9Ej5fM();
            PaddingValues paddingValues = SuggestionChipPadding;
            $composer3.startReplaceableGroup(-1455577719);
            ComposerKt.sourceInformation($composer3, "928@46662L21");
            State<BorderStroke> stateBorderStroke$material3_release = border2 == null ? null : border2.borderStroke$material3_release(enabled2, $composer3, (($dirty3 >> 9) & 14) | (($dirty3 >> 21) & 112));
            $composer3.endReplaceableGroup();
            $composer2 = $composer3;
            ChipColors colors5 = colors2;
            Function2 function23 = function2;
            Modifier modifier5 = modifier2;
            m1883ChipnkUnTEs(modifier5, function0, enabled2, function23, textStyleFromToken, jM1873labelColorvNxB06k$material3_release, icon2, null, shape4, colors5, elevation3, stateBorderStroke$material3_release != null ? stateBorderStroke$material3_release.getValue() : null, fM2513getHeightD9Ej5fM, paddingValues, interactionSource2, $composer2, (($dirty3 >> 6) & 14) | i2 | (($dirty3 << 3) & 112) | (($dirty3 >> 3) & 896) | (($dirty3 << 6) & 7168) | (($dirty3 << 6) & 3670016) | (($dirty3 << 9) & 234881024) | (1879048192 & ($dirty3 << 9)), (($dirty3 >> 21) & 14) | 3456 | (($dirty3 >> 15) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            border3 = border2;
            modifier2 = modifier5;
            enabled3 = enabled2;
            icon3 = icon2;
            shape5 = shape4;
            colors4 = colors5;
            elevation4 = elevation3;
            interactionSource3 = interactionSource2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt.ElevatedSuggestionChip.4
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

                public final void invoke(Composer composer, int i14) {
                    ChipKt.ElevatedSuggestionChip(onClick, label, modifier2, enabled3, icon3, shape5, colors4, elevation4, border3, interactionSource3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Chip-nkUnTEs, reason: not valid java name */
    public static final void m1883ChipnkUnTEs(final Modifier modifier, final Function0<Unit> function0, final boolean enabled, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle labelTextStyle, final long labelColor, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Shape shape, final ChipColors colors, final ChipElevation elevation, final BorderStroke border, final float minHeight, final PaddingValues paddingValues, final MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        TextStyle textStyle;
        long j;
        BorderStroke borderStroke;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1400504719);
        ComposerKt.sourceInformation($composer3, "C(Chip)P(10,11,3,5,7,6:c#ui.graphics.Color,8,14,13,1,2!1,9:c#ui.unit.Dp,12)1860@92959L917:Chip.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(enabled) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            function24 = function2;
            $dirty |= $composer3.changedInstance(function24) ? 2048 : 1024;
        } else {
            function24 = function2;
        }
        if (($changed & 24576) == 0) {
            textStyle = labelTextStyle;
            $dirty |= $composer3.changed(textStyle) ? 16384 : 8192;
        } else {
            textStyle = labelTextStyle;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            j = labelColor;
            $dirty |= $composer3.changed(j) ? 131072 : 65536;
        } else {
            j = labelColor;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function23) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changed(shape) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changed(colors) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changed(elevation) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            borderStroke = border;
            $dirty1 |= $composer3.changed(borderStroke) ? 32 : 16;
        } else {
            borderStroke = border;
        }
        if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changed(minHeight) ? 256 : 128;
        }
        if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer3.changed(paddingValues) ? 2048 : 1024;
        }
        if (($changed1 & 24576) == 0) {
            $dirty1 |= $composer3.changed(interactionSource) ? 16384 : 8192;
        }
        int $dirty12 = $dirty1;
        if ((306783379 & $dirty) != 306783378 || ($dirty12 & 9363) != 9362 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1400504719, $dirty, $dirty12, "androidx.compose.material3.Chip (Chip.kt:1859)");
            }
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m5618setRolekuIjeqM($this$semantics, Role.INSTANCE.m5602getButtono7Vup1c());
                }
            }, 1, null);
            long jM1863containerColorvNxB06k$material3_release = colors.m1863containerColorvNxB06k$material3_release(enabled);
            float fM1882tonalElevationu2uoSUM$material3_release = elevation != null ? elevation.m1882tonalElevationu2uoSUM$material3_release(enabled) : C1956Dp.m6297constructorimpl(0);
            $composer3.startReplaceableGroup(64045438);
            ComposerKt.sourceInformation($composer3, "1867@93261L43");
            State<C1956Dp> stateShadowElevation$material3_release = elevation == null ? null : elevation.shadowElevation$material3_release(enabled, interactionSource, $composer3, (($dirty >> 6) & 14) | (($dirty12 >> 9) & 112) | (($dirty12 << 6) & 896));
            $composer3.endReplaceableGroup();
            int $dirty2 = $dirty;
            final TextStyle textStyle2 = textStyle;
            final long j2 = j;
            final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
            SurfaceKt.m2522Surfaceo_FOJdg(function0, modifierSemantics$default, enabled, shape, jM1863containerColorvNxB06k$material3_release, 0L, fM1882tonalElevationu2uoSUM$material3_release, stateShadowElevation$material3_release != null ? stateShadowElevation$material3_release.getValue().m6311unboximpl() : C1956Dp.m6297constructorimpl(0), borderStroke, interactionSource, ComposableLambdaKt.composableLambda($composer3, -1985962652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$2
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

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C1871@93409L461:Chip.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1985962652, $changed2, -1, "androidx.compose.material3.Chip.<anonymous> (Chip.kt:1871)");
                        }
                        ChipKt.m1884ChipContentfe0OD_I(function25, textStyle2, j2, function22, null, function23, colors.m1874leadingIconContentColorvNxB06k$material3_release(enabled), colors.m1875trailingIconContentColorvNxB06k$material3_release(enabled), minHeight, paddingValues, $composer4, 24576);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, (($dirty2 >> 3) & 14) | ($dirty2 & 896) | (($dirty2 >> 15) & 7168) | (($dirty12 << 21) & 234881024) | (1879048192 & ($dirty12 << 15)), 6, 32);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$3
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

                public final void invoke(Composer composer, int i) {
                    ChipKt.m1883ChipnkUnTEs(modifier, function0, enabled, function2, labelTextStyle, labelColor, function22, function23, shape, colors, elevation, border, minHeight, paddingValues, interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: SelectableChip-u0RnIRE, reason: not valid java name */
    public static final void m1885SelectableChipu0RnIRE(final boolean selected, final Modifier modifier, final Function0<Unit> function0, final boolean enabled, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle labelTextStyle, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Shape shape, final SelectableChipColors colors, final SelectableChipElevation elevation, final BorderStroke border, final float minHeight, final PaddingValues paddingValues, final MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int $changed1) {
        Function2<? super Composer, ? super Integer, Unit> function25;
        TextStyle textStyle;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(402951308);
        ComposerKt.sourceInformation($composer3, "C(SelectableChip)P(13,10,11,4,6,7,8!1,15,14,2,3!1,9:c#ui.unit.Dp,12)1912@94717L33,1906@94515L1012:Chip.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(selected) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(enabled) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            function25 = function2;
            $dirty |= $composer3.changedInstance(function25) ? 16384 : 8192;
        } else {
            function25 = function2;
        }
        if (($changed & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            textStyle = labelTextStyle;
            $dirty |= $composer3.changed(textStyle) ? 131072 : 65536;
        } else {
            textStyle = labelTextStyle;
        }
        if (($changed & 1572864) == 0) {
            function26 = function22;
            $dirty |= $composer3.changedInstance(function26) ? 1048576 : 524288;
        } else {
            function26 = function22;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changedInstance(function23) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changedInstance(function24) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changed(shape) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changed(colors) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changed(elevation) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changed(border) ? 256 : 128;
        }
        if (($changed1 & 3072) == 0) {
            $dirty1 |= $composer3.changed(minHeight) ? 2048 : 1024;
        }
        if (($changed1 & 24576) == 0) {
            $dirty1 |= $composer3.changed(paddingValues) ? 16384 : 8192;
        }
        if (($changed1 & ProfileVerifier.CompilationStatus.f249xf2722a21) == 0) {
            $dirty1 |= $composer3.changed(interactionSource) ? 131072 : 65536;
        }
        if (($dirty & 306783379) != 306783378 || (74899 & $dirty1) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(402951308, $dirty, $dirty1, "androidx.compose.material3.SelectableChip (Chip.kt:1904)");
            }
            int $dirty2 = $dirty;
            int $dirty12 = $dirty1;
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.m5618setRolekuIjeqM($this$semantics, Role.INSTANCE.m5603getCheckboxo7Vup1c());
                }
            }, 1, null);
            long jM3959unboximpl = colors.containerColor$material3_release(enabled, selected, $composer3, (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty12 << 6) & 896)).getValue().m3959unboximpl();
            float fM2381tonalElevationu2uoSUM$material3_release = elevation != null ? elevation.m2381tonalElevationu2uoSUM$material3_release(enabled) : C1956Dp.m6297constructorimpl(0);
            $composer3.startReplaceableGroup(1036687563);
            ComposerKt.sourceInformation($composer3, "1914@94864L43");
            State<C1956Dp> stateShadowElevation$material3_release = elevation == null ? null : elevation.shadowElevation$material3_release(enabled, interactionSource, $composer3, (($dirty2 >> 9) & 14) | (($dirty12 >> 12) & 112) | (($dirty12 << 3) & 896));
            $composer3.endReplaceableGroup();
            final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
            final TextStyle textStyle2 = textStyle;
            final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
            SurfaceKt.m2520Surfaced85dljk(selected, function0, modifierSemantics$default, enabled, shape, jM3959unboximpl, 0L, fM2381tonalElevationu2uoSUM$material3_release, stateShadowElevation$material3_release != null ? stateShadowElevation$material3_release.getValue().m6311unboximpl() : C1956Dp.m6297constructorimpl(0), border, interactionSource, ComposableLambdaKt.composableLambda($composer3, -577614814, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$2
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

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C1918@95012L509:Chip.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-577614814, $changed2, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:1918)");
                        }
                        ChipKt.m1884ChipContentfe0OD_I(function27, textStyle2, colors.m2372labelColorWaAFU9c$material3_release(enabled, selected), function28, function23, function24, colors.m2373leadingIconContentColorWaAFU9c$material3_release(enabled, selected), colors.m2374trailingIconContentColorWaAFU9c$material3_release(enabled, selected), minHeight, paddingValues, $composer4, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, ($dirty2 & 14) | (($dirty2 >> 3) & 112) | ($dirty2 & 7168) | (($dirty2 >> 15) & 57344) | (($dirty12 << 21) & 1879048192), (($dirty12 >> 15) & 14) | 48, 64);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$3
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

                public final void invoke(Composer composer, int i) {
                    ChipKt.m1885SelectableChipu0RnIRE(selected, modifier, function0, enabled, function2, labelTextStyle, function22, function23, function24, shape, colors, elevation, border, minHeight, paddingValues, interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ChipContent-fe0OD_I, reason: not valid java name */
    public static final void m1884ChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle labelTextStyle, long labelColor, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final long leadingIconColor, final long trailingIconColor, final float minHeight, final PaddingValues paddingValues, Composer $composer, final int $changed) {
        long j;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        long j2;
        long j3;
        Composer $composer2 = $composer.startRestartGroup(-782878228);
        ComposerKt.sourceInformation($composer2, "C(ChipContent)P(1,3,2:c#ui.graphics.Color,4!1,8,5:c#ui.graphics.Color,9:c#ui.graphics.Color,6:c#ui.unit.Dp)1946@95904L3672:Chip.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(labelTextStyle) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            j = labelColor;
            $dirty |= $composer2.changed(j) ? 256 : 128;
        } else {
            j = labelColor;
        }
        if (($changed & 3072) == 0) {
            function25 = function22;
            $dirty |= $composer2.changedInstance(function25) ? 2048 : 1024;
        } else {
            function25 = function22;
        }
        if (($changed & 24576) == 0) {
            function26 = function23;
            $dirty |= $composer2.changedInstance(function26) ? 16384 : 8192;
        } else {
            function26 = function23;
        }
        if ((196608 & $changed) == 0) {
            function27 = function24;
            $dirty |= $composer2.changedInstance(function27) ? 131072 : 65536;
        } else {
            function27 = function24;
        }
        if ((1572864 & $changed) == 0) {
            j2 = leadingIconColor;
            $dirty |= $composer2.changed(j2) ? 1048576 : 524288;
        } else {
            j2 = leadingIconColor;
        }
        if ((12582912 & $changed) == 0) {
            j3 = trailingIconColor;
            $dirty |= $composer2.changed(j3) ? 8388608 : 4194304;
        } else {
            j3 = trailingIconColor;
        }
        if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changed(minHeight) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changed(paddingValues) ? 536870912 : 268435456;
        }
        if (($dirty & 306783379) != 306783378 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-782878228, $dirty, -1, "androidx.compose.material3.ChipContent (Chip.kt:1945)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function28 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
            final long j4 = j2;
            final long j5 = j3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3939boximpl(j)), TextKt.getLocalTextStyle().provides(labelTextStyle)}, ComposableLambdaKt.composableLambda($composer2, 1748799148, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$1
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

                /* JADX WARN: Removed duplicated region for block: B:69:0x042f  */
                /* JADX WARN: Removed duplicated region for block: B:87:0x0591  */
                /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r53, int r54) {
                    /*
                        Method dump skipped, instructions count: 1429
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ChipKt$ChipContent$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final long j6 = j;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$2
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

                public final void invoke(Composer composer, int i) {
                    ChipKt.m1884ChipContentfe0OD_I(function2, labelTextStyle, j6, function22, function23, function24, leadingIconColor, trailingIconColor, minHeight, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final ChipColors getDefaultSuggestionChipColors(ColorScheme $this$defaultSuggestionChipColors) {
        ChipColors defaultSuggestionChipColorsCached = $this$defaultSuggestionChipColors.getDefaultSuggestionChipColorsCached();
        if (defaultSuggestionChipColorsCached != null) {
            return defaultSuggestionChipColorsCached;
        }
        long jM3984getTransparent0d7_KjU = Color.INSTANCE.m3984getTransparent0d7_KjU();
        long jFromToken = ColorSchemeKt.fromToken($this$defaultSuggestionChipColors, SuggestionChipTokens.INSTANCE.getLabelTextColor());
        long jFromToken2 = ColorSchemeKt.fromToken($this$defaultSuggestionChipColors, SuggestionChipTokens.INSTANCE.getLeadingIconColor());
        long jM3985getUnspecified0d7_KjU = Color.INSTANCE.m3985getUnspecified0d7_KjU();
        long jM3984getTransparent0d7_KjU2 = Color.INSTANCE.m3984getTransparent0d7_KjU();
        long jFromToken3 = ColorSchemeKt.fromToken($this$defaultSuggestionChipColors, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor());
        long jM3947copywmQWz5c = Color.m3947copywmQWz5c(jFromToken3, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jFromToken3) : 0.38f, (14 & 2) != 0 ? Color.m3955getRedimpl(jFromToken3) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jFromToken3) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jFromToken3) : 0.0f);
        long jFromToken4 = ColorSchemeKt.fromToken($this$defaultSuggestionChipColors, SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor());
        ChipColors it = new ChipColors(jM3984getTransparent0d7_KjU, jFromToken, jFromToken2, jM3985getUnspecified0d7_KjU, jM3984getTransparent0d7_KjU2, jM3947copywmQWz5c, Color.m3947copywmQWz5c(jFromToken4, (14 & 1) != 0 ? Color.m3951getAlphaimpl(jFromToken4) : 0.38f, (14 & 2) != 0 ? Color.m3955getRedimpl(jFromToken4) : 0.0f, (14 & 4) != 0 ? Color.m3954getGreenimpl(jFromToken4) : 0.0f, (14 & 8) != 0 ? Color.m3952getBlueimpl(jFromToken4) : 0.0f), Color.INSTANCE.m3985getUnspecified0d7_KjU(), null);
        $this$defaultSuggestionChipColors.setDefaultSuggestionChipColorsCached$material3_release(it);
        return it;
    }

    static /* synthetic */ PaddingValues inputChipPadding$default(boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return inputChipPadding(z, z2, z3);
    }

    private static final PaddingValues inputChipPadding(boolean hasAvatar, boolean hasLeadingIcon, boolean hasTrailingIcon) {
        float start = (hasAvatar || !hasLeadingIcon) ? C1956Dp.m6297constructorimpl(4) : C1956Dp.m6297constructorimpl(8);
        float end = hasTrailingIcon ? C1956Dp.m6297constructorimpl(8) : C1956Dp.m6297constructorimpl(4);
        return PaddingKt.m764PaddingValuesa9UjIt4$default(start, 0.0f, end, 0.0f, 10, null);
    }
}
