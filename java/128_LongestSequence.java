// https://neetcode.io/problems/longest-consecutive-sequence?list=neetcode150

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        // add all numbers to Set, so we can look up values easily
        for (int num : nums) {
            numSet.add(num);
        }
        int longestSequence = 0;

        for (int num : numSet) {
            // check if the current number Set has -1 in Set, if it doesn't
            // it is a start of a new sequence
            if (!numSet.contains(num - 1)) {
                int sequenceLength = 1;
                // increment sequenceLength if the number Set contains +1 value
                while (numSet.contains(num + sequenceLength)) {
                    sequenceLength++;
                }
                // keep track of max sequence so we can return it later
                longestSequence = Math.max(longestSequence, sequenceLength);
            }
        }

        return longestSequence;
    }
}