import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/daily-temperatures/description/
class P739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] answer = new int[n]; // defaults to 0

        for (int i = 0; i < n; i++) {
            int curr = temperatures[i];
            while (!stack.isEmpty() && curr > temperatures[stack.peek()]) {
                // this will be previous day index IF it is below current temp
                int prevDayIndex = stack.pop();
                // we need to calculate how many days AGO the temperature
                // was below the current HIGH temperature
                answer[prevDayIndex] = i - prevDayIndex;
            }

            // we store day idexes as opposed to temperatures
            stack.push(i);
        }

        return answer;
    }
}