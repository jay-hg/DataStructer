package search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraysIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> ans = new HashSet<>();
        Arrays.sort(nums1);
        for (Integer num : nums2) {
            if (find(num, nums1, 0, nums1.length)) {
                ans.add(num);
            }
        }
        int[] ret = new int[ans.size()];
        int i=0;
        for (Integer e : ans) {
            ret[i] = e;
            i++;
        }

        return ret;
    }

    private boolean find(int num, int[] nums, int start, int end) {
        if (start == nums.length) {
            return false;
        }
        if (start > end) {
            return false;
        }
        int mid = (start+end)/2;
        if (nums[mid] == num) {
            return true;
        } else if (num < nums[mid]) {
            return find(num, nums, start, mid - 1);
        } else {
            return find(num, nums, start + 1, end);
        }
    }
}
