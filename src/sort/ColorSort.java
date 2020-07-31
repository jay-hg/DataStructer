package sort;

public class ColorSort {
    public void sortColors(int[] nums) {
        int left = 0;
        int cur = 0;
        int right = nums.length-1;

        while (cur <= right) {
            if (nums[cur] == 1) {
                cur ++;
                continue;
            } else if (nums[cur] == 0) {
                swap(nums, left, cur);
                left++;
                cur++;
            } else {
                swap(nums, right, cur);
                right --;
            }
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
