class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();

        while(a > 0 && b > 0){
            sb.append("a").append("b");
            a--;
            b--;
        }

        if( a > 0){
            for(int i=0;i<sb.length() && a> 0;i++){
                if(sb.charAt(i) == 'a'){
                    sb.insert(i, 'a');
                    i++;
                    a--;
                }
            }

            if (a == 1){
                sb.append('a');
            }else if(a==2){
                sb.append("aa");
            }
        }else if(b > 0){
            for(int i=0;i<sb.length() && b > 0;i++){
                if(sb.charAt(i) == 'b'){
                    sb.insert(i, 'b');
                    b--;
                    i++;
                }
            }
            
            if(b == 1) sb.insert(0, "b");
            else if(b==2){
                sb.insert(0, "bb");
            }
        }
        
        return sb.toString();
    }
}