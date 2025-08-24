// https://neetcode.io/problems/max-water-container

class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;

        var left = 0;
        var right = heights.length-1;

        while (left < right) {
            int area = (right - left) * Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[right] < heights[left]) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        return maxArea;
    }
}
