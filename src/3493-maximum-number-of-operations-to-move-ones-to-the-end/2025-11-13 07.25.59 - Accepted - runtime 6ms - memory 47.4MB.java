class Solution {
    public int maxOperations(String s) {
        int ans = 0;
        char ch[] = s.toCharArray();

        if(s.length() ==1 ) return 0;

        int cnt = 0;
        int zero = 0;
        for(char c : ch){
            if(c=='1'){
                if(zero !=0){
                    ans+= cnt;
                    zero = 0;
                }
                cnt++;
            }else{

                zero++;
            }
        }
        if(s.charAt(s.length()-1)=='0'){
            ans += cnt;
        }
        return ans;

    }
}