class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();

        int m = station.length();

        if(n == 1) return 0;

        int l[] = new int[n];
        int r[] = new int[n];

        int ind = 0;
        for(int i=0;i<n;i++){
            while(ind < m && station.charAt(ind) != skill.charAt(i)){
                ind++;
            }

            l[i] = ind;
            ind++;
        }

        ind = m- 1;
        for(int i = n-1;i>=0;i--){
            while(ind >=0 && station.charAt(ind) != skill.charAt(i)){
                ind--;
            }

            r[i] = ind;
            ind--;
        }

        int ans = 0;

        for(int i=1;i < n;i++){
            ans = Math.max(ans, r[i] - l[i-1]);
        }

        return ans;
        
    }

    private boolean possible(char ch[], int ind[][], int mid, int n){
        int first = ch[0] - 'a';
        int curr = ind[0][first];

        if(curr == -1) return false;

        for(int i=1;i<n;i++){
            int cInd = ch[i] - 'a';
            int req = curr + 1;
            if(req >= ind.length - 1){
                return false;
            }

            int next = ind[req][cInd];
            if(next == -1 || next - curr > mid){
                return false;
            }

            curr = next;
        }

        return true;
    }
}