class Solution {
    public int totalFruit(int[] fruits) {
        int num1 = -1;
        int num2 = -1;
        int cnt1 = 0;
        int cnt2 = 0;
        int ans = 0;

        int start = 0;
        int end = 0;

        while(end < fruits.length){
            if(fruits[end] == num1) cnt1++;
            if(fruits[end] == num2) cnt2++;
            ans = Math.max(ans, cnt1 + cnt2);
            if(num1 == -1){
                num1 = fruits[end];
                cnt1 = 1;
            }else if(num2 == -1 && num1 != fruits[end]){
                num2 = fruits[end];
                cnt2 = 1;
            }else if(num1!=-1 && num2!=-1 && num1 != fruits[end] && num2 != fruits[end]){
                while(cnt1 !=0 && cnt2 !=0){
                    ans = Math.max(ans, cnt1 + cnt2);
                    if(fruits[start] == num1){
                        cnt1--;
                    }else{
                        cnt2--;
                    }
                    start++;
                }
                if(cnt1 == 0){
                    num1 = fruits[end];
                    cnt1 = 1;
                }else{
                    num2 = fruits[end];
                    cnt2 = 1;
                }
            }

            end++;
        }

        return Math.max(ans, cnt1 + cnt2);
    }
}