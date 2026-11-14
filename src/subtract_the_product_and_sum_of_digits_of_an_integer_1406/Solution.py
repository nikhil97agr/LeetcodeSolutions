class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        n = str(n)
        product = 1
        total = 0
        for i in n:
            product*=int(i)
            total+=int(i)
        return product - total
        