package LinkedList;

public class RemoveKthNodeFromEnd {
    public static void main(String[] args) {

    }
    public static void removeKthNodeFromEnd(LinkedList head, int k) {

        LinkedList start = head;
        LinkedList node = head.next;
        for(int i=1; i<k; i++) node = node.next;
        if(node == null){
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        while (node.next != null){
            node = node.next;
            start = start.next;
        }
        start.next = start.next.next;
        return;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
