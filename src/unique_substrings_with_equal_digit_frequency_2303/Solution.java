package unique_substrings_with_equal_digit_frequency_2303;

import java.util.*;
class Solution {
    public int equalDigitFrequency(String s) {
        Set<Integer> set = new HashSet<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            int cnt[] = new int[10];
            for(int j=i;j<n;j++){
                cnt[s.charAt(j) - '0']++;
                sb.append(s.charAt(j));
                if(check(cnt)){
                    set.add(sb.toString().hashCode());
                }
            }
        }
        return set.size();
    }

    private boolean check(int cnt[]){
        int max = 0;
        for(int x : cnt){
            if(x!=0){
                max = x;
                break;
            }
        }

        for(int x : cnt){
            if(x!=0 && x!=max){
                return false;
            }
        }

        return true;
    }
}