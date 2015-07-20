/**

 * Definition for singly-linked list.

 * public class ListNode {

 *     int val;

 *     ListNode next;

 *     ListNode(int x) { val = x; }

 * }

 */

public class Solution {

    public void deleteNode(ListNode node) {

        if (node == null)

            return;

        ListNode next = null;

        if ((next = node.next) != null) {

            node.val = next.val;

            node.next = next.next;

        } else {

            node = null;

        }

        return;

    }

}
 