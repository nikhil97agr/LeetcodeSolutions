class Solution {
    public String largestTimeFromDigits(int[] arr) {
        String result = "";
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    for(int l=0;l<4;l++){
                        if(i!=j && i!=k && i!=l && j!=k && j!=l && k!=l){
                            String st = ""+arr[i]+arr[j]+":"+arr[k]+arr[l];
                            if(isValid(st)){
                                if(st.compareTo(result) > 0){
                                    result = st;
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String s){
        String st[] = s.split(":");
        int hr = Integer.parseInt(st[0]);
        int min = Integer.parseInt(st[1]);

        return hr >=0 && hr <= 23 && min >=0 && min <= 59;
    }
}