package remove_outermost_parentheses_1078;

class Solution {
    public String removeOuterParentheses(String S) {
        String result = "";
        int count = 0;
        for(char c : S.toCharArray())
        {
            if(c=='(')
            {
                if(count>0)
                {
                    result+=c;
                    count++;
                }
                else
                {
                    count++;
                }
            }
            else
            {
                if(count==1)
                {
                    count--;
                }
                else
                {
                    count--;
                    result+=c;
                }
            }
        }
        return result;
    }
}