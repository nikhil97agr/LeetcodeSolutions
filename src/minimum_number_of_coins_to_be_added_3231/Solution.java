package minimum_number_of_coins_to_be_added_3231;

import java.util.*;
class Solution {
    public int minimumAddedCoins(int[] arr, int target) {
        Arrays.sort(arr);
        int total = 0;
        int i=0;
        long num = 1;
        long sum = 0;
        int n = arr.length;
        while(num <= 1l*target){
            
            while(i<n && arr[i] <= num){
                sum += arr[i];
                i++;
            }
            
            if(sum < num){
                sum += num;
                total++;
            }
            num++;
            
        }
        
        return total;
        
    }
}