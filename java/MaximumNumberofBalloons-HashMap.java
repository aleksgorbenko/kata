import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/maximum-number-of-balloons/description/
class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> freq = new HashMap<>();

        String target = "balloon";

        char[] charArr = text.toCharArray();
        for (char c : charArr) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int b = freq.getOrDefault('b', 0) / 1;
        int a = freq.getOrDefault('a', 0) / 1;
        int n = freq.getOrDefault('n', 0) / 1;
        int l2 = freq.getOrDefault('l', 0) / 2;
        int o2 = freq.getOrDefault('o', 0) / 2;

        return Math.min(b, Math.min(a, Math.min(l2, Math.min(o2, n))));
    }
}