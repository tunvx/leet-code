// https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150

package top150

import (
	"fmt"
)

func majorityElement(nums []int) int {
	count := 0
	majoyrityElement := 0
	for i := 0; i < len(nums); i++ {
		if count == 0 {
			majoyrityElement = nums[i]
		}
		if majoyrityElement == nums[i] {
			count++
		} else {
			count--
		}
	}
	return majoyrityElement
}

func RunMajoyrityElement() {
	// Example slice
	nums := []int{2, 2, 1, 1, 1, 2, 2}

	// Print the entire slice
	fmt.Println("Array:", nums)
	fmt.Print("Maroyrity element: ", majorityElement(nums), "\n")
}

// Time complex: O(n), Extra-space: O(1)
