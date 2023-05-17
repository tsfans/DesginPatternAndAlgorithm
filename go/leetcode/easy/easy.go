package easy

/**
 * 1.Two Sum https://leetcode.com/problems/two-sum/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
func twoSum(nums []int, target int) []int {
	if nums == nil || len(nums) < 2 {
		return nil
	}
	map1 := make(map[int]int)
	for i, v := range nums {
		compelemnt := target - v
		// if the complement exists in the map, return the index
		if value, ok := map1[compelemnt]; ok {
			return []int{value, i}
		}
		map1[v] = i
	}
	return nil
}
