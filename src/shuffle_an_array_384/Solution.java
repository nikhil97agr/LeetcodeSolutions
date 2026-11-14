package shuffle_an_array_384;

import java.util.*;
class Solution {
    int nums[];
    Random randm;
    public Solution(int[] nums) {
        this.nums= nums;
        this.randm = new Random();

    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        if(nums==null) return null;

        int a[] = nums.clone();

        for(int i=1;i<nums.length;i++){
            int ind = randm.nextInt(i+1);
            swap(a, i, ind);
        }
        return a;
    }

    private void swap(int a[], int i ,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */