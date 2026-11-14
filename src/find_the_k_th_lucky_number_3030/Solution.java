package find_the_k_th_lucky_number_3030;

class Solution {
    public String kthLuckyNumber(int k) {
        StringBuilder res = new StringBuilder();
        for(int i=k+1;i>1;i/=2){
            if(i%2==0) res.append(4);
            else res.append(7);
        }

        return res.reverse().toString();
        
    }
}