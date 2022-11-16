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


public class RightPaddle extends Rectangle {
    public RightPaddle (int x ,int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width; 
        this.height = height; 
    }
    public void move() {
        if (GDV5.KeysPressed[38] && y>0) {
            translate(0,-2);
        }
        if (GDV5.KeysPressed[40]  && y + height < 600) {
            translate(0,2);
        }
    }
    
    public static void main(String[] args) {
        
    }
}