class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        Set<String> set = new HashSet<>();

        generate(target.toCharArray(), 0,  new StringBuilder(), target.length(), set);
        
        Set<String> s2 = new HashSet<>();

        for(String s : dictionary){
            if(target.length() != s.length()) continue;
            generate(s.toCharArray(), 0, new StringBuilder(), s.length(), s2);
        }
        
        if(s2.isEmpty()){
            return ""+target.length();
        }



        String ans = "";
        int len = target.length() + 1;

        for(String s : set){
            if(s2.contains(s)) continue;
            int l = getLen(s);
            if(l < len){
                len = l;
                ans = s;

            }
        }

        return ans;
    }

    private int getLen(String s){
        int len = 0;
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                len++;
                continue;
            }

            while ( i < s.length() && Character.isDigit(s.charAt(i))) i++;
            i--;
            len++;
        }

        return len;
    }

    private void generate(char ch[], int i,  StringBuilder sb, int n, Set<String> set){
        if(i>=n){
            set.add(sb.toString());
            return;
        }

        int cnt = 0;
        for(int j=i;j<n;j++){
            cnt++;
            sb.append(cnt);
            if(j+1 < n){
                sb.append(ch[j+1]);
            }
            generate(ch, j+2, sb, n, set);

            if(j+1 < n){
                sb.deleteCharAt(sb.length() -1);
            }

            deleteNum(sb);
        }
        sb.append(ch[i]);
        generate(ch, i+1, sb, n, set);
        sb.deleteCharAt(sb.length() - 1);
    }

    private void deleteNum(StringBuilder sb){
        int i= sb.length()-1;
        while(i >=0 && Character.isDigit(sb.charAt(i))) i--;

        sb.delete(i+1, sb.length());
    }
}