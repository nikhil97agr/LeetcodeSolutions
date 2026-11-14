class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int ans = 0;

        int start = 0;
        int end = removable.length;

        while(start <= end){
            int mid= (start + end)/2;

            if(check(s.toCharArray(), p.toCharArray(), removable, mid)){
                ans= mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return ans;
    }

    private boolean check(char s[], char p[], int arr[], int ind){
        for(int i=0;i<ind;i++){
            s[arr[i]] = ' ';
        }

        int i=0;
        int j=0;
        int n = s.length;
        int m = p.length;

        while(i < n && j < m){
 
            if(s[i] == p[j]){
                j++;
            }
            i++;
        }

        return j == m;
    }
}