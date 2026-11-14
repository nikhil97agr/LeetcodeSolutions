package meeting_rooms_iii_2479;

import java.util.*;
class Solution {

    public int mostBooked(int n, int[][] meetings) {
        int counter[] = new int[n];
        PriorityQueue<int[]> started = new PriorityQueue<int[]>((a,b)->{
            if(a[0]==b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int minAvailRoom = 0;
        PriorityQueue<Integer> minRoomAvail = new PriorityQueue<Integer>();

        Arrays.sort(meetings, (a,b)->a[0]-b[0]);
        int i=0;
        int m = meetings.length;
        for(;i<m;i++){
            int meeting[] = meetings[i];
            int ended[] = started.peek();
            if(ended!=null && ended[0] <= meeting[0]){
                i--;
                started.poll();
                minRoomAvail.offer(ended[1]);
                continue;
            }

            if(started.size()<n){
                int nextRoom = -1;
                if(minRoomAvail.isEmpty()){
                    nextRoom = minAvailRoom++;
                }else{
                    nextRoom = minRoomAvail.poll();
                }
                counter[nextRoom]++;
                started.offer(new int[]{meeting[1], nextRoom});
                continue;
            }

            int newEnd = meeting[1] + ended[0] - meeting[0];
            started.poll();
            started.offer(new int[]{newEnd, ended[1]});
            counter[ended[1]]++;

        }
        int minRoom = -1;
        int maxMeeting = 0;
        for(int j=0;j<n;j++){
            if(counter[j]>maxMeeting){
                minRoom = j;
                maxMeeting = counter[j];
            }
        }
        return minRoom;
    }
}