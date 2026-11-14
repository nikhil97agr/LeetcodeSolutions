package count_mentions_per_user_3721;


import java.util.*;

class Solution {

    public static void main(String[] args) {
        List<List<String>> temp = new ArrayList<>();
        temp.add(Arrays.asList("MESSAGE", "2", "HERE"));
        temp.add(Arrays.asList("OFFLINE", "2", "1"));
        temp.add(Arrays.asList("OFFLINE", "1", "0"));
        temp.add(Arrays.asList("MESSAGE", "61", "HERE"));
        System.out.println(Arrays.toString(new Solution().countMentions(
                3,
                temp
        )));
    }

    public int[] countMentions(int n, List<List<String>> events) {
        TreeMap<Integer, PriorityQueue<List<String>>> map = new TreeMap<>();
        for(List<String> e : events){
            map.computeIfAbsent(Integer.parseInt(e.get(1)), q -> new PriorityQueue<>((e1, e2)->{
                String msg = e1.get(0);

                if(msg.equals("MESSAGE")) return 1;
                return -1;
            })).offer(e);
        }
        int ans[] = new int[n];
        PriorityQueue<Offline> que = new PriorityQueue<>((a,b)-> a.timestamp - b.timestamp);
        Set<Integer> online = new HashSet<>();
        for(int i=0;i<n;i++) online.add(i);
        for(int key : map.keySet()){
            PriorityQueue<List<String>> pq = map.get(key);
            while(!pq.isEmpty()){
                List<String> list = pq.poll();
                String msg = list.get(0);
                int time = Integer.parseInt(list.get(1));
                String mention = list.get(2);
                while(!que.isEmpty() && que.peek().timestamp <= time){
                    Offline of = que.poll();
                    online.add(of.user);
                }

                switch(msg){
                    case "MESSAGE":{
                        if(Objects.equals(mention, "HERE")){
                            for(int x : online){
                                ans[x]++;
                            }
                        }else if(mention.equals("ALL")){
                            for(int i=0;i<n;i++){
                                ans[i]++;
                            }
                        }else{
                            for(String id : mention.split(" ")){
                                int dig = Integer.parseInt(id.substring(2));
                                ans[dig]++;
                            }
                        }

                        break;
                    }
                    case "OFFLINE":{
                        int id = Integer.parseInt(mention);
                        que.offer(new Offline(id, time));
                        online.remove(id);
                        break;
                    }
                }
            }

        }

        return ans;
    }

    class Offline{
        int user;
        int timestamp;

        public Offline(int user, int timestamp){
            this.user = user;
            this.timestamp = timestamp + 60;
        }
    }
}