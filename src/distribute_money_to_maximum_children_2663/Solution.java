package distribute_money_to_maximum_children_2663;

class Solution {
    public int distMoney(int m, int n) {
        if(m<n) return -1;
        if(m==n) return 0;
        if(n==1 && m==4) return -1;
        m-=n;
        int count = 0;
        for(int i=0;i<n;i++){
            if(i==n-1){
                if(m==3){
                    return count-1;
                }
                if(m==7) return count+1;
                return count;
            }
            if(m>=7){
                count++;
                m-=7;
                continue;
            }
            return count;
        }
        return -1;
    }
}