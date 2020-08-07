package wangdao.chapter2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyArrayList {
    private int[] array;
    private int arrayLength;

    public MyArrayList(int[] array) {
        this.array = array;
        this.arrayLength = array.length;
    }

    // question1
    public int deleteMinNum() {
        if (array == null || array.length == 0) {
            System.out.println("顺序表为空");
            return -1;
        }
        int idx = 0;
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < this.arrayLength; i++) {
            if (array[i] < min) {
                min = array[i];
                minIdx = idx;
            }
            idx++;
        }
        array[minIdx] = array[arrayLength - 1];
        arrayLength--;
        return min;
    }

    //question2
    public void reverse() {
        int temp = 0;
        for (int i = 0; i < arrayLength / 2; i++) {
            temp = array[i];
            array[i] = array[arrayLength - i - 1];
            array[arrayLength - i - 1] = temp;
        }
    }

    public void printList() {
        if (array == null) {
            return;
        }

        System.out.print("[");
        for (int i = 0; i < this.arrayLength; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println("]");
    }

    public void deleteAllX(int x) {
        int k = 0;
        for (int i = 0; i < this.arrayLength; i++) {
            if (array[i] == x) {
                k++;
                continue;
            }
            array[i - k] = array[i];
        }
        arrayLength -= k;
    }

    public void deleteAllXByRange(int s, int t) {
        if (array == null || array.length == 0) {
            System.out.println("顺序表为空");
            return;
        }
        if (s >= t) {
            System.out.println("illegal argument s,t");
            return;
        }
        int k = 0;
        for (int i = 0; i < this.arrayLength; i++) {
            if (array[i] >= s && array[i] <= t) {
                k++;
                continue;
            }
            array[i - k] = array[i];
        }
        arrayLength -= k;
    }

    public void deleteDuplicatedXInOrderList() {
        Arrays.sort(this.array);

        int k = 0;
        for (int i = 1; i < this.arrayLength; i++) {
            if (array[i] == array[i - k - 1]) {
                k++;
                continue;
            }
            array[i - k] = array[i];
        }
        arrayLength -= k;
    }

    public static MyArrayList merge(MyArrayList list1, MyArrayList list2) {
        int[] ans = new int[list1.arrayLength + list2.arrayLength];
        int j = 0, k = 0;
        int i = 0;
        while (j < list1.arrayLength && k < list2.arrayLength) {
            if (list1.array[j] < list2.array[k]) {
                ans[i] = list1.array[j];
                j++;
            } else {
                ans[i] = list2.array[k];
                k++;
            }
            i++;
        }

        while (j < list1.arrayLength) {
            ans[i] = list1.array[j];
            i++;
            j++;
        }

        while (k < list2.arrayLength) {
            ans[i] = list2.array[k];
            i++;
            k++;
        }

        MyArrayList retList = new MyArrayList(ans);
        return retList;
    }

    //question 8
    public void reverse(int m, int n) {
        this.reverse();
        int temp = 0;
        for (int i = 0; i < n / 2; i++) {
            temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }

        for (int i = 0; i < m / 2; i++) {
            temp = array[n + i];
            array[n + i] = array[n + m - i - 1];
            array[n + m - i - 1] = temp;
        }
    }

    public void findOrInsert(int x) {
        Arrays.sort(this.array);

        int s = 0, t = this.arrayLength;
        int mid = (s + t) / 2;
        boolean find = false;
        while (s < t) {
            mid = (s + t) / 2;
            if (array[mid] == x) {
                find = true;
                if (mid + 1 < this.arrayLength) {
                    int temp = array[mid + 1];
                    array[mid + 1] = array[mid];
                    array[mid] = temp;
                }
                return;
            } else if (array[mid] > x) {
                t = mid;
            } else {
                s = mid + 1;
            }
        }

        if (!find) {
            int[] newArray = new int[arrayLength + 1];
            for (int i = 0; i < mid; i++) {
                newArray[i] = array[i];
            }
            newArray[mid] = x;
            for (int i = mid; i < arrayLength; i++) {
                newArray[i + 1] = array[i];
            }
            array = newArray;
            arrayLength = array.length;
        }
    }

    public void shift(int p) {
        int[] temp = new int[p];
        for (int i = 0; i < p; i++) {
            temp[i] = array[i];
        }

        for (int i = p; i < arrayLength; i++) {
            array[i - p] = array[i];
        }

        for (int i = 0; i < temp.length; i++) {
            array[i + arrayLength - p] = temp[i];
        }
    }

    public int median(MyArrayList list1, MyArrayList list2) {
        int m1 = 0, m2 = 0;
        int s1 = 0, t1 = list1.arrayLength, s2 = 0, t2 = list2.arrayLength;
        while (s1 != t1 || s2 != t2) {
            m1 = (s1 + t1) / 2;
            m2 = (s2 + t2) / 2;
            if (list1.array[m1] == list2.array[m2]) {
                return list1.array[m1];
            } else if (list1.array[m1] < list2.array[m2]) {
                if ((s1 + t1) % 2 == 0) {
                    s1 = m1;
                    t2 = m2;
                } else {
                    s1 = m1 + 1;
                    t2 = m2;
                }
            } else {
                if ((s2 + t2) % 2 == 0) {
                    s2 = m2;
                    t1 = m1;
                } else {
                    s2 = m2 + 1;
                    t1 = m1;
                }
            }
        }

        return list1.array[s1] < list2.array[s2] ? list1.array[s1] : list2.array[s2];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 > length2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            length1 = nums1.length;
            length2 = nums2.length;
        }


        //在nums1的[0,length1]内找恰当的分割线
        //使得nums1[mid1-1] <= nums2[mid2] && nums2[mid2-1] <= nums1[mid1]
        int left = 0, right = length1;
        while (left < right) {
            int mid1 = (left + right + 1) / 2;
            int mid2 = (length1 + length2 + 1) / 2 - mid1;

            if (nums1[mid1 - 1] > nums2[mid2]) {
                //下一轮搜索区间[left,mid1-1]
                right = mid1 - 1;
            } else {
                //下一轮搜索区间[mid1,right]
                left = mid1;
            }
        }

        int mid1 = left;
        int mid2 = (length1 + length2 + 1) / 2 - left;
        int nums1LeftMax = (mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1]);
        int nums2LeftMax = (mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1]);
        int nums1RightMin = (mid1 == length1 ? Integer.MAX_VALUE : nums1[mid1]);
        int nums2RightMin = (mid2 == length2 ? Integer.MAX_VALUE : nums2[mid2]);

        if ((length1 + length2) % 2 == 1) {
            //总共奇数个节点，取中间那个数
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            //总共偶数个点，取平均值
            return ((double)(Math.min(nums1RightMin, nums2RightMin) + Math.max(nums1LeftMax, nums2LeftMax))) / 2;
        }
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer count = countMap.get(nums[i]);
            if (count == null) {
                count = 0;
            }
            count ++;
            countMap.put(nums[i], count);
        }
        for (Map.Entry<Integer, Integer> e : countMap.entrySet()) {
            if (e.getValue() > nums.length / 2) {
                return e.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(new int[]{3,2});


//        int min = list.deleteMinNum();
//        System.out.println(min);

//        list.reverse();

//        list.deleteAllX(6);

//        list.deleteAllXByRange(3,8);

//        list.deleteDuplicatedXInOrderList();

        /*MyArrayList list1 = new MyArrayList(new int[]{1, 3, 5, 7, 9});
        MyArrayList list2 = new MyArrayList(new int[]{2, 4, 6, 8, 10});
        MyArrayList ansList = merge(list1, list2);
        ansList.printList();*/

//        list.reverse(3,5);

//        list.findOrInsert(5);

//        list.shift(3);

        /*MyArrayList list1 = new MyArrayList(new int[]{1, 3, 5, 7, 9});
        MyArrayList list2 = new MyArrayList(new int[]{2, 4, 6, 8, 10});
        int mid = list.median(list1, list2);
        System.out.println(mid);*/

        System.out.println(list.majorityElement(list.array));
        list.printList();
    }
}
