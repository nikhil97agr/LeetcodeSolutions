/** 
 * Definition of commonSetBits API (defined in the parent class Problem).
 * int commonSetBits(int num);
 */

public class Solution extends Problem {
    public int findNumber() {
        int ans = 0;
        for(int i=0;i<30;i++){
            int num = commonSetBits(1<<i);
            if(num == 1){
                ans |= (1<<i);
            }
        }

        return ans;
    }
}