public class Solution_2_add_two_numbers {
/**
        * Definition for singly-linked list.
            * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 18 + 19
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode p1 = l1, p2 = l2;
    ListNode dummy = new ListNode(-1);  //initialize a start node
    ListNode p = dummy;  //p的第一个node是dummy, p实际是个 tempotorial node
    int carry = 0, newVal = 0;
    while(p1 != null || p2 != null || carry > 0){
        newVal = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 :p2.val) + carry;  // 8+9 =11  ，1+1+1 =3
        carry = newVal / 10; // carry is 1 ， carry is 0
        newVal %= 10;       // newval is 1 , newVal is 3
        p.next = new ListNode(newVal);  //next node is 1, next node is 3
        p1 = (p1 == null ? null : p1.next); //update p1,
        p2 = (p2 == null ? null : p2.next); //update p2
        p = p.next;   //move p,  p.next is always null
    }
    return dummy.next;
}

}
