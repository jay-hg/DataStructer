package sort;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode cur = head;
        while (cur != null) {
            //准备下一次循环
            ListNode todoNode = cur;
            cur = cur.next;
            //找到插入位置
            ListNode insertPre = getInsertPre(hair,todoNode);
            //将当前节点插入排序
            insert(hair, todoNode, insertPre);
        }

        return hair.next;
    }

    private ListNode getInsertPre(ListNode hair, ListNode todoNode) {
        ListNode insertPre = hair;
        while (insertPre.next != todoNode && insertPre.next.val < todoNode.val) {
            insertPre = insertPre.next;
        }
        return insertPre;
    }

    private void insert(ListNode hair, ListNode todoNode, ListNode insertPre) {
        if (insertPre.next == todoNode) {
            return;
        }
        //连接todoNode的前后节点
        ListNode preTodoNode = getPre(hair, todoNode);
        preTodoNode.next = todoNode.next;

        //插入todoNode
        todoNode.next = insertPre.next;
        insertPre.next = todoNode;
    }

    private ListNode getPre(ListNode hair, ListNode targetNode) {
        ListNode pre = hair;
        while (pre != null && pre.next != null && pre.next != targetNode) {
            pre = pre.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        InsertionSortList isl = new InsertionSortList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head = isl.insertionSortList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
