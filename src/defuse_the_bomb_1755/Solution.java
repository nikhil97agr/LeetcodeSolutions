package defuse_the_bomb_1755;

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            if(k > 0){
                int j = (i+1)%n;
                int cnt = 0;
                int sum = 0;
                while(cnt < k){
                    cnt++;
                    sum+= code[j];
                    j++;
                    j%=n;
                }
                ans[i] = sum;
            }else if(k < 0){
                int j = i==0 ? n-1 : i-1;

                int sum = 0;
                int cnt = 0;
                while(cnt < Math.abs(k)){
                    sum += code[j];
                    j = j==0 ? n-1 : j-1;
                    cnt++;
                    
                }
                ans[i] = sum;
            }else{
                ans[i] = 0;
            }
        }
        return ans;
    }
}