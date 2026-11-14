class Solution {
    public int countPoints(String s) {
        Set<Character> set[] = new HashSet[10];
        for(int i=0;i<10;i++) set[i] = new HashSet<>();

        for(int i=0;i<s.length();i+=2){
            char c= s.charAt(i);
            int x = s.charAt(i+1)-'0';
            set[x].add(c);
        }

        int ans = 0;
        
        
        return (int)Arrays.stream(set).filter(st -> st.size() ==3).count();
        
    }
}