class Solution {
    public int shortestWay(String source, String target) {
        boolean exists[] = new boolean[26];
        for(char c: source.toCharArray()){
            exists[c-'a'] = true;
        }
        for(char c : target.toCharArray()){
            if(!exists[c-'a']) return -1;
        }

        int ans = 0;
        int i=0;
        
        while( i < target.length()){
            int j=0;
            while(i < target.length() && j < source.length()){
                if(target.charAt(i) == source.charAt(j)){
                    i++;
                }
                j++;
            }
            ans++;
        }
        return ans;
    }
}