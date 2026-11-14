class Solution {
    public String minimizeResult(String expression) {
        int min = Integer.MAX_VALUE;
        String result = "";
        String st[] = expression.split("\\+");

        String s1 = st[0];
        String s2 = st[1];

        for(int i=0;i<s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                int a= num(s1.substring(0,i));
                int b = num(s1.substring(i));
                int c = num(s2.substring(0,j));
                int d = num(s2.substring(j));
                int res = (a==0?1:a)*(d==0 ? 1 : d)*(b+c);
                if(res < min){
                    min = res;
                    result = ""+(a==0 ? "":a)+"("+b+"+"+c+")"+(d==0 ? "":d);
                }
            }
        }

        return result;
    }

    private int num(String s){
        if(s.length() == 0) return 0;
        return Integer.parseInt(s);
    }
}