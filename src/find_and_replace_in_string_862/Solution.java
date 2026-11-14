package find_and_replace_in_string_862;

import java.util.*;
class Solution {
    class ReplacementParameter{
        int index;
        String source;
        String target;

        public ReplacementParameter(int index, String source, String target){
            this.index = index;
            this.source = source;
            this.target = target;
        }
    }
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        ReplacementParameter[] parameter = new ReplacementParameter[n];
        for(int i=0;i<n;i++){
            parameter[i] = new ReplacementParameter(indices[i], sources[i], targets[i]);
        }

        Arrays.sort(parameter , (a,b) -> a.index - b.index);
        for(int i=n-1;i>=0;i--){
            ReplacementParameter param = parameter[i];
            int ind = param.index;
            String src = param.source;
            String target = param.target;
            String sub = s.substring(ind, Math.min(ind+src.length(), s.length()));

            if(sub.equals(src)){
                s = s.substring(0, ind) + target + s.substring(ind + src.length(), s.length());
            }
        }

        return s;
    }
}