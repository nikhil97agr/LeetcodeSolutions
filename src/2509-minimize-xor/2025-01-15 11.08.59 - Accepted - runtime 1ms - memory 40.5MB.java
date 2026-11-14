class Solution {
    public int minimizeXor(int num1, int num2) {
        int count = 0;
        int bits[] = new int[33];
        while(num2>0){
            int bit = num2%2;
            if(bit==1){
                count++;
            }
            num2/=2;
        }
        int ind = 0;
        while(num1>0){
            int bit = num1%2;
            bits[ind++] =bit;
            num1/=2;
        }
        int result[] = new int[33];
        ind = 32;
        while(ind>=0 && count >0){
            if(bits[ind]==1){
                result[ind] = 1;
                count--;
            }
            ind--;
        }
        ind = 0;
        while(count>0){
            if(result[ind]==0){
                result[ind] = 1;
                count--;
            }
            ind++;
        }

        int ans = 0;
        for(int i=0;i<33;i++){
            if(result[i]==1){
                ans += 1<<i;
            }
        }
        return ans;

    }
}