class Solution {
    boolean found = false;

    public String[] createGrid(int m, int n, int k) {
        char result[][] = new char[m][n];
        for (char ch[] : result) {
            Arrays.fill(ch, '#');
        }
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                result[0][i] = '.';
            }
            for (int i = 0; i < m; i++) {
                result[i][n - 1] = '.';
            }

            return transform(result);
        }

        if (m == 1 || n == 1) {
            return new String[0];
        }

        if (k == 2) {

            for (int i = 0; i < n; i++) {
                result[0][i] = '.';
            }
            for (int i = 0; i < m; i++) {
                result[i][n - 1] = '.';
            }

            result[1][n - 2] = '.';

            return transform(result);

        }

        if (k == 3) {
            if (m <= 2 && n <= 2) {
                return new String[0];
            }
            for (int i = 0; i < n; i++) {
                result[0][i] = '.';
            }
            for (int i = 0; i < m; i++) {
                result[i][n - 1] = '.';
            }
            if (n >= 3) {
                result[1][n-2] = result[1][n-3] = '.';
            }else{
                result[1][n-2] = result[2][n-2] = '.';
            }

            return transform(result);

            
        }

        if( m<= 2 && n <= 2){
            return new String[0];
        }

        if((m <=3 && n <= 2) || (m <= 2 && n <=3)){
            return new String[0];
        }

                    for (int i = 0; i < n; i++) {
                result[0][i] = '.';
            }
            for (int i = 0; i < m; i++) {
                result[i][n - 1] = '.';
            }

        if(m == 3 && n == 3){
            result[0][n-1] = '#';
            result[1][n-2] = result[1][n-3] = result[2][n-2] = '.';

            return transform(result);
        }

        if( n >= 4){
            result[1][n-2] = result[1][n-3] = result[1][n-4] = '.';
        }else{
            result[1][n-2] = result[2][n-2] = result[3][n-2] = '.';
        }

        return transform(result);

    }

    private String[] transform(char ch[][]) {
        int m = ch.length;
        String result[] = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(ch[i]);
        }

        return result;
    }
}