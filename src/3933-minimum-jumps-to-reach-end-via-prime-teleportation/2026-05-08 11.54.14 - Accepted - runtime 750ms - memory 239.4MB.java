import java.util.*;

class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if(n<2) return 0;
        if(n==2) return 1;
        int max = Arrays.stream(nums).max().getAsInt();
        boolean primes[] = new boolean[max+1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for(int i=2;i<primes.length;i++){
            if(primes[i]){
                int j = i+i;

                while(j< primes.length){
                    primes[j] = true;
                    j+=i;
                }
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            build(map, i, nums[i]);
        }

        Set<Integer> vis = new HashSet<>();
        
        vis.add(0);
        PriorityQueue<Node> que= new PriorityQueue<>((p1,p2)-> p1.cnt - p2.cnt);
        
        que.offer(new Node(0, 0));
        while(!que.isEmpty()){
            Node node = que.poll();
            
            if(node.ind == n-1){
                return node.cnt;
            }
            
            int diff[] = new int[]{1, -1};
            
            for(int x : diff){
                int ni = node.ind + x;
                
                if(ni >=0 && ni < n && !vis.contains(ni)){
                    vis.add(ni);
                    que.offer(new Node(ni, node.cnt + 1));
                }
            }
            
            if(primes[nums[node.ind]] && map.containsKey(nums[node.ind])){
                List<Integer> list = map.get(nums[node.ind]);
                for(int x : list){
                    if(!vis.contains(x)){
                       que.offer(new Node(x, node.cnt + 1)); 
                       vis.add(x);
                    }
                }
                
                map.remove(nums[node.ind]);
                
            }
        }
        return -1;

    }
    
    class Node{
        int ind;
        int cnt;
        
        public Node(int ind, int cnt){
            this.ind = ind;
            this.cnt = cnt;
        }
    }

    private void build(Map<Integer, List<Integer>> map, int i, int n){
        if(n%2==0){
            add(map, 2, i);
            while(n%2==0){
                 n/=2;
            }
        }
        for(int j=3;j<=Math.sqrt(n);j+=2){
            if(n%j ==0){
                add(map, j, i);

                while(n%j==0) n/=j;
            }
        }

        if(n > 1){
            add(map, n, i);
        }


    }

    private void add(Map<Integer, List<Integer>> map, int val, int i){
        map.computeIfAbsent(val, x-> new ArrayList<>()).add(i);
    }
}