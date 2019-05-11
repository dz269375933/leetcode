public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] listNodes=new ListNode[100000];
        int length=0;
        while (head!=null){
            listNodes[length++]=head;
            head=head.next;
        }
        int aim=length-n;
        if(aim==0){
            return listNodes[1];
        }else{
            listNodes[aim-1].next=listNodes[aim+1];
        }

        return listNodes[0];
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
