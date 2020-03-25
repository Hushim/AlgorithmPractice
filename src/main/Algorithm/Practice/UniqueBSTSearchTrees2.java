public class UniqueBSTSearchTrees2 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//Search with memorization
//Time: O(T) ~ O(n^2)
//Space: O(S)~ O(4^n/n ^(3/2)) = n^2G(n)
class Solution {
    private class TreesKey {
        int start;
        int end;

        private TreesKey(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<TreeNode> generateTrees(int n) {

        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }

        // select x from [1, n], left [1..x), right (x, n]
        //recursion: termination condition: len == 0
        //return buildTree(1, n);
        Map<TreesKey, List<TreeNode>> mem = new HashMap<>();
        return buildTreeWithMem(1, n, mem);
    }

    private List<TreeNode> buildTreeWithMem(int lower, int high, Map<TreesKey, List<TreeNode>> mem) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (lower > high) {
            res.add(null);
            return res;
        }

        TreesKey treesKey = new TreesKey(lower, high);
        if (mem.containsKey(treesKey)) {
            return mem.get(treesKey);
        }

        for (int i = lower; i <= high; i++) {
            List<TreeNode> left = buildTreeWithMem(lower, i - 1, mem);
            List<TreeNode> right = buildTreeWithMem(i + 1, high, mem);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        mem.put(treesKey, res);
        return res;
    }

}


//Brute force
//Time: O(T) ~ O(4^n/n ^(3/2)) = G(n)
//Space: O(S)~ O(4^n/n ^(3/2)) = nG(n)
class Solution {
    public List<TreeNode> generateTrees(int n) {

        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }

        // select x from [1, n], left [1..x), right (x, n]
        //recursion: termination condition: len == 0
        //return buildTree(1, n);
        Map<TreesKey, List<TreeNode>> mem = new HashMap<>();
        return buildTree(1, n);
    }

     private List<TreeNode> buildTree(int lower, int upper) {
         List<TreeNode> res = new ArrayList<>();
         if (lower > upper) {
             res.add(null);
             return res;
         }

         for (int i = lower; i <= upper; i++) {
             List<TreeNode> left = buildTree(lower, i - 1);
             List<TreeNode> right = buildTree(i + 1, upper);
             for (TreeNode leftNode : left) {
                 for (TreeNode rightNode : right) {
                     TreeNode node = new TreeNode(i);
                     node.left = leftNode;
                     node.right = rightNode;
                     res.add(node);
                 }
             }
         }
         return res;
     }
}