package cracking_the_safe_754;

import java.util.*;
class Solution {
    public String crackSafe(int n, int k) {
        if(n==1 && k==1) return "0";
        Set<String> visited = new HashSet<>();
        StringBuilder result = new StringBuilder();

        String s = "";
        for(int i=0;i<n-1;i++){
            s += 0;
        }
        solve(s, k, visited, result);
        return result.append(s).toString();
    }

    private void solve(String s, int k, Set<String> visited,StringBuilder result){
        for(int i=0;i<k;i++){
            String val = s+i;
            if(!visited.contains(val)){
                visited.add(val);
                solve(val.substring(1), k, visited, result);
                result.append(i);
            }
        }
    }
}