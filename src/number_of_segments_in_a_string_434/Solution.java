package number_of_segments_in_a_string_434;

class Solution {
    public int countSegments(String s) {
        if(s.trim().length()==0){
            return 0;
        }
        int count = 0;
        int contSpace = 0;
        for(char c : s.trim().toCharArray()){
            if(c==' '){
                if(contSpace ==0){
                   count++; 
                }
                contSpace = 1;
                
            }else{
                contSpace = 0;
            }
        }
        count++;
        return count;
        
    }
}