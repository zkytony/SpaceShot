package Java2Dskeleton;

import javax.swing.JFrame;

//This is the entry point of the game. Here we have the main method. 
public class Skeleton extends JFrame {

    public Skeleton() {
    	//Here we put the Board to the center of the JFrame component.
        add(new Board());
        setTitle("Skeleton");
        //This will close the application when we click on the close button. It is not the default behaviour. 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //This line sets the size for our window. 
        setSize(300, 280);
        //We center the window. 
        setLocationRelativeTo(null);
        //Make the window able to be seen
        setVisible(true);
        // Make the window unresizable.
        setResizable(false);
    }
    public static void main(String[] args) {
        new Skeleton();
    }
}

