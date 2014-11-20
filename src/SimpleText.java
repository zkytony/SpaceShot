/*
 * File: SimpleText.java;
 * -----------------------------
 * This is an applet that simply display a text on the screen;
 */

import javax.swing.*;
import java.awt.*;

public class SimpleText extends JApplet {
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("GOOD! ", 50, 50);
	}
}
