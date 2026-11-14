package minimum_number_of_refueling_stops_902;

import java.util.*;
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {


        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        int stops = 0;
        int prevMile = 0;
        for(int s[] : stations){
            int pos = s[0];
            int fuel = s[1];

            startFuel -= pos - prevMile;

            while( !que.isEmpty() && startFuel <0){
                startFuel += que.poll();
                stops++;

            }

            if(startFuel < 0) return -1;
            que.offer(fuel);
            prevMile = pos;
        }

        startFuel -= target - prevMile;

        while(!que.isEmpty() && startFuel<0){
            startFuel += que.poll();
            stops++;
        }

        return startFuel < 0 ? -1 : stops;
    }
}