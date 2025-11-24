import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/counting-elements/description/
class Solution {
    public int countElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int answer = 0;
        
        for (int i: arr) {
            set.add(i);
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] + 1)) {
                answer++;
            }
        }
        
        return answer;
    }
}