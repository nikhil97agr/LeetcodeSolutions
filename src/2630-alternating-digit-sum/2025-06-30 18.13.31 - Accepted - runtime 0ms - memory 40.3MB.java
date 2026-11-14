class Solution {
    public int alternateDigitSum(int n) {
        int sign = 1;
        List<Integer> dig = new ArrayList<>();
        while(n > 0){
            dig.add(n%10);
            n/=10;
        }
        int ans= 0;
        for(int i=dig.size()-1;i>=0;i--){
            ans = ans + sign*dig.get(i);
            sign*=-1;
        }

        return ans;
    }
}