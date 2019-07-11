package sort;

public class LinkedListSort {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //找中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //以中点为界，递归获取两个子链表
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;
        l1 = sortList(l1);
        l2 = sortList(l2);
        //归并两个子链表
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(0);
        ListNode curNode = resultNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        curNode.next = l1 == null ? l2 : l1;
        return resultNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode l = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(3);
        LinkedListSort lls = new LinkedListSort();
        lls.sortList(l);
    }
}



