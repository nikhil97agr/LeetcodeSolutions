class Solution {
    class Trie{
        Trie trie[];
        boolean last;
        public Trie(){
            trie = new Trie[26];
            
        }
        
        public void add(String s, int i, int n){
            if(i==n){
                this.last= true;
                return;
            }
            
            char ch  = s.charAt(i);
            if(trie[ch-'a']==null){
                trie[ch-'a'] = new Trie();
            }
            trie[ch-'a'].add(s, i+1, n);
            
            
        }
        
        public boolean check(String s, int i, int n){
            if(i==n){
                return last;
            }
            
            char ch = s.charAt(i);
            if(trie[ch-'a']==null){
                return false;
            }
            
            return trie[ch-'a'].check(s, i+1,n);
        }
    }
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Trie positive = new Trie();
        Trie negative = new Trie();
        for(String s : positive_feedback){
            positive.add(s, 0, s.length());
        }
        
        for(String s : negative_feedback){
            negative.add(s, 0, s.length());
        }
        List<Object[]> list = new ArrayList<Object[]>();
        for(int i=0;i<student_id.length;i++){
            Integer score = 0;
            for(String s : report[i].split(" ")){
                if(positive.check(s, 0, s.length())){
                    score+=3;
                }else if(negative.check(s, 0,s.length())){
                    score--;
                }
            }
            
            list.add(new Object[]{student_id[i], score});
            
            
        }
        Collections.sort(list, (obj1, obj2)->{
            Integer x1 = (Integer)obj1[1];
            Integer x2 = (Integer)obj2[1];
            
            Integer s1 = (Integer)obj1[0];
            Integer s2 = (Integer) obj2[0];
            
            if(x1>x2){
                return -1;
            }else if(x2>x1){
                return 1;
            }else{
                if(s1 > s2){
                    return 1;
                }else{
                    return -1;
                }
            }

        });
        
        List<Integer> result = new ArrayList<Integer>();
        for(Object[] x : list){
            result.add((Integer)x[0]);
            k--;
            if(k==0){
                return result;
            }
        }
        return result;
    }
}