class Solution {
    public long calculateScore(String s) {
        long ans = 0;
        char map[] = new char[26];
        int ind=0;
        for(char c='z';c>='a';c--){
            map[ind++] = c;
        }

        TreeSet<Integer> set[] = new TreeSet[26];
        for(int i=0;i<26;i++) set[i] = new TreeSet<>(Collections.reverseOrder());

        for(int i=0;i<s.length();i++){
            char rev = map[s.charAt(i) - 'a'];
             ind = rev-'a';
            if(!set[ind].isEmpty()){
                int j = set[ind].removeFirst();
                ans += (i-j);

            }else{
                int i2 = s.charAt(i) - 'a';
                set[i2].add(i);
            }
        }
        return ans;

    }
}