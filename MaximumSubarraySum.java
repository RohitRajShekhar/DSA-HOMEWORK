// Write a program to find the maximum subarray sum using Kadane’s algorithm
public class MaximumSubarraySum {

    // Function to find the maximum subarray sum using Kadane's Algorithm
    public static int maxSubArraySum(int[] nums) {
        // Initialize currentMax and globalMax with the first element
        int currentMax = nums[0];
        int globalMax = nums[0];
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update currentMax to be either the current element or the sum of the subarray
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            
            // Update globalMax to be the maximum of currentMax and globalMax
            globalMax = Math.max(globalMax, currentMax);
        }
        
        return globalMax; // Return the globalMax which is the maximum subarray sum
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        int result = maxSubArraySum(nums);
        System.out.println("Maximum subarray sum is: " + result);  // Output: 6
    }
}
