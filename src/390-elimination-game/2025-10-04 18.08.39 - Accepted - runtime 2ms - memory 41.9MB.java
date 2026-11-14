class Solution {
    public int lastRemaining(int n) {
        int total = n;
        int start = 1;
        int end = n;

        int pow = 0;
        int flag= 0;

        while(total > 2){
            if(flag == 0){
                if(total%2==0){
                    start = start + (1<<pow);
                }else{
                    start = start + (1<<pow);
                    end = end - (1<<pow);
                }
                total/=2;
                flag = 1;
            }else{
                if(total%2==0){
                    end = end - (1<<pow);
                }else{
                    start = start + (1<<pow);
                    end = end - (1<<pow);
                }
                total/=2;
                flag = 0;
            }
            
            pow++;
        }

        if(total == 1) return end;
        if(flag == 1) return start;
        else return end;

    }
}