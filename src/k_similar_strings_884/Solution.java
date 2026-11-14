package k_similar_strings_884;

import java.util.*;
class Solution {
    public int kSimilarity(String s1, String s2) {
        int ans = 0;
        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();

        int n =ch1.length;

        Queue<char[]> que = new LinkedList<>();
        que.offer(ch1);
        Set<String> vis = new HashSet<>();
        vis.add(new String(ch1));
        while(!que.isEmpty()){
            int size = que.size();
            while(size--> 0){
                char curr[] = que.poll();
                if(Arrays.equals(curr,ch2)) return ans;
                for(int i=0;i<n;i++){
                    if(curr[i] == ch2[i]){
                        continue;
                    }
                    for(int j=i+1;j<n;j++){
                        if(ch2[i] == curr[j]){
                            char clone[] = curr.clone();
                            char temp = clone[i];
                            clone[i] = clone[j];
                            clone[j] = temp;
                            String s = new String(clone);
                            if(!vis.contains(s)){
                                vis.add(s);
                                que.offer(clone);
                            }
                        }
                    }

                    break;
                }
            }
            ans++;
        }

        return -1;
    }
}