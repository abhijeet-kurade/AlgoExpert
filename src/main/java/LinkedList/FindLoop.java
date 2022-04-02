package LinkedList;

import java.util.Arrays;
import java.util.Collections;

public class FindLoop {
    public static void main(String[] args) {
        int[] arr = {6,3,4,1,4,8,2};
        System.out.println(missingNumber(arr, arr.length));

    }
    public static int missingNumber(int arr[], int n) {
        int idx =0;
        n = arr.length;
        while(idx < n){
            if(arr[idx] > n || arr[idx] <= 0 || arr[arr[idx]-1] == arr[idx]){
                idx += 1;
                continue;
            }
            int temp = arr[idx];
            arr[idx] = arr[arr[idx]-1];
            arr[idx] = temp;
        }
        for(idx=0; idx<n; idx++){
            if(idx+1 == arr[idx]) continue;
            return idx+1;
        }
        return n+1;
    }

    public static LinkedList findLoop(LinkedList head) {

        LinkedList slow = head;
        LinkedList fast = head.next;

        while (slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        fast = fast.next;

        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
