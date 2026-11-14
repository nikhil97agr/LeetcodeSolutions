/**
 * Definition for an infinite stream.
 * class InfiniteStream {
 *     public InfiniteStream(int[] bits);
 *     public int next();
 * }
 */
class Solution {
    public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
        int ind = 0;
        Queue<Integer> que= new LinkedList<>();
        int n = pattern.length;
        while(true){
            que.offer(infiniteStream.next());
            if(que.size() ==n){
                if(check(pattern, que)){
                    return ind;
                }
                ind++;
                que.poll();
            }
        }



    }

    private boolean check(int pattern[], Queue<Integer> que){
        int n = pattern.length;
        int i=0;
        boolean flag = true;
        while(i<n){
            int ele = que.poll();
            if(pattern[i] != ele){
                flag = false;
            }
            que.offer(ele);
            i++;
            
        }

        return flag;
    }
}