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

public class LeftPaddle extends Rectangle   {
    public LeftPaddle (int x ,int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width; 
        this.height = height; 
    }
    public void move() {
        if(GDV5.KeysPressed[87] && y>0) {
            translate(0,-1);
        }
        if (GDV5.KeysPressed[83] && y + height < 600) {
            translate(0,1);
        }
        
    }
    public static void main(String[] args) {
        
    }
}