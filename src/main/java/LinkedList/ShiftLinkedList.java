package LinkedList;

public class ShiftLinkedList {
    public static void main(String[] args) {

    }
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        LinkedList node = head;
        int nodes = 1;
        while (node.next != null){
            node = node.next;
            nodes += 1;
        }
        LinkedList tail = node;
        tail.next = head;
        int shift = k % nodes;
        shift = shift < 0 ? shift : nodes - shift;
        shift = Math.abs(shift);
        //System.out.println(shift);
        node = tail;
        for(int i =0; i<shift; i++){
            node = node.next;
        }
        LinkedList newHead = node.next;
        node.next = null;

        return newHead;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}
