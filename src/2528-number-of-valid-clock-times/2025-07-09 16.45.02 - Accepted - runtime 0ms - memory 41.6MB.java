class Solution {
    public int countTime(String time) {
        char t[] = time.toCharArray();

        int left =1;
        int right = 1;

        if(t[0] == '?'){
            if(t[1] == '?'){
                left = 2*10 + 4;
            }else if(t[1] <= '3'){
                left = 3;
            }else{
                left = 2;
            }
        }else{
            if(t[1] == '?'){
                left = t[0] == '2' ? 4 : 10;
            }
        }

        if(t[3] == '?' && t[4] == '?'){
            right = 6*10;
        }else if(t[3] == '?'){
            right = 6;
        }else if(t[4] == '?'){
            right = 10;
        }

        return left*right;
    }
}