package java10_17;

import java.util.ArrayList;
import java.util.List;

/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-17
 * Time:16:40
 **/

class TreeNode{
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class TestInterview {

    public static List<Integer> prevOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        result.add(root.val);
        result.addAll(prevOrder(root.left));
        result.addAll(prevOrder(root.right));
        return result;
    }

    public static List<Integer> inOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root  == null){
            return result;
        }
        result.addAll(inOrder(root.left));
        result.add(root.val);
        result.addAll(inOrder(root.right));
        return result;
    }
    public static List<Integer> pastOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        result.addAll(pastOrder(root.left));
        result.addAll(pastOrder(root.right));
        result.add(root.val);
        return result;
    }

    public boolean isSameTree(TreeNode p,TreeNode q){
        //如果p,q同时为空，则认为他们是相同的树
        if (p == null && q == null){

            return true;
        }
        //其中一个为空，则两个树不相同
        if (p == null  || q == null ){
            return false;
        }
        //判断根节点是否相同
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
    public  boolean isSubTree(TreeNode s,TreeNode t){
        if (s == null && t == null){
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        boolean ret = false;
        if (s.val == t.val){
            ret = isSameTree(s,t);
        }

        return ret ||isSubTree(s.left,t)||isSubTree(s.right,t) ;
    }
}
