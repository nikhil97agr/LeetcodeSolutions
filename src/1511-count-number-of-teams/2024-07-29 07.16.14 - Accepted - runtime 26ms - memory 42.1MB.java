class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        int n = rating.length;
        for(int i=1;i<n;i++){
            int small = 0;
            int large = 0;
            for(int j=i-1;j>=0;j--){
                if(rating[j] < rating[i]) small++;

            }

            for(int j=i+1;j<n;j++){
                if(rating[j] > rating[i]) large++;
            }

            ans+= small*large;
        }

        for(int i=1;i<n;i++){
            int small = 0;
            int large = 0;
            for(int j=i-1;j>=0;j--){
                if(rating[j] > rating[i]) large++;

            }

            for(int j=i+1;j<n;j++){
                if(rating[j] < rating[i]) small++;
            }

            ans+= small*large;
        }
        return ans;
    }
}