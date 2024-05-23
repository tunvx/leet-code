// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

package top150

import (
	"fmt"
)

// func removeDuplicates(nums []int) int {
// 	k := 0
// 	for i := 1; i < len(nums); i++ {
// 		if nums[i] != nums[k] {
// 			k++
// 			nums[k] = nums[i]
// 		}
// 	}
// 	return k + 1
// }

type Solution struct {
	slow int
	fast int
}

func (so *Solution) removeDuplicates(nums []int) int {
	for so.fast < len(nums) {
		if nums[so.slow] != nums[so.fast] {
			so.slow++
			nums[so.slow] = nums[so.fast]
		}
		so.fast++
	}
	return so.slow + 1
}

func removeDuplicates_1(nums []int) int {
	so := Solution{
		slow: 0,
		fast: 0,
	}

	return so.removeDuplicates(nums)
}

func RunRemoveDuplicates_1() {
	// Example slice
	nums := []int{1, 1, 2}

	// Print the entire slice
	fmt.Println("Original array:", nums)

	// Call removeElement and print the modified slice and new length
	newLength := removeDuplicates_1(nums)
	fmt.Printf("Array after removing: %v\n", nums[:newLength])
	fmt.Printf("New length: %d\n", newLength)
}

// Time complex: O(n), Extra-space: O(1)
