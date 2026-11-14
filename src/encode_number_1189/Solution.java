package encode_number_1189;

class Solution {
    public String encode(int num) {
        return num > 0 ? encode((num-1)/2) + "10".charAt(num%2) : "";
    }
}