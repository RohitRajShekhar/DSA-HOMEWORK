// Calculate how much water can be trapped between the bars of a histogram. Write its
// algorithm, program. Find its time and space complexities. Explain with suitable
// example.
public class TrappingRainWater {

    // Function to calculate the trapped rainwater using prefix and suffix arrays
    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        // Initialize prefix and suffix arrays
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int waterTrapped = 0;

        // Fill prefix array (maximum height from the left)
        prefix[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }

        // Fill suffix array (maximum height from the right)
        suffix[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }

        // Calculate water trapped at each index
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(prefix[i], suffix[i]) - height[i];
        }

        return waterTrapped;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = trap(heights);
        System.out.println("Total water trapped: " + result);  // Output: 6
    }
}
