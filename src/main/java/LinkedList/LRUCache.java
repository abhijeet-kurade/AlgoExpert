package LinkedList;

import java.util.HashMap;

public class LRUCache{
    int maxSize;
    HashMap<String, DLLNode> cache;
    DoublyLinkedList list ;

    public  LRUCache(int maxSize){
        this.cache = new HashMap<>();
        this.maxSize = maxSize;
        this.list = new DoublyLinkedList();
    }

    public void viewCache(){
        if(list.size == 0){
            System.out.println("No keys");
        }
        DLLNode node = this.list.head;
        while (node != null){
            System.out.println(node.key + " - "+node.val);
            node = node.next;
        }
    }

    public void insertKeyValue(String key, int val){
        if(cache.get(key) != null){
            DLLNode node = cache.get(key);
            node.val = val;
            node = list.removeNode(node);
            list.insertAtHead(node);
            return;
        }
        else{
            DLLNode node = new DLLNode(key,val);
            if(cache.size() == maxSize){
                DLLNode leastEntry = this.list.tail;
                String leastKey = leastEntry.key;
                this.cache.remove(leastKey);
                this.list.removeNode(leastEntry);
            }
            this.list.insertAtHead(node);
            this.cache.put(key, node);
        }
    }
    public int getValueFromKey(String key){
        if(this.cache.get(key) == null){
            return -1;
        }
        DLLNode node = this.cache.get(key);
        node = this.list.removeNode(node);
        int val = node.val;
        this.list.insertAtHead(node);
        return val;
    }
    public String getMostRecentKey(){
        if(cache.size() == 0){
            return "";
        }
        String key = this.list.head.key;
        return key;
    }
}
class DLLNode{
    String key;
    int val;
    DLLNode prev;
    DLLNode next;

    public DLLNode(String key, int val){
        this.val = val;
        this.prev = null;
        this.next = null;
        this.key = key;
    }
}
class DoublyLinkedList{

    DLLNode head;
    DLLNode tail;
    int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtHead(DLLNode node){
        if(this.head == null){
            this.tail = node;
        }
        else{
            node.next = this.head;
            this.head.prev = node;
        }
        this.head = node;
        this.size++;
    }

    public void insertAtTail(DLLNode node){

        if(this.tail == null){
            this.head = node;
        }
        else{
            node.prev = this.tail;
            this.tail.next =node;
        }
        this.tail = node;
        this.size++;

    }

    public DLLNode removeNode(DLLNode node){
        if(this.head == node && this.tail == node){
            this.head = null;
            this.tail = null;
        }
        else if(this.head == node && this.tail != node){
            this.head = this.head.next;
            this.head.prev = null;
            node.next = null;
        }
        else if(this.head != node && this.tail == node){
            this.tail = this.tail.prev;
            this.tail.next = null;
            node.prev = null;
        }
        else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = null;
            node.prev = null;
        }
        this.size--;
        return node;
    }

}
