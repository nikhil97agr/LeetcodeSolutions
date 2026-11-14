package complete_prime_number_4100;

class Solution {
    public boolean completePrime(int num) {
        char ch[]= Integer.toString(num).toCharArray();
        int n= ch.length;
        for(int i=0;i<ch.length;i++){
            if(!prime(ch, 0, i) || !prime(ch, i, n-1)) return false;

        }

    

        return true;
    }

    private boolean prime(char ch[], int start, int end){
        int num = 0;
        while(start <= end){
            num = num * 10 + (ch[start]-'0');
            start++;
        }
        if(num == 1) return false;
        if(num <= 3) return true;

        if(num%2==0) return false;

        for(int i=3;i<=Math.sqrt(num);i+=2){
            if(num%i==0) return false;
        }

        return true;
    }
}