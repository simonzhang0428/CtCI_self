package Linked_List;

import CtCILibrary.LinkedListNode;

/*
50 There are really two parts to this problem.
First, detect if the linked list has a loop.
Second, figure out where the loop starts.

69 To identify if there's a cycle, try the "runner" approach described on page 93.
Have one pointer move faster than the other.

83 You can use two pointers, one moving twice as fast as the other.
If there is a cycle, the two pointers will collide.
They will land at the same location at the same time.
Where do they land? Why there?

90 If you haven't identified the pattern of where the two pointers start, try this:
Use the linked list 1->2->3->4->5->6->7->8->9->?, where the ? links to another node.
Try making the ? the first node (that is, the 9 points to the 1 such that the entire linked list is a loop).
Then make the ? the node 2. Then the node 3. Then the node 4.
What is the pattern? Can you explain why this happens?
 */
public class Q2_08_Loop_Detection {

    public static void main(String[] args) {
        int list_length = 6;
        int k = 4;

        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }

        // Create loop;
        nodes[list_length - 1].next = nodes[list_length - k];

        LinkedListNode loop = FindBeginning(nodes[0]);
        if (loop == null) {
            System.out.println("No Cycle.");
        } else {
            System.out.println(loop.data);
        }
    }

    private static LinkedListNode FindBeginning(LinkedListNode node) {
        if (node == null) return null;

        // fast twice than slow
        LinkedListNode fast = node;
        LinkedListNode slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        // if it has no loop
        if (fast == null || fast.next == null) {
            return null;
        }

        /* Move slow to Head. Keep fast at Meeting Point. Each are k steps
		/* from the Loop Start. If they move at the same pace, they must
		 * meet at Loop Start. */
        slow = node;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both now point to the start of the loop.
        return fast;

//        return fast.next;
    }
}
