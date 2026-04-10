// https://leetcode.com/problems/find-lucky-integer-in-an-array/description/

package main

func findLucky(arr []int) int {
	freq := make(map[int]int)
	lucky := make(map[int]bool)

	for _, num := range arr {
		if _, ok := freq[num]; ok {
			freq[num]++

			if freq[num] == num {
				lucky[num] = true
			}

			if freq[num] > num {
				delete(lucky, num)
			}
		} else {
			freq[num] = 1
			// store it as lucky, as it could be just number 1 that can be lucy
			if freq[num] == num {
				lucky[num] = true
			}
		}
	}

	max := -1
	for num, _ := range lucky {
		if num > max {
			max = num
		}
	}

	return max
}
