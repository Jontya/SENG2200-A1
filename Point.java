import java.lang.Math;
public class Point {

    private double x;
    private double y;

    public Point(double _x, double _y){
        x = _x;
        y = _y;
    }

    public double distanceFromOrigin(){ // Calculates a points distance from (0, 0)
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public String toString(){ // Clean string for a point "(x, y)"
        return "(" + String.format("%4.2f", x) + " , " + String.format("%4.2f", y) + ")" ;
    }

    public double getx(){
        return x;
    }

    public double gety(){
        return y;
    }

    public void setx(double _x){
        x = _x;
    }

    public void sety(double _y){
        y = _y;
    }
    
}
