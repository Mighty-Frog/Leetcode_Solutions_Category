package LiinkedList;

class MyLinkedList {
    int size;
    Node head;

    class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new Node(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        //exception case 特殊情况，小于0以及大于等于链表大小
        if(index < 0 || index >= size){
            return -1;
        }
        //creat a head node and traverse to find the index node 创建一个头节点，然后遍历找到索引节点
        Node cur = head;
        for(int i = 0; i <= index; i++){
            cur = cur.next;
        }
        //return its value 返回这个节点的值
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {

        //initialise the added node 初始化要加入的节点
        Node added = new Node(val);
        //let the added node point to first node of original linkedlist新点接原首节点
        added.next = head.next;
        //adjust head node to point to the added node 让头节点指向增加节点
        head.next = added;
        //update size 更新大小
        size++;

        //Another method, call add method
        // addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    //初始新点，找到尾点，接上。
    public void addAtTail(int val) {
        //initialise the added node 初始化要加入的节点
        Node added_tail = new Node(val);
        //using a new node to finde last node 用一个新节点找到最后一个节点
        Node tail_pre = head;
        for(int i = 0; i < size; i++) {
            // i 在小于size和小于index 的区别， size = index+1， 完成i = index,
            // 就是在index当前个，所以此处i最大循环到第size -1， 即最大index：最后一个。
            tail_pre = tail_pre.next;
        }
        //link the added node to the last node 接上
        tail_pre.next = added_tail;
        //update size
        size++;
        //addAtIndex(size, val);
    }

    //another way, add(size, val) 另一种方法，调用add()

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        //exception conditon
        if(index < 0 || index > size) {
            return;
        }
        //intialise Node of inserted
        Node inserted = new Node(val);
        //find the Node 0f index
        Node index_pre = head;
        for(int i = 0; i < index; i++){
            index_pre = index_pre.next;
        }
        //link
        inserted.next = index_pre.next;  //can be null, it is fine
        index_pre.next = inserted;
        //increase size
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        //invalid cases 不合法情况
        if(index >= size || index < 0) {
            return;
        }
        //find the pre_index node 找到索引节点前面一个
        Node index_pre = head;
        for(int i = 0; i < index; i++) {
            index_pre = index_pre.next;
        }
        //delete operation, gap the index node and link the pre and next nodes 删除操作，跳过索引节点，连接前后两个节点
        index_pre.next = index_pre.next.next;
        //update size
        size--;


    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
