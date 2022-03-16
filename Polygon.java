import java.lang.Math;

interface ComparePoly { 
    boolean comesBefore(Polygon o);
}

public class Polygon implements ComparePoly{

    // Array of points and the number of sides
    private Point[] points;
    private int sides;

    public Polygon(String data){ // Constructor
        String[] arr = data.split("\\s"); // Splits each token into an array
        sides = Integer.parseInt(arr[0]); // Number of sides will always be first
        points = new Point[sides]; // Resized array to hold all of the points
        int x = 1;
        for(int i = 0; i < sides; i++){
            points[i] = new Point(Double.parseDouble(arr[x]), Double.parseDouble(arr[x+1])); // Stores each point in the array
            x += 2;
        }
    }

    public int getSides(){
        return sides;
    }

    public boolean comesBefore(Polygon poly){ // Checks if a polygon should come before another (used for the sorted list)
        double numerator = (Math.abs(poly.polygonArea() - polygonArea()));
        double denominator = (poly.polygonArea() + polygonArea() / 2); // Equation to find the difference as a percent
        double percentDifference = (numerator / denominator) * 100;
        if(percentDifference > 0.1 && polygonArea() < poly.polygonArea()){ // if the percent difference is > 0.1% and the the polygon in question is less than the target 
            return true; // returns true
        }
        else if(percentDifference <= 0.1){ // If polygons percent difference is < 0.1%
            if(distanceFromOrigin() < poly.distanceFromOrigin()){ // And the target polygons distance from (0,0) is < the target
                return true; // Returns true
            }
        }
        return false;
    }
    
    public String polygonString(){ // Puts all of the points into a readable string along with the polygons area
        String polygon = "[";
        for(int i = 0; i < points.length; i++){
            polygon = polygon + points[i].coordinatesString() + " ";
        }
        polygon = polygon + "]: " + String.format("%.2f", polygonArea()) + "\n";
        return polygon;
    }

    public double polygonArea(){ // Calculates the polygons area
        double area = 0;
        int j = sides - 1;
        for(int i = 0; i < sides; i++){
            area += (points[j].getx() + points[i].getx()) * (points[j].gety() - points[i].gety()); // Equation to get the area
            j = i;
        }
        area = Math.abs(area / 2); // Absolute value of the area / 2
        return area;
    }

    public double distanceFromOrigin(){ // Calculates the closest point from (0, 0)
        double distance = 0;
        for(int i = 0; i < points.length; i++){
            double temp = Math.sqrt(Math.pow((points[i].getx() - 0), 2) + Math.pow((points[i].gety() - 0), 2)); // Equation to get the distance
            if(temp < distance || i == 0){
                distance = temp;
            }
        }
        return distance;
    }
}