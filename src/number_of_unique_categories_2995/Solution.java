package number_of_unique_categories_2995;

import java.util.*;
// Definition for a category handler.
abstract class CategoryHandler {
    public CategoryHandler(int[] categories) {}
    public abstract boolean haveSameCategory(int a, int b);
}
class Solution {
	public int numberOfCategories(int n, CategoryHandler categoryHandler) {
    	int par[] =new int[n];
        for(int i=0;i<n;i++){
            par[i] = i;
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int p1 = find(par, i);
                int p2 = find(par, j);
                if(p1 != p2){
                    if(categoryHandler.haveSameCategory(i, j)){
                        par[p1] = p2;
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            int p = find(par, i);
            set.add(p);
        }

        return set.size();
	}

    private int find(int par[], int p){
        if(par[p] == p) return p;

        return par[p] = find(par, par[p]);
    }
}