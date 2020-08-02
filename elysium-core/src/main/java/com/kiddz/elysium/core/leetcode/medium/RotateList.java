package com.kiddz.elysium.core.leetcode.medium;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode tail = rotateRight(node1, 2);

        ListNode node6 = new ListNode(0);
        ListNode node7 = new ListNode(1);
        node6.next = node7;
        ListNode node8 = new ListNode(2);
        node7.next = node8;
        ListNode tail2 = rotateRight(node6, 4);
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        ListNode pivtol = head;
        int size = 1;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }
        k = size - (k % size);
        for (int i = 1; i < k; i++) {
            pivtol = pivtol.next;
        }
        tail.next = head;
        ListNode newHead = pivtol.next;
        pivtol.next = null;
        return newHead;
    }

}


