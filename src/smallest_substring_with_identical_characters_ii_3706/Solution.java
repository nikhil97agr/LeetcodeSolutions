package smallest_substring_with_identical_characters_ii_3706;

class Solution {
    public int minLength(String s, int ops) {
        int n = s.length();
        char ch[] = s.toCharArray();

        boolean ans = len1(ch, n, ops, '1') || len1(ch, n, ops, '0');
        if(ans) return 1;

        int start = 2;
        int end = n;
        while(start < end){
            int mid = (start +end)/2;
            if(check(ch, n,mid, ops)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return end;
    }

    private boolean check(char ch[], int n,int len, int ops){
        int cnt = 0;
        for(int i=0, prev = -1;i<n;i++){
            if(ch[i] == prev) cnt++;
            else{
                ops -= cnt/(len + 1);
                cnt = 1;
                prev= ch[i];
            }
        }
        if(cnt > len){
            ops -= cnt/(len + 1);
        }

        return ops >=0;
    }


    
    private boolean len1(char ch[],int n, int ops, char curr){
        for(int i=0;i<n;i++){
            if(ch[i] == curr){
                ops--;
            }
            curr = (curr == '1' ? '0' : '1');
        }

        return ops >= 0;
    }

}