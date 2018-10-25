package DataStructures.BinaryTree;

class Node<T> {

    private Node rightChild;

    private Node leftChild;

    private T key;

    public Node(T keyValue){
        key = keyValue;
        rightChild = null;
        leftChild = null;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public T getKey() {
        return key;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setKey(T key) {
        this.key = key;
    }

}
