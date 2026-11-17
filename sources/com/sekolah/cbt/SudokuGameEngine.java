package com.sekolah.cbt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SudokuGameEngine.kt */
@Metadata(m164d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\"\u001a\u00020\u0012H\u0002J\u000e\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0007J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0014J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0006\u0010,\u001a\u00020\u0012J\u0006\u0010-\u001a\u00020\u0012R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, m165d2 = {"Lcom/sekolah/cbt/SudokuGameEngine;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "grid", "", "", "[[I", "isFixed", "", "[[Z", "onGameOver", "Lkotlin/Function0;", "", "getOnGameOver", "()Lkotlin/jvm/functions/Function0;", "setOnGameOver", "(Lkotlin/jvm/functions/Function0;)V", "onScoreUpdated", "Lkotlin/Function1;", "getOnScoreUpdated", "()Lkotlin/jvm/functions/Function1;", "setOnScoreUpdated", "(Lkotlin/jvm/functions/Function1;)V", "paint", "Landroid/graphics/Paint;", "sampleBoard", "selectedCol", "selectedRow", "checkWinCondition", "inputNumber", "number", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "resetGame", "startGame", "app_debug"}, m166k = 1, m167mv = {1, 9, 0}, m169xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class SudokuGameEngine extends View {
    public static final int $stable = 8;
    private final int[][] grid;
    private final boolean[][] isFixed;
    private Function0<Unit> onGameOver;
    private Function1<? super Integer, Unit> onScoreUpdated;
    private final Paint paint;
    private final int[][] sampleBoard;
    private int selectedCol;
    private int selectedRow;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SudokuGameEngine(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SudokuGameEngine(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SudokuGameEngine(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SudokuGameEngine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        int[][] iArr = new int[9][];
        for (int i = 0; i < 9; i++) {
            int[] iArr2 = new int[9];
            for (int i2 = 0; i2 < 9; i2++) {
                iArr2[i2] = 0;
            }
            iArr[i] = iArr2;
        }
        this.grid = iArr;
        boolean[][] zArr = new boolean[9][];
        for (int i3 = 0; i3 < 9; i3++) {
            boolean[] zArr2 = new boolean[9];
            for (int i4 = 0; i4 < 9; i4++) {
                zArr2[i4] = false;
            }
            zArr[i3] = zArr2;
        }
        this.isFixed = zArr;
        this.selectedRow = -1;
        this.selectedCol = -1;
        this.paint = new Paint(1);
        this.sampleBoard = new int[][]{new int[]{5, 3, 0, 0, 7, 0, 0, 0, 0}, new int[]{6, 0, 0, 1, 9, 5, 0, 0, 0}, new int[]{0, 9, 8, 0, 0, 0, 0, 6, 0}, new int[]{8, 0, 0, 0, 6, 0, 0, 0, 3}, new int[]{4, 0, 0, 8, 0, 3, 0, 0, 1}, new int[]{7, 0, 0, 0, 2, 0, 0, 0, 6}, new int[]{0, 6, 0, 0, 0, 0, 2, 8, 0}, new int[]{0, 0, 0, 4, 1, 9, 0, 0, 5}, new int[]{0, 0, 0, 0, 8, 0, 0, 7, 9}};
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
    }

    public final void resetGame() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                this.grid[r][c] = this.sampleBoard[r][c];
                this.isFixed[r][c] = this.sampleBoard[r][c] != 0;
            }
        }
        this.selectedRow = -1;
        this.selectedCol = -1;
        invalidate();
    }

    public final void inputNumber(int number) {
        if (this.selectedRow != -1 && this.selectedCol != -1 && !this.isFixed[this.selectedRow][this.selectedCol]) {
            this.grid[this.selectedRow][this.selectedCol] = number;
            invalidate();
            checkWinCondition();
        }
    }

    private final void checkWinCondition() {
        boolean isComplete = true;
        for (int r = 0; r < 9; r++) {
            int c = 0;
            while (true) {
                if (c >= 9) {
                    break;
                }
                if (this.grid[r][c] != 0) {
                    c++;
                } else {
                    isComplete = false;
                    break;
                }
            }
        }
        if (isComplete) {
            Function1<? super Integer, Unit> function1 = this.onScoreUpdated;
            if (function1 != null) {
                function1.invoke(1000);
            }
            Function0<Unit> function0 = this.onGameOver;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 0) {
            float cellW = getWidth() / 9.0f;
            float cellH = getHeight() / 9.0f;
            int c = (int) (event.getX() / cellW);
            int r = (int) (event.getY() / cellH);
            boolean z = false;
            if (r >= 0 && r < 9) {
                if (c >= 0 && c < 9) {
                    z = true;
                }
                if (z) {
                    this.selectedRow = r;
                    this.selectedCol = c;
                    invalidate();
                }
            }
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawColor(-1);
        float cellW = getWidth() / 9.0f;
        float cellH = getHeight() / 9.0f;
        if (this.selectedRow != -1 && this.selectedCol != -1) {
            this.paint.setColor(Color.parseColor("#FEF08A"));
            this.paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(this.selectedCol * cellW, this.selectedRow * cellH, (this.selectedCol + 1) * cellW, (this.selectedRow + 1) * cellH, this.paint);
        }
        this.paint.setStyle(Paint.Style.STROKE);
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                this.paint.setColor(Color.parseColor("#0F172A"));
                this.paint.setStrokeWidth(6.0f);
            } else {
                this.paint.setColor(Color.parseColor("#94A3B8"));
                this.paint.setStrokeWidth(2.0f);
            }
            canvas.drawLine(i * cellW, 0.0f, i * cellW, getHeight(), this.paint);
            canvas.drawLine(0.0f, i * cellH, getWidth(), i * cellH, this.paint);
        }
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setTextSize(0.45f * cellH);
        this.paint.setFakeBoldText(true);
        this.paint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
        float baselineOffset = (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int value = this.grid[r][c];
                if (value != 0) {
                    this.paint.setColor(this.isFixed[r][c] ? Color.parseColor("#0F172A") : Color.parseColor("#0284C7"));
                    float x = (c * cellW) + (cellW / 2.0f);
                    float y = ((r * cellH) + (cellH / 2.0f)) - baselineOffset;
                    canvas.drawText(String.valueOf(value), x, y, this.paint);
                }
            }
        }
    }
}
