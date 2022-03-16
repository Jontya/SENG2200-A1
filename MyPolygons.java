import javax.xml.crypto.Data;

public class MyPolygons{
    
    private int count;
    private Node sentinel;    
    private Node curr;

    public MyPolygons(){
        sentinel = new Node();

        count = 0;
        curr = null;
    }

    public class Node{
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

    public void prepend(Polygon newPoly){ // add to head
        curr = new Node(newPoly);
        if(count == 0){
            sentinel.setNext(curr);
            sentinel.setPrev(curr);
            curr.setNext(sentinel);
            curr.setPrev(sentinel);
            count++;
            return;
        }

        curr.setNext(sentinel.getNext());
        curr.setPrev(sentinel);
        sentinel.getNext().setPrev(curr);
        sentinel.setNext(curr);
        count++;        
    }

    public void append(Polygon newPoly){ // add to tail
        curr = new Node(newPoly);
        if(count == 0){
            sentinel.setNext(curr);
            sentinel.setPrev(curr);
            curr.setNext(sentinel);
            curr.setPrev(sentinel);
            count++;
            return;
        }

        curr.setNext(sentinel);
        curr.setPrev(sentinel.getPrev());
        sentinel.getPrev().setNext(curr);
        sentinel.setPrev(curr);
        count++;
        return;
        
    }

    public void insertBefore(Polygon data, Node target){
        if(target == sentinel){
            return;
        }
        curr = new Node(data);
        curr.setNext(target);
        curr.setPrev(target.getPrev());
        target.getPrev().setNext(curr);
        target.setPrev(curr);
        count++;
    }

    public void insertInOrder(Polygon data){
        if(count == 0){
            prepend(data);
            return;
        }
        curr = sentinel.getNext();
        for(int i = 0; i < count; i++){
            if(data.polygonArea() <= curr.getData().polygonArea()){
                insertBefore(data, curr);
                return;
            }
            else if(i+1 == count){
                append(data);
                return;
            }
            curr = curr.getNext();
        }
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
