class Solution {
    public String sortSentence(String s) {
        List<String> list =new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        for(String st : s.split(" ")){
            int dig = st.charAt(st.length()-1) - '0';

            String s1 =st.substring(0, st.length()-1);

            map.put(dig, s1);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=map.size();i++){
            sb.append(" ").append(map.get(i));
        }

        return sb.toString().trim();
    }
}