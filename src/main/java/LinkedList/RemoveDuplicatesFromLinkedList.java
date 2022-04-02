package LinkedList;

public class RemoveDuplicatesFromLinkedList {
    public static void main(String[] args) {

    }
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList head) {
        LinkedList current = head;
        LinkedList nextNode = head.next;

        while (nextNode != null){
            if(current.value != nextNode.value){
                current.next = nextNode;
                current = nextNode;
            }
            nextNode = nextNode.next;
        }

        current.next = null;

        return head;
    }

}
