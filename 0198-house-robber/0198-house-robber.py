class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        
        maxv = [0 for _ in range(len(nums))]
        maxv[0] = nums[0]
        maxv[1] = max(nums[0], nums[1])
        for i in range(2,len(nums)):
            maxv[i] = max(maxv[i-2]+nums[i], maxv[i-1])
        return max(maxv)