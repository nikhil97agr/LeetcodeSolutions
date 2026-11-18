package car_fleet_ii_1902;

import java.util.*;
class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        var stack =new Stack<Integer>();
        int n =cars.length;
        var result = new double[n];

        Arrays.fill(result, -1);

        for(int i=n-1;i>=0;i--){
            int pos = cars[i][0];
            int speed = cars[i][1];
            while(!stack.isEmpty()){
                int peek = stack.peek();
                int pFront = cars[peek][0];
                int sFront = cars[peek][1];
                double time = (1d * pFront - pos)/(speed - sFront) ;
                if(speed <= sFront){
                    stack.pop();
                }else if(time>= result[peek] && result[peek] > 0){
                    stack.pop();
                }else{
                    result[i] = time;
                    break;
                }
            }


            stack.push(i);
        }


        return result;
    }
}