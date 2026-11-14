class Solution {
    public String arrangeWords(String text) {
        String arr[] = text.split(" ");

        TreeMap<Integer, List<String>> map = new TreeMap<>();
        for (String s : arr) {
            map.computeIfAbsent(s.length(), a -> new ArrayList<>()).add(s);
        }

        StringBuilder res = new StringBuilder();
        for (List<String> list : map.values()) {
            for (String s : list) {
                res.append(s+" ");
            }

        }
        char ch = Character.toUpperCase(res.charAt(0));
        res.setCharAt(0, ch);

        for(int i=1;i<res.length();i++){
            if(Character.isUpperCase(res.charAt(i))){
                res.setCharAt(i, Character.toLowerCase(res.charAt(i)));
                break;
            }
        }

        return res.toString().trim();
    }
}