class Solution {
    public int minPartitions(String n) {
        char curr  = '0';
        for(char c : n.toCharArray()){
            if(c > curr){
                curr = c;
            }
        }
        return curr-'0';
    }
}