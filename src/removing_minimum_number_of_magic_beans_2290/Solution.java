package removing_minimum_number_of_magic_beans_2290;

import java.util.*;
class Solution {
    public long minimumRemoval(int[] beans) {
        long ans = Long.MAX_VALUE;
        int n = beans.length;

        Arrays.sort(beans);
        long pre[] = new long[n+1];
        
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + beans[i];
        }
        

        for(int i=0;i<n;i++){
            int left = leftSearch(beans[i], beans);
            int right = rightSearch(beans[i], beans);
            int cnt = n - right;
            ans = Math.min(ans, pre[left+1] + (pre[n] - pre[right]) - 1l*cnt*beans[i]);

        }

        return ans;
    }

    private int leftSearch(int val, int arr[]){
        int ind = -1;
        int start =0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end)/2;

            if(arr[mid] < val){
                ind = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ind;
    }
    private int rightSearch(int val, int arr[]){
        int ind = arr.length;
        int start =0;
        int end = arr.length -1;
        while(start <= end){
            int mid =( start + end)/2;
            if(arr[mid] > val){
                ind= mid;
                end = mid- 1;
            }else{
                start = mid + 1;
            }
        }

        return ind;
    }
}