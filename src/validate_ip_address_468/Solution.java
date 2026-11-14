package validate_ip_address_468;

class Solution {
    public String validIPAddress(String queryIP) {

        if (ipV4(queryIP)) {
            return "IPv4";
        }
        if(ipV6(queryIP)) {
            return "IPv6";
        }

        return "Neither";
    }

    private boolean ipV6(String s){
        if(s.startsWith(":") || s.endsWith(":")) return false;
        String split[] = s.split(":");
        if(split.length != 8) return false;
        for(String st : split){
            if(st.isEmpty() || st.length() > 4) return false;
            for(char c : st.toCharArray()){
                if(!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean ipV4(String s){
        if(s.startsWith(".") || s.endsWith(".")) return false;
        String split[] = s.split("\\.");
        if(split.length != 4) return false;

        try{
            for(String st : split){
                if(st.startsWith("0") && st.length()!=1) return false;
                int val = Integer.parseInt(st);
                if(val < 0 || val > 255) return false;
            }
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}