class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer>que = new LinkedList<>();
        for(int x : students){
            que.offer(x);
        }
        int cnt = 0;
        int i=0;
        boolean changed = true;
        while(changed){
            changed = false;
            int size= que.size();
            while(size-->0){
                int x  = que.poll();
                if(x ==  sandwiches[i]){
                    changed = true;
                    cnt++;
                    i++;    
                }else{
                    que.offer(x);
                }

            }
        }

        return students.length - cnt;
    }
}