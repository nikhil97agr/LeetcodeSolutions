class Solution {
    public boolean hasMatch(String s, String p) {
        String st[] = Arrays.stream(p.split("\\*")).filter(t -> !t.isEmpty()).toArray(String[]::new);
        if(st.length == 0) return true;
        
        int i1 = s.indexOf(st[0]);

        if(i1 < 0) return false;
        if(st.length == 1) return true;
        int i2 = s.indexOf(st[1], i1+st[0].length());
        if(i2 == -1) return false;
        return true;
    }
}