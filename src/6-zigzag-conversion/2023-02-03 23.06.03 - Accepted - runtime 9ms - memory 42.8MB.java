class Solution {
    public String convert(String s, int numRows) {
        List<Character>[] result = new ArrayList[numRows];
        for(int i=0;i<numRows;i++){
            result[i] = new ArrayList<Character>();
        }
        int sign = 1;
        int ind = 0;
        if(numRows==1){
            return s;
        }
        for(char c : s.toCharArray()){
            result[ind].add(c);
            
            if(ind==numRows-1){
                sign =-1;
            }else if(ind==0){
                sign = 1;
            }
            ind += sign;


        }
        StringBuilder ans = new StringBuilder();
        for(List<Character> temp : result){
            for(char c : temp){
                ans.append(""+c);
            }
        }
        
        return ans.toString();

    }
}