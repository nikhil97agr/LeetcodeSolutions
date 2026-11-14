class Solution {
    public int countBinaryPalindromes(long n) {
        if(n == 0) return 1;
        if(n == 1) return 2;
        int len = Long.toBinaryString(n).length();
        int ans = 2;
        for(int l =2;l<len;l++){
            ans += 1<<((l + 1)/2 -1 );
        }
        

        return ans + dfs(Long.toBinaryString(n).toCharArray(), new char[len], 0, len -1);
        
    }

    private int dfs(char n[], char m[], int start, int end){
        if(start > end){
            if(Arrays.equals(n, m)) return 1;
            for(int i=0;i<n.length;i++){
                if(n[i] > m[i]){
                    return 1;
                }

                if(n[i] < m[i]){
                    return 0;
                }
            }

            

            
        }

        if(n[start] == '1'){
            int res = 0;
            if( start > 0){
                res += (1 << ((end-start)/2));
            }

            m[start] = m[end] = '1';
            res += dfs(n, m, start + 1, end - 1);
            return res;
        }else{
            m[start] = m[end] = '0';
            return dfs(n, m, start+1, end - 1);
        }
    }
}


/**
 1 -> 0, 1
 2 -> 10, 11
 3 -> 100, 101, 110, 111
 4 -> 1000, 1001, 1010, 1011, 1100, 1101, 1110, 1111



 */