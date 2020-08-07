package wangdao.chapter2;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return cut(head);
    }

    private ListNode cut(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }

        ListNode previousNode = p;
        ListNode q = p;
        ListNode tail = p;

        while (tail != null) {
            previousNode = q;
            q = q.next;
            tail = tail.next;
            if (tail != null) {
                tail = tail.next;
            }
        }
        previousNode.next = null;

        ListNode r1 = cut(p);
        ListNode r2 = cut(q);
        ListNode ret = merge(r1, r2);
        return ret;
    }

    private ListNode merge(ListNode p, ListNode q) {
        ListNode tail = new ListNode(-1);
        ListNode head = tail;

        while (p != null && q != null) {
            if (p.val < q.val) {
                tail.next = p;
                p = p.next;
            } else {
                tail.next = q;
                q = q.next;
            }
            tail = tail.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 6, 78, 24, 65, 87, 12, 3, 57, 89, 54, 25};
        ListNode head = new ListNode(-1);
        for (int i : a) {
            ListNode p = new ListNode(i);
            p.next = head.next;
            head.next = p;
        }

        head = head.sortList(head.next);
        ListNode p = head;
        while ((p = p.next) != null) {
            System.out.print(p + " ");
        }
        System.out.println();
    }
}
