public class PrefixSumRangeQuery {

    // Function to build the prefix sum array
    public static int[] buildPrefixSum(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        return prefix;
    }

    // Function to get sum from index L to R
    public static int rangeSum(int[] prefix, int L, int R) {
        if (L == 0) {
            return prefix[R];
        } else {
            return prefix[R] - prefix[L - 1];
        }
    }

    // Main method to test the above logic
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 6, 5};
        int[] prefix = buildPrefixSum(arr);

        int L = 1;
        int R = 4;

        int sum = rangeSum(prefix, L, R);
        System.out.println("Sum of elements from index " + L + " to " + R + " is: " + sum);
    }
}
