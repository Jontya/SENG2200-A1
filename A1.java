import java.io.File;
import java.util.Scanner;

public class A1 {
    public static void main(String args[]) throws Exception{
        File data = new File(args[0]);
        Scanner scnr = new Scanner(data);

        MyPolygons l1 = new MyPolygons();
        MyPolygons l2 = new MyPolygons();

        String polyData = "";
        
        while(scnr.hasNext()){
            String next = scnr.next();
            char ch = next.charAt(0);
            if(ch == 80 && polyData.length() != 0){
                l1.append(new Polygon(polyData));
                l2.insertInOrder(new Polygon(polyData));
                polyData = "";
            }
            else{
                if(ch != 80){
                    polyData += next + " ";
                }
                if(!scnr.hasNext()){
                    l1.append(new Polygon(polyData));
                    l2.insertInOrder(new Polygon(polyData));
                }
            }
        }
        
        System.out.println("Unsorted list");
        System.out.print(l1.print());
        System.out.println("Sorted list");
        System.out.print(l2.print());

    }
}
