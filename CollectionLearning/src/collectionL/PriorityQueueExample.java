package collectionL;

import java.util.*;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        minHeap.addAll(Arrays.asList(10, 20, 15, 5));
        maxHeap.addAll(Arrays.asList(10, 20, 15, 5));

        System.out.println("Min Heap: " + minHeap);
        System.out.println("Max Heap: " + maxHeap);

        System.out.println("Min Element: " + minHeap.peek());
        System.out.println("Max Element: " + maxHeap.peek());
    }
}

