class Solution {
    List<Integer> adjList[] = new ArrayList[26];
    public List<List<Integer>> supersequences(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        int ind = 0;
        for(String s : words){
            char c1 = s.charAt(0), c2 = s.charAt(1);
            if(!map.containsKey(c1)){
                map.put(c1, ind++);
            }

            if(!map.containsKey(c2)){
                map.put(c2, ind++);
            }
        }

        int m = map.size();
        char inp[] = new char[m];
        for(var entry : map.entrySet()){
            inp[entry.getValue()] = entry.getKey();
        }

        adjList = new ArrayList[m];
        for(int i=0;i<m;i++) adjList[i] = new ArrayList<>();
        for(String s : words){
            int i1 = map.get(s.charAt(0));
            int i2 = map.get(s.charAt(1));
            adjList[i1].add(i2);
        }
        List<List<Integer>> res = new ArrayList<>();
        if(!cycle(m, 0)){
            int arr[] = new int[26];
            for(int i=0;i<m;i++){
                arr[inp[i]-'a'] = 1;
            }

            res.add(Arrays.stream(arr).boxed().toList());

            return res;
        }

        int minLen = Integer.MAX_VALUE;

        for(int mask = 1;mask < ( 1 << m);mask++){
            int len = Integer.bitCount(mask);

            if(len > minLen){
                continue;
            }

            if(!cycle(m, mask)){
                if(len < minLen){
                    minLen = len;
                    res = new ArrayList<>();

                }

                int freq[] = new int[26];
                for(int j=0;j<m;j++){
                     ind = inp[j] - 'a';

                     if((mask & (1 << j)) !=0){
                        freq[ind]=2;
                     }else{
                        freq[ind] = 1;
                     }

                }

                res.add(Arrays.stream(freq).boxed().toList());
            }
        }

        return res;
    }

    private boolean cycle(int n, int mask){
        for(int i=0;i<n;i++){
            int bit = (mask >> i) & 1;
            if(bit == 1) continue;
            boolean []vis= new boolean[n];
            if(check(i, mask, vis)){
                return true;
            }
        }

        return false;
    }

    private boolean check(int curr, int mask, boolean vis[]){
        vis[curr] = true;
        for(int child : adjList[curr]){
            int bit = (mask >> child) &1;
            if(bit == 1) continue;

            if(vis[child]) return true;

            if(check(child, mask, vis)){
                return true;
            }
        }
        vis[curr] = false;
        return false;
    }
}