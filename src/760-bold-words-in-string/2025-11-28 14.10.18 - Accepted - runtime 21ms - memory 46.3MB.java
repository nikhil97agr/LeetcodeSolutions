class Solution {
    public String boldWords(String[] words, String s) {
        List<Pair> list = new ArrayList<>();

        for(String w : words){
            int lps[] = lps(w);

            list.addAll(findPair(s.toCharArray(), w.toCharArray(), lps));

        }

        Collections.sort(list, (a,b)->{
            if(a.start == b.start) return b.end - a.end;

            return a.start - b.start;
        });


        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int i=0;
        int cnt = 0;
        int j= 0;
        while( i < s.length()){
            if(j < list.size()){
                if(list.get(j).start <= i){
                    if(que.isEmpty()){
                        sb.append("<b>");
                        que.offer(list.get(j).end);
                    }else{
                        que.offer(list.get(j).end);
                    }
                    j++;
                    continue;
                }


            }
            if(!que.isEmpty() && que.peek() <= i){
                que.poll();
                if(que.isEmpty()){
                    sb.append("</b>");
                }
            }else{
                sb.append(s.charAt(i));
                i++;
            }
        }

        if(!que.isEmpty()){
            sb.append("</b>");
        }

        return sb.toString();
    }

    private List<Pair> findPair(char a[], char b[], int lps[]){
        int n = a.length;
        int m = b.length;
        int i=0;
        List<Pair> list= new ArrayList<>();
        int j=0;
        while ( i < n){
            if(a[i] == b[j]){
                i++;
                j++;

                if(j==m){
                    list.add(new Pair(i-j, i));
                    j = lps[j-1];
                }
            }else{
                if(j ==0){
                    i++;
                }else{
                    j = lps[j-1] ;
                }
            }
        }
        return list;
    }

    private int[] lps(String s){
        int n = s.length();

        int lps[] = new int[n];

        int len = 0;
        int i = 1;
        while( i < n){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len !=0){
                    len = lps[len - 1];
                }else{
                    i++;
                }
            }
        }
        return lps;
    }

    class Pair{
        int start;
        int end;

        public Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}