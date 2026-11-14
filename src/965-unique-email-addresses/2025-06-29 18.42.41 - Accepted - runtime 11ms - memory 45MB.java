class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String s : emails){
            String split[] = s.split("@");
            StringBuilder sb = new StringBuilder();
            for(char c : split[0].toCharArray()){
                if(c == '+') break;
                if(c!='.') sb.append(c);
            }
            sb.append("@"+split[1]);
            set.add(sb.toString());
        }

        return set.size();
    }
}