class Solution {
    public int prefixConnected(String[] words, int k) {
        int n = words.length;
        int parent[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        Map<String, Integer> map = new HashMap<>();
        for(String s : words){
            if(k > s.length()) continue;
            String sub = s.substring(0, k);
            map.merge(sub, 1, Integer::sum);
        }
        int ans = 0;
        for(int val : map.values()){
            if(val > 1) ans++;
        }

        return ans;
    }
    
}