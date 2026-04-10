// https://leetcode.com/problems/find-the-highest-altitude/description/

class P1732_FindtheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int len = gain.length;

        long[] prefix = new long[gain.length+1];
        for (int i=0; i< len; i++) {
            prefix[i+1] = prefix[i] + gain[i];
            max = (int) Math.max(max, prefix[i+1]);
        }

        return max;
    }

    public static void main(String[] args) {
        P1732_FindtheHighestAltitude sol = new P1732_FindtheHighestAltitude();
        System.out.println(sol.largestAltitude(new int[]{-5, 1, 5, 0, -7})); // 1
    }
}
