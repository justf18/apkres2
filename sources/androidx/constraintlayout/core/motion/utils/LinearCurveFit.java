package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes5.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;

    /* renamed from: mT */
    private double[] f185mT;
    private double mTotalLength;

    /* renamed from: mY */
    private double[][] f186mY;

    public LinearCurveFit(double[] time, double[][] y) {
        int dim;
        double px;
        this.mTotalLength = Double.NaN;
        int length = time.length;
        char c = 0;
        int dim2 = y[0].length;
        this.mSlopeTemp = new double[dim2];
        this.f185mT = time;
        this.f186mY = y;
        if (dim2 > 2) {
            double sum = 0.0d;
            double lastx = 0.0d;
            double lasty = 0.0d;
            int i = 0;
            while (i < time.length) {
                double px2 = y[i][c];
                double py = y[i][c];
                if (i <= 0) {
                    dim = dim2;
                    px = px2;
                } else {
                    dim = dim2;
                    px = px2;
                    sum += Math.hypot(px2 - lastx, py - lasty);
                }
                lastx = px;
                lasty = py;
                i++;
                dim2 = dim;
                c = 0;
            }
            this.mTotalLength = 0.0d;
        }
    }

    private double getLength2D(double t) {
        double d;
        int i;
        LinearCurveFit linearCurveFit = this;
        double d2 = 0.0d;
        if (Double.isNaN(linearCurveFit.mTotalLength)) {
            return 0.0d;
        }
        int n = linearCurveFit.f185mT.length;
        int n2 = 0;
        if (t <= linearCurveFit.f185mT[0]) {
            return 0.0d;
        }
        if (t >= linearCurveFit.f185mT[n - 1]) {
            return linearCurveFit.mTotalLength;
        }
        double sum = 0.0d;
        double last_x = 0.0d;
        double last_y = 0.0d;
        int i2 = 0;
        while (i2 < n - 1) {
            double px = linearCurveFit.f186mY[i2][n2];
            double py = linearCurveFit.f186mY[i2][1];
            if (i2 <= 0) {
                d = d2;
                i = n2;
            } else {
                d = d2;
                i = n2;
                sum += Math.hypot(px - last_x, py - last_y);
            }
            last_x = px;
            last_y = py;
            if (t == linearCurveFit.f185mT[i2]) {
                return sum;
            }
            if (t >= linearCurveFit.f185mT[i2 + 1]) {
                i2++;
                linearCurveFit = this;
                n2 = i;
                d2 = d;
            } else {
                double h = linearCurveFit.f185mT[i2 + 1] - linearCurveFit.f185mT[i2];
                double x = (t - linearCurveFit.f185mT[i2]) / h;
                double x1 = linearCurveFit.f186mY[i2][i];
                double x2 = linearCurveFit.f186mY[i2 + 1][i];
                double y1 = linearCurveFit.f186mY[i2][1];
                double y2 = linearCurveFit.f186mY[i2 + 1][1];
                return sum + Math.hypot(py - (((1.0d - x) * y1) + (y2 * x)), px - (((1.0d - x) * x1) + (x2 * x)));
            }
        }
        return d2;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double t, double[] v) {
        int n = this.f185mT.length;
        int dim = this.f186mY[0].length;
        if (this.mExtrapolate) {
            if (t <= this.f185mT[0]) {
                getSlope(this.f185mT[0], this.mSlopeTemp);
                for (int j = 0; j < dim; j++) {
                    v[j] = this.f186mY[0][j] + ((t - this.f185mT[0]) * this.mSlopeTemp[j]);
                }
                return;
            }
            if (t >= this.f185mT[n - 1]) {
                getSlope(this.f185mT[n - 1], this.mSlopeTemp);
                for (int j2 = 0; j2 < dim; j2++) {
                    v[j2] = this.f186mY[n - 1][j2] + ((t - this.f185mT[n - 1]) * this.mSlopeTemp[j2]);
                }
                return;
            }
        } else {
            if (t <= this.f185mT[0]) {
                for (int j3 = 0; j3 < dim; j3++) {
                    v[j3] = this.f186mY[0][j3];
                }
                return;
            }
            if (t >= this.f185mT[n - 1]) {
                for (int j4 = 0; j4 < dim; j4++) {
                    v[j4] = this.f186mY[n - 1][j4];
                }
                return;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (t == this.f185mT[i]) {
                for (int j5 = 0; j5 < dim; j5++) {
                    v[j5] = this.f186mY[i][j5];
                }
            }
            if (t < this.f185mT[i + 1]) {
                double h = this.f185mT[i + 1] - this.f185mT[i];
                double x = (t - this.f185mT[i]) / h;
                for (int j6 = 0; j6 < dim; j6++) {
                    double y1 = this.f186mY[i][j6];
                    double y2 = this.f186mY[i + 1][j6];
                    v[j6] = ((1.0d - x) * y1) + (y2 * x);
                }
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double t, float[] v) {
        int n = this.f185mT.length;
        int dim = this.f186mY[0].length;
        if (this.mExtrapolate) {
            if (t <= this.f185mT[0]) {
                getSlope(this.f185mT[0], this.mSlopeTemp);
                for (int j = 0; j < dim; j++) {
                    v[j] = (float) (this.f186mY[0][j] + ((t - this.f185mT[0]) * this.mSlopeTemp[j]));
                }
                return;
            }
            if (t >= this.f185mT[n - 1]) {
                getSlope(this.f185mT[n - 1], this.mSlopeTemp);
                for (int j2 = 0; j2 < dim; j2++) {
                    v[j2] = (float) (this.f186mY[n - 1][j2] + ((t - this.f185mT[n - 1]) * this.mSlopeTemp[j2]));
                }
                return;
            }
        } else {
            if (t <= this.f185mT[0]) {
                for (int j3 = 0; j3 < dim; j3++) {
                    v[j3] = (float) this.f186mY[0][j3];
                }
                return;
            }
            if (t >= this.f185mT[n - 1]) {
                for (int j4 = 0; j4 < dim; j4++) {
                    v[j4] = (float) this.f186mY[n - 1][j4];
                }
                return;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (t == this.f185mT[i]) {
                for (int j5 = 0; j5 < dim; j5++) {
                    v[j5] = (float) this.f186mY[i][j5];
                }
            }
            if (t < this.f185mT[i + 1]) {
                double h = this.f185mT[i + 1] - this.f185mT[i];
                double x = (t - this.f185mT[i]) / h;
                for (int j6 = 0; j6 < dim; j6++) {
                    double y1 = this.f186mY[i][j6];
                    double y2 = this.f186mY[i + 1][j6];
                    v[j6] = (float) (((1.0d - x) * y1) + (y2 * x));
                }
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double t, int j) {
        int n = this.f185mT.length;
        if (this.mExtrapolate) {
            if (t <= this.f185mT[0]) {
                return this.f186mY[0][j] + ((t - this.f185mT[0]) * getSlope(this.f185mT[0], j));
            }
            if (t >= this.f185mT[n - 1]) {
                return this.f186mY[n - 1][j] + ((t - this.f185mT[n - 1]) * getSlope(this.f185mT[n - 1], j));
            }
        } else {
            if (t <= this.f185mT[0]) {
                return this.f186mY[0][j];
            }
            if (t >= this.f185mT[n - 1]) {
                return this.f186mY[n - 1][j];
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (t == this.f185mT[i]) {
                return this.f186mY[i][j];
            }
            if (t < this.f185mT[i + 1]) {
                double h = this.f185mT[i + 1] - this.f185mT[i];
                double x = (t - this.f185mT[i]) / h;
                double y1 = this.f186mY[i][j];
                double y2 = this.f186mY[i + 1][j];
                return ((1.0d - x) * y1) + (y2 * x);
            }
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double t, double[] v) {
        double t2;
        int n = this.f185mT.length;
        int dim = this.f186mY[0].length;
        if (t <= this.f185mT[0]) {
            t2 = this.f185mT[0];
        } else if (t < this.f185mT[n - 1]) {
            t2 = t;
        } else {
            t2 = this.f185mT[n - 1];
        }
        for (int i = 0; i < n - 1; i++) {
            if (t2 <= this.f185mT[i + 1]) {
                double h = this.f185mT[i + 1] - this.f185mT[i];
                double d = (t2 - this.f185mT[i]) / h;
                for (int j = 0; j < dim; j++) {
                    double y1 = this.f186mY[i][j];
                    double y2 = this.f186mY[i + 1][j];
                    v[j] = (y2 - y1) / h;
                }
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double t, int j) {
        double t2;
        int n = this.f185mT.length;
        if (t < this.f185mT[0]) {
            t2 = this.f185mT[0];
        } else if (t < this.f185mT[n - 1]) {
            t2 = t;
        } else {
            t2 = this.f185mT[n - 1];
        }
        for (int i = 0; i < n - 1; i++) {
            if (t2 <= this.f185mT[i + 1]) {
                double h = this.f185mT[i + 1] - this.f185mT[i];
                double d = (t2 - this.f185mT[i]) / h;
                double y1 = this.f186mY[i][j];
                double y2 = this.f186mY[i + 1][j];
                return (y2 - y1) / h;
            }
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.f185mT;
    }
}
