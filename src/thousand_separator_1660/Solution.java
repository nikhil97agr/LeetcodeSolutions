package thousand_separator_1660;

class Solution {
    public String thousandSeparator(int n) {
        if(n<1000) return ""+n;

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        while(n> 0){
            if(cnt ==3 ){
                sb.append(".");
                cnt = 0;
            }
            int dig = n%10;

            sb.append(dig);
            cnt++;
            n/=10;
            
        }

        return sb.reverse().toString();
    }

}