package ch03_Stack_and_Queue;

import java.util.Stack;

/*
27 Observe that the minimum element doesn't change very often.
It only changes when a smaller element is added,
or when the smallest element is popped.

59 What if we kept track of extra data at each stack node?
What sort of data might make it easier to solve the problem?

78 consider having each node know the minimum of its "substack",
all the elements beneath it, including itself

 */
public class Q3_02_Stack_Min {

    public static class StackWithMin2 extends Stack<Integer> {
        Stack<Integer> s2;

        public StackWithMin2() {
            s2 = new Stack<>();
        }

        public void push(int value){
            if (value <= min()) {
                s2.push(value);
            }
            super.push(value);
        }

        public Integer pop() {
            int value = super.pop();
            if (value == min()) {
                s2.pop();
            }
            return value;
        }

        public int min() {
            if (s2.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return s2.peek();
            }
        }
    }

    public static void main(String[] args) {
        StackWithMin2 stack2 = new StackWithMin2();
        int[] array = {2, 1, 3, 1};
        for (int value : array) {
            stack2.push(value);
            System.out.print(value + ", ");
        }
        System.out.println('\n');
        for (int i = 0; i < array.length; i++) {
            System.out.println("Popped " + stack2.pop());
            System.out.println("New min is " + stack2.min());
        }
    }
}
