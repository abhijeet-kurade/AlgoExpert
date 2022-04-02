package LinkedList;

public class MergeLinkedLists {
    public static void main(String[] args) {

    }
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList head = new LinkedList(0);
        LinkedList curr = head;
        while (headOne != null || headTwo != null){
            int one = headOne != null ? headOne.value : Integer.MAX_VALUE;
            int two = headTwo != null ? headTwo.value : Integer.MAX_VALUE;
            if(one <= two){
                curr.next = headOne;
                headOne = headOne.next;
            }
            else {
                curr.next = headTwo;
                headTwo = headTwo.next;
            }
            curr = curr.next;
        }
        return head.next;
    }
}
