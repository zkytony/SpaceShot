package Image;

import javax.swing.JFrame;

//main method
public class Image extends JFrame {

    public Image() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(280, 240);
        setLocationRelativeTo(null);
        setTitle("Bardejov");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Image();
    }
}
