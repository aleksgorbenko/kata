import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/jewels-and-stones/description/
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        
        for (char stone : stones.toCharArray()) {
            if (jewels.indexOf(stone) != -1) {
                count++;
            }
        }
        
        return count;
    }
}