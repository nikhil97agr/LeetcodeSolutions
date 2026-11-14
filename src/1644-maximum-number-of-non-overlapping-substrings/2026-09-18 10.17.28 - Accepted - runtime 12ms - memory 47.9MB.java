class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int start[] = new int [26];
        int end [] = new int[26];
        int n = s.length();
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        for(int i=0;i<n;i++){
            int ind = s.charAt(i) - 'a';
            if(start[ind] == -1){
                start[ind] = i;
            }
            end[ind] = i;
        }



        List<String> result = new ArrayList<>();
        int right = -1;
        for(int i=0;i<n;i++){
            if( i == start[s.charAt(i) - 'a']){
                int nextEnd = find(s, i, start, end);
                if(nextEnd != -1){
                    if(i > right){
                        result.add("");
                    }
                    right = nextEnd;
                    result.set(result.size()-1, s.substring(i, right + 1));
                }
            }
        }

        return result;
        
    }

    private int find(String s, int i, int start[], int end[]){
        int right = end[s.charAt(i) - 'a'];

        for(int j=i;j<=right;j++){
            if(start[s.charAt(j) -'a'] < i)return -1;
            right = Math.max(right, end[s.charAt(j) -'a']);
        }
        return right;
    }


}