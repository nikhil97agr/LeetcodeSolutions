import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> cost=new HashMap<>();
        Map<String, List<String>> parents = new HashMap<>();

        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        int level = 0;
        int n = beginWord.length();
        cost.put(beginWord, 1);
        parents.put(beginWord, new ArrayList<>());
        Set<String> words  =new HashSet<>(wordList);
        words.add(beginWord);

        while(!que.isEmpty()){
            int size = que.size();
            level++;
            while(size--> 0){
                String next = que.poll();
                if (next.equals(endWord)) {
                    break;
                }

                for(int i=0;i<n;i++){
                    char ch[] = next.toCharArray();
                    for(char c = 'a';c<='z';c++){
                        ch[i] = c;

                        String s = new String(ch);
                        if(!words.contains(s) || s.equals(next)){
                            continue;
                        }
                        if(!parents.containsKey(s)){
                            parents.put(s, new ArrayList<>());
                            cost.put(s, level + 1);
                            que.offer(s);

                        }

                        if(cost.get(s) == level + 1){
                            parents.get(s).add(next);
                        }

                    }
                }
            }
        }

        List<List<String >> result = new ArrayList<>();
        if(!parents.containsKey(endWord)){
            return result;
        }

        bfs(parents, endWord, beginWord, result, new ArrayList<>());

        return result;
    }

    private void bfs(Map<String, List<String>> map, String curr, String src, List<List<String>> result, List<String> list){
        if(curr.equals(src)){
            list.add(src);
            Collections.reverse(list);
            result.add(list);
            return;
        }

        for(String s : map.get(curr)){
            List<String> path = new ArrayList<>(list);
            path.add(curr);
            bfs(map, s, src, result, path);
        }
    }
}