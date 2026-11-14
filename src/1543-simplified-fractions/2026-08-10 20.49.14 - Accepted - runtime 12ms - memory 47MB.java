class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

        for(int num=1;num<n;num++){
            sb.append(num).append("/");
            int len = sb.length();
            for(int den = num + 1;den <= n;den++){
                int gcd = gcd(num, den);
                if(gcd == 1){
                    sb.append(den);
                    list.add(sb.toString());
                    sb.setLength(len);
                }
            }
            sb.setLength(0);
        }

        return list;
    }

    private int gcd(int a, int b){
        while(a > 0 && b > 0){
            if( a > b){
                a %= b;
            }else{
                b%=a;
            }
        }


        return a ==0 ? b : a;
    }



}