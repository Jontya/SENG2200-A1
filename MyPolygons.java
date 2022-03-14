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

    public void prepend(Polygon newPoly){
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

    public void append(Polygon newPoly){
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

    public void insert(Polygon data, Node target){
        curr = sentinel.getNext();
        while(curr != target || curr != sentinel){
            curr = curr.getNext();
        }
        if(curr == sentinel){
            System.out.println("Not Found");
            return;
        }
        Node newNode = new Node(data);
        newNode.setNext(curr);
        newNode.setPrev(curr.getPrev());
        curr.getPrev().setNext(newNode);
        curr.setPrev(newNode);
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
