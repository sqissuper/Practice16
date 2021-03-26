class ListDNode{
    public int val;
    public ListDNode next;
    public ListDNode prev;

    public ListDNode(int val) {
        this.val = val;
    }
}
public class DoubleLinkedList {
    public ListDNode head;
    public ListDNode last;

    public boolean isEmpty() {
        return this.head == null;
    }
    public void display() {
        ListDNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    public int size() {
        ListDNode cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    //头插法
    public void headInsert(int val) {
        ListDNode node  = new ListDNode(val);
        if(isEmpty()) {
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void tailInsert(int val) {
        ListDNode node = new ListDNode(val);
        if(isEmpty()) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    //任意位置插入
    public void insert(int val,int n) {
        if(n > size() || n < 0) return;
        if(n == 0) {
            headInsert(val);
            return;
        }
        if(n == size()) {
            tailInsert(val);
            return;
        }
        ListDNode node = new ListDNode(val);
        ListDNode cur = this.head;
        while(n  != 0) {
            cur = cur.next;
            n--;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
    }

    //删除
    public void deleteNode(int val) {
        if(isEmpty()) return;
        if(this.head.val == val) {
            this.head = this.head.next;
            this.head.prev = null;
            return;
        }
        if(this.last.val == val) {
            this.last.prev.next = null;
            this.last = this.last.prev;
            return;
        }
        ListDNode cur = this.head;
        while(cur != null) {
            if(cur.val == val) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有的额值
    public void delAll(int val) {
        ListDNode cur = this.head;
        while(cur != null) {
            if(cur.val == val) {
                if(cur.val == this.head.val) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = this.last.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
    public static void main(String[] args) {
        DoubleLinkedList myList = new DoubleLinkedList();
        myList.headInsert(1);
        myList.headInsert(2);
        myList.tailInsert(3);
        myList.tailInsert(5);
        myList.insert(4,4);
        myList.insert(22,3);
        myList.insert(11,1);
        myList.delAll(11);
        myList.display();
    }
}
