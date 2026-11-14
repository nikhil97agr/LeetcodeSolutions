package find_unique_binary_string_2107;

import java.util.*;
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(String s : nums){
            int num = 0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='1'){
                    num += (1<<(n-1-i));
                }
            }
            set.add(num);
        }
        int max = (1<<n)-1;
        while(set.contains(max)){
            max--;
        }
        String ans = Integer.toBinaryString(max);
        StringBuilder sb = new StringBuilder();
        int remain = n - ans.length();
        while(remain-->0){
            sb.append('0');
        }

        return sb.append(ans).toString();
    }
}