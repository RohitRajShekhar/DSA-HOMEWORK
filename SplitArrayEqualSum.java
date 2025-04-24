// Check if an array can be split into two parts such that the sum of the prefix equals the
// sum of the suffix. Write its algorithm, program. Find its time and space complexities.
// Explain with suitable example.
public class SplitArrayEqualSum {

    // Function to check if the array can be split
    public static boolean canBeSplit(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            leftSum += arr[i];
            int rightSum = totalSum - leftSum;

            if (leftSum == rightSum) {
                return true;
            }
        }

        return false;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] arr = {3,3, 3,3, 3, 3};

        if (canBeSplit(arr)) {
            System.out.println("Array can be split into two parts with equal sum.");
        } else {
            System.out.println("Array cannot be split into two parts with equal sum.");
        }
    }
}
