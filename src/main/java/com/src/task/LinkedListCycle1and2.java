package com.src;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class LinkedListCycle1and2 {

    public static void main(String[] args) {
        LinkedListCycle1and2 linkedListCycle = new LinkedListCycle1and2();
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // cycle

        System.out.println("Has cycle: " + linkedListCycle.hasCycle(head));
        System.out.println("Tail connects to node index: " + linkedListCycle.detectCycle(head).val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode intersection = intersection(head);
        if (intersection == null) {
            return null;
        }

        while (head != intersection) {
            head = head.next;
            intersection = intersection.next;
        }

        return head;
    }

    public ListNode intersection(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
