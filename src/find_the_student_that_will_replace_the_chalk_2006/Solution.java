package find_the_student_that_will_replace_the_chalk_2006;

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int x : chalk) sum+=x;
        long mod = (1L*k)%sum;
        int n = chalk.length;
        for(int i=0;i<n;i++){
            if(mod < chalk[i]) return i;
            mod -= chalk[i];
        }
        return -1;
    }
}