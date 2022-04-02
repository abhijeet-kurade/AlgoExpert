package BinaryTree;

public class BinaryTreeDiameter {
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

    public int[] getDiameter(BinaryTree node){
        if(node == null)
            return new int[]{0, 0}; // 1. dia 2. depth

        int left[] = 	getDiameter(node.left);
        int right[] = getDiameter(node.right);

        int depth = Math.max(left[1], right[1]) + 1;
        int diameter = Math.max(Math.max(left[0], right[0]), left[1] + right[1]);

        return new int[]{diameter, depth};
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        return getDiameter(tree)[0];
    }
}
