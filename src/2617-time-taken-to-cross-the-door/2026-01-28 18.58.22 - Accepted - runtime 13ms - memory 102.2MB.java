class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int sec = 0;
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n = arrival.length;
        int ans[] = new int[n];
        int i=0;
        boolean isExit = true;
        while( true){
            while(i < n && arrival[i] <= sec){
                if(state[i] ==0){
                    enter.add(i);
                }else{
                    exit.add(i);
                }
                i++;
            } 
            if(isExit){
                if(!exit.isEmpty()){
                    ans[exit.poll()]= sec;
                }else if(!enter.isEmpty()){
                    ans[enter.poll()] = sec;
                    isExit = false;
                }else{
                    isExit = true;
                }
            }else{
                if(!enter.isEmpty()){
                    ans[enter.poll()] = sec;
                }else if(!exit.isEmpty()){
                    ans[exit.poll()] = sec;
                    isExit = true;
                }else{
                    isExit = true;
                }
            }

            sec++;

            if(i == n && enter.isEmpty() && exit.isEmpty()) return ans;
        }
    }
}