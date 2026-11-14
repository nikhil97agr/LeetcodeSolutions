class Solution {
    public int minStoneSum(int[] piles, int k) {
      PriorityQueue<Integer> que = new PriorityQueue<Integer>((x,y)->{
          return y-x;
      });
      for(int x : piles){
          que.add(x);
      }  

      while(!que.isEmpty()&&k-->0){
          int x  =que.poll();
          x -= x/2;
          if(x>0){
              que.add(x);
          }
      }
      int total = 0;
      while(!que.isEmpty()){
          total += que.poll();
      }
      return total;
    }
}