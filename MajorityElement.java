// Find the majority element in an array that appears more than n/2 times. Write its
// algorithm, program. Find its time and space complexities. Explain with suitable
// example.
public class MajorityElement {

    // Function to find majority element using Boyer-Moore Voting Algorithm
    public static int majorityElement(int[] nums) {
        int candidate = -1, count = 0;

        // First pass: Find potential majority element (candidate)
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Second pass: Verify if the candidate is the majority
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        } else {
            return -1;  // No majority element
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        int result = majorityElement(arr);
        if (result != -1) {
            System.out.println("The majority element is: " + result);
        } else {
            System.out.println("No majority element found.");
        }
    }
}
