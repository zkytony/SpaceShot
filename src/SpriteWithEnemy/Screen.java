package SpriteWithEnemy;

import java.awt.*;

import javax.swing.*;

//This is a class that makes Full-screen display;
//It is essential for a game;
//It includes some specific objects that I have never touched;

public class Screen {
	
	//The GraphicsDevice is something that can control the screen;
	private GraphicsDevice vc;
	
	public Screen() {
		//To have full-screen, 
		//The computer should set the Graphics Environment
		//So that graphics can be displayed ( or pixels );
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = env.getDefaultScreenDevice();
	}
	
	//DisplayMode is the setting of displaying a screen or graphics
	//JFrame is the class of windows;
	public void setFullScreen(DisplayMode dm, JFrame window) {
		//Full Screen basic codes
		
		//No stuffs surrounding like normal windows;
		window.setUndecorated(true);
		
		//cannot be resized because it is full screen
		window.setResizable(false);
		
		//The vc controls the screen of a computer;
		//it can make a window be full screen;
		vc.setFullScreenWindow(window);
		
		//dm != null --> as long as there is setting of the screen
		//vc.isDisplayChangeSupported() --> check if it is able to display the settings;
		if (dm != null && vc.isDisplayChangeSupported()) {
			try {
				vc.setDisplayMode(dm);
			} catch (Exception ex) {}
			
		}
	}
	
	//get full screen window
	public Window getFullScreenWindow() {
		return vc.getFullScreenWindow();
	}
	
	//change the screen from full-size to normal or closed;
	public void restoreScreen() {
		Window w = vc.getFullScreenWindow();
		
		if ( w != null) {
			//free resources;
			w.dispose();
		}
		
		//takes away from Full Screen
		vc.setFullScreenWindow(null);
	}
}
