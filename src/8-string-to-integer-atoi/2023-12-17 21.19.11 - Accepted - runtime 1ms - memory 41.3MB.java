class Solution {
    public int myAtoi(String s) {
        long ans = 0;
        s = s.trim();
        boolean neg = false;
        int i=0;
        int n = s.length();
        while(i<n){
            if(Character.isDigit(s.charAt(i))){
                while(i<n && Character.isDigit(s.charAt(i)) && ans <= Integer.MAX_VALUE && ans >= Integer.MIN_VALUE){
                    ans = ans*10 + (s.charAt(i)-'0');
                    i++;
                }
                if(ans < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                if(ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                return (int) ans;
            }
            char ch = s.charAt(i);
            switch(ch){
                case '+': if(i+1<n && Character.isDigit(s.charAt(i+1))){
                    i++;
                    while(i<n && Character.isDigit(s.charAt(i))&& ans <= Integer.MAX_VALUE && ans >= Integer.MIN_VALUE){
                        ans = ans*10 + (s.charAt(i)-'0');
                        i++;
                    }
                    if(ans < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                if(ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                return (int) ans;
                }
                break;
                case '-':if(i+1<n && Character.isDigit(s.charAt(i+1))){
                    i++;
                    while(i<n && Character.isDigit(s.charAt(i))&& -ans <= Integer.MAX_VALUE && -ans >= Integer.MIN_VALUE){
                        ans = ans*10 + (s.charAt(i)-'0');
                        i++;
                    }
                    if(-ans < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                if(-ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                return (int) -ans;
                }
                break;
            }
            return 0;
        }
        return 0;
    }
}