import java.util.concurrent.Semaphore;

public class MyPolygons{
    
    private int count;
    private Node sentinel;    
    private Node curr;

    public MyPolygons(){ // default constructor to create the sentinel node
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

    public void moveCurrNext(){ // Moves curr to the next node
        curr = curr.getNext();
    }

    public void moveCurrPrev(){ // Moves curr to the prev node
        curr = curr.getPrev(); 
    }

    public void moveCurrStart(){
        curr = sentinel;
    }

    public void prepend(Polygon newPoly){ // Adds to the head of list
        curr = new Node(newPoly);
        if(count == 0){ // If list is empty (not including the sentinel)
            sentinel.setNext(curr); // Sets all of the links between the sentinel and new node
            sentinel.setPrev(curr);
            curr.setNext(sentinel);
            curr.setPrev(sentinel);
            count++; // Count increases by one
            return;
        }

        curr.setNext(sentinel.getNext()); // Sets all of links between the sentinel and previous head
        curr.setPrev(sentinel);
        sentinel.getNext().setPrev(curr);
        sentinel.setNext(curr);
        count++; // Count increases by one    
    }

    public void append(Polygon newPoly){ // Adds to the tail of list
        curr = new Node(newPoly);
        if(count == 0){ // If list is empty (not including the sentinel)
            sentinel.setNext(curr); // Sets all of the links between the sentinel and new node
            sentinel.setPrev(curr);
            curr.setNext(sentinel);
            curr.setPrev(sentinel);
            count++; // Count increases by one
            return;
        }

        curr.setNext(sentinel); // Sets all of links between the sentinel and previous tail
        curr.setPrev(sentinel.getPrev());
        sentinel.getPrev().setNext(curr);
        sentinel.setPrev(curr);
        count++; // Count increases by one
        return;
        
    }

    public void removeFromHead(){ // Removes from head
        if(count == 0){ // If list is empty (excluding the sentinel) the method ends
            return;
        }

        curr = sentinel.getNext();
        sentinel.setNext(curr.getNext()); // Sets new links
        curr.getNext().setPrev(sentinel);

        curr.setNext(null); // Sets links to null
        curr.setPrev(null);

        count--; // Count decreases by one
    }

    public void removeFromTail(){ // Removes from tail
        if(count == 0){ // If list is empty (excluding the sentinel) the method ends
            return;
        }

        curr = sentinel.getPrev();
        sentinel.setPrev(curr.getPrev()); // Sets new links
        curr.getPrev().setNext(sentinel);
        
        curr.setNext(null); // Sets links to null
        curr.setPrev(null);

        count--; // Count decreases by one
    }

    public void insertBefore(Polygon data, Node target){ // Inserts a node before a target node
        if(target == sentinel){ // If the target is the sentinel the function cancels 
            return;
        }
        curr = new Node(data); // Creates a new node
        curr.setNext(target); // Sets all of the links between each node
        curr.setPrev(target.getPrev());
        target.getPrev().setNext(curr);
        target.setPrev(curr);
        count++; // Count increases by one
    }

    public void insertAfter(Polygon data, Node target){ // Inserts a node after a target node
        if(target == sentinel){ // If the target is the sentinel the function cancels 
            return;
        }
        curr = new Node(data); // Creates a new node
        curr.setNext(target.getNext()); // Sets all of the links between each node
        curr.setPrev(target);
        target.getNext().setPrev(curr);
        target.setNext(curr);
        count++; // Count increases by one
    }

    public void insertInOrder(Polygon data){ // Inserts data in order based on the polygons area 
        if(count == 0){ // If the list is empty (not including the sentinel) the node is added to the head
            prepend(data);
            return;
        }
        moveCurrStart();
        moveCurrNext();
        for(int i = 0; i < count; i++){ // Cycles through the list
            if(data.comesBefore(curr.getData())){ // Uses the comesBefore method to determine if the node should be placed before the current node
                insertBefore(data, curr);
                return;
            }
            else if(i+1 == count){ // If the new nodes area is larger than every other node in the list it is added to the tail
                append(data);
                return;
            }
            moveCurrNext(); // Moves the current node to the next node in the list
        }
    }

    public String print(){ // Returns a string to be printed with all polygons in a list
        String out = "";
        curr = sentinel.getNext();
        for(int i = 0; i < count; i++){ // For each item
            out += curr.getData().polygonString(); // Adds the polygon data to the string
            moveCurrNext(); // Moves curr to the next node in the list
        }
        return out; // Returns the string
    }
}   
