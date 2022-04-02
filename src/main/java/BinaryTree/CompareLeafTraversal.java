package BinaryTree;

import java.util.Stack;

public class CompareLeafTraversal {
    public static void main(String[] args) {

    }
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {

        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();

        BinaryTree node1 = getNextLeaf(stack1,tree1);
        BinaryTree node2 = getNextLeaf(stack2,tree2);
        while (true){
            if(node1 == null && node2 == null) break;
            else if(node1 == null || node2 == null || node1.value != node2.value) return  false;
            node1 = getNextLeaf(stack1,null);
            node2 = getNextLeaf(stack2,null);
        }
        return true;

    }
    public BinaryTree getNextLeaf(Stack<BinaryTree> stack, BinaryTree current ){
        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if(current.left == null && current.right == null) return current;
            current = current.right;
        }
        return null;
    }
}
