class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            StringBuilder sb = new StringBuilder();
            Map<Character, Integer> distinct = new HashMap<>();
            int j=i;
            while( j< s.length() && sb.length() < minSize-1){
                sb.append(s.charAt(j));
                distinct.merge(s.charAt(j), 1, Integer::sum);
                j++;
            }

            if(sb.length() != minSize - 1 || distinct.size() > maxLetters){
                continue;
            }

            while(sb.length()<maxSize && j < s.length()){
                sb.append(s.charAt(j));
                distinct.merge(s.charAt(j), 1, Integer::sum);
                if(distinct.size() > maxLetters) break;
                add(sb.toString(), map);
                j++;
            }
        }

        for(int x : map.values()) ans = Math.max(ans, x);
        return ans;
    }

    private void add(String s, Map<Integer, Integer> map){
        map.merge(s.hashCode(), 1, Integer::sum);
    }
}