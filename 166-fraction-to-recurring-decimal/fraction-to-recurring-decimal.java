class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Check negative result
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert to long to avoid integer overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        result.append(num / den);

        long remainder = num % den;

        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        // Store remainder -> position
        java.util.HashMap<Long, Integer> map = new java.util.HashMap<>();

        while (remainder != 0) {

            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());

            remainder *= 10;

            result.append(remainder / den);

            remainder %= den;
        }

        return result.toString();
    }
}