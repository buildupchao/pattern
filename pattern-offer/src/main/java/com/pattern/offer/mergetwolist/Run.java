package com.pattern.offer.mergetwolist;

public class Run {
	public static void main(String[] args) {
		ListNode p = new ListNode(1);
		p.next = new ListNode(3);
		p.next.next = new ListNode(8);
		p.next.next.next = new ListNode(11);
		p.next.next.next.next = new ListNode(15);

		ListNode q = new ListNode(2);

		ListNode head = new MergeTwoList().mergeTwoList(p, q);

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
