package find_pattern_in_infinite_stream_ii_3352;

// Definition for an infinite stream.
abstract class InfiniteStream {
    public InfiniteStream(int[] bits) {}
    public abstract int next();
}
class Solution {
    public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
        int lps[] = lps(pattern);
        int n = pattern.length;
        int j = 0;
        int i=0;
        int next = infiniteStream.next();
        while(true){
            
            if(next == pattern[j]){
                i++;
                next = infiniteStream.next();
                j++;

                if(j == n){
                    return i - j;
                }
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    next = infiniteStream.next();
                    i++;
                }
            }
        }
    }

    private int[] lps(int pattern[]){
        int n = pattern.length;
        int lps[] = new int[n];

        int i=1;
        int len = 0;
        while( i < n){
            if(pattern[i] == pattern[len]){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len !=0){
                    len = lps[len - 1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}