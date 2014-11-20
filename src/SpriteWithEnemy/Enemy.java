package SpriteWithEnemy;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;



public class Enemy {
	
	private int x = 800;
	private int y = 350;
	private int speed;
 	private Image enemy;
 	private int width;
 	private int height;
 	private boolean visible;
 	private int type;
 	
 	private int armorIncrease = 2;
 	private int armorLevel;
 	private ArrayList<EnemyMissile> missiles = new ArrayList<EnemyMissile>();
	
	public Enemy(int x, int y, int type) {
		this.type = type;
		this.x = x;
		this.y = y;
		
		if (type == 1) { 
			enemy = new ImageIcon("enemy.png").getImage();
			speed = (int) ((int)10 * Math.random());
			speed = checkSpeed(speed);
			setArmorLevel(1);
		} else if (type == 2) {
			enemy = new ImageIcon("enemy2.png").getImage();
			speed= (int) ((int)5 * Math.random());
			speed = checkSpeed(speed);
			setArmorLevel(2);
		}else if (type == 3) {
			enemy = new ImageIcon("enemy3.png").getImage();
			speed= (int) ((int)7 * Math.random());
			speed = checkSpeed(speed);
			setArmorLevel(3);
			fire();
		}
		width = enemy.getWidth(null);
		height = enemy.getHeight(null);
        visible = true;
	}
	
	private int checkSpeed(int s) {
		if (s == 0) {
			s = 1;
		}
		return s;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return enemy;
	}
	
	public Rectangle getBoard() {
		return new Rectangle(x, y, width, height);
	}
	
	public void move() {
		
		if (x <= 0) {
			x = 1500;
			if (type == 1) {
				speed = (int) ((int)10 * Math.random());
			} else if (type == 2) {
				speed = (int) ((int)5 * Math.random());
			} else if (type == 3) {
				speed = (int) ((int)7 * Math.random());
			}
		}
		x -= speed;
	}
	
	public int getArmorLevel() {
		return armorLevel;
	}
	
	public void setArmorLevel(int type) {
		switch (type) {
			case 1:
				armorLevel = 1;
				break;
			case 2:
				armorLevel = 3;
				break;
			case 3:
				armorLevel = 2;
				break;
		}
	}
	
	public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    
    public int getType() {
    	return type;
    }
    public void fire() {
    	missiles.add(new EnemyMissile(x, y + height/2));
    	try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public ArrayList<EnemyMissile> getMissiles() {
    	return missiles;
    }

}
