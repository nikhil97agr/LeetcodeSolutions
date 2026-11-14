package minimum_insertions_to_balance_a_parentheses_string_1648;

class Solution {
    public int minInsertions(String s) {
      int res = 0;
      int open = 0;

      int n = s.length();
      for(int i=0;i<n;i++){
        if(s.charAt(i) == '('){
            open++;
            continue;
        }
        if(i<n-1){
            if(s.charAt(i+1) == ')'){
                if(open==0){
                    res++;
                }else{
                    open--;
                }
                i++;
            }else{
                if(open==0){
                    res+=2;
                }else{
                    open--;
                    res++;
                }
            }
            continue;
        }
        if(open ==0){
            res+=2;
        }else{
            res++;
            open--;
        }
      }  

      if(open!=0){
        res += (open<<1);
      }
      return res;
    }
}