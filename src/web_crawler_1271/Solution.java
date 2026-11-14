package web_crawler_1271;

import java.util.*;

// This is the HtmlParser's API interface.
// You should not implement it, or speculate about its implementation
interface HtmlParser {
    public List<String> getUrls(String url);
}

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> set = new HashSet<>();
        Queue<String> que= new LinkedList<>();
        int index = startUrl.indexOf("/", 7);
        String host = index == -1 ? startUrl: startUrl.substring(0, index);
        que.offer(startUrl);
        set.add(startUrl);
        Set<String> visited= new HashSet<>();
        visited.add(startUrl);
        while(!que.isEmpty()){
            String url = que.poll();
            List<String> list = htmlParser.getUrls(url);

            for(String st : list){
                if(!visited.contains(st)){
                    visited.add(st);
                    if(st.startsWith(host)){
                        set.add(st);
                                            que.offer(st);

                    }
                }
            }
        }

        return set.stream().toList();

    }
}