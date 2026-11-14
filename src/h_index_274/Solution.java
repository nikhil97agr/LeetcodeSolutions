package h_index_274;

import java.util.*;
class Solution {
    public int hIndex(int[] arr) {
        Arrays.sort(arr);
        int cnt = 0;
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            cnt++;
            if(arr[i] < cnt){
                cnt--;
                break;
            }
        }
        return cnt;
    }
}