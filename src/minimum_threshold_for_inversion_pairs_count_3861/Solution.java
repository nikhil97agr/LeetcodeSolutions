package minimum_threshold_for_inversion_pairs_count_3861;

import java.util.*;
class Solution {
    public int minThreshold(int[] nums, int k) {
        int ans = -1;
        int start = 1;
        int end = Arrays.stream(nums).max().getAsInt() - Arrays.stream(nums).min().getAsInt()+1;

        while(start <= end){
            int mid = start + (end - start)/2;
            long cnt = count(mid, nums);
            if( cnt>= 1l*k){
                ans= mid;
                end= mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    private long count(int x, int nums[]){
        return mergeSort(nums, 0, nums.length-1, x).cnt;
    }
    
    private State mergeSort(int nums[], int start, int end, int x){
        if(start == end){
            return new State(new int[]{nums[start]}, 0);
        }

        int mid = (start + end)/2;
        State left = mergeSort(nums, start, mid, x);
        State right = mergeSort(nums, mid + 1, end, x);
        int l1 = left.arr.length;
        int l2 = right.arr.length;
        int l = l1 + l2;
        int merge[] = new int[l];
        int i = l-1;
        int i1 = l1-1;
        int i2 = l2 -1;
        int la[] =left.arr;
        int ra[] = right.arr;
        long cnt = 0;

        while(i1 >=0 && i2 >=0){
            if(la[i1] <= ra[i2]){
                merge[i--] = ra[i2--];
            }else{
                cnt += cnt(ra, 0, i2, la[i1] - x);
                merge[i--] = la[i1--];
            }
        }

        while(i1 >=0){
            merge[i--] = la[i1--];
        }

        while(i2 >=0){
            merge[i--] = ra[i2--];
        }


        long total = left.cnt + right.cnt;


        return new State(merge, total + cnt);
    }

    private long cnt(int arr[], int start, int end, int val){
        int cnt = 0;
        int len = end - start + 1;
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] >= val){
                cnt = (len - mid);
                end= mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return cnt;
    }

    class State{
        int arr[];
        long cnt;

        public State(int arr[], long cnt){
            this.arr = arr;
            this.cnt = cnt;
        }
    }

}