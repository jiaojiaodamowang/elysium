package com.kiddz.elysium.core.leetcode.easy;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        // initialize the first list
        ListNode a4 = new ListNode(4);
        ListNode a2 = new ListNode(2);
        a2.next = a4;
        ListNode a1 = new ListNode(1);
        a1.next = a2;
        // initialize the second list
        ListNode b4 = new ListNode(4);
        ListNode b3 = new ListNode(3);
        b3.next = b4;
        ListNode b1 = new ListNode(1);
        b1.next = b3;
        ListNode head = mergeTwoLists(a1, b1);
        while(head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode index1 = l1;
        ListNode index2 = l2;
        while(index1 != null && index2 != null) {
            if (index1.val <= index2.val) {
                tail.next = index1;
                tail = index1;
                index1 = index1.next;
            } else {
                tail.next = index2;
                tail = index2;
                index2 = index2.next;
            }
        }
        if (index1 == null) {
            tail.next = index2;
        } else {
            tail.next = index1;
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


