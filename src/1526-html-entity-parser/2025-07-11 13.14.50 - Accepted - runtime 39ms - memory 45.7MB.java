import java.util.HashMap;
import java.util.Map;

class Solution {
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();

        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        StringBuilder res = new StringBuilder();

        int i=0;
        while(i < text.length()){
            char c = text.charAt(i);

            if( c == '&'){
                int j=i;

                while( j < text.length() && j-i+1 <= 7 && !map.containsKey(text.substring(i,j+1))){
                    j++;
                }

                if(j < text.length() && j-i+1 <= 7){
                    res.append(map.get(text.substring(i, j+1)));
                    i = j+1;
                }else{
                    res.append(c);
                    i++;
                }
            }else{
                res.append(c);
                i++;
            }

        }
        return res.toString();
    }
}