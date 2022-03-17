public class MyPolygons{
    
    private int count;
    private Node sentinel;    
    private Node curr;

    public MyPolygons(){ // default constructor to create the sentinel node
        sentinel = new Node();
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);

        count = 0;
        curr = sentinel;
    }

    public void next(){ // Moves curr to the next node
        curr = curr.getNext();
    }

    public void resetCurrent(){ // Resets curr to the start of the list
        curr = sentinel;
    }

    public void prepend(Polygon newPoly){ // Adds to the head of list
        resetCurrent();
        Node temp = new Node(newPoly);
        if(count == 0){ // If list is empty (not including the sentinel)
            curr.setNext(temp); // Sets all of the links between the sentinel and new node
            curr.setPrev(temp);
            temp.setNext(curr);
            temp.setPrev(curr);
            count++; // Count increases by one
            next(); // Sets curr as the first node in the list
            return;
        }

        temp.setNext(curr.getNext()); // Sets all of links between the sentinel and previous head
        temp.setPrev(curr);
        curr.getNext().setPrev(temp);
        curr.setNext(temp);
        next(); // Sets curr as the first node in the list
        count++; // Count increases by one    
    }

    public void append(Polygon newPoly){ // Adds to the tail of list
        resetCurrent();
        Node temp = new Node(newPoly);
        if(count == 0){ // If list is empty (not including the sentinel)
            curr.setNext(temp); // Sets all of the links between the sentinel and new node
            curr.setPrev(temp);
            temp.setNext(curr);
            temp.setPrev(curr);
            next(); // Sets curr as the first node in the list
            count++; // Count increases by one
            return;
        }

        temp.setNext(curr); // Sets all of links between the sentinel and previous tail
        temp.setPrev(curr.getPrev());
        curr.getPrev().setNext(temp);
        curr.setPrev(temp);
        count++; // Count increases by one
        next(); // Sets curr as the first node in the list
        return;
        
    }

    public void remove(){ // Removes from head
        if(count == 0){ // If list is empty (excluding the sentinel) the method ends
            return;
        }

        resetCurrent();
        next();
        sentinel.setNext(curr.getNext()); // Sets new links
        curr.getNext().setPrev(sentinel);

        curr.setNext(null); // Sets links to null
        curr.setPrev(null);

        count--; // Count decreases by one
    }

    public void insert(Polygon data){ // Inserts a node before the current node
        if(curr == sentinel){ // If the target is the sentinel the function cancels 
            return;
        }
        Node temp = new Node(data); // Creates a new node
        temp.setNext(curr); // Sets all of the links between each node
        temp.setPrev(curr.getPrev());
        curr.getPrev().setNext(temp);
        curr.setPrev(temp);
        count++; // Count increases by one
    }

    public void insertInOrder(Polygon data){ // Inserts data in order based on the polygons area 
        if(count == 0){ // If the list is empty (not including the sentinel) the node is added to the head
            prepend(data);
            return;
        }
        resetCurrent();
        next();
        for(int i = 0; i < count; i++){ // Cycles through the list
            if(data.comesBefore(curr.getData())){ // Uses the comesBefore method to determine if the node should be placed before the current node
                insert(data);
                return;
            }
            else if(i+1 == count){ // If the new nodes area is larger than every other node in the list it is added to the tail
                append(data);
                return;
            }
            next(); // Moves the current node to the next node in the list
        }
    }

    public String print(){ // Returns a string to be printed with all polygons in a list
        String out = "";
        resetCurrent();
        next();
        for(int i = 0; i < count; i++){ // For each item
            out += curr.getData().toString(); // Adds the polygon data to the string
            next(); // Moves curr to the next node in the list
        }
        return out; // Returns the string
    }
}   
