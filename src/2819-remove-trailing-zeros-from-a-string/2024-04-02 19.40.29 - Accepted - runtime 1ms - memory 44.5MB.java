class Solution {
    public String removeTrailingZeros(String num) {
        int ind = num.length()-1;
        while(ind >=0 && num.charAt(ind)=='0')ind--;
        return ind < 0 ? "" : num.substring(0, ind+1);
    }
}