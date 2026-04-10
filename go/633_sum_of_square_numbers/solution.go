// https://leetcode.com/problems/sum-of-square-numbers/description/

package main

import "fmt"

func judgeSquareSum(c int) bool {
	// create a set of squares that are less than c
	squares := make(map[int]int)
	for i := 0; i*i <= c; i++ {
		squares[i*i] = i * i
	}
	// look for squared pairs that sum to c
	for _, num := range squares {
		if _, ok := squares[c-num]; ok {
			fmt.Printf("Found a pair: %d and %d\n", num, c-num)
			return true
		}
	}

	return false
}

func main() {
	fmt.Println(judgeSquareSum(5))  // true (1^2 + 2^2)
	fmt.Println(judgeSquareSum(3))  // false
	fmt.Println(judgeSquareSum(4))  // true (0^2 + 2^2)
}
