package vector;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums.length < 1) {
            return 1;
        }
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > nums.length) {
                continue;
            }
            temp[nums[i]-1] = nums[i];
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i]-1 != i) {
                return i+1;
            }
        }
        return temp.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive fms = new FirstMissingPositive();
        int ans = fms.firstMissingPositive(new int[]{1});
        System.out.println(ans);
    }
}
