import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)return null;
        PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val<o2.val){
                    return -1;
                }else if(o1.val==o2.val){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        for(ListNode node:lists){
            if(node!=null)queue.add(node);
        }
        ListNode head=new ListNode(0);
        ListNode current=head;
        while (!queue.isEmpty()){
            current.next=queue.poll();
            current=current.next;
            if(current.next!=null){
                queue.add(current.next);
            }
        }
        return head.next;

    }
}
