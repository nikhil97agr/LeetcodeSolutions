class Solution {
    public int nextGreaterElement(int n) {
        char arr[]= Integer.toString(n).toCharArray();

        int ind[] = new int[10];
        Arrays.fill(ind, -1);

        for(int i=arr.length -1 ;i>=0;i--){
            int j = -1;
            char dig = ' ';
            for(char k='0';k<='9';k++){
                if(k > arr[i] && ind[k-'0'] != -1){
                    j = ind[k-'0'];
                    dig = k;
                    break;
                }
            }

            if(j!=-1){
                
                char prev = arr[i];
                arr[i] = dig;
                arr[j] = prev;
                List<Character> list = new ArrayList<>();

                for(int k=i+1;k<arr.length;k++){
                    list.add(arr[k]);
                }

                Collections.sort(list);
                int in = 0;
                for(int k=i+1;k<arr.length;k++){
                    arr[k] = list.get(in++); 
                }

                String s = new String(arr);
                long val = Long.parseLong(s);
                if(val > Integer.MAX_VALUE) return -1;

                return (int) val;
            }

            if(ind[arr[i]-'0']==-1){
                ind[arr[i]-'0'] = i;
            }
        }

        return -1;
    }
}