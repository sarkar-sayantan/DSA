/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode newHead = null;
        while(curr != null) {
            ListNode temp = curr;
            if(curr.next == null) 
                newHead = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }
        return newHead;
    }
}