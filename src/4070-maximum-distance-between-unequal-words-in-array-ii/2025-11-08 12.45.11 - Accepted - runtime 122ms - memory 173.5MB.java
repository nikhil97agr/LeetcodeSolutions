class Solution {
    public int maxDistance(String[] words) {
        int ans = 0;
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i =0;i<words.length;i++){
            String s =words[i];
            map.computeIfAbsent(s, x-> new ArrayList<>()).add(i);
        }
        int n = words.length;
        for(String s : map.keySet()){
            int min = 0;
            int max = n-1;
            List<Integer> list = map.get(s);

            for(int i=0;i<list.size() && min == list.get(i);i++){
                min++;
            }

            for(int i=list.size()-1;i>=0 && max == list.get(i);i--){
                max--;
            }

            for(int ind : list){
                if(min != n){
                    ans = Math.max(ans, Math.abs(min - ind)+1);
                }
                if(max != -1){
                    ans = Math.max(ans, Math.abs(max - ind)+1);
                }
            }
        }
        return ans;
    }
}