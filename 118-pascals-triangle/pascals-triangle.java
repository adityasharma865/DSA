import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // First element
            row.add(1);

            // Middle elements
            if (i > 0) {
                List<Integer> prev = result.get(i - 1);

                for (int j = 1; j < i; j++) {
                    row.add(prev.get(j - 1) + prev.get(j));
                }

                // Last element
                row.add(1);
            }

            result.add(row);
        }

        return result;
    }
}