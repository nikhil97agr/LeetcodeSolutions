package minimum_fuel_cost_to_report_to_the_capital_2568;

import java.util.*;
class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        for(int r[] : roads){
            int u = r[0];
            int v = r[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        Response response = new Response(0,0,0);

        for(int child : adjList[0]){
            Response res = dfs(adjList, child, 0, seats);
            response.fuel += res.fuel;
            response.seats += res.seats;
            response.cars += res.cars;
        }
        return response.fuel;
    }

    private Response dfs(LinkedList<Integer> adjList[], int curr, int par, int seats ){
        
        Response response = new Response(0, 0, 0);
        for(int child : adjList[curr]){
            if(child != par){
                Response res = dfs(adjList, child, curr, seats);
                response.cars += res.cars;
                response.seats+=res.seats;
                response.fuel += res.fuel;
            }
        }
        if(response.seats !=0){
            response.seats--;
            long cars = response.seats / seats;
            response.seats = response.seats%seats;
            response.cars -= cars;
            response.fuel += response.cars;
        }else{
            response.seats = seats-1;
            response.cars++;
            response.fuel += response.cars;
        }

        return response;
    }

    class Response{
        long cars;
        long seats;
        long fuel;

        public Response(long cars, long seats, long fuel){
            this.cars = cars;
            this.seats = seats;
            this.fuel = fuel;
        }
    }
}