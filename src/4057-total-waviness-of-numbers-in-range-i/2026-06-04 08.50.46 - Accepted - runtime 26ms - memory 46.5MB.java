class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for(int i= num1;i<=num2;i++){
            ans += cnt(i);
        }

        return ans;
    }

    private int cnt(int num){
        char ch[] = (""+num).toCharArray();
        int ans = 0;
        for(int i=1;i<ch.length-1;i++){
            if(ch[i] > ch[i-1] && ch[i] > ch[i+1]){
                ans++;
                continue;
            }

            if(ch[i] < ch[i-1] && ch[i] < ch[i+1]){
                ans++;
                continue;
            }
        }

        return ans;
    }
}