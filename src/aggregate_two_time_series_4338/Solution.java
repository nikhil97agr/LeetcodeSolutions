package aggregate_two_time_series_4338;

import java.util.*;
class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> timestamp = new TreeSet<>();
        for(var x : series1){
            timestamp.add(x[0]);
        }

        for(var x : series2){
            timestamp.add(x[0]);
        }
        sum(map, series1, timestamp);
        sum(map, series2, timestamp);

        List<List<Integer>> result = new ArrayList<>();

        for(var entry : map.entrySet()){
            result.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }

        Collections.sort(result, (a,b)->{
            return a.get(0) - b.get(0);
        });

        return result;
    }

    private void sum(Map<Integer, Integer> map, int series[][], TreeSet<Integer> set){
        int i=0;
        for(int x : set){
            if( i == series.length){
                map.merge(x, 0, Integer::sum);
                continue;
            }
            if(x <= series[i][0]){
                map.merge(x, series[i][1], Integer::sum);
            }else{
                while(i < series.length && x > series[i][0]){
                    i++;
                }


                if(i < series.length){
                    map.merge(x, series[i][1], Integer::sum);
                }
            }
        }

        
    }
}