class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;

        if (n < 2) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) {
            return 0;
        }

        // Minimum possible gap
        int gap = (max - min + n - 2) / (n - 1);

        int bucketCount = (max - min) / gap + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] used = new boolean[bucketCount];

        // Put elements into buckets
        for (int num : nums) {
            int index = (num - min) / gap;

            if (!used[index]) {
                bucketMin[index] = num;
                bucketMax[index] = num;
                used[index] = true;
            } else {
                bucketMin[index] = Math.min(bucketMin[index], num);
                bucketMax[index] = Math.max(bucketMax[index], num);
            }
        }

        // Find maximum gap between buckets
        int ans = 0;
        int previousMax = min;

        for (int i = 0; i < bucketCount; i++) {
            if (!used[i]) {
                continue;
            }

            ans = Math.max(ans, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }

        return ans;
    }
}