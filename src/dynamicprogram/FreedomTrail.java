package dynamicprogram;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        //初始化
        int ret = 0;
        char[] keys = key.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            if (map.get(keys[i]) == null) {
                map.put(keys[i], new LinkedList<>());
            }
            map.get(keys[i]).add(i);
        }
        Map<Character, Map<Integer, Integer>> idxResult = new HashMap<>();
        char[] ringChar = ring.toCharArray();
        for (int i = 0; i < ringChar.length; i++) {
            if (idxResult.get(ringChar[i]) == null) {
                idxResult.put(ringChar[i], new HashMap<>());
            }
            idxResult.get(ringChar[i]).put(i, 0);
        }
        int ringLen = ring.length();

        for (int keyIdx = 0; keyIdx < keys.length; keyIdx++) {
            char prevChar = keyIdx==0? ringChar[0] : keys[keyIdx - 1];
            char curChar = keys[keyIdx];

            //ring中每一个出现curChar的位置计算最小步数
            List<Integer> curIdxs = map.get(curChar);
            Map<Integer, Integer> resultMap = idxResult.get(curChar);
            Map<Integer, Integer> prevResultMap = idxResult.get(prevChar);
            if (keyIdx == 0) {
                prevResultMap = new HashMap<>();
                prevResultMap.put(0, 0);
            }
            int roundMin = Integer.MAX_VALUE;
            for (Map.Entry<Integer,Integer> e:resultMap.entrySet()) {
                //计算上个位置到当前位置的累计最小步数
                int min = distanceFromPrevToCur(prevResultMap, e.getKey(), ringLen);
                e.setValue(min);

                roundMin = Math.min(roundMin, min);
            }
            ret = roundMin;
        }
        return ret+key.length();
    }

    private int distanceFromPrevToCur(Map<Integer, Integer> prevChar, Integer curIdx, int ringLen) {
        if(prevChar == null) return 0;
        int min = Integer.MAX_VALUE;
        //ring.length
        for (Map.Entry<Integer,Integer> e : prevChar.entrySet()) {
            //顺时针旋转or逆时针旋转
            int temp = Math.min(Math.abs(e.getKey() - curIdx), ringLen-Math.abs(e.getKey()-curIdx));
            min = Math.min(min, temp+e.getValue());
        }
        return min;
    }

    public static void main(String[] args) {
        FreedomTrail ft = new FreedomTrail();
        System.out.println(ft.findRotateSteps("pqwcx","cpqwx"));
    }
}
