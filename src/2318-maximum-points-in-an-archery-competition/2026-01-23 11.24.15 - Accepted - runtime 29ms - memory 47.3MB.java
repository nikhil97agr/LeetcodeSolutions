class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int ans[] = new int[12];
        int score = 0;

        for(int i=0;i<(1<<12);i++){
            int sum = 0;
            boolean possible= true;
            int arrows = numArrows;
            int temp[] = new int[12];
            for(int j=1;j<12;j++){
                if((i & (1<<j)) ==0) continue;

                int a= aliceArrows[j];
                if(arrows >= a+1){
                    arrows -= a+1;
                    sum += j;
                    temp[j] = a+1;
                }else{
                    possible= false;
                    break;
                }
            }

            if(possible){
                if(sum > score){
                    score = sum;

                    ans = temp;
                    ans[0] = arrows;
                }
            }
        }
        return ans;
    }
}