package maximum_number_of_balls_in_a_box_1844;

import java.util.*;
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int cnt[] = new int[60];

        for(int i=lowLimit;i<=highLimit;i++){
            int temp = i;
            int sum =0;
            while(temp > 0){
                sum += temp%10;
                temp/=10;
            }
            cnt[sum]++;
        }

        int max = Arrays.stream(cnt).max().getAsInt();

        return max;
    }
}