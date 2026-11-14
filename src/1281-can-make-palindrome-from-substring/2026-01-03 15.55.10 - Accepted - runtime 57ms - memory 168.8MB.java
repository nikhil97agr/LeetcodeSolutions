class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result= new ArrayList<>();
        int n =s.length();
        int cnt[][] = new int[n+1][26];

        for(int i=0;i<n;i++){
            int ind = s.charAt(i) - 'a';
            cnt[i+1] = cnt[i].clone();
            cnt[i+1][ind]++;
        }

        for(int q[] : queries){
            int l = q[0];
            int r= q[1];
            int k =q[2];
            int op = 0;
            int len = r - l + 1;
            int diff[] = cnt[r+1].clone();
            for(int i=0;i<26;i++){
                diff[i] -= cnt[l][i];
            }



            for(int i=0;i<26;i++){
                diff[i]%=2;
            }

            int replace = 0;
            for(int x : diff) replace += x;

            int o = replace/2;
            if(o > k){
                result.add(false);
            }else{
                result.add(true);
            }

            
        }

        return result;
    }
}