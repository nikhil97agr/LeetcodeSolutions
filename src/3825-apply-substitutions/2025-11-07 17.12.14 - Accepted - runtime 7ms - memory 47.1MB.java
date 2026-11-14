class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        Map<String, String> map = new HashMap<>();
        for(List<String> list: replacements){
            map.put(list.get(0), list.get(1));
        }

        return solve(map, text);
    }

    private String solve(Map<String, String> map, String text){
        StringBuilder res = new StringBuilder();
        int n = text.length();
        for(int i=0;i<n;i++){
            char ch = text.charAt(i);
            if(ch == '%'){
                i++;
                StringBuilder temp = new StringBuilder();
                while(text.charAt(i) != '%'){
                    temp.append(text.charAt(i));
                    i++;
                }
                String s = map.get(temp.toString());
                res.append(solve(map, s));
            }else{
                res.append(ch);
            }
        }
        return res.toString();
    }
}