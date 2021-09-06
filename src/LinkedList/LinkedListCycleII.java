package LinkedList;

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 *
 * Do not modify the linked list.
 * */
public class LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode runner = head, walker = head;
        while(true) {
            if(runner == null || runner.next == null) return null;
            //we ignore the start point, only consider meeting poiny after moving, so move first then judge
            runner = runner.next.next;
            walker = walker.next;
            //when they meet, themselves are the meeting point, so just break the while loop.
            if(runner == walker) break;
        }

        //let walker return back to the start point
        walker = head;
        //they two move one step each time, when they meet again, the meeting point is the start of the circle
        while(walker != runner) {
            walker = walker.next;
            runner = runner.next;
        }
        return walker;

    }
}
