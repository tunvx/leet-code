// https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150

package top150

import (
	"fmt"
)

func removeElement(nums []int, val int) int {
	k := 0
	for _, num := range nums {
		if num != val {
			nums[k] = num
			k++
		}
	}
	return k
}

func RunRemoveElement() {
	// Example slice
	nums := []int{3, 2, 2, 3}

	// Print the entire slice
	fmt.Printf("Original array: %v\n", nums)

	valToRemove := 3
	newLength := removeElement(nums, valToRemove)
	fmt.Printf("Array after removing %d: %v\n", valToRemove, nums[:newLength])
	fmt.Printf("New length: %d\n", newLength)
}

// Time complex: O(n), Extra-space: O(1)
