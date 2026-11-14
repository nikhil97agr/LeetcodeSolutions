package maximum_number_of_upgradable_servers_3458;

class Solution {
    public int[] maxUpgrades(int[] count, int[] upgrade, int[] sell, int[] money) {
        int n = count.length;
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            int min = 0;
            int max = count[i];
            int m = money[i];
            int total = 0;
            while(min <= max){
                int mid = (min+max)/2;
                int left = count[i] - mid;
                long totalMoney = 1l*m + 1l*sell[i]*left;
                long servers = totalMoney/upgrade[i];
                if(servers >= 1l*mid){
                    total = mid;
                    min = mid + 1;
                }else{
                    max = mid - 1;
                }
            }
            ans[i] = total;
        }

        return ans;
    }
}