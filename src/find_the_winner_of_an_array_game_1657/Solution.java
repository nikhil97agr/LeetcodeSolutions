package find_the_winner_of_an_array_game_1657;

import java.util.*;
class Solution {
    public int getWinner(int[] arr, int k) {
        Queue<Integer> que = new LinkedList<>();

        int curr = arr[0];
        int max = Arrays.stream(arr).max().getAsInt();
        for(int i=1;i<arr.length;i++){
            que.add(arr[i]);
        }

        int cnt = 0;
        while(!que.isEmpty()){
            int num = que.poll();

            if(curr > num){
                que.offer(num);
                cnt++;
            }else{
                que.offer(curr);
                cnt = 1;
                curr = num;

            }

            if(cnt ==k || curr == max) return curr;
        }
        return -1;
    }
}