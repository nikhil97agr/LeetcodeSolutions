class Solution {

    // maitain max val of cur slide window in head of deque
    static int[] maxDeque ;
    static int[] minDeque;
    static int maxHead;
    static int maxTail;
    static int minHead;
    static int minTail;

    // maintain min val of cur silde window in head of deque
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        maxDeque = new int[n];
        minDeque = new int[n];

        // queue range [h,t)
        maxHead=0;
        maxTail=0;
        minHead=0;
        minTail=0;

        // take each num in nums as start of slide window
        // get max len of window with any two elements in window is less than or equal to limit.

        int res =0;
        int r=0;
        for(int l =0;l<n;l++){

            // window is [l,r), check if add r to window still meet condition
            while(r<n&&withinLimit(nums,nums[r],limit)){
                addToLast(nums,r);
                r++;
            }
            // [l,r) is max len of a valid window using l as start 
            res= Math.max(res, r-l);

           removeExpired(l);
        }

        return res;
        
    }

    public boolean withinLimit(int[] nums,int num,int limit){
        int max = maxHead<maxTail?Math.max(nums[maxDeque[maxHead]], num):num;
        int min = minHead<minTail?Math.min(nums[minDeque[minHead]],num):num;

        return max-min<=limit;
    }

    public void addToLast(int[] nums,int r){
        // add to max deque 
        while(maxHead<maxTail&&nums[maxDeque[maxTail-1]]<=nums[r]){
             maxTail--;
        }
        maxDeque[maxTail++]=r;

        // add to min deque
        while(minHead<minTail&&nums[minDeque[minTail-1]]>=nums[r]){
            minTail--;
        }
        minDeque[minTail++]=r;

    }

    public void removeExpired(int l){
        if(maxDeque[maxHead]==l){
            maxHead++;
        }

        if(minDeque[minHead]==l){
            minHead++;
        }
    }

}