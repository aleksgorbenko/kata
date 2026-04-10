// https://neetcode.io/problems/max-water-container

class P11_LargestWaterContainer {
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

    public static void main(String[] args) {
        P11_LargestWaterContainer sol = new P11_LargestWaterContainer();
        System.out.println(sol.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
    }
}
