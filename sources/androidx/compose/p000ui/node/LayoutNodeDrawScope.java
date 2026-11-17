package androidx.compose.p000ui.node;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Canvas;
import androidx.compose.p000ui.graphics.ColorFilter;
import androidx.compose.p000ui.graphics.ImageBitmap;
import androidx.compose.p000ui.graphics.Path;
import androidx.compose.p000ui.graphics.PathEffect;
import androidx.compose.p000ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p000ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawContext;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawStyle;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.DpRect;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutNodeDrawScope.kt */
@Metadata(m164d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J2\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020#H\u0000ø\u0001\u0000¢\u0006\u0004\b$\u0010%Jq\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106Jq\u0010&\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:JY\u0010;\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010<\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>JY\u0010;\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010<\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020\u001eH\u0016J2\u0010B\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\bC\u0010DJO\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010IJm\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020K2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJw\u0010E\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020K2\b\b\u0002\u0010O\u001a\u00020M2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u0010R\u001a\u00020SH\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJk\u0010V\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010_Jk\u0010V\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00072\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010aJY\u0010b\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bc\u0010dJY\u0010b\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\be\u0010fJM\u0010g\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020i2\u0006\u0010'\u001a\u00020(2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bj\u0010kJM\u0010g\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020i2\u0006\u00107\u001a\u0002082\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010mJq\u0010n\u001a\u00020\u001e2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070p2\u0006\u0010q\u001a\u00020r2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010tJq\u0010n\u001a\u00020\u001e2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070p2\u0006\u0010q\u001a\u00020r2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010Y\u001a\u00020\u000b2\b\b\u0002\u0010Z\u001a\u00020[2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bu\u0010vJY\u0010w\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bx\u0010dJY\u0010w\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\by\u0010fJc\u0010z\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010{\u001a\u00020|2\b\b\u0003\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b}\u0010~Jd\u0010z\u001a\u00020\u001e2\u0006\u00107\u001a\u0002082\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010{\u001a\u00020|2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0003\u0010.\u001a\u00020\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u000204H\u0096\u0001ø\u0001\u0000¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0013\u0010\u0081\u0001\u001a\u00020\u001e*\u00020\u00132\u0006\u0010\u001f\u001a\u00020 J\u001c\u0010\u0082\u0001\u001a\u00030\u0083\u0001*\u00030\u0084\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u001c\u0010\u0082\u0001\u001a\u00030\u0083\u0001*\u00030\u0087\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001c\u0010\u008a\u0001\u001a\u00030\u0084\u0001*\u00030\u0087\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u001e\u0010\u008a\u0001\u001a\u00030\u0084\u0001*\u00020\u000bH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001f\u0010\u008a\u0001\u001a\u00030\u0084\u0001*\u00030\u0083\u0001H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008f\u0001J\u001b\u0010\u0090\u0001\u001a\u00030\u0091\u0001*\u00020\u001bH\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u000b*\u00030\u0084\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u0095\u0001\u0010\u008e\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u000b*\u00030\u0087\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u0096\u0001\u0010\u008c\u0001J\u0010\u0010\u0097\u0001\u001a\u00030\u0098\u0001*\u00030\u0099\u0001H\u0097\u0001J\u001b\u0010\u009a\u0001\u001a\u00020\u001b*\u00030\u0091\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u009b\u0001\u0010\u0093\u0001J\u001c\u0010\u009c\u0001\u001a\u00030\u0087\u0001*\u00030\u0084\u0001H\u0097\u0001ø\u0001\u0000¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u001e\u0010\u009c\u0001\u001a\u00030\u0087\u0001*\u00020\u000bH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009f\u0001\u0010\u009e\u0001J\u001f\u0010\u009c\u0001\u001a\u00030\u0087\u0001*\u00030\u0083\u0001H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009f\u0001\u0010 \u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0012\u0010\u0016\u001a\u00020\u0017X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001c\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¡\u0001"}, m165d2 = {"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawNode", "Landroidx/compose/ui/node/DrawModifierNode;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/Modifier$Node;", "draw-x_KDEd0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/Modifier$Node;)V", "drawArc", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawContent", "drawDirect", "drawDirect-x_KDEd0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/node/DrawModifierNode;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "performDraw", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, m166k = 1, m167mv = {1, 8, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {
    public static final int $stable = 0;
    private final CanvasDrawScope canvasDrawScope;
    private DrawModifierNode drawNode;

    public LayoutNodeDrawScope() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawArc-illE91I */
    public void mo4399drawArcillE91I(Brush brush, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4399drawArcillE91I(brush, startAngle, sweepAngle, useCenter, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawArc-yD3GUKo */
    public void mo4400drawArcyD3GUKo(long color, float startAngle, float sweepAngle, boolean useCenter, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4400drawArcyD3GUKo(color, startAngle, sweepAngle, useCenter, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-V9BoPsw */
    public void mo4401drawCircleV9BoPsw(Brush brush, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4401drawCircleV9BoPsw(brush, radius, center, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-VaOC9Bg */
    public void mo4402drawCircleVaOC9Bg(long color, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4402drawCircleVaOC9Bg(color, radius, center, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE */
    public /* synthetic */ void mo4403drawImage9jGpkUE(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4403drawImage9jGpkUE(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-AZ2fEMs */
    public void mo4404drawImageAZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        this.canvasDrawScope.mo4404drawImageAZ2fEMs(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, filterQuality);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-gbVJVH8 */
    public void mo4405drawImagegbVJVH8(ImageBitmap image, long topLeft, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4405drawImagegbVJVH8(image, topLeft, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-1RTmtNc */
    public void mo4406drawLine1RTmtNc(Brush brush, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4406drawLine1RTmtNc(brush, start, end, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-NGM6Ib0 */
    public void mo4407drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4407drawLineNGM6Ib0(color, start, end, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawOval-AsUm42w */
    public void mo4408drawOvalAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4408drawOvalAsUm42w(brush, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawOval-n-J9OG0 */
    public void mo4409drawOvalnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4409drawOvalnJ9OG0(color, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-GBMwjPU */
    public void mo4410drawPathGBMwjPU(Path path, Brush brush, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4410drawPathGBMwjPU(path, brush, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-LG529CI */
    public void mo4411drawPathLG529CI(Path path, long color, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4411drawPathLG529CI(path, color, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawPoints-F8ZwMP8 */
    public void mo4412drawPointsF8ZwMP8(List<Offset> points, int pointMode, long color, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4412drawPointsF8ZwMP8(points, pointMode, color, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawPoints-Gsft0Ws */
    public void mo4413drawPointsGsft0Ws(List<Offset> points, int pointMode, Brush brush, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4413drawPointsGsft0Ws(points, pointMode, brush, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-AsUm42w */
    public void mo4414drawRectAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4414drawRectAsUm42w(brush, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-n-J9OG0 */
    public void mo4415drawRectnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4415drawRectnJ9OG0(color, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-ZuiqVtQ */
    public void mo4416drawRoundRectZuiqVtQ(Brush brush, long topLeft, long size, long cornerRadius, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4416drawRoundRectZuiqVtQ(brush, topLeft, size, cornerRadius, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-u-Aw5IA */
    public void mo4417drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo4417drawRoundRectuAw5IA(color, topLeft, size, cornerRadius, style, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: getCenter-F1C5BW0 */
    public long mo4497getCenterF1C5BW0() {
        return this.canvasDrawScope.mo4497getCenterF1C5BW0();
    }

    @Override // androidx.compose.p000ui.unit.Density
    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    @Override // androidx.compose.p000ui.unit.FontScaling
    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    @Override // androidx.compose.p000ui.graphics.drawscope.DrawScope
    /* renamed from: getSize-NH-jbRc */
    public long mo4498getSizeNHjbRc() {
        return this.canvasDrawScope.mo4498getSizeNHjbRc();
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: roundToPx--R2X_6o */
    public int mo511roundToPxR2X_6o(long j) {
        return this.canvasDrawScope.mo511roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public int mo512roundToPx0680j_4(float f) {
        return this.canvasDrawScope.mo512roundToPx0680j_4(f);
    }

    @Override // androidx.compose.p000ui.unit.FontScaling
    /* renamed from: toDp-GaN1DYA */
    public float mo513toDpGaN1DYA(long j) {
        return this.canvasDrawScope.mo513toDpGaN1DYA(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo514toDpu2uoSUM(float f) {
        return this.canvasDrawScope.mo514toDpu2uoSUM(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo515toDpu2uoSUM(int i) {
        return this.canvasDrawScope.mo515toDpu2uoSUM(i);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public long mo516toDpSizekrfVVM(long j) {
        return this.canvasDrawScope.mo516toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public float mo517toPxR2X_6o(long j) {
        return this.canvasDrawScope.mo517toPxR2X_6o(j);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public float mo518toPx0680j_4(float f) {
        return this.canvasDrawScope.mo518toPx0680j_4(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    public Rect toRect(DpRect dpRect) {
        return this.canvasDrawScope.toRect(dpRect);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public long mo519toSizeXkaWNTQ(long j) {
        return this.canvasDrawScope.mo519toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.p000ui.unit.FontScaling
    /* renamed from: toSp-0xMU5do */
    public long mo520toSp0xMU5do(float f) {
        return this.canvasDrawScope.mo520toSp0xMU5do(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo521toSpkPz2Gy4(float f) {
        return this.canvasDrawScope.mo521toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.p000ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo522toSpkPz2Gy4(int i) {
        return this.canvasDrawScope.mo522toSpkPz2Gy4(i);
    }

    public LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope) {
        this.canvasDrawScope = canvasDrawScope;
    }

    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    @Override // androidx.compose.p000ui.graphics.drawscope.ContentDrawScope
    public void drawContent() {
        NodeCoordinator wrapped;
        LayoutNodeDrawScope layoutNodeDrawScope;
        int i;
        LayoutNodeDrawScope layoutNodeDrawScope2;
        int i2;
        MutableVector mutableVector;
        LayoutNodeDrawScope layoutNodeDrawScope3 = this;
        LayoutNodeDrawScope layoutNodeDrawScope4 = layoutNodeDrawScope3;
        int i3 = 0;
        Canvas canvas = layoutNodeDrawScope4.getDrawContext().getCanvas();
        DrawModifierNode drawModifierNode = layoutNodeDrawScope3.drawNode;
        Intrinsics.checkNotNull(drawModifierNode);
        Modifier.Node nodeNextDrawNode = LayoutNodeDrawScopeKt.nextDrawNode(drawModifierNode);
        if (nodeNextDrawNode == null) {
            NodeCoordinator nodeCoordinatorM5322requireCoordinator64DMado = DelegatableNodeKt.m5322requireCoordinator64DMado(drawModifierNode, NodeKind.m5425constructorimpl(4));
            if (nodeCoordinatorM5322requireCoordinator64DMado.getTail() == drawModifierNode.getNode()) {
                wrapped = nodeCoordinatorM5322requireCoordinator64DMado.getWrapped();
                Intrinsics.checkNotNull(wrapped);
            } else {
                wrapped = nodeCoordinatorM5322requireCoordinator64DMado;
            }
            wrapped.performDraw(canvas);
            return;
        }
        int iM5425constructorimpl = NodeKind.m5425constructorimpl(4);
        MutableVector mutableVector2 = null;
        Modifier.Node nodePop = nodeNextDrawNode;
        while (nodePop != 0) {
            if (nodePop instanceof DrawModifierNode) {
                layoutNodeDrawScope3.performDraw(nodePop, canvas);
                layoutNodeDrawScope = layoutNodeDrawScope4;
                i = i3;
            } else {
                int i4 = 1;
                if (((nodePop.getKindSet() & iM5425constructorimpl) != 0 ? 1 : null) == null || !(nodePop instanceof DelegatingNode)) {
                    layoutNodeDrawScope = layoutNodeDrawScope4;
                    i = i3;
                } else {
                    int i5 = 0;
                    Modifier.Node delegate = nodePop.getDelegate();
                    nodePop = nodePop;
                    while (delegate != null) {
                        Modifier.Node node = delegate;
                        if (((node.getKindSet() & iM5425constructorimpl) != 0 ? i4 : 0) == 0) {
                            layoutNodeDrawScope2 = layoutNodeDrawScope4;
                            i2 = i3;
                        } else {
                            i5++;
                            if (i5 == i4) {
                                nodePop = node;
                                layoutNodeDrawScope2 = layoutNodeDrawScope4;
                                i2 = i3;
                            } else {
                                if (mutableVector2 != null) {
                                    layoutNodeDrawScope2 = layoutNodeDrawScope4;
                                    i2 = i3;
                                    mutableVector = mutableVector2;
                                } else {
                                    layoutNodeDrawScope2 = layoutNodeDrawScope4;
                                    i2 = i3;
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                mutableVector2 = mutableVector;
                                Object obj = nodePop;
                                nodePop = nodePop;
                                if (obj != null) {
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(obj);
                                    }
                                    nodePop = 0;
                                }
                                if (mutableVector2 != null) {
                                    mutableVector2.add(node);
                                }
                            }
                        }
                        delegate = delegate.getChild();
                        layoutNodeDrawScope4 = layoutNodeDrawScope2;
                        i3 = i2;
                        i4 = 1;
                        nodePop = nodePop;
                    }
                    layoutNodeDrawScope = layoutNodeDrawScope4;
                    i = i3;
                    if (i5 == 1) {
                        layoutNodeDrawScope3 = this;
                        layoutNodeDrawScope4 = layoutNodeDrawScope;
                        i3 = i;
                    }
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector2);
            layoutNodeDrawScope3 = this;
            layoutNodeDrawScope4 = layoutNodeDrawScope;
            i3 = i;
        }
    }

    public final void performDraw(DrawModifierNode $this$performDraw, Canvas canvas) {
        NodeCoordinator coordinator = DelegatableNodeKt.m5322requireCoordinator64DMado($this$performDraw, NodeKind.m5425constructorimpl(4));
        long size = IntSizeKt.m6477toSizeozmzZPI(coordinator.mo5226getSizeYbymL2g());
        LayoutNodeDrawScope drawScope = coordinator.getLayoutNode().getMDrawScope$ui_release();
        drawScope.m5359drawDirectx_KDEd0$ui_release(canvas, size, coordinator, $this$performDraw);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* renamed from: draw-x_KDEd0$ui_release, reason: not valid java name */
    public final void m5358drawx_KDEd0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, Modifier.Node drawNode) {
        int i;
        int i2;
        MutableVector mutableVector;
        int iM5425constructorimpl = NodeKind.m5425constructorimpl(4);
        MutableVector mutableVector2 = null;
        Modifier.Node nodePop = drawNode;
        while (nodePop != 0) {
            if (nodePop instanceof DrawModifierNode) {
                m5359drawDirectx_KDEd0$ui_release(canvas, size, coordinator, nodePop);
                i = iM5425constructorimpl;
            } else {
                int i3 = 1;
                if (((nodePop.getKindSet() & iM5425constructorimpl) != 0 ? 1 : null) == null || !(nodePop instanceof DelegatingNode)) {
                    i = iM5425constructorimpl;
                } else {
                    int i4 = 0;
                    Modifier.Node delegate = nodePop.getDelegate();
                    nodePop = nodePop;
                    while (delegate != null) {
                        Modifier.Node node = delegate;
                        if (((node.getKindSet() & iM5425constructorimpl) != 0 ? i3 : 0) == 0) {
                            i2 = iM5425constructorimpl;
                        } else {
                            i4++;
                            if (i4 == i3) {
                                nodePop = node;
                                i2 = iM5425constructorimpl;
                            } else {
                                if (mutableVector2 != null) {
                                    i2 = iM5425constructorimpl;
                                    mutableVector = mutableVector2;
                                } else {
                                    i2 = iM5425constructorimpl;
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                mutableVector2 = mutableVector;
                                Object obj = nodePop;
                                nodePop = nodePop;
                                if (obj != null) {
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(obj);
                                    }
                                    nodePop = 0;
                                }
                                if (mutableVector2 != null) {
                                    mutableVector2.add(node);
                                }
                            }
                        }
                        delegate = delegate.getChild();
                        iM5425constructorimpl = i2;
                        i3 = 1;
                        nodePop = nodePop;
                    }
                    i = iM5425constructorimpl;
                    if (i4 == 1) {
                        iM5425constructorimpl = i;
                    }
                }
            }
            nodePop = DelegatableNodeKt.pop(mutableVector2);
            iM5425constructorimpl = i;
        }
    }

    /* renamed from: drawDirect-x_KDEd0$ui_release, reason: not valid java name */
    public final void m5359drawDirectx_KDEd0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, DrawModifierNode drawNode) {
        DrawModifierNode previousDrawNode = this.drawNode;
        this.drawNode = drawNode;
        CanvasDrawScope this_$iv = this.canvasDrawScope;
        LayoutDirection layoutDirection$iv = coordinator.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = this_$iv.getDrawParams();
        Density prevDensity$iv = drawParams.getDensity();
        LayoutDirection prevLayoutDirection$iv = drawParams.getLayoutDirection();
        Canvas prevCanvas$iv = drawParams.getCanvas();
        long prevSize$iv = drawParams.getSize();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u240$iv = this_$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u240$iv.setDensity(coordinator);
        $this$draw_yzxVdVo_u24lambda_u240$iv.setLayoutDirection(layoutDirection$iv);
        $this$draw_yzxVdVo_u24lambda_u240$iv.setCanvas(canvas);
        $this$draw_yzxVdVo_u24lambda_u240$iv.m4422setSizeuvyYCjk(size);
        canvas.save();
        drawNode.draw(this);
        canvas.restore();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u241$iv = this_$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u241$iv.setDensity(prevDensity$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.setLayoutDirection(prevLayoutDirection$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.setCanvas(prevCanvas$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.m4422setSizeuvyYCjk(prevSize$iv);
        this.drawNode = previousDrawNode;
    }
}
