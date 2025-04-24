// Find the maximum sum of any subarray of size K in a given array. Write its algorithm,
// program. Find its time and space complexities. Explain with suitable example.
public class MaxSumSubarrayOfSizeK {

    // Function to find the maximum sum of subarray of size K
    public static int maxSumSubarray(int[] arr, int k) {
        if (arr.length < k) {
            System.out.println("Invalid: Array size is less than K.");
            return -1;
        }

        // Step 1: Find sum of first K elements
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;

        // Step 2: Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int result = maxSumSubarray(arr, k);
        System.out.println("Maximum sum of subarray of size " + k + " is: " + result);
    }
}
