class Solution {
    public String largestGoodInteger(String num) {
        String result = "";
        for(int i=0;i<num.length()-2;i++){
            String temp = num.substring(i, i+3);
            if(temp.charAt(0)== temp.charAt(1) && temp.charAt(1)==temp.charAt(2)){
                if(result.compareTo(temp)<0){
                    result = temp;
                }
                
            }
        }
        return result;
    }
}