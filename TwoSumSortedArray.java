// Find two numbers in a sorted array that add up to a target. Write its algorithm, program.
// Find its time and space complexities. Explain with suitable example.
public class TwoSumSortedArray {

    // Function to find two numbers that add up to the target
    public static int[] findTwoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                return new int[] { arr[left], arr[right] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { -1, -1 }; // No valid pair
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 6, 8, 11 };
        int target = 10;

        int[] result = findTwoSum(arr, target);

        if (result[0] != -1) {
            System.out.println("Pair found: " + result[0] + " + " + result[1] + " = " + target);
        } else {
            System.out.println("No pair found that adds up to " + target);
        }
    }
}
