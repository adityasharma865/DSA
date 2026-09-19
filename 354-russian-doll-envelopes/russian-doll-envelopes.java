import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        // Sort:
        // 1. Width ascending
        // 2. Height descending when widths are equal
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // Find LIS on heights
        int[] dp = new int[envelopes.length];
        int size = 0;

        for (int[] envelope : envelopes) {
            int height = envelope[1];

            int left = 0;
            int right = size;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (dp[mid] < height) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            dp[left] = height;

            if (left == size) {
                size++;
            }
        }

        return size;
    }
}