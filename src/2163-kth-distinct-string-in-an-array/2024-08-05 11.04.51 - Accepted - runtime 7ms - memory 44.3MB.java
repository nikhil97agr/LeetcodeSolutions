class Solution {
    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> map =new LinkedHashMap<>();
        for(String s : arr){
            int cnt = map.getOrDefault(s, 0);

            map.put(s, cnt+1);
        }

        int cnt = 0;

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() ==1) cnt++;

            if(cnt == k) return entry.getKey();
        }

        return "";
    }
}