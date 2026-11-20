
class Solution {

    public boolean isAdditiveNumber(String num) {

        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {

            // First number cannot have leading zeros
            if (num.charAt(0) == '0' && i > 1) {
                break;
            }

            for (int j = i + 1; j < n; j++) {

                int len = j - i;

                // Third number must have enough remaining space
                if (Math.max(i, len) > n - j) {
                    break;
                }

                // Second number cannot have leading zeros
                if (num.charAt(i) == '0' && len > 1) {
                    break;
                }

                if (check(num, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(String num, int start,
                          int mid, int end) {

        String a = num.substring(start, mid);
        String b = num.substring(mid, end);

        while (end < num.length()) {

            String sum = addStrings(a, b);

            if (!num.startsWith(sum, end)) {
                return false;
            }

            end += sum.length();

            a = b;
            b = sum;
        }

        return true;
    }

    // Add two numbers represented as strings
    private String addStrings(String a, String b) {

        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }
}
