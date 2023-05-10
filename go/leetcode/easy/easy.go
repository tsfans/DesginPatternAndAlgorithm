package easy

// 1.TwoSum https://leetcode.com/problems/two-sum/
func TwoSum(nums []int, target int) []int {
	if nums == nil || len(nums) < 2 {
		return nil
	}
	map1 := make(map[int]int)

	for i, v := range nums {
		compelemnt := target - v
		if value, ok := map1[compelemnt]; ok {
			return []int{value, i}
		}
		map1[v] = i
	}
	return nil
}
