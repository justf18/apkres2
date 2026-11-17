package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
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

/* compiled from: Button.kt */
@Metadata(m164d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0016\u0010\u0010J\u001d\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, m165d2 = {"Landroidx/compose/material3/ButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "(FFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation-u2uoSUM$material3_release", "(Z)F", "material3_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ButtonElevation {
    public static final int $stable = 0;
    private final float defaultElevation;
    private final float disabledElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ ButtonElevation(float f, float f2, float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5);
    }

    private ButtonElevation(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float disabledElevation) {
        this.defaultElevation = defaultElevation;
        this.pressedElevation = pressedElevation;
        this.focusedElevation = focusedElevation;
        this.hoveredElevation = hoveredElevation;
        this.disabledElevation = disabledElevation;
    }

    /* renamed from: tonalElevation-u2uoSUM$material3_release, reason: not valid java name */
    public final float m1821tonalElevationu2uoSUM$material3_release(boolean enabled) {
        return enabled ? this.defaultElevation : this.disabledElevation;
    }

    public final State<C1956Dp> shadowElevation$material3_release(boolean enabled, InteractionSource interactionSource, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-2045116089);
        ComposerKt.sourceInformation($composer, "C(shadowElevation)890@42214L74:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2045116089, $changed, -1, "androidx.compose.material3.ButtonElevation.shadowElevation (Button.kt:889)");
        }
        State<C1956Dp> stateAnimateElevation = animateElevation(enabled, interactionSource, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAnimateElevation;
    }

    private final State<C1956Dp> animateElevation(boolean enabled, InteractionSource interactionSource, Composer $composer, int $changed) {
        Object value$iv;
        ButtonElevation$animateElevation$1$1 value$iv2;
        float target;
        Object value$iv3;
        $composer.startReplaceableGroup(-1312510462);
        ComposerKt.sourceInformation($composer, "C(animateElevation)898@42463L46,899@42552L1083,899@42518L1117,947@44132L51,949@44216L819,949@44193L842:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1312510462, $changed, -1, "androidx.compose.material3.ButtonElevation.animateElevation (Button.kt:897)");
        }
        $composer.startReplaceableGroup(-719928451);
        ComposerKt.sourceInformation($composer, "CC(remember):Button.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt.mutableStateListOf();
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        SnapshotStateList interactions = (SnapshotStateList) value$iv;
        $composer.endReplaceableGroup();
        $composer.startReplaceableGroup(-719928362);
        ComposerKt.sourceInformation($composer, "CC(remember):Button.kt#9igjgp");
        boolean invalid$iv = ((($changed & 112) ^ 48) > 32 && $composer.changed(interactionSource)) || ($changed & 48) == 32;
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = new ButtonElevation$animateElevation$1$1(interactionSource, interactions, null);
            $composer.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv2, $composer, ($changed >> 3) & 14);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull((List) interactions);
        if (!enabled) {
            target = this.disabledElevation;
        } else if (interaction instanceof PressInteraction.Press) {
            target = this.pressedElevation;
        } else if (interaction instanceof HoverInteraction.Enter) {
            target = this.hoveredElevation;
        } else {
            target = interaction instanceof FocusInteraction.Focus ? this.focusedElevation : this.defaultElevation;
        }
        $composer.startReplaceableGroup(-719926782);
        ComposerKt.sourceInformation($composer, "CC(remember):Button.kt#9igjgp");
        Object it$iv3 = $composer.rememberedValue();
        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv3 = new Animatable(C1956Dp.m6295boximpl(target), VectorConvertersKt.getVectorConverter(C1956Dp.INSTANCE), null, null, 12, null);
            $composer.updateRememberedValue(value$iv3);
        } else {
            value$iv3 = it$iv3;
        }
        Animatable animatable = (Animatable) value$iv3;
        $composer.endReplaceableGroup();
        C1956Dp c1956DpM6295boximpl = C1956Dp.m6295boximpl(target);
        $composer.startReplaceableGroup(-719926698);
        ComposerKt.sourceInformation($composer, "CC(remember):Button.kt#9igjgp");
        boolean invalid$iv2 = $composer.changedInstance(animatable) | $composer.changed(target) | (((($changed & 14) ^ 6) > 4 && $composer.changed(enabled)) || ($changed & 6) == 4) | (((($changed & 896) ^ 384) > 256 && $composer.changed(this)) || ($changed & 384) == 256) | $composer.changedInstance(interaction);
        ButtonElevation$animateElevation$2$1 value$iv4 = $composer.rememberedValue();
        if (invalid$iv2 || value$iv4 == Composer.INSTANCE.getEmpty()) {
            value$iv4 = new ButtonElevation$animateElevation$2$1(animatable, target, enabled, this, interaction, null);
            $composer.updateRememberedValue(value$iv4);
        }
        $composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(c1956DpM6295boximpl, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv4, $composer, 0);
        State<C1956Dp> stateAsState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return stateAsState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && (other instanceof ButtonElevation) && C1956Dp.m6302equalsimpl0(this.defaultElevation, ((ButtonElevation) other).defaultElevation) && C1956Dp.m6302equalsimpl0(this.pressedElevation, ((ButtonElevation) other).pressedElevation) && C1956Dp.m6302equalsimpl0(this.focusedElevation, ((ButtonElevation) other).focusedElevation) && C1956Dp.m6302equalsimpl0(this.hoveredElevation, ((ButtonElevation) other).hoveredElevation) && C1956Dp.m6302equalsimpl0(this.disabledElevation, ((ButtonElevation) other).disabledElevation)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = C1956Dp.m6303hashCodeimpl(this.defaultElevation);
        return (((((((result * 31) + C1956Dp.m6303hashCodeimpl(this.pressedElevation)) * 31) + C1956Dp.m6303hashCodeimpl(this.focusedElevation)) * 31) + C1956Dp.m6303hashCodeimpl(this.hoveredElevation)) * 31) + C1956Dp.m6303hashCodeimpl(this.disabledElevation);
    }
}
