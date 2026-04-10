import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/intersection-of-multiple-arrays/description/
class P2248_IntersectionofMultipleArrays {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        int len = nums.length;

        for (int[] numArr : nums) {
            for (int num : numArr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == len) {
                answer.add(entry.getKey());
            }
        }

        Collections.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        P2248_IntersectionofMultipleArrays sol = new P2248_IntersectionofMultipleArrays();
        System.out.println(sol.intersection(new int[][]{{3,1,2,4,5},{1,2,3,4},{3,4,5,6}})); // [3, 4]
    }
}
