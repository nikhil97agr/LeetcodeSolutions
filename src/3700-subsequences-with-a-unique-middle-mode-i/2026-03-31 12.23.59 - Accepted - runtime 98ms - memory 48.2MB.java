import java.util.HashMap;
import java.util.Map;

//Problem Link: https://leetcode.com/problems/subsequences-with-a-unique-middle-mode-i/

/**
 * Solution for counting subsequences with a unique middle mode.
 *
 * A subsequence of length 5 has a "unique middle mode" if the element at the middle position (index 2)
 * appears more frequently in the subsequence than any other element.
 *
 * For a subsequence [a, b, c, d, e], element c is the middle mode if:
 * - freq(c) > freq(x) for all x != c in the subsequence
 *
 * Algorithm approach:
 * 1. Fix each element as the middle element (index i in original array)
 * 2. Count ways to form valid 5-element subsequences with nums[i] as the mode
 * 3. Use combinatorics and inclusion-exclusion principle
 * 4. Track frequencies in prefix and suffix using sliding window
 * 5. Maintain cumulative statistics for efficient counting
 *
 * Key insight: For nums[i] to be the unique mode in a 5-element subsequence:
 * - Select 2 elements before i and 2 elements after i
 * - nums[i] must appear more than any other element in those 4 selected elements
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for factorials and frequency maps
 */
class Solution{

    int mod = 1_000_000_007;  // Modulo for all operations
    int fact[];               // Factorials for combinatorics: fact[i] = i!
    int inv[];                // Modular inverses of factorials

    /**
     * Counts subsequences where the middle element is the unique mode.
     *
     * @param nums Input array
     * @return Count of valid 5-element subsequences modulo 10^9 + 7
     */
    public int subsequencesWithMiddleMode(int[] nums) {

        int n = nums.length;

        // Precompute factorials and their modular inverses for combinations
        fact = new int[n + 1];
        inv = new int[n + 1];
        fact[0] = fact[1] = 1;
        inv[0] = inv[1] = 1;
        for (int i = 2; i <= n; i++) {
            fact[i] = prod(i, fact[i - 1]);           // fact[i] = i!
            inv[i] = pow(fact[i], mod - 2);            // inv[i] = (i!)^(-1) using Fermat's Little Theorem
        }

        int ans = 0;

        // Frequency maps for elements before and after current position
        var preCnt = new HashMap<Integer, Integer>();  // Count of each value in prefix
        var sufCnt = new HashMap<Integer, Integer>();  // Count of each value in suffix

        // Initialize suffix with all elements
        for (int i = 0; i < n; i++) {
            add(nums[i], sufCnt);
        }

        // Cumulative statistics for combinatorial calculations
        // These track various sum-of-products needed for inclusion-exclusion
        int suffSqSum = 0;      // Sum of cnt[x]^2 for all x in suffix
        int preSqSum = 0;       // Sum of cnt[x]^2 for all x in prefix
        int preSufSum = 0;      // Sum of preCnt[x] * sufCnt[x] for all x
        int preSqSuffSum = 0;   // Sum of preCnt[x]^2 * sufCnt[x] for all x
        int preSuffSqSum = 0;   // Sum of preCnt[x] * sufCnt[x]^2 for all x

        // Initialize suffix square sum
        for (var val : sufCnt.values()) {
            suffSqSum = add(suffSqSum, prod(val, val));
        }

        int right = n;  // Number of elements in suffix
        int left = 0;   // Number of elements in prefix

        // Fix each position as the middle element
        for (int i = 0; i < n; i++) {
            right--;
            remove(nums[i], sufCnt);  // Remove current element from suffix

            // Get counts of nums[i] in prefix and suffix
            var cPre = preCnt.getOrDefault(nums[i], 0);
            var cSuf = sufCnt.getOrDefault(nums[i], 0);

            // Update cumulative statistics (subtract old values before nums[i] is added to prefix)
            suffSqSum = add(suffSqSum, -prod(cSuf + 1, cSuf + 1));
            preSqSum = add(preSqSum, -prod(cPre, cPre));
            preSufSum = add(preSufSum, -prod(cPre, cSuf + 1));
            preSqSuffSum = add(preSqSuffSum, -prod(cPre, prod(cPre, cSuf + 1)));
            preSuffSqSum = add(preSuffSqSum, -prod(cPre, prod(cSuf + 1, cSuf + 1)));

            // Count 1: Total ways to choose 2 from left and 2 from right
            // C(left, 2) * C(right, 2)
            ans = add(ans, prod(comb(left, 2), comb(right, 2)));

            // Count 2: Subtract cases where nums[i] doesn't appear in the chosen 4 elements
            // (nums[i] must appear at least once in the 4 selected elements for it to be mode)
            ans = add(ans, -prod(comb(left - cPre, 2), comb(right - cSuf, 2)));

            // Remaining counts excluding nums[i]
            int preRemain = left - cPre;   // Elements in prefix different from nums[i]
            int sufRemain = right - cSuf;  // Elements in suffix different from nums[i]

            // Count 3: Subtract cases where some element in suffix appears twice
            // and nums[i] appears only once (so the other element has higher frequency)
            int a = add(preSqSum, -preRemain);  // Sum of squares minus single counts
            a = prod(a, cSuf);       // Ways to select that element from suffix
            a = prod(a, sufRemain);  // Ways to select the other suffix element
            a = prod(a, pow(2, mod - 2));  // Divide by 2 (modular inverse)
            ans = add(ans, -a);

            // Count 4: Subtract cases where some element in prefix appears twice
            // Similar reasoning to Count 3
            int b = add(suffSqSum, -sufRemain);
            b = prod(b, cPre);
            b = prod(b, preRemain);
            b = prod(b, pow(2, mod - 2));
            ans = add(ans, -b);

            // Count 5: Subtract cases where some element appears once in prefix and once in suffix
            // forming a pair that matches nums[i]'s frequency
            int c = prod(cPre, right);
            c = add(c, prod(cSuf, left));
            int d = prod(2, prod(cPre, cSuf));
            c = add(c, -d);
            int e = prod(preSufSum, c);
            ans = add(ans, -e);

            // Count 6 & 7: Add back overcounted cases (inclusion-exclusion principle)
            // Cases where an element appears in both prefix and suffix with specific patterns
            ans = add(ans, prod(preSqSuffSum, cSuf));
            ans = add(ans, prod(preSuffSqSum, cPre));

            // Move current element from middle to prefix
            left++;
            add(nums[i], preCnt);

            // Update cumulative statistics (add new values after nums[i] is added to prefix)
            suffSqSum = add(suffSqSum, prod(cSuf, cSuf));
            preSqSum = add(preSqSum, prod(cPre + 1, cPre + 1));
            preSufSum = add(preSufSum, prod(cPre + 1, cSuf));
            preSqSuffSum = add(preSqSuffSum, prod(cPre + 1, prod(cPre + 1, cSuf)));
            preSuffSqSum = add(preSuffSqSum, prod(cPre + 1, prod(cSuf, cSuf)));

        }

        return ans;
    }
    /**
     * Removes an element from the frequency map.
     *
     * @param val Element value to remove
     * @param map Frequency map
     */
    private void remove(int val, Map<Integer, Integer> map) {

        map.merge(val, -1, Integer::sum);  // Decrement count
        if (map.get(val) == 0) {
            map.remove(val);  // Remove key if count becomes 0
        }
    }

