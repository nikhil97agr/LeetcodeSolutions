package distance_between_bus_stops_1287;

class Solution {
    public int distanceBetweenBusStops(int[] dist, int start, int dest) {
        int d1 = 0;
        int d2 = 0;
        int n = dist.length;
        for(int i=start;i!=dest;i++){
            d1 += dist[i];
            if(i == n-1) i=-1;
        }

        for(int i=start;i!=dest;i--){
           

            if(i==0){
                i = n;
            }
            d2 += dist[i-1];
        }

        return Math.min(d1, d2);
    }
}