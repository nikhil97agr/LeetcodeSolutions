import java.util.Arrays;
import java.util.List;

class Solution {
    public String reorderSpaces(String text) {
        int spaces = 0;
        for(char c : text.toCharArray()){
            if(c==' ') spaces++;
        }

        StringBuilder sb = new StringBuilder();
        List<String> arr =Arrays.stream(text.split(" ")).filter(s-> !s.isEmpty()).toList();
        if(arr.size() ==1){
            return arr.get(0)+" ".repeat(spaces);
        }
        int equals = spaces/(arr.size()-1);
        int extra  = spaces%(arr.size()-1);
        for(String s : arr){
            sb.append(s);
            sb.append(" ".repeat(equals));
        }
        String res = sb.toString().trim();
        return res + " ".repeat(extra);
    }
}