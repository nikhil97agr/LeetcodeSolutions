package remove_max_number_of_edges_to_keep_graph_fully_traversable_1701;

import java.util.*;
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int count = 0;
        int parent[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        for(int edge[] : edges){
            if(edge[0]==1 || edge[0]==2){
                continue;
            }

            int p1 = find(parent, edge[1]-1);
            int p2 = find(parent, edge[2]-1);
            if(p1!=p2){
                parent[p1] = p2;
            }else{
                count++;
            }

        }
        int alice[]  = parent.clone();
        int bob[] = parent.clone();

        for(int edge[] : edges){
            if(edge[0]==1){
                int p1 = find(alice, edge[1]-1);
                int p2 = find(alice, edge[2]-1);
                if(p1!=p2){
                    alice[p1] = p2;
                }else{
                    count++;
                }
            }else if(edge[0]==2){
                int p1 = find(bob, edge[1]-1);
                int p2 = find(bob, edge[2]-1);
                if(p1!=p2){
                    bob[p1]=p2;
                }else{
                    count++;
                }
            }

        }
        Set<Integer> aliceTraverse = new HashSet<>();
        Set<Integer> bobTraverse = new HashSet<>();

        for(int i=0;i<n;i++){
            aliceTraverse.add(find(alice, i));
            bobTraverse.add(find(bob, i));
        }
        return (aliceTraverse.size()==1 && bobTraverse.size()==1) ? count : -1;
    }

    private int find(int parent[], int i){
        return parent[i] = ((parent[i]==i) ? i : find(parent, parent[i]));
    }
}