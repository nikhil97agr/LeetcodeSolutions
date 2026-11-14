package maximum_product_of_the_length_of_two_palindromic_substrings_1336;

import java.util.*;

/**
 * Maximum Product of the Length of Two Palindromic Substrings
 *
 * Pick two non-overlapping, odd-length palindromic substrings of s (the first
 * ending strictly before the second begins) so that the product of their
 * lengths is maximised.
 *
 * Approach (Manacher + prefix/suffix best-palindrome arrays):
 * 1. Run Manacher's algorithm to get, for every index i, the length of the
 *    longest odd palindrome centred at i. This is the only O(n) way to get all
 *    centres; anything slower is too slow for n up to 1e5.
 * 2. Build two helper arrays:
 *      left[i]  = length of the longest odd palindrome lying entirely in s[0..i]
 *      right[i] = length of the longest odd palindrome lying entirely in s[i..n-1]
 * 3. Every valid pair is separated by some split point, so the answer is
 *    max(left[i] * right[i + 1]) over all i.
 *
 * The key trick in step 2 is that a palindrome can be *shrunk*: if a palindrome
 * of length L ends at index i + 1, dropping one character from each end leaves a
 * palindrome of length L - 2 ending at index i. That lets a long palindrome
 * found further right still contribute to earlier positions.
 *
 * Time Complexity: O(n)  - Manacher plus a constant number of linear scans
 * Space Complexity: O(n) - the radius / left / right arrays
 */
class Solution {
    public long maxProduct(String s) {
        ManacherAlgorithm algo = new ManacherAlgorithm(s);
        int p[] = algo.p;
        int n = s.length();
        int left[] = new int[n];
        int right[] = new int[n];
        int radius[] = new int[n];

        // Manacher works on the padded string "#a#b#c#", where original index j
        // sits at padded index 2j+1. Those odd positions are the character
        // centres, i.e. exactly the odd-length palindromes we care about.
        for(int i=1,j=0;j < n;i+=2,j++){
            radius[j] = p[i];
        }

        // Pass 1: for each centre, record the palindrome at the index where it ENDS,
        // then sweep left-to-right so left[i] = best palindrome finishing at or before i.
        for(int i=0;i<n;i++){
            int len = radius[i] - 1;   // p[] is a padded radius; -1 converts it to a real length
            int half = len / 2;        // distance from the centre to either end
            left[i + half] = Math.max(left[i + half],len);
            if(i > 0){
                left[i] = Math.max(left[i], left[i-1]);
            }
        }

        // Pass 2: mirror of the above. Record each palindrome at the index where it
        // STARTS, then sweep right-to-left so right[i] = best palindrome beginning at or after i.
        for(int i=n-1;i>=0;i--){
            int len = radius[i] - 1;
            int half = len / 2;
            right[i - half] = Math.max(right[i-half], len);
            if(i + 1 < n){
                right[i] = Math.max(right[i], right[i + 1]);
            }
        }

        // Shrink pass for left[]: a palindrome of length L ending at i+1 contains a
        // palindrome of length L-2 ending at i. Walking backwards propagates every
        // long palindrome down to the earlier split points it can still serve.
        for(int i=n-2;i>=0;i--){
            left[i] = Math.max(left[i], left[i + 1] -2);
        }

        // Same shrink pass for right[], walking forwards.
        for(int i=1;i<n;i++){
            right[i]= Math.max(right[i-1] -2, right[i]);
        }


        // Try every split: first palindrome ends at or before i, second starts at or after i+1.
        long ans = 0;
        for(int i=0;i<n-1;i++){
            ans = Math.max(ans, 1l * left[i] * right[i+1]);  // 1l * ... to avoid int overflow
        }
        return ans;
    }
}


/**
 * Manacher's algorithm: computes the longest palindromic radius around every
 * centre of a string in O(n).
 *
 * The input is padded with '#' separators ("abc" -> "#a#b#c#") so that even- and
 * odd-length palindromes are handled uniformly: odd padded indices are character
 * centres, even ones are gap centres.
 */
class ManacherAlgorithm {

    String t;    // the padded string
    int p[];     // p[i] = palindromic radius around padded index i

    public ManacherAlgorithm(String s) {

        // Interleave '#' so every palindrome in t has odd length.
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append("#");
        }

        t = sb.toString();
        p = new int[t.length()];
        Arrays.fill(p, 1);   // every position is trivially a palindrome of radius 1

        build();
    }

    public void build() {

        int n = t.length();
        // [l, r] tracks the palindrome that currently reaches furthest right.
        int l = 1;
        int r = 1;
        for (int i = 1; i < n; i++) {
            // Seed p[i] from the mirror of i inside [l, r] instead of starting at 0.
            // This reuse is what keeps the whole algorithm linear.
            if (r - i + l< 0){
                // Mirror index would fall outside the array, so only the part of
                // the current palindrome still ahead of i is guaranteed.
                p[i] = Math.max(0, r - i);
            }else{

            // Either the mirror's radius, or the distance to r, whichever is smaller;
            // beyond r nothing has been verified yet.
            p[i] = Math.max(0, Math.min(r - i, p[r - i + l]));
            }
            // Expand past the guaranteed part by comparing characters directly.
            while (i + p[i] < n && i - p[i] >= 0 && t.charAt(i + p[i]) == t.charAt(i - p[i])) {
                p[i]++;
            }
            // If this palindrome reaches further right than any before, it becomes
            // the new reference window.
            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }
    }


}
