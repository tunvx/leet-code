// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150

package top150

import "fmt"

func removeDuplicates_2(nums []int) int {
	if len(nums) <= 2 {
		return len(nums)
	}
	k := 0
	cnt := 1
	for i := 1; i < len(nums); i++ {
		if nums[k] != nums[i] {
			k++
			nums[k] = nums[i]
			cnt = 1
		} else if nums[k] == nums[i] && cnt == 1 {
			k++
			nums[k] = nums[i]
			cnt++
		}
	}
	return k + 1
}

func RunRemoveDuplicates_2() {
	// Example slice
	nums := []int{1, 2, 2}

	// Print the entire slice
	fmt.Println("Original array:", nums)

	// Call removeElement and print the modified slice and new length
	newLength := removeDuplicates_2(nums)
	fmt.Printf("Array after removing: %v\n", nums[:newLength])
	fmt.Printf("New length: %d\n", newLength)
}

// Time complex: O(n), Extra-space: O(1)
