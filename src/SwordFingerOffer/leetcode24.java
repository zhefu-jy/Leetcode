package SwordFingerOffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 025. 链表中的两数相加
 * 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *
 *
 * 示例1：
 *
 *
 *
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 */
public class leetcode24 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val=2;
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2 = new ListNode();
        l2.val=5;
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        addTwoNumbers(l1,l2);



    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       Deque<Integer>  deque1=new ArrayDeque<>();
       Deque<Integer>  deque2=new ArrayDeque<>();
        ListNode res = new ListNode();
        while (l1!=null){
           deque1.push(l1.val);
           l1=l1.next;
       }
        while (l2!=null){
            deque2.push(l2.val);
            l2=l2.next;
        }
        int sub=0;
        while (deque1!=null || deque2!=null || sub!=0){
            int num1=deque1.isEmpty()?0:deque1.pop();
            int num2=deque1.isEmpty()?0:deque1.pop();
            int cur=num1+num2+sub;
            sub=cur/10;
            cur=cur%10;
            ListNode temp = new ListNode(cur);
            temp.next=res;
            res=temp;
        }

         return res;
    }


   static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
