package Image;

//UNDERSTAND/////////////////
	//When we create computer games, we often work with images. In the next example we load an image and display it on the Board. 

	//Board.java

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
	  Image bardejov;
	    
	  public Board() {
		  /*//We create an ImageIcon
	     ImageIcon ii = new ImageIcon(this.getClass().getResource("redsquare.jpg"));
	     //We get an Image out of the ImageIcon. 
	     bardejov = ii.getImage();*/
		  
		 bardejov = new ImageIcon("redsquare.jpg").getImage();
	  }

	  public void paint(Graphics g) {
		 //We draw the image on the window
	     Graphics2D g2d = (Graphics2D) g;
	     g2d.drawImage(bardejov, 10, 10, null); 
	  }
}
	


