import java.util.List;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int cnt = 0;

        for(List<String> list : items){
            switch(ruleKey){
                case "type":
                    if(ruleValue.equals(list.get(0))) cnt++;
                    break;
                case "color":
                    if(ruleValue.equals(list.get(1))) cnt++;
                    break;
                case "name":
                    if(ruleValue.equals(list.get(2))) cnt++;
                    break;
            }
        }
        
        return cnt;
    }
}