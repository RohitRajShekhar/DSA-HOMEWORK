// How to find the maximum product subarray. Write its algorithm, program. Find its time
// and space complexities. Explain with suitable example.
public class MaxProductSubarray {

    // Function to find the maximum product subarray
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        // Initialize the max and min products to the first element
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        // Traverse the array from the second element onwards
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // Swap maxProd and minProd when the current number is negative
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // Update the max and min products
            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);

            // Update the result to keep track of the maximum product found so far
            result = Math.max(result, maxProd);
        }

        return result;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int result = maxProduct(nums);
        System.out.println("Maximum Product Subarray: " + result);  // Output: 6
    }
}
