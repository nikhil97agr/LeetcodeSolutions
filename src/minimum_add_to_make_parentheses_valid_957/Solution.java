package minimum_add_to_make_parentheses_valid_957;

class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int open = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                open++;
            }else{
                if(open == 0){
                    ans++;
                }else{
                    open--;
                }
            }
        }

        return ans + open;
    }
}