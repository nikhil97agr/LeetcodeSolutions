class Solution {
    public String getEncryptedString(String s, int k) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        
        for(int i=0;i<n;i++){
            int next = (i+k)%n;
            res.append(s.charAt(next));
        }
        
        return res.toString();
    }
}