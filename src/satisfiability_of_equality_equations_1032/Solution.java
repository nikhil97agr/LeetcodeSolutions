package satisfiability_of_equality_equations_1032;

class Solution {
    
    class DisjointSet{
        int parent[];
        public DisjointSet(){
            parent= new int[26];
            for(int i=0;i<26;i++){
                parent[i] = i;
            }
        }
        
        public int find(int i){
            if(parent[i]==i){
                return i;
            }
            return find(parent[i]);
        }
        
        public void union(int x, int y){
            parent[x] = y;
        }
    }
    public boolean equationsPossible(String[] equations) {
        DisjointSet set = new DisjointSet();
        
        for(String s :equations){
            if(s.charAt(1)=='='){
                int x = set.find(s.charAt(0)-'a');
                int y = set.find(s.charAt(3)-'a');
                
                if(x!=y){
                    set.union(x, y);
                }
            }
            
            
            
        }
        for(String s : equations){
                if(s.charAt(1)=='!'){
                    int x = set.find(s.charAt(0)-'a');
                    int y = set.find(s.charAt(3)-'a');
                    if(x==y){
                        return false;
                    }
                }
            }
        
            return true;
        
        
        
    }
}