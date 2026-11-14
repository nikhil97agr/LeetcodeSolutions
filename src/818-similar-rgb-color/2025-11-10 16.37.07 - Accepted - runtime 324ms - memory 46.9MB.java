class Solution {
            String res = "";
        int sim = Integer.MIN_VALUE;
    public String similarRGB(String color) {
        generate(0, new StringBuilder(), 6, color.substring(1));
        return "#"+res;
    }

    private void generate(int i, StringBuilder sb, int n, String color){
        if(i==n){
            int sim = similarity(sb.toString(), color);
            if(sim > this.sim){
                this.sim = sim;
                res = sb.toString();
            }

            return;
        }
        for(char c = '0';c<='9'; c++){
            sb.append(c).append(c);
            generate(i+2, sb, n, color);
            sb.delete(sb.length()-2,sb.length());
        }

        for(char c = 'a';c<='f'; c++){
            sb.append(c).append(c);
            generate(i+2, sb, n, color);
            sb.delete(sb.length()-2,sb.length());
        }

    }

    private int similarity(String s1, String s2){
        int sim = 0;
        for(int i=0;i<s1.length();i+=2){
            int h1 = hex(s1.substring(i, i+2));
            int h2 = hex(s2.substring(i, i+2));

            sim += -(h1-h2)*(h1-h2);
        }

        return sim;
    }

    private int hex(String s){
        int val = 0;
        for(int i=0;i<s.length();i++){
            int v =0;
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                v = ch - '0';
             }else{
                v = 10 + (ch - 'a');
             }
             val += v * Math.pow(16, 1 - i);
        }

        return val;
    }

}