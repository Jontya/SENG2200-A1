import java.lang.Math;

interface ComparePoly { 
    boolean ComesBefore(Polygon o); // true if this < param 
}

public class Polygon implements ComparePoly{

    private Point[] points;
    private int sides;

    public Polygon(String data){
        String[] arr = data.split("\\s");
        sides = Integer.parseInt(arr[0]);
        points = new Point[sides];
        int x = 1;
        for(int i = 0; i < sides; i++){
            points[i] = new Point(Double.parseDouble(arr[x]), Double.parseDouble(arr[x+1]));
            x += 2;
        }
    }

    public int getSides(){
        return sides;
    }

    public boolean ComesBefore(Polygon poly){
        if(poly.polygonArea() < polygonArea()){
            return true;
        }
        return false;
    }
    
    public String polygonString(){
        String polygon = "[";
        for(int i = 0; i < points.length; i++){
            polygon = polygon + points[i].coordinatesString() + " ";
        }
        polygon = polygon + "]: " + String.format("%.2f", polygonArea()) + "\n";
        return polygon;
    }

    public double polygonArea(){
        double area = 0;
        int j = sides - 1;
        for(int i = 0; i < sides; i++){
            area += (points[j].getx() + points[i].getx()) * (points[j].gety() - points[i].gety());
            j = i;
        }
        area = Math.abs(area / 2);
        return area;
    }

    public double distanceFromOrigin(){
        double distance = 0;
        for(int i = 0; i < points.length; i++){
            double temp = Math.sqrt(Math.pow((points[i].getx() - 0), 2) + Math.pow((points[i].gety() - 0), 2));
            if(temp < distance || i == 0){
                distance = temp;
            }
        }
        return distance;
    }
}