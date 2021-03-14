package Linked_List;

import CtCILibrary.LinkedListNode;

/*
There are many solutions to this problem, most of which are equally optimal in runtime.
Some have shorter, cleaner code than others. Can you brainstorm different solutions?

Consider that the elements don't have to stay in the same relative order.
We only need to ensure that elements less than the pivot must be before elements greater than the pivot.
Does that help you come up with more solutions?

 */
public class Q2_04_Partition {
    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        /* Partition list */
        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                /* Insert node at head. */
                node.next = head;
                head = node;
            } else {
                /* Insert node at tail. */
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }

    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {33,9,2,3,10,10389,838,874578,5};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        System.out.println(head.printForward());

        /* Partition */
        LinkedListNode h = partition(head, 3);

        /* Print Result */
        System.out.println(h.printForward());
    }
}
