// Write a program to check if an integer is a palindrome without converting it to a string.
// Write its algorithm, program. Find its time and space complexities. Explain with
// suitable example.
public class PalindromeNumber {

    // Function to check if the integer is a palindrome without converting to string
    public static boolean isPalindrome(int num) {
        // Handle negative numbers and multiples of 10 (except 0)
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }
        
        int reversedHalf = 0;
        while (num > reversedHalf) {
            reversedHalf = reversedHalf * 10 + num % 10;  // Append the last digit to reversedHalf
            num /= 10;  // Remove the last digit from num
        }
        
        // If the number is equal to the reversed half or the reversed half (after removing last digit) equals num
        return num == reversedHalf || num == reversedHalf / 10;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int num = 121;
        System.out.println("Is " + num + " a palindrome? " + isPalindrome(num));  // Output: true
        
        int num2 = -121;
        System.out.println("Is " + num2 + " a palindrome? " + isPalindrome(num2));  // Output: false
        
        int num3 = 10;
        System.out.println("Is " + num3 + " a palindrome? " + isPalindrome(num3));  // Output: false
    }
}
