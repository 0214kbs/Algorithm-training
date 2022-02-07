class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
  
        nums.sort()
        #nums = [0,1,2,3,4,5]
        
        half = len(nums)//2 if len(nums)%2==0 else len(nums)//2+1

        nums[::2],nums[1::2] = nums[:half][::-1],nums[half:][::-1]
        # nums[:half] = nums[:3] = [0,1,2]
        # [::-1] means reverse = [2,1,0]
        # nums = [2,1,1,3,0,5]
        
        # nums[1::2] = [1,3,5]
        # nums[half:]=nums[3:] = [3,4,5]
        # [::-1] means reverse = [5,4,3]
        # nums = [2,5,1,4,0,3]
        