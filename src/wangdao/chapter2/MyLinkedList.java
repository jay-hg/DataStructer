package wangdao.chapter2;

public class MyLinkedList {
    private Node head = new Node(-1);

    public MyLinkedList(int[] a) {
        Node p = head;
        for (int i : a) {
            Node temp = new Node(i);
            p.next = temp;
            p = temp;
        }
    }

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void printList() {
        Node temp = head;
        while ((temp = temp.next) != null) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    public Node deleteX(Node list, int x) {
        if (list == null) {
            return list;
        }
        Node next = deleteX(list.next, x);
        list.next = next;
        if (list.data == x) {
            list = list.next;
        }
        return list;
    }

    public void printFromTailToHead() {
        printNextNode(head.next);
        System.out.println();
    }

    private void printNextNode(Node p) {
        if (p == null) {
            return;
        }
        printNextNode(p.next);
        System.out.print(p.data + " ");
    }

    public void deleteMin() {
        Node minNode = null;
        int min = Integer.MAX_VALUE;
        Node p = head;
        while ((p = p.next) != null) {
            if (p.data < min) {
                min = p.data;
                minNode = p;
            }
        }

        for (p = head; p.next != minNode; p = p.next) {

        }
        p.next = minNode.next;
    }

    public void reverse() {
        Node p = head.next;
        head.next = null;
        while (p != null) {
            Node temp = p.next;
            p.next = head.next;
            head.next = p;
            p = temp;
        }
    }

    public void sort() {
        Node preNode = head.next,q = head.next;
        while ((q = q.next) != null) {

            preNode = q;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(new int[]{10, 2, 3, 4, 5, 4, 6});
//        list.deleteX(list.head.next, 4);

//        list.printFromTailToHead();

//        list.deleteMin();

        list.reverse();
        list.printList();
    }
}
