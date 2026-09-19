class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        // Power of 2
        if ((n & (n - 1)) != 0) {
            return false;
        }

        // Power of 4
        return (n - 1) % 3 == 0;
    }
}