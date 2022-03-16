import java.io.File;
import java.util.Scanner;

public class A1 {
    public static void main(String args[]) throws Exception{
        File data = new File(args[0]);
        Scanner scanner = new Scanner(data);

        MyPolygons l1 = new MyPolygons(); // Unsorted List
        MyPolygons l2 = new MyPolygons(); // Sorted List

        String polyData = ""; // Each polygon string is stored here
        
        while(scanner.hasNext()){ // While file still has content
            String next = scanner.next(); // Next token is stored
            char ch = next.charAt(0);
            if(ch == 80 && polyData.length() != 0){ // Checks for a "P"
                l1.append(new Polygon(polyData)); // Adds the previous data to both lists
                l2.insertInOrder(new Polygon(polyData));
                polyData = "";
            }
            else{
                if(ch != 80){
                    polyData += next + " "; // Adds next token to string
                }
                if(!scanner.hasNext()){ // Checks for the last token
                    l1.append(new Polygon(polyData)); // Adds last token to both lists
                    l2.insertInOrder(new Polygon(polyData));
                }
            }
        }
        
        // Prints output to console
        System.out.println("Unsorted list");
        System.out.print(l1.print());
        System.out.println("Sorted list");
        System.out.print(l2.print());
    }
}
