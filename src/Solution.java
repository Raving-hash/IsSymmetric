


 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
/*
递归不能做太多事；确认好递归方法的作用，有几种状态
这里有两种：
1 高为2的树，这里即起点，只需要判断两个分支是否相等
2 高为3的树，需要传递镜像分支，即左左与右右，左右与右左。
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    return mirror(root.left, root.right);
    }
    public boolean mirror(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return  false;
        return mirror(left.left,right.right) && mirror(right.left,left.right);
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        TreeNode A = new TreeNode(2);
        //[4,2,3,4,5,6,7,8,9]
        //[4,8,9]
        A.left = new TreeNode(3);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(5);
//        A.right.right = new TreeNode(3);
//        A.left.left.left = new TreeNode(8);
//        A.left.left.right = new TreeNode(9);
//        TreeNode B = new TreeNode(4);
//        B.left = new TreeNode(8);
//        B.right = new TreeNode(9);
        boolean symmetric = so.isSymmetric(A);
        System.out.println("symmetric = " + symmetric);
    }
}