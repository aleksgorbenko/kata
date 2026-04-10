// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
class P26_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        // track write pointer where we will write the next non-duplicate number
        int writePos = 0;

        // track read pointer
        // if read pointer and write pointers are the same - skip to the next item
        // in array
        // if they are not the same, we need to move write pointer to the left
        // and write the current read pointer - it has the new non-duplicate value
        for (int readPos = 1; readPos < nums.length; readPos++) {
            if (nums[readPos] != nums[writePos]) {
                writePos++;
                nums[writePos] = nums[readPos];
            }
        }

        // array is zero indexed, so number of elements will be
        // write pointer + 1. This is the total number of unique numbers
        return writePos + 1;
    }
}