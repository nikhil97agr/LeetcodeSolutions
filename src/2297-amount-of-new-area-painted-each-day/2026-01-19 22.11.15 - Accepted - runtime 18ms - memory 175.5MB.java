class Solution {
    public int[] amountPainted(int[][] paint) {
       int n = paint.length;
       int ans[] = new int[n];
       TreeMap<Integer, Integer> map = new TreeMap<>();
       for(int i=0;i<n;i++){
            int p[] = paint[i];
            int s = p[0];
            int e = p[1];

            int dist = e - s;
            
            Integer lower = map.floorKey(s);

            if(lower != null){
                int end = map.get(lower);
                
                if(end >= e){
                    continue;
                }
                if(end < e && end >= s){
                    map.remove(lower);
                    dist -= (end - s);
                    s = lower;

                }
                
            }

            Integer higher = map.ceilingKey(s);

            while(higher !=null && e >= higher){
                int end = map.get(higher);

                if(end <= e){
                    map.remove(higher);
                    dist -= (end - higher);

                }else{
                    dist -= (e - higher);
                    e = end;
                    map.remove(higher);
                }

                higher = map.ceilingKey(higher);
            }



            ans[i] = dist;
            map.put(s,e);
       }

       return ans;
    }
}