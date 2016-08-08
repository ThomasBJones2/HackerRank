/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Done in one pass...
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pass = head;
        ListNode removeNode = null;
        
        int count = 0;
        while(pass != null){
            if(count == n){
                removeNode = head;
            }
            if(count > n){
                removeNode = removeNode.next;
            }
            pass = pass.next;
            count ++;
        }
        if(removeNode == null){
            head = head.next;
        }
        else {
            removeNode.next = removeNode.next.next;
        }
        return head;
    }
}
