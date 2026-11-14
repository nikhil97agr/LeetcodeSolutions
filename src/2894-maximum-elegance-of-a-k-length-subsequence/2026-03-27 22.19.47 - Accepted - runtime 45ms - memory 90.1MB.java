class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        long ans = 0;
        var n = items.length;
        Arrays.sort(items, (a,b) -> b[0] - a[0]);
        var stack = new Stack<Integer>();
        var set = new HashSet<Integer>();
        long sum = 0;
        for(int i=0;i<n;i++){
            int p = items[i][0];
            int c = items[i][1];

            if( i < k){
                if(set.contains(c)){
                    stack.push(p);
                }
                sum += p;
                
            }else if(!set.contains(c)){
                if(stack.isEmpty()) break;
                sum += (p - stack.pop());

            }

            set.add(c);
            ans = Math.max(ans, sum + 1l * set.size() * set.size());
        }


        return ans;
    }
}