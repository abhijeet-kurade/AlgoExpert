package BinaryTree;

public class NodeDepths {
    public static void main(String[] args) {

    }
    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        return modeDepthSum(root, 0);
    }
    public static int modeDepthSum(BinaryTree node, int depth){
        if(node == null) return 0;
        int left = modeDepthSum(node.left, depth+1) ;
        int right =  modeDepthSum(node.right, depth+1) ;
        return depth + left + right;

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
