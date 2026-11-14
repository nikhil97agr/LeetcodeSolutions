class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int s1 = calc(player1);
        int s2 = calc(player2);
        return s1 == s2 ? 0  : s1 > s2 ? 1 : 2;
        
    }

    private int calc(int arr[]){
        int score = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(i <= 0){
                score += arr[i];
                continue;
            }

            if(i<=1){
                if(arr[i-1] ==10) score += 2*arr[i];
                else score+= arr[i];
                continue;
            }

            if(arr[i-1] == 10 || arr[i-2] == 10){
                score += 2*arr[i];
            }else{
                score += arr[i];
            }
        }
        return score;
    }
}