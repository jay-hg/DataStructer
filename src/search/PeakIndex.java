package search;

public class PeakIndex {
    public int peakIndexInMountainArray(int[] A) {
        return findFromArray(A, 0, A.length);
    }

    private int findFromArray(int[] a, int start, int end) {
        int mid = (start + end)/2;

        if (a[mid] < a[mid - 1]) {
            return findFromArray(a,start,mid);
        } else if (a[mid] < a[mid + 1]) {
            return findFromArray(a, mid, end);
        } else {
            return mid;
        }
    }
}
