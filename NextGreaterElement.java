// Solve the problem of finding the next greater element for each element in an array.
// Write its algorithm, program. Find its time and space complexities. Explain with
// suitable example.
import java.util.Stack;

public class NextGreaterElement {

    // Function to find the next greater element for each element in the array
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n]; // Array to store the next greater element for each element
        Stack<Integer> stack = new Stack<>(); // Stack to store indices of elements
        
        // Initialize the result array with -1 (default value when no greater element is found)
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Check if the current element is greater than the element corresponding to the top index in the stack
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop(); // Pop the index of the element whose next greater element is found
                result[index] = nums[i]; // Set the next greater element for that element
            }
            stack.push(i); // Push the current index onto the stack
        }

        return result;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = nextGreaterElement(nums);

        // Output the result
        System.out.print("Next greater element for each element: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
