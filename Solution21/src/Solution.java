public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1000000);
        ListNode current=head;
        while (l1 !=null && l2 !=null){
            if(l1.val<=l2.val){
                current.next=l1;
                current=current.next;
                l1=l1.next;
            }else{
                current.next=l2;
                current=current.next;
                l2=l2.next;
            }
        }
        if(l1==null){
            current.next=l2;
            return head.next;
        }else{
            current.next=l1;
            return head.next;
        }
    }
}
class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
}
