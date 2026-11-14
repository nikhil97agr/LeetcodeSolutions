package longest_absolute_file_path_388;

class Solution {
    public int lengthLongestPath(String input) {
        int ans = 0;
        String str[] = input.split("\n");
        int len[] = new int[str.length + 1];

        for(String s : str){
            int ind = s.lastIndexOf("\t")+1;
            len[ind+1] = len[ind] + s.length() - ind +1;
            if(s.contains(".")){
                ans = Math.max(ans, len[ind+1]-1);
            }

        
        }
        return ans;
    }
}