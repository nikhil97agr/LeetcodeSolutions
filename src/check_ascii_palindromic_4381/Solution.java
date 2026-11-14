package check_ascii_palindromic_4381;

class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        for(int x : s.toCharArray()){
            sb.append(String.format("%8s", Integer.toBinaryString(x)).replace(' ', '0'));
        }

        int i=0;
        int j = sb.length() - 1;

        while( i < j){
            if(sb.charAt(i) != sb.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}