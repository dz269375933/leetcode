public class Solution148 {
    public ListNode sortList(ListNode head) {
        return head==null ? null:quickSort(head);
    }
    public ListNode quickSort(ListNode head){
        ListNode newHead=new ListNode(0);
        newHead.next=head;
        ListNode temp=head;
        ListNode currentNode=head;
        int current=head.val;
        while (temp!=null){
            if(head.val<current){
                newHead=merge(newHead,temp);
                temp=temp.next;
            }else if(head.val>current){

            }
        }
        return null;
    }
    public ListNode merge(ListNode head,ListNode middle){
        middle.next=head.next;
        head.next=middle;
        return head;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
