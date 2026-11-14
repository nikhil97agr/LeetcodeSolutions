class Solution {
    public int maxBalancedShipments(int[] weight) {
        int ans = 0;
        int max = 0;
        int n = weight.length;
        for(int i=0;i<n;i++){
            max = Math.max(max, weight[i]);

            if(weight[i] < max){
                ans++;
                max = 0;
            }
        }
        return ans;
    }
}