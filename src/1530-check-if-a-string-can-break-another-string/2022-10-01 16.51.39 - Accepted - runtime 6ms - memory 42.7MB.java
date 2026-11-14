class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();
        int c1[] = new int[26];
        int c2[] = new int[26];
        boolean r1 = false;
        boolean r2 = false;
        for(int i=0;i<n;i++){
            c1[s1.charAt(i)-'a']++;
            c2[s2.charAt(i)-'a']++;
        }
        
        int t1= 0;
        int t2=0;
        for(int i=0;i<26;i++){
            t1 += c1[i];
            t2 += c2[i];
            if(t1>t2){
                if(r2){
                    return false;
                }
                r1 = true;
            }else if(t2>t1){
                if(r1){
                    return false;
                }
                r2 =true;
            }
        }
        return true;
    }
}