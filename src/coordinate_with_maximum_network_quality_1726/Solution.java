package coordinate_with_maximum_network_quality_1726;

class Solution {

    private int dist(int a[], int b[]){
        return (int)(Math.pow(a[0]-b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
    private boolean valid(int a[], int b[], int radius){
        int dist = dist(a, b);
        return dist <= radius* radius;
    }

    private int quality(int a[], int b[]){
        int dist = dist(a,b);
        double x = Math.sqrt(dist) + 1;
        return (int)(b[2]/x);
    }
    public int[] bestCoordinate(int[][] towers, int radius) {
        int n = towers.length;
        int ans = 0;
        int coor[] = new int[]{50, 50};
        for(int i=0;i<=50;i++){
            for(int j=0;j<=50;j++){
                int curr[] = new int[]{i,j};
                int total = 0;
                for(int k=0;k<n;k++){
                    if(valid(curr, towers[k], radius)){
                        total += quality(curr, towers[k]);
                    }
                }

                if(total > ans){
                    ans = total;
                    coor = curr;
                }else if(total == ans){
                    if(curr[0] < coor[0]){
                        coor = curr;
                    }else if(curr[0] == coor[0] && curr[1] < coor[1]){
                        coor = curr;
                    }
                }

            }
        }



        return coor;


    }
}