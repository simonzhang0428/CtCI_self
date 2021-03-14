package Linked_List;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

/*
20 You can do this in O(A+B) time and 0(1) additional space.
That is, you do not need a hash table (although you could do it with one).

45 Examples will help you. Draw a picture of intersecting linked lists and two equivalent
linked lists (by value) that do not intersect.

55 Focus first on just identifying if there's an intersection.

65 Observe that two intersecting linked lists will always have the same last node.
Once they intersect, all the nodes after that will be equal.

76 You can determine if two linked lists intersect by traversing to the end of each and comparing their tails.

93 Now, you need to find where the linked lists intersect.
Suppose the linked lists were the same length. How could you do this?

111 If the two linked lists were the same length, you could traverse forward in each until you found an element in common.
Now, how do you adjust this for lists of different lengths?

120 Try using the difference between the lengths of the two linked lists.

129 If you move a pointer in the longer linked list forward by the difference in lengths,
you can then apply a similar approach to the scenario when the linked lists are equal.

 */
public class Q2_07_Intersection {

    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);

        int[] vals2 = {12, 14, 15};
        LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);

        list2.next.next = list1.next.next.next.next;

        System.out.println(list1.printForward());
        System.out.println(list2.printForward());


        LinkedListNode intersection = findIntersection(list1, list2);

        System.out.println(intersection.printForward());
    }

    public static class Result {
        public LinkedListNode tail;
        public int size;
        public Result(LinkedListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    public static Result getTailAndSize(LinkedListNode list) {
        if (list == null) return null;

        int size = 1;
        LinkedListNode current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    public static LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    public static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null) return null;

        /* Get tail and sizes. */
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        /* If different tail nodes, then there's no intersection. */
        if (result1.tail != result2.tail) {
            return null;
        }

        /* Set pointers to the start of each linked list. */
        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size < result2.size ? list2 : list1;

        /* Advance the pointer for the longer linked list by the difference in lengths. */
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        /* Move both pointers until you have a collision. */
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        /* Return either one. */
        return longer;
    }

}
