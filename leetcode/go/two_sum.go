// https://leetcode.com/problems/two-sum/

func twoSum(nums []int, target int) []int {
	result := make([]int, 2)
	for i := 0; i < len(nums)-1; i++ {
		for j := i + 1; j < len(nums); j++ {
			if target == nums[i]+nums[j] {
				result[0] = i
				result[1] = j
			}
		}
	}

	return result
}