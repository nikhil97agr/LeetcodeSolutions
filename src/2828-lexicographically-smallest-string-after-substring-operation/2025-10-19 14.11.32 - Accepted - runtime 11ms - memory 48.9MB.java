class Solution {
    public String smallestString(String s) {
        char ch[] = s.toCharArray();
        int n = s.length();
        int ind = -1;
        for(int i=0;i<n;i++){
            if(ch[i] != 'a'){
                ind = i;
                break;
            }
        }

        if(ind == -1){
            ch[n-1] = 'z';
            return new String(ch);
        }

        for(int j=ind;j<n;j++){
            if(ch[j] != 'a'){
                ch[j]--;
            }else{
                break;
            }
        }

        return new String(ch);
    }
}