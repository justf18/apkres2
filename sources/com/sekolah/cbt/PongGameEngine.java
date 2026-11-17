package com.sekolah.cbt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* compiled from: PongGameEngine.kt */
@Metadata(m164d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b$*\u0001(\b\u0007\u0018\u00002\u00020\u0001:\u000e\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ;\u0010_\u001a\u00020;2\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\f2\u0006\u0010b\u001a\u00020\f2\u0006\u0010c\u001a\u00020\u00072\f\u0010d\u001a\b\u0012\u0004\u0012\u00020f0eH\u0002¢\u0006\u0002\u0010gJ\u0010\u0010h\u001a\u00020;2\u0006\u0010i\u001a\u00020jH\u0002J(\u0010k\u001a\u00020;2\u0006\u0010l\u001a\u00020\f2\u0006\u0010b\u001a\u00020\f2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u000202H\u0002J\b\u0010o\u001a\u00020\fH\u0002J\b\u0010p\u001a\u00020\fH\u0002J\u0010\u0010q\u001a\u00020;2\u0006\u0010r\u001a\u00020sH\u0002J\u0018\u0010t\u001a\u00020;2\u0006\u0010r\u001a\u00020s2\u0006\u0010u\u001a\u00020TH\u0002J\u0018\u0010v\u001a\u00020;2\u0006\u0010r\u001a\u00020s2\u0006\u0010w\u001a\u00020\u0018H\u0002J\b\u0010x\u001a\u00020\fH\u0002J\b\u0010y\u001a\u00020;H\u0002J\u0010\u0010z\u001a\u00020\u00072\u0006\u0010{\u001a\u00020\u0007H\u0002J\b\u0010|\u001a\u00020;H\u0014J\u0010\u0010}\u001a\u00020;2\u0006\u0010r\u001a\u00020sH\u0014J+\u0010~\u001a\u00020;2\u0006\u0010\u007f\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u00072\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u0083\u0001\u001a\u00020;H\u0002J\"\u0010\u0084\u0001\u001a\u00020;2\u0006\u0010l\u001a\u00020\f2\u0006\u0010b\u001a\u00020\f2\u0007\u0010\u0085\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0086\u0001\u001a\u00020;H\u0002J\t\u0010\u0087\u0001\u001a\u00020;H\u0002J\u0011\u0010\u0088\u0001\u001a\u00020;2\u0006\u0010b\u001a\u00020\fH\u0002J\t\u0010\u0089\u0001\u001a\u00020\fH\u0002J\u0019\u0010\u008a\u0001\u001a\u00020;2\u0006\u0010l\u001a\u00020\f2\u0006\u0010b\u001a\u00020\fH\u0002J\u0007\u0010\u008b\u0001\u001a\u00020;J\u0007\u0010\u008c\u0001\u001a\u00020;J\u0010\u0010\u008d\u0001\u001a\u00020;2\u0007\u0010\u008e\u0001\u001a\u00020\fJ\t\u0010\u008f\u0001\u001a\u00020;H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00109\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?RL\u0010@\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020;\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\b\u0012\u0004\u0012\u00020P0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0097\u0001"}, m165d2 = {"Lcom/sekolah/cbt/PongGameEngine;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ballPaint", "Landroid/graphics/Paint;", "ballRadius", "", "balls", "", "Lcom/sekolah/cbt/PongGameEngine$Ball;", "baseSpeed", "bgColor", "brickColors", "", "brickH", "brickPadding", "brickPaint", "bricks", "Lcom/sekolah/cbt/PongGameEngine$Brick;", "buffBarBgPaint", "buffBarFgPaint", "buffLabelBitmap", "Landroid/graphics/Bitmap;", "comboCount", "comboTimer", "dangerColor", "extraShieldCount", "fireBallPaint", "fireBallTimer", "floaters", "Lcom/sekolah/cbt/PongGameEngine$Floater;", "frameRate", "", "gameLoop", "com/sekolah/cbt/PongGameEngine$gameLoop$1", "Lcom/sekolah/cbt/PongGameEngine$gameLoop$1;", "handler", "Landroid/os/Handler;", "hudBarH", "hudBarW", "hudLineH", "hudPaint", "hudX", "isFireBall", "", "isRunning", "isShieldActive", "level", "linePaint", "magnetReleaseDelay", "magnetTimer", "onGameOver", "Lkotlin/Function0;", "", "getOnGameOver", "()Lkotlin/jvm/functions/Function0;", "setOnGameOver", "(Lkotlin/jvm/functions/Function0;)V", "onScoreUpdated", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "score", "getOnScoreUpdated", "()Lkotlin/jvm/functions/Function2;", "setOnScoreUpdated", "(Lkotlin/jvm/functions/Function2;)V", "paddleHeight", "paddlePaint", "paddleWidth", "paddleX", "paddleY", "particlePaint", "particles", "Lcom/sekolah/cbt/PongGameEngine$Particle;", "path", "Landroid/graphics/Path;", "powerUps", "Lcom/sekolah/cbt/PongGameEngine$PowerUp;", "rowGap", "rowsSpawned", "screenHeight", "screenWidth", "shieldPaint", "slowTimer", "spawnProgress", "stuckBallPaint", "textPaint", "widePaddleTimer", "addBrick", "col", "brickW", "y", "maxHp", "shapes", "", "Lcom/sekolah/cbt/PongGameEngine$BrickShape;", "(IFFI[Lcom/sekolah/cbt/PongGameEngine$BrickShape;)V", "applyPowerUp", "type", "Lcom/sekolah/cbt/PongGameEngine$PowerType;", "createExplosion", "x", TypedValues.Custom.S_COLOR, "big", "currentDefaultWidth", "currentSpeed", "drawBuffHud", "canvas", "Landroid/graphics/Canvas;", "drawPowerUp", "p", "drawVariedBrick", "b", "fallSpeed", "gameOver", "lighten", "c", "onDetachedFromWindow", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "rebuildBuffLabelCache", "registerHit", "basePoints", "releaseAllStuckBalls", "resetBallPosition", "spawnBrickRow", "spawnInterval", "spawnPowerUp", "startGame", "stopGame", "updatePaddleTouch", "touchX", "updatePhysics", "Ball", "Brick", "BrickShape", "Floater", "Particle", "PowerType", "PowerUp", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class PongGameEngine extends View {
    public static final int $stable = 8;
    private final Paint ballPaint;
    private final float ballRadius;
    private final List<Ball> balls;
    private final float baseSpeed;
    private final int bgColor;
    private final int[] brickColors;
    private final float brickH;
    private final float brickPadding;
    private final Paint brickPaint;
    private final List<Brick> bricks;
    private final Paint buffBarBgPaint;
    private final Paint buffBarFgPaint;
    private Bitmap buffLabelBitmap;
    private int comboCount;
    private int comboTimer;
    private final int dangerColor;
    private int extraShieldCount;
    private final Paint fireBallPaint;
    private int fireBallTimer;
    private final List<Floater> floaters;
    private final long frameRate;
    private final PongGameEngine$gameLoop$1 gameLoop;
    private final Handler handler;
    private final float hudBarH;
    private final float hudBarW;
    private final float hudLineH;
    private final Paint hudPaint;
    private final float hudX;
    private boolean isFireBall;
    private boolean isRunning;
    private boolean isShieldActive;
    private int level;
    private final Paint linePaint;
    private int magnetReleaseDelay;
    private int magnetTimer;
    private Function0<Unit> onGameOver;
    private Function2<? super Integer, ? super Integer, Unit> onScoreUpdated;
    private final float paddleHeight;
    private final Paint paddlePaint;
    private float paddleWidth;
    private float paddleX;
    private float paddleY;
    private final Paint particlePaint;
    private final List<Particle> particles;
    private final Path path;
    private final List<PowerUp> powerUps;
    private final float rowGap;
    private int rowsSpawned;
    private int score;
    private float screenHeight;
    private float screenWidth;
    private final Paint shieldPaint;
    private int slowTimer;
    private float spawnProgress;
    private final Paint stuckBallPaint;
    private final Paint textPaint;
    private int widePaddleTimer;

    /* compiled from: PongGameEngine.kt */
    @Metadata(m164d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m165d2 = {"Lcom/sekolah/cbt/PongGameEngine$BrickShape;", "", "(Ljava/lang/String;I)V", "SQUARE", "TRIANGLE_LEFT", "TRIANGLE_RIGHT", "CIRCLE", "DIAMOND", "HEXAGON", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum BrickShape {
        SQUARE,
        TRIANGLE_LEFT,
        TRIANGLE_RIGHT,
        CIRCLE,
        DIAMOND,
        HEXAGON;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<BrickShape> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: PongGameEngine.kt */
    @Metadata(m164d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m165d2 = {"Lcom/sekolah/cbt/PongGameEngine$PowerType;", "", "(Ljava/lang/String;I)V", "WIDE_PADDLE", "SLOW_BALL", "BOMB", "SHIELD", "FIRE_BALL", "MULTI_BALL", "MAGNET", "EXTRA_SHIELD", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum PowerType {
        WIDE_PADDLE,
        SLOW_BALL,
        BOMB,
        SHIELD,
        FIRE_BALL,
        MULTI_BALL,
        MAGNET,
        EXTRA_SHIELD;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<PowerType> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: PongGameEngine.kt */
    @Metadata(m166k = 3, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PowerType.values().length];
            try {
                iArr[PowerType.WIDE_PADDLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PowerType.SLOW_BALL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PowerType.BOMB.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PowerType.SHIELD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PowerType.EXTRA_SHIELD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[PowerType.FIRE_BALL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[PowerType.MULTI_BALL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[PowerType.MAGNET.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BrickShape.values().length];
            try {
                iArr2[BrickShape.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr2[BrickShape.TRIANGLE_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr2[BrickShape.TRIANGLE_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr2[BrickShape.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr2[BrickShape.DIAMOND.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr2[BrickShape.HEXAGON.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PongGameEngine(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PongGameEngine(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PongGameEngine(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v19, types: [com.sekolah.cbt.PongGameEngine$gameLoop$1] */
    public PongGameEngine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.handler = new Handler(Looper.getMainLooper());
        this.frameRate = 16L;
        this.paddleWidth = 200.0f;
        this.paddleHeight = 35.0f;
        this.balls = new ArrayList();
        this.ballRadius = 18.0f;
        this.baseSpeed = 14.0f;
        this.brickH = 50.0f;
        this.brickPadding = 12.0f;
        this.rowGap = this.brickH + this.brickPadding;
        this.level = 1;
        this.bricks = new ArrayList();
        this.powerUps = new ArrayList();
        this.particles = new ArrayList();
        this.floaters = new ArrayList();
        this.bgColor = Color.parseColor("#0F172A");
        this.dangerColor = Color.parseColor("#EF4444");
        this.brickColors = new int[]{Color.parseColor("#EF4444"), Color.parseColor("#F97316"), Color.parseColor("#10B981"), Color.parseColor("#06B6D4"), Color.parseColor("#8B5CF6")};
        this.path = new Path();
        Paint $this$paddlePaint_u24lambda_u240 = new Paint(1);
        $this$paddlePaint_u24lambda_u240.setColor(Color.parseColor("#38BDF8"));
        this.paddlePaint = $this$paddlePaint_u24lambda_u240;
        Paint $this$ballPaint_u24lambda_u241 = new Paint(1);
        $this$ballPaint_u24lambda_u241.setColor(Color.parseColor("#FACC15"));
        this.ballPaint = $this$ballPaint_u24lambda_u241;
        Paint $this$fireBallPaint_u24lambda_u242 = new Paint(1);
        $this$fireBallPaint_u24lambda_u242.setColor(Color.parseColor("#EF4444"));
        this.fireBallPaint = $this$fireBallPaint_u24lambda_u242;
        Paint $this$stuckBallPaint_u24lambda_u243 = new Paint(1);
        $this$stuckBallPaint_u24lambda_u243.setColor(Color.parseColor("#F472B6"));
        this.stuckBallPaint = $this$stuckBallPaint_u24lambda_u243;
        Paint $this$shieldPaint_u24lambda_u244 = new Paint(1);
        $this$shieldPaint_u24lambda_u244.setColor(Color.parseColor("#10B981"));
        this.shieldPaint = $this$shieldPaint_u24lambda_u244;
        this.brickPaint = new Paint(1);
        this.particlePaint = new Paint(1);
        Paint $this$linePaint_u24lambda_u245 = new Paint(1);
        $this$linePaint_u24lambda_u245.setColor(this.dangerColor);
        $this$linePaint_u24lambda_u245.setAlpha(90);
        $this$linePaint_u24lambda_u245.setStrokeWidth(3.0f);
        this.linePaint = $this$linePaint_u24lambda_u245;
        Paint $this$textPaint_u24lambda_u246 = new Paint(1);
        $this$textPaint_u24lambda_u246.setColor(-1);
        $this$textPaint_u24lambda_u246.setTextSize(40.0f);
        $this$textPaint_u24lambda_u246.setTextAlign(Paint.Align.CENTER);
        this.textPaint = $this$textPaint_u24lambda_u246;
        Paint $this$hudPaint_u24lambda_u247 = new Paint(1);
        $this$hudPaint_u24lambda_u247.setColor(-1);
        $this$hudPaint_u24lambda_u247.setTextSize(26.0f);
        $this$hudPaint_u24lambda_u247.setTextAlign(Paint.Align.LEFT);
        this.hudPaint = $this$hudPaint_u24lambda_u247;
        Paint $this$buffBarBgPaint_u24lambda_u248 = new Paint(1);
        $this$buffBarBgPaint_u24lambda_u248.setColor(Color.parseColor("#334155"));
        this.buffBarBgPaint = $this$buffBarBgPaint_u24lambda_u248;
        Paint $this$buffBarFgPaint_u24lambda_u249 = new Paint(1);
        $this$buffBarFgPaint_u24lambda_u249.setColor(Color.parseColor("#22D3EE"));
        this.buffBarFgPaint = $this$buffBarFgPaint_u24lambda_u249;
        this.hudX = 24.0f;
        this.hudBarW = 100.0f;
        this.hudBarH = 8.0f;
        this.hudLineH = 34.0f;
        this.gameLoop = new Runnable() { // from class: com.sekolah.cbt.PongGameEngine$gameLoop$1
            @Override // java.lang.Runnable
            public void run() {
                if (this.this$0.isRunning) {
                    this.this$0.updatePhysics();
                    this.this$0.invalidate();
                    if (this.this$0.isRunning) {
                        this.this$0.handler.postDelayed(this, this.this$0.frameRate);
                    }
                }
            }
        };
    }

    public final Function2<Integer, Integer, Unit> getOnScoreUpdated() {
        return this.onScoreUpdated;
    }

    public final void setOnScoreUpdated(Function2<? super Integer, ? super Integer, Unit> function2) {
        this.onScoreUpdated = function2;
    }

    public final Function0<Unit> getOnGameOver() {
        return this.onGameOver;
    }

    public final void setOnGameOver(Function0<Unit> function0) {
        this.onGameOver = function0;
    }

    /* compiled from: PongGameEngine.kt */
    @Metadata(m164d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006$"}, m165d2 = {"Lcom/sekolah/cbt/PongGameEngine$Ball;", "", "x", "", "y", "vx", "vy", "stuck", "", "(FFFFZ)V", "getStuck", "()Z", "setStuck", "(Z)V", "getVx", "()F", "setVx", "(F)V", "getVy", "setVy", "getX", "setX", "getY", "setY", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final /* data */ class Ball {
        private boolean stuck;
        private float vx;
        private float vy;
        private float x;
        private float y;

        public static /* synthetic */ Ball copy$default(Ball ball, float f, float f2, float f3, float f4, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                f = ball.x;
            }
            if ((i & 2) != 0) {
                f2 = ball.y;
            }
            if ((i & 4) != 0) {
                f3 = ball.vx;
            }
            if ((i & 8) != 0) {
                f4 = ball.vy;
            }
            if ((i & 16) != 0) {
                z = ball.stuck;
            }
            boolean z2 = z;
            float f5 = f3;
            return ball.copy(f, f2, f5, f4, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* renamed from: component2, reason: from getter */
        public final float getY() {
            return this.y;
        }

        /* renamed from: component3, reason: from getter */
        public final float getVx() {
            return this.vx;
        }

        /* renamed from: component4, reason: from getter */
        public final float getVy() {
            return this.vy;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getStuck() {
            return this.stuck;
        }

        public final Ball copy(float x, float y, float vx, float vy, boolean stuck) {
            return new Ball(x, y, vx, vy, stuck);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ball)) {
                return false;
            }
            Ball ball = (Ball) other;
            return Float.compare(this.x, ball.x) == 0 && Float.compare(this.y, ball.y) == 0 && Float.compare(this.vx, ball.vx) == 0 && Float.compare(this.vy, ball.vy) == 0 && this.stuck == ball.stuck;
        }

        public int hashCode() {
            return (((((((Float.hashCode(this.x) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.vx)) * 31) + Float.hashCode(this.vy)) * 31) + Boolean.hashCode(this.stuck);
        }

        public String toString() {
            return "Ball(x=" + this.x + ", y=" + this.y + ", vx=" + this.vx + ", vy=" + this.vy + ", stuck=" + this.stuck + ")";
        }

        public Ball(float x, float y, float vx, float vy, boolean stuck) {
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
            this.stuck = stuck;
        }

        public /* synthetic */ Ball(float f, float f2, float f3, float f4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, f3, f4, (i & 16) != 0 ? false : z);
        }

        public final boolean getStuck() {
            return this.stuck;
        }

        public final float getVx() {
            return this.vx;
        }

        public final float getVy() {
            return this.vy;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public final void setStuck(boolean z) {
            this.stuck = z;
        }

        public final void setVx(float f) {
            this.vx = f;
        }

        public final void setVy(float f) {
            this.vy = f;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final void setY(float f) {
            this.y = f;
        }
    }

    /* compiled from: PongGameEngine.kt */
    @Metadata(m164d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003JY\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u001b¨\u0006-"}, m165d2 = {"Lcom/sekolah/cbt/PongGameEngine$Brick;", "", "x", "", "y", "width", "height", "hp", "", "maxHp", TypedValues.Custom.S_COLOR, "shape", "Lcom/sekolah/cbt/PongGameEngine$BrickShape;", "(FFFFIIILcom/sekolah/cbt/PongGameEngine$BrickShape;)V", "getColor", "()I", "getHeight", "()F", "getHp", "setHp", "(I)V", "getMaxHp", "getShape", "()Lcom/sekolah/cbt/PongGameEngine$BrickShape;", "getWidth", "getX", "setX", "(F)V", "getY", "setY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Brick {
        public static final int $stable = 8;
        private final int color;
        private final float height;
        private int hp;
        private final int maxHp;
        private final BrickShape shape;
        private final float width;
        private float x;
        private float y;

        public static /* synthetic */ Brick copy$default(Brick brick, float f, float f2, float f3, float f4, int i, int i2, int i3, BrickShape brickShape, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                f = brick.x;
            }
            if ((i4 & 2) != 0) {
                f2 = brick.y;
            }
            if ((i4 & 4) != 0) {
                f3 = brick.width;
            }
            if ((i4 & 8) != 0) {
                f4 = brick.height;
            }
            if ((i4 & 16) != 0) {
                i = brick.hp;
            }
            if ((i4 & 32) != 0) {
                i2 = brick.maxHp;
            }
            if ((i4 & 64) != 0) {
                i3 = brick.color;
            }
            if ((i4 & 128) != 0) {
                brickShape = brick.shape;
            }
            int i5 = i3;
            BrickShape brickShape2 = brickShape;
            int i6 = i;
            int i7 = i2;
            return brick.copy(f, f2, f3, f4, i6, i7, i5, brickShape2);
        }

        /* renamed from: component1, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* renamed from: component2, reason: from getter */
        public final float getY() {
            return this.y;
        }

        /* renamed from: component3, reason: from getter */
        public final float getWidth() {
            return this.width;
        }

        /* renamed from: component4, reason: from getter */
        public final float getHeight() {
            return this.height;
        }

        /* renamed from: component5, reason: from getter */
        public final int getHp() {
            return this.hp;
        }

        /* renamed from: component6, reason: from getter */
        public final int getMaxHp() {
            return this.maxHp;
        }

        /* renamed from: component7, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        /* renamed from: component8, reason: from getter */
        public final BrickShape getShape() {
            return this.shape;
        }

        public final Brick copy(float x, float y, float width, float height, int hp, int maxHp, int color, BrickShape shape) {
            Intrinsics.checkNotNullParameter(shape, "shape");
            return new Brick(x, y, width, height, hp, maxHp, color, shape);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Brick)) {
                return false;
            }
            Brick brick = (Brick) other;
            return Float.compare(this.x, brick.x) == 0 && Float.compare(this.y, brick.y) == 0 && Float.compare(this.width, brick.width) == 0 && Float.compare(this.height, brick.height) == 0 && this.hp == brick.hp && this.maxHp == brick.maxHp && this.color == brick.color && this.shape == brick.shape;
        }

        public int hashCode() {
            return (((((((((((((Float.hashCode(this.x) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.width)) * 31) + Float.hashCode(this.height)) * 31) + Integer.hashCode(this.hp)) * 31) + Integer.hashCode(this.maxHp)) * 31) + Integer.hashCode(this.color)) * 31) + this.shape.hashCode();
        }

        public String toString() {
            return "Brick(x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", hp=" + this.hp + ", maxHp=" + this.maxHp + ", color=" + this.color + ", shape=" + this.shape + ")";
        }

        public Brick(float x, float y, float width, float height, int hp, int maxHp, int color, BrickShape shape) {
            Intrinsics.checkNotNullParameter(shape, "shape");
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.hp = hp;
            this.maxHp = maxHp;
            this.color = color;
            this.shape = shape;
        }

        public final float getX() {
            return this.x;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final float getY() {
            return this.y;
        }

        public final void setY(float f) {
            this.y = f;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float getHeight() {
            return this.height;
        }

        public final int getHp() {
            return this.hp;
        }

        public final void setHp(int i) {
            this.hp = i;
        }

        public final int getMaxHp() {
            return this.maxHp;
        }

        public final int getColor() {
            return this.color;
        }

        public final BrickShape getShape() {
            return this.shape;
        }
    }

    /* compiled from: PongGameEngine.kt */
    @Metadata(m164d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\u0011¨\u0006!"}, m165d2 = {"Lcom/sekolah/cbt/PongGameEngine$PowerUp;", "", "x", "", "y", "type", "Lcom/sekolah/cbt/PongGameEngine$PowerType;", "radius", "speedY", "(FFLcom/sekolah/cbt/PongGameEngine$PowerType;FF)V", "getRadius", "()F", "getSpeedY", "getType", "()Lcom/sekolah/cbt/PongGameEngine$PowerType;", "getX", "setX", "(F)V", "getY", "setY", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class PowerUp {
        public static final int $stable = 8;
        private final float radius;
        private final float speedY;
        private final PowerType type;
        private float x;
        private float y;

        public static /* synthetic */ PowerUp copy$default(PowerUp powerUp, float f, float f2, PowerType powerType, float f3, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = powerUp.x;
            }
            if ((i & 2) != 0) {
                f2 = powerUp.y;
            }
            if ((i & 4) != 0) {
                powerType = powerUp.type;
            }
            if ((i & 8) != 0) {
                f3 = powerUp.radius;
            }
            if ((i & 16) != 0) {
                f4 = powerUp.speedY;
            }
            float f5 = f4;
            PowerType powerType2 = powerType;
            return powerUp.copy(f, f2, powerType2, f3, f5);
        }

        /* renamed from: component1, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* renamed from: component2, reason: from getter */
        public final float getY() {
            return this.y;
        }

        /* renamed from: component3, reason: from getter */
        public final PowerType getType() {
            return this.type;
        }

        /* renamed from: component4, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        /* renamed from: component5, reason: from getter */
        public final float getSpeedY() {
            return this.speedY;
        }

        public final PowerUp copy(float x, float y, PowerType type, float radius, float speedY) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new PowerUp(x, y, type, radius, speedY);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PowerUp)) {
                return false;
            }
            PowerUp powerUp = (PowerUp) other;
            return Float.compare(this.x, powerUp.x) == 0 && Float.compare(this.y, powerUp.y) == 0 && this.type == powerUp.type && Float.compare(this.radius, powerUp.radius) == 0 && Float.compare(this.speedY, powerUp.speedY) == 0;
        }

        public int hashCode() {
            return (((((((Float.hashCode(this.x) * 31) + Float.hashCode(this.y)) * 31) + this.type.hashCode()) * 31) + Float.hashCode(this.radius)) * 31) + Float.hashCode(this.speedY);
        }

        public String toString() {
            return "PowerUp(x=" + this.x + ", y=" + this.y + ", type=" + this.type + ", radius=" + this.radius + ", speedY=" + this.speedY + ")";
        }

        public PowerUp(float x, float y, PowerType type, float radius, float speedY) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.x = x;
            this.y = y;
            this.type = type;
            this.radius = radius;
            this.speedY = speedY;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ PowerUp(float f, float f2, PowerType powerType, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            float f5;
            float f6;
            if ((i & 8) == 0) {
                f5 = f3;
            } else {
                f5 = 22.0f;
            }
            if ((i & 16) == 0) {
                f6 = f4;
            } else {
                f6 = 5.0f;
            }
            this(f, f2, powerType, f5, f6);
        }

        public final float getX() {
            return this.x;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final float getY() {
            return this.y;
        }

        public final void setY(float f) {
            this.y = f;
        }

        public final PowerType getType() {
            return this.type;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final float getSpeedY() {
            return this.speedY;
        }
    }

    /* compiled from: PongGameEngine.kt */
    @Metadata(m164d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003Jm\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010/\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\bHÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u001d¨\u00064"}, m165d2 = {"Lcom/sekolah/cbt/PongGameEngine$Particle;", "", "x", "", "y", "vx", "vy", "alpha", "", TypedValues.Custom.S_COLOR, "size", "decay", "gravity", "square", "", "(FFFFIIFIFZ)V", "getAlpha", "()I", "setAlpha", "(I)V", "getColor", "getDecay", "getGravity", "()F", "getSize", "getSquare", "()Z", "getVx", "setVx", "(F)V", "getVy", "setVy", "getX", "setX", "getY", "setY", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Particle {
        public static final int $stable = 8;
        private int alpha;
        private final int color;
        private final int decay;
        private final float gravity;
        private final float size;
        private final boolean square;
        private float vx;
        private float vy;
        private float x;
        private float y;

        public static /* synthetic */ Particle copy$default(Particle particle, float f, float f2, float f3, float f4, int i, int i2, float f5, int i3, float f6, boolean z, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                f = particle.x;
            }
            if ((i4 & 2) != 0) {
                f2 = particle.y;
            }
            if ((i4 & 4) != 0) {
                f3 = particle.vx;
            }
            if ((i4 & 8) != 0) {
                f4 = particle.vy;
            }
            if ((i4 & 16) != 0) {
                i = particle.alpha;
            }
            if ((i4 & 32) != 0) {
                i2 = particle.color;
            }
            if ((i4 & 64) != 0) {
                f5 = particle.size;
            }
            if ((i4 & 128) != 0) {
                i3 = particle.decay;
            }
            if ((i4 & 256) != 0) {
                f6 = particle.gravity;
            }
            if ((i4 & 512) != 0) {
                z = particle.square;
            }
            float f7 = f6;
            boolean z2 = z;
            float f8 = f5;
            int i5 = i3;
            int i6 = i;
            int i7 = i2;
            return particle.copy(f, f2, f3, f4, i6, i7, f8, i5, f7, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getSquare() {
            return this.square;
        }

        /* renamed from: component2, reason: from getter */
        public final float getY() {
            return this.y;
        }

        /* renamed from: component3, reason: from getter */
        public final float getVx() {
            return this.vx;
        }

        /* renamed from: component4, reason: from getter */
        public final float getVy() {
            return this.vy;
        }

        /* renamed from: component5, reason: from getter */
        public final int getAlpha() {
            return this.alpha;
        }

        /* renamed from: component6, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        /* renamed from: component7, reason: from getter */
        public final float getSize() {
            return this.size;
        }

        /* renamed from: component8, reason: from getter */
        public final int getDecay() {
            return this.decay;
        }

        /* renamed from: component9, reason: from getter */
        public final float getGravity() {
            return this.gravity;
        }

        public final Particle copy(float x, float y, float vx, float vy, int alpha, int color, float size, int decay, float gravity, boolean square) {
            return new Particle(x, y, vx, vy, alpha, color, size, decay, gravity, square);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Particle)) {
                return false;
            }
            Particle particle = (Particle) other;
            return Float.compare(this.x, particle.x) == 0 && Float.compare(this.y, particle.y) == 0 && Float.compare(this.vx, particle.vx) == 0 && Float.compare(this.vy, particle.vy) == 0 && this.alpha == particle.alpha && this.color == particle.color && Float.compare(this.size, particle.size) == 0 && this.decay == particle.decay && Float.compare(this.gravity, particle.gravity) == 0 && this.square == particle.square;
        }

        public int hashCode() {
            return (((((((((((((((((Float.hashCode(this.x) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.vx)) * 31) + Float.hashCode(this.vy)) * 31) + Integer.hashCode(this.alpha)) * 31) + Integer.hashCode(this.color)) * 31) + Float.hashCode(this.size)) * 31) + Integer.hashCode(this.decay)) * 31) + Float.hashCode(this.gravity)) * 31) + Boolean.hashCode(this.square);
        }

        public String toString() {
            return "Particle(x=" + this.x + ", y=" + this.y + ", vx=" + this.vx + ", vy=" + this.vy + ", alpha=" + this.alpha + ", color=" + this.color + ", size=" + this.size + ", decay=" + this.decay + ", gravity=" + this.gravity + ", square=" + this.square + ")";
        }

        public Particle(float x, float y, float vx, float vy, int alpha, int color, float size, int decay, float gravity, boolean square) {
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
            this.alpha = alpha;
            this.color = color;
            this.size = size;
            this.decay = decay;
            this.gravity = gravity;
            this.square = square;
        }

        public final float getX() {
            return this.x;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final float getY() {
            return this.y;
        }

        public final void setY(float f) {
            this.y = f;
        }

        public final float getVx() {
            return this.vx;
        }

        public final void setVx(float f) {
            this.vx = f;
        }

        public final float getVy() {
            return this.vy;
        }

        public final void setVy(float f) {
            this.vy = f;
        }

        public final int getAlpha() {
            return this.alpha;
        }

        public final void setAlpha(int i) {
            this.alpha = i;
        }

        public final int getColor() {
            return this.color;
        }

        public final float getSize() {
            return this.size;
        }

        public final int getDecay() {
            return this.decay;
        }

        public final float getGravity() {
            return this.gravity;
        }

        public final boolean getSquare() {
            return this.square;
        }
    }

    /* compiled from: PongGameEngine.kt */
    @Metadata(m164d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006#"}, m165d2 = {"Lcom/sekolah/cbt/PongGameEngine$Floater;", "", "x", "", "y", "alpha", "", "text", "", TypedValues.Custom.S_COLOR, "(FFILjava/lang/String;I)V", "getAlpha", "()I", "setAlpha", "(I)V", "getColor", "getText", "()Ljava/lang/String;", "getX", "()F", "setX", "(F)V", "getY", "setY", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Floater {
        public static final int $stable = 8;
        private int alpha;
        private final int color;
        private final String text;
        private float x;
        private float y;

        public static /* synthetic */ Floater copy$default(Floater floater, float f, float f2, int i, String str, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                f = floater.x;
            }
            if ((i3 & 2) != 0) {
                f2 = floater.y;
            }
            if ((i3 & 4) != 0) {
                i = floater.alpha;
            }
            if ((i3 & 8) != 0) {
                str = floater.text;
            }
            if ((i3 & 16) != 0) {
                i2 = floater.color;
            }
            int i4 = i2;
            int i5 = i;
            return floater.copy(f, f2, i5, str, i4);
        }

        /* renamed from: component1, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* renamed from: component2, reason: from getter */
        public final float getY() {
            return this.y;
        }

        /* renamed from: component3, reason: from getter */
        public final int getAlpha() {
            return this.alpha;
        }

        /* renamed from: component4, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component5, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        public final Floater copy(float x, float y, int alpha, String text, int color) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new Floater(x, y, alpha, text, color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Floater)) {
                return false;
            }
            Floater floater = (Floater) other;
            return Float.compare(this.x, floater.x) == 0 && Float.compare(this.y, floater.y) == 0 && this.alpha == floater.alpha && Intrinsics.areEqual(this.text, floater.text) && this.color == floater.color;
        }

        public int hashCode() {
            return (((((((Float.hashCode(this.x) * 31) + Float.hashCode(this.y)) * 31) + Integer.hashCode(this.alpha)) * 31) + this.text.hashCode()) * 31) + Integer.hashCode(this.color);
        }

        public String toString() {
            return "Floater(x=" + this.x + ", y=" + this.y + ", alpha=" + this.alpha + ", text=" + this.text + ", color=" + this.color + ")";
        }

        public Floater(float x, float y, int alpha, String text, int color) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.x = x;
            this.y = y;
            this.alpha = alpha;
            this.text = text;
            this.color = color;
        }

        public final float getX() {
            return this.x;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final float getY() {
            return this.y;
        }

        public final void setY(float f) {
            this.y = f;
        }

        public final int getAlpha() {
            return this.alpha;
        }

        public final void setAlpha(int i) {
            this.alpha = i;
        }

        public final String getText() {
            return this.text;
        }

        public final int getColor() {
            return this.color;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.screenWidth = w;
        this.screenHeight = h;
        this.paddleX = (this.screenWidth - this.paddleWidth) / 2.0f;
        this.paddleY = this.screenHeight - 120.0f;
        resetBallPosition();
        rebuildBuffLabelCache();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        stopGame();
        Bitmap bitmap = this.buffLabelBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.buffLabelBitmap = null;
        super.onDetachedFromWindow();
    }

    private final void rebuildBuffLabelCache() {
        Bitmap bitmap = this.buffLabelBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        Bitmap bmp = Bitmap.createBitmap(200, 220, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bmp, "createBitmap(...)");
        Canvas c = new Canvas(bmp);
        Paint labelPaint = new Paint(1);
        float f = 24.0f;
        labelPaint.setTextSize(24.0f);
        labelPaint.setTextAlign(Paint.Align.LEFT);
        labelPaint.setTypeface(Typeface.DEFAULT_BOLD);
        int i = 0;
        Pair[] labels = {TuplesKt.m172to("WIDE", "#3B82F6"), TuplesKt.m172to("SLOW", "#06B6D4"), TuplesKt.m172to("FIRE", "#EF4444"), TuplesKt.m172to("MAGN", "#F472B6"), TuplesKt.m172to("SHLD", "#10B981")};
        Pair[] pairArr = labels;
        int index$iv = 0;
        int length = pairArr.length;
        while (i < length) {
            Pair pair = pairArr[i];
            String label = (String) pair.component1();
            String colorHex = (String) pair.component2();
            float f2 = f;
            labelPaint.setColor(Color.parseColor(colorHex));
            c.drawText(label, 0.0f, (index$iv * this.hudLineH) + f2, labelPaint);
            i++;
            index$iv++;
            f = f2;
            pairArr = pairArr;
        }
        this.buffLabelBitmap = bmp;
    }

    private final float fallSpeed() {
        return RangesKt.coerceAtMost(((this.level - 1) * 0.11f) + 0.35f, 3.0f);
    }

    private final float spawnInterval() {
        float base = this.rowGap * 2.2f;
        float minV = this.rowGap * 0.95f;
        return RangesKt.coerceAtLeast(base - ((this.level - 1) * 9.0f), minV);
    }

    private final float currentSpeed() {
        return RangesKt.coerceAtMost(this.baseSpeed + ((this.level - 1) * 0.55f), 21.0f);
    }

    private final float currentDefaultWidth() {
        return RangesKt.coerceAtLeast(200.0f - ((this.level - 1) * 5.0f), 130.0f);
    }

    public final void startGame() {
        this.score = 0;
        this.level = 1;
        this.rowsSpawned = 0;
        this.spawnProgress = 0.0f;
        this.paddleWidth = currentDefaultWidth();
        this.isFireBall = false;
        this.isShieldActive = false;
        this.widePaddleTimer = 0;
        this.fireBallTimer = 0;
        this.slowTimer = 0;
        this.magnetTimer = 0;
        this.magnetReleaseDelay = 0;
        this.extraShieldCount = 0;
        this.comboCount = 0;
        this.comboTimer = 0;
        this.bricks.clear();
        this.powerUps.clear();
        this.particles.clear();
        this.floaters.clear();
        this.balls.clear();
        for (int k = 1; k < 4; k++) {
            spawnBrickRow((-this.brickH) + (k * this.rowGap));
        }
        resetBallPosition();
        this.isRunning = true;
        this.handler.removeCallbacks(this.gameLoop);
        this.handler.post(this.gameLoop);
        Function2<? super Integer, ? super Integer, Unit> function2 = this.onScoreUpdated;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(this.level), Integer.valueOf(this.score));
        }
    }

    public final void stopGame() {
        this.isRunning = false;
        this.handler.removeCallbacks(this.gameLoop);
    }

    public final void updatePaddleTouch(float touchX) {
        this.paddleX = RangesKt.coerceIn(touchX - (this.paddleWidth / 2.0f), 0.0f, Math.max(0.0f, this.screenWidth - this.paddleWidth));
        if (this.magnetReleaseDelay > 0) {
            this.magnetReleaseDelay = 0;
        }
    }

    private final void resetBallPosition() {
        float sp = currentSpeed();
        this.balls.clear();
        this.balls.add(new Ball(this.screenWidth / 2.0f, this.paddleY - 40.0f, Random.INSTANCE.nextBoolean() ? 0.7f * sp : 0.7f * (-sp), -sp, false, 16, null));
    }

    private final void gameOver() {
        stopGame();
        Function0<Unit> function0 = this.onGameOver;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePhysics() {
        float f;
        float f2;
        boolean z;
        float fAbs;
        if (this.widePaddleTimer > 0) {
            this.widePaddleTimer--;
        }
        if (this.fireBallTimer > 0) {
            this.fireBallTimer--;
            if (this.fireBallTimer == 0) {
                this.isFireBall = false;
            }
        }
        if (this.slowTimer > 0) {
            this.slowTimer--;
        }
        if (this.magnetTimer > 0) {
            this.magnetTimer--;
            if (this.magnetTimer == 0) {
                releaseAllStuckBalls();
            }
        }
        if (this.magnetReleaseDelay > 0) {
            this.magnetReleaseDelay--;
            if (this.magnetReleaseDelay == 0) {
                releaseAllStuckBalls();
            }
        }
        if (this.comboTimer > 0) {
            this.comboTimer--;
            if (this.comboTimer == 0) {
                this.comboCount = 0;
            }
        }
        float f3 = 1.5f;
        this.paddleWidth = this.widePaddleTimer > 0 ? currentDefaultWidth() * 1.5f : currentDefaultWidth();
        float f4 = 0.0f;
        this.paddleX = RangesKt.coerceIn(this.paddleX, 0.0f, Math.max(0.0f, this.screenWidth - this.paddleWidth));
        float fall = fallSpeed();
        for (Brick b : this.bricks) {
            b.setY(b.getY() + fall);
            if (b.getY() + b.getHeight() >= this.paddleY) {
                gameOver();
                return;
            }
        }
        this.spawnProgress += fall;
        if (this.spawnProgress >= spawnInterval()) {
            this.spawnProgress -= spawnInterval();
            spawnBrickRow((-this.brickH) + this.spawnProgress);
            this.rowsSpawned++;
            int newLevel = (this.rowsSpawned / 5) + 1;
            if (newLevel != this.level) {
                this.level = newLevel;
                Function2<? super Integer, ? super Integer, Unit> function2 = this.onScoreUpdated;
                if (function2 != null) {
                    function2.invoke(Integer.valueOf(this.level), Integer.valueOf(this.score));
                }
            }
        }
        float slowMul = this.slowTimer > 0 ? 0.65f : 1.0f;
        Iterator bIt = this.balls.iterator();
        while (bIt.hasNext()) {
            Ball ball = bIt.next();
            if (ball.getStuck()) {
                ball.setX(this.paddleX + (this.paddleWidth / 2.0f));
                ball.setY(this.paddleY - this.ballRadius);
            } else {
                ball.setX(ball.getX() + (ball.getVx() * slowMul));
                ball.setY(ball.getY() + (ball.getVy() * slowMul));
                if (ball.getX() - this.ballRadius <= 0.0f) {
                    ball.setX(this.ballRadius);
                    ball.setVx(Math.abs(ball.getVx()));
                } else if (ball.getX() + this.ballRadius >= this.screenWidth) {
                    ball.setX(this.screenWidth - this.ballRadius);
                    ball.setVx(-Math.abs(ball.getVx()));
                }
                if (ball.getY() - this.ballRadius <= 0.0f) {
                    ball.setY(this.ballRadius);
                    ball.setVy(Math.abs(ball.getVy()));
                }
                if (ball.getVy() > 0.0f && ball.getY() + this.ballRadius >= this.paddleY && ball.getY() - this.ballRadius <= this.paddleY + this.paddleHeight && ball.getX() + this.ballRadius >= this.paddleX && ball.getX() - this.ballRadius <= this.paddleX + this.paddleWidth) {
                    ball.setY(this.paddleY - this.ballRadius);
                    if (this.magnetTimer > 0) {
                        ball.setStuck(true);
                        ball.setVx(0.0f);
                        ball.setVy(0.0f);
                        this.magnetReleaseDelay = 55;
                    } else {
                        float sp = currentSpeed();
                        float hit = RangesKt.coerceIn((ball.getX() - (this.paddleX + (this.paddleWidth / 2.0f))) / (this.paddleWidth / 2.0f), -1.0f, 1.0f);
                        ball.setVx(hit * sp * 0.9f);
                        ball.setVy(-((float) Math.sqrt(RangesKt.coerceAtLeast((sp * sp) - (ball.getVx() * ball.getVx()), sp * sp * 0.25f))));
                    }
                }
                float hit2 = ball.getY();
                if (hit2 - this.ballRadius > this.screenHeight) {
                    bIt.remove();
                }
            }
        }
        if (this.balls.isEmpty()) {
            if (this.isShieldActive) {
                this.isShieldActive = false;
                resetBallPosition();
            } else if (this.extraShieldCount > 0) {
                this.extraShieldCount--;
                resetBallPosition();
            } else {
                gameOver();
                return;
            }
        }
        for (Ball ball2 : this.balls) {
            if (!ball2.getStuck()) {
                Iterator it = this.bricks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        f = f3;
                        f2 = f4;
                        break;
                    }
                    Brick brick = it.next();
                    if (brick.getY() + brick.getHeight() > f4) {
                        if (ball2.getX() + this.ballRadius >= brick.getX() && ball2.getX() - this.ballRadius <= brick.getX() + brick.getWidth()) {
                            if (ball2.getY() + this.ballRadius >= brick.getY() && ball2.getY() - this.ballRadius <= brick.getY() + brick.getHeight()) {
                                float bx = brick.getX() + (brick.getWidth() / 2.0f);
                                float by = brick.getY() + (brick.getHeight() / 2.0f);
                                brick.setHp(this.isFireBall ? 0 : brick.getHp() - 1);
                                int color = brick.getColor();
                                if (brick.getHp() <= 0) {
                                    f = f3;
                                    z = true;
                                } else {
                                    f = f3;
                                    z = false;
                                }
                                createExplosion(bx, by, color, z);
                                if (brick.getHp() <= 0) {
                                    it.remove();
                                    registerHit(bx, by, brick.getMaxHp() * 10);
                                    if (Random.INSTANCE.nextFloat() < 0.22f) {
                                        spawnPowerUp(bx, by);
                                    }
                                }
                                if (this.isFireBall) {
                                    f3 = f;
                                } else {
                                    float dx = (ball2.getX() - bx) / (brick.getWidth() / 2.0f);
                                    float dy = (ball2.getY() - by) / (brick.getHeight() / 2.0f);
                                    if (Math.abs(dx) > Math.abs(dy)) {
                                        if (dx > f4) {
                                            f2 = f4;
                                            fAbs = Math.abs(ball2.getVx());
                                        } else {
                                            f2 = f4;
                                            fAbs = -Math.abs(ball2.getVx());
                                        }
                                        ball2.setVx(fAbs);
                                    } else {
                                        f2 = f4;
                                        ball2.setVy(dy > f2 ? Math.abs(ball2.getVy()) : -Math.abs(ball2.getVy()));
                                    }
                                }
                            }
                        }
                    }
                }
                f3 = f;
                f4 = f2;
            }
        }
        float f5 = f3;
        Iterator pIt = this.powerUps.iterator();
        while (pIt.hasNext()) {
            PowerUp p = pIt.next();
            p.setY(p.getY() + p.getSpeedY());
            if (p.getY() + p.getRadius() >= this.paddleY && p.getY() - p.getRadius() <= this.paddleY + this.paddleHeight && p.getX() >= this.paddleX && p.getX() <= this.paddleX + this.paddleWidth) {
                applyPowerUp(p.getType());
                pIt.remove();
            } else if (p.getY() > this.screenHeight) {
                pIt.remove();
            }
        }
        Iterator ptIt = this.particles.iterator();
        while (ptIt.hasNext()) {
            Particle pt = ptIt.next();
            pt.setX(pt.getX() + pt.getVx());
            pt.setY(pt.getY() + pt.getVy());
            pt.setVy(pt.getVy() + pt.getGravity());
            pt.setVx(pt.getVx() * 0.985f);
            pt.setAlpha(pt.getAlpha() - pt.getDecay());
            if (pt.getAlpha() <= 0) {
                ptIt.remove();
            }
        }
        Iterator fIt = this.floaters.iterator();
        while (fIt.hasNext()) {
            Floater f6 = fIt.next();
            f6.setY(f6.getY() - f5);
            f6.setAlpha(f6.getAlpha() - 8);
            if (f6.getAlpha() <= 0) {
                fIt.remove();
            }
        }
    }

    private final void releaseAllStuckBalls() {
        for (Ball b : this.balls) {
            if (b.getStuck()) {
                b.setStuck(false);
                float sp = currentSpeed();
                b.setVx((Random.INSTANCE.nextFloat() - 0.5f) * sp);
                b.setVy(-((float) Math.sqrt(RangesKt.coerceAtLeast((sp * sp) - (b.getVx() * b.getVx()), sp * sp * 0.25f))));
            }
        }
    }

    private final void registerHit(float x, float y, int basePoints) {
        float mult;
        this.comboCount++;
        this.comboTimer = 60;
        if (this.comboCount >= 4) {
            mult = 2.0f;
        } else {
            mult = this.comboCount >= 2 ? 1.5f : 1.0f;
        }
        int gained = (int) (basePoints * mult);
        this.score += gained;
        this.floaters.add(new Floater(x, y, 255, "+" + gained, -1));
        Function2<? super Integer, ? super Integer, Unit> function2 = this.onScoreUpdated;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(this.level), Integer.valueOf(this.score));
        }
    }

    private final void spawnBrickRow(float y) {
        float y2;
        float brickW = (this.screenWidth - (this.brickPadding * (6 + 1))) / 6;
        BrickShape[] shapes = BrickShape.values();
        int maxHp = RangesKt.coerceAtMost(this.level, 5);
        int added = 0;
        int i = 0;
        while (i < 6) {
            if (Random.INSTANCE.nextFloat() <= 0.15f) {
                y2 = y;
            } else {
                y2 = y;
                addBrick(i, brickW, y2, maxHp, shapes);
                added++;
            }
            i++;
            y = y2;
        }
        float y3 = y;
        while (added < 2) {
            addBrick(Random.INSTANCE.nextInt(6), brickW, y3, maxHp, shapes);
            added++;
        }
    }

    private final void addBrick(int col, float brickW, float y, int maxHp, BrickShape[] shapes) {
        int hp = Random.INSTANCE.nextInt(1, maxHp + 1);
        this.bricks.add(new Brick(this.brickPadding + (col * (this.brickPadding + brickW)), y, brickW, this.brickH, hp, hp, this.brickColors[Random.INSTANCE.nextInt(this.brickColors.length)], shapes[Random.INSTANCE.nextInt(shapes.length)]));
    }

    private final void spawnPowerUp(float x, float y) {
        PowerType[] types = PowerType.values();
        this.powerUps.add(new PowerUp(x, y, types[Random.INSTANCE.nextInt(types.length)], 0.0f, 0.0f, 24, null));
    }

    private final void applyPowerUp(PowerType type) {
        int i = 0;
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                this.widePaddleTimer = 400;
                break;
            case 2:
                this.slowTimer = 360;
                break;
            case 3:
                Iterable $this$filter$iv = this.bricks;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    Brick it = (Brick) element$iv$iv;
                    if ((it.getY() + it.getHeight() > 0.0f ? 1 : null) != null) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                List visible = (List) destination$iv$iv;
                int iCoerceAtMost = RangesKt.coerceAtMost(3, visible.size());
                while (i < iCoerceAtMost) {
                    Brick b = (Brick) visible.get(Random.INSTANCE.nextInt(visible.size()));
                    if (this.bricks.remove(b)) {
                        registerHit(b.getX() + (b.getWidth() / 2.0f), b.getY() + (b.getHeight() / 2.0f), b.getMaxHp() * 10);
                        createExplosion(b.getX() + (b.getWidth() / 2.0f), b.getY() + (b.getHeight() / 2.0f), b.getColor(), true);
                    }
                    i++;
                }
                break;
            case 4:
                this.isShieldActive = true;
                break;
            case 5:
                this.extraShieldCount = RangesKt.coerceAtMost(this.extraShieldCount + 1, 3);
                break;
            case 6:
                this.isFireBall = true;
                this.fireBallTimer = 350;
                break;
            case 7:
                if (!this.balls.isEmpty()) {
                    Ball source = (Ball) CollectionsKt.first((List) this.balls);
                    float sp = currentSpeed();
                    while (i < 2) {
                        float angle = (Random.INSTANCE.nextFloat() - 0.5f) * 1.2f;
                        float nvx = (source.getVx() * ((float) Math.cos(angle))) - (source.getVy() * ((float) Math.sin(angle)));
                        float nvy = (source.getVx() * ((float) Math.sin(angle))) + (source.getVy() * ((float) Math.cos(angle)));
                        float len = RangesKt.coerceAtLeast((float) Math.sqrt((nvx * nvx) + (nvy * nvy)), 0.01f);
                        this.balls.add(new Ball(source.getX(), source.getY(), (nvx / len) * sp, (nvy / len) * sp, false, 16, null));
                        i++;
                    }
                    break;
                }
                break;
            case 8:
                this.magnetTimer = 300;
                for (Ball b2 : this.balls) {
                    if (!b2.getStuck()) {
                        b2.setStuck(true);
                        b2.setVx(0.0f);
                        b2.setVy(0.0f);
                    }
                }
                this.magnetReleaseDelay = 55;
                break;
        }
    }

    private final int lighten(int c) {
        return Color.rgb(Math.min(255, Color.red(c) + 100), Math.min(255, Color.green(c) + 100), Math.min(255, Color.blue(c) + 100));
    }

    private final void createExplosion(float x, float y, int color, boolean big) {
        int i;
        Particle p;
        if (this.particles.size() > 160) {
            return;
        }
        int i2 = 10;
        int count = big ? 24 : 10;
        int i3 = 0;
        while (i3 < count) {
            float angle = Random.INSTANCE.nextFloat() * 6.2832f;
            int kind = Random.INSTANCE.nextInt(i2);
            float dirX = (float) Math.cos(angle);
            float dirY = (float) Math.sin(angle);
            if (kind < 5) {
                float s = (Random.INSTANCE.nextFloat() * 10.0f) + 6.0f;
                i = i2;
                p = new Particle(x, y, dirX * s, dirY * s, 255, Random.INSTANCE.nextBoolean() ? -1 : lighten(color), (Random.INSTANCE.nextFloat() * 1.5f) + 1.5f, Random.INSTANCE.nextInt(9) + 10, 0.0f, false);
            } else {
                i = i2;
                if (kind < 8) {
                    float s2 = (Random.INSTANCE.nextFloat() * 6.0f) + 3.0f;
                    p = new Particle(x, y, dirX * s2, dirY * s2, 255, color, (Random.INSTANCE.nextFloat() * 3.0f) + 3.0f, Random.INSTANCE.nextInt(6) + 7, 0.25f, false);
                } else {
                    float s3 = (Random.INSTANCE.nextFloat() * 4.0f) + 2.0f;
                    p = new Particle(x, y, dirX * s3, (dirY * s3) - 2.0f, 255, color, (Random.INSTANCE.nextFloat() * 5.0f) + 6.0f, Random.INSTANCE.nextInt(4) + 5, 0.5f, true);
                }
            }
            this.particles.add(p);
            i3++;
            i2 = i;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawColor(this.bgColor);
        canvas.drawLine(0.0f, this.paddleY, this.screenWidth, this.paddleY, this.linePaint);
        if (this.isShieldActive || this.extraShieldCount > 0) {
            this.shieldPaint.setAlpha(((int) (Math.sin(System.currentTimeMillis() / 200.0d) * 55)) + 200);
            canvas.drawRect(0.0f, this.screenHeight - 20.0f, this.screenWidth, this.screenHeight, this.shieldPaint);
            this.shieldPaint.setAlpha(255);
        }
        canvas.drawRoundRect(this.paddleX, this.paddleY, this.paddleWidth + this.paddleX, this.paddleHeight + this.paddleY, 16.0f, 16.0f, this.paddlePaint);
        for (Ball ball : this.balls) {
            if (ball.getStuck()) {
                paint = this.stuckBallPaint;
            } else {
                paint = this.isFireBall ? this.fireBallPaint : this.ballPaint;
            }
            canvas.drawCircle(ball.getX(), ball.getY(), this.ballRadius, paint);
        }
        for (Brick b : this.bricks) {
            if (b.getY() + b.getHeight() >= 0.0f) {
                this.brickPaint.setColor(b.getColor());
                drawVariedBrick(canvas, b);
            }
        }
        for (PowerUp p : this.powerUps) {
            drawPowerUp(canvas, p);
        }
        for (Particle pt : this.particles) {
            this.particlePaint.setColor(pt.getColor());
            this.particlePaint.setAlpha(RangesKt.coerceIn(pt.getAlpha(), 0, 255));
            if (pt.getSquare()) {
                canvas.drawRect(pt.getX() - pt.getSize(), pt.getY() - pt.getSize(), pt.getX() + pt.getSize(), pt.getY() + pt.getSize(), this.particlePaint);
            } else {
                canvas.drawCircle(pt.getX(), pt.getY(), pt.getSize(), this.particlePaint);
            }
        }
        for (Floater f : this.floaters) {
            this.textPaint.setColor(f.getColor());
            this.textPaint.setAlpha(f.getAlpha());
            canvas.save();
            canvas.scale(1.0f, 1.0f, f.getX(), f.getY());
            canvas.drawText(f.getText(), f.getX(), f.getY(), this.textPaint);
            canvas.restore();
        }
        drawBuffHud(canvas);
    }

    private final void drawBuffHud(Canvas canvas) {
        PongGameEngine pongGameEngine;
        Canvas canvas2;
        Ref.FloatRef y = new Ref.FloatRef();
        y.element = 40.0f;
        Bitmap labelBmp = this.buffLabelBitmap;
        int row = 0;
        if (this.widePaddleTimer > 0) {
            pongGameEngine = this;
            canvas2 = canvas;
            drawBuffHud$drawBuffRow(labelBmp, pongGameEngine, y, canvas2, 0, this.widePaddleTimer, 400, Color.parseColor("#3B82F6"));
            row = 0 + 1;
        } else {
            pongGameEngine = this;
            canvas2 = canvas;
        }
        if (pongGameEngine.slowTimer > 0) {
            drawBuffHud$drawBuffRow(labelBmp, pongGameEngine, y, canvas2, row, pongGameEngine.slowTimer, 360, Color.parseColor("#06B6D4"));
            row++;
        }
        if (pongGameEngine.fireBallTimer > 0) {
            drawBuffHud$drawBuffRow(labelBmp, pongGameEngine, y, canvas2, row, pongGameEngine.fireBallTimer, 350, Color.parseColor("#EF4444"));
            row++;
        }
        if (pongGameEngine.magnetTimer > 0) {
            drawBuffHud$drawBuffRow(labelBmp, pongGameEngine, y, canvas2, row, pongGameEngine.magnetTimer, 300, Color.parseColor("#F472B6"));
            row++;
        }
        if (pongGameEngine.isShieldActive) {
            drawBuffHud$drawBuffRow(labelBmp, pongGameEngine, y, canvas2, row, 1, 1, Color.parseColor("#10B981"));
            int i = row + 1;
        }
        if (pongGameEngine.extraShieldCount > 0) {
            pongGameEngine.hudPaint.setColor(Color.parseColor("#22C55E"));
            pongGameEngine.hudPaint.setTextSize(24.0f);
            canvas2.drawText("+" + pongGameEngine.extraShieldCount + " LIFE", pongGameEngine.hudX, y.element, pongGameEngine.hudPaint);
        }
    }

    private static final void drawBuffHud$drawBuffRow(Bitmap labelBmp, PongGameEngine this$0, Ref.FloatRef y, Canvas $canvas, int rowIndex, int remaining, int total, int color) {
        Canvas canvas;
        if (labelBmp == null) {
            canvas = $canvas;
        } else {
            Rect srcRect = new Rect(0, (int) (rowIndex * this$0.hudLineH), 80, (int) ((rowIndex + 1) * this$0.hudLineH));
            float f = 26;
            Rect dstRect = new Rect((int) this$0.hudX, (int) (y.element - f), ((int) this$0.hudX) + 80, ((int) (y.element - f)) + ((int) this$0.hudLineH));
            canvas = $canvas;
            canvas.drawBitmap(labelBmp, srcRect, dstRect, (Paint) null);
        }
        canvas.drawRect(this$0.hudX + 70.0f, y.element - 16.0f, this$0.hudBarW + this$0.hudX + 70.0f, this$0.hudBarH + (y.element - 16.0f), this$0.buffBarBgPaint);
        this$0.buffBarFgPaint.setColor(color);
        float fill = RangesKt.coerceIn(remaining / total, 0.0f, 1.0f);
        $canvas.drawRect(this$0.hudX + 70.0f, y.element - 16.0f, this$0.hudX + 70.0f + (this$0.hudBarW * fill), (y.element - 16.0f) + this$0.hudBarH, this$0.buffBarFgPaint);
        y.element += this$0.hudLineH;
    }

    private final void drawVariedBrick(Canvas canvas, Brick b) {
        Canvas canvas2;
        this.path.reset();
        switch (WhenMappings.$EnumSwitchMapping$1[b.getShape().ordinal()]) {
            case 1:
                canvas2 = canvas;
                canvas2.drawRoundRect(b.getX(), b.getY(), b.getX() + b.getWidth(), b.getY() + b.getHeight(), 10.0f, 10.0f, this.brickPaint);
                break;
            case 2:
                this.path.moveTo(b.getX(), b.getY() + b.getHeight());
                this.path.lineTo(b.getX() + b.getWidth(), b.getY() + b.getHeight());
                this.path.lineTo(b.getX() + b.getWidth(), b.getY());
                this.path.close();
                canvas.drawPath(this.path, this.brickPaint);
                canvas2 = canvas;
                break;
            case 3:
                this.path.moveTo(b.getX(), b.getY());
                this.path.lineTo(b.getX() + b.getWidth(), b.getY() + b.getHeight());
                this.path.lineTo(b.getX(), b.getY() + b.getHeight());
                this.path.close();
                canvas.drawPath(this.path, this.brickPaint);
                canvas2 = canvas;
                break;
            case 4:
                float r = Math.min(b.getWidth(), b.getHeight()) / 2.0f;
                canvas.drawCircle(b.getX() + (b.getWidth() / 2.0f), b.getY() + (b.getHeight() / 2.0f), r, this.brickPaint);
                canvas2 = canvas;
                break;
            case 5:
                this.path.moveTo(b.getX() + (b.getWidth() / 2.0f), b.getY());
                this.path.lineTo(b.getX() + b.getWidth(), b.getY() + (b.getHeight() / 2.0f));
                this.path.lineTo(b.getX() + (b.getWidth() / 2.0f), b.getY() + b.getHeight());
                this.path.lineTo(b.getX(), b.getY() + (b.getHeight() / 2.0f));
                this.path.close();
                canvas.drawPath(this.path, this.brickPaint);
                canvas2 = canvas;
                break;
            case 6:
                float cx = b.getX() + (b.getWidth() / 2.0f);
                float cy = b.getY() + (b.getHeight() / 2.0f);
                float rx = b.getWidth() / 2.0f;
                this.path.moveTo(cx - (rx * 0.5f), b.getY());
                this.path.lineTo((rx * 0.5f) + cx, b.getY());
                this.path.lineTo(b.getX() + b.getWidth(), cy);
                this.path.lineTo((rx * 0.5f) + cx, b.getY() + b.getHeight());
                this.path.lineTo(cx - (0.5f * rx), b.getY() + b.getHeight());
                this.path.lineTo(b.getX(), cy);
                this.path.close();
                canvas.drawPath(this.path, this.brickPaint);
                canvas2 = canvas;
                break;
            default:
                canvas2 = canvas;
                break;
        }
        if (b.getHp() > 1) {
            this.textPaint.setColor(-1);
            this.textPaint.setTextSize(b.getHeight() * 0.45f);
            canvas2.drawText(String.valueOf(b.getHp()), b.getX() + (b.getWidth() / 2.0f), b.getY() + (b.getHeight() * 0.7f), this.textPaint);
        }
    }

    private final void drawPowerUp(Canvas canvas, PowerUp p) {
        Pair pair;
        switch (WhenMappings.$EnumSwitchMapping$0[p.getType().ordinal()]) {
            case 1:
                pair = new Pair(Integer.valueOf(Color.parseColor("#3B82F6")), "W");
                break;
            case 2:
                pair = new Pair(Integer.valueOf(Color.parseColor("#06B6D4")), "T");
                break;
            case 3:
                pair = new Pair(Integer.valueOf(Color.parseColor("#EF4444")), "B");
                break;
            case 4:
                pair = new Pair(Integer.valueOf(Color.parseColor("#10B981")), "H");
                break;
            case 5:
                pair = new Pair(Integer.valueOf(Color.parseColor("#22C55E")), "+");
                break;
            case 6:
                pair = new Pair(Integer.valueOf(Color.parseColor("#EC4899")), "F");
                break;
            case 7:
                pair = new Pair(Integer.valueOf(Color.parseColor("#A855F7")), "M");
                break;
            case 8:
                pair = new Pair(Integer.valueOf(Color.parseColor("#F472B6")), "G");
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        int color = ((Number) pair.component1()).intValue();
        String label = (String) pair.component2();
        this.brickPaint.setColor(color);
        canvas.drawCircle(p.getX(), p.getY(), p.getRadius(), this.brickPaint);
        this.textPaint.setColor(-1);
        this.textPaint.setTextSize(24.0f);
        canvas.drawText(label, p.getX(), p.getY() + 8.0f, this.textPaint);
    }
}
