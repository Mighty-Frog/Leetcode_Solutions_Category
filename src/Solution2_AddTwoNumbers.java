//Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      @Override
      public String toString(){
          String a = Integer.toString(this.val);
          ListNode cur = this;
          while(cur.next != null){
             cur = cur.next;
             a = a+ cur.val;
          }
          return a;
      }
  }

class Solution2_AddTwoNumbers {
      public static void main(String[] args){
          ListNode l1= new ListNode(1, new ListNode(2, new ListNode(3)));
          ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3)));
          System.out.println(new Solution2_AddTwoNumbers().addTwoNumbers(l1,l2).toString());
      }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode();
        ListNode cur1 = l1, cur2 = l2, cur3 =  new ListNode(0);

        while(cur1.next != null || cur2.next != null){
            int sum = cur1.val + cur2.val;
            System.out.println("whileloop");
            if(sum > 9){
                cur3.val += cur1.val + cur2.val -10;
                cur3.next = new ListNode(1);
            }else{
                cur3.val = cur1.val+cur2.val;
            }
            cur1= cur1.next;
            cur2= cur2.next;
            cur3.next = new ListNode();
            cur3= cur3.next;
        }
        return cur3;

    }
}
