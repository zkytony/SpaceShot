package Donut;

//UNDERSTAND/////////////////BUT TRICKY/////////////

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;


public class Board extends JPanel{
	
	//The objects on the Board are either images 
	//or are drawn with the painting tools provided by the Java 2D API. 
	//In the next example, we draw a Donut. 
	//We use the painting API. 
    public void paint(Graphics g)
    {
      super.paint(g);

      Graphics2D g2 = (Graphics2D) g;
      
      //The Graphics2D object provides a 
      //sophisticated control over painting. 
      
      //The rendering hints are used to make the drawing smooth. 
      RenderingHints rh =
            new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                               RenderingHints.VALUE_ANTIALIAS_ON);

      rh.put(RenderingHints.KEY_RENDERING,
             RenderingHints.VALUE_RENDER_QUALITY);

      g2.setRenderingHints(rh);
      
      //We get the height and the width of the window. 
      Dimension size = getSize();
      double w = size.getWidth();
      double h = size.getHeight();

      //Here we create the ellipse.
      Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
      g2.setStroke(new BasicStroke(1));
      g2.setColor(Color.gray);

      //Here the ellispse is rotated 72 
      //times to create a "donut". 
      for (double deg = 0; deg < 360; deg += 5) {
          AffineTransform at =
              AffineTransform.getTranslateInstance(w / 2, h / 2);
          at.rotate(Math.toRadians(deg));
          g2.draw(at.createTransformedShape(e));
       }
    }
}
