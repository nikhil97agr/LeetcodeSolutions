class Solution {
    public int countDivisibleSubstrings(String word) {
        int ans = 0;
        int n = word.length();
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                char ch = word.charAt(j);
                if(ch >= 'a' && ch <='b')sum += 1;
                if(ch >= 'c' && ch <='e') sum+=2;
                if(ch >='f' && ch <='h') sum +=3;
                if(ch >='i' && ch <='k') sum += 4;
                if(ch >='l' && ch <='n') sum += 5;
                if(ch >='o' && ch <='q') sum+=6;
                if(ch >='r' && ch<='t') sum+=7;
                if(ch >='u' && ch <='w') sum +=8;
                if(ch >='x' && ch <='z') sum+=9;

                if(sum %(j-i+1)==0) ans++;
            }
        }

        return ans;
    }
}