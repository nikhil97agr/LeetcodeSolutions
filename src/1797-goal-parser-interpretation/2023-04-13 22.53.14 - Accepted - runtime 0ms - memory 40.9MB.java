class Solution {
    public String interpret(String command) {
        StringBuilder str = new StringBuilder();

        int i=0;
        int n = command.length();
        while(i<n){
            if(command.charAt(i)=='G'){
                str.append("G");
                i++;
                continue;
            }
            if(command.charAt(i)=='(' && command.charAt(i+1)==')'){
                i+=2;
                str.append("o");
                continue;
            }

            str.append("al");
            i+=4;
        }

        return String.valueOf(str);
    }
}