package LinkedList;

public class IntersectionOfTwoLinkedList {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            /**
             *pointer, (a+C+b)+C = (b+C+a)+C ,so buil two list which connected A and B, will share same ponsitioned C
             */
            ListNode a = headA, b =headB;
            while(true) {
                if(a == b) break;
                //判断不能是a.next==null,否则a为空会报错，其二，ab各为单元素，且不同会反复横跳。
                a = a == null?headB:a.next;
                b = b == null?headA:b.next;
            }
            return a;




            /**
             *HashSet
             */
        /*
        Set<ListNode> set = new HashSet<>();
        ListNode curA = headA, curB = headB;
        while(curA != null){
            set.add(curA);
            curA = curA.next;
        }
        while(curB != null){
            if(set.contains(curB)) {
                return curB;
            }
            curB = curB.next;
        }
        return null;
        */
        }


}
