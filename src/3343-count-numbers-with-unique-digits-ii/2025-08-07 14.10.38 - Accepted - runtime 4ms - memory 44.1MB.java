class Solution {
    public int numberCount(int a, int b) {
        int ans= 0; 
        for(int i=a;i<=b;i++){
            ans += check(i);
        }

        return ans;
    }

    private int check(int x){
        boolean vis[] = new boolean[10];
        while(x > 0){
           int dig = x%10;
           if(vis[dig]) return 0;
           vis[dig] = true;
           x/=10;
        }

        return 1;
    }
}