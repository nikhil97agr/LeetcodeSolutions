class Solution {
    public long countPalindromePaths(List<Integer> parent, String s) {
        int n= parent.size();
        List<Integer> list[] = new ArrayList[n];
        for(int i=0;i<n;i++) list[i] =new ArrayList<>();

        for(int i=1;i<n;i++){
            int p = parent.get(i);
            list[p].add(i);
        }
        int mask[] = new int[n];
        Map<Integer, Integer> maskCount = new HashMap<>();
        dfs(mask, 0, list, 0, maskCount, -1, s.toCharArray());

        long ans = 0;
        for(int i=0;i<n;i++){
            int curr = mask[i];

            ans += maskCount.get(curr) - 1;

            for(int j=0;j<26;j++){
                int newMask = (curr ^ (1 << j));

                ans += maskCount.getOrDefault(newMask, 0);
            }
        }

        return ans/2;
    }

    private void dfs(int mask[], int currMask, List<Integer> list[], int ind, Map<Integer, Integer> map, int par, char ch[]){
        for(int child : list[ind]){
            if(child !=par){
                int newMask = (currMask ^ ( 1 << (ch[child] - 'a')));
                dfs(mask, newMask, list, child, map, ind, ch);
            }
        }

        mask[ind] = currMask;

        map.merge(currMask, 1, Integer::sum);
    }
}