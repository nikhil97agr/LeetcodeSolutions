class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length() < 8) return false;
        boolean lower = false, upper = false, special = false, digit = false;

        for(int i=0;i<password.length() - 1;i++){
            if(password.charAt(i) == password.charAt(i+1)) return false;
        }

        for(char c : password.toCharArray()){
            if(c >= 'a' && c <= 'z') lower = true;
            else if(c>='A' && c <='Z') upper = true;
            else if(c>='0' && c <='9') digit = true;
            else special = true;
        }

        return upper && lower && special && digit;
    }
}