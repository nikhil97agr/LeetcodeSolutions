package check_if_strings_can_be_made_equal_with_operations_ii_2978;

class Solution {
    public boolean checkStrings(String s1, String s2) {
        int even[] = new int[26];
        int odd[] = new int[26];
        int n = s1.length();
        for(int i=0;i<n;i++){
            if(i%2==0){
                even[s1.charAt(i)-'a']++;
            }else{
                odd[s1.charAt(i)-'a']++;
            }
        }

        for(int i=0;i<n;i++){
            int ind = s2.charAt(i)-'a';
            if(i%2==0){
                if(even[ind]!=0) even[ind]--;
                else return false;
            }else{
                if(odd[ind]!=0) odd[ind]--;
                else return false;
            }
        }

        return true;
    }
}