// https://leetcode.com/problems/jewels-and-stones/description/
class P771_JewelsandStones {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;

        for (char stone : stones.toCharArray()) {
            if (jewels.indexOf(stone) != -1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        P771_JewelsandStones sol = new P771_JewelsandStones();
        System.out.println(sol.numJewelsInStones("aA", "aAAbbbb")); // 3
    }
}
