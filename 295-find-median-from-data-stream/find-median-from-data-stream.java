
import java.util.*;

class MedianFinder {

    // Max Heap for smaller half
    PriorityQueue<Integer> small =
        new PriorityQueue<>(Collections.reverseOrder());

    // Min Heap for larger half
    PriorityQueue<Integer> large =
        new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {

        small.offer(num);

        // Move largest element of small to large
        large.offer(small.poll());

        // Balance both heaps
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        if (small.size() > large.size()) {
            return small.peek();
        }

        return (small.peek() + (double) large.peek()) / 2.0;
    }
}
