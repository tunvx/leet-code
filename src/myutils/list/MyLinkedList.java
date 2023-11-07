package myutils.list;

/**
 * https://leetcode.com/problems/design-linked-list
 * Idea: **Implement Double Linked List**
 */

public class MyLinkedList {
    private Node head, tail;
    private int size;

    public void print() {
        Node run = head.next;
        while (run != tail) {
            System.out.print(run.val + " ");
            run = run.next;
        }
        System.out.println();
    }

    public void connect(Node node1, Node node2) {
        node1.next = node2;
        node2.prev = node1;
    }

    public MyLinkedList() {
        head = new Node();
        tail = new Node();
        connect(head, tail);
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node run = head.next;
        while (true) {
            if (index == 0) {
                return run.val;
            }
            run = run.next;
            index --;
        }
    }

    public void addAtHead(int val) {
        size += 1;
        Node newNode = new Node(val);
        connect(newNode, head.next);
        connect(head, newNode);
    }

    public void addAtTail(int val) {
        size ++;
        Node newNode = new Node(val);
        connect(tail.prev, newNode);
        connect(newNode, tail);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        else if (index == 0) {
            addAtHead(val);
        }
        else if (index == size) {
            addAtTail(val);
        }
        else {
            Node run = head.next;
            while (true) {
                index -= 1;
                if (index <= 0) {
                    break;
                }
                run = run.next;
            }
            size ++;
            Node newNode = new Node(val);
            connect(newNode, run.next);
            connect(run, newNode);
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        else if (index == 0) {
            if (size != 0) {
                size -= 1;
                Node temp = head.next;
                connect(head, temp.next);
                temp.del();
            }
        }
        else  {
            Node run = head.next;
            while (true) {
                if (index == 0) {
                    break;
                }
                run = run.next;
                index --;
            }
            size --;
            connect(run.prev, run.next);
            run.del();
        }
    }

    class Node {
        int val;
        Node prev, next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public void del() {
            this.prev = this.next = null;
        }
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