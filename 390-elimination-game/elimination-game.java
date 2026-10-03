class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;

        while (n > 1) {
            // If eliminating from left,
            // head always moves.
            // If eliminating from right,
            // head moves only when n is odd.
            if (left || n % 2 == 1) {
                head += step;
            }

            n /= 2;
            step *= 2;
            left = !left;
        }

        return head;
    }
}