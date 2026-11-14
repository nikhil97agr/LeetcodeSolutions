class Solution {
    public int longestDecomposition(String text) {
        int ans = 0;
        int start = 0;
        int end = text.length()-1;
        while(start <= end){
            String sub = text.substring(start ,end + 1);
            int z[] = z(sub.toCharArray(), sub.length());
            int endIndex = z.length - 1;

            while(end > start && z[endIndex] != sub.length() -endIndex){
                end--;
                endIndex--;
            }

            if(start == end){
                return ans + 1;
            }else{
                ans += 2;
                int len = z[endIndex];
                start += len;
                end--;
            }
        }
        return ans;
    }

    private int[] z(char ch[], int len){
        int zarray[] = new int[len];
        int l = 0;
        int r = 0;
        for(int i=1;i<len;i++){
            if( i > r){
                l = r = i;
                while(r < len && ch[r - l] == ch[r]){
                    r++;
                }

                zarray[i] = r -l;
                r--;
            }else{
                int k = i - l;
                if(zarray[k] < r - i + 1){
                    zarray[i] = zarray[k];
                }else{
                    l = i;
                    while(r < len && ch[r- l ] == ch[r]){
                        r++;
                    }

                    zarray[i] = r - l;
                    r--;
                }
            }
        }

        zarray[0] = len;
        return zarray;
    }
}