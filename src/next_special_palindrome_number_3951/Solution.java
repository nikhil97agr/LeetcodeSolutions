package next_special_palindrome_number_3951;

class Solution {
    public long specialPalindrome(long n) {
        String s = ""+n;
        int len = s.length();

        StringBuilder res = new StringBuilder();

        int i = len;
        while(true){
            if(check(res,i,0,(i+1)/2, s, new int[10])){
                return Long.parseLong(res.toString());
            }
            res.setLength(0);
            i++;
        }

    }

    private boolean check(StringBuilder res, int len, int i,int end, String s, int cnt[]){
        if(i==end){
            if(check(cnt)){
                    StringBuilder temp = new StringBuilder(res);

                if(len %2==1){
                    temp.deleteCharAt(temp.length() -1);
                }
                temp.reverse();
                res.append(temp);

                if(res.length() == s.length() && res.toString().compareTo(s) <= 0){
                    res.delete(res.length() - temp.length(), res.length());
                    return false;
                }
                return true;
            }

            return false;
        }

        for(int dig =1;dig <=9;dig++){
            if(i == end - 1){
                if(len %2==0){
                   if(cnt[dig]+2 == dig){
                    res.append(dig);
                    cnt[dig]+=2;
                    if(check(res, len, i+1, end, s, cnt)){
                        return true;
                    }
                    cnt[dig] -= 2;
                    res.deleteCharAt(res.length() - 1);
                } 
                }else{
                    if(cnt[dig]+1 == dig){
                        res.append(dig);
                        cnt[dig]++;
                        if(check(res, len, i+1, end, s, cnt)){
                            return true;
                        }

                        cnt[dig]--;
                        res.deleteCharAt(res.length() - 1);
                    }
                }
            }else{
                if(cnt[dig]+2 <= dig){
                    res.append(dig);
                    cnt[dig]+=2;
                    if(check(res, len, i+1, end, s, cnt)){
                        return true;
                    }
                    cnt[dig] -= 2;
                    res.deleteCharAt(res.length() - 1);
                }
            }
        }

        return false;
    }

    private boolean check(int cnt[]){
        for(int i=0;i<=9;i++){
            if(cnt[i] !=0 && cnt[i] !=i) return false;
        }

        return true;
    }  


}