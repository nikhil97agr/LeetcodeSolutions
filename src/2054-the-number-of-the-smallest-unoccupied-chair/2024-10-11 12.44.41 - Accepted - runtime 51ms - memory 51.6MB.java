class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
       int maxOccupied = 0;
        PriorityQueue<Integer> q = new PriorityQueue();
        HashMap<Integer, Integer> map = new HashMap();
        List<int[]> list =new ArrayList<int[]>();
        int n = times.length;
        for(int i=0;i<n;i++){
            list.add(new int[]{times[i][0], i, 1});
            list.add(new int[]{times[i][1], i, -1});
        }
        Collections.sort(list, (a,b)->{
           if(a[0]==b[0]){
               if(a[2]==1){
                   return 1;
               }
               return -1;
           }
            return a[0] - b[0];
        });
        
        for(int [] x : list){
            
            if(x[2]==1){
              if(q.isEmpty()){
                  map.put(x[1], maxOccupied++);
              }else{
                  map.put(x[1], q.poll());
              }
            }else{
               q.add(map.get(x[1])); 
            }
            
            if(x[1]==targetFriend){
                return map.get(x[1]);
            }
        }
        return -1;
    }
}