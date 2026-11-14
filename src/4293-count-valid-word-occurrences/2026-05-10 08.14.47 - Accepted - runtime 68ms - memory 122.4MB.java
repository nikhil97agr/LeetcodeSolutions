import java.util.HashMap;

class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {

        StringBuilder sb = new StringBuilder();
        for(String s : chunks){
            sb.append(s);
        }

        var map = new HashMap<String, Integer>();
        char ch[] = sb.toString().toCharArray();
        int i=0;
        int n = sb.length();
        StringBuilder ss = new StringBuilder();
        while(i < n){
            
            if(check(ch, i)){
                ss.append(ch[i]);
            }else{
                if(!ss.isEmpty()){
                    String st = ss.toString();
                    map.merge(st, 1, Integer::sum);
                }
                ss.setLength(0);
                
                
            }
            i++;
            
        }
        if(!ss.isEmpty()){
            String st = ss.toString();
            map.merge(st, 1, Integer::sum);
        }
        
        int ans[] = new int[queries.length];
        
        for( i=0;i<queries.length;i++){
            String st = queries[i];
            
            ans[i] = map.getOrDefault(st, 0);
        }
        
        return ans;
    }

    private boolean isValid(char ch){
        if(ch >= 'a' && ch <= 'z') return true;
        
        return false;
    }
    
    private boolean check(char ch[], int i){
        
        if(isValid(ch[i])) return true;
        
        if(ch[i] == '-'){
            if(i ==0 || i == ch.length-1) return false;
            if(!isValid(ch[i-1]) || !isValid(ch[i+1])) return false;
            
            return true;
        }
        
        return false;
    }
    
}