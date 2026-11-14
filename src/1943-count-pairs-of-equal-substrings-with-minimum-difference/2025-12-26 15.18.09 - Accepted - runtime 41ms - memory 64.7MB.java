class Solution {
    public int countQuadruples(String firstString, String secondString) {
        int index[] = new int[26];
        Arrays.fill(index, -1);
        int ans = 0;

        for(int i=0;i<secondString.length();i++){
            int ind = secondString.charAt(i) - 'a';

            index[ind] = i;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<firstString.length();i++){
            int ind = firstString.charAt(i) - 'a';

            if(index[ind] != -1){
                int diff = i - index[ind];
                map.merge(diff, 1, Integer::sum);
            }
        }

        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey() < min){
                ans = entry.getValue();
                min = entry.getKey();
            }
        }

        return ans;
    }
}