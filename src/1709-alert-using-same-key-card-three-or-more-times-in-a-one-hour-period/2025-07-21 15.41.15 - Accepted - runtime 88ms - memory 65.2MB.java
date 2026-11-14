class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> res = new ArrayList<>();

        Map<String, List<Integer>> map = new HashMap<>();

        for(int i=0;i<keyName.length;i++){
            map.computeIfAbsent(keyName[i], s -> new ArrayList<>()).add(seconds(keyTime[i]));
        }
        
        for(String key : map.keySet()){
            List<Integer> list = map.get(key);
            Collections.sort(list);
            for(int i=2;i<list.size();i++){
                if(check(list.get(i) - list.get(i-2))){
                    res.add(key);
                    break;
                }
            }
        }

        Collections.sort(res);

        return res;
    }

    private boolean check(int diff){
        
        return diff <= 3600;
    }

    private int seconds(String time){
        String t [] = time.split(":");
        int hrs = Integer.parseInt(t[0]);
        int min = Integer.parseInt(t[1]);

        return hrs*60*60 + min*60;
    }
}