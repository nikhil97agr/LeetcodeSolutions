package convert_date_to_binary_3567;

class Solution {
    public String convertDateToBinary(String date) {
        String d[] = date.split("-");
        
        StringBuilder res= new StringBuilder();
        for(String s : d){
            String binary = Integer.toBinaryString(Integer.valueOf(s));
            
            res.append(binary).append("-");
            
        }
        
        return res.substring(0, res.length()-1).toString();
    }
}