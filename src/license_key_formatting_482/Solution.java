package license_key_formatting_482;

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        StringBuilder result = new StringBuilder("");
        int i =0;
        int total = 0;
        for(char c : S.toCharArray())
        {
            if(c!='-')
                total++;
        }
        boolean temp = false;
        if(total%K==0)
        {
            temp = true;
        }
        while(i<S.length())
        {
            if(!temp)
            {
                int count = 0;
                while(i<S.length()&&count<total%K)
                {
                    if(S.charAt(i)!='-')
                    {
                        result.append(S.charAt(i));
                        count++;
                    }
                    i++;
                }
                temp = true;
            }
            else
            {
                int count = 0;
                while(i<S.length()&&count<K)
                {
                    if(S.charAt(i)!='-')
                    {
                        result.append(S.charAt(i));
                        count++;
                    }
                    i++;
                }
            }
            while(i<S.length()&&S.charAt(i)=='-')
            {
                i++;
            }
            if(i!=S.length())
            {
                
                result.append('-');
            }
        }
        return new String(result);
    }
}