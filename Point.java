public class Point {

    private double xcord;
    private double ycord;

    public Point(double x, double y){
        xcord = x;
        ycord = y;
    }

    public double distanceFromOrigin(){
        double distance = 0;
        return distance;
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
