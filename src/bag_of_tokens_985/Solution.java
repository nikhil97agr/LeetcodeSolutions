package bag_of_tokens_985;

import java.util.*;
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int ans = 0;
        int n = tokens.length;
        int start = 0;
        int end = n-1;
        int score = 0;
        while(start <= end){
            System.out.println(score+":"+start+":"+end+":"+power);

            if(tokens[start] <= power){
                power -= tokens[start];
                score++;
                start++;
                ans = Math.max(ans, score);
            }else if(score>=1){
                score -= 1;
                power += tokens[end];
                end--;
            }else{
                break;
            }

        }
        return ans;
    }


}