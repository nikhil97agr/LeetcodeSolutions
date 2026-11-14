package largest_number_179;

import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
        String s[] = new String[nums.length];

        for(int i=0;i<nums.length;i++){
            s[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(s, (a,b)-> -(a+b).compareTo(b+a));

        StringBuilder res = new StringBuilder();
        if(s[0].equals("0")) return "0";
        for(String str : s) res.append(str);

        return res.toString();
    }
}