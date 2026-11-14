class Solution {
    public boolean isBalanced(String num) {
        int odd = 0;
        int even = 0;
        boolean e = true;
        for(char c : num.toCharArray()){
            int x = c-'0';
            if(e){
                even+=x;
            }else{
                odd+=x;
            }
            e=!e;
        }
        return odd == even;
    }
}