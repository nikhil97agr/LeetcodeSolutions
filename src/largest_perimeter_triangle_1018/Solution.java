package largest_perimeter_triangle_1018;

import java.util.*;
class Solution {
    public int largestPerimeter(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        if(n==3){
            int a = nums[0];
            int b = nums[1];
            int c = nums[2];
            if(a+b>c){
                return a+b+c;
            }
            return 0;
        }

        int i=n-1;
        int j=  n-2;
        int k = n-3;
        while(k>=0){
            int a= nums[k];
            int b = nums[j];
            int c = nums[i];
            if(a+b>c){
                return a+b+c;
            }
            i--;
            j--;
            k--;
        }
        return 0;
    }
}