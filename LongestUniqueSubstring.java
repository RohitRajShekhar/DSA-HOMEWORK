// Find the length of the longest substring without repeating characters. Write its
// algorithm, program. Find its time and space complexities. Explain with suitable
// example
import java.util.HashSet;

public class LongestUniqueSubstring {

    // Function to find length of longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;

        int start = 0, end = 0;
        HashSet<Character> seen = new HashSet<>();

        while (end < n) {
            char currentChar = s.charAt(end);

            if (!seen.contains(currentChar)) {
                seen.add(currentChar);
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            } else {
                seen.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }

    // Main method to test the function
    public static void main(String[] args) {
        String input = "abcabcbb";
        int result = lengthOfLongestSubstring(input);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}
