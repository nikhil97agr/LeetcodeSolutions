class Solution {
    public int getMinSwaps(String num, int k) {
        int ans = 0;
        int n = num.length();
        char ch[] = num.toCharArray();
        Queue<Integer> que[] = new LinkedList[10];
        for(int i=0;i<10;i++) que[i] = new LinkedList<>();
        for(int i=0;i<n;i++){
            int dig =num.charAt(i) - '0';
            que[dig].offer(i);
        }
        while( k > 0){
            generate(ch);
            k--;
        }
        
        char src[] = num.toCharArray();
        for(int i=0;i<n;i++){
            if(src[i] == ch[i]) continue;

            int j= i +1;
            while(src[j] != ch[i]) j++;

            while( j > i){
                char temp = src[j];
                src[j] = src[j-1];
                src[j-1] = temp;
                ans++;
                j--;
            }
        }

        return ans;
    }

    private void generate(char ch[]){
        PriorityQueue<Character> que = new PriorityQueue<>();
        int n = ch.length;
        int ind[] = new int[10];
        Arrays.fill(ind , -1);
        for(int i=n-1;i>=0;i--){
            int dig = ch[i] - '0';
            que.offer(ch[i]);
            int i1 = -1;
            for(int j= dig + 1;j<10;j++){
                if(ind[j] !=-1){
                    i1 = ind[j];
                    break;
                }
            }


            if(ind[dig]==-1){
                ind[dig] = i;
            }

            if(i1 != -1){
                char temp = ch[i];
                ch[i] = ch[i1];
                ch[i1] = temp;

                i1 =i + 1;
                boolean found= false;
                while(!que.isEmpty()){

                    if(ch[i] == que.peek() && !found){
                        que.poll();
                        found = true;
                        continue;
                    }
                    ch[i1] =que.poll();
                    i1++;
                }
                break;
            }
        }
    }
}