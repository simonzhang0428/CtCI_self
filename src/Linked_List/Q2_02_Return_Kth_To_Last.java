package Linked_List;

import CtCILibrary.*;

/*
What if you knew the linked list size? What is the difference between finding the Kth-to-last element and finding the Xth element?

If you don't know the linked list size, can you compute it? How does this impact the runtime?

Try implementing it recursively. If you could find the (K-l)th to last element, can you find the Kth element?

You might find it useful to return multiple values. Some languages don't directly support this,
but there are workarounds in essentially any language. What are some of those workarounds?

Can you do it iteratively? Imagine if you had two pointers pointing to adjacent nodes and they were moving at the same speed through the linked list.
When one hits the end of the linked list, where will the other be?
 */
public class Q2_02_Return_Kth_To_Last {

    public static int printKthToLast(LinkedListNode head, int k) {

        // compute count, then find the kth to last
        if (head == null) {
            return -1;
        }
        LinkedListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        if (k > count) {
            return -1;
        }
        temp = head;
        if (k == 0) {
            k++;
        }
        int times = count - k;
        for (int i = 0; i < times; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // Recursion
    public static int printKthToLast2(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }

        int index = printKthToLast2(head.next, k) + 1;
        if (index == k) {
            return head.data;
        }
        return index;
    }



    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        for (int i = 0; i <= array.length + 1; i++) {
            System.out.println(printKthToLast2(head, i));
        }
    }
}
