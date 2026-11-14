class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            map.put(words[i], i);
            set.add(words[i].length());
        }

        for(int i=0;i<n;i++){
            String reverse = new StringBuilder(words[i]).reverse().toString();
            int len = reverse.length();
            if(reverse.length()==1 ){
                if( map.containsKey("")){
                    result.add(Arrays.asList(i, map.get("")));
                    result.add(Arrays.asList(map.get(""), i));
                    
                }
                continue;
            }

            if(map.containsKey(reverse) && map.get(reverse)!=i){
                result.add(Arrays.asList(i, map.get(reverse)));
            }
            for(int x : set){
                if(x==len) break;

                if(isPalindrome(reverse, 0, len-1-x) && map.containsKey(reverse.substring(len-x))){
                    result.add(Arrays.asList(i, map.get(reverse.substring(len-x))));
                }

                if(isPalindrome(reverse, x, len-1) && map.containsKey(reverse.substring(0,x))){
                    result.add(Arrays.asList(map.get(reverse.substring(0,x)), i));
                }
            }
        }
       
        return result;
    }

    private boolean isPalindrome(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }
}