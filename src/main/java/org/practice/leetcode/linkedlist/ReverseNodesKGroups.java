package org.practice.leetcode.linkedlist;

public class ReverseNodesKGroups {
    public ListNode reverseKLengthLinkedList(ListNode head, int k) {
        ListNode ptr = head, prev = null, next = null;
        while (k > 0) {
            next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
            k--;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null, kTail = null, ptr = head;
        while (ptr != null) {
            int counter = 0;
            while (counter < k && ptr != null) {
                ptr = ptr.next;
                counter++;
            }
            if (counter == k) {
                ListNode kReversedHead = reverseKLengthLinkedList(head, k);
                if (newHead == null) newHead = kReversedHead;
                if (kTail != null) kTail.next = kReversedHead;
                kTail = head;
                head = ptr;
            }
        }
        if (kTail != null) kTail.next = head;
        return newHead != null ? newHead : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode kReversed = new ReverseNodesKGroups().reverseKGroup(head, 2);
        ListNode ptr = kReversed;
        while (ptr != null) {
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }
}
