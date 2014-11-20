package swingTimer;

//UNDERSTAND/////////////////

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    Image star;
    Timer timer;
    int x, y;

    public Board() {
        setBackground(Color.BLACK);

        
        star = new ImageIcon("enemy.png").getImage();
        //Our JPanel component will use a buffer to paint. 
        //This means that all drawing will be done 
        //in memory first. Later the off-screen buffer will be 
        //copied to the screen. 
        //In this example, I didn't notice any differences. 
        setDoubleBuffered(true);

        x = y = 10;
        //Here we create a Swing Timer class. 
        //We start the timer.
        //Every 25 ms the timer will call 
        //the actionPerformed() method. 
        //In order to use the actionPerformed() method, 
        //we must implement the ActionListener interface. 
        timer = new Timer(25, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    //Every 25 ms the timer will call 
    //the actionPerformed() method. 
    public void actionPerformed(ActionEvent e) {
 
        x += 1;
        y += 1;

        if (y > 240) {
            y = -45;
            x = -45;
        }
        repaint();  
    }
}
