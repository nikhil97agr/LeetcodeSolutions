package defanging_an_ip_address_1205;

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        for(char c : address.toCharArray()){
            if(c=='.'){
                res.append("[.]");
            }else{
                res.append(c);
            }
        }

        return res.toString();
    }
}