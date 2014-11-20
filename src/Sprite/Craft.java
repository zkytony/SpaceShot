package Sprite;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

//This class represents a spacecraft. 
//In this class we keep the image of 
//the sprite and the coordinates of the sprite. 
//The keyPressed() and keyReleased() methods control 
//whether the sprite is moving or is in standstill. 
public class Craft {

    private String craft = "craft.bmp";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    private int width = 67;
    private int height = 64;
    
    //Since it can have multiple missiles at a time;
    private ArrayList<Missle> missiles = new ArrayList<Missle>();
    
    public Craft() {
    	ImageIcon ii = new ImageIcon("craft.png");
    	image = ii.getImage();
        x = 40;
        y = 60;
    }


    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
    
    public void fire() {
    	missiles.add(new Missle(x + width, y + height/2));
    }
    
    public ArrayList<Missle> getMissiles() {
    	return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
       
        if (key == KeyEvent.VK_SPACE) {
            fire();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        //When we release the left cursor key, 
        //we set the dx variable to zero. 
        //The spacecraft will stop moving. 
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}

