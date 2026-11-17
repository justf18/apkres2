package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Chip.kt */
@Metadata(m164d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001e\u0010\u0018J\u001d\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\"²\u0006\f\u0010#\u001a\u0004\u0018\u00010$X\u008a\u008e\u0002"}, m165d2 = {"Landroidx/compose/material3/ChipElevation;", "", "elevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDisabledElevation-D9Ej5fM", "()F", "F", "getDraggedElevation-D9Ej5fM", "getElevation-D9Ej5fM", "getFocusedElevation-D9Ej5fM", "getHoveredElevation-D9Ej5fM", "getPressedElevation-D9Ej5fM", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation-u2uoSUM$material3_release", "(Z)F", "material3_release", "lastInteraction", "Landroidx/compose/foundation/interaction/Interaction;"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ChipElevation {
    public static final int $stable = 0;
    private final float disabledElevation;
    private final float draggedElevation;
    private final float elevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ ChipElevation(float f, float f2, float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6);
    }

    private ChipElevation(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation) {
        this.elevation = elevation;
        this.pressedElevation = pressedElevation;
        this.focusedElevation = focusedElevation;
        this.hoveredElevation = hoveredElevation;
        this.draggedElevation = draggedElevation;
        this.disabledElevation = disabledElevation;
    }

    /* renamed from: getElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getElevation() {
        return this.elevation;
    }

    /* renamed from: getPressedElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getPressedElevation() {
        return this.pressedElevation;
    }

    /* renamed from: getFocusedElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getFocusedElevation() {
        return this.focusedElevation;
    }

    /* renamed from: getHoveredElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getHoveredElevation() {
        return this.hoveredElevation;
    }

    /* renamed from: getDraggedElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getDraggedElevation() {
        return this.draggedElevation;
    }

    /* renamed from: getDisabledElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getDisabledElevation() {
        return this.disabledElevation;
    }

    /* renamed from: tonalElevation-u2uoSUM$material3_release, reason: not valid java name */
    public final float m1882tonalElevationu2uoSUM$material3_release(boolean enabled) {
        return enabled ? this.elevation : this.disabledElevation;
    }

    public final State<C1956Dp> shadowElevation$material3_release(boolean enabled, InteractionSource interactionSource, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1881877139);
        ComposerKt.sourceInformation($composer, "C(shadowElevation)2086@101914L74:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1881877139, $changed, -1, "androidx.compose.material3.ChipElevation.shadowElevation (Chip.kt:2085)");
        }
        State<C1956Dp> stateAnimateElevation = animateElevation(enabled, interactionSource, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateElevation;
    }

    private final State<C1956Dp> animateElevation(boolean z, InteractionSource interactionSource, Composer composer, int i) {
        Object objMutableStateListOf;
        Object objMutableStateOf$default;
        boolean z2;
        ChipElevation$animateElevation$1$1 chipElevation$animateElevation$1$1;
        float f;
        Object animatable;
        composer.startReplaceableGroup(-2071499570);
        ComposerKt.sourceInformation(composer, "C(animateElevation)2094@102163L46,2095@102241L47,2096@102331L1482,2096@102297L1516,2156@104316L51,2158@104400L466,2158@104377L489:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2071499570, i, -1, "androidx.compose.material3.ChipElevation.animateElevation (Chip.kt:2093)");
        }
        composer.startReplaceableGroup(-1373742441);
        ComposerKt.sourceInformation(composer, "CC(remember):Chip.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objMutableStateListOf = SnapshotStateKt.mutableStateListOf();
            composer.updateRememberedValue(objMutableStateListOf);
        } else {
            objMutableStateListOf = objRememberedValue;
        }
        SnapshotStateList snapshotStateList = (SnapshotStateList) objMutableStateListOf;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-1373742363);
        ComposerKt.sourceInformation(composer, "CC(remember):Chip.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(objMutableStateOf$default);
        } else {
            objMutableStateOf$default = objRememberedValue2;
        }
        MutableState mutableState = (MutableState) objMutableStateOf$default;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-1373742273);
        ComposerKt.sourceInformation(composer, "CC(remember):Chip.kt#9igjgp");
        boolean z3 = (((i & 112) ^ 48) > 32 && composer.changed(interactionSource)) || (i & 48) == 32;
        Object objRememberedValue3 = composer.rememberedValue();
        if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            z2 = false;
            chipElevation$animateElevation$1$1 = new ChipElevation$animateElevation$1$1(interactionSource, snapshotStateList, null);
            composer.updateRememberedValue(chipElevation$animateElevation$1$1);
        } else {
            z2 = false;
            chipElevation$animateElevation$1$1 = objRememberedValue3;
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) chipElevation$animateElevation$1$1, composer, (i >> 3) & 14);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull((List) snapshotStateList);
        if (!z) {
            f = this.disabledElevation;
        } else if (interaction instanceof PressInteraction.Press) {
            f = this.pressedElevation;
        } else if (interaction instanceof HoverInteraction.Enter) {
            f = this.hoveredElevation;
        } else if (interaction instanceof FocusInteraction.Focus) {
            f = this.focusedElevation;
        } else {
            f = interaction instanceof DragInteraction.Start ? this.draggedElevation : this.elevation;
        }
        composer.startReplaceableGroup(-1373740288);
        ComposerKt.sourceInformation(composer, "CC(remember):Chip.kt#9igjgp");
        Object objRememberedValue4 = composer.rememberedValue();
        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            animatable = new Animatable(C1956Dp.m6295boximpl(f), VectorConvertersKt.getVectorConverter(C1956Dp.INSTANCE), null, null, 12, null);
            composer.updateRememberedValue(animatable);
        } else {
            animatable = objRememberedValue4;
        }
        Animatable animatable2 = (Animatable) animatable;
        composer.endReplaceableGroup();
        C1956Dp c1956DpM6295boximpl = C1956Dp.m6295boximpl(f);
        composer.startReplaceableGroup(-1373740204);
        ComposerKt.sourceInformation(composer, "CC(remember):Chip.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(animatable2) | composer.changed(f) | (((((i & 14) ^ 6) <= 4 || !composer.changed(z)) && (i & 6) != 4) ? z2 : true) | composer.changedInstance(interaction);
        ChipElevation$animateElevation$2$1 chipElevation$animateElevation$2$1RememberedValue = composer.rememberedValue();
        if (zChangedInstance || chipElevation$animateElevation$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            chipElevation$animateElevation$2$1RememberedValue = new ChipElevation$animateElevation$2$1(animatable2, f, z, interaction, mutableState, null);
            composer.updateRememberedValue(chipElevation$animateElevation$2$1RememberedValue);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(c1956DpM6295boximpl, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) chipElevation$animateElevation$2$1RememberedValue, composer, z2 ? 1 : 0);
        State<C1956Dp> stateAsState = animatable2.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Interaction animateElevation$lambda$2(MutableState<Interaction> mutableState) {
        MutableState<Interaction> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && (other instanceof ChipElevation) && C1956Dp.m6302equalsimpl0(this.elevation, ((ChipElevation) other).elevation) && C1956Dp.m6302equalsimpl0(this.pressedElevation, ((ChipElevation) other).pressedElevation) && C1956Dp.m6302equalsimpl0(this.focusedElevation, ((ChipElevation) other).focusedElevation) && C1956Dp.m6302equalsimpl0(this.hoveredElevation, ((ChipElevation) other).hoveredElevation) && C1956Dp.m6302equalsimpl0(this.disabledElevation, ((ChipElevation) other).disabledElevation)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = C1956Dp.m6303hashCodeimpl(this.elevation);
        return (((((((result * 31) + C1956Dp.m6303hashCodeimpl(this.pressedElevation)) * 31) + C1956Dp.m6303hashCodeimpl(this.focusedElevation)) * 31) + C1956Dp.m6303hashCodeimpl(this.hoveredElevation)) * 31) + C1956Dp.m6303hashCodeimpl(this.disabledElevation);
    }
}
