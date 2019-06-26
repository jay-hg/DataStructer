package sort;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeRange {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        LinkedList<int[]> mergeList = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (mergeList.isEmpty() || intervals[i][0] > mergeList.getLast()[1]) {
                mergeList.add(intervals[i]);
            } else {
                //合并
                mergeList.getLast()[1] = Math.max(mergeList.getLast()[1], intervals[i][1]);
            }
        }

        /*int[][] ret = new int[mergeList.size()][2];
        int i = 0;
        for (int[] e : mergeList) {
            ret[i][0] = e[0];
            ret[i][1] = e[1];
            i++;
        }*/
        return mergeList.toArray(new int[0][]);
    }
}
