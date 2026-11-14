class Solution {
    int ind = 0;
    public long evaluateExpression(String expression) {
        return solve(expression.toCharArray());
    }

    private long solve(char exp[]){
        if(exp[ind] == '-' || Character.isDigit(exp[ind])){
            return eval(exp);
        }

        char c = exp[ind];
        // skip ops & '('
        ind += 4;

        long left = solve(exp);
        // skip ','
        ind++;

        long right = solve(exp);
        //skip ')'
        ind++;

        if(c == 'a'){
            return left + right;
        }

        if( c== 'm'){
            return left * right;
        }

        if( c== 's'){
            return left - right;
        }

        return left / right;

    }

    private long eval(char exp[]){
        int mul = 1;
        if(exp[ind] == '-'){
            mul = -1;
            ind++;
        }
        long num = 0;
        while(ind < exp.length &&  Character.isDigit(exp[ind])){
            num = num * 10 + (exp[ind] - '0');
            ind++;
        }

        return num * mul;
    }
}