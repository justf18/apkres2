package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.ClipKt;
import androidx.compose.p000ui.draw.ShadowKt;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.RectangleShapeKt;
import androidx.compose.p000ui.graphics.Shape;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.unit.C1956Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: Surface.kt */
@Metadata(m164d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a©\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001ac\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00142\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0093\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00142\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010'\u001a,\u0010(\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u000eH\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a8\u0010.\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00062"}, m165d2 = {"Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "contentColor", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Surface-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-Ny5ogXk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SurfaceKt {
    /* renamed from: Surface-F-jzlyU, reason: not valid java name */
    public static final void m1669SurfaceFjzlyU(Modifier modifier, Shape shape, long color, long contentColor, BorderStroke border, float elevation, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Shape shape2;
        long color2;
        long contentColor2;
        BorderStroke border2;
        float f;
        final float elevation2;
        final Modifier modifier3;
        final Shape shape3;
        final long color3;
        final BorderStroke border3;
        final long contentColor3;
        final Shape shape4;
        final long color4;
        final BorderStroke border4;
        final float elevation3;
        final Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(1412203386);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(5,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)107@5308L6,108@5350L22,*113@5525L7,114@5549L894:Surface.kt#jmzs0o");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            shape2 = shape;
        } else if (($changed & 112) == 0) {
            shape2 = shape;
            $dirty |= $composer2.changed(shape2) ? 32 : 16;
        } else {
            shape2 = shape;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                color2 = color;
                int i4 = $composer2.changed(color2) ? 256 : 128;
                $dirty |= i4;
            } else {
                color2 = color;
            }
            $dirty |= i4;
        } else {
            color2 = color;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                contentColor2 = contentColor;
                int i5 = $composer2.changed(contentColor2) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i5;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            border2 = border;
        } else if ((57344 & $changed) == 0) {
            border2 = border;
            $dirty |= $composer2.changed(border2) ? 16384 : 8192;
        } else {
            border2 = border;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            f = elevation;
        } else if (($changed & 458752) == 0) {
            f = elevation;
            $dirty |= $composer2.changed(f) ? 131072 : 65536;
        } else {
            f = elevation;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 1048576 : 524288;
        }
        if (($dirty & 2995931) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            shape4 = shape2;
            contentColor3 = contentColor2;
            modifier4 = modifier2;
            elevation3 = f;
            color4 = color2;
            border4 = border2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    shape2 = RectangleShapeKt.getRectangleShape();
                }
                if ((i & 4) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1494getSurface0d7_KjU();
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    contentColor2 = ColorsKt.m1508contentColorForek8zF_U(color2, $composer2, ($dirty >> 6) & 14);
                    $dirty &= -7169;
                }
                if (i6 != 0) {
                    border2 = null;
                }
                if (i7 != 0) {
                    elevation2 = C1956Dp.m6297constructorimpl(0);
                    modifier3 = modifier2;
                    shape3 = shape2;
                    color3 = color2;
                    border3 = border2;
                } else {
                    elevation2 = f;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    color3 = color2;
                    border3 = border2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    elevation2 = f;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    color3 = color2;
                    border3 = border2;
                } else {
                    elevation2 = f;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    color3 = color2;
                    border3 = border2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1412203386, $dirty, -1, "androidx.compose.material.Surface (Surface.kt:112)");
            }
            ProvidableCompositionLocal<C1956Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float arg0$iv = ((C1956Dp) objConsume).m6311unboximpl();
            final float absoluteElevation = C1956Dp.m6297constructorimpl(arg0$iv + elevation2);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3939boximpl(contentColor2)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1956Dp.m6295boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer2, -1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x01ab  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
                    /*
                        Method dump skipped, instructions count: 431
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt$Surface$1.invoke(androidx.compose.runtime.Composer, int):void");
                }

                /* compiled from: Surface.kt */
                @Metadata(m164d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m165d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m166k = 3, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(m179c = "androidx.compose.material.SurfaceKt$Surface$1$2", m180f = "Surface.kt", m181i = {}, m182l = {}, m183m = "invokeSuspend", m184n = {}, m185s = {})
                /* renamed from: androidx.compose.material.SurfaceKt$Surface$1$2 */
                static final class C11062 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                    int label;

                    C11062(Continuation<? super C11062> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C11062(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        return ((C11062) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
            }), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentColor3 = contentColor2;
            shape4 = shape3;
            color4 = color3;
            border4 = border3;
            elevation3 = elevation2;
            modifier4 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$2
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

                public final void invoke(Composer composer, int i8) {
                    SurfaceKt.m1669SurfaceFjzlyU(modifier4, shape4, color4, contentColor3, border4, elevation3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: Surface-LPr_se0, reason: not valid java name */
    public static final void m1670SurfaceLPr_se0(final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function02;
        Modifier modifier2;
        boolean enabled2;
        Shape shape2;
        long color2;
        int i2;
        long contentColor2;
        int i3;
        int i4;
        final BorderStroke border2;
        final float elevation2;
        final MutableInteractionSource interactionSource2;
        final boolean enabled3;
        final Shape shape3;
        int $dirty;
        final long color3;
        Object value$iv$iv;
        final long contentColor3;
        final Modifier modifier3;
        final Shape shape4;
        final long color4;
        final BorderStroke border3;
        final float elevation3;
        final MutableInteractionSource interactionSource3;
        final boolean enabled4;
        Composer $composer2 = $composer.startRestartGroup(1560876237);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(8,7,5,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)216@10794L6,217@10836L22,220@10970L39,*223@11102L7,224@11126L982:Surface.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
            function02 = function0;
        } else if (($changed & 14) == 0) {
            function02 = function0;
            $dirty2 |= $composer2.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            enabled2 = enabled;
        } else if (($changed & 896) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 256 : 128;
        } else {
            enabled2 = enabled;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            shape2 = shape;
        } else if (($changed & 7168) == 0) {
            shape2 = shape;
            $dirty2 |= $composer2.changed(shape2) ? 2048 : 1024;
        } else {
            shape2 = shape;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                color2 = color;
                int i8 = $composer2.changed(color2) ? 16384 : 8192;
                $dirty2 |= i8;
            } else {
                color2 = color;
            }
            $dirty2 |= i8;
        } else {
            color2 = color;
        }
        if ((458752 & $changed) == 0) {
            if ((i & 32) == 0) {
                i2 = i5;
                contentColor2 = contentColor;
                int i9 = $composer2.changed(contentColor2) ? 131072 : 65536;
                $dirty2 |= i9;
            } else {
                i2 = i5;
                contentColor2 = contentColor;
            }
            $dirty2 |= i9;
        } else {
            i2 = i5;
            contentColor2 = contentColor;
        }
        int i10 = i & 64;
        if (i10 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty2 |= $composer2.changed(border) ? 1048576 : 524288;
        }
        int i11 = i & 128;
        if (i11 != 0) {
            $dirty2 |= 12582912;
            i3 = i11;
        } else if (($changed & 29360128) == 0) {
            i3 = i11;
            $dirty2 |= $composer2.changed(elevation) ? 8388608 : 4194304;
        } else {
            i3 = i11;
        }
        int i12 = i & 256;
        if (i12 != 0) {
            $dirty2 |= 100663296;
            i4 = i12;
        } else if (($changed & 234881024) == 0) {
            i4 = i12;
            $dirty2 |= $composer2.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i4 = i12;
        }
        if ((i & 512) != 0) {
            $dirty2 |= 805306368;
        } else if ((1879048192 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 536870912 : 268435456;
        }
        int $dirty3 = $dirty2;
        if (($dirty2 & 1533916891) == 306783378 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            long j = contentColor2;
            enabled4 = enabled2;
            contentColor3 = j;
            modifier3 = modifier2;
            shape4 = shape2;
            color4 = color2;
            border3 = border;
            elevation3 = elevation;
            interactionSource3 = interactionSource;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i2 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    enabled2 = true;
                }
                if (i7 != 0) {
                    shape2 = RectangleShapeKt.getRectangleShape();
                }
                if ((i & 16) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1494getSurface0d7_KjU();
                    $dirty3 &= -57345;
                }
                if ((i & 32) != 0) {
                    contentColor2 = ColorsKt.m1508contentColorForek8zF_U(color2, $composer2, ($dirty3 >> 12) & 14);
                    $dirty3 &= -458753;
                }
                BorderStroke border4 = i10 != 0 ? null : border;
                float elevation4 = i3 != 0 ? C1956Dp.m6297constructorimpl(0) : elevation;
                if (i4 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    BorderStroke border5 = border4;
                    Object it$iv$iv = $composer2.rememberedValue();
                    float elevation5 = elevation4;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    border2 = border5;
                    elevation2 = elevation5;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    $dirty = $dirty3;
                    color3 = color2;
                } else {
                    border2 = border4;
                    elevation2 = elevation4;
                    interactionSource2 = interactionSource;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    $dirty = $dirty3;
                    color3 = color2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 32) != 0) {
                    border2 = border;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty3 & (-458753);
                    enabled3 = enabled2;
                    shape3 = shape2;
                    color3 = color2;
                } else {
                    border2 = border;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    enabled3 = enabled2;
                    shape3 = shape2;
                    $dirty = $dirty3;
                    color3 = color2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1560876237, $dirty, -1, "androidx.compose.material.Surface (Surface.kt:222)");
            }
            ProvidableCompositionLocal<C1956Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float arg0$iv = ((C1956Dp) objConsume).m6311unboximpl();
            final float absoluteElevation = C1956Dp.m6297constructorimpl(arg0$iv + elevation2);
            final Function0<Unit> function03 = function02;
            final Modifier modifier4 = modifier2;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3939boximpl(contentColor2)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1956Dp.m6295boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer2, 2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$4
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x01bb  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
                    /*
                        Method dump skipped, instructions count: 447
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt$Surface$4.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentColor3 = contentColor2;
            modifier3 = modifier4;
            shape4 = shape3;
            color4 = color3;
            border3 = border2;
            elevation3 = elevation2;
            interactionSource3 = interactionSource2;
            enabled4 = enabled3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$5
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
                    SurfaceKt.m1670SurfaceLPr_se0(function0, modifier3, enabled4, shape4, color4, contentColor3, border3, elevation3, interactionSource3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m1671SurfaceNy5ogXk(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        Function0<Unit> function02;
        Modifier modifier2;
        boolean z2;
        Shape shape2;
        final long color2;
        int $dirty;
        int $dirty1;
        int i2;
        int i3;
        int i4;
        int $dirty12;
        long contentColor2;
        final BorderStroke border2;
        final MutableInteractionSource interactionSource2;
        final float elevation2;
        final boolean enabled2;
        long contentColor3;
        final Shape shape3;
        int $dirty2;
        final long color3;
        int i5;
        Object value$iv$iv;
        final long contentColor4;
        final Modifier modifier3;
        final Shape shape4;
        final BorderStroke border3;
        final float elevation3;
        final MutableInteractionSource interactionSource3;
        final boolean enabled3;
        int $dirty3;
        Composer $composer2 = $composer.startRestartGroup(262027249);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(9,8,7,5,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)330@16547L6,331@16589L22,334@16723L39,*337@16855L7,338@16879L1024:Surface.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
            z = selected;
        } else if (($changed & 14) == 0) {
            z = selected;
            $dirty4 |= $composer2.changed(z) ? 4 : 2;
        } else {
            z = selected;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
            function02 = function0;
        } else if (($changed & 112) == 0) {
            function02 = function0;
            $dirty4 |= $composer2.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty4 |= 3072;
            z2 = enabled;
        } else if (($changed & 7168) == 0) {
            z2 = enabled;
            $dirty4 |= $composer2.changed(z2) ? 2048 : 1024;
        } else {
            z2 = enabled;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty4 |= 24576;
            shape2 = shape;
        } else if ((57344 & $changed) == 0) {
            shape2 = shape;
            $dirty4 |= $composer2.changed(shape2) ? 16384 : 8192;
        } else {
            shape2 = shape;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                color2 = color;
                int i9 = $composer2.changed(color2) ? 131072 : 65536;
                $dirty4 |= i9;
            } else {
                color2 = color;
            }
            $dirty4 |= i9;
        } else {
            color2 = color;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                $dirty1 = $changed1;
                int i10 = $composer2.changed(contentColor) ? 1048576 : 524288;
                $dirty = $dirty3 | i10;
            } else {
                $dirty3 = $dirty4;
                $dirty1 = $changed1;
            }
            $dirty = $dirty3 | i10;
        } else {
            $dirty = $dirty4;
            $dirty1 = $changed1;
        }
        int i11 = i & 128;
        if (i11 != 0) {
            $dirty |= 12582912;
            i2 = i11;
        } else if (($changed & 29360128) == 0) {
            i2 = i11;
            $dirty |= $composer2.changed(border) ? 8388608 : 4194304;
        } else {
            i2 = i11;
        }
        int i12 = i & 256;
        if (i12 != 0) {
            $dirty |= 100663296;
            i3 = i12;
        } else if (($changed & 234881024) == 0) {
            i3 = i12;
            $dirty |= $composer2.changed(elevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i12;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty |= 805306368;
            i4 = i13;
        } else if (($changed & 1879048192) == 0) {
            i4 = i13;
            $dirty |= $composer2.changed(interactionSource) ? 536870912 : 268435456;
        } else {
            i4 = i13;
        }
        if ((i & 1024) != 0) {
            $dirty12 = $dirty1 | 6;
        } else {
            int $dirty13 = $changed1 & 14;
            if ($dirty13 == 0) {
                $dirty1 |= $composer2.changedInstance(function2) ? 4 : 2;
            }
            $dirty12 = $dirty1;
        }
        if (($dirty & 1533916891) == 306783378 && ($dirty12 & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            contentColor4 = contentColor;
            elevation3 = elevation;
            modifier3 = modifier2;
            enabled3 = z2;
            shape4 = shape2;
            border3 = border;
            interactionSource3 = interactionSource;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i6 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i7 != 0 ? true : z2;
                if (i8 != 0) {
                    shape2 = RectangleShapeKt.getRectangleShape();
                }
                if ((i & 32) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1494getSurface0d7_KjU();
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    contentColor2 = ColorsKt.m1508contentColorForek8zF_U(color2, $composer2, ($dirty >> 15) & 14);
                    $dirty &= -3670017;
                } else {
                    contentColor2 = contentColor;
                }
                BorderStroke border4 = i2 != 0 ? null : border;
                float elevation4 = i3 != 0 ? C1956Dp.m6297constructorimpl(0) : elevation;
                if (i4 != 0) {
                    Modifier modifier5 = modifier4;
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    BorderStroke border5 = border4;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    border2 = border5;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    elevation2 = elevation4;
                    enabled2 = enabled4;
                    contentColor3 = contentColor2;
                    shape3 = shape2;
                    $dirty2 = $dirty;
                    modifier2 = modifier5;
                    color3 = color2;
                    i5 = 262027249;
                } else {
                    Modifier modifier6 = modifier4;
                    border2 = border4;
                    interactionSource2 = interactionSource;
                    elevation2 = elevation4;
                    enabled2 = enabled4;
                    contentColor3 = contentColor2;
                    shape3 = shape2;
                    $dirty2 = $dirty;
                    modifier2 = modifier6;
                    color3 = color2;
                    i5 = 262027249;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty2 = $dirty & (-3670017);
                    contentColor3 = contentColor;
                    border2 = border;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    color3 = color2;
                    enabled2 = z2;
                    shape3 = shape2;
                    i5 = 262027249;
                } else {
                    contentColor3 = contentColor;
                    border2 = border;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    enabled2 = z2;
                    shape3 = shape2;
                    $dirty2 = $dirty;
                    color3 = color2;
                    i5 = 262027249;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i5, $dirty2, $dirty12, "androidx.compose.material.Surface (Surface.kt:336)");
            }
            ProvidableCompositionLocal<C1956Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float arg0$iv = ((C1956Dp) objConsume).m6311unboximpl();
            final float absoluteElevation = C1956Dp.m6297constructorimpl(arg0$iv + elevation2);
            final boolean z3 = z;
            final Function0<Unit> function03 = function02;
            final Modifier modifier7 = modifier2;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3939boximpl(contentColor3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1956Dp.m6295boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer2, -1391199439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$7
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x01bc  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
                    /*
                        Method dump skipped, instructions count: 448
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt$Surface$7.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentColor4 = contentColor3;
            modifier3 = modifier7;
            shape4 = shape3;
            color2 = color3;
            border3 = border2;
            elevation3 = elevation2;
            interactionSource3 = interactionSource2;
            enabled3 = enabled2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$8
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
                    SurfaceKt.m1671SurfaceNy5ogXk(selected, function0, modifier3, enabled3, shape4, color2, contentColor4, border3, elevation3, interactionSource3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m1672SurfaceNy5ogXk(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        Function1<? super Boolean, Unit> function12;
        Modifier modifier2;
        boolean z2;
        Shape shape2;
        final long color2;
        int $dirty;
        int $dirty1;
        int i2;
        int i3;
        int i4;
        int $dirty12;
        long contentColor2;
        final BorderStroke border2;
        final MutableInteractionSource interactionSource2;
        final float elevation2;
        final boolean enabled2;
        long contentColor3;
        final Shape shape3;
        int $dirty2;
        final long color3;
        int i5;
        Object value$iv$iv;
        final long contentColor4;
        final Modifier modifier3;
        final Shape shape4;
        final BorderStroke border3;
        final float elevation3;
        final MutableInteractionSource interactionSource3;
        final boolean enabled3;
        int $dirty3;
        Composer $composer2 = $composer.startRestartGroup(1341569296);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(1,9,8,6,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color!1,5:c#ui.unit.Dp,7)445@22417L6,446@22459L22,449@22593L39,*452@22725L7,453@22749L1034:Surface.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
            z = checked;
        } else if (($changed & 14) == 0) {
            z = checked;
            $dirty4 |= $composer2.changed(z) ? 4 : 2;
        } else {
            z = checked;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
            function12 = function1;
        } else if (($changed & 112) == 0) {
            function12 = function1;
            $dirty4 |= $composer2.changedInstance(function12) ? 32 : 16;
        } else {
            function12 = function1;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty4 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty4 |= 3072;
            z2 = enabled;
        } else if (($changed & 7168) == 0) {
            z2 = enabled;
            $dirty4 |= $composer2.changed(z2) ? 2048 : 1024;
        } else {
            z2 = enabled;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty4 |= 24576;
            shape2 = shape;
        } else if ((57344 & $changed) == 0) {
            shape2 = shape;
            $dirty4 |= $composer2.changed(shape2) ? 16384 : 8192;
        } else {
            shape2 = shape;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                color2 = color;
                int i9 = $composer2.changed(color2) ? 131072 : 65536;
                $dirty4 |= i9;
            } else {
                color2 = color;
            }
            $dirty4 |= i9;
        } else {
            color2 = color;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                $dirty1 = $changed1;
                int i10 = $composer2.changed(contentColor) ? 1048576 : 524288;
                $dirty = $dirty3 | i10;
            } else {
                $dirty3 = $dirty4;
                $dirty1 = $changed1;
            }
            $dirty = $dirty3 | i10;
        } else {
            $dirty = $dirty4;
            $dirty1 = $changed1;
        }
        int i11 = i & 128;
        if (i11 != 0) {
            $dirty |= 12582912;
            i2 = i11;
        } else if (($changed & 29360128) == 0) {
            i2 = i11;
            $dirty |= $composer2.changed(border) ? 8388608 : 4194304;
        } else {
            i2 = i11;
        }
        int i12 = i & 256;
        if (i12 != 0) {
            $dirty |= 100663296;
            i3 = i12;
        } else if (($changed & 234881024) == 0) {
            i3 = i12;
            $dirty |= $composer2.changed(elevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i12;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty |= 805306368;
            i4 = i13;
        } else if (($changed & 1879048192) == 0) {
            i4 = i13;
            $dirty |= $composer2.changed(interactionSource) ? 536870912 : 268435456;
        } else {
            i4 = i13;
        }
        if ((i & 1024) != 0) {
            $dirty12 = $dirty1 | 6;
        } else {
            int $dirty13 = $changed1 & 14;
            if ($dirty13 == 0) {
                $dirty1 |= $composer2.changedInstance(function2) ? 4 : 2;
            }
            $dirty12 = $dirty1;
        }
        if (($dirty & 1533916891) == 306783378 && ($dirty12 & 11) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            contentColor4 = contentColor;
            elevation3 = elevation;
            modifier3 = modifier2;
            enabled3 = z2;
            shape4 = shape2;
            border3 = border;
            interactionSource3 = interactionSource;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i6 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled4 = i7 != 0 ? true : z2;
                if (i8 != 0) {
                    shape2 = RectangleShapeKt.getRectangleShape();
                }
                if ((i & 32) != 0) {
                    color2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1494getSurface0d7_KjU();
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    contentColor2 = ColorsKt.m1508contentColorForek8zF_U(color2, $composer2, ($dirty >> 15) & 14);
                    $dirty &= -3670017;
                } else {
                    contentColor2 = contentColor;
                }
                BorderStroke border4 = i2 != 0 ? null : border;
                float elevation4 = i3 != 0 ? C1956Dp.m6297constructorimpl(0) : elevation;
                if (i4 != 0) {
                    Modifier modifier5 = modifier4;
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    BorderStroke border5 = border4;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    border2 = border5;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    elevation2 = elevation4;
                    enabled2 = enabled4;
                    contentColor3 = contentColor2;
                    shape3 = shape2;
                    $dirty2 = $dirty;
                    modifier2 = modifier5;
                    color3 = color2;
                    i5 = 1341569296;
                } else {
                    Modifier modifier6 = modifier4;
                    border2 = border4;
                    interactionSource2 = interactionSource;
                    elevation2 = elevation4;
                    enabled2 = enabled4;
                    contentColor3 = contentColor2;
                    shape3 = shape2;
                    $dirty2 = $dirty;
                    modifier2 = modifier6;
                    color3 = color2;
                    i5 = 1341569296;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    $dirty2 = $dirty & (-3670017);
                    contentColor3 = contentColor;
                    border2 = border;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    color3 = color2;
                    enabled2 = z2;
                    shape3 = shape2;
                    i5 = 1341569296;
                } else {
                    contentColor3 = contentColor;
                    border2 = border;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    enabled2 = z2;
                    shape3 = shape2;
                    $dirty2 = $dirty;
                    color3 = color2;
                    i5 = 1341569296;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i5, $dirty2, $dirty12, "androidx.compose.material.Surface (Surface.kt:451)");
            }
            ProvidableCompositionLocal<C1956Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float arg0$iv = ((C1956Dp) objConsume).m6311unboximpl();
            final float absoluteElevation = C1956Dp.m6297constructorimpl(arg0$iv + elevation2);
            final boolean z3 = z;
            final Function1<? super Boolean, Unit> function13 = function12;
            final Modifier modifier7 = modifier2;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3939boximpl(contentColor3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1956Dp.m6295boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer2, -311657392, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$10
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x01bc  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
                    /*
                        Method dump skipped, instructions count: 448
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt$Surface$10.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentColor4 = contentColor3;
            modifier3 = modifier7;
            shape4 = shape3;
            color2 = color3;
            border3 = border2;
            elevation3 = elevation2;
            interactionSource3 = interactionSource2;
            enabled3 = enabled2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$11
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
                    SurfaceKt.m1672SurfaceNy5ogXk(checked, function1, modifier3, enabled3, shape4, color2, contentColor4, border3, elevation3, interactionSource3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Surface function overload that accepts an onClick().", replaceWith = @ReplaceWith(expression = "Surface(onClick, modifier, enabled, shape, color, contentColor, border, elevation, interactionSource, content)", imports = {}))
    /* renamed from: Surface-9VG74zQ, reason: not valid java name */
    public static final void m1668Surface9VG74zQ(final Function0<Unit> function0, Modifier modifier, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Indication indication, boolean enabled, String onClickLabel, Role role, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int $changed1, final int i) {
        Shape shape2;
        long contentColor2;
        BorderStroke border2;
        final float elevation2;
        int i2;
        int i3;
        int i4;
        Shape shape3;
        long color2;
        float elevation3;
        MutableInteractionSource interactionSource2;
        Indication indication2;
        final float elevation4;
        final Role role2;
        final MutableInteractionSource interactionSource3;
        final Indication indication3;
        final boolean enabled2;
        final String onClickLabel2;
        final BorderStroke border3;
        int i5;
        int i6;
        final long color3;
        long color4;
        final Shape shape4;
        final Modifier modifier2;
        Object value$iv$iv;
        Composer $composer2;
        int $dirty1;
        final long contentColor3;
        final Shape shape5;
        final BorderStroke border4;
        final MutableInteractionSource interactionSource4;
        final boolean enabled3;
        final long color5;
        final String onClickLabel3;
        final Role role3;
        Composer $composer3 = $composer.startRestartGroup(1585925488);
        ComposerKt.sourceInformation($composer3, "C(Surface)P(9,8,12,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,7,6,5,10,11:c#ui.semantics.Role)573@28985L6,574@29027L22,577@29161L39,578@29248L7,*584@29435L7,585@29459L1128:Surface.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        int i7 = i & 2;
        if (i7 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i8 = i & 4;
        if (i8 != 0) {
            $dirty |= 384;
            shape2 = shape;
        } else if (($changed & 896) == 0) {
            shape2 = shape;
            $dirty |= $composer3.changed(shape2) ? 256 : 128;
        } else {
            shape2 = shape;
        }
        if (($changed & 7168) == 0) {
            $dirty |= ((i & 8) == 0 && $composer3.changed(color)) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                contentColor2 = contentColor;
                int i9 = $composer3.changed(contentColor2) ? 16384 : 8192;
                $dirty |= i9;
            } else {
                contentColor2 = contentColor;
            }
            $dirty |= i9;
        } else {
            contentColor2 = contentColor;
        }
        int i10 = i & 32;
        if (i10 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.f249xf2722a21;
            border2 = border;
        } else if (($changed & 458752) == 0) {
            border2 = border;
            $dirty |= $composer3.changed(border2) ? 131072 : 65536;
        } else {
            border2 = border;
        }
        int i11 = i & 64;
        if (i11 != 0) {
            $dirty |= 1572864;
            elevation2 = elevation;
        } else if (($changed & 3670016) == 0) {
            elevation2 = elevation;
            $dirty |= $composer3.changed(elevation2) ? 1048576 : 524288;
        } else {
            elevation2 = elevation;
        }
        int i12 = i & 128;
        if (i12 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer3.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            $dirty |= ((i & 256) == 0 && $composer3.changed(indication)) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty |= 805306368;
            i2 = i13;
        } else if (($changed & 1879048192) == 0) {
            i2 = i13;
            $dirty |= $composer3.changed(enabled) ? 536870912 : 268435456;
        } else {
            i2 = i13;
        }
        int i14 = i & 1024;
        if (i14 != 0) {
            $dirty12 |= 6;
            i3 = i14;
        } else if (($changed1 & 14) == 0) {
            i3 = i14;
            $dirty12 |= $composer3.changed(onClickLabel) ? 4 : 2;
        } else {
            i3 = i14;
        }
        int i15 = i & 2048;
        if (i15 != 0) {
            $dirty12 |= 48;
            i4 = i15;
        } else if (($changed1 & 112) == 0) {
            i4 = i15;
            $dirty12 |= $composer3.changed(role) ? 32 : 16;
        } else {
            i4 = i15;
        }
        if ((i & 4096) != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty12 |= $composer3.changedInstance(function2) ? 256 : 128;
        }
        if (($dirty & 1533916891) == 306783378 && ($dirty12 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            interactionSource4 = interactionSource;
            indication3 = indication;
            onClickLabel3 = onClickLabel;
            role3 = role;
            $composer2 = $composer3;
            $dirty1 = $dirty12;
            shape5 = shape2;
            contentColor3 = contentColor2;
            border4 = border2;
            modifier2 = modifier;
            color5 = color;
            enabled3 = enabled;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i7 != 0 ? Modifier.INSTANCE : modifier;
                if (i8 != 0) {
                    shape2 = RectangleShapeKt.getRectangleShape();
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    shape3 = shape2;
                    color2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1494getSurface0d7_KjU();
                } else {
                    shape3 = shape2;
                    color2 = color;
                }
                if ((i & 16) != 0) {
                    contentColor2 = ColorsKt.m1508contentColorForek8zF_U(color2, $composer3, ($dirty >> 9) & 14);
                    $dirty &= -57345;
                }
                if (i10 != 0) {
                    border2 = null;
                }
                float elevation5 = i11 != 0 ? C1956Dp.m6297constructorimpl(0) : elevation2;
                if (i12 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    elevation3 = elevation5;
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    elevation3 = elevation5;
                    interactionSource2 = interactionSource;
                }
                if ((i & 256) != 0) {
                    ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = $composer3.consume(localIndication);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    indication2 = (Indication) objConsume;
                    $dirty &= -234881025;
                } else {
                    indication2 = indication;
                }
                boolean enabled4 = i2 != 0 ? true : enabled;
                String onClickLabel4 = i3 != 0 ? null : onClickLabel;
                if (i4 != 0) {
                    elevation4 = elevation3;
                    interactionSource3 = interactionSource2;
                    indication3 = indication2;
                    enabled2 = enabled4;
                    onClickLabel2 = onClickLabel4;
                    role2 = null;
                    border3 = border2;
                    i5 = 2;
                    i6 = 1585925488;
                    color3 = color2;
                    color4 = contentColor2;
                    shape4 = shape3;
                    modifier2 = modifier3;
                } else {
                    elevation4 = elevation3;
                    role2 = role;
                    interactionSource3 = interactionSource2;
                    indication3 = indication2;
                    enabled2 = enabled4;
                    onClickLabel2 = onClickLabel4;
                    border3 = border2;
                    i5 = 2;
                    i6 = 1585925488;
                    color3 = color2;
                    color4 = contentColor2;
                    shape4 = shape3;
                    modifier2 = modifier3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i & 256) != 0) {
                    shape4 = shape2;
                    color4 = contentColor2;
                    modifier2 = modifier;
                    color3 = color;
                    interactionSource3 = interactionSource;
                    indication3 = indication;
                    enabled2 = enabled;
                    onClickLabel2 = onClickLabel;
                    role2 = role;
                    $dirty &= -234881025;
                    elevation4 = elevation2;
                    border3 = border2;
                    i5 = 2;
                    i6 = 1585925488;
                } else {
                    shape4 = shape2;
                    color4 = contentColor2;
                    modifier2 = modifier;
                    color3 = color;
                    interactionSource3 = interactionSource;
                    indication3 = indication;
                    enabled2 = enabled;
                    onClickLabel2 = onClickLabel;
                    role2 = role;
                    elevation4 = elevation2;
                    border3 = border2;
                    i5 = 2;
                    i6 = 1585925488;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i6, $dirty, $dirty12, "androidx.compose.material.Surface (Surface.kt:583)");
            }
            ProvidableCompositionLocal<C1956Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = $composer3.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float arg0$iv = ((C1956Dp) objConsume2).m6311unboximpl();
            final float absoluteElevation = C1956Dp.m6297constructorimpl(arg0$iv + elevation4);
            ProvidedValue[] providedValueArr = new ProvidedValue[i5];
            providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m3939boximpl(color4));
            providedValueArr[1] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(C1956Dp.m6295boximpl(absoluteElevation));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer3, 149594672, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$13
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

                /* JADX WARN: Removed duplicated region for block: B:28:0x01b2  */
                /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
                    /*
                        Method dump skipped, instructions count: 438
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt$Surface$13.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer3, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2 = $composer3;
            $dirty1 = $dirty12;
            contentColor3 = color4;
            shape5 = shape4;
            border4 = border3;
            elevation2 = elevation4;
            interactionSource4 = interactionSource3;
            enabled3 = enabled2;
            color5 = color3;
            onClickLabel3 = onClickLabel2;
            role3 = role2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Indication indication4 = indication3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$14
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

                public final void invoke(Composer composer, int i16) {
                    SurfaceKt.m1668Surface9VG74zQ(function0, modifier4, shape5, color5, contentColor3, border4, elevation2, interactionSource4, indication4, enabled3, onClickLabel3, role3, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surface-8ww4TTg, reason: not valid java name */
    public static final Modifier m1675surface8ww4TTg(Modifier $this$surface_u2d8ww4TTg, Shape shape, long backgroundColor, BorderStroke border, float elevation) {
        Modifier $this$surface_u2d8ww4TTg2 = ShadowKt.m3621shadows4CzXII$default($this$surface_u2d8ww4TTg, elevation, shape, false, 0L, 0L, 24, null);
        Modifier.Companion companionBorder = Modifier.INSTANCE;
        if (border != null) {
            companionBorder = BorderKt.border(companionBorder, border, shape);
        }
        return ClipKt.clip(BackgroundKt.m414backgroundbw27NRU($this$surface_u2d8ww4TTg2.then(companionBorder), backgroundColor, shape), shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surfaceColorAtElevation-cq6XJ1M, reason: not valid java name */
    public static final long m1676surfaceColorAtElevationcq6XJ1M(long color, ElevationOverlay elevationOverlay, float absoluteElevation, Composer $composer, int $changed) {
        Composer $composer2;
        long color2;
        $composer.startReplaceableGroup(1561611256);
        ComposerKt.sourceInformation($composer, "C(surfaceColorAtElevation)P(1:c#ui.graphics.Color,2,0:c#ui.unit.Dp)635@31093L6,636@31164L31:Surface.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1561611256, $changed, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:634)");
        }
        if (Color.m3950equalsimpl0(color, MaterialTheme.INSTANCE.getColors($composer, 6).m1494getSurface0d7_KjU()) && elevationOverlay != null) {
            $composer2 = $composer;
            color2 = elevationOverlay.mo1530apply7g2Lkgo(color, absoluteElevation, $composer2, ($changed & 14) | (($changed >> 3) & 112) | (($changed << 3) & 896));
        } else {
            $composer2 = $composer;
            color2 = color;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer2.endReplaceableGroup();
        return color2;
    }
}
