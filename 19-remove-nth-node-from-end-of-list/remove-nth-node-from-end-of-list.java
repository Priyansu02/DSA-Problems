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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz=0;
        ListNode temp=head;

        while(temp != null){
            temp=temp.next;
            sz++;
        }

        if(sz == n){
            head=head.next;
            return head;
        }

        int x=sz-n;
       ListNode temp2 = head;

        for(int i = 1; i < x; i++){
            temp2 = temp2.next;
        }

        temp2.next = temp2.next.next;

        return head;
    

    }
}