public class Node{
    private Polygon data;
    private Node next;
    private Node prev;

    public Node(){
        data = null;
    }

    public Node(Polygon _data){
        data = _data;
    }

    public Node getNext(){
        return next;
    }

    public Node getPrev(){
        return prev;
    }

    public Polygon getData(){
        return data;
    }

    public void setNext(Node _next){
        next = _next;
    }

    public void setPrev(Node _prev){
        prev = _prev;
    }
}
