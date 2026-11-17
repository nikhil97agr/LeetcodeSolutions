class Solution:
    def prefixesDivBy5(self, A: List[int]) -> List[bool]:
        n = len(A)
        result = [False for i in range(n)]
        num = 0
        for i in range(n):
            num = num*2 + A[i]
            result[i] = True if num%5==0 else False
        return result