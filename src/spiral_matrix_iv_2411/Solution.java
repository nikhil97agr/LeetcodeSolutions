package spiral_matrix_iv_2411;

import java.util.*;
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int result[][] = new int[m][n];
        for(int x[] : result){
            Arrays.fill(x, -1);
        }

        int sr = 0;
        int er = m-1;
        int sc = 0;
        int ec = n-1;
        int i,j;
        while(sr<=er && sc<=ec && head!=null){
            i = sr;
            j = sc;
            while(j<=ec && head!=null){
                result[i][j] = head.val;
                head = head.next;
                j++;
            }
            sr++;
            i = sr;
            j = ec;
            while(i<=er && head!=null){
                result[i][j] = head.val;
                head = head.next;
                i++;
            }
            ec--;
            i=er;
            j=ec;
            while(j>=sc && head!=null){
                result[i][j] = head.val;
                head = head.next;
                j--;
            }

            er--;
            i = er;
            j = sc;
            while(i>=sr && head!=null){
                result[i][j] = head.val;
                head = head.next;
                i--;
            }
            sc++;
        }
        return result;
    }
}