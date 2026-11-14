package sliding_window_median_480;

import java.util.*;
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a,b)->{
            if(nums[a]!=nums[b]) return Integer.compare(nums[a], nums[b]);

            return a-b;
        };

        TreeSet<Integer> min = new TreeSet<>(comparator);
        TreeSet<Integer> max = new TreeSet<>(comparator.reversed());
        int n = nums.length;
        double ans[] =new double[n-k+1];
        int ind = 0;
        for(int i=0;i<n;i++){
            if(i>=k){
                min.remove(i-k);
                max.remove(i-k);
            }

            min.add(i);
            max.add(min.pollFirst());

            balance(min, max);

            if(i>=k-1) ans[ind++] = calculateMedian(min, max, k, nums);
        }
        return ans;
    }

    private double calculateMedian(TreeSet<Integer> min , TreeSet<Integer>max, int k, int nums[]){
        if(k%2==0) return (1d*nums[min.first()] + 1d*nums[max.first()])/2d;

        return 1d*nums[min.first()];
    }

    private void balance(TreeSet<Integer> min, TreeSet<Integer> max){
        if(max.size() > min.size()) min.add(max.pollFirst());
    }
}