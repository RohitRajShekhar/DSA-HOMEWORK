// Solve the problem of finding the subarray sum equal to K using hashing. Write its
// algorithm, program. Find its time and space complexities. Explain with suitable
// example.
import java.util.HashMap;

public class SubarraySumEqualK {

    // Function to find if there is a subarray with sum equal to K
    public static boolean subarraySumEqualsK(int[] nums, int K) {
        // Initialize hash map to store the frequency of cumulative sums
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        // Initialize currentSum and add the base case: sum 0 is present initially
        int currentSum = 0;
        prefixSumMap.put(0, 1);
        
        // Iterate through the array
        for (int num : nums) {
            currentSum += num; // Update cumulative sum
            
            // Check if currentSum - K exists in the prefix sum map
            if (prefixSumMap.containsKey(currentSum - K)) {
                return true;  // Found the subarray with sum equal to K
            }
            
            // Store/update the current cumulative sum in the map
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        // Return false if no subarray is found with sum equal to K
        return false;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int K = 9;
        
        boolean result = subarraySumEqualsK(nums, K);
        System.out.println("Is there a subarray with sum equal to " + K + "? " + result);  // Output: true
    }
}
