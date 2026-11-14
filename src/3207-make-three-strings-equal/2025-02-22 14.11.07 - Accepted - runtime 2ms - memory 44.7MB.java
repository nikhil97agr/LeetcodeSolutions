class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int ind = 0;
        int min = Math.min(s1.length(), Math.min(s2.length(), s3.length()));

        while(ind < min){
            if(s1.charAt(ind) == s2.charAt(ind) && s2.charAt(ind) == s3.charAt(ind)){
                ind++;
            }else{
                break;
            }
        }

        if(ind == 0) return -1;

        return s1.length() - ind + s2.length() - ind + s3.length() - ind;
    }
}