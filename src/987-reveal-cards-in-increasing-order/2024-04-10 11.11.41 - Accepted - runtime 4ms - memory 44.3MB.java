class Solution {
    public int[] deckRevealedIncreasing(int[] arr) {
        int n =arr.length;
        Arrays.sort(arr);
        if(n<=2) return arr;
        Queue<Integer> que = new LinkedList<>();
        que.offer(arr[n-1]);
        que.offer(arr[n-2]);
        for(int i=n-3;i>=0;i--){
            int x= que.poll();
            que.offer(x);
            que.offer(arr[i]);
        }   

        int ans[] = new int[n];
        int i = n-1;
        while(!que.isEmpty()){
            ans[i] = que.poll();
            i--;
        }
        return ans;
    }
}