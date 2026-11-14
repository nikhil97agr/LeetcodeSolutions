class Solution {
    public String shortestSuperstring(String s1, String s2) {
        if(s1.length() > s2.length()){
            return shortestSuperstring(s2, s1);
        }

        if(s2.contains(s1)) return s2;
        String r1 = getResult(s1, s2);
        String r2 = getResult(s2, s1);
        

        return r1.length() > r2.length() ? r2 : r1;
    }

    public String getResult(String s1, String s2){
        int n = s1.length();
        String result = s1+s2;
        for(int i=n-1;i>=0;i--){
            String sub1 = s1.substring(i);
            if(s2.startsWith(sub1)){
                String sub = s1.substring(0, i) + sub1 + s2.substring(n-i);
                if(sub.length() < result.length()){
                    result = sub;
                }
            }
        }

        return result;
    }
}