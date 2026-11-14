class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int n = s.length();
        int m = strs.length;
        boolean ans[] = new boolean[m];
        int pre[] = new int[n + 1];
        for(int i=0;i<n;i++){
            pre[i + 1] = pre[i];
            if(s.charAt(i) == '0'){
                pre[i+1]++;
            }
        }
        int one = n - pre[n];

        for(int i=0;i<m;i++){
            if(check(pre, strs[i].toCharArray(), one)){
                ans[i] = true;
            }
        }

        return ans;
    }


    private boolean check(int pre[], char c2[], int ones){
        int o = 0;
        int w = 0;
        for(char c : c2){
            if(c == '1'){
                o++;
            }else if(c == '?'){
                w++;
            }
        }

        int diff = ones - o;
        if(diff < 0 || diff > w){
            return false;
        }

        int wVis = 0;
        int z = 0;
        for(int i=0;i<c2.length;i++){
            if(c2[i] == '0'){
                z++;
            }else if(c2[i] == '?'){
                wVis++;

                if(wVis <= w - diff){
                    z++;
                }
            }

            if(z < pre[i + 1]){
                return false;
            }
        }

        return true;
    }
}