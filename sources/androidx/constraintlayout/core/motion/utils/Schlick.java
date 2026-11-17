package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes5.dex */
public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double eps;

    /* renamed from: mS */
    double f189mS;

    /* renamed from: mT */
    double f190mT;

    Schlick(String configString) {
        this.str = configString;
        int start = configString.indexOf(40);
        int off1 = configString.indexOf(44, start);
        this.f189mS = Double.parseDouble(configString.substring(start + 1, off1).trim());
        int off2 = configString.indexOf(44, off1 + 1);
        this.f190mT = Double.parseDouble(configString.substring(off1 + 1, off2).trim());
    }

    private double func(double x) {
        if (x < this.f190mT) {
            return (this.f190mT * x) / ((this.f189mS * (this.f190mT - x)) + x);
        }
        return ((1.0d - this.f190mT) * (x - 1.0d)) / ((1.0d - x) - (this.f189mS * (this.f190mT - x)));
    }

    private double dfunc(double x) {
        if (x < this.f190mT) {
            return ((this.f189mS * this.f190mT) * this.f190mT) / (((this.f189mS * (this.f190mT - x)) + x) * ((this.f189mS * (this.f190mT - x)) + x));
        }
        return ((this.f189mS * (this.f190mT - 1.0d)) * (this.f190mT - 1.0d)) / (((((-this.f189mS) * (this.f190mT - x)) - x) + 1.0d) * ((((-this.f189mS) * (this.f190mT - x)) - x) + 1.0d));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double x) {
        return dfunc(x);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double x) {
        return func(x);
    }
}
