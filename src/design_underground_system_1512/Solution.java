package design_underground_system_1512;

import java.util.*;
class UndergroundSystem {
    class CheckInDetail{
        int id;
        String station;
        int time;

        public CheckInDetail(int id, String station, int time){
            this.id = id;
            this.station = station;
            this.time = time;
        }

        public boolean equals(Object obj){
            CheckInDetail detail = (CheckInDetail)obj;
            return detail.id == this.id;
        }
    }
    HashMap<Integer, CheckInDetail> checkIn;
    HashMap<String, Map<String, List<Integer>>> avgTime;
    public UndergroundSystem() {
        avgTime = new HashMap<>();
        checkIn = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new CheckInDetail(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInDetail detail = checkIn.get(id);
        Map<String, List<Integer>> map = avgTime.getOrDefault(detail.station, new HashMap<>());
        List<Integer> list = map.getOrDefault(stationName, new ArrayList<>());
        if(list.isEmpty()){
            list.add(t-detail.time);
            list.add(1);
        }else{
            int time = list.get(0);
            int total = list.get(1);
            list = new ArrayList<>();
            time += (t-detail.time);
            total++;
            list.add(time);
            list.add(total);
        }
        map.put(stationName, list);
        avgTime.put(detail.station, map);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<Integer> list = avgTime.getOrDefault(startStation, new HashMap<>()).getOrDefault(endStation, new ArrayList<>());

        if(list.isEmpty()){
            return 0d;
        }

        double time = (double)list.get(0);
        double total = (double)list.get(1);
        return time/total;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */