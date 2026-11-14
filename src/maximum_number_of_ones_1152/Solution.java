package maximum_number_of_ones_1152;

import java.util.*;
class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int cnt[][] = new int[sideLength][sideLength];

        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                cnt[i%sideLength][j%sideLength]++;
            }
        }

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for(int x [] : cnt){
            for(int y : x) que.offer(y);
        }
        int ans =0 ;
        for(int i=0;i<maxOnes;i++){
            ans += que.poll();
        }

        return ans;
    }
}