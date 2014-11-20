package SpriteWithEnemy;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class AppThread extends JFrame {
	private GraphicsDevice vc;
	private Board bd = new Board();

    public AppThread() {
    	
    	try {
    		add(bd);
    		getKeyListeners();
    		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    		vc = env.getDefaultScreenDevice();
    		this.setResizable(false);
    		this.setUndecorated(true);
    		vc.setFullScreenWindow(this);
    		//vc.setDisplayMode(dm);
    		
    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		setResizable(false);
            setVisible(true);
            
            if (!bd.getGameStatus()) {
            	Window w = vc.getFullScreenWindow();
    			
    			if ( w != null) {
    				//free resources;
    				w.dispose();
    			}
    			vc.setFullScreenWindow(null);
    			System.out.println("END");
            }
            /*
            if (bd.getGameStatus() == false) {
    			Window w = vc.getFullScreenWindow();
    			
    			if ( w != null) {
    				//free resources;
    				w.dispose();
    			}
    			vc.setFullScreenWindow(null);
    		}*/
    	} catch(Exception ex) {}

    }

   public void keyPressed(KeyEvent e) {
   	   int code = e.getKeyCode();
   	   if (code == KeyEvent.VK_B) {
   		   Window w = vc.getFullScreenWindow();
   			if ( w != null) {
   				//free resources;
   				w.dispose();
   			}
    		 	vc.setFullScreenWindow(null);
   	   }
       
    }
    public static void main(String[] args) {
        new AppThread();
    }
}
