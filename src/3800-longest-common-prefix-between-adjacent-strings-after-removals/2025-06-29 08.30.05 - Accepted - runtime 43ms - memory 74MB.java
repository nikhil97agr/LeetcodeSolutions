import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public int[] longestCommonPrefix(String[] words) {
        int n =words.length;
        int ans[] = new int[n];
        if(n==1){
            return ans;
        }
        TreeMap<Integer, List<Pair>> map= new TreeMap<>();

        for(int i=0;i<n-1;i++){
            int len = getLen(words[i], words[i+1]);

            map.computeIfAbsent(len, l -> new ArrayList<>()).add(new Pair(i, i+1));
        }
        int max = map.lastKey();
        int cnt = map.get(max).size();
        List<Pair> list = map.get(max);
        
        for(int i=0;i<n;i++){
            if(i==0){
                if(cnt > 1){
                    ans[i] = max;
                }else{
                    Pair pair = list.get(0);
                    if(pair.first == 0){
                        Integer next = map.lowerKey(max);
                        if(next != null){
                            ans[i] = next;
                        }
                    }else{
                        ans[i] = max;
                    }
                }
            }else if(i==n-1){
                if(cnt > 1){
                    ans[i] = max;
                }else{
                    Pair pair = list.get(0);
                    if(pair.second == n-1){
                        Integer next = map.lowerKey(max);
                        if(next !=null){
                            ans[i] = next;
                        }
                    }else{
                        ans[i] = max;
                    }
                }
            }else{
                if(cnt > 2){
                    ans[i] = Math.max(max, getLen(words[i-1], words[i+1]));
                }else if(cnt ==1){
                    Pair p = list.get(0);
                    
                    if(p.first ==i  || p.second == i){
                        Integer next = map.lowerKey(max);
                        if(next == null){
                            ans[i] = getLen(words[i-1], words[i+1]);
                        }else{
                            ans[i] = Math.max(next, getLen(words[i-1], words[i+1]));
                        }
                    }else{
                        ans[i] = Math.max(max, getLen(words[i-1], words[i+1]));
                    }
                }else{
                    Pair p1 = list.get(0);
                    Pair p2 =list.get(1);
                    
                    if((p1.first ==i || p1.second == i) && (p2.first ==i || p2.second == i)){
                        Integer next = map.lowerKey(max);
                        
                        if(next == null){
                            ans[i] = getLen(words[i-1], words[i+1]);
                        }else{
                            ans[i] = Math.max(next, getLen(words[i-1], words[i+1]));
                        }
                    }else{
                        ans[i] = Math.max(max, getLen(words[i-1], words[i+1]));
                    }
                }
            }
        }
        return ans;
    }

    private int getLen(String a, String b){
        int i=0;
        int j=0;
        while(i < a.length() && j < b.length()){
            if(a.charAt(i)!= b.charAt(j)){
                return i;
            }
            i++;
            j++;
        }

        return Math.min(a.length(), b.length());

    }

    class Pair{
        int first;
        int second ;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}