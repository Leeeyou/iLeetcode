package type.tree.easy;

import com.sun.istack.internal.NotNull;
import geektime.high_frequency.top30.TreeNode;

import java.util.ArrayList;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * <p>
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class Offer_68_II_LowestCommonAncestorOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);

        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(8));

        root.getLeft().setLeft(new TreeNode(0));
        root.getLeft().setRight(new TreeNode(4));

        root.getRight().setLeft(new TreeNode(7));
        root.getRight().setRight(new TreeNode(9));

        root.getLeft().getRight().setLeft(new TreeNode(3));
        root.getLeft().getRight().setRight(new TreeNode(5));

        Offer_68_II_LowestCommonAncestorOfBinaryTree obj = new Offer_68_II_LowestCommonAncestorOfBinaryTree();
        TreeNode treeNode1 = obj.lowestCommonAncestor3(root, new TreeNode(4), new TreeNode(7));
        TreeNode treeNode2 = obj.lowestCommonAncestor3(root, new TreeNode(3), new TreeNode(5));
        if (treeNode1 != null) {
            System.out.println(treeNode1.getVal());
        }
        if (treeNode2 != null) {
            System.out.println(treeNode2.getVal());
        }
        System.out.println();
    }

    // 两次遍历，分别拿到p和q的路径，再拿到路径上最后一个相同的节点
    // 与搜索二叉树不同的是需要逐个遍历子树，如果不在该子树上要remove当前node
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pList = new ArrayList<>();
        ArrayList<TreeNode> qList = new ArrayList<>();
        getPath(root, p, pList);
        getPath(root, q, qList);

        TreeNode ancestor = root;
        for (int i = 0; i < pList.size() && i < qList.size(); i++) {
            if (pList.get(i).getVal() == qList.get(i).getVal()) {
                ancestor = pList.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public boolean getPath(TreeNode root, @NotNull TreeNode target, @NotNull ArrayList<TreeNode> list) {
        if (root == null) {
            return false;
        }

        list.add(root);
        if (root.getVal() == target.getVal()) {
            return true;
        }

        if (getPath(root.getLeft(), target, list)) {
            return true;
        } else if (getPath(root.getRight(), target, list)) {
            return true;
        } else {
            list.remove(root);
            return false;
        }
    }

    // 极客时间的覃老师的答案
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode l = lowestCommonAncestor3(root.getLeft(), p, q);
        TreeNode r = lowestCommonAncestor3(root.getRight(), p, q);

        return l == null ? r : (r == null ? l : root);
    }

}
