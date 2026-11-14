package make_string_a_subsequence_using_cyclic_increments_3018;

class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0;
        int j = 0;
        int n = str1.length();
        int m = str2.length();
        if (m > n)
            return false;

        while (i < n && j < m) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);
            if(c1 == c2){
                i++;
                j++;
            }else{
                if(c1 == 'z') c1 = 'a';
                else c1++;

                if(c1 == c2){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }


        }

        return j==m;
    }
}