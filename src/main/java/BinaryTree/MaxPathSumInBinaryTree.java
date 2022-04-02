package BinaryTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxPathSumInBinaryTree {
    public static void main(String[] args) {

    }
    public static int[] getMaxPathSum(BinaryTree node){
        if(node == null) return new int[]{0, Integer.MIN_VALUE}; // branch and path

        int[] left = getMaxPathSum(node.left);
        int[] right = getMaxPathSum(node.right);


        int branch = Math.max(left[0], right[0]);
        int maxBranch = Math.max(branch + node.value, node.value);

        int maxWithRoot = Math.max(maxBranch, left[0] + node.value + right[0]);
        int maxPathSum = Math.max(maxWithRoot, Math.max(left[1], right[1]));

        return new int[] {maxBranch, maxPathSum};
    }

    public static int[] maxPathSums(BinaryTree node){
        if(node == null) return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

        int[] left = maxPathSums(node.left);
        int[] right = maxPathSums(node.right);

        int leftPath = left[0];
        int leftBranch = left[1];
        int rightPath = right[0];
        int rightBranch = right[1];

        int currLeftBranch = leftBranch != Integer.MIN_VALUE ? node.value + leftBranch : Integer.MIN_VALUE;
        int currRightBranch = rightBranch != Integer.MIN_VALUE ? node.value + rightBranch : Integer.MIN_VALUE;

        int maxBranchSum = Math.max(Math.max(currLeftBranch, currRightBranch), node.value);

        int currLeftRightPath = (leftBranch == Integer.MIN_VALUE || rightBranch == Integer.MIN_VALUE) ? Integer.MIN_VALUE : leftBranch + node.value + rightBranch;

        List<Integer> list = Arrays.asList(leftPath, rightPath, currLeftBranch, currRightBranch, currLeftRightPath, node.value);
        int maxPathSum = Collections.max(list);
        System.out.println(maxPathSum + " "+maxBranchSum);

        return new int[]{maxPathSum, maxBranchSum};
    }

    public static int maxPathSum(BinaryTree tree) {
        return Math.max(getMaxPathSum(tree)[0], getMaxPathSum(tree)[1]);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
