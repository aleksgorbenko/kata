import java.util.HashSet;

// https://leetcode.com/problems/counting-elements/description/
class P1426_CountingElements {
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

    public static void main(String[] args) {
        P1426_CountingElements sol = new P1426_CountingElements();
        System.out.println(sol.countElements(new int[]{1, 2, 3})); // 2
        System.out.println(sol.countElements(new int[]{1, 1, 2})); // 2
    }
}
