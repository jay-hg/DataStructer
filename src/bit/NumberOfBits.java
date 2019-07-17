package bit;

public class NumberOfBits {
    /*public int hammingWeight(int n) {
        int a = 1;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += n & a;
            n >>= 1;
        }
        return ans;
    }*/

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum ++;
            n &= (n - 1);
        }
        return sum;
    }
}
