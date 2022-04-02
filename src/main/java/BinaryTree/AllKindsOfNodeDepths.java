package BinaryTree;

public class AllKindsOfNodeDepths {
    public static void main(String[] args) {

    }
    public static int allKindsOfNodeDepths(BinaryTree root) {
        return allNodes(root, 0);
    }

    public  static int allNodes(BinaryTree node, int depth){
        if(node == null) return 0;
        int contribution = ( depth * (depth + 1) ) / 2;
        depth += 1;
        int left = allNodes(node.left, depth);
        int right = allNodes(node.right, depth);

        return  left + contribution + right;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
