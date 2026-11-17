package androidx.constraintlayout.core.widgets;

/* loaded from: classes5.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x */
    public int f200x;

    /* renamed from: y */
    public int f201y;

    public void setBounds(int x, int y, int width, int height) {
        this.f200x = x;
        this.f201y = y;
        this.width = width;
        this.height = height;
    }

    void grow(int w, int h) {
        this.f200x -= w;
        this.f201y -= h;
        this.width += w * 2;
        this.height += h * 2;
    }

    boolean intersects(Rectangle bounds) {
        return this.f200x >= bounds.f200x && this.f200x < bounds.f200x + bounds.width && this.f201y >= bounds.f201y && this.f201y < bounds.f201y + bounds.height;
    }

    public boolean contains(int x, int y) {
        return x >= this.f200x && x < this.f200x + this.width && y >= this.f201y && y < this.f201y + this.height;
    }

    public int getCenterX() {
        return (this.f200x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f201y + this.height) / 2;
    }
}
