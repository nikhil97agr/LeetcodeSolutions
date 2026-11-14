class Solution {
    public long sumScores(String s) {
        int zarray[] = zarray(s.toCharArray());
        int n = s.length();
        long ans = s.length();
        for(int i=1;i<n;i++){
            ans += zarray[i];
        }
        return ans;
    }


    private int[] zarray(char ch[]){
        int n = ch.length;
        int arr[] = new int[n];
        int l=0,r=0;
        for(int i=1;i<n;i++){
            if( i > r){
                l = r = i;
                while(r < n && ch[r-l] == ch[r]){
                    r++;
                }

                arr[i] = r - l;
                r--;
            }else{
                int k = i - l;
                if(arr[k] < r - i + 1){
                    arr[i] = arr[k];
                }else{
                     l = i;
                     while( r < n && ch[r-l] == ch[r]){
                        r++;
                     }
                     arr[i] = r - l;
                     r--;
                }
            }
        }

        return arr;
    }
}