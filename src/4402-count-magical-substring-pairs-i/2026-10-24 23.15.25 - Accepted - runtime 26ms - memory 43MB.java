class Solution {
    public int countMagicalPairs(String s) {
        int ans = 0;
        int n = s.length();
        char ch[] = s.toCharArray();
        for(int j=0;j<n-1;j++){

            int i= j;
            int k = j + 1;
            int left = 1 << get(ch[i]);
            int right = 1 << get(ch[k]);
            while(i >=0 && k < n){
                int cl = 0;
                int cr = 0;
                while( i >=0 && ((left >> get(ch[i])) & 1) == 1){
                    cl++;
                    i--;
                }

                while( k < n && ((right >> get(ch[k])) & 1) == 1){
                    cr++;

                    k++;

                }


                ans += cl * cr;
                if( i >=0 ){
                    left |= 1 << get(ch[i]);
                }

                if(k < n ){
                    right |= 1 << get(ch[k]);
                }

            }

        }

        return ans;
    }

    private int get(char ch){
        return ch - 'a';
    }
}