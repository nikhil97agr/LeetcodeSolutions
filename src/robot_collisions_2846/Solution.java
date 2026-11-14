package robot_collisions_2846;

import java.util.stream.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot robot[] = new Robot[n];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            robot[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
            res.add(0);
        }

        Arrays.sort(robot, Comparator.comparingInt(r -> r.pos));
        Stack<Robot> stack = new Stack<>();

        for(Robot r : robot){
            if(r.dir == 'R'){
                stack.push(r);
                continue;
            }

            while(!stack.isEmpty() && stack.peek().health < r.health){
                stack.pop();
                r.health--;
            }

            if(stack.isEmpty()){
                res.set(r.ind, r.health);
            }else{
                if(stack.peek().health == r.health){
                    stack.pop();
                }else{
                    stack.peek().health--;
                }
            }
        }

        while(!stack.isEmpty()){
            Robot r = stack.pop();
            res.set(r.ind, r.health);
        }
        
        return res.stream().filter(x -> x!=0).collect(Collectors.toList());
    }

    class Robot{
        int pos;
        int health;
        char dir;
        int ind;

        public Robot(int pos, int health, char dir, int ind){
            this.pos=  pos;
            this.health = health;
            this.dir = dir;
            this.ind = ind;
        }
    }

    
}