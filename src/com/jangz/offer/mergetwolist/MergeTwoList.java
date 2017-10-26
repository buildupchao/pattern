package com.jangz.offer.mergetwolist;

public class MergeTwoList {

	public ListNode mergeTwoList(ListNode p, ListNode q) {

		if (p == null)
			return q;
		if (q == null)
			return p;
		ListNode head = new ListNode(-1);
		ListNode node = head;
		
		while (p != null && q != null) {
			if (p.val > q.val) {
				node.next = new ListNode(q.val);
				node = node.next;
				q = q.next;
			} else {
				node.next = new ListNode(p.val);
				node = node.next;
				p = p.next;
			}
		}
		if (p == null)
			node.next = q;
		if (q == null)
			node.next = p;
		return head.next;
	}
}