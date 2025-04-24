// Solve the problem of finding the equilibrium index in an array. Write its algorithm,
// program. Find its time and space complexities. Explain with suitable example.
public class EquilibriumIndex {

    // Function to find equilibrium index
    public static int findEquilibriumIndex(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i]; // Now totalSum is the right sum

            if (leftSum == totalSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1; // No equilibrium index found
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        int index = findEquilibriumIndex(arr);

        if (index != -1) {
            System.out.println("Equilibrium index is: " + index);
        } else {
            System.out.println("No equilibrium index found.");
        }
    }
}
