package split_two_strings_to_make_palindrome_1739;

class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return isPal(a.toCharArray(), b.toCharArray()) || isPal(b.toCharArray(), a.toCharArray());
    }
    private boolean isPal(char a[], char b[]){
        int i=0;
        int j=b.length - 1;
        while( i< j && a[i] == b[j]){
            i++;
            j--;
        }

        if(i < j){
            int i1 = i;
            int j1 = j;
            while(i1 < j1 && a[i1] == a[j1]){
                i1++;
                j1--;
            }
            if(i1 < j1){
                i1 = i;
                j1 = j;
                while(i1 < j1 && b[i1] == b[j1]){
                    i1++;
                    j1--;
                }

                if(i1 < j1) return false;
                return true;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }
}