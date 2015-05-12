package arrays;
import java.util.Arrays;
/**
 *
 * @author Vasia
 */
public class Square extends GeometricObject implements Comparable, Cloneable{
    
    private double side;

    
    @Override
    public Object clone(){
        Square square = new Square(side);
        square.color = new String(this.color);
        return square;
    }
    
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side*side;
    }
    
    public Square(double side){
        this.side = side;
    }
    
    @Override
    public String toString(){
        return "The length of the side is " + side;
    }
    
    
    public static void sort(Square[] arr) {
        Arrays.sort(arr);
    }
    
    public static void main(String[] args) throws CloneNotSupportedException {
        Square s1 = new Square(2);
        Square s2 = new Square(10);
        Square s3 = new Square(20);
        Square s4 = (Square)s2.clone();
        //Square s4 = s2;
        Square[] sqarr = {s2, s3, s1};
        sort(sqarr);
        
        
    }
    
    @Override
    public int compareTo(Object o) {
            double area1 = this.getArea();
            double area2 = ((Square)o).getArea();
            if(area1 > area2)
                return 1;
            if(area1 == area2)
                return 0;
            return -1;
    }

    @Override
    public double getPerimeter() {
        return side*4;
    }
    
    

}
