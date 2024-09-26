
public class Node<T extends Comparable<? super T>> {

    private Node<T> leftnode, rightnode, parentnode;
    private T data;
    // Implement the constructor
    public Node(T data, Node<T> parentnode){
        this.data = data;
        this.parentnode = parentnode;
    }

    // Implement the setElement method
    public void setElement(T data) {
        this.data = data;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    // Implement the setLeft method
    public void setLeft(Node<T> node){
        this.leftnode = node;
    }

    // Implement the setRight method
    public void setRight(Node<T> node){
        this.rightnode = node;
    }

    public void setParent(Node<T> node){
        this.parentnode = node;
    }

    public Node<T> getParent(){
        return this.parentnode;
    }


    // Implement the getLeft method
    public Node<T> getLeft(){
        return this.leftnode;
    }

    // Implement the getRight method
    public Node<T> getRight(){
        return this.rightnode;
    }

    // Implement the getElement method
    public T getElement(){
        return this.data;
    }

    // Implement the isLeaf method
    public boolean isLeaf(){
        return this.leftnode == null && this.rightnode == null;
    }

    public boolean hasRight(){
        return (this.rightnode != null);
    }

    public boolean hasLeft(){
        return (this.leftnode != null);
    }
}



