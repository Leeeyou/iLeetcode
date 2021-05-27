package type.tree.easy;

import geektime.high_frequency.top30.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * <p>
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class Offer_68_I_LowestCommonAncestorOfBinarySearchTree {

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

        Offer_68_I_LowestCommonAncestorOfBinarySearchTree obj = new Offer_68_I_LowestCommonAncestorOfBinarySearchTree();
        TreeNode treeNode1 = obj.lowestCommonAncestor(root, new TreeNode(4), new TreeNode(7));
        TreeNode treeNode2 = obj.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(5));
        System.out.println(treeNode1.getVal());
        System.out.println(treeNode2.getVal());
    }


    // 两次遍历，分别拿到p和q的路径，再拿到路径上最后一个相同的节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = getPath(root, p);
        List<TreeNode> qList = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < pList.size() && i < qList.size(); i++) {
            if (pList.get(i).equals(qList.get(i))) {
                ancestor = pList.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode r, TreeNode t) {
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode node = r;
        while (node != null && t != null && node != t) {
            list.add(node);
            if (t.getVal() < node.getVal()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        if (node != null) {
            list.add(node);
        }
        return list;
    }

    // 一次遍历，同时比较p和q节点与ancestor的大小，再更新ancestor节点
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (ancestor != null && p.getVal() < ancestor.getVal() && q.getVal() < ancestor.getVal()) {
                ancestor = ancestor.getLeft();
            } else if (ancestor != null && p.getVal() > ancestor.getVal() && q.getVal() > ancestor.getVal()) {
                ancestor = ancestor.getRight();
            } else {
                break;
            }
        }
        return ancestor;
    }

}
