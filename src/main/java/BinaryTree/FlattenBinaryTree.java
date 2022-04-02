package BinaryTree;

public class FlattenBinaryTree {
    public static void main(String[] args) {

    }
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        BinaryTree[] rt = flattenTree(root);
        return rt[0];
    }

    public static BinaryTree[] flattenTree(BinaryTree node){
        BinaryTree left_most = null;
        BinaryTree right_most = null;
        if(node.left == null){
            left_most = node;
        }
        else{
            BinaryTree[] left = flattenTree(node.left);
            connect(left[1], node);
            left_most = left[0];
        }
        if(node.right == null){
            right_most = node;
        }
        else{
            BinaryTree[] right = flattenTree(node.right);
            connect(node, right[0]);
            right_most = right[1];
        }
        return new BinaryTree[]{left_most, right_most};
    }

    public static void connect(BinaryTree node_one, BinaryTree node_two){
        node_one.right = node_two;
        node_two.left = node_one;
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
