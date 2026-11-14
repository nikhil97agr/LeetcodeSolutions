class Solution {
    public long maxWeight(int[] pizzas) {
        long ans = 0;
        int n = pizzas.length;
        Arrays.sort(pizzas);
        int total = n/4;
        int odd = (total+1)/2;
        int j= n-1;
        while(odd-- > 0){
            ans += pizzas[j];
            j--;
        }
        int left = total/2;
        while(left-- > 0){
            j--;
            ans += pizzas[j];
            j--;
        }
        return ans;
    }
}