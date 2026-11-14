class Solution {
    public String toHex(int num) {
        long n = num;
        if(num ==0) return "0";
        if( num < 0){
            n = (1l<<32 )+ num;
        }
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            int mod = (int)(n%16);

            n/=16;

            switch(mod){
                case 10: sb.append('a'); break;
                case 11: sb.append('b'); break;
                case 12: sb.append('c'); break;
                case 13: sb.append('d'); break;
                case 14: sb.append('e'); break;
                case 15: sb.append('f'); break;
                default: sb.append(mod);
            }
        }
        return sb.reverse().toString();
    }
}