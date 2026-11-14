package maximum_number_of_people_that_can_be_caught_in_tag_1979;

import java.util.*;
class Solution {
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        Queue<Integer> que= new LinkedList<>();
        for(int i=0;i<team.length;i++){
            if(team[i] ==0) que.offer(i);
        }

        int ans = 0;

        for(int i=0;i<team.length && !que.isEmpty();i++){
            if(team[i] ==0) continue;
            int start =i - dist;
            int end = i + dist;
            while(!que.isEmpty() && start > que.peek() ){
                que.poll();
            }
            if(!que.isEmpty() && start <= que.peek() && que.peek() <= end){
                que.poll();
                ans++;
            }
        }

        return ans;

    }
}