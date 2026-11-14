package nearest_available_drone_4378;

class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int dist = 1_000_000;
        int ind = -1;
        int n = drones.length;
        for(int i=0;i<n;i++){
            int d[] = drones[i];
            int dd = dist(d, target);
            if(dd <= d[2] && dd < dist){
                dist = dd;
                ind = i;
            }
        }

        return ind;
    }
    private int dist(int d[], int target[]){
        return Math.abs(d[0] - target[0]) + Math.abs(d[1] - target[1]);
    }
}

