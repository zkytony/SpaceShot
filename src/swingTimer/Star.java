package swingTimer;

//In the first example we
//will use a Swing timer to create animation. 
//This is the easiest but also the least effective way 
//of animating objects in Java games. 


import javax.swing.JFrame;

public class Star extends JFrame {

    public Star() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 440);
        setLocationRelativeTo(null);
        setTitle("Star");
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Star();
    }
}

