package Sprite;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Craft craft;
    private ArrayList<Missle> msl = new ArrayList<Missle>();

    public Board() {
    	
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        craft = new Craft();

        timer = new Timer(5, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);
        //In the paint() method, we draw the spacecraft. 
        //We get the image and the coordinates from the 
        //sprite class. 
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        
        msl = craft.getMissiles();
        
        //How many times you press space 
        //will give you that many missiles
        for (int i = 0; i < msl.size(); i++ ) {
            Missle m = msl.get(i);
            g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
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
    	
    	for (int i = 0; i < msl.size(); i++) {
            Missle m = msl.get(i);
            if (m.isVisible()) 
                m.move();
            else msl.remove(i);
        }

        craft.move();
        repaint();  
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

