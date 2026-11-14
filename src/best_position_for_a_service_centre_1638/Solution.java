package best_position_for_a_service_centre_1638;

class Solution {
    public double getMinDistSum(int[][] positions) {
        double ans = Double.MAX_VALUE;
        double sx = -1;
        double sy = -1;
        int n = positions.length;
        for(int x=0;x<=100;x++){
            for(int y=0;y<=100;y++){
                double sum = 0d;
                for(int p[] : positions){
                    sum += getSum(x, y, p[0], p[1]);
                }
                if(sum < ans){
                    ans = sum;
                    sx = x;
                    sy = y;
                }
            }
        }

        double delta = 100;
        for(int i=0;i<1000;i++){
            int dir[] = new int[]{0,1,0,-1,0};
            boolean found = false;;
            for(int j=0;j<4;j++){
                double nx = sx + dir[j] * delta;
                double ny = sy + dir[j+1] * delta;
                double score = getScore(nx, ny, positions);

                if(score < ans){
                    ans = score;
                sx = nx;
                sy = ny;
                found = true;
                break;
                }
            }

            if(!found){
                delta/=2;
            }
        }

        return ans;
    }

    private double getScore(double x, double y, int [][]positions){
        double score = 0;
        for(int p[] : positions){
            score += getSum(x,y, p[0], p[1]);
        }

        return score;
    }

    private double getSum(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1- x2,2) + Math.pow(y1-y2,2)); 
    }
}