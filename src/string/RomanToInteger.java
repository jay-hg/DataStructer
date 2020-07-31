package string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        char[] chs = s.toCharArray();
        int ans = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = chs[i];
            int num = map.get(c);
            if (num > last) {
                ans -= 2*last;
            }
            ans += num;
            last = num;
        }
        return ans;
    }
}
