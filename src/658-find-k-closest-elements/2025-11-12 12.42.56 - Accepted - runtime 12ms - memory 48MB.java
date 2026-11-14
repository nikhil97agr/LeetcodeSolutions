import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Deque<Integer> que= new ArrayDeque<>();
        int curr = Integer.MAX_VALUE;
        int ind = -1;
        int n = arr.length;
        for(int i=0;i<n;i++){
            int diff = Math.abs(arr[i] - x);
            if(diff < curr){
                curr = diff;
                ind = i;
            }


        }
        que.offer(arr[ind]);
        int start = ind - 1;
        int end = ind + 1;
        while(que.size() < k && start >=0 && end < n ){
            int a1 = Math.abs(x - arr[start]);
            int a2 = Math.abs(x - arr[end]);

            if(a1 <= a2){
                que.offerFirst(arr[start]);
                start--;
            }else{
                que.offerLast(arr[end]);
                end++;
            }


        }

        while(que.size() < k && start >=0){
            que.offerFirst(arr[start]);
            start--;
        }

        while(que.size() < k && end < n){
            que.offerLast(arr[end]);
            end++;
        }

        return que.stream().toList();
    }
}