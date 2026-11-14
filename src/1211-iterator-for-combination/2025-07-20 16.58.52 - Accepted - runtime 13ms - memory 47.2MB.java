class CombinationIterator {
    Queue<String> que;
    public CombinationIterator(String characters, int combinationLength) {
        que= new LinkedList<>();

        generate(characters,0, combinationLength, characters.length(), new StringBuilder());
    }

    private void generate(String s, int i, int maxLen, int n, StringBuilder sb){
        if(maxLen ==0){
            que.offer(sb.toString());
            return;
        }

        if(i==n) return;

        sb.append(s.charAt(i));
        generate(s, i+1, maxLen - 1, n, sb);
        sb.deleteCharAt(sb.length()-1);
        generate(s, i+1, maxLen, n, sb);
    }
    
    public String next() {
        return que.poll();
    }
    
    public boolean hasNext() {
        return !que.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */