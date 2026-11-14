class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        l=[]
        for i in s:
            if i=='(' or i=='[' or i=='{':
                l.append(i)
            elif len(l)==0:
                return False
            elif (i==')' and l[-1]=='(') or (i==']' and l[-1]=='[') or (i=='}' and l[-1]=='{'):
                l.pop()
            else:
                return False
        if len(l) != 0:
            return False
            
        return True

        
           