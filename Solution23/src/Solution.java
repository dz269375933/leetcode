import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] arg){
        Solution s=new Solution();
        ListNode first=new ListNode(-3);
        ListNode first1=new ListNode(2);
        ListNode first2=new ListNode(2);

        ListNode second=new ListNode(-9);

        ListNode third=new ListNode(-10);
        ListNode third1=new ListNode(-5);
        ListNode third2=new ListNode(-4);
        ListNode third3=new ListNode(-2);
        ListNode third4=new ListNode(-1);
        ListNode third5=new ListNode(1);
        ListNode third6=new ListNode(3);
        ListNode third7=new ListNode(4);
        third.next=third1;
        third1.next=third2;
        third2.next=third3;
        third3.next=third4;
        third4.next=third5;
        third5.next=third6;
        third6.next=third7;


        ListNode Fourth=new ListNode(-10);
        ListNode Fourth1=new ListNode(-9);
        ListNode Fourth2=new ListNode(-8);
        ListNode Fourth3=new ListNode(3);
        ListNode Fourth4=new ListNode(4);
        Fourth.next=Fourth1;
        Fourth1.next=Fourth2;
        Fourth2.next=Fourth3;
        Fourth3.next=Fourth4;

        ListNode Fifth=new ListNode(-5);
        ListNode Fifth1=new ListNode(-3);
        ListNode Fifth2=new ListNode(3);
        ListNode Fifth3=new ListNode(4);
        Fifth.next=Fifth1;
        Fifth1.next=Fifth2;
        Fifth2.next=Fifth3;

        ListNode Sixth=new ListNode(-9);
        ListNode Sixth1=new ListNode(-8);
        ListNode Sixth2=new ListNode(-5);
        ListNode Sixth3=new ListNode(-4);
        ListNode Sixth4=new ListNode(-2);
        ListNode Sixth5=new ListNode(-1);
        ListNode Sixth6=new ListNode(3);

        Sixth.next=Sixth1;
        Sixth1.next=Sixth2;
        Sixth2.next=Sixth3;
        Sixth3.next=Sixth4;
        Sixth4.next=Sixth5;
        Sixth5.next=Sixth6;

        first.next=first1;
        first1.next=first2;

        ListNode[] lists=new ListNode[6];
        lists[0]=first;
        lists[1]=second;
        lists[2]=third;
        lists[3]=Fourth;
        lists[4]=Fifth;
        lists[5]=Sixth;
        System.out.println(s.mergeKLists(lists).val);



    }
    public ListNode mergeKLists(ListNode[] lists) {
        int length=lists.length;

        ListNode head=new ListNode(0);
        ListNode current=head;
        int max=0x7fffffff;
        int[] first=new int[length];
        for(int i=0;i<length;i++){
            if(lists[i]==null){
                first[i]=max;
            }else{
                first[i]=lists[i].val;
            }
        }
        int count=0;
        while (true){
            count=0;
            int currentNum=max;
            int currentIndex=-1;
            for(int i=0;i<length;i++){
                if(first[i]==max){
                    count++;
                    continue;
                }
                if(first[i]<currentNum){
                    currentIndex=i;
                    currentNum=first[i];
                }
            }
            if (count==length)break;
            current.next=lists[currentIndex];
            current=current.next;
            if(lists[currentIndex].next==null){
                first[currentIndex]=max;
            }else{
                lists[currentIndex]=lists[currentIndex].next;
                first[currentIndex]=lists[currentIndex].val;
            }
        }
        return head.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
