// Solve the problem of finding the top K frequent elements in an array. Write its
// algorithm, program. Find its time and space complexities. Explain with suitable
// example.
import java.util.*;

public class TopKFrequentElements {

    // Function to find the top K frequent elements
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a priority queue (min-heap) to find the K most frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        // Step 3: Build the heap of top K frequent elements
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the element with the smallest frequency
            }
        }

        // Step 4: Extract the top K elements from the heap and return them
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        // Reverse the list because we want the most frequent elements first
        Collections.reverse(result);
        return result;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        List<Integer> result = topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent elements: " + result);  // Output: [1, 2]
    }
}
