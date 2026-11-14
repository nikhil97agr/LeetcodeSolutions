package minimize_the_maximum_adjacent_element_difference_3658;

class Solution {
    public int minDifference(int[] nums) {
        int n= nums.length;
        var min = Integer.MAX_VALUE;
        var max = 0;
        var gap = 0;
        for(int i=0;i+1 < n;i++){
            int sm = Math.min(nums[i], nums[i+1]);
            int lg = Math.max(nums[i], nums[i+1]);

            if(sm == -1 && lg != -1){
                min = Math.min(min, lg);
                max = Math.max(max, lg);
            }else{
                gap = Math.max(gap, Math.abs(nums[i] - nums[i+1]));
            }
        }

        int l= gap;
        int r = (max - min+1)/2;
        while( l < r){
            int mid = l + (r-l)/2;
            if(check(nums, min + mid, max - mid, mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }

    private boolean check(int nums[], int x, int y, int maxDiff){
        var cnt = 0;
        var prev = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == -1){

                if(prev !=0 && Math.min(Math.abs(prev - x), Math.abs(prev - y)) > maxDiff){
                    return false;

                }

                cnt++;
            }else{
                if(cnt > 0){
                    int diff = 0 ;
                    if(prev !=0 ){
                        diff = min(max(abs(prev - x), abs(nums[i] - x)), max(abs(prev - y), abs(nums[i] - y)));
                    }else{
                        diff = min(abs(nums[i] - x), abs(nums[i] - y));
                    }
                    if(diff > maxDiff && (cnt==1 || y -x > maxDiff)){
                        return false;
                    }
                    
                }
                prev = nums[i];
                cnt = 0;
            }

        }
        return true;
    }

    private int min(int a, int b){
        return Math.min(a, b);
    }

    private int max(int a, int b){
        return Math.max(a,b);
    }

    private int abs(int a){
        return Math.abs(a);
    }
}