package ambiguous_coordinates_834;

import java.util.*;
class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
         s= s.substring(1, n-1);
         n = s.length();
         solve(0, new StringBuilder(), new StringBuilder(), true, s.toCharArray(), n, result);

         return result;
    }

    private void solve(int i, StringBuilder s1, StringBuilder s2, boolean first, char ch[], int n, List<String> result){
        if(i==n){
            if(isValid(s1) && isValid(s2)){
                String ans = "(" + s1.toString()+", "+s2.toString()+")";

                result.add(ans);
            }

            return;
        }

        if(first){
            add(s1, ch[i]);
            solve(i+1, s1, s2, first, ch, n, result);
            delete(s1);
            add(s1, '.');
            add(s1,ch[i]);
            solve(i+1, s1, s2, first, ch, n, result);
            delete(s1);
            delete(s1);
            solve(i, s1, s2, false, ch,n, result);
        }else{
            add(s2, ch[i]);
            solve(i+1, s1, s2, false, ch, n, result);
            delete(s2);
            add(s2, '.');
            add(s2, ch[i]);
            solve(i+1, s1, s2, first, ch, n, result);
            delete(s2);
            delete(s2);

        }

    


    }
    private boolean isValid(StringBuilder sb){
        char ch[] = sb.toString().toCharArray();
        int n =ch.length;
        if(n ==0 || ch[0] == '.' || ch[n-1] == '.') return false;
        int cnt = 0;
        for(char c : ch) if(c=='.') cnt++;
        if(cnt > 1) return false;
        if(n==1) return true;
        if(ch[0] == '0' && ch[1] != '.') return false;
        int ind = -1;
        int zero = 0;

        for(int i=0;i<n;i++){
            if(ch[i] == '.'){
                ind  = i;
            }
            if(ch[i] != '0' && ch[i]!='.') zero++;
        }
        if(ind == -1) return true;
        if(zero  == 0) return false;
        if(ch[n-1] == '0') return false;
        
        return true;
    }

    private void add(StringBuilder sb, char c){
        sb.append(c);
    }

    private void delete(StringBuilder sb){
        sb.deleteCharAt(sb.length() - 1);
    }
}