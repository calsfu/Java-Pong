import Gaming.GDV5;
import java.awt.Rectangle; 
import java.awt.Graphics2D; 
import java.awt.Color;
public class SmashBall extends Rectangle
{
    int dx = 1;
    int dy = -1;
    public SmashBall(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width; 
        this.height = height; 
    }
    public void update() {
        translate(dx,dy);
        if(y <= 0 || y + height >= 600) {
            dy*=-1;
        }
        
    }
}
