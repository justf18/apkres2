package com.sekolah.cbt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* compiled from: CyberSnakeEngine.kt */
@Metadata(m164d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001-\b\u0007\u0018\u00002\u00020\u0001:\u0002mnB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010X\u001a\u00020=H\u0002J\b\u0010Y\u001a\u00020=H\u0002J\b\u0010Z\u001a\u00020=H\u0014J\u0010\u0010[\u001a\u00020=2\u0006\u0010\\\u001a\u00020]H\u0014J(\u0010^\u001a\u00020=2\u0006\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007H\u0014J\u0006\u0010c\u001a\u00020=J\u0016\u0010d\u001a\u00020=2\u0006\u0010e\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u0007J\u0010\u0010g\u001a\u00020=2\u0006\u0010h\u001a\u00020OH\u0002J\b\u0010i\u001a\u00020=H\u0002J\b\u0010j\u001a\u00020=H\u0002J\u0006\u0010k\u001a\u00020=J\b\u0010l\u001a\u00020=H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.R\u000e\u0010/\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001a0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR(\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020=\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001a0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006o"}, m165d2 = {"Lcom/sekolah/cbt/CyberSnakeEngine;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "baseSpeed", "", "bgColor", "bodyColor", "cellH", "", "cellW", "comboBarBgColor", "comboBarFgColor", "comboCount", "comboMultiplier", "comboTextColor", "comboTimer", "currentFoodType", "Lcom/sekolah/cbt/CyberSnakeEngine$FoodType;", "currentSpeed", "direction", "Lkotlin/Pair;", "enemyColor", "enemyEyeColor", "enemyLifeTimer", "enemyMoveCounter", "enemyPos", "eyeColor", "floaters", "", "Lcom/sekolah/cbt/CyberSnakeEngine$Floater;", "food", "foodBombColor", "foodColor", "foodNormalColor", "foodPoints", "foodShieldColor", "foodSlowColor", "frameCounter", "gameRunnable", "com/sekolah/cbt/CyberSnakeEngine$gameRunnable$1", "Lcom/sekolah/cbt/CyberSnakeEngine$gameRunnable$1;", "gridColor", "handler", "Landroid/os/Handler;", "headNormalColor", "headShieldColor", "isGameRunning", "", "nextDirection", "numCols", "numRows", "obstacleColor", "obstacles", "onGameOver", "Lkotlin/Function0;", "", "getOnGameOver", "()Lkotlin/jvm/functions/Function0;", "setOnGameOver", "(Lkotlin/jvm/functions/Function0;)V", "onScoreUpdated", "Lkotlin/Function1;", "getOnScoreUpdated", "()Lkotlin/jvm/functions/Function1;", "setOnScoreUpdated", "(Lkotlin/jvm/functions/Function1;)V", "paint", "Landroid/graphics/Paint;", "score", "shieldTimer", "slowTimer", "snake", "statusMessage", "", "statusMessageAlpha", "statusTextColor", "telegraphColor", "telegraphTimer", "telegraphX", "telegraphY", "textPaint", "whiteColor", "generateObstacles", "moveEnemyTowardsSnake", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "resetGame", "setDirection", "dx", "dy", "showStatusMessage", NotificationCompat.CATEGORY_MESSAGE, "spawnEnemy", "spawnFood", "startGame", "updateGameLogic", "Floater", "FoodType", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class CyberSnakeEngine extends View {
    public static final int $stable = 8;
    private final long baseSpeed;
    private final int bgColor;
    private final int bodyColor;
    private float cellH;
    private float cellW;
    private final int comboBarBgColor;
    private final int comboBarFgColor;
    private int comboCount;
    private float comboMultiplier;
    private final int comboTextColor;
    private int comboTimer;
    private FoodType currentFoodType;
    private long currentSpeed;
    private Pair<Integer, Integer> direction;
    private final int enemyColor;
    private final int enemyEyeColor;
    private int enemyLifeTimer;
    private int enemyMoveCounter;
    private Pair<Integer, Integer> enemyPos;
    private final int eyeColor;
    private final List<Floater> floaters;
    private Pair<Integer, Integer> food;
    private final int foodBombColor;
    private int foodColor;
    private final int foodNormalColor;
    private int foodPoints;
    private final int foodShieldColor;
    private final int foodSlowColor;
    private int frameCounter;
    private final CyberSnakeEngine$gameRunnable$1 gameRunnable;
    private final int gridColor;
    private final Handler handler;
    private final int headNormalColor;
    private final int headShieldColor;
    private boolean isGameRunning;
    private Pair<Integer, Integer> nextDirection;
    private final int numCols;
    private final int numRows;
    private final int obstacleColor;
    private final List<Pair<Integer, Integer>> obstacles;
    private Function0<Unit> onGameOver;
    private Function1<? super Integer, Unit> onScoreUpdated;
    private final Paint paint;
    private int score;
    private int shieldTimer;
    private int slowTimer;
    private final List<Pair<Integer, Integer>> snake;
    private String statusMessage;
    private int statusMessageAlpha;
    private final int statusTextColor;
    private final int telegraphColor;
    private int telegraphTimer;
    private int telegraphX;
    private int telegraphY;
    private final Paint textPaint;
    private final int whiteColor;

    /* compiled from: CyberSnakeEngine.kt */
    @Metadata(m164d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m165d2 = {"Lcom/sekolah/cbt/CyberSnakeEngine$FoodType;", "", "(Ljava/lang/String;I)V", "NORMAL", "SLOW_MOTION", "SHIELD", "BOMB", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public enum FoodType {
        NORMAL,
        SLOW_MOTION,
        SHIELD,
        BOMB;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<FoodType> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: CyberSnakeEngine.kt */
    @Metadata(m166k = 3, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FoodType.values().length];
            try {
                iArr[FoodType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FoodType.SLOW_MOTION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FoodType.SHIELD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[FoodType.BOMB.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CyberSnakeEngine(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CyberSnakeEngine(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CyberSnakeEngine(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.sekolah.cbt.CyberSnakeEngine$gameRunnable$1] */
    public CyberSnakeEngine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.numCols = 14;
        this.numRows = 22;
        this.snake = new ArrayList();
        this.obstacles = new ArrayList();
        this.telegraphX = -1;
        this.telegraphY = -1;
        this.direction = new Pair<>(1, 0);
        this.nextDirection = new Pair<>(1, 0);
        this.currentFoodType = FoodType.NORMAL;
        this.foodPoints = 15;
        this.statusMessage = "";
        this.comboMultiplier = 1.0f;
        this.floaters = new ArrayList();
        this.baseSpeed = 240L;
        this.currentSpeed = this.baseSpeed;
        this.paint = new Paint(1);
        Paint $this$textPaint_u24lambda_u240 = new Paint(1);
        $this$textPaint_u24lambda_u240.setTextAlign(Paint.Align.CENTER);
        $this$textPaint_u24lambda_u240.setTypeface(Typeface.DEFAULT_BOLD);
        this.textPaint = $this$textPaint_u24lambda_u240;
        this.bgColor = Color.parseColor("#0F172A");
        this.gridColor = Color.parseColor("#1E293B");
        this.obstacleColor = Color.parseColor("#475569");
        this.enemyColor = Color.parseColor("#EF4444");
        this.enemyEyeColor = InputDeviceCompat.SOURCE_ANY;
        this.telegraphColor = Color.parseColor("#F87171");
        this.headShieldColor = Color.parseColor("#FACC15");
        this.headNormalColor = Color.parseColor("#38BDF8");
        this.bodyColor = Color.parseColor("#0EA5E9");
        this.eyeColor = ViewCompat.MEASURED_STATE_MASK;
        this.foodNormalColor = Color.parseColor("#EF4444");
        this.foodSlowColor = Color.parseColor("#EAB308");
        this.foodShieldColor = Color.parseColor("#06B6D4");
        this.foodBombColor = Color.parseColor("#EC4899");
        this.comboBarBgColor = Color.parseColor("#334155");
        this.comboBarFgColor = Color.parseColor("#F59E0B");
        this.comboTextColor = Color.parseColor("#FACC15");
        this.whiteColor = -1;
        this.statusTextColor = Color.parseColor("#FACC15");
        this.handler = new Handler(Looper.getMainLooper());
        this.gameRunnable = new Runnable() { // from class: com.sekolah.cbt.CyberSnakeEngine$gameRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (this.this$0.isGameRunning) {
                    this.this$0.updateGameLogic();
                    this.this$0.invalidate();
                    this.this$0.handler.postDelayed(this, this.this$0.currentSpeed);
                }
            }
        };
    }

    public final Function1<Integer, Unit> getOnScoreUpdated() {
        return this.onScoreUpdated;
    }

    public final void setOnScoreUpdated(Function1<? super Integer, Unit> function1) {
        this.onScoreUpdated = function1;
    }

    public final Function0<Unit> getOnGameOver() {
        return this.onGameOver;
    }

    public final void setOnGameOver(Function0<Unit> function0) {
        this.onGameOver = function0;
    }

    /* compiled from: CyberSnakeEngine.kt */
    @Metadata(m164d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006'"}, m165d2 = {"Lcom/sekolah/cbt/CyberSnakeEngine$Floater;", "", "x", "", "y", "alpha", "", "scale", "text", "", TypedValues.Custom.S_COLOR, "(FFIFLjava/lang/String;I)V", "getAlpha", "()I", "setAlpha", "(I)V", "getColor", "getScale", "()F", "setScale", "(F)V", "getText", "()Ljava/lang/String;", "getX", "setX", "getY", "setY", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    private static final /* data */ class Floater {
        private int alpha;
        private final int color;
        private float scale;
        private final String text;
        private float x;
        private float y;

        public static /* synthetic */ Floater copy$default(Floater floater, float f, float f2, int i, float f3, String str, int i2, int i3, Object obj) {
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
                f3 = floater.scale;
            }
            if ((i3 & 16) != 0) {
                str = floater.text;
            }
            if ((i3 & 32) != 0) {
                i2 = floater.color;
            }
            String str2 = str;
            int i4 = i2;
            return floater.copy(f, f2, i, f3, str2, i4);
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
        public final float getScale() {
            return this.scale;
        }

        /* renamed from: component5, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component6, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        public final Floater copy(float x, float y, int alpha, float scale, String text, int color) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new Floater(x, y, alpha, scale, text, color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Floater)) {
                return false;
            }
            Floater floater = (Floater) other;
            return Float.compare(this.x, floater.x) == 0 && Float.compare(this.y, floater.y) == 0 && this.alpha == floater.alpha && Float.compare(this.scale, floater.scale) == 0 && Intrinsics.areEqual(this.text, floater.text) && this.color == floater.color;
        }

        public int hashCode() {
            return (((((((((Float.hashCode(this.x) * 31) + Float.hashCode(this.y)) * 31) + Integer.hashCode(this.alpha)) * 31) + Float.hashCode(this.scale)) * 31) + this.text.hashCode()) * 31) + Integer.hashCode(this.color);
        }

        public String toString() {
            return "Floater(x=" + this.x + ", y=" + this.y + ", alpha=" + this.alpha + ", scale=" + this.scale + ", text=" + this.text + ", color=" + this.color + ")";
        }

        public Floater(float x, float y, int alpha, float scale, String text, int color) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.x = x;
            this.y = y;
            this.alpha = alpha;
            this.scale = scale;
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

        public final float getScale() {
            return this.scale;
        }

        public final void setScale(float f) {
            this.scale = f;
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
        if (w <= 0 || h <= 0) {
            return;
        }
        this.cellW = w / this.numCols;
        this.cellH = h / this.numRows;
    }

    public final void startGame() {
        resetGame();
        this.isGameRunning = true;
        this.handler.removeCallbacks(this.gameRunnable);
        this.handler.post(this.gameRunnable);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.isGameRunning = false;
        this.handler.removeCallbacks(this.gameRunnable);
        super.onDetachedFromWindow();
    }

    public final void resetGame() {
        int startX = this.numCols / 2;
        int startY = this.numRows / 2;
        this.snake.clear();
        this.snake.add(new Pair<>(Integer.valueOf(startX), Integer.valueOf(startY)));
        this.snake.add(new Pair<>(Integer.valueOf(startX - 1), Integer.valueOf(startY)));
        this.snake.add(new Pair<>(Integer.valueOf(startX - 2), Integer.valueOf(startY)));
        this.direction = new Pair<>(1, 0);
        this.nextDirection = new Pair<>(1, 0);
        this.score = 0;
        this.currentSpeed = this.baseSpeed;
        this.shieldTimer = 0;
        this.slowTimer = 0;
        this.enemyPos = null;
        this.enemyLifeTimer = 0;
        this.enemyMoveCounter = 0;
        this.telegraphX = -1;
        this.telegraphY = -1;
        this.telegraphTimer = 0;
        this.statusMessageAlpha = 0;
        this.comboCount = 0;
        this.comboTimer = 0;
        this.comboMultiplier = 1.0f;
        this.floaters.clear();
        generateObstacles();
        spawnFood();
        Function1<? super Integer, Unit> function1 = this.onScoreUpdated;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(this.score));
        }
    }

    private final void generateObstacles() {
        Pair obs;
        this.obstacles.clear();
        int count = Random.INSTANCE.nextInt(4, 7);
        for (int i = 0; i < count; i++) {
            do {
                obs = new Pair(Integer.valueOf(Random.INSTANCE.nextInt(1, this.numCols - 1)), Integer.valueOf(Random.INSTANCE.nextInt(1, this.numRows - 1)));
            } while (this.snake.contains(obs));
            this.obstacles.add(obs);
        }
    }

    private final void spawnFood() {
        FoodType foodType;
        int i;
        int i2;
        float rand = Random.INSTANCE.nextFloat();
        if (rand < 0.7f) {
            foodType = FoodType.NORMAL;
        } else if (rand < 0.8f) {
            foodType = FoodType.SLOW_MOTION;
        } else {
            foodType = rand < 0.9f ? FoodType.SHIELD : FoodType.BOMB;
        }
        this.currentFoodType = foodType;
        switch (WhenMappings.$EnumSwitchMapping$0[this.currentFoodType.ordinal()]) {
            case 1:
                i = this.foodNormalColor;
                break;
            case 2:
                i = this.foodSlowColor;
                break;
            case 3:
                i = this.foodShieldColor;
                break;
            case 4:
                i = this.foodBombColor;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        this.foodColor = i;
        switch (WhenMappings.$EnumSwitchMapping$0[this.currentFoodType.ordinal()]) {
            case 1:
                i2 = 15;
                break;
            case 2:
                i2 = 25;
                break;
            case 3:
                i2 = 30;
                break;
            case 4:
                i2 = 40;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        this.foodPoints = i2;
        while (true) {
            int fx = Random.INSTANCE.nextInt(0, this.numCols);
            int fy = Random.INSTANCE.nextInt(0, this.numRows);
            if (!this.snake.contains(new Pair(Integer.valueOf(fx), Integer.valueOf(fy))) && !this.obstacles.contains(new Pair(Integer.valueOf(fx), Integer.valueOf(fy))) && !Intrinsics.areEqual(this.enemyPos, new Pair(Integer.valueOf(fx), Integer.valueOf(fy)))) {
                this.food = new Pair<>(Integer.valueOf(fx), Integer.valueOf(fy));
                return;
            }
        }
    }

    private final void spawnEnemy() {
        int ex;
        int ey;
        if (this.enemyPos != null || this.telegraphTimer > 0) {
            return;
        }
        int attempts = 0;
        while (true) {
            ex = Random.INSTANCE.nextInt(0, this.numCols);
            ey = Random.INSTANCE.nextInt(0, this.numRows);
            attempts++;
            if (attempts >= 100 || (!this.snake.contains(new Pair(Integer.valueOf(ex), Integer.valueOf(ey))) && !this.obstacles.contains(new Pair(Integer.valueOf(ex), Integer.valueOf(ey))) && !Intrinsics.areEqual(this.food, new Pair(Integer.valueOf(ex), Integer.valueOf(ey))))) {
                break;
            }
        }
        this.telegraphX = ex;
        this.telegraphY = ey;
        this.telegraphTimer = 3;
    }

    public final void setDirection(int dx, int dy) {
        if (dx != 0 && this.direction.getFirst().intValue() != (-dx)) {
            this.nextDirection = new Pair<>(Integer.valueOf(dx), 0);
        }
        if (dy != 0 && this.direction.getSecond().intValue() != (-dy)) {
            this.nextDirection = new Pair<>(0, Integer.valueOf(dy));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateGameLogic() {
        float f;
        this.frameCounter++;
        this.direction = this.nextDirection;
        if (this.shieldTimer > 0) {
            this.shieldTimer--;
        }
        if (this.slowTimer > 0) {
            this.slowTimer--;
            if (this.slowTimer == 0) {
                this.currentSpeed = RangesKt.coerceAtLeast(this.baseSpeed - ((this.score / 65) * 9), 135L);
            }
        }
        if (this.comboTimer > 0) {
            this.comboTimer--;
            if (this.comboTimer == 0) {
                this.comboCount = 0;
                this.comboMultiplier = 1.0f;
            }
        }
        if (this.telegraphTimer > 0) {
            this.telegraphTimer--;
            if (this.telegraphTimer == 0) {
                this.enemyPos = new Pair<>(Integer.valueOf(this.telegraphX), Integer.valueOf(this.telegraphY));
                this.enemyLifeTimer = 25;
                this.enemyMoveCounter = 0;
                this.telegraphX = -1;
                this.telegraphY = -1;
            }
        }
        Pair head = (Pair) CollectionsKt.first((List) this.snake);
        int newX = (((Number) head.getFirst()).intValue() + this.direction.getFirst().intValue()) % this.numCols;
        if (newX < 0) {
            newX += this.numCols;
        }
        int newY = (((Number) head.getSecond()).intValue() + this.direction.getSecond().intValue()) % this.numRows;
        if (newY < 0) {
            newY += this.numRows;
        }
        Pair newHead = new Pair(Integer.valueOf(newX), Integer.valueOf(newY));
        boolean isBodyHit = this.snake.contains(newHead);
        boolean isObsHit = this.obstacles.contains(newHead);
        boolean isEnemyHit = this.enemyPos != null && Intrinsics.areEqual(newHead, this.enemyPos);
        if ((isBodyHit || isObsHit || isEnemyHit) && this.shieldTimer <= 0) {
            this.isGameRunning = false;
            Function0<Unit> function0 = this.onGameOver;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        this.snake.add(0, newHead);
        float f2 = 1.0f;
        if (this.food == null || !Intrinsics.areEqual(newHead, this.food)) {
            this.snake.remove(this.snake.size() - 1);
        } else {
            this.comboCount++;
            this.comboTimer = 18;
            if (this.comboCount >= 5) {
                f = 2.5f;
            } else if (this.comboCount >= 3) {
                f = 2.0f;
            } else {
                f = this.comboCount >= 2 ? 1.5f : 1.0f;
            }
            this.comboMultiplier = f;
            int gained = (int) (this.foodPoints * this.comboMultiplier);
            this.score += gained;
            Function1<? super Integer, Unit> function1 = this.onScoreUpdated;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(this.score));
            }
            if (this.floaters.size() >= 3) {
                this.floaters.remove(0);
            }
            float fx = (newHead.getFirst().floatValue() * this.cellW) + (this.cellW / 2.0f);
            float fy = (newHead.getSecond().floatValue() * this.cellH) + (this.cellH / 2.0f);
            String label = (this.comboMultiplier > 1.0f ? new StringBuilder().append("+").append(gained).append(" x").append(this.comboMultiplier) : new StringBuilder().append("+").append(gained)).toString();
            this.floaters.add(new Floater(fx, fy, 255, this.comboMultiplier > 1.0f ? 1.3f : 1.1f, label, this.comboMultiplier > 1.0f ? this.comboTextColor : this.whiteColor));
            switch (WhenMappings.$EnumSwitchMapping$0[this.currentFoodType.ordinal()]) {
                case 2:
                    this.slowTimer = 20;
                    this.currentSpeed = 320L;
                    showStatusMessage("SLOW MOTION!");
                    break;
                case 3:
                    this.shieldTimer = 25;
                    showStatusMessage("SHIELD ACTIVE!");
                    break;
                case 4:
                    this.enemyPos = null;
                    this.telegraphTimer = 0;
                    this.telegraphX = -1;
                    this.telegraphY = -1;
                    showStatusMessage("BOMB CLEAR!");
                    break;
            }
            if (this.slowTimer <= 0) {
                this.currentSpeed = RangesKt.coerceAtLeast(this.baseSpeed - ((this.score / 65) * 9), 135L);
            }
            if (this.enemyPos == null && this.telegraphTimer == 0 && Random.INSTANCE.nextFloat() < 0.3f) {
                spawnEnemy();
            }
            spawnFood();
        }
        if (this.enemyPos != null) {
            this.enemyLifeTimer--;
            if (this.enemyLifeTimer > 0) {
                this.enemyMoveCounter++;
                if (this.enemyMoveCounter % 2 == 0) {
                    moveEnemyTowardsSnake();
                }
            } else {
                this.enemyPos = null;
            }
        }
        int i = 0;
        while (i < this.floaters.size()) {
            Floater f3 = this.floaters.get(i);
            f3.setY(f3.getY() - 1.5f);
            f3.setAlpha(f3.getAlpha() - 6);
            float f4 = f2;
            f3.setScale(RangesKt.coerceAtLeast(f3.getScale() - 0.005f, f4));
            if (f3.getAlpha() <= 0) {
                this.floaters.remove(i);
                f2 = f4;
            } else {
                i++;
                f2 = f4;
            }
        }
        if (this.statusMessageAlpha > 0) {
            this.statusMessageAlpha -= 6;
        }
    }

    private final void moveEnemyTowardsSnake() {
        Pair nextEnemyPos;
        Pair ep = this.enemyPos;
        if (ep == null) {
            return;
        }
        Pair head = (Pair) CollectionsKt.first((List) this.snake);
        int dx = 0;
        int dy = 0;
        if (ep.getFirst().intValue() < ((Number) head.getFirst()).intValue()) {
            dx = 1;
        } else if (ep.getFirst().intValue() > ((Number) head.getFirst()).intValue()) {
            dx = -1;
        }
        if (ep.getSecond().intValue() < ((Number) head.getSecond()).intValue()) {
            dy = 1;
        } else if (ep.getSecond().intValue() > ((Number) head.getSecond()).intValue()) {
            dy = -1;
        }
        if ((dx == 0 || !Random.INSTANCE.nextBoolean()) && dy != 0) {
            nextEnemyPos = new Pair(ep.getFirst(), Integer.valueOf(ep.getSecond().intValue() + dy));
        } else {
            nextEnemyPos = new Pair(Integer.valueOf(ep.getFirst().intValue() + dx), ep.getSecond());
        }
        if (!this.obstacles.contains(nextEnemyPos)) {
            this.enemyPos = nextEnemyPos;
        }
    }

    private final void showStatusMessage(String msg) {
        this.statusMessage = msg;
        this.statusMessageAlpha = 255;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        Canvas canvas2;
        Canvas canvas3;
        Canvas canvas4 = canvas;
        Intrinsics.checkNotNullParameter(canvas4, "canvas");
        super.onDraw(canvas);
        if (this.cellW <= 0.0f || this.cellH <= 0.0f) {
            return;
        }
        canvas4.drawColor(this.bgColor);
        this.paint.setColor(this.gridColor);
        this.paint.setStrokeWidth(1.5f);
        int i = this.numCols;
        if (0 <= i) {
            int i2 = 0;
            while (true) {
                canvas4.drawLine(i2 * this.cellW, 0.0f, this.cellW * i2, getHeight(), this.paint);
                if (i2 == i) {
                    break;
                }
                i2++;
                canvas4 = canvas;
            }
        }
        int i3 = this.numRows;
        if (0 <= i3) {
            int j = 0;
            while (true) {
                canvas.drawLine(0.0f, j * this.cellH, getWidth(), j * this.cellH, this.paint);
                if (j == i3) {
                    break;
                } else {
                    j++;
                }
            }
        }
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.obstacleColor);
        for (Pair obs : this.obstacles) {
            canvas.drawRoundRect((obs.getFirst().floatValue() * this.cellW) + 3.0f, (obs.getSecond().floatValue() * this.cellH) + 3.0f, ((obs.getFirst().intValue() + 1) * this.cellW) - 3.0f, ((obs.getSecond().intValue() + 1) * this.cellH) - 3.0f, 6.0f, 6.0f, this.paint);
        }
        Pair f2 = this.food;
        if (f2 == null) {
            f = 2.0f;
        } else {
            this.paint.setColor(this.foodColor);
            float cx = (f2.getFirst().floatValue() * this.cellW) + (this.cellW / 2.0f);
            float cy = (f2.getSecond().floatValue() * this.cellH) + (this.cellH / 2.0f);
            float r = Math.min(this.cellW, this.cellH) / 2.3f;
            canvas.drawCircle(cx, cy, r, this.paint);
            float pulse = (float) ((Math.sin(this.frameCounter * 0.15d) * 0.3d) + 0.7d);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(2.0f);
            this.paint.setAlpha(RangesKt.coerceIn((int) (150 * pulse), 0, 255));
            canvas.drawCircle(cx, cy, 1.4f * r, this.paint);
            this.paint.setAlpha(255);
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(this.whiteColor);
            f = 2.0f;
            canvas.drawCircle(cx - (r / 3.0f), cy - (r / 3.0f), r / 3.0f, this.paint);
        }
        if (this.telegraphTimer > 0 && this.telegraphX >= 0) {
            float x = this.telegraphX * this.cellW;
            float y = this.telegraphY * this.cellH;
            this.paint.setColor(this.telegraphColor);
            this.paint.setAlpha(RangesKt.coerceIn(((int) (Math.sin(this.frameCounter * 0.4d) * 100)) + 100, 0, 255));
            canvas.drawRoundRect(x + f, y + f, (this.cellW + x) - f, (this.cellH + y) - f, 10.0f, 10.0f, this.paint);
            this.paint.setAlpha(255);
        }
        Pair ep = this.enemyPos;
        if (ep == null) {
            canvas2 = canvas;
        } else {
            float x2 = ep.getFirst().floatValue() * this.cellW;
            float y2 = ep.getSecond().floatValue() * this.cellH;
            this.paint.setColor(this.enemyColor);
            canvas2 = canvas;
            canvas2.drawRoundRect(x2 + f, y2 + f, (x2 + this.cellW) - f, (y2 + this.cellH) - f, 10.0f, 10.0f, this.paint);
            this.paint.setColor(this.enemyEyeColor);
            canvas2.drawCircle(x2 + (this.cellW * 0.35f), y2 + (this.cellH * 0.4f), 4.0f, this.paint);
            canvas2.drawCircle(x2 + (this.cellW * 0.65f), y2 + (this.cellH * 0.4f), 4.0f, this.paint);
        }
        int size = this.snake.size();
        int i4 = 0;
        while (i4 < size) {
            Pair p = this.snake.get(i4);
            float x3 = p.getFirst().floatValue() * this.cellW;
            float y3 = p.getSecond().floatValue() * this.cellH;
            if (i4 == 0) {
                this.paint.setColor(this.shieldTimer > 0 ? this.headShieldColor : this.headNormalColor);
                canvas2.drawRoundRect(x3 + f, y3 + f, (x3 + this.cellW) - f, (y3 + this.cellH) - f, 12.0f, 12.0f, this.paint);
                this.paint.setColor(this.eyeColor);
                float eyeOffsetX = this.direction.getFirst().floatValue() * 6.0f;
                float eyeOffsetY = this.direction.getSecond().floatValue() * 6.0f;
                canvas2.drawCircle(x3 + (this.cellW / f) + eyeOffsetX, y3 + (this.cellH / f) + eyeOffsetY, 5.0f, this.paint);
                if (this.shieldTimer > 0) {
                    this.paint.setStyle(Paint.Style.STROKE);
                    this.paint.setStrokeWidth(3.0f);
                    this.paint.setColor(this.headShieldColor);
                    this.paint.setAlpha(RangesKt.coerceIn(((int) (Math.sin(this.frameCounter * 0.2d) * 100)) + 150, 0, 255));
                    canvas2.drawRoundRect(x3 - f, y3 - f, x3 + this.cellW + f, y3 + this.cellH + f, 14.0f, 14.0f, this.paint);
                    this.paint.setAlpha(255);
                    this.paint.setStyle(Paint.Style.FILL);
                }
            } else {
                this.paint.setColor(this.bodyColor);
                this.paint.setAlpha(255 - RangesKt.coerceAtMost(i4 * 8, 160));
                canvas.drawRoundRect(x3 + 3.0f, y3 + 3.0f, (x3 + this.cellW) - 3.0f, (y3 + this.cellH) - 3.0f, 8.0f, 8.0f, this.paint);
            }
            i4++;
            canvas2 = canvas;
        }
        this.paint.setAlpha(255);
        if (this.comboMultiplier <= 1.0f || this.comboTimer <= 0) {
            canvas3 = canvas;
        } else {
            float barW = getWidth() * 0.6f;
            float barX = (getWidth() - barW) / f;
            this.paint.setColor(this.comboBarBgColor);
            canvas.drawRoundRect(barX, 20.0f, barX + barW, 20.0f + 10.0f, 5.0f, 5.0f, this.paint);
            this.paint.setColor(this.comboBarFgColor);
            float fill = this.comboTimer / 18.0f;
            canvas3 = canvas;
            canvas3.drawRoundRect(barX, 20.0f, barX + (barW * fill), 20.0f + 10.0f, 5.0f, 5.0f, this.paint);
            this.textPaint.setColor(this.comboTextColor);
            this.textPaint.setTextSize(32.0f);
            this.textPaint.setAlpha(255);
            canvas3.drawText("COMBO x" + this.comboMultiplier, getWidth() / f, 40.0f + 20.0f, this.textPaint);
        }
        for (Floater f3 : this.floaters) {
            this.textPaint.setColor(f3.getColor());
            this.textPaint.setAlpha(f3.getAlpha());
            this.textPaint.setTextSize(26.0f);
            canvas3.save();
            canvas3.scale(f3.getScale(), f3.getScale(), f3.getX(), f3.getY());
            canvas3.drawText(f3.getText(), f3.getX(), f3.getY(), this.textPaint);
            canvas3.restore();
        }
        if (this.statusMessageAlpha > 0) {
            this.textPaint.setColor(this.statusTextColor);
            this.textPaint.setAlpha(this.statusMessageAlpha);
            this.textPaint.setTextSize(42.0f);
            canvas3.drawText(this.statusMessage, getWidth() / f, getHeight() / 3.0f, this.textPaint);
        }
    }
}
