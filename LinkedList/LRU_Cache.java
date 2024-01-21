


class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    Map<Integer,Node> map = new HashMap();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // check if the key is present if it is presnt please delete and insert at start
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            delete(node);
            insert(node);
            return node.val;
        }
        // else return -1 from it
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            delete(map.get(key));
        }
        // delete the last one
        if(map.size() == capacity)
            delete(tail.prev);
        // and insert at start

        insert(new Node(key,value));
    }

    public void insert(Node node)
    {
        // just establish the connection between head and headnext
        map.put(node.key,node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void delete(Node node)
    {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node {
        Node prev , next;
        int key;
        int val;

        Node(int key , int val)
        {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
