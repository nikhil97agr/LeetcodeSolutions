package maximize_grid_happiness_1778;

import java.util.*;
import java.util.Arrays;

class Solution {
    int m;
    int n;
    int dp[][][][][];
    int maxMask;
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        this.m = m;
        this.n = n;
        maxMask = 1 << n;
        dp = new int[m][1<<n][1<<n][introvertsCount+1][extrovertsCount+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<1<<n;j++){
                for(int k=0;k<1<<n;k++){
                    for(int l=0;l<introvertsCount+1;l++){
                        Arrays.fill(dp[i][j][k][l], -1);
                    }
                }
            }
        }
        return solve(0, 0, 0, introvertsCount, extrovertsCount);
    }

    private int solve(int i, int preIntro, int preExtro, int iCount, int eCount){
        if(i==m){

            return 0;
        }
        if(dp[i][preIntro][preExtro][iCount][eCount]!=-1) return dp[i][preIntro][preExtro][iCount][eCount];
        int ans = 0;
        //combination of both
        for(int comb = 0;comb <maxMask;comb++){
            for(int intro = comb;; intro = ((intro- 1)& comb)){
                int extro = comb ^ intro;
                int c1 = Integer.bitCount(intro);
                int c2 = Integer.bitCount(extro);
                /**
                 * 1. intro and extro should not overlap
                 * 2. atleast iCount introverts and eCount extroverts should be there
                 * 3. intro and extro creating the comb
                 */
                if( c1 > iCount || c2 > eCount ){
                    if(intro == 0) break;
                    continue;
                }

                int score = 120 * c1 + 40 * c2;
                // vertical interactions with previous row

                int introIntroV = intro & preIntro;
                int extroExtroV = extro & preExtro;
                int introExtroV = intro & preExtro;
                int extroIntroV = extro & preIntro;

// intro-intro: -60
                score += Integer.bitCount(introIntroV) * -60;

// extro-extro: +40
                score += Integer.bitCount(extroExtroV) * 40;

// intro-extro OR extro-intro: -10
                score += Integer.bitCount(introExtroV) * -10;
                score += Integer.bitCount(extroIntroV) * -10;

                // horizontal interactions inside current row
                int introIntro = intro & (intro >> 1);
                int extroExtro = extro & (extro >> 1);
                int introExtro = intro & (extro >> 1);
                int extroIntro = extro & (intro >> 1);

// intro-intro: -60 (-30 each)
                score += Integer.bitCount(introIntro) * -60;

// extro-extro: +40 (+20 each)
                score += Integer.bitCount(extroExtro) * 40;

// intro-extro OR extro-intro: (-30 + 20) = -10
                score += Integer.bitCount(introExtro) * -10;
                score += Integer.bitCount(extroIntro) * -10;


                int temp =solve(i+1, intro, extro, iCount - c1, eCount - c2);
                if(temp != Integer.MAX_VALUE){
                    ans = Math.max(ans, score + temp);
                }
                if(intro ==0 ) break;
            }
        }

        return dp[i][preIntro][preExtro][iCount][eCount] = ans;
    }

}