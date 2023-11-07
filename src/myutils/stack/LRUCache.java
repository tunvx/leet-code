package myutils.stack;

/**
 * https://leetcode.com/problems/lru-cache/
 * Idea: Use DList run in O(1) average time complexity for each function.
 */

public class LRUCache {
    public Node[] map;
    public Node head, tail;
    public int maxSize, count;

    public void print() {
        Node run = head.next;
        while (run != tail) {
            System.out.print(run.key + ", " + run.val + " -> ");
            run = run.next;
        }
        System.out.println();
    }

    public LRUCache(int capacity) {
        map = new Node[10001];
        maxSize = capacity;
        head = new Node();
        tail = new Node();
        connect(head, tail);
    }

    private void connect(Node node1, Node node2) {
        node1.next = node2;
        node2.prev = node1;
    }

    private void deleteNode(Node cur) {
        connect(cur.prev, cur.next);
        cur.del();
    }

    private void addAtTail(Node cur) {
        connect(tail.prev, cur);
        connect(cur, tail);
    }

    public int get(int key) {
        if (map[key] != null) {
            Node node = map[key];
            deleteNode(node);
            addAtTail(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map[key] != null) {
            Node node = map[key];
            node.val = value;
            deleteNode(node);
            addAtTail(node);
        }
        else {
            Node node = new Node(key, value);
            map[key] = node;
            if (count < maxSize) {
                count ++;
                addAtTail(node);
            }
            else {
                map[head.next.key] = null;
                deleteNode(head.next);
                addAtTail(node);
            }
        }
    }

    class Node {
        int key, val;
        Node next, prev;

        public Node() {}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        void del() {
            this.next = this.prev = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
