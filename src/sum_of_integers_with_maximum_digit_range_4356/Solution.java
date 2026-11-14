package sum_of_integers_with_maximum_digit_range_4356;

class Solution {
    public int maxDigitRange(int[] nums) {
        int cnt[] = new int[10];

        for(int x : nums){
            int range = get(x);
            cnt[range] += x;
        }


        for(int i=9;i>=0;i--){
            if(cnt[i] !=0) return cnt[i];
        }

        return 0;
    }

    private int get(int x){
        int min = 10;
        int max = 0;
        while(x > 0){
            int d = x%10;
            min = Math.min(min, d);
            max = Math.max(max, d);
            x/=10;
        }

        return max - min;
    }
}