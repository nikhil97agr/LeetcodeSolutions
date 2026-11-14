class Solution {
    public String parseTernary(String expression) {
        int i=0;
        int n =expression.length();
        char ch[] =expression.toCharArray();
        while(true){
            if(ch[i] != 'T' && ch[i]!='F') return ""+ch[i];

            if(i == n-1) return ""+ch[i];

            if(ch[i+1] == ':'){
                return ""+ch[i];
            }

            if(ch[i] == 'T'){
                i+=2;
                continue;
            }

            int cnt = 1;
            i = i + 2;
            while(cnt > 0){
                if(ch[i] == ':'){
                    cnt--;
                }else if(ch[i] == '?'){
                    cnt++;
                }
                i++;
            }
        }
    }
}