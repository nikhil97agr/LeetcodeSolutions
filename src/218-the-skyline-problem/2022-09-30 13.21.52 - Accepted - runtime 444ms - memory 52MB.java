class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b)->{
            return -a.compareTo(b);
        });
        int n = buildings.length;
        int start[] []= new int[n][2];
        int end[][] = new int[n][2];
        int i=0;
        for(int []x : buildings){
            start[i][0] = x[0];
            start[i][1] = x[2];
            end[i][0] = x[1];
            end[i][1] = x[2];
            i++;
        }
Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(end, (a,b)->{
            if(a[0]>b[0]){
                return 1;
            }
            return -1;
        });
        int i1=0;
        int i2=0;
        int currMax= 0;
        while(i1<n&&i2<n){
            int x1 = start[i1][0];
            int x2 = end[i2][0];
            if(x1<=x2){
                int height = start[i1][1];
                if(q.isEmpty()){
                    q.add(height);
                    currMax = height;
                    map.put(x1, height);
                    
                }else{
                    q.add(height);
                    if(q.peek()!=currMax){
                        currMax = height;
                        map.put(x1, height);
                    }
                }
                i1++;
            }else{
                int height = end[i2][1];
                i2++;
                q.remove(height);
                if(q.isEmpty()){
                    currMax = 0;
                    map.put(x2, 0);
                }
                else if(q.peek()!=currMax){
                    currMax= q.peek();
                    map.put(x2, currMax);
                }
            }
        }
        
        while(i2<n){
            int x2 = end[i2][0];
            int height = end[i2][1];
            i2++;
            q.remove(height);
            if(q.isEmpty()){
                currMax = 0;
                map.put(x2, 0);
            }else if(q.peek()!=currMax){
                currMax =q.peek();
                map.put(x2, currMax);
            }
            
        }
        map.forEach((k,v)->{
            result.add(Arrays.asList(new Integer[]{k,v}));
        });
        return result;
    }
}