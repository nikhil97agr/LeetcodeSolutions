package minimum_swaps_to_make_strings_equal_1369;

class Solution {
    public int minimumSwap(String s1, String s2) {
        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();
        int ans = 0;
        int n = s1.length();
        for(int i=0;i<n;i++){
            if(ch1[i] == ch2[i]) continue;
            boolean result = false;
            for(int j=i+1;j<n;j++){
                if(ch1[j] == ch1[i] && ch2[j] == ch2[i]){
                    ans++;
                    char temp = ch1[i];
                    ch1[i] = ch2[j];
                    ch2[j] = temp;
                    result = true;
                    break;
                }
            }

            if(result) continue;
            for(int j=i+1;j<n;j++){
                if(ch1[j] == ch2[i] && ch1[i] == ch2[j]){
                    ans+=2;
                    char temp = ch1[i];
                    ch1[i] = ch1[j];
                    ch1[j] = temp;
                    result = true;
                    break;
                }
            }
            if(result) continue;
            return -1;
        }

        return ans;
    }
}