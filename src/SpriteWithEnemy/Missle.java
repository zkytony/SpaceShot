package SpriteWithEnemy;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missle {

    private int x, y;
    private int height;
    private int width;
    private Image image;
    boolean visible;

    private final int BOARD_WIDTH = 2000;
    private final int MISSILE_SPEED = 10;
    
    
    //Methods of this class are just so well designed
    public Missle(int x, int y) {

        ImageIcon ii =
            new ImageIcon("missile.png");
        image = ii.getImage();
        visible = true;
        width = image.getWidth(null);
        height = image.getHeight(null);

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
    
    public Rectangle getBoard() {
    	return new Rectangle(x, y, width, height);
    }
    
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

}
