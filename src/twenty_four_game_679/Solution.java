package twenty_four_game_679;

class Solution {
    public boolean judgePoint24(int[] cards) {
        double arr[] = new double[]{1d*cards[0], 1d*cards[1], 1d*cards[2], 1d*cards[3]};
        return solve(arr);
    }

    private boolean solve(double arr[]){
        if(arr.length == 1 ) return Math.abs(arr[0]-24d)<0.001;

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                double b[] = new double[arr.length-1];
                int ind = 0;
                for(int k=0;k<arr.length;k++){
                    if(i!=k && j!=k){
                        b[ind++] = arr[k];
                    }
                }

                for(double d : compute(arr[i], arr[j])){
                    b[b.length-1] =d;
                    if(solve(b)) return true;
                }
            }
        }

        return false;
    }

    private double[] compute(double x, double y){
        return new double[]{x+y, x-y, y-x, x*y, x/y, y/x};
    }
}