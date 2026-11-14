package friends_of_appropriate_ages_852;

import java.util.*;
class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        for(int i=0;i<ages.length;i++){
            double req = 0.5d * ages[i] + 7;
            ans += bs(ages, req, ages[i], i);
        }

        return ans;
    }

    private int bs(int arr[], double v1, int v2, int ind){
        int start =0;
        int end =arr.length - 1;
        int i1 = -1;
        int i2 = -1;

        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] > v1){
                i1 = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        start =0;
        end = arr.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] <= v2){
                i2 = mid ;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }



        if(i1 == -1 || i2 == -1 || i1 > i2) return 0;

        return i2 - i1 + 1 + (ind >= i1 && ind <= i2 ? -1 : 0);
    }
}