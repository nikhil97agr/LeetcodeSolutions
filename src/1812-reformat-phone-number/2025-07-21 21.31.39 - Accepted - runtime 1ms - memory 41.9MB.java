class Solution {
    public String reformatNumber(String number) {
        number = number.replace(" ", "");
        number = number.replace("-","");
        int n = number.length();
        StringBuilder res= new StringBuilder();
        int i=0;
        for(;i<n-4;i+=3){
            res.append(number.substring(i, i+3));
            res.append("-");
        }

        if(n-i==0){
            res.deleteCharAt(res.length()-1);
        }else if(n-i == 1 || n-i == 2 || n-i == 3){
            res.append(number.substring(i));
        }else{
            res.append(number.substring(i,i+2)).append("-").append(number.substring(i+2));
        }

        return res.toString();
    }
}