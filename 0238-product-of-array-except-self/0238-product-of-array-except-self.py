class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        all = 1
        zero_cnt = 0
        for n in nums:
            if n==0: zero_cnt +=1
            else: all*= n
        answer = []
        if zero_cnt == len(nums):
            return [0 for _ in range(len(nums))]
        
        for n in nums:
            if n == 0:
                if zero_cnt == 1: answer.append(all)
                else: answer.append(0)
            else:
                if zero_cnt == 0: answer.append(all//n)
                else: answer.append(0)
        return answer