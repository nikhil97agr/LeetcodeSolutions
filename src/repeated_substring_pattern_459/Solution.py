class Solution(object):
    def repeatedSubstringPattern(self, s):
        """
        :type s: str
        :rtype: bool
        """
        l=[]
        n=len(s)
        for i in range(1,n):
            if n%i==0:
                var=s[0:i]
                j=n/i
                if j*var==s:
                    return True
        return False
           
        


        