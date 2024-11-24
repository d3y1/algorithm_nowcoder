package com.nowcoder.special.sort.middle;

/**
 * NC133 链表的奇偶重排
 * @author d3y1
 */
public class NC133{
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        return solution(head);
    }

    /**
     * 链表排序: 奇偶节点
     * @param head
     * @return
     */
    private ListNode solution(ListNode head){
        if(head == null){
            return null;
        }

        ListNode oddHead = head;
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;

        // 关键
        while(evenTail!=null && evenTail.next!=null){
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }

        // if(evenHead != null){
        //     oddTail.next = evenHead;
        // }
        oddTail.next = evenHead;

        return oddHead;
    }

    private class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
}