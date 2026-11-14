/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> que = new PriorityQueue<>((a,b)-> a.start - b.start);

        for(List<Interval> list : schedule){
            for(Interval it : list){
                que.add(it);
            }
        }
        if(que.size()==1) return result;

        int lastEnd = que.poll().end;
        while(!que.isEmpty()){
            Interval i = que.poll();
            if(i.start > lastEnd){
                result.add(new Interval(lastEnd, i.start));
                lastEnd = i.end;
            }else{
                lastEnd = Math.max(lastEnd, i.end);
            }
        }
        return result;

    }
}