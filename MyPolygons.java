
public class MyPolygons {
    
    private int count;
    private Node sentinel;    
    private Node curr;

    public MyPolygons(){
        sentinel = new Node();

        count = 0;
        curr = null;
    }

    private class Node{
        private Polygon data;
        private Node next;
        private Node prev;

        public Node(){
            data = null;
            next = sentinel;
            prev = sentinel;
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

    public void prepend(Polygon newPoly){
        Node newNode = new Node(newPoly);
        if(count == 0){
            sentinel.setNext(newNode);
            sentinel.setPrev(newNode);
            newNode.setNext(sentinel);
            newNode.setPrev(sentinel);
            count++;
            return;
        }

        newNode.setNext(sentinel.getNext());
        newNode.setPrev(sentinel);
        sentinel.getNext().setPrev(newNode);
        sentinel.setNext(newNode);
        count++;        
    }

    public void append(Polygon newPoly){
        Node newNode = new Node(newPoly);
        if(count == 0){
            sentinel.setNext(newNode);
            sentinel.setPrev(newNode);
            newNode.setNext(sentinel);
            newNode.setPrev(sentinel);
            count++;
            return;
        }

        newNode.setNext(sentinel);
        newNode.setPrev(sentinel.getPrev());
        sentinel.getPrev().setNext(newNode);
        sentinel.setPrev(newNode);
        count++;
        return;
        
    }

    public void insert(double area){
    }

    public String print(){
        String out = "";
        curr = sentinel.getNext();
        for(int i = 0; i < count; i++){
            out += curr.getData().polygonString();
            curr = curr.getNext();
        }
        return out;
    }
}   
