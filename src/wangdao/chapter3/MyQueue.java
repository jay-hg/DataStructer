package wangdao.chapter3;

import java.util.Queue;
import java.util.Stack;

public class MyQueue {
    int[] arr;
    final static int N = 10;
    int total;
    boolean tag;
    int front = 0;
    int rear = 0;

    public MyQueue() {
        arr = new int[N];
        total = 0;
        tag = false;
    }

    boolean enQueue(int x) {
        if (tag) {
            return false;
        }
        arr[rear] = x;
        rear = (rear + 1) % N;
        total++;
        if (rear == front) {
            tag = true;
        }
        return true;
    }

    int deQueue() {
        int x = arr[front];
        front = (front + 1) % N;
        total--;
        if (tag) {
            tag = false;
        }
        return x;
    }

    void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            stack.push(x);
        }
        while (!stack.isEmpty()) {
            Integer x = stack.pop();
            queue.offer(x);
        }
    }
}
