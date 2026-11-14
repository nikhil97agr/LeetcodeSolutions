class Solution {
    public String smallestBeautifulString(String s, int k) {
        int n = s.length();
        char res[] = s.toCharArray();
        int i = n-1;
        for(;i>=0;i--){
            int ind = (res[i] - 'a') + 1;
            if(ind >=k || res[i] == 'z'){
                continue;
            }
            boolean found= false;
            for(char c = (char)(ind + 'a'); c<('a'+ k);c++){
                if((i-1 >=0 && res[i-1] == c) || (i-2 >=0 && res[i-2] == c)){
                    continue;
                }
                res[i] = c;
                found= true;
                break;
            }



            if(!found){
                continue;
            }
            int j =i + 1;
            char seq[] = new char[]{'a','b','c'};
             ind = 0;
            if(j < n && i-1 >=0 && res[i-1] == 'a'){
                res[j] = 'b';
                j++;
            }
            for(;j<n;j++){
                if(seq[ind] - 'a' >= k) return "";
                if(j -2 >=0 && res[j-2] == seq[ind]){
                    ind++;
                    j--;
                    ind%=3;
                    continue;
                }
                res[j] = seq[ind];
                ind++;
                ind%=3;
            }
            return new String(res);
        }

        return "";
    }
}