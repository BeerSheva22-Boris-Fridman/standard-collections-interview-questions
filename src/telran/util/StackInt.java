package telran.util;

//All methods should have complexity O[1]
import java.util.NoSuchElementException;

public class StackInt {
    private Node top; // верхний элемент стека
    private int max; // максимальный элемент стека

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void push(int num) {
        Node newNode = new Node(num);
        if (top == null) {
            top = newNode;
            max = num;
        } else {
            newNode.next = top;
            top = newNode;
            max = Math.max(max, num);
        }
    }

    public int pop() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        int value = top.value;
        top = top.next;
        if (top == null) {
            max = 0;
        } else {
            max = Math.max(max, top.value);
        }
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getMax() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return max;
    }
}
