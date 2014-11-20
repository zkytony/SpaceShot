package SpriteWithEnemy;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Craft craft;
    private int width = 800;
    private int height = 700;
    private ArrayList<Missle> msl = new ArrayList<Missle>();
    private ArrayList<EnemyMissile> emsl = new ArrayList<EnemyMissile>();
    private boolean ingame;
    private int num1 = 15;
    private int num2 = 5;
    private int num3 = 10;
    //to cumulate the time being hit;
    //Most tricky place. Have to use the array to keep 
    //track of the number of hits of each flying
    int[] cum = new int[num1 + num2 + num3];
    //These are initial positions of alien ships.
    private int[] startY1 = new int[num1];
    private int[] startX1 = new int[num1];
    private int[] startY2 = new int[num2];
    private int[] startX2 = new int[num2];
    private int[] startY3 = new int[num3];
    private int[] startX3 = new int[num3];
    
    private ArrayList<Enemy> enemy = new ArrayList<Enemy>();
    
    public Board() {
    	
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        ingame = true;

        for (int i = 0; i < num1; i++) {
    		startY1[i] = randomInt(10, 600);
    		startX1[i] = randomInt(1500, 2500);
    	}
        
        for (int i = 0; i < num2; i++) {
    		startY2[i] = randomInt(10, 600);
    		startX2[i] = randomInt(1500, 2500);
    	}
        
        for (int i = 0; i < num3; i++) {
    		startY3[i] = randomInt(10, 600);
    		startX3[i] = randomInt(1500, 2500);
    	}
        
        craft = new Craft();
        initEnemies();
        
        timer = new Timer(5, this);
        timer.start();
    }
    
    public void initEnemies() {
    	
    	for (int i = 0; i < startY1.length; i++) {
    		enemy.add(new Enemy(startX1[i], startY1[i], 1));
    	}
    	for (int i = 0; i < startY2.length; i++) {
    		enemy.add(new Enemy(startX2[i], startY2[i], 2));
    	}
    	for (int i = 0; i < startY3.length; i++) {
    		enemy.add(new Enemy(startX3[i], startY3[i], 3));
    	}
    }


    public void paint(Graphics g) {
        super.paint(g);
        
        if (ingame) {
	        //In the paint() method, we draw the spacecraft. 
	        //We get the image and the coordinates from the 
	        //sprite class. 
	        Graphics2D g2d = (Graphics2D)g;
	        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
	        
	        msl = craft.getMissiles();
	        for (int i = 0; i < enemy.size(); i++) {
	        	Enemy e = enemy.get(i);
	        	emsl = enemy.get(i).getMissiles();
	        }
	        
	        //How many times you press space 
	        //will give you that many missiles
	        for (int i = 0; i < msl.size(); i++ ) {
	            Missle m = msl.get(i);
	            g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
	        }
	        
	        //The paint() method draws all aliens from the aliens ArrayList. 
	        //They are drawn only if they have not been previously destroyed. 
	        //This is checked by the isVisible() method. 
	        for (int i = 0; i < enemy.size(); i++) {
	        	Enemy e = enemy.get(i);
	        	if (e.isVisible()){
	        		g2d.drawImage(e.getImage(), e.getX(), e.getY(), this);
	        	} else enemy.remove(i);
	        }
	        
	        for (int i = 0; i < emsl.size(); i++ ) {
	            EnemyMissile em = emsl.get(i);
	            g2d.drawImage(em.getImage(), em.getX(), em.getY(), this);
	        }
        }//If game is over
        else {
	            String msg = "Game Over";
	            Font small = new Font("Helvetica", Font.BOLD, 14);
	            FontMetrics metr = this.getFontMetrics(small);

	            g.setColor(Color.white);
	            g.setFont(small);
	            g.drawString(msg, (width - metr.stringWidth(msg)) / 2,
	                         height / 2);
	        }

	
	
	        Toolkit.getDefaultToolkit().sync();
	        g.dispose();
    }

    /**
     * Interesting logic:
     * when the key is not pressed, 
     * dy and dx = 0;
     * so the move method cannot change the coordinate of the craft;
     */
    
    //In the actionPerformed() method we parse all missiles 
    //from the array list. Depending on the visible flag, 
    //we move the missile or remove it from the container.
    public void actionPerformed(ActionEvent e) {
    	
    	if(enemy.size() == 0) {
    		ingame = false;
    	}
    	
    	for (int i = 0; i < msl.size(); i++) {
            Missle m = msl.get(i);
            if (m.isVisible()) 
                m.move();
            else msl.remove(i);
        }
    	
    	for (int i = 0; i < enemy.size(); i++) {
    		Enemy en = enemy.get(i);
    		if (en.isVisible()) {
    			en.move();
    		}
    	}
    	
    	for (int i = 0; i < emsl.size(); i++) {
            EnemyMissile em = emsl.get(i);
            if (em.isVisible()) 
                em.move();
            else emsl.remove(i);
        }

        craft.move();
        checkCollisions();
        repaint();  
    }
    
    public void checkCollisions() {

        Rectangle r3 = craft.getBoard();

        for (int j = 0; j < enemy.size(); j++) {
            Enemy en = enemy.get(j);
            Rectangle r2 = en.getBoard();

            if (r3.intersects(r2)) {
                craft.setVisible(false);
                en.setVisible(false);
                ingame = false;
            }
        }
        
        
        for (int i = 0; i < msl.size(); i++) {
            Missle m = msl.get(i);

            Rectangle r1 = m.getBoard();
            
            for (int j = 0; j < enemy.size(); j++) {
                Enemy en = enemy.get(j);
                Rectangle r2 = en.getBoard();
                if (r1.intersects(r2)) {
                	m.setVisible(false);
                	cum[j]++;
                	if (cum[j] >= en.getArmorLevel()) {
                		en.setVisible(false);
                	}
                }
            }
        }
        
        for (int i = 0; i < emsl.size(); i++) {
        	EnemyMissile em = emsl.get(i);
        	Rectangle r4 = em.getBoard();
        	
        	 if (r3.intersects(r4)) {
                 craft.setVisible(false);
                 em.setVisible(false);
                 ingame = false;
             }
        }
    }

    private int randomInt(int min, int max) {
		Random rand = new Random();
		
		//Why we need to +1?
		//Because originally, it gets [min, max), 
		//which does not include the max
		//After adding 1, the range becomes [min, max+1);
		//Since it only returns integers, the biggest integer will be max;
		
		int get = rand.nextInt((max - min) + 1) + min;
		return get;
	}
    
    public boolean getGameStatus() {
    	return ingame;
    }
    
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }

}

