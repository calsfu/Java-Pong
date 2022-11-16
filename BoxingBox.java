
import Gaming.GDV5;
import java.awt.Rectangle; 
import java.awt.Graphics2D; 
import java.awt.Color;

public class BoxingBox extends GDV5 {
    Rectangle r1 = new Rectangle(300,400,50,50);
    int a = 1;
    int b = -1;
    boolean colorChange;
    Color color = newColor();
    
    public static Color newColor(){
        int R = (int)(Math.random() * 255);
        int G = (int) (Math.random() * 255);
        int B = (int)(Math.random() * 255);
        Color colorChange = new Color(R,G,B);
        return colorChange;
    }
    public void update() {
        r1.translate(a, b);
        double width = r1.getWidth();
        double height = r1.getHeight();
        double x = r1.getX();
        double y = r1.getY();
        
        if(x == 0 || x + width == 800) {
            a*= -1;
            color = newColor();
        }
        if (y == 0 || y + height == 600) {
            b *=-1;
            color = newColor();
        }
    }
    public void draw (Graphics2D win) {
        win.setColor(color);
        win.fill(r1);
    }
    
    public static void main(String[] args) {
        BoxingBox b1 = new BoxingBox(); 
        b1.start();
    }
}