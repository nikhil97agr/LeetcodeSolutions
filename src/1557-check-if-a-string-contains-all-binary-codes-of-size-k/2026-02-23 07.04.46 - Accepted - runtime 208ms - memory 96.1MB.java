class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        int end = 0;
        int n = s.length();


        while(end < n){
            if(sb.length() < k){
                sb.append(s.charAt(end));
                end++;
                continue;
            }

            set.add(sb.toString());
            sb.deleteCharAt(0);
            sb.append(s.charAt(end));
            end++;
        }

        set.add(sb.toString());

        return set.size() == (1<<k);
    }
}