package Sprite;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Missle {

    private int x, y;
    private Image image;
    boolean visible;

    private final int BOARD_WIDTH = 700;
    private final int MISSILE_SPEED = 10;
    
    
    //Methods of this class are just so well designed
    public Missle(int x, int y) {

        ImageIcon ii =
            new ImageIcon("missile.png");
        image = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
    }


    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    //The missile moves at constant speed. 
    //When it hits the right border of the Board, 
    //it becomes invisible. 
    //It is then removed from the ArrayList of missiles. 
    public void move() {
        x += MISSILE_SPEED;
        if (x > BOARD_WIDTH)
            visible = false;
    }
}
