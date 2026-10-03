class Solution {
    public boolean validUtf8(int[] data) {
        int remaining = 0;

        for (int num : data) {
            if (remaining == 0) {

                // 1-byte character: 0xxxxxxx
                if ((num >> 7) == 0) {
                    remaining = 0;
                }
                // 2-byte character: 110xxxxx
                else if ((num >> 5) == 0b110) {
                    remaining = 1;
                }
                // 3-byte character: 1110xxxx
                else if ((num >> 4) == 0b1110) {
                    remaining = 2;
                }
                // 4-byte character: 11110xxx
                else if ((num >> 3) == 0b11110) {
                    remaining = 3;
                }
                else {
                    return false;
                }

            } else {
                // Continuation byte must be 10xxxxxx
                if ((num >> 6) != 0b10) {
                    return false;
                }

                remaining--;
            }
        }

        return remaining == 0;
    }
}