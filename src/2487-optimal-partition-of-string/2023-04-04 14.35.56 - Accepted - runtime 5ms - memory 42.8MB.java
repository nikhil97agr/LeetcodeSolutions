class Solution {
    public int partitionString(String s) {
        int mask = 0;
        int count =1;
        for(char c : s.toCharArray()){
            if((mask&(1<<c))!=0){
                count++;
                mask = 0;
                
            }

            mask ^= (1<<c);
        }
        return count;
    }
}