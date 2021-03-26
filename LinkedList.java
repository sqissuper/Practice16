class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class LinkedList {
    public ListNode head;

    //判断是否为空
    public boolean empty() {
        return this.head == null;
    }

    //计算链表长度
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //打印链表
    public void display() {
        ListNode cur = this.head;
        while(cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    //头插法
    public void headInsert(int val) {
        //首先new一个节点
        ListNode node = new ListNode(val);
        //判断链表是否为空
        if(empty()) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void tailInsert(int val) {
        ListNode node = new ListNode(val);
        if(empty()) {
            this.head = node;
        } else {
            ListNode cur = this.head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //任意位置插入
    public void insert(int val,int n) {
        ListNode node = new ListNode(val);
        if(empty()) {
            this.head = node;
        }
        if(n == 0) {
            //使用头插法
            headInsert(val);
            return;
        }
        if(n == size()) {
            //使用尾插法
            tailInsert(val);
            return;
        }
        ListNode cur = this.head;
        int count = 1; //计数，与n相等时插入,默认下标从1开始
        while(n - 1 != count) {
            count++;
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }

    //查找n位置的节点
    public ListNode findN(int n) {
        if(this.head == null) return null;
        if(n < 0 || n > size()) return null;
        ListNode cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            if(count == n) return cur;
            cur = cur.next;
        }
        return null;
    }

    //删除节点
    public void delVal (int val) {
        //判空
        if(empty()) return;
        if(this.head.val == val) {
            this.head = this.head.next;
            return;
        }
        ListNode prev = this.head;
        ListNode cur = prev.next;
        while(cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
    }
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.headInsert(2);
        myList.headInsert(1);
        myList.tailInsert(3);
        myList.insert(0,0);
        myList.insert(5,3);
        System.out.println(myList.size());
        System.out.println(myList.findN(3).val);
        myList.delVal(0);
        myList.display();
    }
}
