package java10_17;

/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-16
 * Time:21:52
 **/
class Node {
    public Node left;
    public Node right;
    public char val;

    public Node(char val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
public class TestTree {
    public static Node buildTree(){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;
        return a;

    }
    public static void prevOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.val+"  ");
        prevOrder(root.left);
        prevOrder(root.right);
    }
    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+"  ");
        inOrder(root.right);
    }
    public static void lastOrder(Node root){
        if (root == null){
            return;
        }
        prevOrder(root.left);
        prevOrder(root.right);
        System.out.print(root.val+"  ");
    }
    public static int size(Node root){
        if (root == null){
            return 0;
        }
        return 1+size(root.left)+size(root.right);
    }

    public static int leafSize(Node root){
        if (root == null){
            return 0;
        }
        if (root.right == null && root.left == null){
            return 1;
        }
        return leafSize(root.right)+leafSize(root.left);
    }

    public static int kLevelSize(int k,Node root){
        if (k < 1){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        return kLevelSize(k-1,root.left)+kLevelSize(k-1,root.right);
    }
    public static Node  search(Node root,char toFind){
        if (root == null){
            return null;
        }
        if (root.val == toFind){
            return root;
        }
        Node ret = search(root.left,toFind);
        if (ret != null){
            return ret;
        }
        return search(root.right,toFind);
    }

    public static void main(String[] args) {
        Node root = buildTree();
        prevOrder(root);
        System.out.println();
        System.out.println(size(root));
        System.out.println(leafSize(root));
    }

}
