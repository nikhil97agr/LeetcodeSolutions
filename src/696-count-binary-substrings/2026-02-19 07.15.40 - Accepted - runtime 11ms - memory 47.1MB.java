class Solution {
    public int countBinarySubstrings(String s) {
        int cnt = 0;

        List<Integer> list = new ArrayList<>();

        char prev = s.charAt(0);

        for(char c : s.toCharArray()){
            if(c == prev) cnt++;
            else {
                list.add(cnt);
                cnt = 1;
                prev = c;
            }
        }
        list.add(cnt);


        int ans = 0;
        for(int i=1;i<list.size();i++){
            ans += Math.min(list.get(i), list.get(i-1));
        }

        return ans;
    }
}