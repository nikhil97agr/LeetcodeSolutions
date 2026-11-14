class Solution {
    public int maxDistance(String[] words) {
        int ans = 0;
        int n = words.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(words[i].equals(words[j])) continue;

                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}