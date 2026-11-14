package check_if_number_has_equal_digit_count_and_digit_value_2377;

class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        int cnt[] = new int[10];

        for(int i=0;i<n;i++){
            cnt[num.charAt(i)-'0']++;
        }

        for(int i=0;i<n;i++){
            int dig = num.charAt(i) - '0';

            if(cnt[i]!=dig) return false;
        }

        return true;
    }
}