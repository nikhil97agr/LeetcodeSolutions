package prison_cells_after_n_days_994;

import java.util.*;
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i : cells){
            sb.append(i);

        }

        String state = sb.toString();
        int day = 0;
        while( !map.containsKey(state)){
            map.put(state, day);
            day++;
            state = nextState(state.toCharArray());
        }
        int start = map.get(state);
        int len = day - start;
        if(n >= start){
            n = start + (n-start)%len;
        }
        String res = "";
        for(String key : map.keySet()){
            if(map.get(key) == n){
                res = key;
                break;
            }
        }
        int ans[] = new int[8];
        for(int i=0;i<8;i++){
            ans[i] = res.charAt(i)-'0';
        }

        return ans;
    }

    private String nextState(char ch[]){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<8;i++){
            if(i==0 || i==7){
                sb.append('0');
            }else{
                if(ch[i-1] == ch[i+1]){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
            }
        }
        return sb.toString();
    }


}