
import Gaming.GDV5;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Paddles extends Rectangle   {
    //0 = left
    // 1 = right
    int side;
    int dy = 8;
    public Paddles (int x ,int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width; 
        this.height = height; 
        
    }
    public void setLeft() {
        side = 0;
    }
    public void setRight() {
        side = 1;
    }
    public void resetSpeed() {
        dy = 8;
    }
    public void speed() {
        dy = 12;
    }
    public void move() {
        if(GDV5.KeysPressed[87] && y>0 && side == 0) {
            translate(0,-dy);
        }
        if (GDV5.KeysPressed[83] && y + height < 600 && side == 0) {
            translate(0,dy);
        }
        if (GDV5.KeysPressed[38] && y>0 && side == 1) {
            translate(0,-dy);
        }
        if (GDV5.KeysPressed[40]  && y + height < 600 && side == 1) {
            translate(0,dy);
        }
    }   
    public static void main(String[] args) {
        
    }
}