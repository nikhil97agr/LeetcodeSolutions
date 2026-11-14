package web_crawler_multithreaded_1368;

import java.util.*;
import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;



// This is the HtmlParser's API interface.
// You should not implement it, or speculate about its implementation
interface HtmlParser {
    public List<String> getUrls(String url);
}

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        ExecutorService service = Executors.newFixedThreadPool(5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {

                Thread thread = new Thread(r);
                thread.setDaemon(true);

                return thread;
            }
        });

        String host = startUrl.split("/")[2];
        Set<String> visited = new HashSet<>();
        Queue<Future<List<String>>> que = new LinkedList<>();

        visited.add(startUrl);
        que.offer(service.submit(()-> htmlParser.getUrls(startUrl)));

        while(!que.isEmpty()){

            Future<List<String>> future = que.poll();

            List<String> urls = null;
            try {
                urls = future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }

            for(String url : urls){
                String h = url.split("/")[2];

                if(!h.equals(host) || visited.contains(url)){
                    continue;
                }
                
                visited.add(url);
                que.offer(service.submit(() -> htmlParser.getUrls(url)));
            }
        }
        return new ArrayList<>(visited);
    }
}