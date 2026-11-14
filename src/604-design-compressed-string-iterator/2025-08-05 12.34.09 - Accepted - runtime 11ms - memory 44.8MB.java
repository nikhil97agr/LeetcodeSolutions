class StringIterator {
    int cnt;
    int ind;
    char curr;
    String s;
    public StringIterator(String compressedString) {
        cnt = 0;
        ind = 0;
        s = compressedString;
        curr= ' ';
    }
    
    public char next() {
        if(cnt !=0){
            cnt--;
            return curr;
        }
        if(ind == s.length()) return ' ';
        curr= s.charAt(ind);
        ind++;
        while(ind < s.length() && Character.isDigit(s.charAt(ind))){

            cnt = cnt * 10 + (s.charAt(ind) - '0');
            ind++;
        }

        cnt--;
        return curr;
    }
    
    public boolean hasNext() {
        if(cnt ==0 && ind == s.length()) return false;

        return true;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */