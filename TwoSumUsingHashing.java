// How to find two numbers in an array that add up to a target using hashing. Write its
// algorithm, program. Find its time and space complexities. Explain with suitable
// example.
import java.util.HashSet;

public class TwoSumUsingHashing {

    // Function to find two numbers that add up to the target
    public static int[] twoSum(int[] nums, int target) {
        // HashSet to store the elements we have seen
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // Check if the complement (target - num) exists in the set
            int complement = target - num;
            if (seen.contains(complement)) {
                return new int[] { complement, num };  // Return the pair
            }
            // Otherwise, add the current number to the set
            seen.add(num);
        }

        return null;  // Return null if no pair is found
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        if (result != null) {
            System.out.println("Pair found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found.");
        }
    }
}
