class Solution {
    public String removeDigit(String number, char digit) {
        for(int i=0;i<number.length()-1;i++){
            if(number.charAt(i) == digit && number.charAt(i+1) > number.charAt(i)){
                return number.substring(0,i) + number.substring(i+1);
            }   
        }

        int ind = number.lastIndexOf(digit);
        if(ind != -1){
            return number.substring(0, ind) + number.substring(ind + 1);
        }
        return number;
    }
}