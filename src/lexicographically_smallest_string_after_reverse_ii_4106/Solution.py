class Solution:
    def lexSmallest(self, s: str) -> str:
        x = set(s)
        if len(x) == 1:
            return s
        l = len(s)
        res = min(s, s[::-1])

        for i in range(1, l - 1):
            res = min(res, self.compute(i, s, l))

        return res
    def compute(self, mid: int, s: str, n: int) -> str:
        s1 = s[0:mid+1][::-1]+s[mid+1:n]
        s2 = s[0:mid]+s[mid:n][::-1]
        return min(s1, s2)