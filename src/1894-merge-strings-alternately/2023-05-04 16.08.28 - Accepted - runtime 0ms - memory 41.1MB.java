class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i =0;
        int j =0;
        int m = word1.length();
        int n = word2.length();
        char result[] = new char[m+n];
        int k =0;
        while(i<m && j<n){
            if(i<=j){
                result[k++] = word1.charAt(i++);
            }else{
                result[k++] = word2.charAt(j++);
            }
        }
        while(i<m){
            result[k++] = word1.charAt(i++);
        }
        while(j<n){
            result[k++] = word2.charAt(j++);
        }

        return String.valueOf(result);
    }
}