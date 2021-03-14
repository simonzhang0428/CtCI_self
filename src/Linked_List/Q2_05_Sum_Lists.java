package Linked_List;

import CtCILibrary.LinkedListNode;

/*
Of course, you could convert the linked lists to integers, compute the sum, and then convert it back to a new linked list.
If you did this in an interview, your interviewer would likely accept the answer, and then see if you could do this without converting it to a number and back.

Try recursion. Suppose you have two lists, A = 1->5->9 (representing 951) and B 2-> 3->6->7 (representing 7632),
and a function that operates on the remainder of the lists (5->9 and 3->6->7).
Could you use this to create the sum method? What is the relationship between sum(1->5->9, 2->3->6->7) and sum(5->9, 3->6->7)?

Make sure you have considered linked lists that are not the same length.

Does your algorithm work on linked lists like 9->7->8 and 6->8->5? Double check that.

For the follow-up question: The issue is that when the linked lists aren't the same length,
the head of one linked list might represent the 1OOO's place while the other represents the 1O's place.
What if you made them the same length? Is there a way to modify the linked list to do that, without changing the value it represents?
 */
public class Q2_05_Sum_Lists {
    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        return addLists(l1, l2, 0);
    }

    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        LinkedListNode result = new LinkedListNode();
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        result.data = value % 10;
        if (l1 != null || l2 != null) {
            LinkedListNode more = addLists(
                    l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }

    public static int linkedListToInt(LinkedListNode node) {
        int value = 0;
        if (node.next != null) {
            value = 10 * linkedListToInt(node.next);
        }
        return value + node.data;
    }

    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(9, null, null);
        LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(9, null, lA2);

        LinkedListNode lB1 = new LinkedListNode(1, null, null);
        LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(0, null, lB2);

        LinkedListNode list3 = addLists(lA1, lB1);

        System.out.println("  " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        System.out.println("= " + list3.printForward());

        int l1 = linkedListToInt(lA1);
        int l2 = linkedListToInt(lB1);
        int l3 = linkedListToInt(list3);

        System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
        System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
    }
}
