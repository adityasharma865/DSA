import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            long curr = nums[i];

            // Find smallest value >= curr - valueDiff
            Long candidate = set.ceiling(curr - valueDiff);

            if (candidate != null && candidate <= curr + valueDiff) {
                return true;
            }

            set.add(curr);

            // Maintain window of size indexDiff
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}