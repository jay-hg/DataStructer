package wangdao.chapter3;

/**
 * 初始为空
 * 入队时允许增加队列占用空间
 * 出队后占用空间可以复用，队列占用空间只增不减
 * 入队操作和出队操作时间复杂度为O(1)
 */
public class Queue {

    ListNode front;
    ListNode rear;

    class ListNode {
        int data;
        ListNode next;
        ListNode prior;

        public ListNode(int data) {
            this.data = data;
        }
    }

    boolean enQueue(int x) {
        ListNode newNode = null;
        if (front.prior == null) {
            newNode = new ListNode(x);
        } else {
            newNode = front.prior;
            newNode.data = x;
            front.prior = newNode.prior;
            newNode.next = null;
            newNode.prior = null;
        }

        if (rear == null) {
            //空队列
            rear = newNode;
            front = newNode;
        } else {
            rear.next = newNode;
            newNode.prior = rear;
            rear = newNode;
        }
        return true;
    }

    int deQueue() {
        if (front == null) {
            throw new RuntimeException("队空");
        }
        int x = front.data;
        front = front.next;
        return x;
    }
}
