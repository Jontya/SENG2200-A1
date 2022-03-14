import java.lang.Math;
public class Point {

    private double xcord;
    private double ycord;

    public Point(double x, double y){
        xcord = x;
        ycord = y;
    }

    public double distanceFromOrigin(){
        return Math.sqrt(Math.pow((xcord - 0), 2) + Math.pow((ycord - 0), 2));
    }

    public String coordinatesString(){
        return "(" + String.format("%.2f", xcord) + " , " + String.format("%.2f", ycord) + ")" ;
    }

    public double getx(){
        return xcord;
    }

    public double gety(){
        return ycord;
    }
    
}
