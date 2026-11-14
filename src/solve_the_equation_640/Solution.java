package solve_the_equation_640;

class Solution {
    public String solveEquation(String equation) {
        String[] eq = equation.split("=");
        int left[] = solve(eq[0]);
        int right[] = solve(eq[1]);

        
        int l = left[0] - right[0];
        int r = right[1] - left[1];

        if(l==0 && r==0){
            return "Infinite solutions";
        }

        if(l==0){
            return "No solution";
        }

        if(l < 0){
            l = -l;
            r = -r;
        }

        return "x="+(r/l);



    }

    private int[] solve(String s){
        
        int coef = 0;
        int num = 0;
        int ind = 0;

        int prev = 0;
        boolean neg = false;
        while(ind < s.length()){
            neg = false;
            if(s.charAt(ind) == '-'){
                neg = true;
                prev++;
                ind++;
            }else if(s.charAt(ind) == '+'){
                ind++;
                prev++;
            }
            while(ind < s.length() && (s.charAt(ind) !='-' && s.charAt(ind)!='+')){
                ind++;
            }
            String sub = s.substring(prev, ind);
            if(sub.endsWith("x")){
                if(sub.length() == 1){
                    coef += neg ? -1 : 1;
                }else{
                    coef += (neg?-1 : 1)*Integer.parseInt(sub.substring(0, sub.length()-1));

                }
            }else{
                num += (neg ? -1 : 1)*Integer.parseInt(sub);
            }
            prev = ind ;
        }

        return new int[]{coef, num};
    }   
}