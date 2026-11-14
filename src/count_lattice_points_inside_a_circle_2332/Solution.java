package count_lattice_points_inside_a_circle_2332;

class Solution {
    public int countLatticePoints(int[][] circles) {
        int n = 0;
        int m=0;
        int ans = 0;
        for(int c[] : circles){
            n = Math.max(n, c[0] + c[2]);
            m = Math.max(m, c[1] + c[2]);
        }

        for(int y = 0;y<=m;y++){
            for(int x =0;x<=n;x++){
                if(inside(circles, x, y)) ans++;
            }
        }
        

        return ans;
    }

    private boolean inside(int arr[][], int x, int y){
        for(int c[] : arr){
            int dist =(int) Math.pow(c[0] - x,2) + (int)Math.pow(c[1] -y, 2);

            if(dist <= c[2]*c[2]) return true;
        }
        return false;
    }
}