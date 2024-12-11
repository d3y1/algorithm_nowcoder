package com.nowcoder.topic.hash.middle;

import java.util.HashSet;

/**
 * NC3 链表中环的入口结点
 * @author d3y1
 */
public class NC3 {
    /**
     * 相似 -> NC305 寻找唯一重复数 [nowcoder]
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // return solution1(pHead);
        // return solution2(pHead);
        return solution3(pHead);
    }

    /**
     * 双指针: 快慢指针
     * @param pHead
     * @return
     */
    private ListNode solution1(ListNode pHead){
        ListNode fast = pHead;
        ListNode slow = pHead;
        if(fast==null || fast.next==null){
            return null;
        }
        do{
            fast = fast.next.next;
            slow = slow.next;
        }while(fast!=null && fast.next!=null && fast!=slow);

        // 有环(相遇)
        if(fast == slow){
            slow = pHead;
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        // 无环
        else{
            return null;
        }
    }

    /**
     * 双指针: 快慢指针
     * @param pHead
     * @return
     */
    private ListNode solution2(ListNode pHead){
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }

        // 无环
        if(fast==null || fast.next==null){
            return null;
        }

        // 有环
        slow = pHead;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    /**
     * 哈希: HashSet
     * @param pHead
     * @return
     */
    private ListNode solution3(ListNode pHead){
        HashSet<ListNode> set = new HashSet<>();
        while(pHead != null){
            if(set.contains(pHead)){
                return pHead;
            }
            set.add(pHead);
            pHead = pHead.next;
        }

        return null;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}