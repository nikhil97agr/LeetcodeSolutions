class Solution {
    public int beautifulSubstrings(String s, int k) {
        int v =0;
        int c = 0;
        Set<Character> set = new HashSet<>();
        int ans = 0;
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++){
            v=0;
            c=0;
            for(int j=i;j<s.length();j++){
                if(set.contains(s.charAt(j))){
                    v++;
                }else{
                    c++;
                }
                
                if(v==c && (v*c)%k==0) ans++;
            }
        }
        return ans;
    }
}