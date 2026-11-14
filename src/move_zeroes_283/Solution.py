class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        index = 0
        n = len(nums)
        for i in range(n):
            if nums[i]!=0:
                if index==i:
                    index+=1
                else:
                    nums[index] = nums[i]
                    index+=1
        for i in range(index,n):
            nums[i] = 0
                    
        