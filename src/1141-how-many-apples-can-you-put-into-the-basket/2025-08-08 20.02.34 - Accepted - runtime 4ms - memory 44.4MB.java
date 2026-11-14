class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int max = 5000;
        int ans = 0;

        int i=0;
        while(i < weight.length && max >= weight[i]){
            max -= weight[i];
            ans++;
            i++;
        }

        return ans;
    }
}