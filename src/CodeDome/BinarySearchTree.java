package CodeDome;

class Node{
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    int val;
    Node right;
    Node left;

    Node(int val,Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n2 = new Node(2, n1, n3);

        System.out.println(contains(n2, 3));
    }

    private static boolean contains(Node node, int key) {
        if(node==null){
            return false;
        }
        int currentVal = node.getVal();

        if(currentVal==key){
            return true;
        } else if(currentVal<key){
            return contains(node.getRight(),key);
        }else{
            return contains(node.getLeft(),key);
        }
    }
}
