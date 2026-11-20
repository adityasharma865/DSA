
class NumArray {

    int[] tree;
    int n;

    public NumArray(int[] nums) {

        n = nums.length;
        tree = new int[2 * n];

        // Build the segment tree
        for (int i = 0; i < n; i++) {
            tree[n + i] = nums[i];
        }

        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int index, int val) {

        // Update the leaf node
        index += n;
        tree[index] = val;

        // Update parent nodes
        while (index > 1) {
            index /= 2;
            tree[index] = tree[2 * index] + tree[2 * index + 1];
        }
    }

    public int sumRange(int left, int right) {

        left += n;
        right += n;

        int sum = 0;

        while (left <= right) {

            if (left % 2 == 1) {
                sum += tree[left];
                left++;
            }

            if (right % 2 == 0) {
                sum += tree[right];
                right--;
            }

            left /= 2;
            right /= 2;
        }

        return sum;
    }
}
