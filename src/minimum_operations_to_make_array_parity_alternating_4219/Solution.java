package minimum_operations_to_make_array_parity_alternating_4219;

import java.util.*;
import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().makeParityAlternating(new int[]{7,7}));
    }
    public int[] makeParityAlternating(int[] nums) {
        int n = nums.length;
        if(n==1) return new int[]{0, 0};

        int res1[] = process(nums, 0);
        int res2[] = process(nums, 1);

        if(res1[0] < res2[0]){
            return new int[]{res1[0], res1[1]};
        }
        if(res2[0] < res1[0]){
            return new int[]{res2[0], res2[1]};
        }

        return new int[]{res1[0], Math.min(res1[1], res2[1])};

    }

    private int[] process(int arr[], int expected){
        int n = arr.length;
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        int ans = 0;


        for(int i=0;i<n;i++){
            int parity = (i%2==0) ? expected : 1 - expected;

            int curr = Math.abs(arr[i]%2);
            if(curr != parity){
                ans++;

            }
        }
        int diff= Integer.MAX_VALUE;
        for(int d1 = -1;d1<=1;d1++){
            for(int d2 = -1;d2 <= 1;d2++){
                int newMin = min + d1;
                int newMax = max + d2;
                if(newMin> newMax) continue;

                if(possible(arr, expected, newMin, newMax)){
                    diff = Math.min(diff, newMax - newMin);
                }
            }
        }
        return new int[]{ans,diff};

    }

    private boolean possible(int arr[], int expected, int low, int high){
        int n =arr.length;
        for(int i=0;i<n;i++){
            int parity = (i%2==0) ? expected : 1 - expected;

            int curr = Math.abs(arr[i]%2);
            if(curr != parity){
                int up = arr[i] + 1;
                int down = arr[i] - 1;

                boolean plus = up >= low && up <= high;
                boolean minus = down >= low && down <= high;
                if(!plus && !minus){
                    return false;
                }

            }else{
                if(arr[i] < low || arr[i] > high) return false;
            }
        }

        return true;
    }

}