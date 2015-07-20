/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        
        int count = 0;
        ListNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        
        int mid = count / 2;
        current = head;
        for (int i = 0; i < mid; i++) {
            current = current.next;
        }
        
        ListNode head2 = reverse(head, mid);
        if (count%2 == 1) {
            current = current.next;
        }
        return compare(current, head2);
    }
    
    private ListNode reverse(ListNode head, int count ){
        if (count == 0) {
            return null;
        }
        
        if (count == 1) {
            head.next = null;
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        
        for (int i = 0; i < count-1; i++) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = null;
        return pre;
    }
    
    private boolean compare(ListNode node1, ListNode node2) {
        while (node1!= null && node2 != null) {
            if (node1.val != node2.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        
        if (node1 == null && node2 == null) {
            return true;
        }
        
        return false;
    }
    
    
}