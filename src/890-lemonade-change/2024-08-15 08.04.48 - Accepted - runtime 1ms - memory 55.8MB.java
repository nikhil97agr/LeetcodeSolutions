class Solution {
    public boolean lemonadeChange(int[] bills) {
     int coin5=0;
        int coin10=0;

        for(int b : bills){
            if(b== 5) coin5++;
            else if(b==10){
                if(coin5> 0){
                    coin10++;
                    coin5--;
                }else{
                    return false;
                }
            }else{
                if(coin5 > 0 && coin10 > 0){
                    coin10--;
                    coin5--;
                }else if(coin5 >=3){
                    coin5-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}