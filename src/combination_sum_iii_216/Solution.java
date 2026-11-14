package combination_sum_iii_216;

import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> dp = new HashSet<>();
        boolean visited[] = new boolean[10];
        for(int i=1;i<=9;i++)
        generate(k, n,i,visited, new ArrayList<>(), result, dp);
        return result;
    }

    private void generate(int k, int n, int num,boolean visited[], List<Integer> temp, List<List<Integer>> result, Set<String> dp){
        if(n<0){
            return;
        }
        
        if(k==0){
            if(n==0){
                if(!dp.contains(Arrays.toString(visited))){
                    result.add(new ArrayList<>(temp));
                    dp.add(Arrays.toString(visited));
                }
                

            }
            return;
        }

        for(int i=num;i<=9;i++){
            if(n>=i){
                if(!visited[i]){
                    visited[i] = true;
                    temp.add(i);
                    generate(k-1, n-i, i+1,visited, temp, result, dp);
                    visited[i] = false;
                    temp.remove(temp.size()-1);
                }
            }else{
                break;
            }
        }
    }
}