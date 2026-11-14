class Solution {
    public void reverseWords(char[] s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s){
            if(c==' '){
                list.add(sb.toString());
                sb = new StringBuilder();
            }else{
                sb.append(c);
            }
        }
        list.add(sb.toString());
        int i=0;
        int j = list.size()-1;
        while(i < s.length){
            String st = list.get(j);
            j--;
            for(char c : st.toCharArray()){
                s[i] = c;
                i++;
            }
            if(i!=s.length){
                s[i] = ' ';
                i++;
            }
        }
    }
}