import java.io.File;
import java.util.Scanner;

public class A1 {

    private static String filename; 
    private MyPolygons l1 = new MyPolygons(); // Unsorted List
    private MyPolygons l2 = new MyPolygons(); // Sorted List

    public static void main(String args[]) throws Exception{

        // Checks to see if file name exists
        try{
            filename = args[0];
            A1 polygons = new A1();
            polygons.readFile();
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Missing Filename Argument");
        }
    }

    public void readFile() throws Exception{
        File file = new File(filename);
        if(!file.exists()){
            System.out.println("File Not Found");
            return;
        }
        
        Scanner scanner = new Scanner(file);
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

        System.out.println("Unsorted list\n" + l1.print() + "Sorted list\n" + l2.print());
    }
}

