
import Gaming.GDV5;
import java.awt.Rectangle; 
import java.awt.Graphics2D; 
import java.awt.Color;

public class Ball extends Rectangle{
    int dx = 5;
    int dy = -5;
    int leftScore = 0;
    int rightScore = 0;
    int bounces = 0;
    int counter = 0;
    boolean scored;
    boolean reset;
    Color color = newColor();
    public Ball(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width; 
        this.height = height; 
    }
    public void reset() {
        x = 400;
        y = 300;
        scored = false;
        reset = true;
        dy = 0;
    }
    public void paddleContact() {
        if(dx > 0) {
            x -= dx;
            
        }
        else {
            x -= dx;
            
        }
        if(reset) {
            dy = 5;
            reset = false;
        }
        dx *=-1;
        bounces++;
        color = newColor();
    }
    public void update() {
        translate(dx,dy);
        if(y <= 0 || y + height >= 600) {
            dy*=-1;
        }
        if (x + width >= 800) {
                leftScore += 1;
                scored = true;
                reset();
                bounces++;
            }
        if (x <= 0) {
            rightScore += 1;
            reset();
        }
        if (bounces % 5 == 0 && bounces != 0) {
           if(dx > 0) {
               dx++;
            }
           else {
               dx--;
            }
           if(dy>0) {
                dy++;
           }
           else {
                dy--;
           }
           bounces = 0;
           counter++;
        }
    }
    public void draw(Graphics2D win) {
        win.setColor(color);
        
    }
    public static Color newColor(){
        int R;
        int G;
        int B;
        do {
            R = (int)(Math.random() * 255);
            G = (int) (Math.random() * 255);
            B = (int)(Math.random() * 255);
        } while (R < 80 ||  G < 80 ||  B < 80);
        Color colorChange = new Color(R,G,B);
        return colorChange;
    }
    public static void main(String[] args) {
        
    }
}