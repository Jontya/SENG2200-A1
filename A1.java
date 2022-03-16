import java.io.File;
import java.util.Scanner;

public class A1 {
    public static void main(String args[]) throws Exception{
        File data = new File(args[0]);
        Scanner scanner = new Scanner(data);

        MyPolygons l1 = new MyPolygons();
        MyPolygons l2 = new MyPolygons();

        String polyData = "";
        
        while(scanner.hasNext()){
            String next = scanner.next();
            char ch = next.charAt(0);
            if(ch == 80 || ch == 112 && polyData.length() != 0){
                l1.append(new Polygon(polyData));
                l2.insertInOrder(new Polygon(polyData));
                polyData = "";
            }
            else{
                if(ch != 80 && ch != 112){
                    polyData += next + " ";
                }
                if(!scanner.hasNext()){
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
