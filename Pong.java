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
import java.awt.Font;

public class Pong extends GDV5 
{   
    Ball ball = new Ball(200,100,10,10);
    Paddles left = new Paddles(100,400,10,50); 
    Paddles right = new Paddles(700,400,10,50);
    SmashBall smashBall = new SmashBall(200,100,75,75);
    boolean smashed = false;
    String title = "Pong";
    int start = 0;
    int page = 0;
    int running = 0;
    boolean smashOn;
    public  Pong() {
        left.setLeft();
        right.setRight();
    }
    public void splash(Graphics2D win) {
        win.setColor(Color.WHITE);
        win.setFont(new Font("Dialog", Font.BOLD, 50));
        win.drawString("Pong", 340, 100);
        win.drawString("Press 1 for Single Player", 175, 300);
        win.drawString("Press 2 for Multiplayer", 175, 400);
        win.drawString("Controls",0,530);
        win.setFont(new Font("Dialog", Font.BOLD, 20));
        win.drawString("Left Side: W and S to move",0,550);
        win.drawString("Right Side: Up and Down Arrowkeys to move",0,570);
    }
    public void scoreboard(Graphics2D win) {
        win.setColor(Color.WHITE);
        win.setFont(new Font("Dialog", Font.BOLD, 50));
        win.drawString("Score", 325,45);
        String leftScore = String.valueOf(ball.leftScore);
        String rightScore = String.valueOf(ball.rightScore);
        win.drawString(leftScore + "-" + rightScore, 360, 100);
    }
    public void checkWinner() {
        if (ball.leftScore == 5) {
            page= 2;
            start = 0;
            running = 0;
        }
        if (ball.rightScore == 5) {
            page = 2;
            start = 0;
            running = 0;
        }
    }
    public void startGame() {
        if (KeysPressed[50] && running == 0) {
            start = 1;
            page = 1;
            running = 1;
            ball.rightScore = 0;
            ball.leftScore = 0;
        }
        if (KeysPressed[49] && running == 0) {
            start = 2;
            page = 1;
            running = 1;
            ball.rightScore = 0;
            ball.leftScore = 0;
        }
    }
    public void checkIntersect() {
        if (ball.intersects(left) || ball.intersects(right)) {
                ball.paddleContact();
        }
        if (ball.intersects(smashBall)) {
            smashed = true;
        }
    }
    public void update() {
        startGame();
        System.out.println(start);
        if (start == 1) {
            ball.update();
            right.move();
            left.move();
            checkIntersect();
            checkWinner();
        }
        if (start == 2) {
            ball.update();
            left.move();
            checkIntersect();
            checkWinner();
            if (ball.y > right.y) {
                right.translate(0,8);
            }
            if (ball.y < right.y) {
                right.translate(0,-8);
            }
        }
        if (smashOn) {
            smashBall.update();
        }
        if (smashed) {
            if(ball.dx > 0) {
                left.speed();
            }
            else {
                right.speed();
            }
            smashed = false;
        }
        if(ball.scored) {
            left.resetSpeed();
            right.resetSpeed();
        }
    }
    public void draw(Graphics2D win) {
        if (page == 0) {
            splash(win);
        }
        if (page == 1) {
            scoreboard(win);
            ball.draw(win);
            win.fill(ball);
            win.setColor(Color.WHITE);
            win.fill(left);
            win.fill(right);
            if(ball.rightScore + ball.leftScore >= 6 && !smashed) {
                win.fill(smashBall);
                smashOn = true;
            }
        }
        if (page ==2) { 
            scoreboard(win);
            win.setColor(Color.WHITE);
            win.fill(ball);
            win.fill(left);
            win.fill(right);
            win.setFont(new Font("Dialog", Font.BOLD, 50));
            if(ball.rightScore == 5) {
                win.drawString("Right Wins", 200, 200); 
            }
            else {
                win.drawString("Left Wins", 175, 200); 
            }
            win.drawString("Press 1 to play again", 175, 300); 
        }
    }
    public static void main(String args[])
    {
        Pong p1 = new Pong(); 
        p1.start();
        
        //enter keycode is 13
        }
}
