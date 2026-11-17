package androidx.compose.p000ui.layout;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TestModifierUpdater.kt */
@Metadata(m164d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m165d2 = {"TestModifierUpdaterLayout", "", "onAttached", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/TestModifierUpdater;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ui_release"}, m166k = 2, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TestModifierUpdaterKt {
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d8  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "It is a test API, do not use it in the real applications")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TestModifierUpdaterLayout(final kotlin.jvm.functions.Function1<? super androidx.compose.p000ui.layout.TestModifierUpdater, kotlin.Unit> r16, androidx.compose.runtime.Composer r17, final int r18) {
        /*
            r0 = r16
            r1 = r18
            r2 = -1673066036(0xffffffff9c4709cc, float:-6.585624E-22)
            r3 = r17
            androidx.compose.runtime.Composer r3 = r3.startRestartGroup(r2)
            java.lang.String r4 = "C(TestModifierUpdaterLayout)50@1816L23,54@1971L330:TestModifierUpdater.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r18
            r5 = r1 & 14
            r6 = 2
            if (r5 != 0) goto L23
            boolean r5 = r3.changedInstance(r0)
            if (r5 == 0) goto L21
            r5 = 4
            goto L22
        L21:
            r5 = r6
        L22:
            r4 = r4 | r5
        L23:
            r5 = r4 & 11
            if (r5 != r6) goto L33
            boolean r5 = r3.getSkipping()
            if (r5 != 0) goto L2e
            goto L33
        L2e:
            r3.skipToGroupEnd()
            goto Ldb
        L33:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L3f
            r5 = -1
            java.lang.String r6 = "androidx.compose.ui.layout.TestModifierUpdaterLayout (TestModifierUpdater.kt:49)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r4, r5, r6)
        L3f:
            r2 = 0
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r3, r2)
            androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1 r5 = new androidx.compose.p000ui.layout.MeasurePolicy() { // from class: androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1
                static {
                    /*
                        androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1 r0 = new androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1) androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.INSTANCE androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p000ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p000ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.<init>():void");
                }


                @Override // androidx.compose.p000ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final androidx.compose.p000ui.layout.MeasureResult mo243measure3p2s80s(androidx.compose.p000ui.layout.MeasureScope r8, java.util.List<? extends androidx.compose.p000ui.layout.Measurable> r9, long r10) {
                    /*
                        r7 = this;
                        int r1 = androidx.compose.p000ui.unit.Constraints.m6253getMaxWidthimpl(r10)
                        int r2 = androidx.compose.p000ui.unit.Constraints.m6252getMaxHeightimpl(r10)
                        androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$1 r9 = new kotlin.jvm.functions.Function1<androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>() { // from class: androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.1
                            static {
                                /*
                                    androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$1 r0 = new androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$1
                                    r0.<init>()
                                    
                                    // error: 0x0005: SPUT (r0 I:androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$1) androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.1.INSTANCE androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$1
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p000ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.C17971.<clinit>():void");
                            }

                            {
                                /*
                                    r1 = this;
                                    r0 = 1
                                    r1.<init>(r0)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p000ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.C17971.<init>():void");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ kotlin.Unit invoke(androidx.compose.ui.layout.Placeable.PlacementScope r2) {
                                /*
                                    r1 = this;
                                    r0 = r2
                                    androidx.compose.ui.layout.Placeable$PlacementScope r0 = (androidx.compose.ui.layout.Placeable.PlacementScope) r0
                                    r1.invoke2(r0)
                                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p000ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.C17971.invoke(java.lang.Object):java.lang.Object");
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(androidx.compose.ui.layout.Placeable.PlacementScope r1) {
                                /*
                                    r0 = this;
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p000ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.C17971.invoke2(androidx.compose.ui.layout.Placeable$PlacementScope):void");
                            }
                        }
                        r4 = r9
                        kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
                        r5 = 4
                        r6 = 0
                        r3 = 0
                        r0 = r8
                        androidx.compose.ui.layout.MeasureResult r8 = androidx.compose.p000ui.layout.MeasureScope.layout$default(r0, r1, r2, r3, r4, r5, r6)
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p000ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.mo243measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
                }
            }
            androidx.compose.ui.layout.MeasurePolicy r5 = (androidx.compose.p000ui.layout.MeasurePolicy) r5
            androidx.compose.ui.node.LayoutNode$Companion r6 = androidx.compose.p000ui.node.LayoutNode.INSTANCE
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor$ui_release()
            r7 = 6
            r8 = 0
            r9 = 1886828752(0x7076b8d0, float:3.0542695E29)
            r3.startReplaceableGroup(r9)
            java.lang.String r9 = "CC(ComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r9)
            androidx.compose.runtime.Applier r9 = r3.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L67
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L67:
            r3.startNode()
            boolean r9 = r3.getInserting()
            if (r9 == 0) goto L7b
            androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$$inlined$ComposeNode$1 r9 = new androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$$inlined$ComposeNode$1
            r9.<init>()
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r3.createNode(r9)
            goto L7e
        L7b:
            r3.useNode()
        L7e:
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m3479constructorimpl(r3)
            r10 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.p000ui.node.ComposeUiNode.INSTANCE
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m3486setimpl(r9, r5, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.p000ui.node.ComposeUiNode.INSTANCE
            kotlin.jvm.functions.Function2 r11 = r11.getSetCompositeKeyHash()
            r12 = 0
            r13 = r9
            r14 = 0
            boolean r15 = r13.getInserting()
            if (r15 != 0) goto Lac
            java.lang.Object r15 = r13.rememberedValue()
            r17 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r15, r2)
            if (r2 != 0) goto Lbc
            goto Lae
        Lac:
            r17 = r2
        Lae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            r13.updateRememberedValue(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            r9.apply(r2, r11)
        Lbc:
            androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1 r2 = new androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1
            r2.<init>()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.runtime.Updater.m3483initimpl(r9, r2)
            r3.endNode()
            r3.endReplaceableGroup()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto Ldb
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        Ldb:
            androidx.compose.runtime.ScopeUpdateScope r2 = r3.endRestartGroup()
            if (r2 == 0) goto Leb
            androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$2 r5 = new androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$2
            r5.<init>()
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r2.updateScope(r5)
        Leb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p000ui.layout.TestModifierUpdaterKt.TestModifierUpdaterLayout(kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }
}
