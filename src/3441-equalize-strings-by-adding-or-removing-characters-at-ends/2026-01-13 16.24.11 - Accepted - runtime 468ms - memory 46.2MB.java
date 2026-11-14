class Solution {
    public int minOperations(String initial, String target) {
        int start = 1;
        int end = target.length();
        int ans = -1;
        char t[] =target.toCharArray();
        char i[] = initial.toCharArray();
        int n= initial.length();
        int m = target.length();
        while(start <= end){
            int mid = (start + end)/2;

            if(possible(t, i, n, m, mid)){
                ans = n + m - 2*mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans == -1 ? n  + m : ans;
    }

    private boolean possible(char t[], char i[], int n, int m, int len){
        int start = 0;
        int end = len - 1;
        while(end < m){
            int lps[] = lps(t, start, end + 1);
            if(check(lps, start, end + 1, t, i)) return true;
            start++;
            end++;
        }

        return false;
    }

    private boolean check(int lps[], int start, int n, char pattern[], char text[]){
        int i = start;
        int j = 0;

        while( j < text.length){
            if(text[j] == pattern[i]){
                i++;
                j++;
                if(i == n) return true;
                continue;
            }

            if(i != start){
                i = lps[i-1];
            }else{
                j++;
            }

        }
        return false;
    }

    private int[] lps(char pattern[], int start, int n){
        int lps[] = new int[pattern.length];
        lps[start] = start;
        int i=start+1;
        int len = start;
        if(start == 1){
            System.out.println("THIS");
        }
        while(i < n){
            if(pattern[i] == pattern[len]){
                len++;
                lps[i]= len;
                i++;
            }else{
                if(len != start){
                    len = lps[len - 1];
                }else{
                    lps[i] = start;
                    i++;
                }
            }
        }

        return lps;
    }
}