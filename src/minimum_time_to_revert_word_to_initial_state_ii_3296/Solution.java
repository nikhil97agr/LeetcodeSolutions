package minimum_time_to_revert_word_to_initial_state_ii_3296;

class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int z[] = zarray(word.toCharArray(), word.length());
        int n = word.length();
        int ans = 1;
        
        for(; ans * k < n; ans++){
            if(z[k * ans] >= n - k * ans){
                return ans;
            }
        }
        
        return ans;
    }
    
    private int[] zarray(char ch[], int n){
        int z[] = new int[n];
        int l =0;
        int r= 0;
        for(int i=1;i<n;i++){
            if( i > r){
                l = r= i;
                while(r < n && ch[r] == ch[r- l]){
                    r++;
                }
                z[i] = r - l;
                r--;
            }else{
                int k = i - l;
                if(z[k] < r - i + 1){
                    z[i] = z[k];
                }else{
                    l = i;
                    while(r < n && ch[r] == ch[r- l]){
                        r++;
                    }
                    
                    z[i] = r- l;
                    r--;
                }
            }
            
            
        }
        return z;
    }
}