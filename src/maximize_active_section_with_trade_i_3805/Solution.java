package maximize_active_section_with_trade_i_3805;

import java.util.*;
class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int total = 0;
        List<int[]> list= new ArrayList<>();
        char prev = s.charAt(0);
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c== prev){
                cnt++;
            }else{
                if(prev == '1'){
                    total += cnt;
                }
                list.add(new int[]{prev - '0', cnt});
                cnt = 1;
                prev = c;
            }
        }

        if(prev == '1'){
            total += cnt;
        }
        list.add(new int[]{prev - '0', cnt});
        cnt = total;
        int n = list.size();
        for(int i=0;i<n;i++){
            if(list.get(i)[0] == 1){
                if(i !=0 && i != n-1){
                    cnt = Math.max(cnt, total + list.get(i-1)[1] + list.get(i+1)[1]);
                }
            }
        }

        return cnt;
       
    }
}