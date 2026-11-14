package factor_combinations_254;

import java.util.*;
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> list = new ArrayList<>();
        solve(n, list, new ArrayList<>(), false);
        return list;
    }

    private void solve(int n, List<List<Integer>> result, List<Integer> list, boolean incl){
        
        if(incl){
            list.add(n);
            result.add(new ArrayList<>(list));
            list.remove(list.size()-1);
        }

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0 && (list.isEmpty() || i >= list.get(list.size() - 1))){
                list.add(i);
                solve(n/i, result, list, true);
                list.remove(list.size() - 1);

            }
        }
    }
}