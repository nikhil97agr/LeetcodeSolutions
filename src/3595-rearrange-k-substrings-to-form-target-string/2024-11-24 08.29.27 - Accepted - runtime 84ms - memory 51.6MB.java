class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        if(s.equals(t)) return true;
        
        int n = s.length();
        int req = n/k;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            sb.append(s.charAt(i));
            
            cnt++;
            if(cnt == req){
                cnt =0;
                int hash = sb.toString().hashCode();
                map.put(hash, map.getOrDefault(hash, 0)+1);
                sb = new StringBuilder();
            }
            
            
        }
        
        sb = new StringBuilder();
        cnt = 0;
        for(int i=0;i<n;i++){
            sb.append(t.charAt(i));
            cnt++;
            if(cnt == req){
                cnt =0;
                int hash = sb.toString().hashCode();
                if(!map.containsKey(hash)) return false;
                
                map.put(hash, map.get(hash)-1);
                if(map.get(hash)==0) map.remove(hash);
                sb = new StringBuilder();
            }
        }
        return true;
    }
}