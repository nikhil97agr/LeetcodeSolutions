package robot_room_cleaner_865;

import java.util.*;
// This is the robot's control interface.
// You should not implement it, or speculate about its implementation
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();
    public void turnRight();

    // Clean the current cell.
    public void clean();
}

class Solution {
    public void cleanRoom(Robot robot) {
        Set<String> set = new HashSet<>();
        solve(0, 0, set, robot, "up");
    }

    private void solve(int i, int j, Set<String> set, Robot robot, String orientation){

        String key = ""+i+":"+j;

        if(set.contains(key)) return;
        set.add(key);
        robot.clean();
        switch(orientation){
            case "up":{
                if(!set.contains(""+(i-1)+":"+j)&&robot.move()){
                    solve(i-1, j, set, robot, "up");
                    returnRobot(robot);
                }
                robot.turnLeft();
                if(!set.contains(""+i+":"+(j-1))&&robot.move()){
                    solve(i, j-1, set, robot, "left");
                    returnRobot(robot);
                }
                robot.turnLeft();
                if(!set.contains(""+(i+1)+":"+j)&&robot.move()){
                    solve(i+1, j, set, robot, "down");
                    returnRobot(robot);
                }

                robot.turnLeft();
                if(!set.contains(""+i+":"+(j+1))&&robot.move()){
                    solve(i, j+1, set, robot, "right");
                    returnRobot(robot);
                }
                robot.turnLeft();

                break;
            }

            case "left" : {
                if(!set.contains(""+i+":"+(j-1))&&robot.move()){
                    solve(i, j-1, set, robot, "left");
                    returnRobot(robot);
                }
                robot.turnLeft();
                if(!set.contains(""+(i+1)+":"+j)&&robot.move()){
                    solve(i+1, j, set, robot, "down");
                    returnRobot(robot);
                }
                robot.turnLeft();
                if(!set.contains(""+i+":"+(j+1))&&robot.move()){
                    solve(i, j+1, set, robot, "right");
                    returnRobot(robot);
                }

                robot.turnLeft();
                if(!set.contains(""+(i-1)+":"+j)&&(robot.move())){
                    solve(i-1, j, set, robot, "up");
                    returnRobot(robot);
                }
                robot.turnLeft();
                break;
            }
            case "right" : {
                if(!set.contains(""+i+":"+(j+1))&&robot.move()){
                    solve(i, j+1, set, robot, "right");
                    returnRobot(robot);
                }
                robot.turnLeft();
                if(!set.contains(""+(i-1)+":"+j)&&robot.move()){
                    solve(i-1, j, set, robot, "up");
                    returnRobot(robot);
                }
                robot.turnLeft();
                if(!set.contains(""+i+":"+(j-1))&&robot.move()){
                    solve(i, j-1, set, robot, "left");
                    returnRobot(robot);
                }

                robot.turnLeft();
                if(!set.contains(""+(i+1)+":"+j)&&robot.move()){
                    solve(i+1, j, set, robot, "down");
                    returnRobot(robot);
                }
                robot.turnLeft();
                break;
            }

            case "down" : {
                if(!set.contains(""+(i+1)+":"+j)&&robot.move()){
                    solve(i+1, j, set, robot, "down");
                    returnRobot(robot);
                }
                robot.turnLeft();
                if(!set.contains(""+i+":"+(j+1))&&robot.move()){
                    solve(i, j+1, set, robot, "right");
                    returnRobot(robot);
                }
                robot.turnLeft();
                if(!set.contains(""+(i-1)+":"+j)&&robot.move()){
                    solve(i-1, j, set, robot, "up");
                    returnRobot(robot);
                }

                robot.turnLeft();
                if(!set.contains(""+i+":"+(j-1))&&robot.move()){
                    solve(i, j-1, set, robot, "left");
                    returnRobot(robot);
                }
                robot.turnLeft();
                break;
            }
        }
    }
    private void returnRobot(Robot robot){
         robot.turnLeft();
         robot.turnLeft();
         robot.move();
         robot.turnLeft();
         robot.turnLeft();
    }
}