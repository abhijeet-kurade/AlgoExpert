package BinaryTree;

public class HeightBalancedBinaryTree {
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

    // [first, second]    first is this subtree is balanced or not (0 = balanced 1 = unbalanced) second = height
    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        return balancedBinaryTree(tree)[0] == 0;
    }

    public int[] balancedBinaryTree(BinaryTree node) {

        if(node.left == null && node.right == null) return new int[]{0, 1};

        int[] left = node.left != null ? balancedBinaryTree(node.left) : new int[]{0, 0};
        int[] right = node.right != null ? balancedBinaryTree(node.right) : new int[]{0, 0};

        int diff = Math.abs(left[1] - right[1]) > 1 ? 1 : 0;
        int curr = Math.max(Math.max(left[0], right[0]), diff);

        int height = Math.max(left[1], right[1]) + 1;

        return new int[]{curr, height};
    }

}