    /**
     * Adds an element to the frequency map.
     *
     * @param val Element value to add
     * @param map Frequency map
     */
    private void add(int val, Map<Integer, Integer> map) {

        map.merge(val, 1, Integer::sum);  // Increment count
    }

    /**
     * Computes binomial coefficient C(n, r) = n! / (r! * (n-r)!)
     * Uses precomputed factorials and their modular inverses.
     *
     * @param n Total number of items
     * @param r Number of items to choose
     * @return C(n, r) mod (10^9 + 7)
     */
    private int comb(int n, int r) {

        if (r > n) {
            return 0;  // Can't choose more than available
        }
        if (r == n) {
            return 1;  // Only one way to choose all
        }
        // C(n, r) = n! / (r! * (n-r)!)
        return prod(fact[n], prod(inv[r], inv[n - r]));
    }

    /**
     * Adds two numbers with modulo arithmetic, handling negative values.
     *
     * @param a First number
     * @param b Second number (can be negative)
     * @return (a + b) mod (10^9 + 7), guaranteed non-negative
     */
    private int add(int a, int b) {

        // Add mod to handle negative intermediate results
        long sum = 1l * a + b + mod;

        return (int) (sum % mod);
    }

    /**
     * Multiplies two numbers with modulo arithmetic.
     *
     * @param a First number
     * @param b Second number
     * @return (a * b) mod (10^9 + 7)
     */
    private int prod(int a, int b) {

        long p = 1l * a * b;
        return (int) (p % mod);
    }

    /**
     * Computes modular exponentiation: a^b mod (10^9 + 7).
     * Uses iterative exponentiation by squaring.
     *
     * Commonly used to compute modular multiplicative inverse:
     * - a^(p-2) ≡ a^(-1) (mod p) by Fermat's Little Theorem
     *
     * @param a Base
     * @param b Exponent
     * @return a^b mod (10^9 + 7)
     */
    private int pow(int a, int b) {

        int p = 1;  // Result
        while (b > 0) {
            if ((b & 1) == 1) {
                p = prod(p, a);  // If current bit is 1, multiply result by current a
            }

            a = prod(a, a);  // Square a for next bit
            b >>= 1;         // Shift to next bit
        }

        return p;
    }
}