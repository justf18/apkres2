package com.sekolah.cbt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* compiled from: TetrisGameEngine.kt */
@Metadata(m164d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u001b\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0001\\B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010?\u001a\u00020,H\u0002J8\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020<2\u0006\u0010D\u001a\u00020<2\u0006\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020<2\u0006\u0010G\u001a\u00020\u0007H\u0002J\b\u0010H\u001a\u00020\u0007H\u0002J\u0006\u0010I\u001a\u00020,J+\u0010J\u001a\u00020#2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020,H\u0002J\u0006\u0010P\u001a\u00020,J\u0006\u0010Q\u001a\u00020,J\u0006\u0010R\u001a\u00020,J\b\u0010S\u001a\u00020,H\u0014J\u0010\u0010T\u001a\u00020,2\u0006\u0010A\u001a\u00020BH\u0014J\u0010\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020WH\u0016J\u0006\u0010X\u001a\u00020,J\u0006\u0010Y\u001a\u00020,J\b\u0010Z\u001a\u00020,H\u0002J\u0006\u0010[\u001a\u00020,R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R7\u00101\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020,\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, m165d2 = {"Lcom/sekolah/cbt/TetrisGameEngine;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "borderPaint", "Landroid/graphics/Paint;", "cellPaint", "cols", "comboText", "", "comboTextAlpha", "currentColor", "currentPiece", "", "", "[[I", "currentPieceIndex", "currentX", "currentY", "dropInterval", "", "gameRunnable", "com/sekolah/cbt/TetrisGameEngine$gameRunnable$1", "Lcom/sekolah/cbt/TetrisGameEngine$gameRunnable$1;", "ghostPaint", "grid", "handler", "Landroid/os/Handler;", "hudPaint", "isGameRunning", "", "lastTapTime", "level", "linesClearedTotal", "nextColor", "nextPiece", "nextPieceIndex", "onGameOver", "Lkotlin/Function0;", "", "getOnGameOver", "()Lkotlin/jvm/functions/Function0;", "setOnGameOver", "(Lkotlin/jvm/functions/Function0;)V", "onScoreUpdated", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "score", "getOnScoreUpdated", "()Lkotlin/jvm/functions/Function1;", "setOnScoreUpdated", "(Lkotlin/jvm/functions/Function1;)V", "rows", "startTouchX", "", "startTouchY", "textEffectPaint", "clearLines", "drawBlock", "canvas", "Landroid/graphics/Canvas;", "x", "y", "w", "h", TypedValues.Custom.S_COLOR, "getGhostY", "hardDrop", "isValidMove", "piece", "offsetX", "offsetY", "([[III)Z", "lockPiece", "moveDown", "moveLeft", "moveRight", "onDetachedFromWindow", "onDraw", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "resetGame", "rotate", "spawnPiece", "startGame", "Companion", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class TetrisGameEngine extends View {
    private final Paint borderPaint;
    private final Paint cellPaint;
    private final int cols;
    private String comboText;
    private int comboTextAlpha;
    private int currentColor;
    private int[][] currentPiece;
    private int currentPieceIndex;
    private int currentX;
    private int currentY;
    private long dropInterval;
    private final TetrisGameEngine$gameRunnable$1 gameRunnable;
    private final Paint ghostPaint;
    private final int[][] grid;
    private final Handler handler;
    private final Paint hudPaint;
    private boolean isGameRunning;
    private long lastTapTime;
    private int level;
    private int linesClearedTotal;
    private int nextColor;
    private int[][] nextPiece;
    private int nextPieceIndex;
    private Function0<Unit> onGameOver;
    private Function1<? super Integer, Unit> onScoreUpdated;
    private final int rows;
    private int score;
    private float startTouchX;
    private float startTouchY;
    private final Paint textEffectPaint;
    public static final int $stable = 8;
    private static final List<int[][]> pieces = CollectionsKt.listOf((Object[]) new int[][][]{new int[][]{new int[]{1, 1, 1, 1}}, new int[][]{new int[]{1, 1}, new int[]{1, 1}}, new int[][]{new int[]{0, 1, 0}, new int[]{1, 1, 1}}, new int[][]{new int[]{1, 0, 0}, new int[]{1, 1, 1}}, new int[][]{new int[]{0, 0, 1}, new int[]{1, 1, 1}}, new int[][]{new int[]{0, 1, 1}, new int[]{1, 1, 0}}, new int[][]{new int[]{1, 1, 0}, new int[]{0, 1, 1}}});
    private static final List<Integer> pieceColors = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#06B6D4")), Integer.valueOf(Color.parseColor("#EAB308")), Integer.valueOf(Color.parseColor("#A855F7")), Integer.valueOf(Color.parseColor("#F97316")), Integer.valueOf(Color.parseColor("#3B82F6")), Integer.valueOf(Color.parseColor("#22C55E")), Integer.valueOf(Color.parseColor("#EF4444"))});

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TetrisGameEngine(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TetrisGameEngine(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TetrisGameEngine(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v24, types: [com.sekolah.cbt.TetrisGameEngine$gameRunnable$1] */
    public TetrisGameEngine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.cols = 10;
        this.rows = 20;
        int i = this.rows;
        int[][] iArr = new int[i][];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.cols;
            int[] iArr2 = new int[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                iArr2[i4] = 0;
            }
            iArr[i2] = iArr2;
        }
        this.grid = iArr;
        this.currentX = 3;
        this.currentPiece = pieces.get(0);
        this.currentColor = pieceColors.get(0).intValue();
        this.nextPieceIndex = Random.INSTANCE.nextInt(pieces.size());
        this.nextPiece = pieces.get(this.nextPieceIndex);
        this.nextColor = pieceColors.get(this.nextPieceIndex).intValue();
        this.level = 1;
        this.dropInterval = 500L;
        this.comboText = "";
        this.cellPaint = new Paint(1);
        Paint $this$borderPaint_u24lambda_u240 = new Paint(1);
        $this$borderPaint_u24lambda_u240.setStyle(Paint.Style.STROKE);
        $this$borderPaint_u24lambda_u240.setStrokeWidth(2.0f);
        $this$borderPaint_u24lambda_u240.setColor(Color.parseColor("#334155"));
        this.borderPaint = $this$borderPaint_u24lambda_u240;
        Paint $this$ghostPaint_u24lambda_u241 = new Paint(1);
        $this$ghostPaint_u24lambda_u241.setStyle(Paint.Style.STROKE);
        $this$ghostPaint_u24lambda_u241.setStrokeWidth(3.0f);
        this.ghostPaint = $this$ghostPaint_u24lambda_u241;
        Paint $this$textEffectPaint_u24lambda_u242 = new Paint(1);
        $this$textEffectPaint_u24lambda_u242.setColor(Color.parseColor("#FACC15"));
        $this$textEffectPaint_u24lambda_u242.setTextSize(50.0f);
        $this$textEffectPaint_u24lambda_u242.setTextAlign(Paint.Align.CENTER);
        $this$textEffectPaint_u24lambda_u242.setTypeface(Typeface.DEFAULT_BOLD);
        this.textEffectPaint = $this$textEffectPaint_u24lambda_u242;
        Paint $this$hudPaint_u24lambda_u243 = new Paint(1);
        $this$hudPaint_u24lambda_u243.setColor(-1);
        $this$hudPaint_u24lambda_u243.setTextSize(20.0f);
        $this$hudPaint_u24lambda_u243.setTextAlign(Paint.Align.LEFT);
        $this$hudPaint_u24lambda_u243.setTypeface(Typeface.DEFAULT_BOLD);
        this.hudPaint = $this$hudPaint_u24lambda_u243;
        this.handler = new Handler(Looper.getMainLooper());
        this.gameRunnable = new Runnable() { // from class: com.sekolah.cbt.TetrisGameEngine$gameRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (this.this$0.isGameRunning) {
                    this.this$0.moveDown();
                    this.this$0.invalidate();
                    this.this$0.handler.postDelayed(this, this.this$0.dropInterval);
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
        int i = this.rows;
        for (int r = 0; r < i; r++) {
            int i2 = this.cols;
            for (int c = 0; c < i2; c++) {
                this.grid[r][c] = 0;
            }
        }
        this.score = 0;
        this.linesClearedTotal = 0;
        this.level = 1;
        this.dropInterval = 500L;
        this.comboTextAlpha = 0;
        this.nextPieceIndex = Random.INSTANCE.nextInt(pieces.size());
        spawnPiece();
        Function1<? super Integer, Unit> function1 = this.onScoreUpdated;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(this.score));
        }
    }

    private final void spawnPiece() {
        this.currentPieceIndex = this.nextPieceIndex;
        this.currentPiece = pieces.get(this.currentPieceIndex);
        this.currentColor = pieceColors.get(this.currentPieceIndex).intValue();
        this.nextPieceIndex = Random.INSTANCE.nextInt(pieces.size());
        this.nextPiece = pieces.get(this.nextPieceIndex);
        this.nextColor = pieceColors.get(this.nextPieceIndex).intValue();
        this.currentX = (this.cols - this.currentPiece[0].length) / 2;
        this.currentY = 0;
        if (!isValidMove(this.currentPiece, this.currentX, this.currentY)) {
            this.isGameRunning = false;
            Function0<Unit> function0 = this.onGameOver;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public final void moveLeft() {
        if (isValidMove(this.currentPiece, this.currentX - 1, this.currentY)) {
            this.currentX--;
            invalidate();
        }
    }

    public final void moveRight() {
        if (isValidMove(this.currentPiece, this.currentX + 1, this.currentY)) {
            this.currentX++;
            invalidate();
        }
    }

    public final void moveDown() {
        if (isValidMove(this.currentPiece, this.currentX, this.currentY + 1)) {
            this.currentY++;
        } else {
            lockPiece();
            clearLines();
            spawnPiece();
        }
        invalidate();
    }

    public final void hardDrop() {
        while (isValidMove(this.currentPiece, this.currentX, this.currentY + 1)) {
            this.currentY++;
            this.score += 2;
        }
        lockPiece();
        clearLines();
        spawnPiece();
        invalidate();
    }

    public final void rotate() {
        int length = this.currentPiece[0].length;
        int[][] rotated = new int[length][];
        for (int i = 0; i < length; i++) {
            rotated[i] = new int[this.currentPiece.length];
        }
        int length2 = this.currentPiece.length;
        for (int r = 0; r < length2; r++) {
            int length3 = this.currentPiece[0].length;
            for (int c = 0; c < length3; c++) {
                rotated[c][(this.currentPiece.length - 1) - r] = this.currentPiece[r][c];
            }
        }
        int r2 = this.currentX;
        if (isValidMove(rotated, r2, this.currentY)) {
            this.currentPiece = rotated;
            invalidate();
        } else if (isValidMove(rotated, this.currentX - 1, this.currentY)) {
            this.currentX--;
            this.currentPiece = rotated;
            invalidate();
        } else if (isValidMove(rotated, this.currentX + 1, this.currentY)) {
            this.currentX++;
            this.currentPiece = rotated;
            invalidate();
        }
    }

    private final boolean isValidMove(int[][] piece, int offsetX, int offsetY) {
        int length = piece.length;
        for (int r = 0; r < length; r++) {
            int length2 = piece[r].length;
            for (int c = 0; c < length2; c++) {
                if (piece[r][c] != 0) {
                    int newX = offsetX + c;
                    int newY = offsetY + r;
                    if (newX < 0 || newX >= this.cols || newY >= this.rows) {
                        return false;
                    }
                    if (newY >= 0 && this.grid[newY][newX] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private final void lockPiece() {
        int length = this.currentPiece.length;
        for (int r = 0; r < length; r++) {
            int length2 = this.currentPiece[r].length;
            for (int c = 0; c < length2; c++) {
                if (this.currentPiece[r][c] != 0 && this.currentY + r >= 0) {
                    this.grid[this.currentY + r][this.currentX + c] = this.currentColor;
                }
            }
        }
    }

    private final void clearLines() {
        int points;
        int i;
        StringBuilder sb;
        String str;
        int[] $this$all$iv;
        int linesCleared = 0;
        int r = this.rows - 1;
        while (r >= 0) {
            int[] $this$all$iv2 = this.grid[r];
            int length = $this$all$iv2.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    int element$iv = $this$all$iv2[i2];
                    int it = element$iv != 0 ? 1 : 0;
                    if (it == 0) {
                        $this$all$iv = null;
                        break;
                    }
                    i2++;
                } else {
                    $this$all$iv = 1;
                    break;
                }
            }
            if ($this$all$iv != null) {
                for (int moveR = r; moveR > 0; moveR--) {
                    int[][] iArr = this.grid;
                    int[] iArr2 = this.grid[moveR - 1];
                    int[] iArrCopyOf = Arrays.copyOf(iArr2, iArr2.length);
                    Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
                    iArr[moveR] = iArrCopyOf;
                }
                int[][] iArr3 = this.grid;
                int i3 = this.cols;
                int[] iArr4 = new int[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    iArr4[i4] = 0;
                }
                iArr3[0] = iArr4;
                linesCleared++;
            } else {
                r--;
            }
        }
        if (linesCleared > 0) {
            switch (linesCleared) {
                case 1:
                    points = 100;
                    break;
                case 2:
                    points = 300;
                    break;
                case 3:
                    points = 500;
                    break;
                case 4:
                    points = 800;
                    break;
                default:
                    points = 1000;
                    break;
            }
            this.score += this.level * points;
            this.linesClearedTotal += linesCleared;
            if (linesCleared == 4) {
                i = this.level * points;
                sb = new StringBuilder();
                str = "TETRIS! +";
            } else {
                i = this.level * points;
                sb = new StringBuilder();
                str = "+";
            }
            this.comboText = sb.append(str).append(i).toString();
            this.comboTextAlpha = 255;
            this.level = (this.linesClearedTotal / 5) + 1;
            this.dropInterval = RangesKt.coerceAtLeast(500 - ((this.level - 1) * 40), 100L);
            Function1<? super Integer, Unit> function1 = this.onScoreUpdated;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(this.score));
            }
        }
    }

    private final int getGhostY() {
        int ghostY = this.currentY;
        while (isValidMove(this.currentPiece, this.currentX, ghostY + 1)) {
            ghostY++;
        }
        return ghostY;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isGameRunning) {
            return super.onTouchEvent(event);
        }
        switch (event.getAction()) {
            case 0:
                this.startTouchX = event.getX();
                this.startTouchY = event.getY();
                long currentTime = System.currentTimeMillis();
                if (currentTime - this.lastTapTime < 250) {
                    hardDrop();
                    this.lastTapTime = 0L;
                    return true;
                }
                this.lastTapTime = currentTime;
                return true;
            case 1:
                float deltaX = event.getX() - this.startTouchX;
                float deltaY = event.getY() - this.startTouchY;
                if (Math.abs(deltaX) < 30.0f && Math.abs(deltaY) < 30.0f) {
                    rotate();
                } else if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    if (deltaX > 40.0f) {
                        moveRight();
                    } else if (deltaX < -40.0f) {
                        moveLeft();
                    }
                } else if (deltaY > 50.0f) {
                    moveDown();
                }
                return true;
            default:
                return true;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int c;
        TetrisGameEngine tetrisGameEngine;
        float cellW;
        float cellH;
        int c2;
        int i;
        float cellW2;
        float cellH2;
        TetrisGameEngine tetrisGameEngine2;
        int c3;
        int r;
        int i2;
        int c4;
        int i3;
        TetrisGameEngine tetrisGameEngine3 = this;
        Canvas canvas2 = canvas;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        super.onDraw(canvas);
        canvas2.drawColor(Color.parseColor("#0F172A"));
        float playW = tetrisGameEngine3.getWidth() - 80.0f;
        float playH = tetrisGameEngine3.getHeight() - 50.0f;
        float cellW3 = playW / tetrisGameEngine3.cols;
        float cellH3 = playH / tetrisGameEngine3.rows;
        float f = 20.0f;
        tetrisGameEngine3.hudPaint.setTextSize(20.0f);
        canvas2.drawText("SKOR " + tetrisGameEngine3.score, 16.0f, 26.0f, tetrisGameEngine3.hudPaint);
        tetrisGameEngine3.hudPaint.setTextSize(16.0f);
        canvas2.drawText("LEVEL " + tetrisGameEngine3.level, 16.0f, 46.0f, tetrisGameEngine3.hudPaint);
        tetrisGameEngine3.hudPaint.setTextSize(14.0f);
        canvas2.drawText("NEXT", playW + 8.0f, 16.0f + 50.0f, tetrisGameEngine3.hudPaint);
        float previewStartX = 8.0f + playW + (((4 - tetrisGameEngine3.nextPiece[0].length) * 14.0f) / 2.0f);
        int r2 = 0;
        int length = tetrisGameEngine3.nextPiece.length;
        while (r2 < length) {
            int c5 = 0;
            int length2 = tetrisGameEngine3.nextPiece[r2].length;
            while (c5 < length2) {
                if (tetrisGameEngine3.nextPiece[r2][c5] != 0) {
                    float px = previewStartX + (c5 * 14.0f);
                    float py = 50.0f + f + (r2 * 14.0f);
                    tetrisGameEngine3.cellPaint.setColor(tetrisGameEngine3.nextColor);
                    float f2 = 1;
                    float f3 = (px + 14.0f) - f2;
                    float f4 = (py + 14.0f) - f2;
                    i2 = length;
                    c4 = c5;
                    r = r2;
                    i3 = length2;
                    canvas2.drawRoundRect(px, py, f3, f4, 3.0f, 3.0f, tetrisGameEngine3.cellPaint);
                } else {
                    r = r2;
                    i2 = length;
                    c4 = c5;
                    i3 = length2;
                }
                c5 = c4 + 1;
                length = i2;
                length2 = i3;
                r2 = r;
                f = 20.0f;
            }
            r2++;
            f = 20.0f;
        }
        canvas2.save();
        canvas2.translate(0.0f, 50.0f);
        int i4 = tetrisGameEngine3.rows;
        int r3 = 0;
        while (r3 < i4) {
            int c6 = 0;
            int i5 = tetrisGameEngine3.cols;
            while (c6 < i5) {
                canvas2.drawRect(c6 * cellW3, r3 * cellH3, (c6 + 1) * cellW3, (r3 + 1) * cellH3, tetrisGameEngine3.borderPaint);
                c6++;
                canvas2 = canvas;
            }
            r3++;
            canvas2 = canvas;
        }
        int i6 = tetrisGameEngine3.rows;
        int r4 = 0;
        while (r4 < i6) {
            int c7 = 0;
            int i7 = tetrisGameEngine3.cols;
            while (c7 < i7) {
                if (tetrisGameEngine3.grid[r4][c7] == 0) {
                    cellW2 = cellW3;
                    cellH2 = cellH3;
                    tetrisGameEngine2 = tetrisGameEngine3;
                    c3 = c7;
                } else {
                    float cellW4 = cellW3;
                    float cellH4 = cellH3;
                    c3 = c7;
                    tetrisGameEngine3.drawBlock(canvas, c7 * cellW3, r4 * cellH3, cellW4, cellH4, tetrisGameEngine3.grid[r4][c7]);
                    tetrisGameEngine2 = tetrisGameEngine3;
                    cellW2 = cellW4;
                    cellH2 = cellH4;
                }
                c7 = c3 + 1;
                tetrisGameEngine3 = tetrisGameEngine2;
                cellW3 = cellW2;
                cellH3 = cellH2;
            }
            r4++;
            cellW3 = cellW3;
            cellH3 = cellH3;
        }
        float cellW5 = cellW3;
        float cellH5 = cellH3;
        TetrisGameEngine tetrisGameEngine4 = tetrisGameEngine3;
        int ghostY = tetrisGameEngine4.getGhostY();
        tetrisGameEngine4.ghostPaint.setColor(tetrisGameEngine4.currentColor);
        tetrisGameEngine4.ghostPaint.setAlpha(100);
        int length3 = tetrisGameEngine4.currentPiece.length;
        for (int r5 = 0; r5 < length3; r5++) {
            int c8 = 0;
            int length4 = tetrisGameEngine4.currentPiece[r5].length;
            while (c8 < length4) {
                if (tetrisGameEngine4.currentPiece[r5][c8] == 0) {
                    c2 = c8;
                    i = length4;
                } else {
                    float drawX = (tetrisGameEngine4.currentX + c8) * cellW5;
                    float drawY = (ghostY + r5) * cellH5;
                    float f5 = 2;
                    i = length4;
                    c2 = c8;
                    canvas.drawRoundRect(drawX + f5, drawY + f5, (drawX + cellW5) - f5, (drawY + cellH5) - f5, 8.0f, 8.0f, tetrisGameEngine4.ghostPaint);
                }
                c8 = c2 + 1;
                length4 = i;
            }
        }
        int length5 = tetrisGameEngine4.currentPiece.length;
        int r6 = 0;
        while (r6 < length5) {
            int c9 = 0;
            int length6 = tetrisGameEngine4.currentPiece[r6].length;
            while (c9 < length6) {
                if (tetrisGameEngine4.currentPiece[r6][c9] == 0) {
                    TetrisGameEngine tetrisGameEngine5 = tetrisGameEngine4;
                    c = c9;
                    tetrisGameEngine = tetrisGameEngine5;
                    cellW = cellW5;
                    cellH = cellH5;
                } else {
                    float drawX2 = (tetrisGameEngine4.currentX + c9) * cellW5;
                    float drawY2 = (tetrisGameEngine4.currentY + r6) * cellH5;
                    int i8 = tetrisGameEngine4.currentColor;
                    TetrisGameEngine tetrisGameEngine6 = tetrisGameEngine4;
                    c = c9;
                    tetrisGameEngine = tetrisGameEngine6;
                    cellW = cellW5;
                    cellH = cellH5;
                    tetrisGameEngine.drawBlock(canvas, drawX2, drawY2, cellW, cellH, i8);
                }
                int i9 = c + 1;
                tetrisGameEngine4 = tetrisGameEngine;
                c9 = i9;
                cellW5 = cellW;
                cellH5 = cellH;
            }
            r6++;
            tetrisGameEngine4 = tetrisGameEngine4;
        }
        TetrisGameEngine tetrisGameEngine7 = tetrisGameEngine4;
        if (tetrisGameEngine7.comboTextAlpha > 0) {
            tetrisGameEngine7.textEffectPaint.setAlpha(tetrisGameEngine7.comboTextAlpha);
            canvas.drawText(tetrisGameEngine7.comboText, playW / 2.0f, playH / 2.0f, tetrisGameEngine7.textEffectPaint);
            tetrisGameEngine7.comboTextAlpha -= 8;
            tetrisGameEngine7.invalidate();
        }
        canvas.restore();
    }

    private final void drawBlock(Canvas canvas, float x, float y, float w, float h, int color) {
        this.cellPaint.setColor(color);
        float f = 2;
        canvas.drawRoundRect(x + f, y + f, (x + w) - f, (y + h) - f, 8.0f, 8.0f, this.cellPaint);
        this.cellPaint.setColor(-1);
        this.cellPaint.setAlpha(80);
        float f2 = 4;
        canvas.drawRoundRect(x + f2, y + f2, (x + w) - f2, y + 10.0f, 4.0f, 4.0f, this.cellPaint);
        this.cellPaint.setAlpha(255);
    }
}
