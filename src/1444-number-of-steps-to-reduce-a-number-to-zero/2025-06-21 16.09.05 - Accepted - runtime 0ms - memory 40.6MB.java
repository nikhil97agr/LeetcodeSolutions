class Solution {
    public int numberOfSteps(int num) {
        int ans = 0;
        while(num > 0){
            while(num > 0 && num%2==0){
                num /=2;
                ans++;
            }
            if(num > 0){
                num--;
                ans++;
            }
        }

        return ans;
    }
}