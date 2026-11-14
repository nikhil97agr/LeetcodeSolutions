package design_exam_scores_tracker_4059;

import java.util.*;
class ExamTracker {
    List<Record> list = new ArrayList<>();
    public ExamTracker() {
        
    }
    
    public void record(int time, int score) {
        Record record = new Record(time, score);
        if(list.isEmpty()){
            list.add(record);
            return;
        }

        record.score += list.get(list.size()-1).score;
        list.add(record);
    }
    
    public long totalScore(int start, int end) {

        if(list.isEmpty()) return 0l;

        if(list.get(0).time > end){
            return 0;
        }

        if(list.get(list.size()-1).time < start) return 0;
        
        int s = 0;
        int e = list.size()-1;
        long a= 0;
        long b = 0;
        while(s <= e){
            int mid = (s+e)/2;

            if(list.get(mid).time < start){
                a = list.get(mid).score;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }

        s = 0;
        e = list.size()-1;

        while(s <= e){
            int mid = (s+e)/2;

            if(list.get(mid).time <= end){
                b = list.get(mid).score;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }

        return b-a;
    }
}

class Record{
    int time;
    long score;

    public Record(int time, long score){
        this.time = time;
        this.score = score;
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */