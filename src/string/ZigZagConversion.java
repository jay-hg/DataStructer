package string;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            StringBuilder sb = new StringBuilder();
            rows[i] = sb;
        }
        char[] strs = s.toCharArray();
        boolean down = true;
        int cur = 0;
        for (int i = 0; i < strs.length; i++) {
            char c = strs[i];
            rows[cur].append(c);
            if (down) {
                cur++;
                if (cur >= numRows) {
                    down = false;
                    cur = cur - 2;
                }
            } else {
                cur--;
                if (cur < 0) {
                    down = true;
                    cur = cur + 2;
                }
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            ret.append(rows[i]);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zzc = new ZigZagConversion();
        System.out.println(zzc.convert("ab", 1));
    }
}
