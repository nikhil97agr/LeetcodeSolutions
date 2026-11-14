class Solution {
    public String toHexspeak(String num) {
        StringBuilder hex = new StringBuilder();
        long n = Long.parseLong(num);
        Map<Integer, Character> map = Map.of(
            10, 'A',
            11, 'B',
            12, 'C',
            13, 'D',
            14, 'E',
            15, 'F' 
        );
        while(n > 0){
            int mod =(int) (n%16);
            if(mod < 10){
                hex.append(mod);
            }else{
                hex.append(map.get(mod));
            }
            n/=16;
        }

        char ch[] = hex.reverse().toString().toCharArray();
        System.out.println(Arrays.toString(ch));
        for(int i=0;i<ch.length;i++){
            if(ch[i] == '0') ch[i] = 'O';
            else if(ch[i] == '1') ch[i] = 'I';
            else if(Character.isDigit(ch[i])) return "ERROR";
        }

        return new String(ch);
        
    }
}