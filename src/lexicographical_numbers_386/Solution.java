package lexicographical_numbers_386;

import java.util.*;
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i=1;i<=9;i++){
            solve(result, i,n);
        }
        return result;
    }

    private void solve(List<Integer> result, int num, int n){
        if(num > n) return;

        result.add(num);

        for(int i=0;i<=9;i++){
            int next = num*10 + i;
            if(next > n) return;
            solve(result,num*10 + i, n);
        }
    }
}
