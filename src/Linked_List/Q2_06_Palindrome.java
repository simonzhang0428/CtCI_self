package Linked_List;

import CtCILibrary.LinkedListNode;

import java.util.Stack;

/*
A palindrome is something which is the same when written forwards and backwards.
What if you reversed the linked list?

Try using a stack.

Assume you have the length of the linked list. Can you implement this recursively?

Remember: There are ways to return multiple values. You can do this with a new class.
 */
public class Q2_06_Palindrome {
    /*
    Our first solution is to reverse the linked list and compare the reversed list to the original list.
    If they're the same, the lists are identical.
     */
    public static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    public static LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data, null, null); // Clone
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    public static boolean isEqual(LinkedListNode one, LinkedListNode two) {
        while (one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }
    public static void main(String[] args) {
        int length = 9;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }
        //nodes[length - 2].data = 9; // Uncomment to ruin palindrome

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());
        System.out.println(isPalindrome(head));
    }


    public static class QuestionB {
        public static boolean isPalindrome(LinkedListNode head) {
            LinkedListNode fast = head;
            LinkedListNode slow = head;

            Stack<Integer> stack = new Stack<>();

            while (fast != null && fast.next != null) {
                stack.push(slow.data);
                slow = slow.next;
                fast = fast.next.next;
            }

            /* Has odd number of elements, so skip the middle */
            if (fast != null) {
                slow = slow.next;
            }

            while (slow != null) {
                int top = stack.pop();
                if (top != slow.data) {
                    return false;
                }
                slow = slow.next;
            }
            return true;
        }

        public static void main(String[] args) {
            int length = 9;
            LinkedListNode[] nodes = new LinkedListNode[length];
            for (int i = 0; i < length; i++) {
                nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
            }

            for (int i = 0; i < length; i++) {
                if (i < length - 1) {
                    nodes[i].setNext(nodes[i + 1]);
                }
                if (i > 0) {
                    nodes[i].setPrevious(nodes[i - 1]);
                }
            }
            //nodes[length - 2].data = 9; // Uncomment to ruin palindrome

            LinkedListNode head = nodes[0];
            System.out.println(head.printForward());
            System.out.println(isPalindrome(head));
        }

    }

    public static class QuestionC {
        public static class Result {
            public LinkedListNode node;
            public boolean result;
            public Result(LinkedListNode n, boolean res) {
                node = n;
                result = res;
            }
        }

        public static Result isPalindromeRecurse(LinkedListNode head, int length) {
            if (head == null || length <= 0) { // Even number of nodes
                return new Result(head, true);
            } else if (length == 1) { // Odd number of nodes
                return new Result(head.next, true);
            }

            /* Recurse on sublist. */
            Result res = isPalindromeRecurse(head.next, length - 2);

            /* If child calls are not a palindrome, pass back up
             * a failure. */
            if (!res.result || res.node == null) {
                return res;
            }

            /* Check if matches corresponding node on other side. */
            res.result = (head.data == res.node.data);

            /* Return corresponding node. */
            res.node = res.node.next;

            return res;
        }

        public static int lengthOfList(LinkedListNode n) {
            int size = 0;
            while (n != null) {
                size++;
                n = n.next;
            }
            return size;
        }

        public static boolean isPalindrome(LinkedListNode head) {
            int length = lengthOfList(head);
            Result p = isPalindromeRecurse(head, length);
            return p.result;
        }

        public static void main(String[] args) {
            int length = 9;
            LinkedListNode[] nodes = new LinkedListNode[length];
            for (int i = 0; i < length; i++) {
                nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
            }

            for (int i = 0; i < length; i++) {
                if (i < length - 1) {
                    nodes[i].setNext(nodes[i + 1]);
                }
                if (i > 0) {
                    nodes[i].setPrevious(nodes[i - 1]);
                }
            }
            //nodes[length - 2].data = 9; // Uncomment to ruin palindrome

            LinkedListNode head = nodes[0];
            System.out.println(head.printForward());
            System.out.println(isPalindrome(head));
        }

    }

}
