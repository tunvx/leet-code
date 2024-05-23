// https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150

package top150

import (
	"fmt"
)

func reverse(nums []int, start int, end int) {
	for start < end {
		temp := nums[start]
		nums[start] = nums[end]
		nums[end] = temp

		start++
		end--
	}
}

func rotate(nums []int, k int) {
	k = k % len(nums)
	reverse(nums, 0, len(nums)-1)
	reverse(nums, 0, k-1)
	reverse(nums, k, len(nums)-1)
}

func RunRotateArray() {
	nums := []int{1}
	k := 3

	fmt.Printf("The original array: %v\n", nums)
	rotate(nums, k)
	fmt.Printf("Aray after rotate %d: %v\n", k, nums)
}

// Time complex: O(n), Extra-space: O(1)
