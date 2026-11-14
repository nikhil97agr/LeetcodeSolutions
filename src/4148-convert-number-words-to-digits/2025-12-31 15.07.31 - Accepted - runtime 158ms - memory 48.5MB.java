class Solution {
    public String convertNumber(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        StringBuilder res = new StringBuilder();
        int i=0;
        while(i < s.length()){
            String next = get(s,i, map);
            if(next.isEmpty()){
                i++;
            }else{
                res.append(map.get(next));
                i += next.length();
            }
        }

        return res.toString();
    }

    private String get(String s, int i, Map<String, Integer> map){
        StringBuilder sb = new StringBuilder();
        while(i < s.length() && sb.length() < 7){
            sb.append(s.charAt(i));
            if(map.containsKey(sb.toString())){
                return sb.toString();
            }
            i++;
        }
        return "";
    }
}