class Solution {
    public List<String> validStrings(int n) {
        List<String> subs = new ArrayList<>();
        subs.add("0");
        subs.add("1");
        for(int i=1;i<n;i++){
            List<String> v = new ArrayList<>();
            for(String s: subs){
                v.add(s + "0");
                v.add(s + "1");
            }
            subs = v;
        }
        List<String> res = new ArrayList<>();
        for(String s: subs){
            boolean valid = true;
            for(int i=1;i<s.length();i++){
                if(s.charAt(i) == '0' && s.charAt(i-1) == '0'){
                    valid = false;
                    break;
                }
            }
            if(valid){
                res.add(s);
            }
        }
        return res;
    }
}