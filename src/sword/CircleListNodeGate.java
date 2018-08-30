package sword;

/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
*/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class CircleListNodeGate{
	public ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast.next!=null&&fast.next.next!=null){
        	fast = fast.next.next;
        	slow = slow.next;
        	if(fast == slow){
        		fast = pHead;
        		while(fast!=slow){
        			fast = fast.next;
        			slow = slow.next;
        		}
        		return fast;
        	}
        }
        return null;
    }
}