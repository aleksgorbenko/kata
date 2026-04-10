// https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4592/
import java.util.Arrays;

class P344_ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        P344_ReverseString sol = new P344_ReverseString();
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        sol.reverseString(input);
        System.out.println(Arrays.toString(input)); // [o, l, l, e, h]
    }
}
