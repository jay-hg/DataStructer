package other;

public class PowN {
    public double myPow(double x, int n) {
        long ln = n;
        if (n > 0) {
            return qpow(x, n);
        } else if (n < 0) {
            return 1/qpow(x, -ln);
        }
        return 1.0;
    }

    private double qpow(double x, long n) {
        double ret = 1.0;
        while (n > 0) {
            if ((n & 1) > 0) {
                ret = ret * x;
            }
            n >>= 1;
            x *= x;
        }
        return ret;
    }

    public static void main(String[] args) {
        PowN pn = new PowN();
        System.out.println(pn.myPow(2.0, -2147483648));
    }
}
