class Solution {
    public int minChanges(int n, int k) {
        int cnt = 0;
        for(int i=0;i<32;i++){
            int b1 = n&(1<<i);
            int b2 = k&(1<<i);

            if(b2==0){
                if(b1 !=0) cnt++;
            }else{
                if(b1==0) return -1;
            }
        }

        return cnt;
    }
}