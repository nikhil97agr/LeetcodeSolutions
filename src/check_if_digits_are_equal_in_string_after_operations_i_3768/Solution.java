package check_if_digits_are_equal_in_string_after_operations_i_3768;

class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length() > 2){
            StringBuilder res = new StringBuilder();
            for(int i=0;i<s.length()-1;i++){
                int dig1 = s.charAt(i)-'0';
                int dig2 = s.charAt(i+1)-'0';
                int ans = (dig1 + dig2)%10;
                res.append(ans);
            }
            s = res.toString();
        }

        return s.charAt(0) == s.charAt(1);
    }
}