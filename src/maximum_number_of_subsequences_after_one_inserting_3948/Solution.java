package maximum_number_of_subsequences_after_one_inserting_3948;

import java.util.*;
class Solution {
    public long numOfSubsequences(String s) {
        long sub = 0;
        PriorityQueue<Long> que = new PriorityQueue<>(Collections.reverseOrder());
        int n = s.length();
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = s.charAt(0) == 'L' ? 1 : 0;
        right[n-1] = s.charAt(n-1) == 'T' ? 1 : 0;
        for(int i=1;i<n;i++){
            left[i] = left[i-1] + (s.charAt(i) == 'L' ? 1 : 0);
        }


        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1] + ( s.charAt(i) == 'T' ? 1 : 0);
        }

        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'C'){
                sub += 1l*left[i]*right[i];
            }
        }
        que.offer(sub);
        sub = 0;

        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'C'){
                sub += 1l*left[i]*(right[i] + 1);
            }
        }

        que.offer(sub);
        sub = 0;

        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'C'){
                sub += 1l*(left[i] + 1)*right[i];
            }
        }
        que.offer(sub);
        sub = 0;
        long max = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'C'){
                sub += 1l*left[i]*right[i];
            }
            max = Math.max(max, 1l*left[i] * right[i]);

        }
        sub += max;

        que.offer(sub);

        return que.poll();
        
    
    }
}